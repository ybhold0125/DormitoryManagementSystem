package dms.boot.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import dms.boot.annotation.JwtToken;
import dms.boot.user.domain.User;
import dms.boot.user.service.IUserService;

public class AuthenticationInterceptor implements HandlerInterceptor {
	@Autowired
	private IUserService iUserService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object)
			throws Exception {
		String token = request.getHeader("token");
		//如果不是映射到方法直接通过
		if(!(object instanceof HandlerMethod)) {
			return true;
		}
		
		HandlerMethod handlerMethod = (HandlerMethod) object;
		Method method = handlerMethod.getMethod();
		if(method.isAnnotationPresent(JwtToken.class)) {
			JwtToken jwtToken = method.getAnnotation(JwtToken.class);
			if(jwtToken.required()) {
				//执行认证
				if(token == null) {
					throw new RuntimeException("无Token,请重新登录");
				}
				//获取token中的userid
				String userId;
				try {
					userId = JWT.decode(token).getAudience().get(0);
				} catch (Exception e) {
					throw new RuntimeException("401");
				}
				User user = iUserService.queryUserByUserId(userId);
				if(user == null) {
					throw new RuntimeException("用户不存在，请重试");
				}
				
				//验证token
				JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
				try {
					jwtVerifier.verify(token);
				} catch (Exception e) {
					throw new RuntimeException("401");
				}
				return true;
			}
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}	

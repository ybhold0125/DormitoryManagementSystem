package dms.boot.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import dms.boot.user.domain.User;

public class JwtUtil {
	/**
	 * 	过期时间 两小时
	 */
	private static final long EXPIRE_TIME = 120 * 60 * 1000;
    
    /**
     * 	生成签名，两小时后过期
     * @param userId
     * @return
     */
    public static String getToken(User user) {
    	try {
        	Date date= new Date(System.currentTimeMillis() + EXPIRE_TIME);
        	return JWT.create().withAudience(user.getUserId())
                	.withExpiresAt(date).sign(Algorithm.HMAC256(user.getPassword()));
		} catch (Exception e) {
			return null;
		}
    }
    
//    /**
//     * 	根据token获取userId
//     * @param token
//     * @return
//     */
//    public static String getUserId(String token) {
//    	try {
//			String userId = JWT.decode(token).getAudience().get(0);
//			return userId;
//		} catch (Exception e) {
//			return null;
//		}
//    }
    
//    public static boolean checkSign(String token) {
//    	try {
//			Algorithm algorithm = Algorithm.HMAC256(SECRET);
//			JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username).build();
//		} catch (Exception e) {
//			
//		}
//    }
}

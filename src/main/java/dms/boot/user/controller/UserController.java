package dms.boot.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dms.boot.annotation.JwtToken;
import dms.boot.user.domain.User;
import dms.boot.user.service.IUserService;
import dms.boot.util.JwtUtil;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private IUserService iUserService;
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody User user){
		Map<String, Object> map = new HashMap<String, Object>();
		User userInfo = iUserService.queryUserByUsername("admin");
		if(userInfo == null || !userInfo.getPassword().equals(user.getPassword())) {
			map.put("status", "false");
			map.put("msg", "登录失败，账号或密码不存在");
			return map;
		}
		String token = JwtUtil.getToken(userInfo);
		map.put("status", "true");
		map.put("msg", "登录成功");
		map.put("token", token);
		map.put("user", userInfo);
		return map;
	}
	
	@JwtToken
	@GetMapping("/getMessage")
	public String getMessage() {
		return "成功";
	}
}

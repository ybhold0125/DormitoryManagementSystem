package dms.boot.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dms.boot.user.domain.Identity;
import dms.boot.user.domain.User;
import dms.boot.user.service.identityService.IIdentityService;
import dms.boot.user.service.userService.IUserService;
import dms.boot.util.JwtUtil;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private IUserService iUserService;
	
	@Autowired
	private IIdentityService iIdentityService;
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody User user){
		Map<String, Object> map = iUserService.queryUserByUsername(user);
		return map;
	}
	
	@GetMapping("/getIdentity")
	public Map<String, Object> getIdentity() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Identity> identityData = iIdentityService.queryIdentity();
		map.put("data", identityData);
		return map;
	}
}

package dms.boot.student.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dms.boot.annotation.JwtToken;
import dms.boot.student.domain.Student;
import dms.boot.student.service.IStudentSerivce;

@RestController
@RequestMapping("student")
@CrossOrigin
public class StudentController {
	@Autowired
	private IStudentSerivce iStudentSerivce;

	@JwtToken
	@GetMapping("/queryStudentList")
	public Map<String, Object> queryStudentList(String pageNo, String pageSize) {
		Map<String, Object> map = iStudentSerivce.queryStudentList(pageNo, pageSize);
		return map;
	}
	
	@JwtToken
	@PostMapping("/insertStudent")
	public Map<String, Object> insertStudent(@RequestBody Student student) {
		Map<String, Object> map = iStudentSerivce.insertStudent(student);
		return map;
	}
	
	@JwtToken
	@PostMapping("/deleteStudent")
	public Map<String, Object> deleteStudent(Integer id) {
		Map<String, Object> map = iStudentSerivce.deleteStudent(id);
		return map;
	}
	
	@JwtToken
	@PostMapping("/queryStudent")
	public Map<String, Object> queryStudent(Integer id) {
		Map<String, Object> map = iStudentSerivce.queryStudent(id);
		return map;
	}
	
	@JwtToken
	@PostMapping("/updateStudent")
	public Map<String, Object> updateStudent(@RequestBody Student student) {
		Map<String, Object> map = iStudentSerivce.updateStudent(student);
		return map;
	}
}

package dms.boot.student.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dms.boot.student.dao.IStudentDao;
import dms.boot.student.domain.Student;
import dms.boot.student.service.IStudentSerivce;
import dms.boot.user.dao.IUserDao;
import dms.boot.user.domain.User;

@Service
@Transactional
public class StudentSerivceImpl implements IStudentSerivce {
	@Autowired
	private IStudentDao iStudentDao;
	
	@Autowired
	private IUserDao iUserDao;

	@Override
	public List<Student> queryStudentList() {
		List<Student> studentList = iStudentDao.queryStudentList();
		return studentList;
	}

	@Override
	public Map<String, Object> insertStudent(Student student) {
		Map<String, Object> map = new HashMap<String, Object>();
		Student queryStudentByStudentId = iStudentDao.queryStudentByStudentId(student.getStudentId());
		if(queryStudentByStudentId != null) {
			map.put("status", "false");
			map.put("msg", "学号已被使用，请重新输入！");
			return map;
		}
		int i = iStudentDao.insertStudent(student);
		if(i > 0) {
			User user = new User();
			user.setUsername(student.getStudentId());
			user.setPassword(student.getPhone());
			int j = iUserDao.insertUser(user);
			if(j > 0) {
				map.put("status", "true");
				map.put("msg", "添加成功！");
			}else {
				map.put("status", "false");
				map.put("msg", "添加成功！");
			}
		}else {
			map.put("status", "false");
			map.put("msg", "添加成功！");
		}
		return map;
	}

}	

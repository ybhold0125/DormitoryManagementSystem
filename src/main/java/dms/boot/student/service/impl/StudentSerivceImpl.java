package dms.boot.student.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import dms.boot.student.dao.IStudentDao;
import dms.boot.student.domain.Student;
import dms.boot.student.service.IStudentSerivce;
import dms.boot.user.dao.userDao.IUserDao;
import dms.boot.user.domain.User;

@Service
@Transactional
public class StudentSerivceImpl implements IStudentSerivce {
	@Autowired
	private IStudentDao iStudentDao;

	@Autowired
	private IUserDao iUserDao;

	@Override
	public Map<String,Object> queryStudentList(String pageNo, String pageSize) {
		Map<String,Object> map = new HashMap<String,Object>();
		int paNum = 1;
		int paSize = 10;
		if (StringUtils.isNotBlank(pageNo)) {
			paNum = Integer.parseInt(pageNo);
		}
		if (StringUtils.isNotBlank(pageSize)) {
			paSize = Integer.parseInt(pageSize);
		}
		
		Integer leftLimit = (paNum - 1) * paSize;
		Integer rightLimit = paSize;
		Integer numberOfStudent = iStudentDao.queryStudentNumber();
		List<Student> studentList = new ArrayList<Student>();
		map.put("current", paNum);
		map.put("pageSize", paSize);
		if(numberOfStudent == 0) {
			map.put("total", numberOfStudent);
			map.put("res", studentList);

		}else {
			studentList = iStudentDao.queryStudentList(leftLimit, rightLimit);
			map.put("total", numberOfStudent);
			map.put("res", studentList);
		}
		return map;
	}

	@Override
	public Map<String, Object> insertStudent(Student student) {
		Map<String, Object> map = new HashMap<String, Object>();
		Student queryStudentByStudentId = iStudentDao.queryStudentByStudentId(student.getStudentId());
		if (queryStudentByStudentId != null) {
			map.put("status", "false");
			map.put("msg", "学号已被使用，请重新输入！");
			return map;
		}
		int i = iStudentDao.insertStudent(student);
		if (i > 0) {
			User user = new User();
			user.setUsername(student.getStudentId());
			user.setPassword(student.getPhone());
			user.setIdentity(3);;
			int j = iUserDao.insertUser(user);
			if (j > 0) {
				map.put("status", "true");
				map.put("msg", "添加成功！");
			} else {
				map.put("status", "false");
				map.put("msg", "添加成功！");
			}
		} else {
			map.put("status", "false");
			map.put("msg", "添加失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteStudent(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer i = iStudentDao.deleteStudentById(id);
		if (i > 0) {
			map.put("status", "true");
			map.put("msg", "删除成功！");
		} else {
			map.put("status", "false");
			map.put("msg", "删除失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> queryStudent(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Student studentDoc = iStudentDao.queryStudentById(id);
			map.put("status", "true");
			map.put("data", studentDoc);
		}catch (Exception e) {
			e.printStackTrace();
			map.put("status", "false");
			map.put("msg", e.getMessage());
		}
		return map;
	}

	@Override
	public Map<String, Object> updateStudent(Student student) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer i = iStudentDao.updateStudent(student);
		if (i > 0) {
			map.put("status", "true");
			map.put("msg", "编辑成功！");
		} else {
			map.put("status", "false");
			map.put("msg", "编辑失败！");
		}
		return map;
	}
}

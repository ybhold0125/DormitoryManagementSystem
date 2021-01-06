package dms.boot.student.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dms.boot.dormitory.dao.dormitoryDao.IDormitoryDao;
import dms.boot.dormitory.dao.stuDormitoryDao.IStuDormitoryDao;
import dms.boot.dormitory.domain.Dormitory;
import dms.boot.dormitory.domain.StuDormitory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Autowired
	private IStuDormitoryDao iStuDormitoryDao;

	@Autowired
	private IDormitoryDao iDormitoryDao;

	@Override
	public Map<String,Object> queryStudentList(String pageNo, String pageSize) {
		Map<String,Object> map = new HashMap<>();
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
		List<Student> studentList = new ArrayList<>();
		map.put("current", paNum);
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
		Map<String, Object> map = new HashMap<>();
		Student queryStudentByStudentId = iStudentDao.queryStudentByStudentId(student.getStudentId());
		if (queryStudentByStudentId != null) {
			map.put("status", "false");
			map.put("msg", "学号已被使用，请重新输入！");
			return map;
		}
		Dormitory dormitoryInfo = iDormitoryDao.queryDormitoryByDorNum(student.getDormitoryNum());
		StuDormitory stuDormitoryInfo = iStuDormitoryDao.queryStuDormitoryByDorIdWithBedNum(dormitoryInfo.getId(), student.getBedNum());
		if (stuDormitoryInfo != null) {
			map.put("status", "false");
			map.put("msg", "床号已被使用，请重新输入！");
			return map;
		}
		int i = iStudentDao.insertStudent(student);
		StuDormitory stuDormitoryForAdd = new StuDormitory();
		stuDormitoryForAdd.setStudentId(student.getStudentId());
		stuDormitoryForAdd.setDorId(dormitoryInfo.getId());
		stuDormitoryForAdd.setBedNum(student.getBedNum());
		iStuDormitoryDao.insertStuDormitory(stuDormitoryForAdd);
		if (i > 0) {
			User user = new User();
			user.setUsername(student.getStudentId());
			user.setPassword(student.getPhone());
			user.setIdentity(3);
			int j = iUserDao.insertUser(user);
			if (j > 0) {
				map.put("status", "true");
				map.put("msg", "添加成功！");
			} else {
				map.put("status", "false");
				map.put("msg", "添加失败！");
			}
		} else {
			map.put("status", "false");
			map.put("msg", "添加失败！");
		}
		return map;
	}

	@Override
	public Map<String, Object> deleteStudent(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Integer i = iStudentDao.deleteStudentById(id);
		Student student = iStudentDao.queryStudentById(id);
		iStuDormitoryDao.deleteStuDormitory(student.getStudentId());
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
		Map<String, Object> map = new HashMap<>();
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
		Map<String, Object> map = new HashMap<>();
		int i = iStudentDao.updateStudent(student);
		Dormitory dormitoryInfo = iDormitoryDao.queryDormitoryByDorNum(student.getDormitoryNum());
		StuDormitory stuDormitoryInfoForDistinct = iStuDormitoryDao.queryStuDormitoryByDorIdWithBedNum(dormitoryInfo.getId(), student.getBedNum());
		if (stuDormitoryInfoForDistinct != null) {
			map.put("status", "false");
			map.put("msg", "床号已被使用，请重新输入！");
			return map;
		}
		StuDormitory stuDormitoryInfo = iStuDormitoryDao.queryStuDormitoryByStudentId(student.getStudentId());
		stuDormitoryInfo.setDorId(dormitoryInfo.getId());
		stuDormitoryInfo.setBedNum(student.getBedNum());
		iStuDormitoryDao.updateStuDormitory(stuDormitoryInfo);
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

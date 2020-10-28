package dms.boot.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dms.boot.student.dao.IStudentDao;
import dms.boot.student.domain.Student;
import dms.boot.student.service.IStudentSerivce;

@Service
@Transactional
public class StudentSerivceImpl implements IStudentSerivce {
	@Autowired
	private IStudentDao iStudentMapper;

	@Override
	public List<Student> queryStudentList() {
		List<Student> studentList = iStudentMapper.queryStudentList();
		return studentList;
	}

}	

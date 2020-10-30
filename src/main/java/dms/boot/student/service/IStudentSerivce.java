package dms.boot.student.service;

import java.util.List;
import java.util.Map;

import dms.boot.student.domain.Student;

public interface IStudentSerivce {
	public List<Student> queryStudentList();
	
	public Map<String, Object> insertStudent(Student student);
};

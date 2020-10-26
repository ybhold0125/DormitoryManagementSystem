package dms.boot.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import dms.boot.student.domain.Student;

@Mapper
public interface IStudentMapper {
	@Select("SELECT * FROM student")
	public List<Student> queryStudentList();
}

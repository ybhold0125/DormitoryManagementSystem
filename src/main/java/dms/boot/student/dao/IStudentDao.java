package dms.boot.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import dms.boot.student.domain.Student;

@Mapper
public interface IStudentDao {
	/**
	 * 	 分页学生列表
	 * @return
	 */
	@Select("SELECT * FROM student")
	public List<Student> queryStudentList();
	
	/**
	 * 	学生新增
	 * @param student
	 * @return
	 */
	@Insert("INSERT INTO student(id, name, gender, birthday, address, phone, studentId, college, profession, classes) VALUES(null, #{name}, #{gender}, #{birthday}, #{address}, #{phone}, #{studentId}, #{college}, #{profession}, #{classes})")
	public int insertStudent(Student student);
	
	/**
	 * 	查询学生记录（查询条件为studentId）
	 * @param studentId
	 * @return
	 */
	@Select("SELECT * FROM student WHERE studentId = #{studentId}")
	public Student queryStudentByStudentId(String studentId);
}
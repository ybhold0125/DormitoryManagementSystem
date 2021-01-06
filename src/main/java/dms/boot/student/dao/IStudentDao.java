package dms.boot.student.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import dms.boot.student.domain.Student;

@Mapper
public interface IStudentDao {
	/**
	 * 	 分页学生列表
	 * @return
	 */
	@Select("SELECT s.id, s.name, CASE s.gender WHEN 0 THEN '男' WHEN 1 THEN '女' END AS gender, s.birthday, s.address, s.phone, s.studentId, s.college, s.profession, s.classes, d.dormitory_num, sd.bed_num FROM student s LEFT JOIN stu_dormitory sd ON s.studentId = sd.studentId LEFT JOIN dormitory d ON sd.dor_id = d.id ORDER BY id LIMIT #{leftLimit}, #{rightLimit}")
	public List<Student> queryStudentList(Integer leftLimit, Integer rightLimit);
	
	/**
	 * 	 统计学生顺序
	 * @return
	 */
	@Select("SELECT COUNT(1) COUNT FROM student")
	public Integer queryStudentNumber();
			
	/**
	 * 	删除 学生（删除条件为id）
	 * @param id 
	 * @return
	 */
	@Delete("DELETE FROM student WHERE id=#{id}")
	public Integer deleteStudentById(Integer id);
	
	/**
	 * 	学生新增
	 * @param student
	 * @return
	 */
	@Insert("INSERT INTO student(id, name, gender, birthday, address, phone, studentId, college, profession, classes) VALUES(null, #{name}, #{gender}, #{birthday}, #{address}, #{phone}, #{studentId}, #{college}, #{profession}, #{classes})")
	public int insertStudent(Student student);
	
	/**
	 * 	学生修改
	 * @param student
	 * @return
	 */
	@Update("UPDATE student SET name=#{name}, gender=#{gender}, birthday=#{birthday}, address=#{address}, phone=#{phone}, studentId=#{studentId}, college=#{college}, profession=#{profession}, classes=#{classes} WHERE id=#{id}")
	public int updateStudent(Student student);
	
	/**
	 * 	查询学生记录（查询条件为studentId）
	 * @param studentId
	 * @return
	 */
	@Select("SELECT * FROM student WHERE studentId = #{studentId}")
	public Student queryStudentByStudentId(String studentId);
	
	/**
	 * 	查询学生记录（查询条件为id）
	 * @param id
	 * @return
	 */
	@Select("SELECT s.*, d.dormitory_num, sd.bed_num FROM student s LEFT JOIN stu_dormitory sd ON s.studentId = sd.studentId LEFT JOIN dormitory d ON sd.dor_id = d.id WHERE s.id=#{id}")
	public Student queryStudentById(Integer id);
}
package dms.boot.student.service;

import java.util.Map;

import dms.boot.student.domain.Student;

public interface IStudentSerivce {
	
	/**
	 * 	分页学生列表数据
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Map<String,Object> queryStudentList(String pageNo, String pageSize);
	
	/**
	 * 	新增学生
	 * @param student
	 * @return
	 */
	public Map<String, Object> insertStudent(Student student);
	
	/**
	 * 	查询学生
	 * @param id
	 * @return
	 */
	public Map<String, Object> queryStudent(Integer id);
	
	/**
	 * 	删除学生
	 * @param id
	 * @return
	 */
	public Map<String, Object> deleteStudent(Integer id);
	
	/**
	 * 	编辑学生
	 * @param student
	 * @return
	 */
	public Map<String, Object> updateStudent(Student student);
};

package dms.boot.dormitory.dao.stuDormitoryDao;

import dms.boot.dormitory.domain.StuDormitory;
import org.apache.ibatis.annotations.*;

@Mapper
public interface IStuDormitoryDao {
    /**
     * 增加学生宿舍信息
     *
     * @param stuDormitory 学生宿舍信息
     * @return 成功记录数
     */
    @Insert("INSERT INTO stu_dormitory(id, studentId, dor_id, bed_num) VALUES(NULL, #{studentId}, #{dorId}, #{bedNum})")
    int insertStuDormitory(StuDormitory stuDormitory);

    /**
     * 更新学生宿舍信息
     *
     * @param stuDormitory 学生宿舍信息
     * @return 成功记录数
     */
    @Update("UPDATE stu_dormitory SET dor_id=#{dorId}, bed_num=#{bedNum} WHERE id=#{id}")
    int updateStuDormitory(StuDormitory stuDormitory);

    /**
     * 根据宿舍id和床号查询学生宿舍信息
     *
     * @param dorId  宿舍id
     * @param bedNum 床号
     * @return 学生宿舍信息
     */
    @Select("SELECT * FROM stu_dormitory WHERE dor_id=#{dorId} AND bed_num=#{bedNum}")
    StuDormitory queryStuDormitoryByDorIdWithBedNum(int dorId, int bedNum);

    /**
     * 根据学生学号查询学生宿舍信息
     *
     * @param studentId 学生学号
     * @return 学生宿舍信息
     */
    @Select("SELECT * FROM stu_dormitory WHERE studentId=#{studentId}")
    StuDormitory queryStuDormitoryByStudentId(String studentId);

    /**
     *  根据学号删除学生宿舍信息
     * @param studentId 学号
     * @return 成功记录数
     */
    @Delete("DELETE FROM stu_dormitory WHERE studentId=#{studentId}")
    int deleteStuDormitory(String studentId);
}

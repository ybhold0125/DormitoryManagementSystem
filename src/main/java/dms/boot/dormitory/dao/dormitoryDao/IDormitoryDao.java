package dms.boot.dormitory.dao.dormitoryDao;

import dms.boot.dormitory.domain.Dormitory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IDormitoryDao {
    /**
     *  查询宿舍信息
     * @return 宿舍信息List
     */
    @Select("SELECT * FROM dormitory ORDER BY dormitory_num LIMIT #{leftLimit}, #{rightLimit}")
    List<Dormitory> queryDormitoryInfoList(int leftLimit, int rightLimit);

    /**
     *  查询宿舍信息总记录数
     * @return  宿舍信息总记录数
     */
    @Select("SELECT COUNT(*) FROM dormitory")
    int queryDormitoryCount();

    /**
     *  根据宿舍号查询宿舍信息
     * @param dorNum 宿舍号
     * @return  宿舍信息
     */
    @Select("SELECT * FROM dormitory WHERE dormitory_num=#{dorNum}")
    Dormitory queryDormitoryByDorNum(String dorNum);
}

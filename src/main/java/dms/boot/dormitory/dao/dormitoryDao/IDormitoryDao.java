package dms.boot.dormitory.dao.dormitoryDao;

import dms.boot.dormitory.domain.Dormitory;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IDormitoryDao {
    @Insert("INSERT INTO dormitory(id, dormitory_num, bed, people_num) VALUES(NULL, #{dormitoryNum}, #{bed}, #{peopleNum})")
    int saveDormitory(Dormitory dormitory);

    @DeleteProvider(type = SqlProvider.class, method = "deleteById")
    int bitchDeleteDormitory(String[] ids);

    @Update("UPDATE dormitory SET dormitory_num=#{dormitoryNum}, bed=#{bed}, people_num=#{peopleNum} WHERE id=#{id}")
    int updateDormitory(Dormitory dormitory);

    @Select("SELECT * FROM dormitory WHERE id=#{id}")
    Dormitory queryDormitoryById(int id);

    @Select("SELECT COUNT(1) FROM dormitory WHERE dormitory_num=#{dormitoryNum}")
    int queryDormitoryByDormitoryNum(String dormitoryNum);

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

    public static class SqlProvider {
        public static String deleteById(String[] ids) {
            String bitchId = StringUtils.join(ids, ",");
            return "DELETE FROM dormitory WHERE id IN (" + bitchId + ")";
        }
    }
}

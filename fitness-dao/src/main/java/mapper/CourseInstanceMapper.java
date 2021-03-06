package mapper;

import model.CourseInstance;
import model.CourseInstanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseInstanceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    long countByExample(CourseInstanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    int deleteByExample(CourseInstanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    int deleteByPrimaryKey(Integer courseInstanceId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    int insert(CourseInstance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    int insertSelective(CourseInstance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    List<CourseInstance> selectByExample(CourseInstanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    CourseInstance selectByPrimaryKey(Integer courseInstanceId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    int updateByExampleSelective(@Param("record") CourseInstance record, @Param("example") CourseInstanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    int updateByExample(@Param("record") CourseInstance record, @Param("example") CourseInstanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    int updateByPrimaryKeySelective(CourseInstance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course_instance
     *
     * @mbg.generated Mon Dec 31 09:59:50 CST 2018
     */
    int updateByPrimaryKey(CourseInstance record);
}
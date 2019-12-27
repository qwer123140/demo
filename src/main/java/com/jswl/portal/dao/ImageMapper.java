package com.jswl.portal.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jswl.portal.entity.Image;
import com.jswl.portal.entity.ImageExample;

public interface ImageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_image
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int countByExample(ImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_image
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int deleteByExample(ImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_image
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_image
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int insert(Image record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_image
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int insertSelective(Image record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_image
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    List<Image> selectByExample(ImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_image
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    Image selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_image
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int updateByExampleSelective(@Param("record") Image record, @Param("example") ImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_image
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int updateByExample(@Param("record") Image record, @Param("example") ImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_image
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int updateByPrimaryKeySelective(Image record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_image
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int updateByPrimaryKey(Image record);
    
    
   
}
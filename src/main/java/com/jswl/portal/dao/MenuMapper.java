package com.jswl.portal.dao;

import com.jswl.portal.entity.Menu;
import com.jswl.portal.entity.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_menu
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int countByExample(MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_menu
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int deleteByExample(MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_menu
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_menu
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int insert(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_menu
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int insertSelective(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_menu
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    List<Menu> selectByExample(MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_menu
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    Menu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_menu
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_menu
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_menu
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table s_menu
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    int updateByPrimaryKey(Menu record);
    
    //根据用户信息查询当前用户所能操作的菜单
    List<Menu> findMenusByUserId(Integer userId);
    
    
}
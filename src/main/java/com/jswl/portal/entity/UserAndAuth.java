package com.jswl.portal.entity;

public class UserAndAuth {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_user_auth.id
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_user_auth.user_id
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column s_user_auth.role_id
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    private Integer roleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_user_auth.id
     *
     * @return the value of s_user_auth.id
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_user_auth.id
     *
     * @param id the value for s_user_auth.id
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_user_auth.user_id
     *
     * @return the value of s_user_auth.user_id
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_user_auth.user_id
     *
     * @param userId the value for s_user_auth.user_id
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column s_user_auth.role_id
     *
     * @return the value of s_user_auth.role_id
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column s_user_auth.role_id
     *
     * @param roleId the value for s_user_auth.role_id
     *
     * @mbggenerated Wed Sep 18 16:17:34 CST 2019
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
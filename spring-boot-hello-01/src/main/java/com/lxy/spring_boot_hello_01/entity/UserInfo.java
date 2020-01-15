package com.lxy.spring_boot_hello_01.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 年龄
     */
    @Column(name = "user_age")
    private Integer userAge;

    @Column(name = "user_birthday")
    private Date userBirthday;

    /**
     * 性别（0：女；1：男）
     */
    @Column(name = "user_sex")
    private Boolean userSex;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return user_name - 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置姓名
     *
     * @param userName 姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取年龄
     *
     * @return user_age - 年龄
     */
    public Integer getUserAge() {
        return userAge;
    }

    /**
     * 设置年龄
     *
     * @param userAge 年龄
     */
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    /**
     * @return user_birthday
     */
    public Date getUserBirthday() {
        return userBirthday;
    }

    /**
     * @param userBirthday
     */
    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    /**
     * 获取性别（0：女；1：男）
     *
     * @return user_sex - 性别（0：女；1：男）
     */
    public Boolean getUserSex() {
        return userSex;
    }

    /**
     * 设置性别（0：女；1：男）
     *
     * @param userSex 性别（0：女；1：男）
     */
    public void setUserSex(Boolean userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userName=" + userName + ", userAge=" + userAge + ", userBirthday="
				+ userBirthday + ", userSex=" + userSex + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}
    
    
}
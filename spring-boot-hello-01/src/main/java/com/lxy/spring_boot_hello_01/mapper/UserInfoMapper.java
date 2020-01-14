package com.lxy.spring_boot_hello_01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lxy.spring_boot_hello_01.entity.UserInfo;

@Mapper
public interface UserInfoMapper {
	
//	@Select("select id id, user_name userName, user_age userAge, user_birthday userBirthday, user_sex userSex, create_time createTime, update_time updateTime from user_info")
	List<UserInfo> selectAll();
	
	
//	@Insert("insert into "
//			+ " user_info(user_name, user_age, user_birthday, user_sex, create_time, update_time) "
//			+ " values(#{userName},#{userAge}, #{userBirthday}, #{userSex}, #{createTime}, #{updateTime})")
	void saveUserInfo(UserInfo userInfo);
	
//	@Update("update user_info set "
//			+ " user_name = #{userName}, "
//			+ " user_age = #{userAge}, "
//			+ " user_birthday = #{userBirthday}, "
//			+ " user_sex = #{userSex}, "
//			+ " update_Time = #{updateTime} "
//			+ " where id = #{id}")
	void updateUserInfo(UserInfo userInfo);
}

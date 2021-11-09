package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
@Component
public interface UserMapper extends BaseMapper<User> {
    default  User getByUserName(String name) {
        return selectOne(new LambdaQueryWrapper<User>().eq(User::getUserName,name));
    }

    @Update("update user set(password=#{password}) where userName=#{userName}")
    void changePassword(@Param("userName") String userName, @Param("password") String password);
    @Update("update user set name=#{name}, age=#{age}, gender=#{gender}, detail=#{detail} where user_name=#{userName}")
    void updateUser(@Param("userName") String userName, @Param("name") String name,@Param("age") int age, @Param("gender") String gender, @Param("detail") String detail);

}

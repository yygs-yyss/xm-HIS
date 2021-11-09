package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.TechnicalOffice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@Component
public interface DoctorMapper extends BaseMapper<Doctor> {

    @Select("select * from Hospital.doctor")
    public List<Doctor> getAll() ;

    @Select("select detail from Hospital.doctor where id=#{id}")
    public String getById(long id) ;
}

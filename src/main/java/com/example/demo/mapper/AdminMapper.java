package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.TechnicalOffice;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
@Repository
@Component
public interface AdminMapper extends BaseMapper<TechnicalOffice> {
    default TechnicalOffice getById(long id) {
        return selectOne(new LambdaQueryWrapper<TechnicalOffice>().eq(TechnicalOffice::getId, id));
    }

    @Select("select * from technical_office")
    List<TechnicalOffice> getAllTechnicalOffice();
    @Insert("insert into technical_office values(null, #{name},#{number},#{detail})")
    void insertT(@Param("name") String name,@Param("number") int number,@Param("detail") String detail);
    @Delete("delete from technical_office where id=#{id}")
    void delete(long id);
    @Update("update technical_office set name=#{name}, number=#{number}, detail=#{detail} where id=#{id}")
    void updateT(@Param("name") String name, @Param("number") int number, @Param("detail") String detail, @Param("id") long id);
}

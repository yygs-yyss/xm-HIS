package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.TechnicalOffice;
import com.example.demo.entity.arrangeMessage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
@Component
public interface MessageMapper extends BaseMapper<arrangeMessage> {
    @Select("select * from arrange_message")
    List<arrangeMessage> getMessages();
}

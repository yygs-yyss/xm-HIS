package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.entity.TechnicalOffice;
import com.example.demo.entity.User;
import com.example.demo.entity.arrangeMessage;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Map;

@Api(value = "管理员端请求", tags = {"登录以及管理员操作"})
@Slf4j
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @ApiOperation(value = "查询科室")
    @GetMapping("getAll")
    public ResultVO getTechical() {
        List<TechnicalOffice> t = adminService.getAll();
        return ResultVO.success(Map.of("technicalOffice", t));
    }
    @ApiOperation(value = "修改科室")
    @PatchMapping("update")
    public ResultVO updateT(@RequestBody TechnicalOffice technicalOffice) {
        adminService.updateT(technicalOffice);
        return ResultVO.success(Map.of());
    }
    @ApiOperation(value = "插入数据")
    @PostMapping("insert")
    public ResultVO insert(@RequestBody TechnicalOffice technicalOffice) {
        adminService.insertT(technicalOffice);
        return ResultVO.success(Map.of());
    }
    @ApiOperation(value = "删除数据")
    @DeleteMapping("delete/{id}")
    public ResultVO delete(@PathVariable long id) {
        adminService.delete(id);
        return ResultVO.success(Map.of());
    }
    @ApiOperation(value = "添加排班记录")
    @PostMapping("addMessage")
    public ResultVO addMessage(@RequestBody arrangeMessage arrangeMessage) {
        adminService.addMessage(arrangeMessage);
        return ResultVO.success(Map.of());
    }
    @ApiOperation(value = "查询排班记录")
    @GetMapping("getMessages")
    public ResultVO getMessages() {
        List<arrangeMessage> t = adminService.getMessages();
        return ResultVO.success(Map.of("messages", t));
    }
}

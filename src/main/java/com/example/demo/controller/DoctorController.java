package com.example.demo.controller;

import com.example.demo.VO.ResultVO;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.TechnicalOffice;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.service.AdminService;
import com.example.demo.service.DoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.util.List;
import java.util.Map;

@Api(value = "管理员端", tags = {"登录以及管理员对医生操作"})
@Slf4j
@RestController
@RequestMapping("/api/admin/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @ApiOperation(value = "查询全部医生")
    @GetMapping("getAll")
    public ResultVO getDoctor() {
        List<Doctor> list = doctorService.getAll();
        return ResultVO.success(Map.of("doctors", list));
    }
    @ApiOperation(value = "修改医生信息")
    @PatchMapping("update")
    public ResultVO updateDoctor(@RequestBody Doctor doctor) {
        doctorService.update(doctor);
        return ResultVO.success(Map.of());
    }
    @ApiOperation(value = "插入数据")
    @PostMapping("insert")
    public ResultVO insertDoctor(@RequestBody Doctor doctor) {
        doctorService.insert(doctor);
        return ResultVO.success(Map.of());
    }
    @ApiOperation(value = "删除数据")
    @DeleteMapping("delete/{id}")
    public ResultVO deleteDoctor(@PathVariable long id) {
        doctorService.delete(id);
        return ResultVO.success(Map.of());
    }
}

package com.example.demo.service;

import com.example.demo.entity.Doctor;
import com.example.demo.mapper.DoctorMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class DoctorService {
    @Autowired
    private DoctorMapper doctorMapper;

    public List<Doctor> getAll() {
        List<Doctor> list = doctorMapper.getAll();
        return list;
    }
    public String getById(long id) {
        return doctorMapper.getById(id);
    }
    public void insert(Doctor doctor) {
        doctorMapper.insert(doctor);
    }
    public void update(Doctor doctor) {
        doctorMapper.updateById(doctor);
    }
    public void delete(long id) {
        doctorMapper.deleteById(id);
    }
}

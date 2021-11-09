package com.example.demo.service;
import com.example.demo.entity.TechnicalOffice;
import com.example.demo.entity.arrangeMessage;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.mapper.MessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Slf4j
@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private MessageMapper messageMapper;
    public List<TechnicalOffice> getAll() {
        return adminMapper.getAllTechnicalOffice();
    }
    public void updateT(TechnicalOffice technicalOffice) {
        adminMapper.updateT(technicalOffice.getName(),technicalOffice.getNumber(),technicalOffice.getDetail(),technicalOffice.getId());
    }
    public void insertT(TechnicalOffice technicalOffice) {
        adminMapper.insert(technicalOffice);
    }
    public void delete(long id) {
        adminMapper.deleteById(id);
    }
    public List<arrangeMessage> getMessages() {
        return messageMapper.getMessages();
    }
    public void addMessage(arrangeMessage arrangeMessage) {
        messageMapper.insert(arrangeMessage);
    }
}

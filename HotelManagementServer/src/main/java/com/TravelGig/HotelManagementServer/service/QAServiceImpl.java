package com.TravelGig.HotelManagementServer.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelGig.HotelManagementServer.domain.QA;
import com.TravelGig.HotelManagementServer.repository.QARepository;

@Service
public class QAServiceImpl implements QAService{

    @Autowired
    QARepository qaRepository;
    @Override
    public List<QA> getQABy(int hotelId, String status) {
        return qaRepository.findAllByHotelIdAndStatus(hotelId, status);
    }

    @Override
    public List<QA> getQABy(String status) {
        return qaRepository.findAllByStatus(status);
    }

    @Override
    public QA createQA(QA qa) {
        return qaRepository.save(qa);
    }

    @Override
    public QA answerQA(int id, String answer, String serviceId) {
        Optional<QA> oqa = qaRepository.findById(id);
        if(!oqa.isPresent()){
            return null;
        }
        QA qa = oqa.get();
        qa.setAnswer(answer);
        qa.setServiceId(serviceId);
        qa.setStatus("answered");
        return qaRepository.save(qa);
    }

    @Override
    public List<QA> isExpired(String status) {
        // get current date
        LocalDateTime daysBefore = LocalDateTime.now().minusDays(4);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String db = dtf.format(daysBefore);
        List<QA> qas = qaRepository.findAllByStatusAndCreateDateBefore(status, db);
        // set qas
        for(QA qa : qas){
            qa.setStatus("expired");
        }
        return qaRepository.saveAll(qas);
    }
    
}

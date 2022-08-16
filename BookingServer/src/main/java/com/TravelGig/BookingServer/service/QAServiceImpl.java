package com.TravelGig.BookingServer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelGig.BookingServer.domain.QA;
import com.TravelGig.BookingServer.repository.QARepository;

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
    public QA answerQA(int id, String answer, int serviceId) {
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
        return null;
    }
    
}

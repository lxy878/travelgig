package com.TravelGig.HotelManagementServer.service;

import java.util.List;

import com.TravelGig.HotelManagementServer.domain.QA;

public interface QAService {
    public List<QA> getQABy(int hotelId, String status);
    public List<QA> getQABy(String status);
    public QA createQA(QA qa);
    public QA answerQA(int id, String answer, String serviceId);
    public List<QA> isExpired(String status);
    
}

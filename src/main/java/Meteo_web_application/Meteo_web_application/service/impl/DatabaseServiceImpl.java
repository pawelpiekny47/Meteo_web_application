package Meteo_web_application.Meteo_web_application.service.impl;

import Meteo_web_application.Meteo_web_application.dto.ReceivedRequestTo;
import Meteo_web_application.Meteo_web_application.entity.ReceivedRequest;
import Meteo_web_application.Meteo_web_application.mapper.ReceivedRequestMapper;
import Meteo_web_application.Meteo_web_application.mapper.impl.ReceivedRequestMapperImpl;
import Meteo_web_application.Meteo_web_application.repo.ReceivedRequestRepo;
import Meteo_web_application.Meteo_web_application.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of DatabaseService interface
 */
@Service
@Transactional
public class DatabaseServiceImpl implements DatabaseService {

    private final ReceivedRequestRepo receivedRequestRepo;
    private final ReceivedRequestMapper receivedRequestMapper;

    @Autowired
    public DatabaseServiceImpl(ReceivedRequestRepo receivedRequestRepo, ReceivedRequestMapper receivedRequestMapper) {
        this.receivedRequestRepo = receivedRequestRepo;
        this.receivedRequestMapper = receivedRequestMapper;
    }

    @Override
    public ReceivedRequestTo saveReceivedRequestInDatabase(ReceivedRequestTo receivedRequestTo) {
        ReceivedRequest savedEntity = receivedRequestRepo.save(receivedRequestMapper.toReceivedRequestEntity(receivedRequestTo));
        return receivedRequestMapper.toReceivedRequestDto(savedEntity);
    }
}

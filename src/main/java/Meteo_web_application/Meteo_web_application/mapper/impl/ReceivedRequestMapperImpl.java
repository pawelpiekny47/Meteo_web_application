package Meteo_web_application.Meteo_web_application.mapper.impl;

import Meteo_web_application.Meteo_web_application.dto.ReceivedRequestTo;
import Meteo_web_application.Meteo_web_application.entity.ReceivedRequest;
import Meteo_web_application.Meteo_web_application.mapper.ReceivedRequestMapper;
import org.springframework.stereotype.Component;

/**
 * Implementation of ReceivedRequestMapper interface
 */
@Component
public class ReceivedRequestMapperImpl implements ReceivedRequestMapper {
    @Override
    public ReceivedRequest toReceivedRequestEntity(ReceivedRequestTo receivedRequestTo) {
        return ReceivedRequest.builder()
                .latitude(receivedRequestTo.getLatitude())
                .longitude(receivedRequestTo.getLongitude())
                .date(receivedRequestTo.getDate())
                .build();
    }

    @Override
    public ReceivedRequestTo toReceivedRequestDto(ReceivedRequest receivedRequest) {
        return ReceivedRequestTo.builder()
                .id(receivedRequest.getId())
                .latitude(receivedRequest.getLatitude())
                .longitude(receivedRequest.getLongitude())
                .date(receivedRequest.getDate())
                .build();
    }
}

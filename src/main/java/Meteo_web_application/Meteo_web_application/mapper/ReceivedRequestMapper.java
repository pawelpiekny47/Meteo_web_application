package Meteo_web_application.Meteo_web_application.mapper;

import Meteo_web_application.Meteo_web_application.dto.ReceivedRequestTo;
import Meteo_web_application.Meteo_web_application.entity.ReceivedRequest;

/**
 * Mapper between transfer object and entity for ReceivedRequest
 */
public interface ReceivedRequestMapper {
    ReceivedRequest toReceivedRequestEntity(ReceivedRequestTo receivedRequestTo);

    ReceivedRequestTo toReceivedRequestDto(ReceivedRequest receivedRequest);
}

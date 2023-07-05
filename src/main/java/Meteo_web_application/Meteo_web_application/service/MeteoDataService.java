package Meteo_web_application.Meteo_web_application.service;

import Meteo_web_application.Meteo_web_application.dto.ReceivedRequestTo;

/**
 * Service connecting to external api
 */
public interface MeteoDataService {

    /**
     * Returns information from external Api, which contains required and unused information (which should be filtered afterwards)
     *
     * @param receivedRequestTo transfer object with details about request
     * @return Response from external api
     */
    String getInformationFromExternalApiForPreviousSevenDays(ReceivedRequestTo receivedRequestTo);
}

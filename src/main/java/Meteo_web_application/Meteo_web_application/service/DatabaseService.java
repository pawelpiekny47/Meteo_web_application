package Meteo_web_application.Meteo_web_application.service;

import Meteo_web_application.Meteo_web_application.dto.ReceivedRequestTo;

/**
 * Service used for operations on database
 */
public interface DatabaseService {

    /**
     * Save details about weather request in database.
     *
     * @param receivedRequestTo transfer object with detail about request
     * @return Transfer object for ReceivedDetail
     */
    ReceivedRequestTo saveReceivedRequestInDatabase(ReceivedRequestTo receivedRequestTo);
}

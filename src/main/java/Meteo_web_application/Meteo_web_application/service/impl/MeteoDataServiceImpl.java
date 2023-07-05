package Meteo_web_application.Meteo_web_application.service.impl;

import Meteo_web_application.Meteo_web_application.dto.ReceivedRequestTo;
import Meteo_web_application.Meteo_web_application.service.MeteoDataService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Implementation of MeteoDataService interface
 */
@Service
public class MeteoDataServiceImpl implements MeteoDataService {
    private final static String URI = "https://archive-api.open-meteo.com/v1/archive?latitude={latitude}&longitude={longitude}&start_date={startDay}&end_date={endDay}&daily=sunrise,sunset,rain_sum&timezone=Europe/Berlin";

    @Override
    public String getInformationFromExternalApiForPreviousSevenDays(ReceivedRequestTo receivedRequestTo) {
        RestTemplate restTemplate = new RestTemplate();
        URI resultUri =
                UriComponentsBuilder.fromUriString(URI).build()
                        .expand(receivedRequestTo.getLatitude(),
                                receivedRequestTo.getLongitude(),
                                receivedRequestTo.getDate().toLocalDate().minusDays(7),
                                receivedRequestTo.getDate().toLocalDate().minusDays(1))
                        .encode()
                        .toUri();

        return restTemplate.getForObject(resultUri, String.class);
    }
}
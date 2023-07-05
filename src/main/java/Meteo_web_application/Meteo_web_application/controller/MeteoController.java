package Meteo_web_application.Meteo_web_application.controller;

import Meteo_web_application.Meteo_web_application.dto.ReceivedRequestTo;
import Meteo_web_application.Meteo_web_application.service.DatabaseService;
import Meteo_web_application.Meteo_web_application.service.MeteoDataService;
import Meteo_web_application.Meteo_web_application.service.impl.DatabaseServiceImpl;
import Meteo_web_application.Meteo_web_application.service.impl.MeteoDataServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Controller for weather data related operations
 */
@RestController
@RequestMapping("meteo/")
public class MeteoController {

    private final MeteoDataService meteoDataService;

    private final DatabaseService databaseService;

    @Autowired
    public MeteoController(MeteoDataServiceImpl meteoDataService, DatabaseServiceImpl databaseService) {
        this.meteoDataService = meteoDataService;
        this.databaseService = databaseService;
    }

    /**
     * Function that returns information about sunrise, sunset and rain sum from previous 7 days.
     * All necessary information are stored in "daily" field in response from External Api.
     *
     * @param latitude  latitude, for which data should be returned
     * @param longitude longitude, for which data should be returned
     * @return Json, with weather details for previous 7 days.
     * @throws JsonProcessingException
     */
    @GetMapping("{latitude}&{longitude}")
    public JsonNode findLastWeekWeatherData(@PathVariable("latitude") final BigDecimal latitude, @PathVariable("longitude") final BigDecimal longitude) throws JsonProcessingException {
        ReceivedRequestTo receivedRequestTo = ReceivedRequestTo.builder().latitude(latitude).longitude(longitude).date(LocalDateTime.now()).build();
        String dataFromExternalApi = meteoDataService.getInformationFromExternalApiForPreviousSevenDays(receivedRequestTo);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode nameNode = mapper.readTree(dataFromExternalApi);
        JsonNode daily = nameNode.get("daily");
        databaseService.saveReceivedRequestInDatabase(receivedRequestTo);

        return daily;
    }
}

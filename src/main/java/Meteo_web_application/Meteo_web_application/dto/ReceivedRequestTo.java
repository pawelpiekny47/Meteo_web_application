package Meteo_web_application.Meteo_web_application.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Data transfer object with request details from MeteoController
 */
@Getter
@Builder
public class ReceivedRequestTo {
    private Long id;
    private LocalDateTime date;
    private BigDecimal latitude;
    private BigDecimal longitude;
}

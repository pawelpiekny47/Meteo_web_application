package Meteo_web_application.Meteo_web_application.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity used to store details about request from MeteoController. Used to save information in database
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ReceivedRequest")
public class ReceivedRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Date")
    private LocalDateTime date;

    @Column(name = "Latitude", scale = 6)
    private BigDecimal latitude;

    @Column(name = "Longitude", scale = 6)
    private BigDecimal longitude;

}

package Meteo_web_application.Meteo_web_application.repo;

import Meteo_web_application.Meteo_web_application.entity.ReceivedRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceivedRequestRepo extends JpaRepository<ReceivedRequest, Long> {

}

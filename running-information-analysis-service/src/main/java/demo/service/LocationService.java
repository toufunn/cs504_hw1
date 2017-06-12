package demo.service;

import demo.domain.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LocationService {
    List<Location> saveRunningLocations(List<Location> runningLocations);

    void deleteAll();

    void deleteItem(Long userId);

    Page<Location> findByUserId(Long userId, Pageable pageable);

    Page<Location> sortByHeartRate(Pageable pageable);
    Page<Location> findAllUserId(Pageable pageable);
}

package demo.service.impl;

import demo.domain.Location;
import demo.domain.LocationRepository;
import demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    @Override
    public List<Location> saveRunningLocations(List<Location> runningLocations) {
        return locationRepository.save(runningLocations);
    }

    @Override
    public void deleteAll() {
        locationRepository.deleteAll();
    }

    @Override
    public void deleteItem(Long userId){locationRepository.deleteByUserId(userId);
    }

    @Override
    public Page<Location> sortByHeartRate(Pageable pageable) {
        return locationRepository.findAllByOrderByHeartsRateDesc(pageable);
    }

    @Override
    public Page<Location> findByUserId(Long userId, Pageable pageable) {
        return locationRepository.findByUserId(userId, pageable);
    }
    @Override
    public Page<Location> findAllUserId(Pageable pageable) {
        return locationRepository.findAll(pageable);
    }

}

package demo.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Page<Location> findByUserId(@Param("userId") Long userId, Pageable pageable);
    @Modifying
    @Transactional
    void deleteByUserId(Long runningId);
    Page<Location> findAllByOrderByHeartsRateDesc(Pageable pageable);
    //@Query("SELECT runningId,totalRunningTime,heartsRate,userId,healthWarningLevel FROM Location l")
    // Can't return colum name Need to write Specification
    Page<Location> findAll(Pageable pageable);
}

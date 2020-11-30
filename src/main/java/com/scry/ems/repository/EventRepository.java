package com.scry.ems.repository;

import com.scry.ems.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EventRepository extends JpaRepository<EventModel,Integer> {

    String QUERY = "select * from event e "
            + " where e.date between ?1 and ?2 order by e.date asc";

    @Query(nativeQuery = true, value = QUERY)
    public List<EventModel> fetchVenuesBasedOnDates(String startDate, String endDate);
}

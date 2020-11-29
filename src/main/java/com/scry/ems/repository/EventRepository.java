package com.scry.ems.repository;

import com.scry.ems.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventModel,String> {
}

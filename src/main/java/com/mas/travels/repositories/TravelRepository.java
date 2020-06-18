package com.mas.travels.repositories;

import com.mas.travels.models.travel.Travel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository extends PagingAndSortingRepository<Travel, Long> {
    List<Travel> findAll();
}


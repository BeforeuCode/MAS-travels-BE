package com.mas.travels.repositories;

import com.mas.travels.models.travel.Travel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TravelRepository extends PagingAndSortingRepository<Travel, Long> {
    Set<Travel> findAll();
    @Query("SELECT t FROM Travel t " +
            "JOIN t.clients client " +
            "JOIN client.travels travel " +
            "WHERE client.id = :clientId")
    Set<Travel> findAllTravelsByClientId(@Param("clientId") long clientId);
}


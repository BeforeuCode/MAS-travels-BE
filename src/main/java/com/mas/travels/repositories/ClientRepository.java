package com.mas.travels.repositories;

import com.mas.travels.models.client.RegisteredClient;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<RegisteredClient, Long> {
    List<RegisteredClient> findAll();
}

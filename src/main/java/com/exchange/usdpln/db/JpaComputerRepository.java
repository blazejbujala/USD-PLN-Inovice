package com.exchange.usdpln.db;

import com.exchange.usdpln.models.Computer;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaComputerRepository extends PagingAndSortingRepository<Computer, UUID> {
}

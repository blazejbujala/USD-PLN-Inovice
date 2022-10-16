package com.exchange.usdpln.db;

import com.exchange.usdpln.models.Invoice;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaInvoiceRepository extends PagingAndSortingRepository<Invoice, UUID> {
}

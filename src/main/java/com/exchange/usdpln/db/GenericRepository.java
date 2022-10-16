package com.exchange.usdpln.db;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.xml.bind.JAXBException;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository<T> {

    T add(T object) throws JAXBException, IOException;

    T getById(UUID id) throws JAXBException, IOException;

    List<T> getAll() throws JAXBException, IOException;

    boolean delete(UUID id);

    void clear();
}


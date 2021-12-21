package com.g25.reto5.appg25clean.repository.crud;


import com.g25.reto5.appg25clean.model.Order;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author desarrolloextremo
 */
public interface OrderCrudRepository extends CrudRepository<Order, Integer> {

    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);
    
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
}

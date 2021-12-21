package com.g25.reto5.appg25clean.repository.crud;



import com.g25.reto5.appg25clean.model.User;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author desaextremo
 */
public interface UserCrudRepository extends CrudRepository<User, Integer>{
    Optional<User> findByEmail(String email);
    List<User> findBybirthtDay(Date date);
    Optional <User> findByEmailAndPassword(String email,String password);
    
    List<User> findByMonthBirthtDay(String monthBirthtDay);
}

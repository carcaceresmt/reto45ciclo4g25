package com.g25.reto5.appg25clean.repository;


import com.g25.reto5.appg25clean.model.CleaningProduct;
import com.g25.reto5.appg25clean.repository.crud.CleaningProductCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author desaextremo
 */
@Repository
public class CleaningProductRepository {

    @Autowired
    private CleaningProductCrudRepository gatgetCrudRepository;

    public List< CleaningProduct> getAll() {
        return gatgetCrudRepository.findAll();
    }

    public Optional<CleaningProduct> getGadget(int productId) {
        return gatgetCrudRepository.findById(productId);
    }

    public CleaningProduct create(CleaningProduct gadget) {
        return gatgetCrudRepository.save(gadget);
    }

    public void update(CleaningProduct product) {
        gatgetCrudRepository.save(product);
    }

    public void delete(CleaningProduct product) {
        gatgetCrudRepository.delete(product);
    }
    //Reto 5
    public List<CleaningProduct> gadgetsByPrice(double precio) {
        return gatgetCrudRepository.findByPriceLessThanEqual(precio);
    }

    public List<CleaningProduct> gadgetsByCategory(String categoria) {
        return gatgetCrudRepository.findByCategory(categoria);
    }

    public List<CleaningProduct> gadgetsByName(String nombre) {
        return gatgetCrudRepository.findByNameLike(nombre);
    }

    //Reto 5
    public List<CleaningProduct> findByDescriptionLike(String description) {
        return gatgetCrudRepository.findByDescriptionLike(description);
    }
}

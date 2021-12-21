package com.g25.reto5.appg25clean.repository.crud;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.g25.reto5.appg25clean.model.CleaningProduct;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author desaextremo
 */
public interface CleaningProductCrudRepository extends MongoRepository<CleaningProduct, Integer> {

    public List<CleaningProduct> findByPriceLessThanEqual(double precio);

    public List<CleaningProduct> findByCategory(String categoria);

    @Query("{'name':{'$regex':'?0','$options':'i'}}")
    public List<CleaningProduct> findByNameLike(String name);

    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<CleaningProduct> findByDescriptionLike(String description);
}

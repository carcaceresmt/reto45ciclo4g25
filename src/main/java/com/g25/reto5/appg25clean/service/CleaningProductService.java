package com.g25.reto5.appg25clean.service;



import com.g25.reto5.appg25clean.model.CleaningProduct;
import com.g25.reto5.appg25clean.repository.CleaningProductRepository;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author desaextremo
 */
@Service
public class CleaningProductService {

    @Autowired
    private CleaningProductRepository gadgetRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<CleaningProduct> getAll() {
        return gadgetRepository.getAll();
    }

    public Optional<CleaningProduct> getGadget(int id) {
        return gadgetRepository.getGadget(id);
    }

    public CleaningProduct create(CleaningProduct gadget) {
        if (gadget.getId() == null) {
            return gadget;
        } else {
            return gadgetRepository.create(gadget);
        }
    }

    public CleaningProduct update(CleaningProduct gadget) {

        if (gadget.getId() != null) {
            Optional<CleaningProduct> gadgetDb = gadgetRepository.getGadget(gadget.getId());
            if (!gadgetDb.isEmpty()) {
                if (gadget.getName() != null) {
                    gadgetDb.get().setName(gadget.getName());
                }
                if (gadget.getBrand() != null) {
                    gadgetDb.get().setBrand(gadget.getBrand());
                }
                if (gadget.getCategory() != null) {
                    gadgetDb.get().setCategory(gadget.getCategory());
                }
                if (gadget.getDescription() != null) {
                    gadgetDb.get().setDescription(gadget.getDescription());
                }
                if (gadget.getQuantity() != 0) {
                    gadgetDb.get().setQuantity(gadget.getQuantity());
                }
                if (gadget.getPrice() != 0.0) {
                    gadgetDb.get().setPrice(gadget.getPrice());
                }
                if (gadget.getPhotography() != null) {
                    gadgetDb.get().setPhotography(gadget.getPhotography());
                }

                gadgetRepository.update(gadgetDb.get());
                return gadgetDb.get();
            } else {
                return gadget;
            }
        } else {
            return gadget;
        }
    }

    public boolean delete(int gatgetId) {
        Boolean aBoolean = getGadget(gatgetId).map(product -> {
            gadgetRepository.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    //Reto 5
    public List<CleaningProduct> gadgetsByPrice(double price) {
        return gadgetRepository.gadgetsByPrice(price);
    }

    public List<CleaningProduct> gadgetsByCategory(String category) {
        return gadgetRepository.gadgetsByCategory(category);
    }

    public List<CleaningProduct> gadgetsByName(String name) {
        return gadgetRepository.gadgetsByName(name);
    }

    public List<String> getAllCategories() {
        List<String> categoryList = new ArrayList<>();
        MongoCollection mongoCollection = mongoTemplate.getCollection("gadgets");
        DistinctIterable distinctIterable = mongoCollection.distinct("category", String.class);
        MongoCursor cursor = distinctIterable.iterator();
        while (cursor.hasNext()) {
            String category = (String) cursor.next();
            categoryList.add(category);
        }

        return categoryList;
    }

    //Reto 5
    public List<CleaningProduct> findByDescriptionLike(String description) {
        return gadgetRepository.findByDescriptionLike(description);
    }

}

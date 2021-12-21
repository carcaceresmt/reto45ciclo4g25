package com.g25.reto5.appg25clean.controller;


import com.g25.reto5.appg25clean.model.CleaningProduct;
import com.g25.reto5.appg25clean.service.CleaningProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author desaextremo
 */
@RestController
@RequestMapping("/api/cleaningprod")
@CrossOrigin("*")
public class CleaningProductController {

    @Autowired
    private CleaningProductService gadgetService;

    @GetMapping("/all")
    public List<CleaningProduct> getAll() {
        return gadgetService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<CleaningProduct> getGadget(@PathVariable("id") int id) {
        return gadgetService.getGadget(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct create(@RequestBody CleaningProduct gadget) {
        return gadgetService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct gadget) {
        return gadgetService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return gadgetService.delete(id);
    }

    @GetMapping("/category/{category}")
    public List<CleaningProduct> gadgetsByCategory(@PathVariable("category") String category) {
        return gadgetService.gadgetsByCategory(category);
    }

    //Reto 5
    @GetMapping("/price/{precio}")
    public List<CleaningProduct> gadgetsByPrice(@PathVariable("precio") double precio) {
        return gadgetService.gadgetsByPrice(precio);
    }

    @GetMapping("/name/{name}")
    public List<CleaningProduct> gadgetsByName(@PathVariable("name") String name) {
        return gadgetService.gadgetsByName(name);
    }

    @GetMapping("/category")
    public List<String> category() {
        return gadgetService.getAllCategories();
    }

    //Reto 5
    @GetMapping("/description/{description}")
    public List<CleaningProduct> findByDescriptionLike(@PathVariable("description") String description) {
        return gadgetService.findByDescriptionLike(description);
    }
}

package dev.fujioka.java.avancado.web.web.rest;

import dev.fujioka.java.avancado.web.domain.Product;
import dev.fujioka.java.avancado.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> getProductList() {
        return productService.findAll();
    }


    @PostMapping("/product")
    public ResponseEntity<Product> save(
            @RequestBody Product product) {

        product = productService.save(product).get();

        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> update(
            @RequestBody Product product) {

        product = productService.save(product).get();

        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> delete(
            @RequestBody Product product) {

        productService.delete(product);
        return ResponseEntity.ok().body("Product excluded " + product.getId());
    }

    @GetMapping("/product/{name}")
    public List<Product> listProductsByName(@PathVariable String name) {
        return productService.listProductsByName(name);
    }

    @GetMapping(value = "/product/id/{id}")
    public List<Product> getListById(@PathVariable Long id){
        return productService.getListById(id);
    }

    @GetMapping(value = "/product/description/{description}")
    public List<Product> getProductByDescription(@PathVariable String description){
        return productService.getProductByDescription(description);
    }

    @GetMapping(value = "/product/nameanddescription/{name}/{description}")
    public List<Product> getProductByNameAndDescription(@PathVariable String name, @PathVariable String description){
        return productService.getProductByNameAndDescription(name, description);
    }
}
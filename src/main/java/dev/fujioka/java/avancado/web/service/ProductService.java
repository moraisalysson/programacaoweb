package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.domain.Product;
import dev.fujioka.java.avancado.web.domain.StatusProduto;
import dev.fujioka.java.avancado.web.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService
        implements CrudInterface<Product> {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> save(Product entity) {
        return Optional.of(productRepository.save(entity));
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(Product entity) {
        productRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public long count() {
        return productRepository.count();
    }

    public List<Product> listProductsByName(String name) { return productRepository.findProductByName(name); }

    public List<Product> getListById(Long id){ return productRepository.findProductById(id); }

    public List<Product> getProductByDescription(String description) {
        return productRepository.findProductByDescription(description);
    }

    public List<Product> getProductByNameAndDescription(String name, String description) {
        return productRepository.findProductByNameAndDescription(name, description);
    }

    public List<Product> getProductByStatus(StatusProduto status) {
    	return productRepository.findProductByStatus(status);
    }
}
package dev.fujioka.java.avancado.web.repository;

import dev.fujioka.java.avancado.web.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository
     extends JpaRepository<Product, Long> {

    public List<Product> findProductByName(@Param("name") String name);

    public List<Product> findProductById(@Param("id") Long id);

    public List<Product> findProductByDescription(@Param("description") String description);

    public List<Product> findProductByNameAndDescription(
            @Param("name") String name, @Param("description") String description
    );

}
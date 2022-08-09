package ru.pel.tests.multicartatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.pel.tests.multicartatest.entity.Product;

import java.util.Optional;

@Repository
//@RepositoryRestResource/*(collectionResourceRel = "products", path = "products")*/
public interface ProductsRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

//    @Override
//    @Modifying
//    @Query(value = "INSERT INTO products (name) VALUES (:product.name) ON CONFLICT DO NOTHING", nativeQuery = true)
//    <S extends Product> S save(S product);
}

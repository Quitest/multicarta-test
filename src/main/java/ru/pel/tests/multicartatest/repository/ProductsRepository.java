package ru.pel.tests.multicartatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pel.tests.multicartatest.entity.Product;

@Repository
//@RepositoryRestResource/*(collectionResourceRel = "products", path = "products")*/
public interface ProductsRepository extends JpaRepository<Product, Long> {
}

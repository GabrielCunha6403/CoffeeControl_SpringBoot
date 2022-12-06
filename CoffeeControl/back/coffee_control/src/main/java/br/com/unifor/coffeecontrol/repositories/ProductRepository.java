package br.com.unifor.coffeecontrol.repositories;

import br.com.unifor.coffeecontrol.modelos.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findByName(String name);

}

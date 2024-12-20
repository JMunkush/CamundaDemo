package io.munkush.com.repo;

import io.munkush.com.entity.Product;
import io.munkush.com.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Boolean existsByName(String name);
    Product findByName(String name);


    List<Product> findByActiveIdAndStatusIn(Long activeId, List<Status> statusList);
}

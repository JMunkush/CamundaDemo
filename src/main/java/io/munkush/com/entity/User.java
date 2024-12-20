package io.munkush.com.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @OneToMany
    private List<Product> purchasedProducts;

    public void addPurchasedProduct(Product product){
        this.purchasedProducts.add(product);
    }

}

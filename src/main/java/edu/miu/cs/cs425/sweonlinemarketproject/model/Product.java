package edu.miu.cs.cs425.sweonlinemarketproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @NotNull
    @NotBlank
    @Column(length = 50, nullable = false)
    private String name;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private BigDecimal price;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String description;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private int quantity;

    private String category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @OneToOne
    @JoinColumn(name = "ShoppingCartItem_Id")
    private ShoppingCartItem shoppingCartItem;

}

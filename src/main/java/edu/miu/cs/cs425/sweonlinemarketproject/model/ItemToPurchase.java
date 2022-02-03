package edu.miu.cs.cs425.sweonlinemarketproject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//@Table(name = "items")

public class ItemToPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;


    @NotNull
    @Column(nullable = false)
    private BigDecimal itemPricePerUnit;


    @NotNull
    @Column(nullable = false)
    private int quantity;

    @NotNull
    @Column(nullable = false, unique = true)
    private String sku;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;
}

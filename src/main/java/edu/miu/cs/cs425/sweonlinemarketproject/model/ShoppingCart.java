package edu.miu.cs.cs425.sweonlinemarketproject.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.MERGE)
    private User buyer;

    @ManyToMany
    private List<Product> products;
}

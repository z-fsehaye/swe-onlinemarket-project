package edu.miu.cs.cs425.sweonlinemarketproject.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "shoppingCart",cascade = CascadeType.MERGE)
    private User buyer;



    @OneToMany(mappedBy = "shoppingCart")
    private List<ShoppingCartItem> shoppingCartItem;
}

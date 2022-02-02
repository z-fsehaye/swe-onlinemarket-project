package edu.miu.cs.cs425.sweonlinemarketproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "shoppingcartitems")
public class ShoppingCartItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "shoppingcart_id")
    private ShoppingCart shoppingCart;

    @OneToOne(mappedBy = "shoppingCartItem")
    private Product product;
}

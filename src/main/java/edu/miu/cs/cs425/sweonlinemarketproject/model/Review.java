package edu.miu.cs.cs425.sweonlinemarketproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reviewText;
    private String userId;
    private boolean approveStatus;

    @ManyToOne
    @JoinColumn(name = "product_product_id")
    private Product product;

}

package edu.miu.cs.cs425.sweonlinemarketproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name= "orders")
public class Order implements Serializable {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String orderStatus;
    @NotNull
    @DateTimeFormat(pattern= "yyyy-mm-dd")
    private LocalDate createdAt;
    @NotNull
    @Column(nullable= false)
    private double price;

    @ManyToOne
    private User owner;

    //we get products from user of the owner by getCart


    public Order(String orderStatus, LocalDate createdAt, double price, User owner) {
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
        this.price = price;
        this.owner = owner;
    }

    @Override
    public java.lang.String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderStatus=" + orderStatus +
                ", createdAt=" + createdAt +
                ", price=" + price +
                ", owner=" + owner +
                '}';
    }


}

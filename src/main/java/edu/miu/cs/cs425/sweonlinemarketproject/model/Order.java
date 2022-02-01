package edu.miu.cs.cs425.sweonlinemarketproject.model;

import edu.miu.cs.cs425.sweonlinemarketproject.constant.AppConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name= "orders")
public class Order {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @NotNull
    @NotBlank
    private AppConstant orderStatus;
    @NotNull
    @DateTimeFormat(pattern= "yyyy-mm-dd")
    private LocalDate createdAt;
    @NotNull
    @DateTimeFormat(pattern= "yyyy-mm-dd")
    private LocalDate modifiedAt;
    @Column(nullable= false)
    private Double price;

    @ManyToOne
    private User owner;

    @OneToMany
    private List<Product> products;


    public Order() {
    }

    public Order(Long orderId, AppConstant orderStatus, LocalDate createdAt, LocalDate modifiedAt, Double price, User owner, List<Product> products) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.price = price;
        this.owner = owner;
        this.products = products;
    }

    public Order(AppConstant orderStatus, LocalDate createdAt, LocalDate modifiedAt, Double price, User owner, List<Product> products) {
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.price = price;
        this.owner = owner;
        this.products = products;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public AppConstant getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(AppConstant orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDate modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderStatus=" + orderStatus +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", price=" + price +
                ", owner=" + owner +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId) && orderStatus == order.orderStatus && Objects.equals(createdAt, order.createdAt) && Objects.equals(modifiedAt, order.modifiedAt) && Objects.equals(price, order.price) && Objects.equals(owner, order.owner) && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderStatus, createdAt, modifiedAt, price, owner, products);
    }
}

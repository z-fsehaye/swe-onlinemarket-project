package edu.miu.cs.cs425.sweonlinemarketproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.cs.cs425.sweonlinemarketproject.constant.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;

    @NotNull
    @NotBlank(message = "Required")
    @Column(nullable = false)
    private String cardName;

    @NotNull
    @NotBlank(message = "Required")
    @Column(nullable = false)
    private PaymentType type;

    @NotNull
    @NotBlank(message = "Required")
    @Column(nullable = false, unique = true)
    private String cardNumber;

    @NotNull
    @NotBlank(message = "Required")
    @Column(nullable = false)
    private int csv;

    @Column(name = "is-default")
    private boolean isDefault;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user-id", nullable = false)
    @JsonBackReference
    private User user;


}

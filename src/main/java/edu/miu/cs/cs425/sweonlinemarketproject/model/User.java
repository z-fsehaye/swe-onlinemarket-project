package edu.miu.cs.cs425.sweonlinemarketproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String firstName;
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String lastName;
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String userName;
    @Email
    private String email;
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String password;
    @NotNull
    @NotBlank
//    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private boolean approvedSeller;
    private long createDate;
    private long modifiedDate;
    @OneToMany(mappedBy = "user")
    private List<Address> address;
//    @OneToMany(mappedBy = "user")
//    List<Payment> payment;

}

package edu.miu.cs.cs425.sweonlinemarketproject.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String roleId;
    @OneToMany(mappedBy = "role")
    private List<User> user;

}

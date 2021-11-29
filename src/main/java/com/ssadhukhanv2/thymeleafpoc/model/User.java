package com.ssadhukhanv2.thymeleafpoc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotBlank(message = "Username is not optional")
    private String userName;




    // https://www.baeldung.com/javax-validation
//    @NotBlank(message = "Email is mandatory")
//    @Email(message = "Please use a valid email")
    private String userEmail;


    @JsonIgnore
    @NotBlank(message = "Password is not optional")
    private String userPassword;
    @CreationTimestamp
    LocalDateTime createdDate;
    @UpdateTimestamp
    LocalDateTime lastUpdatedDate;



    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Node> nodeList=new ArrayList<Node>();

    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Information> informationList=new ArrayList<>();


    public void addNode(Node node) {
        nodeList.add(node);
    }

}

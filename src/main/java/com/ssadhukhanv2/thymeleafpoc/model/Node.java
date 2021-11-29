package com.ssadhukhanv2.thymeleafpoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nodeId;
    private String nodeIdentifier;
    private String nodeTitle;
    private String nodeDescription;

    @Enumerated(EnumType.STRING)
    private NodeCategory nodeCategory;


    @CreationTimestamp
    LocalDateTime createdDate;
    // @UpdateTimestamp is modified on update
    @UpdateTimestamp
    LocalDateTime lastUpdatedDate;


    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "NODE_INFORMATION", joinColumns = {@JoinColumn(
            name = "NODE_ID"
    )}, inverseJoinColumns = {@JoinColumn(name = "INFORMATION_ID")})
    List<Information> informationList = new ArrayList<Information>();


    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public void addInformation(Information information) {
        this.informationList.add(information);
    }


}

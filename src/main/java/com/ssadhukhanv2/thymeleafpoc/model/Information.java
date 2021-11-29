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
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long informationId;
    private String informationTitle;
    private String informationDescription;
    private String informationUrl;
    @CreationTimestamp
    LocalDateTime createdDate;
    @UpdateTimestamp
    LocalDateTime lastUpdatedDate;


    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "informationList")
    private List<Node> nodeList = new ArrayList<Node>();

    @ToString.Exclude
    @ManyToOne
    private User user;

    public void addNode(Node node) {
        this.nodeList.add(node);
    }

}

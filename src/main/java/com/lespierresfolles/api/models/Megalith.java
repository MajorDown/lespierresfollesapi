package com.lespierresfolles.api.models;

import com.lespierresfolles.api.models.enums.Conservation;
import com.lespierresfolles.api.models.enums.MegalithType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Megalith {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private int department;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private MegalithType type;

    private Boolean publicAccess;

    private String description;

    private Double size;

    private Double weight;

    private String material;

    @Column(nullable = false)
    private Conservation conservation;

    private String imageUrl1;
    private String imageUrl2;
    private String imageUrl3;
    private String imageUrl4;
    private String imageUrl5;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate date;

    @OneToMany(mappedBy = "megalith", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Post> posts;
}

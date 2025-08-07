package com.lespierresfolles.api.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "megalith_id", nullable = false)
    private Megalith megalith;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;
}

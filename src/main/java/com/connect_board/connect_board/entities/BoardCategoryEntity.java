package com.connect_board.connect_board.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "board_categories")
@NoArgsConstructor
@AllArgsConstructor
public class BoardCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "description")
    private String description;

    ManyToMany(mappedBy = "categories")
    private List<BoardEntity> boards;
}

package com.connect_board.connect_board.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

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

    @ManyToMany(mappedBy = "categories")
    private Set<BoardEntity> boards;

    public void addBoardEntity(BoardEntity board){
        boards.add(board);
        board.getCategories().add(this);

    }

    public void removeBoardEntity(BoardEntity board){
        boards.remove(board);
        board.getCategories().remove(this);
    }
}

package com.connect_board.connect_board.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "board_categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "categories")
    private Set<BoardEntity> boards = new HashSet<>();

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }

    // TO DO implement equals - https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
    @Override
    public boolean equals(Object ob){
        if(ob == null){
            return false;
        }
        if(!(ob instanceof BoardCategoryEntity)){
            return false;
        }

        return id != null && id.equals(((BoardCategoryEntity) ob).getId());
    }

}

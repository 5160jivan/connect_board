package com.connect_board.connect_board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "board")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", nullable = false)
    private UserEntity createdBy;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "board_categories", joinColumns = @JoinColumn(name = "board_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<BoardCategoryEntity> categories;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BoardMemberEntity> boardMembers;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "modified_date")
    private String modifiedDate;

    @Column(name = "deleted_date")
    private String deletedDate;

    @PrePersist
    void createdAt() {
        this.createdDate = String.valueOf(new Timestamp(System.currentTimeMillis()));
    }

    @PreUpdate
    void updatedAt() {
        this.modifiedDate = String.valueOf(new Timestamp(System.currentTimeMillis()));
    }

    @PreRemove
    void beforeDelete() {
        this.deletedDate = String.valueOf(new Timestamp(System.currentTimeMillis()));
    }

    public void addBoardCategory(BoardCategoryEntity boardCategory){
        categories.add(boardCategory);
        boardCategory.getBoards().add(this);
    }

    public void removeBoardCategory(BoardCategoryEntity boardCategory){
        categories.remove(boardCategory);
        boardCategory.getBoards().remove(this);
    }

    public void addBoardMember(BoardMemberEntity boardMember){
        boardMembers.add(boardMember);
        boardMember.setBoard(this);

    }

    public void removeBoardMember(BoardMemberEntity boardMember){
        boardMembers.remove(boardMember);
        boardMember.setBoard(null);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(!(obj instanceof BoardEntity)) return false;

        return id != null && id.equals(((BoardEntity) obj).getId());
    }



}

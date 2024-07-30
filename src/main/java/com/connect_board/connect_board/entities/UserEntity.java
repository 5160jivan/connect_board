package com.connect_board.connect_board.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import jakarta.validation.constraints.NotNull;
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoardEntity> boards;

    public void addBoard(BoardEntity board) {
        boards.add(board);
        board.setCreatedBy(this);
    }

    public void removeBoard(BoardEntity board) {
        boards.remove(board);
        board.setCreatedBy(null);
    }
}

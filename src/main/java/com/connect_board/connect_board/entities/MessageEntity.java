package com.connect_board.connect_board.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "messages", indexes = {
        @Index(name = "idx_board_message", columnList = "board_id, created_at"),
        @Index(name = "idx_user_message", columnList = "user_id, created_at")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageEntity {
    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "board_id", nullable = false)
    private BoardEntity board;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @NotNull
    private String message;

    @Column(name = "created_date")
    private String createdDate;

    @Column(name = "updated_date")
    private String updatedDate;

    @Column(name = "deleted_date")
    private String deletedDate;

    @PrePersist
    void createdAt() {
        this.createdDate = String.valueOf(new Timestamp(System.currentTimeMillis()));
    }

    @PreUpdate
    void updatedAt() {
        this.updatedDate = String.valueOf(new Timestamp(System.currentTimeMillis()));
    }
}

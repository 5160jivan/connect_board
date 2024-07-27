package com.connect_board.connect_board.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO{
    private Long id;

    @NotBlank
    private String title;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private String createdBy;

    @NotNull
    private String createdDate;

    @NotNull
    private String modifiedDate;

}

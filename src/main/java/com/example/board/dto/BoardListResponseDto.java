package com.example.board.dto;

import com.example.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardListResponseDto {
    private Long id;
    private String title;
    private String writer;

    public BoardListResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.writer = board.getWriter();
    }
}

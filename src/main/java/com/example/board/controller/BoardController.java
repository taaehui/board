package com.example.board.controller;

import com.example.board.dto.BoardListResponseDto;
import com.example.board.dto.BoardRequestDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.entity.Board;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/BoardUp")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }

    @GetMapping("/{id}")
    public BoardResponseDto getBoard(@PathVariable Long id) {
        return boardService.getBoard(id);
    }

    @GetMapping
    public List<BoardListResponseDto> getBoardList() {
        return boardService.getBoardList();
    }

    @PutMapping("/update")
    public void updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        boardService.updateBoard(id, requestDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBoard(@PathVariable("id") Long id) {
        return boardService.deleteBoard(id);
    }
}

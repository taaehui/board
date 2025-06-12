package com.example.board.service;

import com.example.board.dto.BoardListResponseDto;
import com.example.board.dto.BoardRequestDto;
import com.example.board.dto.BoardResponseDto;
import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board createBoard(BoardRequestDto requestDto) {
        Board board = Board.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .writer(requestDto.getWriter())
                .build();
        boardRepository.save(board);
        return board;
    }

    public BoardResponseDto getBoard(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        return new BoardResponseDto(board);
    }

    public List<BoardListResponseDto> getBoardList() {
        return boardRepository.findAll().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
    }

    public void updateBoard(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        board.setTitle(requestDto.getTitle());
        board.setContent(requestDto.getContent());
        board.setWriter(requestDto.getWriter());

        boardRepository.save(board);
    }

    public String deleteBoard(Long id){
        boardRepository.deleteById(id);
        return "삭제 성공!";
    }
}

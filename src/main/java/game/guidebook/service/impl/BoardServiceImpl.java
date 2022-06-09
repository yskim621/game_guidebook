package game.guidebook.service.impl;

import game.common.persist.query.SearchResult;
import game.guidebook.api.dto.BoardDto;
import game.guidebook.api.dto.BoardForm;
import game.guidebook.domain.Board;
import game.guidebook.repository.BoardRepository;
import game.guidebook.service.BoardService;
import game.guidebook.service.dto.QueryParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public SearchResult<BoardDto> findAll(QueryParam query_param, int offset, int limit) {

        List<Board> boards = boardRepository.findAll(query_param, offset, limit);
        List<BoardDto> collect = boards.stream()
                .map(BoardDto::new)
                .collect(Collectors.toList());

        SearchResult<BoardDto> result = new SearchResult<>();
        result.setResult(collect);
        result.setCount(collect.size());
        return result;
    }

    @Override
    public Board detail(Long id) {
        return boardRepository.findOne(id);
    }

    @Override
    public void create(BoardForm boardForm) {
        Board board = new Board();
        board.setTitle(boardForm.getTitle());
        board.setContent(boardForm.getContent());
        board.setUserNickname(boardForm.getUserNickname());
        board.setAttachment(boardForm.getAttachment());
        board.setWriteDate(new Date());
        boardRepository.create(board);
    }

    @Override
    public Long update(Long id, Board board) {
        Board originalContent = boardRepository.findOne(id);
        originalContent.setTitle(board.getTitle());
        originalContent.setContent(board.getContent());
        originalContent.setAttachment(board.getAttachment());
        originalContent.setWriteDate(new Date());
        return id;
    }

    @Override
    public Long delete(Long id) {
        return boardRepository.delete(id);
    }
}

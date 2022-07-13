package game.guidebook.service.impl;

import game.common.persist.query.SearchResult;
import game.guidebook.api.dto.BoardDto;
import game.guidebook.api.dto.BoardForm;
import game.guidebook.domain.Board;
import game.guidebook.repository.BoardJpaRepository;
import game.guidebook.repository.BoardRepository;
import game.guidebook.repository.impl.BoardRepositoryImpl;
import game.guidebook.service.BoardService;
import game.guidebook.service.dto.QueryParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardJpaRepository boardJpaRepository;
    private final BoardRepositoryImpl boardRepositoryImpl;
    private final BoardRepository boardRepository;

    @Override
    public SearchResult<BoardDto> findAll(QueryParam query_param) {

        List<Board> boards = boardJpaRepository.findAll(query_param);
        List<BoardDto> collect = boards.stream()
                .map(BoardDto::new)
                .collect(Collectors.toList());

        SearchResult<BoardDto> result = new SearchResult<>();
        result.setResult(collect);
        result.setCount(boardRepositoryImpl.findCountByCondition(query_param));
        return result;
    }

    @Override
    public Board detail(Long id) {
        Optional<Board> optBoard = boardRepository.findById(id);
        if (optBoard.isPresent()) {
            Integer readCnt = optBoard.get().getReadCnt();
            readCnt = readCnt + 1;
            optBoard.get().setReadCnt(readCnt);
        }

        return optBoard.orElseThrow();
    }

    @Override
    public void create(BoardForm boardForm) {
        Board board = new Board();
        board.setTitle(boardForm.getTitle());
        board.setContent(boardForm.getContent());
        board.setUserNickname(boardForm.getUserNickname());
        board.setAttachment(boardForm.getAttachment());
        board.setWriteDate(new Date());
        boardRepository.save(board);
    }

    @Override
    public Long update(Long id, Board board) {
        Board originalContent = boardJpaRepository.findOne(id);
        originalContent.setTitle(board.getTitle());
        originalContent.setContent(board.getContent());
        originalContent.setAttachment(board.getAttachment());
        originalContent.setWriteDate(new Date());
        return id;
    }

    @Override
    public Long delete(Long id) {
        Board board = boardRepository.getById(id);
        boardRepository.delete(board);
        return board.getId();
    }
}

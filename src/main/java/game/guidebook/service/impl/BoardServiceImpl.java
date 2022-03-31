package game.guidebook.service.impl;

import game.guidebook.domain.Board;
import game.guidebook.repository.BoardRepository;
import game.guidebook.service.BoardService;
import game.guidebook.service.dto.QueryParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<Board> list(QueryParam query_param, int offset, int limit) {
        return boardRepository.findAll(query_param, offset, limit);
    }

    @Override
    public Board detail(Long id) {
        return boardRepository.findOne(id);
    }

    @Override
    public void create(MultipartHttpServletRequest request) {

    }

    @Override
    public void update(MultipartHttpServletRequest request) {

    }

    @Override
    public Long delete(Long id) {
        return boardRepository.delete(id);
    }
}

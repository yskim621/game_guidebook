package game.guidebook.service;

import game.common.persist.query.SearchResult;
import game.guidebook.api.dto.BoardDto;
import game.guidebook.api.dto.BoardForm;
import game.guidebook.domain.Board;
import game.guidebook.service.dto.QueryParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BoardService {

    // 전체 보기를 위한 메소드
    public SearchResult<BoardDto> findAll(QueryParam query_param);

    // 상세 보기를 위한 메소드
    public Board detail(Long id);

    // 데이터 생성을 위한 메소드
    public void create(BoardForm boardForm);

    // 데이터 수정을 위한 메소드
    public Long update(Long id, Board board);

    // 데이터 삭제을 위한 메소드
    public Long delete(Long id);
}

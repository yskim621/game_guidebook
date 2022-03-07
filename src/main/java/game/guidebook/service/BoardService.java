package game.guidebook.service;

import game.guidebook.domain.Board;
import game.guidebook.service.dto.QueryParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BoardService {

    // 전체 보기를 위한 메소드
    public List<Board> list(QueryParam query_param, int offset, int limit);

    // 상세 보기를 위한 메소드
    public Board detail(Long id);

    // 데이터 생성을 위한 메소드
    public void create(MultipartHttpServletRequest request);

    // 데이터 수정을 위한 메소드
    public void update(MultipartHttpServletRequest request);

    // 데이터 삭제을 위한 메소드
    public void delete(HttpServletRequest request);
}

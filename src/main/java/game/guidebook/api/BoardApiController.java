package game.guidebook.api;

import game.common.persist.query.SearchResult;
import game.guidebook.api.dto.BoardDto;
import game.guidebook.domain.Board;
import game.guidebook.repository.BoardRepository;
import game.guidebook.service.BoardService;
import game.guidebook.service.dto.QueryParam;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board")
public class BoardApiController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @PostMapping("ajaxList")
    public SearchResult<BoardDto> list(QueryParam query_param, Model model,
                               @RequestParam(value = "offset", defaultValue = "0") int offset,
                               @RequestParam(value = "limit", defaultValue = "100") int limit
    ) {
        List<Board> boards = boardRepository.findAll(query_param, offset, limit);
        List<BoardDto> collect = boards.stream()
                .map(board -> new BoardDto(board))
                .collect(Collectors.toList());

        SearchResult<BoardDto> result = new SearchResult<>();
        result.setResult(collect);
        return result;
    }

}

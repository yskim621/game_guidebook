package game.guidebook.api;

import game.common.persist.query.SearchResult;
import game.common.util.Validate;
import game.guidebook.api.dto.BoardDto;
import game.guidebook.common.AjaxResponseBody;
import game.guidebook.controller.BaseController;
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
public class BoardApiController extends BaseController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @PostMapping("ajaxList")
    public SearchResult<BoardDto> contentList(@RequestBody QueryParam query_param, Model model,
                               @RequestParam(value = "offset", defaultValue = "0") int offset,
                               @RequestParam(value = "limit", defaultValue = "10") int limit
    ) {
        List<Board> boards = boardRepository.findAll(query_param, offset, limit);
        List<BoardDto> collect = boards.stream()
                .map(BoardDto::new)
                .collect(Collectors.toList());

        SearchResult<BoardDto> result = new SearchResult<>();
        result.setResult(collect);
        result.setCount(collect.size());
        return result;
    }

    @PostMapping("delete/{id}")
    public AjaxResponseBody deleteContent(@PathVariable Long id) {
        if (Validate.validateObjectsNullOrEmpty(id))
        {
            return returnErrorBody("데이터가 검증되지 않았습니다, 페이지 새로고침 후 다시 시도해주세요!");
        }
        try
        {
            boardService.delete(id);
            return returnSuccessBody();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return returnErrorBody(ex);
        }
    }

}

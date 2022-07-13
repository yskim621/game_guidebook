package game.guidebook.api;

import game.common.persist.query.SearchResult;
import game.common.util.Validate;
import game.guidebook.api.dto.BoardDto;
import game.guidebook.api.dto.BoardForm;
import game.guidebook.common.AjaxResponseBody;
import game.guidebook.controller.BaseController;
import game.guidebook.domain.Board;
import game.guidebook.repository.BoardJpaRepository;
import game.guidebook.service.BoardService;
import game.guidebook.service.dto.QueryParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/board")
public class BoardApiController extends BaseController {

    private final BoardService boardService;

    @PostMapping("ajaxList")
    public SearchResult<BoardDto> contentList(@RequestBody QueryParam query_param) {
        System.out.println("BoardApiController.contentList 호출 ==========================================================================");
        log.info("searchType = {}", query_param.getSearchType());
        log.info("value = {}", query_param.getValue());
        return boardService.findAll(query_param);
    }

    @PostMapping("create")
    public AjaxResponseBody createContent(@ModelAttribute BoardForm boardForm) {
        try
        {
            boardService.create(boardForm);
            return returnSuccessBody("게시글 작성이 완료 되었습니다.");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return returnErrorBody(ex);
        }
    }

    @PostMapping("update/{id}")
    public AjaxResponseBody updateContent(@PathVariable("id") Long id, @ModelAttribute("board") Board board) {
        try
        {
            boardService.update(id, board);
            return returnSuccessBody("수정이 완료 되었습니다.");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return returnErrorBody(ex);
        }
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

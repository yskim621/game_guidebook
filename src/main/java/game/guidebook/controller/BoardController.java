package game.guidebook.controller;

import game.common.util.Validate;
import game.guidebook.common.AjaxResponseBody;
import game.guidebook.domain.Board;
import game.guidebook.repository.BoardRepository;
import game.guidebook.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping(value="board")
public class BoardController extends BaseController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;


//    @GetMapping("/")
//    public String board(HttpServletRequest request) {
//
//        return "member/login/login";
//    }

    @GetMapping("list")
    public String list(Model model,
                       @RequestParam(value = "offset", defaultValue = "0") int offset,
                       @RequestParam(value = "limit", defaultValue = "100") int limit
    ) {

//        List<Board> boards = boardService.list(offset, limit);
//        model.addAttribute("result", boards);
        return "board/list";
    }


    @GetMapping("get/{id}")
    public String detail(@PathVariable Long id, ModelMap map) {

        Board board = boardRepository.findOne(id);
        map.put("board", board);

        return "board/detail";
    }


    @RequestMapping(value="write", method = RequestMethod.GET)
    public String insert() {

        return "board/create";
    }


    @GetMapping("update/{id}")
    public String update(@PathVariable Long id, ModelMap map) {

        // 서비스 메소드 호출
        Board board = boardRepository.findOne(id);
        map.put("board", board);

        return "board/update";
    }

    @PostMapping("update/{id}")
    public AjaxResponseBody updateContent(@PathVariable("id") Long id, @ModelAttribute("board") Board board) {
        System.out.println("id = " + id + "=====================================================================");
        try
        {
            boardService.update(id, board);
            return returnSuccessBody("수정이 완료되었습니다.");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return returnErrorBody(ex);
        }
    }
}

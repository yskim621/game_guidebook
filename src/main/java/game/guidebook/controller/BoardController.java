package game.guidebook.controller;

import game.guidebook.api.dto.BoardDto;
import game.guidebook.domain.Board;
import game.guidebook.repository.BoardRepository;
import game.guidebook.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="board")
public class BoardController {

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

        List<Board> boards = boardService.list(offset, limit);
        model.addAttribute("result", boards);
        return "board/list";
    }


    @RequestMapping(value="get/{id}", method = RequestMethod.GET)
    public String detail(HttpServletRequest request, @PathVariable Long id) {

        boardService.detail(id);

        return "board/detail";
    }


    @RequestMapping(value="write", method = RequestMethod.GET)
    public String insert() {

        return "board/create";
    }


    @RequestMapping(value="alter/{boardnum}", method = RequestMethod.GET)
    public String update(HttpServletRequest request, @PathVariable Long id) {

        // 서비스 메소드 호출
        boardService.detail(id);

        return "board/update";
    }
}

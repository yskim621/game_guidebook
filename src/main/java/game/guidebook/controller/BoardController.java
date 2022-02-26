package game.guidebook.controller;

import game.guidebook.domain.Board;
import game.guidebook.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="board")
public class BoardController {

    private final BoardService boardService;


//    @GetMapping("/")
//    public String board(HttpServletRequest request) {
//
//        return "member/login/login";
//    }

    @GetMapping("list")
    public String list(Model model) {
        List<Board> boards = boardService.list();
        model.addAttribute("result", boards);
        return "board/list";
    }


    @RequestMapping(value="get/{boardnum}", method = RequestMethod.GET)
    public String detail(HttpServletRequest request) {

        boardService.detail(request);

        return "board/detail";
    }


    @RequestMapping(value="write", method = RequestMethod.GET)
    public String insert() {

        return "board/create";
    }


    @RequestMapping(value="alter/{boardnum}", method = RequestMethod.GET)
    public String update(HttpServletRequest request) {

        // 서비스 메소드 호출
        boardService.detail(request);

        return "board/update";
    }
}

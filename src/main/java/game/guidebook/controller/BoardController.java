package game.guidebook.controller;

import game.guidebook.domain.Board;
import game.guidebook.repository.BoardJpaRepository;
import game.guidebook.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value="board")
public class BoardController extends BaseController {

    private final BoardService boardService;
    private final BoardJpaRepository boardJpaRepository;

    @GetMapping("list")
    public String list(Model model,
                       @RequestParam(value = "offset", defaultValue = "0") int offset,
                       @RequestParam(value = "limit", defaultValue = "100") int limit
    ) {

        return "board/list";
    }


    @GetMapping("get/{id}")
    public String detail(@PathVariable Long id, ModelMap map) {

        Board board = boardJpaRepository.findOne(id);
        map.put("board", board);

        return "board/detail";
    }


    @GetMapping("create")
    public String create() {

        return "board/create";
    }


    @GetMapping("update/{id}")
    public String update(@PathVariable Long id, ModelMap map) {

        // 서비스 메소드 호출
        Board board = boardJpaRepository.findOne(id);
        map.put("board", board);

        return "board/update";
    }

}

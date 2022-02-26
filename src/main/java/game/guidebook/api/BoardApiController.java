package game.guidebook.api;

import game.guidebook.domain.Board;
import game.guidebook.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board")
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("ajaxList")
    public List<Board> list(Model model) {
        return boardService.list();
    }

}

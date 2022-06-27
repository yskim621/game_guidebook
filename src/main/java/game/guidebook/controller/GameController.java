package game.guidebook.controller;

import game.guidebook.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping(value="game")
public class GameController extends BaseController {

    private final GameService gameService;

    @GetMapping("trumpcard")
    public String trumpcardView() {

        return "game/trumpcard";
    }

    @GetMapping("hwatu")
    public String hwatuView() {

        return "game/hwatu";
    }

    @GetMapping("boardgame")
    public String boardgameView() {

        return "game/boardgame";
    }

}

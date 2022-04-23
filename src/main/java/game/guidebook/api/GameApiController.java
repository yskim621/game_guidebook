package game.guidebook.api;

import game.guidebook.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="api/game")
public class GameApiController {

    private final GameService gameService;

    // Trumpcard
    @RequestMapping(value = "trumpcard/black_jack")
    public Map<String, Object> gameInfo_blackjack(HttpServletRequest request) {

        return getStringObjectMap(request);
    }

    @RequestMapping(value = "trumpcard/bacara")
    public Map<String, Object> gameInfo_bacara(HttpServletRequest request) {

        return getStringObjectMap(request);
    }

    @RequestMapping(value = "trumpcard/hoola")
    public Map<String, Object> gameInfo_hoola(HttpServletRequest request) {

        return getStringObjectMap(request);
    }



    // Hwatu
    @RequestMapping(value = "hwatu/gostop")
    public Map<String, Object> gameInfo_gostop(HttpServletRequest request) {

        return getStringObjectMap(request);
    }

    @RequestMapping(value = "hwatu/seosda")
    public Map<String, Object> gameInfo_seosda(HttpServletRequest request) {

        return getStringObjectMap(request);
    }



    // Boardgame
    @RequestMapping(value = "boardgame/chess")
    public Map<String, Object> gameInfo_chess(HttpServletRequest request) {

        return getStringObjectMap(request);
    }

    @RequestMapping(value = "boardgame/go")
    public Map<String, Object> gameInfo_go(HttpServletRequest request) {

        return getStringObjectMap(request);
    }

    @RequestMapping(value = "boardgame/janggi")
    public Map<String, Object> gameInfo_janggi(HttpServletRequest request) {

        return getStringObjectMap(request);
    }

    @RequestMapping(value = "boardgame/omok")
    public Map<String, Object> gameInfo_omok(HttpServletRequest request) {

        return getStringObjectMap(request);
    }

    private Map<String, Object> getStringObjectMap(HttpServletRequest request) {
        gameService.gameInfo(request);

        List<String> result = (List<String>) request.getAttribute("result");

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", result);

        return map;
    }
}

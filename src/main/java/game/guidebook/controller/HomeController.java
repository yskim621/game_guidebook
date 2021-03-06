package game.guidebook.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;

@Slf4j
@Controller
public class HomeController extends BaseController {

    @RequestMapping("/")
    public String home() {
        log.info("home controller");
        return "home";
    }
}

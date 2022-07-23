package game.guidebook.controller;

import game.guidebook.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController extends BaseController {

    private final UserService userService;

    @GetMapping("register")
    public String register() {
        return "user/register";
    }

    @GetMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response, ModelMap map)
    {
//        if (UserUtils.isLogined())
//        {
//            return "redirect:/board/list";
//        }
//        else
//        {
//            if (request.getAttribute(SysConstants.LOGIN_ERR_MSG) != null)
//            {
//                map.put(SysConstants.REQUEST_KEY_LOGIN_PARAM_ERRORMESSAGE,
//                        request.getAttribute(SysConstants.LOGIN_ERR_MSG));
//            }
//
//            // 사용자 이름과 암호를 기억할지 여부 결정
//            Boolean rememberMe = true;
//            map.put(SysConstants.REQUEST_KEY_LOGIN_PARAM_REMEMBERME, rememberMe);
//        }
        return "user/login";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "user/login";
    }

}

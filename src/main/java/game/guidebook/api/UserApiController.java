package game.guidebook.api;

import game.common.util.Validate;
import game.guidebook.common.AjaxResponseBody;
import game.guidebook.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

import static game.guidebook.controller.BaseController.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value="api/user")
public class UserApiController {

    private final UserService userService;

    @RequestMapping(value = "register/exist/name")
    public boolean existUserName(String name, ModelMap map) throws Exception
    {
        return !userService.existUserName(name.trim());
    }

    @RequestMapping(value = "register/exist/mobile")
    public boolean existMobile(String mobile,ModelMap map) throws Exception
    {
        return !userService.existMobile(mobile.trim());
    }

    @RequestMapping(value = "register/exist/email")
    public boolean existEmail(String email, ModelMap map) throws Exception
    {
        return !userService.existEmail(email.trim());
    }

    @PostMapping(value = "login")
    public AjaxResponseBody login(String name, String password, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        if (Validate.validateObjectsNullOrEmpty(name, password))
        {
            return returnErrorBody("데이터가 검증되지 않았습니다, 페이지 새로고침 후 다시 시도해주세요!");
        }

        Map<String, Object> result = userService.login(name, password, request, response);
        if (result.get("result").equals("NotExistUser") || result.get("result").equals("WrongPassword") )
        {
            return returnErrorBody("아이디 또는 비밀번호 오류, 다시 시도해주세요");
        }
        return returnSuccessBody();
    }

}

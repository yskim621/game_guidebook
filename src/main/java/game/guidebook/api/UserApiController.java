package game.guidebook.api;

import game.common.util.Validate;
import game.guidebook.common.AjaxResponseBody;
import game.guidebook.common.utils.StringUtils;
import game.guidebook.common.utils.UserUtils;
import game.guidebook.constants.SysConstants;
import game.guidebook.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String login(String name, String password, ModelMap map) {
        log.info("name = {}", name);
        log.info("password = {}", password);
        String error_message = null;
        if (Validate.validateObjectsNullOrEmpty(name, password))
        {
            return returnErrorPage(map, "데이터가 검증되지 않았습니다, 페이지 새로고침 후 다시 시도해주세요!");
        }

        Map<String, Object> result = userService.login(name, password);
        if (result.get("result").equals("NotExistUser") || result.get("result").equals("WrongPassword") )
        {
            error_message = "아이디 또는 비밀번호오류, 다시 시도해주세요";
        }

        if (StringUtils.isNotBlank(error_message))
        {
            map.put(SysConstants.REQUEST_KEY_LOGIN_PARAM_ERRORMESSAGE, error_message);
//			map.put(SysConstants.REQUEST_KEY_LOGIN_PARAM_ISSHOWCAPTCHA, isCaptchaLogin(username, true, false));
            return "login";
        }
        else
        {
            return "redirect:/board/list";
        }
    }

}

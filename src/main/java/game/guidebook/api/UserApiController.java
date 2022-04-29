package game.guidebook.api;

import game.guidebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}

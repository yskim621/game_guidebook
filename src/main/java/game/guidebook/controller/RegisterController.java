package game.guidebook.controller;

import game.common.util.Validate;
import game.guidebook.common.AjaxResponseBody;
import game.guidebook.controller.dto.RegisterDto;
import game.guidebook.domain.User;
import game.guidebook.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * 注册控制层
 * </pre>
 * @author zhaojt
 * @version 1.0, 2016年9月3日
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("register")
public class RegisterController extends BaseController {

    private final UserService userService;

    @ResponseBody
    @PostMapping("authentication/send-sms")
    public AjaxResponseBody SendSms(String mobile)
    {
        try {
            if (Validate.validateObjectsNullOrEmpty(mobile)){
                return returnErrorBody("휴대폰 번호를 입력해주시길 바랍니다.");
            } else {
                String authenticateCode = userService.sendSms(mobile);
                return returnSuccessBody(authenticateCode);
            }

        } catch (Exception e)
        {
            e.printStackTrace();
            return returnErrorBody(e);
        }
    }

    @ResponseBody
    @PostMapping("authentication/confirm-code")
    public AjaxResponseBody authenticateSmsCode(String authenticateCode, String userCode)
    {
        try {
            if (Validate.validateObjectsNullOrEmpty(userCode)) {
                return returnErrorBody("인증번호를 입력하십시오.");
            }
            if (Validate.validateObjectsNullOrEmpty(authenticateCode)) {
                return returnErrorBody("인증번호를 전송 후 입력해주십시오.");
            }
            if (authenticateCode.equals(userCode)){
                return returnSuccessBody();
            } else {
                return returnErrorBody("전송된 인증번호와 일치하지 않습니다. 다시 확인하시고 입력하시길 바랍니다.");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
            return returnErrorBody(e);
        }
    }

	@PostMapping("form-submit")
	public String register_submit(HttpServletRequest request, ModelMap map, RegisterDto dto)
	{
        System.out.println("Register Controller 요청 도달==============================================================================");
		try
		{
//			if (Validate.validateObjectsNullOrEmpty(vo,vo.getUserName(),vo.getMobile(), vo.getEmail(),vo.getPassword(),vo.getValidCode()))
			if (Validate.validateObjectsNullOrEmpty(dto, dto.getName(),dto.getMobile(), dto.getEmail(),dto.getPassword()))
			{
				return returnErrorPage(map, "등록정보를 바르게 입력해 주세요");
			}

            userService.register(dto);

//			User user = serviceFactory.getDaoFactory().getUserDao().getByMobile(vo.getMobile());
//			if (user != null)
//			{
//				return returnErrorPage(map, dto.getMobile()+"전화번호가 이미 존재합니다 ");
//			}
//
//			dto.setIp(request.getRemoteAddr());
////			ServiceResult<User> result=serviceFactory.getUserService().register(vo,request);
//
//			if(result.getIsSuccess())
//			{
//				return "redirect:/";
//			}else
//			{
//				return returnErrorPage(map, "시스템 점검중입니다...");
//			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return "redirect:/" ;
	}

}

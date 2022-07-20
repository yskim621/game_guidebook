package game.guidebook.service;

import game.guidebook.controller.dto.RegisterDto;
import game.guidebook.domain.User;
import net.nurigo.java_sdk.api.Message;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface UserService {

    public User getById(Long id);

    public boolean existUserName(String userName) throws Exception;

    public boolean existMobile(String mobile) throws Exception;

    public boolean existEmail(String email) throws Exception;

    public Long register(RegisterDto dto);

    public Map<String, Object> login(String name, String password, HttpServletRequest request, HttpServletResponse response);

    public String sendSms(String mobileNo);
}

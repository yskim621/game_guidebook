package game.guidebook.service.impl;

import game.guidebook.common.utils.SessionConst;
import game.guidebook.common.utils.SessionManager;
import game.guidebook.controller.dto.RegisterDto;
import game.guidebook.common.utils.UserUtils;
import game.guidebook.domain.User;
import game.guidebook.domain.enumerate.*;
import game.guidebook.repository.UserRepository;
import game.guidebook.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

//    private final UserRepositoryOld userRepositoryOld;
    private final UserRepository userRepository;
//    private final SessionManager sm;

    @Value("${app.sms.api-key}")
    private String apiKey;

    @Value("${app.sms.api-secret}")
    private String apiSecretKey;

    @Value("${app.sms.send-number}")
    private String managerNumber;

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public boolean existUserName(String name){
        Optional<User> optUser = userRepository
                .findByName(name)
                .stream()
                .findAny();
        return optUser.isPresent();
    }

    @Override
    public boolean existMobile(String mobile) {
        Optional<User> optUser = userRepository
                .findByMobile(mobile)
                .stream()
                .findAny();
        return optUser.isPresent();
    }

    @Override
    public boolean existEmail(String email) {
        Optional<User> optUser = userRepository
                .findByEmail(email)
                .stream()
                .findAny();
        return optUser.isPresent();
    }

    @Override
    public Long register(RegisterDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setMobile(dto.getMobile());
        user.setEmail(dto.getEmail());
        user.setPassword(UserUtils.entryptPassword(dto.getPassword().trim()));
        user.setCreateName(dto.getName());
        user.setCreateTime(new Date());
        user.setResource(UserSource.WEB);
        user.setLoginErrCount(0);
        user.setLoginCount(1);
        user.setLastLoginIp(dto.getIp());
        user.setLastLoginTime(new Date());
        userRepository.saveAndFlush(user);

        // 등록 후 자동 로그인
        //UserUtils.login(user);
        return user.getId();
    }

    @Override
    public Map<String, Object> login(String name, String password, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        Optional<User> optUser = userRepository.findUserByName(name);
        if (optUser.isEmpty()) {
            map.put("result", "NotExistUser");
        } else {
            if (!UserUtils.validatePassword(password, optUser.get().getPassword())) {
                map.put("result", "WrongPassword");
            } else {
//                UserUtils.login(optUser.get());
                //세션 매니저를 통해 세션 생성 및 회원정보 보관
                //세션이 있으면 있는 세션 반환, 없으면 신규 세션 생성
                HttpSession session = request.getSession();
                session.setAttribute(SessionConst.LOGIN_MEMBER, optUser.get());
                map.put("result", "SuccessLogin");
            }
        }
        return map;
    }

    @Override
    public String sendSms(String mobileNo) {
        String code = RandomStringUtils.randomNumeric(6);
        String text = "[C & B guidebook] 인증번호는 [ " + code + " ] 입니다.";
        Message coolsms = new Message(apiKey, apiSecretKey);
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", mobileNo);
        params.put("from", managerNumber.trim()); //사전에 사이트에서 번호를 인증하고 등록하여야 함
        params.put("type", "SMS");
        params.put("text", text); //메시지 내용 params.put("app_version", "test app 1.2");

        try {
            JSONObject obj = (JSONObject) coolsms.send(params);
        } catch (CoolsmsException e) {
            e.printStackTrace();
        }
        return code;
    }
}

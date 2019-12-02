package com.yalogs.rwc.common.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yalogs.rwc.common.RSAED.RSAUtils;
import com.yalogs.rwc.common.service.RSACookieService;
import com.yalogs.rwc.user.entity.User;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class RSACookieServiceImpl implements RSACookieService {

    private static final Logger logger = LoggerFactory.getLogger(RSACookieServiceImpl.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private RSAUtils rsaUtils;

    /**
     * 获取私钥Cookie
     * @return
     */
    @ApiOperation(value = "私钥Cookie")
    @Override
    public Cookie privateKeyCookie() {
       return new Cookie("private_key", rsaUtils.downKey4Redis("private_key"));
    }

    @ApiOperation(value = "公钥Cookie")
    @Override
    public Cookie publicKeyCookie() {
        return new Cookie("public_key", rsaUtils.downKey4Redis("public_key"));
    }


    /**
     * au_token生成公共server
     * @param user
     * @return
     */
    @ApiOperation(value = "根据用户生成token", notes = "注意只能携带用户可见信息，不能携带私密信息")
    @Override
    public String generateToken4User(User user) {
        // Algorithm使用HS256,使用private_key作为secret
        Algorithm algorithm = Algorithm.HMAC256(rsaUtils.downKey4Redis("private_key"));
        // 生成Subject信息
        Map<String, String> subjectMap = new HashMap<>();
        String subject = null;
        try {
            subject = mapper.writeValueAsString(subjectMap.put("id", String.valueOf(user.getId())));
        } catch (JsonProcessingException e) {
            logger.error("token创建时生成用户信息失败，{}", e.getMessage());
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 15);
        Date expire = calendar.getTime();
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("alg", "HS256");
        headerMap.put("type", "JWT");
        return JWT.create().withHeader(headerMap)
                .withIssuer("rwc")
                .withExpiresAt(expire)
                .withSubject(subject)
                .withIssuedAt(new Date())
                .withJWTId(String.valueOf(user.getId())).sign(algorithm);
    }
}

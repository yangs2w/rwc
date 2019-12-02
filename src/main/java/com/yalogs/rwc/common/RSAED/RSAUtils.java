package com.yalogs.rwc.common.RSAED;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

@Component
@ApiModel(value = "秘钥存储和获取", description = "注意，这是一个被Spring容器管理的Component组件，不是一个static修饰的工具类")
public class RSAUtils {

    private static final Logger logger = LoggerFactory.getLogger(RSAUtils.class);

    @Autowired
    private StringRedisTemplate template;

    /**
     * 向redis服务器上传秘钥对
     */
    @ApiOperation(value = "上传密钥对")
    public void upKey2Redis() {
        // 获取到秘钥对
        String privateKey = RSAFactory.getPrivateKey();
        String publicKey = RSAFactory.getPublicKey();
        // 判断一下是否为空，为空则需要生成秘钥对
        if (StringUtils.isBlank(privateKey) || StringUtils.isBlank(publicKey)) {
            try {
                RSAFactory.generatePair();
            } catch (NoSuchAlgorithmException e) {
                logger.error("在上传密钥对时异常，异常信息：{}", e.getMessage());
                return;
            }
        }
        privateKey = RSAFactory.getPrivateKey();
        publicKey = RSAFactory.getPublicKey();
        // 使用template上传密钥对
        template.opsForValue().set("private_key", privateKey);
        template.opsForValue().set("public_key", publicKey);
    }

    /**
     * 从redis上获取密钥对
     * @param keyType
     * @return
     */
    @ApiOperation(value = "根据秘钥类型，获取秘钥", notes = "keyType为private_key和public_key")
    public String downKey4Redis(String keyType) {
        if (StringUtils.isBlank(keyType))
            return null;
        String yue = template.opsForValue().get(keyType);
        if (StringUtils.isBlank(yue)) {
            try {
                RSAFactory.generatePair();
            } catch (NoSuchAlgorithmException e) {
                logger.error("在获取密钥匙时创建密钥对异常，异常信息：{}", e.getMessage());
                return null;
            }
        }
        upKey2Redis();
        return template.opsForValue().get(keyType);
    }

    /**
     * 删除秘钥对
     */
    @ApiOperation(value = "删除密钥对", notes = "只能删除密钥对，不能只删除私钥或者是公钥")
    public void deleteKey4Redis() {
        template.setEnableTransactionSupport(true);
        template.multi();
        template.delete("private_key");
        template.delete("public_key");
        template.exec();
    }


}

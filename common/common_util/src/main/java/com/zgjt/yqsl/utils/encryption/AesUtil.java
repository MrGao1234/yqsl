package com.zgjt.yqsl.utils.encryption;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * @author admin
 */
public class AesUtil {

    /** 加密 AES */
    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(encryptKey.getBytes());
        kgen.init(128,random);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new
                SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        return new
                String(Base64.encodeBase64Chunked(cipher.doFinal(content.getBytes("utf-8"))));
    }

    /** 解密 AES */
    public static String aesDecrypt(String content, String decryptKey) throws Exception {
        byte[] encryptBytes= Base64.decodeBase64(content.getBytes());
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(decryptKey.getBytes());
        kgen.init(128,random);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new
                SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
        return new String(cipher.doFinal(encryptBytes));
    }

    public static void main(String[] args) throws Exception {

        System.out.println(DigestUtils.md5DigestAsHex("123123".getBytes()));

        System.out.println( aesEncrypt("zhangsan", "qsadfsrqwrqdsdfsfsf") );
        System.out.println( aesEncrypt("123123", "qsadfsrqwrqdsdfsfsf") );
    }
}

package com.zgjt.yqsl.utils.jwt;

import com.zgjt.yqsl.entity.PowerUser;
import io.jsonwebtoken.*;

import java.util.Date;

/**
 * @author admin
 */
public class JwtUtil {

    private static final String SUBJECT = "guli-user";
    //秘钥
    private static final String APP_SECRET = "79e7c69681b8270162386e6daa53d1dc";
    //过期时间，毫秒，30分钟
    private static final long EXPIRE = 1000 * 60 * 30;

    /**
     * 生成Jwt令牌
     * @return
     */
    public static String generateJwt(PowerUser user){
        String token = Jwts.builder()
                //令牌类型
                .setHeaderParam("typ", "JWT")
                //签名算法
                .setHeaderParam("alg", "HS256")
                //令牌主题
                .setSubject(SUBJECT)
                //签发时间
                .setIssuedAt(new Date())
                //过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("id", user.getId())
                .claim("account", user.getAccount())
                .claim("avatar", user.getAvatar())
                .signWith(SignatureAlgorithm.HS256, APP_SECRET).compact();
        return token;
    }

    /**
     * 校验jwt
     * @param jwtToken
     * @return
     */
    public static Claims checkJwt(String jwtToken){
        Claims claims;
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
            claims = claimsJws.getBody();
        } catch( ExpiredJwtException e) {
            claims = e.getClaims();
        }
        return claims;
    }
}

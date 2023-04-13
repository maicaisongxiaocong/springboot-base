package com.hebut.base.config.auth;

/**
 * @program: base
 * @description: token生成类
 * @author: cxc
 * @create: 2023-04-13 09:58
 **/

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
* @Description: token生成工具类
* @Author: cxc
* @Date: 2023/4/13
* @Time: 20:52
*/
@Component
public class TokenUtil {

    //静态变量的从配置文件加载，类上面加@Component
    //用set函数
    //set函数加@Value
    public static  long EXPIRE_TIME;//token到期时间5分钟，毫秒为单位

    public static  long REFRESH_EXPIRE_TIME; //RefreshToken到期时间为30分钟，秒为单位

    private static  String TOKEN_SECRET;  //密钥盐
    @Value("${jwt.expire-time}")
    public void setExpireTime(long expireTime) {
        EXPIRE_TIME = expireTime;
    }

    @Value("${jwt.refresh-expire-time}")
    public void setRefreshExpireTime(long refreshExpireTime) {
        REFRESH_EXPIRE_TIME = refreshExpireTime;
    }

    @Value("${jwt.token-secret}")
    public void setTokenSecret(String tokenSecret) {
        TOKEN_SECRET = tokenSecret;
    }

    /**
     * @Description  ：生成token
     * @author       : cxc
     * @param        : [user]
     * @return       : java.lang.String
     * @exception    :
     */
    public static String sign(String account,Long currentTime){

        String token=null;
        try {
            Date expireAt=new Date(currentTime+EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")//发行人
                    .withClaim("account",account)//存放数据
                    .withClaim("currentTime",currentTime)
                    .withExpiresAt(expireAt)//过期时间
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (IllegalArgumentException | JWTCreationException je) {

        }
        return token;
    }


    /**
     * @Description  ：token验证
     * @author       : cxc
     * @param        : [token]
     * @return       : java.lang.Boolean
     * @exception    :
     */
    public static Boolean verify(String token) throws Exception{

        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();//创建token验证器
        DecodedJWT decodedJWT=jwtVerifier.verify(token);
        System.out.println("认证通过：");
        System.out.println("account: " + decodedJWT.getClaim("account").asString());
        System.out.println("过期时间：      " + decodedJWT.getExpiresAt());
        return true;
    }



    public static String getAccount(String token){
        try{
            DecodedJWT decodedJWT=JWT.decode(token);
            return decodedJWT.getClaim("account").asString();

        }catch (JWTCreationException e){
            return null;
        }
    }
    public static Long getCurrentTime(String token){
        try{
            DecodedJWT decodedJWT=JWT.decode(token);
            return decodedJWT.getClaim("currentTime").asLong();

        }catch (JWTCreationException e){
            return null;
        }
    }

}
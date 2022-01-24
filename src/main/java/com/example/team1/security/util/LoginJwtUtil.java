package com.example.team1.security.util;

import com.example.team1.constant.JwtConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginJwtUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginJwtUtil.class);

    public static String getSubjectFromJwt(String token) {
        try {
            String subject = Jwts.parser().setSigningKey(JwtConstant.JWT_SIGNING_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            return subject;
        } catch(SignatureException e) {
            LOGGER.warn("Invalid Jwt Signature");
            return null;
        } catch(ExpiredJwtException e) {
            LOGGER.warn("Expired Jwt");
            return null;
        } catch(Exception e) {
            LOGGER.warn("Exception Parsing Jwt");
            return null;
        }
    }


    public static Claims getClaimsFromJwt(String token){
        try {
            Claims claims = Jwts.parser().setSigningKey(JwtConstant.JWT_SIGNING_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            return claims;
        } catch (SignatureException e){
            LOGGER.warn("Invalid Jwt Signature");
            return null;
        } catch (ExpiredJwtException e){
            LOGGER.warn("Expired Jwt");
            return null;
        } catch (Exception e){
            LOGGER.warn("Exception Parsing Jwt");
            return null;
        }
    }
}

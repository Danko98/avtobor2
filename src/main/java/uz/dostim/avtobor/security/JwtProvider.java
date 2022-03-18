package uz.dostim.avtobor.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.xml.crypto.Data;
import java.util.Date;


public class JwtProvider {

    static long expireTime = 36_000_000;
    static String maxfiysoz = "mahfiySozHechkimgaAytmangKorsangizHamKormaslikkaOling";
     public static String generateToken(String username) {
         Date expireDate = new Date(System.currentTimeMillis() + expireTime);
         String token = Jwts
                 .builder()
                 .setSubject(username)
                 .setIssuedAt(new Date())
                 .setExpiration(expireDate)
                 .signWith(SignatureAlgorithm.HS512, maxfiysoz)
                 .compact();
         return token;
     }

    public static void main(String[] args) {
        String token = generateToken("userLogini");
        System.out.println("****");
        System.out.println(token);
    }
}

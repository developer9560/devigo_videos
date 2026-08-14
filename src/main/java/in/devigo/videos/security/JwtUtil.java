package in.devigo.videos.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtUtil {
        private final String SECRETE_KEY="ABCDOILKADSKAHEWOIEKLSLKSKGSDJSDADPOPOHSDADA";
        private final long EXPIRATION_TIME = 1000*60*60*24;//24 hourse
        private  final Long USER_EXPIRATION_TIME = 1000*60*60*24*30L; // one mongth;


        public String generateToken(Long userId, String role){
            return  Jwts.builder()
                    .setSubject(userId.toString())
                    .claim("role",role)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS256 ,SECRETE_KEY)
                    .compact();
        }

        public String generateTokenForUser(Long userId, String role){
            return  Jwts.builder()
                    .setSubject(userId.toString())
                    .claim("role",role)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis()+USER_EXPIRATION_TIME))
                    .signWith(SignatureAlgorithm.HS256 ,SECRETE_KEY)
                    .compact();
        }

        public Long extractUserId(String token){
            return Long.parseLong(Jwts.parser()
                    .setSigningKey(SECRETE_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject()

            );
        }

        public String extractRole(String token){
            return Jwts.parser()
                    .setSigningKey(SECRETE_KEY)
                    .parseClaimsJws(token)
                    .getBody()
                    .get("role",String.class);
        }

        public boolean isTokenValid(String token){
            try{
                Jwts.parser().setSigningKey(SECRETE_KEY).parseClaimsJws(token);
                return true;
            }catch (Exception e){
                return false;
            }
        }

}



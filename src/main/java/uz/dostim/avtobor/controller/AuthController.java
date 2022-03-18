package uz.dostim.avtobor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.dostim.avtobor.dto.LoginDto;
import uz.dostim.avtobor.service.auth.MyAuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    MyAuthService myAuthService;

    @PostMapping("/login")
    public HttpEntity<?> loginToSystem(@RequestBody LoginDto loginDto) {
        UserDetails userDetails = myAuthService.loadUserByUsername(loginDto.getUsername());
        return ResponseEntity.ok("ok");
    }
}

package com.example.webfastfood.controller;




import com.example.webfastfood.entity.JwtResponse;
import com.example.webfastfood.jwt_token.JwtUtils;

import com.example.webfastfood.jwt_token.LoginRequest;
import com.example.webfastfood.repository.AccountRepository;
import com.example.webfastfood.service.AccountService;
import com.example.webfastfood.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AccountService accountService;


    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    AccountRepository accountRepository;


    // UsernamePasswordAuthenticationToken {tên người dùng, mật khẩu} từ Yêu cầu đăng nhập,
    //và AuthenticationManager sẽ sử dụng nó để xác thực tài khoản đăng nhập.
    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser( @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        accountRepository.changeStatus(1,userDetails.getAccountId());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getAccountId(),
                userDetails.getUsername(),
                userDetails.getUserTime(),
                userDetails.getEmployee(),
                roles));
    }

    @PatchMapping("singout/{employeeId}")
    public ResponseEntity<Void> logout(@PathVariable(name = "employeeId") Long employeeId) {
        accountRepository.changeStatus(0,employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

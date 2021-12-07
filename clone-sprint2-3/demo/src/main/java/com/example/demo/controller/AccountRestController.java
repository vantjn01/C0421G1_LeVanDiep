package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping
public class AccountRestController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/account/setPass")
    public ResponseEntity<Void> setNewPassword(@RequestParam String username,
                                               @RequestParam String newPassword) {
        Optional<Account> account = accountService.findByUserNames(username);
        if (account.isPresent()) {
            accountService.changePassWord( newPassword,account.get().getAccountRoleId());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/account/{username}")
    public ResponseEntity<Optional<Account>> getAccountByUserName(@PathVariable(name = "username") String username) {
        Optional<Account> account = accountService.findByUserNames(username);
        if (account.isPresent()){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

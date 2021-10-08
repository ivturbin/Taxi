package ru.digitalleague.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.digitalleague.core.api.UserService;
import ru.digitalleague.core.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;

@Slf4j
@RestController
public class SecurityController {
    @Autowired
    private final UserService userService;

    public SecurityController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public User login(@RequestParam String login){
        return userService.login(login);
    }

    @PostMapping("/registration")
    public User register(@RequestBody User userAccount){
        return userService.registration(userAccount);
    }

    @GetMapping("/auth")
    public String auth(Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "auth " + principal.getName();
    }
    @GetMapping("/checkstats")
    public String check(){
        return "everything is mkay!";
    }

    @RequestMapping(value = "/view-flop-pic", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<Resource> getImageAsResource() throws IOException {
        final ByteArrayResource byteArrayResource = new ByteArrayResource(
                Files.readAllBytes(
                        Paths.get("core/src/main/resources/img/flop.png")));
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(byteArrayResource.contentLength())
                .body(byteArrayResource);
    }
}

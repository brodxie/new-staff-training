package com.github.xieyu.ssmdemo.web.controller;

import com.github.xieyu.ssmdemo.web.dao.UserDAO;
import com.github.xieyu.ssmdemo.web.domain.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xieyu
 */
@Controller
public class DemoController {
    @Autowired
    private UserDAO userDAO;

    @GetMapping("/hello")
    public ResponseEntity<?> getHello() {
        APIResponse response = new APIResponse();
        response.setCode("OK");
        response.setMessage("成功");
        response.setBody("hello");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user")
    public ResponseEntity<?> listUser() {
        APIResponse response = new APIResponse();
        response.setCode("OK");
        response.setMessage("成功");
        response.setBody(userDAO.listAll());
        return ResponseEntity.ok(response);
    }
}

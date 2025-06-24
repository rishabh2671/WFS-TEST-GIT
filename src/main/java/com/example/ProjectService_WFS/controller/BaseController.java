package com.example.ProjectService_WFS.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BaseController {
    @RequestMapping("/")
    public String Home()
    {
        return "Home Page........";
    }
}

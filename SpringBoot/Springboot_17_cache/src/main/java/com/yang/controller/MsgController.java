package com.yang.controller;

import com.yang.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yang
 * @Date 2022/7/27
 */
@RestController
@RequestMapping("/msg")
public class MsgController {
    @Autowired
    private MsgService msgService;

    @GetMapping("{tele}")
    public String get(@PathVariable String tele){
        return msgService.get(tele);
    }

    @PostMapping
    public Boolean check(String tele,String code){
        return msgService.check(tele,code);
    }


}

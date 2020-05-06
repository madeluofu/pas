package com.zifeng.pas.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zifeng.pas.exception.CustomException;

@RestController
public class ExcepionTestController {
	@GetMapping("/test3")
    public String test3(Integer num) {
        if (num == null) {
            throw new CustomException(400, "num不能为空");
        }
        
        int i = 10 / num;
        return "result:" + i;
    }
}

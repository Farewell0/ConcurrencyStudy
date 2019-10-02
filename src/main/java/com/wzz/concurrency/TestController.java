package com.wzz.concurrency;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TestController
 *
 * @author wzzfarewell
 * @date 2019/9/30
 **/
@Controller
public class TestController {

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        return "test";
    }
}

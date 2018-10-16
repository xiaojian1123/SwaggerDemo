package com.xiaojian.swaggerdemo.swaggerdemo.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: xiaojian
 * @Date: 2018/9/7 16:05
 * @Description:
 */
@RestController
@RequestMapping("/api")
@Api(description = "用户接口测试")
public class testController {

    @ApiOperation("测试方法")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "hello world";
    }

    @ApiOperation("获取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="header",name="username",dataType="String",required=true,value="用户的姓名",defaultValue="zhaojigang"),
            @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户的密码",defaultValue="wangna")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value="/getUser",method=RequestMethod.POST)
    public Object getUser(@RequestHeader("username") String username, @RequestParam("password") String password){
        System.out.println("username = "+ username +", password = "+password);
        return "{'code:200','result:true'}";
    }
}


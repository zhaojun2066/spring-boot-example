package com.jufeng.springboot.example045;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @program: spring-boot-example
 * @description:
 * @author: JuFeng(ZhaoJun)
 * @create: 2019-10-16 14:36
 **/

@Api(tags = "Hello 测试api",description = "测试Swagger2 api")
@RestController
@RequestMapping("hello")
public class HelloController {


    @ApiOperation("hello 接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "姓名",required = true,paramType = "path"),
            @ApiImplicitParam(name = "age",value = "年龄",required = true,paramType = "path")
    })
    @GetMapping("/{name}")
    public User getUser(@PathVariable("name") String name,@RequestParam(name = "age") Integer age){
        User user = new User();
        user.setAge(age);
        user.setName(name);
        return user;
    }

    // 屏蔽接口不出现文档内
    @ApiIgnore
    public int getAge(){
        return 10;
    }
}

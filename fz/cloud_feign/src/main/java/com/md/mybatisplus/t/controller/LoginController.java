package com.md.mybatisplus.t.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.service.IService;
import com.md.mybatisplus.t.Utils.AutoIdempotent;
import com.md.mybatisplus.t.Utils.R;
import com.md.mybatisplus.t.entity.LocalTest;
import com.md.mybatisplus.t.service.LocalTestService;
import com.md.mybatisplus.t.service.impl.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import org.apache.http.HttpRequest;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 登录注册相关的
 */
@RestController
@RequestMapping("/c")
@Api(value = "/api", tags = {"登录注册相关"}, description = "登录注册相关接口")
public class LoginController {
    @Autowired
    LocalTestService localTestService;

//    @Autowired
//    RedisTemplate redisTemplate;

    @Autowired
    TokenService tokenService;


    /**
     * https://blog.csdn.net/tsundere_x/article/details/104196411
     *这里用Spring Security加密
     *注册
     *
     * 数据库里的加密后的值不同,实际上都是相同的
     *
     * 每次的盐不一样
     * 然后生成的hash也不一样
     *
     * 2 表单重复提交  需要redis机器
     */
    @ApiOperation(value = "单个新增 加密注册", notes = "新增add 注册")
    @AutoIdempotent
    @PostMapping(value = "/add")
    @ApiImplicitParam(name = "token", value = "token", required = false, dataType = "String",paramType="header")
    public R add(@RequestBody LocalTest localTest, HttpRequest r) {

        //  r.getHeaders()
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String encode = encoder.encode(localTest.getName());
        System.out.println(encoder.matches("string",encode));  ;
        localTest.setName(encode );
        localTestService.save(localTest);
        return R.OK(true);
    }


    /**
     * 批量新增（注册）
     */
    @ApiOperation(value = "批量新增（注册）   或修改", notes = "批量新增（注册） 增加 add")

    @PostMapping(value = "/addlist")
    public R addlisttt(@RequestBody  List< LocalTest> entityList) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        for(int i=0;i<entityList.size();i++){
            LocalTest listName=entityList.get(i);
            String  getname=listName.getName();
            String encode = encoder.encode(getname);
            listName.setName(encode);
        }

        localTestService.saveBatch(entityList);
        return R.OK(true);
    }



    @ApiOperation(value = "获取token", notes = "")
    @GetMapping(value = "/getToken")
    public R getToken(){
        String token=tokenService.createToken();
        return R.ok1().data("token",token);
    }


    @ApiOperation(value = "登录接口", notes = "")
    @GetMapping(value = "/login")
   // @ApiImplicitParam(name = "token", value = "token", required = false, dataType = "String",paramType="header")
    public Object login(@RequestBody LocalTest localTest,String sessionToken) {

        String name=localTest.getName();
        String password=localTest.getPassword();
        //QueryWrapper<localTest> w= Wrapper.
        //Wrapper<T> w=new Wrapper<T>();
        QueryWrapper<LocalTest> wrapper = Wrappers.query();
        LocalTest locallogin =localTestService.getOne(wrapper);
        if(!locallogin.equals("null")){
           //加载主页面数据
            System.out.println("登录了");
        }else{
            System.out.println("账号或密码错误");
        }

        return "login";
    }



    /**
     * BeanUtils.copyProperties();  减少重复get/set
     */
    @ApiOperation(value = "减少大量get/set", notes = "")
    @GetMapping(value = "/date")
    public R date() {
        return R.OK(222);
    }



//    @ApiOperation(value = "查询所有  暂没有分页  暂没有redis", notes = "")
//    @GetMapping(value = "/goMybatisp")
//    public R goMybatisp() {
//        ValueOperations<String, String> operations = redisTemplate.opsForValue();
//        operations.set("12313", "sff");
//       // operations.ex
//        //获取缓存数据
//       // List<LocalTest> all = localTestService.getAll();
//        List<LocalTest> all =  localTestService.list();
//        return R.OK(all);
//    }



    /**修改密码
     *用户名填写正确
     * 前端传过来的密码Spring Security加密 如果和数据库里的一样就让登录
     */












    /**
     * 删除
     */
    @ApiOperation(value = "根据多个字段删除和单个删除", notes = "批量删除 和 单个删除    delete")
     @PostMapping(value = "/delete")
   // @GetMapping(value = "/delete") @RequestBody
    public R delete( Map<String, Object> map)
    {

        //批量删除 多条件
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.equals(map);
       // wrapper.eq("id",map.get("id"));
      //  wrapper.eq("name",map.get("name"));
        localTestService.remove(wrapper);
        return R.OK(null);
    }






    /**
     * 远程执行liunx脚本命令
     */

//    @ApiOperation(value = "远程执行liunx脚本命令", notes = "远程执行liunx脚本命令")
//    @PostMapping(value = "/远程执行liunx脚本命令")
//    public R remoteScript( )
//    {
//
//
//    }





    /**
     *
     * 关联混合查询
     */
}


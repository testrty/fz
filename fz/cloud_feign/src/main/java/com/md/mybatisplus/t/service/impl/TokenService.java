package com.md.mybatisplus.t.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.md.mybatisplus.t.Utils.BaseException;
import com.md.mybatisplus.t.Utils.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


@Service
public class TokenService {
    @Autowired
    RedisService redisService;

    //生成token
    public String createToken() {
        UUID uuid = UUID.randomUUID();
        String token = uuid.toString();
        System.out.println(token+"生成了token");
        boolean b = redisService.setEx(token, token, 10000L);
        return token;
    }

    // 验证token
    public Boolean checktoen(HttpServletRequest request) {

        System.out.println("来了。。。。。。。。。。。。。");
        String token = request.getHeader("token");
        System.out.println(token+"token.,............");
        if (StringUtils.isBlank(token)) { //如果head中不存在token
            token = request.getParameter("token");//从参数中拿
            {
                throw new BaseException(20001, "缺少参数token");
            }
        }

        //判断缓存中是否存在
        if (!redisService.exists(token)) {
            System.out.println("重复提交token");;
            throw new BaseException(20001, "不能重复提交-------token不正确、空");
        }

        //token正确 移除token
        if(!redisService.remove(token)){
            System.out.println("移除token 中");;
            throw new BaseException(20001, "token移除失败");
        }

        return true;

    }

}

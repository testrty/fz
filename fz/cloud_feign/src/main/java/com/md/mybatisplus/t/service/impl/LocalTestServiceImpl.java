package com.md.mybatisplus.t.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.md.mybatisplus.t.entity.LocalTest;
import com.md.mybatisplus.t.mapper.LocalTestMapper;
import com.md.mybatisplus.t.service.LocalTestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author md
 * @since 2021-04-04
 */
@Service
public class LocalTestServiceImpl  extends ServiceImpl<LocalTestMapper, LocalTest> implements LocalTestService {



}

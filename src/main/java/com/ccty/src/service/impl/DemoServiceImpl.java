package com.ccty.src.service.impl;

import com.ccty.src.aop.aspect.target.NoahService;
import com.ccty.src.domain.convertor.DemoConvertor;
import com.ccty.src.mapper.DemoMapper;
import com.ccty.src.domain.dto.DemoDTO;
import com.ccty.src.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 缄默
 * @date 2019/12/14
 */
@NoahService
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Autowired
    private DemoConvertor demoConvertor;

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    @Override
    public DemoDTO queryUserInfoById(int id) {
        return demoConvertor.demoDOToDemoDTO(demoMapper.queryUserInfoById(id));
    }
}

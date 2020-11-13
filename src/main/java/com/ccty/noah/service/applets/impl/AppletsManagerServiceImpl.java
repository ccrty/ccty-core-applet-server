package com.ccty.noah.service.applets.impl;

import com.ccty.noah.aop.target.NoahService;
import com.ccty.noah.mapper.applets.AppletsManagerMapper;
import com.ccty.noah.service.applets.AppletsManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/10/22
 */
@NoahService
@Slf4j
public class AppletsManagerServiceImpl implements AppletsManagerService {

    @Autowired
    private AppletsManagerMapper appletsManagerMapper;

    @Override
    public List<String> getCarouselList(Integer type) {
        return appletsManagerMapper.queryCarouselListByType(type);
    }
}

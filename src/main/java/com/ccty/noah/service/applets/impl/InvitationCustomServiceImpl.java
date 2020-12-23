package com.ccty.noah.service.applets.impl;

import com.ccty.noah.aop.target.NoahService;
import com.ccty.noah.domain.convertor.DataDictConvertor;
import com.ccty.noah.domain.dto.DataDictDTO;
import com.ccty.noah.domain.dto.PageDTO;
import com.ccty.noah.mapper.applets.InvitationCustomMapper;
import com.ccty.noah.service.applets.InvitationCustomService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ryan
 * @date 2020/12/23
 */

@NoahService
@Slf4j
public class InvitationCustomServiceImpl implements InvitationCustomService {

    @Autowired
    private InvitationCustomMapper invitationCustomMapper;

    @Autowired
    private DataDictConvertor dataDictConvertor;

    @Override
    public PageInfo<DataDictDTO> findAllInvitationType(PageDTO condition) {
        Page page = PageHelper.startPage(condition.getPageNum() ,condition.getPageSize() );
        PageInfo pageInfo = new PageInfo<>(page.getResult());
        List<DataDictDTO> dataDictDTOS = dataDictConvertor.DOListToDTO(invitationCustomMapper.findAllInvitationType());
        pageInfo.setList(dataDictDTOS);
        return  pageInfo;
    }
}

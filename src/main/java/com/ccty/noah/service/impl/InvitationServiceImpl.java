package com.ccty.noah.service.impl;

import com.ccty.noah.aop.target.NoahService;
import com.ccty.noah.domain.convertor.DataDictConvertor;
import com.ccty.noah.domain.dto.DataDictDTO;
import com.ccty.noah.domain.dto.PageDTO;
import com.ccty.noah.mapper.InvitationMapper;
import com.ccty.noah.service.InvitationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author ryan
 */
@NoahService
@Slf4j
public class InvitationServiceImpl implements InvitationService{

    @Autowired
    private InvitationMapper invitationMapper;

    @Autowired
    private DataDictConvertor dataDictConvertor;

    @Override
    public PageInfo<DataDictDTO> findAllInvitationType(PageDTO condition) {
        Page page = PageHelper.startPage(condition.getPageNum() ,condition.getPageSize() );
        PageInfo pageInfo = new PageInfo<>(page.getResult());
        List<DataDictDTO> dataDictDTOS = dataDictConvertor.DOListToDTO(invitationMapper.findAllInvitationType());
        pageInfo.setList(dataDictDTOS);
        return  pageInfo;
    }

    @Override
    public void doDeleteInvitationType(Long id) {
        invitationMapper.deleteInvitationType(id);
    }

    @Override
    public void doInsertInvitationType(String dataDictValue) {
        invitationMapper.doInsertInvitationType(dataDictValue);
    }

}

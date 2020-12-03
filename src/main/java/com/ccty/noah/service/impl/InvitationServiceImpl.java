package com.ccty.noah.service.impl;

import com.ccty.noah.aop.target.NoahService;
import com.ccty.noah.domain.convertor.DataDictConvertor;
import com.ccty.noah.domain.dto.DataDictDTO;
import com.ccty.noah.mapper.InvitationMapper;
import com.ccty.noah.service.InvitationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@NoahService
@Slf4j
public class InvitationServiceImpl implements InvitationService{

    @Autowired
    private InvitationMapper invitationMapper;

    @Autowired
    private DataDictConvertor dataDictConvertor;

    @Override
    public List<DataDictDTO> findAllInvitationType() {
        System.out.println(invitationMapper.findAllInvitationType());
        return  dataDictConvertor.DOListToDTO(invitationMapper.findAllInvitationType());
    }

}

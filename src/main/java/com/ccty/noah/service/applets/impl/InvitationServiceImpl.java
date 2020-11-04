package com.ccty.noah.service.applets.impl;

import com.ccty.noah.aop.target.NoahService;
import com.ccty.noah.domain.convertor.applets.InvitationConvertor;
import com.ccty.noah.domain.dto.applets.InvitationDTO;
import com.ccty.noah.mapper.applets.InvitationMapper;
import com.ccty.noah.service.applets.InvitationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@NoahService
@Slf4j
public class InvitationServiceImpl implements InvitationService{

    @Autowired
    private InvitationMapper invitationMapper;

    @Autowired
    private InvitationConvertor invitationConvertor;

    @Override
    public void doInsertInvitation(InvitationDTO invitationDTO) {
        invitationMapper.insertInvitation(invitationConvertor.DTOToDO(invitationDTO));
    }
}

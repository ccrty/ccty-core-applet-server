package com.ccty.noah.service.applets;

import com.ccty.noah.domain.dto.applets.InvitationDTO;

/**
 * @author ryan
 * @date 2020/11/3
 */
public interface InvitationService {

    /**
     * 新增帖子
     * @param invitationDTO
     */
    void doInsertInvitation(InvitationDTO invitationDTO);
}

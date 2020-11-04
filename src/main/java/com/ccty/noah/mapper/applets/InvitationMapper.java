package com.ccty.noah.mapper.applets;

import com.ccty.noah.domain.database.applets.InvitationDO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author ryan
 * @date 2020/11/3
 */
@Mapper
@Component
public interface InvitationMapper {

    /**
     * 发布帖子
     * @param invitationDO
     */
    void insertInvitation(InvitationDO invitationDO);
}

package com.ccty.noah.domain.convertor.applets;

import com.ccty.noah.domain.database.applets.InvitationDO;
import com.ccty.noah.domain.dto.applets.InvitationDTO;
import com.ccty.noah.util.EntityFactory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = EntityFactory.class)
public interface InvitationConvertor {

    /**
     * DTO转DO
     * @param invitationDTO
     * @return
     */
    InvitationDO DTOToDO(InvitationDTO invitationDTO);
}

package com.ccty.noah.domain.convertor.applets;

import com.ccty.noah.domain.database.UserDO;
import com.ccty.noah.domain.dto.applets.WXUserLoginDTO;
import com.ccty.noah.util.EntityFactory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author 缄默
 * @date   2020/09/21
 */
@Mapper(componentModel = "spring", uses = EntityFactory.class)
public interface WXLoginConvertor {

    /**
     * dto转换do
     * @param user
     * @return
     */
    @Mappings({
            @Mapping(source="gender", target="sex"),
            @Mapping(source="province", target="area"),
            @Mapping(source="avatarUrl", target="picture"),
            @Mapping(source="nickName", target="nickname")
    })
    UserDO WXLoginDTOToUserDO(WXUserLoginDTO user);
}

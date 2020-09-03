package com.ccty.noah.domain.convertor;

import com.ccty.noah.domain.database.UserDO;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.util.EntityFactory;
import org.mapstruct.Mapper;

/**
 * @author 缄默
 * @date 2019/10/14
 */
@Mapper(componentModel = "spring", uses = EntityFactory.class)
public interface UserConvertor {

    /**
     * DO对象转换DTO对象
     * @param userDO
     * @return
     */
    UserDTO userDOToUserDTO(UserDO userDO);

}

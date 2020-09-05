package com.ccty.noah.domain.convertor;

import com.ccty.noah.domain.database.UserDO;
import com.ccty.noah.domain.database.UserListConditionDO;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.domain.dto.UserListConditionDTO;
import com.ccty.noah.util.EntityFactory;
import org.mapstruct.Mapper;

import java.util.List;

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

    /**
     * 条件DTO对象转换DO对象
     * @param condition
     * @return
     */
    UserListConditionDO conditionDTOToDO(UserListConditionDTO condition);

    /**
     * listDO转换DTO
     * @param userDOList
     * @return
     */
    List<UserDTO> userDOListToDTO(List<UserDO> userDOList);

}

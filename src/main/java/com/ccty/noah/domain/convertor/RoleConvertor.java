package com.ccty.noah.domain.convertor;

import com.ccty.noah.domain.database.RoleDO;
import com.ccty.noah.domain.dto.RoleDTO;
import com.ccty.noah.util.EntityFactory;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author  ryan
 * @date 2020/09/16
 */
@Mapper(componentModel = "spring", uses = EntityFactory.class)
public interface RoleConvertor {

    /**
     * DO对象转换DTO对象
     * @param roleDTO
     * @return
     */
    RoleDO roleDOToRoleDTO(RoleDTO roleDTO);

    /**
     * DO集合转DTO集合
     * @param roleList
     * @return
     */
    List<RoleDTO> roleDOListToDTO(List<RoleDO> roleList);
}

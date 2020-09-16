package com.ccty.noah.mapper;

import com.ccty.noah.domain.database.RoleDO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author ryan
 * @date   2020/09/16
 */
@Mapper
@Component
public interface RoleMapper {

    /**
     * 根据角色获取信息
     * @param name
     * @return
     */
    Integer queryInfoByRoleName(String name);


    /**
     * 新增角色
     * @param roleDO
     */
    void  insertRole(RoleDO roleDO);

}

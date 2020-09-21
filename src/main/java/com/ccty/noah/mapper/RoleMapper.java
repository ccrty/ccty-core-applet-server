package com.ccty.noah.mapper;

import com.ccty.noah.domain.database.RoleDO;
import com.ccty.noah.domain.dto.RoleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author Ryan & 缄默
 * @date   2020/09/21
 */
@Component
@Mapper
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
    void insertRole(RoleDO roleDO);

    /**
     * 根据条件查询角色列表
     * @param name
     * @return
     */
    List<RoleDO> queryRoleListByCondition(String name);

    /**
     * 删除角色
     * @param id
     */
    void deleteRole(Integer id);

    /**
     * 修改角色
     * @param role
     */
    void updateRole(RoleDO role);
}

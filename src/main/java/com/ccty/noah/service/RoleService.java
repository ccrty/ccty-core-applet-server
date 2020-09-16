package com.ccty.noah.service;


import com.ccty.noah.domain.dto.RoleDTO;

/**
 * @author ryan
 * @date   2020/09/15
 */
public interface RoleService {
    /**
     * 校验角色名是否存在
     * @param name
     * @return
     */
    Boolean validRoleName(String name);

    /**
     * 新增角色
     * @param roleDTO
     * @return
     */
    void doInsertRole(RoleDTO roleDTO);
}

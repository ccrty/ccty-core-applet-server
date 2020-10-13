package com.ccty.noah.mapper;

import com.ccty.noah.domain.database.RoleDO;
import com.ccty.noah.domain.database.RoleResourcesDO;
import com.ccty.noah.domain.dto.RoleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    List<RoleDO> queryRoleListByCondition(@Param("name") String name);

    /**
     * 删除角色
     * @param id
     */
    void deleteRole(Long id);

    /**
     * 修改角色
     * @param role
     */
    void updateRole(RoleDO role);

    /**
     * 获取所有角色名称
     * @return
     */
    List<RoleDO> queryAllRoleName();

    /**
     * 根据角色id删除角色资源数据
     * @param roleId
     */
    void deleteRoleResources(Long roleId);

    /**
     * 插入角色资源数据
     * @param roleId
     * @param list
     */
    void insertRoleResources(@Param("roleId")Long roleId,@Param("list") List<Long> list);

    /**
     * 根据角色id获取资源id集合
     * @param roleId
     * @return
     */
    List<RoleResourcesDO> queryResourcesIdsByRoleId(Long roleId);
}

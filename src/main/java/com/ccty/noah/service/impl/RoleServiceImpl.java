package com.ccty.noah.service.impl;

import com.ccty.noah.aop.exception.NoahException;
import com.ccty.noah.aop.target.NoahService;
import com.ccty.noah.domain.constance.ExceptionEnum;
import com.ccty.noah.domain.convertor.RoleConvertor;
import com.ccty.noah.domain.database.RoleDO;
import com.ccty.noah.domain.database.UserDO;
import com.ccty.noah.domain.database.UserListConditionDO;
import com.ccty.noah.domain.dto.RoleDTO;
import com.ccty.noah.domain.dto.RoleListConditionDTO;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.mapper.RoleMapper;
import com.ccty.noah.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * @author ryan & 缄默
 * @date   2020/09/15
 */
@NoahService
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleConvertor roleConvertor;


    /**
     * 判断角色名是否重复
     * @param name 角色名
     * @return
     */
    @Override
    public Boolean validRoleName(String name) {
        Optional.ofNullable(
                roleMapper.queryInfoByRoleName(name)).orElseThrow(
                () -> new NoahException(ExceptionEnum.ROLE_NAME_ERROR.getCode(),
                        ExceptionEnum.ROLE_NAME_ERROR.getName()));
        return Boolean.TRUE;
    }

    /**
     * 新增角色
     * @param roleDTO 角色
     */
    @Override
    public void doInsertRole(RoleDTO roleDTO) {
        RoleDO roleDO = roleConvertor.roleDOToRoleDTO(roleDTO);
        roleMapper.insertRole(roleDO);
    }

    /**
     * 根据条件获取角色列表
     * @param condition
     * @return
     */
    @Override
    public PageInfo<RoleDTO> getRoleListByCondition(RoleListConditionDTO condition) {
        Page page = PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        List<RoleDO> roleList = roleMapper.queryRoleListByCondition(condition.getName());
        PageInfo pageInfo = new PageInfo<>(page.getResult());
        List<RoleDTO> roleDTOS = roleConvertor.roleDOListToDTO(roleList);
        pageInfo.setList(roleDTOS);
        return pageInfo;
    }

    /**
     * 删除角色
     * @param id
     */
    @Override
    public void doDeleteRole(Integer id) {
        roleMapper.deleteRole(id);
    }

    /**
     * 修改角色
     * @param role
     */
    @Override
    public void doUpdateRole(RoleDTO role) {
        RoleDO roleDO = roleConvertor.roleDOToRoleDTO(role);
        roleMapper.updateRole(roleDO);
    }


}

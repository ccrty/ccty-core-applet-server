package com.ccty.noah.service.impl;

import com.ccty.noah.aop.aspect.exception.NoahException;
import com.ccty.noah.aop.aspect.target.NoahService;
import com.ccty.noah.domain.constance.ExceptionEnum;
import com.ccty.noah.domain.constance.UserConst;
import com.ccty.noah.domain.convertor.RoleConvertor;
import com.ccty.noah.domain.database.RoleDO;
import com.ccty.noah.domain.database.UserDO;
import com.ccty.noah.domain.dto.CodeDTO;
import com.ccty.noah.domain.dto.RoleDTO;
import com.ccty.noah.mapper.RoleMapper;
import com.ccty.noah.service.RoleService;
import com.ccty.noah.util.AliyunSmsUtils;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Optional;

@NoahService
@Slf4j
public class RoleServiceImpl implements RoleService {

    private static Map<String, CodeDTO> codeCache = Maps.newConcurrentMap();

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleConvertor roleConvertor;


    /**
     *  判断角色名是否重复
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


}

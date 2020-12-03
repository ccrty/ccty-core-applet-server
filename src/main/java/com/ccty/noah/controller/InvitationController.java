package com.ccty.noah.controller;

import com.ccty.noah.aop.target.NoahController;
import com.ccty.noah.domain.dto.DataDictDTO;
import com.ccty.noah.service.InvitationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author ryan
 * @date 2020/11/13
 */
@Api("帖子控制器")
@Controller
@NoahController
@Slf4j
@RequestMapping("/{version}/api/invitation/invitationType")
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @ApiOperation(value = "查看帖子类目")
    @GetMapping(value = "/typeList")
    public List<DataDictDTO> findAllInvitationType(){
        return invitationService.findAllInvitationType();
    }
}

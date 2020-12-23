package com.ccty.noah.controller.applets;

import com.ccty.noah.aop.NoahResult;
import com.ccty.noah.aop.target.NoahController;
import com.ccty.noah.domain.dto.DataDictDTO;
import com.ccty.noah.domain.dto.PageDTO;
import com.ccty.noah.service.applets.InvitationCustomService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ryan
 * @date 2020/12/23
 */

@Controller
@NoahController
@Slf4j
@RequestMapping("/{version}/api/invitation/invitationCustom")
public class InvitationCustomController {

    @Autowired
    private InvitationCustomService invitationCustomService;

    @ApiOperation(value = "小程序端查看帖子类目")
    @GetMapping("/typeList")
    public NoahResult<PageInfo<DataDictDTO>> findAllInvitationType(PageDTO page){
        return NoahResult.builderSuccess(invitationCustomService.findAllInvitationType(page));
    }
}

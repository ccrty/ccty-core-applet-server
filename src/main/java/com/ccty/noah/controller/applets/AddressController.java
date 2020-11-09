package com.ccty.noah.controller.applets;

import com.ccty.noah.aop.NoahResult;
import com.ccty.noah.aop.target.NoahController;
import com.ccty.noah.domain.dto.PageDTO;
import com.ccty.noah.domain.dto.applets.AddressDTO;
import com.ccty.noah.service.applets.AddressService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author 缄默
 * @date   2020/11/09
 */
@Api("小程序地址管理控制器")
@RequestMapping("/{version}/applets/api/address")
@NoahController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @ApiOperation(value = "新增地址")
    @PostMapping
    public NoahResult<Boolean> doInsertAddress(@RequestBody @Validated AddressDTO address){
        addressService.doInsertAddress(address);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }

    @ApiOperation(value = "获取地址列表")
    @GetMapping("/list")
    public NoahResult<PageInfo<AddressDTO>> getAddressList(PageDTO page){
        return NoahResult.builderSuccess(addressService.getAddressList(page));
    }

    @ApiOperation(value = "删除地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value="地址id",required = true,paramType = "query",dataType = "string")
    })
    @DeleteMapping
    public NoahResult<Boolean> doDeleteAddress(@RequestParam("id")Long id){
        addressService.doDeleteAddress(id);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }

    @ApiOperation(value = "修改地址")
    @PutMapping
    public NoahResult<Boolean> doUpdateAddress(@RequestBody @Validated AddressDTO address){
        addressService.doUpdateAddress(address);
        return NoahResult.builderSuccess(Boolean.TRUE);
    }
}

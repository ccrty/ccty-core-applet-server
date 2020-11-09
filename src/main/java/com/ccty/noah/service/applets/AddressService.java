package com.ccty.noah.service.applets;

import com.ccty.noah.domain.dto.PageDTO;
import com.ccty.noah.domain.dto.applets.AddressDTO;
import com.github.pagehelper.PageInfo;

/**
 * @author 缄默
 * @date   2020/11/09
 */
public interface AddressService {

    /**
     * 新增地址
     * @param address
     */
    void doInsertAddress(AddressDTO address);

    /**
     * 获取地址列表
     * @param page
     * @return
     */
    PageInfo<AddressDTO> getAddressList(PageDTO page);

    /**
     * 删除地址
     * @param id
     */
    void doDeleteAddress(Long id);

    /**
     * 修改地址
     * @param address
     */
    void doUpdateAddress(AddressDTO address);
}

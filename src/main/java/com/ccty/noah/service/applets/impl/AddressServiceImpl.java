package com.ccty.noah.service.applets.impl;

import com.ccty.noah.aop.target.NoahService;
import com.ccty.noah.domain.convertor.applets.AddressConvertor;
import com.ccty.noah.domain.database.applets.AddressDO;
import com.ccty.noah.domain.dto.PageDTO;
import com.ccty.noah.domain.dto.applets.AddressDTO;
import com.ccty.noah.mapper.applets.AddressMapper;
import com.ccty.noah.service.applets.AddressService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/11/09
 */
@NoahService
@Slf4j
public class AddressServiceImpl implements AddressService {
    
    @Autowired
    private AddressConvertor addressConvertor;
    @Autowired
    private AddressMapper addressMapper;

    /**
     * 新增地址
     * @param address
     */
    @Override
    public void doInsertAddress(AddressDTO address) {
        AddressDO addressDO = addressConvertor.DTOToDO(address);
        addressMapper.insertAddress(addressDO);
    }

    /**
     * 获取地址
     * @param condition
     * @return
     */
    @Override
    public PageInfo<AddressDTO> getAddressList(PageDTO condition) {
        Page page = PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        List<AddressDO> addressList = addressMapper.queryAddressList();
        PageInfo pageInfo = new PageInfo<>(page.getResult());
        List<AddressDTO> addressDTOS = addressConvertor.DOListToDTO(addressList);
        pageInfo.setList(addressDTOS);
        return pageInfo;
    }

    /**
     * 删除地址
     * @param id
     */
    @Override
    public void doDeleteAddress(Long id) {
        addressMapper.deleteAddress(id);
    }

    /**
     * 修改地址
     * @param address
     */
    @Override
    public void doUpdateAddress(AddressDTO address) {
        AddressDO addressDO = addressConvertor.DTOToDO(address);
        addressMapper.updateAddress(addressDO);
    }
}

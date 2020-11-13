package com.ccty.noah.mapper.applets;

import com.ccty.noah.domain.database.applets.AddressDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author 缄默
 * @date 2020/11/09
 */
@Mapper
@Component
public interface AddressMapper {

    /**
     * 新增地址
     * @param addressDO
     */
    void insertAddress(AddressDO addressDO);

    /**
     * 查询地址列表
     * @return
     */
    List<AddressDO> queryAddressList();

    /**
     * 删除地址
     * @param id
     */
    void deleteAddress(Long id);

    /**
     * 修改地址
     * @param addressDO
     */
    void updateAddress(AddressDO addressDO);
}

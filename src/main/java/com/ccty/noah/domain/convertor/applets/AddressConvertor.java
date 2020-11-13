package com.ccty.noah.domain.convertor.applets;

import com.ccty.noah.domain.database.applets.AddressDO;
import com.ccty.noah.domain.dto.applets.AddressDTO;
import com.ccty.noah.util.EntityFactory;
import org.mapstruct.Mapper;

import java.util.List;


/**
 * @author 缄默
 * @date 2020/11/09
 */
@Mapper(componentModel = "spring", uses = EntityFactory.class)
public interface AddressConvertor {


    /**
     * 对象转换
     * @param address
     * @return
     */
    AddressDO DTOToDO(AddressDTO address);

    /**
     * 对象转换
     * @param addressList
     * @return
     */
    List<AddressDTO> DOListToDTO(List<AddressDO> addressList);
}

package com.ccty.noah.domain.convertor;


import com.ccty.noah.domain.database.DataDictDO;
import com.ccty.noah.domain.dto.DataDictDTO;
import com.ccty.noah.util.EntityFactory;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author ryan
 * @date 2020/11/20
 */
@Mapper(componentModel = "spring",uses = EntityFactory.class)
public interface DataDictConvertor {

    /**
     * 对象转换
     * @param dataDictDTO
     * @return DO对象
     */
    DataDictDO DTOToDO(DataDictDTO dataDictDTO);

    /**
     * 对象转换
     * @param dataDictDO
     * @return
     */
    List<DataDictDTO> DOListToDTO(List<DataDictDO> dataDictDO);

}

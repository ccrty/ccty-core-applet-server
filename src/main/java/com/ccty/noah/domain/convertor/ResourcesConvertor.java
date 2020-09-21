package com.ccty.noah.domain.convertor;

import com.ccty.noah.domain.database.ResourcesDO;
import com.ccty.noah.domain.dto.ResourcesDTO;
import com.ccty.noah.util.EntityFactory;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/09/21
 */
@Mapper(componentModel = "spring", uses = EntityFactory.class)
public interface ResourcesConvertor {

    /**
     * 对象转换
     * @param resourcesDTO
     * @return
     */
    ResourcesDO DTOToDO(ResourcesDTO resourcesDTO);

    /**
     * 对象转换
     * @param resourcesList
     * @return
     */
    List<ResourcesDTO> DOListToDTO(List<ResourcesDO> resourcesList);
}

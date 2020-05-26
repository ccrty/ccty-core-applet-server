package com.distance.src.domain.convertor;

import com.distance.src.domain.database.DemoDO;
import com.distance.src.domain.dto.DemoDTO;
import com.distance.src.util.EntityFactory;
import org.mapstruct.Mapper;

/**
 * @author 缄默
 * @date 2019/10/14
 */
@Mapper(componentModel = "spring", uses = EntityFactory.class)
public interface DemoConvertor {

    /**
     * DTO对象转换DO对象
     * @param demoDO
     * @return
     */
    DemoDTO demoDOToDemoDTO(DemoDO demoDO);

}

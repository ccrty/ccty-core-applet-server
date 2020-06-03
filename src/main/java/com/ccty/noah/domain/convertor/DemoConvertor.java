package com.ccty.noah.domain.convertor;

import com.ccty.noah.util.EntityFactory;
import com.ccty.noah.domain.database.DemoDO;
import com.ccty.noah.domain.dto.DemoDTO;
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

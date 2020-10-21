package com.ccty.noah.domain.convertor;

import com.ccty.noah.domain.database.CarouselDO;
import com.ccty.noah.domain.dto.CarouselDTO;
import com.ccty.noah.util.EntityFactory;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author  缄默
 * @date 2020/10/15
 */
@Mapper(componentModel = "spring", uses = EntityFactory.class)
public interface SystemManagerConvertor {

    /**
     * DO集合转DTO集合
     * @param carouselDOS
     * @return
     */
    List<CarouselDTO> DOsToDTOs(List<CarouselDO> carouselDOS);
}

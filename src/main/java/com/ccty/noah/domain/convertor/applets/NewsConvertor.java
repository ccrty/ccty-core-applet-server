package com.ccty.noah.domain.convertor.applets;

import com.ccty.noah.domain.database.applets.NewsDO;
import com.ccty.noah.domain.dto.applets.NewsDTO;
import com.ccty.noah.util.EntityFactory;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author 缄默
 * @date 2020/09/13
 */
@Mapper(componentModel = "spring", uses = EntityFactory.class)
public interface NewsConvertor {


    /**
     * do转dto集合
     * @param newsDOS
     * @return
     */
    List<NewsDTO> newsDOToDTOs(List<NewsDO> newsDOS);

    /**
     * dto转do
     * @param newsDTO
     * @return
     */
    NewsDO DTOToDO(NewsDTO newsDTO);
}

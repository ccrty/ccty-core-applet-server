package com.ccty.noah.domain.convertor.applets;

import com.ccty.noah.domain.database.applets.RunnerDO;
import com.ccty.noah.domain.dto.applets.RunnerDTO;
import com.ccty.noah.util.EntityFactory;
import org.mapstruct.Mapper;

/**
 * @author 缄默
 * @date 2020/12/22
 */
@Mapper(componentModel = "spring", uses = EntityFactory.class)
public interface RunnerConvertor {

    /**
     * 对象转换
     * @param runner
     * @return
     */
    RunnerDO DTOToDO(RunnerDTO runner);
}

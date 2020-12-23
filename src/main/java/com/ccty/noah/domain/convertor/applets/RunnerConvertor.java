package com.ccty.noah.domain.convertor.applets;

import com.ccty.noah.domain.database.applets.RunnerConditionDO;
import com.ccty.noah.domain.database.applets.RunnerDO;
import com.ccty.noah.domain.dto.applets.RunnerConditionDTO;
import com.ccty.noah.domain.dto.applets.RunnerDTO;
import com.ccty.noah.util.EntityFactory;
import org.mapstruct.Mapper;

import java.util.List;

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

    /**
     * 对象转换
     * @param conditionDO
     * @return
    */
    RunnerConditionDO coditionDTOToDO(RunnerConditionDTO conditionDO);

    /**
     * 对象转换
     * @param runner
     * @return
     */
    List<RunnerDTO> listDOToDTO(List<RunnerDO> runner);
}

package com.ccty.noah.mapper.applets;

import com.ccty.noah.domain.database.DataDictDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ryan
 * @date 2020/12/23
 */

@Mapper
@Component
public interface InvitationCustomMapper {
    /**
     * 查看帖子类目
     */
    List<DataDictDO> findAllInvitationType();

}

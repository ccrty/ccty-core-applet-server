package com.ccty.noah.mapper;

import com.ccty.noah.domain.database.DataDictDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ryan
 * @date 2020/11/3
 */
@Mapper
@Component
public interface InvitationMapper {

    /**
     * 查看帖子类目
     */
    List<DataDictDO> findAllInvitationType();

    /**
     * 添加帖子类目
     * @param dataDictValue
     */
    void doInsertInvitationType(String dataDictValue);

    /**
     * 删除帖子类目
     * @param id
     */
    void deleteInvitationType(Long id);
}

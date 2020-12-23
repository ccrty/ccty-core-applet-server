package com.ccty.noah.service;

import com.ccty.noah.domain.database.DataDictDO;
import com.ccty.noah.domain.dto.DataDictDTO;
import com.ccty.noah.domain.dto.PageDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author ryan
 * @date 2020/11/3
 */
public interface InvitationService {

    /**
     * 找到所有帖子类目
     * @return 类目集合
     */
    PageInfo<DataDictDTO> findAllInvitationType(PageDTO page);


    /**
     * 删除帖子类目
     * @param id
     */
    void doDeleteInvitationType(Long id);

    /**
     * 新增帖子类目
     */
    void doInsertInvitationType(String dataDictValue);

    /**
     * 修改帖子类目删除标志
     * @param id
     */
    void doUpdateInvitationTypeDel(Long id);
}

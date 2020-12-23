package com.ccty.noah.service.applets;

import com.ccty.noah.domain.dto.DataDictDTO;
import com.ccty.noah.domain.dto.PageDTO;
import com.github.pagehelper.PageInfo;

/**
 * @author ryan
 * @date 2020/12/23
 */
public interface InvitationCustomService {

    /**
     * 找到所有帖子类目
     * @return 类目集合
     */
    PageInfo<DataDictDTO> findAllInvitationType(PageDTO page);
}

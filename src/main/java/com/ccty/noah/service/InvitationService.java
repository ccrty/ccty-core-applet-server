package com.ccty.noah.service;

import com.ccty.noah.domain.dto.DataDictDTO;

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
    List<DataDictDTO> findAllInvitationType();


}

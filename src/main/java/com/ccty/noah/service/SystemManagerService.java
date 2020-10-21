package com.ccty.noah.service;

import com.ccty.noah.domain.dto.CarouselDTO;
import com.ccty.noah.domain.dto.PageDTO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 缄默
 * @date   2020/10/15
 */
public interface SystemManagerService {

    /**
     * 新增/修改轮播图
     * @param file
     * @param id
     */
    void doUpdateCarousel(MultipartFile file, Long id);

    /**
     * 删除轮播图
     * @param file
     * @param id
     */
    void doDeletedCarousel(MultipartFile file, Long id);


    /**
     * 分页查询轮播图
     * @param page
     * @return
     */
    PageInfo<CarouselDTO> getCarouselList(PageDTO page);
}

package com.ccty.noah.service.impl;

import com.ccty.noah.aop.target.NoahService;
import com.ccty.noah.domain.constance.UserConst;
import com.ccty.noah.domain.convertor.SystemManagerConvertor;
import com.ccty.noah.domain.database.CarouselDO;
import com.ccty.noah.domain.database.ResourcesDO;
import com.ccty.noah.domain.dto.CarouselDTO;
import com.ccty.noah.domain.dto.PageDTO;
import com.ccty.noah.domain.dto.ResourcesDTO;
import com.ccty.noah.mapper.SystemManagerMapper;
import com.ccty.noah.service.SystemManagerService;
import com.ccty.noah.util.UploadUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 缄默
 * @date   2020/10/15
 */
@NoahService
public class SystemManagerServiceImpl implements SystemManagerService {

    @Autowired
    private UploadUtils uploadUtils;
    @Autowired
    private SystemManagerMapper systemManagerMapper;
    @Autowired
    private SystemManagerConvertor systemManagerConvertor;

    /**
     * 新增/修改轮播图
     * @param file
     * @param id
     */
    @Override
    public void doUpdateCarousel(MultipartFile file, Long id) {
        String filename = file.getOriginalFilename();
        String url = uploadUtils.uploadFile(file, "", filename);
        CarouselDO carousel = new CarouselDO();
        carousel.setAddress(url);
        carousel.setType(UserConst.APPLETS_INDEX_CAROUSEL);
        if(ObjectUtils.isEmpty(id)){
            systemManagerMapper.insertCarousel(carousel);
            return;
        }
        carousel.setId(id);
        systemManagerMapper.updateCarousel(carousel);
    }

    /**
     * 删除轮播图
     * @param file
     * @param id
     */
    @Override
    public void doDeletedCarousel(MultipartFile file, Long id) {
        systemManagerMapper.deleteCarousel(id);
    }

    /**
     * 分页查询轮播图信息
     * @param condition
     * @return
     */
    @Override
    public PageInfo<CarouselDTO> getCarouselList(PageDTO condition) {
        Page page = PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        List<CarouselDO> carouselDOS = systemManagerMapper.queryCarouselList();
        PageInfo pageInfo = new PageInfo<>(page.getResult());
        List<CarouselDTO> carouselDTOS = systemManagerConvertor.DOsToDTOs(carouselDOS);
        pageInfo.setList(carouselDTOS);
        return pageInfo;
    }
}

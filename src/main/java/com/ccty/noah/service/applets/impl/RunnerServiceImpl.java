package com.ccty.noah.service.applets.impl;

import com.ccty.noah.aop.exception.NoahException;
import com.ccty.noah.aop.target.NoahService;
import com.ccty.noah.domain.constance.ExceptionEnum;
import com.ccty.noah.domain.constance.IntegralConst;
import com.ccty.noah.domain.constance.RunnerConst;
import com.ccty.noah.domain.convertor.applets.RunnerConvertor;
import com.ccty.noah.domain.database.applets.AddressDO;
import com.ccty.noah.domain.database.applets.IntegralDO;
import com.ccty.noah.domain.database.applets.IntegralRecordDO;
import com.ccty.noah.domain.database.applets.RunnerDO;
import com.ccty.noah.domain.dto.applets.AddressDTO;
import com.ccty.noah.domain.dto.applets.RunnerConditionDTO;
import com.ccty.noah.domain.dto.applets.RunnerDTO;
import com.ccty.noah.mapper.IntegralMapper;
import com.ccty.noah.mapper.applets.RunnerMapper;
import com.ccty.noah.service.applets.RunnerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author 缄默
 * @date   2020/12/22
 */
@NoahService
public class RunnerServiceImpl implements RunnerService {

    @Autowired
    private IntegralMapper integralMapper;
    @Autowired
    private RunnerConvertor runnerConvertor;
    @Autowired
    private RunnerMapper runnerMapper;

    /**
     * 发布跑腿订单
     * @param runner
     * @return
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void publishRunnerOrder(RunnerDTO runner) {
        //总费用为选择费用+垫付费用
        BigDecimal totalCost = runner.getCost().add(ObjectUtils.isEmpty(runner.getAdvance())?BigDecimal.ZERO:runner.getAdvance());
        //判断用户积分是否足够
        IntegralDO integral = integralMapper.queryIntegralInfoByUserId(runner.getPublishId());
        if(!ObjectUtils.isEmpty(integral) && integral.getAvailableIntegral().compareTo(totalCost) == -1){
            throw new NoahException(ExceptionEnum.USER_INVITATION_ISSUFF.getCode(),ExceptionEnum.USER_INVITATION_ISSUFF.getName());
        }
        //冻结用户积分并插入积分记录
        integralMapper.updateAvailableIntegralById(runner.getId(),totalCost);
        IntegralRecordDO integralRecord = new IntegralRecordDO(runner.getId(),runner.getPublishId(),totalCost, IntegralConst.OPERATE_SUBTRACT,IntegralConst.IntegralType.RUNNER.getCode(),IntegralConst.IntegralStatus.FREEZING.getCode());
        integralMapper.insertIntegralRecord(integralRecord);
        //插入跑腿订单
        RunnerDO runnerDO = runnerConvertor.DTOToDO(runner);
        runnerDO.setStatus(RunnerConst.OrderStatus.PUBLISHED.getCode());
        runnerMapper.insertRunner(runnerDO);
    }

    /**
     * 查询跑腿订单
     * @param condition
     * @return
     */
    @Override
    public PageInfo<RunnerDTO> queryRunnerOrder(RunnerConditionDTO condition) {
        Page page = PageHelper.startPage(condition.getPageNum(), condition.getPageSize());
        List<RunnerDO> runnerList = runnerMapper.queryRunnerList(runnerConvertor.coditionDTOToDO(condition));
        PageInfo pageInfo = new PageInfo<>(page.getResult());
        List<RunnerDTO> runnerDTOList = runnerConvertor.listDOToDTO(runnerList);
        pageInfo.setList(runnerDTOList);
        return pageInfo;
    }

    /**
     * 骑手接收订单
     * @param orderId
     * @param riderId
     */
    @Override
    public void receiveRunnerOrder(Long orderId, Long riderId) {
        runnerMapper.updateOrderStatus(orderId,riderId,RunnerConst.OrderStatus.DELIVERING.getCode());

    }

    /**
     * 结束跑腿订单
     * @param orderId
     */
    @Override
    public void finishRunnerOrder(Long orderId) {
        //修改订单状态

        //查询积分情况 扣减用户积分

        //骑手增加积分
    }


}

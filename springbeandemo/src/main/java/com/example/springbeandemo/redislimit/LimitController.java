package com.example.springbeandemo.redislimit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

public class LimitController {

//    @Autowired
//    private RedisLimit redisLimit ;
//
//    @Override
//    @CheckReqNo
//    public BaseResponse<OrderNoResVO> getOrderNo(@RequestBody OrderNoReqVO orderNoReq) {
//        BaseResponse<OrderNoResVO> res = new BaseResponse();
//        //限流
//        boolean limit = redisLimit.limit();
//        if (!limit){
//            res.setCode(StatusEnum.REQUEST_LIMIT.getCode());
//            res.setMessage(StatusEnum.REQUEST_LIMIT.getMessage());
//            return res ;
//        }
//        res.setReqNo(orderNoReq.getReqNo());
//        if (null == orderNoReq.getAppId()){
//            throw new SBCException(StatusEnum.FAIL);
//        }
//        OrderNoResVO orderNoRes = new OrderNoResVO() ;
//        orderNoRes.setOrderId(DateUtil.getLongTime());
//        res.setCode(StatusEnum.SUCCESS.getCode());
//        res.setMessage(StatusEnum.SUCCESS.getMessage());
//        res.setDataBody(orderNoRes);
//        return res ;
//    }
}

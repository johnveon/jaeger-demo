//package com.example.jaegerdemo.config;
//
//import com.example.jaegerdemo.common.Baseresult;
//import com.example.jaegerdemo.facade.consumer.TestReadFacade;
//import com.example.jaegerdemo.model.vo.facade.Serv2VO;
//import feign.hystrix.FallbackFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
///**
// * @Description: 工厂
// * @Author: zhoufengen
// * @Create In: 2019-05-05 17:14
// **/
//@Component
//public class MyFeignFallbackFactory implements FallbackFactory<TestReadFacade> {
//
//    private static Logger logger = LoggerFactory.getLogger(MyFeignFallbackFactory.class);
//
//
//    @Override
//    public TestReadFacade create(Throwable throwable) {
//        if (throwable.getMessage() != null) {
//            if (logger.isErrorEnabled()) {
//                logger.error("调用错误：", throwable);
//            }
//        }
//        return new TestReadFacade() {
//            @Override
//            public Baseresult<Serv2VO> list(String name) {
//                return Baseresult.fail("调用错误:");
//            }
//        };
//    }
//}

package com.example.jaegerdemo.facade.consumer;

import com.example.jaegerdemo.common.Baseresult;
import com.example.jaegerdemo.model.vo.facade.Serv2VO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: 接口重试失败的结果返回
 * @Author: zhoufengen
 * @Create In: 2019-04-29 17:18
 **/
@Component
public class TestReadFacadeFallback implements TestReadFacade {

    private static Logger logger = LoggerFactory.getLogger(TestReadFacadeFallback.class);

    @Override
    public Baseresult<Serv2VO> list(String name) {

        if (logger.isWarnEnabled()) {
            logger.warn("TestReadFacade 接口调用失败");
        }

        return Baseresult.fail("接口调用失败");
    }
}

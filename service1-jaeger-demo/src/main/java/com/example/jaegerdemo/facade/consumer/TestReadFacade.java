package com.example.jaegerdemo.facade.consumer;

import com.example.jaegerdemo.common.Baseresult;
import com.example.jaegerdemo.model.vo.facade.Serv2VO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description: 读的接口，可以重试
 * @Author: zhoufengen
 * @Create In: 2019-04-29 17:14
 **/
@FeignClient(name = "${rest.service2.name}", url = "${rest.service2.url:}", fallback = TestReadFacadeFallback.class)
public interface TestReadFacade {
    String USER_BASE_URI = "/service2/v1/api/demo";

    @GetMapping(USER_BASE_URI + "/list")
    Baseresult<Serv2VO> list(@RequestParam("name") String name);
}

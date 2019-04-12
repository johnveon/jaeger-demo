package com.example.jaegerdemo.facade.consumer;

import com.example.jaegerdemo.common.Baseresult;
import com.example.jaegerdemo.model.vo.facade.Serv1VO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @description: 外部的接口
 * @author: zhoufengen
 * @create at: 2019-04-10 16:49
 **/
@FeignClient(name = "${rest.service1.name}", url = "${rest.service1.url}")
public interface Serv1Facade {

    String USER_BASE_URI = "/service1/v1/api/demo";

    @PostMapping(USER_BASE_URI + "/findByName")
    Baseresult<Serv1VO> findByName(String name);

}

package com.example.jaegerdemo.facade.consumer;

import com.example.jaegerdemo.common.Baseresult;
import com.example.jaegerdemo.model.vo.facade.Serv2VO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 外部的接口
 * @author: zhoufengen
 * @create at: 2019-04-10 16:49
 **/
@FeignClient(name = "${rest.service2.name}", url = "${rest.service2.url}")
public interface Serv2Facade {

    String USER_BASE_URI = "/service2/v1/api/demo";

    //@RequestParam("name") 解决调用post的问题
    @GetMapping(USER_BASE_URI + "/findByName")
    Baseresult<Serv2VO> findByName(@RequestParam("name") String name);

}

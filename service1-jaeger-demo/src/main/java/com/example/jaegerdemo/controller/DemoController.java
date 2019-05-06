package com.example.jaegerdemo.controller;

import com.example.jaegerdemo.common.Baseresult;
import com.example.jaegerdemo.facade.consumer.Serv2Facade;
import com.example.jaegerdemo.facade.consumer.TestReadFacade;
import com.example.jaegerdemo.model.vo.DemoVO;
import com.example.jaegerdemo.model.vo.es.UserVO;
import com.example.jaegerdemo.model.vo.facade.Serv2VO;
import com.example.jaegerdemo.service.DemoService;
import com.example.jaegerdemo.service.EsDemoService;
import com.example.jaegerdemo.table.Demo;
import com.example.jaegerdemo.table.es.User;
import com.example.jaegerdemo.trace.OwlTrace;
import com.example.jaegerdemo.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description: 测试
 * @author: zhoufengen
 * @create at: 2019-04-10 15:29
 **/
@RestController
@RequestMapping("/service1/v1/api/demo")
public class DemoController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DemoService demoService;

    @Autowired
    private Serv2Facade serv2Facade;

    @Autowired
    private EsDemoService esDemoService;

    @Autowired
    private TestReadFacade testReadFacade;

    @OwlTrace
    @GetMapping("/test")
    public Baseresult<DemoVO> test(String key){

        DemoVO demoVO = new DemoVO(1L,"测试");

        Demo zxx = demoService.findByName("zxx");

        return Baseresult.success(demoVO);
    }


    @GetMapping("/call/serv2/list")
    public Baseresult<DemoVO> list(String key){

        DemoVO demoVO = new DemoVO(1L,"测试222");

        Baseresult<Serv2VO> zxx = testReadFacade.list(key);

        if (zxx.getCode() != 200){
            return Baseresult.fail(zxx.getDesc());
        }
        return Baseresult.success(demoVO);
    }

    @GetMapping("/call/serv2")
    public Baseresult<DemoVO> callServ2(String key){

        DemoVO demoVO = new DemoVO(1L,"测试222");

        Baseresult<Serv2VO> zxx = serv2Facade.findByName("test222");

        return Baseresult.success(demoVO);
    }



    @RequestMapping("/chaining")
    public String chaining() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8082/service2/v1/api/demo/chaining", String.class);
        return "Chaining + " + response.getBody();
    }

    @GetMapping("/estest")
    public Baseresult<UserVO> estest(@RequestParam("name") String name) {
        User user = esDemoService.esFindByName(name);
        return Baseresult.success(UserUtil.modelToVO(user));
    }

}

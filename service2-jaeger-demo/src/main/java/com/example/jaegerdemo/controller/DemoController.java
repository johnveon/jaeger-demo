package com.example.jaegerdemo.controller;

import com.example.jaegerdemo.common.Baseresult;
import com.example.jaegerdemo.facade.consumer.Serv1Facade;
import com.example.jaegerdemo.model.vo.DemoVO;
import com.example.jaegerdemo.model.vo.facade.Serv1VO;
import com.example.jaegerdemo.service.DemoService;
import com.example.jaegerdemo.table.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 测试
 * @author: zhoufengen
 * @create at: 2019-04-10 15:29
 **/
@RestController
@RequestMapping("/service2/v1/api/demo")
public class DemoController {


    @Autowired
    private DemoService demoService;

    @Autowired
    private Serv1Facade serv1Facade;

    @GetMapping("/test")
    public Baseresult<DemoVO> test(String key){

        DemoVO demoVO = new DemoVO(1L,"测试1");

        Demo zxx = demoService.findByName("name1");

        return Baseresult.success(demoVO);
    }




    @GetMapping("/findByName")
    public Baseresult<DemoVO> findByName(@RequestParam("name") String name) throws InterruptedException {

        DemoVO demoVO = new DemoVO(1L,"测试2");

        Demo zxx = demoService.findByName("name2");

        Thread.sleep(7 * 1000);

        return Baseresult.success(demoVO);
    }


    @GetMapping("/list")
    public Baseresult<DemoVO> list(@RequestParam("name") String name) throws InterruptedException {

        DemoVO demoVO = new DemoVO(1L,"测试1");

        Demo zxx = demoService.findByName("name2");

//        boolean b = true;
//        if (b){
//            throw new RuntimeException("测试异常");
//        }
        if ((Math.random() * 100) > 25 ) {
            Thread.sleep(15 * 1000);
        }

        return Baseresult.success(demoVO);
    }


    @GetMapping("/call/serv1")
    public Baseresult<DemoVO> callServ1(String key){

        DemoVO demoVO = new DemoVO(1L,"测试1");

        Baseresult<Serv1VO> zxx = serv1Facade.findByName("name1");

        return Baseresult.success(demoVO);
    }

    @RequestMapping("/chaining")
    public String chaining() {
        return "xxxsseweee-service2";
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Math.random() * 100 );
        }
    }
}

/*
package com.example.jaegerdemo.config;

*/
/**
 * @Description: feign的错误码解析
 * @Author: zhoufengen
 * @Create In: 2019-05-05 17:07
 **//*

import feign.Response;
import feign.codec.ErrorDecoder;

public class MyErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {

        if(response.status() >= 400 && response.status() <= 499){
            return new MyFeignException("xxxxxx");
        }
        return feign.FeignException.errorStatus(methodKey, response);
    }
}*/

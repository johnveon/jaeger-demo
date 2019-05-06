//package com.example.jaegerdemo.config;
//
//import feign.Response;
//
///**
// * @Description: feign的异常
// * @Author: zhoufengen
// * @Create In: 2019-05-05 17:08
// **/
//public class MyFeignException extends RuntimeException {
//    private String desc;
//    private String methodKey;
//    private Response response;
//
//
//    MyFeignException(String methodKey, Response response) {
//        this.methodKey = methodKey;
//        this.response = response;
//    }
//
//    public MyFeignException(String desc) {
//        this.desc = desc;
//    }
//
//
//    public Response getResponse() {
//        return response;
//    }
//
//    public String getMethodKey() {
//        return methodKey;
//    }
//}
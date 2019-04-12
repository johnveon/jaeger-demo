package com.example.jaegerdemo.config;

import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.tag.Tags;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: 自定义的一条链路的trace配置，分组在tag用my_java查询出来
 * @author: zhoufengen
 * @create at: 2019-04-11 11:43
 **/
@Configuration
@Slf4j
public class OwlTraceAutoConfiguration {
    static final String TAG_COMPONENT = "my_java";

    @Autowired
    @Lazy
    Tracer tracer;

    @Bean
    public TracingAspect pxTracingAspect() {
        return new TracingAspect();
    }

    @Aspect
    class TracingAspect {
        @Around("@annotation(com.example.jaegerdemo.trace.OwlTrace)")
        public Object pxTraceProcess(ProceedingJoinPoint pjp) throws Throwable {
            Span span = null;
            if (tracer != null) {
                final String cls = pjp.getTarget().getClass().getName();
                final String mName = pjp.getSignature().getName();
                span = tracer.buildSpan(cls + "." + mName)
                        .withTag(Tags.COMPONENT.getKey(), TAG_COMPONENT)
                        .withTag("class", cls)
                        .withTag("method", mName)
                        .startActive(false)
                        .span();
            }
            try {
                return pjp.proceed();
            } catch (Throwable t) {
                Map exceptionLogs = new LinkedHashMap(2);
                exceptionLogs.put("event", Tags.ERROR.getKey());
                exceptionLogs.put("error.object", t);
                span.log(exceptionLogs);
                Tags.ERROR.set(span, true);
                throw t;
            } finally {
                if (tracer != null && span != null) {
                    span.finish();
                }
            }
        }
    }
}
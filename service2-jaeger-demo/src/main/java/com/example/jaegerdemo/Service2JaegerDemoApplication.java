package com.example.jaegerdemo;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import io.jaegertracing.Configuration;
import io.jaegertracing.internal.samplers.ConstSampler;
import io.opentracing.Tracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class Service2JaegerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Service2JaegerDemoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

//	@Bean
//	public Tracer jaegerTracer() {
//		Configuration.SenderConfiguration senderConfiguration = new Configuration.SenderConfiguration()
//				.withEndpoint("http://192.168.2.127:14268/api/traces");
//		Configuration.ReporterConfiguration reporterConfiguration = new Configuration.ReporterConfiguration()
//				.withSender(senderConfiguration).withLogSpans(false).withMaxQueueSize(1000).withFlushInterval(100);
//		Configuration.SamplerConfiguration samplerConfiguration = new Configuration.SamplerConfiguration()
//				.withType(ConstSampler.TYPE).withParam(1);
//		Configuration configuration = new Configuration("service2-jaeger-demo")
//				.withReporter(reporterConfiguration).withSampler(samplerConfiguration);
//		return configuration.getTracer();
//	}

	@Bean
	public ServletRegistrationBean getServlet(){
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/actuator/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}

}

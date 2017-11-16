package com.sath.devops.service2.service

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.sath.devops.service2.shared.domain.Service2OpenInfoStore
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import kotlin.properties.Delegates

@Service
class Service2Service(val env: Environment) {

    val log: Log? = LogFactory.getLog(this.javaClass);
    var restTemplate:RestTemplate by Delegates.notNull();

    init {
        this.restTemplate = RestTemplate();
    }

    @HystrixCommand(fallbackMethod = "errorHandler")
    fun insertDataIntoService1(service2OpenInfoStore: Service2OpenInfoStore):Boolean{
        log?.info("Service2OpenInfoStore data received $service2OpenInfoStore");
        val response = restTemplate.postForEntity(env.getProperty("service1.create_url")
                ,service2OpenInfoStore,String.javaClass);
        log?.info("Status received is "+response.body);
        return response.statusCode.value()==200;
    }

    fun errorHandler(service2OpenInfoStore: Service2OpenInfoStore):Boolean{
        log?.info("Invoking the fallback Method!!!!!!")
        return false;
    }

}
package com.sath.devops.service2.resources
import com.sath.devops.service2.service.Service2Service
import com.sath.devops.service2.shared.domain.Service2OpenInfoStore
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class Service2Resource(val service:Service2Service) {

    @GetMapping("/default", "/","/welcome","/index")
    fun sayHelloToVisitor():String{
        return "Hello and Welcome";
    }

    @GetMapping("/create_garbage_data")
    fun insertDataIntoServiceOne():String{
        service.insertDataIntoService1(Service2OpenInfoStore(
                UUID.randomUUID().toString(),"Rand Generation","Generated From Service 2"));
        return "Info created successfully"
    }


}
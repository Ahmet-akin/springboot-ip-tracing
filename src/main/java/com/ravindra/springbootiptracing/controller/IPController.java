package com.ravindra.springbootiptracing.controller;

import com.ravindra.springbootiptracing.entity.IPLocation;
import com.ravindra.springbootiptracing.service.IPLocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value ="IP Controller")
public class IPController {

    @Autowired
    private IPLocationService ipService;

    @ApiOperation(value =" get Ip info")
    @GetMapping(value = "/ipinfo")
    public IPLocation getIPLocation(@RequestParam("ip") String ip){
        return ipService.getIpInfo(ip);
    }

    @ApiOperation(value ="post Ip info")
    @PostMapping(value = "/ipinfo")
    public  IPLocation saveIpInfo(@RequestParam("ip") String ip,boolean isSave ){
     return ipService.saveIpInfo(ip, isSave);
    }

    @GetMapping(value = "/ipdetails")
    public List<IPLocation> getIpLocation(){
        return ipService.getIpDetails();
    }

}

package com.ustb.boot.controller;

import com.ustb.boot.pojo.Result;
import com.ustb.boot.service.FacilityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/facility")
public class FacilityController {

    @Resource
    private FacilityService facilityService;

    @GetMapping("/get-facility-all")
    public Result getFacilityAll() {
        return facilityService.getFacilityAll();
    }
}

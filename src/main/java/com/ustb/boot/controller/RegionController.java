package com.ustb.boot.controller;

import com.ustb.boot.pojo.Result;
import com.ustb.boot.service.RegionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("api/region")
public class RegionController {

    @Resource
    private RegionService regionService;

    @GetMapping("/get-region-all")
    public Result getRegionAll() {
        return regionService.getRegionAll();
    }
}

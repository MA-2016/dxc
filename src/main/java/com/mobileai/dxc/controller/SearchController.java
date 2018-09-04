package com.mobileai.dxc.controller;

import com.mobileai.dxc.service.SearchService;
import com.mobileai.dxc.util.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")

public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/DynamicRecommend")
    public Result dynamicRecommend(String location, String topic) {
        return searchService.dynamicRecommend(location, topic);
    }

}
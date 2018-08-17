package com.mobileai.dxc.service;

import com.mobileai.dxc.util.Result;

public interface SearchService {
    /**
     * 动态模糊匹配搜索
     * 
     */
    public Result dynamicRecommend(String location, String topic);

}
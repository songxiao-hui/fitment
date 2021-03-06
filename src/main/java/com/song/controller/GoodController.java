package com.song.controller;

import com.song.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/10/19.
 */
@Controller
@Scope("prototype")
@RequestMapping("/goods")
public class GoodController {

    @Autowired
    private GoodsService goodsService;
    //测试 json数据
    @RequestMapping(value = "/getGoodsData",method = RequestMethod.GET)
    public @ResponseBody List<Map<String,Object>> getGoodsData() throws Exception {
        List<Map<String, Object>> maps = goodsService.queryGoods();
        return maps;
    }

    @RequestMapping("/uploadGood")
    public void uploadGood(@RequestParam String goodName,double goodPrice,String goodDesc,
                           @RequestParam("photoFile")MultipartFile file) throws Exception{
        System.out.println("--------");
        System.out.println(goodName);
        System.out.println(file.getOriginalFilename());
    }

}

package com.liang.iotmall.product.web;

import com.liang.iotmall.product.service.SkuInfoService;
import com.liang.iotmall.product.vo.SkuItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.ExecutionException;

/**
 * @author: Mr.Liang
 * @date: 2021/5/27 17:47
 * @Version: 1.0
 */
@Controller
public class itemController {

    @Autowired
    SkuInfoService skuInfoService;
    /**
     * 展示当前sku的详情
     * @param skuId: 
     * @return: java.lang.String
     */
    @GetMapping("{skuId}.html")
    public String skuItem(@PathVariable("skuId") Long skuId, Model model) throws ExecutionException, InterruptedException {
        System.out.println("准备查询"+skuId+"的详情");
        SkuItemVo vo= skuInfoService.item(skuId);
        model.addAttribute("item",vo);
        return "item";
    }

}

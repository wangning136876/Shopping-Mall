package com.dev.controller;

import com.dev.Utils.JSONResult;
import com.dev.pojo.Items;
import com.dev.pojo.ItemsImg;
import com.dev.pojo.ItemsParam;
import com.dev.pojo.ItemsSpec;
import com.dev.pojo.vo.CommentCountsVO;
import com.dev.pojo.vo.ItemInfoVO;
import com.dev.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "商品详情页面",tags = {"商品详情页面"})
@RestController
@RequestMapping("items")
public class ItemsController {

    @Autowired
    private ItemService itemService;


    private static final Logger logger = LoggerFactory.getLogger(ItemsController.class);

    @ApiOperation(value = "查询商品详情",notes = "查询商品详情",httpMethod = "GET")
    @GetMapping("/detail")
    public JSONResult detail(
            @ApiParam(name = "itemId",value = "商品id",required = true)
            @RequestParam String itemId) {
        //判断非空
        if(StringUtils.isBlank(itemId)){
            return JSONResult.errorMsg("商品序号不能为空");
        }

        Items items = itemService.queryItemById(itemId);
        List<ItemsImg> itemsImgs = itemService.quertItemImgList(itemId);
        List<ItemsSpec> itemsSpecs = itemService.queryItemSpecList(itemId);
        ItemsParam itemParam = itemService.queryItemParam(itemId);
        //设置VO，data返回对象
        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItems(items);
        itemInfoVO.setItemsImgs(itemsImgs);
        itemInfoVO.setItemsSpecs(itemsSpecs);
        itemInfoVO.setItemParam(itemParam);
        return JSONResult.ok(itemInfoVO);
    }

    @ApiOperation(value = "查询商品评价",notes = "查询商品评价",httpMethod = "GET")
    @GetMapping("/comment")
    public JSONResult comment(
            @ApiParam(name = "itemId",value = "商品id",required = true)
            @RequestParam String itemId) {
        //判断非空
        if(StringUtils.isBlank(itemId)){
            return JSONResult.errorMsg("商品序号不能为空");
        }
        CommentCountsVO commentResult = itemService.queryCommentCounts(itemId);
        return JSONResult.ok(commentResult);
    }
}

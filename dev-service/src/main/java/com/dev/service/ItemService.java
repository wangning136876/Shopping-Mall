package com.dev.service;

import com.dev.pojo.Items;
import com.dev.pojo.ItemsImg;
import com.dev.pojo.ItemsParam;
import com.dev.pojo.ItemsSpec;

import java.util.List;

public interface ItemService {
    /**
     *  根据id查询商品详情
     * @param id
     * @return
     */
    public Items queryItemById(String id);

    /**
     * 根据id查询商品图片
     * @param id
     * @return
     */
    public List<ItemsImg> quertItemImgList(String id);

    /**
     * 根据商品id查询商品详情
     * @param id
     * @return
     */
    public List<ItemsSpec> queryItemSpecList(String id);

    /**
     * 根据商品id查询商品参数
     * @param id
     * @return
     */
    public ItemsParam queryItemParam(String id);
}
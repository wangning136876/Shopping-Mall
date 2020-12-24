package com.dev.mapper;

import com.dev.pojo.vo.ItemCommentVO;
import com.dev.pojo.vo.SearchItemsVO;
import com.dev.pojo.vo.ShopCartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom  {
    public List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String,Object> map);
    public List<SearchItemsVO> searchItemsSpec(@Param("paramsMap") Map<String,Object> map);

    /**
     * 根据三级标签点击查询商品列表
     * @param map
     * @return VO
     */
    public List<SearchItemsVO> searchItemsByThirdCat(@Param("paramsMap") Map<String,Object> map);
    /**
     * 购物车
     */
    public List<ShopCartVO> queryShopCartItems(@Param("paramsList") List<ShopCartItems> list);
}
package com.micropos.cart.service;

import com.micropos.datatype.cart.Cart;
import com.micropos.datatype.cart.Item;
import com.micropos.datatype.cart.Order;
import reactor.core.publisher.Mono;

public interface ICartService {
    /**
     * @param cart
     * 绑定一个Cart，使用其他函数前需要注册
     * 解绑时传入null
     */
    public void registerCart(Cart cart);
    /**
     * 新建一个购物车，并将其绑定为当前购物车
     * @param usrId 购物车的拥有者
     * @return 返回新生成购物车的编号
     */
    public String createAndRegisterCart(String usrId);
    /**
     * @param item
     * 添加货物
     * @return
     */
    public boolean addItem(Item item);
    /**
     * 根据产品id和数量添加商品
     * @param productId
     * @param quantity
     * @return
     */
    public boolean addItem(String productId, Integer quantity);


    /**
     * @param item
     * 移除货物
     * @return
     */
    public boolean delItem(Item item);
    /**
     * 移除货物
     * @param productId
     * @param quantity
     * @return
     */
    public boolean delItem(String productId, Integer quantity);
    /**
     * 移除货物
     * @param productId
     * @return
     */
    public boolean delItem(String productId);
    /**
     * 清空购物车
     * @return
     */
    public boolean clear();
    /**
     * 结账
     * @return
     */
    public boolean checkout();
    /**
     * 登出，更新数据库
     * @return
     */
    public boolean logout();
    /**
     * 结束购物
     * @return
     */
    public boolean finish();
    /**
     * 获取当前绑定的购物车
     * @return
     */
    public Cart getCart();
}

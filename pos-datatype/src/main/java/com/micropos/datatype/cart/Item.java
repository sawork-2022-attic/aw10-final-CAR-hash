package com.micropos.datatype.cart;

import com.micropos.datatype.product.Product;
import lombok.Data;

@Data
public class Item {
    public Product product;
    public Integer quantity;
}

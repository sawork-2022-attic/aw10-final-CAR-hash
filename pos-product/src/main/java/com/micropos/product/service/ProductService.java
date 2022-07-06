package com.micropos.product.service;

import com.micropos.datatype.product.Product;

import java.util.List;

public interface ProductService {


    public List<Product> products();

    public Product getProduct(String id);

    public Product randomProduct();

    public void updateProducts();
}

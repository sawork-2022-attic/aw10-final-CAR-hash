package com.micropos.dataloader;


import com.micropos.datatype.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


public class ProductInserter {

    @Autowired
    ProductRepository productRepository;

    public Boolean insertProduct(Product product){
        productRepository.save(product);
        /*for (String cat:
             categories) {
            productMapper.insertProductCategory(asin,title,cat);

        }
        for (String imageURL:imageURLS){
            productMapper.insertProductImageURL(asin,title,imageURL);
        }*/

        return true;
    }
}

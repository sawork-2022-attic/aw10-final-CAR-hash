package com.micropos.datatype.cart;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("carts")
public class Cart {
    @MongoId
    private String id;

    private String usrId;

    private List<Item> merchandises;

    public Cart(){
        id=new ObjectId().toString()+"-cart";
        merchandises=new ArrayList<>();
    }
}

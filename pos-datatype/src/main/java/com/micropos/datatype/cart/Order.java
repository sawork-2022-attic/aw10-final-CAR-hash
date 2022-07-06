package com.micropos.datatype.cart;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Data
@Document("orders")
public class Order {
    @MongoId
    public String orderId;
    public String usrId;
    public List<Item> merchandises;

    public double price;

    public Order(String usrId,List<Item> merchandises){
        this.merchandises =merchandises;
        this.usrId =usrId;
        this.orderId=new ObjectId().toString();
        price=0;
        for (Item i:merchandises
             ) {
            price+=i.getProduct().getDoublePrice()*i.getQuantity();
        }
    }
    public Order(List<Item> merchandises){
        for (Item i:merchandises
        ) {
            price+=i.getProduct().getDoublePrice()*i.getQuantity();
        }
        this.merchandises =merchandises;
    }

    public Order(Cart cart){
        this.merchandises=cart.getMerchandises();
        this.usrId=cart.getUsrId();
        this.orderId=new ObjectId().toString();
        price=0;
        for (Item i:merchandises
        ) {
            price+=i.getProduct().getDoublePrice()*i.getQuantity();
        }
    }

    public Order(){

    }


}

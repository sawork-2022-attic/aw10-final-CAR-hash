package com.micropos.datatype.product;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

@Data
@Document("products")
public class Product implements Serializable {
    @MongoId
    private String mongoId;
    private String id;
    private String name;
    private String price;
    private String image;

    private int page;
    public Product(){
        mongoId=new ObjectId().toString()+"-product";
    }

    public Product(String id, String name, String price, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;

        mongoId=new ObjectId().toString()+"-product";
    }

    public Product(String id, String name, String price, String image,int page) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.page=page;

        mongoId=new ObjectId().toString()+"-product";
    }
    public String getMongoId(){
        return mongoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getDoublePrice(){
        return Double.parseDouble(price);
    }
}

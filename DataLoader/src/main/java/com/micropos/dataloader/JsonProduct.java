package com.micropos.dataloader;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonProduct {
    private String main_cat;

    private String title;

    private String asin;

    private String price;

    private List<String> category;

    private List<String> imageURLHighRes;
}

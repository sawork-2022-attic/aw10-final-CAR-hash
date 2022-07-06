package com.micropos.dataloader;

import com.fasterxml.jackson.databind.JsonNode;
import com.micropos.datatype.product.Product;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job dataLoadJob(){
        return jobBuilderFactory.get("dataLoadJob")
                .start(loadBeautyStep())
                .next(loadApplianceStep())
                .build();
    }
    @Bean
    public ItemProcessor<JsonNode, JsonProduct> productProcessor(){
        return new ProductProcessor();
    }
    @Bean
    public Step loadBeautyStep(){
        return stepBuilderFactory.get("loadBeutyStep")
                .<JsonNode, JsonProduct>chunk(20)
                .reader(beautyItemReader())
                .processor(productProcessor())
                .writer(beautyItemWriter())
                .build();
    }

    public ItemWriter<JsonProduct> beautyItemWriter(){
        return new ProductWriter(productInserter());
    }

    @Bean
    public ItemReader<JsonNode> beautyItemReader(){
        return new JsonFileReader("./DataLoader/src/main/resources/data/meta_All_Beauty.json");
    }

    @Bean
    public ProductInserter productInserter(){
        return new ProductInserter();
    }

    @Bean
    public Step loadApplianceStep(){
        return stepBuilderFactory.get("loadBeutyStep")
                .<JsonNode, JsonProduct>chunk(20)
                .reader(applianceItemReader())
                .processor(productProcessor())
                .writer(applianceItemWriter())
                .build();
    }

    public ItemWriter<JsonProduct> applianceItemWriter(){
        return new ProductWriter(productInserter());
    }

    @Bean
    public ItemReader<JsonNode> applianceItemReader(){
        return new JsonFileReader("./DataLoader/src/main/resources/data/meta_Appliances.json");
    }




}

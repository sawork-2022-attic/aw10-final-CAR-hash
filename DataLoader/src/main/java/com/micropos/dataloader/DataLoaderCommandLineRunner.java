package com.micropos.dataloader;

import com.micropos.datatype.product.Product;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

@SpringBootApplication
public class DataLoaderCommandLineRunner implements CommandLineRunner {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @Autowired
    ProductRepository productRepository;

    public static void main(String args[]){
        SpringApplication.run(DataLoaderCommandLineRunner.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addDate("data",new Date())
                .toJobParameters();
        JobExecution execution = jobLauncher.run(job, jobParameters);
        System.out.println("STATUS :: " + execution.getStatus());
    }
}

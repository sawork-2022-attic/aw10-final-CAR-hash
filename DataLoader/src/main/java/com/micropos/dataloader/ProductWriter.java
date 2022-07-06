package com.micropos.dataloader;

import com.micropos.datatype.product.Product;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class ProductWriter implements ItemWriter<JsonProduct>, StepExecutionListener {
    @Override
    public void beforeStep(StepExecution stepExecution) {

    }
    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
    ProductInserter productInserter;
    public ProductWriter(ProductInserter productInserter){
        this.productInserter=productInserter;
    }
    @Override
    public void write(List<? extends JsonProduct> list) throws Exception {
        String regex="^.[0-9]+(\\.[0-9]+)?";
        Pattern r=Pattern.compile(regex);

        List<Product> products=list.stream()
                .filter(p->
                        !p.getAsin().isEmpty())
                .filter(p-> {
                            return !p.getPrice().isEmpty() && !p.getPrice().equals("") && p.getPrice().charAt(0) == '$' &&
                                    r.matcher(p.getPrice()).matches();
                        }
                )
                .filter(p->
                        p.getImageURLHighRes().size()>0)
                .map(p->{
                    ProductRepository.productCounter.getAndIncrement();
                    return new Product(p.getAsin(),p.getTitle(),p.getPrice().substring(1),p.getImageURLHighRes().get(0),ProductRepository.productCounter.get()/20+1);
                }
                )
                .collect(Collectors.toList());

        for (Product product:
             products) {
            productInserter.insertProduct(product);
        }
    }
}

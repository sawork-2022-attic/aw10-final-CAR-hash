package com.micropos.dataloader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.micropos.datatype.product.Product;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;

public class ProductProcessor implements ItemProcessor<JsonNode, JsonProduct>, StepExecutionListener {

    private ObjectMapper objectMapper;

    @Override
    public void beforeStep(StepExecution stepExecution) {
        objectMapper = new ObjectMapper();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public JsonProduct process(JsonNode jsonNode) throws Exception {

        return objectMapper.treeToValue(jsonNode, JsonProduct.class);
    }
}

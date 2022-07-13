package me.samplespring.my_samples.config.DataInsertion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RunData {

    @Autowired
    private ProductData productData;

    public void loadData(){
        productData.loadData();
    }
}

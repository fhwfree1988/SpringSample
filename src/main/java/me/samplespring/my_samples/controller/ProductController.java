package me.samplespring.my_samples.controller;

import me.samplespring.my_samples.model.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductController {

    @GetMapping("/")
    public String index(){
        return "Hello";
    }

    @GetMapping("/products")
    public Optional<ProductDTO> getProduct(){
        return /*new Optional<ProductDTO>()*/ null;
    }
}

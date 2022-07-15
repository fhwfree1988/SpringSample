package me.samplespring.my_samples.rest;


import me.samplespring.my_samples.model.ProductDTO;
import me.samplespring.my_samples.service.ProductService;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index(){
        return "Hello";
    }

    @GetMapping("/products")
    public Optional<ProductDTO> getProduct(){
        return /*new Optional<ProductDTO>()*/ null;
    }

    @GetMapping("/product/{id}")
    public /*Optional<ProductDTO>*/ProductDTO getProduct(@PathVariable Long id){
        ProductDTO productDTO = productService.get(id);
        return productDTO;
    }
}

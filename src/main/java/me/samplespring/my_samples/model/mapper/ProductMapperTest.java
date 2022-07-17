package me.samplespring.my_samples.model.mapper;

import me.samplespring.my_samples.domain.Product;
import me.samplespring.my_samples.model.ProductDTO;
import org.mapstruct.Mapper;
/*import org.modelmapper.ModelMapper;*/
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
public class ProductMapperTest implements EntityMapper<ProductDTO, Product> {
    /*@Autowired
    private ModelMapper modelMapper;*/

    @Override
    public Product toEntity(ProductDTO dto) {
      /*  Product product = modelMapper.map(dto, Product.class);
        return product;*/
        return null;
    }

    @Override
    public ProductDTO toDto(Product entity) {
//        ProductDTO productDTO = modelMapper.map(entity, ProductDTO.class);
//        /*productDTO.setSubmissionDate(entity.getSubmissionDate(),
//                userService.getCurrentUser().getPreference().getTimezone());*/
//        return productDTO;
        return null;
    }

    @Override
    public List<Product> toEntity(List<ProductDTO> dtoList) {
        return null;
    }

    @Override
    public List<ProductDTO> toDto(List<Product> entityList) {
        return null;
    }
}

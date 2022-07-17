package me.samplespring.my_samples.model.mapper;

import me.samplespring.my_samples.domain.Product;
import me.samplespring.my_samples.model.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
   /* ProductMapper instance =  Mappers.getMapper( ProductMapper.class );*/
    @Mapping(source = "id", target = "id")
    public ProductDTO convertDTO(Product product);
}

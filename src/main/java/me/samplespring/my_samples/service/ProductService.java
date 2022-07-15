package me.samplespring.my_samples.service;


import me.samplespring.my_samples.domain.Product;
import me.samplespring.my_samples.domain.Reservation;
import me.samplespring.my_samples.domain.User;
import me.samplespring.my_samples.model.ProductDTO;
import me.samplespring.my_samples.model.ReservationDTO;
import me.samplespring.my_samples.model.mapper.ProductMapper;
import me.samplespring.my_samples.repos.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository,ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDTO get(final Long productNo){
        return this.productRepository.findById(productNo).map(product -> mapToDTO(product, new ProductDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    private ProductDTO mapToDTO(final Product product,
                                final ProductDTO productDTO) {
        /*productDTO.setId(product.getId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductNo(product.getProductNo());
        //productDTO.setUser(product.getUser() == null ? null : product.getUser());
        return productDTO;*/
        return productMapper.toDto(product);

    }

    private Product mapToEntity(final ProductDTO productDTO,
                                    final Product product) {
        product.setId(productDTO.getId());
        product.setProductName(productDTO.getProductName());
        product.setProductNo(productDTO.getProductNo());
        /*if (productDTO.getUser() != null && (product.getUser() == null || !product.getUser().getId().equals(productDTO.getUser().getId()))) {
            final User user = userRepository.findById(productDTO.getUser().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
            product.setUser(user);
        }*/
        return product;
    }
}

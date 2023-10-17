package com.greenlight.productservice.service;

import com.greenlight.productservice.dto.ProductRequest;
import com.greenlight.productservice.dto.ProductResponse;
import com.greenlight.productservice.model.Product;
import com.greenlight.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    public void CreateProduct(ProductRequest request){
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product id {} saved!", product.getId());
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        // return products.stream().map(product -> mapToProductReponse(product)).toList();
        return products.stream().map(this::mapToProductReponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductReponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}

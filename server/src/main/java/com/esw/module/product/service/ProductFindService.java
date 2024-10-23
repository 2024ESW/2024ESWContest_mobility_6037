package com.esw.module.product.service;

import com.esw.module.product.entities.ProductFindResponseDTO;
import com.esw.module.product.repository.ProductRepository;
import com.esw.module.storescore.entities.StoreScoreFindResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductFindService {

    private ProductRepository productRepository;

    @Autowired
    public ProductFindService(
            ProductRepository productRepository
    ) {
        this.productRepository = productRepository;
    }

    public List<ProductFindResponseDTO> findAllProducts() {
        List<ProductFindResponseDTO> productList = productRepository.findAll().stream()
                .map(ProductFindResponseDTO::new)
                .toList();

        productList.forEach(System.out::println);

        return productRepository.findAll()
                .stream()
                .map(ProductFindResponseDTO::new)
                .toList();
    }

    public ProductFindResponseDTO findProductById(Long id) {

        return new ProductFindResponseDTO(productRepository.findById(id).orElseThrow(IllegalArgumentException::new));

    }
}

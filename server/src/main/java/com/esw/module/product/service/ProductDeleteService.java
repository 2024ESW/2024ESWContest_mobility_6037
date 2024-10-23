package com.esw.module.product.service;

import com.esw.module.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDeleteService {

    private ProductRepository productRepository;

    @Autowired
    public ProductDeleteService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void deleteProductById(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);  // ID에 해당하는 엔티티 삭제
        } else {
            throw new IllegalArgumentException("ID에 해당하는 품목이 존재하지 않습니다.");
        }
    }
}

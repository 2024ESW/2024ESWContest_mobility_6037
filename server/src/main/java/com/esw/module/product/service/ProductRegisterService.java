package com.esw.module.product.service;

import com.esw.module.member.entities.Member;
import com.esw.module.product.entities.Product;
import com.esw.module.product.entities.ProductRegisterRequestDTO;
import com.esw.module.product.repository.ProductRepository;
import com.esw.module.store.entities.Store;
import com.esw.module.store.repository.StoreRepository;
import com.esw.module.storescore.entities.StoreScore;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductRegisterService {

    private ProductRepository productRepository;
    private StoreRepository storeRepository;

    @Autowired
    public ProductRegisterService(
            ProductRepository productRepository,
            StoreRepository storeRepository
    ) {
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
    }

    @Transactional
    public Product registerProduct(ProductRegisterRequestDTO productInfo) {

        Store store = storeRepository.findById(productInfo.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("Store ID가 존재하지 않습니다."));

        Product newProduct = new Product(
                store,
                productInfo.getName(),
                productInfo.getPrice(),
                productInfo.getProductCategory()
        );

        Product product = productRepository.save(newProduct);

        // 엄격하게 하려면 반환 타입을 따로 지정해서 반환
        return product;
    }
}

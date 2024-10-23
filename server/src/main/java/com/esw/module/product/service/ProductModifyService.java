package com.esw.module.product.service;

import com.esw.module.member.entities.Member;
import com.esw.module.product.entities.Product;
import com.esw.module.product.entities.ProductModifyRequestDTO;
import com.esw.module.product.repository.ProductRepository;
import com.esw.module.store.entities.Store;
import com.esw.module.store.repository.StoreRepository;
import com.esw.module.storescore.entities.StoreScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductModifyService {

    private ProductRepository productRepository;
    private StoreRepository storeRepository;

    @Autowired
    public ProductModifyService(ProductRepository productRepository, StoreRepository storeRepository) {
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
    }

    @Transactional
    public void modifyProductById(Long id, ProductModifyRequestDTO productInfo) {

        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            // 받은 DTO에 따라 수정할 필드들을 업데이트
            if (productInfo.getStoreId() != null) {
                Store store = storeRepository.findById(productInfo.getStoreId())
                        .orElseThrow(() -> new IllegalArgumentException("Store ID가 존재하지 않습니다."));

                product.setStore(store);
            }
            if (productInfo.getName() != null) {
                product.setName(productInfo.getName());
            }
            if (productInfo.getPrice() != null) {
                product.setPrice(productInfo.getPrice());
            }
            if (productInfo.getProductCategory() != null) {
                product.setProductCategory(productInfo.getProductCategory());
            }

        } else {
            throw new IllegalArgumentException("ID에 해당하는 품목이 존재하지 않습니다.");
        }

    }
}

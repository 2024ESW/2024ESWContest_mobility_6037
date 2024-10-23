package com.esw.module.product.controller;

import com.esw.module.ResponseMessage;
import com.esw.module.product.entities.Product;
import com.esw.module.product.entities.ProductFindResponseDTO;
import com.esw.module.product.entities.ProductModifyRequestDTO;
import com.esw.module.product.entities.ProductRegisterRequestDTO;
import com.esw.module.product.service.ProductDeleteService;
import com.esw.module.product.service.ProductFindService;
import com.esw.module.product.service.ProductModifyService;
import com.esw.module.product.service.ProductRegisterService;
import com.esw.module.storescore.entities.StoreScore;
import com.esw.module.storescore.entities.StoreScoreFindResponseDTO;
import com.esw.module.storescore.entities.StoreScoreModifyRequestDTO;
import com.esw.module.storescore.entities.StoreScoreRegisterRequestDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name="Product Controller", description = "Product CRUD")
@RestController
@RequestMapping("/v1/dev/entity")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductController {

    private List<ProductFindResponseDTO> FoundProducts;
    private ProductFindService productFindService;
    private ProductRegisterService productRegisterService;
    private ProductModifyService productModifyService;
    private ProductDeleteService productDeleteService;

    @Autowired
    public ProductController(
            List<ProductFindResponseDTO> FoundProducts,
            ProductFindService productFindService,
            ProductRegisterService productRegisterService,
            ProductModifyService productModifyService,
            ProductDeleteService productDeleteService
    ) {
        this.FoundProducts = FoundProducts;
        this.productFindService = productFindService;
        this.productRegisterService = productRegisterService;
        this.productModifyService = productModifyService;
        this.productDeleteService = productDeleteService;
    }

    @GetMapping("/products")
    public ResponseEntity<ResponseMessage> findAllProducts(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        FoundProducts = productFindService.findAllProducts();

        responseMap.put("products", FoundProducts);

        FoundProducts.forEach(System.out::println);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ResponseMessage> findProductById(@PathVariable("id") Long id){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        ProductFindResponseDTO foundProduct = productFindService.findProductById(id);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("product", foundProduct);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "조회 성공", responseMap));
    }

    @PostMapping("/products")
    public ResponseEntity<?> registerProduct(@RequestBody ProductRegisterRequestDTO newProduct){

        Product product = productRegisterService.registerProduct(newProduct);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/products/" + product.getId())) // 201 status code + URI of created Resource
                .build();
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity<?> modifyProduct(@PathVariable Long id, @RequestBody ProductModifyRequestDTO productInfo){

        productModifyService.modifyProductById(id, productInfo);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/products/" + id))
                .build();
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){

        productDeleteService.deleteProductById(id);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/products/" + id))
                .build();
    }
}

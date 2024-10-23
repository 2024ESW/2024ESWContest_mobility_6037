package com.esw.module.store.controller;

import com.esw.module.ResponseMessage;
import com.esw.module.pgcompany.entities.PgCompany;
import com.esw.module.pgcompany.entities.PgCompanyFindResponseDTO;
import com.esw.module.pgcompany.entities.PgCompanyRegisterRequestDTO;
import com.esw.module.store.entities.Store;
import com.esw.module.store.entities.StoreFindResponseDTO;
import com.esw.module.store.entities.StoreModifyRequestDTO;
import com.esw.module.store.entities.StoreRegisterRequestDTO;
import com.esw.module.store.service.StoreDeleteService;
import com.esw.module.store.service.StoreFindService;
import com.esw.module.store.service.StoreModifyService;
import com.esw.module.store.service.StoreRegisterService;
import io.swagger.v3.oas.annotations.Operation;
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

@Tag(name="Store Controller", description = "Store CRUD")
@RestController
@RequestMapping("/v1/dev/entity")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class StoreController {

    private List<StoreFindResponseDTO> FoundStores;
    private StoreFindService storeFindService;
    private StoreRegisterService storeRegisterService;
    private StoreModifyService storeModifyService;
    private StoreDeleteService storeDeleteService;

    @Autowired
    public StoreController(
            List<StoreFindResponseDTO> FoundStores,
            StoreFindService storeFindService,
            StoreRegisterService storeRegisterService,
            StoreModifyService storeModifyService,
            StoreDeleteService storeDeleteService
    ){
        this.FoundStores = FoundStores;
        this.storeFindService = storeFindService;
        this.storeRegisterService = storeRegisterService;
        this.storeModifyService = storeModifyService;
        this.storeDeleteService = storeDeleteService;
    }

    @GetMapping("/stores")
    public ResponseEntity<ResponseMessage> findAllStores(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        FoundStores = storeFindService.findAllStores();

        responseMap.put("stores", FoundStores);

        FoundStores.forEach(System.out::println);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/stores/{id}")
    public ResponseEntity<ResponseMessage> findStoreById(@PathVariable("id") Long id){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        StoreFindResponseDTO foundStore = storeFindService.findStoreById(id);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("store", foundStore);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "조회 성공", responseMap));
    }

    @PostMapping("/stores")
    public ResponseEntity<?> registerStore(@RequestBody StoreRegisterRequestDTO newStore){

        Store store = storeRegisterService.registerStore(newStore);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/stores/" + store.getId())) // 201 status code + URI of created Resource
                .build();
    }

    @PatchMapping("/stores/{id}")
    public ResponseEntity<?> modifyStore(@PathVariable Long id, @RequestBody StoreModifyRequestDTO storeInfo){

        storeModifyService.modifyStoreById(id, storeInfo);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/stores/" + id))
                .build();
    }

    @DeleteMapping("/stores/{id}")
    public ResponseEntity<?> deleteStore(@PathVariable Long id){

        storeDeleteService.deleteStoreById(id);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/stores/" + id))
                .build();
    }
}

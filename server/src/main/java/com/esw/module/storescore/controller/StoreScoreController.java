package com.esw.module.storescore.controller;

import com.esw.module.ResponseMessage;
import com.esw.module.store.entities.Store;
import com.esw.module.store.entities.StoreFindResponseDTO;
import com.esw.module.store.entities.StoreModifyRequestDTO;
import com.esw.module.store.entities.StoreRegisterRequestDTO;
import com.esw.module.storescore.entities.StoreScore;
import com.esw.module.storescore.entities.StoreScoreFindResponseDTO;
import com.esw.module.storescore.entities.StoreScoreModifyRequestDTO;
import com.esw.module.storescore.entities.StoreScoreRegisterRequestDTO;
import com.esw.module.storescore.service.StoreScoreDeleteService;
import com.esw.module.storescore.service.StoreScoreFindService;
import com.esw.module.storescore.service.StoreScoreModifyService;
import com.esw.module.storescore.service.StoreScoreRegisterService;
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

@Tag(name="Store Score Controller", description = "Store Score CRUD")
@RestController
@RequestMapping("/v1/dev/entity")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class StoreScoreController {

    private List<StoreScoreFindResponseDTO> FoundStoreScores;
    private StoreScoreFindService storeScoreFindService;
    private StoreScoreRegisterService storeScoreRegisterService;
    private StoreScoreModifyService storeScoreModifyService;
    private StoreScoreDeleteService storeScoreDeleteService;

    @Autowired
    public StoreScoreController(
            List<StoreScoreFindResponseDTO> FoundStoreScores,
            StoreScoreFindService storeScoreFindService,
            StoreScoreRegisterService storeScoreRegisterService,
            StoreScoreModifyService storeScoreModifyService,
            StoreScoreDeleteService storeScoreDeleteService
    ) {
        this.FoundStoreScores = FoundStoreScores;
        this.storeScoreFindService = storeScoreFindService;
        this.storeScoreRegisterService = storeScoreRegisterService;
        this.storeScoreModifyService = storeScoreModifyService;
        this.storeScoreDeleteService = storeScoreDeleteService;
    }

    @GetMapping("/store-scores")
    public ResponseEntity<ResponseMessage> findAllStoreScores(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        FoundStoreScores = storeScoreFindService.findAllStoreScores();

        responseMap.put("store scores", FoundStoreScores);

        FoundStoreScores.forEach(System.out::println);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/store-scores/{id}")
    public ResponseEntity<ResponseMessage> findStoreScoreById(@PathVariable("id") Long id){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        StoreScoreFindResponseDTO foundStoreScore = storeScoreFindService.findStoreById(id);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("store score", foundStoreScore);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "조회 성공", responseMap));
    }

    @PostMapping("/store-scores")
    public ResponseEntity<?> registerStoreScore(@RequestBody StoreScoreRegisterRequestDTO newStoreScore){

        StoreScore storeScore = storeScoreRegisterService.registerStoreScore(newStoreScore);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/store-scores/" + storeScore.getId())) // 201 status code + URI of created Resource
                .build();
    }

    @PatchMapping("/store-scores/{id}")
    public ResponseEntity<?> modifyStoreScore(@PathVariable Long id, @RequestBody StoreScoreModifyRequestDTO storeScoreInfo){

        storeScoreModifyService.modifyStoreScoreById(id, storeScoreInfo);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/store-scores/" + id))
                .build();
    }

    @DeleteMapping("/store-scores/{id}")
    public ResponseEntity<?> deleteStoreScore(@PathVariable Long id){

        storeScoreDeleteService.deleteStoreScoreById(id);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/store-scores/" + id))
                .build();
    }
}

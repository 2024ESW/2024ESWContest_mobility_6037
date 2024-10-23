package com.esw.module.cardcompany.controller;

import com.esw.module.ResponseMessage;
import com.esw.module.cardcompany.entities.CardCompany;
import com.esw.module.cardcompany.entities.CardCompanyFindResponseDTO;
import com.esw.module.cardcompany.entities.CardCompanyModifyRequestDTO;
import com.esw.module.cardcompany.entities.CardCompanyRegisterRequestDTO;
import com.esw.module.cardcompany.service.CardCompanyDeleteService;
import com.esw.module.cardcompany.service.CardCompanyFindService;
import com.esw.module.cardcompany.service.CardCompanyModifyService;
import com.esw.module.cardcompany.service.CardCompanyRegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Tag(name="Card Company Controller", description = "Card Company CRUD")
@RestController
@RequestMapping("/v1/dev/entity")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CardCompanyController {

    private List<CardCompanyFindResponseDTO> FoundCardCompanies;
    private CardCompanyFindService cardCompanyFindService;
    private CardCompanyRegisterService cardCompanyRegisterService;
    private CardCompanyModifyService cardCompanyModifyService;
    private CardCompanyDeleteService cardCompanyDeleteService;

    public CardCompanyController(
            List<CardCompanyFindResponseDTO> FoundCardCompanies,
            CardCompanyFindService cardCompanyFindService,
            CardCompanyRegisterService cardCompanyRegisterService,
            CardCompanyModifyService cardCompanyModifyService,
            CardCompanyDeleteService cardCompanyDeleteService
    ) {
        this.FoundCardCompanies = FoundCardCompanies;
        this.cardCompanyFindService = cardCompanyFindService;
        this.cardCompanyRegisterService = cardCompanyRegisterService;
        this.cardCompanyModifyService = cardCompanyModifyService;
        this.cardCompanyDeleteService = cardCompanyDeleteService;
    }

    @GetMapping("/card-companies")
    @Operation(summary = "find card company list", description = "find all card company")
    public ResponseEntity<ResponseMessage> findAllCardCompanies(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        FoundCardCompanies = cardCompanyFindService.findAllCardCompanies();

        responseMap.put("cardCompanies", FoundCardCompanies);

        FoundCardCompanies.forEach(System.out::println);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/card-companies/{id}")
    public ResponseEntity<ResponseMessage> findCardCompanyById(@PathVariable("id") Long id){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        CardCompanyFindResponseDTO foundCardCompany = cardCompanyFindService.findCardCompanyById(id);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("cardCompany", foundCardCompany);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "조회 성공", responseMap));
    }

    @PostMapping("/card-companies")
    public ResponseEntity<?> registerCardCompany(@RequestBody CardCompanyRegisterRequestDTO newCardCompany){

        CardCompany cardCompany = cardCompanyRegisterService.registerCardCompany(newCardCompany);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/card-companies/" + cardCompany.getId())) // 201 status code + URI of created Resource
                .build();
    }

    @PutMapping("/card-companies/{id}")
    public ResponseEntity<?> modifyCardCompany(@PathVariable Long id, @RequestBody CardCompanyModifyRequestDTO cardCompanyModifyRequestDTO){

        //CardCompanyFindResponseDTO foundCardCompany = cardCompanyFindService.findCardCompanyById(id);

        //foundCardCompany.setName(newName);

        cardCompanyModifyService.modifyCardCompanyById(id, cardCompanyModifyRequestDTO);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/card-companies/" + id))
                .build();
    }

    @DeleteMapping("/card-companies/{id}")
    public ResponseEntity<?> deleteCardCompany(@PathVariable Long id){

        cardCompanyDeleteService.deleteCardCompanyById(id);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/card-companies/" + id))
                .build();
    }


}

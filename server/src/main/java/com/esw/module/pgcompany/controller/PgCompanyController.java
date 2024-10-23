package com.esw.module.pgcompany.controller;

import com.esw.module.ResponseMessage;
import com.esw.module.cardcompany.entities.CardCompany;
import com.esw.module.cardcompany.entities.CardCompanyFindResponseDTO;
import com.esw.module.cardcompany.entities.CardCompanyModifyRequestDTO;
import com.esw.module.cardcompany.entities.CardCompanyRegisterRequestDTO;
import com.esw.module.pgcompany.entities.PgCompany;
import com.esw.module.pgcompany.entities.PgCompanyFindResponseDTO;
import com.esw.module.pgcompany.entities.PgCompanyModifyRequestDTO;
import com.esw.module.pgcompany.entities.PgCompanyRegisterRequestDTO;
import com.esw.module.pgcompany.service.PgCompanyDeleteService;
import com.esw.module.pgcompany.service.PgCompanyFindService;
import com.esw.module.pgcompany.service.PgCompanyModifyService;
import com.esw.module.pgcompany.service.PgCompanyRegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name="PG Company Controller", description = "PG Company CRUD")
@RestController
@RequestMapping("/v1/dev/entity")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PgCompanyController {

    private List<PgCompanyFindResponseDTO> FoundPgCompanies;
    private PgCompanyFindService pgCompanyFindService;
    private PgCompanyRegisterService pgCompanyRegisterService;
    private PgCompanyModifyService pgCompanyModifyService;
    private PgCompanyDeleteService pgCompanyDeleteService;

    public PgCompanyController(
        List<PgCompanyFindResponseDTO> FoundPgCompanies,
        PgCompanyFindService pgCompanyFindService,
        PgCompanyRegisterService pgCompanyRegisterService,
        PgCompanyModifyService pgCompanyModifyService,
        PgCompanyDeleteService pgCompanyDeleteService
    ){
        this.FoundPgCompanies = FoundPgCompanies;
        this.pgCompanyFindService = pgCompanyFindService;
        this.pgCompanyRegisterService = pgCompanyRegisterService;
        this.pgCompanyModifyService = pgCompanyModifyService;
        this.pgCompanyDeleteService = pgCompanyDeleteService;
    }

    @GetMapping("/pg-companies")
    @Operation(summary = "find pg company list", description = "find all pg company")
    public ResponseEntity<ResponseMessage> findAllPgCompanies(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        FoundPgCompanies = pgCompanyFindService.findAllPgCompanies();

        responseMap.put("pgCompanies", FoundPgCompanies);

        FoundPgCompanies.forEach(System.out::println);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/pg-companies/{id}")
    public ResponseEntity<ResponseMessage> findPgCompanyById(@PathVariable("id") Long id){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        PgCompanyFindResponseDTO foundPgCompany = pgCompanyFindService.findPgCompanyById(id);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("pgCompany", foundPgCompany);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "조회 성공", responseMap));
    }

    @PostMapping("/pg-companies")
    public ResponseEntity<?> registerPgCompany(@RequestBody PgCompanyRegisterRequestDTO newPgCompany){

        PgCompany pgCompany = pgCompanyRegisterService.registerPgCompany(newPgCompany);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/pg-companies/" + pgCompany.getId())) // 201 status code + URI of created Resource
                .build();
    }

    @PutMapping("/pg-companies/{id}")
    public ResponseEntity<?> modifyPgCompany(@PathVariable Long id, @RequestBody PgCompanyModifyRequestDTO pgCompanyModifyRequestDTO){

        pgCompanyModifyService.modifyPgCompanyById(id, pgCompanyModifyRequestDTO);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/pg-companies/" + id))
                .build();
    }

    @DeleteMapping("/pg-companies/{id}")
    public ResponseEntity<?> deletePgCompany(@PathVariable Long id){

        pgCompanyDeleteService.deletePgCompanyById(id);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/pg-companies/" + id))
                .build();
    }
}

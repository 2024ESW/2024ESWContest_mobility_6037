package com.esw.module.paymentdetail.controller;

import com.esw.module.ResponseMessage;
import com.esw.module.paymentdetail.entities.PaymentDetail;
import com.esw.module.paymentdetail.entities.PaymentDetailFindResponseDTO;
import com.esw.module.paymentdetail.entities.PaymentDetailModifyRequestDTO;
import com.esw.module.paymentdetail.entities.PaymentDetailRegisterRequestDTO;
import com.esw.module.paymentdetail.service.PaymentDetailDeleteService;
import com.esw.module.paymentdetail.service.PaymentDetailFindService;
import com.esw.module.paymentdetail.service.PaymentDetailModifyService;
import com.esw.module.paymentdetail.service.PaymentDetailRegisterService;
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

@Tag(name="Payment Detail Controller", description = "Payment Detail CRUD")
@RestController
@RequestMapping("/v1/dev/entity")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PaymentDetailController {

    private List<PaymentDetailFindResponseDTO> FoundPaymentDetails;
    private PaymentDetailFindService paymentDetailFindService;
    private PaymentDetailRegisterService paymentDetailRegisterService;
    private PaymentDetailModifyService paymentDetailModifyService;
    private PaymentDetailDeleteService paymentDetailDeleteService;

    @Autowired
    public PaymentDetailController(
            List<PaymentDetailFindResponseDTO> FoundPaymentDetails,
            PaymentDetailFindService paymentDetailFindService,
            PaymentDetailRegisterService paymentDetailRegisterService,
            PaymentDetailModifyService paymentDetailModifyService,
            PaymentDetailDeleteService paymentDetailDeleteService
    ){
        this.FoundPaymentDetails = FoundPaymentDetails;
        this.paymentDetailFindService = paymentDetailFindService;
        this.paymentDetailRegisterService = paymentDetailRegisterService;
        this.paymentDetailModifyService = paymentDetailModifyService;
        this.paymentDetailDeleteService = paymentDetailDeleteService;
    }

    @GetMapping("/payment-details")
    public ResponseEntity<ResponseMessage> findAllPaymentDetails(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        FoundPaymentDetails = paymentDetailFindService.findAllPaymentDetails();

        responseMap.put("payment details", FoundPaymentDetails);

        FoundPaymentDetails.forEach(System.out::println);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/payment-details/{id}")
    public ResponseEntity<ResponseMessage> findPaymentDetailById(@PathVariable("id") Long id){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        PaymentDetailFindResponseDTO foundPaymentDetail = paymentDetailFindService.findPaymentDetailById(id);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("payment detail", foundPaymentDetail);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "조회 성공", responseMap));
    }

    @PostMapping("/payment-details")
    public ResponseEntity<?> registerPaymentDetail(@RequestBody PaymentDetailRegisterRequestDTO newPaymentDetail){

        PaymentDetail paymentDetail = paymentDetailRegisterService.registerPaymentDetail(newPaymentDetail);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/payment-details/" + paymentDetail.getId())) // 201 status code + URI of created Resource
                .build();
    }

    @PatchMapping("/payment-details/{id}")
    public ResponseEntity<?> modifyPaymentDetail(@PathVariable("id") Long id, @RequestBody PaymentDetailModifyRequestDTO paymentDetailInfo){
        paymentDetailModifyService.modifyPaymentDetailById(id, paymentDetailInfo);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/payment-details/" + id))
                .build();
    }

    @DeleteMapping("/payment-details/{id}")
    public ResponseEntity<?> deletePaymentDetail(@PathVariable Long id){

        paymentDetailDeleteService.deletePaymentDetailById(id);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/payment-details/" + id))
                .build();
    }
}

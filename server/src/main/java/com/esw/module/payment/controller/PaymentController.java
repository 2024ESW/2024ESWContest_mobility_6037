package com.esw.module.payment.controller;

import com.esw.module.ResponseMessage;
import com.esw.module.payment.entities.Payment;
import com.esw.module.payment.entities.PaymentFindResponseDTO;
import com.esw.module.payment.entities.PaymentModifyRequestDTO;
import com.esw.module.payment.entities.PaymentRegisterRequestDTO;
import com.esw.module.payment.service.PaymentDeleteService;
import com.esw.module.payment.service.PaymentFindService;
import com.esw.module.payment.service.PaymentModifyService;
import com.esw.module.payment.service.PaymentRegisterService;
import com.esw.module.product.entities.ProductFindResponseDTO;
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

@Tag(name="Payment Controller", description = "Payment CRUD")
@RestController
@RequestMapping("/v1/dev/entity")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PaymentController {

    private List<PaymentFindResponseDTO> FoundPayments;
    private PaymentFindService paymentFindService;
    private PaymentRegisterService paymentRegisterService;
    private PaymentModifyService paymentModifyService;
    private PaymentDeleteService paymentDeleteService;

    @Autowired
    public PaymentController (
            List<PaymentFindResponseDTO> FoundPayments,
            PaymentFindService paymentFindService,
            PaymentRegisterService paymentRegisterService,
            PaymentModifyService paymentModifyService,
            PaymentDeleteService paymentDeleteService
    ){
        this.FoundPayments = FoundPayments;
        this.paymentFindService = paymentFindService;
        this.paymentRegisterService = paymentRegisterService;
        this.paymentModifyService = paymentModifyService;
        this.paymentDeleteService = paymentDeleteService;
    }

    @GetMapping("/payments")
    public ResponseEntity<ResponseMessage> findAllPayments(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        FoundPayments = paymentFindService.findAllPayments();

        responseMap.put("payments", FoundPayments);

        FoundPayments.forEach(System.out::println);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/payments/{id}")
    public ResponseEntity<ResponseMessage> findPaymentById(@PathVariable("id") Long id){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        PaymentFindResponseDTO foundPayment = paymentFindService.findPaymentById(id);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("payment", foundPayment);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "조회 성공", responseMap));
    }

    @PostMapping("/payments")
    public ResponseEntity<?> registerPayment(@RequestBody PaymentRegisterRequestDTO newPayment){

        Payment payment = paymentRegisterService.registerPayment(newPayment);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/payments/" + payment.getId())) // 201 status code + URI of created Resource
                .build();
    }

    @PatchMapping("/payments/{id}")
    public ResponseEntity<?> modifyPayment(@PathVariable("id") Long id, @RequestBody PaymentModifyRequestDTO paymentInfo){
        paymentModifyService.modifyPaymentById(id, paymentInfo);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/payments/" + id))
                .build();
    }

    @DeleteMapping("/payments/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable Long id){

        paymentDeleteService.deletePaymentById(id);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/payments/" + id))
                .build();
    }
}

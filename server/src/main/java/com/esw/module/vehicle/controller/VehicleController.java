package com.esw.module.vehicle.controller;

import com.esw.module.ResponseMessage;
import com.esw.module.store.entities.Store;
import com.esw.module.store.entities.StoreFindResponseDTO;
import com.esw.module.store.entities.StoreModifyRequestDTO;
import com.esw.module.store.entities.StoreRegisterRequestDTO;
import com.esw.module.vehicle.entities.Vehicle;
import com.esw.module.vehicle.entities.VehicleFindResponseDTO;
import com.esw.module.vehicle.entities.VehicleModifyRequestDTO;
import com.esw.module.vehicle.entities.VehicleRegisterRequestDTO;
import com.esw.module.vehicle.service.VehicleDeleteService;
import com.esw.module.vehicle.service.VehicleFindService;
import com.esw.module.vehicle.service.VehicleModifyService;
import com.esw.module.vehicle.service.VehicleRegisterService;
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

@Tag(name="Vehicle Controller", description = "Vehicle CRUD")
@RestController
@RequestMapping("/v1/dev/entity")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class VehicleController {

    private List<VehicleFindResponseDTO> FoundVehicles;
    private VehicleFindService vehicleFindService;
    private VehicleRegisterService vehicleRegisterService;
    private VehicleModifyService vehicleModifyService;
    private VehicleDeleteService vehicleDeleteService;

    @Autowired
    public VehicleController(
            List<VehicleFindResponseDTO> FoundVehicles,
            VehicleFindService vehicleFindService,
            VehicleRegisterService vehicleRegisterService,
            VehicleModifyService vehicleModifyService,
            VehicleDeleteService vehicleDeleteService
    ) {
        this.FoundVehicles = FoundVehicles;
        this.vehicleFindService = vehicleFindService;
        this.vehicleRegisterService = vehicleRegisterService;
        this.vehicleModifyService = vehicleModifyService;
        this.vehicleDeleteService = vehicleDeleteService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<ResponseMessage> findAllVehicles(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Map<String, Object> responseMap = new HashMap<>();

        FoundVehicles = vehicleFindService.findAllVehicles();

        responseMap.put("vehicles", FoundVehicles);

        FoundVehicles.forEach(System.out::println);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공", responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.OK);
    }

    @GetMapping("/vehicles/{id}")
    public ResponseEntity<ResponseMessage> findVehicleById(@PathVariable("id") Long id){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        VehicleFindResponseDTO foundVehicle = vehicleFindService.findVehicleById(id);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("vehicle", foundVehicle);

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseMessage(200, "조회 성공", responseMap));
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> registerVehicle(@RequestBody VehicleRegisterRequestDTO newVehicle){

        Vehicle vehicle = vehicleRegisterService.registerVehicle(newVehicle);
        return ResponseEntity
                .created(URI.create("/v1/dev/entity/vehicles/" + vehicle.getId())) // 201 status code + URI of created Resource
                .build();
    }

    @PatchMapping("/vehicles/{id}")
    public ResponseEntity<?> modifyVehicle(@PathVariable Long id, @RequestBody VehicleModifyRequestDTO vehicleInfo){

        vehicleModifyService.modifyVehicleById(id, vehicleInfo);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/vehicles/" + id))
                .build();
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){

        vehicleDeleteService.deleteVehicleById(id);

        return ResponseEntity
                .created(URI.create("/v1/dev/entity/vehicles/" + id))
                .build();
    }
}

package com.shototech.healthcare.system.api;

import com.shototech.healthcare.system.dto.request.RequestDoctorDto;
import com.shototech.healthcare.system.service.DoctorService;
import com.shototech.healthcare.system.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<StandardResponse> createDoctor(@RequestBody RequestDoctorDto doctorDto){
        doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Doctor was saved!",doctorDto.getName()),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> findDoctor(@PathVariable long id){
        return new ResponseEntity<>(
                new StandardResponse(200,"Doctor data",doctorService.getDoctor(id)),
                HttpStatus.CREATED
        );
    }

    @PutMapping(params = "id")
    public ResponseEntity<StandardResponse> updateDoctor(
            @RequestParam long id,
            @RequestBody RequestDoctorDto doctorDto
    ){
        doctorService.updateDoctor(id,doctorDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Update data",doctorDto.getName()),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteDoctor(@PathVariable long id){
        doctorService.deleteDoctor(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"Deleted data",id),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping(path = "/list",params = {"searchText","page","size"})
    public ResponseEntity<StandardResponse> findAllDoctor(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(200,"Data List!",doctorService.getAllDoctors(
                        searchText,page,size)),
                HttpStatus.OK
        );
    }

}

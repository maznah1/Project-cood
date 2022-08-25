package com.example.pro1b.Controller;


import com.example.pro1b.Model.MobileMaintenance;
import com.example.pro1b.Model.Users;
import com.example.pro1b.Service.ServiceMobile;
import com.example.pro1b.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/MobileMaintenance")
public class ControlerMobileMaintenance {
    private final ServiceMobile serviceMobile;

    @GetMapping("/Get")
    public ResponseEntity getmobile(@AuthenticationPrincipal Users users) {
        return ResponseEntity.status(200).body(serviceMobile.getMoblie(users));
    }

    @PostMapping
    public ResponseEntity addMobile(@RequestBody MobileMaintenance mobileMaintenance, @AuthenticationPrincipal Users users) {
        serviceMobile.addMobile(mobileMaintenance, users);
        return ResponseEntity.status(201).body(new ApiResponse("DONE", 201));
    }

   @PutMapping("/Problem/{problem}")
    public ResponseEntity <ApiResponse> updateProblem(@PathVariable String problem,@RequestBody MobileMaintenance mobileMaintenance){
        serviceMobile.updateProblem(mobileMaintenance,problem);
        return ResponseEntity.status(201).body(new ApiResponse("update problem done ",201));
}
   @DeleteMapping("/delet/{id}")
    public ResponseEntity <ApiResponse>deleteUser(@PathVariable Integer id ){
        serviceMobile.deleteUser(id);
        return ResponseEntity.status(201).body(new ApiResponse("delet",201));
}

    @PostMapping("/Evaluation/{id}")
    private ResponseEntity enterEvaluation (@PathVariable Integer id,@RequestBody Integer ev) {

        serviceMobile.enterEvaluation1(id,ev);
        return ResponseEntity.status(201).body(new ApiResponse("Evaluation done", 201));
    }
    }

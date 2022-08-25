package com.example.pro1b.Controller;

import com.example.pro1b.Model.MakingSuggestions;
import com.example.pro1b.Model.MobileMaintenance;
import com.example.pro1b.Model.Users;
import com.example.pro1b.Service.ServiceMakingSug;
import com.example.pro1b.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/MakingSuggestions")
public class ControlerMakingSug {
   private final ServiceMakingSug serviceMakingSug;

   @GetMapping("/GetSuqqestions")

   public ResponseEntity getSuqqestions(@AuthenticationPrincipal Users users){

      return ResponseEntity.status(200).body(serviceMakingSug.getSuqqestions(users));
   }

   @PostMapping
   public ResponseEntity addSuggestions(@RequestBody MakingSuggestions makingSuggestions,@AuthenticationPrincipal Users users){
      serviceMakingSug.addSuggestions(makingSuggestions, users);
      return ResponseEntity.status(201).body(new ApiResponse("Thank you:) ",201));
   }
@PutMapping("/Suqqestions/{suggestions}")
   private ResponseEntity<ApiResponse>updatesuggestions(@PathVariable String suggestions,@RequestBody MakingSuggestions makingSuggestions){

      serviceMakingSug.updatesuggestions(makingSuggestions,suggestions);
   return ResponseEntity.status(201).body(new ApiResponse("update",201));

}
@DeleteMapping("/delet/{id}")

   public ResponseEntity<ApiResponse>deletsuggestions(@PathVariable Integer id){

      serviceMakingSug.deletsuggestions(id);
   return ResponseEntity.status(201).body(new ApiResponse("delet",201));

}


}

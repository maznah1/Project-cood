package com.example.pro1b.Service;


import com.example.pro1b.Model.MakingSuggestions;
import com.example.pro1b.Model.MobileMaintenance;
import com.example.pro1b.Model.Users;
import com.example.pro1b.Repository.MakingSugRepository;
import com.example.pro1b.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceMakingSug {

    public final MakingSugRepository makingSugRepository;

    public List<MakingSuggestions>getSuqqestions(Users users){

        return makingSugRepository.findByUserId(users.getId());

    }

    public void addSuggestions(MakingSuggestions makingSuggestions, Users users) {
        makingSuggestions.setUserId(users.getId());
        makingSugRepository.save(makingSuggestions);
    }

    public void updatesuggestions(MakingSuggestions makingSuggestions, String suggestions) {
        MakingSuggestions  suggestions1=makingSugRepository.getReferenceById(makingSuggestions.getId());
        suggestions1.setSuggestions(suggestions);
        makingSugRepository.save(suggestions1);
    }

    public void deletsuggestions(Integer id) {

        MakingSuggestions Suggestionn = makingSugRepository.getById(id);
        makingSugRepository.delete(Suggestionn);

    }


}

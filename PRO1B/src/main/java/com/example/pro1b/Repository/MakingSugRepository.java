package com.example.pro1b.Repository;


import com.example.pro1b.Model.MakingSuggestions;
import com.example.pro1b.Model.MobileMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakingSugRepository extends JpaRepository<MakingSuggestions,Integer> {

    List<MakingSuggestions>findByUserId(Integer id);

}

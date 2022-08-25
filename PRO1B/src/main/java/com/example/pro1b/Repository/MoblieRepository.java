package com.example.pro1b.Repository;

import com.example.pro1b.Model.MobileMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoblieRepository extends JpaRepository<MobileMaintenance,Integer> {
    List<MobileMaintenance>findByUserId(Integer id);
    MobileMaintenance findByProblem(String problem);




}

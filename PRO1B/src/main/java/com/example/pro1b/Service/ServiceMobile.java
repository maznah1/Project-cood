package com.example.pro1b.Service;


import com.example.pro1b.Model.MobileMaintenance;
import com.example.pro1b.Model.Users;
import com.example.pro1b.Repository.MoblieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceMobile {

    public final MoblieRepository moblieRepository;

    public List<MobileMaintenance> getMoblie (Users users){
        return moblieRepository.findByUserId(users.getId());
    }
    public void addMobile(MobileMaintenance mobileMaintenance,Users users) {
        mobileMaintenance.setUserId(users.getId());
       moblieRepository.save(mobileMaintenance);
    }
    public void updateProblem(MobileMaintenance mobileMaintenance,String problem){

        MobileMaintenance Problem1= moblieRepository.getReferenceById(mobileMaintenance.getId());
        Problem1.setProblem(problem);
        moblieRepository.save(Problem1);
    }

    public void deleteUser(Integer id) {
        MobileMaintenance mobile = moblieRepository.getById(id);
        moblieRepository.delete(mobile);
    }


    public void enterEvaluation1(Integer id,Integer ev) {
        MobileMaintenance mobileMaintenance=moblieRepository.getById(id);
        mobileMaintenance.setEvaluation(ev);
        moblieRepository.save(mobileMaintenance);

    }


}

package com.example.pro1b.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor
@Data
@Entity
public class MobileMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @NotEmpty(message = "Please write your problem")
    @Column(columnDefinition = "varchar(120) unique not null")
    private String problem;

    @NotEmpty(message = "Please write your  MobileType")
    @Column(columnDefinition = "varchar(20) not null")
    private String mobiletype;

    @NotEmpty(message = "Please write your MobileVersion")
    @Column(columnDefinition = "varchar(20) not null")
    private String mobileversion;

    @NotEmpty(message = "Please write your HomeAddress")
    @Column(columnDefinition = "varchar(80) not null")
    private String homeaddress;

    @NotEmpty(message = "Please write Day ")
    @Column(columnDefinition = "varchar(20) not null")
    private String day;

    //private String time;

    @NotNull
    private Integer Evaluation=0;

   private Integer userId;


}

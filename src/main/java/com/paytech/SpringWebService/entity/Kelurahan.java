
package com.paytech.SpringWebService.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;


@Data
@Entity @Table(name = "kelurahan")
public class Kelurahan {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull @NotEmpty
    private String kode;
    
    @NotNull @NotEmpty
    private String nama;
    
    @NotNull @NotEmpty
    private String kodepos;
    
}

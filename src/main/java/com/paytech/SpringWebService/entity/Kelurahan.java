
package com.paytech.SpringWebService.entity;

import javax.persistence.Column;
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
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    
    @NotNull @NotEmpty
    @Column(name = "kode")
    private String kode;
    
    @NotNull @NotEmpty
    @Column(name = "nama")
    private String nama;
    
    @NotNull @NotEmpty
    @Column(name = "kodepos")
    private String kodepos;
    
}

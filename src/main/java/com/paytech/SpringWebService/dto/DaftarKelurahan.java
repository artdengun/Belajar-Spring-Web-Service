/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paytech.SpringWebService.dto;

import com.paytech.SpringWebService.entity.Kelurahan;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author denigunawan
 */

@Data
public class DaftarKelurahan {
    private List<Kelurahan> kelurahan = new ArrayList<>();
}

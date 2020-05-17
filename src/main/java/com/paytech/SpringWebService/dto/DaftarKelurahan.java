
package com.paytech.SpringWebService.dto;

import com.paytech.SpringWebService.entity.Kelurahan;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;


@Data
public class DaftarKelurahan {
    private List<Kelurahan> kelurahan = new ArrayList<>();
}

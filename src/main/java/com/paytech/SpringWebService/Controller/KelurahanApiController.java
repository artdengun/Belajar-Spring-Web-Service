
package com.paytech.SpringWebService.Controller;

import com.paytech.SpringWebService.dao.KelurahanDao;
import com.paytech.SpringWebService.entity.Kelurahan;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KelurahanApiController {
    @Autowired
    private KelurahanDao kelurahanDao;
    
    @GetMapping("/api/kelurahan")
    @ResponseBody
    public Page<Kelurahan> dataKelurahan(Pageable page){
        return kelurahanDao.findAll(page);
    }
}

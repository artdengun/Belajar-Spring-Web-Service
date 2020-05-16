package com.paytech.SpringWebService.Controller;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WaktuController {
  
    @GetMapping("/waktu")
    @ResponseBody
    public String sekarang(){
       SimpleDateFormat formatwaktu = new SimpleDateFormat("EEEE, dd MMMM yyyy",new Locale("id","ID"));
       return formatwaktu.format(new Date());
    }
    
    @GetMapping("/appinfo")
    @ResponseBody
    public Map<String, String> info(@RequestParam String nama){
        Map<String, String> data = new LinkedHashMap<>();
        
        data.put("application.name", "Aplikasi SIUP");
        data.put("application.version","1.0.0");
        data.put("last.update", "2020-05-10");
        data.put("author", nama);       
        return data;
    }
}



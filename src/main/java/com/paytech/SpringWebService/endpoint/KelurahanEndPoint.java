/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paytech.SpringWebService.endpoint;

import com.paytech.SpringWebService.dao.KelurahanDao;
import com.paytech.SpringWebService.dto.DaftarKelurahan;
import com.paytech.SpringWebService.dto.DaftarKelurahanRequest;
import com.paytech.SpringWebService.dto.DaftarKelurahanResponse;
import com.paytech.SpringWebService.entity.Kelurahan;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class KelurahanEndPoint {
    
    
    @Autowired private KelurahanDao kelurahanDao;
    
    
    public List<Kelurahan> cari(String nama){
           Iterable<Kelurahan> dataKelurahan = kelurahanDao.findAll();
           
           
         List<Kelurahan> hasil = new ArrayList<>();    
            for(Kelurahan k : dataKelurahan){
                hasil.add(k);
            }
            return hasil;
    }
   
    @PayloadRoot(localPart = "daftarKelurahanRequest", namespace = "http://paytech.com/webservices/siup")
    @ResponsePayload
    public DaftarKelurahanResponse cariKelurahan(@RequestPayload DaftarKelurahanRequest Request){
            String cariNama= Request.getPencarian().getNama();
            System.out.println("Mencari Kelurahan Dengan nama " + cariNama);
            
            DaftarKelurahanResponse resp = new DaftarKelurahanResponse();
            DaftarKelurahan soapBody = new DaftarKelurahan();
            soapBody.setKelurahan(cari(cariNama));
            resp.setDaftarKelurahan(soapBody);
            return resp;
    
    }
            
 }

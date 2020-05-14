/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paytech.SpringWebService.endpoint;

import generated.DaftarKelurahan;
import generated.DaftarKelurahanRequest;
import generated.DaftarKelurahanResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import generated.Kelurahan;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
/**
 *
 * @author denigunawan
 */
@Endpoint
public class KelurahanEndPoint {
    public List<Kelurahan> cari(String nama){
            List<Kelurahan> hasil = new ArrayList<>();
          
            Kelurahan k1 = new Kelurahan();
            k1.setId(new BigInteger("1"));
            k1.setKode("k-001");
            k1.setNama(nama);
            k1.setKodepos(new BigInteger("17426"));
            hasil.add(k1);
            
            
            Kelurahan k2 = new Kelurahan();
            k2.setId(new BigInteger("2"));
            k2.setKode("k-002");
            k2.setNama(nama);
            k2.setKodepos(new BigInteger("17427"));
            hasil.add(k2);
            
            Kelurahan k3 = new Kelurahan();
            k3.setId(new BigInteger("3"));
            k3.setKode("k-003");
            k3.setNama(nama);
            k3.setKodepos(new BigInteger("17428"));
            hasil.add(k1);
            
            
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

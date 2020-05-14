package com.paytech.SpringWebService;

import java.util.Scanner;

public class Pengulangan {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    String nama;
    String nilai;
    char hasil = 'A';
    
    System.out.print("Masukkan Nama  Lengkap : " );
    nama = input.nextLine();
    System.out.print("Masukkan nilai: ");
    nilai = input.nextLine();
    
    if (hasil=='A'){
        System.out.println("Kualitas Nilai dari, "+ nama + " Adalah" );
        System.out.println("Sangat Memuaskan!");
    }else if (hasil=='B'){
        System.out.println("Kualitas Nilai dari, "+nama + " Adalah");
        System.out.println("Memuaskan!");
    }else if (hasil=='C'){
        System.out.println("Kualitas Nilai dari, "+nama + " Adalah");
        System.out.println("Cukup");
    }else if (hasil=='D'){
        System.out.println("Kualitas Nilai dari, "+nama + " Adalah");
        System.out.println("Kurang");
    }else if (hasil=='E'){
        System.out.println("Kualitas Nilai dari, "+nama + "Adalah");
        System.out.println("sangat Kurang");
    }else{
        System.out.println(" Nilai Tidak ada  Kosong ");
    }
     
  } 

}
    

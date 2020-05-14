
import java.util.Scanner;


public class MenghitungKerucut {
     public static void main(String[] args) {
         Scanner input = new Scanner(System.in);
        System.out.println("Volume dan Luas Kerucut");
        System.out.print("jari-jari : ");
        int r = input.nextInt();
        System.out.print("garis pelukis : ");
        int s = input.nextInt();
        System.out.print("tinggi : ");
        int t = input.nextInt();
        double pi = 3.14;
        double luas_alas = 3.14 * r * r;
        System.out.print("Luas alas : " + (luas_alas) + "\n");
        System.out.print("Luas selimut : " + (pi * r * s) + "\n");
        System.out.print("Luas permukaan : " + (pi * r * (r + s)) + "\n");
        System.out.println("Volume : " + (luas_alas * t * 1 / 3));
    }
}
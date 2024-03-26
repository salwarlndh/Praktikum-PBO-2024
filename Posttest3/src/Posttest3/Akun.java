package Posttest3;

import java.io.*;
import java.util.*;

public abstract class Akun {
    protected String username, password, nama, jenisKelamin;
    protected InputStreamReader p = new InputStreamReader(System.in);
    protected BufferedReader input = new BufferedReader(p);
    protected int pilih;
    protected static int banyak = 0;
    
    public Akun(String username, String password, String nama, String jenisKelamin){
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        p = new InputStreamReader(System.in);
        input = new BufferedReader(p);
        banyak++;
    }

    protected int error_int() throws IOException{
        int masukkan_integer = 0;
         while(true){
             try{
                 masukkan_integer = Integer.parseInt(input.readLine());
                 break;
             }catch(NumberFormatException  e){
                 System.err.print("\tInputan harus Integer >> ");
             }
         }
         return masukkan_integer;
     }

     protected static boolean ulang(String message){
        Scanner pilihan = new Scanner(System.in);
        System.out.print("\n"+message+" [y/n] >> ");
        String pilihan_user = pilihan.next();

        while(!pilihan_user.equalsIgnoreCase("y") && !pilihan_user.equalsIgnoreCase("n")){
            System.err.println("----------------------------");
            System.err.println("         Only Y / N         ");
            System.err.println("----------------------------");
            System.out.print("\n"+message+" [y/n] >>> ");
            pilihan_user = pilihan.next();
        }
        return pilihan_user.equalsIgnoreCase("y");
    }

    protected void profile(){
        System.out.println("Username        >> " + this.username);
        System.out.println("Nama            >> " + this.nama);
        System.out.println("Jenis Kelamin   >> " + this.jenisKelamin);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getNama(){
        return nama;
    }

    public String getJenisKelamin(){
        return jenisKelamin;
    }
}
package Posttest3;

import java.io.*;
import java.util.*;

public class Main {
    public int batasan;
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    private static ArrayList<User> DataUser = new ArrayList<>();
    private static ArrayList<Agent> agent = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // static akun user dan admin
        Admin Admin1 = new Admin("ryoiswsant", "230523", "yansa", "Laki-laki", "Admin", DataUser, agent);

        while (true) {
            clear();
            System.out.println("\t|-------------------------|");
            System.out.println("\t|      Agent Valorant     |");
            System.out.println("\t|-------------------------|");
            System.out.println("\t| 1. | Daftar             |");
            System.out.println("\t| 2. | Login              |");
            System.out.println("\t| 3. | Exit               |");
            System.out.println("\t|-------------------------|");
            System.out.print("\n\t| Enter your choice : ");
            int pilih = error_int();
            switch(pilih){
                case 1:
                    clear();
                    String jenisKelamin = null;
                    System.out.println("-----------------------------");
                    System.out.println("         Daftar Akun         ");
                    System.out.println("-----------------------------");
                    System.out.print("| Enter username : ");
                    String user = input.readLine();
                    System.out.print("| Enter password : ");
                    String pass = input.readLine();
                    System.out.print("| Enter name     : ");
                    String nama = input.readLine();
                    System.out.println("-----------------------------");                    
                    System.out.println(" 1.| Laki-laki               ");
                    System.out.println(" 2.| Perempuan               ");
                    System.out.println("-----------------------------");                    
                    System.out.print("| Enter your choice : ");
                    int pilihan = error_int();
                    if(pilihan == 1){
                        jenisKelamin = "Laki-laki"; 
                    }
                    else if(pilihan == 2){
                        jenisKelamin = "Perempuan";
                    }
                    else{
                        System.out.println("Gender hanya 2");
                        jenisKelamin = null;
                    }
                    User new_user = new User(user, pass, nama, jenisKelamin, "User", agent);
                    DataUser.add(new_user);
                    System.out.println("-------------------------------");
                    System.out.println("    Data successfully added    ");
                    System.out.println("-------------------------------");
                    System.out.println("");
                    System.out.println("Silakan Login");
                    System.out.println("");
                    System.out.println("Tekan enter untuk melanjutkan. . .");input.readLine();
                    break;
                case 2:
                    clear();
                    System.out.print("Enter your username : ");
                    String username = input.readLine();
                    System.out.print("Enter your password : ");
                    String password = input.readLine();
                    if(username.equals(Admin1.getUsername()) && password.equals(Admin1.getPassword())){
                        Admin1.menuAdm();
                    }
                    for (User User : DataUser){
                        if(username.equals(User.getUsername()) && password.equals(User.getPassword())){
                            User.menuUser();
                        }
                    }
                    break;
                case 3:
                    clear();
                    System.out.println("----------------------------------");
                    System.out.println("      Thankyou, come again!       ");
                    System.out.println("----------------------------------");
                    System.exit(0);
                    break;
                default:
                    System.err.println("|-----------------------|");
                    System.err.println("| Option does not exist |");
                    System.err.println("|-----------------------|");
                    System.out.println("| Tekan enter untuk melanjutkan |"); input.readLine();
                    login();
                    break;
            }
        }
    }

    private static void login() throws IOException, NumberFormatException {
        
    }

    private static void clear(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    private static int error_int() throws IOException{
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

    private static boolean ulang(String message){
        Scanner pilihan = new Scanner(System.in);
        System.out.print("\n"+message+" [y/n] >> ");
        String pilihan_user = pilihan.next();

        while(!pilihan_user.equalsIgnoreCase("y") && !pilihan_user.equalsIgnoreCase("n")){
            System.err.println("--------------------------");
            System.err.println("|       Pilih Y/N !      |");
            System.err.println("--------------------------");
            System.out.print("\n"+message+" [y/n] >>> ");
            pilihan_user = pilihan.next();
        }
        return pilihan_user.equalsIgnoreCase("y");
    }
}
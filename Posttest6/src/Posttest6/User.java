package Posttest6;

import java.io.IOException;
import java.util.ArrayList;

public class User extends Akun{
    private ArrayList<Agent> DataAgent;
    private String priv;

    public User(String username, String password, String nama, String jenisKelamin, String priv, ArrayList<Agent> agent){
        super(username, password, nama, jenisKelamin);
        this.priv = priv;
        this.DataAgent = agent;
    }

    @Override
    protected void profile(){
        clear();
        System.out.println("---------------------------------");
        super.profile();
        System.out.println("Privillage " + this.priv);
        System.out.println("---------------------------------");
    }

    @Override
    protected void display() throws IOException {
        if(this.DataAgent.isEmpty()){
            clear();
            System.err.println("-----------------------------");
            System.err.println("     Data agent not found    ");
            System.err.println("-----------------------------");
        }
        else {
            clear();
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("| No |\tNama Agent\t      |\tRole\t              |\tSkill\t               | Utility\t    |");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            for(int i =0; i < DataAgent.size(); i++){
            System.out.printf("| %2d ", (i+1));
            System.out.printf("|\t%-20s  ", DataAgent.get(i).getNama());
            System.out.printf("|\t%-20s  ", DataAgent.get(i).getRole());
            System.out.printf("|\t%-20s   ", DataAgent.get(i).getSkill());
            System.out.printf("| %-20s   ", DataAgent.get(i).getUtility());
            System.out.println("\n-----------------------------------------------------------------------------------------------------");
            }
        }
    }
    
    @Override 
    public void menu() throws IOException {
        boolean lanjut = true;
        while(lanjut){
            clear();
            System.out.println("\t|-------------------------|");
            System.out.println("\t|        Menu User        |");
            System.out.println("\t|-------------------------|");
            System.out.println("\t| 1. | Display Data Agent |");
            System.out.println("\t| 2. | Display Profile    |");
            System.out.println("\t| 3. | Exit               |");
            System.out.println("\t|-------------------------|");
            System.out.print("\n\t| Enter your choice : ");
            int pilih = error_int();
            switch(pilih){
                case 1:
                    clear();
                    display();
                    break;
                case 2:
                    clear();
                    profile();
                    break;
                case 3:
                    clear();
                    exit();
                    break;
                default:
                    System.err.println("|-----------------------|");
                    System.err.println("| Option does not exist |");
                    System.err.println("|-----------------------|");
                    System.out.println("| Tekan enter untuk melanjutkan |"); input.readLine();
                    break;
            }
            lanjut = ulang("Apakah Anda ingin melanjutkan");
        }
        exit();
    }

    @Override
    protected void clear() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static void exit(){
        System.out.println("\n-------------------------------");
        System.out.println("| Yakin nih keluar program :( |");
        System.out.println("-------------------------------");
    }
}
package Posttest1;

import java.io.*;
import java.util.*;

import javax.management.relation.Role;

public class Main {
    public int batasan;
    private static InputStreamReader p = new InputStreamReader(System.in);
    private static BufferedReader input = new BufferedReader(p);
    private static ArrayList<Agent> DataAgent = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        menu_awal();
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

    private static void exit(){
        System.out.println("\n-------------------------------");
        System.out.println("| Yakin nih keluar program :( |");
        System.out.println("-------------------------------");
    }

    private static void add_data()throws NumberFormatException, IOException{
        System.out.println("------------------");
        System.out.println("| Add Data Agent |");
        System.out.println("------------------\n");
        System.out.print("Ingin masukkan berapa data : ");
        int batasan = Integer.parseInt(input.readLine());
        clear();
        for(int i = 1; i <= batasan; i++) {
            System.out.println("==========================");
            System.out.println("Data ke - " + i);
            System.out.print("Masukkan nama agent    : ");
            String nama = input.readLine();
            System.out.print("Masukkan role agent    : ");
            String role = input.readLine();
            System.out.print("Masukkan skill agent   : ");
            String skill = input.readLine();
            System.out.print("Masukkan utility agent : ");
            String utility = input.readLine();
            Agent new_data = new Agent(nama, role, skill, utility);
            DataAgent.add(new_data);
        }
        System.out.println("-----------------------------");
        System.out.println("| Data berhasil ditambahkan |");
        System.out.println("-----------------------------");
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

    public static void display_data() throws NumberFormatException, IOException{
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

    public static void update_data() throws NumberFormatException, IOException {
        System.out.println("---------------------");
        System.out.println("| Update data agent |");
        System.out.println("---------------------");
        System.out.println("");

        System.out.print("Input nama agent : ");
        String nm = input.readLine();
        clear();
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("| No |\tNama Agent\t      |\tRole\t              |\tSkill\t               | Utility\t    |");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for(Agent agent : DataAgent) {
            if(agent.getNama().equals(nm)){
                System.out.printf("|\t%-20s  ", agent.getNama());
                System.out.printf("|\t%-20s  ", agent.getRole());
                System.out.printf("|\t%-20s   ", agent.getSkill());
                System.out.printf("| %-20s    ", agent.getUtility());
                System.out.println("\n-----------------------------------------------------------------------------------------------------");
                boolean lanjut = true;
                while(lanjut){
                    System.out.println("\n|-------------------------|");
                    System.out.println("|         OPTION          |");
                    System.out.println("|-------------------------|");
                    System.out.println("| 1. | Update Name        |");
                    System.out.println("| 2. | Update Role        |");
                    System.out.println("| 3. | Update Skill       |");
                    System.out.println("| 4. | Update Utility     |");
                    System.out.println("|-------------------------|");
                    System.out.print("| Enter your choice : ");
                    int pilihan = Integer.parseInt(input.readLine());
                    switch(pilihan){
                        case 1:
                            System.out.print("| Masukkan nama agent baru : "); 
                            agent.setNama_agent(input.readLine());
                            break;
                        case 2:
                            System.out.print("| Masukkan role baru       : "); 
                            agent.setRole_agent(input.readLine());
                            break;
                        case 3:
                            System.out.print("| Masukkan skill baru      : ");
                            agent.setSkill_agent(input.readLine());
                            break;
                        case 4:
                            System.out.print("| Masukkan utility baru    : ");
                            agent.setUtility_agent(input.readLine());
                            break;
                        default:
                            System.err.println("-------------------------");
                            System.err.println("| Option does not exist |");
                            System.err.println("-------------------------");
                            break;
                    }
                    lanjut = ulang("Ada lagi yang mau dirubah ");
                }
            }
        }
    }

    public static void delete_data() throws NumberFormatException, IOException{
        System.out.println("---------------------");
        System.out.println("| Delete data agent |");
        System.out.println("---------------------");
        System.out.print("Input nama agent : ");
        String nmd = input.readLine();

        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("| No |\tNama Agent\t      |\tRole\t              |\tSkill\t               | Utility\t    |");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for(Agent agent: DataAgent){
            if(agent.getNama().equals(nmd)){
                System.out.printf("|\t%-20s  ", agent.getNama());
                System.out.printf("|\t%-20s  ", agent.getRole());
                System.out.printf("|\t%-20s   ", agent.getSkill());
                System.out.printf("| %-20s    ", agent.getUtility());
                System.out.println("\n-----------------------------------------------------------------------------------------------------");
                System.out.print("Yakin mau menghapus data [y/n] >> ");
                String yakin = input.readLine();
                
                if(yakin.equalsIgnoreCase("y")){
                    DataAgent.remove(agent);
                    System.out.println("-------------------------");
                    System.out.println("| Data berhasil dihapus |");
                    System.out.println("-------------------------");
                }
                else if(yakin.equalsIgnoreCase("n")){
                    System.out.println("-------------------------------");
                    System.out.println("| Data tidak berhasil dihapus |");
                    System.out.println("-------------------------------");
                }
                break;
            }
        }
    }

    private static void menu_awal() throws NumberFormatException, IOException{
        boolean lanjut = true;
        while(lanjut){
            clear();
            System.out.println("\t|-------------------------|");
            System.out.println("\t|       Data Agent        |");
            System.out.println("\t|-------------------------|");
            System.out.println("\t| 1. | Add Data Agent     |");
            System.out.println("\t| 2. | Display Data Agent |");
            System.out.println("\t| 3. | Update Data Agent  |");
            System.out.println("\t| 4. | Delete Data Agent  |");
            System.out.println("\t| 5. | Exit               |");
            System.out.println("\t|-------------------------|");
            System.out.print("\n\t| Enter your choice : ");
            int pilih = error_int();
            switch(pilih){
                case 1:
                    clear();
                    add_data();
                    break;
                case 2:
                    clear();
                    display_data();
                    break;
                case 3:
                    clear();
                    update_data();
                    break;
                case 4:
                    clear();
                    delete_data();
                    break;
                case 5:
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
}
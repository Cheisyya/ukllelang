/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lelangukl;

import java.util.Scanner;
/**
 *
 * @author MOKLET-1
 */
public class LelangUkl {

    /**
     * @param args the command line arguments
     */
 
    static Masyarakat masyarakat = new Masyarakat();
    static Barang barangLelang = new Barang();
    static Petugas petugas = new Petugas("Admin", "Sawojajar", "08123425624");

    static Scanner userInput = new Scanner(System.in);
    static Scanner ulangi = new Scanner(System.in);

    static String jawab = "";
    static String user_input = "";
    static int Pilihan;

    static String loginName = "";
    static Masyarakatdua opponent = new Masyarakatdua();
    static int currentHarga;

    static int bot_harga;
    static int user_harga;
    /*VAR*/

    public static void main(String[] args) {
        
        login();
        askGeneratebarang();
        askAjukanBarang();
        System.out.println("Daftar barang");
        System.out.println();//jarak
        barangLelang.tampilBarang();
       
        System.out.print("Barang mana yang ingin anda tawar ? : ");
        Pilihan = userInput.nextInt();
        if (Pilihan > barangLelang.idBarang.size() || !barangLelang.getStatus(Pilihan)){
            System.out.println("Nomor barang tidak ada");
        }else  {
            System.out.println("=================== OUTPUTT ===================");
            System.out.println("Barang : " + barangLelang.getNamaBarang(Pilihan));
            System.out.println("harga awal : " + barangLelang.getHargaAwal(Pilihan));
            System.out.println("Status : " + barangLelang.getStatus(Pilihan));
            barangLelang.addPenawar(masyarakat.getIdMasyarakat(masyarakat.getIndexFromName(loginName)));
            barangLelang.overrideHargaTawar();
            barangLelang.addHargaTawar(Integer.parseInt(barangLelang.getHargaAwal(Pilihan)));
            lelangStart();
        } 
        pemenang();
        System.out.println();//jarak
        System.out.println("=============== Memastikan Status =============");
        barangLelang.tampilBarang();
    }

    static boolean UserAnswerIsYes(String input){
        return input.equalsIgnoreCase("y");
    }

    
    static void login(){
        System.out.println("================ MASUKKAN DATA ================");
        System.out.print("Nama : ");
        String nama = userInput.nextLine();
        loginName = nama;
        System.out.print("Alamat : ");
        String alamat = userInput.nextLine();
        System.out.print("Telp : ");
        String telp = userInput.nextLine();
        masyarakat.Masyarakat(nama, alamat, telp);
        System.out.println("===============================================");
    }

    
    static void askGeneratebarang(){
        //ask for generate
        System.out.print("Generate Barang ? (y/n) : ");
        user_input = userInput.nextLine();
        
        if (UserAnswerIsYes(user_input)){
            generatebarang();
            System.out.println();//jarak
            System.out.println("=========== Barang Lelang Generated ===========");
        }else{
            System.out.println("ya oke");
            System.out.println("===============================================");
        }
    }

    static void askAjukanBarang(){
        //ask if you want to create barang yourself
        System.out.print("Ajukan barang untuk lelang? (y/n) : ");
        user_input = userInput.nextLine();
        if (UserAnswerIsYes(user_input)){
            petugas.doYourJob(barangLelang);
            System.out.println();//jarak
            System.out.println("=========== Barang Lelang Generated ===========");
        }else{
            System.out.println("Baik, Kami akan menampilkan daftar barang");
            System.out.println("===============================================");
        }
    }
    
   

    static void lelangStart() {
        do {
            /*logic here*/
            //our turn
            currentHarga = barangLelang.getHargaTertinggi();
            System.out.println("Harga Saat Ini : " + currentHarga);
            System.out.println("===============================================");
            System.out.println();//jarak
            System.out.println("=============== LELANG DIMULAI ================");
            System.out.print("Masukkan Harga : ");
            int harga = userInput.nextInt();

            System.out.println();//jarak

            if (harga <= barangLelang.getHargaTertinggi()){
                System.out.println("Harga anda terlalu rendah");
                System.out.println();//jarak
            }else {
                barangLelang.addHargaTawar(harga);
                user_harga = harga;
            }
            //System.out.println();//jarak

            currentHarga = barangLelang.getHargaTertinggi();

            //bot turn
            bot_harga = opponent.generateHarga(currentHarga);
            if (bot_harga <= barangLelang.getHargaTertinggi()){
                System.out.println("Masyarakat :  Harga anda tinggi/Masyarakat Kalah");
            }else {
                barangLelang.addHargaTawar(bot_harga);
                System.out.println("Masyarakat : " + bot_harga);
            }
            currentHarga = barangLelang.getHargaTertinggi();
            System.out.println();//jarak
            /*logic here*/

            System.out.print("Apakah anda ingin menawar lagi ? (y/t) : ");
            jawab = ulangi.nextLine();

        } while (UserAnswerIsYes(jawab));
    }

    static void generatebarang() {
        System.out.println("===============================================");
        barangLelang.addNamaBarang("Iphone 12");
        barangLelang.addHargaAwal("50000");
        barangLelang.addHargaTawar(50000);
        barangLelang.setStatus(true);

        barangLelang.addNamaBarang("Laptop Asus");
        barangLelang.addHargaAwal("600000");
        barangLelang.addHargaTawar(600000);
        barangLelang.setStatus(true);

        barangLelang.addNamaBarang("Lemari Kaca");
        barangLelang.addHargaAwal("700000");
        barangLelang.addHargaTawar(700000);
        barangLelang.setStatus(true);
        
        barangLelang.addNamaBarang("Pc");
        barangLelang.addHargaAwal("900000");
        barangLelang.addHargaTawar(900000);
        barangLelang.setStatus(true);
        
        barangLelang.addNamaBarang("Botol");
        barangLelang.addHargaAwal("400000");
        barangLelang.addHargaTawar(400000);
        barangLelang.setStatus(true);
    }
     
      static void pemenang(){
        barangLelang.setStatus(Pilihan, false);
        if (currentHarga == user_harga){
            System.out.println();//jarak
            System.out.println("================ HASIL LELANG ================");
            System.out.println("Pemenang " + barangLelang.getNamaBarang(Pilihan));
            System.out.println("Adalah : " + loginName);
            System.out.println("Dengan harga : " + currentHarga);
            System.out.println("Status : " + barangLelang.getStatus(Pilihan));
            
        }else {
            System.out.println();//jarak
            System.out.println("================ HASIL LELANG ================");
            System.out.println("Pemenang " + barangLelang.getNamaBarang(Pilihan));
            System.out.println("Adalah : Masyarakat");
            System.out.println("Dengan harga : " + currentHarga);
            System.out.println("Status : " + barangLelang.getStatus(Pilihan));
        }
    }
      
}

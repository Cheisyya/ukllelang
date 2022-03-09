/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lelangukl;
import java.util.Random;
/**
 *
 * @author MOKLET-1
 */
public class Masyarakatdua {
     public int generateHarga(int hargaSebelum){
        Random rand = new Random();
        int lelang = rand.nextInt(2);
        if(lelang != 2){ //0
            int hargaMasyarakatdua = rand.nextInt(hargaSebelum) + hargaSebelum;
            return hargaMasyarakatdua;
            
           //range 0 - harga sebelumya + harga sebelumnya 
           // semisal harga 5000, 0 - 5000 + 5000
        }else{//1
            return 0;
        }
    }
      }

// 0 - 1
// 0 = ikut lelang, 1 = gakikut

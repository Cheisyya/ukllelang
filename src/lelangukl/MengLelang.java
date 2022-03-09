/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lelangukl;
import java.util.ArrayList;
/**
 *
 * @author MOKLET-1
 */
public interface MengLelang {
    void addPenawar(int ID);
    void addIdBarang(int ID);
    void addHargaTawar(int harga);
    void setStatus(boolean status);

    int getHargaTertinggi();
    int getIdPenawar();
    boolean getStatus(int id);
}

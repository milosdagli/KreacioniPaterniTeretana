/* Panel.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */


package AbstractProductA;



import java.awt.event.KeyEvent;
import java.util.Date;

// Promenljivo!!!
public abstract class Panel extends javax.swing.JPanel{
       
       public abstract String getIdClanovi(); // Promenljivo!!!
       public abstract javax.swing.JTextField getIdClanovi1(); // Promenljivo!!!
       public abstract String getIme(); // Promenljivo!!!
       public abstract String getPrezime(); // Promenljivo!!!
       public abstract String getPaket(); // Promenljivo!!!
       public abstract Date getDatumDo(); // Promenljivo!!!
       
       public abstract void setIdClanovi(String SifraPrijave); // Promenljivo!!!
       public abstract void setIme(String SifraPredmeta); // Promenljivo!!!
       public abstract void setPrezime(String BrojIndeksa); // Promenljivo!!!
       public abstract void setPaket(String Ocena); // Promenljivo!!!
       public abstract void setDatumDo(Date Datum); // Promenljivo!!!
       
       public abstract void setPoruka(String Poruka);
       
       public abstract javax.swing.JButton getDodaj(); 
       public abstract javax.swing.JButton getPromeni(); 
       public abstract javax.swing.JButton getObrisi(); 
       public abstract javax.swing.JButton getNadji();
       
       
       
}

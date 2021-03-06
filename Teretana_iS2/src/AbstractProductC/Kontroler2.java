/* Kontroler2.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package AbstractProductC;

import AbstractProductA.*;
import AbstractProductB.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.Teretana;


public final class Kontroler2 extends Kontroler{
    
    
      
    public Kontroler2(EkranskaForma ef1,BrokerBazePodataka bbp1){ef=ef1;bbp=bbp1; Povezi(); osveziFormu();}
    
    void Povezi()
    {javax.swing.JButton Kreiraj = ef.getPanel().getDodaj();
     javax.swing.JButton Promeni = ef.getPanel().getPromeni();
     javax.swing.JButton Obrisi = ef.getPanel().getObrisi();
     javax.swing.JButton Nadji = ef.getPanel().getNadji();
     Kreiraj.addActionListener( new OsluskivacKreiraj1(this));
     Promeni.addActionListener( new OsluskivacPromeni1(this));
     Obrisi.addActionListener( new OsluskivacObrisi1(this));
     Nadji.addActionListener( new OsluskivacNadji11(this));
     
     javax.swing.JTextField SifraPrijave = ef.getPanel().getIdClanovi1(); // Promenljivo!!!
     SifraPrijave.addFocusListener( new OsluskivacNadji12(this));
    }
    
// Promenljivo!!!    
void napuniDomenskiObjekatIzGrafickogObjekta()   {
       ter= new Teretana();
       ter.setIdclanovi(getInteger(ef.getPanel().getIdClanovi()));
       ter.setIme(ef.getPanel().getPrezime());
       ter.setPrezime(ef.getPanel().getIme());
       ter.setPaket(ef.getPanel().getPaket());
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       java.util.Date Datum = java.sql.Date.valueOf(sdf.format(ef.getPanel().getDatumDo())); 
       ter.setDatumDo(Datum); 
    
    }

// Promenljivo!!!
void napuniGrafickiObjekatIzDomenskogObjekta(Teretana ip){
       ef.getPanel().setIdClanovi(Integer.toString(ip.getIdclanovi()));
       ef.getPanel().setPrezime(ip.getPrezime());
       ef.getPanel().setIme(ip.getIme());
       ef.getPanel().setPaket(ip.getPaket());
       ef.getPanel().setDatumDo(ip.getDatumDo());
      
    }

// Promenljivo!!!
void isprazniGrafickiObjekat(){

 ef.getPanel().setIdClanovi("");
 ef.getPanel().setPrezime("");
 ef.getPanel().setIme("");
 ef.getPanel().setPaket("obicni");
 ef.getPanel().setDatumDo(new java.util.Date());
}


void prikaziPoruku() 
{ ef.getPanel().setPoruka(poruka);
      
  Timer timer = new Timer();
  
  timer.schedule(new TimerTask() {
  @Override
  public void run() {
    ef.getPanel().setPoruka(""); 
  }
}, 3000);
  
}


void prikaziPoruku(String poruka) 
{ ef.getPanel().setPoruka(poruka);
      
  Timer timer = new Timer();
  
  timer.schedule(new TimerTask() {
  @Override
  public void run() {
    ef.getPanel().setPoruka(""); 
  }
}, 1000);
  
}

void osveziFormu() 
{    
  Timer timer = new Timer();
  
  timer.scheduleAtFixedRate(new TimerTask() {
  @Override
  public void run() {
      napuniDomenskiObjekatIzGrafickogObjekta();
      nadjiDomenskiObjekat();
      prikaziPoruku("Освежавање форме!!!");
  }
}, 0,10000);
  
}

public int getInteger(String s) {
    int broj = 0;
    try
        {
            if(s != null)
                broj = Integer.parseInt(s);
        }
            catch (NumberFormatException e)
            { broj = 0;}
   
    return broj;
}


 
boolean zapamtiDomenskiObjekat(){ 
    
    bbp.makeConnection();
    boolean signal = bbp.insertRecord(ter);
    if (signal==true) 
        { bbp.commitTransation();
          poruka ="Систем је запамтио нову испитну пријаву."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          poruka ="Систем не може да запамти нову испитну пријаву."; // Promenljivo!!!  
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal; 
       
    }
    
boolean kreirajDomenskiObjekat(){
    boolean signal;
    ter= new Teretana(); // Promenljivo!!!
    AtomicInteger counter = new AtomicInteger(0);
    
    bbp.makeConnection();
    if (!bbp.getCounter(ter,counter)) return false;
    if (!bbp.increaseCounter(ter,counter)) return false;
          
    ter.setIdclanovi(counter.get()); // Promenljivo!!!
    signal = bbp.insertRecord(ter);
    if (signal==true) 
        { bbp.commitTransation();
          napuniGrafickiObjekatIzDomenskogObjekta(ter);
          poruka = "Систем је креирао нову испитну пријаву."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
        isprazniGrafickiObjekat();
        poruka ="Систем не може да креира нову испитну пријаву."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;
}

boolean obrisiDomenskiObjekat(){
    bbp.makeConnection();
    boolean signal = bbp.deleteRecord(ter);
    if (signal==true) 
        { bbp.commitTransation();
          poruka = "Систем je oбрисао испитну пријаву."; // Promenljivo!!!
            isprazniGrafickiObjekat();
        }
        else
        { bbp.rollbackTransation();
          poruka = "Систем не може да обрише испитну пријаву."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}

boolean promeniDomenskiObjekat(){
    bbp.makeConnection();
    boolean signal = bbp.updateRecord(ter);
    if (signal==true) 
        { bbp.commitTransation();
          poruka = "Систем je променио испитну пријаву."; // Promenljivo!!!
        }
        else
        { bbp.rollbackTransation();
          isprazniGrafickiObjekat();
          poruka = "Систем не може да промени испитну пријаву."; // Promenljivo!!!
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}


boolean nadjiDomenskiObjekat(){
    boolean signal;
    bbp.makeConnection();
    ter = (Teretana)bbp.findRecord(ter); // Promenljivo!!!
    if (ter != null) 
        { napuniGrafickiObjekatIzDomenskogObjekta(ter);
          poruka = "Систем je нашао испитну пријаву.";  // Promenljivo!!!
          signal = true;
        }
        else
        { isprazniGrafickiObjekat();
          poruka ="Систем не може да нађе испитну пријаву."; // Promenljivo!!!
          signal = false;
        }
    prikaziPoruku();
    bbp.closeConnection();
    return signal;   
}

}

class OsluskivacZapamti1 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacZapamti1(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.zapamtiDomenskiObjekat();
        
    }
}

class OsluskivacKreiraj1 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacKreiraj1(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.kreirajDomenskiObjekat();
         
        
    }
}

class OsluskivacObrisi1 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacObrisi1(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.obrisiDomenskiObjekat();
        
    }
}

class OsluskivacPromeni1 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacPromeni1(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.promeniDomenskiObjekat();
        
    }
}

class OsluskivacNadji11 implements ActionListener
{   Kontroler2 kon;
 
    OsluskivacNadji11(Kontroler2 kon1) {kon = kon1;}
    
@Override
    public void actionPerformed(ActionEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
    }
}

class OsluskivacNadji12 implements FocusListener
{   Kontroler2 kon;
 
    OsluskivacNadji12(Kontroler2 kon1) {kon = kon1;}
    

    public void focusLost(java.awt.event.FocusEvent e) {
         kon.napuniDomenskiObjekatIzGrafickogObjekta();
         kon.nadjiDomenskiObjekat();
        
    }

    @Override
    public void focusGained(FocusEvent e) {
       
    }
}


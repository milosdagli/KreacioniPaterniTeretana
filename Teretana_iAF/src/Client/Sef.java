/* Sef.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package Client;

import AbstractFactory.*;//projektant kod nas
import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

public class Sef { // Client
    
        //ovo klasa u klasi je da se vidi zapravo ko ima odgovornost. Ova klasa je finalni proizvod
        Projektant proj; // Abstract Factory   
        class SoftverskiSistem // Complex Product
           {  EkranskaForma ef; // AbstractProductA 
              BrokerBazePodataka bbp; // AbstractProductB 
              Kontroler kon; // AbstractProductC 
              SoftverskiSistem(EkranskaForma ef1,BrokerBazePodataka bbp1,Kontroler kon1){ef=ef1;bbp=bbp1;kon=kon1;}
              void prikaziEkranskuFormu(){ef.prikaziEkranskuFormu();}
           }
        //referenca i na finalni proizvod.
        SoftverskiSistem ss;
//sef pravi projektankta koji ce sastavljati djelove
Sef (Projektant proj1){proj = proj1; }   


public static void main(String args[])  {  
//referenca sefa
Sef sef; 
// ConcreteFactory3, konkretni projektant
Projektant proj = new Projektant1(); // Promenljivo!!! 
//povezujemo sefa sa projektantom, i sad sef ima sve sta mu treba.
sef = new Sef(proj);
sef.Kreiraj();
}

void Kreiraj()     { 
      EkranskaForma ef =proj.kreirajEkranskuFormu();
      BrokerBazePodataka bbp = proj.kreirajBrokerBazePodataka();
      Kontroler kon= proj.kreirajKontroler(ef,bbp);
      ss = new SoftverskiSistem(ef,bbp,kon);
      ss.prikaziEkranskuFormu();
} 
    
}

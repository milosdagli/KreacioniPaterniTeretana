/* Sef.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */

package Client;

import Creator.*;

public class Sef { // Client
        Projektant proj; // Creator   
        
        

Sef (Projektant proj1){proj = proj1; }   
public static void main(String args[])  {  
Sef sef;                    
// ConcreteCreator
Projektant proj = new Projektant1(); // Promenljivo!!!
sef = new Sef(proj);
sef.Kreiraj();
}

void Kreiraj()     
{ proj.Kreiraj();
} 
    
}

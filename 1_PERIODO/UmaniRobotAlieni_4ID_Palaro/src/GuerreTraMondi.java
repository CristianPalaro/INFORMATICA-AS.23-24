/* COGNOME e NOME: Palaro Cristian 
 * CLASSE: 4ID
 * DATA: 23/10/2023
 */
public class GuerreTraMondi {
    public static void main(String[] args) {
        Umani u = new Umani("alfredo");
        Robot r = new Robot("gilberto");
        Alieni a = new Alieni("alberto");
    
        r.attack(a);
        a.attack(r);
        a.attack(u);
    }
}

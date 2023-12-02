/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ProblemaDosFumantes;

public class Main {

    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        Agente agente = new Agente(mesa);

        Fumantes fumante1 = new Fumantes(mesa, Ingredientes.TABACO);
        Fumantes fumante2 = new Fumantes(mesa, Ingredientes.PAPEL);
        Fumantes fumante3 = new Fumantes(mesa, Ingredientes.FOSFOROS);

        agente.start();
        fumante1.start();
        fumante2.start();
        fumante3.start();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaDosFumantes;

import java.util.Random;

// Classe Agente
class Agente extends Thread {
    private final Mesa mesa;
    private final Random random = new Random();

    public Agente(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000); // Espera um pouco antes de colocar os próximos ingredientes
                Ingredientes ing1 = Ingredientes.values()[random.nextInt(3)];
                Ingredientes ing2;
                do {
                    ing2 = Ingredientes.values()[random.nextInt(3)];
                } while (ing1 == ing2);

                mesa.colocarIngredientes(ing1, ing2);
                System.out.println("Agente colocou ingredientes na mesa: " + ing1 + " e " + ing2);
                System.out.flush();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

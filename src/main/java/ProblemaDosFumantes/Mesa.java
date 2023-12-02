/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaDosFumantes;

// Classe Mesa com métodos sincronizados para colocar e pegar ingredientes

import java.util.concurrent.Semaphore;

class Mesa {
    private Ingredientes ingrediente1 = null;
    private Ingredientes ingrediente2 = null;
    private final Semaphore semaforo = new Semaphore(0);

    public synchronized void colocarIngredientes(Ingredientes ing1, Ingredientes ing2) {
        this.ingrediente1 = ing1;
        this.ingrediente2 = ing2;
        semaforo.release(); // Permite que um fumante pegue os ingredientes
    }

    public synchronized boolean pegarIngredientes(Ingredientes meuIngrediente) {
        try {
            semaforo.acquire(); // Espera até que os ingredientes estejam disponíveis
            if (meuIngrediente != ingrediente1 && meuIngrediente != ingrediente2) {
                System.out.println("Fumante com " + meuIngrediente + " está fumando.");
                System.out.flush();
                return true;
            } else {
                semaforo.release(); // Libera o semáforo se os ingredientes não combinam
                System.out.println("Fumante com "+ meuIngrediente + "não fumou.");
                System.out.flush();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
        return true;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaDosFumantes;

// Classe Fumante
class Fumantes extends Thread {
    private final Mesa mesa;
    private final Ingredientes meuIngrediente;

    public Fumantes(Mesa mesa, Ingredientes meuIngrediente) {
        this.mesa = mesa;
        this.meuIngrediente = meuIngrediente;
    }

    @Override
    public void run() {
        while (true) {
            if (mesa.pegarIngredientes(meuIngrediente)) {
                try {
                    Thread.sleep(500); // Simula o tempo fumando
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Fumante com " + meuIngrediente + "terminou de fumar.");
                    System.out.flush();
                    break;
                }
            }
        }
    }
}

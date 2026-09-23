package org.example;

public class Juego {

    public static void main(String[] args) {

        Mazo mazo = new Mazo();

        System.out.println("Creando mazo");
        System.out.println("Cartas: " + mazo.getCantidadCartas());

        mazo.barajar();

        System.out.println("\nBarajeando mazo");

        Jugador jugador1 = new Jugador("Ivan");
        Jugador jugador2 = new Jugador("Alonso");

        mazo.repartir(jugador1, 5);
        mazo.repartir(jugador2, 5);

        System.out.println("\n===== JUGADORES =====");
        System.out.println(jugador1);
        System.out.println(jugador2);

        System.out.println("===== ESTADO DEL MAZO =====");
        System.out.println("Cartas restantes: "
                + mazo.getCantidadCartas());

        Carta regresarCarta =
                jugador1.deshacerseDeCarta(0);

        mazo.agregarCarta(regresarCarta);

        System.out.println("\nTirar carta a la pila: "
                + regresarCarta);

        System.out.println("Cartas en pila: "
                + mazo.getCantidadNoRepartidas());

        Carta tomarCarta =
                mazo.agregarCarta(jugador1);

        System.out.println("\n El jugador 1 tomo la carta: "
                + tomarCarta);
        System.out.println(jugador1 + "\n");

        //mazo.regresarCartaAlMazo();

        //System.out.println("\nCarta regresada correctamente");
        //System.out.println("Cartas en el mazo: "
        //        + mazo.getCantidadCartas());

        System.out.println("Cartas del mazo \n");
        mazo.mostrarMazo();
    }
}

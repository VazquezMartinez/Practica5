package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private ArrayList<Carta> cartas;
    private ArrayList<Carta> pilaNoRepartidas;

    /**
     *  Constructor que crea un mazo nuevo.
     */
    public Mazo() {
        cartas = new ArrayList<>();
        pilaNoRepartidas = new ArrayList<>();
        restablecer();
    }

    /**
     * Restablece el mazo a sus 52 cartas originales.
     */
    public void restablecer() {
        cartas.clear();
        pilaNoRepartidas.clear();

        for (Figura figura : Figura.values()) {
            for (int valor = 1; valor <= 13; valor++) {
                cartas.add(new Carta(valor, figura));
            }
        }
    }

    /**
     * Baraja las cartas.
     */
    public void barajar() {
        Collections.shuffle(cartas);
    }

    /**
     * Reparte cartas a un jugador.
     *
     * @param jugador jugador que recibirá las cartas
     * @param cantidad cantidad de cartas a repartir
     */
    public void repartir(Jugador jugador, int cantidad) {

        if (cantidad < 0) {
            throw new IllegalArgumentException(
                    "La cantidad de cartas no puede ser negativa."
                );
        }

        if (cantidad > cartas.size()) {
            throw new IllegalArgumentException(
                    "No hay suficientes cartas en el mazo."
            );
        }

        for (int i = 0; i < cantidad; i++) {
            Carta carta = cartas.remove(cartas.size() - 1);
            jugador.recibirCarta(carta);
        }
    }

    /**
     * Agrega una carta a la pila de cartas no repartidas.
     *
     * @param carta carta que se agregará
     */
    public void agregarCarta(Carta carta) {
        if (carta != null) {
            pilaNoRepartidas.add(carta);
        }
    }

    /**
     * Quita una carta de la pila de cartas no repartidas.
     *
     * @return carta retirada o null si la pila está vacía
     */
    public Carta quitarCarta() {
        if (pilaNoRepartidas.isEmpty()) {
            return null;
        }

        return pilaNoRepartidas.remove(
                pilaNoRepartidas.size() - 1
        );
    }

    public Carta agregarCarta(Jugador jugador) {
        Carta carta = cartas.remove(cartas.size() - 1);
        jugador.recibirCarta(carta);
        return carta;
    }

    /**
     * Regresa una carta de la pila al mazo.
     */
    public void regresarCartaAlMazo() {
        Carta carta = quitarCarta();

        if (carta != null) {
            cartas.add(carta);
        }
    }

    public int getCantidadCartas() {
        return cartas.size();
    }

    public int getCantidadNoRepartidas() {
        return pilaNoRepartidas.size();
    }

    /**
     * Muestra las cartas que permanecen en el mazo.
     */
    public void mostrarMazo() {
        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }

    /**
     * Muestra la pila de cartas no repartidas.
     */
    public void mostrarPilaNoRepartidas() {
        for (Carta carta : pilaNoRepartidas) {
            System.out.println(carta);
        }
    }
}


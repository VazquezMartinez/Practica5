package org.example;
import java.util.ArrayList;

public class Jugador {

    public String nombre;
    private ArrayList<Carta> cartas;

    /**
     * Constructor del jugador.
     *
     * @param nombre nombre del jugador
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        cartas = new ArrayList<>();
    }

    /**
     * Recibe una carta.
     *
     * @param carta carta que recibe el jugador
     */
    public void recibirCarta(Carta carta) {
        if (carta != null) {
            cartas.add(carta);
        }
    }

    /**
     * Se deshace de una carta.
     *
     * @param indice posición de la carta
     * @return carta eliminada
     */
    public Carta deshacerseDeCarta(int indice) {
        if (indice < 0 || indice >= cartas.size()) {
            return null;
        }

        return cartas.remove(indice);
    }

    public int getCantidadCartas() {
        return cartas.size();
    }

    /**
     * Regresa la información del jugador.
     *
     * @return nombre y cartas del jugador
     */
    @Override
    public String toString() {
        String resultado = "Jugador: " + nombre + "\n";
        resultado += "Cartas:\n";

        for (Carta carta : cartas) {
            resultado += "- " + carta + "\n";
        }

        return resultado;
    }
}

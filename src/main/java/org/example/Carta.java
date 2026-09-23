package org.example;

public class Carta {

    private int valor;
    private Figura tipo;

    /**
     * Constructor de la carta
     *
     * @param valor valor numerico de la carta
     * @param tipo figura de la carta
     */


    public Carta(int valor, Figura tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public int getValor() {
        return valor;
    }

    public Figura getTipo() {
        return tipo;
    }

    /**
     * Regresa la representación de la carta.
     *
     * @return información de la carta
     */
    @Override
    public String toString() {
        String valorTexto;

        switch (valor) {
            case 1:
                valorTexto = "A";
                break;
            case 11:
                valorTexto = "J";
                break;
            case 12:
                valorTexto = "Q";
                break;
            case 13:
                valorTexto = "K";
                break;
            default:
                valorTexto = String.valueOf(valor);
        }

        return valorTexto + " de " + tipo;
    }
}

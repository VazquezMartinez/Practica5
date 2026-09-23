package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.example.Carta;
import org.example.Jugador;
import org.example.Mazo;
import org.junit.jupiter.api.Test;

public class MazoTest {

    @Test
    public void mazoDebeTener52Cartas() {
        Mazo mazo = new Mazo();

        assertEquals(52, mazo.getCantidadCartas());
    }

    @Test
    public void repartirDebeReducirElMazo() {
        Mazo mazo = new Mazo();
        Jugador jugador = new Jugador("Alonso");

        mazo.repartir(jugador, 5);

        assertEquals(47, mazo.getCantidadCartas());
        assertEquals(5, jugador.getCantidadCartas());
    }

    @Test
    public void noDebeRepartirMasCartasDeLasDisponibles() {
        Mazo mazo = new Mazo();
        Jugador jugador = new Jugador("Alonso");

        assertThrows(
                IllegalArgumentException.class,
                () -> mazo.repartir(jugador, 53)
        );
    }

    @Test
    public void regresarCartaDebeAumentarElMazo() {
        Mazo mazo = new Mazo();
        Jugador jugador = new Jugador("Alonso");

        mazo.repartir(jugador, 1);

        Carta carta = jugador.deshacerseDeCarta(0);
        mazo.agregarCarta(carta);
        mazo.regresarCartaAlMazo();

        assertEquals(52, mazo.getCantidadCartas());
    }
}
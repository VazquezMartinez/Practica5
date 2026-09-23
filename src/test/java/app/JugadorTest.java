package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.example.Carta;
import org.example.Figura;
import org.example.Jugador;
import org.junit.jupiter.api.Test;

public class JugadorTest {

    @Test
    public void jugadorDebeRecibirCarta() {
        Jugador jugador = new Jugador("Alonso");

        jugador.recibirCarta(
                new Carta(10, Figura.ESPADAS)
        );

        assertEquals(1, jugador.getCantidadCartas());
    }

    @Test
    public void jugadorDebePoderDeshacerseDeCarta() {
        Jugador jugador = new Jugador("Alonso");

        jugador.recibirCarta(
                new Carta(10, Figura.ESPADAS)
        );

        Carta carta = jugador.deshacerseDeCarta(0);

        assertNotNull(carta);
        assertEquals(0, jugador.getCantidadCartas());
    }
}

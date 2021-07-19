package Main;

/**
 *
 * @author wilmar Sanchez
 */
import Ids.PlayerID;
import Ids.Name;
import Game.Game;
import java.util.Scanner;
import java.util.UUID;
import java.awt.Color;

public class Main {

    public static void main(String[] args) {
        UUID ID;
        int cantidadJugadores;
        String nombreJugador;
        Game nuevoJuego = new Game();

        System.out.println("... Iniciando un nuevo juego ...");

        Scanner in = new Scanner(System.in);
        System.out.println("¿Cuántos jugadores deseas crear?");
        while (!in.hasNextInt()) {
            in.next();
        }
        cantidadJugadores = in.nextInt();

        for (int i = 0; i < cantidadJugadores; i++) {
            ID = UUID.randomUUID();
            PlayerID jugadorID = new PlayerID(ID);
            nombreJugador = "Jugador" + (i + 1);
            Name nombre = new Name(nombreJugador);
            nuevoJuego.crearJugador(jugadorID, nombre, Color.BLACK);
        }

        nuevoJuego.crearPistas();

        nuevoJuego.iniciarJuego();

    }
    
}

package Game;

/**
 *
 * @author wilmar Sanchez
 */
import Car.Driver;
import Car.Car;
import Lane.Lane;
import Ids.CarID;
import Ids.GameID;
import Ids.PlayerID;
import Ids.Name;
import Game.Values.Track;
import Game.Values.Podium;
import Position.Position;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Game {

    public Game() {
    }

    protected Map<PlayerID, Player> jugadores = new HashMap<>();
    protected Track pista;
    protected Boolean jugando;
    protected Podium podio = new Podium();
    protected ArrayList<Track> pistas = new ArrayList<>();
    protected ArrayList<Car> carrosEnJuego = new ArrayList<>();
    protected ArrayList<Lane> carrilesEnJuego = new ArrayList<>();
    protected ArrayList<Winners> ganadores = new ArrayList<>();
    private final Car carro = new Car();

    public void crearJugador(PlayerID jugadorID, Name Nombre, Color color) {
        Player jugador = new Player(Nombre, color, 0);
        jugadores.put(jugadorID, jugador);
        crearConductor(Nombre);
    }

    public void crearConductor(Name Nombre) {
        UUID ID;
        Scanner in = new Scanner(System.in);
        System.out.println("Desea que el jugador con nombre: " + Nombre.getNombre() + " sea conductor ? " + "Y/N");
        while (!in.hasNext("[yYnN]")) {
            System.out.println("Solo se reciben como respuesta Y/N ");
            in.next();
        }
        String consultaConductores = in.next();
        if (consultaConductores.equals("Y") || consultaConductores.equals("y")) {
            Driver conductor = new Driver(Nombre.getNombre());
            ID = UUID.randomUUID();
            CarID carroID = new CarID(ID);
            carro.asignarConductor(carroID, conductor);
        }
    }

    public void crearPistas() {
        int kilometrosRandom;
        int numeroCarriles = carro.numeroCarros();
        for (int i = 0; i < carro.numeroCarros(); i++) {
            kilometrosRandom = (int) (Math.random() * 100 + 1);
            Track pista = new Track(kilometrosRandom, numeroCarriles);
            pistas.add(pista);
        }
    }

    public void asignarPrimerLugar(PlayerID jugadorID) {
        podio.asignarPrimerLugar(jugadores.get(jugadorID));
        System.out.println(jugadores.get(jugadorID).Nombre().getNombre() + ": Primer Lugar");

    }

    public void asignarSegundoLugar(PlayerID jugadorID) {
        podio.asignarSegundoLugar(jugadores.get(jugadorID));
        System.out.println(jugadores.get(jugadorID).Nombre().getNombre() + ": Segundo Lugar");
    }

    public void asignarTercerLugar(PlayerID jugadorID) {
        podio.asignarTercerLugar(jugadores.get(jugadorID));
        System.out.println(jugadores.get(jugadorID).Nombre().getNombre() + ": Tercer Lugar");

    }

    public void iniciarJuego() {

        UUID ID;
        ID = UUID.randomUUID();
        GameID juegoID = new GameID(ID);

        Scanner in = new Scanner(System.in);
        System.out.println("Elige la  pista en la que deseas jugar:  ");
        System.out.println("Pistas: ");
        int counter = 1;
        for (Track p : pistas) {
            System.out.println(counter + "." + " Kilometros: " + p.kilometros() + " Número de carriles:  " + p.numeroDeCarriles());
            counter++;
        }
        while (!in.hasNextInt()) {
            in.next();
        }
        int pistaElegida = in.nextInt();

        carro.carros().forEach((key, value) -> {
            Car carrosJuego = new Car(value, 0, Color.BLACK, juegoID);
            carrosEnJuego.add(carrosJuego);

            int kilometrosAMetros = pistas.get(pistaElegida - 1).kilometros() * 1000;
            Position posicion = new Position(0, kilometrosAMetros);
            Lane carriles = new Lane(key, juegoID, posicion, kilometrosAMetros, false);
            carrilesEnJuego.add(carriles);
        });

        jugando = true;
        Driver conductor = new Driver();
        System.out.println("*******Inicia  carrera*******");

        while (jugando) {
            int contador = 0;
            System.out.println("*******Avance******* " + "******* Meta: " + carrilesEnJuego.get(contador).metros() + " metros");
            for (Car carros : carrosEnJuego) {

                if (!CarroGanador(carros.conductor().Nombre())) {
                    int mover = conductor.lanzarDado() * 100;
                    carros.setDistancia(carros.distancia() + mover);
                    carrilesEnJuego.get(contador).moverCarro(carrilesEnJuego.get(contador).posicion(), mover);
                    System.out.println(carros.conductor().Nombre() + ":" + " mueve: " + mover + " Nueva posición: " + carros.distancia());

                    if (carrilesEnJuego.get(contador).desplazamientoFinal()) {
                        if (podio.primerLugar() == null) {
                            asignarPrimerLugar(jugadorID(carros.conductor().Nombre()));
                        } else if (podio.segundoLugar() == null) {
                            asignarSegundoLugar(jugadorID(carros.conductor().Nombre()));
                        } else if (podio.tercerLugar() == null) {
                            asignarTercerLugar(jugadorID(carros.conductor().Nombre()));
                        }
                    }
                }
                contador++;
            }
            if (podio.estaLleno()) {
                break;
            }
        }

        mostrarPodio();

        repetirJuego();
    }

    public Map<PlayerID, Player> jugadores() {

        return jugadores;

    }

    public Boolean jugando() {

        return jugando;

    }

    public PlayerID jugadorID(String Nombre) {
        PlayerID wID = null;
        for (PlayerID keys : jugadores.keySet()) {
            if (jugadores.get(keys).Nombre().getNombre().equals(Nombre)) {
                wID = keys;
            }
        }
        return wID;
    }

    public Boolean CarroGanador(String Nombre) {
        boolean CaGanador = false;
        if (podio.tercerLugar() == jugadores.get(jugadorID(Nombre))
                || podio.primerLugar() == jugadores.get(jugadorID(Nombre))
                || podio.segundoLugar() == jugadores.get(jugadorID(Nombre))) {
            CaGanador = true;
        }
        return CaGanador;
    }

    public void repetirJuego() {
        Scanner in = new Scanner(System.in);
        System.out.println("Desea jugar otra vez?  Y/N");
        while (!in.hasNext("[yYnN]")) {
            System.out.println("Solo se reciben como respuesta Y/N ");
            in.next();
        }
        String jugarOtro = in.next();
        if (jugarOtro.equals("Y") || jugarOtro.equals("y")) {
            carrosEnJuego.clear();
            carrilesEnJuego.clear();
            Podium podioNuevo = new Podium();
            podio = podioNuevo;
            iniciarJuego();

        }

    }

    public void mostrarPodio() {
        System.out.println("*******Podio*******");
        System.out.println("Primer Lugar: " + podio.primerLugar().Nombre().getNombre());
        System.out.println("Segundo Lugar: " + podio.segundoLugar().Nombre().getNombre());
        System.out.println("Tercer Lugar: " + podio.tercerLugar().Nombre().getNombre());

    }

}

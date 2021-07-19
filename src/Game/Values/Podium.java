package Game.Values;

/**
 *
 * @author wilmar Sanchez
 */
import Game.Player;

public class Podium implements Poss {

    private Player primerLugar;
    private Player segundoLugar;
    private Player tercerLugar;

    public Podium() {
    }

    public void asignarPrimerLugar(Player jugador) {
        primerLugar = jugador;
    }

    public void asignarSegundoLugar(Player jugador) {
        segundoLugar = jugador;
    }

    public void asignarTercerLugar(Player jugador) {
        tercerLugar = jugador;
    }

    @Override
    public Player primerLugar() {
        return primerLugar;
    }

    @Override
    public Player segundoLugar() {
        return segundoLugar;
    }

    @Override
    public Player tercerLugar() {
        return tercerLugar;
    }

    @Override
    public Boolean estaLleno() {
        Boolean lleno = false;
        if (primerLugar != null && segundoLugar != null && tercerLugar != null) {
            lleno = true;
        }
        return lleno;
    }

}

package Game.Values;

/**
 *
 * @author wilmar Sanchez
 */
import Game.Player;

public interface Poss {

    public Player primerLugar();

    public Player segundoLugar();

    public Player tercerLugar();

    public Boolean estaLleno();

}

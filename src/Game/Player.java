package Game;

/**
 *
 * @author wilmar Sanchez
 */
import Ids.Name;
import java.awt.Color;

public class Player {

    private Name Nombre;
    private Color color;
   

    public Player(Name Nombre, Color color, Integer puntos) {
        this.Nombre = Nombre;
        this.color = color;
      
    }

    public Name Nombre() {
        return Nombre;
    }

    public Color color() {
        return color;
    }

    

}

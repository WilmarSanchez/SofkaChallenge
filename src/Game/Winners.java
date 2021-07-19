package Game;

/**
 *
 * @author wilmar Sanchez
 */
import java.io.Serializable;

public class Winners implements Serializable {

    private int ID;
    private String Nombre;
    private int Primero;
    private int Segundo;
    private int Tercero;

    public Winners() {
    }

    public Winners(int ID, String Nombre, int Primero, int Segundo, int Tercero) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Primero = Primero;
        this.Segundo = Segundo;
        this.Tercero = Tercero;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPrimero() {
        return Primero;
    }

    public void setPrimero(int Primero) {
        this.Primero = Primero;
    }

    public int getSegundo() {
        return Segundo;
    }

    public void setSegundo(int Segundo) {
        this.Segundo = Segundo;
    }

    public int getTercero() {
        return Tercero;
    }

    public void setTercero(int Tercero) {
        this.Tercero = Tercero;
    }

}

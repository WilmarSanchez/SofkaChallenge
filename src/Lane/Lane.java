package Lane;

/**
 *
 * @author wilmar Sanchez
 */
import Ids.GameID;
import Ids.CarID;
import Position.Position;

public class Lane {

    protected CarID carroID;
    protected GameID juegoID;
    protected Position posicion;
    protected Integer metros;
    protected Boolean desplazamientoFinal;

    public Lane(CarID carroID, GameID juegoID, Position posicion, Integer metros, Boolean desplazamientoFinal) {

        this.juegoID = juegoID;
        this.posicion = posicion;
        this.metros = metros;
        this.desplazamientoFinal = desplazamientoFinal;
    }

    public void alcanzarMeta() {
        if (posicionActual() >= posicionDeseada()) {
            desplazamientoFinal = true;
        }

    }

    public void moverCarro(Position posicion, Integer cantidad) {
        this.posicion = posicion;
        posicion.setActual(posicion.actual() + cantidad);
        alcanzarMeta();
    }

    public Integer metros() {

        return metros;

    }

    public Position posicion() {

        return posicion;

    }

    public Integer posicionActual() {

        return posicion.actual();

    }

    public Integer posicionDeseada() {
        return posicion.meta();
    }

    public Boolean desplazamientoFinal() {

        return desplazamientoFinal;

    }

}

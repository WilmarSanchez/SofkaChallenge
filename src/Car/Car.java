package Car;

/**
 *
 * @author wilmar Sanchez
 */
import Ids.CarID;
import Ids.GameID;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class Car {

    protected Driver conductor;
    protected Integer distancia;
    protected Color color;
    protected GameID juegoID;
    private final Map<CarID, Driver> carros = new HashMap<>();

    public Car() {
    }

    public Car(Driver conductor, Integer distancia, Color color, GameID juegoID) {
        this.conductor = conductor;
        this.distancia = distancia;
        this.color = color;
        this.juegoID = juegoID;
    }

    public void asignarConductor(CarID carroID, Driver conductor) {
        carros.put(carroID, conductor);

    }

    public Map<CarID, Driver> carros() {
        return carros;

    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Integer numeroCarros() {
        return carros.size();
    }

    public Driver conductor() {

        return conductor;

    }

    public Integer distancia() {

        return distancia;

    }

    public Color color() {

        return color;

    }

}
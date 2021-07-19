package Car;

/**
 *
 * @author wilmar Sanchez
 */
public class Driver {

    private String Nombre;

    public Driver() {
    }

    public Driver(String Nombre) {
        this.Nombre = Nombre;
    }

    public String Nombre() {
        return Nombre;

    }

    public Integer lanzarDado() {
        int dadoAleatorio = (int) (Math.random() * 6 + 1);
        return dadoAleatorio;
    }

}

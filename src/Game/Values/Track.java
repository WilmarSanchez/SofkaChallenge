package Game.Values;

/**
 *
 * @author wilmar Sanchez
 */
public class Track implements Values {

    public Track(Integer kilometros, Integer numeroDeCarriles) {
        this.kilometros = kilometros;
        this.numeroDeCarriles = numeroDeCarriles;
    }

    private Integer kilometros;
    private Integer numeroDeCarriles;

    @Override
    public Integer kilometros() {
        return kilometros;
    }

    @Override
    public Integer numeroDeCarriles() {
        return numeroDeCarriles;
    }

}

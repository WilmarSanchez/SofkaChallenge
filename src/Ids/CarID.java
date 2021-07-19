package Ids;

/**
 *
 * @author wilmar Sanchez
 */
import java.util.UUID;

public class CarID {

    private final UUID ID;

    public CarID(UUID ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID.toString();
    }

}

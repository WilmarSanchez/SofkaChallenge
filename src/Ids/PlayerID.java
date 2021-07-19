package Ids;

/**
 *
 * @author wilmar Sanchez
 */
import java.util.UUID;

public class PlayerID {

    private final UUID ID;

    public PlayerID(UUID ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID.toString();
    }

}

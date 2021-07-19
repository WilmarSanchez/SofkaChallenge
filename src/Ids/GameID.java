package Ids;

/**
 *
 * @author wilmar Sanchez
 */
import java.util.UUID;

public class GameID {

    private final UUID ID;

    public GameID(UUID ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID.toString();
    }

}

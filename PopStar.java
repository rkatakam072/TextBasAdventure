import java.util.List;

public class PopStar extends GenericEntity {

    public PopStar(String name, World.Room currentRoom) {
        super(name, null, currentRoom);
    }

    @Override
    public void move() {
        List<World.Room> neighbors = getRoom().getNeighbors();

        for (World.Room room : neighbors) {
            for (Entity entity : room.getEntitiesInRoom()) {
                if (entity.getName().equals("player")) {
                    setCurrentRoom(room);
                    return;
                }
            }
        }
    }
}
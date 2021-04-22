import java.util.List;

public class Wumpus extends GenericEntity{

    public Wumpus(String name, World.Room currentRoom) {
        super(name,null, currentRoom);
    }

    @Override
    public void move() {
        List<World.Room> neighbors = getRoom().getNeighbors();

        for (World.Room room : neighbors) {
            for (Entity entity : room.getEntitiesInRoom()) {
                if (entity.getName().equals("player")) {
                    setCurrentRoom(neighbors.get((int) (Math.random() * neighbors.size())));
                    return;
                }
            }
        }
    }
}

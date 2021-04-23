import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class World {

    private final ArrayList<Room> rooms;
    private final ArrayList<Entity> entities;

    public World() {
        rooms = new ArrayList<>();
        entities = new ArrayList<>();
        initialRoomSetup();

        initializeEntities();
    }

    private void initializeEntities() {
        entities.add(new Player(getRoom("hall")));
        entities.add(new Wumpus("wumpus", getRoom("closet")));
        entities.add(new PopStar("popstar", getRoom("dungeon")));
   }

    private void initialRoomSetup() {
        this.addRoom("hall");
        this.addRoom("closet");
        this.addRoom("dungeon");

        this.addDirectedEdge("Hall", "dungeon");
        this.addUndirectedEdge("hall", "closet");
    }

    public void addRoom(String name) {
        rooms.add(new Room(name));
    }

    public void addDirectedEdge(String name1, String name2) {
        for (Room room : rooms) {
            if (room.getName().equals(name1)) {
                room.addNeighbor(new Room(name2));
                return;
            }
        }
        addRoom(name1);
        Room room = rooms.get(rooms.size() - 1);
        room.addNeighbor(new Room(name2));
    }

    public void addUndirectedEdge(String name1, String name2) {
        addDirectedEdge(name1, name2);
        addDirectedEdge(name2, name1);
    }

    public Room getRoom(String string) {
        for (Room room : rooms) {
            if (room.getName().equals(string))
                return room;
        }

        return null;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void moveEntities() {
        entities.forEach(e -> e.move());
    }

    public class Room implements ItemContainer {
        private final String name;
        private final ArrayList<Room> neighbors;
        private final ArrayList<Item> items;

        private Room(String name) {
            this.name = name;
            neighbors = new ArrayList<>();
            items = new ArrayList<>();
        }

        @Override
        public ArrayList<Item> getListOfItems() {
            return items;
        }

        public void addNeighbor(Room room) {
            neighbors.add(room);
        }

        public void addNeighbor(String string) {
            neighbors.add(new Room(string));
        }

        public String getNeighborNames() {
            StringBuilder string = new StringBuilder();

            for (Room room : neighbors) {
                string.append(" ").append(room.getName());
            }

            return string.toString();
        }

        public String getEntitiesNames() {
            StringBuilder string = new StringBuilder();

            for (Entity entity : entities) {
                if (entity.getRoom() == this)
                    string.append(" ").append(entity.getName());
            }

            return string.toString();
        }

        public Room getNeighbor(String name) {
            for (Room room : neighbors) {
                if (room.getName().equals(name))
                    return room;
            }

            return null;
        }

        public String getName() {
            return name;
        }

        public List<Room> getNeighbors() {
            return Collections.unmodifiableList(neighbors);
        }

        public List<Entity> getEntitiesInRoom() {

            List<Entity> entities = new ArrayList<>();
            for (Entity entity : entities) {
                if (entity.getRoom() == this)
                    entities.add(entity);
            }

            return Collections.unmodifiableList(entities);
        }

        public Entity removeEntity(GenericEntity genericEntity) {
            for (Entity entity : entities) {
                if (entity.getRoom() == this) {
                    entities.remove(entity);
                    return entity;
                }
            }
            return null;
        }
    }
}
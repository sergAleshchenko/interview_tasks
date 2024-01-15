package others;

public class StoneService {
    public void buildHouse(Stone stone) {
        try {
            stone.accept("some info");
        } catch (ResourceException e) {
            System.err.println(e);
        }
    }
}

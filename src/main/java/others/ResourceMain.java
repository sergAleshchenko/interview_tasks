package others;

public class ResourceMain {

    public static void main(String[] args) {

        try {
            Resource resource = new Resource();
            ResourceAction.load(resource);
        } catch (ResourceException e) {
            throw new RuntimeException(e);
        }
    }
}

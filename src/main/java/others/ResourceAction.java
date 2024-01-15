package others;

public class ResourceAction {

    public static void load(Resource resource) throws ResourceException {
        if (resource == null || !resource.exists() || !resource.isCreate()) {
            throw new ResourceException("mess...");
        }
    }
}

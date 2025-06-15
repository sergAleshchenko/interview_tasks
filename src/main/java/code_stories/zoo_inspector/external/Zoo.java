package code_stories.zoo_inspector.external;

import java.util.Collection;

public interface Zoo {
    String getId();

    Collection<Enclosure> getEnclosures();

    void closeEnclosure(Enclosure enclosure);

    void requestSecurityTo(Enclosure enclosure);

    void requestMaintenanceCrewTo(Enclosure enclosure);

    void requestVeterinaryTo(Animal animal);

    Image capturePictureOf(Animal animal);

    Image capturePictureOf(Enclosure enclosure);
}

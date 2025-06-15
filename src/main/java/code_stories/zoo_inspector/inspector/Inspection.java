package code_stories.zoo_inspector.inspector;

import code_stories.zoo_inspector.external.*;

import java.util.Collection;
import java.util.LinkedList;

public class Inspection {
    private static final String WARNING_STATUS = "WARNING";
    private static final String OK_STATUS = "OK";
    private static final String ZOO_STATUS_NAME = "ZOO";
    private static final String ENCLOSURE_STATUS_NAME = "ENCLOSURE";
    private static final String ANIMAL_STATUS_NAME = "ANIMAL";

    private final Zoo zoo;
    private Collection<String> inspectionStatuses ;
    private final ImageRecognitionSystem imageRecognitionSystem;

    public Inspection(Zoo zoo, ImageRecognitionSystem imageRecognitionSystem) {
        this.zoo = zoo;
        this.imageRecognitionSystem = imageRecognitionSystem;
        this.inspectionStatuses = new LinkedList<>();
    }

    void runInspection() {
        inspectEnclosuresAndAnimals();
        reportZooStatus();
    }

    private void inspectEnclosuresAndAnimals() {
        for (Enclosure enclosure : zoo.getEnclosures()) {
            inspectEnclosure(enclosure);
            inspectAnimal(enclosure);
        }
    }

    private void reportZooStatus() {
        String zooStatus = isZooInWarningStatus() ? WARNING_STATUS : OK_STATUS;
        reportStatus(ZOO_STATUS_NAME, zoo.getId(), zooStatus);
    }

    private boolean isZooInWarningStatus() {
        return isNotEmptyInspectionStatuses();
    }

    private boolean isNotEmptyInspectionStatuses() {
        return !inspectionStatuses.isEmpty();
    }

    private void reportEnclosureWarningStatus(Enclosure enclosure) {
        reportStatus(ENCLOSURE_STATUS_NAME, enclosure.getId(), WARNING_STATUS);
    }

    private void reportAnimalWarningStatus(Animal animal) {
        reportStatus(ANIMAL_STATUS_NAME, animal.getName(), WARNING_STATUS);
    }

    private void reportStatus(String objectName, String objectId, String status) {
        inspectionStatuses.add(String.format("%s#%s#%s", objectName, objectId, status));
    }

    private void inspectEnclosure(Enclosure enclosure) {
        Image enclosureImage = zoo.capturePictureOf(enclosure);
        EnclosureStatus enclosureStatus =
                imageRecognitionSystem.recognizeEnclosureStatus(enclosure, enclosureImage);

        if (isNotSafeEnclosure(enclosureStatus)) {
            respondToNotSafeEnclosure(enclosure);
            reportEnclosureWarningStatus(enclosure);
        }
    }

    private boolean isNotSafeEnclosure(EnclosureStatus enclosureStatus) {
        return !enclosureStatus.isEnclosureSafe();
    }

    private void respondToNotSafeEnclosure(Enclosure enclosure) {
        zoo.closeEnclosure(enclosure);
        zoo.requestSecurityTo(enclosure);
        zoo.requestMaintenanceCrewTo(enclosure);
    }

    private void inspectAnimal(Enclosure enclosure) {
        Image animalImage = zoo.capturePictureOf(enclosure.getAnimal());
        AnimalStatus animalStatus =
                imageRecognitionSystem.recognizeAnimalStatus(enclosure.getAnimal(), animalImage);

        if (animalStatus.isAnimalSick()) {
            respondToSickAnimal(enclosure);
            reportAnimalWarningStatus(enclosure.getAnimal());
        }
    }

    private void respondToSickAnimal(Enclosure enclosure) {
        zoo.closeEnclosure(enclosure);
        zoo.requestVeterinaryTo(enclosure.getAnimal());
    }

    public Collection<String> getStatuses() {
        return inspectionStatuses;
    }

}

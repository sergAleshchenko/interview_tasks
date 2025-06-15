package code_stories.zoo_inspector.external;

public interface ImageRecognitionSystem {
    AnimalStatus recognizeAnimalStatus(Animal animal, Image animalImage);

    EnclosureStatus recognizeEnclosureStatus(Enclosure enclosure, Image enclosureImage);
}

package code_stories.zoo_inspector.inspector;

import code_stories.zoo_inspector.external.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ZooInspectorTest {
    private static final String ZOO_ID = "zoo";
    private static final String TEST_ENCLOSURE_ID = "enclosure";
    private static final String TEST_ANIMAL_NAME = "animal";

    @Mock
    private Zoo zoo;

    @Mock
    private ImageRecognitionSystem imageRecognitionSystem;

    private InspectionLogStub inspectionLog;

    private ZooInspector zooInspector;

    @Before
    public void setUp() {
        when(zoo.getId()).thenReturn(ZOO_ID);
        inspectionLog = new InspectionLogStub();
        zooInspector = new ZooInspector(inspectionLog, imageRecognitionSystem);
    }

    @Test
    public void whenNoAnimals_ThenNoRequests() {
        // given
        List<Enclosure> noEnclosures = Collections.emptyList();
        when(zoo.getEnclosures()).thenReturn(noEnclosures);

        // when
        zooInspector.inspect(zoo);

        // then
        verify(zoo, never()).requestMaintenanceCrewTo(any(Enclosure.class));
        verify(zoo, never()).requestSecurityTo(any(Enclosure.class));
        verify(zoo, never()).requestVeterinaryTo(any(Animal.class));
        verify(zoo, never()).closeEnclosure(any(Enclosure.class));

        verifyLog("ZOO#" + ZOO_ID + "#" + "OK");
    }

    @Test
    public void whenEnclosureAndAnimalAlright_ThenNoRequests() {
        // given
        Enclosure enclosure = mock(Enclosure.class);
        Animal animal = mock(Animal.class);
        when(enclosure.getAnimal()).thenReturn(animal);
        List<Enclosure> enclosures = Collections.singletonList(enclosure);
        when(zoo.getEnclosures()).thenReturn(enclosures);

        AnimalStatus animalStatus = mock(AnimalStatus.class);
        EnclosureStatus enclosureStatus = mock(EnclosureStatus.class);
        when(imageRecognitionSystem.recognizeAnimalStatus(any(), any())).thenReturn(animalStatus);
        when(imageRecognitionSystem.recognizeEnclosureStatus(any(), any())).thenReturn(enclosureStatus);
        when(enclosureStatus.isEnclosureSafe()).thenReturn(true);
        when(animalStatus.isAnimalSick()).thenReturn(false);

        // when
        zooInspector.inspect(zoo);

        // then
        verify(zoo, never()).requestMaintenanceCrewTo(any(Enclosure.class));
        verify(zoo, never()).requestSecurityTo(any(Enclosure.class));
        verify(zoo, never()).requestVeterinaryTo(any(Animal.class));
        verify(zoo, never()).closeEnclosure(any(Enclosure.class));

        verifyLog("ZOO#" + ZOO_ID + "#" + "OK");
    }

    @Test
    public void whenEnclosureIsNotSafe_ThenRequests() {
        // given
        Animal animal = mock(Animal.class);
        Enclosure enclosure = mock(Enclosure.class);
        when(enclosure.getAnimal()).thenReturn(animal);
        when(enclosure.getId()).thenReturn(TEST_ENCLOSURE_ID);
        List<Enclosure> enclosures = Collections.singletonList(enclosure);
        when(zoo.getEnclosures()).thenReturn(enclosures);

        AnimalStatus animalStatus = mock(AnimalStatus.class);
        when(animalStatus.isAnimalSick()).thenReturn(false);
        EnclosureStatus enclosureStatus = mock(EnclosureStatus.class);
        when(enclosureStatus.isEnclosureSafe()).thenReturn(false);
        when(imageRecognitionSystem.recognizeAnimalStatus(any(), any())).thenReturn(animalStatus);
        when(imageRecognitionSystem.recognizeEnclosureStatus(any(), any())).thenReturn(enclosureStatus);

        // when
        zooInspector.inspect(zoo);

        // then
        verify(zoo).requestMaintenanceCrewTo(any(Enclosure.class));
        verify(zoo).requestSecurityTo(any(Enclosure.class));
        verify(zoo).closeEnclosure(any(Enclosure.class));
        // but animal is fine
        verify(zoo, never()).requestVeterinaryTo(any(Animal.class));

        verifyLog("ENCLOSURE#" + TEST_ENCLOSURE_ID + "#WARNING", "ZOO#" + ZOO_ID + "#" + "WARNING");
    }

    @Test
    public void whenAnimalIsSick_ThenRequests() {
        // given
        Animal animal = mock(Animal.class);
        when(animal.getName()).thenReturn(TEST_ANIMAL_NAME);
        Enclosure enclosure = mock(Enclosure.class);
        when(enclosure.getAnimal()).thenReturn(animal);
        List<Enclosure> noEnclosures = Collections.singletonList(enclosure);
        when(zoo.getEnclosures()).thenReturn(noEnclosures);

        AnimalStatus animalStatus = mock(AnimalStatus.class);
        when(animalStatus.isAnimalSick()).thenReturn(true);

        EnclosureStatus enclosureStatus = mock(EnclosureStatus.class);
        when(enclosureStatus.isEnclosureSafe()).thenReturn(true);

        when(imageRecognitionSystem.recognizeAnimalStatus(any(), any())).thenReturn(animalStatus);
        when(imageRecognitionSystem.recognizeEnclosureStatus(any(), any())).thenReturn(enclosureStatus);

        // when
        zooInspector.inspect(zoo);

        // then
        verify(zoo).closeEnclosure(any(Enclosure.class));
        verify(zoo).requestVeterinaryTo(any(Animal.class));
        // but enclosure is fine
        verify(zoo, never()).requestMaintenanceCrewTo(any(Enclosure.class));
        verify(zoo, never()).requestSecurityTo(any(Enclosure.class));

        verifyLog("ANIMAL#" + TEST_ANIMAL_NAME + "#WARNING", "ZOO#" + ZOO_ID + "#" + "WARNING");
    }

    @Test
    public void whenFirstAnimalIsSickAndSecondIsHealth_ThenStillRequest() {
        // given
        Animal sickAnimal = mock(Animal.class, "Sick animal");
        when(sickAnimal.getName()).thenReturn("SICK_ANIMAL");
        Enclosure enclosureWithSickAnimal= mock(Enclosure.class, "Enclosure with sick animal");
        when(enclosureWithSickAnimal.getAnimal()).thenReturn(sickAnimal);

        Animal healthyAnimal = mock(Animal.class);
//        when(healthyAnimal.getName()).thenReturn("HEALTHY_ANIMAL", "Health animal");
        Enclosure enclosureWithHealthyAnimal= mock(Enclosure.class, "eEnclosure with health animal");
        when(enclosureWithHealthyAnimal.getAnimal()).thenReturn(healthyAnimal);


        List<Enclosure> enclosures = Arrays.asList(enclosureWithSickAnimal, enclosureWithHealthyAnimal);
        when(zoo.getEnclosures()).thenReturn(enclosures);

        AnimalStatus sickAnimalStatus = mock(AnimalStatus.class, "Sick animal status");
        when(sickAnimalStatus.isAnimalSick()).thenReturn(true);

        AnimalStatus healthyAnimalStatus = mock(AnimalStatus.class, "Healthy animal status");
        when(healthyAnimalStatus.isAnimalSick()).thenReturn(false);

        EnclosureStatus enclosureStatus = mock(EnclosureStatus.class);
        when(enclosureStatus.isEnclosureSafe()).thenReturn(true);

        when(imageRecognitionSystem.recognizeAnimalStatus(eq(sickAnimal), any())).thenReturn(sickAnimalStatus);
        when(imageRecognitionSystem.recognizeAnimalStatus(eq(healthyAnimal), any())).thenReturn(healthyAnimalStatus);
        when(imageRecognitionSystem.recognizeEnclosureStatus(any(), any())).thenReturn(enclosureStatus);

        // when
        zooInspector.inspect(zoo);

        // then
        verify(zoo).closeEnclosure(enclosureWithSickAnimal);
        verify(zoo).requestVeterinaryTo(sickAnimal);
        // but enclosure is fine
        verify(zoo, never()).requestMaintenanceCrewTo(any(Enclosure.class));
        verify(zoo, never()).requestSecurityTo(any(Enclosure.class));

        verifyLog("ANIMAL#" + "SICK_ANIMAL" + "#WARNING", "ZOO#" + ZOO_ID + "#" + "WARNING");
    }

    private void verifyLog(String... statuses) {
        Collection<String> expectedStatuses = Arrays.asList(statuses);
        Collection<String> actualStatuses = inspectionLog.getStatuses();
        assertEquals(expectedStatuses, actualStatuses);
    }


    private class InspectionLogStub implements InspectionLog {

        private Collection<String> statuses;

        public void log(Collection<String> statuses) {
            this.statuses = statuses;
        }

        Collection<String> getStatuses() {
            return statuses;
        }
    }
}
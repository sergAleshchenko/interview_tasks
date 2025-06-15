package code_stories.zoo_inspector.inspector;

import code_stories.zoo_inspector.external.*;

import java.util.Collection;
import java.util.LinkedList;

public class ZooInspector {
    private final InspectionLog inspectionLog;
    private final ImageRecognitionSystem imageRecognitionSystem;

    public ZooInspector(InspectionLog inspectionLog, ImageRecognitionSystem imageRecognitionSystem) {
        this.inspectionLog = inspectionLog;
        this.imageRecognitionSystem = imageRecognitionSystem;
    }

    public void inspect(Zoo zoo) {
        Inspection inspection = new Inspection(zoo, imageRecognitionSystem);
        inspection.runInspection();
        inspectionLog.log(inspection.getStatuses());
    }
}

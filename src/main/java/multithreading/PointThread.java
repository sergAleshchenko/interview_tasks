package multithreading;


public class PointThread extends Thread {
    private PointManager pointManager;
    private boolean writeStatus;
    private Point point;

    public PointThread(PointManager pointManager, Point point, boolean writeStatus) {
        this.pointManager = pointManager;
        this.writeStatus = writeStatus;
        this.point = point;
    }

    @Override
    public void run() {
        if (writeStatus) {
            pointManager.randomChangePoint(point);
        } else {
            pointManager.length(point);
        }
    }
}

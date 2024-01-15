package patterns.bridge;

import patterns.bridge.devices.Device;
import patterns.bridge.devices.Radio;
import patterns.bridge.devices.TV;
import patterns.bridge.remotes.AdvancedRemote;
import patterns.bridge.remotes.BasicRemote;

/**
 * @author Sergei Aleshchenko
 */
public class Demo {
    public static void main(String[] args) {

        testDevice(new TV());
        testDevice(new Radio());
    }


    public static void testDevice(Device device) {
        System.out.println("Test with basic remote");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Test with advanced remote");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}

package patterns.bridge.remotes;

import patterns.bridge.devices.Device;

/**
 * @author Sergei Aleshchenko
 */
public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}

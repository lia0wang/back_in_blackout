package unsw.blackout.models.devices;

import unsw.blackout.models.superclasses.Device;
import unsw.utils.Angle;

final public class DesktopDevice extends Device{
    /*
     * Constructor
     */
    public DesktopDevice(String deviceId, Angle position) {
        super(deviceId, position, 200000.0);
    }
}

package unsw.blackout.models.devices;

import unsw.blackout.models.superclasses.Device;
import unsw.utils.Angle;

final public class HandheldDevice extends Device {
    /*
     * Constructor
     */
    public HandheldDevice(String deviceId, Angle position) {
        super(deviceId, position, 50000.0);
    }
}
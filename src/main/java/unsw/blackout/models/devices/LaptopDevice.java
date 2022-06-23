package unsw.blackout.models.devices;

import unsw.blackout.models.superclasses.Device;
import unsw.utils.Angle;

public class LaptopDevice extends Device{
    /*
     * Constructor
     */
    public LaptopDevice(String deviceId, Angle position) {
        super(deviceId, position, 100000.0);
    }
}

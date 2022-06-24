package unsw.blackout.models.devices;

import unsw.blackout.models.superclasses.Device;
import unsw.utils.Angle;

/**
 * Represents the Desktop Device class
 *
 * @note this is the lowest level class in the hierarchy of devices
 *
 * @author Wang Liao
 */
final public class DesktopDevice extends Device {
    /**
     * Constructor
     * @param uniqueId
     * @param position
     * @param maxRange
     */
    final static private Integer MAX_RANGE = 200000;
    public DesktopDevice(String uniqueId, Angle position) {
        super(uniqueId, position, MAX_RANGE);
    }
}

package unsw.blackout.models.superclasses;

import unsw.utils.Angle;
import unsw.utils.MathsHelper;

public class Device extends Entity {
    public Device(String deviceId, Angle position, Double maxRange) {
        super(deviceId, position, MathsHelper.RADIUS_OF_JUPITER, maxRange);
    }
}
package unsw.blackout.models.superclasses;

import unsw.utils.Angle;
import unsw.utils.MathsHelper;

/**
 * Represents a generic entity object superclass for Device.
 * @author Wang Liao
 */
public class Device extends BaseObject {
    /**
     * Constructor
     * @param uniqueId
     * @param position
     * @param maxRange
     */
    final protected Double FIXED_HEIGHT = MathsHelper.RADIUS_OF_JUPITER;
    public Device(String uniqueId, Angle position, Integer maxRange) {
        super(uniqueId, position, maxRange);
        setHeight(FIXED_HEIGHT);
    }
}
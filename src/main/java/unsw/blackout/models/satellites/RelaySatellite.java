package unsw.blackout.models.satellites;

import unsw.blackout.models.superclasses.Satellite;
import unsw.utils.Angle;

/**
 * Represents the Relay Satellite class
 *
 * @note this is the lowest level class in the hierarchy of satellites
 *
 * @author Wang Liao
 *
 */
final public class RelaySatellite extends Satellite {
    
    /**
     * Attributes
     */
    final static private Integer MAX_RANGE = 300000;
    final static private Integer LINEAR_VELOCITY = 1500;
    private Integer direction;
    /**
     * Constructor
     * @param uniqueId
     * @param position
     * @param height
     */
    public RelaySatellite(String uniqueId, Angle position, Double height) {
        super(uniqueId, position, MAX_RANGE, height, LINEAR_VELOCITY);
        this.direction = -1;
    }
    
    public void setDirection(Integer direction) {
        this.direction *= -1;
    }
    
    public Integer getDirection() {
        return this.direction;
    }
}
package unsw.blackout.models.superclasses;

import unsw.utils.Angle;

/**
 * Represents the Satellite class
 *
 * @note this is the highest level class in the hierarchy of satellites
 *
 * @author Wang Liao
 */
public class Satellite extends BaseObject {
    protected Integer linearVelocity;
    /**
     * Constructor
     * @param uniqueId
     * @param position
     * @param maxRange
     * @param height
     * @param linearVelocity
     */
    public Satellite(String uniqueId, Angle position, Integer maxRange, Double height, Integer linearVelocity) {
        super(uniqueId, position, maxRange);
        setHeight(height);
        this.linearVelocity = linearVelocity;
    }
    
    /**
     * Getters and Setters
     */
    public Integer getLinearVelocity() {
        return linearVelocity;
    }
    
    public void setLinearVelocity(Integer linearVelocity) {
        this.linearVelocity = linearVelocity;
    }
    
}
package unsw.blackout.models.satellites.storage_satellite;

import java.util.List;

import unsw.utils.Angle;

/**
 * Represents the Standard Satellite class
 *
 * @note this is the lowest level class in the hierarchy of satellites
 *
 * @author Wang Liao
 *
 */
final public class StandardSatellite extends StorageSatellite {
    
    /**
     * Attributes
     */
    final static private Integer FILES_STORAGE_CAPACITY = 3;
    final static private Integer BYTES_STORAGE_CAPACITY = 80;
    final static private Integer SPEED_OF_RECEIVE_FILE = 1;
    final static private Integer SPEED_OF_SEND_FILE = 1;
    final static private Integer MAX_RANGE = 150000;
    final static private Integer LINEAR_VELOCITY = 2500;
    final static private List<String> SUPPORTED_TYPES = List.of("HandheldDevice", "LaptopDevice");
    
    /**
     * Constructor
     * @param uniqueId
     * @param position
     * @param height
     */
    public StandardSatellite(String uniqueId, Angle position, Double height) {
        super(uniqueId, position, MAX_RANGE, height, LINEAR_VELOCITY, FILES_STORAGE_CAPACITY, BYTES_STORAGE_CAPACITY, SPEED_OF_RECEIVE_FILE, SPEED_OF_SEND_FILE);
        setSupportedTypes(SUPPORTED_TYPES);
    }
}
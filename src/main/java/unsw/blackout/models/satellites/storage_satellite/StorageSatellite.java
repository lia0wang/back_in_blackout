package unsw.blackout.models.satellites.storage_satellite;


import unsw.blackout.models.superclasses.Satellite;
import unsw.utils.Angle;
import java.util.List;

/**
 * Represents the Storage Satellite class
 *
 * @note this is the 2-nd highest level class in the hierarchy of satellites
 *
 * @author Wang Liao
 *
 */
public class StorageSatellite extends Satellite {
    protected Integer maxFilesStorage;
    protected Integer maxBytesStorage;
    protected Integer SpeedOfReceiving;
    protected Integer SpeedOfSending;
    protected Integer NumOfFilesReceiving;
    protected Integer NumOfFilesSending;
    protected List<String> supportedTypes;
    
    /**
     * Constructor
     * @param uniqueId
     * @param position
     * @param maxRange
     * @param height
     * @param linearVelocity
     * @param maxFilesStorage
     * @param maxBytesStorage
     * @param SpeedOfReceiving
     * @param SpeedOfSending
     */
    public StorageSatellite(String uniqueId, Angle position, Integer maxRange, Double height, Integer linearVelocity, Integer maxFilesStorage, Integer maxBytesStorage, Integer SpeedOfReceiving, Integer SpeedOfSending) {
        super(uniqueId, position, maxRange, height, linearVelocity);
        this.maxFilesStorage = maxFilesStorage;
        this.maxBytesStorage = maxBytesStorage;
        this.SpeedOfReceiving = SpeedOfReceiving;
        this.SpeedOfSending = SpeedOfSending;
        this.NumOfFilesReceiving = 0;
        this.NumOfFilesSending = 0;
    }
    
    /**
     * Getters and Setters
     */
    public Integer getMaxFilesStorage() {
        return maxFilesStorage;
    }
    
    public void setMaxFilesStorage(Integer maxFilesStorage) {
        this.maxFilesStorage = maxFilesStorage;
    }
    
    public Integer getMaxBytesStorage() {
        return maxBytesStorage;
    }
    
    public void setMaxBytesStorage(Integer maxBytesStorage) {
        this.maxBytesStorage = maxBytesStorage;
    }
    
    public Integer getSpeedOfReceiving() {
        return SpeedOfReceiving;
    }
    
    public void setSpeedOfReceiving(Integer SpeedOfReceiving) {
        this.SpeedOfReceiving = SpeedOfReceiving;
    }
    
    public Integer getSpeedOfSending() {
        return SpeedOfSending;
    }
    
    public void setSpeedOfSending(Integer SpeedOfSending) {
        this.SpeedOfSending = SpeedOfSending;
    }
    
    public Integer getNumOfFilesReceiving() {
        return NumOfFilesReceiving;
    }
    
    public void setNumOfFilesReceiving(Integer NumOfFilesReceiving) {
        this.NumOfFilesReceiving = NumOfFilesReceiving;
    }
    
    public Integer getNumOfFilesSending() {
        return NumOfFilesSending;
    }
    
    public void setNumOfFilesSending(Integer NumOfFilesSending) {
        this.NumOfFilesSending = NumOfFilesSending;
    }
    
    public List<String> getSupportedTypes() {
        return supportedTypes;
    }
    
    public void setSupportedTypes(List<String> supportedTypes) {
        this.supportedTypes = supportedTypes;
    }
    
    /**
     * Helper Methods
     */
    
    /**
     * Get bandwidth of receiving
     * bandwidth = speed of receiving / number of files receiving
     * @return bandwidth of receiving
     */
    public Integer getBandwidthOfReceiving() {
        return this.NumOfFilesReceiving > 0 ? this.SpeedOfReceiving / this.NumOfFilesReceiving : this.SpeedOfReceiving;
    }
    
    /**
     * Get bandwidth of sending
     * bandwidth = speed of sending / number of files sending
     * @return bandwidth of sending
     */
    public Integer getBandwidthOfSending() {
        return this.NumOfFilesSending > 0 ? this.SpeedOfSending / this.NumOfFilesSending : this.SpeedOfSending;
    }
    
    /**
     * Increase the number of files receiving
     */
    public void increaseNumOfFilesReceiving(Integer num) {
        this.NumOfFilesReceiving += num;
    }
    
    /**
     * Increase the number of files sending
     */
    public void increaseNumOfFilesSending(Integer num) {
        this.NumOfFilesSending += num;
    }
    
    /**
     * Check if capacity of storage is enough
     * @return true if capacity of storage is enough
     */
    public boolean isCapacityEnough() {
        return getTotalFileSize() <= this.maxBytesStorage;
    }
    
    /**
     * Check if the type is supported
     * @param type
     * @return true if the type is supported
     */
    public boolean isTypeSupported(String type) {
        return this.supportedTypes.contains(type);
    }
    
    /**
     * Check if the receiving bandwidth is enough
     * @return true if the receiving bandwidth is enough
     */
    public boolean isReceivingBandwidthEnough() {
        return getBandwidthOfReceiving() >= 1;
    }
    
    /**
     * Check if the sending bandwidth is enough
     * @return true if the sending bandwidth is enough
     */
    public boolean isSendingBandwidthEnough() {
        return getBandwidthOfSending() >= 1;
    }
    
}
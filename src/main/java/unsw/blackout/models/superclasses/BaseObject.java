package unsw.blackout.models.superclasses;

import unsw.utils.Angle;
import java.util.HashMap;

/**
 * Represents a generic entity object superclass for Device and Satellite.
 * 
 * @note this is the highest level class in the hierarchy
 * 
 * @author Wang Liao
 */
 
public class BaseObject {
    private String uniqueId;
    private Double height;
    private Angle position;
    private Integer maxRange;
    private HashMap <String, File> files;

    /**
     * Constructor
     * @param uniqueId
     * @param position
     * @param maxRange
     */
    public BaseObject (String uniqueId, Angle position, Integer maxRange) {
        this.uniqueId = uniqueId;
        this.position = position;
        this.maxRange = maxRange;
        this.files = new HashMap<String, File>();
    }
    
    /**
     * Getters and setters for unique id, height, position, and max range
     */
       
    public String getUniqueId() {
        return uniqueId;
    }
    
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
    
    public Double getHeight() {
        return height;
    }
    
    public void setHeight(Double height) {
        this.height = height;
    }
    
    public Angle getPosition() {
        return position;
    }
    
    public void setPosition(Angle position) {
        this.position = position;
    }
    
    public Integer getMaxRange() {
        return maxRange;
    }
    
    public void setMaxRange(Integer maxRange) {
        this.maxRange = maxRange;
    }
    
    public HashMap<String, File> getFiles() {
        return files;
    }
    
    public void setFiles(HashMap<String, File> files) {
        this.files = files;
    }
    
    /**
     * Add a file to the files hashmap
     * @param file
     */
    public void addFile(File file) {
        this.files.put(file.getFileName(), file);
    }
    
    /**
     * Remove a file from the files hashmap
     * @param file
     */
    public void removeFile(String fileName) {
        this.files.remove(fileName);
    }
    
    /**
     * Get a file from the files hashmap
     * @param fileName
     * @return
     */
    public File getFile(String fileName) {
        return this.files.get(fileName);
    }
    
    /**
     * Check if a file exists in the files hashmap
     * @param fileName
     * @return
     */
    public Boolean fileExists(String fileName) {
        return this.files.containsKey(fileName);
    }
    
    /**
     * Check if a file is complete
     * @param fileName
     * @return
     */
    public Boolean isFileComplete(String fileName) {
        return this.files.get(fileName).getHasTransferCompleted();
    }
    
    /**
     * Get the total size of all files
     * @return total size of all files
     */
    public Integer getTotalFileSize() {
        Integer totalSize = 0;
        for (File file : this.files.values()) {
            totalSize += file.getFileSize();
        }
        return totalSize;
    }
    
    /**
     * Get the total size of all files that are complete
     * @return total size of all files that are complete
     */
    public Integer getTotalCompleteFileSize() {
        Integer totalSize = 0;
        for (File file : this.files.values()) {
            if (file.getHasTransferCompleted()) {
                totalSize += file.getFileSize();
            }
        }
        return totalSize;
    }
    
    /**
     * Get the total number of files
     * @return total number of files
     */
    public Integer getTotalFileCount() {
        return this.files.size();
    }
}
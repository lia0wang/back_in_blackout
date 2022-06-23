package unsw.blackout.models.superclasses;

import java.util.HashMap;

import unsw.utils.Angle;

public class Entity {

    /**
     * Attributes
     */
    protected String uniqueId;
    protected Angle position;
    protected Double height;
    protected Double maxRange;
    protected HashMap<String, File> files;
    
    /**
     * Constructor
     */
    public Entity(String uniqueId, Angle position, Double height, Double maxRange) {
        this.uniqueId = uniqueId;
        this.position = position;
        this.height = height;
        this.maxRange = maxRange;
        this.files = new HashMap<String, File>();
    }
    
    /**
     * Getters and Setters
     */
    public String getUniqueId() {
        return uniqueId;
    }
    
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
    
    public Angle getPosition() {
        return position;
    }
    
    public void setPosition(Angle position) {
        this.position = position;
    }
    
    public Double getHeight() {
        return height;
    }
    
    public void setHeight(Double height) {
        this.height = height;
    }
    
    public Double getMaxRange() {
        return maxRange;
    }
    
    public void setMaxRange(Double maxRange) {
        this.maxRange = maxRange;
    }
    
    public HashMap<String, File> getFiles() {
        return files;
    }
    
    public void setFiles(HashMap<String, File> files) {
        this.files = files;
    }
    
    public void addFile(File file) {
        this.files.put(file.getFileName(), file);
    }
    
    public void removeFile(String fileName) {
        this.files.remove(fileName);
    }
    
}

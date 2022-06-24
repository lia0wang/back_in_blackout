package unsw.blackout.models.superclasses;

/**
 * Represents a File class
 * 
 * @note this is the highest level class in the hierarchy of files
 * 
 * @author Wang Liao
 */

public class File {
    protected String toObjectId;
    protected String fileName;
    protected String fileContent;
    protected Integer fileSize;
    protected Boolean hasTransferCompleted;

    /**
     * Constructor
     * @param toObjectId
     * @param fileName
     * @param fileContent
     */
    public File(String toObjectId, String fileName, String fileContent) {
        this.toObjectId = toObjectId;
        this.fileName = fileName;
        this.fileContent = fileContent;
        this.fileSize = fileContent.length();
        this.hasTransferCompleted = true;
    }

    /**
     * Getters and setters for file name, file content, file size, and transfer completed flag
     */
    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public String getFileContent() {
        return fileContent;
    }
    
    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }
    
    public Integer getFileSize() {
        return fileSize;
    }
    
    public void setFileSize() {
        this.fileSize = fileContent.length();
    }
    
    public Boolean getHasTransferCompleted() {
        return hasTransferCompleted;
    }
    
    public void setHasTransferCompleted(Boolean hasTransferCompleted) {
        this.hasTransferCompleted = hasTransferCompleted;
    }
    
    public String getToObjectId() {
        return toObjectId;
    }
    
    public void setToObjectId(String toObjectId) {
        this.toObjectId = toObjectId;
    }
    
    /**
     * Overrides the toString method
    * @return String
     */
    @Override
    public String toString() {
        return "File: " + fileName + " " + fileContent + " " + fileSize + " " + hasTransferCompleted;
    }
    
    /**
     * Extend file content with another string
     * @param str
     */
    public void extendFileContent(String str) {
        this.fileContent += str;
    }
}

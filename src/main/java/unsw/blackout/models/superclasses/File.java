package unsw.blackout.models.superclasses;

public class File {
    
    /**
     * Attributes
     */
    protected String fileName;
    protected String fileContent;
    protected Integer fileSize;
    protected Boolean hasTransferCompleted;
    
    /**
     * Constructor
     */
    public File(String fileName, String fileContent, Integer fileSize) {
        this.fileName = fileName;
        this.fileContent = fileContent;
        this.fileSize = fileContent.length();
        this.hasTransferCompleted = true;
    }

    /**
     * Getters and Setters
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
    
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }
    
    public Boolean getHasTransferCompleted() {
        return hasTransferCompleted;
    }
    
    public void setHasTransferCompleted(Boolean hasTransferCompleted) {
        this.hasTransferCompleted = hasTransferCompleted;
    }
    
    public void addFileContent(String fileContent) {
        this.fileContent += fileContent;
    }
    
    public boolean isFileComplete() {
        return this.fileSize == this.fileContent.length();
    }
}

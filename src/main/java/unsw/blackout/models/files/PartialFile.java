package unsw.blackout.models.files;

import unsw.blackout.models.superclasses.File;

/**
 * Represents a Partial File class
 * 
 * @note this is the lowest level class in the hierarchy of files
 * 
 * @author Wang Liao
 */

final public class PartialFile extends File {
    
    public PartialFile(File file) {
        super(file.getToObjectId(), file.getFileName(), file.getFileContent());
        this.fileSize = file.getFileSize();
        this.hasTransferCompleted = false;
    }
}
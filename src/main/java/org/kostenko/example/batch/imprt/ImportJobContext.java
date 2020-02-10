package org.kostenko.example.batch.imprt;

import java.io.File;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author kostenko
 */
@Named
public class ImportJobContext {
    
    @Inject
    private JobContext jobContext;
    private File file;
    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
}

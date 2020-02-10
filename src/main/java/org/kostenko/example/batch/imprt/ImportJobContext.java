package org.kostenko.example.batch.imprt;

import java.io.File;
import java.util.Optional;
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
    
    private Optional<File> file;


    public Optional<File> getFile() {
        return file;
    }

    public void setFile(Optional<File> file) {
        this.file = file;
    }
}

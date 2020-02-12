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

    private Optional<File> file = Optional.empty();

    public Optional<File> getFile() {
        return getTransientUserData().getFile();
    }

    public void setFile(Optional<File> file) {
        getTransientUserData().setFile(file);
    }

    
    private ImportJobContext getTransientUserData() {
        if (jobContext.getTransientUserData() == null) {
            jobContext.setTransientUserData(this);
        }
        return (ImportJobContext) jobContext.getTransientUserData();
    }
}

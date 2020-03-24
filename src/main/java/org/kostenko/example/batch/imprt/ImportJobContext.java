package org.kostenko.example.batch.imprt;

import java.io.File;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
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
    private Queue<ImportItem> items = new ConcurrentLinkedQueue<>();
    
    public Optional<File> getFile() {
        return getImportJobContext().file;
    }

    public void setFile(Optional<File> file) {
        getImportJobContext().file = file;
    }

    public Queue<ImportItem> getItems() {
        return getImportJobContext().items;
    }

    private ImportJobContext getImportJobContext() {
        if (jobContext.getTransientUserData() == null) {
            jobContext.setTransientUserData(this);
        }
        return (ImportJobContext) jobContext.getTransientUserData();
    }
}

package org.kostenko.example.batch.imprt;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import javax.batch.api.AbstractBatchlet;
import javax.batch.api.BatchProperty;
import javax.batch.runtime.BatchStatus;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author kostenko
 */
@Named
public class FileSelectorBatchlet extends AbstractBatchlet {

    @Inject
    private ImportJobContext jobContext;

    @Inject
    @BatchProperty
    private String path;

    @Override
    public String process() throws Exception {

        Optional<File> file = Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .map(Path::toFile).findAny();

        if (file.isPresent()) {
            jobContext.setFile(file);
        }
        
        System.out.println("fs --> " + file.get().getName());
        return BatchStatus.COMPLETED.name();
    }
}

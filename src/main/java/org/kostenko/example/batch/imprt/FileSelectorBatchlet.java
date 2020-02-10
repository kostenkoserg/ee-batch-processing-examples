package org.kostenko.example.batch.imprt;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import javax.batch.api.AbstractBatchlet;
import javax.batch.api.BatchProperty;
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

    @Inject
    @BatchProperty
    private String extensions;

    @Override
    public String process() throws Exception {

        List<File> filesInFolder = Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
        
        
        return "OK";
    }

}

package org.kostenko.example.batch.imprt;

import java.io.FileInputStream;
import java.util.List;
import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.xml.bind.JAXBContext;

/**
 *
 * @author kostenko
 */
public class JsonParserBatchlet  extends AbstractBatchlet {

    @Inject
    ImportJobContext importJobContext;
    
    @Override
    public String process() throws Exception {
        
        List<ImportItem> items = JsonbBuilder.create().fromJson(new FileInputStream(importJobContext.getFile().get()), List.class);

        for (ImportItem item : items) {
            importJobContext.getItems().add(item);
        }
        
        return BatchStatus.COMPLETED.name();
    }
}

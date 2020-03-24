package org.kostenko.example.batch.imprt;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.bind.JsonbBuilder;

/**
 *
 * @author kostenko
 */
@Named
public class JsonParserBatchlet  extends AbstractBatchlet {

    @Inject
    ImportJobContext importJobContext;
    
    @Override
    public String process() throws Exception {
        
        List<ImportItem> items = JsonbBuilder.create().fromJson(
                new FileInputStream(importJobContext.getFile().get()),
                new ArrayList<ImportItem>(){}.getClass().getGenericSuperclass());

        
            System.out.println("--> Parsed items: " + items);
            importJobContext.getItems().addAll(items);
        
        
        return BatchStatus.COMPLETED.name();
    }
}

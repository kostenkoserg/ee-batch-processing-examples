package org.kostenko.example.batch.imprt;

import java.util.List;
import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import javax.inject.Inject;
import javax.xml.bind.JAXBContext;

/**
 *
 * @author kostenko
 */
public class XmlParserBatchlet  extends AbstractBatchlet {

    @Inject
    ImportJobContext importJobContext;
    
    @Override
    public String process() throws Exception {
        JAXBContext jaxb = JAXBContext.newInstance(ImportItem.class);
        List<ImportItem> items = (List<ImportItem>) jaxb.createUnmarshaller().unmarshal(importJobContext.getFile().get());

        for (ImportItem item : items) {
            importJobContext.getItems().add(item);
        }
        
        return BatchStatus.COMPLETED.name();
    }
}

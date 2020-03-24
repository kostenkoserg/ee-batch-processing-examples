package org.kostenko.example.batch.imprt;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBContext;

/**
 *
 * @author kostenko
 */
@Named
public class XmlParserBatchlet extends AbstractBatchlet {

    @Inject
    ImportJobContext importJobContext;

    @Override
    public String process() throws Exception {
        
        JAXBContext jaxb = JAXBContext.newInstance(ImportItems.class);
        ImportItems items = (ImportItems) jaxb.createUnmarshaller().unmarshal(importJobContext.getFile().get());

        System.out.println("XML items: " + items);
        importJobContext.getItems().addAll(items.getItems());

        return BatchStatus.COMPLETED.name();
    }
}

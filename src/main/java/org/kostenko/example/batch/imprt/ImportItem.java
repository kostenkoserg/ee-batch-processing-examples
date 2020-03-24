package org.kostenko.example.batch.imprt;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kostenko
 */
@Entity
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImportItem {

    @Id
    @XmlAttribute
    @JsonbProperty
    private Long id;
    
    @XmlAttribute
    @JsonbProperty
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ImportItem{" + "id=" + id + ", name=" + name + '}';
    }
}

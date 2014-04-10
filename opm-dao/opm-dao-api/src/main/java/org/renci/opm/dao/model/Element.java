package org.renci.opm.dao.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.renci.opm.dao.Persistable;

@XmlTransient
@javax.persistence.Entity
@Table(name = "element")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "discriminator", discriminatorType = DiscriminatorType.STRING)
public class Element implements Persistable {

    private static final long serialVersionUID = -4073470843291923798L;

    @XmlAttribute(name = "pk")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "element_sequence")
    @SequenceGenerator(name = "element_sequence", sequenceName = "element_sequence", allocationSize = 1, initialValue = 1)
    @Column(name = "pk", nullable = false)
    protected Long primaryKey;

    public Element() {
        super();
    }

    public Long getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Long primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public String toString() {
        return String.format("Element [primaryKey=%s]", primaryKey);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((primaryKey == null) ? 0 : primaryKey.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Element other = (Element) obj;
        if (primaryKey == null) {
            if (other.primaryKey != null)
                return false;
        } else if (!primaryKey.equals(other.primaryKey))
            return false;
        return true;
    }

}

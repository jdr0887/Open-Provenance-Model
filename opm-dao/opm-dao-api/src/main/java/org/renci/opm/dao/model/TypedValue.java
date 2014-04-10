package org.renci.opm.dao.model;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TypedValue", namespace = "http://www.w3.org/ns/prov#", propOrder = {})
@javax.persistence.Entity
@Table(name = "typed_value")
public class TypedValue extends Value {

    private static final long serialVersionUID = 8138582830128718779L;

    @XmlJavaTypeAdapter(QNameAdapter.class)
    @XmlAttribute(name = "type", namespace = "http://www.w3.org/2001/XMLSchema-instance")
    @ManyToOne
    @JoinColumn(name = "type")
    protected QualifiedName type;

    public TypedValue() {
        super();
    }

    public void setValue(Float value) {
        set_float(value);
    }

    public void setValue(Date value) {
        setDateTime(value);
    }

    public void setValue(Boolean value) {
        set_boolean(value);
    }

    public void setValue(String value) {
        setString(value);
    }

    public void setValue(Integer value) {
        setInteger(value);
    }

    public void setValue(QualifiedName value) {
        setQualifiedName(value);
    }

    public QualifiedName getType() {
        return type;
    }

    public void setType(QualifiedName type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("TypedValue [type=%s]", type);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        TypedValue other = (TypedValue) obj;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

}

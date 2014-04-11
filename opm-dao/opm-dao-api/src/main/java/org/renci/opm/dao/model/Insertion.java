package org.renci.opm.dao.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

/**
 * <p>
 * Java class for Insertion complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Insertion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="newDictionary" type="{http://www.w3.org/ns/prov#}IDRef"/>
 *         &lt;element name="oldDictionary" type="{http://www.w3.org/ns/prov#}IDRef"/>
 *         &lt;element name="keyEntityPair" type="{http://www.w3.org/ns/prov#}KeyEntityPair" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.w3.org/ns/prov#}label" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/ns/prov#}type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute ref="{http://www.w3.org/ns/prov#}id"/>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Insertion", propOrder = { "newDictionary", "oldDictionary", "keyEntityPair", "label", "type", "other" })
@javax.persistence.Entity
@Table(name = "opm_insertion")
public class Insertion extends Element {

    private static final long serialVersionUID = 5408771090219888760L;

    @XmlJavaTypeAdapter(IDRefAdapter.class)
    @XmlElement(required = true, type = IDRef.class)
    @ManyToOne
    @JoinColumn(name = "new_dictionary")
    protected QualifiedName newDictionary;

    @XmlJavaTypeAdapter(IDRefAdapter.class)
    @XmlElement(required = true, type = IDRef.class)
    @ManyToOne
    @JoinColumn(name = "old_dictionary")
    protected QualifiedName oldDictionary;

    @XmlElement(required = true)
    protected List<KeyEntityPair> keyEntityPair;

    @ManyToMany(targetEntity = InternationalizedString.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "opm_insertion_opm_internationalized_string", joinColumns = @JoinColumn(name = "insertion_fk"), inverseJoinColumns = @JoinColumn(name = "internationalized_string_fk"))
    protected Set<InternationalizedString> label;

    @ManyToMany(targetEntity = Type.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "opm_insertion_opm_type", joinColumns = @JoinColumn(name = "insertion_fk"), inverseJoinColumns = @JoinColumn(name = "type_fk"))
    protected Set<Type> type;

    @ManyToMany(targetEntity = Other.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "opm_insertion_opm_other", joinColumns = @JoinColumn(name = "insertion_fk"), inverseJoinColumns = @JoinColumn(name = "other_fk"))
    protected Set<Other> other;

    @XmlAttribute(name = "id", namespace = "http://www.w3.org/ns/prov#")
    @XmlJavaTypeAdapter(QNameAdapter.class)
    @ManyToOne
    @JoinColumn(name = "id")
    protected QualifiedName id;

    @XmlAnyAttribute
    @Transient
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public Insertion() {
        super();
        label = new HashSet<InternationalizedString>();
        type = new HashSet<Type>();
        other = new HashSet<Other>();
        otherAttributes = new HashMap<QName, String>();
    }

    public QualifiedName getNewDictionary() {
        return newDictionary;
    }

    public void setNewDictionary(QualifiedName newDictionary) {
        this.newDictionary = newDictionary;
    }

    public QualifiedName getOldDictionary() {
        return oldDictionary;
    }

    public void setOldDictionary(QualifiedName oldDictionary) {
        this.oldDictionary = oldDictionary;
    }

    public List<KeyEntityPair> getKeyEntityPair() {
        return keyEntityPair;
    }

    public void setKeyEntityPair(List<KeyEntityPair> keyEntityPair) {
        this.keyEntityPair = keyEntityPair;
    }

    public Set<InternationalizedString> getLabel() {
        return label;
    }

    public void setLabel(Set<InternationalizedString> label) {
        this.label = label;
    }

    public Set<Type> getType() {
        return type;
    }

    public void setType(Set<Type> type) {
        this.type = type;
    }

    public Set<Other> getOther() {
        return other;
    }

    public void setOther(Set<Other> other) {
        this.other = other;
    }

    public QualifiedName getId() {
        return id;
    }

    public void setId(QualifiedName id) {
        this.id = id;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public void setOtherAttributes(Map<QName, String> otherAttributes) {
        this.otherAttributes = otherAttributes;
    }

    @Override
    public String toString() {
        return String.format("Insertion [primaryKey=%s, id=%s, newDictionary=%s, oldDictionary=%s, keyEntityPair=%s]",
                primaryKey, id, newDictionary, oldDictionary, keyEntityPair);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((keyEntityPair == null) ? 0 : keyEntityPair.hashCode());
        result = prime * result + ((newDictionary == null) ? 0 : newDictionary.hashCode());
        result = prime * result + ((oldDictionary == null) ? 0 : oldDictionary.hashCode());
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
        Insertion other = (Insertion) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (keyEntityPair == null) {
            if (other.keyEntityPair != null)
                return false;
        } else if (!keyEntityPair.equals(other.keyEntityPair))
            return false;
        if (newDictionary == null) {
            if (other.newDictionary != null)
                return false;
        } else if (!newDictionary.equals(other.newDictionary))
            return false;
        if (oldDictionary == null) {
            if (other.oldDictionary != null)
                return false;
        } else if (!oldDictionary.equals(other.oldDictionary))
            return false;
        if (primaryKey == null) {
            if (other.primaryKey != null)
                return false;
        } else if (!primaryKey.equals(other.primaryKey))
            return false;
        return true;
    }

}

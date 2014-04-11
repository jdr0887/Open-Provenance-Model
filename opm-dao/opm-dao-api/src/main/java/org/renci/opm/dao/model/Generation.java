package org.renci.opm.dao.model;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

/**
 * <p>
 * Java class for Generation complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Generation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="entity" type="{http://www.w3.org/ns/prov#}IDRef"/>
 *         &lt;element name="activity" type="{http://www.w3.org/ns/prov#}IDRef" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/ns/prov#}label" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/ns/prov#}location" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/ns/prov#}role" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "Generation", propOrder = { "entity", "activity", "time", "label", "location", "role", "type", "other" })
@javax.persistence.Entity
@Table(name = "opm_generation")
public class Generation extends Element {

    private static final long serialVersionUID = -5817509889532571858L;

    @XmlJavaTypeAdapter(IDRefAdapter.class)
    @XmlElement(required = true, type = IDRef.class)
    @ManyToOne
    @JoinColumn(name = "entity")
    protected QualifiedName entity;

    @XmlJavaTypeAdapter(IDRefAdapter.class)
    @XmlElement(type = IDRef.class)
    @ManyToOne
    @JoinColumn(name = "activity")
    protected QualifiedName activity;

    @XmlSchemaType(name = "dateTime")
    protected Date time;

    @ManyToMany(targetEntity = InternationalizedString.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "opm_generation_opm_internationalized_string", joinColumns = @JoinColumn(name = "generation_fk"), inverseJoinColumns = @JoinColumn(name = "internationalized_string_fk"))
    protected Set<InternationalizedString> label;

    @ManyToMany(targetEntity = Location.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "opm_generation_opm_location", joinColumns = @JoinColumn(name = "generation_fk"), inverseJoinColumns = @JoinColumn(name = "location_fk"))
    protected Set<Location> location;

    @ManyToMany(targetEntity = Role.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "opm_generation_opm_role", joinColumns = @JoinColumn(name = "generation_fk"), inverseJoinColumns = @JoinColumn(name = "role_fk"))
    protected Set<Role> role;

    @ManyToMany(targetEntity = Type.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "opm_generation_opm_type", joinColumns = @JoinColumn(name = "generation_fk"), inverseJoinColumns = @JoinColumn(name = "type_fk"))
    protected Set<Type> type;

    @ManyToMany(targetEntity = Other.class, cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(name = "opm_generation_opm_other", joinColumns = @JoinColumn(name = "generation_fk"), inverseJoinColumns = @JoinColumn(name = "other_fk"))
    protected Set<Other> other;

    @XmlAttribute(name = "id", namespace = "http://www.w3.org/ns/prov#")
    @XmlJavaTypeAdapter(QNameAdapter.class)
    @ManyToOne
    @JoinColumn(name = "id")
    protected QualifiedName id;

    @XmlAnyAttribute
    @Transient
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    public Generation() {
        super();
        label = new HashSet<InternationalizedString>();
        location = new HashSet<Location>();
        type = new HashSet<Type>();
        other = new HashSet<Other>();
        otherAttributes = new HashMap<QName, String>();
    }

    public QualifiedName getEntity() {
        return entity;
    }

    public void setEntity(QualifiedName entity) {
        this.entity = entity;
    }

    public QualifiedName getActivity() {
        return activity;
    }

    public void setActivity(QualifiedName activity) {
        this.activity = activity;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Set<InternationalizedString> getLabel() {
        return label;
    }

    public void setLabel(Set<InternationalizedString> label) {
        this.label = label;
    }

    public Set<Location> getLocation() {
        return location;
    }

    public void setLocation(Set<Location> location) {
        this.location = location;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
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
        return String.format("Generation [primaryKey=%s, id=%s, entity=%s, activity=%s, time=%s]", primaryKey, id,
                entity, activity, time);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((activity == null) ? 0 : activity.hashCode());
        result = prime * result + ((entity == null) ? 0 : entity.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((primaryKey == null) ? 0 : primaryKey.hashCode());
        result = prime * result + ((time == null) ? 0 : time.hashCode());
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
        Generation other = (Generation) obj;
        if (activity == null) {
            if (other.activity != null)
                return false;
        } else if (!activity.equals(other.activity))
            return false;
        if (entity == null) {
            if (other.entity != null)
                return false;
        } else if (!entity.equals(other.entity))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (primaryKey == null) {
            if (other.primaryKey != null)
                return false;
        } else if (!primaryKey.equals(other.primaryKey))
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        return true;
    }

}

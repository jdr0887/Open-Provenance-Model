package org.renci.opm.dao.jpa;

import java.io.StringWriter;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Activity;
import org.renci.opm.dao.model.Document;
import org.renci.opm.dao.model.InternationalizedString;
import org.renci.opm.dao.model.Location;
import org.renci.opm.dao.model.ObjectFactory;
import org.renci.opm.dao.model.QualifiedName;
import org.renci.opm.dao.model.Type;

public class RoundTripTest {

    private static EntityManagerFactory emf;

    private static EntityManager em;

    @BeforeClass
    public static void setup() {
        emf = Persistence.createEntityManagerFactory("test-opm", null);
        em = emf.createEntityManager();
    }

    @Test
    public void roundTrip() {

        OtherDAOImpl otherDAO = new OtherDAOImpl();
        otherDAO.setEntityManager(em);

        LocationDAOImpl locationDAO = new LocationDAOImpl();
        locationDAO.setEntityManager(em);

        TypeDAOImpl typeDAO = new TypeDAOImpl();
        typeDAO.setEntityManager(em);

        InternationalizedStringDAOImpl internationalizedStringDAO = new InternationalizedStringDAOImpl();
        internationalizedStringDAO.setEntityManager(em);

        QualifiedNameDAOImpl qualifiedNameDAO = new QualifiedNameDAOImpl();
        qualifiedNameDAO.setEntityManager(em);

        DocumentDAOImpl documentDAO = new DocumentDAOImpl();
        documentDAO.setEntityManager(em);

        ActivityDAOImpl activityDAO = new ActivityDAOImpl();
        activityDAO.setEntityManager(em);

        QualifiedName exampleQN = new QualifiedName("http://example.org/", "a1", "ex");
        QualifiedName stringQN = new QualifiedName("http://www.w3.org/2001/XMLSchema", "string", "xs");
        QualifiedName intQN = new QualifiedName("http://www.w3.org/2001/XMLSchema", "int", "xs");
        QualifiedName floatQN = new QualifiedName("http://www.w3.org/2001/XMLSchema", "float", "xs");
        QualifiedName qnameQN = new QualifiedName("http://www.w3.org/2001/XMLSchema", "QName", "xs");
        QualifiedName anyURIQN = new QualifiedName("http://www.w3.org/2001/XMLSchema", "anyURI", "xs");
        QualifiedName dateTimeQN = new QualifiedName("http://www.w3.org/2001/XMLSchema", "dateTime", "xs");

        try {
            em.getTransaction().begin();
            Long pk = qualifiedNameDAO.save(exampleQN);
            em.getTransaction().commit();
            exampleQN.setPrimaryKey(pk);

            em.getTransaction().begin();
            pk = qualifiedNameDAO.save(stringQN);
            em.getTransaction().commit();
            stringQN.setPrimaryKey(pk);

            em.getTransaction().begin();
            pk = qualifiedNameDAO.save(intQN);
            em.getTransaction().commit();
            intQN.setPrimaryKey(pk);

            em.getTransaction().begin();
            pk = qualifiedNameDAO.save(floatQN);
            em.getTransaction().commit();
            floatQN.setPrimaryKey(pk);

            em.getTransaction().begin();
            pk = qualifiedNameDAO.save(qnameQN);
            em.getTransaction().commit();
            qnameQN.setPrimaryKey(pk);

            em.getTransaction().begin();
            pk = qualifiedNameDAO.save(anyURIQN);
            em.getTransaction().commit();
            anyURIQN.setPrimaryKey(pk);

            em.getTransaction().begin();
            pk = qualifiedNameDAO.save(dateTimeQN);
            em.getTransaction().commit();
            dateTimeQN.setPrimaryKey(pk);

        } catch (OPMDAOException e) {
            e.printStackTrace();
        }

        ObjectFactory factory = new ObjectFactory();
        Activity activity = factory.createActivity();

        try {
            InternationalizedString is = new InternationalizedString("asdfads");
            em.getTransaction().begin();
            Long internationalizedStringPK = internationalizedStringDAO.save(is);
            em.getTransaction().commit();
            is.setPrimaryKey(internationalizedStringPK);
            activity.getLabel().add(is);
        } catch (OPMDAOException e2) {
            e2.printStackTrace();
        }

        try {
            InternationalizedString is = new InternationalizedString("qwerqwr");
            em.getTransaction().begin();
            Long internationalizedStringPK = internationalizedStringDAO.save(is);
            em.getTransaction().commit();
            is.setPrimaryKey(internationalizedStringPK);
            activity.getLabel().add(is);
        } catch (OPMDAOException e2) {
            e2.printStackTrace();
        }

        try {
            InternationalizedString is = new InternationalizedString("bye");
            is.setLang("en");
            em.getTransaction().begin();
            Long internationalizedStringPK = internationalizedStringDAO.save(is);
            em.getTransaction().commit();
            is.setPrimaryKey(internationalizedStringPK);
            activity.getLabel().add(is);
        } catch (OPMDAOException e2) {
            e2.printStackTrace();
        }

        try {
            InternationalizedString is = new InternationalizedString("bonjour");
            is.setLang("fr");
            em.getTransaction().begin();
            Long internationalizedStringPK = internationalizedStringDAO.save(is);
            em.getTransaction().commit();
            is.setPrimaryKey(internationalizedStringPK);
            activity.getLabel().add(is);
        } catch (OPMDAOException e2) {
            e2.printStackTrace();
        }

        try {
            Type t = new Type();
            t.setValue("asdf");
            t.setType(stringQN);
            em.getTransaction().begin();
            Long pk = typeDAO.save(t);
            em.getTransaction().commit();
            t.setPrimaryKey(pk);
            activity.getType().add(t);
        } catch (OPMDAOException e2) {
            e2.printStackTrace();
        }

        try {
            Type t = new Type();
            t.setValue("qwer");
            t.setType(stringQN);
            em.getTransaction().begin();
            Long pk = typeDAO.save(t);
            em.getTransaction().commit();
            t.setPrimaryKey(pk);
            activity.getType().add(t);
        } catch (OPMDAOException e2) {
            e2.printStackTrace();
        }

        try {
            Type t = new Type();
            t.setValue(1.0F);
            t.setType(floatQN);
            em.getTransaction().begin();
            Long pk = typeDAO.save(t);
            em.getTransaction().commit();
            t.setPrimaryKey(pk);
            activity.getType().add(t);
        } catch (OPMDAOException e2) {
            e2.printStackTrace();
        }

        try {
            Type t = new Type();
            t.setValue(1);
            t.setType(intQN);
            em.getTransaction().begin();
            Long pk = typeDAO.save(t);
            em.getTransaction().commit();
            t.setPrimaryKey(pk);
            activity.getType().add(t);
        } catch (OPMDAOException e2) {
            e2.printStackTrace();
        }

        try {
            Type t = new Type();
            t.setValue(exampleQN);
            t.setType(qnameQN);
            em.getTransaction().begin();
            Long pk = typeDAO.save(t);
            em.getTransaction().commit();
            t.setPrimaryKey(pk);
            activity.getType().add(t);
        } catch (OPMDAOException e2) {
            e2.printStackTrace();
        }

        try {
            Type t = new Type();
            t.setValue(new Date());
            t.setType(dateTimeQN);
            em.getTransaction().begin();
            Long pk = typeDAO.save(t);
            em.getTransaction().commit();
            t.setPrimaryKey(pk);
            activity.getType().add(t);
        } catch (OPMDAOException e2) {
            e2.printStackTrace();
        }

        try {
            Location location = new Location();
            location.setValue("London");
            location.setType(stringQN);
            em.getTransaction().begin();
            Long pk = locationDAO.save(location);
            em.getTransaction().commit();
            location.setPrimaryKey(pk);
            activity.getLocation().add(location);
        } catch (OPMDAOException e2) {
            e2.printStackTrace();
        }

        // try {
        //
        // Other other = new Other();
        // // other.setActivity(activity);
        //
        // DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        // docBuilderFactory.setNamespaceAware(true);
        // DocumentBuilder builder = docBuilderFactory.newDocumentBuilder();
        // org.w3c.dom.Document doc = builder.newDocument();
        // org.w3c.dom.Element el = doc.createElementNS(exampleQN.getNamespaceURI(), exampleQN.getPrefix() + ":"
        // + exampleQN.getLocalPart());
        // el.appendChild(doc.createTextNode("poop"));
        // doc.appendChild(el);
        // other.getAny().add(el);
        // em.getTransaction().begin();
        // Long pk = otherDAO.save(other);
        // em.getTransaction().commit();
        // other.setPrimaryKey(pk);
        // activity.getOther().add(other);
        // } catch (ParserConfigurationException e) {
        // e.printStackTrace();
        // } catch (HearsayDAOException e2) {
        // e2.printStackTrace();
        // }

        try {
            activity.setId(exampleQN);
            activity.setStartTime(new Date());
            activity.setEndTime(new Date());
            em.getTransaction().begin();
            Long pk = activityDAO.save(activity);
            em.getTransaction().commit();
            activity.setPrimaryKey(pk);
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }

        try {
            Document document = factory.createDocument();
            document.getEntityOrActivityOrWasGeneratedBy().add(activity);
            em.getTransaction().begin();
            Long documentPK = documentDAO.save(document);
            em.getTransaction().commit();
            document.setPrimaryKey(documentPK);

            JAXBContext context = JAXBContext.newInstance(Document.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            m.marshal(document, sw);
            System.out.println(sw.toString());
        } catch (OPMDAOException e) {
            e.printStackTrace();
        } catch (PropertyException e1) {
            e1.printStackTrace();
        } catch (JAXBException e1) {
            e1.printStackTrace();
        }

    }

    @Test
    public void validate() {

        try {
            DocumentDAOImpl documentDAO = new DocumentDAOImpl();
            documentDAO.setEntityManager(em);
            Document foundDocument = documentDAO.findById(140L);
            // Activity activity = (Activity) foundDocument.getEntityOrActivityOrWasGeneratedBy().iterator().next();
            // Type type = activity.getType().iterator().next();
            // System.out.println(type.toString());
            JAXBContext context = JAXBContext.newInstance(Document.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            m.marshal(foundDocument, sw);
            System.out.println(sw.toString());
        } catch (PropertyException e1) {
            e1.printStackTrace();
        } catch (JAXBException e1) {
            e1.printStackTrace();
        } catch (OPMDAOException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public static void tearDown() {
        em.close();
        emf.close();
    }

}

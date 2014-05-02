package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.PersonDAO;
import org.renci.opm.dao.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class PersonDAOImpl extends BaseDAOImpl<Person, Long> implements PersonDAO {

    private final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

    public PersonDAOImpl() {
        super(Person.class);
    }

    @Override
    public Long save(Person entity) throws OPMDAOException {
        logger.debug("ENTERING save(Person)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Person findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Person entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Person.class);
        return entity;
    }

}

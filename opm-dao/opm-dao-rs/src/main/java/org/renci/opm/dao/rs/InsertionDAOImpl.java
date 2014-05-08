package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.InsertionDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Insertion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class InsertionDAOImpl extends BaseDAOImpl<Insertion, Long> implements InsertionDAO {

    private final Logger logger = LoggerFactory.getLogger(InsertionDAOImpl.class);

    public InsertionDAOImpl() {
        super(Insertion.class);
    }

    @Override
    public Long save(Insertion entity) throws OPMDAOException {
        logger.debug("ENTERING save(Influence)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Insertion findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Insertion entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Insertion.class);
        return entity;
    }

}

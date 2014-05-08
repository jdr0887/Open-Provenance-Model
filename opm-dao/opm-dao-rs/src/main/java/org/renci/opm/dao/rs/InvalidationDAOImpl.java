package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.InvalidationDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Invalidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class InvalidationDAOImpl extends BaseDAOImpl<Invalidation, Long> implements InvalidationDAO {

    private final Logger logger = LoggerFactory.getLogger(InvalidationDAOImpl.class);

    public InvalidationDAOImpl() {
        super(Invalidation.class);
    }

    @Override
    public Long save(Invalidation entity) throws OPMDAOException {
        logger.debug("ENTERING save(Invalidation)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Invalidation findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Invalidation entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML)
                .get(Invalidation.class);
        return entity;
    }

}

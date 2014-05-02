package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.RevisionDAO;
import org.renci.opm.dao.model.Revision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class RevisionDAOImpl extends BaseDAOImpl<Revision, Long> implements RevisionDAO {

    private final Logger logger = LoggerFactory.getLogger(RevisionDAOImpl.class);

    public RevisionDAOImpl() {
        super(Revision.class);
    }

    @Override
    public Long save(Revision entity) throws OPMDAOException {
        logger.debug("ENTERING save(Revision)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Revision findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Revision entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Revision.class);
        return entity;
    }

}

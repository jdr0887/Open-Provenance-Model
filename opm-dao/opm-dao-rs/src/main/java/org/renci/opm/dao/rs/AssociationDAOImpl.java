package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.AssociationDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Association;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class AssociationDAOImpl extends BaseDAOImpl<Association, Long> implements AssociationDAO {

    private final Logger logger = LoggerFactory.getLogger(AssociationDAOImpl.class);

    public AssociationDAOImpl() {
        super(Association.class);
    }

    @Override
    public Long save(Association entity) throws OPMDAOException {
        logger.debug("ENTERING save(Association)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Association findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Association entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Association.class);
        return entity;
    }

}

package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.EndDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.End;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class EndDAOImpl extends BaseDAOImpl<End, Long> implements EndDAO {

    private final Logger logger = LoggerFactory.getLogger(EndDAOImpl.class);

    public EndDAOImpl() {
        super(End.class);
    }

    @Override
    public Long save(End entity) throws OPMDAOException {
        logger.debug("ENTERING save(End)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public End findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        End end = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(End.class);
        return end;
    }

}

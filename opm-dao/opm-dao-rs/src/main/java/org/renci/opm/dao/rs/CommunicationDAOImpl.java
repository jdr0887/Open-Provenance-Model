package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.CommunicationDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Communication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class CommunicationDAOImpl extends BaseDAOImpl<Communication, Long> implements CommunicationDAO {

    private final Logger logger = LoggerFactory.getLogger(CommunicationDAOImpl.class);

    public CommunicationDAOImpl() {
        super(Communication.class);
    }

    @Override
    public Long save(Communication entity) throws OPMDAOException {
        logger.debug("ENTERING save(Attribution)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Communication findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Communication entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML)
                .get(Communication.class);
        return entity;
    }

}

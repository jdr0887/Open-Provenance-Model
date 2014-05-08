package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.DelegationDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Delegation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class DelegationDAOImpl extends BaseDAOImpl<Delegation, Long> implements DelegationDAO {

    private final Logger logger = LoggerFactory.getLogger(DelegationDAOImpl.class);

    public DelegationDAOImpl() {
        super(Delegation.class);
    }

    @Override
    public Long save(Delegation entity) throws OPMDAOException {
        logger.debug("ENTERING save(Delegation)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Delegation findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Delegation entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Delegation.class);
        return entity;
    }

}

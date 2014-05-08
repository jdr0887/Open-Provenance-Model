package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.DerivationDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.model.Derivation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class DerivationDAOImpl extends BaseDAOImpl<Derivation, Long> implements DerivationDAO {

    private final Logger logger = LoggerFactory.getLogger(DerivationDAOImpl.class);

    public DerivationDAOImpl() {
        super(Derivation.class);
    }

    @Override
    public Long save(Derivation entity) throws OPMDAOException {
        logger.debug("ENTERING save(Derivation)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Derivation findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Derivation entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Derivation.class);
        return entity;
    }

}

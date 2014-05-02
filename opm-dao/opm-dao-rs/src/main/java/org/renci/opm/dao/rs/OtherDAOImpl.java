package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.OtherDAO;
import org.renci.opm.dao.model.Other;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class OtherDAOImpl extends BaseDAOImpl<Other, Long> implements OtherDAO {

    private final Logger logger = LoggerFactory.getLogger(OtherDAOImpl.class);

    public OtherDAOImpl() {
        super(Other.class);
    }

    @Override
    public Long save(Other entity) throws OPMDAOException {
        logger.debug("ENTERING save(Other)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Other findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Other entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Other.class);
        return entity;
    }

}

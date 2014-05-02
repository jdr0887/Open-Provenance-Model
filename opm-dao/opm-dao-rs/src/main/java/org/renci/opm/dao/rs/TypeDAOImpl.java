package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.TypeDAO;
import org.renci.opm.dao.model.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class TypeDAOImpl extends BaseDAOImpl<Type, Long> implements TypeDAO {

    private final Logger logger = LoggerFactory.getLogger(TypeDAOImpl.class);

    public TypeDAOImpl() {
        super(Type.class);
    }

    @Override
    public Long save(Type entity) throws OPMDAOException {
        logger.debug("ENTERING save(Type)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Type findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Type entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Type.class);
        return entity;
    }

}

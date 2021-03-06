package org.renci.opm.dao.rs;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.RoleDAO;
import org.renci.opm.dao.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jdr0887
 */
public class RoleDAOImpl extends BaseDAOImpl<Role, Long> implements RoleDAO {

    private final Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);

    public RoleDAOImpl() {
        super(Role.class);
    }

    @Override
    public Long save(Role entity) throws OPMDAOException {
        logger.debug("ENTERING save(Role)");
        WebClient client = WebClient.create(getRestServiceURL()).type(MediaType.APPLICATION_XML)
                .accept(MediaType.APPLICATION_XML);
        Response response = client.path("/").post(entity);
        Long id = response.readEntity(Long.class);
        return id;
    }

    @Override
    public Role findById(Long id) throws OPMDAOException {
        logger.debug("ENTERING findById(Long)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Role entity = client.path("findById/{id}", id).accept(MediaType.APPLICATION_XML).get(Role.class);
        return entity;
    }

}

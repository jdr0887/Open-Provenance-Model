package edu.unc.mapseq.dao.rs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.unc.mapseq.config.MaPSeqConfigurationService;
import edu.unc.mapseq.dao.MaPSeqDAOException;
import edu.unc.mapseq.dao.PlatformDAO;
import edu.unc.mapseq.dao.model.Platform;

/**
 * 
 * @author jdr0887
 */
public class PlatformDAOImpl extends BaseEntityDAOImpl<Platform, Long> implements PlatformDAO {

    private final Logger logger = LoggerFactory.getLogger(PlatformDAOImpl.class);

    private MaPSeqConfigurationService configurationService;

    public PlatformDAOImpl() {
        super(Platform.class);
    }

    public void init() {
        setRestServiceURL(String.format("http://%1$s:%2$d/cxf/%3$s/%3$sService", getConfigurationService()
                .getWebServiceHost("localhost"), 8181, Platform.class.getSimpleName()));
    }

    @Override
    public List<Platform> findAll() throws MaPSeqDAOException {
        logger.debug("ENTERING findAll()");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Collection<? extends Platform> results = client.path("findAll").type(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).getCollection(Platform.class);
        return new ArrayList<Platform>(results);
    }

    @Override
    public Long save(Platform entity) throws MaPSeqDAOException {
        return null;
    }

    @Override
    public Platform findById(Long id) throws MaPSeqDAOException {
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Platform platform = client.path("findById/{id}", id).accept(MediaType.APPLICATION_JSON).get(Platform.class);
        return platform;
    }

    @Override
    public Platform findByInstrumentAndModel(String instrument, String model) throws MaPSeqDAOException {
        logger.debug("ENTERING findByInstrumentAndModel(String, String)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Platform ret = client.path("findByInstrumentAndModel/{instrument}/{model}", instrument, model)
                .accept(MediaType.APPLICATION_JSON).get(Platform.class);
        return ret;
    }

    @Override
    public List<Platform> findByInstrument(String instrument) throws MaPSeqDAOException {
        logger.debug("ENTERING findByInstrument(String)");
        WebClient client = WebClient.create(getRestServiceURL(), getProviders());
        Collection<? extends Platform> results = client.path("findByInstrument/{instrument}", instrument)
                .accept(MediaType.APPLICATION_JSON).getCollection(Platform.class);
        return new ArrayList<Platform>(results);
    }

    public MaPSeqConfigurationService getConfigurationService() {
        return configurationService;
    }

    public void setConfigurationService(MaPSeqConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

}

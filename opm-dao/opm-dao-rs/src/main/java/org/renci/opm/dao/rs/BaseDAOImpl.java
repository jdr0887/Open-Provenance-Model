package org.renci.opm.dao.rs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.renci.opm.config.OPMConfigurationService;
import org.renci.opm.dao.BaseDAO;
import org.renci.opm.dao.OPMDAOException;
import org.renci.opm.dao.Persistable;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

public abstract class BaseDAOImpl<T extends Persistable, ID extends Serializable> implements BaseDAO<T, ID> {

    private Class<T> persistentClass;

    private final List<Object> providers = new ArrayList<Object>();

    private OPMConfigurationService configurationService;

    public BaseDAOImpl() {
        super();
        JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        providers.add(provider);
    }

    public BaseDAOImpl(Class<T> persistentClass) {
        this();
        this.persistentClass = persistentClass;
    }

    @Override
    public void delete(List<T> idList) throws OPMDAOException {
        // TODO Auto-generated method stub
    }

    @Override
    public void delete(T entity) throws OPMDAOException {
        // TODO Auto-generated method stub

    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void setPersistentClass(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
    }

    public List<Object> getProviders() {
        return providers;
    }

    public String getRestServiceURL() {
        return String.format("http://%1$s:%2$d/cxf/%3$s/%3$sService",
                getConfigurationService().getWebServiceHost("localhost"), 8181, getPersistentClass().getSimpleName());
    }

    public OPMConfigurationService getConfigurationService() {
        return configurationService;
    }

    public void setConfigurationService(OPMConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

}

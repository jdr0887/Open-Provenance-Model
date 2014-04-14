package org.renci.opm.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T extends Persistable, ID extends Serializable> {

    /**
     * 
     * @param entity
     */
    public abstract Long save(T entity) throws OPMDAOException;

    /**
     * 
     * @param entity
     */
    public abstract void delete(T entity) throws OPMDAOException;

    /**
     * 
     * @param id
     * @throws OPMDAOException
     */
    public abstract void delete(List<T> idList) throws OPMDAOException;

    /**
     * 
     * @param id
     * @return
     */
    public abstract T findById(ID id) throws OPMDAOException;

}

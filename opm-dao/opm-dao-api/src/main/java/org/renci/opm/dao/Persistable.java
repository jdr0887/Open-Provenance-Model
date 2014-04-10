package org.renci.opm.dao;

import java.io.Serializable;

public interface Persistable extends Serializable {

    /**
     * 
     * @return
     */
    public Long getPrimaryKey();

}

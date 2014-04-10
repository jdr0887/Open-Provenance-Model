package org.renci.opm.dao;

public class OPMDAOException extends Exception {

    private static final long serialVersionUID = -7851739902384642707L;

    public OPMDAOException() {
        super();
    }

    public OPMDAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public OPMDAOException(String message) {
        super(message);
    }

    public OPMDAOException(Throwable cause) {
        super(cause);
    }

}

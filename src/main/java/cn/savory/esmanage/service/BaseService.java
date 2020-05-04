package cn.savory.esmanage.service;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public abstract class BaseService {

    private Logger log;

    public BaseService() {
        log = LogManager.getLogger(this.getClass());
    }
}

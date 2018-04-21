package com.mjuApps.springDemo.tasks.task05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotManagedBySpring {

    private static final Logger LOG = LoggerFactory.getLogger(NotManagedBySpring.class);

    private String whoAmI;

    public NotManagedBySpring(String whoAmI) {
        this.whoAmI = whoAmI;
        LOG.info("I am " + whoAmI + " and I'm not managed by Spring");
    }

    public String getWhoAmI() {
        return whoAmI;
    }
}

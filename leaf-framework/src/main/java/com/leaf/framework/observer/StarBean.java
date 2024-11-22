package com.leaf.framework.observer;

import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;

/**
 * @author jhlz
 * @version 1.0.0
 */
public class StarBean {

    public void start(@Observes StartupEvent ev) {
        System.out.println("StartupEvent");
    }
}

package com.bigvienna.monitoring.service.mock.snmp.service;

/**
 * The interface Mock snmp service.
 */
public interface MockSnmpService {

    /**
     * Gets routers data.
     *
     * @return the routers data
     */
    String getRoutersData();


    /**
     * Gets switches data.
     *
     * @return the switches data
     */
    String getSwitchesData();
}

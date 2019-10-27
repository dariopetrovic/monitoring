package com.bigvienna.monitoring.service.mock.snmp.service.impl;

import com.bigvienna.monitoring.service.mock.snmp.service.MockSnmpService;
import org.springframework.stereotype.Service;

@Service("mockSnmpServiceImpl")
public class MockSnmpServiceImpl implements MockSnmpService {

    @Override
    public String getRoutersData() {
        return "Router Data, 123156456456465465, 2019-05-05";
    }

    @Override
    public String getSwitchesData() {
        return "Switch Data, 123156456456465465, 2019-10-10";
    }
}

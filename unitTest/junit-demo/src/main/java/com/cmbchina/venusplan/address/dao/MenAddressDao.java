package com.cmbchina.venusplan.address.dao;

import com.cmbchina.venusplan.address.domain.MenAddress;
import com.cmbchina.venusplan.address.domain.MenAddressCreateDTO;

public class MenAddressDao {
    public Long createMenAddress(MenAddressCreateDTO menAddressCreateDTO) {
        return 2L;
    }
    public MenAddress findById(long id){
        return new MenAddress();
    }
}


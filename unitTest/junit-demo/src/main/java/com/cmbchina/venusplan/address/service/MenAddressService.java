package com.cmbchina.venusplan.address.service;

import com.cmbchina.venusplan.address.dao.MenAddressDao;
import com.cmbchina.venusplan.address.domain.MenAddress;
import com.cmbchina.venusplan.address.domain.MenAddressCreateDTO;

public interface MenAddressService {
    Long createMenAddress(MenAddressCreateDTO menAddressCreateDTO);


}


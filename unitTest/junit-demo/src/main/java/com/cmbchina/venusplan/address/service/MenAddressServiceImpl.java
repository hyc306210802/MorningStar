package com.cmbchina.venusplan.address.service;

import com.cmbchina.venusplan.address.dao.MenAddressDao;
import com.cmbchina.venusplan.address.domain.MenAddressCreateDTO;

public class MenAddressServiceImpl implements MenAddressService {

    private MenAddressDao menAddressDao;

    @Override
    public Long createMenAddress(MenAddressCreateDTO menAddressCreateDTO) {
        return menAddressDao.createMenAddress(menAddressCreateDTO);
    }
}


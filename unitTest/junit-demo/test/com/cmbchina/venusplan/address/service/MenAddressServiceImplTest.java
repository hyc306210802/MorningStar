package com.cmbchina.venusplan.address.service;

import com.cmbchina.venusplan.address.dao.MenAddressDao;
import com.cmbchina.venusplan.address.domain.MenAddress;
import com.cmbchina.venusplan.address.domain.MenAddressCreateDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MenAddressServiceImplTest {
    @InjectMocks
    private MenAddressServiceImpl menAddressService;
    @Mock
    private MenAddressDao menAddressDao;

    @Test
    public void should_get_address_id_create_man_address() {
        //given
        MenAddressCreateDTO menAddressCreateDTO = new MenAddressCreateDTO();
        given(menAddressDao.createMenAddress(menAddressCreateDTO)).willReturn(1L);
        //when
        long menAddressId = menAddressService.createMenAddress(menAddressCreateDTO);
        //then
        Assertions.assertThat(menAddressId).isNotNull().isEqualTo(1L);
        verify(menAddressDao, times(1)).createMenAddress(menAddressCreateDTO);
    }

    @Test
    public void should_find_man_address_by_id() {
        //given
        MenAddress menAddress = new MenAddress();
        given(menAddressDao.findById(5L)).willReturn(menAddress);

        MenAddress menAddress1 = null;

    }
}
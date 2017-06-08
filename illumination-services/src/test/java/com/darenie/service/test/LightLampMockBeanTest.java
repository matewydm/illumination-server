package com.darenie.service.test;

import com.darenie.database.dao.LightLampDataRepository;
import com.darenie.database.model.AddressData;
import com.darenie.database.model.LampModuleData;
import com.darenie.database.model.LightLampData;
import com.darenie.service.impl.LightLampMockBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.constraints.Null;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration

public class LightLampMockBeanTest {

    @Configuration
    static class LightLampMockBeanTestContextConfiguration {

        @Bean
        public LightLampMockBean lightLampMockBean() {
            return new LightLampMockBean();
        }
        @Bean
        public LightLampDataRepository lightLampDataRepository() {
            return mock(LightLampDataRepository.class);
        }
    }

    @Autowired
    private LightLampMockBean lightLampMockBean;
    @Autowired
    private LightLampDataRepository lightLampDataRepository;

    @Test
    public void getStatusTest () {
        LightLampData lampData = prepareLightLampData();

        String status = lightLampMockBean.getLampStatus(lampData);

        Assert.assertEquals(status,LightLampData.Status.BROKEN);
    }

    @Test
    public void setStatusTest () {
        LightLampData lampData = prepareLightLampData();

        lightLampMockBean.setLampStatus(lampData);
    }

    private LightLampData prepareLightLampData(){

        LightLampData dae = mock(LightLampData.class,Mockito.RETURNS_DEEP_STUBS);

        System.out.println(dae.getAddressData().getCity());
        AddressData a =mock(AddressData.class);

        when(a.getCity()).thenReturn("dare");
        when(dae.getAddressData()).thenReturn(a);
        when(dae.getStatus()).thenReturn(LightLampData.Status.BROKEN);

        LightLampData lampData = new LightLampData();
        LampModuleData lampModuleData = new LampModuleData();
        lampModuleData.setId((long) 1);
        lampModuleData.setDescription("Dary modul");
        lampModuleData.setName("DareModule");
        lampModuleData.setIpAddress("127.0.0.1");
        lampModuleData.setPort(8081);

        lampData.setId((long) 1);
        lampData.setDescription("Dara lampa");
        lampData.setName("LampaDare1");

        lampData.setStatus(LightLampData.Status.BROKEN);
        lampData.setLampModuleNumber(1);
        lampData.setLampModuleData(lampModuleData);

        return lampData;
    }


}

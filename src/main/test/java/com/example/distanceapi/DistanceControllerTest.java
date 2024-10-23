package com.example.distanceapi;

import com.example.distanceapi.entity.DistanceEntity;
import com.example.distanceapi.service.DistanceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class DistanceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DistanceService distanceService;

    @Test
    public void testGetDistance() throws Exception {
        DistanceEntity mockEntity = new DistanceEntity();
        mockEntity.setFromPincode("141106");
        mockEntity.setToPincode("110060");
        mockEntity.setDistance(250.0);
        mockEntity.setDuration("3 hours");

        when(distanceService.getDistance(anyString(), anyString())).thenReturn(mockEntity);

        mockMvc.perform(get("/api/distances")
                .param("fromPincode", "141106")
                .param("toPincode", "110060"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.distance").value(250.0))
                .andExpect(jsonPath("$.duration").value("3 hours"));
    }
}






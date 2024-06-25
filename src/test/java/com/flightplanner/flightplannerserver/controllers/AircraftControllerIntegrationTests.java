package com.flightplanner.flightplannerserver.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightplanner.flightplannerserver.TestDataUtil;
import com.flightplanner.flightplannerserver.domain.dto.AircraftDto;
import com.flightplanner.flightplannerserver.services.AircraftService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class AircraftControllerIntegrationTests {

    private final AircraftService aircraftService;
    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @Autowired
    public AircraftControllerIntegrationTests(AircraftService aircraftService, MockMvc mockMvc) {
        this.aircraftService = aircraftService;
        this.mockMvc = mockMvc;
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void testThatCreatesAircraftDto_returnsHttp201Created() throws Exception {
        AircraftDto testAircraftDtoA = TestDataUtil.createTestValidAircraftDtoA();
        String aircraftJson = objectMapper.writeValueAsString(testAircraftDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/aircraft")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(aircraftJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    public void testThatCreatesAircraftDtoWithEmptyAircraftMake_returnsHttp400BadRequest() throws Exception {
        AircraftDto testAircraftEmptyMakeAircraftDto = TestDataUtil.createTestInvalidAircraftDtoEmptyAircraftMake();
        String aircraftJson = objectMapper.writeValueAsString(testAircraftEmptyMakeAircraftDto);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/aircraft")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(aircraftJson)
        ).andExpect(
                MockMvcResultMatchers.status().isBadRequest()
        );
    }

    @Test
    public void testThatCreatesAircraftDtoWithEmptyAircraftModel_returnsHttp400BadRequest() throws Exception {
        AircraftDto testEmptyAircraftModelAircraftDto = TestDataUtil.createTestInvalidAircraftDtoEmptyAircraftModel();
        String aircraftJson = objectMapper.writeValueAsString(testEmptyAircraftModelAircraftDto);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/aircraft")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(aircraftJson)
        ).andExpect(
                MockMvcResultMatchers.status().isBadRequest()
        );
    }

    @Test
    public void testThatCreatesAircraftDtoWithEmptyAircraftType_returnsHttp400BadRequest() throws Exception {
        AircraftDto testEmptyAircraftTypeAircraftDto = TestDataUtil.createTestInvalidAircraftDtoEmptyAircraftType();
        String aircraftJson = objectMapper.writeValueAsString(testEmptyAircraftTypeAircraftDto);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/aircraft")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(aircraftJson)
        ).andExpect(
                MockMvcResultMatchers.status().isBadRequest()
        );
    }

    @Test
    public void testThatCreatesAircraftDtoWithEmptyFuelType_returnsHttp400BadRequest() throws Exception {
        AircraftDto testEmptyFuelTypeAircraftDto = TestDataUtil.createTestInvalidAircraftDtoEmptyFuelType();
        String aircraftJson = objectMapper.writeValueAsString(testEmptyFuelTypeAircraftDto);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/aircraft")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(aircraftJson)
        ).andExpect(
                MockMvcResultMatchers.status().isBadRequest()
        );
    }

    @Test
    public void testThatCreatesAircraftDtoWithNullFuelTankSize_returnsHttp400BadRequest() throws Exception {
        AircraftDto testNullFuelTankSizeAircraftDto = TestDataUtil.createTestInvalidAircraftDtoNullFuelTankSize();
        String aircraftJson = objectMapper.writeValueAsString(testNullFuelTankSizeAircraftDto);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/aircraft")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(aircraftJson)
        ).andExpect(
                MockMvcResultMatchers.status().isBadRequest()
        );
    }

    @Test
    public void testThatCreatesAircraftDtoWithNullFuelBurnRate_returnsHttp400BadRequest() throws Exception {
        AircraftDto testNullFuelBurnRateAircraftDto = TestDataUtil.createTestInvalidAircraftDtoNullFuelBurnRate();
        String aircraftJson = objectMapper.writeValueAsString(testNullFuelBurnRateAircraftDto);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/aircraft")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(aircraftJson)
        ).andExpect(
                MockMvcResultMatchers.status().isBadRequest()
        );
    }

    @Test
    public void testThatCreatesAircraftDtoWithNullAirspeed_returnsHttp400BadRequest() throws Exception {
        AircraftDto testNullAirspeedAircraftDto = TestDataUtil.createTestInvalidAircraftDtoNullAirspeed();
        String aircraftJson = objectMapper.writeValueAsString(testNullAirspeedAircraftDto);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/aircraft")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(aircraftJson)
        ).andExpect(
                MockMvcResultMatchers.status().isBadRequest()
        );
    }

    @Test
    public void testThatCreatesAircraftDtoWithNullMinimumRunwayLengthRequired_returnsHttp400BadRequest() throws Exception {
        AircraftDto testInvalidAircraftDtoNullMinimumRunwayLengthRequiredAircraftDto = TestDataUtil.createTestInvalidAircraftDtoNullMinimumRunwayLengthRequired();
        String aircraftJson = objectMapper.writeValueAsString(testInvalidAircraftDtoNullMinimumRunwayLengthRequiredAircraftDto);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/aircraft")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(aircraftJson)
        ).andExpect(
                MockMvcResultMatchers.status().isBadRequest()
        );
    }

    @Test
    public void testThatCreatesAircraftDto_returnsSavedAircraftDto() throws Exception {
        AircraftDto testAircraftDtoA = TestDataUtil.createTestValidAircraftDtoA();
        String aircraftJson = objectMapper.writeValueAsString(testAircraftDtoA);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/aircraft")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(aircraftJson)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.aircraftId").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.aircraftMake").value("Airbus")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.aircraftModel").value("A320")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.aircraftType").value("jet")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.fuelType").value("jeta")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.fuelTankSize").value(27200.0)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.fuelBurnRate").value(3648.14)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.airspeed").value(450.0)
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.range").value(Math.floor(27200.0 / 3648.14 * 450.0))
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.minimumRunwayLengthRequired").value(5900.0)
        );
    }
}

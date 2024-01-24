package com.example.warcraft3;

import com.example.warcraft3.entity.Hero;
import com.example.warcraft3.entity.PrimaryAttribute;
import com.example.warcraft3.entity.Race;
import com.example.warcraft3.entity.SearchCriteria;
import com.example.warcraft3.service.HeroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class HeroControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HeroService heroService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllHeroes() throws Exception {
        mockMvc.perform(get("/api/heroes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void getHeroById() throws Exception {
        Long heroId = 1L;
        mockMvc.perform(get("/api/heroes/{id}", heroId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(heroId))
                .andExpect(jsonPath("$.name").value("Артас"));
    }

    @Test
    void deleteHero() throws Exception {
        Long heroId = 2L;
        mockMvc.perform(delete("/api/heroes/{id}", heroId))
                .andExpect(status().isOk());

        Hero deletedHero = heroService.getHeroById(heroId);
        assertNull(deletedHero);
    }

    @Test
    void searchByCriteria() throws Exception {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setSearchTerm("Артас");
        criteria.setSearchRace(Race.UNDEAD);
        criteria.setSearchPrimaryAttribute(PrimaryAttribute.STRENGTH);

        mockMvc.perform(post("/api/heroes/search")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(criteria)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Артас"));
    }
}

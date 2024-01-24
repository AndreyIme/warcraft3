package com.example.warcraft3;

import com.example.warcraft3.entity.Hero;
import com.example.warcraft3.entity.PrimaryAttribute;
import com.example.warcraft3.entity.Race;
import com.example.warcraft3.entity.SearchCriteria;
import com.example.warcraft3.repository.HeroRepository;
import com.example.warcraft3.service.HeroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class HeroServiceTests {

    @Autowired
    private HeroService heroService;

    @Autowired
    private HeroRepository heroRepository;

    @Test
    void getAllHeroes() {
        List<Hero> heroes = heroService.getAllHeroes();
        assertNotNull(heroes);
    }

    @Test
    void getHeroById() {
        Hero hero = heroService.getHeroById(1L);
        assertNotNull(hero);
        assertEquals("Артас", hero.getName());
    }

    @Test
    void createAndUpdateHero() {
        Hero newHero = new Hero();
        newHero.setId(11L);
        newHero.setName("Новый герой");
        newHero.setRace(Race.HUMAN);
        newHero.setPrimaryAttribute(PrimaryAttribute.STRENGTH);
        newHero.setDescription("Описание нового героя");
        newHero.setMovementSpeed(300);

        Hero createdHero = heroService.createHero(newHero);
        assertNotNull(createdHero);

        Long heroId = createdHero.getId();
        assertNotNull(heroId);

        Hero updatedHero = new Hero();
        updatedHero.setId(heroId);
        updatedHero.setName("Обновленный герой");
        updatedHero.setRace(Race.ORC);
        updatedHero.setPrimaryAttribute(PrimaryAttribute.AGILITY);
        updatedHero.setDescription("Обновленное описание героя");
        updatedHero.setMovementSpeed(310);

        Hero savedHero = heroService.updateHero(heroId, updatedHero);
        assertNotNull(savedHero);
        assertEquals("Обновленный герой", savedHero.getName());
        assertEquals(Race.ORC, savedHero.getRace());
    }

    @Test
    void deleteHero() {
        Long heroId = 2L;
        heroService.deleteHero(heroId);

        Hero deletedHero = heroRepository.findById(heroId).orElse(null);
        assertNull(deletedHero);
    }

    @Test
    void searchByCriteria() {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setSearchTerm("Артас");
        criteria.setSearchRace(Race.UNDEAD);
        criteria.setSearchPrimaryAttribute(PrimaryAttribute.STRENGTH);

        List<Hero> heroes = heroService.searchByCriteria(criteria);
        assertNotNull(heroes);
        assertEquals(1, heroes.size());
        assertEquals("Артас", heroes.get(0).getName());
    }
}

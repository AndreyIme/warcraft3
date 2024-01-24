package com.example.warcraft3.controller;

import com.example.warcraft3.entity.Hero;
import com.example.warcraft3.entity.PrimaryAttribute;
import com.example.warcraft3.entity.Race;
import com.example.warcraft3.entity.SearchCriteria;
import com.example.warcraft3.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/heroes")
public class HeroController {

    private final HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    public List<Hero> getAllHeroes() {
        return heroService.getAllHeroes();
    }

    @GetMapping("/{id}")
    public Hero getHeroById(@PathVariable Long id) {
        return heroService.getHeroById(id);
    }

    @PostMapping
    public Hero createHero(@RequestBody Hero hero) {
        return heroService.createHero(hero);
    }

    @PutMapping("/{id}")
    public Hero updateHero(@PathVariable Long id, @RequestBody Hero updatedHero) {
        return heroService.updateHero(id, updatedHero);
    }

    @DeleteMapping("/{id}")
    public void deleteHero(@PathVariable Long id) {
        heroService.deleteHero(id);
    }

    @GetMapping("/stringSearch")
    public List<Hero> searchByFields(@RequestParam(name = "searchTerm") String searchTerm) {
        return heroService.searchByFields(searchTerm);
    }

    @PostMapping("/search")
    public List<Hero> searchByCriteria(@RequestBody SearchCriteria searchCriteria) {
        return heroService.searchByCriteria(searchCriteria);
    }

    @GetMapping("/search")
    public List<Hero> searchByCriteria(@RequestParam(name = "searchTerm", required = false) String searchTerm,
                                       @RequestParam(name = "searchRace", required = false) String searchRace,
                                       @RequestParam(name = "searchPrimaryAttribute", required = false) String searchPrimaryAttribute,
                                       @RequestParam(name = "movementSpeed", required = false) Integer movementSpeed) {

        SearchCriteria criteria = new SearchCriteria();
        criteria.setSearchTerm(searchTerm);
        criteria.setSearchRace(Race.valueOf(searchRace));
        criteria.setSearchPrimaryAttribute(PrimaryAttribute.valueOf(searchPrimaryAttribute));
        criteria.setMovementSpeed(movementSpeed);

        return heroService.searchByCriteria(criteria);
    }
}
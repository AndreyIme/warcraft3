package com.example.warcraft3.service;

import com.example.warcraft3.entity.Hero;
import com.example.warcraft3.entity.SearchCriteria;
import com.example.warcraft3.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    private final HeroRepository heroRepository;

    @Autowired
    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    public Hero getHeroById(Long id) {
        return heroRepository.findById(id).orElse(null);
    }

    public Hero createHero(Hero hero) {
        return heroRepository.save(hero);
    }

    public Hero updateHero(Long id, Hero updatedHero) {
        updatedHero.setId(id);
        return heroRepository.save(updatedHero);
    }

    public void deleteHero(Long id) {
        heroRepository.deleteById(id);
    }

    public List<Hero> searchByFields(String searchTerm) {
        return heroRepository.searchByFields(searchTerm);
    }

    public List<Hero> searchByCriteria(SearchCriteria criteria) {
        return heroRepository.searchByCriteria(criteria);
    }
}
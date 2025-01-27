package cat.itacademy.s04.t02.n01.service.impl;

import cat.itacademy.s04.t02.n01.exception.custom.DuplicateFruitException;
import cat.itacademy.s04.t02.n01.exception.custom.NoFruitFoundException;
import cat.itacademy.s04.t02.n01.model.Fruit;
import cat.itacademy.s04.t02.n01.repository.FruitRepository;
import cat.itacademy.s04.t02.n01.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public Fruit addFruit(Fruit fruit) {
        fruitRepository.findByName(fruit.getName())
                .ifPresent(existingFruit -> {
                    throw new DuplicateFruitException("Entity with the name '" + fruit.getName() + "' already exists.");
                });
        return fruitRepository.save(fruit);
    }

    public Fruit updateFruit(Fruit updatedFruit) {
        fruitRepository.findById(updatedFruit.getId())
                .orElseThrow(() -> new NoFruitFoundException("Fruit not found with id " + updatedFruit.getId()));
        Fruit dbFruit = fruitRepository.getReferenceById(updatedFruit.getId());
        dbFruit.setName(updatedFruit.getName());
        dbFruit.setQuantityKg(updatedFruit.getQuantityKg());
        return fruitRepository.save(dbFruit);
    }

    public void deleteFruit(int id) {
        fruitRepository.findById(id)
                .orElseThrow(() -> new NoFruitFoundException("Fruit not found with id " + id));
        fruitRepository.deleteById(id);
    }

    public Fruit getOneFruit(int id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new NoFruitFoundException("Fruit not found with id " + id));
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }
}

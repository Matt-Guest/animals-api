package cx.catapult.animals.service;

import cx.catapult.animals.domain.Animal;

import cx.catapult.animals.exceptions.AnimalNotFoundException;
import java.util.*;

public abstract class BaseService<T extends Animal> implements Service<T> {

    private HashMap<String, T> items = new HashMap<>();

    @Override
    public Collection<T> all() {
        return items.values();
    }

    @Override
    public T create(T animal) {
        String id = UUID.randomUUID().toString();
        animal.setId(id);
        items.put(id, animal);
        return animal;
    }

    @Override
    public T get(String id) {
        return items.get(id);
    }

    @Override
    public void remove(final String key) throws AnimalNotFoundException {
        if (items.containsKey(key)) {
            items.remove(key);
        } else {
            throw new AnimalNotFoundException(String.format("Animal not found %s", key));
        }
    }
}

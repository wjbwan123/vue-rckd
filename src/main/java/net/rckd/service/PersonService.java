package net.rckd.service;

import net.rckd.entity.Person;

/**
 * @author hanyi
 * @date 2017年04月12日
 */
public interface PersonService {
    Person getById(Integer id);

    Person getByUserId(Integer userId);

    void save(Person person);

    void update(Person person);
}

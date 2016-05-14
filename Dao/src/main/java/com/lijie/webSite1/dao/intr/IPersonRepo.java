package com.lijie.webSite1.dao.intr;

import com.lijie.webSite1.model.entity.Person;
import com.lijie.webSite1.model.exception.WebException;

import java.util.List;

/**
 * Created by lj on 16-3-6.
 */
public interface IPersonRepo {
    public void savePerson(Person person)throws WebException;
    public Person getPersonById(int id) throws WebException;
    public List<Person> getAll() throws WebException;
    public void deletePersonById(int id) throws WebException;
}

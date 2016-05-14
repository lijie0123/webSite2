package com.lijie.webSite1.api.app;

import com.lijie.webSite1.api.dto.PersonDto;
import com.lijie.webSite1.model.exception.WebException;

import java.util.List;

/**
 * Created by lj on 16-3-6.
 */
public interface IPersonApi {
    public void savePerson(PersonDto personDto) throws WebException;
    public PersonDto getPersonById(int id) throws WebException;
    public List<PersonDto> getAll() throws WebException;
    public void deletePersonById(int id) throws WebException;
}

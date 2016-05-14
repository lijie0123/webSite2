package com.lijie.webSite1.api.impl;

import com.lijie.webSite1.api.app.IPersonApi;
import com.lijie.webSite1.api.dto.PersonDto;
import com.lijie.webSite1.model.entity.Person;
import com.lijie.webSite1.model.exception.WebException;
import com.lijie.webSite1.service.intr.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lj on 16-3-6.
 */
@Service
public class PersonApi implements IPersonApi{
    @Autowired
    private IPersonService personService;
    public void savePerson(PersonDto personDto) throws WebException {
        checkDto(personDto);
        int sex=sex2int(personDto.getSex());
        personService.savePerson(personDto.getId(),personDto.getName(),sex,personDto.getAge(),personDto.getDesc());
    }

    public PersonDto getPersonById(int id) throws WebException {
        Person person=personService.getPersonById(id);
        String sex=sex2String(person.getSex());
        PersonDto personDto=new PersonDto(person.getId(),person.getName(),sex,person.getAge(),person.getDescription());
        return personDto;
    }

    public List<PersonDto> getAll() throws WebException {
        List<PersonDto> personDtos=new ArrayList<PersonDto>();
        List<Person> persons=personService.getAll();
        if(persons==null)return null;
        for(Person person:persons){
            personDtos.add(new PersonDto(person.getId(),person.getName(),sex2String(person.getSex()),person.getAge(),person.getDescription()));
        }
        return personDtos;
    }

    public void deletePersonById(int id) throws WebException {
        personService.deletePersonById(id);
    }

    private int sex2int(String sexString){
        int sex=0;
        if(sexString.equals("male"))sex=1;
        else if(sexString.equals("female"))sex=2;
        else sex=3;
        return sex;
    }
    private String sex2String(int sexInt){
        String sex=null;
        if(sexInt==1)sex="male";
        else if(sexInt==2)sex="female";
        else sex="other";
        return sex;
    }
    private void checkDto(PersonDto personDto) throws WebException {
        if(personDto.getName()==null||personDto.getName().equals("")){
            throw new WebException(3,"Dto参数错误");
        }
    }

}

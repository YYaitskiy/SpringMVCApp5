package ua.yura.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.yura.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;


    private List<Person> people;

    {
            people = new ArrayList<>();

            people.add(new Person(++PEOPLE_COUNT, "Bob"));
            people.add(new Person(++PEOPLE_COUNT, "Tom"));
            people.add(new Person(++PEOPLE_COUNT, "Donald"));
            people.add(new Person(++PEOPLE_COUNT, "Nik"));
    }



    public List<Person> show(){
        return people;
    }

    public Person index(int id){
        Person idPerson = new Person();
        for (Person person:people){
            if (person.getId()==id){
                idPerson=person;
                break;
            }
        }
        return idPerson;
        //        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson){
        Person person = index(id);
        person.setName(updatePerson.getName());


    }

    public void delete(int id){
        people.removeIf(person -> person.getId() == id);

//        for (Person person:people){
//            if(person.getId()==id){
//                people.remove(person);
//                break;
//            }
//        }
    }
}

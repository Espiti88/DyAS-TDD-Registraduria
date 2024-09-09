package edu.unisabana.dyas.tdd.registry;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Registry {

    ArrayList<Person> voters = new ArrayList<Person>();

    public RegisterResult registerVoter(Person p) {
        // TODO Validate person and return real result.
        if (p.getAge() < 0 ){
            return RegisterResult.INVALID_AGE;

        } else if (p.getAge() < 18) {
            return RegisterResult.UNDERAGE;

        } else if (!p.isAlive()) {
            return RegisterResult.DEAD;

        } else if (existId(p)){
            return RegisterResult.DUPLICATED;
        }
        addVoter(p);
        return RegisterResult.VALID;
    }

    public void addVoter(Person p){
        voters.add(p);
    }

    public boolean existId(Person p){
        for (Person voter : voters) {
            if (voter.getId() == p.getId()){
               return true;
            }
        }
        return false;
    }
}

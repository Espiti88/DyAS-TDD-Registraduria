package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    // Caso de equivalencia: Ingreso de edad invalida
    @Test
    public void validateRegistryInvalidAge() {
        Person person = new Person("Juan Esteban", 1, -1, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    // Caso de equivalencia: Ingreso de menor de edad
    @Test
    public void validateRegistryUnderAge() {
        Person person = new Person("Valentina", 2, 17, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    // Caso de equivalencia: Ingreso de persona fallecida
    @Test
    public void validateRegistryDead() {
        Person person = new Person("Pepito", 3, 28, Gender.UNIDENTIFIED, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    // Caso de equivalencia: Ingreso de persona con ID repetido
    @Test
    public void validateRegistryDuplicated() {
        Person person1 = new Person("Camilo", 4, 51, Gender.MALE, true);
        RegisterResult result1 = registry.registerVoter(person1);

        Person person2 = new Person("Juan Fernando", 4, 29, Gender.MALE, true);
        RegisterResult result2 = registry.registerVoter(person2);

        Assert.assertEquals(RegisterResult.DUPLICATED, result2);
    }

    // Caso de equivalencia: Ingreso de personas validas
    @Test
    public void validateRegistryValid() {
        Person person1 = new Person("Samuel", 1, 20, Gender.MALE, true);
        RegisterResult result1 = registry.registerVoter(person1);
        Assert.assertEquals(RegisterResult.VALID, result1);

        Person person2 = new Person("Sofía", 2, 18, Gender.FEMALE, true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.VALID, result2);

    }
}
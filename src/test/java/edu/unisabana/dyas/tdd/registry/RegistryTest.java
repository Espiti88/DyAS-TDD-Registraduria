package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    /**
     * Caso de equivalencia 1:
     * Caso valido de identificar si una persona es menor de edad
     * Al ingresar un menor de edad debe devolver RegisterResult.UNDERAGE
     */

    // Ingreso de menor de edad
    @Test
    public void validateRegistryUnderAge() {
        Person person = new Person("Valentina", 1053788564, 17, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    /**
     * Caso de equivalencia 2:
     * Caso valido de identificar si una persona ha fallecido
     * Al ingresar una persona fallecida debe devolver RegisterResult.DEAD
     */

    // Ingreso de persona fallecida
    @Test
    public void validateRegistryDead() {
        Person person = new Person("Pepito", 1053832910, 28, Gender.UNIDENTIFIED, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    /**
     * Caso de equivalencia 3:
     * Caso invalido de identificar si una persona tiene su id repetido
     * Al ingresar una persona con id repetido no debería devolver RegisterResult.VALID
     */

    // Ingreso de persona con ID repetido
    @Test
    public void validateRegistryDuplicated() {
        Person person1 = new Person("Camilo", 4, 51, Gender.MALE, true);
        RegisterResult result1 = registry.registerVoter(person1);

        Person person2 = new Person("Juan Fernando", 4, 29, Gender.MALE, true);
        RegisterResult result2 = registry.registerVoter(person2);

        Assert.assertNotSame(RegisterResult.VALID, result2);
    }

    /**
     * Caso de equivalencia 4:
     * Caso invalido de identificar si una persona tiene una edad invalida
     * Al ingresar una persona con edad negativa no debería devolver RegisterResult.DEAD
     */

    // Ingreso de persona con edad negativa
    @Test
    public void validateRegistryValidAge() {
        Person person = new Person("Santiago", 1053833608, -28, Gender.UNIDENTIFIED, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertNotSame(RegisterResult.DEAD, result);

    }

    /**
     * Caso de equivalencia 5:
     * Caso valido de un ingreso de persona valida para ser registrada
     * Al ingresar una persona valida debería devolver RegisterResult.VALID
     */

    @Test
    public void validateEmpyPerson() {
        Person person = new Person("Fabián", 1193524007, 20, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
}
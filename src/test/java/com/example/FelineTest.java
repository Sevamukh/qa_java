package com.example;

import junitparams.JUnitParamsRunner;
import org.junit.*;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class FelineTest {

    Feline felineTest = new Feline();

    @Test
    public void eatMeatReturnsValidValues() throws Exception {
        Assert.assertEquals("Неправильный рацион", List.of("Животные", "Птицы", "Рыба"), felineTest.eatMeat());
    }

    @Test
    public void getFamilyReturnsValidValue() {
        Assert.assertEquals("Неправильное название семейства", "Кошачьи", felineTest.getFamily());
    }

    @Test
    public void getKittensReturnsValidValue() {
        Assert.assertEquals("Неправильное количество котят по умолчанию",
                1, felineTest.getKittens());
    }

    @Test
    public void getKittensTestWithArgReturnsValidValue() {
        Assert.assertEquals("Неправильное количество котят", 3, felineTest.getKittens(3));
    }
}
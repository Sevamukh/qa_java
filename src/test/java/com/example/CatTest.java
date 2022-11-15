package com.example;

import junitparams.JUnitParamsRunner;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class CatTest {

    @Rule public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    Feline felineMock;

    Cat catTest;

    @Before
    public void setUp() {
        catTest = new Cat(felineMock);
    }

    @Test
    public void getSoundReturnsValidValue() {
        Assert.assertEquals("Неправильный звук", "Мяу", catTest.getSound());
    }

    @Test
    public void getFoodReturnsValidValues() throws Exception {
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals("Неправильный рацион", List.of("Животные", "Птицы", "Рыба"), catTest.getFood());
    }
}
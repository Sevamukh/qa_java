package com.example;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

@RunWith(JUnitParamsRunner.class)
public class LionTest {

    @Rule public MockitoRule rule = MockitoJUnit.rule();

    public LionTest() throws Exception {}

    @Mock
    Feline felineMock;
    Lion lionMaleTest;
    Lion lionFemaleTest;

    @Before
    public void setUp() throws Exception {
        lionMaleTest = new Lion("Самец", felineMock);
        lionFemaleTest = new Lion("Самка", felineMock);
    }

    @Test(expected = Exception.class)
    public void lionWrongSex() throws Exception {
        Lion lionTest = new Lion("Нечто иное", new Feline());
    }

    @Test
    public void getKittensReturnsValidValue() throws Exception {
        Lion lionFemaleTest = new Lion("Самка", felineMock);
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        Assert.assertEquals("Неправильное количество котят по умолчанию", 1, lionFemaleTest.getKittens());
    }

    @Test
    @Parameters(method = "doesHaveManeParameters")
    @TestCaseName("haveMane={1}")
    public void doesHaveManeReturnsValidValueBySex(Lion lion, boolean haveMane) {
        Assert.assertEquals("Неправильное значение наличия гривы", haveMane, lion.doesHaveMane());
    }
    private Object[][] doesHaveManeParameters() throws Exception {
        return new Object[][]{
                {new Lion("Самец", felineMock), true},
                {new Lion("Самка", felineMock), false},
        };
    }

    @Test
    public void getFoodReturnsValidValues() throws Exception {
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Assert.assertEquals("Неправильный рацион", List.of("Животные", "Птицы", "Рыба"), lionMaleTest.getFood());
    }
}
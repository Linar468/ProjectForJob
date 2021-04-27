package com.calc.example;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Iterator;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class Test_Mockito {
    @Mock
    ICalculator mcalc;
//	ICalculator mcalc = Mockito.mock(ICalculator.class);

    // используем аанотацию @InjectMocks для создания mock объекта
    @InjectMocks
    Calculator calc = new Calculator(mcalc);

    @Test
    public void testCalcAdd() {
        // определяем поведение калькулятора для операции сложения
        when(calc.add(10.0, 20.0)).thenReturn(30.0);

        // проверяем действие сложения
        assertEquals(calc.add(10, 20), 30.0, 0);
        // проверяем выполнение действия
        verify(mcalc).add(10.0, 20.0);

        // определение поведения с использованием doReturn
        doReturn(15.0).when(mcalc).add(10.0, 5.0);

        // проверяем действие сложения
        assertEquals(calc.add(10.0, 5.0), 15.0, 0);
        verify(mcalc).add(10.0, 5.0);
    }

    @Test
    public void testCallMethod() {
        // определяем поведение (результаты)
        when(mcalc.subtract(15.0, 25.0)).thenReturn(10.0);
        when(mcalc.subtract(35.0, 25.0)).thenReturn(-10.0);

        // вызов метода subtract и проверка результата
        assertEquals(calc.subtract(15.0, 25.0), 10, 0);
        assertEquals(calc.subtract(15.0, 25.0), 10, 0);

        assertEquals(calc.subtract(35.0, 25.0), -10, 0);

        // проверка вызова методов
        verify(mcalc, atLeastOnce()).subtract(35.0, 25.0);
        verify(mcalc, atLeast(2)).subtract(15.0, 25.0);

        // проверка - был ли метод вызван 2 раза?
        verify(mcalc, times(2)).subtract(15.0, 25.0);
        // проверка - метод не был вызван ни разу
        verify(mcalc, never()).divide(10.0, 20.0);

        /* Если снять комментарий со следующей проверки, то
         * ожидается exception, поскольку метод "subtract"
         * с параметрами (35.0, 25.0) был вызван 1 раз
         */
//      verify(mcalc, atLeast   (2)).subtract(35.0, 25.0);

        /* Если снять комментарий со следующей проверки, то
         * ожидается exception, поскольку метод "subtract"
         * с параметрами (15.0, 25.0) был вызван 2 раза, а
         * ожидался всего один вызов
         */
//		verify(mcalc, atMost    (1)).subtract(15.0, 25.0);
    }

    @Test
    public void testDivide() {
        when(mcalc.divide(15.0, 3)).thenReturn(5.0);

        assertEquals(calc.divide(15.0, 3), 5.0, 0);
        verify(mcalc).divide(15.0, 3);

        // создаем исключение
        RuntimeException exception = new RuntimeException("Division by zero");
        // определяем поведение
        doThrow(exception).when(mcalc).divide(15.0, 0);

        assertEquals(calc.divide(15.0, 0), 0.0, 0);
        verify(mcalc).divide(15.0, 0);
    }

    // метод обработки ответа
    private Answer<Double> answer = new Answer<Double>() {
        @Override
        public Double answer(InvocationOnMock invocation) throws Throwable {
            // получение объекта mock
            Object mock = invocation.getMock();
            System.out.println("mock object : " + mock.toString());
            // аргументы метода, переданные mock
            Object[] args = invocation.getArguments();
            double d1 = (double) args[0];
            double d2 = (double) args[1];
            double d3 = d1 + d2;
            System.out.println("" + d1 + " + " + d2);
            return d3;
        }
    };

    @Test
    public void testThenAnswer() {
        // определение поведения mock для метода с параметрами add(11.0, 12.0)
        when(mcalc.add(11.0, 12.0)).thenAnswer(answer);
        assertEquals(calc.add(11.0, 12.0), 23.0, 0);
    }

    @Test
    public void testSpy() {
        Calculator scalc = spy(new Calculator());
        when(scalc.double15()).thenReturn(23.0);

        // вызов метода реального класса
        double d15 = scalc.double15();
        assertEquals(23.0, d15, 0);
        // проверка вызова метода
        verify(scalc).double15();

        // проверка возвращаемого методом значения
        assertEquals(23.0, scalc.double15(), 0);
        // проверка вызова метода не менее 2-х раз
        verify(scalc, atLeast(2)).double15();
    }

    @Test
    public void testTimeout() {
        // определение поведения mock для метода с параметрами add(11.0, 12.0)
        when(mcalc.add(11.0, 12.0)).thenReturn(23.0);
        // проверка значения
        assertEquals(calc.add(11.0, 12.0), 23.0, 0);

        // проверка вызова метода в течение 10 мс
        verify(mcalc, timeout(100)).add(11.0, 12.0);
    }


    @SuppressWarnings("unchecked")
    @Test
    public void testJavaClasses() {
        // создание объекта mock
        Iterator<String> mis = mock(Iterator.class);
        // формирование ответов
        when(mis.next()).thenReturn("Привет").thenReturn("Mockito");
        // формирование строки из ответов
        String result = mis.next() + ", " + mis.next();
        // проверка
        assertEquals("Привет, Mockito", result);

        Comparable<String> mcs = mock(Comparable.class);
        when(mcs.compareTo("Mockito")).thenReturn(1);
        assertEquals(1, mcs.compareTo("Mockito"));

        Comparable<Integer> mci = mock(Comparable.class);
        when(mci.compareTo(anyInt())).thenReturn(1);
        assertEquals(1, mci.compareTo(5));
    }
}

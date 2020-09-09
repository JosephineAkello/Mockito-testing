package com.example.Mockitotesting.business;

import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListMockTest {

    List<String> mock = mock(List.class);

    @Test
    public void size_basic(){
        when(mock.size()).thenReturn(5);
        assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentValues(){
        when(mock.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mock.size());
        assertEquals(10, mock.size());
    }

    @Test
    public void returnWithGenericParameters(){
        when(mock.get(anyInt())).thenReturn("Mj.....");
        assertEquals("Mj.....", mock.get(0));
        assertEquals("Mj.....", mock.get(1));
    }

    @Test
    public void verifiation_basics(){
    String value = mock.get(0);
    String value1 = mock.get(1);

    verify(mock).get(0);
    verify(mock, times(2)).get(anyInt());
    verify(mock,atLeast(1)).get(anyInt());
    verify(mock,atLeastOnce()).get(anyInt());
    verify(mock,atMost(2)).get(anyInt());
    verify(mock,never()).get(2);
    }

    @Test
    public void argumentCapturing(){
   mock.add("SomeString");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }
}

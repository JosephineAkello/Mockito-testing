package com.example.Mockitotesting.business;

import java.util.ArrayList;
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
import static org.mockito.Mockito.spy;
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
        mock.add("SomeString2");


        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock,times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();
        assertEquals("SomeString", allValues.get(0));
        assertEquals("SomeString2", allValues.get(1));
    }


    @Test
    public void spyingMock(){
        ArrayList arrayListMock = mock(ArrayList.class);
            arrayListMock.get(0);
            arrayListMock.size();
            arrayListMock.add("Test");
            arrayListMock.add("Test1");
            arrayListMock.size();
            when(arrayListMock.size()).thenReturn(5);
            arrayListMock.size();
        }

    @Test
    public void spying(){
        ArrayList arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Test0");
        arrayListSpy.get(0);
        arrayListSpy.size();
        arrayListSpy.add("Test");
        arrayListSpy.add("Test1");
        arrayListSpy.size();
        when(arrayListSpy.size()).thenReturn(5);
        arrayListSpy.size();
        arrayListSpy.add("Test4");

        verify(arrayListSpy).add("Test4");
    }
}





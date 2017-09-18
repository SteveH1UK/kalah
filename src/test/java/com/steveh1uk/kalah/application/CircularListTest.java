package com.steveh1uk.kalah.application;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CircularListTest {

    private String[] items = new String[] {"first", "second", "third", "fourth"};
    private CircularList circularList = new CircularList(Arrays.asList(items));

    @Test
    public void goAroundTheListFromFirst() throws Exception {

        System.out.println(circularList.toString());

        assertEquals("first", circularList.retrieveCurrentItem(0));
        assertEquals("second", circularList.retrieveNextItem());
        assertEquals("third", circularList.retrieveNextItem());
        assertEquals("fourth", circularList.retrieveNextItem());
        assertEquals("first", circularList.retrieveNextItem());
    }

    @Test
    public void goAroundTheListFromLast() throws Exception {


        assertEquals("fourth", circularList.retrieveCurrentItem(3));
        assertEquals("first", circularList.retrieveNextItem());
    }

}
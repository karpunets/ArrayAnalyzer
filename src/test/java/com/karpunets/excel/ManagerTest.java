package com.karpunets.excel;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Karpunets
 * @since 02.12.2016
 */
public class ManagerTest {
    @Test(expected = NullPointerException.class)
    public void createXML() throws Exception {
        Manager.createXML(null, null);
    }

}
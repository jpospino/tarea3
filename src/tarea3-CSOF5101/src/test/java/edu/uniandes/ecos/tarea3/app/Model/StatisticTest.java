/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.tarea3.app.Model;

import junit.framework.TestCase;

/**
 *
 * @author JuanPablo
 */
public class StatisticTest extends TestCase {
    public Statistic statistic;
    
    public StatisticTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        this.statistic = new Statistic(1, 130, 163, 186, 15);
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
    
    /**
     * Prueba unitaria para el metodo getActualAddedModifiedSize
     */
    public void testGetActualAddedModifiedSize()
    {
        assertEquals(this.statistic.getActualAddedModifiedSize(), 186.0);
    }
    
    /**
     * Prueba unitaria para el metodo getActualDevelopmentTime
     */
    public void testGetActualDevelopmentTime()
    {
        assertEquals(this.statistic.getActualDevelopmentTime(), 15.0);
    }
    
    /**
     * Prueba unitaria para el metodo getEstimatedProxySize
     */
    public void testGetEstimatedProxySize()
    {
        assertEquals(this.statistic.getEstimatedProxySize(), 130.0);
    }
    
    /**
     * Prueba unitaria para el metodo getPlanAddedModifiedSize
     */
    public void testGetPlanAddedModifiedSize()
    {
        assertEquals(this.statistic.getPlanAddedModifiedSize(), 163.0);
    }
    
    /**
     * Prueba unitaria para el metodo actualAddedModifiedSizeSquared
     */
    public void testActualAddedModifiedSizeSquared()
    {
        assertEquals(this.statistic.actualAddedModifiedSizeSquared(), (186.0 * 186.0));
        
    }
    
    /**
     * Prueba unitaria para el metodo actualDevelopmentTimeSquared
     */
    public void testActualDevelopmentTimeSquared()
    {
        assertEquals(this.statistic.actualDevelopmentTimeSquared(), 15.0 * 15.0);
    }
    
    /**
     * Prueba unitaria para el metodo estimatedProxySizeSquared
     */
    public void testEstimatedProxySizeSquared()
    {
        assertEquals(this.statistic.estimatedProxySizeSquared(), 130.0 * 130.0);
    }
    
    /**
     * Prueba unitaria para el metodo planAddedModifiedSizeSquared
     */
    public void testPlanAddedModifiedSizeSquared()
    {
        assertEquals(this.statistic.planAddedModifiedSizeSquared(), 163.0 * 163.0);
    }
    
    /**
     * Prueba unitaria para el metodo estimatedProxySizeActualAddedModifiedSize
     */
    public void testValidarProductos()
    {
        assertEquals(this.statistic.estimatedProxySizeActualAddedModifiedSize(), 130.0 * 186.0);
    }
    
    /**
     * Prueba unitaria para el metodo estimatedProxySizeActualDevelopmentTime
     */
    public void testEstimatedProxySizeActualDevelopmentTime()
    {
        assertEquals(this.statistic.estimatedProxySizeActualDevelopmentTime(), 130.0 * 15.0);
    }
    
    /**
     * Prueba unitaria para el metodo planAddedModifiedSizeActualAddedModifiedSize
     */
    public void testPlanAddedModifiedSizeActualAddedModifiedSize()
    {
        
        assertEquals(this.statistic.planAddedModifiedSizeActualAddedModifiedSize(), 163.0 * 186.0);
    }
    
    /**
     * Prueba unitaria para el metodo planAddedModifiedSizeActualDevelopmentTime
     */
    public void testPlanAddedModifiedSizeActualDevelopmentTime()
    {
        assertEquals(this.statistic.planAddedModifiedSizeActualDevelopmentTime(), 163.0 * 15.0);               
    }
}

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
    
    public void testValidarValores()
    {
        assertEquals(this.statistic.getActualAddedModifiedSize(), 186.0);
        assertEquals(this.statistic.getActualDevelopmentTime(), 15.0);
        assertEquals(this.statistic.getEstimatedProxySize(), 130.0);
        assertEquals(this.statistic.getPlanAddedModifiedSize(), 163.0);
    }
    
    public void testValidarCuadrados()
    {
        assertEquals(this.statistic.actualAddedModifiedSizeSquared(), (186.0 * 186.0));
        assertEquals(this.statistic.actualDevelopmentTimeSquared(), 15.0 * 15.0);
        assertEquals(this.statistic.estimatedProxySizeSquared(), 130.0 * 130.0);
        assertEquals(this.statistic.planAddedModifiedSizeSquared(), 163.0 * 163.0);
    }
    
    public void testValidarProductos()
    {
        assertEquals(this.statistic.estimatedProxySizeActualAddedModifiedSize(), 130.0 * 186.0);
        assertEquals(this.statistic.estimatedProxySizeActualDevelopmentTime(), 130.0 * 15.0);
        assertEquals(this.statistic.planAddedModifiedSizeActualAddedModifiedSize(), 163.0 * 186.0);
        assertEquals(this.statistic.planAddedModifiedSizeActualDevelopmentTime(), 163.0 * 15.0);               
    }
}

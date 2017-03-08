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
public class LinealRegressionCalculatorTest extends TestCase {
    
    public LinealRegressionCalculator linealRegressionCalculator;
    
    public LinealRegressionCalculatorTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        
        this.linealRegressionCalculator = new LinealRegressionCalculator();
        this.linealRegressionCalculator.addStatictics(1, 130.0, 163.0, 186.0, 15.0);
        this.linealRegressionCalculator.addStatictics(2, 650.0, 765.0, 699.0, 69.9);
        this.linealRegressionCalculator.addStatictics(3, 99.0, 141.0, 132.0, 6.50);
        this.linealRegressionCalculator.addStatictics(4, 150.0, 166.0, 272.0, 22.40);
        this.linealRegressionCalculator.addStatictics(5, 128.0, 137.0, 291.0, 28.4);
        this.linealRegressionCalculator.addStatictics(6, 302.0, 355.0, 331.0, 65.9);
        this.linealRegressionCalculator.addStatictics(7, 95.0, 136.0, 199.0, 19.4);
        this.linealRegressionCalculator.addStatictics(8, 945.0, 1206.0, 1890.0, 198.7);
        this.linealRegressionCalculator.addStatictics(9, 368.0, 433.0, 788.0, 38.8);
        this.linealRegressionCalculator.addStatictics(10, 961.0, 1130.0, 1601.0, 138.2);
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // TODO add test methods here. The name must begin with 'test'. For example:
    // public void testHello() {}
    
    /**
     * Prueba unitarioa del metodo SumActualAddedModifiedSize
     */
    public void testSumActualAddedModifiedSize()
    {
        assertEquals(this.linealRegressionCalculator.sumActualAddedModifiedSize(), 6389.0, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo SumActualAddedModifiedSizeSquared
     */
    public void testSumActualAddedModifiedSizeSquared()
    {
        assertEquals(this.linealRegressionCalculator.sumActualAddedModifiedSizeSquared(), 7604693.0, 0.01);
    }

    /**
     * Prueba unitarioa del metodo SumActualDevelopmentTimeSquared
     */
    public void testSumActualDevelopmentTimeSquared()
    {
        assertEquals(this.linealRegressionCalculator.sumActualDevelopmentTimeSquared(), 71267.12, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo sumEstimatedProxySize
     */
    public void testSumEstimatedProxySize()
    {
        assertEquals(this.linealRegressionCalculator.sumEstimatedProxySize(), 3828.0, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo sumEstimatedProxySizeActualAddedModifiedSize
     */
    public void testSumEstimatedProxySizeActualAddedModifiedSize()
    {
        assertEquals(this.linealRegressionCalculator.sumEstimatedProxySizeActualAddedModifiedSize(), 4303108.0, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo sumEstimatedProxySizeActualDevelopmentTime
     */
    public void testSumEstimatedProxySizeActualDevelopmentTime()
    {
        assertEquals(this.linealRegressionCalculator.sumEstimatedProxySizeActualDevelopmentTime(), 411628.6, 0.01);  
    }
    
    /**
     * Prueba unitarioa del metodo sumEstimatedProxySizeSquared
     */
    public void testSumEstimatedProxySizeSquared()
    {
        assertEquals(this.linealRegressionCalculator.sumEstimatedProxySizeSquared(), 2540284.0, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo sumPlanAddedModifiedSizeActualAddedModifiedSize
     */
    public void testSumPlanAddedModifiedSizeActualAddedModifiedSize()
    {
        assertEquals(this.linealRegressionCalculator.sumPlanAddedModifiedSizeActualAddedModifiedSize(), 5242927.0, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo sumPlanAddedModifiedSizeActualDevelopmentTime
     */
    public void testSumPlanAddedModifiedSizeActualDevelopmentTime()
    {
        assertEquals(this.linealRegressionCalculator.sumPlanAddedModifiedSizeActualDevelopmentTime(), 503075.7, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo sumPlanAddedModifiedSizeSquared
     */
    public void testSumPlanAddedModifiedSizeSquared()
    {
        assertEquals(this.linealRegressionCalculator.sumPlanAddedModifiedSizeSquared(), 3741346.0, 0.01);
    }
    
    /**
     * Prueba unitarioa del metodo printStatistics
     */
    public void testImprimirStatistics()
    {
        //this.linealRegressionCalculator.printStatistics();
    }
    
    /**
     * Prueba unitarioa de la impresión de los resultados
     */
    public void testCalcPlanAddedModifiedSizeEPSAAM()
    {
        
        System.out.println("[B0]          [B1]          [r_xy]        [r^2]         [y_k]");
        
        this.linealRegressionCalculator.calcPlanAddedModifiedSizeEPSAAM(386);
        this.linealRegressionCalculator.calcTimeEstmateEPSADT(386);
        this.linealRegressionCalculator.calcPlanAddedModifiedSizePAMSAAMS(386);
        this.linealRegressionCalculator.calcTimeEstimatedPAMSADT(386);
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.tarea3.app.Model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>LinealRegressionCalculator</h1>
 * Clase LinealRegressionCalculator
 *
 * @author Juan Pablo Ospino Solano
 * @version 1.0
 * @since   2017-03-04
 */
public class LinealRegressionCalculator {
    public List<Statistic> statistic = new ArrayList();
    
    public LinealRegressionCalculator()
    {
        //this.statistic = new ArrayList<Statistic>();
    }
    
    /*
     * Agrega un elemento a la lista
     * @param pgrID
     * @param ePS
     * @param pAMS
     * @param aAMS
     * @param aDH 
     */
    public void addStatictics(int pgrID, double ePS, double pAMS, double aAMS, double aDH) 
    { 
        this.statistic.add(new Statistic(pgrID, ePS, pAMS, aAMS, aDH));
    }
    
    /**
     * Calculo de la sumatiora de la proiedad EstimatedProxySize de la clase statistic
     * @return valor calculado de la sumatoria
     */
    public double sumEstimatedProxySize()
    {
        return this.statistic.stream().mapToDouble( x -> x.getEstimatedProxySize()).sum();
    } 
        
    /**
     * SUmatoria de la propiedad ActualAddedModifiedSize
     * @return valor calculado de la sumatoria
     */
    public double sumActualAddedModifiedSize()
    {
        return this.statistic.stream().mapToDouble( x -> x.getActualAddedModifiedSize()).sum();
    } 
    
    
    
    // <editor-fold defaultstate="collapsed" desc=" Sumas de cuadrados ">
    
    /**
     * Método para calculo de sumatoria de EstimatedProxySizeSquared
     * @return valor de la sumatoria de EstimatedProxySizeSquared
     */
    public double sumEstimatedProxySizeSquared()
    { 
        return this.statistic.stream().mapToDouble( x -> x.estimatedProxySizeSquared() ).sum();
    }

    /**
     * Método para calculo de sumatoria de PlanAddedModifiedSizeSquared
     * @return valor de sumatoria de PlanAddedModifiedSizeSquared
     */
    public double sumPlanAddedModifiedSizeSquared()
    { 
        return this.statistic.stream().mapToDouble( x -> x.planAddedModifiedSizeSquared()).sum();
    }
    
    /**
     * Método para calculo de sumatoria de ActualAddedModifiedSizeSquared
     * @return valor de sumatoria de ActualAddedModifiedSizeSquared
     */
    public double sumActualAddedModifiedSizeSquared()
    { 
        return this.statistic.stream().mapToDouble( x -> x.actualAddedModifiedSizeSquared()).sum();
    }
    
    /**
     * Método para calculo de sumatoria de ActualDevelopmentTimeSquared
     * @return valor de sumatoria de sumActualDevelopmentTimeSquared
     */
    public double sumActualDevelopmentTimeSquared()
    { 
        return this.statistic.stream().mapToDouble( x -> x.actualDevelopmentTimeSquared()).sum();
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Sumas de productos ">
    
    /**
     * Método par el calculo del producto de estimatedProxySizeActualAddedModifiedSize
     * @return valor del producto estimatedProxySizeActualAddedModifiedSize
     */
    public double sumEstimatedProxySizeActualAddedModifiedSize()
    { 
        return this.statistic.stream().mapToDouble( x -> x.estimatedProxySizeActualAddedModifiedSize()).sum();
    }
    
        /**
     * Método par el calculo del producto de estimatedProxySizeActualDevelopmentTime
     * @return valor del producto estimatedProxySizeActualDevelopmentTime
     */
    public double sumEstimatedProxySizeActualDevelopmentTime()
    { 
        return this.statistic.stream().mapToDouble( x -> x.estimatedProxySizeActualDevelopmentTime()).sum();
    }
    
    /**
     * Método par el calculo del producto de planAddedModifiedSizeActualAddedModifiedSize
     * @return valor del producto planAddedModifiedSizeActualAddedModifiedSize
     */
    public double sumPlanAddedModifiedSizeActualAddedModifiedSize()
    { 
        return this.statistic.stream().mapToDouble( x -> x.planAddedModifiedSizeActualAddedModifiedSize()).sum();
    }
    
        /**
     * Método par el calculo del producto de planAddedModifiedSizeActualDevelopmentTime
     * @return valor del producto planAddedModifiedSizeActualDevelopmentTime
     */
    public double sumPlanAddedModifiedSizeActualDevelopmentTime()
    { 
        return this.statistic.stream().mapToDouble( x -> x. planAddedModifiedSizeActualDevelopmentTime()).sum();
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Promedio de valores  ">
   
    /**
     * Método para el calculo del promedio del valor de EstimatedProxySiz
     * @return valor promedio de EstimatedProxySiz
     */
    public double avgEstimatedProxySize()
    { 
        return this.statistic.stream().mapToDouble( x -> x.getEstimatedProxySize()).sum() / this.statistic.size();
    }
    
    /**
     * Método para el calculo del promedio del valor de PlanAddedAndModifiedSize
     * @return valor promedio de PlanAddedAndModifiedSize
     */
    public double avgPlanAddedAndModifiedSize()
    { 
        return this.statistic.stream().mapToDouble( x -> x.getPlanAddedModifiedSize()).sum() / this.statistic.size(); 
    }
    
    /**
     * Método para el calculo del promedio del valor de ActualAddedAndModifiedSize
     * @return valor promedio de ActualAddedAndModifiedSize
     */
    public double avgActualAddedAndModifiedSize()
    { 
        return this.statistic.stream().mapToDouble( x -> x.getActualAddedModifiedSize()).sum() / this.statistic.size(); 
    }
    
    /**
     * Método para el calculo del promedio del valor de ActualDevelopmentTime
     * @return valor promedio de ActualDevelopmentTime
     */
    public double avgActualDevelopmentTime()
    { 
        return this.statistic.stream().mapToDouble( x -> x.getActualDevelopmentTime()).sum() / this.statistic.size(); 
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Calculos de regresión lineal  ">
    
    /**
     * Calculo para el test 1. Esimate proxy size - Actual added and modifies size
     * @param estimatedProxySize  valor del proxy calculado
     */
    public void calcPlanAddedModifiedSizeEPSAAM(int estimatedProxySize) 
    {        
        /* Cálculo del B1 de la ecuación */
        double calcTmp = this.sumEstimatedProxySizeActualAddedModifiedSize() - (this.statistic.size() * this.avgEstimatedProxySize() * this.avgActualAddedAndModifiedSize());
        double beta1 = calcTmp / (this.sumEstimatedProxySizeSquared() - (this.statistic.size() * this.avgEstimatedProxySize() * this.avgEstimatedProxySize())); 
        
        /* Calculo del coeficiende de coorelación*/
        calcTmp = 0;
        calcTmp = ( this.statistic.size() * this.sumEstimatedProxySizeActualAddedModifiedSize()) - (sumEstimatedProxySize() * sumActualAddedModifiedSize());
        
        double calcTmpDiv = ((this.statistic.size() * this.sumEstimatedProxySizeSquared()) - ( sumEstimatedProxySize() * sumEstimatedProxySize())) * ((this.statistic.size() * this.sumActualAddedModifiedSizeSquared()) - (sumActualAddedModifiedSize() * sumActualAddedModifiedSize()));
       
        double relation = (calcTmp / Math.sqrt(calcTmpDiv));
        
        /* cálculo del beta0*/
        double beta0 = this.avgActualAddedAndModifiedSize() - (beta1 * this.avgEstimatedProxySize());
        
        /* impresión de resultados */
        //System.out.println("[B0]    [B1]    [r_xy]    [r^2]    [y_k]");
        System.out.println(padRight(beta0, 14) + padRight(beta1, 14) + padRight(relation, 14) + padRight(relation * relation, 14) + padRight((beta0 + (beta1 * estimatedProxySize)), 14));
    }
    
    /**
     * Calculo para el test 2. Esimate proxy size - Actual added and modified size
     * @param estimatedProxySize  valor del proxy calculado
     */
    public void calcTimeEstmateEPSADT(int estimatedProxySize) 
    {
        /* Cálculo del B1 de la ecuación */
        double calcTmp = this.sumEstimatedProxySizeActualDevelopmentTime()- (this.statistic.size() * this.avgEstimatedProxySize() * this.avgActualDevelopmentTime());
        double beta1 = calcTmp / (this.sumEstimatedProxySizeSquared() - (this.statistic.size() * this.avgEstimatedProxySize() * this.avgEstimatedProxySize())); 
        
        double sumEstimatedProxySize = this.statistic.stream().mapToDouble( x -> x.getEstimatedProxySize()).sum(); 
        double sumActualDevelopmentTime = this.statistic.stream().mapToDouble( x -> x.getActualDevelopmentTime()).sum(); 
        
        /* Calculo del coeficiende de coorelación*/
        calcTmp = 0;
        calcTmp = ( this.statistic.size() * this.sumEstimatedProxySizeActualDevelopmentTime()) - (sumEstimatedProxySize() * sumActualDevelopmentTime);
        
        double calcTmpDiv =  ((this.statistic.size() * this.sumEstimatedProxySizeSquared()) - ( sumEstimatedProxySize() * sumEstimatedProxySize())) * ((this.statistic.size() * this.sumActualDevelopmentTimeSquared()) - (sumActualDevelopmentTime * sumActualDevelopmentTime));
       
        double relation = (calcTmp / Math.sqrt(calcTmpDiv));
                
        /* cálculo del beta0*/
        double beta0 = this.avgActualDevelopmentTime()- (beta1 * this.avgEstimatedProxySize());
        
        /* impresión de resultados */
        System.out.println(padRight(beta0, 14) + padRight(beta1, 14) + padRight(relation, 14) + padRight(relation * relation, 14) + padRight((beta0 + (beta1 * estimatedProxySize)), 14));
    }
    
    /**
     * Calculo para el test 3. plan added and modified size - Actual added and modified size
     * @param estimatedProxySize  valor del proxy calculado
     */
    public void calcPlanAddedModifiedSizePAMSAAMS(int estimatedProxySize) 
    {
        /* Cálculo del B1 de la ecuación */
            
        double calcTmp = this.sumPlanAddedModifiedSizeActualAddedModifiedSize() - (this.statistic.size() * this.avgPlanAddedAndModifiedSize() * this.avgActualAddedAndModifiedSize());
        double beta1 = calcTmp / (this.sumPlanAddedModifiedSizeSquared() - (this.statistic.size() * this.avgPlanAddedAndModifiedSize() * this.avgPlanAddedAndModifiedSize())); 
        
        /* Calculo del coeficiende de coorelación*/
        double sumPlanAddedModifiedSize = this.statistic.stream().mapToDouble(x -> x.getPlanAddedModifiedSize()).sum();
        
        calcTmp = 0;
        calcTmp = ( this.statistic.size() * this.sumPlanAddedModifiedSizeActualAddedModifiedSize()) - (sumPlanAddedModifiedSize * sumActualAddedModifiedSize());
        
        double calcTmpDiv = ((this.statistic.size() * this.sumPlanAddedModifiedSizeSquared()) - ( sumPlanAddedModifiedSize * sumPlanAddedModifiedSize)) * ((this.statistic.size() * this.sumActualAddedModifiedSizeSquared()) - (sumActualAddedModifiedSize() * sumActualAddedModifiedSize()));
       
        double relation = (calcTmp / Math.sqrt(calcTmpDiv));
        
        /* cálculo del beta0*/
        double beta0 = this.avgActualAddedAndModifiedSize() - (beta1 * this.avgPlanAddedAndModifiedSize());
        
        /* impresión de resultados */
        //System.out.println("[B0]    [B1]    [r_xy]    [r^2]    [y_k]");
        System.out.println(padRight(beta0, 14) + padRight(beta1, 14) + padRight(relation, 14) + padRight(relation * relation, 14) + padRight((beta0 + (beta1 * estimatedProxySize)), 14));
    }
    
    /**
     * Calculo para el test 2. plan added and modified size
     * @param estimatedProxySize  valor del proxy calculado
     */
    public void calcTimeEstimatedPAMSADT(int estimatedProxySize) 
    { 
        double calcTmp = this.sumPlanAddedModifiedSizeActualDevelopmentTime()- (this.statistic.size() * this.avgPlanAddedAndModifiedSize()* this.avgActualDevelopmentTime());
        double beta1 = calcTmp / (this.sumPlanAddedModifiedSizeSquared()- (this.statistic.size() * this.avgPlanAddedAndModifiedSize() * this.avgPlanAddedAndModifiedSize())); 
        
        double sumPlanAddedModifiedSize = this.statistic.stream().mapToDouble(x -> x.getPlanAddedModifiedSize()).sum();
        double sumActualDevelopmentTime = this.statistic.stream().mapToDouble( x -> x.getActualDevelopmentTime()).sum();
        
        /* Calculo del coeficiende de coorelación*/
        calcTmp = 0;
        calcTmp = ( this.statistic.size() * this.sumPlanAddedModifiedSizeActualDevelopmentTime()) - (sumPlanAddedModifiedSize * sumActualDevelopmentTime);
        
        double calcTmpDiv =  ((this.statistic.size() * this.sumPlanAddedModifiedSizeSquared()) - ( sumPlanAddedModifiedSize * sumPlanAddedModifiedSize)) * ((this.statistic.size() * this.sumActualDevelopmentTimeSquared()) - (sumActualDevelopmentTime * sumActualDevelopmentTime));
       
        double relation = (calcTmp / Math.sqrt(calcTmpDiv));
                
        /* cálculo del beta0*/
        double beta0 = this.avgActualDevelopmentTime()- (beta1 * this.avgPlanAddedAndModifiedSize());
        
        /* impresión de resultados */
        System.out.println(padRight(beta0, 14) + padRight(beta1, 14) + padRight(relation, 14) + padRight(relation * relation, 14) + padRight((beta0 + (beta1 * estimatedProxySize)), 14));
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc=" Impresión de la regresión y valores calculados  ">
    /**
     * Impresión de las estadisticas
     */
    public void printStatistics() 
    { 
        System.out.println("[Prog Num]   [EsAdModS]   [AAdMoSiz]   [ActDevTi]");
        for(Statistic item : this.statistic)
        {
            System.out.println(padRight(item.getEstimatedProxySize(), 14) + padRight(item.getPlanAddedModifiedSize(), 14) + padRight(item.getActualAddedModifiedSize(), 14) + padRight(item.getActualDevelopmentTime(), 14));
        }
        System.out.println("");
    } 
    
    /**
     * Retorna cadena de caracteres tabulado
     * @param s cadena de caracteres a tabular
     * @param n espacios a tabular
     * @return cadena de caracteres tabulado
     */
    private String padRight(double s, int n) 
    {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return String.format("%1$-" +  n + "s", decimalFormat.format(s));  
    }
    
    // </editor-fold>
}

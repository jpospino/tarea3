package edu.uniandes.ecos.tarea3.app;

import edu.uniandes.ecos.tarea3.app.Model.LinealRegressionCalculator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * <h1>App</h1>
 * Clase App
 *
 * @author Juan Pablo Ospino Solano
 * @version 1.0
 * @since   2017-03-04
 */
public class App 
{
    /**
     * Método main par hacer la jecución del código
     * @param args en la posición 0 -> ruta del archivo
     *             en la posición 1 -> valor del proxy
     * @throws Exception 
     */
    public static void main( String[] args ) 
            throws Exception
    {        
        LinealRegressionCalculator linealRegressionCalculator = new LinealRegressionCalculator();
        String[] stringSplit;
        
        try 
        {
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while (line != null) 
            {
                stringSplit = line.split(";");
                
                int programNumber = Integer.parseInt(stringSplit[0]);
                
                double estimatedProxySize = trayParseDouble(stringSplit[1]);
                if(trayParseDouble(stringSplit[1]) < 0 )
                {
                    System.out.println("Elvalor de Estimated Proxy Size nos es un valor decimal");
                    return;
                }
                
                double planAddedModifiedSize = trayParseDouble(stringSplit[2]);
                if(trayParseDouble(stringSplit[2]) < 0)
                {
                    System.out.println("Elvalor de plan Added Modified Size nos es un valor decimal");
                    return;
                }
                
                double actualAddedAndModifiedSize = trayParseDouble(stringSplit[3]);
                if(actualAddedAndModifiedSize < 0)
                {
                    System.out.println("Elvalor de actual Added And ModifiedSize nos es un valor decimal");
                    return;
                }
                
                double actualDevelopmentHours = App.trayParseDouble(stringSplit[4]);
                if(actualDevelopmentHours < 0)
                {
                    System.out.println("Elvalor de actual Developmen tHours nos es un valor decimal");
                    return;
                }
                
                linealRegressionCalculator.addStatictics(programNumber, estimatedProxySize, planAddedModifiedSize, actualAddedAndModifiedSize, actualDevelopmentHours);
                
                line = bufferedReader.readLine();
            }
        }
        catch(Exception exc)
        {
            throw exc;
        }   
        
        System.out.println("[B0]          [B1]          [r_xy]        [r^2]         [y_k]");
        int proxySize = Integer.parseInt(args[1]);
        linealRegressionCalculator.calcPlanAddedModifiedSizeEPSAAM(proxySize);
        linealRegressionCalculator.calcTimeEstmateEPSADT(proxySize);
        linealRegressionCalculator.calcPlanAddedModifiedSizePAMSAAMS(proxySize);
        linealRegressionCalculator.calcTimeEstimatedPAMSADT(proxySize);
    }
        
    /**
     * Método para hacer la conversión de texto a double
     * @param stringNumber n´mero en variable string
     * @return número convertido
     */
    public static double trayParseDouble(String stringNumber)
    {
        try 
        {
            return Double.parseDouble(stringNumber);
        }
        catch (NumberFormatException e) 
        {
            return -1.0;
        }
    }
}

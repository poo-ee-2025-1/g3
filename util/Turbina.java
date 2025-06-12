
package util;

public class Turbina
{
    private double betz_c = 0.592592593d;
    
    private double densidade_vapor = 500.804d;
    private double area_turbina = 0d;
    
    private double velocidade = 0d;
    
    public double potencia_maxima(double energia)
    {
        double P = betz_c * densidade_vapor * area_turbina * Math.pow(velocidade, 3d) / 2d;
        
        //double P = betz_c * energia;
        //Assumindo que a energia do sistema seja conservativa, entao a energia do metano deve ser igual a energia do vapor da agua
        
        //System.out.println("DEBUG: "+ betz_c);
        //System.out.println("DEBUG: "+ densidade_vapor);
        //System.out.println("DEBUG: "+ area_turbina);
        //System.out.println("DEBUG: "+ velocidade);
        return P;
    }
    
    public void energia_paraVelocidade(double energia)
    {
        //K= (3/2)(R/NA)T
        //NA = 6.022
        
        //mv^2 / 2 = J
        //v = sqrt(2J/m)
        //this.velocidade = (double)Math.sqrt(Math.abs(2d * energia * 1000d / densidade_vapor));
        //System.out.println(this.velocidade + " m/s");
    }
    
    public void set_area_turbina(double valor)
    {
        this.area_turbina = valor;
    }
    
    public double get_area_turbina()
    {
        return area_turbina;
    }
}
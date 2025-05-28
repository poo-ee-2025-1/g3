public class EficienciaBiometano
{
    public double eficiencia = 0.9d;
    //Quanto de metano tem no biometano
    
    public double entalpia_metano = -802.27d;
    //energia liberada na queima de 1 mol de metano
    
    public double massa_molar_metano = 0.01604245; //16.04245; esse valor esta em grama/mol
    //massa de metano em kilograma/mol
    
    public double densidade_metano = 0.668d;
    //densidade do metano em kg/m^3 segundo o site https://www.engineeringtoolbox.com/gas-density-d_158.html
    
    public double densidade_bio()
    {
        return densidade_metano * eficiencia;
    }
    
    public double massa_met()
    {
        return massa_molar_metano * eficiencia;
    }
    
    public double  kg_para_ton(double kg)
    {
        return kg * 0.001102311;
        //Retorna o valor em toneladas
    }
}
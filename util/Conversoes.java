package util;

public class Conversoes
{
    EficienciaBiometano ebio = new EficienciaBiometano();
    public double Volume = 30.1045d;
    //Volume de biometano produzido por tonelada de lixo em Nm3
    
    public double massa_met(double toneladas)
    {
        double massa = (double) (((ebio.kg_para_ton(ebio.densidade_metano)) / Volume) * ebio.eficiencia * toneladas);
        return massa;
    }
    
    public double mol_met(double toneladas)
    {
        double mol = (double) (massa_met(toneladas) / ebio.kg_para_ton(ebio.massa_molar_metano));
        return mol;
    }
    
    public double energia_met(double toneladas)
    {
        double energia = (double) (mol_met(toneladas) * ebio.entalpia_metano);
        return energia;
    }
    
    //TESTE DE CALCULOS, rode isso para testar os valores das conversoes
    public static void main(String[] args)
    {
        EficienciaBiometano ebio = new EficienciaBiometano();
        
        //System.out.println(ebio.kg_para_ton(ebio.massa_met()));
        
        //tonelada a partir do volume
        //V=densidade/massa
        double Volume = 30.1045d;
        double massa_met = (double) (((ebio.kg_para_ton(ebio.densidade_metano)) / Volume) * ebio.eficiencia);
        double mol_met = (double) (massa_met / ebio.kg_para_ton(ebio.massa_molar_metano));
        double energia_met = (double) (mol_met * ebio.entalpia_metano);
        
        System.out.println(Volume + " Nm^3");
        System.out.println(massa_met + " Ton");
        System.out.println(mol_met + " mol");
        System.out.println(energia_met + " kJ/mol");
    }
}
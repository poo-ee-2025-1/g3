package modelo;

public class LixoSeco {
    private double mMadeira;
    private double mTecidos;
    private double mPapeis;
    private double eficiencia;
    private double jAparente;
    private double jUtil;
    private double jPerda;
    
    private double jMadeira = 16_000_000;
    private double jTecidos = 15_000_000;
    private double jPapeis = 13_500_000;

    public LixoSeco(double mMadeira, double mTecidos, double mPapeis, double eficiencia, double jMadeira, double jTecidos, double jPapeis) {
        this.mMadeira = mMadeira;
        this.mTecidos = mTecidos;
        this.mPapeis = mPapeis;
        this.eficiencia = eficiencia;
        
        this.jMadeira = jMadeira;
        this.jTecidos = jTecidos;
        this.jPapeis = jPapeis;
        
    }

    public void calcularEnergias() {
        jAparente = (mMadeira * jMadeira) + (mTecidos * jTecidos) + (mPapeis * jPapeis);
        jUtil = jAparente * eficiencia;
        jPerda = jAparente - jUtil;
    }

    public double getJAparente() {
        return jAparente;
    }

    public double getJUtil() {
        return jUtil;
    }

    public double getJPerda() {
        return jPerda;
    }
}

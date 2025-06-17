package modelo;

public class LixoSeco {
    private double mMadeira;
    private double mTecidos;
    private double mPapeis;
    private double eficiencia;
    private double jAparente;
    private double jUtil;
    private double jPerda;

    public LixoSeco(double mMadeira, double mTecidos, double mPapeis, double eficiencia) {
        this.mMadeira = mMadeira;
        this.mTecidos = mTecidos;
        this.mPapeis = mPapeis;
        this.eficiencia = eficiencia;
    }

    public void calcularEnergias() {
        jAparente = (mMadeira * 16_000_000) + (mTecidos * 15_000_000) + (mPapeis * 13_500_000);
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

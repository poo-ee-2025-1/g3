package servicos;

import modelo.LixoSeco;

public class ConEnSec {

    public double aparenteParaWh(LixoSeco lixo) {
        return lixo.getJAparente() / 3600;
    }

    public double aparenteParaKWh(LixoSeco lixo) {
        return lixo.getJAparente() / 3_600_000;
    }

    public double utilParaWh(LixoSeco lixo) {
        return lixo.getJUtil() / 3600;
    }

    public double utilParaKWh(LixoSeco lixo) {
        return lixo.getJUtil() / 3_600_000;
    }

    public double perdaParaWh(LixoSeco lixo) {
        return lixo.getJPerda() / 3600;
    }

    public double perdaParaKWh(LixoSeco lixo) {
        return lixo.getJPerda() / 3_600_000;
    }
}

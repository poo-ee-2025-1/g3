package servicos;

import modelo.LixoSeco;

public class ReEnSec {
    private LixoSeco ls;
    private ConEnSec ces;

    public ReEnSec(LixoSeco ls, ConEnSec ces) {
        this.ls = ls;
        this.ces = ces;
    }

    public void relatorio() {
        System.out.println();
        System.out.println("// Tipo             : Energia (J)       : Energia (Wh)     : Energia (kWh)");
        System.out.printf("// Energia Aparente : %,.2f : %,.2f : %,.4f%n",
                ls.getJAparente(), ces.aparenteParaWh(ls), ces.aparenteParaKWh(ls));
        System.out.printf("// Energia Útil     : %,.2f : %,.2f : %,.4f%n",
                ls.getJUtil(), ces.utilParaWh(ls), ces.utilParaKWh(ls));
        System.out.printf("// Energia Perdida  : %,.2f : %,.2f : %,.4f%n",
                ls.getJPerda(), ces.perdaParaWh(ls), ces.perdaParaKWh(ls));
        System.out.println();
    }
}

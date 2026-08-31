package br.edu.utfpr.giuvane.revisao.principal;

import br.edu.utfpr.giuvane.revisao.controle.PatrimonioController;
import br.edu.utfpr.giuvane.revisao.modelo.dao.EntityManagerProvider;

/**
 * @author Caio Macedo
 */
public class Principal {
    public static void main(String[] args) {
        
        // Inicializa a fábrica e força a leitura do persistence.xml (e do seed.sql consequentemente)
        EntityManagerProvider.getInstance().getEntityManager().close();
        
        PatrimonioController controller = new PatrimonioController();
        controller.exibirQuantidadePatrimoniosPorCidade();
        controller.exibirValorTotalBairro1();
        controller.exibirPatrimonioMaiorValor();
        
        EntityManagerProvider.getInstance().close();
    }
}

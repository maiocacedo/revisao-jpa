package br.edu.utfpr.giuvane.revisao.controle;

import br.edu.utfpr.giuvane.revisao.modelo.dao.PatrimonioDAO;
import br.edu.utfpr.giuvane.revisao.modelo.classes.Patrimonio;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Caio Macedo
 */
public class PatrimonioController {
    
    private PatrimonioDAO dao;
    
    public PatrimonioController() {
        this.dao = new PatrimonioDAO();
    }
    
    public void exibirQuantidadePatrimoniosPorCidade() {
        System.out.println("\n--- Quantidade de Patrimônios por Cidade ---");
        List<Object[]> resultados = dao.getQuantidadePatrimoniosPorCidade();
        for (Object[] row : resultados) {
            System.out.println("Cidade: " + row[0] + " | Quantidade: " + row[1]);
        }
    }
    
    public void exibirValorTotalBairro1() {
        System.out.println("\n--- Valor Total de Aquisição no Bairro ID 1 ---");
        BigDecimal total = dao.getValorTotalAquisicaoNoBairroId1();
        System.out.println("Valor Total: " + (total != null ? total : 0));
    }
    
    public void exibirPatrimonioMaiorValor() {
        System.out.println("\n--- Patrimônio de Maior Valor de Aquisição ---");
        Patrimonio p = dao.getPatrimonioMaiorValorAquisicao();
        if (p != null) {
            System.out.println("Patrimônio: " + p.getDescricao() + " | Valor: " + p.getValorAquisicao());
        } else {
            System.out.println("Nenhum patrimônio encontrado.");
        }
    }
}

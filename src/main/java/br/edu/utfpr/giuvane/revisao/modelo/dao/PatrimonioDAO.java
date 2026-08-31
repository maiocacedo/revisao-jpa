package br.edu.utfpr.giuvane.revisao.modelo.dao;

import br.edu.utfpr.giuvane.revisao.modelo.classes.Patrimonio;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author Caio Macedo
 */
public class PatrimonioDAO {
    
    public List<Object[]> getQuantidadePatrimoniosPorCidade() {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        try {
            String jpql = "SELECT p.predio.cidade.descricao, COUNT(p) " +
                          "FROM Patrimonio p " +
                          "GROUP BY p.predio.cidade.descricao";
            return em.createQuery(jpql, Object[].class).getResultList();
        } finally {
            em.close();
        }
    }
    
    public BigDecimal getValorTotalAquisicaoNoBairroId1() {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        try {
            String jpql = "SELECT SUM(p.valorAquisicao) FROM Patrimonio p WHERE p.predio.bairro.codigo = 1L";
            return em.createQuery(jpql, BigDecimal.class).getSingleResult();
        } finally {
            em.close();
        }
    }
    
    public Patrimonio getPatrimonioMaiorValorAquisicao() {
        EntityManager em = EntityManagerProvider.getInstance().getEntityManager();
        try {
            String jpql = "SELECT p FROM Patrimonio p ORDER BY p.valorAquisicao DESC";
            return em.createQuery(jpql, Patrimonio.class).setMaxResults(1).getSingleResult();
        } finally {
            em.close();
        }
    }
}

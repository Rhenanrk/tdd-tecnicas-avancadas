package br.ufg.inf.es.tacs;

import br.ufg.inf.es.tacs.dominio.Lance;
import br.ufg.inf.es.tacs.dominio.Leilao;
import br.ufg.inf.es.tacs.dominio.Usuario;
import leilao.Avaliador;
import org.junit.Assert;
import org.junit.Test;

public class TesteDoAvaliador {

    @Test
    public void teste(){
        // cenario
        Usuario joao = new Usuario("João");
        Usuario jose = new Usuario("Jose");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Honda GC 150");

        /*Primeiro teste*/
        leilao.propoe(new Lance(joao, 250.00));
        leilao.propoe(new Lance(jose, 300.00));
        leilao.propoe(new Lance(maria, 400.00));

        // acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        // validacao
        double maiorEsperado = 400;
        double menorEsperado = 250;

        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.000001);
        Assert.assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.000001);


        /* Segundo teste*/
        leilao.propoe(new Lance(joao, 300.00));
        leilao.propoe(new Lance(jose, 400.00));
        leilao.propoe(new Lance(maria, 250.00));

        // acao
        leiloeiro.avalia(leilao);

        // validacao
        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorDeTodos(), 0.000001);
        Assert.assertEquals(menorEsperado, leiloeiro.getMenorDeTodos(), 0.000001);



    }
}

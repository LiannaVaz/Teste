package Testes.Pagamento;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExemploTesteJUnit {


    @Before
    public void rodandoAntes() {
        System.out.println("Rodando antes de cada teste da bateria");
    }

    @After
    public void rodandoDepois() {
        System.out.println("Rodando DEPOIS de cada teste da bateria");
    }



    @Test
    public void testeExemplo() {

       System.out.println("teste");
        assertTrue("Este é o meu primeiro teste", true);
        assertFalse("Espero que o retorno aqui seja falso", false);


    }

    @Test
    public void testeExemplo2() {

       System.out.println("Teste2");
        assertTrue("Este é o meu Segundo teste", true);
        assertFalse("Espero que o retorno aqui seja falso", false);


    }



}

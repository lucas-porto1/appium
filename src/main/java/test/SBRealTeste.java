package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.MenuPage;
import page.SBRealPage;

/**
 * Teste de uma aplicação real.
 * Métodos de inserção, alteração, exclusão de contas e movimentações.
 * @author Lucas Porto Gomes
 */

public class SBRealTeste extends BaseTest {
    MenuPage menuPage = new MenuPage();
    SBRealPage sbRealPage = new SBRealPage();

    @Before
    public void inicializa(){
        menuPage.acessarSBNativo();
        sbRealPage.setEmail("lucas@lucas");
        sbRealPage.setSenha("lucas");
        sbRealPage.entrar();
    }

    @Test
    public void inserirConta(){
        sbRealPage.reset();
        sbRealPage.acessaAbaContas();
        //valida se a mensagem não está aparecendo antes de criar a conta.
        Assert.assertFalse(menuPage.existemElementosByText("Conta adicionada com sucesso"));


        //insere e salva uma nova conta.
        sbRealPage.insereNomeConta("Conta do Porto via Appium");
        sbRealPage.salvar();


        //valida se a mensagem apareceu após criar a conta com sucesso.
        Assert.assertTrue(menuPage.existemElementosByText("Conta adicionada com sucesso"));
        //valida se a conta realmente foi criada.
        Assert.assertTrue(menuPage.existemElementosByText("Conta do Porto via Appium"));

        //tenta inserir a mesma conta novamente.
        sbRealPage.insereNomeConta("Conta do Porto via Appium");
        sbRealPage.salvar();

        //valida a mensagem após tentar criar a mesma conta.
        Assert.assertEquals("Problemas de comunicação",menuPage.obterTextoByText("Problemas de comunicação"));
    }

    @Test
    public void excluirConta(){
        sbRealPage.reset();
        sbRealPage.acessaAbaContas();
        //valida se a mensagem não está aparecendo antes de excluir a conta.
        Assert.assertFalse(menuPage.existemElementosByText("Conta excluída com sucesso"));
        //valida se a conta existe antes de excluir.
        Assert.assertTrue(menuPage.existemElementosByText("Conta mesmo nome"));


        //seleciona conta que já está em uso nas movimentações
        sbRealPage.selecionarContaParaExclusao("Conta para movimentacoes");
        sbRealPage.excluirConta();
        //valida se a conta não foi excluída e se a mensagem de uso aparece.
        Assert.assertTrue(menuPage.existemElementosByText("Conta para movimentacoes"));
        Assert.assertTrue(menuPage.existemElementosByText("Conta em uso nas movimentações"));


        //seleciona e exclui uma conta.
        sbRealPage.selecionarContaParaExclusao("Conta mesmo nome");
        sbRealPage.excluirConta();


        //valida se a mensagem apareceu após excluir a conta com sucesso.
        Assert.assertTrue(menuPage.existemElementosByText("Conta excluída com sucesso"));
        //valida se a conta realmente foi excluída.
        Assert.assertFalse(menuPage.existemElementosByText("Conta mesmo nome"));
    }


    @Test
    public void validaInclusaoMov(){
        sbRealPage.acessaAbaMovimentacao();
        menuPage.esperar(1000);
        /* cenário: validar os campos obrigatórios */

        //validar descrição
         sbRealPage.salvar(); //tenta salvar sem preencher descrição.
         Assert.assertTrue(sbRealPage.existemElementosByText("Descrição é um campo obrigatório"));

        //validar interessados
        sbRealPage.setDescricao("Appium");
        menuPage.esperar(1000);
        sbRealPage.salvar();
        Assert.assertTrue(sbRealPage.existemElementosByText("Interessado é um campo obrigatório"));

        //validar valor
        sbRealPage.setInteressado("Lucas");
        menuPage.esperar(1000);
        sbRealPage.salvar();
        Assert.assertTrue(sbRealPage.existemElementosByText("Valor é um campo obrigatório"));

        //validar conta
        sbRealPage.setValor("500");
        menuPage.esperar(1000);
        sbRealPage.salvar();
        Assert.assertTrue(sbRealPage.existemElementosByText("Conta é um campo obrigatório"));

        //inserir com sucesso.
        sbRealPage.setConta("Conta para saldo");
        menuPage.esperar(1000);
        sbRealPage.salvar();
        Assert.assertTrue(sbRealPage.existemElementosByText("Movimentação cadastrada com sucesso"));

    }

    @Test
    public void excluirMovimentacaoESaldo(){
        sbRealPage.reset();
        sbRealPage.esperar(500);
        //verifica saldo "Conta para saldo" = 534.00
        Assert.assertEquals("534.00",sbRealPage.obterSaldoConta("Conta para saldo"));

        //ir para resumo
        sbRealPage.acessaAbaResumo();
        sbRealPage.esperar(500);
        sbRealPage.atualizar();
        sbRealPage.esperar(500);
        //excluir movimentação 3
        sbRealPage.excluirMovimentacao("Movimentacao 3, calculo saldo");


        //validar a mensagem "Movimentação removida com sucesso!"
        Assert.assertTrue(menuPage.existemElementosByText("Movimentação removida com sucesso!"));

        //voltar home
        sbRealPage.esperar(500);
        sbRealPage.acessarAbaHome();

        //atualizar saldo
        sbRealPage.esperar(500);
        sbRealPage.scroll(0.2,0.9);
        sbRealPage.esperar(500);

        //verificar se o saldo foi atualizado para =-1000.00
        Assert.assertEquals("-1000.00",sbRealPage.obterSaldoConta("Conta para saldo"));

    }

}

package page;

import core.BasePage;
import core.DriverFactory;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;


public class SBRealPage extends BasePage {

    public void setEmail(String email){
        escrever(By.xpath("//*[@text='Nome']"),email);
    }

    public void setSenha(String senha){
        escrever(By.xpath("//*[@text='Senha']"),senha);
    }

    public void entrar(){
        clicarPorTexto("ENTRAR");
    }

    public void reset(){
        clicarPorTexto("RESET");
    }

    public void acessaAbaContas(){
        clicarPorTexto("CONTAS");
    }

    public void insereNomeConta(String conta){
        escrever(By.className("android.widget.EditText"),conta);
    }

    public void salvar(){
        clicarPorTexto("SALVAR");
    }

    public void selecionarContaParaExclusao(String conta){
            cliqueLongo(By.xpath("//*[@text='"+conta+"']"));
    }

    public void excluirConta(){
        clicarPorTexto("EXCLUIR");
    }

    public void acessarAbaHome(){
        clicarPorTexto("HOME");
    }

    public void acessaAbaMovimentacao(){
        clicarPorTexto("MOV...");
    }

    public void acessaAbaResumo(){
        clicarPorTexto("RESUMO");
    }

    public void setDescricao(String descricao){
        escrever(By.className("android.widget.EditText"),descricao);
    }

    public void setInteressado(String interessado){
        escrever(By.xpath("//android.widget.EditText[2]"),interessado);
    }

    public void setValor(String valor){
        escrever(By.xpath("//android.widget.EditText[3]"),valor);
    }

    public void setConta(String conta){
        selecionarCombo(By.xpath("//android.widget.Spinner[2]"), conta);
    }

    public String obterSaldoConta(String conta){
        return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
    }

    public void excluirMovimentacao(String movimentacao){
        MobileElement element = (MobileElement) DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+movimentacao+"']/.."));
        swipeElement(element,0.9,0.1);
        esperar(500);
        clicarPorTexto("Del");
    }

    public void atualizar(){
        clicarPorTexto("ATUALIZAR");
    }

}

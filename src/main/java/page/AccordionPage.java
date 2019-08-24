package page;

import core.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {

    public boolean verificaQtdElementos() {
        return existemQtdElementos(By.className("android.widget.TextView"), 6);
    }

    public void acessaOpcaoUm() {
        clicarPorTexto("Opção 1");
    }

    public void acessaOpcaoDois() {
        clicarPorTexto("Opção 2");
    }

    public void acessaOpcaoTres() {
        clicarPorTexto("Opção 3");
    }

    public void acessaOpcaoQuatro() {
        clicarPorTexto("Opção 4");
    }

    public void acessaOpcaoCinco() {
        clicarPorTexto("Opção 5");
    }

    public void acessaOpcaoSeis() {
        clicarPorTexto("Opção 6");
    }

    public String verificaTextoOpcaoUm() {
        return obterTexto(By.xpath("//*[@text='Esta é a descrição da opção 1']"));
    }

    public String verificaTextoOpcaoDois() {
        return obterTexto(By.xpath("//*[@text='Esta é a descrição da opção 2']"));
    }

    public String verificaTextoOpcaoTres() {
        return obterTexto(By.xpath("//*[@text='Esta é a descrição da opção 3. Que pode, inclusive ter mais que uma linha']"));
    }

    public String verificaTextoOpcaoQuatro() {
        return obterTexto(By.xpath("//*[@text='Esta é a descrição da opção 4']"));
    }

    public String verificaTextoOpcaoCinco() {
        return obterTexto(By.xpath("//*[@text='Esta é a descrição da opção 5']"));
    }

    public String verificaTextoOpcaoSeis() {
        return obterTexto(By.xpath("//*[@text='Esta é a descrição da opção 6']"));
    }


}

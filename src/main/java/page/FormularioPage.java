package page;

import core.BasePage;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class FormularioPage extends BasePage {


    public void escreverNome(String nome) {
        escrever(MobileBy.AccessibilityId("nome"), nome);
    }

    public String obterNome() {
        return obterTexto(MobileBy.AccessibilityId("nome"));
    }

    public void selecionarComboBox(String valor) {
        selecionarCombo(MobileBy.AccessibilityId("console"), valor);
    }

    public String obterValorCombo() {
        return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarCheck() {
        clicar(MobileBy.AccessibilityId("check"));
    }

    public void clicarSwitch() {
        clicar(MobileBy.AccessibilityId("switch"));
    }

    public boolean isCheckMarcado() {
        return isCheckMarcado(MobileBy.AccessibilityId("check"));
    }

    public boolean isSwitchMarcado() {
        return isCheckMarcado(MobileBy.AccessibilityId("switch"));
    }

    public void salvarCadastro() {
        clicar(MobileBy.AccessibilityId("save"));
    }

    public String obterNomeCadastrado() {
        return obterTexto(MobileBy.xpath("//android.widget.TextView[starts-with(@text, 'Nome: ')]"));
    }

    public String obterConsoleCadastrado() {
        return obterTexto(MobileBy.xpath("//android.widget.TextView[starts-with(@text, 'Console: ')]"));
    }

    public String obterCheckCadastrado() {
        return obterTexto(MobileBy.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox: ')]"));
    }

    public String obterSwitchCadastrado() {
        return obterTexto(MobileBy.xpath("//android.widget.TextView[starts-with(@text, 'Switch: ')]"));
    }

    public void clicaData(String data){
        clicarPorTexto(data);
    }

    public void clicaHora(String hora){
        clicarPorTexto(hora);
    }

    public boolean verificaData(String data){
      return  existeElemento(By.xpath("//*[@text='"+data+"']"));
    }

    public boolean verificaHora(String hora){
        return  existeElemento(By.xpath("//*[@text='"+hora+"']"));
    }


}

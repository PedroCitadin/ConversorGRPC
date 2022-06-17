
package conversor.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pedro Citadin Coelho
 */
public class Conversao {
    private Float valor;
    private int moedaInicial;
    private int moedaFinal;
    private Float valorFinal;

    public Conversao(Float valor, int moedaInicial, int moedaFinal) {
        this.valor = valor;
        this.moedaInicial = moedaInicial;
        this.moedaFinal = moedaFinal;
    }

    //////urls
    public final String BRLTOUSD = "https://economia.awesomeapi.com.br/last/BRL-USD";
    public final String BRLTOEUR = "https://economia.awesomeapi.com.br/last/BRL-EUR";
    public final String BRLTOGBP = "https://economia.awesomeapi.com.br/last/BRL-GBP";
    public final String USDTOBRL = "https://economia.awesomeapi.com.br/last/USD-BRL";
    public final String USDTOEUR = "https://economia.awesomeapi.com.br/last/USD-EUR";
    public final String USDTOGBP = "https://economia.awesomeapi.com.br/last/USD-GBP";
    public final String EURTOUSD = "https://economia.awesomeapi.com.br/last/EUR-USD";
    public final String EURTOBRL = "https://economia.awesomeapi.com.br/last/EUR-BRL";
    public final String EURTOGBP = "https://economia.awesomeapi.com.br/last/EUR-GBP";
    public final String GBPTOUSD = "https://economia.awesomeapi.com.br/last/GBP-USD";
    public final String GBPTOBRL = "https://economia.awesomeapi.com.br/last/GBP-BRL";
    public final String GBPTOEUR = "https://economia.awesomeapi.com.br/last/GBP-EUR";

    public Conversao() {

    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public int getMoedaInicial() {
        return moedaInicial;
    }

    public void setMoedaInicial(int moedaInicial) {
        this.moedaInicial = moedaInicial;
    }

    public int getMoedaFinal() {
        return moedaFinal;
    }

    public void setMoedaFinal(int moedaFinal) {
        this.moedaFinal = moedaFinal;
    }

    public Float getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Float valorFinal) {
        this.valorFinal = valorFinal;
    }
    public float converte(Conversao conv){
        float valorFinal = 0;
        switch(conv.getMoedaInicial()){
            case 0:
                switch (conv.getMoedaFinal()) {
                    case 1 -> valorFinal = conv.getValor() * requisicao(BRLTOUSD);
                    case 2 -> valorFinal = conv.getValor() * requisicao(BRLTOEUR);
                    case 3 -> valorFinal = conv.getValor() * requisicao(BRLTOGBP);
                }
                break;
            case 1:
                valorFinal = switch (conv.getMoedaFinal()) {
                    case 0 -> conv.getValor() * requisicao(USDTOBRL);
                    case 2 -> conv.getValor() * requisicao(USDTOEUR);
                    case 3 -> conv.getValor() * requisicao(USDTOGBP);
                    default -> valorFinal;
                };

                break;
            case 2:
                valorFinal = switch (conv.getMoedaFinal()) {
                    case 0 -> conv.getValor() * requisicao(EURTOBRL);
                    case 1 -> conv.getValor() * requisicao(EURTOUSD);
                    case 3 -> conv.getValor() * requisicao(EURTOGBP);
                    default -> valorFinal;
                };
                break;
            case 3:
                valorFinal = switch (conv.getMoedaFinal()) {
                    case 0 -> conv.getValor() * requisicao(GBPTOBRL);
                    case 1 -> conv.getValor() * requisicao(GBPTOUSD);
                    case 2 -> conv.getValor() * requisicao(GBPTOEUR);
                    default -> valorFinal;
                };
                break;
        }


        return valorFinal;
    }

    public Float requisicao(String url){
        Float valorFinal = null;
        try {


            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String output = "";
            String line;
            while ((line = br.readLine()) != null) {
                output += line;
            }

            conn.disconnect();
            String saa = output;
            String aux[] = saa.split(":");
            String aux2[] = aux[6].split(",");

            StringBuilder aux3 = new StringBuilder(aux2[0]);
            aux3.deleteCharAt(0);
            aux3.deleteCharAt(aux3.length()-1);
            System.out.println(aux3);
            valorFinal = Float.parseFloat(String.valueOf(aux3));
        } catch (IOException ex) {
            Logger.getLogger(Conversao.class.getName()).log(Level.SEVERE, null, ex);
        }


        return valorFinal;
    }




}

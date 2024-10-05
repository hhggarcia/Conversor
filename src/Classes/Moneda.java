package Classes;

public class Moneda {
    private String codigoPais;
    private double valor;
    private String pais;

    public Moneda(String codigoPais, double valor, String pais) {
        this.codigoPais = codigoPais;
        this.valor = valor;
        this.pais = pais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return " | Codigo: " + this.codigoPais +
                " Pais: " + this.pais +
                " Cambio: " + this.valor + " |\n";
    }
}

package validaciontarjetas.domain;

public class Respuesta {

    private Integer cod;
    private String info;

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getInfo() {
        return info;
    }

    public Respuesta(Integer cod, String info) {
        this.cod = cod;
        this.info = info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
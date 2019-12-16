package validaciontarjetas.domain;

public class RespuestaError {

    private Integer codError;
    private String error;

    public Integer getCodError() {
        return codError;
    }

    public void setCodError(Integer codError) {
        this.codError = codError;
    }

    public String getError() {
        return error;
    }

    public RespuestaError(Integer codError, String error) {
        this.codError = codError;
        this.error = error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

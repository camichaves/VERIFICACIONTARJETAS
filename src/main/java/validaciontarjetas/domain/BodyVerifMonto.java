package validaciontarjetas.domain;

import java.io.Serializable;

import com.google.gson.Gson;



public class BodyVerifMonto {
    /**
     *
     */
    
    private Long id;
    private Double monto;

    public BodyVerifMonto ( String json){
        System.out.println("Entre al constructor");
        Gson gson = new Gson();
        BodyVerifMonto b = gson.fromJson(json, BodyVerifMonto.class);
        this.id= b.getId();
        this.monto=b.getMonto();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}

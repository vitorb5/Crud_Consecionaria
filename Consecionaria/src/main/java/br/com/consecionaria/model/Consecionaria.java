package br.com.consecionaria.model;

import javax.persistence.*;

@Entity
@Table(name = "CONSECIONARIA")
public class Consecionaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "COR")
    private String cor;

    @Column(name = "TIPO")
    private boolean tipo;

    @Column(name = "QUILOMETRAGEM")
    private double quilometragem;

    @Column(name = "PLACA")
    private String placa;

    public Consecionaria(String modelo){
        this.id = id;
        this.modelo = modelo;
        this.cor =cor;
        this.tipo = tipo;
        this.quilometragem = quilometragem;
        this.placa = placa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}

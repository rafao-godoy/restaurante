package br.com.comercio.springcomercio.entity;


public class Restaurante {

    private int codigo_restaurante;
    private String nome_restaurante;
    private String tipo_comida;
    private String estado;
    private String cidade;

    public Restaurante(int codigo_restaurante, String nome_restaurante, String tipo_comida, String estado, String cidade) {
        this.codigo_restaurante = codigo_restaurante;
        this.nome_restaurante = nome_restaurante;
        this.tipo_comida = tipo_comida;
        this.estado = estado;
        this.cidade = cidade;
    }

    public Restaurante(){}

    public int getCodigo_restaurante() {
        return codigo_restaurante;
    }

    public void setCodigo_restaurante(int codigo_restaurante) {
        this.codigo_restaurante = codigo_restaurante;
    }

    public String getNome_restaurante() {
        return nome_restaurante;
    }

    public void setNome_restaurante(String nome_restaurante) {
        this.nome_restaurante = nome_restaurante;
    }

    public String getTipo_comida() {
        return tipo_comida;
    }

    public void setTipo_comida(String tipo_comida) {
        this.tipo_comida = tipo_comida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}

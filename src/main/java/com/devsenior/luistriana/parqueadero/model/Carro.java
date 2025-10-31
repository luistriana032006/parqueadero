package com.devsenior.luistriana.parqueadero.model;

public class Carro {
    private String placa;
    private Double tiempoPago;

    

    public Carro() {
    }

    public Carro(String placa, double tiempoPago) {
        this.placa = placa;
        this.tiempoPago = tiempoPago;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getTiempoPago() {
        return tiempoPago;
    }

    public void setTiempoPago(double tiempoPago) {
        this.tiempoPago = tiempoPago;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((placa == null) ? 0 : placa.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carro other = (Carro) obj;
        if (placa == null) {
            if (other.placa != null)
                return false;
        } else if (!placa.equals(other.placa))
            return false;
        return true;
    }

}

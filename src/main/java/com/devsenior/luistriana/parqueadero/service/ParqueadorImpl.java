package com.devsenior.luistriana.parqueadero.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.devsenior.luistriana.parqueadero.model.Carro;

@Service
public class ParqueadorImpl implements ServiceParqueadero {
    Set<Carro> carros;
    private final double tarifaPorHora = 3000;

    // calculo de dinero a pagar

    public ParqueadorImpl() {
        this.carros = new HashSet<>();
    }

    @Override
    public Map<String, Object> calcularPago(String placa) {
        try {
            Carro carro = buscarCarroPorPlaca(placa);
            double totalAPagar = carro.getTiempoPago() * tarifaPorHora;
            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("placa", carro.getPlaca());
            respuesta.put("Horas usadas", carro.getTiempoPago());
            respuesta.put("tarifaPorHora", tarifaPorHora);
            respuesta.put("total a pagar", totalAPagar);
            respuesta.put("mensaje", "el total a pagar por el uso del parqueadero es " + totalAPagar);
            return respuesta;
        } catch (RuntimeException e) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", true);
            error.put("mensaje", "carro con la placa " + placa + " no fue encontrado en el sistema");
            return error;
        }
    }

    @Override
    public void agregarCarro(Carro carro) {
        carros.add(carro);

    }

    @Override
    public List<Carro> obtenerTodosLosCarros() {
        return new ArrayList<>(carros);
    }

    @Override
    public Carro buscarCarroPorPlaca(String placa) {
        return carros.stream().filter(carro -> carro.getPlaca().equals(placa))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(" el carro con esa placa no esta en el sistema"));

    }

    @Override
    public void eliminarCarro(String placa) {
        Carro carroEliminado = buscarCarroPorPlaca(placa);
        carros.remove(carroEliminado);

    }

    @Override
    public Carro actualizarTiempo(String placa, Carro carro) {
        Carro carroActualizar = buscarCarroPorPlaca(placa);
        Optional.ofNullable(carro.getTiempoPago()).ifPresent(carroActualizar::setTiempoPago);
        return carroActualizar;
    }

}

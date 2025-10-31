package com.devsenior.luistriana.parqueadero.service;

import java.util.List;
import java.util.Map;

import com.devsenior.luistriana.parqueadero.model.Carro;

public interface ServiceParqueadero {
    Map<String, Object> calcularPago(String placa);
    
    void agregarCarro(Carro carro);

    List<Carro> obtenerTodosLosCarros();

    Carro buscarCarroPorPlaca(String placa);

    void eliminarCarro(String placa);
 // vamos a retornar le carro que se actulalizo 
    Carro actualizarTiempo(String placa, Carro carro);

}

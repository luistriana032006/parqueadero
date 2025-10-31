package com.devsenior.luistriana.parqueadero.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.luistriana.parqueadero.model.Carro;

import com.devsenior.luistriana.parqueadero.service.ServiceParqueadero;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/parqueadero")
public class CarroController {
    private final ServiceParqueadero carros;

    public CarroController(ServiceParqueadero carros) {
        this.carros = carros;
    }

    // ver todos los carros
    @GetMapping("/vercarros")
    public List<Carro> vercarros() {
        return carros.obtenerTodosLosCarros();
    }

    // agregar un nuevo carro
    @PostMapping("/carro")
    public Carro agregCarro(@RequestBody Carro carro) {
        carros.agregarCarro(carro);
        return carro;
    }

    // eliminar un carro
    @DeleteMapping("/carro/{placa}")
    public void borrarcarro(@PathVariable String placa) {
        carros.eliminarCarro(placa);
    }

    // actualizar las horas de un carro

    @PatchMapping("/carro/{placa}")
    public void actualizarTiempo(@PathVariable String placa, @RequestBody Carro carro) {
        carros.actualizarTiempo(placa, carro);

    }

    // calcular el tiempo de uso del carro del parqueadero
    @GetMapping("/carro/tiempo/{placa}")
    public Map<String, Object>PagoTiempoDeUso(@PathVariable String placa) {
       return carros.calcularPago(placa);

    }

}

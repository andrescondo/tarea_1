/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tarea_1;


/**
 * Nombre: Sistema de gestion cable tipo C
 * Autor: Kevin Andres Condo Chaguay
 * Fecha de creación: 2025-04-14
 * Descripción: El sistema presenta el funcionamiento del polimorfismo de una interfaz la cual brinda metodos a otras clases
 */



// Interfaz para dispositivos que se pueden conectar a través de un cable tipo C
interface DispositivoTipoC {
    void conectar();
    void desconectar();
    void transferirDatos(String datos);
}

// Clase para un teléfono inteligente que utiliza un cable tipo C
class TelefonoInteligente implements DispositivoTipoC {
    private String modelo;
    private boolean conectado;


    /**
     * Clase constructor.
     *
     * @param modelo Nombre del modelo del telefono inteligente
     */
    public TelefonoInteligente(String modelo) {
        this.modelo = modelo;
        this.conectado = false;
    }

     /**
     * metodo encargado de presentar el nombre del modelo en uso.
     *
     * @return Nombre del modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * metodo heredada con capacidad de actualizar el estado de conectado (activar)
     */
    @Override
    public void conectar() {
        System.out.println("Teléfono " + modelo + ": Conectado a través de cable tipo C.");
        conectado = true;
    }

     /**
     * metodo heredada con capacidad de actualizar el estado de conectado (desactivar)
     */
    @Override
    public void desconectar() {
        System.out.println("Teléfono " + modelo + ": Desconectado del cable tipo C.");
        conectado = false;
    }

    /**
     * metodo que activa la funcion de transferir datos en base al estado de la clase.
     *
     * @param modelo Nombre del modelo del telefono inteligente
     */
    @Override
    public void transferirDatos(String datos) {
        if (conectado) {
            System.out.println("Teléfono " + modelo + ": Transfiriendo datos '" + datos + "' a través del cable tipo C.");
        } else {
            System.out.println("Teléfono " + modelo + ": No se pueden transferir datos. El dispositivo no está conectado.");
        }
    }
}

// Clase para una tableta que utiliza un cable tipo C
class Tableta implements DispositivoTipoC {
    private String marca;
    private boolean conectado;

    /**
     * metodo constructor
     */
    public Tableta(String marca) {
        this.marca = marca;
        this.conectado = false;
    }
    
    /**
     * metodo encargado de presentar el nombre de la marca en uso.
     *
     * @return Nombre del modelo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * metodo heredada con capacidad de actualizar el estado de conectado (activar)
     */
    @Override
    public void conectar() {
        System.out.println("Tableta " + marca + ": Conectada a través de cable tipo C.");
        conectado = true;
    }

    /**
     * metodo heredada con capacidad de actualizar el estado de conectado (desactivar)
     */
    @Override
    public void desconectar() {
        System.out.println("Tableta " + marca + ": Desconectada del cable tipo C.");
        conectado = false;
    }

    /**
     * metodo que activa la funcion de transferir datos en base al estado de la clase.
     *
     * @param modelo Nombre del modelo del telefono inteligente
     */
    @Override
    public void transferirDatos(String datos) {
        if (conectado) {
            System.out.println("Tableta " + marca + ": Recibiendo datos '" + datos + "' a través del cable tipo C.");
        } else {
            System.out.println("Tableta " + marca + ": No se pueden recibir datos. El dispositivo no está conectado.");
        }
    }
}

// Clase principal que demuestra el polimorfismo en tiempo de ejecución
/**
 *
 * @author andrescondo
 */
public class Tarea_1 {

    public static void main(String[] args) {
        // Crear instancias de dispositivos tipo C
        DispositivoTipoC miTelefono = new TelefonoInteligente("Samsung Galaxy S23");
        DispositivoTipoC miTableta = new Tableta("iPad Air");

        // Simular la conexión de los dispositivos
        miTelefono.conectar();
        miTableta.conectar();

        System.out.println();

        // Simular la transferencia de datos a través del cable tipo C
        miTelefono.transferirDatos("Mis fotos importantes");
        miTableta.transferirDatos("Un archivo grande");

        System.out.println();

        // Simular la desconexión de los dispositivos
        miTelefono.desconectar();
        miTableta.desconectar();

        System.out.println();

        // Demostración de polimorfismo: trabajar con los dispositivos a través de la interfaz
        DispositivoTipoC[] dispositivos = new DispositivoTipoC[2];
        dispositivos[0] = miTelefono;
        dispositivos[1] = miTableta;

        for (DispositivoTipoC dispositivo : dispositivos) {
            System.out.println("Trabajando con el dispositivo: " + dispositivo.getClass().getSimpleName());
            dispositivo.conectar();
            dispositivo.transferirDatos("Información genérica");
            dispositivo.desconectar();
            System.out.println();
        }
    }
}

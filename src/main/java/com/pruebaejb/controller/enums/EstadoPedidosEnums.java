package com.pruebaejb.controller.enums;

public enum EstadoPedidosEnums {
    PENDIENTE(1), EMITIDO(2), FINALIZADO(3), SUSPENDIDO(4);
    
    Integer valor;
    
    private EstadoPedidosEnums(Integer v){
        valor=v;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}

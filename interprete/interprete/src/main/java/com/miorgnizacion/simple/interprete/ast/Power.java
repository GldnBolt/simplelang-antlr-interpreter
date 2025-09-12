package com.miorgnizacion.simple.interprete.ast;

import java.util.Map;

public class Power implements ASTNode {
    private final ASTNode a,b;
    public Power(ASTNode a, ASTNode b){ this.a=a; this.b=b; }

    @Override public Object execute(Map<String, Object> sym) {
        Object x = a.execute(sym), y = b.execute(sym);
        if ((Types.isInt(x) || Types.isReal(x)) && Types.isInt(y)) {
            double base = Types.asDouble(x);
            long   exp  = Types.asLong(y);
            return Math.pow(base, (double) exp);
        }
        throw new RuntimeSemError("Potencia requiere base numérica y exponente entero");
    }
}

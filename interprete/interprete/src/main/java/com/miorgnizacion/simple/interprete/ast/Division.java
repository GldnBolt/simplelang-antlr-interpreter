package com.miorgnizacion.simple.interprete.ast;

import java.util.Map;

public class Division implements ASTNode {
    private final ASTNode a,b;
    public Division(ASTNode a, ASTNode b){ this.a=a; this.b=b; }

    @Override public Object execute(Map<String, Object> sym) {
        Object x = a.execute(sym), y = b.execute(sym);
        if ((Types.isInt(x) || Types.isReal(x)) && (Types.isInt(y) || Types.isReal(y))) {
            double den = Types.asDouble(y);
            if (den == 0.0) throw new RuntimeSemError("División por cero");
            // Si ambos eran enteros, mantenemos división entera (como tu intérprete original hacía con '/')
            if (Types.isInt(x) && Types.isInt(y)) return (int)(Types.asLong(x) / Types.asLong(y));
            return Types.asDouble(x) / den;
        }
        throw new RuntimeSemError("División requiere números");
    }
}

package com.miorgnizacion.simple.interprete.ast;

import java.util.Map;

public class Subtraction implements ASTNode {
    private final ASTNode a,b;
    public Subtraction(ASTNode a, ASTNode b){ this.a=a; this.b=b; }

    @Override public Object execute(Map<String, Object> sym) {
        Object x = a.execute(sym), y = b.execute(sym);
        if ((Types.isInt(x) || Types.isReal(x)) && (Types.isInt(y) || Types.isReal(y))) {
            if (Types.isReal(x) || Types.isReal(y)) return Types.asDouble(x) - Types.asDouble(y);
            return (int) (Types.asLong(x) - Types.asLong(y));
        }
        throw new RuntimeSemError("Resta requiere números");
    }
}

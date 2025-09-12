package com.miorgnizacion.simple.interprete.ast;

final class Types {
    static boolean isInt(Object o) {
        return (o instanceof Integer) || (o instanceof Long);
    }
    static boolean isReal(Object o) {
        return (o instanceof Double) || (o instanceof Float);
    }
    static boolean isBool(Object o) {
        return (o instanceof Boolean);
    }

    static double asDouble(Object o) {
        if (o instanceof Integer) return ((Integer) o).doubleValue();
        if (o instanceof Long)    return ((Long)    o).doubleValue();
        if (o instanceof Double)  return ((Double)  o).doubleValue();
        if (o instanceof Float)   return ((Float)   o).doubleValue();
        throw new IllegalStateException("Se esperaba número, obtuve: " + o);
    }

    static long asLong(Object o) {
        if (o instanceof Integer) return ((Integer) o).longValue();
        if (o instanceof Long)    return ((Long)    o).longValue();
        // Nota: no convertimos Double/Float a entero aquí para evitar sorpresas.
        throw new IllegalStateException("Se esperaba entero, obtuve: " + o);
    }

    private Types() {}
}

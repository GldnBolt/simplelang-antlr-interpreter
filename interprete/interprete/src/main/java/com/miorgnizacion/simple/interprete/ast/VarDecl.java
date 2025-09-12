package com.miorgnizacion.simple.interprete.ast;

import java.util.Map;

public class VarDecl implements ASTNode {
	
	private String name;
	
	

	public VarDecl(String name) {
		super();
		this.name = name;
	}



	@Override
	public Object execute(Map<String, Object> symbolTable) {
		symbolTable.put(name, new Object());
		return null;
	}

}

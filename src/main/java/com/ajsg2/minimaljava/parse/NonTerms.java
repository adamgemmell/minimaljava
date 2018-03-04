package com.ajsg2.minimaljava.common;

import com.ajsg2.minimaljava.parse.sym;

public class NonTerms {

	public static final String[] ID = {
			"lit", "numtype", "primtype", "type", "infixop", "block", "name", "simplename",
			"qualifiedname",
			"program", "classdef", "classdecl", "classbodydecl", "classbody",
			"constructordef", "constructordecl", "constructorbody", "statement",
			"param", "paramlistcomma", "fielddef", "localvardef", "ifelse",
			"methoddef", "methoddecl", "methodheader", "expression",
			"promexpression", "opexpression", "castexpression", "unaryexpression",
			"varassignment", "primary", "fieldaccess", "classdeflist",
			"classbodydecls", "statementlist", "paramlist", "arglist"
	};


	public static int getProgram() {
		return sym.program;
	}

	public static int getLit() {
		return sym.lit;
	}

	public static int getQualifiedname() {
		return sym.qualifiedname;
	}

	public static int getVarassignment() {
		return sym.varassignment;
	}

	public static int getParam() {
		return sym.param;
	}

	public static int getClassbodydecl() {
		return sym.classbodydecl;
	}

	public static int getOpexpression() {
		return sym.opexpression;
	}

	public static int getClassdef() {
		return sym.classdef;
	}

	public static int getClassbody() {
		return sym.classbody;
	}

	public static int getConstructordef() {
		return sym.constructordef;
	}

	public static int getBlock() {
		return sym.block;
	}

	public static int getParamlist() {
		return sym.paramlist;
	}

	public static int getFielddef() {
		return sym.fielddef;
	}

	public static int getFieldaccess() {
		return sym.fieldaccess;
	}

	public static int getMethodheader() {
		return sym.methodheader;
	}

	public static int getName() {
		return sym.name;
	}

	public static int getCastexpression() {
		return sym.castexpression;
	}

	public static int getArglist() {
		return sym.arglist;
	}

	public static int getConstructorbody() {
		return sym.constructorbody;
	}

	public static int getMethoddef() {
		return sym.methoddef;
	}

	public static int getPrimtype() {
		return sym.primtype;
	}

	public static int getPrimary() {
		return sym.primary;
	}

	public static int getPromexpression() {
		return sym.promexpression;
	}

	public static int getExpression() {
		return sym.expression;
	}

	public static int getStatement() {
		return sym.statement;
	}

	public static int getUnaryexpression() {
		return sym.unaryexpression;
	}

	public static int getClassdeflist() {
		return sym.classdeflist;
	}

	public static int getClassbodydecls() {
		return sym.classbodydecls;
	}

	public static int getIfelse() {
		return sym.ifelse;
	}

	public static int getClassdecl() {
		return sym.classdecl;
	}

	public static int getParamlistcomma() {
		return sym.paramlistcomma;
	}

	public static int getConstructordecl() {
		return sym.constructordecl;
	}

	public static int getLocalvardef() {
		return sym.localvardef;
	}

	public static int getSimplename() {
		return sym.simplename;
	}

	public static int getStatementlist() {
		return sym.statementlist;
	}

	public static int getMethoddecl() {
		return sym.methoddecl;
	}

	public static int getNumtype() {
		return sym.numtype;
	}

	public static int getInfixop() {
		return sym.infixop;
	}

	public static int getType() {
		return sym.type;
	}
}

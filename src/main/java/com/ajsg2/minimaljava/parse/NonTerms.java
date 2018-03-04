package com.ajsg2.minimaljava.parse;

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
	public static final int program = sym.program;
	public static final int lint = sym.lit;
	public static final int qualifiedname = sym.qualifiedname;
	public static final int varassignment = sym.varassignment;
	public static final int param = sym.param;
	public static final int classbodydecl = sym.classbodydecl;
	public static final int opexpression = sym.opexpression;
	public static final int classdef = sym.classdef;
	public static final int classbody = sym.classbody;
	public static final int constructordef = sym.constructordef;
	public static final int block = sym.block;
	public static final int paramlist = sym.paramlist;
	public static final int fielddef = sym.fielddef;
	public static final int fieldaccess = sym.fieldaccess;
	public static final int methodheader = sym.methodheader;
	public static final int name = sym.name;
	public static final int castexpression = sym.castexpression;
	public static final int arglist = sym.arglist;
	public static final int constructorbody = sym.constructorbody;
	public static final int methoddef = sym.methoddef;
	public static final int primtype = sym.primtype;
	public static final int primary = sym.primary;
	public static final int promexpression = sym.promexpression;
	public static final int expression = sym.expression;
	public static final int statement = sym.statement;
	public static final int unaryexpression = sym.unaryexpression;
	public static final int classdeflist = sym.classdeflist;
	public static final int classbodydecls = sym.classbodydecls;
	public static final int ifelse = sym.ifelse;
	public static final int classdecl = sym.classdecl;
	public static final int paramlistcomma = sym.paramlistcomma;
	public static final int constructordecl = sym.constructordecl;
	public static final int localvardef = sym.localvardef;
	public static final int simplename = sym.simplename;
	public static final int statementlist = sym.statementlist;
	public static final int methoddecl = sym.methoddecl;
	public static final int numtype = sym.numtype;
	public static final int infixop = sym.infixop;
	public static final int type = sym.type;
}

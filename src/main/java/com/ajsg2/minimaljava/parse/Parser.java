
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\026\000\002\002\003\000\002\002\004\000\002\002" +
    "\003\000\002\002\003\000\002\002\003\000\002\002\003" +
    "\000\002\003\003\000\002\003\003\000\002\003\003\000" +
    "\002\003\003\000\002\003\003\000\002\004\003\000\002" +
    "\004\003\000\002\005\003\000\002\007\004\000\002\007" +
    "\002\000\002\006\013\000\002\010\005\000\002\011\004" +
    "\000\002\011\002\000\002\014\004\000\002\014\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\010\000\014\030\005\031\011\032\004\033\010\034" +
    "\007\001\002\000\004\002\ufffe\001\002\000\004\002\001" +
    "\001\002\000\004\002\012\001\002\000\004\002\ufffc\001" +
    "\002\000\004\002\ufffd\001\002\000\004\002\uffff\001\002" +
    "\000\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\010\000\004\002\005\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // lit ::= LITINT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("lit",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= lit EOF 
            {
              Object RESULT =null;
		Location start_valxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location start_valxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // lit ::= LITCHAR 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("lit",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // lit ::= LITLONG 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("lit",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // lit ::= LITDOUBLE 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("lit",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // lit ::= LITBOOL 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("lit",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // type ::= INT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("type",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // type ::= CHAR 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("type",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // type ::= LONG 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("type",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // type ::= DOUBLE 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("type",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // type ::= BOOL 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("type",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // value ::= IDENT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("value",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // value ::= lit 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("value",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // program ::= classdeflist 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("program",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // classdeflist ::= classdef classdeflist 
            {
              Object RESULT =null;
		Location cdxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location cdxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Object cd = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		Location cdlxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location cdlxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Object cdl = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("classdeflist",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // classdeflist ::= 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("classdeflist",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // classdef ::= CLASS IDENT EXTENDS IDENT CURLYBRACEL fielddeflist constructordef methoddeflist CURLYBRACER 
            {
              Object RESULT =null;
		Location idxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-7)).xleft;
		Location idxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-7)).xright;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-7)).value;
		Location id2xleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).xleft;
		Location id2xright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-5)).xright;
		Object id2 = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-5)).value;
		Location fdlxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).xleft;
		Location fdlxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).xright;
		Object fdl = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		Location cndxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xleft;
		Location cndxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).xright;
		Object cnd = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		Location mdlxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location mdlxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Object mdl = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("classdef",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-8)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // fielddef ::= type IDENT SEMICOLON 
            {
              Object RESULT =null;
		Location idxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location idxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Object id = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("fielddef",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // fielddeflist ::= fielddef fielddeflist 
            {
              Object RESULT =null;
		Location fdxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location fdxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Object fd = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		Location fdlxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xleft;
		Location fdlxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.peek()).xright;
		Object fdl = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("fielddeflist",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // fielddeflist ::= 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("fielddeflist",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // methoddeflist ::= methoddef methoddeflist 
            {
              Object RESULT =null;
		Location mdxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location mdxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Object md = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("methoddeflist",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // methoddeflist ::= 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("methoddeflist",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
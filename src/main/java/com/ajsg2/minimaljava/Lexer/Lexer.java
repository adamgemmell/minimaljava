/* The following code was generated by JFlex 1.6.1 */

/* Spec file built with the guidance of the example lexer at http://jflex.de/manual.html */

package com.ajsg2.minimaljava.Lexer;

import com.ajsg2.minimaljava.common.tokens.*;
import com.ajsg2.minimaljava.common.tokens.simple.*;
import com.ajsg2.minimaljava.common.tokens.value.*;

/**
 * The Minimal Java Lexer
 */

public class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\16\0\4\0\1\3\1\35"+
    "\2\0\1\0\1\33\1\30\1\0\1\40\1\41\1\34\1\37\1\0"+
    "\1\32\1\44\1\4\1\0\11\0\1\0\1\45\1\0\1\27\1\31"+
    "\2\0\32\0\4\0\1\0\1\0\1\20\1\23\1\24\1\16\1\6"+
    "\1\17\1\26\1\25\1\15\2\0\1\21\1\0\1\5\1\14\2\0"+
    "\1\10\1\22\1\11\1\12\1\13\1\7\3\0\1\42\1\36\1\43"+
    "\1\0\41\0\2\0\4\0\4\0\1\0\2\0\1\0\7\0\1\0"+
    "\4\0\1\0\5\0\27\0\1\0\37\0\1\0\u01ca\0\4\0\14\0"+
    "\16\0\5\0\7\0\1\0\1\0\1\0\21\0\160\0\5\0\1\0"+
    "\2\0\2\0\4\0\1\0\1\0\6\0\1\0\1\0\3\0\1\0"+
    "\1\0\1\0\24\0\1\0\123\0\1\0\213\0\1\0\5\0\2\0"+
    "\246\0\1\0\46\0\2\0\1\0\7\0\47\0\7\0\1\0\1\0"+
    "\55\0\1\0\1\0\1\0\2\0\1\0\2\0\1\0\1\0\10\0"+
    "\33\0\5\0\3\0\15\0\6\0\5\0\1\0\4\0\13\0\1\0"+
    "\1\0\3\0\53\0\37\0\4\0\2\0\1\0\143\0\1\0\1\0"+
    "\10\0\1\0\6\0\2\0\2\0\1\0\4\0\2\0\12\0\3\0"+
    "\2\0\1\0\17\0\1\0\1\0\1\0\36\0\33\0\2\0\131\0"+
    "\13\0\1\0\16\0\12\0\41\0\11\0\2\0\4\0\1\0\5\0"+
    "\26\0\4\0\1\0\11\0\1\0\3\0\1\0\5\0\22\0\31\0"+
    "\3\0\104\0\25\0\56\0\41\0\66\0\3\0\1\0\22\0\1\0"+
    "\7\0\12\0\2\0\2\0\12\0\1\0\20\0\3\0\1\0\10\0"+
    "\2\0\2\0\2\0\26\0\1\0\7\0\1\0\1\0\3\0\4\0"+
    "\2\0\1\0\1\0\7\0\2\0\2\0\2\0\3\0\1\0\10\0"+
    "\1\0\4\0\2\0\1\0\3\0\2\0\2\0\12\0\4\0\7\0"+
    "\1\0\5\0\3\0\1\0\6\0\4\0\2\0\2\0\26\0\1\0"+
    "\7\0\1\0\2\0\1\0\2\0\1\0\2\0\2\0\1\0\1\0"+
    "\5\0\4\0\2\0\2\0\3\0\3\0\1\0\7\0\4\0\1\0"+
    "\1\0\7\0\14\0\3\0\1\0\13\0\3\0\1\0\11\0\1\0"+
    "\3\0\1\0\26\0\1\0\7\0\1\0\2\0\1\0\5\0\2\0"+
    "\1\0\1\0\10\0\1\0\3\0\1\0\3\0\2\0\1\0\17\0"+
    "\2\0\2\0\2\0\12\0\1\0\1\0\7\0\1\0\7\0\3\0"+
    "\1\0\10\0\2\0\2\0\2\0\26\0\1\0\7\0\1\0\2\0"+
    "\1\0\5\0\2\0\1\0\1\0\7\0\2\0\2\0\2\0\3\0"+
    "\10\0\2\0\4\0\2\0\1\0\3\0\2\0\2\0\12\0\1\0"+
    "\1\0\20\0\1\0\1\0\1\0\6\0\3\0\3\0\1\0\4\0"+
    "\3\0\2\0\1\0\1\0\1\0\2\0\3\0\2\0\3\0\3\0"+
    "\3\0\14\0\4\0\5\0\3\0\3\0\1\0\4\0\2\0\1\0"+
    "\6\0\1\0\16\0\12\0\11\0\1\0\6\0\4\0\1\0\10\0"+
    "\1\0\3\0\1\0\27\0\1\0\20\0\3\0\1\0\7\0\1\0"+
    "\3\0\1\0\4\0\7\0\2\0\1\0\3\0\5\0\2\0\2\0"+
    "\2\0\12\0\21\0\3\0\1\0\10\0\1\0\3\0\1\0\27\0"+
    "\1\0\12\0\1\0\5\0\2\0\1\0\1\0\7\0\1\0\3\0"+
    "\1\0\4\0\7\0\2\0\7\0\1\0\1\0\2\0\2\0\2\0"+
    "\12\0\1\0\2\0\16\0\3\0\1\0\10\0\1\0\3\0\1\0"+
    "\51\0\2\0\1\0\7\0\1\0\3\0\1\0\4\0\1\0\10\0"+
    "\1\0\7\0\3\0\2\0\2\0\12\0\12\0\6\0\2\0\2\0"+
    "\1\0\22\0\3\0\30\0\1\0\11\0\1\0\1\0\2\0\7\0"+
    "\3\0\1\0\4\0\6\0\1\0\1\0\1\0\10\0\6\0\12\0"+
    "\2\0\2\0\15\0\60\0\1\0\2\0\7\0\4\0\10\0\10\0"+
    "\1\0\12\0\47\0\2\0\1\0\1\0\2\0\2\0\1\0\1\0"+
    "\2\0\1\0\6\0\4\0\1\0\7\0\1\0\3\0\1\0\1\0"+
    "\1\0\1\0\2\0\2\0\1\0\4\0\1\0\2\0\6\0\1\0"+
    "\2\0\1\0\2\0\5\0\1\0\1\0\1\0\6\0\2\0\12\0"+
    "\2\0\4\0\40\0\1\0\27\0\2\0\6\0\12\0\13\0\1\0"+
    "\1\0\1\0\1\0\1\0\4\0\2\0\10\0\1\0\44\0\4\0"+
    "\24\0\1\0\2\0\5\0\13\0\1\0\44\0\11\0\1\0\71\0"+
    "\53\0\24\0\1\0\12\0\6\0\6\0\4\0\4\0\3\0\1\0"+
    "\3\0\2\0\7\0\3\0\4\0\15\0\14\0\1\0\17\0\2\0"+
    "\46\0\1\0\1\0\5\0\1\0\2\0\53\0\1\0\u014d\0\1\0"+
    "\4\0\2\0\7\0\1\0\1\0\1\0\4\0\2\0\51\0\1\0"+
    "\4\0\2\0\41\0\1\0\4\0\2\0\7\0\1\0\1\0\1\0"+
    "\4\0\2\0\17\0\1\0\71\0\1\0\4\0\2\0\103\0\2\0"+
    "\3\0\40\0\20\0\20\0\126\0\2\0\6\0\3\0\u026c\0\2\0"+
    "\21\0\1\0\32\0\5\0\113\0\3\0\13\0\7\0\15\0\1\0"+
    "\4\0\3\0\13\0\22\0\3\0\13\0\22\0\2\0\14\0\15\0"+
    "\1\0\3\0\1\0\2\0\14\0\64\0\40\0\3\0\1\0\3\0"+
    "\2\0\1\0\2\0\12\0\41\0\4\0\1\0\12\0\6\0\130\0"+
    "\10\0\51\0\1\0\1\0\5\0\106\0\12\0\37\0\1\0\14\0"+
    "\4\0\14\0\12\0\12\0\36\0\2\0\5\0\13\0\54\0\4\0"+
    "\32\0\6\0\12\0\46\0\27\0\5\0\4\0\65\0\12\0\1\0"+
    "\35\0\2\0\13\0\6\0\12\0\15\0\1\0\10\0\16\0\102\0"+
    "\5\0\57\0\21\0\7\0\4\0\12\0\21\0\11\0\14\0\3\0"+
    "\36\0\15\0\2\0\12\0\54\0\16\0\14\0\44\0\24\0\10\0"+
    "\12\0\3\0\3\0\12\0\44\0\122\0\3\0\1\0\25\0\4\0"+
    "\1\0\4\0\3\0\2\0\1\0\2\0\6\0\300\0\66\0\6\0"+
    "\4\0\u0116\0\2\0\6\0\2\0\46\0\2\0\6\0\2\0\10\0"+
    "\1\0\1\0\1\0\1\0\1\0\1\0\1\0\37\0\2\0\65\0"+
    "\1\0\7\0\1\0\1\0\3\0\3\0\1\0\7\0\3\0\4\0"+
    "\2\0\6\0\4\0\15\0\5\0\3\0\1\0\7\0\16\0\5\0"+
    "\32\0\5\0\20\0\2\0\23\0\1\0\13\0\5\0\1\0\12\0"+
    "\1\0\1\0\15\0\1\0\20\0\15\0\3\0\37\0\21\0\15\0"+
    "\4\0\1\0\3\0\14\0\21\0\1\0\4\0\1\0\2\0\12\0"+
    "\1\0\1\0\3\0\5\0\6\0\1\0\1\0\1\0\1\0\1\0"+
    "\1\0\4\0\1\0\13\0\2\0\4\0\5\0\5\0\4\0\1\0"+
    "\21\0\51\0\u0a77\0\57\0\1\0\57\0\1\0\205\0\6\0\4\0"+
    "\3\0\2\0\14\0\46\0\1\0\1\0\5\0\1\0\2\0\70\0"+
    "\7\0\1\0\17\0\1\0\27\0\11\0\7\0\1\0\7\0\1\0"+
    "\7\0\1\0\7\0\1\0\7\0\1\0\7\0\1\0\7\0\1\0"+
    "\7\0\1\0\40\0\57\0\1\0\u01d5\0\3\0\31\0\11\0\6\0"+
    "\1\0\5\0\2\0\5\0\4\0\126\0\2\0\2\0\2\0\3\0"+
    "\1\0\132\0\1\0\4\0\5\0\51\0\3\0\136\0\21\0\33\0"+
    "\65\0\20\0\u0200\0\u19b6\0\112\0\u51d6\0\52\0\u048d\0\103\0\56\0"+
    "\2\0\u010d\0\3\0\20\0\12\0\2\0\24\0\57\0\1\0\4\0"+
    "\12\0\1\0\37\0\2\0\120\0\2\0\45\0\11\0\2\0\147\0"+
    "\2\0\43\0\2\0\10\0\77\0\13\0\1\0\3\0\1\0\4\0"+
    "\1\0\27\0\5\0\20\0\1\0\7\0\64\0\14\0\2\0\62\0"+
    "\21\0\13\0\12\0\6\0\22\0\6\0\3\0\1\0\1\0\1\0"+
    "\2\0\12\0\34\0\10\0\2\0\27\0\15\0\14\0\35\0\3\0"+
    "\4\0\57\0\16\0\16\0\1\0\12\0\6\0\5\0\1\0\12\0"+
    "\12\0\5\0\1\0\51\0\16\0\11\0\3\0\1\0\10\0\2\0"+
    "\2\0\12\0\6\0\27\0\3\0\1\0\3\0\62\0\1\0\1\0"+
    "\3\0\2\0\2\0\5\0\2\0\1\0\1\0\1\0\30\0\3\0"+
    "\2\0\13\0\5\0\2\0\3\0\2\0\12\0\6\0\2\0\6\0"+
    "\2\0\6\0\11\0\7\0\1\0\7\0\1\0\53\0\1\0\12\0"+
    "\12\0\163\0\10\0\1\0\2\0\2\0\12\0\6\0\u2ba4\0\14\0"+
    "\27\0\4\0\61\0\u2104\0\u016e\0\2\0\152\0\46\0\7\0\14\0"+
    "\5\0\5\0\1\0\1\0\12\0\1\0\15\0\1\0\5\0\1\0"+
    "\1\0\1\0\2\0\1\0\2\0\1\0\154\0\41\0\u016b\0\22\0"+
    "\100\0\2\0\66\0\50\0\15\0\3\0\20\0\20\0\20\0\3\0"+
    "\2\0\30\0\3\0\31\0\1\0\6\0\5\0\1\0\207\0\2\0"+
    "\1\0\4\0\1\0\13\0\12\0\7\0\32\0\4\0\1\0\1\0"+
    "\32\0\13\0\131\0\3\0\6\0\2\0\6\0\2\0\6\0\2\0"+
    "\3\0\3\0\2\0\3\0\2\0\22\0\3\0\4\0\14\0\1\0"+
    "\32\0\1\0\23\0\1\0\2\0\1\0\17\0\2\0\16\0\42\0"+
    "\173\0\105\0\65\0\210\0\1\0\202\0\35\0\3\0\61\0\17\0"+
    "\1\0\37\0\40\0\20\0\33\0\5\0\46\0\5\0\5\0\36\0"+
    "\2\0\44\0\4\0\10\0\1\0\5\0\52\0\236\0\2\0\12\0"+
    "\126\0\50\0\10\0\64\0\234\0\u0137\0\11\0\26\0\12\0\10\0"+
    "\230\0\6\0\2\0\1\0\1\0\54\0\1\0\2\0\3\0\1\0"+
    "\2\0\27\0\12\0\27\0\11\0\37\0\101\0\23\0\1\0\2\0"+
    "\12\0\26\0\12\0\32\0\106\0\70\0\6\0\2\0\100\0\1\0"+
    "\3\0\1\0\2\0\5\0\4\0\4\0\1\0\3\0\1\0\33\0"+
    "\4\0\3\0\4\0\1\0\40\0\35\0\3\0\35\0\43\0\10\0"+
    "\1\0\34\0\2\0\31\0\66\0\12\0\26\0\12\0\23\0\15\0"+
    "\22\0\156\0\111\0\67\0\63\0\15\0\63\0\u030d\0\3\0\65\0"+
    "\17\0\37\0\12\0\17\0\4\0\55\0\13\0\2\0\1\0\22\0"+
    "\31\0\7\0\12\0\6\0\3\0\44\0\16\0\1\0\12\0\20\0"+
    "\43\0\1\0\2\0\1\0\11\0\3\0\60\0\16\0\4\0\5\0"+
    "\3\0\3\0\12\0\1\0\1\0\1\0\43\0\22\0\1\0\31\0"+
    "\14\0\110\0\7\0\1\0\1\0\1\0\4\0\1\0\17\0\1\0"+
    "\12\0\7\0\57\0\14\0\5\0\12\0\6\0\4\0\1\0\10\0"+
    "\2\0\2\0\2\0\26\0\1\0\7\0\1\0\2\0\1\0\5\0"+
    "\2\0\1\0\1\0\7\0\2\0\2\0\2\0\3\0\2\0\1\0"+
    "\6\0\1\0\5\0\5\0\2\0\2\0\7\0\3\0\5\0\u010b\0"+
    "\60\0\24\0\2\0\1\0\1\0\10\0\12\0\246\0\57\0\7\0"+
    "\2\0\11\0\27\0\4\0\2\0\42\0\60\0\21\0\3\0\1\0"+
    "\13\0\12\0\46\0\53\0\15\0\10\0\12\0\66\0\32\0\3\0"+
    "\17\0\4\0\12\0\u0166\0\100\0\12\0\25\0\1\0\u01c0\0\71\0"+
    "\u0507\0\u039a\0\146\0\157\0\21\0\304\0\u0abc\0\u042f\0\u0fd1\0\u0247\0"+
    "\u21b9\0\u0239\0\7\0\37\0\1\0\12\0\146\0\36\0\2\0\5\0"+
    "\13\0\60\0\7\0\11\0\4\0\14\0\12\0\11\0\25\0\5\0"+
    "\23\0\u0370\0\105\0\13\0\1\0\56\0\20\0\4\0\15\0\u4060\0"+
    "\2\0\u0bfe\0\153\0\5\0\15\0\3\0\11\0\7\0\12\0\3\0"+
    "\2\0\1\0\4\0\u14c1\0\5\0\3\0\26\0\2\0\7\0\36\0"+
    "\4\0\224\0\3\0\u01bb\0\125\0\1\0\107\0\1\0\2\0\2\0"+
    "\1\0\2\0\2\0\2\0\4\0\1\0\14\0\1\0\1\0\1\0"+
    "\7\0\1\0\101\0\1\0\4\0\2\0\10\0\1\0\7\0\1\0"+
    "\34\0\1\0\4\0\1\0\5\0\1\0\1\0\3\0\7\0\1\0"+
    "\u0154\0\2\0\31\0\1\0\31\0\1\0\37\0\1\0\31\0\1\0"+
    "\37\0\1\0\31\0\1\0\37\0\1\0\31\0\1\0\37\0\1\0"+
    "\31\0\1\0\10\0\2\0\62\0\u0200\0\67\0\4\0\62\0\10\0"+
    "\1\0\16\0\1\0\26\0\5\0\1\0\17\0\u0d50\0\305\0\13\0"+
    "\7\0\u0529\0\4\0\1\0\33\0\1\0\2\0\1\0\1\0\2\0"+
    "\1\0\1\0\12\0\1\0\4\0\1\0\1\0\1\0\1\0\6\0"+
    "\1\0\4\0\1\0\1\0\1\0\1\0\1\0\1\0\3\0\1\0"+
    "\2\0\1\0\1\0\2\0\1\0\1\0\1\0\1\0\1\0\1\0"+
    "\1\0\1\0\1\0\1\0\2\0\1\0\1\0\2\0\4\0\1\0"+
    "\7\0\1\0\4\0\1\0\4\0\1\0\1\0\1\0\12\0\1\0"+
    "\21\0\5\0\3\0\1\0\5\0\1\0\21\0\u1144\0\ua6d7\0\51\0"+
    "\u1035\0\13\0\336\0\2\0\u1682\0\u295e\0\u021e\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\u05ee\0"+
    "\1\0\36\0\140\0\200\0\360\0\uffff\0\uffff\0\ufe12\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\2\1\1\2\12\0\1\3\1\0\1\4\1\5"+
    "\1\6\1\7\1\10\1\0\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\1\12\0\1\20\1\21\1\22"+
    "\1\23\1\24\3\0\1\25\6\0\1\26\1\27\2\0"+
    "\1\30\1\0\1\31\2\0\1\32\1\0\1\33\1\34"+
    "\1\0\1\35";

  private static int [] zzUnpackAction() {
    int [] result = new int[70];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\46\0\114\0\162\0\230\0\276\0\344\0\u010a"+
    "\0\u0130\0\u0156\0\u017c\0\u01a2\0\u01c8\0\u01ee\0\u0214\0\u023a"+
    "\0\u0260\0\114\0\114\0\114\0\114\0\u0286\0\114\0\114"+
    "\0\114\0\114\0\114\0\114\0\114\0\u02ac\0\u02d2\0\u02f8"+
    "\0\u031e\0\u0344\0\u036a\0\u0390\0\u03b6\0\u03dc\0\u0402\0\u0428"+
    "\0\114\0\114\0\114\0\114\0\114\0\u044e\0\u0474\0\u049a"+
    "\0\114\0\u04c0\0\u04e6\0\u050c\0\u0532\0\u0558\0\u057e\0\114"+
    "\0\114\0\u05a4\0\u05ca\0\114\0\u05f0\0\114\0\u0616\0\u063c"+
    "\0\114\0\u0662\0\114\0\114\0\u0688\0\114";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[70];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\0\1\2\2\3\1\4\1\5\2\0\1\6\1\7"+
    "\1\0\1\10\1\0\1\11\1\12\1\13\1\0\1\14"+
    "\1\0\1\15\1\16\2\0\1\17\1\20\1\21\1\22"+
    "\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\2\0\1\3\115\0\1\36\47\0"+
    "\1\37\45\0\1\40\47\0\1\41\51\0\1\42\36\0"+
    "\1\43\54\0\1\44\51\0\1\45\41\0\1\46\45\0"+
    "\1\47\56\0\1\50\47\0\1\51\46\0\1\52\44\0"+
    "\1\53\54\0\1\54\7\0\1\36\1\2\1\3\43\36"+
    "\7\0\1\55\47\0\1\56\46\0\1\57\50\0\1\60"+
    "\41\0\1\61\46\0\1\62\54\0\1\63\31\0\1\64"+
    "\54\0\1\65\51\0\1\66\37\0\1\67\41\0\1\70"+
    "\55\0\1\71\52\0\1\72\44\0\1\73\51\0\1\74"+
    "\40\0\1\75\34\0\1\76\45\0\1\77\56\0\1\100"+
    "\32\0\1\101\45\0\1\102\44\0\1\103\46\0\1\104"+
    "\57\0\1\105\32\0\1\106\40\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1710];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\1\1\11\1\1\12\0\1\1\1\0\1\1"+
    "\4\11\1\0\7\11\1\1\12\0\5\11\3\0\1\11"+
    "\6\0\2\11\2\0\1\11\1\0\1\11\2\0\1\11"+
    "\1\0\2\11\1\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[70];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    //empty


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 3234) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Token yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { 
            }
          case 30: break;
          case 2: 
            { return new OpDiv(yyline, yycolumn);
            }
          case 31: break;
          case 3: 
            { return new Assignment(yyline, yycolumn);
            }
          case 32: break;
          case 4: 
            { return new OpGT(yyline, yycolumn);
            }
          case 33: break;
          case 5: 
            { return new OpMinus(yyline, yycolumn);
            }
          case 34: break;
          case 6: 
            { return new OpMod(yyline, yycolumn);
            }
          case 35: break;
          case 7: 
            { return new OpMult(yyline, yycolumn);
            }
          case 36: break;
          case 8: 
            { return new OpNot(yyline, yycolumn);
            }
          case 37: break;
          case 9: 
            { return new OpPlus(yyline, yycolumn);
            }
          case 38: break;
          case 10: 
            { return new BracketL(yyline, yycolumn);
            }
          case 39: break;
          case 11: 
            { return new BracketR(yyline, yycolumn);
            }
          case 40: break;
          case 12: 
            { return new CurlyBraceL(yyline, yycolumn);
            }
          case 41: break;
          case 13: 
            { return new CurlyBraceR(yyline, yycolumn);
            }
          case 42: break;
          case 14: 
            { return new Period(yyline, yycolumn);
            }
          case 43: break;
          case 15: 
            { return new Semicolon(yyline, yycolumn);
            }
          case 44: break;
          case 16: 
            { return new OpEq(yyline, yycolumn);
            }
          case 45: break;
          case 17: 
            { return new OpAnd(yyline, yycolumn);
            }
          case 46: break;
          case 18: 
            { return new OpGTE(yyline, yycolumn);
            }
          case 47: break;
          case 19: 
            { return new OpOr(yyline, yycolumn);
            }
          case 48: break;
          case 20: 
            { return new KeywordNew(yyline, yycolumn);
            }
          case 49: break;
          case 21: 
            { return new TypeInt(yyline, yycolumn);
            }
          case 50: break;
          case 22: 
            { return new LitBool(yyline, yycolumn, true);
            }
          case 51: break;
          case 23: 
            { return new KeywordVoid(yyline, yycolumn);
            }
          case 52: break;
          case 24: 
            { return new TypeLong(yyline, yycolumn);
            }
          case 53: break;
          case 25: 
            { return new TypeChar(yyline, yycolumn);
            }
          case 54: break;
          case 26: 
            { return new LitBool(yyline, yycolumn, false);
            }
          case 55: break;
          case 27: 
            { return new KeywordReturn(yyline, yycolumn);
            }
          case 56: break;
          case 28: 
            { return new TypeDouble(yyline, yycolumn);
            }
          case 57: break;
          case 29: 
            { return new TypeBoolean(yyline, yycolumn);
            }
          case 58: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
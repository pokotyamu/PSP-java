/* Generated By:JavaCC: Do not edit this line. ProcessParserConstants.java */
package parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface ProcessParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int FUNCTION = 6;
  /** RegularExpression Id. */
  int GRAPH = 7;
  /** RegularExpression Id. */
  int LC = 8;
  /** RegularExpression Id. */
  int RC = 9;
  /** RegularExpression Id. */
  int LK = 10;
  /** RegularExpression Id. */
  int RK = 11;
  /** RegularExpression Id. */
  int LB = 12;
  /** RegularExpression Id. */
  int RB = 13;
  /** RegularExpression Id. */
  int EQ = 14;
  /** RegularExpression Id. */
  int COM = 15;
  /** RegularExpression Id. */
  int SM = 16;
  /** RegularExpression Id. */
  int AND = 17;
  /** RegularExpression Id. */
  int condition_operator = 18;
  /** RegularExpression Id. */
  int decimal_numeral = 19;
  /** RegularExpression Id. */
  int digits = 20;
  /** RegularExpression Id. */
  int string_literal = 21;
  /** RegularExpression Id. */
  int boolean_literal = 22;
  /** RegularExpression Id. */
  int IDENTIFIERS = 23;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\r\"",
    "\"\\t\"",
    "\"\\f\"",
    "\"\\n\"",
    "\"function\"",
    "\"graph\"",
    "\"(\"",
    "\")\"",
    "\"[\"",
    "\"]\"",
    "\"{\"",
    "\"}\"",
    "\"=\"",
    "\",\"",
    "\";\"",
    "\"&\"",
    "<condition_operator>",
    "<decimal_numeral>",
    "<digits>",
    "<string_literal>",
    "<boolean_literal>",
    "<IDENTIFIERS>",
  };

}

grammar Expr;
prog:   expr ;
expr:   expr '*' expr   # typeMul
    |   expr '/' expr   # typeDiv
    |   expr '+' expr   # typeSum
    |   expr '-' expr   # typeSub
    |   INT             # typeInt
    |   DOUBLE          # typeDouble
    |   '(' expr ')'    # typeRec
    ;

DOUBLE  : [0-9]+[\\.]?[0-9]+ ;
INT     : [0-9]+ ;
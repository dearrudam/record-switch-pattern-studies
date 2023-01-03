grammar Expr;
prog:   expr ;
expr:   expr '*' expr   # typeMul
    |   expr '/' expr   # typeDiv
    |   expr '+' expr   # typeSum
    |   expr '-' expr   # typeSub
    |   INT                   # typeInt
    |   '(' expr ')'          # typeRec
    ;

INT     : [0-9]+ ;
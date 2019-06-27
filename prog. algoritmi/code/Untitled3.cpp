#include <cstdio>
#include <string>

#include "lib\exprtk.hpp"

int main()
{
   typedef exprtk::symbol_table<double> symbol_table_t;
   typedef exprtk::expression<double>     expression_t;
   typedef exprtk::parser<double>             parser_t;

   std::string expression_str = "abs((2 * x)  - 1)";

   double x = 1.1;

   // Register x with the symbol_table
   symbol_table_t symbol_table;
   symbol_table.add_variable("x",x);

   // Instantiate expression and register symbol_table
   expression_t expression;
   expression.register_symbol_table(symbol_table);

   // Instantiate parser and compile the expression
   parser_t parser;
   parser.compile(expression_str,expression);

   double result = 0.0;

   // Evaluate and print result for when x = 1.1
   result = expression.value();
   printf("Result1: %10.5f\n",result);

   // Update/modify the value of x
   x = 2.2;

   // Evaluate and print result for when x = 2.2
   result = expression.value();
   printf("Result2: %10.5f\n",result);

   return 0;
}

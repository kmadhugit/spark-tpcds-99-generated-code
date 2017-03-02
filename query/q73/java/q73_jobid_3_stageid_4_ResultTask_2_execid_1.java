/* 001 */ public SpecificOrdering generate(Object[] references) {
/* 002 */   return new SpecificOrdering(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificOrdering extends org.apache.spark.sql.catalyst.expressions.codegen.BaseOrdering {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */
/* 009 */
/* 010 */   public SpecificOrdering(Object[] references) {
/* 011 */     this.references = references;
/* 012 */
/* 013 */   }
/* 014 */
/* 015 */
/* 016 */
/* 017 */   public int compare(InternalRow a, InternalRow b) {
/* 018 */     InternalRow i = null;  // Holds current row being evaluated.
/* 019 */
/* 020 */     i = a;
/* 021 */     boolean isNullA;
/* 022 */     long primitiveA;
/* 023 */     {
/* 024 */
/* 025 */       long value = i.getLong(5);
/* 026 */       isNullA = false;
/* 027 */       primitiveA = value;
/* 028 */     }
/* 029 */     i = b;
/* 030 */     boolean isNullB;
/* 031 */     long primitiveB;
/* 032 */     {
/* 033 */
/* 034 */       long value = i.getLong(5);
/* 035 */       isNullB = false;
/* 036 */       primitiveB = value;
/* 037 */     }
/* 038 */     if (isNullA && isNullB) {
/* 039 */       // Nothing
/* 040 */     } else if (isNullA) {
/* 041 */       return 1;
/* 042 */     } else if (isNullB) {
/* 043 */       return -1;
/* 044 */     } else {
/* 045 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 046 */       if (comp != 0) {
/* 047 */         return -comp;
/* 048 */       }
/* 049 */     }
/* 050 */
/* 051 */     return 0;
/* 052 */   }
/* 053 */ }

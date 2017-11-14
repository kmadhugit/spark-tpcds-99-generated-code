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
/* 018 */
/* 019 */     InternalRow i = null;
/* 020 */
/* 021 */     i = a;
/* 022 */     boolean isNullA;
/* 023 */     long primitiveA;
/* 024 */     {
/* 025 */
/* 026 */       long value = i.getLong(0);
/* 027 */       isNullA = false;
/* 028 */       primitiveA = value;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB;
/* 032 */     long primitiveB;
/* 033 */     {
/* 034 */
/* 035 */       long value = i.getLong(0);
/* 036 */       isNullB = false;
/* 037 */       primitiveB = value;
/* 038 */     }
/* 039 */     if (isNullA && isNullB) {
/* 040 */       // Nothing
/* 041 */     } else if (isNullA) {
/* 042 */       return -1;
/* 043 */     } else if (isNullB) {
/* 044 */       return 1;
/* 045 */     } else {
/* 046 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 047 */       if (comp != 0) {
/* 048 */         return comp;
/* 049 */       }
/* 050 */     }
/* 051 */
/* 052 */
/* 053 */     return 0;
/* 054 */   }
/* 055 */ }

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
/* 023 */     int primitiveA;
/* 024 */     {
/* 025 */
/* 026 */       boolean isNull = i.isNullAt(16);
/* 027 */       int value = isNull ? -1 : (i.getInt(16));
/* 028 */       isNullA = isNull;
/* 029 */       primitiveA = value;
/* 030 */     }
/* 031 */     i = b;
/* 032 */     boolean isNullB;
/* 033 */     int primitiveB;
/* 034 */     {
/* 035 */
/* 036 */       boolean isNull = i.isNullAt(16);
/* 037 */       int value = isNull ? -1 : (i.getInt(16));
/* 038 */       isNullB = isNull;
/* 039 */       primitiveB = value;
/* 040 */     }
/* 041 */     if (isNullA && isNullB) {
/* 042 */       // Nothing
/* 043 */     } else if (isNullA) {
/* 044 */       return -1;
/* 045 */     } else if (isNullB) {
/* 046 */       return 1;
/* 047 */     } else {
/* 048 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 049 */       if (comp != 0) {
/* 050 */         return comp;
/* 051 */       }
/* 052 */     }
/* 053 */
/* 054 */
/* 055 */     return 0;
/* 056 */   }
/* 057 */ }

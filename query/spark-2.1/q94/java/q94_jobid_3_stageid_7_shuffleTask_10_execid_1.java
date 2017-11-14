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
/* 025 */       boolean isNull1 = i.isNullAt(16);
/* 026 */       int value1 = isNull1 ? -1 : (i.getInt(16));
/* 027 */       boolean isNull = isNull1;
/* 028 */       long value = -1L;
/* 029 */       if (!isNull1) {
/* 030 */         value = (long) value1;
/* 031 */       }
/* 032 */       isNullA = isNull;
/* 033 */       primitiveA = value;
/* 034 */     }
/* 035 */     i = b;
/* 036 */     boolean isNullB;
/* 037 */     long primitiveB;
/* 038 */     {
/* 039 */
/* 040 */       boolean isNull1 = i.isNullAt(16);
/* 041 */       int value1 = isNull1 ? -1 : (i.getInt(16));
/* 042 */       boolean isNull = isNull1;
/* 043 */       long value = -1L;
/* 044 */       if (!isNull1) {
/* 045 */         value = (long) value1;
/* 046 */       }
/* 047 */       isNullB = isNull;
/* 048 */       primitiveB = value;
/* 049 */     }
/* 050 */     if (isNullA && isNullB) {
/* 051 */       // Nothing
/* 052 */     } else if (isNullA) {
/* 053 */       return -1;
/* 054 */     } else if (isNullB) {
/* 055 */       return 1;
/* 056 */     } else {
/* 057 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 058 */       if (comp != 0) {
/* 059 */         return comp;
/* 060 */       }
/* 061 */     }
/* 062 */
/* 063 */     return 0;
/* 064 */   }
/* 065 */ }

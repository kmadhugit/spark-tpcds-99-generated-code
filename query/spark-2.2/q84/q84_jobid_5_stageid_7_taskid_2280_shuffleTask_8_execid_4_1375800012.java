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
/* 026 */       boolean isNull1 = i.isNullAt(3);
/* 027 */       int value1 = isNull1 ? -1 : (i.getInt(3));
/* 028 */       boolean isNull = isNull1;
/* 029 */       long value = -1L;
/* 030 */       if (!isNull1) {
/* 031 */         value = (long) value1;
/* 032 */       }
/* 033 */       isNullA = isNull;
/* 034 */       primitiveA = value;
/* 035 */     }
/* 036 */     i = b;
/* 037 */     boolean isNullB;
/* 038 */     long primitiveB;
/* 039 */     {
/* 040 */
/* 041 */       boolean isNull1 = i.isNullAt(3);
/* 042 */       int value1 = isNull1 ? -1 : (i.getInt(3));
/* 043 */       boolean isNull = isNull1;
/* 044 */       long value = -1L;
/* 045 */       if (!isNull1) {
/* 046 */         value = (long) value1;
/* 047 */       }
/* 048 */       isNullB = isNull;
/* 049 */       primitiveB = value;
/* 050 */     }
/* 051 */     if (isNullA && isNullB) {
/* 052 */       // Nothing
/* 053 */     } else if (isNullA) {
/* 054 */       return -1;
/* 055 */     } else if (isNullB) {
/* 056 */       return 1;
/* 057 */     } else {
/* 058 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 059 */       if (comp != 0) {
/* 060 */         return comp;
/* 061 */       }
/* 062 */     }
/* 063 */
/* 064 */
/* 065 */     return 0;
/* 066 */   }
/* 067 */ }

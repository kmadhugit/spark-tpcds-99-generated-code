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
/* 023 */     double primitiveA;
/* 024 */     {
/* 025 */
/* 026 */       boolean isNull = i.isNullAt(4);
/* 027 */       double value = isNull ? -1.0 : (i.getDouble(4));
/* 028 */       isNullA = isNull;
/* 029 */       primitiveA = value;
/* 030 */     }
/* 031 */     i = b;
/* 032 */     boolean isNullB;
/* 033 */     double primitiveB;
/* 034 */     {
/* 035 */
/* 036 */       boolean isNull = i.isNullAt(4);
/* 037 */       double value = isNull ? -1.0 : (i.getDouble(4));
/* 038 */       isNullB = isNull;
/* 039 */       primitiveB = value;
/* 040 */     }
/* 041 */     if (isNullA && isNullB) {
/* 042 */       // Nothing
/* 043 */     } else if (isNullA) {
/* 044 */       return 1;
/* 045 */     } else if (isNullB) {
/* 046 */       return -1;
/* 047 */     } else {
/* 048 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA, primitiveB);
/* 049 */       if (comp != 0) {
/* 050 */         return -comp;
/* 051 */       }
/* 052 */     }
/* 053 */
/* 054 */     i = a;
/* 055 */     boolean isNullA1;
/* 056 */     int primitiveA1;
/* 057 */     {
/* 058 */
/* 059 */       boolean isNull1 = i.isNullAt(0);
/* 060 */       int value1 = isNull1 ? -1 : (i.getInt(0));
/* 061 */       isNullA1 = isNull1;
/* 062 */       primitiveA1 = value1;
/* 063 */     }
/* 064 */     i = b;
/* 065 */     boolean isNullB1;
/* 066 */     int primitiveB1;
/* 067 */     {
/* 068 */
/* 069 */       boolean isNull1 = i.isNullAt(0);
/* 070 */       int value1 = isNull1 ? -1 : (i.getInt(0));
/* 071 */       isNullB1 = isNull1;
/* 072 */       primitiveB1 = value1;
/* 073 */     }
/* 074 */     if (isNullA1 && isNullB1) {
/* 075 */       // Nothing
/* 076 */     } else if (isNullA1) {
/* 077 */       return -1;
/* 078 */     } else if (isNullB1) {
/* 079 */       return 1;
/* 080 */     } else {
/* 081 */       int comp = (primitiveA1 > primitiveB1 ? 1 : primitiveA1 < primitiveB1 ? -1 : 0);
/* 082 */       if (comp != 0) {
/* 083 */         return comp;
/* 084 */       }
/* 085 */     }
/* 086 */
/* 087 */
/* 088 */     return 0;
/* 089 */   }
/* 090 */ }

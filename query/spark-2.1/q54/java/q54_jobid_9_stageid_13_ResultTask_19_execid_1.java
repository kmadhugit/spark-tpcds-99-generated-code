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
/* 022 */     int primitiveA;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull = i.isNullAt(0);
/* 026 */       int value = isNull ? -1 : (i.getInt(0));
/* 027 */       isNullA = isNull;
/* 028 */       primitiveA = value;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB;
/* 032 */     int primitiveB;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull = i.isNullAt(0);
/* 036 */       int value = isNull ? -1 : (i.getInt(0));
/* 037 */       isNullB = isNull;
/* 038 */       primitiveB = value;
/* 039 */     }
/* 040 */     if (isNullA && isNullB) {
/* 041 */       // Nothing
/* 042 */     } else if (isNullA) {
/* 043 */       return -1;
/* 044 */     } else if (isNullB) {
/* 045 */       return 1;
/* 046 */     } else {
/* 047 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */
/* 054 */     i = a;
/* 055 */     boolean isNullA1;
/* 056 */     long primitiveA1;
/* 057 */     {
/* 058 */
/* 059 */       long value1 = i.getLong(1);
/* 060 */       isNullA1 = false;
/* 061 */       primitiveA1 = value1;
/* 062 */     }
/* 063 */     i = b;
/* 064 */     boolean isNullB1;
/* 065 */     long primitiveB1;
/* 066 */     {
/* 067 */
/* 068 */       long value1 = i.getLong(1);
/* 069 */       isNullB1 = false;
/* 070 */       primitiveB1 = value1;
/* 071 */     }
/* 072 */     if (isNullA1 && isNullB1) {
/* 073 */       // Nothing
/* 074 */     } else if (isNullA1) {
/* 075 */       return -1;
/* 076 */     } else if (isNullB1) {
/* 077 */       return 1;
/* 078 */     } else {
/* 079 */       int comp = (primitiveA1 > primitiveB1 ? 1 : primitiveA1 < primitiveB1 ? -1 : 0);
/* 080 */       if (comp != 0) {
/* 081 */         return comp;
/* 082 */       }
/* 083 */     }
/* 084 */
/* 085 */     return 0;
/* 086 */   }
/* 087 */ }

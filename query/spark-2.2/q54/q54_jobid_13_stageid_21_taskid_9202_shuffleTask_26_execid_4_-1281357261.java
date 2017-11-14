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
/* 026 */       boolean isNull = i.isNullAt(0);
/* 027 */       int value = isNull ? -1 : (i.getInt(0));
/* 028 */       isNullA = isNull;
/* 029 */       primitiveA = value;
/* 030 */     }
/* 031 */     i = b;
/* 032 */     boolean isNullB;
/* 033 */     int primitiveB;
/* 034 */     {
/* 035 */
/* 036 */       boolean isNull = i.isNullAt(0);
/* 037 */       int value = isNull ? -1 : (i.getInt(0));
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
/* 085 */
/* 086 */     return 0;
/* 087 */   }
/* 088 */ }

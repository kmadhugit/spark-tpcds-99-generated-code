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
/* 026 */       boolean isNull = true;
/* 027 */       int value = -1;
/* 028 */
/* 029 */       boolean isNull1 = i.isNullAt(0);
/* 030 */       int value1 = isNull1 ? -1 : (i.getInt(0));
/* 031 */       if (!isNull1) {
/* 032 */
/* 033 */
/* 034 */         isNull = false; // resultCode could change nullability.
/* 035 */         value = value1 - 53;
/* 036 */
/* 037 */       }
/* 038 */       isNullA = isNull;
/* 039 */       primitiveA = value;
/* 040 */     }
/* 041 */     i = b;
/* 042 */     boolean isNullB;
/* 043 */     int primitiveB;
/* 044 */     {
/* 045 */
/* 046 */       boolean isNull = true;
/* 047 */       int value = -1;
/* 048 */
/* 049 */       boolean isNull1 = i.isNullAt(0);
/* 050 */       int value1 = isNull1 ? -1 : (i.getInt(0));
/* 051 */       if (!isNull1) {
/* 052 */
/* 053 */
/* 054 */         isNull = false; // resultCode could change nullability.
/* 055 */         value = value1 - 53;
/* 056 */
/* 057 */       }
/* 058 */       isNullB = isNull;
/* 059 */       primitiveB = value;
/* 060 */     }
/* 061 */     if (isNullA && isNullB) {
/* 062 */       // Nothing
/* 063 */     } else if (isNullA) {
/* 064 */       return -1;
/* 065 */     } else if (isNullB) {
/* 066 */       return 1;
/* 067 */     } else {
/* 068 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 069 */       if (comp != 0) {
/* 070 */         return comp;
/* 071 */       }
/* 072 */     }
/* 073 */
/* 074 */
/* 075 */     return 0;
/* 076 */   }
/* 077 */ }

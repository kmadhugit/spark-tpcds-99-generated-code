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
/* 025 */       boolean isNull = true;
/* 026 */       int value = -1;
/* 027 */
/* 028 */       boolean isNull1 = i.isNullAt(0);
/* 029 */       int value1 = isNull1 ? -1 : (i.getInt(0));
/* 030 */       if (!isNull1) {
/* 031 */
/* 032 */
/* 033 */         isNull = false; // resultCode could change nullability.
/* 034 */         value = value1 - 53;
/* 035 */
/* 036 */       }
/* 037 */       isNullA = isNull;
/* 038 */       primitiveA = value;
/* 039 */     }
/* 040 */     i = b;
/* 041 */     boolean isNullB;
/* 042 */     int primitiveB;
/* 043 */     {
/* 044 */
/* 045 */       boolean isNull = true;
/* 046 */       int value = -1;
/* 047 */
/* 048 */       boolean isNull1 = i.isNullAt(0);
/* 049 */       int value1 = isNull1 ? -1 : (i.getInt(0));
/* 050 */       if (!isNull1) {
/* 051 */
/* 052 */
/* 053 */         isNull = false; // resultCode could change nullability.
/* 054 */         value = value1 - 53;
/* 055 */
/* 056 */       }
/* 057 */       isNullB = isNull;
/* 058 */       primitiveB = value;
/* 059 */     }
/* 060 */     if (isNullA && isNullB) {
/* 061 */       // Nothing
/* 062 */     } else if (isNullA) {
/* 063 */       return -1;
/* 064 */     } else if (isNullB) {
/* 065 */       return 1;
/* 066 */     } else {
/* 067 */       int comp = (primitiveA > primitiveB ? 1 : primitiveA < primitiveB ? -1 : 0);
/* 068 */       if (comp != 0) {
/* 069 */         return comp;
/* 070 */       }
/* 071 */     }
/* 072 */
/* 073 */     return 0;
/* 074 */   }
/* 075 */ }

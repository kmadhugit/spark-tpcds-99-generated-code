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
/* 025 */       boolean isNull1 = i.isNullAt(0);
/* 026 */       int value1 = isNull1 ? -1 : (i.getInt(0));
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
/* 040 */       boolean isNull1 = i.isNullAt(0);
/* 041 */       int value1 = isNull1 ? -1 : (i.getInt(0));
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
/* 063 */
/* 064 */     i = a;
/* 065 */     boolean isNullA1;
/* 066 */     long primitiveA1;
/* 067 */     {
/* 068 */
/* 069 */       boolean isNull3 = i.isNullAt(3);
/* 070 */       int value3 = isNull3 ? -1 : (i.getInt(3));
/* 071 */       boolean isNull2 = isNull3;
/* 072 */       long value2 = -1L;
/* 073 */       if (!isNull3) {
/* 074 */         value2 = (long) value3;
/* 075 */       }
/* 076 */       isNullA1 = isNull2;
/* 077 */       primitiveA1 = value2;
/* 078 */     }
/* 079 */     i = b;
/* 080 */     boolean isNullB1;
/* 081 */     long primitiveB1;
/* 082 */     {
/* 083 */
/* 084 */       boolean isNull3 = i.isNullAt(3);
/* 085 */       int value3 = isNull3 ? -1 : (i.getInt(3));
/* 086 */       boolean isNull2 = isNull3;
/* 087 */       long value2 = -1L;
/* 088 */       if (!isNull3) {
/* 089 */         value2 = (long) value3;
/* 090 */       }
/* 091 */       isNullB1 = isNull2;
/* 092 */       primitiveB1 = value2;
/* 093 */     }
/* 094 */     if (isNullA1 && isNullB1) {
/* 095 */       // Nothing
/* 096 */     } else if (isNullA1) {
/* 097 */       return -1;
/* 098 */     } else if (isNullB1) {
/* 099 */       return 1;
/* 100 */     } else {
/* 101 */       int comp = (primitiveA1 > primitiveB1 ? 1 : primitiveA1 < primitiveB1 ? -1 : 0);
/* 102 */       if (comp != 0) {
/* 103 */         return comp;
/* 104 */       }
/* 105 */     }
/* 106 */
/* 107 */     return 0;
/* 108 */   }
/* 109 */ }

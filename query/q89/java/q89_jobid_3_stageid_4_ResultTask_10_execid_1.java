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
/* 022 */     double primitiveA;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull = true;
/* 026 */       double value = -1.0;
/* 027 */
/* 028 */       boolean isNull1 = i.isNullAt(6);
/* 029 */       double value1 = isNull1 ? -1.0 : (i.getDouble(6));
/* 030 */       if (!isNull1) {
/* 031 */
/* 032 */         boolean isNull2 = i.isNullAt(7);
/* 033 */         double value2 = isNull2 ? -1.0 : (i.getDouble(7));
/* 034 */         if (!isNull2) {
/* 035 */
/* 036 */           isNull = false; // resultCode could change nullability.
/* 037 */           value = value1 - value2;
/* 038 */
/* 039 */         }
/* 040 */
/* 041 */       }
/* 042 */       isNullA = isNull;
/* 043 */       primitiveA = value;
/* 044 */     }
/* 045 */     i = b;
/* 046 */     boolean isNullB;
/* 047 */     double primitiveB;
/* 048 */     {
/* 049 */
/* 050 */       boolean isNull = true;
/* 051 */       double value = -1.0;
/* 052 */
/* 053 */       boolean isNull1 = i.isNullAt(6);
/* 054 */       double value1 = isNull1 ? -1.0 : (i.getDouble(6));
/* 055 */       if (!isNull1) {
/* 056 */
/* 057 */         boolean isNull2 = i.isNullAt(7);
/* 058 */         double value2 = isNull2 ? -1.0 : (i.getDouble(7));
/* 059 */         if (!isNull2) {
/* 060 */
/* 061 */           isNull = false; // resultCode could change nullability.
/* 062 */           value = value1 - value2;
/* 063 */
/* 064 */         }
/* 065 */
/* 066 */       }
/* 067 */       isNullB = isNull;
/* 068 */       primitiveB = value;
/* 069 */     }
/* 070 */     if (isNullA && isNullB) {
/* 071 */       // Nothing
/* 072 */     } else if (isNullA) {
/* 073 */       return -1;
/* 074 */     } else if (isNullB) {
/* 075 */       return 1;
/* 076 */     } else {
/* 077 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA, primitiveB);
/* 078 */       if (comp != 0) {
/* 079 */         return comp;
/* 080 */       }
/* 081 */     }
/* 082 */
/* 083 */
/* 084 */     i = a;
/* 085 */     boolean isNullA1;
/* 086 */     UTF8String primitiveA1;
/* 087 */     {
/* 088 */
/* 089 */       boolean isNull3 = i.isNullAt(3);
/* 090 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 091 */       isNullA1 = isNull3;
/* 092 */       primitiveA1 = value3;
/* 093 */     }
/* 094 */     i = b;
/* 095 */     boolean isNullB1;
/* 096 */     UTF8String primitiveB1;
/* 097 */     {
/* 098 */
/* 099 */       boolean isNull3 = i.isNullAt(3);
/* 100 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 101 */       isNullB1 = isNull3;
/* 102 */       primitiveB1 = value3;
/* 103 */     }
/* 104 */     if (isNullA1 && isNullB1) {
/* 105 */       // Nothing
/* 106 */     } else if (isNullA1) {
/* 107 */       return -1;
/* 108 */     } else if (isNullB1) {
/* 109 */       return 1;
/* 110 */     } else {
/* 111 */       int comp = primitiveA1.compare(primitiveB1);
/* 112 */       if (comp != 0) {
/* 113 */         return comp;
/* 114 */       }
/* 115 */     }
/* 116 */
/* 117 */     return 0;
/* 118 */   }
/* 119 */ }

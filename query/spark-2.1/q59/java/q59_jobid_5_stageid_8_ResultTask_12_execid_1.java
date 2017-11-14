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
/* 022 */     UTF8String primitiveA;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull = i.isNullAt(1);
/* 026 */       UTF8String value = isNull ? null : (i.getUTF8String(1));
/* 027 */       isNullA = isNull;
/* 028 */       primitiveA = value;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB;
/* 032 */     UTF8String primitiveB;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull = i.isNullAt(1);
/* 036 */       UTF8String value = isNull ? null : (i.getUTF8String(1));
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
/* 047 */       int comp = primitiveA.compare(primitiveB);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */
/* 054 */     i = a;
/* 055 */     boolean isNullA1;
/* 056 */     int primitiveA1;
/* 057 */     {
/* 058 */
/* 059 */       boolean isNull1 = true;
/* 060 */       int value1 = -1;
/* 061 */
/* 062 */       boolean isNull2 = i.isNullAt(0);
/* 063 */       int value2 = isNull2 ? -1 : (i.getInt(0));
/* 064 */       if (!isNull2) {
/* 065 */
/* 066 */
/* 067 */         isNull1 = false; // resultCode could change nullability.
/* 068 */         value1 = value2 - 52;
/* 069 */
/* 070 */       }
/* 071 */       isNullA1 = isNull1;
/* 072 */       primitiveA1 = value1;
/* 073 */     }
/* 074 */     i = b;
/* 075 */     boolean isNullB1;
/* 076 */     int primitiveB1;
/* 077 */     {
/* 078 */
/* 079 */       boolean isNull1 = true;
/* 080 */       int value1 = -1;
/* 081 */
/* 082 */       boolean isNull2 = i.isNullAt(0);
/* 083 */       int value2 = isNull2 ? -1 : (i.getInt(0));
/* 084 */       if (!isNull2) {
/* 085 */
/* 086 */
/* 087 */         isNull1 = false; // resultCode could change nullability.
/* 088 */         value1 = value2 - 52;
/* 089 */
/* 090 */       }
/* 091 */       isNullB1 = isNull1;
/* 092 */       primitiveB1 = value1;
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

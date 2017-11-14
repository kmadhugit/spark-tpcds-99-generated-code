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
/* 023 */     UTF8String primitiveA;
/* 024 */     {
/* 025 */
/* 026 */       boolean isNull = i.isNullAt(1);
/* 027 */       UTF8String value = isNull ? null : (i.getUTF8String(1));
/* 028 */       isNullA = isNull;
/* 029 */       primitiveA = value;
/* 030 */     }
/* 031 */     i = b;
/* 032 */     boolean isNullB;
/* 033 */     UTF8String primitiveB;
/* 034 */     {
/* 035 */
/* 036 */       boolean isNull = i.isNullAt(1);
/* 037 */       UTF8String value = isNull ? null : (i.getUTF8String(1));
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
/* 048 */       int comp = primitiveA.compare(primitiveB);
/* 049 */       if (comp != 0) {
/* 050 */         return comp;
/* 051 */       }
/* 052 */     }
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
/* 107 */
/* 108 */     return 0;
/* 109 */   }
/* 110 */ }

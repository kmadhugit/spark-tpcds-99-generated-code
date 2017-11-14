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
/* 016 */   private int compare_1(InternalRow a, InternalRow b) {
/* 017 */
/* 018 */     InternalRow i = null;  // Holds current row being evaluated.
/* 019 */
/* 020 */     i = a;
/* 021 */     boolean isNullA1;
/* 022 */     UTF8String primitiveA1;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull3 = i.isNullAt(2);
/* 026 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(2));
/* 027 */       isNullA1 = isNull3;
/* 028 */       primitiveA1 = value3;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB1;
/* 032 */     UTF8String primitiveB1;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull3 = i.isNullAt(2);
/* 036 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(2));
/* 037 */       isNullB1 = isNull3;
/* 038 */       primitiveB1 = value3;
/* 039 */     }
/* 040 */     if (isNullA1 && isNullB1) {
/* 041 */       // Nothing
/* 042 */     } else if (isNullA1) {
/* 043 */       return -1;
/* 044 */     } else if (isNullB1) {
/* 045 */       return 1;
/* 046 */     } else {
/* 047 */       int comp = primitiveA1.compare(primitiveB1);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */     return 0;
/* 054 */
/* 055 */   }
/* 056 */
/* 057 */
/* 058 */   private int compare_0(InternalRow a, InternalRow b) {
/* 059 */
/* 060 */     InternalRow i = null;  // Holds current row being evaluated.
/* 061 */
/* 062 */     i = a;
/* 063 */     boolean isNullA;
/* 064 */     double primitiveA;
/* 065 */     {
/* 066 */
/* 067 */       boolean isNull = true;
/* 068 */       double value = -1.0;
/* 069 */
/* 070 */       boolean isNull1 = i.isNullAt(6);
/* 071 */       double value1 = isNull1 ? -1.0 : (i.getDouble(6));
/* 072 */       if (!isNull1) {
/* 073 */
/* 074 */         boolean isNull2 = i.isNullAt(5);
/* 075 */         double value2 = isNull2 ? -1.0 : (i.getDouble(5));
/* 076 */         if (!isNull2) {
/* 077 */
/* 078 */           isNull = false; // resultCode could change nullability.
/* 079 */           value = value1 - value2;
/* 080 */
/* 081 */         }
/* 082 */
/* 083 */       }
/* 084 */       isNullA = isNull;
/* 085 */       primitiveA = value;
/* 086 */     }
/* 087 */     i = b;
/* 088 */     boolean isNullB;
/* 089 */     double primitiveB;
/* 090 */     {
/* 091 */
/* 092 */       boolean isNull = true;
/* 093 */       double value = -1.0;
/* 094 */
/* 095 */       boolean isNull1 = i.isNullAt(6);
/* 096 */       double value1 = isNull1 ? -1.0 : (i.getDouble(6));
/* 097 */       if (!isNull1) {
/* 098 */
/* 099 */         boolean isNull2 = i.isNullAt(5);
/* 100 */         double value2 = isNull2 ? -1.0 : (i.getDouble(5));
/* 101 */         if (!isNull2) {
/* 102 */
/* 103 */           isNull = false; // resultCode could change nullability.
/* 104 */           value = value1 - value2;
/* 105 */
/* 106 */         }
/* 107 */
/* 108 */       }
/* 109 */       isNullB = isNull;
/* 110 */       primitiveB = value;
/* 111 */     }
/* 112 */     if (isNullA && isNullB) {
/* 113 */       // Nothing
/* 114 */     } else if (isNullA) {
/* 115 */       return -1;
/* 116 */     } else if (isNullB) {
/* 117 */       return 1;
/* 118 */     } else {
/* 119 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA, primitiveB);
/* 120 */       if (comp != 0) {
/* 121 */         return comp;
/* 122 */       }
/* 123 */     }
/* 124 */
/* 125 */     return 0;
/* 126 */
/* 127 */   }
/* 128 */
/* 129 */
/* 130 */   public int compare(InternalRow a, InternalRow b) {
/* 131 */
/* 132 */     InternalRow i = null;
/* 133 */
/* 134 */     int comp = compare_0(a, b);
/* 135 */     if (comp != 0) {
/* 136 */       return comp;
/* 137 */     }
/* 138 */
/* 139 */     int comp1 = compare_1(a, b);
/* 140 */     if (comp1 != 0) {
/* 141 */       return comp1;
/* 142 */     }
/* 143 */
/* 144 */
/* 145 */     return 0;
/* 146 */   }
/* 147 */ }

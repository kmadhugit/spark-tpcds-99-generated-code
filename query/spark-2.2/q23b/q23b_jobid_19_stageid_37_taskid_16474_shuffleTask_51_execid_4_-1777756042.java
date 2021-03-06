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
/* 021 */     boolean isNullA2;
/* 022 */     double primitiveA2;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull2 = i.isNullAt(2);
/* 026 */       double value2 = isNull2 ? -1.0 : (i.getDouble(2));
/* 027 */       isNullA2 = isNull2;
/* 028 */       primitiveA2 = value2;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB2;
/* 032 */     double primitiveB2;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull2 = i.isNullAt(2);
/* 036 */       double value2 = isNull2 ? -1.0 : (i.getDouble(2));
/* 037 */       isNullB2 = isNull2;
/* 038 */       primitiveB2 = value2;
/* 039 */     }
/* 040 */     if (isNullA2 && isNullB2) {
/* 041 */       // Nothing
/* 042 */     } else if (isNullA2) {
/* 043 */       return -1;
/* 044 */     } else if (isNullB2) {
/* 045 */       return 1;
/* 046 */     } else {
/* 047 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA2, primitiveB2);
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
/* 064 */     UTF8String primitiveA;
/* 065 */     {
/* 066 */
/* 067 */       boolean isNull = i.isNullAt(0);
/* 068 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 069 */       isNullA = isNull;
/* 070 */       primitiveA = value;
/* 071 */     }
/* 072 */     i = b;
/* 073 */     boolean isNullB;
/* 074 */     UTF8String primitiveB;
/* 075 */     {
/* 076 */
/* 077 */       boolean isNull = i.isNullAt(0);
/* 078 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 079 */       isNullB = isNull;
/* 080 */       primitiveB = value;
/* 081 */     }
/* 082 */     if (isNullA && isNullB) {
/* 083 */       // Nothing
/* 084 */     } else if (isNullA) {
/* 085 */       return -1;
/* 086 */     } else if (isNullB) {
/* 087 */       return 1;
/* 088 */     } else {
/* 089 */       int comp = primitiveA.compare(primitiveB);
/* 090 */       if (comp != 0) {
/* 091 */         return comp;
/* 092 */       }
/* 093 */     }
/* 094 */
/* 095 */     i = a;
/* 096 */     boolean isNullA1;
/* 097 */     UTF8String primitiveA1;
/* 098 */     {
/* 099 */
/* 100 */       boolean isNull1 = i.isNullAt(1);
/* 101 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 102 */       isNullA1 = isNull1;
/* 103 */       primitiveA1 = value1;
/* 104 */     }
/* 105 */     i = b;
/* 106 */     boolean isNullB1;
/* 107 */     UTF8String primitiveB1;
/* 108 */     {
/* 109 */
/* 110 */       boolean isNull1 = i.isNullAt(1);
/* 111 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 112 */       isNullB1 = isNull1;
/* 113 */       primitiveB1 = value1;
/* 114 */     }
/* 115 */     if (isNullA1 && isNullB1) {
/* 116 */       // Nothing
/* 117 */     } else if (isNullA1) {
/* 118 */       return -1;
/* 119 */     } else if (isNullB1) {
/* 120 */       return 1;
/* 121 */     } else {
/* 122 */       int comp = primitiveA1.compare(primitiveB1);
/* 123 */       if (comp != 0) {
/* 124 */         return comp;
/* 125 */       }
/* 126 */     }
/* 127 */
/* 128 */     return 0;
/* 129 */
/* 130 */   }
/* 131 */
/* 132 */
/* 133 */   public int compare(InternalRow a, InternalRow b) {
/* 134 */
/* 135 */     InternalRow i = null;
/* 136 */
/* 137 */     int comp = compare_0(a, b);
/* 138 */     if (comp != 0) {
/* 139 */       return comp;
/* 140 */     }
/* 141 */
/* 142 */     int comp1 = compare_1(a, b);
/* 143 */     if (comp1 != 0) {
/* 144 */       return comp1;
/* 145 */     }
/* 146 */
/* 147 */
/* 148 */     return 0;
/* 149 */   }
/* 150 */ }

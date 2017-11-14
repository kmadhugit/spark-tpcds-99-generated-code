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
/* 022 */     int primitiveA2;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull2 = i.isNullAt(4);
/* 026 */       int value2 = isNull2 ? -1 : (i.getInt(4));
/* 027 */       isNullA2 = isNull2;
/* 028 */       primitiveA2 = value2;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB2;
/* 032 */     int primitiveB2;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull2 = i.isNullAt(4);
/* 036 */       int value2 = isNull2 ? -1 : (i.getInt(4));
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
/* 047 */       int comp = (primitiveA2 > primitiveB2 ? 1 : primitiveA2 < primitiveB2 ? -1 : 0);
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
/* 067 */       UTF8String value = i.getUTF8String(0);
/* 068 */       isNullA = false;
/* 069 */       primitiveA = value;
/* 070 */     }
/* 071 */     i = b;
/* 072 */     boolean isNullB;
/* 073 */     UTF8String primitiveB;
/* 074 */     {
/* 075 */
/* 076 */       UTF8String value = i.getUTF8String(0);
/* 077 */       isNullB = false;
/* 078 */       primitiveB = value;
/* 079 */     }
/* 080 */     if (isNullA && isNullB) {
/* 081 */       // Nothing
/* 082 */     } else if (isNullA) {
/* 083 */       return -1;
/* 084 */     } else if (isNullB) {
/* 085 */       return 1;
/* 086 */     } else {
/* 087 */       int comp = primitiveA.compare(primitiveB);
/* 088 */       if (comp != 0) {
/* 089 */         return comp;
/* 090 */       }
/* 091 */     }
/* 092 */
/* 093 */     i = a;
/* 094 */     boolean isNullA1;
/* 095 */     int primitiveA1;
/* 096 */     {
/* 097 */
/* 098 */       boolean isNull1 = i.isNullAt(3);
/* 099 */       int value1 = isNull1 ? -1 : (i.getInt(3));
/* 100 */       isNullA1 = isNull1;
/* 101 */       primitiveA1 = value1;
/* 102 */     }
/* 103 */     i = b;
/* 104 */     boolean isNullB1;
/* 105 */     int primitiveB1;
/* 106 */     {
/* 107 */
/* 108 */       boolean isNull1 = i.isNullAt(3);
/* 109 */       int value1 = isNull1 ? -1 : (i.getInt(3));
/* 110 */       isNullB1 = isNull1;
/* 111 */       primitiveB1 = value1;
/* 112 */     }
/* 113 */     if (isNullA1 && isNullB1) {
/* 114 */       // Nothing
/* 115 */     } else if (isNullA1) {
/* 116 */       return -1;
/* 117 */     } else if (isNullB1) {
/* 118 */       return 1;
/* 119 */     } else {
/* 120 */       int comp = (primitiveA1 > primitiveB1 ? 1 : primitiveA1 < primitiveB1 ? -1 : 0);
/* 121 */       if (comp != 0) {
/* 122 */         return comp;
/* 123 */       }
/* 124 */     }
/* 125 */
/* 126 */     return 0;
/* 127 */
/* 128 */   }
/* 129 */
/* 130 */
/* 131 */   public int compare(InternalRow a, InternalRow b) {
/* 132 */
/* 133 */     InternalRow i = null;
/* 134 */
/* 135 */     int comp = compare_0(a, b);
/* 136 */     if (comp != 0) {
/* 137 */       return comp;
/* 138 */     }
/* 139 */
/* 140 */     int comp1 = compare_1(a, b);
/* 141 */     if (comp1 != 0) {
/* 142 */       return comp1;
/* 143 */     }
/* 144 */
/* 145 */
/* 146 */     return 0;
/* 147 */   }
/* 148 */ }

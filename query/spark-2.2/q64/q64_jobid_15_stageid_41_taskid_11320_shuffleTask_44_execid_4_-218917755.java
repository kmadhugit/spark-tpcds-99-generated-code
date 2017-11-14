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
/* 022 */     long primitiveA2;
/* 023 */     {
/* 024 */
/* 025 */       long value2 = i.getLong(20);
/* 026 */       isNullA2 = false;
/* 027 */       primitiveA2 = value2;
/* 028 */     }
/* 029 */     i = b;
/* 030 */     boolean isNullB2;
/* 031 */     long primitiveB2;
/* 032 */     {
/* 033 */
/* 034 */       long value2 = i.getLong(20);
/* 035 */       isNullB2 = false;
/* 036 */       primitiveB2 = value2;
/* 037 */     }
/* 038 */     if (isNullA2 && isNullB2) {
/* 039 */       // Nothing
/* 040 */     } else if (isNullA2) {
/* 041 */       return -1;
/* 042 */     } else if (isNullB2) {
/* 043 */       return 1;
/* 044 */     } else {
/* 045 */       int comp = (primitiveA2 > primitiveB2 ? 1 : primitiveA2 < primitiveB2 ? -1 : 0);
/* 046 */       if (comp != 0) {
/* 047 */         return comp;
/* 048 */       }
/* 049 */     }
/* 050 */
/* 051 */     return 0;
/* 052 */
/* 053 */   }
/* 054 */
/* 055 */
/* 056 */   private int compare_0(InternalRow a, InternalRow b) {
/* 057 */
/* 058 */     InternalRow i = null;  // Holds current row being evaluated.
/* 059 */
/* 060 */     i = a;
/* 061 */     boolean isNullA;
/* 062 */     UTF8String primitiveA;
/* 063 */     {
/* 064 */
/* 065 */       boolean isNull = i.isNullAt(0);
/* 066 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 067 */       isNullA = isNull;
/* 068 */       primitiveA = value;
/* 069 */     }
/* 070 */     i = b;
/* 071 */     boolean isNullB;
/* 072 */     UTF8String primitiveB;
/* 073 */     {
/* 074 */
/* 075 */       boolean isNull = i.isNullAt(0);
/* 076 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 077 */       isNullB = isNull;
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
/* 095 */     UTF8String primitiveA1;
/* 096 */     {
/* 097 */
/* 098 */       boolean isNull1 = i.isNullAt(1);
/* 099 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 100 */       isNullA1 = isNull1;
/* 101 */       primitiveA1 = value1;
/* 102 */     }
/* 103 */     i = b;
/* 104 */     boolean isNullB1;
/* 105 */     UTF8String primitiveB1;
/* 106 */     {
/* 107 */
/* 108 */       boolean isNull1 = i.isNullAt(1);
/* 109 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
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
/* 120 */       int comp = primitiveA1.compare(primitiveB1);
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

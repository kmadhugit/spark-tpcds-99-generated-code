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
/* 022 */     UTF8String primitiveA2;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull2 = i.isNullAt(2);
/* 026 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 027 */       isNullA2 = isNull2;
/* 028 */       primitiveA2 = value2;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB2;
/* 032 */     UTF8String primitiveB2;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull2 = i.isNullAt(2);
/* 036 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
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
/* 047 */       int comp = primitiveA2.compare(primitiveB2);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */     i = a;
/* 054 */     boolean isNullA3;
/* 055 */     int primitiveA3;
/* 056 */     {
/* 057 */
/* 058 */       boolean isNull3 = i.isNullAt(3);
/* 059 */       int value3 = isNull3 ? -1 : (i.getInt(3));
/* 060 */       isNullA3 = isNull3;
/* 061 */       primitiveA3 = value3;
/* 062 */     }
/* 063 */     i = b;
/* 064 */     boolean isNullB3;
/* 065 */     int primitiveB3;
/* 066 */     {
/* 067 */
/* 068 */       boolean isNull3 = i.isNullAt(3);
/* 069 */       int value3 = isNull3 ? -1 : (i.getInt(3));
/* 070 */       isNullB3 = isNull3;
/* 071 */       primitiveB3 = value3;
/* 072 */     }
/* 073 */     if (isNullA3 && isNullB3) {
/* 074 */       // Nothing
/* 075 */     } else if (isNullA3) {
/* 076 */       return -1;
/* 077 */     } else if (isNullB3) {
/* 078 */       return 1;
/* 079 */     } else {
/* 080 */       int comp = (primitiveA3 > primitiveB3 ? 1 : primitiveA3 < primitiveB3 ? -1 : 0);
/* 081 */       if (comp != 0) {
/* 082 */         return comp;
/* 083 */       }
/* 084 */     }
/* 085 */
/* 086 */     return 0;
/* 087 */
/* 088 */   }
/* 089 */
/* 090 */
/* 091 */   private int compare_0(InternalRow a, InternalRow b) {
/* 092 */
/* 093 */     InternalRow i = null;  // Holds current row being evaluated.
/* 094 */
/* 095 */     i = a;
/* 096 */     boolean isNullA;
/* 097 */     UTF8String primitiveA;
/* 098 */     {
/* 099 */
/* 100 */       boolean isNull = i.isNullAt(0);
/* 101 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 102 */       isNullA = isNull;
/* 103 */       primitiveA = value;
/* 104 */     }
/* 105 */     i = b;
/* 106 */     boolean isNullB;
/* 107 */     UTF8String primitiveB;
/* 108 */     {
/* 109 */
/* 110 */       boolean isNull = i.isNullAt(0);
/* 111 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 112 */       isNullB = isNull;
/* 113 */       primitiveB = value;
/* 114 */     }
/* 115 */     if (isNullA && isNullB) {
/* 116 */       // Nothing
/* 117 */     } else if (isNullA) {
/* 118 */       return -1;
/* 119 */     } else if (isNullB) {
/* 120 */       return 1;
/* 121 */     } else {
/* 122 */       int comp = primitiveA.compare(primitiveB);
/* 123 */       if (comp != 0) {
/* 124 */         return comp;
/* 125 */       }
/* 126 */     }
/* 127 */
/* 128 */     i = a;
/* 129 */     boolean isNullA1;
/* 130 */     UTF8String primitiveA1;
/* 131 */     {
/* 132 */
/* 133 */       boolean isNull1 = i.isNullAt(1);
/* 134 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 135 */       isNullA1 = isNull1;
/* 136 */       primitiveA1 = value1;
/* 137 */     }
/* 138 */     i = b;
/* 139 */     boolean isNullB1;
/* 140 */     UTF8String primitiveB1;
/* 141 */     {
/* 142 */
/* 143 */       boolean isNull1 = i.isNullAt(1);
/* 144 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 145 */       isNullB1 = isNull1;
/* 146 */       primitiveB1 = value1;
/* 147 */     }
/* 148 */     if (isNullA1 && isNullB1) {
/* 149 */       // Nothing
/* 150 */     } else if (isNullA1) {
/* 151 */       return -1;
/* 152 */     } else if (isNullB1) {
/* 153 */       return 1;
/* 154 */     } else {
/* 155 */       int comp = primitiveA1.compare(primitiveB1);
/* 156 */       if (comp != 0) {
/* 157 */         return comp;
/* 158 */       }
/* 159 */     }
/* 160 */
/* 161 */     return 0;
/* 162 */
/* 163 */   }
/* 164 */
/* 165 */
/* 166 */   public int compare(InternalRow a, InternalRow b) {
/* 167 */
/* 168 */     InternalRow i = null;
/* 169 */
/* 170 */     int comp = compare_0(a, b);
/* 171 */     if (comp != 0) {
/* 172 */       return comp;
/* 173 */     }
/* 174 */
/* 175 */     int comp1 = compare_1(a, b);
/* 176 */     if (comp1 != 0) {
/* 177 */       return comp1;
/* 178 */     }
/* 179 */
/* 180 */
/* 181 */     return 0;
/* 182 */   }
/* 183 */ }

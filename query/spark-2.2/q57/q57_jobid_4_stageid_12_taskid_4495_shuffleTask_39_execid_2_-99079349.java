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
/* 058 */       boolean isNull3 = true;
/* 059 */       int value3 = -1;
/* 060 */
/* 061 */       boolean isNull4 = i.isNullAt(4);
/* 062 */       int value4 = isNull4 ? -1 : (i.getInt(4));
/* 063 */       if (!isNull4) {
/* 064 */
/* 065 */
/* 066 */         isNull3 = false; // resultCode could change nullability.
/* 067 */         value3 = value4 + 1;
/* 068 */
/* 069 */       }
/* 070 */       isNullA3 = isNull3;
/* 071 */       primitiveA3 = value3;
/* 072 */     }
/* 073 */     i = b;
/* 074 */     boolean isNullB3;
/* 075 */     int primitiveB3;
/* 076 */     {
/* 077 */
/* 078 */       boolean isNull3 = true;
/* 079 */       int value3 = -1;
/* 080 */
/* 081 */       boolean isNull4 = i.isNullAt(4);
/* 082 */       int value4 = isNull4 ? -1 : (i.getInt(4));
/* 083 */       if (!isNull4) {
/* 084 */
/* 085 */
/* 086 */         isNull3 = false; // resultCode could change nullability.
/* 087 */         value3 = value4 + 1;
/* 088 */
/* 089 */       }
/* 090 */       isNullB3 = isNull3;
/* 091 */       primitiveB3 = value3;
/* 092 */     }
/* 093 */     if (isNullA3 && isNullB3) {
/* 094 */       // Nothing
/* 095 */     } else if (isNullA3) {
/* 096 */       return -1;
/* 097 */     } else if (isNullB3) {
/* 098 */       return 1;
/* 099 */     } else {
/* 100 */       int comp = (primitiveA3 > primitiveB3 ? 1 : primitiveA3 < primitiveB3 ? -1 : 0);
/* 101 */       if (comp != 0) {
/* 102 */         return comp;
/* 103 */       }
/* 104 */     }
/* 105 */
/* 106 */     return 0;
/* 107 */
/* 108 */   }
/* 109 */
/* 110 */
/* 111 */   private int compare_0(InternalRow a, InternalRow b) {
/* 112 */
/* 113 */     InternalRow i = null;  // Holds current row being evaluated.
/* 114 */
/* 115 */     i = a;
/* 116 */     boolean isNullA;
/* 117 */     UTF8String primitiveA;
/* 118 */     {
/* 119 */
/* 120 */       boolean isNull = i.isNullAt(0);
/* 121 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 122 */       isNullA = isNull;
/* 123 */       primitiveA = value;
/* 124 */     }
/* 125 */     i = b;
/* 126 */     boolean isNullB;
/* 127 */     UTF8String primitiveB;
/* 128 */     {
/* 129 */
/* 130 */       boolean isNull = i.isNullAt(0);
/* 131 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 132 */       isNullB = isNull;
/* 133 */       primitiveB = value;
/* 134 */     }
/* 135 */     if (isNullA && isNullB) {
/* 136 */       // Nothing
/* 137 */     } else if (isNullA) {
/* 138 */       return -1;
/* 139 */     } else if (isNullB) {
/* 140 */       return 1;
/* 141 */     } else {
/* 142 */       int comp = primitiveA.compare(primitiveB);
/* 143 */       if (comp != 0) {
/* 144 */         return comp;
/* 145 */       }
/* 146 */     }
/* 147 */
/* 148 */     i = a;
/* 149 */     boolean isNullA1;
/* 150 */     UTF8String primitiveA1;
/* 151 */     {
/* 152 */
/* 153 */       boolean isNull1 = i.isNullAt(1);
/* 154 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 155 */       isNullA1 = isNull1;
/* 156 */       primitiveA1 = value1;
/* 157 */     }
/* 158 */     i = b;
/* 159 */     boolean isNullB1;
/* 160 */     UTF8String primitiveB1;
/* 161 */     {
/* 162 */
/* 163 */       boolean isNull1 = i.isNullAt(1);
/* 164 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 165 */       isNullB1 = isNull1;
/* 166 */       primitiveB1 = value1;
/* 167 */     }
/* 168 */     if (isNullA1 && isNullB1) {
/* 169 */       // Nothing
/* 170 */     } else if (isNullA1) {
/* 171 */       return -1;
/* 172 */     } else if (isNullB1) {
/* 173 */       return 1;
/* 174 */     } else {
/* 175 */       int comp = primitiveA1.compare(primitiveB1);
/* 176 */       if (comp != 0) {
/* 177 */         return comp;
/* 178 */       }
/* 179 */     }
/* 180 */
/* 181 */     return 0;
/* 182 */
/* 183 */   }
/* 184 */
/* 185 */
/* 186 */   public int compare(InternalRow a, InternalRow b) {
/* 187 */
/* 188 */     InternalRow i = null;
/* 189 */
/* 190 */     int comp = compare_0(a, b);
/* 191 */     if (comp != 0) {
/* 192 */       return comp;
/* 193 */     }
/* 194 */
/* 195 */     int comp1 = compare_1(a, b);
/* 196 */     if (comp1 != 0) {
/* 197 */       return comp1;
/* 198 */     }
/* 199 */
/* 200 */
/* 201 */     return 0;
/* 202 */   }
/* 203 */ }

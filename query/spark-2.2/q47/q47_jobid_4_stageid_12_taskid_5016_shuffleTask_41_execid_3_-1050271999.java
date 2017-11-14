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
/* 016 */   private int compare_2(InternalRow a, InternalRow b) {
/* 017 */
/* 018 */     InternalRow i = null;  // Holds current row being evaluated.
/* 019 */
/* 020 */     i = a;
/* 021 */     boolean isNullA4;
/* 022 */     int primitiveA4;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull4 = true;
/* 026 */       int value4 = -1;
/* 027 */
/* 028 */       boolean isNull5 = i.isNullAt(5);
/* 029 */       int value5 = isNull5 ? -1 : (i.getInt(5));
/* 030 */       if (!isNull5) {
/* 031 */
/* 032 */
/* 033 */         isNull4 = false; // resultCode could change nullability.
/* 034 */         value4 = value5 - 1;
/* 035 */
/* 036 */       }
/* 037 */       isNullA4 = isNull4;
/* 038 */       primitiveA4 = value4;
/* 039 */     }
/* 040 */     i = b;
/* 041 */     boolean isNullB4;
/* 042 */     int primitiveB4;
/* 043 */     {
/* 044 */
/* 045 */       boolean isNull4 = true;
/* 046 */       int value4 = -1;
/* 047 */
/* 048 */       boolean isNull5 = i.isNullAt(5);
/* 049 */       int value5 = isNull5 ? -1 : (i.getInt(5));
/* 050 */       if (!isNull5) {
/* 051 */
/* 052 */
/* 053 */         isNull4 = false; // resultCode could change nullability.
/* 054 */         value4 = value5 - 1;
/* 055 */
/* 056 */       }
/* 057 */       isNullB4 = isNull4;
/* 058 */       primitiveB4 = value4;
/* 059 */     }
/* 060 */     if (isNullA4 && isNullB4) {
/* 061 */       // Nothing
/* 062 */     } else if (isNullA4) {
/* 063 */       return -1;
/* 064 */     } else if (isNullB4) {
/* 065 */       return 1;
/* 066 */     } else {
/* 067 */       int comp = (primitiveA4 > primitiveB4 ? 1 : primitiveA4 < primitiveB4 ? -1 : 0);
/* 068 */       if (comp != 0) {
/* 069 */         return comp;
/* 070 */       }
/* 071 */     }
/* 072 */
/* 073 */     return 0;
/* 074 */
/* 075 */   }
/* 076 */
/* 077 */
/* 078 */   private int compare_1(InternalRow a, InternalRow b) {
/* 079 */
/* 080 */     InternalRow i = null;  // Holds current row being evaluated.
/* 081 */
/* 082 */     i = a;
/* 083 */     boolean isNullA2;
/* 084 */     UTF8String primitiveA2;
/* 085 */     {
/* 086 */
/* 087 */       boolean isNull2 = i.isNullAt(2);
/* 088 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 089 */       isNullA2 = isNull2;
/* 090 */       primitiveA2 = value2;
/* 091 */     }
/* 092 */     i = b;
/* 093 */     boolean isNullB2;
/* 094 */     UTF8String primitiveB2;
/* 095 */     {
/* 096 */
/* 097 */       boolean isNull2 = i.isNullAt(2);
/* 098 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 099 */       isNullB2 = isNull2;
/* 100 */       primitiveB2 = value2;
/* 101 */     }
/* 102 */     if (isNullA2 && isNullB2) {
/* 103 */       // Nothing
/* 104 */     } else if (isNullA2) {
/* 105 */       return -1;
/* 106 */     } else if (isNullB2) {
/* 107 */       return 1;
/* 108 */     } else {
/* 109 */       int comp = primitiveA2.compare(primitiveB2);
/* 110 */       if (comp != 0) {
/* 111 */         return comp;
/* 112 */       }
/* 113 */     }
/* 114 */
/* 115 */     i = a;
/* 116 */     boolean isNullA3;
/* 117 */     UTF8String primitiveA3;
/* 118 */     {
/* 119 */
/* 120 */       boolean isNull3 = i.isNullAt(3);
/* 121 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 122 */       isNullA3 = isNull3;
/* 123 */       primitiveA3 = value3;
/* 124 */     }
/* 125 */     i = b;
/* 126 */     boolean isNullB3;
/* 127 */     UTF8String primitiveB3;
/* 128 */     {
/* 129 */
/* 130 */       boolean isNull3 = i.isNullAt(3);
/* 131 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 132 */       isNullB3 = isNull3;
/* 133 */       primitiveB3 = value3;
/* 134 */     }
/* 135 */     if (isNullA3 && isNullB3) {
/* 136 */       // Nothing
/* 137 */     } else if (isNullA3) {
/* 138 */       return -1;
/* 139 */     } else if (isNullB3) {
/* 140 */       return 1;
/* 141 */     } else {
/* 142 */       int comp = primitiveA3.compare(primitiveB3);
/* 143 */       if (comp != 0) {
/* 144 */         return comp;
/* 145 */       }
/* 146 */     }
/* 147 */
/* 148 */     return 0;
/* 149 */
/* 150 */   }
/* 151 */
/* 152 */
/* 153 */   private int compare_0(InternalRow a, InternalRow b) {
/* 154 */
/* 155 */     InternalRow i = null;  // Holds current row being evaluated.
/* 156 */
/* 157 */     i = a;
/* 158 */     boolean isNullA;
/* 159 */     UTF8String primitiveA;
/* 160 */     {
/* 161 */
/* 162 */       boolean isNull = i.isNullAt(0);
/* 163 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 164 */       isNullA = isNull;
/* 165 */       primitiveA = value;
/* 166 */     }
/* 167 */     i = b;
/* 168 */     boolean isNullB;
/* 169 */     UTF8String primitiveB;
/* 170 */     {
/* 171 */
/* 172 */       boolean isNull = i.isNullAt(0);
/* 173 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 174 */       isNullB = isNull;
/* 175 */       primitiveB = value;
/* 176 */     }
/* 177 */     if (isNullA && isNullB) {
/* 178 */       // Nothing
/* 179 */     } else if (isNullA) {
/* 180 */       return -1;
/* 181 */     } else if (isNullB) {
/* 182 */       return 1;
/* 183 */     } else {
/* 184 */       int comp = primitiveA.compare(primitiveB);
/* 185 */       if (comp != 0) {
/* 186 */         return comp;
/* 187 */       }
/* 188 */     }
/* 189 */
/* 190 */     i = a;
/* 191 */     boolean isNullA1;
/* 192 */     UTF8String primitiveA1;
/* 193 */     {
/* 194 */
/* 195 */       boolean isNull1 = i.isNullAt(1);
/* 196 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 197 */       isNullA1 = isNull1;
/* 198 */       primitiveA1 = value1;
/* 199 */     }
/* 200 */     i = b;
/* 201 */     boolean isNullB1;
/* 202 */     UTF8String primitiveB1;
/* 203 */     {
/* 204 */
/* 205 */       boolean isNull1 = i.isNullAt(1);
/* 206 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 207 */       isNullB1 = isNull1;
/* 208 */       primitiveB1 = value1;
/* 209 */     }
/* 210 */     if (isNullA1 && isNullB1) {
/* 211 */       // Nothing
/* 212 */     } else if (isNullA1) {
/* 213 */       return -1;
/* 214 */     } else if (isNullB1) {
/* 215 */       return 1;
/* 216 */     } else {
/* 217 */       int comp = primitiveA1.compare(primitiveB1);
/* 218 */       if (comp != 0) {
/* 219 */         return comp;
/* 220 */       }
/* 221 */     }
/* 222 */
/* 223 */     return 0;
/* 224 */
/* 225 */   }
/* 226 */
/* 227 */
/* 228 */   public int compare(InternalRow a, InternalRow b) {
/* 229 */
/* 230 */     InternalRow i = null;
/* 231 */
/* 232 */     int comp = compare_0(a, b);
/* 233 */     if (comp != 0) {
/* 234 */       return comp;
/* 235 */     }
/* 236 */
/* 237 */     int comp1 = compare_1(a, b);
/* 238 */     if (comp1 != 0) {
/* 239 */       return comp1;
/* 240 */     }
/* 241 */
/* 242 */     int comp2 = compare_2(a, b);
/* 243 */     if (comp2 != 0) {
/* 244 */       return comp2;
/* 245 */     }
/* 246 */
/* 247 */
/* 248 */     return 0;
/* 249 */   }
/* 250 */ }

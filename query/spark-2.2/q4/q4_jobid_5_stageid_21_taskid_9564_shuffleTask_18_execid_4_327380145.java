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
/* 022 */     UTF8String primitiveA4;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull4 = i.isNullAt(4);
/* 026 */       UTF8String value4 = isNull4 ? null : (i.getUTF8String(4));
/* 027 */       isNullA4 = isNull4;
/* 028 */       primitiveA4 = value4;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB4;
/* 032 */     UTF8String primitiveB4;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull4 = i.isNullAt(4);
/* 036 */       UTF8String value4 = isNull4 ? null : (i.getUTF8String(4));
/* 037 */       isNullB4 = isNull4;
/* 038 */       primitiveB4 = value4;
/* 039 */     }
/* 040 */     if (isNullA4 && isNullB4) {
/* 041 */       // Nothing
/* 042 */     } else if (isNullA4) {
/* 043 */       return -1;
/* 044 */     } else if (isNullB4) {
/* 045 */       return 1;
/* 046 */     } else {
/* 047 */       int comp = primitiveA4.compare(primitiveB4);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */     i = a;
/* 054 */     boolean isNullA5;
/* 055 */     UTF8String primitiveA5;
/* 056 */     {
/* 057 */
/* 058 */       boolean isNull5 = i.isNullAt(5);
/* 059 */       UTF8String value5 = isNull5 ? null : (i.getUTF8String(5));
/* 060 */       isNullA5 = isNull5;
/* 061 */       primitiveA5 = value5;
/* 062 */     }
/* 063 */     i = b;
/* 064 */     boolean isNullB5;
/* 065 */     UTF8String primitiveB5;
/* 066 */     {
/* 067 */
/* 068 */       boolean isNull5 = i.isNullAt(5);
/* 069 */       UTF8String value5 = isNull5 ? null : (i.getUTF8String(5));
/* 070 */       isNullB5 = isNull5;
/* 071 */       primitiveB5 = value5;
/* 072 */     }
/* 073 */     if (isNullA5 && isNullB5) {
/* 074 */       // Nothing
/* 075 */     } else if (isNullA5) {
/* 076 */       return -1;
/* 077 */     } else if (isNullB5) {
/* 078 */       return 1;
/* 079 */     } else {
/* 080 */       int comp = primitiveA5.compare(primitiveB5);
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
/* 091 */   private int compare_1(InternalRow a, InternalRow b) {
/* 092 */
/* 093 */     InternalRow i = null;  // Holds current row being evaluated.
/* 094 */
/* 095 */     i = a;
/* 096 */     boolean isNullA2;
/* 097 */     UTF8String primitiveA2;
/* 098 */     {
/* 099 */
/* 100 */       boolean isNull2 = i.isNullAt(2);
/* 101 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 102 */       isNullA2 = isNull2;
/* 103 */       primitiveA2 = value2;
/* 104 */     }
/* 105 */     i = b;
/* 106 */     boolean isNullB2;
/* 107 */     UTF8String primitiveB2;
/* 108 */     {
/* 109 */
/* 110 */       boolean isNull2 = i.isNullAt(2);
/* 111 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 112 */       isNullB2 = isNull2;
/* 113 */       primitiveB2 = value2;
/* 114 */     }
/* 115 */     if (isNullA2 && isNullB2) {
/* 116 */       // Nothing
/* 117 */     } else if (isNullA2) {
/* 118 */       return -1;
/* 119 */     } else if (isNullB2) {
/* 120 */       return 1;
/* 121 */     } else {
/* 122 */       int comp = primitiveA2.compare(primitiveB2);
/* 123 */       if (comp != 0) {
/* 124 */         return comp;
/* 125 */       }
/* 126 */     }
/* 127 */
/* 128 */     i = a;
/* 129 */     boolean isNullA3;
/* 130 */     UTF8String primitiveA3;
/* 131 */     {
/* 132 */
/* 133 */       boolean isNull3 = i.isNullAt(3);
/* 134 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 135 */       isNullA3 = isNull3;
/* 136 */       primitiveA3 = value3;
/* 137 */     }
/* 138 */     i = b;
/* 139 */     boolean isNullB3;
/* 140 */     UTF8String primitiveB3;
/* 141 */     {
/* 142 */
/* 143 */       boolean isNull3 = i.isNullAt(3);
/* 144 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 145 */       isNullB3 = isNull3;
/* 146 */       primitiveB3 = value3;
/* 147 */     }
/* 148 */     if (isNullA3 && isNullB3) {
/* 149 */       // Nothing
/* 150 */     } else if (isNullA3) {
/* 151 */       return -1;
/* 152 */     } else if (isNullB3) {
/* 153 */       return 1;
/* 154 */     } else {
/* 155 */       int comp = primitiveA3.compare(primitiveB3);
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
/* 166 */   private int compare_3(InternalRow a, InternalRow b) {
/* 167 */
/* 168 */     InternalRow i = null;  // Holds current row being evaluated.
/* 169 */
/* 170 */     i = a;
/* 171 */     boolean isNullA6;
/* 172 */     UTF8String primitiveA6;
/* 173 */     {
/* 174 */
/* 175 */       boolean isNull6 = i.isNullAt(6);
/* 176 */       UTF8String value6 = isNull6 ? null : (i.getUTF8String(6));
/* 177 */       isNullA6 = isNull6;
/* 178 */       primitiveA6 = value6;
/* 179 */     }
/* 180 */     i = b;
/* 181 */     boolean isNullB6;
/* 182 */     UTF8String primitiveB6;
/* 183 */     {
/* 184 */
/* 185 */       boolean isNull6 = i.isNullAt(6);
/* 186 */       UTF8String value6 = isNull6 ? null : (i.getUTF8String(6));
/* 187 */       isNullB6 = isNull6;
/* 188 */       primitiveB6 = value6;
/* 189 */     }
/* 190 */     if (isNullA6 && isNullB6) {
/* 191 */       // Nothing
/* 192 */     } else if (isNullA6) {
/* 193 */       return -1;
/* 194 */     } else if (isNullB6) {
/* 195 */       return 1;
/* 196 */     } else {
/* 197 */       int comp = primitiveA6.compare(primitiveB6);
/* 198 */       if (comp != 0) {
/* 199 */         return comp;
/* 200 */       }
/* 201 */     }
/* 202 */
/* 203 */     return 0;
/* 204 */
/* 205 */   }
/* 206 */
/* 207 */
/* 208 */   private int compare_0(InternalRow a, InternalRow b) {
/* 209 */
/* 210 */     InternalRow i = null;  // Holds current row being evaluated.
/* 211 */
/* 212 */     i = a;
/* 213 */     boolean isNullA;
/* 214 */     UTF8String primitiveA;
/* 215 */     {
/* 216 */
/* 217 */       boolean isNull = i.isNullAt(0);
/* 218 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 219 */       isNullA = isNull;
/* 220 */       primitiveA = value;
/* 221 */     }
/* 222 */     i = b;
/* 223 */     boolean isNullB;
/* 224 */     UTF8String primitiveB;
/* 225 */     {
/* 226 */
/* 227 */       boolean isNull = i.isNullAt(0);
/* 228 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 229 */       isNullB = isNull;
/* 230 */       primitiveB = value;
/* 231 */     }
/* 232 */     if (isNullA && isNullB) {
/* 233 */       // Nothing
/* 234 */     } else if (isNullA) {
/* 235 */       return -1;
/* 236 */     } else if (isNullB) {
/* 237 */       return 1;
/* 238 */     } else {
/* 239 */       int comp = primitiveA.compare(primitiveB);
/* 240 */       if (comp != 0) {
/* 241 */         return comp;
/* 242 */       }
/* 243 */     }
/* 244 */
/* 245 */     i = a;
/* 246 */     boolean isNullA1;
/* 247 */     UTF8String primitiveA1;
/* 248 */     {
/* 249 */
/* 250 */       boolean isNull1 = i.isNullAt(1);
/* 251 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 252 */       isNullA1 = isNull1;
/* 253 */       primitiveA1 = value1;
/* 254 */     }
/* 255 */     i = b;
/* 256 */     boolean isNullB1;
/* 257 */     UTF8String primitiveB1;
/* 258 */     {
/* 259 */
/* 260 */       boolean isNull1 = i.isNullAt(1);
/* 261 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 262 */       isNullB1 = isNull1;
/* 263 */       primitiveB1 = value1;
/* 264 */     }
/* 265 */     if (isNullA1 && isNullB1) {
/* 266 */       // Nothing
/* 267 */     } else if (isNullA1) {
/* 268 */       return -1;
/* 269 */     } else if (isNullB1) {
/* 270 */       return 1;
/* 271 */     } else {
/* 272 */       int comp = primitiveA1.compare(primitiveB1);
/* 273 */       if (comp != 0) {
/* 274 */         return comp;
/* 275 */       }
/* 276 */     }
/* 277 */
/* 278 */     return 0;
/* 279 */
/* 280 */   }
/* 281 */
/* 282 */
/* 283 */   public int compare(InternalRow a, InternalRow b) {
/* 284 */
/* 285 */     InternalRow i = null;
/* 286 */
/* 287 */     int comp = compare_0(a, b);
/* 288 */     if (comp != 0) {
/* 289 */       return comp;
/* 290 */     }
/* 291 */
/* 292 */     int comp1 = compare_1(a, b);
/* 293 */     if (comp1 != 0) {
/* 294 */       return comp1;
/* 295 */     }
/* 296 */
/* 297 */     int comp2 = compare_2(a, b);
/* 298 */     if (comp2 != 0) {
/* 299 */       return comp2;
/* 300 */     }
/* 301 */
/* 302 */     int comp3 = compare_3(a, b);
/* 303 */     if (comp3 != 0) {
/* 304 */       return comp3;
/* 305 */     }
/* 306 */
/* 307 */
/* 308 */     return 0;
/* 309 */   }
/* 310 */ }

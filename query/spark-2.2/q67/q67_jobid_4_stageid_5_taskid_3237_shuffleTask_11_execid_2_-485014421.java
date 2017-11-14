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
/* 025 */       boolean isNull4 = i.isNullAt(4);
/* 026 */       int value4 = isNull4 ? -1 : (i.getInt(4));
/* 027 */       isNullA4 = isNull4;
/* 028 */       primitiveA4 = value4;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB4;
/* 032 */     int primitiveB4;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull4 = i.isNullAt(4);
/* 036 */       int value4 = isNull4 ? -1 : (i.getInt(4));
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
/* 047 */       int comp = (primitiveA4 > primitiveB4 ? 1 : primitiveA4 < primitiveB4 ? -1 : 0);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */     i = a;
/* 054 */     boolean isNullA5;
/* 055 */     int primitiveA5;
/* 056 */     {
/* 057 */
/* 058 */       boolean isNull5 = i.isNullAt(5);
/* 059 */       int value5 = isNull5 ? -1 : (i.getInt(5));
/* 060 */       isNullA5 = isNull5;
/* 061 */       primitiveA5 = value5;
/* 062 */     }
/* 063 */     i = b;
/* 064 */     boolean isNullB5;
/* 065 */     int primitiveB5;
/* 066 */     {
/* 067 */
/* 068 */       boolean isNull5 = i.isNullAt(5);
/* 069 */       int value5 = isNull5 ? -1 : (i.getInt(5));
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
/* 080 */       int comp = (primitiveA5 > primitiveB5 ? 1 : primitiveA5 < primitiveB5 ? -1 : 0);
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
/* 166 */   private int compare_4(InternalRow a, InternalRow b) {
/* 167 */
/* 168 */     InternalRow i = null;  // Holds current row being evaluated.
/* 169 */
/* 170 */     i = a;
/* 171 */     boolean isNullA8;
/* 172 */     int primitiveA8;
/* 173 */     {
/* 174 */
/* 175 */       boolean isNull8 = i.isNullAt(8);
/* 176 */       int value8 = isNull8 ? -1 : (i.getInt(8));
/* 177 */       isNullA8 = isNull8;
/* 178 */       primitiveA8 = value8;
/* 179 */     }
/* 180 */     i = b;
/* 181 */     boolean isNullB8;
/* 182 */     int primitiveB8;
/* 183 */     {
/* 184 */
/* 185 */       boolean isNull8 = i.isNullAt(8);
/* 186 */       int value8 = isNull8 ? -1 : (i.getInt(8));
/* 187 */       isNullB8 = isNull8;
/* 188 */       primitiveB8 = value8;
/* 189 */     }
/* 190 */     if (isNullA8 && isNullB8) {
/* 191 */       // Nothing
/* 192 */     } else if (isNullA8) {
/* 193 */       return -1;
/* 194 */     } else if (isNullB8) {
/* 195 */       return 1;
/* 196 */     } else {
/* 197 */       int comp = (primitiveA8 > primitiveB8 ? 1 : primitiveA8 < primitiveB8 ? -1 : 0);
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
/* 208 */   private int compare_3(InternalRow a, InternalRow b) {
/* 209 */
/* 210 */     InternalRow i = null;  // Holds current row being evaluated.
/* 211 */
/* 212 */     i = a;
/* 213 */     boolean isNullA6;
/* 214 */     int primitiveA6;
/* 215 */     {
/* 216 */
/* 217 */       boolean isNull6 = i.isNullAt(6);
/* 218 */       int value6 = isNull6 ? -1 : (i.getInt(6));
/* 219 */       isNullA6 = isNull6;
/* 220 */       primitiveA6 = value6;
/* 221 */     }
/* 222 */     i = b;
/* 223 */     boolean isNullB6;
/* 224 */     int primitiveB6;
/* 225 */     {
/* 226 */
/* 227 */       boolean isNull6 = i.isNullAt(6);
/* 228 */       int value6 = isNull6 ? -1 : (i.getInt(6));
/* 229 */       isNullB6 = isNull6;
/* 230 */       primitiveB6 = value6;
/* 231 */     }
/* 232 */     if (isNullA6 && isNullB6) {
/* 233 */       // Nothing
/* 234 */     } else if (isNullA6) {
/* 235 */       return -1;
/* 236 */     } else if (isNullB6) {
/* 237 */       return 1;
/* 238 */     } else {
/* 239 */       int comp = (primitiveA6 > primitiveB6 ? 1 : primitiveA6 < primitiveB6 ? -1 : 0);
/* 240 */       if (comp != 0) {
/* 241 */         return comp;
/* 242 */       }
/* 243 */     }
/* 244 */
/* 245 */     i = a;
/* 246 */     boolean isNullA7;
/* 247 */     UTF8String primitiveA7;
/* 248 */     {
/* 249 */
/* 250 */       boolean isNull7 = i.isNullAt(7);
/* 251 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(7));
/* 252 */       isNullA7 = isNull7;
/* 253 */       primitiveA7 = value7;
/* 254 */     }
/* 255 */     i = b;
/* 256 */     boolean isNullB7;
/* 257 */     UTF8String primitiveB7;
/* 258 */     {
/* 259 */
/* 260 */       boolean isNull7 = i.isNullAt(7);
/* 261 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(7));
/* 262 */       isNullB7 = isNull7;
/* 263 */       primitiveB7 = value7;
/* 264 */     }
/* 265 */     if (isNullA7 && isNullB7) {
/* 266 */       // Nothing
/* 267 */     } else if (isNullA7) {
/* 268 */       return -1;
/* 269 */     } else if (isNullB7) {
/* 270 */       return 1;
/* 271 */     } else {
/* 272 */       int comp = primitiveA7.compare(primitiveB7);
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
/* 283 */   private int compare_0(InternalRow a, InternalRow b) {
/* 284 */
/* 285 */     InternalRow i = null;  // Holds current row being evaluated.
/* 286 */
/* 287 */     i = a;
/* 288 */     boolean isNullA;
/* 289 */     UTF8String primitiveA;
/* 290 */     {
/* 291 */
/* 292 */       boolean isNull = i.isNullAt(0);
/* 293 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 294 */       isNullA = isNull;
/* 295 */       primitiveA = value;
/* 296 */     }
/* 297 */     i = b;
/* 298 */     boolean isNullB;
/* 299 */     UTF8String primitiveB;
/* 300 */     {
/* 301 */
/* 302 */       boolean isNull = i.isNullAt(0);
/* 303 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 304 */       isNullB = isNull;
/* 305 */       primitiveB = value;
/* 306 */     }
/* 307 */     if (isNullA && isNullB) {
/* 308 */       // Nothing
/* 309 */     } else if (isNullA) {
/* 310 */       return -1;
/* 311 */     } else if (isNullB) {
/* 312 */       return 1;
/* 313 */     } else {
/* 314 */       int comp = primitiveA.compare(primitiveB);
/* 315 */       if (comp != 0) {
/* 316 */         return comp;
/* 317 */       }
/* 318 */     }
/* 319 */
/* 320 */     i = a;
/* 321 */     boolean isNullA1;
/* 322 */     UTF8String primitiveA1;
/* 323 */     {
/* 324 */
/* 325 */       boolean isNull1 = i.isNullAt(1);
/* 326 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 327 */       isNullA1 = isNull1;
/* 328 */       primitiveA1 = value1;
/* 329 */     }
/* 330 */     i = b;
/* 331 */     boolean isNullB1;
/* 332 */     UTF8String primitiveB1;
/* 333 */     {
/* 334 */
/* 335 */       boolean isNull1 = i.isNullAt(1);
/* 336 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 337 */       isNullB1 = isNull1;
/* 338 */       primitiveB1 = value1;
/* 339 */     }
/* 340 */     if (isNullA1 && isNullB1) {
/* 341 */       // Nothing
/* 342 */     } else if (isNullA1) {
/* 343 */       return -1;
/* 344 */     } else if (isNullB1) {
/* 345 */       return 1;
/* 346 */     } else {
/* 347 */       int comp = primitiveA1.compare(primitiveB1);
/* 348 */       if (comp != 0) {
/* 349 */         return comp;
/* 350 */       }
/* 351 */     }
/* 352 */
/* 353 */     return 0;
/* 354 */
/* 355 */   }
/* 356 */
/* 357 */
/* 358 */   public int compare(InternalRow a, InternalRow b) {
/* 359 */
/* 360 */     InternalRow i = null;
/* 361 */
/* 362 */     int comp = compare_0(a, b);
/* 363 */     if (comp != 0) {
/* 364 */       return comp;
/* 365 */     }
/* 366 */
/* 367 */     int comp1 = compare_1(a, b);
/* 368 */     if (comp1 != 0) {
/* 369 */       return comp1;
/* 370 */     }
/* 371 */
/* 372 */     int comp2 = compare_2(a, b);
/* 373 */     if (comp2 != 0) {
/* 374 */       return comp2;
/* 375 */     }
/* 376 */
/* 377 */     int comp3 = compare_3(a, b);
/* 378 */     if (comp3 != 0) {
/* 379 */       return comp3;
/* 380 */     }
/* 381 */
/* 382 */     int comp4 = compare_4(a, b);
/* 383 */     if (comp4 != 0) {
/* 384 */       return comp4;
/* 385 */     }
/* 386 */
/* 387 */
/* 388 */     return 0;
/* 389 */   }
/* 390 */ }

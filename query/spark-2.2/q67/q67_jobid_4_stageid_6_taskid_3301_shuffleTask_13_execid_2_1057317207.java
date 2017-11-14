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
/* 172 */     double primitiveA8;
/* 173 */     {
/* 174 */
/* 175 */       boolean isNull8 = i.isNullAt(8);
/* 176 */       double value8 = isNull8 ? -1.0 : (i.getDouble(8));
/* 177 */       isNullA8 = isNull8;
/* 178 */       primitiveA8 = value8;
/* 179 */     }
/* 180 */     i = b;
/* 181 */     boolean isNullB8;
/* 182 */     double primitiveB8;
/* 183 */     {
/* 184 */
/* 185 */       boolean isNull8 = i.isNullAt(8);
/* 186 */       double value8 = isNull8 ? -1.0 : (i.getDouble(8));
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
/* 197 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA8, primitiveB8);
/* 198 */       if (comp != 0) {
/* 199 */         return comp;
/* 200 */       }
/* 201 */     }
/* 202 */
/* 203 */     i = a;
/* 204 */     boolean isNullA9;
/* 205 */     int primitiveA9;
/* 206 */     {
/* 207 */
/* 208 */       int value9 = i.getInt(9);
/* 209 */       isNullA9 = false;
/* 210 */       primitiveA9 = value9;
/* 211 */     }
/* 212 */     i = b;
/* 213 */     boolean isNullB9;
/* 214 */     int primitiveB9;
/* 215 */     {
/* 216 */
/* 217 */       int value9 = i.getInt(9);
/* 218 */       isNullB9 = false;
/* 219 */       primitiveB9 = value9;
/* 220 */     }
/* 221 */     if (isNullA9 && isNullB9) {
/* 222 */       // Nothing
/* 223 */     } else if (isNullA9) {
/* 224 */       return -1;
/* 225 */     } else if (isNullB9) {
/* 226 */       return 1;
/* 227 */     } else {
/* 228 */       int comp = (primitiveA9 > primitiveB9 ? 1 : primitiveA9 < primitiveB9 ? -1 : 0);
/* 229 */       if (comp != 0) {
/* 230 */         return comp;
/* 231 */       }
/* 232 */     }
/* 233 */
/* 234 */     return 0;
/* 235 */
/* 236 */   }
/* 237 */
/* 238 */
/* 239 */   private int compare_3(InternalRow a, InternalRow b) {
/* 240 */
/* 241 */     InternalRow i = null;  // Holds current row being evaluated.
/* 242 */
/* 243 */     i = a;
/* 244 */     boolean isNullA6;
/* 245 */     int primitiveA6;
/* 246 */     {
/* 247 */
/* 248 */       boolean isNull6 = i.isNullAt(6);
/* 249 */       int value6 = isNull6 ? -1 : (i.getInt(6));
/* 250 */       isNullA6 = isNull6;
/* 251 */       primitiveA6 = value6;
/* 252 */     }
/* 253 */     i = b;
/* 254 */     boolean isNullB6;
/* 255 */     int primitiveB6;
/* 256 */     {
/* 257 */
/* 258 */       boolean isNull6 = i.isNullAt(6);
/* 259 */       int value6 = isNull6 ? -1 : (i.getInt(6));
/* 260 */       isNullB6 = isNull6;
/* 261 */       primitiveB6 = value6;
/* 262 */     }
/* 263 */     if (isNullA6 && isNullB6) {
/* 264 */       // Nothing
/* 265 */     } else if (isNullA6) {
/* 266 */       return -1;
/* 267 */     } else if (isNullB6) {
/* 268 */       return 1;
/* 269 */     } else {
/* 270 */       int comp = (primitiveA6 > primitiveB6 ? 1 : primitiveA6 < primitiveB6 ? -1 : 0);
/* 271 */       if (comp != 0) {
/* 272 */         return comp;
/* 273 */       }
/* 274 */     }
/* 275 */
/* 276 */     i = a;
/* 277 */     boolean isNullA7;
/* 278 */     UTF8String primitiveA7;
/* 279 */     {
/* 280 */
/* 281 */       boolean isNull7 = i.isNullAt(7);
/* 282 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(7));
/* 283 */       isNullA7 = isNull7;
/* 284 */       primitiveA7 = value7;
/* 285 */     }
/* 286 */     i = b;
/* 287 */     boolean isNullB7;
/* 288 */     UTF8String primitiveB7;
/* 289 */     {
/* 290 */
/* 291 */       boolean isNull7 = i.isNullAt(7);
/* 292 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(7));
/* 293 */       isNullB7 = isNull7;
/* 294 */       primitiveB7 = value7;
/* 295 */     }
/* 296 */     if (isNullA7 && isNullB7) {
/* 297 */       // Nothing
/* 298 */     } else if (isNullA7) {
/* 299 */       return -1;
/* 300 */     } else if (isNullB7) {
/* 301 */       return 1;
/* 302 */     } else {
/* 303 */       int comp = primitiveA7.compare(primitiveB7);
/* 304 */       if (comp != 0) {
/* 305 */         return comp;
/* 306 */       }
/* 307 */     }
/* 308 */
/* 309 */     return 0;
/* 310 */
/* 311 */   }
/* 312 */
/* 313 */
/* 314 */   private int compare_0(InternalRow a, InternalRow b) {
/* 315 */
/* 316 */     InternalRow i = null;  // Holds current row being evaluated.
/* 317 */
/* 318 */     i = a;
/* 319 */     boolean isNullA;
/* 320 */     UTF8String primitiveA;
/* 321 */     {
/* 322 */
/* 323 */       boolean isNull = i.isNullAt(0);
/* 324 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 325 */       isNullA = isNull;
/* 326 */       primitiveA = value;
/* 327 */     }
/* 328 */     i = b;
/* 329 */     boolean isNullB;
/* 330 */     UTF8String primitiveB;
/* 331 */     {
/* 332 */
/* 333 */       boolean isNull = i.isNullAt(0);
/* 334 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 335 */       isNullB = isNull;
/* 336 */       primitiveB = value;
/* 337 */     }
/* 338 */     if (isNullA && isNullB) {
/* 339 */       // Nothing
/* 340 */     } else if (isNullA) {
/* 341 */       return -1;
/* 342 */     } else if (isNullB) {
/* 343 */       return 1;
/* 344 */     } else {
/* 345 */       int comp = primitiveA.compare(primitiveB);
/* 346 */       if (comp != 0) {
/* 347 */         return comp;
/* 348 */       }
/* 349 */     }
/* 350 */
/* 351 */     i = a;
/* 352 */     boolean isNullA1;
/* 353 */     UTF8String primitiveA1;
/* 354 */     {
/* 355 */
/* 356 */       boolean isNull1 = i.isNullAt(1);
/* 357 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 358 */       isNullA1 = isNull1;
/* 359 */       primitiveA1 = value1;
/* 360 */     }
/* 361 */     i = b;
/* 362 */     boolean isNullB1;
/* 363 */     UTF8String primitiveB1;
/* 364 */     {
/* 365 */
/* 366 */       boolean isNull1 = i.isNullAt(1);
/* 367 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 368 */       isNullB1 = isNull1;
/* 369 */       primitiveB1 = value1;
/* 370 */     }
/* 371 */     if (isNullA1 && isNullB1) {
/* 372 */       // Nothing
/* 373 */     } else if (isNullA1) {
/* 374 */       return -1;
/* 375 */     } else if (isNullB1) {
/* 376 */       return 1;
/* 377 */     } else {
/* 378 */       int comp = primitiveA1.compare(primitiveB1);
/* 379 */       if (comp != 0) {
/* 380 */         return comp;
/* 381 */       }
/* 382 */     }
/* 383 */
/* 384 */     return 0;
/* 385 */
/* 386 */   }
/* 387 */
/* 388 */
/* 389 */   public int compare(InternalRow a, InternalRow b) {
/* 390 */
/* 391 */     InternalRow i = null;
/* 392 */
/* 393 */     int comp = compare_0(a, b);
/* 394 */     if (comp != 0) {
/* 395 */       return comp;
/* 396 */     }
/* 397 */
/* 398 */     int comp1 = compare_1(a, b);
/* 399 */     if (comp1 != 0) {
/* 400 */       return comp1;
/* 401 */     }
/* 402 */
/* 403 */     int comp2 = compare_2(a, b);
/* 404 */     if (comp2 != 0) {
/* 405 */       return comp2;
/* 406 */     }
/* 407 */
/* 408 */     int comp3 = compare_3(a, b);
/* 409 */     if (comp3 != 0) {
/* 410 */       return comp3;
/* 411 */     }
/* 412 */
/* 413 */     int comp4 = compare_4(a, b);
/* 414 */     if (comp4 != 0) {
/* 415 */       return comp4;
/* 416 */     }
/* 417 */
/* 418 */
/* 419 */     return 0;
/* 420 */   }
/* 421 */ }

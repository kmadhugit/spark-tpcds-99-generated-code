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
/* 022 */     long primitiveA4;
/* 023 */     {
/* 024 */
/* 025 */       long value4 = i.getLong(4);
/* 026 */       isNullA4 = false;
/* 027 */       primitiveA4 = value4;
/* 028 */     }
/* 029 */     i = b;
/* 030 */     boolean isNullB4;
/* 031 */     long primitiveB4;
/* 032 */     {
/* 033 */
/* 034 */       long value4 = i.getLong(4);
/* 035 */       isNullB4 = false;
/* 036 */       primitiveB4 = value4;
/* 037 */     }
/* 038 */     if (isNullA4 && isNullB4) {
/* 039 */       // Nothing
/* 040 */     } else if (isNullA4) {
/* 041 */       return -1;
/* 042 */     } else if (isNullB4) {
/* 043 */       return 1;
/* 044 */     } else {
/* 045 */       int comp = (primitiveA4 > primitiveB4 ? 1 : primitiveA4 < primitiveB4 ? -1 : 0);
/* 046 */       if (comp != 0) {
/* 047 */         return comp;
/* 048 */       }
/* 049 */     }
/* 050 */
/* 051 */     i = a;
/* 052 */     boolean isNullA5;
/* 053 */     double primitiveA5;
/* 054 */     {
/* 055 */
/* 056 */       double value5 = i.getDouble(5);
/* 057 */       isNullA5 = false;
/* 058 */       primitiveA5 = value5;
/* 059 */     }
/* 060 */     i = b;
/* 061 */     boolean isNullB5;
/* 062 */     double primitiveB5;
/* 063 */     {
/* 064 */
/* 065 */       double value5 = i.getDouble(5);
/* 066 */       isNullB5 = false;
/* 067 */       primitiveB5 = value5;
/* 068 */     }
/* 069 */     if (isNullA5 && isNullB5) {
/* 070 */       // Nothing
/* 071 */     } else if (isNullA5) {
/* 072 */       return -1;
/* 073 */     } else if (isNullB5) {
/* 074 */       return 1;
/* 075 */     } else {
/* 076 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA5, primitiveB5);
/* 077 */       if (comp != 0) {
/* 078 */         return comp;
/* 079 */       }
/* 080 */     }
/* 081 */
/* 082 */     return 0;
/* 083 */
/* 084 */   }
/* 085 */
/* 086 */
/* 087 */   private int compare_1(InternalRow a, InternalRow b) {
/* 088 */
/* 089 */     InternalRow i = null;  // Holds current row being evaluated.
/* 090 */
/* 091 */     i = a;
/* 092 */     boolean isNullA2;
/* 093 */     double primitiveA2;
/* 094 */     {
/* 095 */
/* 096 */       boolean isNull2 = i.isNullAt(9);
/* 097 */       double value2 = isNull2 ? -1.0 : (i.getDouble(9));
/* 098 */       isNullA2 = isNull2;
/* 099 */       primitiveA2 = value2;
/* 100 */     }
/* 101 */     i = b;
/* 102 */     boolean isNullB2;
/* 103 */     double primitiveB2;
/* 104 */     {
/* 105 */
/* 106 */       boolean isNull2 = i.isNullAt(9);
/* 107 */       double value2 = isNull2 ? -1.0 : (i.getDouble(9));
/* 108 */       isNullB2 = isNull2;
/* 109 */       primitiveB2 = value2;
/* 110 */     }
/* 111 */     if (isNullA2 && isNullB2) {
/* 112 */       // Nothing
/* 113 */     } else if (isNullA2) {
/* 114 */       return 1;
/* 115 */     } else if (isNullB2) {
/* 116 */       return -1;
/* 117 */     } else {
/* 118 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA2, primitiveB2);
/* 119 */       if (comp != 0) {
/* 120 */         return -comp;
/* 121 */       }
/* 122 */     }
/* 123 */
/* 124 */     i = a;
/* 125 */     boolean isNullA3;
/* 126 */     double primitiveA3;
/* 127 */     {
/* 128 */
/* 129 */       boolean isNull3 = i.isNullAt(11);
/* 130 */       double value3 = isNull3 ? -1.0 : (i.getDouble(11));
/* 131 */       isNullA3 = isNull3;
/* 132 */       primitiveA3 = value3;
/* 133 */     }
/* 134 */     i = b;
/* 135 */     boolean isNullB3;
/* 136 */     double primitiveB3;
/* 137 */     {
/* 138 */
/* 139 */       boolean isNull3 = i.isNullAt(11);
/* 140 */       double value3 = isNull3 ? -1.0 : (i.getDouble(11));
/* 141 */       isNullB3 = isNull3;
/* 142 */       primitiveB3 = value3;
/* 143 */     }
/* 144 */     if (isNullA3 && isNullB3) {
/* 145 */       // Nothing
/* 146 */     } else if (isNullA3) {
/* 147 */       return 1;
/* 148 */     } else if (isNullB3) {
/* 149 */       return -1;
/* 150 */     } else {
/* 151 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA3, primitiveB3);
/* 152 */       if (comp != 0) {
/* 153 */         return -comp;
/* 154 */       }
/* 155 */     }
/* 156 */
/* 157 */     return 0;
/* 158 */
/* 159 */   }
/* 160 */
/* 161 */
/* 162 */   private int compare_3(InternalRow a, InternalRow b) {
/* 163 */
/* 164 */     InternalRow i = null;  // Holds current row being evaluated.
/* 165 */
/* 166 */     i = a;
/* 167 */     boolean isNullA6;
/* 168 */     double primitiveA6;
/* 169 */     {
/* 170 */
/* 171 */       double value6 = i.getDouble(6);
/* 172 */       isNullA6 = false;
/* 173 */       primitiveA6 = value6;
/* 174 */     }
/* 175 */     i = b;
/* 176 */     boolean isNullB6;
/* 177 */     double primitiveB6;
/* 178 */     {
/* 179 */
/* 180 */       double value6 = i.getDouble(6);
/* 181 */       isNullB6 = false;
/* 182 */       primitiveB6 = value6;
/* 183 */     }
/* 184 */     if (isNullA6 && isNullB6) {
/* 185 */       // Nothing
/* 186 */     } else if (isNullA6) {
/* 187 */       return -1;
/* 188 */     } else if (isNullB6) {
/* 189 */       return 1;
/* 190 */     } else {
/* 191 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA6, primitiveB6);
/* 192 */       if (comp != 0) {
/* 193 */         return comp;
/* 194 */       }
/* 195 */     }
/* 196 */
/* 197 */     i = a;
/* 198 */     boolean isNullA7;
/* 199 */     double primitiveA7;
/* 200 */     {
/* 201 */
/* 202 */       boolean isNull13 = true;
/* 203 */       long value13 = -1L;
/* 204 */
/* 205 */       boolean isNull14 = i.isNullAt(8);
/* 206 */       long value14 = isNull14 ? -1L : (i.getLong(8));
/* 207 */       if (!isNull14) {
/* 208 */
/* 209 */         boolean isNull15 = i.isNullAt(7);
/* 210 */         long value15 = isNull15 ? -1L : (i.getLong(7));
/* 211 */         if (!isNull15) {
/* 212 */
/* 213 */           isNull13 = false; // resultCode could change nullability.
/* 214 */           value13 = value14 + value15;
/* 215 */
/* 216 */         }
/* 217 */
/* 218 */       }
/* 219 */       boolean isNull12 = isNull13;
/* 220 */       long value12 = value13;
/* 221 */       if (isNull12) {
/* 222 */
/* 223 */         if (!false) {
/* 224 */           isNull12 = false;
/* 225 */           value12 = 1L;
/* 226 */         }
/* 227 */       }
/* 228 */       boolean isNull11 = isNull12;
/* 229 */       double value11 = -1.0;
/* 230 */       if (!isNull12) {
/* 231 */         value11 = (double) value12;
/* 232 */       }
/* 233 */       boolean isNull8 = false;
/* 234 */       double value8 = -1.0;
/* 235 */       if (isNull11 || value11 == 0) {
/* 236 */         isNull8 = true;
/* 237 */       } else {
/* 238 */
/* 239 */         boolean isNull10 = i.isNullAt(10);
/* 240 */         long value10 = isNull10 ? -1L : (i.getLong(10));
/* 241 */         boolean isNull9 = isNull10;
/* 242 */         double value9 = -1.0;
/* 243 */         if (!isNull10) {
/* 244 */           value9 = (double) value10;
/* 245 */         }
/* 246 */         if (isNull9) {
/* 247 */           isNull8 = true;
/* 248 */         } else {
/* 249 */           value8 = (double)(value9 / value11);
/* 250 */         }
/* 251 */       }
/* 252 */       boolean isNull7 = isNull8;
/* 253 */       double value7 = -1.0;
/* 254 */       if (!isNull7) {
/* 255 */
/* 256 */         if (Double.isNaN(value8) || Double.isInfinite(value8)) {
/* 257 */           value7 = value8;
/* 258 */         } else {
/* 259 */           value7 = java.math.BigDecimal.valueOf(value8).
/* 260 */           setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
/* 261 */         }
/* 262 */       }
/* 263 */       isNullA7 = isNull7;
/* 264 */       primitiveA7 = value7;
/* 265 */     }
/* 266 */     i = b;
/* 267 */     boolean isNullB7;
/* 268 */     double primitiveB7;
/* 269 */     {
/* 270 */
/* 271 */       boolean isNull13 = true;
/* 272 */       long value13 = -1L;
/* 273 */
/* 274 */       boolean isNull14 = i.isNullAt(8);
/* 275 */       long value14 = isNull14 ? -1L : (i.getLong(8));
/* 276 */       if (!isNull14) {
/* 277 */
/* 278 */         boolean isNull15 = i.isNullAt(7);
/* 279 */         long value15 = isNull15 ? -1L : (i.getLong(7));
/* 280 */         if (!isNull15) {
/* 281 */
/* 282 */           isNull13 = false; // resultCode could change nullability.
/* 283 */           value13 = value14 + value15;
/* 284 */
/* 285 */         }
/* 286 */
/* 287 */       }
/* 288 */       boolean isNull12 = isNull13;
/* 289 */       long value12 = value13;
/* 290 */       if (isNull12) {
/* 291 */
/* 292 */         if (!false) {
/* 293 */           isNull12 = false;
/* 294 */           value12 = 1L;
/* 295 */         }
/* 296 */       }
/* 297 */       boolean isNull11 = isNull12;
/* 298 */       double value11 = -1.0;
/* 299 */       if (!isNull12) {
/* 300 */         value11 = (double) value12;
/* 301 */       }
/* 302 */       boolean isNull8 = false;
/* 303 */       double value8 = -1.0;
/* 304 */       if (isNull11 || value11 == 0) {
/* 305 */         isNull8 = true;
/* 306 */       } else {
/* 307 */
/* 308 */         boolean isNull10 = i.isNullAt(10);
/* 309 */         long value10 = isNull10 ? -1L : (i.getLong(10));
/* 310 */         boolean isNull9 = isNull10;
/* 311 */         double value9 = -1.0;
/* 312 */         if (!isNull10) {
/* 313 */           value9 = (double) value10;
/* 314 */         }
/* 315 */         if (isNull9) {
/* 316 */           isNull8 = true;
/* 317 */         } else {
/* 318 */           value8 = (double)(value9 / value11);
/* 319 */         }
/* 320 */       }
/* 321 */       boolean isNull7 = isNull8;
/* 322 */       double value7 = -1.0;
/* 323 */       if (!isNull7) {
/* 324 */
/* 325 */         if (Double.isNaN(value8) || Double.isInfinite(value8)) {
/* 326 */           value7 = value8;
/* 327 */         } else {
/* 328 */           value7 = java.math.BigDecimal.valueOf(value8).
/* 329 */           setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
/* 330 */         }
/* 331 */       }
/* 332 */       isNullB7 = isNull7;
/* 333 */       primitiveB7 = value7;
/* 334 */     }
/* 335 */     if (isNullA7 && isNullB7) {
/* 336 */       // Nothing
/* 337 */     } else if (isNullA7) {
/* 338 */       return -1;
/* 339 */     } else if (isNullB7) {
/* 340 */       return 1;
/* 341 */     } else {
/* 342 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA7, primitiveB7);
/* 343 */       if (comp != 0) {
/* 344 */         return comp;
/* 345 */       }
/* 346 */     }
/* 347 */
/* 348 */     return 0;
/* 349 */
/* 350 */   }
/* 351 */
/* 352 */
/* 353 */   private int compare_0(InternalRow a, InternalRow b) {
/* 354 */
/* 355 */     InternalRow i = null;  // Holds current row being evaluated.
/* 356 */
/* 357 */     i = a;
/* 358 */     boolean isNullA;
/* 359 */     double primitiveA;
/* 360 */     {
/* 361 */
/* 362 */       boolean isNull = i.isNullAt(0);
/* 363 */       double value = isNull ? -1.0 : (i.getDouble(0));
/* 364 */       isNullA = isNull;
/* 365 */       primitiveA = value;
/* 366 */     }
/* 367 */     i = b;
/* 368 */     boolean isNullB;
/* 369 */     double primitiveB;
/* 370 */     {
/* 371 */
/* 372 */       boolean isNull = i.isNullAt(0);
/* 373 */       double value = isNull ? -1.0 : (i.getDouble(0));
/* 374 */       isNullB = isNull;
/* 375 */       primitiveB = value;
/* 376 */     }
/* 377 */     if (isNullA && isNullB) {
/* 378 */       // Nothing
/* 379 */     } else if (isNullA) {
/* 380 */       return -1;
/* 381 */     } else if (isNullB) {
/* 382 */       return 1;
/* 383 */     } else {
/* 384 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA, primitiveB);
/* 385 */       if (comp != 0) {
/* 386 */         return comp;
/* 387 */       }
/* 388 */     }
/* 389 */
/* 390 */     i = a;
/* 391 */     boolean isNullA1;
/* 392 */     long primitiveA1;
/* 393 */     {
/* 394 */
/* 395 */       boolean isNull1 = i.isNullAt(10);
/* 396 */       long value1 = isNull1 ? -1L : (i.getLong(10));
/* 397 */       isNullA1 = isNull1;
/* 398 */       primitiveA1 = value1;
/* 399 */     }
/* 400 */     i = b;
/* 401 */     boolean isNullB1;
/* 402 */     long primitiveB1;
/* 403 */     {
/* 404 */
/* 405 */       boolean isNull1 = i.isNullAt(10);
/* 406 */       long value1 = isNull1 ? -1L : (i.getLong(10));
/* 407 */       isNullB1 = isNull1;
/* 408 */       primitiveB1 = value1;
/* 409 */     }
/* 410 */     if (isNullA1 && isNullB1) {
/* 411 */       // Nothing
/* 412 */     } else if (isNullA1) {
/* 413 */       return 1;
/* 414 */     } else if (isNullB1) {
/* 415 */       return -1;
/* 416 */     } else {
/* 417 */       int comp = (primitiveA1 > primitiveB1 ? 1 : primitiveA1 < primitiveB1 ? -1 : 0);
/* 418 */       if (comp != 0) {
/* 419 */         return -comp;
/* 420 */       }
/* 421 */     }
/* 422 */
/* 423 */     return 0;
/* 424 */
/* 425 */   }
/* 426 */
/* 427 */
/* 428 */   public int compare(InternalRow a, InternalRow b) {
/* 429 */
/* 430 */     InternalRow i = null;
/* 431 */
/* 432 */     int comp = compare_0(a, b);
/* 433 */     if (comp != 0) {
/* 434 */       return comp;
/* 435 */     }
/* 436 */
/* 437 */     int comp1 = compare_1(a, b);
/* 438 */     if (comp1 != 0) {
/* 439 */       return comp1;
/* 440 */     }
/* 441 */
/* 442 */     int comp2 = compare_2(a, b);
/* 443 */     if (comp2 != 0) {
/* 444 */       return comp2;
/* 445 */     }
/* 446 */
/* 447 */     int comp3 = compare_3(a, b);
/* 448 */     if (comp3 != 0) {
/* 449 */       return comp3;
/* 450 */     }
/* 451 */
/* 452 */
/* 453 */     return 0;
/* 454 */   }
/* 455 */ }

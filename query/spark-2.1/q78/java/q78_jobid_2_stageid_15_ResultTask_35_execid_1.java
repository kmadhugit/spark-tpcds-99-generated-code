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
/* 016 */
/* 017 */   public int compare(InternalRow a, InternalRow b) {
/* 018 */     InternalRow i = null;  // Holds current row being evaluated.
/* 019 */
/* 020 */     i = a;
/* 021 */     boolean isNullA;
/* 022 */     double primitiveA;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull = i.isNullAt(0);
/* 026 */       double value = isNull ? -1.0 : (i.getDouble(0));
/* 027 */       isNullA = isNull;
/* 028 */       primitiveA = value;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB;
/* 032 */     double primitiveB;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull = i.isNullAt(0);
/* 036 */       double value = isNull ? -1.0 : (i.getDouble(0));
/* 037 */       isNullB = isNull;
/* 038 */       primitiveB = value;
/* 039 */     }
/* 040 */     if (isNullA && isNullB) {
/* 041 */       // Nothing
/* 042 */     } else if (isNullA) {
/* 043 */       return -1;
/* 044 */     } else if (isNullB) {
/* 045 */       return 1;
/* 046 */     } else {
/* 047 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA, primitiveB);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */
/* 054 */     i = a;
/* 055 */     boolean isNullA1;
/* 056 */     long primitiveA1;
/* 057 */     {
/* 058 */
/* 059 */       boolean isNull1 = i.isNullAt(10);
/* 060 */       long value1 = isNull1 ? -1L : (i.getLong(10));
/* 061 */       isNullA1 = isNull1;
/* 062 */       primitiveA1 = value1;
/* 063 */     }
/* 064 */     i = b;
/* 065 */     boolean isNullB1;
/* 066 */     long primitiveB1;
/* 067 */     {
/* 068 */
/* 069 */       boolean isNull1 = i.isNullAt(10);
/* 070 */       long value1 = isNull1 ? -1L : (i.getLong(10));
/* 071 */       isNullB1 = isNull1;
/* 072 */       primitiveB1 = value1;
/* 073 */     }
/* 074 */     if (isNullA1 && isNullB1) {
/* 075 */       // Nothing
/* 076 */     } else if (isNullA1) {
/* 077 */       return 1;
/* 078 */     } else if (isNullB1) {
/* 079 */       return -1;
/* 080 */     } else {
/* 081 */       int comp = (primitiveA1 > primitiveB1 ? 1 : primitiveA1 < primitiveB1 ? -1 : 0);
/* 082 */       if (comp != 0) {
/* 083 */         return -comp;
/* 084 */       }
/* 085 */     }
/* 086 */
/* 087 */
/* 088 */     i = a;
/* 089 */     boolean isNullA2;
/* 090 */     double primitiveA2;
/* 091 */     {
/* 092 */
/* 093 */       boolean isNull2 = i.isNullAt(9);
/* 094 */       double value2 = isNull2 ? -1.0 : (i.getDouble(9));
/* 095 */       isNullA2 = isNull2;
/* 096 */       primitiveA2 = value2;
/* 097 */     }
/* 098 */     i = b;
/* 099 */     boolean isNullB2;
/* 100 */     double primitiveB2;
/* 101 */     {
/* 102 */
/* 103 */       boolean isNull2 = i.isNullAt(9);
/* 104 */       double value2 = isNull2 ? -1.0 : (i.getDouble(9));
/* 105 */       isNullB2 = isNull2;
/* 106 */       primitiveB2 = value2;
/* 107 */     }
/* 108 */     if (isNullA2 && isNullB2) {
/* 109 */       // Nothing
/* 110 */     } else if (isNullA2) {
/* 111 */       return 1;
/* 112 */     } else if (isNullB2) {
/* 113 */       return -1;
/* 114 */     } else {
/* 115 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA2, primitiveB2);
/* 116 */       if (comp != 0) {
/* 117 */         return -comp;
/* 118 */       }
/* 119 */     }
/* 120 */
/* 121 */
/* 122 */     i = a;
/* 123 */     boolean isNullA3;
/* 124 */     double primitiveA3;
/* 125 */     {
/* 126 */
/* 127 */       boolean isNull3 = i.isNullAt(8);
/* 128 */       double value3 = isNull3 ? -1.0 : (i.getDouble(8));
/* 129 */       isNullA3 = isNull3;
/* 130 */       primitiveA3 = value3;
/* 131 */     }
/* 132 */     i = b;
/* 133 */     boolean isNullB3;
/* 134 */     double primitiveB3;
/* 135 */     {
/* 136 */
/* 137 */       boolean isNull3 = i.isNullAt(8);
/* 138 */       double value3 = isNull3 ? -1.0 : (i.getDouble(8));
/* 139 */       isNullB3 = isNull3;
/* 140 */       primitiveB3 = value3;
/* 141 */     }
/* 142 */     if (isNullA3 && isNullB3) {
/* 143 */       // Nothing
/* 144 */     } else if (isNullA3) {
/* 145 */       return 1;
/* 146 */     } else if (isNullB3) {
/* 147 */       return -1;
/* 148 */     } else {
/* 149 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA3, primitiveB3);
/* 150 */       if (comp != 0) {
/* 151 */         return -comp;
/* 152 */       }
/* 153 */     }
/* 154 */
/* 155 */
/* 156 */     i = a;
/* 157 */     boolean isNullA4;
/* 158 */     long primitiveA4;
/* 159 */     {
/* 160 */
/* 161 */       long value4 = i.getLong(4);
/* 162 */       isNullA4 = false;
/* 163 */       primitiveA4 = value4;
/* 164 */     }
/* 165 */     i = b;
/* 166 */     boolean isNullB4;
/* 167 */     long primitiveB4;
/* 168 */     {
/* 169 */
/* 170 */       long value4 = i.getLong(4);
/* 171 */       isNullB4 = false;
/* 172 */       primitiveB4 = value4;
/* 173 */     }
/* 174 */     if (isNullA4 && isNullB4) {
/* 175 */       // Nothing
/* 176 */     } else if (isNullA4) {
/* 177 */       return -1;
/* 178 */     } else if (isNullB4) {
/* 179 */       return 1;
/* 180 */     } else {
/* 181 */       int comp = (primitiveA4 > primitiveB4 ? 1 : primitiveA4 < primitiveB4 ? -1 : 0);
/* 182 */       if (comp != 0) {
/* 183 */         return comp;
/* 184 */       }
/* 185 */     }
/* 186 */
/* 187 */
/* 188 */     i = a;
/* 189 */     boolean isNullA5;
/* 190 */     double primitiveA5;
/* 191 */     {
/* 192 */
/* 193 */       double value5 = i.getDouble(5);
/* 194 */       isNullA5 = false;
/* 195 */       primitiveA5 = value5;
/* 196 */     }
/* 197 */     i = b;
/* 198 */     boolean isNullB5;
/* 199 */     double primitiveB5;
/* 200 */     {
/* 201 */
/* 202 */       double value5 = i.getDouble(5);
/* 203 */       isNullB5 = false;
/* 204 */       primitiveB5 = value5;
/* 205 */     }
/* 206 */     if (isNullA5 && isNullB5) {
/* 207 */       // Nothing
/* 208 */     } else if (isNullA5) {
/* 209 */       return -1;
/* 210 */     } else if (isNullB5) {
/* 211 */       return 1;
/* 212 */     } else {
/* 213 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA5, primitiveB5);
/* 214 */       if (comp != 0) {
/* 215 */         return comp;
/* 216 */       }
/* 217 */     }
/* 218 */
/* 219 */
/* 220 */     i = a;
/* 221 */     boolean isNullA6;
/* 222 */     double primitiveA6;
/* 223 */     {
/* 224 */
/* 225 */       double value6 = i.getDouble(6);
/* 226 */       isNullA6 = false;
/* 227 */       primitiveA6 = value6;
/* 228 */     }
/* 229 */     i = b;
/* 230 */     boolean isNullB6;
/* 231 */     double primitiveB6;
/* 232 */     {
/* 233 */
/* 234 */       double value6 = i.getDouble(6);
/* 235 */       isNullB6 = false;
/* 236 */       primitiveB6 = value6;
/* 237 */     }
/* 238 */     if (isNullA6 && isNullB6) {
/* 239 */       // Nothing
/* 240 */     } else if (isNullA6) {
/* 241 */       return -1;
/* 242 */     } else if (isNullB6) {
/* 243 */       return 1;
/* 244 */     } else {
/* 245 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA6, primitiveB6);
/* 246 */       if (comp != 0) {
/* 247 */         return comp;
/* 248 */       }
/* 249 */     }
/* 250 */
/* 251 */
/* 252 */     i = a;
/* 253 */     boolean isNullA7;
/* 254 */     double primitiveA7;
/* 255 */     {
/* 256 */
/* 257 */       boolean isNull13 = true;
/* 258 */       long value13 = -1L;
/* 259 */
/* 260 */       boolean isNull14 = i.isNullAt(11);
/* 261 */       long value14 = isNull14 ? -1L : (i.getLong(11));
/* 262 */       if (!isNull14) {
/* 263 */
/* 264 */         boolean isNull15 = i.isNullAt(7);
/* 265 */         long value15 = isNull15 ? -1L : (i.getLong(7));
/* 266 */         if (!isNull15) {
/* 267 */
/* 268 */           isNull13 = false; // resultCode could change nullability.
/* 269 */           value13 = value14 + value15;
/* 270 */
/* 271 */         }
/* 272 */
/* 273 */       }
/* 274 */       boolean isNull12 = isNull13;
/* 275 */       long value12 = value13;
/* 276 */       if (isNull12) {
/* 277 */
/* 278 */         if (!false) {
/* 279 */           isNull12 = false;
/* 280 */           value12 = 1L;
/* 281 */         }
/* 282 */       }
/* 283 */       boolean isNull11 = isNull12;
/* 284 */       double value11 = -1.0;
/* 285 */       if (!isNull12) {
/* 286 */         value11 = (double) value12;
/* 287 */       }
/* 288 */       boolean isNull8 = false;
/* 289 */       double value8 = -1.0;
/* 290 */       if (isNull11 || value11 == 0) {
/* 291 */         isNull8 = true;
/* 292 */       } else {
/* 293 */
/* 294 */         boolean isNull10 = i.isNullAt(10);
/* 295 */         long value10 = isNull10 ? -1L : (i.getLong(10));
/* 296 */         boolean isNull9 = isNull10;
/* 297 */         double value9 = -1.0;
/* 298 */         if (!isNull10) {
/* 299 */           value9 = (double) value10;
/* 300 */         }
/* 301 */         if (isNull9) {
/* 302 */           isNull8 = true;
/* 303 */         } else {
/* 304 */           value8 = (double)(value9 / value11);
/* 305 */         }
/* 306 */       }
/* 307 */       boolean isNull7 = isNull8;
/* 308 */       double value7 = -1.0;
/* 309 */       if (!isNull7) {
/* 310 */
/* 311 */         if (Double.isNaN(value8) || Double.isInfinite(value8)) {
/* 312 */           value7 = value8;
/* 313 */         } else {
/* 314 */           value7 = java.math.BigDecimal.valueOf(value8).
/* 315 */           setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
/* 316 */         }
/* 317 */       }
/* 318 */       isNullA7 = isNull7;
/* 319 */       primitiveA7 = value7;
/* 320 */     }
/* 321 */     i = b;
/* 322 */     boolean isNullB7;
/* 323 */     double primitiveB7;
/* 324 */     {
/* 325 */
/* 326 */       boolean isNull13 = true;
/* 327 */       long value13 = -1L;
/* 328 */
/* 329 */       boolean isNull14 = i.isNullAt(11);
/* 330 */       long value14 = isNull14 ? -1L : (i.getLong(11));
/* 331 */       if (!isNull14) {
/* 332 */
/* 333 */         boolean isNull15 = i.isNullAt(7);
/* 334 */         long value15 = isNull15 ? -1L : (i.getLong(7));
/* 335 */         if (!isNull15) {
/* 336 */
/* 337 */           isNull13 = false; // resultCode could change nullability.
/* 338 */           value13 = value14 + value15;
/* 339 */
/* 340 */         }
/* 341 */
/* 342 */       }
/* 343 */       boolean isNull12 = isNull13;
/* 344 */       long value12 = value13;
/* 345 */       if (isNull12) {
/* 346 */
/* 347 */         if (!false) {
/* 348 */           isNull12 = false;
/* 349 */           value12 = 1L;
/* 350 */         }
/* 351 */       }
/* 352 */       boolean isNull11 = isNull12;
/* 353 */       double value11 = -1.0;
/* 354 */       if (!isNull12) {
/* 355 */         value11 = (double) value12;
/* 356 */       }
/* 357 */       boolean isNull8 = false;
/* 358 */       double value8 = -1.0;
/* 359 */       if (isNull11 || value11 == 0) {
/* 360 */         isNull8 = true;
/* 361 */       } else {
/* 362 */
/* 363 */         boolean isNull10 = i.isNullAt(10);
/* 364 */         long value10 = isNull10 ? -1L : (i.getLong(10));
/* 365 */         boolean isNull9 = isNull10;
/* 366 */         double value9 = -1.0;
/* 367 */         if (!isNull10) {
/* 368 */           value9 = (double) value10;
/* 369 */         }
/* 370 */         if (isNull9) {
/* 371 */           isNull8 = true;
/* 372 */         } else {
/* 373 */           value8 = (double)(value9 / value11);
/* 374 */         }
/* 375 */       }
/* 376 */       boolean isNull7 = isNull8;
/* 377 */       double value7 = -1.0;
/* 378 */       if (!isNull7) {
/* 379 */
/* 380 */         if (Double.isNaN(value8) || Double.isInfinite(value8)) {
/* 381 */           value7 = value8;
/* 382 */         } else {
/* 383 */           value7 = java.math.BigDecimal.valueOf(value8).
/* 384 */           setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue();
/* 385 */         }
/* 386 */       }
/* 387 */       isNullB7 = isNull7;
/* 388 */       primitiveB7 = value7;
/* 389 */     }
/* 390 */     if (isNullA7 && isNullB7) {
/* 391 */       // Nothing
/* 392 */     } else if (isNullA7) {
/* 393 */       return -1;
/* 394 */     } else if (isNullB7) {
/* 395 */       return 1;
/* 396 */     } else {
/* 397 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA7, primitiveB7);
/* 398 */       if (comp != 0) {
/* 399 */         return comp;
/* 400 */       }
/* 401 */     }
/* 402 */
/* 403 */     return 0;
/* 404 */   }
/* 405 */ }

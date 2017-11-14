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
/* 166 */   private int compare_4(InternalRow a, InternalRow b) {
/* 167 */
/* 168 */     InternalRow i = null;  // Holds current row being evaluated.
/* 169 */
/* 170 */     i = a;
/* 171 */     boolean isNullA8;
/* 172 */     UTF8String primitiveA8;
/* 173 */     {
/* 174 */
/* 175 */       boolean isNull8 = i.isNullAt(8);
/* 176 */       UTF8String value8 = isNull8 ? null : (i.getUTF8String(8));
/* 177 */       isNullA8 = isNull8;
/* 178 */       primitiveA8 = value8;
/* 179 */     }
/* 180 */     i = b;
/* 181 */     boolean isNullB8;
/* 182 */     UTF8String primitiveB8;
/* 183 */     {
/* 184 */
/* 185 */       boolean isNull8 = i.isNullAt(8);
/* 186 */       UTF8String value8 = isNull8 ? null : (i.getUTF8String(8));
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
/* 197 */       int comp = primitiveA8.compare(primitiveB8);
/* 198 */       if (comp != 0) {
/* 199 */         return comp;
/* 200 */       }
/* 201 */     }
/* 202 */
/* 203 */     i = a;
/* 204 */     boolean isNullA9;
/* 205 */     UTF8String primitiveA9;
/* 206 */     {
/* 207 */
/* 208 */       boolean isNull9 = i.isNullAt(9);
/* 209 */       UTF8String value9 = isNull9 ? null : (i.getUTF8String(9));
/* 210 */       isNullA9 = isNull9;
/* 211 */       primitiveA9 = value9;
/* 212 */     }
/* 213 */     i = b;
/* 214 */     boolean isNullB9;
/* 215 */     UTF8String primitiveB9;
/* 216 */     {
/* 217 */
/* 218 */       boolean isNull9 = i.isNullAt(9);
/* 219 */       UTF8String value9 = isNull9 ? null : (i.getUTF8String(9));
/* 220 */       isNullB9 = isNull9;
/* 221 */       primitiveB9 = value9;
/* 222 */     }
/* 223 */     if (isNullA9 && isNullB9) {
/* 224 */       // Nothing
/* 225 */     } else if (isNullA9) {
/* 226 */       return -1;
/* 227 */     } else if (isNullB9) {
/* 228 */       return 1;
/* 229 */     } else {
/* 230 */       int comp = primitiveA9.compare(primitiveB9);
/* 231 */       if (comp != 0) {
/* 232 */         return comp;
/* 233 */       }
/* 234 */     }
/* 235 */
/* 236 */     return 0;
/* 237 */
/* 238 */   }
/* 239 */
/* 240 */
/* 241 */   private int compare_3(InternalRow a, InternalRow b) {
/* 242 */
/* 243 */     InternalRow i = null;  // Holds current row being evaluated.
/* 244 */
/* 245 */     i = a;
/* 246 */     boolean isNullA6;
/* 247 */     UTF8String primitiveA6;
/* 248 */     {
/* 249 */
/* 250 */       boolean isNull6 = i.isNullAt(6);
/* 251 */       UTF8String value6 = isNull6 ? null : (i.getUTF8String(6));
/* 252 */       isNullA6 = isNull6;
/* 253 */       primitiveA6 = value6;
/* 254 */     }
/* 255 */     i = b;
/* 256 */     boolean isNullB6;
/* 257 */     UTF8String primitiveB6;
/* 258 */     {
/* 259 */
/* 260 */       boolean isNull6 = i.isNullAt(6);
/* 261 */       UTF8String value6 = isNull6 ? null : (i.getUTF8String(6));
/* 262 */       isNullB6 = isNull6;
/* 263 */       primitiveB6 = value6;
/* 264 */     }
/* 265 */     if (isNullA6 && isNullB6) {
/* 266 */       // Nothing
/* 267 */     } else if (isNullA6) {
/* 268 */       return -1;
/* 269 */     } else if (isNullB6) {
/* 270 */       return 1;
/* 271 */     } else {
/* 272 */       int comp = primitiveA6.compare(primitiveB6);
/* 273 */       if (comp != 0) {
/* 274 */         return comp;
/* 275 */       }
/* 276 */     }
/* 277 */
/* 278 */     i = a;
/* 279 */     boolean isNullA7;
/* 280 */     UTF8String primitiveA7;
/* 281 */     {
/* 282 */
/* 283 */       boolean isNull7 = i.isNullAt(7);
/* 284 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(7));
/* 285 */       isNullA7 = isNull7;
/* 286 */       primitiveA7 = value7;
/* 287 */     }
/* 288 */     i = b;
/* 289 */     boolean isNullB7;
/* 290 */     UTF8String primitiveB7;
/* 291 */     {
/* 292 */
/* 293 */       boolean isNull7 = i.isNullAt(7);
/* 294 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(7));
/* 295 */       isNullB7 = isNull7;
/* 296 */       primitiveB7 = value7;
/* 297 */     }
/* 298 */     if (isNullA7 && isNullB7) {
/* 299 */       // Nothing
/* 300 */     } else if (isNullA7) {
/* 301 */       return -1;
/* 302 */     } else if (isNullB7) {
/* 303 */       return 1;
/* 304 */     } else {
/* 305 */       int comp = primitiveA7.compare(primitiveB7);
/* 306 */       if (comp != 0) {
/* 307 */         return comp;
/* 308 */       }
/* 309 */     }
/* 310 */
/* 311 */     return 0;
/* 312 */
/* 313 */   }
/* 314 */
/* 315 */
/* 316 */   private int compare_0(InternalRow a, InternalRow b) {
/* 317 */
/* 318 */     InternalRow i = null;  // Holds current row being evaluated.
/* 319 */
/* 320 */     i = a;
/* 321 */     boolean isNullA;
/* 322 */     UTF8String primitiveA;
/* 323 */     {
/* 324 */
/* 325 */       boolean isNull = i.isNullAt(0);
/* 326 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 327 */       isNullA = isNull;
/* 328 */       primitiveA = value;
/* 329 */     }
/* 330 */     i = b;
/* 331 */     boolean isNullB;
/* 332 */     UTF8String primitiveB;
/* 333 */     {
/* 334 */
/* 335 */       boolean isNull = i.isNullAt(0);
/* 336 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 337 */       isNullB = isNull;
/* 338 */       primitiveB = value;
/* 339 */     }
/* 340 */     if (isNullA && isNullB) {
/* 341 */       // Nothing
/* 342 */     } else if (isNullA) {
/* 343 */       return -1;
/* 344 */     } else if (isNullB) {
/* 345 */       return 1;
/* 346 */     } else {
/* 347 */       int comp = primitiveA.compare(primitiveB);
/* 348 */       if (comp != 0) {
/* 349 */         return comp;
/* 350 */       }
/* 351 */     }
/* 352 */
/* 353 */     i = a;
/* 354 */     boolean isNullA1;
/* 355 */     int primitiveA1;
/* 356 */     {
/* 357 */
/* 358 */       boolean isNull1 = i.isNullAt(1);
/* 359 */       int value1 = isNull1 ? -1 : (i.getInt(1));
/* 360 */       isNullA1 = isNull1;
/* 361 */       primitiveA1 = value1;
/* 362 */     }
/* 363 */     i = b;
/* 364 */     boolean isNullB1;
/* 365 */     int primitiveB1;
/* 366 */     {
/* 367 */
/* 368 */       boolean isNull1 = i.isNullAt(1);
/* 369 */       int value1 = isNull1 ? -1 : (i.getInt(1));
/* 370 */       isNullB1 = isNull1;
/* 371 */       primitiveB1 = value1;
/* 372 */     }
/* 373 */     if (isNullA1 && isNullB1) {
/* 374 */       // Nothing
/* 375 */     } else if (isNullA1) {
/* 376 */       return -1;
/* 377 */     } else if (isNullB1) {
/* 378 */       return 1;
/* 379 */     } else {
/* 380 */       int comp = (primitiveA1 > primitiveB1 ? 1 : primitiveA1 < primitiveB1 ? -1 : 0);
/* 381 */       if (comp != 0) {
/* 382 */         return comp;
/* 383 */       }
/* 384 */     }
/* 385 */
/* 386 */     return 0;
/* 387 */
/* 388 */   }
/* 389 */
/* 390 */
/* 391 */   public int compare(InternalRow a, InternalRow b) {
/* 392 */
/* 393 */     InternalRow i = null;
/* 394 */
/* 395 */     int comp = compare_0(a, b);
/* 396 */     if (comp != 0) {
/* 397 */       return comp;
/* 398 */     }
/* 399 */
/* 400 */     int comp1 = compare_1(a, b);
/* 401 */     if (comp1 != 0) {
/* 402 */       return comp1;
/* 403 */     }
/* 404 */
/* 405 */     int comp2 = compare_2(a, b);
/* 406 */     if (comp2 != 0) {
/* 407 */       return comp2;
/* 408 */     }
/* 409 */
/* 410 */     int comp3 = compare_3(a, b);
/* 411 */     if (comp3 != 0) {
/* 412 */       return comp3;
/* 413 */     }
/* 414 */
/* 415 */     int comp4 = compare_4(a, b);
/* 416 */     if (comp4 != 0) {
/* 417 */       return comp4;
/* 418 */     }
/* 419 */
/* 420 */
/* 421 */     return 0;
/* 422 */   }
/* 423 */ }

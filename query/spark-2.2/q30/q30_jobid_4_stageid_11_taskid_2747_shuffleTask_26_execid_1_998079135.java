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
/* 091 */   private int compare_5(InternalRow a, InternalRow b) {
/* 092 */
/* 093 */     InternalRow i = null;  // Holds current row being evaluated.
/* 094 */
/* 095 */     i = a;
/* 096 */     boolean isNullA10;
/* 097 */     UTF8String primitiveA10;
/* 098 */     {
/* 099 */
/* 100 */       boolean isNull10 = i.isNullAt(10);
/* 101 */       UTF8String value10 = isNull10 ? null : (i.getUTF8String(10));
/* 102 */       isNullA10 = isNull10;
/* 103 */       primitiveA10 = value10;
/* 104 */     }
/* 105 */     i = b;
/* 106 */     boolean isNullB10;
/* 107 */     UTF8String primitiveB10;
/* 108 */     {
/* 109 */
/* 110 */       boolean isNull10 = i.isNullAt(10);
/* 111 */       UTF8String value10 = isNull10 ? null : (i.getUTF8String(10));
/* 112 */       isNullB10 = isNull10;
/* 113 */       primitiveB10 = value10;
/* 114 */     }
/* 115 */     if (isNullA10 && isNullB10) {
/* 116 */       // Nothing
/* 117 */     } else if (isNullA10) {
/* 118 */       return -1;
/* 119 */     } else if (isNullB10) {
/* 120 */       return 1;
/* 121 */     } else {
/* 122 */       int comp = primitiveA10.compare(primitiveB10);
/* 123 */       if (comp != 0) {
/* 124 */         return comp;
/* 125 */       }
/* 126 */     }
/* 127 */
/* 128 */     i = a;
/* 129 */     boolean isNullA11;
/* 130 */     UTF8String primitiveA11;
/* 131 */     {
/* 132 */
/* 133 */       boolean isNull11 = i.isNullAt(11);
/* 134 */       UTF8String value11 = isNull11 ? null : (i.getUTF8String(11));
/* 135 */       isNullA11 = isNull11;
/* 136 */       primitiveA11 = value11;
/* 137 */     }
/* 138 */     i = b;
/* 139 */     boolean isNullB11;
/* 140 */     UTF8String primitiveB11;
/* 141 */     {
/* 142 */
/* 143 */       boolean isNull11 = i.isNullAt(11);
/* 144 */       UTF8String value11 = isNull11 ? null : (i.getUTF8String(11));
/* 145 */       isNullB11 = isNull11;
/* 146 */       primitiveB11 = value11;
/* 147 */     }
/* 148 */     if (isNullA11 && isNullB11) {
/* 149 */       // Nothing
/* 150 */     } else if (isNullA11) {
/* 151 */       return -1;
/* 152 */     } else if (isNullB11) {
/* 153 */       return 1;
/* 154 */     } else {
/* 155 */       int comp = primitiveA11.compare(primitiveB11);
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
/* 166 */   private int compare_1(InternalRow a, InternalRow b) {
/* 167 */
/* 168 */     InternalRow i = null;  // Holds current row being evaluated.
/* 169 */
/* 170 */     i = a;
/* 171 */     boolean isNullA2;
/* 172 */     UTF8String primitiveA2;
/* 173 */     {
/* 174 */
/* 175 */       boolean isNull2 = i.isNullAt(2);
/* 176 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 177 */       isNullA2 = isNull2;
/* 178 */       primitiveA2 = value2;
/* 179 */     }
/* 180 */     i = b;
/* 181 */     boolean isNullB2;
/* 182 */     UTF8String primitiveB2;
/* 183 */     {
/* 184 */
/* 185 */       boolean isNull2 = i.isNullAt(2);
/* 186 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 187 */       isNullB2 = isNull2;
/* 188 */       primitiveB2 = value2;
/* 189 */     }
/* 190 */     if (isNullA2 && isNullB2) {
/* 191 */       // Nothing
/* 192 */     } else if (isNullA2) {
/* 193 */       return -1;
/* 194 */     } else if (isNullB2) {
/* 195 */       return 1;
/* 196 */     } else {
/* 197 */       int comp = primitiveA2.compare(primitiveB2);
/* 198 */       if (comp != 0) {
/* 199 */         return comp;
/* 200 */       }
/* 201 */     }
/* 202 */
/* 203 */     i = a;
/* 204 */     boolean isNullA3;
/* 205 */     UTF8String primitiveA3;
/* 206 */     {
/* 207 */
/* 208 */       boolean isNull3 = i.isNullAt(3);
/* 209 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 210 */       isNullA3 = isNull3;
/* 211 */       primitiveA3 = value3;
/* 212 */     }
/* 213 */     i = b;
/* 214 */     boolean isNullB3;
/* 215 */     UTF8String primitiveB3;
/* 216 */     {
/* 217 */
/* 218 */       boolean isNull3 = i.isNullAt(3);
/* 219 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 220 */       isNullB3 = isNull3;
/* 221 */       primitiveB3 = value3;
/* 222 */     }
/* 223 */     if (isNullA3 && isNullB3) {
/* 224 */       // Nothing
/* 225 */     } else if (isNullA3) {
/* 226 */       return -1;
/* 227 */     } else if (isNullB3) {
/* 228 */       return 1;
/* 229 */     } else {
/* 230 */       int comp = primitiveA3.compare(primitiveB3);
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
/* 241 */   private int compare_4(InternalRow a, InternalRow b) {
/* 242 */
/* 243 */     InternalRow i = null;  // Holds current row being evaluated.
/* 244 */
/* 245 */     i = a;
/* 246 */     boolean isNullA8;
/* 247 */     UTF8String primitiveA8;
/* 248 */     {
/* 249 */
/* 250 */       boolean isNull8 = i.isNullAt(8);
/* 251 */       UTF8String value8 = isNull8 ? null : (i.getUTF8String(8));
/* 252 */       isNullA8 = isNull8;
/* 253 */       primitiveA8 = value8;
/* 254 */     }
/* 255 */     i = b;
/* 256 */     boolean isNullB8;
/* 257 */     UTF8String primitiveB8;
/* 258 */     {
/* 259 */
/* 260 */       boolean isNull8 = i.isNullAt(8);
/* 261 */       UTF8String value8 = isNull8 ? null : (i.getUTF8String(8));
/* 262 */       isNullB8 = isNull8;
/* 263 */       primitiveB8 = value8;
/* 264 */     }
/* 265 */     if (isNullA8 && isNullB8) {
/* 266 */       // Nothing
/* 267 */     } else if (isNullA8) {
/* 268 */       return -1;
/* 269 */     } else if (isNullB8) {
/* 270 */       return 1;
/* 271 */     } else {
/* 272 */       int comp = primitiveA8.compare(primitiveB8);
/* 273 */       if (comp != 0) {
/* 274 */         return comp;
/* 275 */       }
/* 276 */     }
/* 277 */
/* 278 */     i = a;
/* 279 */     boolean isNullA9;
/* 280 */     UTF8String primitiveA9;
/* 281 */     {
/* 282 */
/* 283 */       boolean isNull9 = i.isNullAt(9);
/* 284 */       UTF8String value9 = isNull9 ? null : (i.getUTF8String(9));
/* 285 */       isNullA9 = isNull9;
/* 286 */       primitiveA9 = value9;
/* 287 */     }
/* 288 */     i = b;
/* 289 */     boolean isNullB9;
/* 290 */     UTF8String primitiveB9;
/* 291 */     {
/* 292 */
/* 293 */       boolean isNull9 = i.isNullAt(9);
/* 294 */       UTF8String value9 = isNull9 ? null : (i.getUTF8String(9));
/* 295 */       isNullB9 = isNull9;
/* 296 */       primitiveB9 = value9;
/* 297 */     }
/* 298 */     if (isNullA9 && isNullB9) {
/* 299 */       // Nothing
/* 300 */     } else if (isNullA9) {
/* 301 */       return -1;
/* 302 */     } else if (isNullB9) {
/* 303 */       return 1;
/* 304 */     } else {
/* 305 */       int comp = primitiveA9.compare(primitiveB9);
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
/* 316 */   private int compare_3(InternalRow a, InternalRow b) {
/* 317 */
/* 318 */     InternalRow i = null;  // Holds current row being evaluated.
/* 319 */
/* 320 */     i = a;
/* 321 */     boolean isNullA6;
/* 322 */     int primitiveA6;
/* 323 */     {
/* 324 */
/* 325 */       boolean isNull6 = i.isNullAt(6);
/* 326 */       int value6 = isNull6 ? -1 : (i.getInt(6));
/* 327 */       isNullA6 = isNull6;
/* 328 */       primitiveA6 = value6;
/* 329 */     }
/* 330 */     i = b;
/* 331 */     boolean isNullB6;
/* 332 */     int primitiveB6;
/* 333 */     {
/* 334 */
/* 335 */       boolean isNull6 = i.isNullAt(6);
/* 336 */       int value6 = isNull6 ? -1 : (i.getInt(6));
/* 337 */       isNullB6 = isNull6;
/* 338 */       primitiveB6 = value6;
/* 339 */     }
/* 340 */     if (isNullA6 && isNullB6) {
/* 341 */       // Nothing
/* 342 */     } else if (isNullA6) {
/* 343 */       return -1;
/* 344 */     } else if (isNullB6) {
/* 345 */       return 1;
/* 346 */     } else {
/* 347 */       int comp = (primitiveA6 > primitiveB6 ? 1 : primitiveA6 < primitiveB6 ? -1 : 0);
/* 348 */       if (comp != 0) {
/* 349 */         return comp;
/* 350 */       }
/* 351 */     }
/* 352 */
/* 353 */     i = a;
/* 354 */     boolean isNullA7;
/* 355 */     int primitiveA7;
/* 356 */     {
/* 357 */
/* 358 */       boolean isNull7 = i.isNullAt(7);
/* 359 */       int value7 = isNull7 ? -1 : (i.getInt(7));
/* 360 */       isNullA7 = isNull7;
/* 361 */       primitiveA7 = value7;
/* 362 */     }
/* 363 */     i = b;
/* 364 */     boolean isNullB7;
/* 365 */     int primitiveB7;
/* 366 */     {
/* 367 */
/* 368 */       boolean isNull7 = i.isNullAt(7);
/* 369 */       int value7 = isNull7 ? -1 : (i.getInt(7));
/* 370 */       isNullB7 = isNull7;
/* 371 */       primitiveB7 = value7;
/* 372 */     }
/* 373 */     if (isNullA7 && isNullB7) {
/* 374 */       // Nothing
/* 375 */     } else if (isNullA7) {
/* 376 */       return -1;
/* 377 */     } else if (isNullB7) {
/* 378 */       return 1;
/* 379 */     } else {
/* 380 */       int comp = (primitiveA7 > primitiveB7 ? 1 : primitiveA7 < primitiveB7 ? -1 : 0);
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
/* 391 */   private int compare_6(InternalRow a, InternalRow b) {
/* 392 */
/* 393 */     InternalRow i = null;  // Holds current row being evaluated.
/* 394 */
/* 395 */     i = a;
/* 396 */     boolean isNullA12;
/* 397 */     double primitiveA12;
/* 398 */     {
/* 399 */
/* 400 */       boolean isNull12 = i.isNullAt(12);
/* 401 */       double value12 = isNull12 ? -1.0 : (i.getDouble(12));
/* 402 */       isNullA12 = isNull12;
/* 403 */       primitiveA12 = value12;
/* 404 */     }
/* 405 */     i = b;
/* 406 */     boolean isNullB12;
/* 407 */     double primitiveB12;
/* 408 */     {
/* 409 */
/* 410 */       boolean isNull12 = i.isNullAt(12);
/* 411 */       double value12 = isNull12 ? -1.0 : (i.getDouble(12));
/* 412 */       isNullB12 = isNull12;
/* 413 */       primitiveB12 = value12;
/* 414 */     }
/* 415 */     if (isNullA12 && isNullB12) {
/* 416 */       // Nothing
/* 417 */     } else if (isNullA12) {
/* 418 */       return -1;
/* 419 */     } else if (isNullB12) {
/* 420 */       return 1;
/* 421 */     } else {
/* 422 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA12, primitiveB12);
/* 423 */       if (comp != 0) {
/* 424 */         return comp;
/* 425 */       }
/* 426 */     }
/* 427 */
/* 428 */     return 0;
/* 429 */
/* 430 */   }
/* 431 */
/* 432 */
/* 433 */   private int compare_0(InternalRow a, InternalRow b) {
/* 434 */
/* 435 */     InternalRow i = null;  // Holds current row being evaluated.
/* 436 */
/* 437 */     i = a;
/* 438 */     boolean isNullA;
/* 439 */     UTF8String primitiveA;
/* 440 */     {
/* 441 */
/* 442 */       boolean isNull = i.isNullAt(0);
/* 443 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 444 */       isNullA = isNull;
/* 445 */       primitiveA = value;
/* 446 */     }
/* 447 */     i = b;
/* 448 */     boolean isNullB;
/* 449 */     UTF8String primitiveB;
/* 450 */     {
/* 451 */
/* 452 */       boolean isNull = i.isNullAt(0);
/* 453 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 454 */       isNullB = isNull;
/* 455 */       primitiveB = value;
/* 456 */     }
/* 457 */     if (isNullA && isNullB) {
/* 458 */       // Nothing
/* 459 */     } else if (isNullA) {
/* 460 */       return -1;
/* 461 */     } else if (isNullB) {
/* 462 */       return 1;
/* 463 */     } else {
/* 464 */       int comp = primitiveA.compare(primitiveB);
/* 465 */       if (comp != 0) {
/* 466 */         return comp;
/* 467 */       }
/* 468 */     }
/* 469 */
/* 470 */     i = a;
/* 471 */     boolean isNullA1;
/* 472 */     UTF8String primitiveA1;
/* 473 */     {
/* 474 */
/* 475 */       boolean isNull1 = i.isNullAt(1);
/* 476 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 477 */       isNullA1 = isNull1;
/* 478 */       primitiveA1 = value1;
/* 479 */     }
/* 480 */     i = b;
/* 481 */     boolean isNullB1;
/* 482 */     UTF8String primitiveB1;
/* 483 */     {
/* 484 */
/* 485 */       boolean isNull1 = i.isNullAt(1);
/* 486 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 487 */       isNullB1 = isNull1;
/* 488 */       primitiveB1 = value1;
/* 489 */     }
/* 490 */     if (isNullA1 && isNullB1) {
/* 491 */       // Nothing
/* 492 */     } else if (isNullA1) {
/* 493 */       return -1;
/* 494 */     } else if (isNullB1) {
/* 495 */       return 1;
/* 496 */     } else {
/* 497 */       int comp = primitiveA1.compare(primitiveB1);
/* 498 */       if (comp != 0) {
/* 499 */         return comp;
/* 500 */       }
/* 501 */     }
/* 502 */
/* 503 */     return 0;
/* 504 */
/* 505 */   }
/* 506 */
/* 507 */
/* 508 */   public int compare(InternalRow a, InternalRow b) {
/* 509 */
/* 510 */     InternalRow i = null;
/* 511 */
/* 512 */     int comp = compare_0(a, b);
/* 513 */     if (comp != 0) {
/* 514 */       return comp;
/* 515 */     }
/* 516 */
/* 517 */     int comp1 = compare_1(a, b);
/* 518 */     if (comp1 != 0) {
/* 519 */       return comp1;
/* 520 */     }
/* 521 */
/* 522 */     int comp2 = compare_2(a, b);
/* 523 */     if (comp2 != 0) {
/* 524 */       return comp2;
/* 525 */     }
/* 526 */
/* 527 */     int comp3 = compare_3(a, b);
/* 528 */     if (comp3 != 0) {
/* 529 */       return comp3;
/* 530 */     }
/* 531 */
/* 532 */     int comp4 = compare_4(a, b);
/* 533 */     if (comp4 != 0) {
/* 534 */       return comp4;
/* 535 */     }
/* 536 */
/* 537 */     int comp5 = compare_5(a, b);
/* 538 */     if (comp5 != 0) {
/* 539 */       return comp5;
/* 540 */     }
/* 541 */
/* 542 */     int comp6 = compare_6(a, b);
/* 543 */     if (comp6 != 0) {
/* 544 */       return comp6;
/* 545 */     }
/* 546 */
/* 547 */
/* 548 */     return 0;
/* 549 */   }
/* 550 */ }

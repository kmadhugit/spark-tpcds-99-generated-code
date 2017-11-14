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
/* 166 */   private int compare_7(InternalRow a, InternalRow b) {
/* 167 */
/* 168 */     InternalRow i = null;  // Holds current row being evaluated.
/* 169 */
/* 170 */     i = a;
/* 171 */     boolean isNullA14;
/* 172 */     UTF8String primitiveA14;
/* 173 */     {
/* 174 */
/* 175 */       boolean isNull14 = i.isNullAt(14);
/* 176 */       UTF8String value14 = isNull14 ? null : (i.getUTF8String(14));
/* 177 */       isNullA14 = isNull14;
/* 178 */       primitiveA14 = value14;
/* 179 */     }
/* 180 */     i = b;
/* 181 */     boolean isNullB14;
/* 182 */     UTF8String primitiveB14;
/* 183 */     {
/* 184 */
/* 185 */       boolean isNull14 = i.isNullAt(14);
/* 186 */       UTF8String value14 = isNull14 ? null : (i.getUTF8String(14));
/* 187 */       isNullB14 = isNull14;
/* 188 */       primitiveB14 = value14;
/* 189 */     }
/* 190 */     if (isNullA14 && isNullB14) {
/* 191 */       // Nothing
/* 192 */     } else if (isNullA14) {
/* 193 */       return -1;
/* 194 */     } else if (isNullB14) {
/* 195 */       return 1;
/* 196 */     } else {
/* 197 */       int comp = primitiveA14.compare(primitiveB14);
/* 198 */       if (comp != 0) {
/* 199 */         return comp;
/* 200 */       }
/* 201 */     }
/* 202 */
/* 203 */     i = a;
/* 204 */     boolean isNullA15;
/* 205 */     double primitiveA15;
/* 206 */     {
/* 207 */
/* 208 */       boolean isNull15 = i.isNullAt(15);
/* 209 */       double value15 = isNull15 ? -1.0 : (i.getDouble(15));
/* 210 */       isNullA15 = isNull15;
/* 211 */       primitiveA15 = value15;
/* 212 */     }
/* 213 */     i = b;
/* 214 */     boolean isNullB15;
/* 215 */     double primitiveB15;
/* 216 */     {
/* 217 */
/* 218 */       boolean isNull15 = i.isNullAt(15);
/* 219 */       double value15 = isNull15 ? -1.0 : (i.getDouble(15));
/* 220 */       isNullB15 = isNull15;
/* 221 */       primitiveB15 = value15;
/* 222 */     }
/* 223 */     if (isNullA15 && isNullB15) {
/* 224 */       // Nothing
/* 225 */     } else if (isNullA15) {
/* 226 */       return -1;
/* 227 */     } else if (isNullB15) {
/* 228 */       return 1;
/* 229 */     } else {
/* 230 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA15, primitiveB15);
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
/* 241 */   private int compare_1(InternalRow a, InternalRow b) {
/* 242 */
/* 243 */     InternalRow i = null;  // Holds current row being evaluated.
/* 244 */
/* 245 */     i = a;
/* 246 */     boolean isNullA2;
/* 247 */     UTF8String primitiveA2;
/* 248 */     {
/* 249 */
/* 250 */       boolean isNull2 = i.isNullAt(2);
/* 251 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 252 */       isNullA2 = isNull2;
/* 253 */       primitiveA2 = value2;
/* 254 */     }
/* 255 */     i = b;
/* 256 */     boolean isNullB2;
/* 257 */     UTF8String primitiveB2;
/* 258 */     {
/* 259 */
/* 260 */       boolean isNull2 = i.isNullAt(2);
/* 261 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 262 */       isNullB2 = isNull2;
/* 263 */       primitiveB2 = value2;
/* 264 */     }
/* 265 */     if (isNullA2 && isNullB2) {
/* 266 */       // Nothing
/* 267 */     } else if (isNullA2) {
/* 268 */       return -1;
/* 269 */     } else if (isNullB2) {
/* 270 */       return 1;
/* 271 */     } else {
/* 272 */       int comp = primitiveA2.compare(primitiveB2);
/* 273 */       if (comp != 0) {
/* 274 */         return comp;
/* 275 */       }
/* 276 */     }
/* 277 */
/* 278 */     i = a;
/* 279 */     boolean isNullA3;
/* 280 */     UTF8String primitiveA3;
/* 281 */     {
/* 282 */
/* 283 */       boolean isNull3 = i.isNullAt(3);
/* 284 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 285 */       isNullA3 = isNull3;
/* 286 */       primitiveA3 = value3;
/* 287 */     }
/* 288 */     i = b;
/* 289 */     boolean isNullB3;
/* 290 */     UTF8String primitiveB3;
/* 291 */     {
/* 292 */
/* 293 */       boolean isNull3 = i.isNullAt(3);
/* 294 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 295 */       isNullB3 = isNull3;
/* 296 */       primitiveB3 = value3;
/* 297 */     }
/* 298 */     if (isNullA3 && isNullB3) {
/* 299 */       // Nothing
/* 300 */     } else if (isNullA3) {
/* 301 */       return -1;
/* 302 */     } else if (isNullB3) {
/* 303 */       return 1;
/* 304 */     } else {
/* 305 */       int comp = primitiveA3.compare(primitiveB3);
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
/* 316 */   private int compare_4(InternalRow a, InternalRow b) {
/* 317 */
/* 318 */     InternalRow i = null;  // Holds current row being evaluated.
/* 319 */
/* 320 */     i = a;
/* 321 */     boolean isNullA8;
/* 322 */     UTF8String primitiveA8;
/* 323 */     {
/* 324 */
/* 325 */       boolean isNull8 = i.isNullAt(8);
/* 326 */       UTF8String value8 = isNull8 ? null : (i.getUTF8String(8));
/* 327 */       isNullA8 = isNull8;
/* 328 */       primitiveA8 = value8;
/* 329 */     }
/* 330 */     i = b;
/* 331 */     boolean isNullB8;
/* 332 */     UTF8String primitiveB8;
/* 333 */     {
/* 334 */
/* 335 */       boolean isNull8 = i.isNullAt(8);
/* 336 */       UTF8String value8 = isNull8 ? null : (i.getUTF8String(8));
/* 337 */       isNullB8 = isNull8;
/* 338 */       primitiveB8 = value8;
/* 339 */     }
/* 340 */     if (isNullA8 && isNullB8) {
/* 341 */       // Nothing
/* 342 */     } else if (isNullA8) {
/* 343 */       return -1;
/* 344 */     } else if (isNullB8) {
/* 345 */       return 1;
/* 346 */     } else {
/* 347 */       int comp = primitiveA8.compare(primitiveB8);
/* 348 */       if (comp != 0) {
/* 349 */         return comp;
/* 350 */       }
/* 351 */     }
/* 352 */
/* 353 */     i = a;
/* 354 */     boolean isNullA9;
/* 355 */     UTF8String primitiveA9;
/* 356 */     {
/* 357 */
/* 358 */       boolean isNull9 = i.isNullAt(9);
/* 359 */       UTF8String value9 = isNull9 ? null : (i.getUTF8String(9));
/* 360 */       isNullA9 = isNull9;
/* 361 */       primitiveA9 = value9;
/* 362 */     }
/* 363 */     i = b;
/* 364 */     boolean isNullB9;
/* 365 */     UTF8String primitiveB9;
/* 366 */     {
/* 367 */
/* 368 */       boolean isNull9 = i.isNullAt(9);
/* 369 */       UTF8String value9 = isNull9 ? null : (i.getUTF8String(9));
/* 370 */       isNullB9 = isNull9;
/* 371 */       primitiveB9 = value9;
/* 372 */     }
/* 373 */     if (isNullA9 && isNullB9) {
/* 374 */       // Nothing
/* 375 */     } else if (isNullA9) {
/* 376 */       return -1;
/* 377 */     } else if (isNullB9) {
/* 378 */       return 1;
/* 379 */     } else {
/* 380 */       int comp = primitiveA9.compare(primitiveB9);
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
/* 391 */   private int compare_3(InternalRow a, InternalRow b) {
/* 392 */
/* 393 */     InternalRow i = null;  // Holds current row being evaluated.
/* 394 */
/* 395 */     i = a;
/* 396 */     boolean isNullA6;
/* 397 */     UTF8String primitiveA6;
/* 398 */     {
/* 399 */
/* 400 */       boolean isNull6 = i.isNullAt(6);
/* 401 */       UTF8String value6 = isNull6 ? null : (i.getUTF8String(6));
/* 402 */       isNullA6 = isNull6;
/* 403 */       primitiveA6 = value6;
/* 404 */     }
/* 405 */     i = b;
/* 406 */     boolean isNullB6;
/* 407 */     UTF8String primitiveB6;
/* 408 */     {
/* 409 */
/* 410 */       boolean isNull6 = i.isNullAt(6);
/* 411 */       UTF8String value6 = isNull6 ? null : (i.getUTF8String(6));
/* 412 */       isNullB6 = isNull6;
/* 413 */       primitiveB6 = value6;
/* 414 */     }
/* 415 */     if (isNullA6 && isNullB6) {
/* 416 */       // Nothing
/* 417 */     } else if (isNullA6) {
/* 418 */       return -1;
/* 419 */     } else if (isNullB6) {
/* 420 */       return 1;
/* 421 */     } else {
/* 422 */       int comp = primitiveA6.compare(primitiveB6);
/* 423 */       if (comp != 0) {
/* 424 */         return comp;
/* 425 */       }
/* 426 */     }
/* 427 */
/* 428 */     i = a;
/* 429 */     boolean isNullA7;
/* 430 */     UTF8String primitiveA7;
/* 431 */     {
/* 432 */
/* 433 */       boolean isNull7 = i.isNullAt(7);
/* 434 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(7));
/* 435 */       isNullA7 = isNull7;
/* 436 */       primitiveA7 = value7;
/* 437 */     }
/* 438 */     i = b;
/* 439 */     boolean isNullB7;
/* 440 */     UTF8String primitiveB7;
/* 441 */     {
/* 442 */
/* 443 */       boolean isNull7 = i.isNullAt(7);
/* 444 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(7));
/* 445 */       isNullB7 = isNull7;
/* 446 */       primitiveB7 = value7;
/* 447 */     }
/* 448 */     if (isNullA7 && isNullB7) {
/* 449 */       // Nothing
/* 450 */     } else if (isNullA7) {
/* 451 */       return -1;
/* 452 */     } else if (isNullB7) {
/* 453 */       return 1;
/* 454 */     } else {
/* 455 */       int comp = primitiveA7.compare(primitiveB7);
/* 456 */       if (comp != 0) {
/* 457 */         return comp;
/* 458 */       }
/* 459 */     }
/* 460 */
/* 461 */     return 0;
/* 462 */
/* 463 */   }
/* 464 */
/* 465 */
/* 466 */   private int compare_6(InternalRow a, InternalRow b) {
/* 467 */
/* 468 */     InternalRow i = null;  // Holds current row being evaluated.
/* 469 */
/* 470 */     i = a;
/* 471 */     boolean isNullA12;
/* 472 */     UTF8String primitiveA12;
/* 473 */     {
/* 474 */
/* 475 */       boolean isNull12 = i.isNullAt(12);
/* 476 */       UTF8String value12 = isNull12 ? null : (i.getUTF8String(12));
/* 477 */       isNullA12 = isNull12;
/* 478 */       primitiveA12 = value12;
/* 479 */     }
/* 480 */     i = b;
/* 481 */     boolean isNullB12;
/* 482 */     UTF8String primitiveB12;
/* 483 */     {
/* 484 */
/* 485 */       boolean isNull12 = i.isNullAt(12);
/* 486 */       UTF8String value12 = isNull12 ? null : (i.getUTF8String(12));
/* 487 */       isNullB12 = isNull12;
/* 488 */       primitiveB12 = value12;
/* 489 */     }
/* 490 */     if (isNullA12 && isNullB12) {
/* 491 */       // Nothing
/* 492 */     } else if (isNullA12) {
/* 493 */       return -1;
/* 494 */     } else if (isNullB12) {
/* 495 */       return 1;
/* 496 */     } else {
/* 497 */       int comp = primitiveA12.compare(primitiveB12);
/* 498 */       if (comp != 0) {
/* 499 */         return comp;
/* 500 */       }
/* 501 */     }
/* 502 */
/* 503 */     i = a;
/* 504 */     boolean isNullA13;
/* 505 */     double primitiveA13;
/* 506 */     {
/* 507 */
/* 508 */       boolean isNull13 = i.isNullAt(13);
/* 509 */       double value13 = isNull13 ? -1.0 : (i.getDouble(13));
/* 510 */       isNullA13 = isNull13;
/* 511 */       primitiveA13 = value13;
/* 512 */     }
/* 513 */     i = b;
/* 514 */     boolean isNullB13;
/* 515 */     double primitiveB13;
/* 516 */     {
/* 517 */
/* 518 */       boolean isNull13 = i.isNullAt(13);
/* 519 */       double value13 = isNull13 ? -1.0 : (i.getDouble(13));
/* 520 */       isNullB13 = isNull13;
/* 521 */       primitiveB13 = value13;
/* 522 */     }
/* 523 */     if (isNullA13 && isNullB13) {
/* 524 */       // Nothing
/* 525 */     } else if (isNullA13) {
/* 526 */       return -1;
/* 527 */     } else if (isNullB13) {
/* 528 */       return 1;
/* 529 */     } else {
/* 530 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA13, primitiveB13);
/* 531 */       if (comp != 0) {
/* 532 */         return comp;
/* 533 */       }
/* 534 */     }
/* 535 */
/* 536 */     return 0;
/* 537 */
/* 538 */   }
/* 539 */
/* 540 */
/* 541 */   private int compare_0(InternalRow a, InternalRow b) {
/* 542 */
/* 543 */     InternalRow i = null;  // Holds current row being evaluated.
/* 544 */
/* 545 */     i = a;
/* 546 */     boolean isNullA;
/* 547 */     UTF8String primitiveA;
/* 548 */     {
/* 549 */
/* 550 */       boolean isNull = i.isNullAt(0);
/* 551 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 552 */       isNullA = isNull;
/* 553 */       primitiveA = value;
/* 554 */     }
/* 555 */     i = b;
/* 556 */     boolean isNullB;
/* 557 */     UTF8String primitiveB;
/* 558 */     {
/* 559 */
/* 560 */       boolean isNull = i.isNullAt(0);
/* 561 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 562 */       isNullB = isNull;
/* 563 */       primitiveB = value;
/* 564 */     }
/* 565 */     if (isNullA && isNullB) {
/* 566 */       // Nothing
/* 567 */     } else if (isNullA) {
/* 568 */       return -1;
/* 569 */     } else if (isNullB) {
/* 570 */       return 1;
/* 571 */     } else {
/* 572 */       int comp = primitiveA.compare(primitiveB);
/* 573 */       if (comp != 0) {
/* 574 */         return comp;
/* 575 */       }
/* 576 */     }
/* 577 */
/* 578 */     i = a;
/* 579 */     boolean isNullA1;
/* 580 */     UTF8String primitiveA1;
/* 581 */     {
/* 582 */
/* 583 */       boolean isNull1 = i.isNullAt(1);
/* 584 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 585 */       isNullA1 = isNull1;
/* 586 */       primitiveA1 = value1;
/* 587 */     }
/* 588 */     i = b;
/* 589 */     boolean isNullB1;
/* 590 */     UTF8String primitiveB1;
/* 591 */     {
/* 592 */
/* 593 */       boolean isNull1 = i.isNullAt(1);
/* 594 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 595 */       isNullB1 = isNull1;
/* 596 */       primitiveB1 = value1;
/* 597 */     }
/* 598 */     if (isNullA1 && isNullB1) {
/* 599 */       // Nothing
/* 600 */     } else if (isNullA1) {
/* 601 */       return -1;
/* 602 */     } else if (isNullB1) {
/* 603 */       return 1;
/* 604 */     } else {
/* 605 */       int comp = primitiveA1.compare(primitiveB1);
/* 606 */       if (comp != 0) {
/* 607 */         return comp;
/* 608 */       }
/* 609 */     }
/* 610 */
/* 611 */     return 0;
/* 612 */
/* 613 */   }
/* 614 */
/* 615 */
/* 616 */   public int compare(InternalRow a, InternalRow b) {
/* 617 */
/* 618 */     InternalRow i = null;
/* 619 */
/* 620 */     int comp = compare_0(a, b);
/* 621 */     if (comp != 0) {
/* 622 */       return comp;
/* 623 */     }
/* 624 */
/* 625 */     int comp1 = compare_1(a, b);
/* 626 */     if (comp1 != 0) {
/* 627 */       return comp1;
/* 628 */     }
/* 629 */
/* 630 */     int comp2 = compare_2(a, b);
/* 631 */     if (comp2 != 0) {
/* 632 */       return comp2;
/* 633 */     }
/* 634 */
/* 635 */     int comp3 = compare_3(a, b);
/* 636 */     if (comp3 != 0) {
/* 637 */       return comp3;
/* 638 */     }
/* 639 */
/* 640 */     int comp4 = compare_4(a, b);
/* 641 */     if (comp4 != 0) {
/* 642 */       return comp4;
/* 643 */     }
/* 644 */
/* 645 */     int comp5 = compare_5(a, b);
/* 646 */     if (comp5 != 0) {
/* 647 */       return comp5;
/* 648 */     }
/* 649 */
/* 650 */     int comp6 = compare_6(a, b);
/* 651 */     if (comp6 != 0) {
/* 652 */       return comp6;
/* 653 */     }
/* 654 */
/* 655 */     int comp7 = compare_7(a, b);
/* 656 */     if (comp7 != 0) {
/* 657 */       return comp7;
/* 658 */     }
/* 659 */
/* 660 */
/* 661 */     return 0;
/* 662 */   }
/* 663 */ }

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
/* 022 */     UTF8String primitiveA;
/* 023 */     {
/* 024 */
/* 025 */       boolean isNull = i.isNullAt(0);
/* 026 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
/* 027 */       isNullA = isNull;
/* 028 */       primitiveA = value;
/* 029 */     }
/* 030 */     i = b;
/* 031 */     boolean isNullB;
/* 032 */     UTF8String primitiveB;
/* 033 */     {
/* 034 */
/* 035 */       boolean isNull = i.isNullAt(0);
/* 036 */       UTF8String value = isNull ? null : (i.getUTF8String(0));
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
/* 047 */       int comp = primitiveA.compare(primitiveB);
/* 048 */       if (comp != 0) {
/* 049 */         return comp;
/* 050 */       }
/* 051 */     }
/* 052 */
/* 053 */
/* 054 */     i = a;
/* 055 */     boolean isNullA1;
/* 056 */     UTF8String primitiveA1;
/* 057 */     {
/* 058 */
/* 059 */       boolean isNull1 = i.isNullAt(1);
/* 060 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 061 */       isNullA1 = isNull1;
/* 062 */       primitiveA1 = value1;
/* 063 */     }
/* 064 */     i = b;
/* 065 */     boolean isNullB1;
/* 066 */     UTF8String primitiveB1;
/* 067 */     {
/* 068 */
/* 069 */       boolean isNull1 = i.isNullAt(1);
/* 070 */       UTF8String value1 = isNull1 ? null : (i.getUTF8String(1));
/* 071 */       isNullB1 = isNull1;
/* 072 */       primitiveB1 = value1;
/* 073 */     }
/* 074 */     if (isNullA1 && isNullB1) {
/* 075 */       // Nothing
/* 076 */     } else if (isNullA1) {
/* 077 */       return -1;
/* 078 */     } else if (isNullB1) {
/* 079 */       return 1;
/* 080 */     } else {
/* 081 */       int comp = primitiveA1.compare(primitiveB1);
/* 082 */       if (comp != 0) {
/* 083 */         return comp;
/* 084 */       }
/* 085 */     }
/* 086 */
/* 087 */
/* 088 */     i = a;
/* 089 */     boolean isNullA2;
/* 090 */     UTF8String primitiveA2;
/* 091 */     {
/* 092 */
/* 093 */       boolean isNull2 = i.isNullAt(2);
/* 094 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 095 */       isNullA2 = isNull2;
/* 096 */       primitiveA2 = value2;
/* 097 */     }
/* 098 */     i = b;
/* 099 */     boolean isNullB2;
/* 100 */     UTF8String primitiveB2;
/* 101 */     {
/* 102 */
/* 103 */       boolean isNull2 = i.isNullAt(2);
/* 104 */       UTF8String value2 = isNull2 ? null : (i.getUTF8String(2));
/* 105 */       isNullB2 = isNull2;
/* 106 */       primitiveB2 = value2;
/* 107 */     }
/* 108 */     if (isNullA2 && isNullB2) {
/* 109 */       // Nothing
/* 110 */     } else if (isNullA2) {
/* 111 */       return -1;
/* 112 */     } else if (isNullB2) {
/* 113 */       return 1;
/* 114 */     } else {
/* 115 */       int comp = primitiveA2.compare(primitiveB2);
/* 116 */       if (comp != 0) {
/* 117 */         return comp;
/* 118 */       }
/* 119 */     }
/* 120 */
/* 121 */
/* 122 */     i = a;
/* 123 */     boolean isNullA3;
/* 124 */     UTF8String primitiveA3;
/* 125 */     {
/* 126 */
/* 127 */       boolean isNull3 = i.isNullAt(3);
/* 128 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 129 */       isNullA3 = isNull3;
/* 130 */       primitiveA3 = value3;
/* 131 */     }
/* 132 */     i = b;
/* 133 */     boolean isNullB3;
/* 134 */     UTF8String primitiveB3;
/* 135 */     {
/* 136 */
/* 137 */       boolean isNull3 = i.isNullAt(3);
/* 138 */       UTF8String value3 = isNull3 ? null : (i.getUTF8String(3));
/* 139 */       isNullB3 = isNull3;
/* 140 */       primitiveB3 = value3;
/* 141 */     }
/* 142 */     if (isNullA3 && isNullB3) {
/* 143 */       // Nothing
/* 144 */     } else if (isNullA3) {
/* 145 */       return -1;
/* 146 */     } else if (isNullB3) {
/* 147 */       return 1;
/* 148 */     } else {
/* 149 */       int comp = primitiveA3.compare(primitiveB3);
/* 150 */       if (comp != 0) {
/* 151 */         return comp;
/* 152 */       }
/* 153 */     }
/* 154 */
/* 155 */
/* 156 */     i = a;
/* 157 */     boolean isNullA4;
/* 158 */     UTF8String primitiveA4;
/* 159 */     {
/* 160 */
/* 161 */       boolean isNull4 = i.isNullAt(4);
/* 162 */       UTF8String value4 = isNull4 ? null : (i.getUTF8String(4));
/* 163 */       isNullA4 = isNull4;
/* 164 */       primitiveA4 = value4;
/* 165 */     }
/* 166 */     i = b;
/* 167 */     boolean isNullB4;
/* 168 */     UTF8String primitiveB4;
/* 169 */     {
/* 170 */
/* 171 */       boolean isNull4 = i.isNullAt(4);
/* 172 */       UTF8String value4 = isNull4 ? null : (i.getUTF8String(4));
/* 173 */       isNullB4 = isNull4;
/* 174 */       primitiveB4 = value4;
/* 175 */     }
/* 176 */     if (isNullA4 && isNullB4) {
/* 177 */       // Nothing
/* 178 */     } else if (isNullA4) {
/* 179 */       return -1;
/* 180 */     } else if (isNullB4) {
/* 181 */       return 1;
/* 182 */     } else {
/* 183 */       int comp = primitiveA4.compare(primitiveB4);
/* 184 */       if (comp != 0) {
/* 185 */         return comp;
/* 186 */       }
/* 187 */     }
/* 188 */
/* 189 */
/* 190 */     i = a;
/* 191 */     boolean isNullA5;
/* 192 */     UTF8String primitiveA5;
/* 193 */     {
/* 194 */
/* 195 */       boolean isNull5 = i.isNullAt(5);
/* 196 */       UTF8String value5 = isNull5 ? null : (i.getUTF8String(5));
/* 197 */       isNullA5 = isNull5;
/* 198 */       primitiveA5 = value5;
/* 199 */     }
/* 200 */     i = b;
/* 201 */     boolean isNullB5;
/* 202 */     UTF8String primitiveB5;
/* 203 */     {
/* 204 */
/* 205 */       boolean isNull5 = i.isNullAt(5);
/* 206 */       UTF8String value5 = isNull5 ? null : (i.getUTF8String(5));
/* 207 */       isNullB5 = isNull5;
/* 208 */       primitiveB5 = value5;
/* 209 */     }
/* 210 */     if (isNullA5 && isNullB5) {
/* 211 */       // Nothing
/* 212 */     } else if (isNullA5) {
/* 213 */       return -1;
/* 214 */     } else if (isNullB5) {
/* 215 */       return 1;
/* 216 */     } else {
/* 217 */       int comp = primitiveA5.compare(primitiveB5);
/* 218 */       if (comp != 0) {
/* 219 */         return comp;
/* 220 */       }
/* 221 */     }
/* 222 */
/* 223 */
/* 224 */     i = a;
/* 225 */     boolean isNullA6;
/* 226 */     UTF8String primitiveA6;
/* 227 */     {
/* 228 */
/* 229 */       boolean isNull6 = i.isNullAt(6);
/* 230 */       UTF8String value6 = isNull6 ? null : (i.getUTF8String(6));
/* 231 */       isNullA6 = isNull6;
/* 232 */       primitiveA6 = value6;
/* 233 */     }
/* 234 */     i = b;
/* 235 */     boolean isNullB6;
/* 236 */     UTF8String primitiveB6;
/* 237 */     {
/* 238 */
/* 239 */       boolean isNull6 = i.isNullAt(6);
/* 240 */       UTF8String value6 = isNull6 ? null : (i.getUTF8String(6));
/* 241 */       isNullB6 = isNull6;
/* 242 */       primitiveB6 = value6;
/* 243 */     }
/* 244 */     if (isNullA6 && isNullB6) {
/* 245 */       // Nothing
/* 246 */     } else if (isNullA6) {
/* 247 */       return -1;
/* 248 */     } else if (isNullB6) {
/* 249 */       return 1;
/* 250 */     } else {
/* 251 */       int comp = primitiveA6.compare(primitiveB6);
/* 252 */       if (comp != 0) {
/* 253 */         return comp;
/* 254 */       }
/* 255 */     }
/* 256 */
/* 257 */
/* 258 */     i = a;
/* 259 */     boolean isNullA7;
/* 260 */     UTF8String primitiveA7;
/* 261 */     {
/* 262 */
/* 263 */       boolean isNull7 = i.isNullAt(7);
/* 264 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(7));
/* 265 */       isNullA7 = isNull7;
/* 266 */       primitiveA7 = value7;
/* 267 */     }
/* 268 */     i = b;
/* 269 */     boolean isNullB7;
/* 270 */     UTF8String primitiveB7;
/* 271 */     {
/* 272 */
/* 273 */       boolean isNull7 = i.isNullAt(7);
/* 274 */       UTF8String value7 = isNull7 ? null : (i.getUTF8String(7));
/* 275 */       isNullB7 = isNull7;
/* 276 */       primitiveB7 = value7;
/* 277 */     }
/* 278 */     if (isNullA7 && isNullB7) {
/* 279 */       // Nothing
/* 280 */     } else if (isNullA7) {
/* 281 */       return -1;
/* 282 */     } else if (isNullB7) {
/* 283 */       return 1;
/* 284 */     } else {
/* 285 */       int comp = primitiveA7.compare(primitiveB7);
/* 286 */       if (comp != 0) {
/* 287 */         return comp;
/* 288 */       }
/* 289 */     }
/* 290 */
/* 291 */
/* 292 */     i = a;
/* 293 */     boolean isNullA8;
/* 294 */     UTF8String primitiveA8;
/* 295 */     {
/* 296 */
/* 297 */       boolean isNull8 = i.isNullAt(8);
/* 298 */       UTF8String value8 = isNull8 ? null : (i.getUTF8String(8));
/* 299 */       isNullA8 = isNull8;
/* 300 */       primitiveA8 = value8;
/* 301 */     }
/* 302 */     i = b;
/* 303 */     boolean isNullB8;
/* 304 */     UTF8String primitiveB8;
/* 305 */     {
/* 306 */
/* 307 */       boolean isNull8 = i.isNullAt(8);
/* 308 */       UTF8String value8 = isNull8 ? null : (i.getUTF8String(8));
/* 309 */       isNullB8 = isNull8;
/* 310 */       primitiveB8 = value8;
/* 311 */     }
/* 312 */     if (isNullA8 && isNullB8) {
/* 313 */       // Nothing
/* 314 */     } else if (isNullA8) {
/* 315 */       return -1;
/* 316 */     } else if (isNullB8) {
/* 317 */       return 1;
/* 318 */     } else {
/* 319 */       int comp = primitiveA8.compare(primitiveB8);
/* 320 */       if (comp != 0) {
/* 321 */         return comp;
/* 322 */       }
/* 323 */     }
/* 324 */
/* 325 */
/* 326 */     i = a;
/* 327 */     boolean isNullA9;
/* 328 */     UTF8String primitiveA9;
/* 329 */     {
/* 330 */
/* 331 */       boolean isNull9 = i.isNullAt(9);
/* 332 */       UTF8String value9 = isNull9 ? null : (i.getUTF8String(9));
/* 333 */       isNullA9 = isNull9;
/* 334 */       primitiveA9 = value9;
/* 335 */     }
/* 336 */     i = b;
/* 337 */     boolean isNullB9;
/* 338 */     UTF8String primitiveB9;
/* 339 */     {
/* 340 */
/* 341 */       boolean isNull9 = i.isNullAt(9);
/* 342 */       UTF8String value9 = isNull9 ? null : (i.getUTF8String(9));
/* 343 */       isNullB9 = isNull9;
/* 344 */       primitiveB9 = value9;
/* 345 */     }
/* 346 */     if (isNullA9 && isNullB9) {
/* 347 */       // Nothing
/* 348 */     } else if (isNullA9) {
/* 349 */       return -1;
/* 350 */     } else if (isNullB9) {
/* 351 */       return 1;
/* 352 */     } else {
/* 353 */       int comp = primitiveA9.compare(primitiveB9);
/* 354 */       if (comp != 0) {
/* 355 */         return comp;
/* 356 */       }
/* 357 */     }
/* 358 */
/* 359 */
/* 360 */     i = a;
/* 361 */     boolean isNullA10;
/* 362 */     UTF8String primitiveA10;
/* 363 */     {
/* 364 */
/* 365 */       boolean isNull10 = i.isNullAt(10);
/* 366 */       UTF8String value10 = isNull10 ? null : (i.getUTF8String(10));
/* 367 */       isNullA10 = isNull10;
/* 368 */       primitiveA10 = value10;
/* 369 */     }
/* 370 */     i = b;
/* 371 */     boolean isNullB10;
/* 372 */     UTF8String primitiveB10;
/* 373 */     {
/* 374 */
/* 375 */       boolean isNull10 = i.isNullAt(10);
/* 376 */       UTF8String value10 = isNull10 ? null : (i.getUTF8String(10));
/* 377 */       isNullB10 = isNull10;
/* 378 */       primitiveB10 = value10;
/* 379 */     }
/* 380 */     if (isNullA10 && isNullB10) {
/* 381 */       // Nothing
/* 382 */     } else if (isNullA10) {
/* 383 */       return -1;
/* 384 */     } else if (isNullB10) {
/* 385 */       return 1;
/* 386 */     } else {
/* 387 */       int comp = primitiveA10.compare(primitiveB10);
/* 388 */       if (comp != 0) {
/* 389 */         return comp;
/* 390 */       }
/* 391 */     }
/* 392 */
/* 393 */
/* 394 */     i = a;
/* 395 */     boolean isNullA11;
/* 396 */     UTF8String primitiveA11;
/* 397 */     {
/* 398 */
/* 399 */       boolean isNull11 = i.isNullAt(11);
/* 400 */       UTF8String value11 = isNull11 ? null : (i.getUTF8String(11));
/* 401 */       isNullA11 = isNull11;
/* 402 */       primitiveA11 = value11;
/* 403 */     }
/* 404 */     i = b;
/* 405 */     boolean isNullB11;
/* 406 */     UTF8String primitiveB11;
/* 407 */     {
/* 408 */
/* 409 */       boolean isNull11 = i.isNullAt(11);
/* 410 */       UTF8String value11 = isNull11 ? null : (i.getUTF8String(11));
/* 411 */       isNullB11 = isNull11;
/* 412 */       primitiveB11 = value11;
/* 413 */     }
/* 414 */     if (isNullA11 && isNullB11) {
/* 415 */       // Nothing
/* 416 */     } else if (isNullA11) {
/* 417 */       return -1;
/* 418 */     } else if (isNullB11) {
/* 419 */       return 1;
/* 420 */     } else {
/* 421 */       int comp = primitiveA11.compare(primitiveB11);
/* 422 */       if (comp != 0) {
/* 423 */         return comp;
/* 424 */       }
/* 425 */     }
/* 426 */
/* 427 */
/* 428 */     i = a;
/* 429 */     boolean isNullA12;
/* 430 */     UTF8String primitiveA12;
/* 431 */     {
/* 432 */
/* 433 */       boolean isNull12 = i.isNullAt(12);
/* 434 */       UTF8String value12 = isNull12 ? null : (i.getUTF8String(12));
/* 435 */       isNullA12 = isNull12;
/* 436 */       primitiveA12 = value12;
/* 437 */     }
/* 438 */     i = b;
/* 439 */     boolean isNullB12;
/* 440 */     UTF8String primitiveB12;
/* 441 */     {
/* 442 */
/* 443 */       boolean isNull12 = i.isNullAt(12);
/* 444 */       UTF8String value12 = isNull12 ? null : (i.getUTF8String(12));
/* 445 */       isNullB12 = isNull12;
/* 446 */       primitiveB12 = value12;
/* 447 */     }
/* 448 */     if (isNullA12 && isNullB12) {
/* 449 */       // Nothing
/* 450 */     } else if (isNullA12) {
/* 451 */       return -1;
/* 452 */     } else if (isNullB12) {
/* 453 */       return 1;
/* 454 */     } else {
/* 455 */       int comp = primitiveA12.compare(primitiveB12);
/* 456 */       if (comp != 0) {
/* 457 */         return comp;
/* 458 */       }
/* 459 */     }
/* 460 */
/* 461 */
/* 462 */     i = a;
/* 463 */     boolean isNullA13;
/* 464 */     double primitiveA13;
/* 465 */     {
/* 466 */
/* 467 */       boolean isNull13 = i.isNullAt(13);
/* 468 */       double value13 = isNull13 ? -1.0 : (i.getDouble(13));
/* 469 */       isNullA13 = isNull13;
/* 470 */       primitiveA13 = value13;
/* 471 */     }
/* 472 */     i = b;
/* 473 */     boolean isNullB13;
/* 474 */     double primitiveB13;
/* 475 */     {
/* 476 */
/* 477 */       boolean isNull13 = i.isNullAt(13);
/* 478 */       double value13 = isNull13 ? -1.0 : (i.getDouble(13));
/* 479 */       isNullB13 = isNull13;
/* 480 */       primitiveB13 = value13;
/* 481 */     }
/* 482 */     if (isNullA13 && isNullB13) {
/* 483 */       // Nothing
/* 484 */     } else if (isNullA13) {
/* 485 */       return -1;
/* 486 */     } else if (isNullB13) {
/* 487 */       return 1;
/* 488 */     } else {
/* 489 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA13, primitiveB13);
/* 490 */       if (comp != 0) {
/* 491 */         return comp;
/* 492 */       }
/* 493 */     }
/* 494 */
/* 495 */
/* 496 */     i = a;
/* 497 */     boolean isNullA14;
/* 498 */     UTF8String primitiveA14;
/* 499 */     {
/* 500 */
/* 501 */       boolean isNull14 = i.isNullAt(14);
/* 502 */       UTF8String value14 = isNull14 ? null : (i.getUTF8String(14));
/* 503 */       isNullA14 = isNull14;
/* 504 */       primitiveA14 = value14;
/* 505 */     }
/* 506 */     i = b;
/* 507 */     boolean isNullB14;
/* 508 */     UTF8String primitiveB14;
/* 509 */     {
/* 510 */
/* 511 */       boolean isNull14 = i.isNullAt(14);
/* 512 */       UTF8String value14 = isNull14 ? null : (i.getUTF8String(14));
/* 513 */       isNullB14 = isNull14;
/* 514 */       primitiveB14 = value14;
/* 515 */     }
/* 516 */     if (isNullA14 && isNullB14) {
/* 517 */       // Nothing
/* 518 */     } else if (isNullA14) {
/* 519 */       return -1;
/* 520 */     } else if (isNullB14) {
/* 521 */       return 1;
/* 522 */     } else {
/* 523 */       int comp = primitiveA14.compare(primitiveB14);
/* 524 */       if (comp != 0) {
/* 525 */         return comp;
/* 526 */       }
/* 527 */     }
/* 528 */
/* 529 */
/* 530 */     i = a;
/* 531 */     boolean isNullA15;
/* 532 */     double primitiveA15;
/* 533 */     {
/* 534 */
/* 535 */       boolean isNull15 = i.isNullAt(15);
/* 536 */       double value15 = isNull15 ? -1.0 : (i.getDouble(15));
/* 537 */       isNullA15 = isNull15;
/* 538 */       primitiveA15 = value15;
/* 539 */     }
/* 540 */     i = b;
/* 541 */     boolean isNullB15;
/* 542 */     double primitiveB15;
/* 543 */     {
/* 544 */
/* 545 */       boolean isNull15 = i.isNullAt(15);
/* 546 */       double value15 = isNull15 ? -1.0 : (i.getDouble(15));
/* 547 */       isNullB15 = isNull15;
/* 548 */       primitiveB15 = value15;
/* 549 */     }
/* 550 */     if (isNullA15 && isNullB15) {
/* 551 */       // Nothing
/* 552 */     } else if (isNullA15) {
/* 553 */       return -1;
/* 554 */     } else if (isNullB15) {
/* 555 */       return 1;
/* 556 */     } else {
/* 557 */       int comp = org.apache.spark.util.Utils.nanSafeCompareDoubles(primitiveA15, primitiveB15);
/* 558 */       if (comp != 0) {
/* 559 */         return comp;
/* 560 */       }
/* 561 */     }
/* 562 */
/* 563 */     return 0;
/* 564 */   }
/* 565 */ }

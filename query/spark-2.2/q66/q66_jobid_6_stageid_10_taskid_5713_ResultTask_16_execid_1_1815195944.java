/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificSafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificSafeProjection extends org.apache.spark.sql.catalyst.expressions.codegen.BaseProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private InternalRow mutableRow;
/* 009 */   private Object[] values;
/* 010 */   private org.apache.spark.sql.types.StructType schema;
/* 011 */
/* 012 */   public SpecificSafeProjection(Object[] references) {
/* 013 */     this.references = references;
/* 014 */     mutableRow = (InternalRow) references[references.length - 1];
/* 015 */
/* 016 */     this.schema = (org.apache.spark.sql.types.StructType) references[0];
/* 017 */
/* 018 */   }
/* 019 */
/* 020 */   public void initialize(int partitionIndex) {
/* 021 */
/* 022 */   }
/* 023 */
/* 024 */
/* 025 */   private void apply_4(InternalRow i) {
/* 026 */
/* 027 */     boolean isNull19 = i.isNullAt(12);
/* 028 */     double value19 = isNull19 ? -1.0 : (i.getDouble(12));
/* 029 */     if (isNull19) {
/* 030 */       values[12] = null;
/* 031 */     } else {
/* 032 */       values[12] = value19;
/* 033 */     }
/* 034 */
/* 035 */     boolean isNull20 = i.isNullAt(13);
/* 036 */     double value20 = isNull20 ? -1.0 : (i.getDouble(13));
/* 037 */     if (isNull20) {
/* 038 */       values[13] = null;
/* 039 */     } else {
/* 040 */       values[13] = value20;
/* 041 */     }
/* 042 */
/* 043 */     boolean isNull21 = i.isNullAt(14);
/* 044 */     double value21 = isNull21 ? -1.0 : (i.getDouble(14));
/* 045 */     if (isNull21) {
/* 046 */       values[14] = null;
/* 047 */     } else {
/* 048 */       values[14] = value21;
/* 049 */     }
/* 050 */
/* 051 */     boolean isNull22 = i.isNullAt(15);
/* 052 */     double value22 = isNull22 ? -1.0 : (i.getDouble(15));
/* 053 */     if (isNull22) {
/* 054 */       values[15] = null;
/* 055 */     } else {
/* 056 */       values[15] = value22;
/* 057 */     }
/* 058 */
/* 059 */     boolean isNull23 = i.isNullAt(16);
/* 060 */     double value23 = isNull23 ? -1.0 : (i.getDouble(16));
/* 061 */     if (isNull23) {
/* 062 */       values[16] = null;
/* 063 */     } else {
/* 064 */       values[16] = value23;
/* 065 */     }
/* 066 */
/* 067 */   }
/* 068 */
/* 069 */
/* 070 */   private void apply_7(InternalRow i) {
/* 071 */
/* 072 */     boolean isNull34 = i.isNullAt(27);
/* 073 */     double value34 = isNull34 ? -1.0 : (i.getDouble(27));
/* 074 */     if (isNull34) {
/* 075 */       values[27] = null;
/* 076 */     } else {
/* 077 */       values[27] = value34;
/* 078 */     }
/* 079 */
/* 080 */     boolean isNull35 = i.isNullAt(28);
/* 081 */     double value35 = isNull35 ? -1.0 : (i.getDouble(28));
/* 082 */     if (isNull35) {
/* 083 */       values[28] = null;
/* 084 */     } else {
/* 085 */       values[28] = value35;
/* 086 */     }
/* 087 */
/* 088 */     boolean isNull36 = i.isNullAt(29);
/* 089 */     double value36 = isNull36 ? -1.0 : (i.getDouble(29));
/* 090 */     if (isNull36) {
/* 091 */       values[29] = null;
/* 092 */     } else {
/* 093 */       values[29] = value36;
/* 094 */     }
/* 095 */
/* 096 */     boolean isNull37 = i.isNullAt(30);
/* 097 */     double value37 = isNull37 ? -1.0 : (i.getDouble(30));
/* 098 */     if (isNull37) {
/* 099 */       values[30] = null;
/* 100 */     } else {
/* 101 */       values[30] = value37;
/* 102 */     }
/* 103 */
/* 104 */     boolean isNull38 = i.isNullAt(31);
/* 105 */     double value38 = isNull38 ? -1.0 : (i.getDouble(31));
/* 106 */     if (isNull38) {
/* 107 */       values[31] = null;
/* 108 */     } else {
/* 109 */       values[31] = value38;
/* 110 */     }
/* 111 */
/* 112 */   }
/* 113 */
/* 114 */
/* 115 */   private void apply_1(InternalRow i) {
/* 116 */
/* 117 */     boolean isNull7 = i.isNullAt(3);
/* 118 */     UTF8String value7 = isNull7 ? null : (i.getUTF8String(3));
/* 119 */     boolean isNull6 = true;
/* 120 */     java.lang.String value6 = null;
/* 121 */     if (!isNull7) {
/* 122 */
/* 123 */       isNull6 = false;
/* 124 */       if (!isNull6) {
/* 125 */
/* 126 */         Object funcResult2 = null;
/* 127 */         funcResult2 = value7.toString();
/* 128 */         value6 = (java.lang.String) funcResult2;
/* 129 */
/* 130 */       }
/* 131 */     }
/* 132 */     if (isNull6) {
/* 133 */       values[3] = null;
/* 134 */     } else {
/* 135 */       values[3] = value6;
/* 136 */     }
/* 137 */
/* 138 */     boolean isNull9 = i.isNullAt(4);
/* 139 */     UTF8String value9 = isNull9 ? null : (i.getUTF8String(4));
/* 140 */     boolean isNull8 = true;
/* 141 */     java.lang.String value8 = null;
/* 142 */     if (!isNull9) {
/* 143 */
/* 144 */       isNull8 = false;
/* 145 */       if (!isNull8) {
/* 146 */
/* 147 */         Object funcResult3 = null;
/* 148 */         funcResult3 = value9.toString();
/* 149 */         value8 = (java.lang.String) funcResult3;
/* 150 */
/* 151 */       }
/* 152 */     }
/* 153 */     if (isNull8) {
/* 154 */       values[4] = null;
/* 155 */     } else {
/* 156 */       values[4] = value8;
/* 157 */     }
/* 158 */
/* 159 */   }
/* 160 */
/* 161 */
/* 162 */   private void apply_9(InternalRow i) {
/* 163 */
/* 164 */     boolean isNull44 = i.isNullAt(37);
/* 165 */     double value44 = isNull44 ? -1.0 : (i.getDouble(37));
/* 166 */     if (isNull44) {
/* 167 */       values[37] = null;
/* 168 */     } else {
/* 169 */       values[37] = value44;
/* 170 */     }
/* 171 */
/* 172 */     boolean isNull45 = i.isNullAt(38);
/* 173 */     double value45 = isNull45 ? -1.0 : (i.getDouble(38));
/* 174 */     if (isNull45) {
/* 175 */       values[38] = null;
/* 176 */     } else {
/* 177 */       values[38] = value45;
/* 178 */     }
/* 179 */
/* 180 */     boolean isNull46 = i.isNullAt(39);
/* 181 */     double value46 = isNull46 ? -1.0 : (i.getDouble(39));
/* 182 */     if (isNull46) {
/* 183 */       values[39] = null;
/* 184 */     } else {
/* 185 */       values[39] = value46;
/* 186 */     }
/* 187 */
/* 188 */     boolean isNull47 = i.isNullAt(40);
/* 189 */     double value47 = isNull47 ? -1.0 : (i.getDouble(40));
/* 190 */     if (isNull47) {
/* 191 */       values[40] = null;
/* 192 */     } else {
/* 193 */       values[40] = value47;
/* 194 */     }
/* 195 */
/* 196 */     boolean isNull48 = i.isNullAt(41);
/* 197 */     double value48 = isNull48 ? -1.0 : (i.getDouble(41));
/* 198 */     if (isNull48) {
/* 199 */       values[41] = null;
/* 200 */     } else {
/* 201 */       values[41] = value48;
/* 202 */     }
/* 203 */
/* 204 */   }
/* 205 */
/* 206 */
/* 207 */   private void apply_3(InternalRow i) {
/* 208 */
/* 209 */     boolean isNull14 = i.isNullAt(7);
/* 210 */     int value14 = isNull14 ? -1 : (i.getInt(7));
/* 211 */     if (isNull14) {
/* 212 */       values[7] = null;
/* 213 */     } else {
/* 214 */       values[7] = value14;
/* 215 */     }
/* 216 */
/* 217 */     boolean isNull15 = i.isNullAt(8);
/* 218 */     double value15 = isNull15 ? -1.0 : (i.getDouble(8));
/* 219 */     if (isNull15) {
/* 220 */       values[8] = null;
/* 221 */     } else {
/* 222 */       values[8] = value15;
/* 223 */     }
/* 224 */
/* 225 */     boolean isNull16 = i.isNullAt(9);
/* 226 */     double value16 = isNull16 ? -1.0 : (i.getDouble(9));
/* 227 */     if (isNull16) {
/* 228 */       values[9] = null;
/* 229 */     } else {
/* 230 */       values[9] = value16;
/* 231 */     }
/* 232 */
/* 233 */     boolean isNull17 = i.isNullAt(10);
/* 234 */     double value17 = isNull17 ? -1.0 : (i.getDouble(10));
/* 235 */     if (isNull17) {
/* 236 */       values[10] = null;
/* 237 */     } else {
/* 238 */       values[10] = value17;
/* 239 */     }
/* 240 */
/* 241 */     boolean isNull18 = i.isNullAt(11);
/* 242 */     double value18 = isNull18 ? -1.0 : (i.getDouble(11));
/* 243 */     if (isNull18) {
/* 244 */       values[11] = null;
/* 245 */     } else {
/* 246 */       values[11] = value18;
/* 247 */     }
/* 248 */
/* 249 */   }
/* 250 */
/* 251 */
/* 252 */   private void apply_6(InternalRow i) {
/* 253 */
/* 254 */     boolean isNull29 = i.isNullAt(22);
/* 255 */     double value29 = isNull29 ? -1.0 : (i.getDouble(22));
/* 256 */     if (isNull29) {
/* 257 */       values[22] = null;
/* 258 */     } else {
/* 259 */       values[22] = value29;
/* 260 */     }
/* 261 */
/* 262 */     boolean isNull30 = i.isNullAt(23);
/* 263 */     double value30 = isNull30 ? -1.0 : (i.getDouble(23));
/* 264 */     if (isNull30) {
/* 265 */       values[23] = null;
/* 266 */     } else {
/* 267 */       values[23] = value30;
/* 268 */     }
/* 269 */
/* 270 */     boolean isNull31 = i.isNullAt(24);
/* 271 */     double value31 = isNull31 ? -1.0 : (i.getDouble(24));
/* 272 */     if (isNull31) {
/* 273 */       values[24] = null;
/* 274 */     } else {
/* 275 */       values[24] = value31;
/* 276 */     }
/* 277 */
/* 278 */     boolean isNull32 = i.isNullAt(25);
/* 279 */     double value32 = isNull32 ? -1.0 : (i.getDouble(25));
/* 280 */     if (isNull32) {
/* 281 */       values[25] = null;
/* 282 */     } else {
/* 283 */       values[25] = value32;
/* 284 */     }
/* 285 */
/* 286 */     boolean isNull33 = i.isNullAt(26);
/* 287 */     double value33 = isNull33 ? -1.0 : (i.getDouble(26));
/* 288 */     if (isNull33) {
/* 289 */       values[26] = null;
/* 290 */     } else {
/* 291 */       values[26] = value33;
/* 292 */     }
/* 293 */
/* 294 */   }
/* 295 */
/* 296 */
/* 297 */   private void apply_0(InternalRow i) {
/* 298 */
/* 299 */     boolean isNull2 = i.isNullAt(0);
/* 300 */     UTF8String value2 = isNull2 ? null : (i.getUTF8String(0));
/* 301 */     boolean isNull1 = true;
/* 302 */     java.lang.String value1 = null;
/* 303 */     if (!isNull2) {
/* 304 */
/* 305 */       isNull1 = false;
/* 306 */       if (!isNull1) {
/* 307 */
/* 308 */         Object funcResult = null;
/* 309 */         funcResult = value2.toString();
/* 310 */         value1 = (java.lang.String) funcResult;
/* 311 */
/* 312 */       }
/* 313 */     }
/* 314 */     if (isNull1) {
/* 315 */       values[0] = null;
/* 316 */     } else {
/* 317 */       values[0] = value1;
/* 318 */     }
/* 319 */
/* 320 */     boolean isNull3 = i.isNullAt(1);
/* 321 */     int value3 = isNull3 ? -1 : (i.getInt(1));
/* 322 */     if (isNull3) {
/* 323 */       values[1] = null;
/* 324 */     } else {
/* 325 */       values[1] = value3;
/* 326 */     }
/* 327 */
/* 328 */     boolean isNull5 = i.isNullAt(2);
/* 329 */     UTF8String value5 = isNull5 ? null : (i.getUTF8String(2));
/* 330 */     boolean isNull4 = true;
/* 331 */     java.lang.String value4 = null;
/* 332 */     if (!isNull5) {
/* 333 */
/* 334 */       isNull4 = false;
/* 335 */       if (!isNull4) {
/* 336 */
/* 337 */         Object funcResult1 = null;
/* 338 */         funcResult1 = value5.toString();
/* 339 */         value4 = (java.lang.String) funcResult1;
/* 340 */
/* 341 */       }
/* 342 */     }
/* 343 */     if (isNull4) {
/* 344 */       values[2] = null;
/* 345 */     } else {
/* 346 */       values[2] = value4;
/* 347 */     }
/* 348 */
/* 349 */   }
/* 350 */
/* 351 */
/* 352 */   private void apply_8(InternalRow i) {
/* 353 */
/* 354 */     boolean isNull39 = i.isNullAt(32);
/* 355 */     double value39 = isNull39 ? -1.0 : (i.getDouble(32));
/* 356 */     if (isNull39) {
/* 357 */       values[32] = null;
/* 358 */     } else {
/* 359 */       values[32] = value39;
/* 360 */     }
/* 361 */
/* 362 */     boolean isNull40 = i.isNullAt(33);
/* 363 */     double value40 = isNull40 ? -1.0 : (i.getDouble(33));
/* 364 */     if (isNull40) {
/* 365 */       values[33] = null;
/* 366 */     } else {
/* 367 */       values[33] = value40;
/* 368 */     }
/* 369 */
/* 370 */     boolean isNull41 = i.isNullAt(34);
/* 371 */     double value41 = isNull41 ? -1.0 : (i.getDouble(34));
/* 372 */     if (isNull41) {
/* 373 */       values[34] = null;
/* 374 */     } else {
/* 375 */       values[34] = value41;
/* 376 */     }
/* 377 */
/* 378 */     boolean isNull42 = i.isNullAt(35);
/* 379 */     double value42 = isNull42 ? -1.0 : (i.getDouble(35));
/* 380 */     if (isNull42) {
/* 381 */       values[35] = null;
/* 382 */     } else {
/* 383 */       values[35] = value42;
/* 384 */     }
/* 385 */
/* 386 */     boolean isNull43 = i.isNullAt(36);
/* 387 */     double value43 = isNull43 ? -1.0 : (i.getDouble(36));
/* 388 */     if (isNull43) {
/* 389 */       values[36] = null;
/* 390 */     } else {
/* 391 */       values[36] = value43;
/* 392 */     }
/* 393 */
/* 394 */   }
/* 395 */
/* 396 */
/* 397 */   private void apply_2(InternalRow i) {
/* 398 */
/* 399 */     boolean isNull11 = i.isNullAt(5);
/* 400 */     UTF8String value11 = isNull11 ? null : (i.getUTF8String(5));
/* 401 */     boolean isNull10 = true;
/* 402 */     java.lang.String value10 = null;
/* 403 */     if (!isNull11) {
/* 404 */
/* 405 */       isNull10 = false;
/* 406 */       if (!isNull10) {
/* 407 */
/* 408 */         Object funcResult4 = null;
/* 409 */         funcResult4 = value11.toString();
/* 410 */         value10 = (java.lang.String) funcResult4;
/* 411 */
/* 412 */       }
/* 413 */     }
/* 414 */     if (isNull10) {
/* 415 */       values[5] = null;
/* 416 */     } else {
/* 417 */       values[5] = value10;
/* 418 */     }
/* 419 */
/* 420 */     UTF8String value13 = i.getUTF8String(6);
/* 421 */     boolean isNull12 = true;
/* 422 */     java.lang.String value12 = null;
/* 423 */     if (!false) {
/* 424 */
/* 425 */       isNull12 = false;
/* 426 */       if (!isNull12) {
/* 427 */
/* 428 */         Object funcResult5 = null;
/* 429 */         funcResult5 = value13.toString();
/* 430 */         value12 = (java.lang.String) funcResult5;
/* 431 */
/* 432 */       }
/* 433 */     }
/* 434 */     if (isNull12) {
/* 435 */       values[6] = null;
/* 436 */     } else {
/* 437 */       values[6] = value12;
/* 438 */     }
/* 439 */
/* 440 */   }
/* 441 */
/* 442 */
/* 443 */   private void apply_10(InternalRow i) {
/* 444 */
/* 445 */     boolean isNull49 = i.isNullAt(42);
/* 446 */     double value49 = isNull49 ? -1.0 : (i.getDouble(42));
/* 447 */     if (isNull49) {
/* 448 */       values[42] = null;
/* 449 */     } else {
/* 450 */       values[42] = value49;
/* 451 */     }
/* 452 */
/* 453 */     boolean isNull50 = i.isNullAt(43);
/* 454 */     double value50 = isNull50 ? -1.0 : (i.getDouble(43));
/* 455 */     if (isNull50) {
/* 456 */       values[43] = null;
/* 457 */     } else {
/* 458 */       values[43] = value50;
/* 459 */     }
/* 460 */
/* 461 */   }
/* 462 */
/* 463 */
/* 464 */   private void apply_5(InternalRow i) {
/* 465 */
/* 466 */     boolean isNull24 = i.isNullAt(17);
/* 467 */     double value24 = isNull24 ? -1.0 : (i.getDouble(17));
/* 468 */     if (isNull24) {
/* 469 */       values[17] = null;
/* 470 */     } else {
/* 471 */       values[17] = value24;
/* 472 */     }
/* 473 */
/* 474 */     boolean isNull25 = i.isNullAt(18);
/* 475 */     double value25 = isNull25 ? -1.0 : (i.getDouble(18));
/* 476 */     if (isNull25) {
/* 477 */       values[18] = null;
/* 478 */     } else {
/* 479 */       values[18] = value25;
/* 480 */     }
/* 481 */
/* 482 */     boolean isNull26 = i.isNullAt(19);
/* 483 */     double value26 = isNull26 ? -1.0 : (i.getDouble(19));
/* 484 */     if (isNull26) {
/* 485 */       values[19] = null;
/* 486 */     } else {
/* 487 */       values[19] = value26;
/* 488 */     }
/* 489 */
/* 490 */     boolean isNull27 = i.isNullAt(20);
/* 491 */     double value27 = isNull27 ? -1.0 : (i.getDouble(20));
/* 492 */     if (isNull27) {
/* 493 */       values[20] = null;
/* 494 */     } else {
/* 495 */       values[20] = value27;
/* 496 */     }
/* 497 */
/* 498 */     boolean isNull28 = i.isNullAt(21);
/* 499 */     double value28 = isNull28 ? -1.0 : (i.getDouble(21));
/* 500 */     if (isNull28) {
/* 501 */       values[21] = null;
/* 502 */     } else {
/* 503 */       values[21] = value28;
/* 504 */     }
/* 505 */
/* 506 */   }
/* 507 */
/* 508 */
/* 509 */   public java.lang.Object apply(java.lang.Object _i) {
/* 510 */     InternalRow i = (InternalRow) _i;
/* 511 */
/* 512 */     values = new Object[44];
/* 513 */     apply_0(i);
/* 514 */     apply_1(i);
/* 515 */     apply_2(i);
/* 516 */     apply_3(i);
/* 517 */     apply_4(i);
/* 518 */     apply_5(i);
/* 519 */     apply_6(i);
/* 520 */     apply_7(i);
/* 521 */     apply_8(i);
/* 522 */     apply_9(i);
/* 523 */     apply_10(i);
/* 524 */     final org.apache.spark.sql.Row value = new org.apache.spark.sql.catalyst.expressions.GenericRowWithSchema(values, schema);
/* 525 */     if (false) {
/* 526 */       mutableRow.setNullAt(0);
/* 527 */     } else {
/* 528 */
/* 529 */       mutableRow.update(0, value);
/* 530 */     }
/* 531 */
/* 532 */     return mutableRow;
/* 533 */   }
/* 534 */ }

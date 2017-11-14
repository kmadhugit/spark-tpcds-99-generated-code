/* 001 */ public java.lang.Object generate(Object[] references) {
/* 002 */   return new SpecificUnsafeProjection(references);
/* 003 */ }
/* 004 */
/* 005 */ class SpecificUnsafeProjection extends org.apache.spark.sql.catalyst.expressions.UnsafeProjection {
/* 006 */
/* 007 */   private Object[] references;
/* 008 */   private UnsafeRow result;
/* 009 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder holder;
/* 010 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter;
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter;
/* 012 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter1;
/* 013 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter1;
/* 014 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter2;
/* 015 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter3;
/* 016 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter4;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter5;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter2;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter6;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter3;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter4;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter5;
/* 023 */
/* 024 */   public SpecificUnsafeProjection(Object[] references) {
/* 025 */     this.references = references;
/* 026 */     init_0();
/* 027 */     init_1();
/* 028 */   }
/* 029 */
/* 030 */   public void initialize(int partitionIndex) {
/* 031 */
/* 032 */   }
/* 033 */
/* 034 */
/* 035 */   private void apply2_7(InternalRow element) {
/* 036 */
/* 037 */
/* 038 */     boolean isNull16 = element.isNullAt(15);
/* 039 */     InternalRow value16 = isNull16 ? null : element.getStruct(15, 4);
/* 040 */
/* 041 */     if (isNull16) {
/* 042 */       rowWriter1.setNullAt(15);
/* 043 */     } else {
/* 044 */       // Remember the current cursor so that we can calculate how many bytes are
/* 045 */       // written later.
/* 046 */       final int tmpCursor52 = holder.cursor;
/* 047 */
/* 048 */       if (value16 instanceof UnsafeRow) {
/* 049 */
/* 050 */         final int sizeInBytes11 = ((UnsafeRow) value16).getSizeInBytes();
/* 051 */         // grow the global buffer before writing data.
/* 052 */         holder.grow(sizeInBytes11);
/* 053 */         ((UnsafeRow) value16).writeToMemory(holder.buffer, holder.cursor);
/* 054 */         holder.cursor += sizeInBytes11;
/* 055 */
/* 056 */       } else {
/* 057 */         rowWriter5.reset();
/* 058 */
/* 059 */
/* 060 */         boolean isNull45 = value16.isNullAt(0);
/* 061 */         double value45 = isNull45 ? -1.0 : value16.getDouble(0);
/* 062 */
/* 063 */         if (isNull45) {
/* 064 */           rowWriter5.setNullAt(0);
/* 065 */         } else {
/* 066 */           rowWriter5.write(0, value45);
/* 067 */         }
/* 068 */
/* 069 */
/* 070 */         boolean isNull46 = value16.isNullAt(1);
/* 071 */         double value46 = isNull46 ? -1.0 : value16.getDouble(1);
/* 072 */
/* 073 */         if (isNull46) {
/* 074 */           rowWriter5.setNullAt(1);
/* 075 */         } else {
/* 076 */           rowWriter5.write(1, value46);
/* 077 */         }
/* 078 */
/* 079 */
/* 080 */         boolean isNull47 = value16.isNullAt(2);
/* 081 */         double value47 = isNull47 ? -1.0 : value16.getDouble(2);
/* 082 */
/* 083 */         if (isNull47) {
/* 084 */           rowWriter5.setNullAt(2);
/* 085 */         } else {
/* 086 */           rowWriter5.write(2, value47);
/* 087 */         }
/* 088 */
/* 089 */
/* 090 */         boolean isNull48 = value16.isNullAt(3);
/* 091 */         double value48 = isNull48 ? -1.0 : value16.getDouble(3);
/* 092 */
/* 093 */         if (isNull48) {
/* 094 */           rowWriter5.setNullAt(3);
/* 095 */         } else {
/* 096 */           rowWriter5.write(3, value48);
/* 097 */         }
/* 098 */       }
/* 099 */
/* 100 */       rowWriter1.setOffsetAndSize(15, tmpCursor52, holder.cursor - tmpCursor52);
/* 101 */     }
/* 102 */
/* 103 */   }
/* 104 */
/* 105 */
/* 106 */   private void apply1_2(InternalRow value15) {
/* 107 */
/* 108 */
/* 109 */     boolean isNull33 = value15.isNullAt(8);
/* 110 */     int value33 = isNull33 ? -1 : value15.getInt(8);
/* 111 */
/* 112 */     if (isNull33) {
/* 113 */       rowWriter4.setNullAt(8);
/* 114 */     } else {
/* 115 */       rowWriter4.write(8, value33);
/* 116 */     }
/* 117 */
/* 118 */
/* 119 */     boolean isNull34 = value15.isNullAt(9);
/* 120 */     int value34 = isNull34 ? -1 : value15.getInt(9);
/* 121 */
/* 122 */     if (isNull34) {
/* 123 */       rowWriter4.setNullAt(9);
/* 124 */     } else {
/* 125 */       rowWriter4.write(9, value34);
/* 126 */     }
/* 127 */
/* 128 */
/* 129 */     boolean isNull35 = value15.isNullAt(10);
/* 130 */     UTF8String value35 = isNull35 ? null : value15.getUTF8String(10);
/* 131 */
/* 132 */     if (isNull35) {
/* 133 */       rowWriter4.setNullAt(10);
/* 134 */     } else {
/* 135 */       rowWriter4.write(10, value35);
/* 136 */     }
/* 137 */
/* 138 */
/* 139 */     boolean isNull36 = value15.isNullAt(11);
/* 140 */     int value36 = isNull36 ? -1 : value15.getInt(11);
/* 141 */
/* 142 */     if (isNull36) {
/* 143 */       rowWriter4.setNullAt(11);
/* 144 */     } else {
/* 145 */       rowWriter4.write(11, value36);
/* 146 */     }
/* 147 */
/* 148 */   }
/* 149 */
/* 150 */
/* 151 */   private void apply2_1(InternalRow element) {
/* 152 */
/* 153 */
/* 154 */     boolean isNull4 = element.isNullAt(3);
/* 155 */     ArrayData value4 = isNull4 ? null : element.getArray(3);
/* 156 */
/* 157 */     if (isNull4) {
/* 158 */       rowWriter1.setNullAt(3);
/* 159 */     } else {
/* 160 */       // Remember the current cursor so that we can calculate how many bytes are
/* 161 */       // written later.
/* 162 */       final int tmpCursor8 = holder.cursor;
/* 163 */
/* 164 */       if (value4 instanceof UnsafeArrayData) {
/* 165 */
/* 166 */         final int sizeInBytes4 = ((UnsafeArrayData) value4).getSizeInBytes();
/* 167 */         // grow the global buffer before writing data.
/* 168 */         holder.grow(sizeInBytes4);
/* 169 */         ((UnsafeArrayData) value4).writeToMemory(holder.buffer, holder.cursor);
/* 170 */         holder.cursor += sizeInBytes4;
/* 171 */
/* 172 */       } else {
/* 173 */         final int numElements3 = value4.numElements();
/* 174 */         arrayWriter3.initialize(holder, numElements3, 8);
/* 175 */
/* 176 */         for (int index3 = 0; index3 < numElements3; index3++) {
/* 177 */           if (value4.isNullAt(index3)) {
/* 178 */             arrayWriter3.setNull(index3);
/* 179 */           } else {
/* 180 */             final UTF8String element3 = value4.getUTF8String(index3);
/* 181 */             arrayWriter3.write(index3, element3);
/* 182 */           }
/* 183 */         }
/* 184 */       }
/* 185 */
/* 186 */       rowWriter1.setOffsetAndSize(3, tmpCursor8, holder.cursor - tmpCursor8);
/* 187 */     }
/* 188 */
/* 189 */   }
/* 190 */
/* 191 */
/* 192 */   private void apply2_4(InternalRow element) {
/* 193 */
/* 194 */
/* 195 */     boolean isNull10 = element.isNullAt(9);
/* 196 */     double value10 = isNull10 ? -1.0 : element.getDouble(9);
/* 197 */
/* 198 */     if (isNull10) {
/* 199 */       rowWriter1.setNullAt(9);
/* 200 */     } else {
/* 201 */       rowWriter1.write(9, value10);
/* 202 */     }
/* 203 */
/* 204 */
/* 205 */     boolean isNull11 = element.isNullAt(10);
/* 206 */     long value11 = isNull11 ? -1L : element.getLong(10);
/* 207 */
/* 208 */     if (isNull11) {
/* 209 */       rowWriter1.setNullAt(10);
/* 210 */     } else {
/* 211 */       rowWriter1.write(10, value11);
/* 212 */     }
/* 213 */
/* 214 */
/* 215 */     boolean isNull12 = element.isNullAt(11);
/* 216 */     ArrayData value12 = isNull12 ? null : element.getArray(11);
/* 217 */
/* 218 */     if (isNull12) {
/* 219 */       rowWriter1.setNullAt(11);
/* 220 */     } else {
/* 221 */       // Remember the current cursor so that we can calculate how many bytes are
/* 222 */       // written later.
/* 223 */       final int tmpCursor18 = holder.cursor;
/* 224 */
/* 225 */       if (value12 instanceof UnsafeArrayData) {
/* 226 */
/* 227 */         final int sizeInBytes8 = ((UnsafeArrayData) value12).getSizeInBytes();
/* 228 */         // grow the global buffer before writing data.
/* 229 */         holder.grow(sizeInBytes8);
/* 230 */         ((UnsafeArrayData) value12).writeToMemory(holder.buffer, holder.cursor);
/* 231 */         holder.cursor += sizeInBytes8;
/* 232 */
/* 233 */       } else {
/* 234 */         final int numElements5 = value12.numElements();
/* 235 */         arrayWriter5.initialize(holder, numElements5, 8);
/* 236 */
/* 237 */         for (int index5 = 0; index5 < numElements5; index5++) {
/* 238 */           if (value12.isNullAt(index5)) {
/* 239 */             arrayWriter5.setNull(index5);
/* 240 */           } else {
/* 241 */             final InternalRow element5 = value12.getStruct(index5, 6);
/* 242 */
/* 243 */             final int tmpCursor19 = holder.cursor;
/* 244 */
/* 245 */             if (element5 instanceof UnsafeRow) {
/* 246 */
/* 247 */               final int sizeInBytes6 = ((UnsafeRow) element5).getSizeInBytes();
/* 248 */               // grow the global buffer before writing data.
/* 249 */               holder.grow(sizeInBytes6);
/* 250 */               ((UnsafeRow) element5).writeToMemory(holder.buffer, holder.cursor);
/* 251 */               holder.cursor += sizeInBytes6;
/* 252 */
/* 253 */             } else {
/* 254 */               rowWriter2.reset();
/* 255 */               apply_0(element5);
/* 256 */               apply_1(element5);
/* 257 */             }
/* 258 */
/* 259 */             arrayWriter5.setOffsetAndSize(index5, tmpCursor19, holder.cursor - tmpCursor19);
/* 260 */
/* 261 */           }
/* 262 */         }
/* 263 */       }
/* 264 */
/* 265 */       rowWriter1.setOffsetAndSize(11, tmpCursor18, holder.cursor - tmpCursor18);
/* 266 */     }
/* 267 */
/* 268 */   }
/* 269 */
/* 270 */
/* 271 */   private void apply_1(InternalRow element5) {
/* 272 */
/* 273 */
/* 274 */     boolean isNull21 = element5.isNullAt(4);
/* 275 */     double value21 = isNull21 ? -1.0 : element5.getDouble(4);
/* 276 */
/* 277 */     if (isNull21) {
/* 278 */       rowWriter2.setNullAt(4);
/* 279 */     } else {
/* 280 */       rowWriter2.write(4, value21);
/* 281 */     }
/* 282 */
/* 283 */
/* 284 */     boolean isNull22 = element5.isNullAt(5);
/* 285 */     double value22 = isNull22 ? -1.0 : element5.getDouble(5);
/* 286 */
/* 287 */     if (isNull22) {
/* 288 */       rowWriter2.setNullAt(5);
/* 289 */     } else {
/* 290 */       rowWriter2.write(5, value22);
/* 291 */     }
/* 292 */
/* 293 */   }
/* 294 */
/* 295 */
/* 296 */   private void apply1_4(InternalRow value15) {
/* 297 */
/* 298 */
/* 299 */     boolean isNull41 = value15.isNullAt(16);
/* 300 */     UTF8String value41 = isNull41 ? null : value15.getUTF8String(16);
/* 301 */
/* 302 */     if (isNull41) {
/* 303 */       rowWriter4.setNullAt(16);
/* 304 */     } else {
/* 305 */       rowWriter4.write(16, value41);
/* 306 */     }
/* 307 */
/* 308 */
/* 309 */     boolean isNull42 = value15.isNullAt(17);
/* 310 */     double value42 = isNull42 ? -1.0 : value15.getDouble(17);
/* 311 */
/* 312 */     if (isNull42) {
/* 313 */       rowWriter4.setNullAt(17);
/* 314 */     } else {
/* 315 */       rowWriter4.write(17, value42);
/* 316 */     }
/* 317 */
/* 318 */
/* 319 */     boolean isNull43 = value15.isNullAt(18);
/* 320 */     int value43 = isNull43 ? -1 : value15.getInt(18);
/* 321 */
/* 322 */     if (isNull43) {
/* 323 */       rowWriter4.setNullAt(18);
/* 324 */     } else {
/* 325 */       rowWriter4.write(18, value43);
/* 326 */     }
/* 327 */
/* 328 */
/* 329 */     boolean isNull44 = value15.isNullAt(19);
/* 330 */     double value44 = isNull44 ? -1.0 : value15.getDouble(19);
/* 331 */
/* 332 */     if (isNull44) {
/* 333 */       rowWriter4.setNullAt(19);
/* 334 */     } else {
/* 335 */       rowWriter4.write(19, value44);
/* 336 */     }
/* 337 */
/* 338 */   }
/* 339 */
/* 340 */
/* 341 */   private void apply2_3(InternalRow element) {
/* 342 */
/* 343 */
/* 344 */     boolean isNull6 = element.isNullAt(5);
/* 345 */     double value6 = isNull6 ? -1.0 : element.getDouble(5);
/* 346 */
/* 347 */     if (isNull6) {
/* 348 */       rowWriter1.setNullAt(5);
/* 349 */     } else {
/* 350 */       rowWriter1.write(5, value6);
/* 351 */     }
/* 352 */
/* 353 */
/* 354 */     boolean isNull7 = element.isNullAt(6);
/* 355 */     double value7 = isNull7 ? -1.0 : element.getDouble(6);
/* 356 */
/* 357 */     if (isNull7) {
/* 358 */       rowWriter1.setNullAt(6);
/* 359 */     } else {
/* 360 */       rowWriter1.write(6, value7);
/* 361 */     }
/* 362 */
/* 363 */
/* 364 */     boolean isNull8 = element.isNullAt(7);
/* 365 */     double value8 = isNull8 ? -1.0 : element.getDouble(7);
/* 366 */
/* 367 */     if (isNull8) {
/* 368 */       rowWriter1.setNullAt(7);
/* 369 */     } else {
/* 370 */       rowWriter1.write(7, value8);
/* 371 */     }
/* 372 */
/* 373 */
/* 374 */     boolean isNull9 = element.isNullAt(8);
/* 375 */     double value9 = isNull9 ? -1.0 : element.getDouble(8);
/* 376 */
/* 377 */     if (isNull9) {
/* 378 */       rowWriter1.setNullAt(8);
/* 379 */     } else {
/* 380 */       rowWriter1.write(8, value9);
/* 381 */     }
/* 382 */
/* 383 */   }
/* 384 */
/* 385 */
/* 386 */   private void apply2_6(InternalRow element) {
/* 387 */
/* 388 */
/* 389 */     boolean isNull15 = element.isNullAt(14);
/* 390 */     InternalRow value15 = isNull15 ? null : element.getStruct(14, 20);
/* 391 */
/* 392 */     if (isNull15) {
/* 393 */       rowWriter1.setNullAt(14);
/* 394 */     } else {
/* 395 */       // Remember the current cursor so that we can calculate how many bytes are
/* 396 */       // written later.
/* 397 */       final int tmpCursor31 = holder.cursor;
/* 398 */
/* 399 */       if (value15 instanceof UnsafeRow) {
/* 400 */
/* 401 */         final int sizeInBytes10 = ((UnsafeRow) value15).getSizeInBytes();
/* 402 */         // grow the global buffer before writing data.
/* 403 */         holder.grow(sizeInBytes10);
/* 404 */         ((UnsafeRow) value15).writeToMemory(holder.buffer, holder.cursor);
/* 405 */         holder.cursor += sizeInBytes10;
/* 406 */
/* 407 */       } else {
/* 408 */         rowWriter4.reset();
/* 409 */         apply1_0(value15);
/* 410 */         apply1_1(value15);
/* 411 */         apply1_2(value15);
/* 412 */         apply1_3(value15);
/* 413 */         apply1_4(value15);
/* 414 */       }
/* 415 */
/* 416 */       rowWriter1.setOffsetAndSize(14, tmpCursor31, holder.cursor - tmpCursor31);
/* 417 */     }
/* 418 */
/* 419 */   }
/* 420 */
/* 421 */
/* 422 */   private void apply1_1(InternalRow value15) {
/* 423 */
/* 424 */
/* 425 */     boolean isNull29 = value15.isNullAt(4);
/* 426 */     int value29 = isNull29 ? -1 : value15.getInt(4);
/* 427 */
/* 428 */     if (isNull29) {
/* 429 */       rowWriter4.setNullAt(4);
/* 430 */     } else {
/* 431 */       rowWriter4.write(4, value29);
/* 432 */     }
/* 433 */
/* 434 */
/* 435 */     boolean isNull30 = value15.isNullAt(5);
/* 436 */     double value30 = isNull30 ? -1.0 : value15.getDouble(5);
/* 437 */
/* 438 */     if (isNull30) {
/* 439 */       rowWriter4.setNullAt(5);
/* 440 */     } else {
/* 441 */       rowWriter4.write(5, value30);
/* 442 */     }
/* 443 */
/* 444 */
/* 445 */     boolean isNull31 = value15.isNullAt(6);
/* 446 */     UTF8String value31 = isNull31 ? null : value15.getUTF8String(6);
/* 447 */
/* 448 */     if (isNull31) {
/* 449 */       rowWriter4.setNullAt(6);
/* 450 */     } else {
/* 451 */       rowWriter4.write(6, value31);
/* 452 */     }
/* 453 */
/* 454 */
/* 455 */     boolean isNull32 = value15.isNullAt(7);
/* 456 */     int value32 = isNull32 ? -1 : value15.getInt(7);
/* 457 */
/* 458 */     if (isNull32) {
/* 459 */       rowWriter4.setNullAt(7);
/* 460 */     } else {
/* 461 */       rowWriter4.write(7, value32);
/* 462 */     }
/* 463 */
/* 464 */   }
/* 465 */
/* 466 */
/* 467 */   private void apply2_0(InternalRow element) {
/* 468 */
/* 469 */
/* 470 */     boolean isNull1 = element.isNullAt(0);
/* 471 */     UTF8String value1 = isNull1 ? null : element.getUTF8String(0);
/* 472 */
/* 473 */     if (isNull1) {
/* 474 */       rowWriter1.setNullAt(0);
/* 475 */     } else {
/* 476 */       rowWriter1.write(0, value1);
/* 477 */     }
/* 478 */
/* 479 */
/* 480 */     boolean isNull2 = element.isNullAt(1);
/* 481 */     UTF8String value2 = isNull2 ? null : element.getUTF8String(1);
/* 482 */
/* 483 */     if (isNull2) {
/* 484 */       rowWriter1.setNullAt(1);
/* 485 */     } else {
/* 486 */       rowWriter1.write(1, value2);
/* 487 */     }
/* 488 */
/* 489 */
/* 490 */     boolean isNull3 = element.isNullAt(2);
/* 491 */     MapData value3 = isNull3 ? null : element.getMap(2);
/* 492 */
/* 493 */     if (isNull3) {
/* 494 */       rowWriter1.setNullAt(2);
/* 495 */     } else {
/* 496 */       // Remember the current cursor so that we can calculate how many bytes are
/* 497 */       // written later.
/* 498 */       final int tmpCursor4 = holder.cursor;
/* 499 */
/* 500 */       if (value3 instanceof UnsafeMapData) {
/* 501 */
/* 502 */         final int sizeInBytes1 = ((UnsafeMapData) value3).getSizeInBytes();
/* 503 */         // grow the global buffer before writing data.
/* 504 */         holder.grow(sizeInBytes1);
/* 505 */         ((UnsafeMapData) value3).writeToMemory(holder.buffer, holder.cursor);
/* 506 */         holder.cursor += sizeInBytes1;
/* 507 */
/* 508 */       } else {
/* 509 */         final ArrayData keys = value3.keyArray();
/* 510 */         final ArrayData values = value3.valueArray();
/* 511 */
/* 512 */         // preserve 8 bytes to write the key array numBytes later.
/* 513 */         holder.grow(8);
/* 514 */         holder.cursor += 8;
/* 515 */
/* 516 */         // Remember the current cursor so that we can write numBytes of key array later.
/* 517 */         final int tmpCursor5 = holder.cursor;
/* 518 */
/* 519 */
/* 520 */         if (keys instanceof UnsafeArrayData) {
/* 521 */
/* 522 */           final int sizeInBytes2 = ((UnsafeArrayData) keys).getSizeInBytes();
/* 523 */           // grow the global buffer before writing data.
/* 524 */           holder.grow(sizeInBytes2);
/* 525 */           ((UnsafeArrayData) keys).writeToMemory(holder.buffer, holder.cursor);
/* 526 */           holder.cursor += sizeInBytes2;
/* 527 */
/* 528 */         } else {
/* 529 */           final int numElements1 = keys.numElements();
/* 530 */           arrayWriter1.initialize(holder, numElements1, 8);
/* 531 */
/* 532 */           for (int index1 = 0; index1 < numElements1; index1++) {
/* 533 */             if (keys.isNullAt(index1)) {
/* 534 */               arrayWriter1.setNull(index1);
/* 535 */             } else {
/* 536 */               final UTF8String element1 = keys.getUTF8String(index1);
/* 537 */               arrayWriter1.write(index1, element1);
/* 538 */             }
/* 539 */           }
/* 540 */         }
/* 541 */
/* 542 */         // Write the numBytes of key array into the first 8 bytes.
/* 543 */         Platform.putLong(holder.buffer, tmpCursor5 - 8, holder.cursor - tmpCursor5);
/* 544 */
/* 545 */
/* 546 */         if (values instanceof UnsafeArrayData) {
/* 547 */
/* 548 */           final int sizeInBytes3 = ((UnsafeArrayData) values).getSizeInBytes();
/* 549 */           // grow the global buffer before writing data.
/* 550 */           holder.grow(sizeInBytes3);
/* 551 */           ((UnsafeArrayData) values).writeToMemory(holder.buffer, holder.cursor);
/* 552 */           holder.cursor += sizeInBytes3;
/* 553 */
/* 554 */         } else {
/* 555 */           final int numElements2 = values.numElements();
/* 556 */           arrayWriter2.initialize(holder, numElements2, 8);
/* 557 */
/* 558 */           for (int index2 = 0; index2 < numElements2; index2++) {
/* 559 */             if (values.isNullAt(index2)) {
/* 560 */               arrayWriter2.setNull(index2);
/* 561 */             } else {
/* 562 */               final UTF8String element2 = values.getUTF8String(index2);
/* 563 */               arrayWriter2.write(index2, element2);
/* 564 */             }
/* 565 */           }
/* 566 */         }
/* 567 */
/* 568 */       }
/* 569 */
/* 570 */       rowWriter1.setOffsetAndSize(2, tmpCursor4, holder.cursor - tmpCursor4);
/* 571 */     }
/* 572 */
/* 573 */   }
/* 574 */
/* 575 */
/* 576 */   private void init_1() {
/* 577 */     this.rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 2);
/* 578 */     this.rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 20);
/* 579 */     this.rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 4);
/* 580 */
/* 581 */   }
/* 582 */
/* 583 */
/* 584 */   private void apply_0(InternalRow element5) {
/* 585 */
/* 586 */
/* 587 */     boolean isNull17 = element5.isNullAt(0);
/* 588 */     UTF8String value17 = isNull17 ? null : element5.getUTF8String(0);
/* 589 */
/* 590 */     if (isNull17) {
/* 591 */       rowWriter2.setNullAt(0);
/* 592 */     } else {
/* 593 */       rowWriter2.write(0, value17);
/* 594 */     }
/* 595 */
/* 596 */
/* 597 */     boolean isNull18 = element5.isNullAt(1);
/* 598 */     UTF8String value18 = isNull18 ? null : element5.getUTF8String(1);
/* 599 */
/* 600 */     if (isNull18) {
/* 601 */       rowWriter2.setNullAt(1);
/* 602 */     } else {
/* 603 */       rowWriter2.write(1, value18);
/* 604 */     }
/* 605 */
/* 606 */
/* 607 */     boolean isNull19 = element5.isNullAt(2);
/* 608 */     int value19 = isNull19 ? -1 : element5.getInt(2);
/* 609 */
/* 610 */     if (isNull19) {
/* 611 */       rowWriter2.setNullAt(2);
/* 612 */     } else {
/* 613 */       rowWriter2.write(2, value19);
/* 614 */     }
/* 615 */
/* 616 */
/* 617 */     boolean isNull20 = element5.isNullAt(3);
/* 618 */     ArrayData value20 = isNull20 ? null : element5.getArray(3);
/* 619 */
/* 620 */     if (isNull20) {
/* 621 */       rowWriter2.setNullAt(3);
/* 622 */     } else {
/* 623 */       // Remember the current cursor so that we can calculate how many bytes are
/* 624 */       // written later.
/* 625 */       final int tmpCursor23 = holder.cursor;
/* 626 */
/* 627 */       if (value20 instanceof UnsafeArrayData) {
/* 628 */
/* 629 */         final int sizeInBytes7 = ((UnsafeArrayData) value20).getSizeInBytes();
/* 630 */         // grow the global buffer before writing data.
/* 631 */         holder.grow(sizeInBytes7);
/* 632 */         ((UnsafeArrayData) value20).writeToMemory(holder.buffer, holder.cursor);
/* 633 */         holder.cursor += sizeInBytes7;
/* 634 */
/* 635 */       } else {
/* 636 */         final int numElements6 = value20.numElements();
/* 637 */         arrayWriter6.initialize(holder, numElements6, 4);
/* 638 */
/* 639 */         for (int index6 = 0; index6 < numElements6; index6++) {
/* 640 */           if (value20.isNullAt(index6)) {
/* 641 */             arrayWriter6.setNullInt(index6);
/* 642 */           } else {
/* 643 */             final int element6 = value20.getInt(index6);
/* 644 */             arrayWriter6.write(index6, element6);
/* 645 */           }
/* 646 */         }
/* 647 */       }
/* 648 */
/* 649 */       rowWriter2.setOffsetAndSize(3, tmpCursor23, holder.cursor - tmpCursor23);
/* 650 */     }
/* 651 */
/* 652 */   }
/* 653 */
/* 654 */
/* 655 */   private void apply1_3(InternalRow value15) {
/* 656 */
/* 657 */
/* 658 */     boolean isNull37 = value15.isNullAt(12);
/* 659 */     int value37 = isNull37 ? -1 : value15.getInt(12);
/* 660 */
/* 661 */     if (isNull37) {
/* 662 */       rowWriter4.setNullAt(12);
/* 663 */     } else {
/* 664 */       rowWriter4.write(12, value37);
/* 665 */     }
/* 666 */
/* 667 */
/* 668 */     boolean isNull38 = value15.isNullAt(13);
/* 669 */     int value38 = isNull38 ? -1 : value15.getInt(13);
/* 670 */
/* 671 */     if (isNull38) {
/* 672 */       rowWriter4.setNullAt(13);
/* 673 */     } else {
/* 674 */       rowWriter4.write(13, value38);
/* 675 */     }
/* 676 */
/* 677 */
/* 678 */     boolean isNull39 = value15.isNullAt(14);
/* 679 */     int value39 = isNull39 ? -1 : value15.getInt(14);
/* 680 */
/* 681 */     if (isNull39) {
/* 682 */       rowWriter4.setNullAt(14);
/* 683 */     } else {
/* 684 */       rowWriter4.write(14, value39);
/* 685 */     }
/* 686 */
/* 687 */
/* 688 */     boolean isNull40 = value15.isNullAt(15);
/* 689 */     int value40 = isNull40 ? -1 : value15.getInt(15);
/* 690 */
/* 691 */     if (isNull40) {
/* 692 */       rowWriter4.setNullAt(15);
/* 693 */     } else {
/* 694 */       rowWriter4.write(15, value40);
/* 695 */     }
/* 696 */
/* 697 */   }
/* 698 */
/* 699 */
/* 700 */   private void apply2_2(InternalRow element) {
/* 701 */
/* 702 */
/* 703 */     boolean isNull5 = element.isNullAt(4);
/* 704 */     ArrayData value5 = isNull5 ? null : element.getArray(4);
/* 705 */
/* 706 */     if (isNull5) {
/* 707 */       rowWriter1.setNullAt(4);
/* 708 */     } else {
/* 709 */       // Remember the current cursor so that we can calculate how many bytes are
/* 710 */       // written later.
/* 711 */       final int tmpCursor10 = holder.cursor;
/* 712 */
/* 713 */       if (value5 instanceof UnsafeArrayData) {
/* 714 */
/* 715 */         final int sizeInBytes5 = ((UnsafeArrayData) value5).getSizeInBytes();
/* 716 */         // grow the global buffer before writing data.
/* 717 */         holder.grow(sizeInBytes5);
/* 718 */         ((UnsafeArrayData) value5).writeToMemory(holder.buffer, holder.cursor);
/* 719 */         holder.cursor += sizeInBytes5;
/* 720 */
/* 721 */       } else {
/* 722 */         final int numElements4 = value5.numElements();
/* 723 */         arrayWriter4.initialize(holder, numElements4, 8);
/* 724 */
/* 725 */         for (int index4 = 0; index4 < numElements4; index4++) {
/* 726 */           if (value5.isNullAt(index4)) {
/* 727 */             arrayWriter4.setNull(index4);
/* 728 */           } else {
/* 729 */             final UTF8String element4 = value5.getUTF8String(index4);
/* 730 */             arrayWriter4.write(index4, element4);
/* 731 */           }
/* 732 */         }
/* 733 */       }
/* 734 */
/* 735 */       rowWriter1.setOffsetAndSize(4, tmpCursor10, holder.cursor - tmpCursor10);
/* 736 */     }
/* 737 */
/* 738 */   }
/* 739 */
/* 740 */
/* 741 */   private void init_0() {
/* 742 */     result = new UnsafeRow(1);
/* 743 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 32);
/* 744 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 1);
/* 745 */     this.arrayWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 746 */     this.rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 16);
/* 747 */     this.arrayWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 748 */     this.arrayWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 749 */     this.arrayWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 750 */     this.arrayWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 751 */     this.arrayWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 752 */     this.rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 6);
/* 753 */     this.arrayWriter6 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 754 */
/* 755 */   }
/* 756 */
/* 757 */
/* 758 */   private void apply2_5(InternalRow element) {
/* 759 */
/* 760 */
/* 761 */     boolean isNull13 = element.isNullAt(12);
/* 762 */     UTF8String value13 = isNull13 ? null : element.getUTF8String(12);
/* 763 */
/* 764 */     if (isNull13) {
/* 765 */       rowWriter1.setNullAt(12);
/* 766 */     } else {
/* 767 */       rowWriter1.write(12, value13);
/* 768 */     }
/* 769 */
/* 770 */
/* 771 */     boolean isNull14 = element.isNullAt(13);
/* 772 */     InternalRow value14 = isNull14 ? null : element.getStruct(13, 2);
/* 773 */
/* 774 */     if (isNull14) {
/* 775 */       rowWriter1.setNullAt(13);
/* 776 */     } else {
/* 777 */       // Remember the current cursor so that we can calculate how many bytes are
/* 778 */       // written later.
/* 779 */       final int tmpCursor28 = holder.cursor;
/* 780 */
/* 781 */       if (value14 instanceof UnsafeRow) {
/* 782 */
/* 783 */         final int sizeInBytes9 = ((UnsafeRow) value14).getSizeInBytes();
/* 784 */         // grow the global buffer before writing data.
/* 785 */         holder.grow(sizeInBytes9);
/* 786 */         ((UnsafeRow) value14).writeToMemory(holder.buffer, holder.cursor);
/* 787 */         holder.cursor += sizeInBytes9;
/* 788 */
/* 789 */       } else {
/* 790 */         rowWriter3.reset();
/* 791 */
/* 792 */
/* 793 */         boolean isNull23 = value14.isNullAt(0);
/* 794 */         UTF8String value23 = isNull23 ? null : value14.getUTF8String(0);
/* 795 */
/* 796 */         if (isNull23) {
/* 797 */           rowWriter3.setNullAt(0);
/* 798 */         } else {
/* 799 */           rowWriter3.write(0, value23);
/* 800 */         }
/* 801 */
/* 802 */
/* 803 */         boolean isNull24 = value14.isNullAt(1);
/* 804 */         UTF8String value24 = isNull24 ? null : value14.getUTF8String(1);
/* 805 */
/* 806 */         if (isNull24) {
/* 807 */           rowWriter3.setNullAt(1);
/* 808 */         } else {
/* 809 */           rowWriter3.write(1, value24);
/* 810 */         }
/* 811 */       }
/* 812 */
/* 813 */       rowWriter1.setOffsetAndSize(13, tmpCursor28, holder.cursor - tmpCursor28);
/* 814 */     }
/* 815 */
/* 816 */   }
/* 817 */
/* 818 */
/* 819 */   private void apply1_0(InternalRow value15) {
/* 820 */
/* 821 */
/* 822 */     boolean isNull25 = value15.isNullAt(0);
/* 823 */     int value25 = isNull25 ? -1 : value15.getInt(0);
/* 824 */
/* 825 */     if (isNull25) {
/* 826 */       rowWriter4.setNullAt(0);
/* 827 */     } else {
/* 828 */       rowWriter4.write(0, value25);
/* 829 */     }
/* 830 */
/* 831 */
/* 832 */     boolean isNull26 = value15.isNullAt(1);
/* 833 */     long value26 = isNull26 ? -1L : value15.getLong(1);
/* 834 */
/* 835 */     if (isNull26) {
/* 836 */       rowWriter4.setNullAt(1);
/* 837 */     } else {
/* 838 */       rowWriter4.write(1, value26);
/* 839 */     }
/* 840 */
/* 841 */
/* 842 */     boolean isNull27 = value15.isNullAt(2);
/* 843 */     long value27 = isNull27 ? -1L : value15.getLong(2);
/* 844 */
/* 845 */     if (isNull27) {
/* 846 */       rowWriter4.setNullAt(2);
/* 847 */     } else {
/* 848 */       rowWriter4.write(2, value27);
/* 849 */     }
/* 850 */
/* 851 */
/* 852 */     boolean isNull28 = value15.isNullAt(3);
/* 853 */     int value28 = isNull28 ? -1 : value15.getInt(3);
/* 854 */
/* 855 */     if (isNull28) {
/* 856 */       rowWriter4.setNullAt(3);
/* 857 */     } else {
/* 858 */       rowWriter4.write(3, value28);
/* 859 */     }
/* 860 */
/* 861 */   }
/* 862 */
/* 863 */
/* 864 */   // Scala.Function1 need this
/* 865 */   public java.lang.Object apply(java.lang.Object row) {
/* 866 */     return apply((InternalRow) row);
/* 867 */   }
/* 868 */
/* 869 */   public UnsafeRow apply(InternalRow i) {
/* 870 */     holder.reset();
/* 871 */
/* 872 */     rowWriter.zeroOutNullBytes();
/* 873 */
/* 874 */
/* 875 */     boolean isNull = i.isNullAt(0);
/* 876 */     ArrayData value = isNull ? null : (i.getArray(0));
/* 877 */     if (isNull) {
/* 878 */       rowWriter.setNullAt(0);
/* 879 */     } else {
/* 880 */       // Remember the current cursor so that we can calculate how many bytes are
/* 881 */       // written later.
/* 882 */       final int tmpCursor = holder.cursor;
/* 883 */
/* 884 */       if (value instanceof UnsafeArrayData) {
/* 885 */
/* 886 */         final int sizeInBytes12 = ((UnsafeArrayData) value).getSizeInBytes();
/* 887 */         // grow the global buffer before writing data.
/* 888 */         holder.grow(sizeInBytes12);
/* 889 */         ((UnsafeArrayData) value).writeToMemory(holder.buffer, holder.cursor);
/* 890 */         holder.cursor += sizeInBytes12;
/* 891 */
/* 892 */       } else {
/* 893 */         final int numElements = value.numElements();
/* 894 */         arrayWriter.initialize(holder, numElements, 8);
/* 895 */
/* 896 */         for (int index = 0; index < numElements; index++) {
/* 897 */           if (value.isNullAt(index)) {
/* 898 */             arrayWriter.setNull(index);
/* 899 */           } else {
/* 900 */             final InternalRow element = value.getStruct(index, 16);
/* 901 */
/* 902 */             final int tmpCursor1 = holder.cursor;
/* 903 */
/* 904 */             if (element instanceof UnsafeRow) {
/* 905 */
/* 906 */               final int sizeInBytes = ((UnsafeRow) element).getSizeInBytes();
/* 907 */               // grow the global buffer before writing data.
/* 908 */               holder.grow(sizeInBytes);
/* 909 */               ((UnsafeRow) element).writeToMemory(holder.buffer, holder.cursor);
/* 910 */               holder.cursor += sizeInBytes;
/* 911 */
/* 912 */             } else {
/* 913 */               rowWriter1.reset();
/* 914 */               apply2_0(element);
/* 915 */               apply2_1(element);
/* 916 */               apply2_2(element);
/* 917 */               apply2_3(element);
/* 918 */               apply2_4(element);
/* 919 */               apply2_5(element);
/* 920 */               apply2_6(element);
/* 921 */               apply2_7(element);
/* 922 */             }
/* 923 */
/* 924 */             arrayWriter.setOffsetAndSize(index, tmpCursor1, holder.cursor - tmpCursor1);
/* 925 */
/* 926 */           }
/* 927 */         }
/* 928 */       }
/* 929 */
/* 930 */       rowWriter.setOffsetAndSize(0, tmpCursor, holder.cursor - tmpCursor);
/* 931 */     }
/* 932 */     result.setTotalSize(holder.totalSize());
/* 933 */     return result;
/* 934 */   }
/* 935 */ }

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
/* 011 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter1;
/* 012 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter;
/* 013 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter1;
/* 014 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter2;
/* 015 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter3;
/* 016 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter4;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter2;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter5;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter3;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter4;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter5;
/* 022 */
/* 023 */   public SpecificUnsafeProjection(Object[] references) {
/* 024 */     this.references = references;
/* 025 */     init_0();
/* 026 */     init_1();
/* 027 */   }
/* 028 */
/* 029 */   public void initialize(int partitionIndex) {
/* 030 */
/* 031 */   }
/* 032 */
/* 033 */
/* 034 */   private void apply1_2(InternalRow value15) {
/* 035 */
/* 036 */
/* 037 */     boolean isNull33 = value15.isNullAt(8);
/* 038 */     int value33 = isNull33 ? -1 : value15.getInt(8);
/* 039 */
/* 040 */     if (isNull33) {
/* 041 */       rowWriter4.setNullAt(8);
/* 042 */     } else {
/* 043 */       rowWriter4.write(8, value33);
/* 044 */     }
/* 045 */
/* 046 */
/* 047 */     boolean isNull34 = value15.isNullAt(9);
/* 048 */     int value34 = isNull34 ? -1 : value15.getInt(9);
/* 049 */
/* 050 */     if (isNull34) {
/* 051 */       rowWriter4.setNullAt(9);
/* 052 */     } else {
/* 053 */       rowWriter4.write(9, value34);
/* 054 */     }
/* 055 */
/* 056 */
/* 057 */     boolean isNull35 = value15.isNullAt(10);
/* 058 */     UTF8String value35 = isNull35 ? null : value15.getUTF8String(10);
/* 059 */
/* 060 */     if (isNull35) {
/* 061 */       rowWriter4.setNullAt(10);
/* 062 */     } else {
/* 063 */       rowWriter4.write(10, value35);
/* 064 */     }
/* 065 */
/* 066 */
/* 067 */     boolean isNull36 = value15.isNullAt(11);
/* 068 */     int value36 = isNull36 ? -1 : value15.getInt(11);
/* 069 */
/* 070 */     if (isNull36) {
/* 071 */       rowWriter4.setNullAt(11);
/* 072 */     } else {
/* 073 */       rowWriter4.write(11, value36);
/* 074 */     }
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */
/* 079 */   private void apply2_1(InternalRow value) {
/* 080 */
/* 081 */
/* 082 */     boolean isNull4 = value.isNullAt(3);
/* 083 */     ArrayData value4 = isNull4 ? null : value.getArray(3);
/* 084 */
/* 085 */     if (isNull4) {
/* 086 */       rowWriter1.setNullAt(3);
/* 087 */     } else {
/* 088 */       // Remember the current cursor so that we can calculate how many bytes are
/* 089 */       // written later.
/* 090 */       final int tmpCursor7 = holder.cursor;
/* 091 */
/* 092 */       if (value4 instanceof UnsafeArrayData) {
/* 093 */
/* 094 */         final int sizeInBytes4 = ((UnsafeArrayData) value4).getSizeInBytes();
/* 095 */         // grow the global buffer before writing data.
/* 096 */         holder.grow(sizeInBytes4);
/* 097 */         ((UnsafeArrayData) value4).writeToMemory(holder.buffer, holder.cursor);
/* 098 */         holder.cursor += sizeInBytes4;
/* 099 */
/* 100 */       } else {
/* 101 */         final int numElements2 = value4.numElements();
/* 102 */         arrayWriter2.initialize(holder, numElements2, 8);
/* 103 */
/* 104 */         for (int index2 = 0; index2 < numElements2; index2++) {
/* 105 */           if (value4.isNullAt(index2)) {
/* 106 */             arrayWriter2.setNull(index2);
/* 107 */           } else {
/* 108 */             final UTF8String element2 = value4.getUTF8String(index2);
/* 109 */             arrayWriter2.write(index2, element2);
/* 110 */           }
/* 111 */         }
/* 112 */       }
/* 113 */
/* 114 */       rowWriter1.setOffsetAndSize(3, tmpCursor7, holder.cursor - tmpCursor7);
/* 115 */     }
/* 116 */
/* 117 */   }
/* 118 */
/* 119 */
/* 120 */   private void apply2_4(InternalRow value) {
/* 121 */
/* 122 */
/* 123 */     boolean isNull10 = value.isNullAt(9);
/* 124 */     double value10 = isNull10 ? -1.0 : value.getDouble(9);
/* 125 */
/* 126 */     if (isNull10) {
/* 127 */       rowWriter1.setNullAt(9);
/* 128 */     } else {
/* 129 */       rowWriter1.write(9, value10);
/* 130 */     }
/* 131 */
/* 132 */
/* 133 */     boolean isNull11 = value.isNullAt(10);
/* 134 */     long value11 = isNull11 ? -1L : value.getLong(10);
/* 135 */
/* 136 */     if (isNull11) {
/* 137 */       rowWriter1.setNullAt(10);
/* 138 */     } else {
/* 139 */       rowWriter1.write(10, value11);
/* 140 */     }
/* 141 */
/* 142 */
/* 143 */     boolean isNull12 = value.isNullAt(11);
/* 144 */     ArrayData value12 = isNull12 ? null : value.getArray(11);
/* 145 */
/* 146 */     if (isNull12) {
/* 147 */       rowWriter1.setNullAt(11);
/* 148 */     } else {
/* 149 */       // Remember the current cursor so that we can calculate how many bytes are
/* 150 */       // written later.
/* 151 */       final int tmpCursor17 = holder.cursor;
/* 152 */
/* 153 */       if (value12 instanceof UnsafeArrayData) {
/* 154 */
/* 155 */         final int sizeInBytes8 = ((UnsafeArrayData) value12).getSizeInBytes();
/* 156 */         // grow the global buffer before writing data.
/* 157 */         holder.grow(sizeInBytes8);
/* 158 */         ((UnsafeArrayData) value12).writeToMemory(holder.buffer, holder.cursor);
/* 159 */         holder.cursor += sizeInBytes8;
/* 160 */
/* 161 */       } else {
/* 162 */         final int numElements4 = value12.numElements();
/* 163 */         arrayWriter4.initialize(holder, numElements4, 8);
/* 164 */
/* 165 */         for (int index4 = 0; index4 < numElements4; index4++) {
/* 166 */           if (value12.isNullAt(index4)) {
/* 167 */             arrayWriter4.setNull(index4);
/* 168 */           } else {
/* 169 */             final InternalRow element4 = value12.getStruct(index4, 6);
/* 170 */
/* 171 */             final int tmpCursor18 = holder.cursor;
/* 172 */
/* 173 */             if (element4 instanceof UnsafeRow) {
/* 174 */
/* 175 */               final int sizeInBytes6 = ((UnsafeRow) element4).getSizeInBytes();
/* 176 */               // grow the global buffer before writing data.
/* 177 */               holder.grow(sizeInBytes6);
/* 178 */               ((UnsafeRow) element4).writeToMemory(holder.buffer, holder.cursor);
/* 179 */               holder.cursor += sizeInBytes6;
/* 180 */
/* 181 */             } else {
/* 182 */               rowWriter2.reset();
/* 183 */               apply_0(element4);
/* 184 */               apply_1(element4);
/* 185 */             }
/* 186 */
/* 187 */             arrayWriter4.setOffsetAndSize(index4, tmpCursor18, holder.cursor - tmpCursor18);
/* 188 */
/* 189 */           }
/* 190 */         }
/* 191 */       }
/* 192 */
/* 193 */       rowWriter1.setOffsetAndSize(11, tmpCursor17, holder.cursor - tmpCursor17);
/* 194 */     }
/* 195 */
/* 196 */   }
/* 197 */
/* 198 */
/* 199 */   private void apply_1(InternalRow element4) {
/* 200 */
/* 201 */
/* 202 */     boolean isNull21 = element4.isNullAt(4);
/* 203 */     double value21 = isNull21 ? -1.0 : element4.getDouble(4);
/* 204 */
/* 205 */     if (isNull21) {
/* 206 */       rowWriter2.setNullAt(4);
/* 207 */     } else {
/* 208 */       rowWriter2.write(4, value21);
/* 209 */     }
/* 210 */
/* 211 */
/* 212 */     boolean isNull22 = element4.isNullAt(5);
/* 213 */     double value22 = isNull22 ? -1.0 : element4.getDouble(5);
/* 214 */
/* 215 */     if (isNull22) {
/* 216 */       rowWriter2.setNullAt(5);
/* 217 */     } else {
/* 218 */       rowWriter2.write(5, value22);
/* 219 */     }
/* 220 */
/* 221 */   }
/* 222 */
/* 223 */
/* 224 */   private void apply1_4(InternalRow value15) {
/* 225 */
/* 226 */
/* 227 */     boolean isNull41 = value15.isNullAt(16);
/* 228 */     UTF8String value41 = isNull41 ? null : value15.getUTF8String(16);
/* 229 */
/* 230 */     if (isNull41) {
/* 231 */       rowWriter4.setNullAt(16);
/* 232 */     } else {
/* 233 */       rowWriter4.write(16, value41);
/* 234 */     }
/* 235 */
/* 236 */
/* 237 */     boolean isNull42 = value15.isNullAt(17);
/* 238 */     double value42 = isNull42 ? -1.0 : value15.getDouble(17);
/* 239 */
/* 240 */     if (isNull42) {
/* 241 */       rowWriter4.setNullAt(17);
/* 242 */     } else {
/* 243 */       rowWriter4.write(17, value42);
/* 244 */     }
/* 245 */
/* 246 */
/* 247 */     boolean isNull43 = value15.isNullAt(18);
/* 248 */     int value43 = isNull43 ? -1 : value15.getInt(18);
/* 249 */
/* 250 */     if (isNull43) {
/* 251 */       rowWriter4.setNullAt(18);
/* 252 */     } else {
/* 253 */       rowWriter4.write(18, value43);
/* 254 */     }
/* 255 */
/* 256 */
/* 257 */     boolean isNull44 = value15.isNullAt(19);
/* 258 */     double value44 = isNull44 ? -1.0 : value15.getDouble(19);
/* 259 */
/* 260 */     if (isNull44) {
/* 261 */       rowWriter4.setNullAt(19);
/* 262 */     } else {
/* 263 */       rowWriter4.write(19, value44);
/* 264 */     }
/* 265 */
/* 266 */   }
/* 267 */
/* 268 */
/* 269 */   private void apply2_3(InternalRow value) {
/* 270 */
/* 271 */
/* 272 */     boolean isNull6 = value.isNullAt(5);
/* 273 */     double value6 = isNull6 ? -1.0 : value.getDouble(5);
/* 274 */
/* 275 */     if (isNull6) {
/* 276 */       rowWriter1.setNullAt(5);
/* 277 */     } else {
/* 278 */       rowWriter1.write(5, value6);
/* 279 */     }
/* 280 */
/* 281 */
/* 282 */     boolean isNull7 = value.isNullAt(6);
/* 283 */     double value7 = isNull7 ? -1.0 : value.getDouble(6);
/* 284 */
/* 285 */     if (isNull7) {
/* 286 */       rowWriter1.setNullAt(6);
/* 287 */     } else {
/* 288 */       rowWriter1.write(6, value7);
/* 289 */     }
/* 290 */
/* 291 */
/* 292 */     boolean isNull8 = value.isNullAt(7);
/* 293 */     double value8 = isNull8 ? -1.0 : value.getDouble(7);
/* 294 */
/* 295 */     if (isNull8) {
/* 296 */       rowWriter1.setNullAt(7);
/* 297 */     } else {
/* 298 */       rowWriter1.write(7, value8);
/* 299 */     }
/* 300 */
/* 301 */
/* 302 */     boolean isNull9 = value.isNullAt(8);
/* 303 */     double value9 = isNull9 ? -1.0 : value.getDouble(8);
/* 304 */
/* 305 */     if (isNull9) {
/* 306 */       rowWriter1.setNullAt(8);
/* 307 */     } else {
/* 308 */       rowWriter1.write(8, value9);
/* 309 */     }
/* 310 */
/* 311 */   }
/* 312 */
/* 313 */
/* 314 */   private void apply2_6(InternalRow value) {
/* 315 */
/* 316 */
/* 317 */     boolean isNull15 = value.isNullAt(14);
/* 318 */     InternalRow value15 = isNull15 ? null : value.getStruct(14, 20);
/* 319 */
/* 320 */     if (isNull15) {
/* 321 */       rowWriter1.setNullAt(14);
/* 322 */     } else {
/* 323 */       // Remember the current cursor so that we can calculate how many bytes are
/* 324 */       // written later.
/* 325 */       final int tmpCursor30 = holder.cursor;
/* 326 */
/* 327 */       if (value15 instanceof UnsafeRow) {
/* 328 */
/* 329 */         final int sizeInBytes10 = ((UnsafeRow) value15).getSizeInBytes();
/* 330 */         // grow the global buffer before writing data.
/* 331 */         holder.grow(sizeInBytes10);
/* 332 */         ((UnsafeRow) value15).writeToMemory(holder.buffer, holder.cursor);
/* 333 */         holder.cursor += sizeInBytes10;
/* 334 */
/* 335 */       } else {
/* 336 */         rowWriter4.reset();
/* 337 */         apply1_0(value15);
/* 338 */         apply1_1(value15);
/* 339 */         apply1_2(value15);
/* 340 */         apply1_3(value15);
/* 341 */         apply1_4(value15);
/* 342 */       }
/* 343 */
/* 344 */       rowWriter1.setOffsetAndSize(14, tmpCursor30, holder.cursor - tmpCursor30);
/* 345 */     }
/* 346 */
/* 347 */
/* 348 */     boolean isNull16 = value.isNullAt(15);
/* 349 */     InternalRow value16 = isNull16 ? null : value.getStruct(15, 4);
/* 350 */
/* 351 */     if (isNull16) {
/* 352 */       rowWriter1.setNullAt(15);
/* 353 */     } else {
/* 354 */       // Remember the current cursor so that we can calculate how many bytes are
/* 355 */       // written later.
/* 356 */       final int tmpCursor51 = holder.cursor;
/* 357 */
/* 358 */       if (value16 instanceof UnsafeRow) {
/* 359 */
/* 360 */         final int sizeInBytes11 = ((UnsafeRow) value16).getSizeInBytes();
/* 361 */         // grow the global buffer before writing data.
/* 362 */         holder.grow(sizeInBytes11);
/* 363 */         ((UnsafeRow) value16).writeToMemory(holder.buffer, holder.cursor);
/* 364 */         holder.cursor += sizeInBytes11;
/* 365 */
/* 366 */       } else {
/* 367 */         rowWriter5.reset();
/* 368 */
/* 369 */
/* 370 */         boolean isNull45 = value16.isNullAt(0);
/* 371 */         double value45 = isNull45 ? -1.0 : value16.getDouble(0);
/* 372 */
/* 373 */         if (isNull45) {
/* 374 */           rowWriter5.setNullAt(0);
/* 375 */         } else {
/* 376 */           rowWriter5.write(0, value45);
/* 377 */         }
/* 378 */
/* 379 */
/* 380 */         boolean isNull46 = value16.isNullAt(1);
/* 381 */         double value46 = isNull46 ? -1.0 : value16.getDouble(1);
/* 382 */
/* 383 */         if (isNull46) {
/* 384 */           rowWriter5.setNullAt(1);
/* 385 */         } else {
/* 386 */           rowWriter5.write(1, value46);
/* 387 */         }
/* 388 */
/* 389 */
/* 390 */         boolean isNull47 = value16.isNullAt(2);
/* 391 */         double value47 = isNull47 ? -1.0 : value16.getDouble(2);
/* 392 */
/* 393 */         if (isNull47) {
/* 394 */           rowWriter5.setNullAt(2);
/* 395 */         } else {
/* 396 */           rowWriter5.write(2, value47);
/* 397 */         }
/* 398 */
/* 399 */
/* 400 */         boolean isNull48 = value16.isNullAt(3);
/* 401 */         double value48 = isNull48 ? -1.0 : value16.getDouble(3);
/* 402 */
/* 403 */         if (isNull48) {
/* 404 */           rowWriter5.setNullAt(3);
/* 405 */         } else {
/* 406 */           rowWriter5.write(3, value48);
/* 407 */         }
/* 408 */       }
/* 409 */
/* 410 */       rowWriter1.setOffsetAndSize(15, tmpCursor51, holder.cursor - tmpCursor51);
/* 411 */     }
/* 412 */
/* 413 */   }
/* 414 */
/* 415 */
/* 416 */   private void apply1_1(InternalRow value15) {
/* 417 */
/* 418 */
/* 419 */     boolean isNull29 = value15.isNullAt(4);
/* 420 */     int value29 = isNull29 ? -1 : value15.getInt(4);
/* 421 */
/* 422 */     if (isNull29) {
/* 423 */       rowWriter4.setNullAt(4);
/* 424 */     } else {
/* 425 */       rowWriter4.write(4, value29);
/* 426 */     }
/* 427 */
/* 428 */
/* 429 */     boolean isNull30 = value15.isNullAt(5);
/* 430 */     double value30 = isNull30 ? -1.0 : value15.getDouble(5);
/* 431 */
/* 432 */     if (isNull30) {
/* 433 */       rowWriter4.setNullAt(5);
/* 434 */     } else {
/* 435 */       rowWriter4.write(5, value30);
/* 436 */     }
/* 437 */
/* 438 */
/* 439 */     boolean isNull31 = value15.isNullAt(6);
/* 440 */     UTF8String value31 = isNull31 ? null : value15.getUTF8String(6);
/* 441 */
/* 442 */     if (isNull31) {
/* 443 */       rowWriter4.setNullAt(6);
/* 444 */     } else {
/* 445 */       rowWriter4.write(6, value31);
/* 446 */     }
/* 447 */
/* 448 */
/* 449 */     boolean isNull32 = value15.isNullAt(7);
/* 450 */     int value32 = isNull32 ? -1 : value15.getInt(7);
/* 451 */
/* 452 */     if (isNull32) {
/* 453 */       rowWriter4.setNullAt(7);
/* 454 */     } else {
/* 455 */       rowWriter4.write(7, value32);
/* 456 */     }
/* 457 */
/* 458 */   }
/* 459 */
/* 460 */
/* 461 */   private void apply2_0(InternalRow value) {
/* 462 */
/* 463 */
/* 464 */     boolean isNull1 = value.isNullAt(0);
/* 465 */     UTF8String value1 = isNull1 ? null : value.getUTF8String(0);
/* 466 */
/* 467 */     if (isNull1) {
/* 468 */       rowWriter1.setNullAt(0);
/* 469 */     } else {
/* 470 */       rowWriter1.write(0, value1);
/* 471 */     }
/* 472 */
/* 473 */
/* 474 */     boolean isNull2 = value.isNullAt(1);
/* 475 */     UTF8String value2 = isNull2 ? null : value.getUTF8String(1);
/* 476 */
/* 477 */     if (isNull2) {
/* 478 */       rowWriter1.setNullAt(1);
/* 479 */     } else {
/* 480 */       rowWriter1.write(1, value2);
/* 481 */     }
/* 482 */
/* 483 */
/* 484 */     boolean isNull3 = value.isNullAt(2);
/* 485 */     MapData value3 = isNull3 ? null : value.getMap(2);
/* 486 */
/* 487 */     if (isNull3) {
/* 488 */       rowWriter1.setNullAt(2);
/* 489 */     } else {
/* 490 */       // Remember the current cursor so that we can calculate how many bytes are
/* 491 */       // written later.
/* 492 */       final int tmpCursor3 = holder.cursor;
/* 493 */
/* 494 */       if (value3 instanceof UnsafeMapData) {
/* 495 */
/* 496 */         final int sizeInBytes1 = ((UnsafeMapData) value3).getSizeInBytes();
/* 497 */         // grow the global buffer before writing data.
/* 498 */         holder.grow(sizeInBytes1);
/* 499 */         ((UnsafeMapData) value3).writeToMemory(holder.buffer, holder.cursor);
/* 500 */         holder.cursor += sizeInBytes1;
/* 501 */
/* 502 */       } else {
/* 503 */         final ArrayData keys = value3.keyArray();
/* 504 */         final ArrayData values = value3.valueArray();
/* 505 */
/* 506 */         // preserve 8 bytes to write the key array numBytes later.
/* 507 */         holder.grow(8);
/* 508 */         holder.cursor += 8;
/* 509 */
/* 510 */         // Remember the current cursor so that we can write numBytes of key array later.
/* 511 */         final int tmpCursor4 = holder.cursor;
/* 512 */
/* 513 */
/* 514 */         if (keys instanceof UnsafeArrayData) {
/* 515 */
/* 516 */           final int sizeInBytes2 = ((UnsafeArrayData) keys).getSizeInBytes();
/* 517 */           // grow the global buffer before writing data.
/* 518 */           holder.grow(sizeInBytes2);
/* 519 */           ((UnsafeArrayData) keys).writeToMemory(holder.buffer, holder.cursor);
/* 520 */           holder.cursor += sizeInBytes2;
/* 521 */
/* 522 */         } else {
/* 523 */           final int numElements = keys.numElements();
/* 524 */           arrayWriter.initialize(holder, numElements, 8);
/* 525 */
/* 526 */           for (int index = 0; index < numElements; index++) {
/* 527 */             if (keys.isNullAt(index)) {
/* 528 */               arrayWriter.setNull(index);
/* 529 */             } else {
/* 530 */               final UTF8String element = keys.getUTF8String(index);
/* 531 */               arrayWriter.write(index, element);
/* 532 */             }
/* 533 */           }
/* 534 */         }
/* 535 */
/* 536 */         // Write the numBytes of key array into the first 8 bytes.
/* 537 */         Platform.putLong(holder.buffer, tmpCursor4 - 8, holder.cursor - tmpCursor4);
/* 538 */
/* 539 */
/* 540 */         if (values instanceof UnsafeArrayData) {
/* 541 */
/* 542 */           final int sizeInBytes3 = ((UnsafeArrayData) values).getSizeInBytes();
/* 543 */           // grow the global buffer before writing data.
/* 544 */           holder.grow(sizeInBytes3);
/* 545 */           ((UnsafeArrayData) values).writeToMemory(holder.buffer, holder.cursor);
/* 546 */           holder.cursor += sizeInBytes3;
/* 547 */
/* 548 */         } else {
/* 549 */           final int numElements1 = values.numElements();
/* 550 */           arrayWriter1.initialize(holder, numElements1, 8);
/* 551 */
/* 552 */           for (int index1 = 0; index1 < numElements1; index1++) {
/* 553 */             if (values.isNullAt(index1)) {
/* 554 */               arrayWriter1.setNull(index1);
/* 555 */             } else {
/* 556 */               final UTF8String element1 = values.getUTF8String(index1);
/* 557 */               arrayWriter1.write(index1, element1);
/* 558 */             }
/* 559 */           }
/* 560 */         }
/* 561 */
/* 562 */       }
/* 563 */
/* 564 */       rowWriter1.setOffsetAndSize(2, tmpCursor3, holder.cursor - tmpCursor3);
/* 565 */     }
/* 566 */
/* 567 */   }
/* 568 */
/* 569 */
/* 570 */   private void init_1() {
/* 571 */     this.rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 20);
/* 572 */     this.rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 4);
/* 573 */
/* 574 */   }
/* 575 */
/* 576 */
/* 577 */   private void apply_0(InternalRow element4) {
/* 578 */
/* 579 */
/* 580 */     boolean isNull17 = element4.isNullAt(0);
/* 581 */     UTF8String value17 = isNull17 ? null : element4.getUTF8String(0);
/* 582 */
/* 583 */     if (isNull17) {
/* 584 */       rowWriter2.setNullAt(0);
/* 585 */     } else {
/* 586 */       rowWriter2.write(0, value17);
/* 587 */     }
/* 588 */
/* 589 */
/* 590 */     boolean isNull18 = element4.isNullAt(1);
/* 591 */     UTF8String value18 = isNull18 ? null : element4.getUTF8String(1);
/* 592 */
/* 593 */     if (isNull18) {
/* 594 */       rowWriter2.setNullAt(1);
/* 595 */     } else {
/* 596 */       rowWriter2.write(1, value18);
/* 597 */     }
/* 598 */
/* 599 */
/* 600 */     boolean isNull19 = element4.isNullAt(2);
/* 601 */     int value19 = isNull19 ? -1 : element4.getInt(2);
/* 602 */
/* 603 */     if (isNull19) {
/* 604 */       rowWriter2.setNullAt(2);
/* 605 */     } else {
/* 606 */       rowWriter2.write(2, value19);
/* 607 */     }
/* 608 */
/* 609 */
/* 610 */     boolean isNull20 = element4.isNullAt(3);
/* 611 */     ArrayData value20 = isNull20 ? null : element4.getArray(3);
/* 612 */
/* 613 */     if (isNull20) {
/* 614 */       rowWriter2.setNullAt(3);
/* 615 */     } else {
/* 616 */       // Remember the current cursor so that we can calculate how many bytes are
/* 617 */       // written later.
/* 618 */       final int tmpCursor22 = holder.cursor;
/* 619 */
/* 620 */       if (value20 instanceof UnsafeArrayData) {
/* 621 */
/* 622 */         final int sizeInBytes7 = ((UnsafeArrayData) value20).getSizeInBytes();
/* 623 */         // grow the global buffer before writing data.
/* 624 */         holder.grow(sizeInBytes7);
/* 625 */         ((UnsafeArrayData) value20).writeToMemory(holder.buffer, holder.cursor);
/* 626 */         holder.cursor += sizeInBytes7;
/* 627 */
/* 628 */       } else {
/* 629 */         final int numElements5 = value20.numElements();
/* 630 */         arrayWriter5.initialize(holder, numElements5, 4);
/* 631 */
/* 632 */         for (int index5 = 0; index5 < numElements5; index5++) {
/* 633 */           if (value20.isNullAt(index5)) {
/* 634 */             arrayWriter5.setNullInt(index5);
/* 635 */           } else {
/* 636 */             final int element5 = value20.getInt(index5);
/* 637 */             arrayWriter5.write(index5, element5);
/* 638 */           }
/* 639 */         }
/* 640 */       }
/* 641 */
/* 642 */       rowWriter2.setOffsetAndSize(3, tmpCursor22, holder.cursor - tmpCursor22);
/* 643 */     }
/* 644 */
/* 645 */   }
/* 646 */
/* 647 */
/* 648 */   private void apply1_3(InternalRow value15) {
/* 649 */
/* 650 */
/* 651 */     boolean isNull37 = value15.isNullAt(12);
/* 652 */     int value37 = isNull37 ? -1 : value15.getInt(12);
/* 653 */
/* 654 */     if (isNull37) {
/* 655 */       rowWriter4.setNullAt(12);
/* 656 */     } else {
/* 657 */       rowWriter4.write(12, value37);
/* 658 */     }
/* 659 */
/* 660 */
/* 661 */     boolean isNull38 = value15.isNullAt(13);
/* 662 */     int value38 = isNull38 ? -1 : value15.getInt(13);
/* 663 */
/* 664 */     if (isNull38) {
/* 665 */       rowWriter4.setNullAt(13);
/* 666 */     } else {
/* 667 */       rowWriter4.write(13, value38);
/* 668 */     }
/* 669 */
/* 670 */
/* 671 */     boolean isNull39 = value15.isNullAt(14);
/* 672 */     int value39 = isNull39 ? -1 : value15.getInt(14);
/* 673 */
/* 674 */     if (isNull39) {
/* 675 */       rowWriter4.setNullAt(14);
/* 676 */     } else {
/* 677 */       rowWriter4.write(14, value39);
/* 678 */     }
/* 679 */
/* 680 */
/* 681 */     boolean isNull40 = value15.isNullAt(15);
/* 682 */     int value40 = isNull40 ? -1 : value15.getInt(15);
/* 683 */
/* 684 */     if (isNull40) {
/* 685 */       rowWriter4.setNullAt(15);
/* 686 */     } else {
/* 687 */       rowWriter4.write(15, value40);
/* 688 */     }
/* 689 */
/* 690 */   }
/* 691 */
/* 692 */
/* 693 */   private void apply2_2(InternalRow value) {
/* 694 */
/* 695 */
/* 696 */     boolean isNull5 = value.isNullAt(4);
/* 697 */     ArrayData value5 = isNull5 ? null : value.getArray(4);
/* 698 */
/* 699 */     if (isNull5) {
/* 700 */       rowWriter1.setNullAt(4);
/* 701 */     } else {
/* 702 */       // Remember the current cursor so that we can calculate how many bytes are
/* 703 */       // written later.
/* 704 */       final int tmpCursor9 = holder.cursor;
/* 705 */
/* 706 */       if (value5 instanceof UnsafeArrayData) {
/* 707 */
/* 708 */         final int sizeInBytes5 = ((UnsafeArrayData) value5).getSizeInBytes();
/* 709 */         // grow the global buffer before writing data.
/* 710 */         holder.grow(sizeInBytes5);
/* 711 */         ((UnsafeArrayData) value5).writeToMemory(holder.buffer, holder.cursor);
/* 712 */         holder.cursor += sizeInBytes5;
/* 713 */
/* 714 */       } else {
/* 715 */         final int numElements3 = value5.numElements();
/* 716 */         arrayWriter3.initialize(holder, numElements3, 8);
/* 717 */
/* 718 */         for (int index3 = 0; index3 < numElements3; index3++) {
/* 719 */           if (value5.isNullAt(index3)) {
/* 720 */             arrayWriter3.setNull(index3);
/* 721 */           } else {
/* 722 */             final UTF8String element3 = value5.getUTF8String(index3);
/* 723 */             arrayWriter3.write(index3, element3);
/* 724 */           }
/* 725 */         }
/* 726 */       }
/* 727 */
/* 728 */       rowWriter1.setOffsetAndSize(4, tmpCursor9, holder.cursor - tmpCursor9);
/* 729 */     }
/* 730 */
/* 731 */   }
/* 732 */
/* 733 */
/* 734 */   private void init_0() {
/* 735 */     result = new UnsafeRow(1);
/* 736 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 32);
/* 737 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 1);
/* 738 */     this.rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 16);
/* 739 */     this.arrayWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 740 */     this.arrayWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 741 */     this.arrayWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 742 */     this.arrayWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 743 */     this.arrayWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 744 */     this.rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 6);
/* 745 */     this.arrayWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 746 */     this.rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 2);
/* 747 */
/* 748 */   }
/* 749 */
/* 750 */
/* 751 */   private void apply2_5(InternalRow value) {
/* 752 */
/* 753 */
/* 754 */     boolean isNull13 = value.isNullAt(12);
/* 755 */     UTF8String value13 = isNull13 ? null : value.getUTF8String(12);
/* 756 */
/* 757 */     if (isNull13) {
/* 758 */       rowWriter1.setNullAt(12);
/* 759 */     } else {
/* 760 */       rowWriter1.write(12, value13);
/* 761 */     }
/* 762 */
/* 763 */
/* 764 */     boolean isNull14 = value.isNullAt(13);
/* 765 */     InternalRow value14 = isNull14 ? null : value.getStruct(13, 2);
/* 766 */
/* 767 */     if (isNull14) {
/* 768 */       rowWriter1.setNullAt(13);
/* 769 */     } else {
/* 770 */       // Remember the current cursor so that we can calculate how many bytes are
/* 771 */       // written later.
/* 772 */       final int tmpCursor27 = holder.cursor;
/* 773 */
/* 774 */       if (value14 instanceof UnsafeRow) {
/* 775 */
/* 776 */         final int sizeInBytes9 = ((UnsafeRow) value14).getSizeInBytes();
/* 777 */         // grow the global buffer before writing data.
/* 778 */         holder.grow(sizeInBytes9);
/* 779 */         ((UnsafeRow) value14).writeToMemory(holder.buffer, holder.cursor);
/* 780 */         holder.cursor += sizeInBytes9;
/* 781 */
/* 782 */       } else {
/* 783 */         rowWriter3.reset();
/* 784 */
/* 785 */
/* 786 */         boolean isNull23 = value14.isNullAt(0);
/* 787 */         UTF8String value23 = isNull23 ? null : value14.getUTF8String(0);
/* 788 */
/* 789 */         if (isNull23) {
/* 790 */           rowWriter3.setNullAt(0);
/* 791 */         } else {
/* 792 */           rowWriter3.write(0, value23);
/* 793 */         }
/* 794 */
/* 795 */
/* 796 */         boolean isNull24 = value14.isNullAt(1);
/* 797 */         UTF8String value24 = isNull24 ? null : value14.getUTF8String(1);
/* 798 */
/* 799 */         if (isNull24) {
/* 800 */           rowWriter3.setNullAt(1);
/* 801 */         } else {
/* 802 */           rowWriter3.write(1, value24);
/* 803 */         }
/* 804 */       }
/* 805 */
/* 806 */       rowWriter1.setOffsetAndSize(13, tmpCursor27, holder.cursor - tmpCursor27);
/* 807 */     }
/* 808 */
/* 809 */   }
/* 810 */
/* 811 */
/* 812 */   private void apply1_0(InternalRow value15) {
/* 813 */
/* 814 */
/* 815 */     boolean isNull25 = value15.isNullAt(0);
/* 816 */     int value25 = isNull25 ? -1 : value15.getInt(0);
/* 817 */
/* 818 */     if (isNull25) {
/* 819 */       rowWriter4.setNullAt(0);
/* 820 */     } else {
/* 821 */       rowWriter4.write(0, value25);
/* 822 */     }
/* 823 */
/* 824 */
/* 825 */     boolean isNull26 = value15.isNullAt(1);
/* 826 */     long value26 = isNull26 ? -1L : value15.getLong(1);
/* 827 */
/* 828 */     if (isNull26) {
/* 829 */       rowWriter4.setNullAt(1);
/* 830 */     } else {
/* 831 */       rowWriter4.write(1, value26);
/* 832 */     }
/* 833 */
/* 834 */
/* 835 */     boolean isNull27 = value15.isNullAt(2);
/* 836 */     long value27 = isNull27 ? -1L : value15.getLong(2);
/* 837 */
/* 838 */     if (isNull27) {
/* 839 */       rowWriter4.setNullAt(2);
/* 840 */     } else {
/* 841 */       rowWriter4.write(2, value27);
/* 842 */     }
/* 843 */
/* 844 */
/* 845 */     boolean isNull28 = value15.isNullAt(3);
/* 846 */     int value28 = isNull28 ? -1 : value15.getInt(3);
/* 847 */
/* 848 */     if (isNull28) {
/* 849 */       rowWriter4.setNullAt(3);
/* 850 */     } else {
/* 851 */       rowWriter4.write(3, value28);
/* 852 */     }
/* 853 */
/* 854 */   }
/* 855 */
/* 856 */
/* 857 */   // Scala.Function1 need this
/* 858 */   public java.lang.Object apply(java.lang.Object row) {
/* 859 */     return apply((InternalRow) row);
/* 860 */   }
/* 861 */
/* 862 */   public UnsafeRow apply(InternalRow i) {
/* 863 */     holder.reset();
/* 864 */
/* 865 */     rowWriter.zeroOutNullBytes();
/* 866 */
/* 867 */
/* 868 */     boolean isNull = i.isNullAt(0);
/* 869 */     InternalRow value = isNull ? null : (i.getStruct(0, 16));
/* 870 */     if (isNull) {
/* 871 */       rowWriter.setNullAt(0);
/* 872 */     } else {
/* 873 */       // Remember the current cursor so that we can calculate how many bytes are
/* 874 */       // written later.
/* 875 */       final int tmpCursor = holder.cursor;
/* 876 */
/* 877 */       if (value instanceof UnsafeRow) {
/* 878 */
/* 879 */         final int sizeInBytes = ((UnsafeRow) value).getSizeInBytes();
/* 880 */         // grow the global buffer before writing data.
/* 881 */         holder.grow(sizeInBytes);
/* 882 */         ((UnsafeRow) value).writeToMemory(holder.buffer, holder.cursor);
/* 883 */         holder.cursor += sizeInBytes;
/* 884 */
/* 885 */       } else {
/* 886 */         rowWriter1.reset();
/* 887 */         apply2_0(value);
/* 888 */         apply2_1(value);
/* 889 */         apply2_2(value);
/* 890 */         apply2_3(value);
/* 891 */         apply2_4(value);
/* 892 */         apply2_5(value);
/* 893 */         apply2_6(value);
/* 894 */       }
/* 895 */
/* 896 */       rowWriter.setOffsetAndSize(0, tmpCursor, holder.cursor - tmpCursor);
/* 897 */     }
/* 898 */     result.setTotalSize(holder.totalSize());
/* 899 */     return result;
/* 900 */   }
/* 901 */ }

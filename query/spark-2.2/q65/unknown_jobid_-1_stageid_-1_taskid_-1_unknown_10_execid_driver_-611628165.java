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
/* 012 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter1;
/* 013 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter1;
/* 014 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter2;
/* 015 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter3;
/* 016 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter4;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter5;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter6;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter7;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter8;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter2;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter9;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter10;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter11;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter12;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter13;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter3;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter arrayWriter14;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter4;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter5;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter rowWriter6;
/* 032 */
/* 033 */   public SpecificUnsafeProjection(Object[] references) {
/* 034 */     this.references = references;
/* 035 */     init_0();
/* 036 */     init_1();
/* 037 */     init_2();
/* 038 */   }
/* 039 */
/* 040 */   public void initialize(int partitionIndex) {
/* 041 */
/* 042 */   }
/* 043 */
/* 044 */
/* 045 */   private void apply3_6(InternalRow element8) {
/* 046 */
/* 047 */
/* 048 */     boolean isNull24 = element8.isNullAt(14);
/* 049 */     InternalRow value24 = isNull24 ? null : element8.getStruct(14, 20);
/* 050 */
/* 051 */     if (isNull24) {
/* 052 */       rowWriter2.setNullAt(14);
/* 053 */     } else {
/* 054 */       // Remember the current cursor so that we can calculate how many bytes are
/* 055 */       // written later.
/* 056 */       final int tmpCursor52 = holder.cursor;
/* 057 */
/* 058 */       if (value24 instanceof UnsafeRow) {
/* 059 */
/* 060 */         final int sizeInBytes23 = ((UnsafeRow) value24).getSizeInBytes();
/* 061 */         // grow the global buffer before writing data.
/* 062 */         holder.grow(sizeInBytes23);
/* 063 */         ((UnsafeRow) value24).writeToMemory(holder.buffer, holder.cursor);
/* 064 */         holder.cursor += sizeInBytes23;
/* 065 */
/* 066 */       } else {
/* 067 */         rowWriter5.reset();
/* 068 */         apply2_0(value24);
/* 069 */         apply2_1(value24);
/* 070 */         apply2_2(value24);
/* 071 */         apply2_3(value24);
/* 072 */         apply2_4(value24);
/* 073 */       }
/* 074 */
/* 075 */       rowWriter2.setOffsetAndSize(14, tmpCursor52, holder.cursor - tmpCursor52);
/* 076 */     }
/* 077 */
/* 078 */   }
/* 079 */
/* 080 */
/* 081 */   private void apply2_1(InternalRow value24) {
/* 082 */
/* 083 */
/* 084 */     boolean isNull38 = value24.isNullAt(4);
/* 085 */     int value38 = isNull38 ? -1 : value24.getInt(4);
/* 086 */
/* 087 */     if (isNull38) {
/* 088 */       rowWriter5.setNullAt(4);
/* 089 */     } else {
/* 090 */       rowWriter5.write(4, value38);
/* 091 */     }
/* 092 */
/* 093 */
/* 094 */     boolean isNull39 = value24.isNullAt(5);
/* 095 */     double value39 = isNull39 ? -1.0 : value24.getDouble(5);
/* 096 */
/* 097 */     if (isNull39) {
/* 098 */       rowWriter5.setNullAt(5);
/* 099 */     } else {
/* 100 */       rowWriter5.write(5, value39);
/* 101 */     }
/* 102 */
/* 103 */
/* 104 */     boolean isNull40 = value24.isNullAt(6);
/* 105 */     UTF8String value40 = isNull40 ? null : value24.getUTF8String(6);
/* 106 */
/* 107 */     if (isNull40) {
/* 108 */       rowWriter5.setNullAt(6);
/* 109 */     } else {
/* 110 */       rowWriter5.write(6, value40);
/* 111 */     }
/* 112 */
/* 113 */
/* 114 */     boolean isNull41 = value24.isNullAt(7);
/* 115 */     int value41 = isNull41 ? -1 : value24.getInt(7);
/* 116 */
/* 117 */     if (isNull41) {
/* 118 */       rowWriter5.setNullAt(7);
/* 119 */     } else {
/* 120 */       rowWriter5.write(7, value41);
/* 121 */     }
/* 122 */
/* 123 */   }
/* 124 */
/* 125 */
/* 126 */   private void apply3_0(InternalRow element8) {
/* 127 */
/* 128 */
/* 129 */     boolean isNull10 = element8.isNullAt(0);
/* 130 */     UTF8String value10 = isNull10 ? null : element8.getUTF8String(0);
/* 131 */
/* 132 */     if (isNull10) {
/* 133 */       rowWriter2.setNullAt(0);
/* 134 */     } else {
/* 135 */       rowWriter2.write(0, value10);
/* 136 */     }
/* 137 */
/* 138 */
/* 139 */     boolean isNull11 = element8.isNullAt(1);
/* 140 */     UTF8String value11 = isNull11 ? null : element8.getUTF8String(1);
/* 141 */
/* 142 */     if (isNull11) {
/* 143 */       rowWriter2.setNullAt(1);
/* 144 */     } else {
/* 145 */       rowWriter2.write(1, value11);
/* 146 */     }
/* 147 */
/* 148 */
/* 149 */     boolean isNull12 = element8.isNullAt(2);
/* 150 */     MapData value12 = isNull12 ? null : element8.getMap(2);
/* 151 */
/* 152 */     if (isNull12) {
/* 153 */       rowWriter2.setNullAt(2);
/* 154 */     } else {
/* 155 */       // Remember the current cursor so that we can calculate how many bytes are
/* 156 */       // written later.
/* 157 */       final int tmpCursor25 = holder.cursor;
/* 158 */
/* 159 */       if (value12 instanceof UnsafeMapData) {
/* 160 */
/* 161 */         final int sizeInBytes14 = ((UnsafeMapData) value12).getSizeInBytes();
/* 162 */         // grow the global buffer before writing data.
/* 163 */         holder.grow(sizeInBytes14);
/* 164 */         ((UnsafeMapData) value12).writeToMemory(holder.buffer, holder.cursor);
/* 165 */         holder.cursor += sizeInBytes14;
/* 166 */
/* 167 */       } else {
/* 168 */         final ArrayData keys4 = value12.keyArray();
/* 169 */         final ArrayData values4 = value12.valueArray();
/* 170 */
/* 171 */         // preserve 8 bytes to write the key array numBytes later.
/* 172 */         holder.grow(8);
/* 173 */         holder.cursor += 8;
/* 174 */
/* 175 */         // Remember the current cursor so that we can write numBytes of key array later.
/* 176 */         final int tmpCursor26 = holder.cursor;
/* 177 */
/* 178 */
/* 179 */         if (keys4 instanceof UnsafeArrayData) {
/* 180 */
/* 181 */           final int sizeInBytes15 = ((UnsafeArrayData) keys4).getSizeInBytes();
/* 182 */           // grow the global buffer before writing data.
/* 183 */           holder.grow(sizeInBytes15);
/* 184 */           ((UnsafeArrayData) keys4).writeToMemory(holder.buffer, holder.cursor);
/* 185 */           holder.cursor += sizeInBytes15;
/* 186 */
/* 187 */         } else {
/* 188 */           final int numElements9 = keys4.numElements();
/* 189 */           arrayWriter9.initialize(holder, numElements9, 8);
/* 190 */
/* 191 */           for (int index9 = 0; index9 < numElements9; index9++) {
/* 192 */             if (keys4.isNullAt(index9)) {
/* 193 */               arrayWriter9.setNull(index9);
/* 194 */             } else {
/* 195 */               final UTF8String element9 = keys4.getUTF8String(index9);
/* 196 */               arrayWriter9.write(index9, element9);
/* 197 */             }
/* 198 */           }
/* 199 */         }
/* 200 */
/* 201 */         // Write the numBytes of key array into the first 8 bytes.
/* 202 */         Platform.putLong(holder.buffer, tmpCursor26 - 8, holder.cursor - tmpCursor26);
/* 203 */
/* 204 */
/* 205 */         if (values4 instanceof UnsafeArrayData) {
/* 206 */
/* 207 */           final int sizeInBytes16 = ((UnsafeArrayData) values4).getSizeInBytes();
/* 208 */           // grow the global buffer before writing data.
/* 209 */           holder.grow(sizeInBytes16);
/* 210 */           ((UnsafeArrayData) values4).writeToMemory(holder.buffer, holder.cursor);
/* 211 */           holder.cursor += sizeInBytes16;
/* 212 */
/* 213 */         } else {
/* 214 */           final int numElements10 = values4.numElements();
/* 215 */           arrayWriter10.initialize(holder, numElements10, 8);
/* 216 */
/* 217 */           for (int index10 = 0; index10 < numElements10; index10++) {
/* 218 */             if (values4.isNullAt(index10)) {
/* 219 */               arrayWriter10.setNull(index10);
/* 220 */             } else {
/* 221 */               final UTF8String element10 = values4.getUTF8String(index10);
/* 222 */               arrayWriter10.write(index10, element10);
/* 223 */             }
/* 224 */           }
/* 225 */         }
/* 226 */
/* 227 */       }
/* 228 */
/* 229 */       rowWriter2.setOffsetAndSize(2, tmpCursor25, holder.cursor - tmpCursor25);
/* 230 */     }
/* 231 */
/* 232 */   }
/* 233 */
/* 234 */
/* 235 */   private void apply3_3(InternalRow element8) {
/* 236 */
/* 237 */
/* 238 */     boolean isNull15 = element8.isNullAt(5);
/* 239 */     double value15 = isNull15 ? -1.0 : element8.getDouble(5);
/* 240 */
/* 241 */     if (isNull15) {
/* 242 */       rowWriter2.setNullAt(5);
/* 243 */     } else {
/* 244 */       rowWriter2.write(5, value15);
/* 245 */     }
/* 246 */
/* 247 */
/* 248 */     boolean isNull16 = element8.isNullAt(6);
/* 249 */     double value16 = isNull16 ? -1.0 : element8.getDouble(6);
/* 250 */
/* 251 */     if (isNull16) {
/* 252 */       rowWriter2.setNullAt(6);
/* 253 */     } else {
/* 254 */       rowWriter2.write(6, value16);
/* 255 */     }
/* 256 */
/* 257 */
/* 258 */     boolean isNull17 = element8.isNullAt(7);
/* 259 */     double value17 = isNull17 ? -1.0 : element8.getDouble(7);
/* 260 */
/* 261 */     if (isNull17) {
/* 262 */       rowWriter2.setNullAt(7);
/* 263 */     } else {
/* 264 */       rowWriter2.write(7, value17);
/* 265 */     }
/* 266 */
/* 267 */
/* 268 */     boolean isNull18 = element8.isNullAt(8);
/* 269 */     double value18 = isNull18 ? -1.0 : element8.getDouble(8);
/* 270 */
/* 271 */     if (isNull18) {
/* 272 */       rowWriter2.setNullAt(8);
/* 273 */     } else {
/* 274 */       rowWriter2.write(8, value18);
/* 275 */     }
/* 276 */
/* 277 */   }
/* 278 */
/* 279 */
/* 280 */   private void apply2_4(InternalRow value24) {
/* 281 */
/* 282 */
/* 283 */     boolean isNull50 = value24.isNullAt(16);
/* 284 */     UTF8String value50 = isNull50 ? null : value24.getUTF8String(16);
/* 285 */
/* 286 */     if (isNull50) {
/* 287 */       rowWriter5.setNullAt(16);
/* 288 */     } else {
/* 289 */       rowWriter5.write(16, value50);
/* 290 */     }
/* 291 */
/* 292 */
/* 293 */     boolean isNull51 = value24.isNullAt(17);
/* 294 */     double value51 = isNull51 ? -1.0 : value24.getDouble(17);
/* 295 */
/* 296 */     if (isNull51) {
/* 297 */       rowWriter5.setNullAt(17);
/* 298 */     } else {
/* 299 */       rowWriter5.write(17, value51);
/* 300 */     }
/* 301 */
/* 302 */
/* 303 */     boolean isNull52 = value24.isNullAt(18);
/* 304 */     int value52 = isNull52 ? -1 : value24.getInt(18);
/* 305 */
/* 306 */     if (isNull52) {
/* 307 */       rowWriter5.setNullAt(18);
/* 308 */     } else {
/* 309 */       rowWriter5.write(18, value52);
/* 310 */     }
/* 311 */
/* 312 */
/* 313 */     boolean isNull53 = value24.isNullAt(19);
/* 314 */     double value53 = isNull53 ? -1.0 : value24.getDouble(19);
/* 315 */
/* 316 */     if (isNull53) {
/* 317 */       rowWriter5.setNullAt(19);
/* 318 */     } else {
/* 319 */       rowWriter5.write(19, value53);
/* 320 */     }
/* 321 */
/* 322 */   }
/* 323 */
/* 324 */
/* 325 */   private void init_2() {
/* 326 */     this.rowWriter6 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 4);
/* 327 */
/* 328 */   }
/* 329 */
/* 330 */
/* 331 */   private void apply_1(InternalRow value3) {
/* 332 */
/* 333 */
/* 334 */     boolean isNull7 = value3.isNullAt(2);
/* 335 */     MapData value7 = isNull7 ? null : value3.getMap(2);
/* 336 */
/* 337 */     if (isNull7) {
/* 338 */       rowWriter1.setNullAt(2);
/* 339 */     } else {
/* 340 */       // Remember the current cursor so that we can calculate how many bytes are
/* 341 */       // written later.
/* 342 */       final int tmpCursor12 = holder.cursor;
/* 343 */
/* 344 */       if (value7 instanceof UnsafeMapData) {
/* 345 */
/* 346 */         final int sizeInBytes7 = ((UnsafeMapData) value7).getSizeInBytes();
/* 347 */         // grow the global buffer before writing data.
/* 348 */         holder.grow(sizeInBytes7);
/* 349 */         ((UnsafeMapData) value7).writeToMemory(holder.buffer, holder.cursor);
/* 350 */         holder.cursor += sizeInBytes7;
/* 351 */
/* 352 */       } else {
/* 353 */         final ArrayData keys2 = value7.keyArray();
/* 354 */         final ArrayData values2 = value7.valueArray();
/* 355 */
/* 356 */         // preserve 8 bytes to write the key array numBytes later.
/* 357 */         holder.grow(8);
/* 358 */         holder.cursor += 8;
/* 359 */
/* 360 */         // Remember the current cursor so that we can write numBytes of key array later.
/* 361 */         final int tmpCursor13 = holder.cursor;
/* 362 */
/* 363 */
/* 364 */         if (keys2 instanceof UnsafeArrayData) {
/* 365 */
/* 366 */           final int sizeInBytes8 = ((UnsafeArrayData) keys2).getSizeInBytes();
/* 367 */           // grow the global buffer before writing data.
/* 368 */           holder.grow(sizeInBytes8);
/* 369 */           ((UnsafeArrayData) keys2).writeToMemory(holder.buffer, holder.cursor);
/* 370 */           holder.cursor += sizeInBytes8;
/* 371 */
/* 372 */         } else {
/* 373 */           final int numElements4 = keys2.numElements();
/* 374 */           arrayWriter4.initialize(holder, numElements4, 8);
/* 375 */
/* 376 */           for (int index4 = 0; index4 < numElements4; index4++) {
/* 377 */             if (keys2.isNullAt(index4)) {
/* 378 */               arrayWriter4.setNull(index4);
/* 379 */             } else {
/* 380 */               final UTF8String element4 = keys2.getUTF8String(index4);
/* 381 */               arrayWriter4.write(index4, element4);
/* 382 */             }
/* 383 */           }
/* 384 */         }
/* 385 */
/* 386 */         // Write the numBytes of key array into the first 8 bytes.
/* 387 */         Platform.putLong(holder.buffer, tmpCursor13 - 8, holder.cursor - tmpCursor13);
/* 388 */
/* 389 */
/* 390 */         if (values2 instanceof UnsafeArrayData) {
/* 391 */
/* 392 */           final int sizeInBytes9 = ((UnsafeArrayData) values2).getSizeInBytes();
/* 393 */           // grow the global buffer before writing data.
/* 394 */           holder.grow(sizeInBytes9);
/* 395 */           ((UnsafeArrayData) values2).writeToMemory(holder.buffer, holder.cursor);
/* 396 */           holder.cursor += sizeInBytes9;
/* 397 */
/* 398 */         } else {
/* 399 */           final int numElements5 = values2.numElements();
/* 400 */           arrayWriter5.initialize(holder, numElements5, 8);
/* 401 */
/* 402 */           for (int index5 = 0; index5 < numElements5; index5++) {
/* 403 */             if (values2.isNullAt(index5)) {
/* 404 */               arrayWriter5.setNull(index5);
/* 405 */             } else {
/* 406 */               final UTF8String element5 = values2.getUTF8String(index5);
/* 407 */               arrayWriter5.write(index5, element5);
/* 408 */             }
/* 409 */           }
/* 410 */         }
/* 411 */
/* 412 */       }
/* 413 */
/* 414 */       rowWriter1.setOffsetAndSize(2, tmpCursor12, holder.cursor - tmpCursor12);
/* 415 */     }
/* 416 */
/* 417 */   }
/* 418 */
/* 419 */
/* 420 */   private void apply4_1(InternalRow i) {
/* 421 */
/* 422 */
/* 423 */     boolean isNull3 = i.isNullAt(3);
/* 424 */     InternalRow value3 = isNull3 ? null : (i.getStruct(3, 5));
/* 425 */     if (isNull3) {
/* 426 */       rowWriter.setNullAt(3);
/* 427 */     } else {
/* 428 */       // Remember the current cursor so that we can calculate how many bytes are
/* 429 */       // written later.
/* 430 */       final int tmpCursor6 = holder.cursor;
/* 431 */
/* 432 */       if (value3 instanceof UnsafeRow) {
/* 433 */
/* 434 */         final int sizeInBytes3 = ((UnsafeRow) value3).getSizeInBytes();
/* 435 */         // grow the global buffer before writing data.
/* 436 */         holder.grow(sizeInBytes3);
/* 437 */         ((UnsafeRow) value3).writeToMemory(holder.buffer, holder.cursor);
/* 438 */         holder.cursor += sizeInBytes3;
/* 439 */
/* 440 */       } else {
/* 441 */         rowWriter1.reset();
/* 442 */         apply_0(value3);
/* 443 */         apply_1(value3);
/* 444 */         apply_2(value3);
/* 445 */       }
/* 446 */
/* 447 */       rowWriter.setOffsetAndSize(3, tmpCursor6, holder.cursor - tmpCursor6);
/* 448 */     }
/* 449 */
/* 450 */
/* 451 */     boolean isNull4 = i.isNullAt(4);
/* 452 */     ArrayData value4 = isNull4 ? null : (i.getArray(4));
/* 453 */     if (isNull4) {
/* 454 */       rowWriter.setNullAt(4);
/* 455 */     } else {
/* 456 */       // Remember the current cursor so that we can calculate how many bytes are
/* 457 */       // written later.
/* 458 */       final int tmpCursor21 = holder.cursor;
/* 459 */
/* 460 */       if (value4 instanceof UnsafeArrayData) {
/* 461 */
/* 462 */         final int sizeInBytes25 = ((UnsafeArrayData) value4).getSizeInBytes();
/* 463 */         // grow the global buffer before writing data.
/* 464 */         holder.grow(sizeInBytes25);
/* 465 */         ((UnsafeArrayData) value4).writeToMemory(holder.buffer, holder.cursor);
/* 466 */         holder.cursor += sizeInBytes25;
/* 467 */
/* 468 */       } else {
/* 469 */         final int numElements8 = value4.numElements();
/* 470 */         arrayWriter8.initialize(holder, numElements8, 8);
/* 471 */
/* 472 */         for (int index8 = 0; index8 < numElements8; index8++) {
/* 473 */           if (value4.isNullAt(index8)) {
/* 474 */             arrayWriter8.setNull(index8);
/* 475 */           } else {
/* 476 */             final InternalRow element8 = value4.getStruct(index8, 16);
/* 477 */
/* 478 */             final int tmpCursor22 = holder.cursor;
/* 479 */
/* 480 */             if (element8 instanceof UnsafeRow) {
/* 481 */
/* 482 */               final int sizeInBytes13 = ((UnsafeRow) element8).getSizeInBytes();
/* 483 */               // grow the global buffer before writing data.
/* 484 */               holder.grow(sizeInBytes13);
/* 485 */               ((UnsafeRow) element8).writeToMemory(holder.buffer, holder.cursor);
/* 486 */               holder.cursor += sizeInBytes13;
/* 487 */
/* 488 */             } else {
/* 489 */               rowWriter2.reset();
/* 490 */               apply3_0(element8);
/* 491 */               apply3_1(element8);
/* 492 */               apply3_2(element8);
/* 493 */               apply3_3(element8);
/* 494 */               apply3_4(element8);
/* 495 */               apply3_5(element8);
/* 496 */               apply3_6(element8);
/* 497 */               apply3_7(element8);
/* 498 */             }
/* 499 */
/* 500 */             arrayWriter8.setOffsetAndSize(index8, tmpCursor22, holder.cursor - tmpCursor22);
/* 501 */
/* 502 */           }
/* 503 */         }
/* 504 */       }
/* 505 */
/* 506 */       rowWriter.setOffsetAndSize(4, tmpCursor21, holder.cursor - tmpCursor21);
/* 507 */     }
/* 508 */
/* 509 */   }
/* 510 */
/* 511 */
/* 512 */   private void apply2_3(InternalRow value24) {
/* 513 */
/* 514 */
/* 515 */     boolean isNull46 = value24.isNullAt(12);
/* 516 */     int value46 = isNull46 ? -1 : value24.getInt(12);
/* 517 */
/* 518 */     if (isNull46) {
/* 519 */       rowWriter5.setNullAt(12);
/* 520 */     } else {
/* 521 */       rowWriter5.write(12, value46);
/* 522 */     }
/* 523 */
/* 524 */
/* 525 */     boolean isNull47 = value24.isNullAt(13);
/* 526 */     int value47 = isNull47 ? -1 : value24.getInt(13);
/* 527 */
/* 528 */     if (isNull47) {
/* 529 */       rowWriter5.setNullAt(13);
/* 530 */     } else {
/* 531 */       rowWriter5.write(13, value47);
/* 532 */     }
/* 533 */
/* 534 */
/* 535 */     boolean isNull48 = value24.isNullAt(14);
/* 536 */     int value48 = isNull48 ? -1 : value24.getInt(14);
/* 537 */
/* 538 */     if (isNull48) {
/* 539 */       rowWriter5.setNullAt(14);
/* 540 */     } else {
/* 541 */       rowWriter5.write(14, value48);
/* 542 */     }
/* 543 */
/* 544 */
/* 545 */     boolean isNull49 = value24.isNullAt(15);
/* 546 */     int value49 = isNull49 ? -1 : value24.getInt(15);
/* 547 */
/* 548 */     if (isNull49) {
/* 549 */       rowWriter5.setNullAt(15);
/* 550 */     } else {
/* 551 */       rowWriter5.write(15, value49);
/* 552 */     }
/* 553 */
/* 554 */   }
/* 555 */
/* 556 */
/* 557 */   private void apply3_2(InternalRow element8) {
/* 558 */
/* 559 */
/* 560 */     boolean isNull14 = element8.isNullAt(4);
/* 561 */     ArrayData value14 = isNull14 ? null : element8.getArray(4);
/* 562 */
/* 563 */     if (isNull14) {
/* 564 */       rowWriter2.setNullAt(4);
/* 565 */     } else {
/* 566 */       // Remember the current cursor so that we can calculate how many bytes are
/* 567 */       // written later.
/* 568 */       final int tmpCursor31 = holder.cursor;
/* 569 */
/* 570 */       if (value14 instanceof UnsafeArrayData) {
/* 571 */
/* 572 */         final int sizeInBytes18 = ((UnsafeArrayData) value14).getSizeInBytes();
/* 573 */         // grow the global buffer before writing data.
/* 574 */         holder.grow(sizeInBytes18);
/* 575 */         ((UnsafeArrayData) value14).writeToMemory(holder.buffer, holder.cursor);
/* 576 */         holder.cursor += sizeInBytes18;
/* 577 */
/* 578 */       } else {
/* 579 */         final int numElements12 = value14.numElements();
/* 580 */         arrayWriter12.initialize(holder, numElements12, 8);
/* 581 */
/* 582 */         for (int index12 = 0; index12 < numElements12; index12++) {
/* 583 */           if (value14.isNullAt(index12)) {
/* 584 */             arrayWriter12.setNull(index12);
/* 585 */           } else {
/* 586 */             final UTF8String element12 = value14.getUTF8String(index12);
/* 587 */             arrayWriter12.write(index12, element12);
/* 588 */           }
/* 589 */         }
/* 590 */       }
/* 591 */
/* 592 */       rowWriter2.setOffsetAndSize(4, tmpCursor31, holder.cursor - tmpCursor31);
/* 593 */     }
/* 594 */
/* 595 */   }
/* 596 */
/* 597 */
/* 598 */   private void apply3_5(InternalRow element8) {
/* 599 */
/* 600 */
/* 601 */     boolean isNull22 = element8.isNullAt(12);
/* 602 */     UTF8String value22 = isNull22 ? null : element8.getUTF8String(12);
/* 603 */
/* 604 */     if (isNull22) {
/* 605 */       rowWriter2.setNullAt(12);
/* 606 */     } else {
/* 607 */       rowWriter2.write(12, value22);
/* 608 */     }
/* 609 */
/* 610 */
/* 611 */     boolean isNull23 = element8.isNullAt(13);
/* 612 */     InternalRow value23 = isNull23 ? null : element8.getStruct(13, 2);
/* 613 */
/* 614 */     if (isNull23) {
/* 615 */       rowWriter2.setNullAt(13);
/* 616 */     } else {
/* 617 */       // Remember the current cursor so that we can calculate how many bytes are
/* 618 */       // written later.
/* 619 */       final int tmpCursor49 = holder.cursor;
/* 620 */
/* 621 */       if (value23 instanceof UnsafeRow) {
/* 622 */
/* 623 */         final int sizeInBytes22 = ((UnsafeRow) value23).getSizeInBytes();
/* 624 */         // grow the global buffer before writing data.
/* 625 */         holder.grow(sizeInBytes22);
/* 626 */         ((UnsafeRow) value23).writeToMemory(holder.buffer, holder.cursor);
/* 627 */         holder.cursor += sizeInBytes22;
/* 628 */
/* 629 */       } else {
/* 630 */         rowWriter4.reset();
/* 631 */
/* 632 */
/* 633 */         boolean isNull32 = value23.isNullAt(0);
/* 634 */         UTF8String value32 = isNull32 ? null : value23.getUTF8String(0);
/* 635 */
/* 636 */         if (isNull32) {
/* 637 */           rowWriter4.setNullAt(0);
/* 638 */         } else {
/* 639 */           rowWriter4.write(0, value32);
/* 640 */         }
/* 641 */
/* 642 */
/* 643 */         boolean isNull33 = value23.isNullAt(1);
/* 644 */         UTF8String value33 = isNull33 ? null : value23.getUTF8String(1);
/* 645 */
/* 646 */         if (isNull33) {
/* 647 */           rowWriter4.setNullAt(1);
/* 648 */         } else {
/* 649 */           rowWriter4.write(1, value33);
/* 650 */         }
/* 651 */       }
/* 652 */
/* 653 */       rowWriter2.setOffsetAndSize(13, tmpCursor49, holder.cursor - tmpCursor49);
/* 654 */     }
/* 655 */
/* 656 */   }
/* 657 */
/* 658 */
/* 659 */   private void apply1_1(InternalRow element13) {
/* 660 */
/* 661 */
/* 662 */     boolean isNull30 = element13.isNullAt(4);
/* 663 */     double value30 = isNull30 ? -1.0 : element13.getDouble(4);
/* 664 */
/* 665 */     if (isNull30) {
/* 666 */       rowWriter3.setNullAt(4);
/* 667 */     } else {
/* 668 */       rowWriter3.write(4, value30);
/* 669 */     }
/* 670 */
/* 671 */
/* 672 */     boolean isNull31 = element13.isNullAt(5);
/* 673 */     double value31 = isNull31 ? -1.0 : element13.getDouble(5);
/* 674 */
/* 675 */     if (isNull31) {
/* 676 */       rowWriter3.setNullAt(5);
/* 677 */     } else {
/* 678 */       rowWriter3.write(5, value31);
/* 679 */     }
/* 680 */
/* 681 */   }
/* 682 */
/* 683 */
/* 684 */   private void apply2_0(InternalRow value24) {
/* 685 */
/* 686 */
/* 687 */     boolean isNull34 = value24.isNullAt(0);
/* 688 */     int value34 = isNull34 ? -1 : value24.getInt(0);
/* 689 */
/* 690 */     if (isNull34) {
/* 691 */       rowWriter5.setNullAt(0);
/* 692 */     } else {
/* 693 */       rowWriter5.write(0, value34);
/* 694 */     }
/* 695 */
/* 696 */
/* 697 */     boolean isNull35 = value24.isNullAt(1);
/* 698 */     long value35 = isNull35 ? -1L : value24.getLong(1);
/* 699 */
/* 700 */     if (isNull35) {
/* 701 */       rowWriter5.setNullAt(1);
/* 702 */     } else {
/* 703 */       rowWriter5.write(1, value35);
/* 704 */     }
/* 705 */
/* 706 */
/* 707 */     boolean isNull36 = value24.isNullAt(2);
/* 708 */     long value36 = isNull36 ? -1L : value24.getLong(2);
/* 709 */
/* 710 */     if (isNull36) {
/* 711 */       rowWriter5.setNullAt(2);
/* 712 */     } else {
/* 713 */       rowWriter5.write(2, value36);
/* 714 */     }
/* 715 */
/* 716 */
/* 717 */     boolean isNull37 = value24.isNullAt(3);
/* 718 */     int value37 = isNull37 ? -1 : value24.getInt(3);
/* 719 */
/* 720 */     if (isNull37) {
/* 721 */       rowWriter5.setNullAt(3);
/* 722 */     } else {
/* 723 */       rowWriter5.write(3, value37);
/* 724 */     }
/* 725 */
/* 726 */   }
/* 727 */
/* 728 */
/* 729 */   private void init_1() {
/* 730 */     this.arrayWriter8 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 731 */     this.rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 16);
/* 732 */     this.arrayWriter9 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 733 */     this.arrayWriter10 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 734 */     this.arrayWriter11 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 735 */     this.arrayWriter12 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 736 */     this.arrayWriter13 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 737 */     this.rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 6);
/* 738 */     this.arrayWriter14 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 739 */     this.rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 2);
/* 740 */     this.rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 20);
/* 741 */
/* 742 */   }
/* 743 */
/* 744 */
/* 745 */   private void apply_0(InternalRow value3) {
/* 746 */
/* 747 */
/* 748 */     boolean isNull5 = value3.isNullAt(0);
/* 749 */     UTF8String value5 = isNull5 ? null : value3.getUTF8String(0);
/* 750 */
/* 751 */     if (isNull5) {
/* 752 */       rowWriter1.setNullAt(0);
/* 753 */     } else {
/* 754 */       rowWriter1.write(0, value5);
/* 755 */     }
/* 756 */
/* 757 */
/* 758 */     boolean isNull6 = value3.isNullAt(1);
/* 759 */     MapData value6 = isNull6 ? null : value3.getMap(1);
/* 760 */
/* 761 */     if (isNull6) {
/* 762 */       rowWriter1.setNullAt(1);
/* 763 */     } else {
/* 764 */       // Remember the current cursor so that we can calculate how many bytes are
/* 765 */       // written later.
/* 766 */       final int tmpCursor8 = holder.cursor;
/* 767 */
/* 768 */       if (value6 instanceof UnsafeMapData) {
/* 769 */
/* 770 */         final int sizeInBytes4 = ((UnsafeMapData) value6).getSizeInBytes();
/* 771 */         // grow the global buffer before writing data.
/* 772 */         holder.grow(sizeInBytes4);
/* 773 */         ((UnsafeMapData) value6).writeToMemory(holder.buffer, holder.cursor);
/* 774 */         holder.cursor += sizeInBytes4;
/* 775 */
/* 776 */       } else {
/* 777 */         final ArrayData keys1 = value6.keyArray();
/* 778 */         final ArrayData values1 = value6.valueArray();
/* 779 */
/* 780 */         // preserve 8 bytes to write the key array numBytes later.
/* 781 */         holder.grow(8);
/* 782 */         holder.cursor += 8;
/* 783 */
/* 784 */         // Remember the current cursor so that we can write numBytes of key array later.
/* 785 */         final int tmpCursor9 = holder.cursor;
/* 786 */
/* 787 */
/* 788 */         if (keys1 instanceof UnsafeArrayData) {
/* 789 */
/* 790 */           final int sizeInBytes5 = ((UnsafeArrayData) keys1).getSizeInBytes();
/* 791 */           // grow the global buffer before writing data.
/* 792 */           holder.grow(sizeInBytes5);
/* 793 */           ((UnsafeArrayData) keys1).writeToMemory(holder.buffer, holder.cursor);
/* 794 */           holder.cursor += sizeInBytes5;
/* 795 */
/* 796 */         } else {
/* 797 */           final int numElements2 = keys1.numElements();
/* 798 */           arrayWriter2.initialize(holder, numElements2, 8);
/* 799 */
/* 800 */           for (int index2 = 0; index2 < numElements2; index2++) {
/* 801 */             if (keys1.isNullAt(index2)) {
/* 802 */               arrayWriter2.setNull(index2);
/* 803 */             } else {
/* 804 */               final UTF8String element2 = keys1.getUTF8String(index2);
/* 805 */               arrayWriter2.write(index2, element2);
/* 806 */             }
/* 807 */           }
/* 808 */         }
/* 809 */
/* 810 */         // Write the numBytes of key array into the first 8 bytes.
/* 811 */         Platform.putLong(holder.buffer, tmpCursor9 - 8, holder.cursor - tmpCursor9);
/* 812 */
/* 813 */
/* 814 */         if (values1 instanceof UnsafeArrayData) {
/* 815 */
/* 816 */           final int sizeInBytes6 = ((UnsafeArrayData) values1).getSizeInBytes();
/* 817 */           // grow the global buffer before writing data.
/* 818 */           holder.grow(sizeInBytes6);
/* 819 */           ((UnsafeArrayData) values1).writeToMemory(holder.buffer, holder.cursor);
/* 820 */           holder.cursor += sizeInBytes6;
/* 821 */
/* 822 */         } else {
/* 823 */           final int numElements3 = values1.numElements();
/* 824 */           arrayWriter3.initialize(holder, numElements3, 8);
/* 825 */
/* 826 */           for (int index3 = 0; index3 < numElements3; index3++) {
/* 827 */             if (values1.isNullAt(index3)) {
/* 828 */               arrayWriter3.setNull(index3);
/* 829 */             } else {
/* 830 */               final UTF8String element3 = values1.getUTF8String(index3);
/* 831 */               arrayWriter3.write(index3, element3);
/* 832 */             }
/* 833 */           }
/* 834 */         }
/* 835 */
/* 836 */       }
/* 837 */
/* 838 */       rowWriter1.setOffsetAndSize(1, tmpCursor8, holder.cursor - tmpCursor8);
/* 839 */     }
/* 840 */
/* 841 */   }
/* 842 */
/* 843 */
/* 844 */   private void apply3_7(InternalRow element8) {
/* 845 */
/* 846 */
/* 847 */     boolean isNull25 = element8.isNullAt(15);
/* 848 */     InternalRow value25 = isNull25 ? null : element8.getStruct(15, 4);
/* 849 */
/* 850 */     if (isNull25) {
/* 851 */       rowWriter2.setNullAt(15);
/* 852 */     } else {
/* 853 */       // Remember the current cursor so that we can calculate how many bytes are
/* 854 */       // written later.
/* 855 */       final int tmpCursor73 = holder.cursor;
/* 856 */
/* 857 */       if (value25 instanceof UnsafeRow) {
/* 858 */
/* 859 */         final int sizeInBytes24 = ((UnsafeRow) value25).getSizeInBytes();
/* 860 */         // grow the global buffer before writing data.
/* 861 */         holder.grow(sizeInBytes24);
/* 862 */         ((UnsafeRow) value25).writeToMemory(holder.buffer, holder.cursor);
/* 863 */         holder.cursor += sizeInBytes24;
/* 864 */
/* 865 */       } else {
/* 866 */         rowWriter6.reset();
/* 867 */
/* 868 */
/* 869 */         boolean isNull54 = value25.isNullAt(0);
/* 870 */         double value54 = isNull54 ? -1.0 : value25.getDouble(0);
/* 871 */
/* 872 */         if (isNull54) {
/* 873 */           rowWriter6.setNullAt(0);
/* 874 */         } else {
/* 875 */           rowWriter6.write(0, value54);
/* 876 */         }
/* 877 */
/* 878 */
/* 879 */         boolean isNull55 = value25.isNullAt(1);
/* 880 */         double value55 = isNull55 ? -1.0 : value25.getDouble(1);
/* 881 */
/* 882 */         if (isNull55) {
/* 883 */           rowWriter6.setNullAt(1);
/* 884 */         } else {
/* 885 */           rowWriter6.write(1, value55);
/* 886 */         }
/* 887 */
/* 888 */
/* 889 */         boolean isNull56 = value25.isNullAt(2);
/* 890 */         double value56 = isNull56 ? -1.0 : value25.getDouble(2);
/* 891 */
/* 892 */         if (isNull56) {
/* 893 */           rowWriter6.setNullAt(2);
/* 894 */         } else {
/* 895 */           rowWriter6.write(2, value56);
/* 896 */         }
/* 897 */
/* 898 */
/* 899 */         boolean isNull57 = value25.isNullAt(3);
/* 900 */         double value57 = isNull57 ? -1.0 : value25.getDouble(3);
/* 901 */
/* 902 */         if (isNull57) {
/* 903 */           rowWriter6.setNullAt(3);
/* 904 */         } else {
/* 905 */           rowWriter6.write(3, value57);
/* 906 */         }
/* 907 */       }
/* 908 */
/* 909 */       rowWriter2.setOffsetAndSize(15, tmpCursor73, holder.cursor - tmpCursor73);
/* 910 */     }
/* 911 */
/* 912 */   }
/* 913 */
/* 914 */
/* 915 */   private void apply2_2(InternalRow value24) {
/* 916 */
/* 917 */
/* 918 */     boolean isNull42 = value24.isNullAt(8);
/* 919 */     int value42 = isNull42 ? -1 : value24.getInt(8);
/* 920 */
/* 921 */     if (isNull42) {
/* 922 */       rowWriter5.setNullAt(8);
/* 923 */     } else {
/* 924 */       rowWriter5.write(8, value42);
/* 925 */     }
/* 926 */
/* 927 */
/* 928 */     boolean isNull43 = value24.isNullAt(9);
/* 929 */     int value43 = isNull43 ? -1 : value24.getInt(9);
/* 930 */
/* 931 */     if (isNull43) {
/* 932 */       rowWriter5.setNullAt(9);
/* 933 */     } else {
/* 934 */       rowWriter5.write(9, value43);
/* 935 */     }
/* 936 */
/* 937 */
/* 938 */     boolean isNull44 = value24.isNullAt(10);
/* 939 */     UTF8String value44 = isNull44 ? null : value24.getUTF8String(10);
/* 940 */
/* 941 */     if (isNull44) {
/* 942 */       rowWriter5.setNullAt(10);
/* 943 */     } else {
/* 944 */       rowWriter5.write(10, value44);
/* 945 */     }
/* 946 */
/* 947 */
/* 948 */     boolean isNull45 = value24.isNullAt(11);
/* 949 */     int value45 = isNull45 ? -1 : value24.getInt(11);
/* 950 */
/* 951 */     if (isNull45) {
/* 952 */       rowWriter5.setNullAt(11);
/* 953 */     } else {
/* 954 */       rowWriter5.write(11, value45);
/* 955 */     }
/* 956 */
/* 957 */   }
/* 958 */
/* 959 */
/* 960 */   private void apply3_1(InternalRow element8) {
/* 961 */
/* 962 */
/* 963 */     boolean isNull13 = element8.isNullAt(3);
/* 964 */     ArrayData value13 = isNull13 ? null : element8.getArray(3);
/* 965 */
/* 966 */     if (isNull13) {
/* 967 */       rowWriter2.setNullAt(3);
/* 968 */     } else {
/* 969 */       // Remember the current cursor so that we can calculate how many bytes are
/* 970 */       // written later.
/* 971 */       final int tmpCursor29 = holder.cursor;
/* 972 */
/* 973 */       if (value13 instanceof UnsafeArrayData) {
/* 974 */
/* 975 */         final int sizeInBytes17 = ((UnsafeArrayData) value13).getSizeInBytes();
/* 976 */         // grow the global buffer before writing data.
/* 977 */         holder.grow(sizeInBytes17);
/* 978 */         ((UnsafeArrayData) value13).writeToMemory(holder.buffer, holder.cursor);
/* 979 */         holder.cursor += sizeInBytes17;
/* 980 */
/* 981 */       } else {
/* 982 */         final int numElements11 = value13.numElements();
/* 983 */         arrayWriter11.initialize(holder, numElements11, 8);
/* 984 */
/* 985 */         for (int index11 = 0; index11 < numElements11; index11++) {
/* 986 */           if (value13.isNullAt(index11)) {
/* 987 */             arrayWriter11.setNull(index11);
/* 988 */           } else {
/* 989 */             final UTF8String element11 = value13.getUTF8String(index11);
/* 990 */             arrayWriter11.write(index11, element11);
/* 991 */           }
/* 992 */         }
/* 993 */       }
/* 994 */
/* 995 */       rowWriter2.setOffsetAndSize(3, tmpCursor29, holder.cursor - tmpCursor29);
/* 996 */     }
/* 997 */
/* 998 */   }
/* 999 */
/* 1000 */
/* 1001 */   private void init_0() {
/* 1002 */     result = new UnsafeRow(5);
/* 1003 */     this.holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(result, 96);
/* 1004 */     this.rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 5);
/* 1005 */     this.arrayWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 1006 */     this.arrayWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 1007 */     this.rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(holder, 5);
/* 1008 */     this.arrayWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 1009 */     this.arrayWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 1010 */     this.arrayWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 1011 */     this.arrayWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 1012 */     this.arrayWriter6 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 1013 */     this.arrayWriter7 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeArrayWriter();
/* 1014 */
/* 1015 */   }
/* 1016 */
/* 1017 */
/* 1018 */   private void apply4_0(InternalRow i) {
/* 1019 */
/* 1020 */
/* 1021 */     long value = i.getLong(0);
/* 1022 */     rowWriter.write(0, value);
/* 1023 */
/* 1024 */
/* 1025 */     int value1 = i.getInt(1);
/* 1026 */     rowWriter.write(1, value1);
/* 1027 */
/* 1028 */
/* 1029 */     boolean isNull2 = i.isNullAt(2);
/* 1030 */     MapData value2 = isNull2 ? null : (i.getMap(2));
/* 1031 */     if (isNull2) {
/* 1032 */       rowWriter.setNullAt(2);
/* 1033 */     } else {
/* 1034 */       // Remember the current cursor so that we can calculate how many bytes are
/* 1035 */       // written later.
/* 1036 */       final int tmpCursor2 = holder.cursor;
/* 1037 */
/* 1038 */       if (value2 instanceof UnsafeMapData) {
/* 1039 */
/* 1040 */         final int sizeInBytes = ((UnsafeMapData) value2).getSizeInBytes();
/* 1041 */         // grow the global buffer before writing data.
/* 1042 */         holder.grow(sizeInBytes);
/* 1043 */         ((UnsafeMapData) value2).writeToMemory(holder.buffer, holder.cursor);
/* 1044 */         holder.cursor += sizeInBytes;
/* 1045 */
/* 1046 */       } else {
/* 1047 */         final ArrayData keys = value2.keyArray();
/* 1048 */         final ArrayData values = value2.valueArray();
/* 1049 */
/* 1050 */         // preserve 8 bytes to write the key array numBytes later.
/* 1051 */         holder.grow(8);
/* 1052 */         holder.cursor += 8;
/* 1053 */
/* 1054 */         // Remember the current cursor so that we can write numBytes of key array later.
/* 1055 */         final int tmpCursor3 = holder.cursor;
/* 1056 */
/* 1057 */
/* 1058 */         if (keys instanceof UnsafeArrayData) {
/* 1059 */
/* 1060 */           final int sizeInBytes1 = ((UnsafeArrayData) keys).getSizeInBytes();
/* 1061 */           // grow the global buffer before writing data.
/* 1062 */           holder.grow(sizeInBytes1);
/* 1063 */           ((UnsafeArrayData) keys).writeToMemory(holder.buffer, holder.cursor);
/* 1064 */           holder.cursor += sizeInBytes1;
/* 1065 */
/* 1066 */         } else {
/* 1067 */           final int numElements = keys.numElements();
/* 1068 */           arrayWriter.initialize(holder, numElements, 8);
/* 1069 */
/* 1070 */           for (int index = 0; index < numElements; index++) {
/* 1071 */             if (keys.isNullAt(index)) {
/* 1072 */               arrayWriter.setNull(index);
/* 1073 */             } else {
/* 1074 */               final UTF8String element = keys.getUTF8String(index);
/* 1075 */               arrayWriter.write(index, element);
/* 1076 */             }
/* 1077 */           }
/* 1078 */         }
/* 1079 */
/* 1080 */         // Write the numBytes of key array into the first 8 bytes.
/* 1081 */         Platform.putLong(holder.buffer, tmpCursor3 - 8, holder.cursor - tmpCursor3);
/* 1082 */
/* 1083 */
/* 1084 */         if (values instanceof UnsafeArrayData) {
/* 1085 */
/* 1086 */           final int sizeInBytes2 = ((UnsafeArrayData) values).getSizeInBytes();
/* 1087 */           // grow the global buffer before writing data.
/* 1088 */           holder.grow(sizeInBytes2);
/* 1089 */           ((UnsafeArrayData) values).writeToMemory(holder.buffer, holder.cursor);
/* 1090 */           holder.cursor += sizeInBytes2;
/* 1091 */
/* 1092 */         } else {
/* 1093 */           final int numElements1 = values.numElements();
/* 1094 */           arrayWriter1.initialize(holder, numElements1, 8);
/* 1095 */
/* 1096 */           for (int index1 = 0; index1 < numElements1; index1++) {
/* 1097 */             if (values.isNullAt(index1)) {
/* 1098 */               arrayWriter1.setNull(index1);
/* 1099 */             } else {
/* 1100 */               final UTF8String element1 = values.getUTF8String(index1);
/* 1101 */               arrayWriter1.write(index1, element1);
/* 1102 */             }
/* 1103 */           }
/* 1104 */         }
/* 1105 */
/* 1106 */       }
/* 1107 */
/* 1108 */       rowWriter.setOffsetAndSize(2, tmpCursor2, holder.cursor - tmpCursor2);
/* 1109 */     }
/* 1110 */
/* 1111 */   }
/* 1112 */
/* 1113 */
/* 1114 */   private void apply3_4(InternalRow element8) {
/* 1115 */
/* 1116 */
/* 1117 */     boolean isNull19 = element8.isNullAt(9);
/* 1118 */     double value19 = isNull19 ? -1.0 : element8.getDouble(9);
/* 1119 */
/* 1120 */     if (isNull19) {
/* 1121 */       rowWriter2.setNullAt(9);
/* 1122 */     } else {
/* 1123 */       rowWriter2.write(9, value19);
/* 1124 */     }
/* 1125 */
/* 1126 */
/* 1127 */     boolean isNull20 = element8.isNullAt(10);
/* 1128 */     long value20 = isNull20 ? -1L : element8.getLong(10);
/* 1129 */
/* 1130 */     if (isNull20) {
/* 1131 */       rowWriter2.setNullAt(10);
/* 1132 */     } else {
/* 1133 */       rowWriter2.write(10, value20);
/* 1134 */     }
/* 1135 */
/* 1136 */
/* 1137 */     boolean isNull21 = element8.isNullAt(11);
/* 1138 */     ArrayData value21 = isNull21 ? null : element8.getArray(11);
/* 1139 */
/* 1140 */     if (isNull21) {
/* 1141 */       rowWriter2.setNullAt(11);
/* 1142 */     } else {
/* 1143 */       // Remember the current cursor so that we can calculate how many bytes are
/* 1144 */       // written later.
/* 1145 */       final int tmpCursor39 = holder.cursor;
/* 1146 */
/* 1147 */       if (value21 instanceof UnsafeArrayData) {
/* 1148 */
/* 1149 */         final int sizeInBytes21 = ((UnsafeArrayData) value21).getSizeInBytes();
/* 1150 */         // grow the global buffer before writing data.
/* 1151 */         holder.grow(sizeInBytes21);
/* 1152 */         ((UnsafeArrayData) value21).writeToMemory(holder.buffer, holder.cursor);
/* 1153 */         holder.cursor += sizeInBytes21;
/* 1154 */
/* 1155 */       } else {
/* 1156 */         final int numElements13 = value21.numElements();
/* 1157 */         arrayWriter13.initialize(holder, numElements13, 8);
/* 1158 */
/* 1159 */         for (int index13 = 0; index13 < numElements13; index13++) {
/* 1160 */           if (value21.isNullAt(index13)) {
/* 1161 */             arrayWriter13.setNull(index13);
/* 1162 */           } else {
/* 1163 */             final InternalRow element13 = value21.getStruct(index13, 6);
/* 1164 */
/* 1165 */             final int tmpCursor40 = holder.cursor;
/* 1166 */
/* 1167 */             if (element13 instanceof UnsafeRow) {
/* 1168 */
/* 1169 */               final int sizeInBytes19 = ((UnsafeRow) element13).getSizeInBytes();
/* 1170 */               // grow the global buffer before writing data.
/* 1171 */               holder.grow(sizeInBytes19);
/* 1172 */               ((UnsafeRow) element13).writeToMemory(holder.buffer, holder.cursor);
/* 1173 */               holder.cursor += sizeInBytes19;
/* 1174 */
/* 1175 */             } else {
/* 1176 */               rowWriter3.reset();
/* 1177 */               apply1_0(element13);
/* 1178 */               apply1_1(element13);
/* 1179 */             }
/* 1180 */
/* 1181 */             arrayWriter13.setOffsetAndSize(index13, tmpCursor40, holder.cursor - tmpCursor40);
/* 1182 */
/* 1183 */           }
/* 1184 */         }
/* 1185 */       }
/* 1186 */
/* 1187 */       rowWriter2.setOffsetAndSize(11, tmpCursor39, holder.cursor - tmpCursor39);
/* 1188 */     }
/* 1189 */
/* 1190 */   }
/* 1191 */
/* 1192 */
/* 1193 */   private void apply_2(InternalRow value3) {
/* 1194 */
/* 1195 */
/* 1196 */     boolean isNull8 = value3.isNullAt(3);
/* 1197 */     int value8 = isNull8 ? -1 : value3.getInt(3);
/* 1198 */
/* 1199 */     if (isNull8) {
/* 1200 */       rowWriter1.setNullAt(3);
/* 1201 */     } else {
/* 1202 */       rowWriter1.write(3, value8);
/* 1203 */     }
/* 1204 */
/* 1205 */
/* 1206 */     boolean isNull9 = value3.isNullAt(4);
/* 1207 */     MapData value9 = isNull9 ? null : value3.getMap(4);
/* 1208 */
/* 1209 */     if (isNull9) {
/* 1210 */       rowWriter1.setNullAt(4);
/* 1211 */     } else {
/* 1212 */       // Remember the current cursor so that we can calculate how many bytes are
/* 1213 */       // written later.
/* 1214 */       final int tmpCursor17 = holder.cursor;
/* 1215 */
/* 1216 */       if (value9 instanceof UnsafeMapData) {
/* 1217 */
/* 1218 */         final int sizeInBytes10 = ((UnsafeMapData) value9).getSizeInBytes();
/* 1219 */         // grow the global buffer before writing data.
/* 1220 */         holder.grow(sizeInBytes10);
/* 1221 */         ((UnsafeMapData) value9).writeToMemory(holder.buffer, holder.cursor);
/* 1222 */         holder.cursor += sizeInBytes10;
/* 1223 */
/* 1224 */       } else {
/* 1225 */         final ArrayData keys3 = value9.keyArray();
/* 1226 */         final ArrayData values3 = value9.valueArray();
/* 1227 */
/* 1228 */         // preserve 8 bytes to write the key array numBytes later.
/* 1229 */         holder.grow(8);
/* 1230 */         holder.cursor += 8;
/* 1231 */
/* 1232 */         // Remember the current cursor so that we can write numBytes of key array later.
/* 1233 */         final int tmpCursor18 = holder.cursor;
/* 1234 */
/* 1235 */
/* 1236 */         if (keys3 instanceof UnsafeArrayData) {
/* 1237 */
/* 1238 */           final int sizeInBytes11 = ((UnsafeArrayData) keys3).getSizeInBytes();
/* 1239 */           // grow the global buffer before writing data.
/* 1240 */           holder.grow(sizeInBytes11);
/* 1241 */           ((UnsafeArrayData) keys3).writeToMemory(holder.buffer, holder.cursor);
/* 1242 */           holder.cursor += sizeInBytes11;
/* 1243 */
/* 1244 */         } else {
/* 1245 */           final int numElements6 = keys3.numElements();
/* 1246 */           arrayWriter6.initialize(holder, numElements6, 8);
/* 1247 */
/* 1248 */           for (int index6 = 0; index6 < numElements6; index6++) {
/* 1249 */             if (keys3.isNullAt(index6)) {
/* 1250 */               arrayWriter6.setNull(index6);
/* 1251 */             } else {
/* 1252 */               final UTF8String element6 = keys3.getUTF8String(index6);
/* 1253 */               arrayWriter6.write(index6, element6);
/* 1254 */             }
/* 1255 */           }
/* 1256 */         }
/* 1257 */
/* 1258 */         // Write the numBytes of key array into the first 8 bytes.
/* 1259 */         Platform.putLong(holder.buffer, tmpCursor18 - 8, holder.cursor - tmpCursor18);
/* 1260 */
/* 1261 */
/* 1262 */         if (values3 instanceof UnsafeArrayData) {
/* 1263 */
/* 1264 */           final int sizeInBytes12 = ((UnsafeArrayData) values3).getSizeInBytes();
/* 1265 */           // grow the global buffer before writing data.
/* 1266 */           holder.grow(sizeInBytes12);
/* 1267 */           ((UnsafeArrayData) values3).writeToMemory(holder.buffer, holder.cursor);
/* 1268 */           holder.cursor += sizeInBytes12;
/* 1269 */
/* 1270 */         } else {
/* 1271 */           final int numElements7 = values3.numElements();
/* 1272 */           arrayWriter7.initialize(holder, numElements7, 8);
/* 1273 */
/* 1274 */           for (int index7 = 0; index7 < numElements7; index7++) {
/* 1275 */             if (values3.isNullAt(index7)) {
/* 1276 */               arrayWriter7.setNull(index7);
/* 1277 */             } else {
/* 1278 */               final UTF8String element7 = values3.getUTF8String(index7);
/* 1279 */               arrayWriter7.write(index7, element7);
/* 1280 */             }
/* 1281 */           }
/* 1282 */         }
/* 1283 */
/* 1284 */       }
/* 1285 */
/* 1286 */       rowWriter1.setOffsetAndSize(4, tmpCursor17, holder.cursor - tmpCursor17);
/* 1287 */     }
/* 1288 */
/* 1289 */   }
/* 1290 */
/* 1291 */
/* 1292 */   private void apply1_0(InternalRow element13) {
/* 1293 */
/* 1294 */
/* 1295 */     boolean isNull26 = element13.isNullAt(0);
/* 1296 */     UTF8String value26 = isNull26 ? null : element13.getUTF8String(0);
/* 1297 */
/* 1298 */     if (isNull26) {
/* 1299 */       rowWriter3.setNullAt(0);
/* 1300 */     } else {
/* 1301 */       rowWriter3.write(0, value26);
/* 1302 */     }
/* 1303 */
/* 1304 */
/* 1305 */     boolean isNull27 = element13.isNullAt(1);
/* 1306 */     UTF8String value27 = isNull27 ? null : element13.getUTF8String(1);
/* 1307 */
/* 1308 */     if (isNull27) {
/* 1309 */       rowWriter3.setNullAt(1);
/* 1310 */     } else {
/* 1311 */       rowWriter3.write(1, value27);
/* 1312 */     }
/* 1313 */
/* 1314 */
/* 1315 */     boolean isNull28 = element13.isNullAt(2);
/* 1316 */     int value28 = isNull28 ? -1 : element13.getInt(2);
/* 1317 */
/* 1318 */     if (isNull28) {
/* 1319 */       rowWriter3.setNullAt(2);
/* 1320 */     } else {
/* 1321 */       rowWriter3.write(2, value28);
/* 1322 */     }
/* 1323 */
/* 1324 */
/* 1325 */     boolean isNull29 = element13.isNullAt(3);
/* 1326 */     ArrayData value29 = isNull29 ? null : element13.getArray(3);
/* 1327 */
/* 1328 */     if (isNull29) {
/* 1329 */       rowWriter3.setNullAt(3);
/* 1330 */     } else {
/* 1331 */       // Remember the current cursor so that we can calculate how many bytes are
/* 1332 */       // written later.
/* 1333 */       final int tmpCursor44 = holder.cursor;
/* 1334 */
/* 1335 */       if (value29 instanceof UnsafeArrayData) {
/* 1336 */
/* 1337 */         final int sizeInBytes20 = ((UnsafeArrayData) value29).getSizeInBytes();
/* 1338 */         // grow the global buffer before writing data.
/* 1339 */         holder.grow(sizeInBytes20);
/* 1340 */         ((UnsafeArrayData) value29).writeToMemory(holder.buffer, holder.cursor);
/* 1341 */         holder.cursor += sizeInBytes20;
/* 1342 */
/* 1343 */       } else {
/* 1344 */         final int numElements14 = value29.numElements();
/* 1345 */         arrayWriter14.initialize(holder, numElements14, 4);
/* 1346 */
/* 1347 */         for (int index14 = 0; index14 < numElements14; index14++) {
/* 1348 */           if (value29.isNullAt(index14)) {
/* 1349 */             arrayWriter14.setNullInt(index14);
/* 1350 */           } else {
/* 1351 */             final int element14 = value29.getInt(index14);
/* 1352 */             arrayWriter14.write(index14, element14);
/* 1353 */           }
/* 1354 */         }
/* 1355 */       }
/* 1356 */
/* 1357 */       rowWriter3.setOffsetAndSize(3, tmpCursor44, holder.cursor - tmpCursor44);
/* 1358 */     }
/* 1359 */
/* 1360 */   }
/* 1361 */
/* 1362 */
/* 1363 */   // Scala.Function1 need this
/* 1364 */   public java.lang.Object apply(java.lang.Object row) {
/* 1365 */     return apply((InternalRow) row);
/* 1366 */   }
/* 1367 */
/* 1368 */   public UnsafeRow apply(InternalRow i) {
/* 1369 */     holder.reset();
/* 1370 */
/* 1371 */     rowWriter.zeroOutNullBytes();
/* 1372 */     apply4_0(i);
/* 1373 */     apply4_1(i);
/* 1374 */     result.setTotalSize(holder.totalSize());
/* 1375 */     return result;
/* 1376 */   }
/* 1377 */ }

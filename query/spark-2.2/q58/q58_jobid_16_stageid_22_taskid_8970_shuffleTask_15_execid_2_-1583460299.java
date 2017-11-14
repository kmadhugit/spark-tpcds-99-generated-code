/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator smj_leftInput;
/* 009 */   private scala.collection.Iterator smj_rightInput;
/* 010 */   private InternalRow smj_leftRow;
/* 011 */   private InternalRow smj_rightRow;
/* 012 */   private UTF8String smj_value2;
/* 013 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 014 */   private UTF8String smj_value3;
/* 015 */   private UTF8String smj_value4;
/* 016 */   private boolean smj_isNull2;
/* 017 */   private double smj_value5;
/* 018 */   private boolean smj_isNull3;
/* 019 */   private double smj_value6;
/* 020 */   private boolean smj_isNull4;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 022 */   private UnsafeRow smj_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 025 */   private UnsafeRow project_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 028 */
/* 029 */   public GeneratedIterator(Object[] references) {
/* 030 */     this.references = references;
/* 031 */   }
/* 032 */
/* 033 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 034 */     partitionIndex = index;
/* 035 */     this.inputs = inputs;
/* 036 */     smj_leftInput = inputs[0];
/* 037 */     smj_rightInput = inputs[1];
/* 038 */
/* 039 */     smj_rightRow = null;
/* 040 */
/* 041 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 042 */
/* 043 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 044 */     smj_result = new UnsafeRow(5);
/* 045 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 64);
/* 046 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 5);
/* 047 */     project_result = new UnsafeRow(8);
/* 048 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 049 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 050 */
/* 051 */   }
/* 052 */
/* 053 */   private boolean findNextInnerJoinRows(
/* 054 */     scala.collection.Iterator leftIter,
/* 055 */     scala.collection.Iterator rightIter) {
/* 056 */     smj_leftRow = null;
/* 057 */     int comp = 0;
/* 058 */     while (smj_leftRow == null) {
/* 059 */       if (!leftIter.hasNext()) return false;
/* 060 */       smj_leftRow = (InternalRow) leftIter.next();
/* 061 */
/* 062 */       boolean smj_isNull = smj_leftRow.isNullAt(0);
/* 063 */       UTF8String smj_value = smj_isNull ? null : (smj_leftRow.getUTF8String(0));
/* 064 */       if (smj_isNull) {
/* 065 */         smj_leftRow = null;
/* 066 */         continue;
/* 067 */       }
/* 068 */       if (!smj_matches.isEmpty()) {
/* 069 */         comp = 0;
/* 070 */         if (comp == 0) {
/* 071 */           comp = smj_value.compare(smj_value3);
/* 072 */         }
/* 073 */
/* 074 */         if (comp == 0) {
/* 075 */           return true;
/* 076 */         }
/* 077 */         smj_matches.clear();
/* 078 */       }
/* 079 */
/* 080 */       do {
/* 081 */         if (smj_rightRow == null) {
/* 082 */           if (!rightIter.hasNext()) {
/* 083 */             smj_value3 = smj_value.clone();
/* 084 */             return !smj_matches.isEmpty();
/* 085 */           }
/* 086 */           smj_rightRow = (InternalRow) rightIter.next();
/* 087 */
/* 088 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 089 */           UTF8String smj_value1 = smj_isNull1 ? null : (smj_rightRow.getUTF8String(0));
/* 090 */           if (smj_isNull1) {
/* 091 */             smj_rightRow = null;
/* 092 */             continue;
/* 093 */           }
/* 094 */           smj_value2 = smj_value1.clone();
/* 095 */         }
/* 096 */
/* 097 */         comp = 0;
/* 098 */         if (comp == 0) {
/* 099 */           comp = smj_value.compare(smj_value2);
/* 100 */         }
/* 101 */
/* 102 */         if (comp > 0) {
/* 103 */           smj_rightRow = null;
/* 104 */         } else if (comp < 0) {
/* 105 */           if (!smj_matches.isEmpty()) {
/* 106 */             smj_value3 = smj_value.clone();
/* 107 */             return true;
/* 108 */           }
/* 109 */           smj_leftRow = null;
/* 110 */         } else {
/* 111 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 112 */           smj_rightRow = null;;
/* 113 */         }
/* 114 */       } while (smj_leftRow != null);
/* 115 */     }
/* 116 */     return false; // unreachable
/* 117 */   }
/* 118 */
/* 119 */   protected void processNext() throws java.io.IOException {
/* 120 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 121 */       boolean smj_loaded = false;
/* 122 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 123 */       smj_value5 = smj_isNull3 ? -1.0 : (smj_leftRow.getDouble(1));
/* 124 */       smj_isNull4 = smj_leftRow.isNullAt(2);
/* 125 */       smj_value6 = smj_isNull4 ? -1.0 : (smj_leftRow.getDouble(2));
/* 126 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 127 */       while (smj_iterator.hasNext()) {
/* 128 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 129 */         double smj_value8 = smj_rightRow1.getDouble(1);
/* 130 */
/* 131 */         boolean smj_isNull14 = true;
/* 132 */         boolean smj_value16 = false;
/* 133 */
/* 134 */         if (!smj_isNull3) {
/* 135 */           boolean smj_isNull16 = false;
/* 136 */
/* 137 */           double smj_value18 = -1.0;
/* 138 */           smj_value18 = 0.9D * smj_value8;
/* 139 */
/* 140 */           smj_isNull14 = false; // resultCode could change nullability.
/* 141 */           smj_value16 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value5, smj_value18) >= 0;
/* 142 */
/* 143 */         }
/* 144 */         boolean smj_isNull13 = false;
/* 145 */         boolean smj_value15 = false;
/* 146 */
/* 147 */         if (!smj_isNull14 && !smj_value16) {
/* 148 */         } else {
/* 149 */           boolean smj_isNull19 = true;
/* 150 */           boolean smj_value21 = false;
/* 151 */
/* 152 */           if (!smj_isNull3) {
/* 153 */             boolean smj_isNull21 = false;
/* 154 */
/* 155 */             double smj_value23 = -1.0;
/* 156 */             smj_value23 = 1.1D * smj_value8;
/* 157 */
/* 158 */             smj_isNull19 = false; // resultCode could change nullability.
/* 159 */             smj_value21 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value5, smj_value23) <= 0;
/* 160 */
/* 161 */           }
/* 162 */           if (!smj_isNull19 && !smj_value21) {
/* 163 */           } else if (!smj_isNull14 && !smj_isNull19) {
/* 164 */             smj_value15 = true;
/* 165 */           } else {
/* 166 */             smj_isNull13 = true;
/* 167 */           }
/* 168 */         }
/* 169 */         boolean smj_isNull12 = false;
/* 170 */         boolean smj_value14 = false;
/* 171 */
/* 172 */         if (!smj_isNull13 && !smj_value15) {
/* 173 */         } else {
/* 174 */           boolean smj_isNull24 = true;
/* 175 */           boolean smj_value26 = false;
/* 176 */
/* 177 */           if (!smj_isNull4) {
/* 178 */             boolean smj_isNull26 = false;
/* 179 */
/* 180 */             double smj_value28 = -1.0;
/* 181 */             smj_value28 = 0.9D * smj_value8;
/* 182 */
/* 183 */             smj_isNull24 = false; // resultCode could change nullability.
/* 184 */             smj_value26 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value6, smj_value28) >= 0;
/* 185 */
/* 186 */           }
/* 187 */           if (!smj_isNull24 && !smj_value26) {
/* 188 */           } else if (!smj_isNull13 && !smj_isNull24) {
/* 189 */             smj_value14 = true;
/* 190 */           } else {
/* 191 */             smj_isNull12 = true;
/* 192 */           }
/* 193 */         }
/* 194 */         boolean smj_isNull11 = false;
/* 195 */         boolean smj_value13 = false;
/* 196 */
/* 197 */         if (!smj_isNull12 && !smj_value14) {
/* 198 */         } else {
/* 199 */           boolean smj_isNull29 = true;
/* 200 */           boolean smj_value31 = false;
/* 201 */
/* 202 */           if (!smj_isNull4) {
/* 203 */             boolean smj_isNull31 = false;
/* 204 */
/* 205 */             double smj_value33 = -1.0;
/* 206 */             smj_value33 = 1.1D * smj_value8;
/* 207 */
/* 208 */             smj_isNull29 = false; // resultCode could change nullability.
/* 209 */             smj_value31 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value6, smj_value33) <= 0;
/* 210 */
/* 211 */           }
/* 212 */           if (!smj_isNull29 && !smj_value31) {
/* 213 */           } else if (!smj_isNull12 && !smj_isNull29) {
/* 214 */             smj_value13 = true;
/* 215 */           } else {
/* 216 */             smj_isNull11 = true;
/* 217 */           }
/* 218 */         }
/* 219 */         boolean smj_isNull10 = false;
/* 220 */         boolean smj_value12 = false;
/* 221 */
/* 222 */         if (!smj_isNull11 && !smj_value13) {
/* 223 */         } else {
/* 224 */           boolean smj_isNull34 = true;
/* 225 */           boolean smj_value36 = false;
/* 226 */
/* 227 */           boolean smj_isNull36 = true;
/* 228 */           double smj_value38 = -1.0;
/* 229 */
/* 230 */           if (!smj_isNull3) {
/* 231 */             smj_isNull36 = false; // resultCode could change nullability.
/* 232 */             smj_value38 = 0.9D * smj_value5;
/* 233 */
/* 234 */           }
/* 235 */           if (!smj_isNull36) {
/* 236 */             smj_isNull34 = false; // resultCode could change nullability.
/* 237 */             smj_value36 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value8, smj_value38) >= 0;
/* 238 */
/* 239 */           }
/* 240 */           if (!smj_isNull34 && !smj_value36) {
/* 241 */           } else if (!smj_isNull11 && !smj_isNull34) {
/* 242 */             smj_value12 = true;
/* 243 */           } else {
/* 244 */             smj_isNull10 = true;
/* 245 */           }
/* 246 */         }
/* 247 */         boolean smj_isNull9 = false;
/* 248 */         boolean smj_value11 = false;
/* 249 */
/* 250 */         if (!smj_isNull10 && !smj_value12) {
/* 251 */         } else {
/* 252 */           boolean smj_isNull39 = true;
/* 253 */           boolean smj_value41 = false;
/* 254 */
/* 255 */           boolean smj_isNull41 = true;
/* 256 */           double smj_value43 = -1.0;
/* 257 */
/* 258 */           if (!smj_isNull3) {
/* 259 */             smj_isNull41 = false; // resultCode could change nullability.
/* 260 */             smj_value43 = 1.1D * smj_value5;
/* 261 */
/* 262 */           }
/* 263 */           if (!smj_isNull41) {
/* 264 */             smj_isNull39 = false; // resultCode could change nullability.
/* 265 */             smj_value41 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value8, smj_value43) <= 0;
/* 266 */
/* 267 */           }
/* 268 */           if (!smj_isNull39 && !smj_value41) {
/* 269 */           } else if (!smj_isNull10 && !smj_isNull39) {
/* 270 */             smj_value11 = true;
/* 271 */           } else {
/* 272 */             smj_isNull9 = true;
/* 273 */           }
/* 274 */         }
/* 275 */         boolean smj_isNull8 = false;
/* 276 */         boolean smj_value10 = false;
/* 277 */
/* 278 */         if (!smj_isNull9 && !smj_value11) {
/* 279 */         } else {
/* 280 */           boolean smj_isNull44 = true;
/* 281 */           boolean smj_value46 = false;
/* 282 */
/* 283 */           boolean smj_isNull46 = true;
/* 284 */           double smj_value48 = -1.0;
/* 285 */
/* 286 */           if (!smj_isNull4) {
/* 287 */             smj_isNull46 = false; // resultCode could change nullability.
/* 288 */             smj_value48 = 0.9D * smj_value6;
/* 289 */
/* 290 */           }
/* 291 */           if (!smj_isNull46) {
/* 292 */             smj_isNull44 = false; // resultCode could change nullability.
/* 293 */             smj_value46 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value8, smj_value48) >= 0;
/* 294 */
/* 295 */           }
/* 296 */           if (!smj_isNull44 && !smj_value46) {
/* 297 */           } else if (!smj_isNull9 && !smj_isNull44) {
/* 298 */             smj_value10 = true;
/* 299 */           } else {
/* 300 */             smj_isNull8 = true;
/* 301 */           }
/* 302 */         }
/* 303 */         boolean smj_isNull7 = false;
/* 304 */         boolean smj_value9 = false;
/* 305 */
/* 306 */         if (!smj_isNull8 && !smj_value10) {
/* 307 */         } else {
/* 308 */           boolean smj_isNull49 = true;
/* 309 */           boolean smj_value51 = false;
/* 310 */
/* 311 */           boolean smj_isNull51 = true;
/* 312 */           double smj_value53 = -1.0;
/* 313 */
/* 314 */           if (!smj_isNull4) {
/* 315 */             smj_isNull51 = false; // resultCode could change nullability.
/* 316 */             smj_value53 = 1.1D * smj_value6;
/* 317 */
/* 318 */           }
/* 319 */           if (!smj_isNull51) {
/* 320 */             smj_isNull49 = false; // resultCode could change nullability.
/* 321 */             smj_value51 = org.apache.spark.util.Utils.nanSafeCompareDoubles(smj_value8, smj_value53) <= 0;
/* 322 */
/* 323 */           }
/* 324 */           if (!smj_isNull49 && !smj_value51) {
/* 325 */           } else if (!smj_isNull8 && !smj_isNull49) {
/* 326 */             smj_value9 = true;
/* 327 */           } else {
/* 328 */             smj_isNull7 = true;
/* 329 */           }
/* 330 */         }
/* 331 */         if (smj_isNull7 || !smj_value9) continue;
/* 332 */         if (!smj_loaded) {
/* 333 */           smj_loaded = true;
/* 334 */           smj_isNull2 = smj_leftRow.isNullAt(0);
/* 335 */           smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 336 */         }
/* 337 */         boolean smj_isNull5 = smj_rightRow1.isNullAt(0);
/* 338 */         UTF8String smj_value7 = smj_isNull5 ? null : (smj_rightRow1.getUTF8String(0));
/* 339 */         smj_numOutputRows.add(1);
/* 340 */
/* 341 */         boolean project_isNull2 = true;
/* 342 */         double project_value2 = -1.0;
/* 343 */
/* 344 */         boolean project_isNull3 = false;
/* 345 */         double project_value3 = -1.0;
/* 346 */         if (false || 3.0D == 0) {
/* 347 */           project_isNull3 = true;
/* 348 */         } else {
/* 349 */           boolean project_isNull6 = true;
/* 350 */           double project_value6 = -1.0;
/* 351 */
/* 352 */           boolean project_isNull7 = true;
/* 353 */           double project_value7 = -1.0;
/* 354 */
/* 355 */           if (!smj_isNull3) {
/* 356 */             if (!smj_isNull4) {
/* 357 */               project_isNull7 = false; // resultCode could change nullability.
/* 358 */               project_value7 = smj_value5 + smj_value6;
/* 359 */
/* 360 */             }
/* 361 */
/* 362 */           }
/* 363 */           if (!project_isNull7) {
/* 364 */             project_isNull6 = false; // resultCode could change nullability.
/* 365 */             project_value6 = project_value7 + smj_value8;
/* 366 */
/* 367 */           }
/* 368 */           boolean project_isNull4 = false;
/* 369 */           double project_value4 = -1.0;
/* 370 */           if (project_isNull6 || project_value6 == 0) {
/* 371 */             project_isNull4 = true;
/* 372 */           } else {
/* 373 */             if (smj_isNull3) {
/* 374 */               project_isNull4 = true;
/* 375 */             } else {
/* 376 */               project_value4 = (double)(smj_value5 / project_value6);
/* 377 */             }
/* 378 */           }
/* 379 */           if (project_isNull4) {
/* 380 */             project_isNull3 = true;
/* 381 */           } else {
/* 382 */             project_value3 = (double)(project_value4 / 3.0D);
/* 383 */           }
/* 384 */         }
/* 385 */         if (!project_isNull3) {
/* 386 */           project_isNull2 = false; // resultCode could change nullability.
/* 387 */           project_value2 = project_value3 * 100.0D;
/* 388 */
/* 389 */         }
/* 390 */         boolean project_isNull14 = true;
/* 391 */         double project_value14 = -1.0;
/* 392 */
/* 393 */         boolean project_isNull15 = false;
/* 394 */         double project_value15 = -1.0;
/* 395 */         if (false || 3.0D == 0) {
/* 396 */           project_isNull15 = true;
/* 397 */         } else {
/* 398 */           boolean project_isNull18 = true;
/* 399 */           double project_value18 = -1.0;
/* 400 */
/* 401 */           boolean project_isNull19 = true;
/* 402 */           double project_value19 = -1.0;
/* 403 */
/* 404 */           if (!smj_isNull3) {
/* 405 */             if (!smj_isNull4) {
/* 406 */               project_isNull19 = false; // resultCode could change nullability.
/* 407 */               project_value19 = smj_value5 + smj_value6;
/* 408 */
/* 409 */             }
/* 410 */
/* 411 */           }
/* 412 */           if (!project_isNull19) {
/* 413 */             project_isNull18 = false; // resultCode could change nullability.
/* 414 */             project_value18 = project_value19 + smj_value8;
/* 415 */
/* 416 */           }
/* 417 */           boolean project_isNull16 = false;
/* 418 */           double project_value16 = -1.0;
/* 419 */           if (project_isNull18 || project_value18 == 0) {
/* 420 */             project_isNull16 = true;
/* 421 */           } else {
/* 422 */             if (smj_isNull4) {
/* 423 */               project_isNull16 = true;
/* 424 */             } else {
/* 425 */               project_value16 = (double)(smj_value6 / project_value18);
/* 426 */             }
/* 427 */           }
/* 428 */           if (project_isNull16) {
/* 429 */             project_isNull15 = true;
/* 430 */           } else {
/* 431 */             project_value15 = (double)(project_value16 / 3.0D);
/* 432 */           }
/* 433 */         }
/* 434 */         if (!project_isNull15) {
/* 435 */           project_isNull14 = false; // resultCode could change nullability.
/* 436 */           project_value14 = project_value15 * 100.0D;
/* 437 */
/* 438 */         }
/* 439 */         boolean project_isNull26 = true;
/* 440 */         double project_value26 = -1.0;
/* 441 */
/* 442 */         boolean project_isNull27 = false;
/* 443 */         double project_value27 = -1.0;
/* 444 */         if (false || 3.0D == 0) {
/* 445 */           project_isNull27 = true;
/* 446 */         } else {
/* 447 */           boolean project_isNull30 = true;
/* 448 */           double project_value30 = -1.0;
/* 449 */
/* 450 */           boolean project_isNull31 = true;
/* 451 */           double project_value31 = -1.0;
/* 452 */
/* 453 */           if (!smj_isNull3) {
/* 454 */             if (!smj_isNull4) {
/* 455 */               project_isNull31 = false; // resultCode could change nullability.
/* 456 */               project_value31 = smj_value5 + smj_value6;
/* 457 */
/* 458 */             }
/* 459 */
/* 460 */           }
/* 461 */           if (!project_isNull31) {
/* 462 */             project_isNull30 = false; // resultCode could change nullability.
/* 463 */             project_value30 = project_value31 + smj_value8;
/* 464 */
/* 465 */           }
/* 466 */           boolean project_isNull28 = false;
/* 467 */           double project_value28 = -1.0;
/* 468 */           if (project_isNull30 || project_value30 == 0) {
/* 469 */             project_isNull28 = true;
/* 470 */           } else {
/* 471 */             if (false) {
/* 472 */               project_isNull28 = true;
/* 473 */             } else {
/* 474 */               project_value28 = (double)(smj_value8 / project_value30);
/* 475 */             }
/* 476 */           }
/* 477 */           if (project_isNull28) {
/* 478 */             project_isNull27 = true;
/* 479 */           } else {
/* 480 */             project_value27 = (double)(project_value28 / 3.0D);
/* 481 */           }
/* 482 */         }
/* 483 */         if (!project_isNull27) {
/* 484 */           project_isNull26 = false; // resultCode could change nullability.
/* 485 */           project_value26 = project_value27 * 100.0D;
/* 486 */
/* 487 */         }
/* 488 */         boolean project_isNull37 = false;
/* 489 */         double project_value37 = -1.0;
/* 490 */         if (false || 3.0D == 0) {
/* 491 */           project_isNull37 = true;
/* 492 */         } else {
/* 493 */           boolean project_isNull38 = true;
/* 494 */           double project_value38 = -1.0;
/* 495 */
/* 496 */           boolean project_isNull39 = true;
/* 497 */           double project_value39 = -1.0;
/* 498 */
/* 499 */           if (!smj_isNull3) {
/* 500 */             if (!smj_isNull4) {
/* 501 */               project_isNull39 = false; // resultCode could change nullability.
/* 502 */               project_value39 = smj_value5 + smj_value6;
/* 503 */
/* 504 */             }
/* 505 */
/* 506 */           }
/* 507 */           if (!project_isNull39) {
/* 508 */             project_isNull38 = false; // resultCode could change nullability.
/* 509 */             project_value38 = project_value39 + smj_value8;
/* 510 */
/* 511 */           }
/* 512 */           if (project_isNull38) {
/* 513 */             project_isNull37 = true;
/* 514 */           } else {
/* 515 */             project_value37 = (double)(project_value38 / 3.0D);
/* 516 */           }
/* 517 */         }
/* 518 */         project_holder.reset();
/* 519 */
/* 520 */         project_rowWriter.zeroOutNullBytes();
/* 521 */
/* 522 */         if (smj_isNull2) {
/* 523 */           project_rowWriter.setNullAt(0);
/* 524 */         } else {
/* 525 */           project_rowWriter.write(0, smj_value4);
/* 526 */         }
/* 527 */
/* 528 */         if (smj_isNull3) {
/* 529 */           project_rowWriter.setNullAt(1);
/* 530 */         } else {
/* 531 */           project_rowWriter.write(1, smj_value5);
/* 532 */         }
/* 533 */
/* 534 */         if (project_isNull2) {
/* 535 */           project_rowWriter.setNullAt(2);
/* 536 */         } else {
/* 537 */           project_rowWriter.write(2, project_value2);
/* 538 */         }
/* 539 */
/* 540 */         if (smj_isNull4) {
/* 541 */           project_rowWriter.setNullAt(3);
/* 542 */         } else {
/* 543 */           project_rowWriter.write(3, smj_value6);
/* 544 */         }
/* 545 */
/* 546 */         if (project_isNull14) {
/* 547 */           project_rowWriter.setNullAt(4);
/* 548 */         } else {
/* 549 */           project_rowWriter.write(4, project_value14);
/* 550 */         }
/* 551 */
/* 552 */         project_rowWriter.write(5, smj_value8);
/* 553 */
/* 554 */         if (project_isNull26) {
/* 555 */           project_rowWriter.setNullAt(6);
/* 556 */         } else {
/* 557 */           project_rowWriter.write(6, project_value26);
/* 558 */         }
/* 559 */
/* 560 */         if (project_isNull37) {
/* 561 */           project_rowWriter.setNullAt(7);
/* 562 */         } else {
/* 563 */           project_rowWriter.write(7, project_value37);
/* 564 */         }
/* 565 */         project_result.setTotalSize(project_holder.totalSize());
/* 566 */         append(project_result.copy());
/* 567 */
/* 568 */       }
/* 569 */       if (shouldStop()) return;
/* 570 */     }
/* 571 */   }
/* 572 */ }

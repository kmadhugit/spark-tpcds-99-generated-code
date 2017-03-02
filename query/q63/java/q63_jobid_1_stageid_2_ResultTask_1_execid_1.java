/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private scala.collection.Iterator scan_input;
/* 009 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 010 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 011 */   private long scan_scanTime1;
/* 012 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 013 */   private int scan_batchIdx;
/* 014 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 015 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 016 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 017 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 018 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 019 */   private UnsafeRow scan_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 023 */   private UnsafeRow filter_result;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 026 */   private UnsafeRow project_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     wholestagecodegen_init_0();
/* 038 */     wholestagecodegen_init_1();
/* 039 */
/* 040 */   }
/* 041 */
/* 042 */   private void wholestagecodegen_init_0() {
/* 043 */     scan_input = inputs[0];
/* 044 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[0];
/* 045 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 046 */     scan_scanTime1 = 0;
/* 047 */     scan_batch = null;
/* 048 */     scan_batchIdx = 0;
/* 049 */     scan_colInstance0 = null;
/* 050 */     scan_colInstance1 = null;
/* 051 */     scan_colInstance2 = null;
/* 052 */     scan_colInstance3 = null;
/* 053 */     scan_colInstance4 = null;
/* 054 */     scan_result = new UnsafeRow(5);
/* 055 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 96);
/* 056 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 057 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 058 */     filter_result = new UnsafeRow(5);
/* 059 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 96);
/* 060 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 061 */     project_result = new UnsafeRow(2);
/* 062 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */   private void scan_nextBatch() throws java.io.IOException {
/* 067 */     long getBatchStart = System.nanoTime();
/* 068 */     if (scan_input.hasNext()) {
/* 069 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 070 */       scan_numOutputRows.add(scan_batch.numRows());
/* 071 */       scan_batchIdx = 0;
/* 072 */       scan_colInstance0 = scan_batch.column(0);
/* 073 */       scan_colInstance1 = scan_batch.column(1);
/* 074 */       scan_colInstance2 = scan_batch.column(2);
/* 075 */       scan_colInstance3 = scan_batch.column(3);
/* 076 */       scan_colInstance4 = scan_batch.column(4);
/* 077 */
/* 078 */     }
/* 079 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 080 */   }
/* 081 */
/* 082 */   private void wholestagecodegen_init_1() {
/* 083 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 084 */
/* 085 */   }
/* 086 */
/* 087 */   protected void processNext() throws java.io.IOException {
/* 088 */     if (scan_batch == null) {
/* 089 */       scan_nextBatch();
/* 090 */     }
/* 091 */     while (scan_batch != null) {
/* 092 */       int numRows = scan_batch.numRows();
/* 093 */       while (scan_batchIdx < numRows) {
/* 094 */         int scan_rowIdx = scan_batchIdx++;
/* 095 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 096 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 097 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 098 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 099 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 100 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 101 */
/* 102 */         boolean filter_value3 = false;
/* 103 */         boolean filter_isNull3 = scan_isNull3;
/* 104 */         if (!filter_isNull3) {
/* 105 */           if (!filter_value3) {
/* 106 */             Object filter_obj = ((Expression) references[3]).eval(null);
/* 107 */             UTF8String filter_value5 = (UTF8String) filter_obj;
/* 108 */             if (false) {
/* 109 */               filter_isNull3 = true;
/* 110 */             } else if (scan_value3.equals(filter_value5)) {
/* 111 */               filter_isNull3 = false;
/* 112 */               filter_value3 = true;
/* 113 */             }
/* 114 */           }
/* 115 */
/* 116 */           if (!filter_value3) {
/* 117 */             Object filter_obj1 = ((Expression) references[4]).eval(null);
/* 118 */             UTF8String filter_value6 = (UTF8String) filter_obj1;
/* 119 */             if (false) {
/* 120 */               filter_isNull3 = true;
/* 121 */             } else if (scan_value3.equals(filter_value6)) {
/* 122 */               filter_isNull3 = false;
/* 123 */               filter_value3 = true;
/* 124 */             }
/* 125 */           }
/* 126 */
/* 127 */           if (!filter_value3) {
/* 128 */             Object filter_obj2 = ((Expression) references[5]).eval(null);
/* 129 */             UTF8String filter_value7 = (UTF8String) filter_obj2;
/* 130 */             if (false) {
/* 131 */               filter_isNull3 = true;
/* 132 */             } else if (scan_value3.equals(filter_value7)) {
/* 133 */               filter_isNull3 = false;
/* 134 */               filter_value3 = true;
/* 135 */             }
/* 136 */           }
/* 137 */
/* 138 */         }
/* 139 */         boolean filter_isNull2 = false;
/* 140 */         boolean filter_value2 = false;
/* 141 */
/* 142 */         if (!filter_isNull3 && !filter_value3) {
/* 143 */         } else {
/* 144 */           boolean filter_value8 = false;
/* 145 */           boolean filter_isNull8 = scan_isNull2;
/* 146 */           if (!filter_isNull8) {
/* 147 */             if (!filter_value8) {
/* 148 */               Object filter_obj3 = ((Expression) references[6]).eval(null);
/* 149 */               UTF8String filter_value10 = (UTF8String) filter_obj3;
/* 150 */               if (false) {
/* 151 */                 filter_isNull8 = true;
/* 152 */               } else if (scan_value2.equals(filter_value10)) {
/* 153 */                 filter_isNull8 = false;
/* 154 */                 filter_value8 = true;
/* 155 */               }
/* 156 */             }
/* 157 */
/* 158 */             if (!filter_value8) {
/* 159 */               Object filter_obj4 = ((Expression) references[7]).eval(null);
/* 160 */               UTF8String filter_value11 = (UTF8String) filter_obj4;
/* 161 */               if (false) {
/* 162 */                 filter_isNull8 = true;
/* 163 */               } else if (scan_value2.equals(filter_value11)) {
/* 164 */                 filter_isNull8 = false;
/* 165 */                 filter_value8 = true;
/* 166 */               }
/* 167 */             }
/* 168 */
/* 169 */             if (!filter_value8) {
/* 170 */               Object filter_obj5 = ((Expression) references[8]).eval(null);
/* 171 */               UTF8String filter_value12 = (UTF8String) filter_obj5;
/* 172 */               if (false) {
/* 173 */                 filter_isNull8 = true;
/* 174 */               } else if (scan_value2.equals(filter_value12)) {
/* 175 */                 filter_isNull8 = false;
/* 176 */                 filter_value8 = true;
/* 177 */               }
/* 178 */             }
/* 179 */
/* 180 */             if (!filter_value8) {
/* 181 */               Object filter_obj6 = ((Expression) references[9]).eval(null);
/* 182 */               UTF8String filter_value13 = (UTF8String) filter_obj6;
/* 183 */               if (false) {
/* 184 */                 filter_isNull8 = true;
/* 185 */               } else if (scan_value2.equals(filter_value13)) {
/* 186 */                 filter_isNull8 = false;
/* 187 */                 filter_value8 = true;
/* 188 */               }
/* 189 */             }
/* 190 */
/* 191 */           }
/* 192 */           if (!filter_isNull8 && !filter_value8) {
/* 193 */           } else if (!filter_isNull3 && !filter_isNull8) {
/* 194 */             filter_value2 = true;
/* 195 */           } else {
/* 196 */             filter_isNull2 = true;
/* 197 */           }
/* 198 */         }
/* 199 */         boolean filter_isNull1 = false;
/* 200 */         boolean filter_value1 = false;
/* 201 */
/* 202 */         if (!filter_isNull2 && !filter_value2) {
/* 203 */         } else {
/* 204 */           boolean filter_value14 = false;
/* 205 */           boolean filter_isNull14 = scan_isNull1;
/* 206 */           if (!filter_isNull14) {
/* 207 */             if (!filter_value14) {
/* 208 */               Object filter_obj7 = ((Expression) references[10]).eval(null);
/* 209 */               UTF8String filter_value16 = (UTF8String) filter_obj7;
/* 210 */               if (false) {
/* 211 */                 filter_isNull14 = true;
/* 212 */               } else if (scan_value1.equals(filter_value16)) {
/* 213 */                 filter_isNull14 = false;
/* 214 */                 filter_value14 = true;
/* 215 */               }
/* 216 */             }
/* 217 */
/* 218 */             if (!filter_value14) {
/* 219 */               Object filter_obj8 = ((Expression) references[11]).eval(null);
/* 220 */               UTF8String filter_value17 = (UTF8String) filter_obj8;
/* 221 */               if (false) {
/* 222 */                 filter_isNull14 = true;
/* 223 */               } else if (scan_value1.equals(filter_value17)) {
/* 224 */                 filter_isNull14 = false;
/* 225 */                 filter_value14 = true;
/* 226 */               }
/* 227 */             }
/* 228 */
/* 229 */             if (!filter_value14) {
/* 230 */               Object filter_obj9 = ((Expression) references[12]).eval(null);
/* 231 */               UTF8String filter_value18 = (UTF8String) filter_obj9;
/* 232 */               if (false) {
/* 233 */                 filter_isNull14 = true;
/* 234 */               } else if (scan_value1.equals(filter_value18)) {
/* 235 */                 filter_isNull14 = false;
/* 236 */                 filter_value14 = true;
/* 237 */               }
/* 238 */             }
/* 239 */
/* 240 */             if (!filter_value14) {
/* 241 */               Object filter_obj10 = ((Expression) references[13]).eval(null);
/* 242 */               UTF8String filter_value19 = (UTF8String) filter_obj10;
/* 243 */               if (false) {
/* 244 */                 filter_isNull14 = true;
/* 245 */               } else if (scan_value1.equals(filter_value19)) {
/* 246 */                 filter_isNull14 = false;
/* 247 */                 filter_value14 = true;
/* 248 */               }
/* 249 */             }
/* 250 */
/* 251 */           }
/* 252 */           if (!filter_isNull14 && !filter_value14) {
/* 253 */           } else if (!filter_isNull2 && !filter_isNull14) {
/* 254 */             filter_value1 = true;
/* 255 */           } else {
/* 256 */             filter_isNull1 = true;
/* 257 */           }
/* 258 */         }
/* 259 */         boolean filter_isNull = false;
/* 260 */         boolean filter_value = true;
/* 261 */
/* 262 */         if (!filter_isNull1 && filter_value1) {
/* 263 */         } else {
/* 264 */           boolean filter_value22 = false;
/* 265 */           boolean filter_isNull22 = scan_isNull3;
/* 266 */           if (!filter_isNull22) {
/* 267 */             if (!filter_value22) {
/* 268 */               Object filter_obj11 = ((Expression) references[14]).eval(null);
/* 269 */               UTF8String filter_value24 = (UTF8String) filter_obj11;
/* 270 */               if (false) {
/* 271 */                 filter_isNull22 = true;
/* 272 */               } else if (scan_value3.equals(filter_value24)) {
/* 273 */                 filter_isNull22 = false;
/* 274 */                 filter_value22 = true;
/* 275 */               }
/* 276 */             }
/* 277 */
/* 278 */             if (!filter_value22) {
/* 279 */               Object filter_obj12 = ((Expression) references[15]).eval(null);
/* 280 */               UTF8String filter_value25 = (UTF8String) filter_obj12;
/* 281 */               if (false) {
/* 282 */                 filter_isNull22 = true;
/* 283 */               } else if (scan_value3.equals(filter_value25)) {
/* 284 */                 filter_isNull22 = false;
/* 285 */                 filter_value22 = true;
/* 286 */               }
/* 287 */             }
/* 288 */
/* 289 */             if (!filter_value22) {
/* 290 */               Object filter_obj13 = ((Expression) references[16]).eval(null);
/* 291 */               UTF8String filter_value26 = (UTF8String) filter_obj13;
/* 292 */               if (false) {
/* 293 */                 filter_isNull22 = true;
/* 294 */               } else if (scan_value3.equals(filter_value26)) {
/* 295 */                 filter_isNull22 = false;
/* 296 */                 filter_value22 = true;
/* 297 */               }
/* 298 */             }
/* 299 */
/* 300 */           }
/* 301 */           boolean filter_isNull21 = false;
/* 302 */           boolean filter_value21 = false;
/* 303 */
/* 304 */           if (!filter_isNull22 && !filter_value22) {
/* 305 */           } else {
/* 306 */             boolean filter_value27 = false;
/* 307 */             boolean filter_isNull27 = scan_isNull2;
/* 308 */             if (!filter_isNull27) {
/* 309 */               if (!filter_value27) {
/* 310 */                 Object filter_obj14 = ((Expression) references[17]).eval(null);
/* 311 */                 UTF8String filter_value29 = (UTF8String) filter_obj14;
/* 312 */                 if (false) {
/* 313 */                   filter_isNull27 = true;
/* 314 */                 } else if (scan_value2.equals(filter_value29)) {
/* 315 */                   filter_isNull27 = false;
/* 316 */                   filter_value27 = true;
/* 317 */                 }
/* 318 */               }
/* 319 */
/* 320 */               if (!filter_value27) {
/* 321 */                 Object filter_obj15 = ((Expression) references[18]).eval(null);
/* 322 */                 UTF8String filter_value30 = (UTF8String) filter_obj15;
/* 323 */                 if (false) {
/* 324 */                   filter_isNull27 = true;
/* 325 */                 } else if (scan_value2.equals(filter_value30)) {
/* 326 */                   filter_isNull27 = false;
/* 327 */                   filter_value27 = true;
/* 328 */                 }
/* 329 */               }
/* 330 */
/* 331 */               if (!filter_value27) {
/* 332 */                 Object filter_obj16 = ((Expression) references[19]).eval(null);
/* 333 */                 UTF8String filter_value31 = (UTF8String) filter_obj16;
/* 334 */                 if (false) {
/* 335 */                   filter_isNull27 = true;
/* 336 */                 } else if (scan_value2.equals(filter_value31)) {
/* 337 */                   filter_isNull27 = false;
/* 338 */                   filter_value27 = true;
/* 339 */                 }
/* 340 */               }
/* 341 */
/* 342 */               if (!filter_value27) {
/* 343 */                 Object filter_obj17 = ((Expression) references[20]).eval(null);
/* 344 */                 UTF8String filter_value32 = (UTF8String) filter_obj17;
/* 345 */                 if (false) {
/* 346 */                   filter_isNull27 = true;
/* 347 */                 } else if (scan_value2.equals(filter_value32)) {
/* 348 */                   filter_isNull27 = false;
/* 349 */                   filter_value27 = true;
/* 350 */                 }
/* 351 */               }
/* 352 */
/* 353 */             }
/* 354 */             if (!filter_isNull27 && !filter_value27) {
/* 355 */             } else if (!filter_isNull22 && !filter_isNull27) {
/* 356 */               filter_value21 = true;
/* 357 */             } else {
/* 358 */               filter_isNull21 = true;
/* 359 */             }
/* 360 */           }
/* 361 */           boolean filter_isNull20 = false;
/* 362 */           boolean filter_value20 = false;
/* 363 */
/* 364 */           if (!filter_isNull21 && !filter_value21) {
/* 365 */           } else {
/* 366 */             boolean filter_value33 = false;
/* 367 */             boolean filter_isNull33 = scan_isNull1;
/* 368 */             if (!filter_isNull33) {
/* 369 */               if (!filter_value33) {
/* 370 */                 Object filter_obj18 = ((Expression) references[21]).eval(null);
/* 371 */                 UTF8String filter_value35 = (UTF8String) filter_obj18;
/* 372 */                 if (false) {
/* 373 */                   filter_isNull33 = true;
/* 374 */                 } else if (scan_value1.equals(filter_value35)) {
/* 375 */                   filter_isNull33 = false;
/* 376 */                   filter_value33 = true;
/* 377 */                 }
/* 378 */               }
/* 379 */
/* 380 */               if (!filter_value33) {
/* 381 */                 Object filter_obj19 = ((Expression) references[22]).eval(null);
/* 382 */                 UTF8String filter_value36 = (UTF8String) filter_obj19;
/* 383 */                 if (false) {
/* 384 */                   filter_isNull33 = true;
/* 385 */                 } else if (scan_value1.equals(filter_value36)) {
/* 386 */                   filter_isNull33 = false;
/* 387 */                   filter_value33 = true;
/* 388 */                 }
/* 389 */               }
/* 390 */
/* 391 */               if (!filter_value33) {
/* 392 */                 Object filter_obj20 = ((Expression) references[23]).eval(null);
/* 393 */                 UTF8String filter_value37 = (UTF8String) filter_obj20;
/* 394 */                 if (false) {
/* 395 */                   filter_isNull33 = true;
/* 396 */                 } else if (scan_value1.equals(filter_value37)) {
/* 397 */                   filter_isNull33 = false;
/* 398 */                   filter_value33 = true;
/* 399 */                 }
/* 400 */               }
/* 401 */
/* 402 */               if (!filter_value33) {
/* 403 */                 Object filter_obj21 = ((Expression) references[24]).eval(null);
/* 404 */                 UTF8String filter_value38 = (UTF8String) filter_obj21;
/* 405 */                 if (false) {
/* 406 */                   filter_isNull33 = true;
/* 407 */                 } else if (scan_value1.equals(filter_value38)) {
/* 408 */                   filter_isNull33 = false;
/* 409 */                   filter_value33 = true;
/* 410 */                 }
/* 411 */               }
/* 412 */
/* 413 */             }
/* 414 */             if (!filter_isNull33 && !filter_value33) {
/* 415 */             } else if (!filter_isNull21 && !filter_isNull33) {
/* 416 */               filter_value20 = true;
/* 417 */             } else {
/* 418 */               filter_isNull20 = true;
/* 419 */             }
/* 420 */           }
/* 421 */           if (!filter_isNull20 && filter_value20) {
/* 422 */           } else if (!filter_isNull1 && !filter_isNull20) {
/* 423 */             filter_value = false;
/* 424 */           } else {
/* 425 */             filter_isNull = true;
/* 426 */           }
/* 427 */         }
/* 428 */         if (filter_isNull || !filter_value) continue;
/* 429 */
/* 430 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 431 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 432 */
/* 433 */         if (!(!(scan_isNull))) continue;
/* 434 */
/* 435 */         filter_numOutputRows.add(1);
/* 436 */
/* 437 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 438 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 439 */         project_rowWriter.zeroOutNullBytes();
/* 440 */
/* 441 */         project_rowWriter.write(0, scan_value);
/* 442 */
/* 443 */         if (scan_isNull4) {
/* 444 */           project_rowWriter.setNullAt(1);
/* 445 */         } else {
/* 446 */           project_rowWriter.write(1, scan_value4);
/* 447 */         }
/* 448 */         append(project_result);
/* 449 */         if (shouldStop()) return;
/* 450 */       }
/* 451 */       scan_batch = null;
/* 452 */       scan_nextBatch();
/* 453 */     }
/* 454 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 455 */     scan_scanTime1 = 0;
/* 456 */   }
/* 457 */ }

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
/* 092 */       int scan_numRows = scan_batch.numRows();
/* 093 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 094 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 095 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 096 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 097 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 098 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 099 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 100 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 101 */         UTF8String scan_value3 = scan_isNull3 ? null : (scan_colInstance3.getUTF8String(scan_rowIdx));
/* 102 */
/* 103 */         boolean filter_value3 = false;
/* 104 */         boolean filter_isNull3 = scan_isNull3;
/* 105 */         if (!filter_isNull3) {
/* 106 */           if (!filter_value3) {
/* 107 */             if (false) {
/* 108 */               filter_isNull3 = true;
/* 109 */             } else if (scan_value3.equals(((UTF8String) references[3]))) {
/* 110 */               filter_isNull3 = false;
/* 111 */               filter_value3 = true;
/* 112 */             }
/* 113 */           }
/* 114 */
/* 115 */           if (!filter_value3) {
/* 116 */             if (false) {
/* 117 */               filter_isNull3 = true;
/* 118 */             } else if (scan_value3.equals(((UTF8String) references[4]))) {
/* 119 */               filter_isNull3 = false;
/* 120 */               filter_value3 = true;
/* 121 */             }
/* 122 */           }
/* 123 */
/* 124 */           if (!filter_value3) {
/* 125 */             if (false) {
/* 126 */               filter_isNull3 = true;
/* 127 */             } else if (scan_value3.equals(((UTF8String) references[5]))) {
/* 128 */               filter_isNull3 = false;
/* 129 */               filter_value3 = true;
/* 130 */             }
/* 131 */           }
/* 132 */
/* 133 */         }
/* 134 */         boolean filter_isNull2 = false;
/* 135 */         boolean filter_value2 = false;
/* 136 */
/* 137 */         if (!filter_isNull3 && !filter_value3) {
/* 138 */         } else {
/* 139 */           boolean filter_value8 = false;
/* 140 */           boolean filter_isNull8 = scan_isNull2;
/* 141 */           if (!filter_isNull8) {
/* 142 */             if (!filter_value8) {
/* 143 */               if (false) {
/* 144 */                 filter_isNull8 = true;
/* 145 */               } else if (scan_value2.equals(((UTF8String) references[6]))) {
/* 146 */                 filter_isNull8 = false;
/* 147 */                 filter_value8 = true;
/* 148 */               }
/* 149 */             }
/* 150 */
/* 151 */             if (!filter_value8) {
/* 152 */               if (false) {
/* 153 */                 filter_isNull8 = true;
/* 154 */               } else if (scan_value2.equals(((UTF8String) references[7]))) {
/* 155 */                 filter_isNull8 = false;
/* 156 */                 filter_value8 = true;
/* 157 */               }
/* 158 */             }
/* 159 */
/* 160 */             if (!filter_value8) {
/* 161 */               if (false) {
/* 162 */                 filter_isNull8 = true;
/* 163 */               } else if (scan_value2.equals(((UTF8String) references[8]))) {
/* 164 */                 filter_isNull8 = false;
/* 165 */                 filter_value8 = true;
/* 166 */               }
/* 167 */             }
/* 168 */
/* 169 */             if (!filter_value8) {
/* 170 */               if (false) {
/* 171 */                 filter_isNull8 = true;
/* 172 */               } else if (scan_value2.equals(((UTF8String) references[9]))) {
/* 173 */                 filter_isNull8 = false;
/* 174 */                 filter_value8 = true;
/* 175 */               }
/* 176 */             }
/* 177 */
/* 178 */           }
/* 179 */           if (!filter_isNull8 && !filter_value8) {
/* 180 */           } else if (!filter_isNull3 && !filter_isNull8) {
/* 181 */             filter_value2 = true;
/* 182 */           } else {
/* 183 */             filter_isNull2 = true;
/* 184 */           }
/* 185 */         }
/* 186 */         boolean filter_isNull1 = false;
/* 187 */         boolean filter_value1 = false;
/* 188 */
/* 189 */         if (!filter_isNull2 && !filter_value2) {
/* 190 */         } else {
/* 191 */           boolean filter_value14 = false;
/* 192 */           boolean filter_isNull14 = scan_isNull1;
/* 193 */           if (!filter_isNull14) {
/* 194 */             if (!filter_value14) {
/* 195 */               if (false) {
/* 196 */                 filter_isNull14 = true;
/* 197 */               } else if (scan_value1.equals(((UTF8String) references[10]))) {
/* 198 */                 filter_isNull14 = false;
/* 199 */                 filter_value14 = true;
/* 200 */               }
/* 201 */             }
/* 202 */
/* 203 */             if (!filter_value14) {
/* 204 */               if (false) {
/* 205 */                 filter_isNull14 = true;
/* 206 */               } else if (scan_value1.equals(((UTF8String) references[11]))) {
/* 207 */                 filter_isNull14 = false;
/* 208 */                 filter_value14 = true;
/* 209 */               }
/* 210 */             }
/* 211 */
/* 212 */             if (!filter_value14) {
/* 213 */               if (false) {
/* 214 */                 filter_isNull14 = true;
/* 215 */               } else if (scan_value1.equals(((UTF8String) references[12]))) {
/* 216 */                 filter_isNull14 = false;
/* 217 */                 filter_value14 = true;
/* 218 */               }
/* 219 */             }
/* 220 */
/* 221 */             if (!filter_value14) {
/* 222 */               if (false) {
/* 223 */                 filter_isNull14 = true;
/* 224 */               } else if (scan_value1.equals(((UTF8String) references[13]))) {
/* 225 */                 filter_isNull14 = false;
/* 226 */                 filter_value14 = true;
/* 227 */               }
/* 228 */             }
/* 229 */
/* 230 */           }
/* 231 */           if (!filter_isNull14 && !filter_value14) {
/* 232 */           } else if (!filter_isNull2 && !filter_isNull14) {
/* 233 */             filter_value1 = true;
/* 234 */           } else {
/* 235 */             filter_isNull1 = true;
/* 236 */           }
/* 237 */         }
/* 238 */         boolean filter_isNull = false;
/* 239 */         boolean filter_value = true;
/* 240 */
/* 241 */         if (!filter_isNull1 && filter_value1) {
/* 242 */         } else {
/* 243 */           boolean filter_value22 = false;
/* 244 */           boolean filter_isNull22 = scan_isNull3;
/* 245 */           if (!filter_isNull22) {
/* 246 */             if (!filter_value22) {
/* 247 */               if (false) {
/* 248 */                 filter_isNull22 = true;
/* 249 */               } else if (scan_value3.equals(((UTF8String) references[14]))) {
/* 250 */                 filter_isNull22 = false;
/* 251 */                 filter_value22 = true;
/* 252 */               }
/* 253 */             }
/* 254 */
/* 255 */             if (!filter_value22) {
/* 256 */               if (false) {
/* 257 */                 filter_isNull22 = true;
/* 258 */               } else if (scan_value3.equals(((UTF8String) references[15]))) {
/* 259 */                 filter_isNull22 = false;
/* 260 */                 filter_value22 = true;
/* 261 */               }
/* 262 */             }
/* 263 */
/* 264 */             if (!filter_value22) {
/* 265 */               if (false) {
/* 266 */                 filter_isNull22 = true;
/* 267 */               } else if (scan_value3.equals(((UTF8String) references[16]))) {
/* 268 */                 filter_isNull22 = false;
/* 269 */                 filter_value22 = true;
/* 270 */               }
/* 271 */             }
/* 272 */
/* 273 */           }
/* 274 */           boolean filter_isNull21 = false;
/* 275 */           boolean filter_value21 = false;
/* 276 */
/* 277 */           if (!filter_isNull22 && !filter_value22) {
/* 278 */           } else {
/* 279 */             boolean filter_value27 = false;
/* 280 */             boolean filter_isNull27 = scan_isNull2;
/* 281 */             if (!filter_isNull27) {
/* 282 */               if (!filter_value27) {
/* 283 */                 if (false) {
/* 284 */                   filter_isNull27 = true;
/* 285 */                 } else if (scan_value2.equals(((UTF8String) references[17]))) {
/* 286 */                   filter_isNull27 = false;
/* 287 */                   filter_value27 = true;
/* 288 */                 }
/* 289 */               }
/* 290 */
/* 291 */               if (!filter_value27) {
/* 292 */                 if (false) {
/* 293 */                   filter_isNull27 = true;
/* 294 */                 } else if (scan_value2.equals(((UTF8String) references[18]))) {
/* 295 */                   filter_isNull27 = false;
/* 296 */                   filter_value27 = true;
/* 297 */                 }
/* 298 */               }
/* 299 */
/* 300 */               if (!filter_value27) {
/* 301 */                 if (false) {
/* 302 */                   filter_isNull27 = true;
/* 303 */                 } else if (scan_value2.equals(((UTF8String) references[19]))) {
/* 304 */                   filter_isNull27 = false;
/* 305 */                   filter_value27 = true;
/* 306 */                 }
/* 307 */               }
/* 308 */
/* 309 */               if (!filter_value27) {
/* 310 */                 if (false) {
/* 311 */                   filter_isNull27 = true;
/* 312 */                 } else if (scan_value2.equals(((UTF8String) references[20]))) {
/* 313 */                   filter_isNull27 = false;
/* 314 */                   filter_value27 = true;
/* 315 */                 }
/* 316 */               }
/* 317 */
/* 318 */             }
/* 319 */             if (!filter_isNull27 && !filter_value27) {
/* 320 */             } else if (!filter_isNull22 && !filter_isNull27) {
/* 321 */               filter_value21 = true;
/* 322 */             } else {
/* 323 */               filter_isNull21 = true;
/* 324 */             }
/* 325 */           }
/* 326 */           boolean filter_isNull20 = false;
/* 327 */           boolean filter_value20 = false;
/* 328 */
/* 329 */           if (!filter_isNull21 && !filter_value21) {
/* 330 */           } else {
/* 331 */             boolean filter_value33 = false;
/* 332 */             boolean filter_isNull33 = scan_isNull1;
/* 333 */             if (!filter_isNull33) {
/* 334 */               if (!filter_value33) {
/* 335 */                 if (false) {
/* 336 */                   filter_isNull33 = true;
/* 337 */                 } else if (scan_value1.equals(((UTF8String) references[21]))) {
/* 338 */                   filter_isNull33 = false;
/* 339 */                   filter_value33 = true;
/* 340 */                 }
/* 341 */               }
/* 342 */
/* 343 */               if (!filter_value33) {
/* 344 */                 if (false) {
/* 345 */                   filter_isNull33 = true;
/* 346 */                 } else if (scan_value1.equals(((UTF8String) references[22]))) {
/* 347 */                   filter_isNull33 = false;
/* 348 */                   filter_value33 = true;
/* 349 */                 }
/* 350 */               }
/* 351 */
/* 352 */               if (!filter_value33) {
/* 353 */                 if (false) {
/* 354 */                   filter_isNull33 = true;
/* 355 */                 } else if (scan_value1.equals(((UTF8String) references[23]))) {
/* 356 */                   filter_isNull33 = false;
/* 357 */                   filter_value33 = true;
/* 358 */                 }
/* 359 */               }
/* 360 */
/* 361 */               if (!filter_value33) {
/* 362 */                 if (false) {
/* 363 */                   filter_isNull33 = true;
/* 364 */                 } else if (scan_value1.equals(((UTF8String) references[24]))) {
/* 365 */                   filter_isNull33 = false;
/* 366 */                   filter_value33 = true;
/* 367 */                 }
/* 368 */               }
/* 369 */
/* 370 */             }
/* 371 */             if (!filter_isNull33 && !filter_value33) {
/* 372 */             } else if (!filter_isNull21 && !filter_isNull33) {
/* 373 */               filter_value20 = true;
/* 374 */             } else {
/* 375 */               filter_isNull20 = true;
/* 376 */             }
/* 377 */           }
/* 378 */           if (!filter_isNull20 && filter_value20) {
/* 379 */           } else if (!filter_isNull1 && !filter_isNull20) {
/* 380 */             filter_value = false;
/* 381 */           } else {
/* 382 */             filter_isNull = true;
/* 383 */           }
/* 384 */         }
/* 385 */         if (filter_isNull || !filter_value) continue;
/* 386 */
/* 387 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 388 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 389 */
/* 390 */         if (!(!(scan_isNull))) continue;
/* 391 */
/* 392 */         filter_numOutputRows.add(1);
/* 393 */
/* 394 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 395 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 396 */         project_rowWriter.zeroOutNullBytes();
/* 397 */
/* 398 */         project_rowWriter.write(0, scan_value);
/* 399 */
/* 400 */         if (scan_isNull4) {
/* 401 */           project_rowWriter.setNullAt(1);
/* 402 */         } else {
/* 403 */           project_rowWriter.write(1, scan_value4);
/* 404 */         }
/* 405 */         append(project_result);
/* 406 */         if (shouldStop()) { scan_batchIdx = scan_rowIdx + 1; return; }
/* 407 */       }
/* 408 */       scan_batchIdx = scan_numRows;
/* 409 */       scan_batch = null;
/* 410 */       scan_nextBatch();
/* 411 */     }
/* 412 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 413 */     scan_scanTime1 = 0;
/* 414 */   }
/* 415 */ }

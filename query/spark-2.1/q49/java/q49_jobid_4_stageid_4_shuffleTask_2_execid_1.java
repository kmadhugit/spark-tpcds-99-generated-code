/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 018 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 019 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 020 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 023 */   private scala.collection.Iterator inputadapter_input;
/* 024 */   private UnsafeRow agg_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 027 */   private int agg_value10;
/* 028 */   private UnsafeRow agg_result1;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 033 */
/* 034 */   public GeneratedIterator(Object[] references) {
/* 035 */     this.references = references;
/* 036 */   }
/* 037 */
/* 038 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 039 */     partitionIndex = index;
/* 040 */     this.inputs = inputs;
/* 041 */     agg_initAgg = false;
/* 042 */
/* 043 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 044 */
/* 045 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 046 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 047 */     inputadapter_input = inputs[0];
/* 048 */     agg_result = new UnsafeRow(1);
/* 049 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 050 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 051 */
/* 052 */     agg_result1 = new UnsafeRow(3);
/* 053 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 054 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 055 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 056 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 057 */
/* 058 */   }
/* 059 */
/* 060 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 061 */     agg_hashMap = agg_plan.createHashMap();
/* 062 */
/* 063 */     while (inputadapter_input.hasNext()) {
/* 064 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 065 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 066 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 067 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 068 */       long inputadapter_value1 = inputadapter_isNull1 ? -1L : (inputadapter_row.getLong(1));
/* 069 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 070 */       long inputadapter_value2 = inputadapter_isNull2 ? -1L : (inputadapter_row.getLong(2));
/* 071 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 072 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 073 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 074 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 075 */
/* 076 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 077 */
/* 078 */       UnsafeRow agg_fastAggBuffer = null;
/* 079 */
/* 080 */       if (agg_fastAggBuffer == null) {
/* 081 */         // generate grouping key
/* 082 */         agg_rowWriter.zeroOutNullBytes();
/* 083 */
/* 084 */         if (inputadapter_isNull) {
/* 085 */           agg_rowWriter.setNullAt(0);
/* 086 */         } else {
/* 087 */           agg_rowWriter.write(0, inputadapter_value);
/* 088 */         }
/* 089 */         agg_value10 = 42;
/* 090 */
/* 091 */         if (!inputadapter_isNull) {
/* 092 */           agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value10);
/* 093 */         }
/* 094 */         if (true) {
/* 095 */           // try to get the buffer from hash map
/* 096 */           agg_unsafeRowAggBuffer =
/* 097 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
/* 098 */         }
/* 099 */         if (agg_unsafeRowAggBuffer == null) {
/* 100 */           if (agg_sorter == null) {
/* 101 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 102 */           } else {
/* 103 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 104 */           }
/* 105 */
/* 106 */           // the hash map had be spilled, it should have enough memory now,
/* 107 */           // try  to allocate buffer again.
/* 108 */           agg_unsafeRowAggBuffer =
/* 109 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value10);
/* 110 */           if (agg_unsafeRowAggBuffer == null) {
/* 111 */             // failed to allocate the first page
/* 112 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 113 */           }
/* 114 */         }
/* 115 */       }
/* 116 */
/* 117 */       if (agg_fastAggBuffer != null) {
/* 118 */         // update fast row
/* 119 */
/* 120 */       } else {
/* 121 */         // update unsafe row
/* 122 */
/* 123 */         // common sub-expressions
/* 124 */         boolean agg_isNull8 = false;
/* 125 */         double agg_value12 = -1.0;
/* 126 */         if (!false) {
/* 127 */           agg_value12 = (double) 0;
/* 128 */         }
/* 129 */         boolean agg_isNull10 = false;
/* 130 */         long agg_value14 = -1L;
/* 131 */         if (!false) {
/* 132 */           agg_value14 = (long) 0;
/* 133 */         }
/* 134 */         // evaluate aggregate function
/* 135 */         boolean agg_isNull13 = true;
/* 136 */         long agg_value17 = -1L;
/* 137 */
/* 138 */         boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 139 */         long agg_value19 = agg_isNull15 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 140 */         boolean agg_isNull14 = agg_isNull15;
/* 141 */         long agg_value18 = agg_value19;
/* 142 */         if (agg_isNull14) {
/* 143 */           if (!agg_isNull10) {
/* 144 */             agg_isNull14 = false;
/* 145 */             agg_value18 = agg_value14;
/* 146 */           }
/* 147 */         }
/* 148 */
/* 149 */         if (!inputadapter_isNull1) {
/* 150 */           agg_isNull13 = false; // resultCode could change nullability.
/* 151 */           agg_value17 = agg_value18 + inputadapter_value1;
/* 152 */
/* 153 */         }
/* 154 */         boolean agg_isNull12 = agg_isNull13;
/* 155 */         long agg_value16 = agg_value17;
/* 156 */         if (agg_isNull12) {
/* 157 */           boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 158 */           long agg_value21 = agg_isNull17 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 159 */           if (!agg_isNull17) {
/* 160 */             agg_isNull12 = false;
/* 161 */             agg_value16 = agg_value21;
/* 162 */           }
/* 163 */         }
/* 164 */         boolean agg_isNull19 = true;
/* 165 */         long agg_value23 = -1L;
/* 166 */
/* 167 */         boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 168 */         long agg_value25 = agg_isNull21 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 169 */         boolean agg_isNull20 = agg_isNull21;
/* 170 */         long agg_value24 = agg_value25;
/* 171 */         if (agg_isNull20) {
/* 172 */           if (!agg_isNull10) {
/* 173 */             agg_isNull20 = false;
/* 174 */             agg_value24 = agg_value14;
/* 175 */           }
/* 176 */         }
/* 177 */
/* 178 */         if (!inputadapter_isNull2) {
/* 179 */           agg_isNull19 = false; // resultCode could change nullability.
/* 180 */           agg_value23 = agg_value24 + inputadapter_value2;
/* 181 */
/* 182 */         }
/* 183 */         boolean agg_isNull18 = agg_isNull19;
/* 184 */         long agg_value22 = agg_value23;
/* 185 */         if (agg_isNull18) {
/* 186 */           boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 187 */           long agg_value27 = agg_isNull23 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 188 */           if (!agg_isNull23) {
/* 189 */             agg_isNull18 = false;
/* 190 */             agg_value22 = agg_value27;
/* 191 */           }
/* 192 */         }
/* 193 */         boolean agg_isNull25 = true;
/* 194 */         double agg_value29 = -1.0;
/* 195 */
/* 196 */         boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 197 */         double agg_value31 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 198 */         boolean agg_isNull26 = agg_isNull27;
/* 199 */         double agg_value30 = agg_value31;
/* 200 */         if (agg_isNull26) {
/* 201 */           if (!agg_isNull8) {
/* 202 */             agg_isNull26 = false;
/* 203 */             agg_value30 = agg_value12;
/* 204 */           }
/* 205 */         }
/* 206 */
/* 207 */         if (!inputadapter_isNull3) {
/* 208 */           agg_isNull25 = false; // resultCode could change nullability.
/* 209 */           agg_value29 = agg_value30 + inputadapter_value3;
/* 210 */
/* 211 */         }
/* 212 */         boolean agg_isNull24 = agg_isNull25;
/* 213 */         double agg_value28 = agg_value29;
/* 214 */         if (agg_isNull24) {
/* 215 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 216 */           double agg_value33 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 217 */           if (!agg_isNull29) {
/* 218 */             agg_isNull24 = false;
/* 219 */             agg_value28 = agg_value33;
/* 220 */           }
/* 221 */         }
/* 222 */         boolean agg_isNull31 = true;
/* 223 */         double agg_value35 = -1.0;
/* 224 */
/* 225 */         boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 226 */         double agg_value37 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 227 */         boolean agg_isNull32 = agg_isNull33;
/* 228 */         double agg_value36 = agg_value37;
/* 229 */         if (agg_isNull32) {
/* 230 */           if (!agg_isNull8) {
/* 231 */             agg_isNull32 = false;
/* 232 */             agg_value36 = agg_value12;
/* 233 */           }
/* 234 */         }
/* 235 */
/* 236 */         if (!inputadapter_isNull4) {
/* 237 */           agg_isNull31 = false; // resultCode could change nullability.
/* 238 */           agg_value35 = agg_value36 + inputadapter_value4;
/* 239 */
/* 240 */         }
/* 241 */         boolean agg_isNull30 = agg_isNull31;
/* 242 */         double agg_value34 = agg_value35;
/* 243 */         if (agg_isNull30) {
/* 244 */           boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 245 */           double agg_value39 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 246 */           if (!agg_isNull35) {
/* 247 */             agg_isNull30 = false;
/* 248 */             agg_value34 = agg_value39;
/* 249 */           }
/* 250 */         }
/* 251 */         // update unsafe row buffer
/* 252 */         if (!agg_isNull12) {
/* 253 */           agg_unsafeRowAggBuffer.setLong(0, agg_value16);
/* 254 */         } else {
/* 255 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 256 */         }
/* 257 */
/* 258 */         if (!agg_isNull18) {
/* 259 */           agg_unsafeRowAggBuffer.setLong(1, agg_value22);
/* 260 */         } else {
/* 261 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 262 */         }
/* 263 */
/* 264 */         if (!agg_isNull24) {
/* 265 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value28);
/* 266 */         } else {
/* 267 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 268 */         }
/* 269 */
/* 270 */         if (!agg_isNull30) {
/* 271 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value34);
/* 272 */         } else {
/* 273 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 274 */         }
/* 275 */
/* 276 */       }
/* 277 */       if (shouldStop()) return;
/* 278 */     }
/* 279 */
/* 280 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 281 */   }
/* 282 */
/* 283 */   protected void processNext() throws java.io.IOException {
/* 284 */     if (!agg_initAgg) {
/* 285 */       agg_initAgg = true;
/* 286 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 287 */       agg_doAggregateWithKeys();
/* 288 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 289 */     }
/* 290 */
/* 291 */     // output the result
/* 292 */
/* 293 */     while (agg_mapIter.next()) {
/* 294 */       wholestagecodegen_numOutputRows.add(1);
/* 295 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 296 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 297 */
/* 298 */       boolean agg_isNull36 = agg_aggKey.isNullAt(0);
/* 299 */       int agg_value40 = agg_isNull36 ? -1 : (agg_aggKey.getInt(0));
/* 300 */       boolean agg_isNull37 = agg_aggBuffer.isNullAt(0);
/* 301 */       long agg_value41 = agg_isNull37 ? -1L : (agg_aggBuffer.getLong(0));
/* 302 */       boolean agg_isNull38 = agg_aggBuffer.isNullAt(1);
/* 303 */       long agg_value42 = agg_isNull38 ? -1L : (agg_aggBuffer.getLong(1));
/* 304 */       boolean agg_isNull39 = agg_aggBuffer.isNullAt(2);
/* 305 */       double agg_value43 = agg_isNull39 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 306 */       boolean agg_isNull40 = agg_aggBuffer.isNullAt(3);
/* 307 */       double agg_value44 = agg_isNull40 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 308 */
/* 309 */       boolean agg_isNull50 = agg_isNull38;
/* 310 */       Decimal agg_value54 = null;
/* 311 */       if (!agg_isNull38) {
/* 312 */         Decimal agg_tmpDecimal1 = Decimal.apply((long) agg_value42);
/* 313 */
/* 314 */         if (agg_tmpDecimal1.changePrecision(15, 4)) {
/* 315 */           agg_value54 = agg_tmpDecimal1;
/* 316 */         } else {
/* 317 */           agg_isNull50 = true;
/* 318 */         }
/* 319 */
/* 320 */       }
/* 321 */       boolean agg_isNull47 = false;
/* 322 */       Decimal agg_value51 = null;
/* 323 */       if (agg_isNull50 || agg_value54.isZero()) {
/* 324 */         agg_isNull47 = true;
/* 325 */       } else {
/* 326 */         boolean agg_isNull48 = agg_isNull37;
/* 327 */         Decimal agg_value52 = null;
/* 328 */         if (!agg_isNull37) {
/* 329 */           Decimal agg_tmpDecimal = Decimal.apply((long) agg_value41);
/* 330 */
/* 331 */           if (agg_tmpDecimal.changePrecision(15, 4)) {
/* 332 */             agg_value52 = agg_tmpDecimal;
/* 333 */           } else {
/* 334 */             agg_isNull48 = true;
/* 335 */           }
/* 336 */
/* 337 */         }
/* 338 */         if (agg_isNull48) {
/* 339 */           agg_isNull47 = true;
/* 340 */         } else {
/* 341 */           agg_value51 = agg_value52.$div(agg_value54);
/* 342 */         }
/* 343 */       }
/* 344 */       boolean agg_isNull46 = agg_isNull47;
/* 345 */       Decimal agg_value50 = null;
/* 346 */
/* 347 */       if (!agg_isNull47) {
/* 348 */         Decimal agg_tmp = agg_value51.clone();
/* 349 */         if (agg_tmp.changePrecision(35, 20)) {
/* 350 */           agg_value50 = agg_tmp;
/* 351 */         } else {
/* 352 */           agg_isNull46 = true;
/* 353 */         }
/* 354 */
/* 355 */       }
/* 356 */       boolean agg_isNull56 = agg_isNull40;
/* 357 */       Decimal agg_value60 = null;
/* 358 */       if (!agg_isNull40) {
/* 359 */         try {
/* 360 */           Decimal agg_tmpDecimal3 = Decimal.apply(scala.math.BigDecimal.valueOf((double) agg_value44));
/* 361 */
/* 362 */           if (agg_tmpDecimal3.changePrecision(15, 4)) {
/* 363 */             agg_value60 = agg_tmpDecimal3;
/* 364 */           } else {
/* 365 */             agg_isNull56 = true;
/* 366 */           }
/* 367 */
/* 368 */         } catch (java.lang.NumberFormatException e) {
/* 369 */           agg_isNull56 = true;
/* 370 */         }
/* 371 */
/* 372 */       }
/* 373 */       boolean agg_isNull53 = false;
/* 374 */       Decimal agg_value57 = null;
/* 375 */       if (agg_isNull56 || agg_value60.isZero()) {
/* 376 */         agg_isNull53 = true;
/* 377 */       } else {
/* 378 */         boolean agg_isNull54 = agg_isNull39;
/* 379 */         Decimal agg_value58 = null;
/* 380 */         if (!agg_isNull39) {
/* 381 */           try {
/* 382 */             Decimal agg_tmpDecimal2 = Decimal.apply(scala.math.BigDecimal.valueOf((double) agg_value43));
/* 383 */
/* 384 */             if (agg_tmpDecimal2.changePrecision(15, 4)) {
/* 385 */               agg_value58 = agg_tmpDecimal2;
/* 386 */             } else {
/* 387 */               agg_isNull54 = true;
/* 388 */             }
/* 389 */
/* 390 */           } catch (java.lang.NumberFormatException e) {
/* 391 */             agg_isNull54 = true;
/* 392 */           }
/* 393 */
/* 394 */         }
/* 395 */         if (agg_isNull54) {
/* 396 */           agg_isNull53 = true;
/* 397 */         } else {
/* 398 */           agg_value57 = agg_value58.$div(agg_value60);
/* 399 */         }
/* 400 */       }
/* 401 */       boolean agg_isNull52 = agg_isNull53;
/* 402 */       Decimal agg_value56 = null;
/* 403 */
/* 404 */       if (!agg_isNull53) {
/* 405 */         Decimal agg_tmp1 = agg_value57.clone();
/* 406 */         if (agg_tmp1.changePrecision(35, 20)) {
/* 407 */           agg_value56 = agg_tmp1;
/* 408 */         } else {
/* 409 */           agg_isNull52 = true;
/* 410 */         }
/* 411 */
/* 412 */       }
/* 413 */       agg_holder1.reset();
/* 414 */
/* 415 */       agg_rowWriter1.zeroOutNullBytes();
/* 416 */
/* 417 */       if (agg_isNull36) {
/* 418 */         agg_rowWriter1.setNullAt(0);
/* 419 */       } else {
/* 420 */         agg_rowWriter1.write(0, agg_value40);
/* 421 */       }
/* 422 */
/* 423 */       if (agg_isNull46) {
/* 424 */         agg_rowWriter1.write(1, (Decimal) null, 35, 20);
/* 425 */       } else {
/* 426 */         agg_rowWriter1.write(1, agg_value50, 35, 20);
/* 427 */       }
/* 428 */
/* 429 */       if (agg_isNull52) {
/* 430 */         agg_rowWriter1.write(2, (Decimal) null, 35, 20);
/* 431 */       } else {
/* 432 */         agg_rowWriter1.write(2, agg_value56, 35, 20);
/* 433 */       }
/* 434 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 435 */       append(agg_result1);
/* 436 */
/* 437 */       if (shouldStop()) return;
/* 438 */     }
/* 439 */
/* 440 */     agg_mapIter.close();
/* 441 */     if (agg_sorter == null) {
/* 442 */       agg_hashMap.free();
/* 443 */     }
/* 444 */   }
/* 445 */ }

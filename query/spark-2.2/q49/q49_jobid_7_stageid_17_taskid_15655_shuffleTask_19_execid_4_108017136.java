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
/* 063 */     while (inputadapter_input.hasNext() && !stopEarly()) {
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
/* 124 */
/* 125 */         // evaluate aggregate function
/* 126 */         boolean agg_isNull9 = true;
/* 127 */         long agg_value13 = -1L;
/* 128 */
/* 129 */         boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 130 */         long agg_value15 = agg_isNull11 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 131 */         boolean agg_isNull10 = agg_isNull11;
/* 132 */         long agg_value14 = agg_value15;
/* 133 */         if (agg_isNull10) {
/* 134 */           boolean agg_isNull12 = false;
/* 135 */           long agg_value16 = -1L;
/* 136 */           if (!false) {
/* 137 */             agg_value16 = (long) 0;
/* 138 */           }
/* 139 */           if (!agg_isNull12) {
/* 140 */             agg_isNull10 = false;
/* 141 */             agg_value14 = agg_value16;
/* 142 */           }
/* 143 */         }
/* 144 */
/* 145 */         if (!inputadapter_isNull1) {
/* 146 */           agg_isNull9 = false; // resultCode could change nullability.
/* 147 */           agg_value13 = agg_value14 + inputadapter_value1;
/* 148 */
/* 149 */         }
/* 150 */         boolean agg_isNull8 = agg_isNull9;
/* 151 */         long agg_value12 = agg_value13;
/* 152 */         if (agg_isNull8) {
/* 153 */           boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 154 */           long agg_value19 = agg_isNull15 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 155 */           if (!agg_isNull15) {
/* 156 */             agg_isNull8 = false;
/* 157 */             agg_value12 = agg_value19;
/* 158 */           }
/* 159 */         }
/* 160 */         boolean agg_isNull17 = true;
/* 161 */         long agg_value21 = -1L;
/* 162 */
/* 163 */         boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 164 */         long agg_value23 = agg_isNull19 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 165 */         boolean agg_isNull18 = agg_isNull19;
/* 166 */         long agg_value22 = agg_value23;
/* 167 */         if (agg_isNull18) {
/* 168 */           boolean agg_isNull20 = false;
/* 169 */           long agg_value24 = -1L;
/* 170 */           if (!false) {
/* 171 */             agg_value24 = (long) 0;
/* 172 */           }
/* 173 */           if (!agg_isNull20) {
/* 174 */             agg_isNull18 = false;
/* 175 */             agg_value22 = agg_value24;
/* 176 */           }
/* 177 */         }
/* 178 */
/* 179 */         if (!inputadapter_isNull2) {
/* 180 */           agg_isNull17 = false; // resultCode could change nullability.
/* 181 */           agg_value21 = agg_value22 + inputadapter_value2;
/* 182 */
/* 183 */         }
/* 184 */         boolean agg_isNull16 = agg_isNull17;
/* 185 */         long agg_value20 = agg_value21;
/* 186 */         if (agg_isNull16) {
/* 187 */           boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 188 */           long agg_value27 = agg_isNull23 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 189 */           if (!agg_isNull23) {
/* 190 */             agg_isNull16 = false;
/* 191 */             agg_value20 = agg_value27;
/* 192 */           }
/* 193 */         }
/* 194 */         boolean agg_isNull25 = true;
/* 195 */         double agg_value29 = -1.0;
/* 196 */
/* 197 */         boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 198 */         double agg_value31 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 199 */         boolean agg_isNull26 = agg_isNull27;
/* 200 */         double agg_value30 = agg_value31;
/* 201 */         if (agg_isNull26) {
/* 202 */           boolean agg_isNull28 = false;
/* 203 */           double agg_value32 = -1.0;
/* 204 */           if (!false) {
/* 205 */             agg_value32 = (double) 0;
/* 206 */           }
/* 207 */           if (!agg_isNull28) {
/* 208 */             agg_isNull26 = false;
/* 209 */             agg_value30 = agg_value32;
/* 210 */           }
/* 211 */         }
/* 212 */
/* 213 */         if (!inputadapter_isNull3) {
/* 214 */           agg_isNull25 = false; // resultCode could change nullability.
/* 215 */           agg_value29 = agg_value30 + inputadapter_value3;
/* 216 */
/* 217 */         }
/* 218 */         boolean agg_isNull24 = agg_isNull25;
/* 219 */         double agg_value28 = agg_value29;
/* 220 */         if (agg_isNull24) {
/* 221 */           boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 222 */           double agg_value35 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 223 */           if (!agg_isNull31) {
/* 224 */             agg_isNull24 = false;
/* 225 */             agg_value28 = agg_value35;
/* 226 */           }
/* 227 */         }
/* 228 */         boolean agg_isNull33 = true;
/* 229 */         double agg_value37 = -1.0;
/* 230 */
/* 231 */         boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 232 */         double agg_value39 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 233 */         boolean agg_isNull34 = agg_isNull35;
/* 234 */         double agg_value38 = agg_value39;
/* 235 */         if (agg_isNull34) {
/* 236 */           boolean agg_isNull36 = false;
/* 237 */           double agg_value40 = -1.0;
/* 238 */           if (!false) {
/* 239 */             agg_value40 = (double) 0;
/* 240 */           }
/* 241 */           if (!agg_isNull36) {
/* 242 */             agg_isNull34 = false;
/* 243 */             agg_value38 = agg_value40;
/* 244 */           }
/* 245 */         }
/* 246 */
/* 247 */         if (!inputadapter_isNull4) {
/* 248 */           agg_isNull33 = false; // resultCode could change nullability.
/* 249 */           agg_value37 = agg_value38 + inputadapter_value4;
/* 250 */
/* 251 */         }
/* 252 */         boolean agg_isNull32 = agg_isNull33;
/* 253 */         double agg_value36 = agg_value37;
/* 254 */         if (agg_isNull32) {
/* 255 */           boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 256 */           double agg_value43 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 257 */           if (!agg_isNull39) {
/* 258 */             agg_isNull32 = false;
/* 259 */             agg_value36 = agg_value43;
/* 260 */           }
/* 261 */         }
/* 262 */         // update unsafe row buffer
/* 263 */         if (!agg_isNull8) {
/* 264 */           agg_unsafeRowAggBuffer.setLong(0, agg_value12);
/* 265 */         } else {
/* 266 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 267 */         }
/* 268 */
/* 269 */         if (!agg_isNull16) {
/* 270 */           agg_unsafeRowAggBuffer.setLong(1, agg_value20);
/* 271 */         } else {
/* 272 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 273 */         }
/* 274 */
/* 275 */         if (!agg_isNull24) {
/* 276 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value28);
/* 277 */         } else {
/* 278 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 279 */         }
/* 280 */
/* 281 */         if (!agg_isNull32) {
/* 282 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value36);
/* 283 */         } else {
/* 284 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 285 */         }
/* 286 */
/* 287 */       }
/* 288 */       if (shouldStop()) return;
/* 289 */     }
/* 290 */
/* 291 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 292 */   }
/* 293 */
/* 294 */   protected void processNext() throws java.io.IOException {
/* 295 */     if (!agg_initAgg) {
/* 296 */       agg_initAgg = true;
/* 297 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 298 */       agg_doAggregateWithKeys();
/* 299 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 300 */     }
/* 301 */
/* 302 */     // output the result
/* 303 */
/* 304 */     while (agg_mapIter.next()) {
/* 305 */       wholestagecodegen_numOutputRows.add(1);
/* 306 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 307 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 308 */
/* 309 */       boolean agg_isNull40 = agg_aggKey.isNullAt(0);
/* 310 */       int agg_value44 = agg_isNull40 ? -1 : (agg_aggKey.getInt(0));
/* 311 */       boolean agg_isNull41 = agg_aggBuffer.isNullAt(0);
/* 312 */       long agg_value45 = agg_isNull41 ? -1L : (agg_aggBuffer.getLong(0));
/* 313 */       boolean agg_isNull42 = agg_aggBuffer.isNullAt(1);
/* 314 */       long agg_value46 = agg_isNull42 ? -1L : (agg_aggBuffer.getLong(1));
/* 315 */       boolean agg_isNull43 = agg_aggBuffer.isNullAt(2);
/* 316 */       double agg_value47 = agg_isNull43 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 317 */       boolean agg_isNull44 = agg_aggBuffer.isNullAt(3);
/* 318 */       double agg_value48 = agg_isNull44 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 319 */
/* 320 */       boolean agg_isNull54 = agg_isNull42;
/* 321 */       Decimal agg_value58 = null;
/* 322 */       if (!agg_isNull42) {
/* 323 */         Decimal agg_tmpDecimal1 = Decimal.apply((long) agg_value46);
/* 324 */
/* 325 */         if (agg_tmpDecimal1.changePrecision(15, 4)) {
/* 326 */           agg_value58 = agg_tmpDecimal1;
/* 327 */         } else {
/* 328 */           agg_isNull54 = true;
/* 329 */         }
/* 330 */
/* 331 */       }
/* 332 */       boolean agg_isNull51 = false;
/* 333 */       Decimal agg_value55 = null;
/* 334 */       if (agg_isNull54 || agg_value58.isZero()) {
/* 335 */         agg_isNull51 = true;
/* 336 */       } else {
/* 337 */         boolean agg_isNull52 = agg_isNull41;
/* 338 */         Decimal agg_value56 = null;
/* 339 */         if (!agg_isNull41) {
/* 340 */           Decimal agg_tmpDecimal = Decimal.apply((long) agg_value45);
/* 341 */
/* 342 */           if (agg_tmpDecimal.changePrecision(15, 4)) {
/* 343 */             agg_value56 = agg_tmpDecimal;
/* 344 */           } else {
/* 345 */             agg_isNull52 = true;
/* 346 */           }
/* 347 */
/* 348 */         }
/* 349 */         if (agg_isNull52) {
/* 350 */           agg_isNull51 = true;
/* 351 */         } else {
/* 352 */           agg_value55 = agg_value56.$div(agg_value58);
/* 353 */         }
/* 354 */       }
/* 355 */       boolean agg_isNull50 = agg_isNull51;
/* 356 */       Decimal agg_value54 = null;
/* 357 */
/* 358 */       if (!agg_isNull51) {
/* 359 */         Decimal agg_tmp = agg_value55.clone();
/* 360 */         if (agg_tmp.changePrecision(35, 20)) {
/* 361 */           agg_value54 = agg_tmp;
/* 362 */         } else {
/* 363 */           agg_isNull50 = true;
/* 364 */         }
/* 365 */
/* 366 */       }
/* 367 */       boolean agg_isNull60 = agg_isNull44;
/* 368 */       Decimal agg_value64 = null;
/* 369 */       if (!agg_isNull44) {
/* 370 */         try {
/* 371 */           Decimal agg_tmpDecimal3 = Decimal.apply(scala.math.BigDecimal.valueOf((double) agg_value48));
/* 372 */
/* 373 */           if (agg_tmpDecimal3.changePrecision(15, 4)) {
/* 374 */             agg_value64 = agg_tmpDecimal3;
/* 375 */           } else {
/* 376 */             agg_isNull60 = true;
/* 377 */           }
/* 378 */
/* 379 */         } catch (java.lang.NumberFormatException e) {
/* 380 */           agg_isNull60 = true;
/* 381 */         }
/* 382 */
/* 383 */       }
/* 384 */       boolean agg_isNull57 = false;
/* 385 */       Decimal agg_value61 = null;
/* 386 */       if (agg_isNull60 || agg_value64.isZero()) {
/* 387 */         agg_isNull57 = true;
/* 388 */       } else {
/* 389 */         boolean agg_isNull58 = agg_isNull43;
/* 390 */         Decimal agg_value62 = null;
/* 391 */         if (!agg_isNull43) {
/* 392 */           try {
/* 393 */             Decimal agg_tmpDecimal2 = Decimal.apply(scala.math.BigDecimal.valueOf((double) agg_value47));
/* 394 */
/* 395 */             if (agg_tmpDecimal2.changePrecision(15, 4)) {
/* 396 */               agg_value62 = agg_tmpDecimal2;
/* 397 */             } else {
/* 398 */               agg_isNull58 = true;
/* 399 */             }
/* 400 */
/* 401 */           } catch (java.lang.NumberFormatException e) {
/* 402 */             agg_isNull58 = true;
/* 403 */           }
/* 404 */
/* 405 */         }
/* 406 */         if (agg_isNull58) {
/* 407 */           agg_isNull57 = true;
/* 408 */         } else {
/* 409 */           agg_value61 = agg_value62.$div(agg_value64);
/* 410 */         }
/* 411 */       }
/* 412 */       boolean agg_isNull56 = agg_isNull57;
/* 413 */       Decimal agg_value60 = null;
/* 414 */
/* 415 */       if (!agg_isNull57) {
/* 416 */         Decimal agg_tmp1 = agg_value61.clone();
/* 417 */         if (agg_tmp1.changePrecision(35, 20)) {
/* 418 */           agg_value60 = agg_tmp1;
/* 419 */         } else {
/* 420 */           agg_isNull56 = true;
/* 421 */         }
/* 422 */
/* 423 */       }
/* 424 */       agg_holder1.reset();
/* 425 */
/* 426 */       agg_rowWriter1.zeroOutNullBytes();
/* 427 */
/* 428 */       if (agg_isNull40) {
/* 429 */         agg_rowWriter1.setNullAt(0);
/* 430 */       } else {
/* 431 */         agg_rowWriter1.write(0, agg_value44);
/* 432 */       }
/* 433 */
/* 434 */       if (agg_isNull50) {
/* 435 */         agg_rowWriter1.write(1, (Decimal) null, 35, 20);
/* 436 */       } else {
/* 437 */         agg_rowWriter1.write(1, agg_value54, 35, 20);
/* 438 */       }
/* 439 */
/* 440 */       if (agg_isNull56) {
/* 441 */         agg_rowWriter1.write(2, (Decimal) null, 35, 20);
/* 442 */       } else {
/* 443 */         agg_rowWriter1.write(2, agg_value60, 35, 20);
/* 444 */       }
/* 445 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 446 */       append(agg_result1);
/* 447 */
/* 448 */       if (shouldStop()) return;
/* 449 */     }
/* 450 */
/* 451 */     agg_mapIter.close();
/* 452 */     if (agg_sorter == null) {
/* 453 */       agg_hashMap.free();
/* 454 */     }
/* 455 */   }
/* 456 */ }

/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private agg_FastHashMap agg_fastHashMap;
/* 015 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 016 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 017 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 018 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 021 */   private scala.collection.Iterator scan_input;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 024 */   private long scan_scanTime1;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 026 */   private int scan_batchIdx;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 031 */   private UnsafeRow scan_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 035 */   private UnsafeRow filter_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 038 */   private UnsafeRow project_result;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 041 */   private UnsafeRow agg_result1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 044 */   private int agg_value7;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 048 */
/* 049 */   public GeneratedIterator(Object[] references) {
/* 050 */     this.references = references;
/* 051 */   }
/* 052 */
/* 053 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 054 */     partitionIndex = index;
/* 055 */     this.inputs = inputs;
/* 056 */     wholestagecodegen_init_0();
/* 057 */     wholestagecodegen_init_1();
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */   private void wholestagecodegen_init_0() {
/* 062 */     agg_initAgg = false;
/* 063 */
/* 064 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 065 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 066 */
/* 067 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 068 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 069 */     scan_input = inputs[0];
/* 070 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 071 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 072 */     scan_scanTime1 = 0;
/* 073 */     scan_batch = null;
/* 074 */     scan_batchIdx = 0;
/* 075 */     scan_colInstance0 = null;
/* 076 */     scan_colInstance1 = null;
/* 077 */     scan_colInstance2 = null;
/* 078 */     scan_colInstance3 = null;
/* 079 */     scan_result = new UnsafeRow(4);
/* 080 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 081 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 082 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 083 */
/* 084 */   }
/* 085 */
/* 086 */   private void scan_nextBatch() throws java.io.IOException {
/* 087 */     long getBatchStart = System.nanoTime();
/* 088 */     if (scan_input.hasNext()) {
/* 089 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 090 */       scan_numOutputRows.add(scan_batch.numRows());
/* 091 */       scan_batchIdx = 0;
/* 092 */       scan_colInstance0 = scan_batch.column(0);
/* 093 */       scan_colInstance1 = scan_batch.column(1);
/* 094 */       scan_colInstance2 = scan_batch.column(2);
/* 095 */       scan_colInstance3 = scan_batch.column(3);
/* 096 */
/* 097 */     }
/* 098 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 099 */   }
/* 100 */
/* 101 */   public class agg_FastHashMap {
/* 102 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 103 */     private int[] buckets;
/* 104 */     private int capacity = 1 << 16;
/* 105 */     private double loadFactor = 0.5;
/* 106 */     private int numBuckets = (int) (capacity / loadFactor);
/* 107 */     private int maxSteps = 2;
/* 108 */     private int numRows = 0;
/* 109 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 110 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 111 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.LongType);
/* 112 */     private Object emptyVBase;
/* 113 */     private long emptyVOff;
/* 114 */     private int emptyVLen;
/* 115 */     private boolean isBatchFull = false;
/* 116 */
/* 117 */     public agg_FastHashMap(
/* 118 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 119 */       InternalRow emptyAggregationBuffer) {
/* 120 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 121 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 122 */
/* 123 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 124 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 125 */
/* 126 */       emptyVBase = emptyBuffer;
/* 127 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 128 */       emptyVLen = emptyBuffer.length;
/* 129 */
/* 130 */       buckets = new int[numBuckets];
/* 131 */       java.util.Arrays.fill(buckets, -1);
/* 132 */     }
/* 133 */
/* 134 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 135 */       long h = hash(agg_key);
/* 136 */       int step = 0;
/* 137 */       int idx = (int) h & (numBuckets - 1);
/* 138 */       while (step < maxSteps) {
/* 139 */         // Return bucket index if it's either an empty slot or already contains the key
/* 140 */         if (buckets[idx] == -1) {
/* 141 */           if (numRows < capacity && !isBatchFull) {
/* 142 */             // creating the unsafe for new entry
/* 143 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 144 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 145 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 146 */               0);
/* 147 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 148 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 149 */               agg_holder,
/* 150 */               1);
/* 151 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 152 */             agg_rowWriter.zeroOutNullBytes();
/* 153 */             agg_rowWriter.write(0, agg_key);
/* 154 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 155 */             Object kbase = agg_result.getBaseObject();
/* 156 */             long koff = agg_result.getBaseOffset();
/* 157 */             int klen = agg_result.getSizeInBytes();
/* 158 */
/* 159 */             UnsafeRow vRow
/* 160 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 161 */             if (vRow == null) {
/* 162 */               isBatchFull = true;
/* 163 */             } else {
/* 164 */               buckets[idx] = numRows++;
/* 165 */             }
/* 166 */             return vRow;
/* 167 */           } else {
/* 168 */             // No more space
/* 169 */             return null;
/* 170 */           }
/* 171 */         } else if (equals(idx, agg_key)) {
/* 172 */           return batch.getValueRow(buckets[idx]);
/* 173 */         }
/* 174 */         idx = (idx + 1) & (numBuckets - 1);
/* 175 */         step++;
/* 176 */       }
/* 177 */       // Didn't find it
/* 178 */       return null;
/* 179 */     }
/* 180 */
/* 181 */     private boolean equals(int idx, int agg_key) {
/* 182 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 183 */       return (row.getInt(0) == agg_key);
/* 184 */     }
/* 185 */
/* 186 */     private long hash(int agg_key) {
/* 187 */       long agg_hash = 0;
/* 188 */
/* 189 */       int agg_result = agg_key;
/* 190 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 191 */
/* 192 */       return agg_hash;
/* 193 */     }
/* 194 */
/* 195 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 196 */       return batch.rowIterator();
/* 197 */     }
/* 198 */
/* 199 */     public void close() {
/* 200 */       batch.close();
/* 201 */     }
/* 202 */
/* 203 */   }
/* 204 */
/* 205 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 206 */     agg_hashMap = agg_plan.createHashMap();
/* 207 */
/* 208 */     if (scan_batch == null) {
/* 209 */       scan_nextBatch();
/* 210 */     }
/* 211 */     while (scan_batch != null) {
/* 212 */       int scan_numRows = scan_batch.numRows();
/* 213 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 214 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 215 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 216 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 217 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 218 */
/* 219 */         if (!(!(scan_isNull1))) continue;
/* 220 */
/* 221 */         boolean filter_isNull2 = false;
/* 222 */
/* 223 */         boolean filter_value2 = false;
/* 224 */         filter_value2 = scan_value1 == 4;
/* 225 */         if (!filter_value2) continue;
/* 226 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 227 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 228 */
/* 229 */         if (!scan_isNull) continue;
/* 230 */
/* 231 */         filter_numOutputRows.add(1);
/* 232 */
/* 233 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 234 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 235 */
/* 236 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 237 */
/* 238 */         UnsafeRow agg_fastAggBuffer = null;
/* 239 */
/* 240 */         if (true) {
/* 241 */           if (!false) {
/* 242 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 243 */               scan_value1);
/* 244 */           }
/* 245 */         }
/* 246 */
/* 247 */         if (agg_fastAggBuffer == null) {
/* 248 */           // generate grouping key
/* 249 */           agg_rowWriter.write(0, scan_value1);
/* 250 */           agg_value7 = 42;
/* 251 */
/* 252 */           if (!false) {
/* 253 */             agg_value7 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value1, agg_value7);
/* 254 */           }
/* 255 */           if (true) {
/* 256 */             // try to get the buffer from hash map
/* 257 */             agg_unsafeRowAggBuffer =
/* 258 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value7);
/* 259 */           }
/* 260 */           if (agg_unsafeRowAggBuffer == null) {
/* 261 */             if (agg_sorter == null) {
/* 262 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 263 */             } else {
/* 264 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 265 */             }
/* 266 */
/* 267 */             // the hash map had be spilled, it should have enough memory now,
/* 268 */             // try  to allocate buffer again.
/* 269 */             agg_unsafeRowAggBuffer =
/* 270 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value7);
/* 271 */             if (agg_unsafeRowAggBuffer == null) {
/* 272 */               // failed to allocate the first page
/* 273 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 274 */             }
/* 275 */           }
/* 276 */         }
/* 277 */
/* 278 */         if (agg_fastAggBuffer != null) {
/* 279 */           // update fast row
/* 280 */
/* 281 */           // common sub-expressions
/* 282 */
/* 283 */           // evaluate aggregate function
/* 284 */           boolean agg_isNull20 = true;
/* 285 */           double agg_value22 = -1.0;
/* 286 */
/* 287 */           boolean agg_isNull21 = agg_fastAggBuffer.isNullAt(0);
/* 288 */           double agg_value23 = agg_isNull21 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 289 */           if (!agg_isNull21) {
/* 290 */             boolean agg_isNull22 = scan_isNull2;
/* 291 */             double agg_value24 = scan_value2;
/* 292 */             if (agg_isNull22) {
/* 293 */               boolean agg_isNull24 = false;
/* 294 */               double agg_value26 = -1.0;
/* 295 */               if (!false) {
/* 296 */                 agg_value26 = (double) 0;
/* 297 */               }
/* 298 */               if (!agg_isNull24) {
/* 299 */                 agg_isNull22 = false;
/* 300 */                 agg_value24 = agg_value26;
/* 301 */               }
/* 302 */             }
/* 303 */
/* 304 */             agg_isNull20 = false; // resultCode could change nullability.
/* 305 */             agg_value22 = agg_value23 + agg_value24;
/* 306 */
/* 307 */           }
/* 308 */           boolean agg_isNull26 = false;
/* 309 */           long agg_value28 = -1L;
/* 310 */           if (!false && scan_isNull2) {
/* 311 */             boolean agg_isNull29 = agg_fastAggBuffer.isNullAt(1);
/* 312 */             long agg_value31 = agg_isNull29 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 313 */             agg_isNull26 = agg_isNull29;
/* 314 */             agg_value28 = agg_value31;
/* 315 */           } else {
/* 316 */             boolean agg_isNull30 = true;
/* 317 */             long agg_value32 = -1L;
/* 318 */
/* 319 */             boolean agg_isNull31 = agg_fastAggBuffer.isNullAt(1);
/* 320 */             long agg_value33 = agg_isNull31 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 321 */             if (!agg_isNull31) {
/* 322 */               agg_isNull30 = false; // resultCode could change nullability.
/* 323 */               agg_value32 = agg_value33 + 1L;
/* 324 */
/* 325 */             }
/* 326 */             agg_isNull26 = agg_isNull30;
/* 327 */             agg_value28 = agg_value32;
/* 328 */           }
/* 329 */           // update fast row
/* 330 */           if (!agg_isNull20) {
/* 331 */             agg_fastAggBuffer.setDouble(0, agg_value22);
/* 332 */           } else {
/* 333 */             agg_fastAggBuffer.setNullAt(0);
/* 334 */           }
/* 335 */
/* 336 */           if (!agg_isNull26) {
/* 337 */             agg_fastAggBuffer.setLong(1, agg_value28);
/* 338 */           } else {
/* 339 */             agg_fastAggBuffer.setNullAt(1);
/* 340 */           }
/* 341 */
/* 342 */         } else {
/* 343 */           // update unsafe row
/* 344 */
/* 345 */           // common sub-expressions
/* 346 */
/* 347 */           // evaluate aggregate function
/* 348 */           boolean agg_isNull7 = true;
/* 349 */           double agg_value9 = -1.0;
/* 350 */
/* 351 */           boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 352 */           double agg_value10 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 353 */           if (!agg_isNull8) {
/* 354 */             boolean agg_isNull9 = scan_isNull2;
/* 355 */             double agg_value11 = scan_value2;
/* 356 */             if (agg_isNull9) {
/* 357 */               boolean agg_isNull11 = false;
/* 358 */               double agg_value13 = -1.0;
/* 359 */               if (!false) {
/* 360 */                 agg_value13 = (double) 0;
/* 361 */               }
/* 362 */               if (!agg_isNull11) {
/* 363 */                 agg_isNull9 = false;
/* 364 */                 agg_value11 = agg_value13;
/* 365 */               }
/* 366 */             }
/* 367 */
/* 368 */             agg_isNull7 = false; // resultCode could change nullability.
/* 369 */             agg_value9 = agg_value10 + agg_value11;
/* 370 */
/* 371 */           }
/* 372 */           boolean agg_isNull13 = false;
/* 373 */           long agg_value15 = -1L;
/* 374 */           if (!false && scan_isNull2) {
/* 375 */             boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 376 */             long agg_value18 = agg_isNull16 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 377 */             agg_isNull13 = agg_isNull16;
/* 378 */             agg_value15 = agg_value18;
/* 379 */           } else {
/* 380 */             boolean agg_isNull17 = true;
/* 381 */             long agg_value19 = -1L;
/* 382 */
/* 383 */             boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 384 */             long agg_value20 = agg_isNull18 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 385 */             if (!agg_isNull18) {
/* 386 */               agg_isNull17 = false; // resultCode could change nullability.
/* 387 */               agg_value19 = agg_value20 + 1L;
/* 388 */
/* 389 */             }
/* 390 */             agg_isNull13 = agg_isNull17;
/* 391 */             agg_value15 = agg_value19;
/* 392 */           }
/* 393 */           // update unsafe row buffer
/* 394 */           if (!agg_isNull7) {
/* 395 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 396 */           } else {
/* 397 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 398 */           }
/* 399 */
/* 400 */           if (!agg_isNull13) {
/* 401 */             agg_unsafeRowAggBuffer.setLong(1, agg_value15);
/* 402 */           } else {
/* 403 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 404 */           }
/* 405 */
/* 406 */         }
/* 407 */         // shouldStop check is eliminated
/* 408 */       }
/* 409 */       scan_batchIdx = scan_numRows;
/* 410 */       scan_batch = null;
/* 411 */       scan_nextBatch();
/* 412 */     }
/* 413 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 414 */     scan_scanTime1 = 0;
/* 415 */
/* 416 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 417 */
/* 418 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 419 */   }
/* 420 */
/* 421 */   private void wholestagecodegen_init_1() {
/* 422 */     filter_result = new UnsafeRow(4);
/* 423 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 424 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 425 */     project_result = new UnsafeRow(2);
/* 426 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 427 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 428 */     agg_result1 = new UnsafeRow(1);
/* 429 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 430 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 431 */
/* 432 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 433 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 434 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 435 */
/* 436 */   }
/* 437 */
/* 438 */   protected void processNext() throws java.io.IOException {
/* 439 */     if (!agg_initAgg) {
/* 440 */       agg_initAgg = true;
/* 441 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 442 */       agg_doAggregateWithKeys();
/* 443 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 444 */     }
/* 445 */
/* 446 */     // output the result
/* 447 */
/* 448 */     while (agg_fastHashMapIter.next()) {
/* 449 */       wholestagecodegen_numOutputRows.add(1);
/* 450 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 451 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 452 */
/* 453 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 454 */
/* 455 */       append(agg_resultRow);
/* 456 */
/* 457 */       if (shouldStop()) return;
/* 458 */     }
/* 459 */     agg_fastHashMap.close();
/* 460 */
/* 461 */     while (agg_mapIter.next()) {
/* 462 */       wholestagecodegen_numOutputRows.add(1);
/* 463 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 464 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 465 */
/* 466 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 467 */
/* 468 */       append(agg_resultRow);
/* 469 */
/* 470 */       if (shouldStop()) return;
/* 471 */     }
/* 472 */
/* 473 */     agg_mapIter.close();
/* 474 */     if (agg_sorter == null) {
/* 475 */       agg_hashMap.free();
/* 476 */     }
/* 477 */   }
/* 478 */ }

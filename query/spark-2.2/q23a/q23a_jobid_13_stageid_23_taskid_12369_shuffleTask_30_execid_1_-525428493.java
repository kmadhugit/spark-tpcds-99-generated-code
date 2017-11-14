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
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private agg_FastHashMap agg_fastHashMap;
/* 013 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator scan_input;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 022 */   private long scan_scanTime1;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 024 */   private int scan_batchIdx;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 026 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 029 */   private UnsafeRow scan_result;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 033 */   private UnsafeRow filter_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 036 */   private UnsafeRow project_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 039 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 040 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 042 */   private UnsafeRow bhj_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 045 */   private UnsafeRow project_result1;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 048 */   private UnsafeRow agg_result1;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 051 */   private int agg_value4;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 053 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 054 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 055 */
/* 056 */   public GeneratedIterator(Object[] references) {
/* 057 */     this.references = references;
/* 058 */   }
/* 059 */
/* 060 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 061 */     partitionIndex = index;
/* 062 */     this.inputs = inputs;
/* 063 */     wholestagecodegen_init_0();
/* 064 */     wholestagecodegen_init_1();
/* 065 */     wholestagecodegen_init_2();
/* 066 */
/* 067 */   }
/* 068 */
/* 069 */   private void wholestagecodegen_init_0() {
/* 070 */     agg_initAgg = false;
/* 071 */
/* 072 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 073 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 074 */
/* 075 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 076 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 077 */     scan_input = inputs[0];
/* 078 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 079 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 080 */     scan_scanTime1 = 0;
/* 081 */     scan_batch = null;
/* 082 */     scan_batchIdx = 0;
/* 083 */     scan_colInstance0 = null;
/* 084 */     scan_colInstance1 = null;
/* 085 */     scan_colInstance2 = null;
/* 086 */     scan_colInstance3 = null;
/* 087 */     scan_result = new UnsafeRow(4);
/* 088 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 089 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 090 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 091 */
/* 092 */   }
/* 093 */
/* 094 */   private void scan_nextBatch() throws java.io.IOException {
/* 095 */     long getBatchStart = System.nanoTime();
/* 096 */     if (scan_input.hasNext()) {
/* 097 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 098 */       scan_numOutputRows.add(scan_batch.numRows());
/* 099 */       scan_batchIdx = 0;
/* 100 */       scan_colInstance0 = scan_batch.column(0);
/* 101 */       scan_colInstance1 = scan_batch.column(1);
/* 102 */       scan_colInstance2 = scan_batch.column(2);
/* 103 */       scan_colInstance3 = scan_batch.column(3);
/* 104 */
/* 105 */     }
/* 106 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 107 */   }
/* 108 */
/* 109 */   public class agg_FastHashMap {
/* 110 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 111 */     private int[] buckets;
/* 112 */     private int capacity = 1 << 16;
/* 113 */     private double loadFactor = 0.5;
/* 114 */     private int numBuckets = (int) (capacity / loadFactor);
/* 115 */     private int maxSteps = 2;
/* 116 */     private int numRows = 0;
/* 117 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 118 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 119 */     private Object emptyVBase;
/* 120 */     private long emptyVOff;
/* 121 */     private int emptyVLen;
/* 122 */     private boolean isBatchFull = false;
/* 123 */
/* 124 */     public agg_FastHashMap(
/* 125 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 126 */       InternalRow emptyAggregationBuffer) {
/* 127 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 128 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 129 */
/* 130 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 131 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 132 */
/* 133 */       emptyVBase = emptyBuffer;
/* 134 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 135 */       emptyVLen = emptyBuffer.length;
/* 136 */
/* 137 */       buckets = new int[numBuckets];
/* 138 */       java.util.Arrays.fill(buckets, -1);
/* 139 */     }
/* 140 */
/* 141 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 142 */       long h = hash(agg_key);
/* 143 */       int step = 0;
/* 144 */       int idx = (int) h & (numBuckets - 1);
/* 145 */       while (step < maxSteps) {
/* 146 */         // Return bucket index if it's either an empty slot or already contains the key
/* 147 */         if (buckets[idx] == -1) {
/* 148 */           if (numRows < capacity && !isBatchFull) {
/* 149 */             // creating the unsafe for new entry
/* 150 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 151 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 152 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 153 */               0);
/* 154 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 155 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 156 */               agg_holder,
/* 157 */               1);
/* 158 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 159 */             agg_rowWriter.zeroOutNullBytes();
/* 160 */             agg_rowWriter.write(0, agg_key);
/* 161 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 162 */             Object kbase = agg_result.getBaseObject();
/* 163 */             long koff = agg_result.getBaseOffset();
/* 164 */             int klen = agg_result.getSizeInBytes();
/* 165 */
/* 166 */             UnsafeRow vRow
/* 167 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 168 */             if (vRow == null) {
/* 169 */               isBatchFull = true;
/* 170 */             } else {
/* 171 */               buckets[idx] = numRows++;
/* 172 */             }
/* 173 */             return vRow;
/* 174 */           } else {
/* 175 */             // No more space
/* 176 */             return null;
/* 177 */           }
/* 178 */         } else if (equals(idx, agg_key)) {
/* 179 */           return batch.getValueRow(buckets[idx]);
/* 180 */         }
/* 181 */         idx = (idx + 1) & (numBuckets - 1);
/* 182 */         step++;
/* 183 */       }
/* 184 */       // Didn't find it
/* 185 */       return null;
/* 186 */     }
/* 187 */
/* 188 */     private boolean equals(int idx, int agg_key) {
/* 189 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 190 */       return (row.getInt(0) == agg_key);
/* 191 */     }
/* 192 */
/* 193 */     private long hash(int agg_key) {
/* 194 */       long agg_hash = 0;
/* 195 */
/* 196 */       int agg_result = agg_key;
/* 197 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 198 */
/* 199 */       return agg_hash;
/* 200 */     }
/* 201 */
/* 202 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 203 */       return batch.rowIterator();
/* 204 */     }
/* 205 */
/* 206 */     public void close() {
/* 207 */       batch.close();
/* 208 */     }
/* 209 */
/* 210 */   }
/* 211 */
/* 212 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 213 */     agg_hashMap = agg_plan.createHashMap();
/* 214 */
/* 215 */     if (scan_batch == null) {
/* 216 */       scan_nextBatch();
/* 217 */     }
/* 218 */     while (scan_batch != null) {
/* 219 */       int scan_numRows = scan_batch.numRows();
/* 220 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 221 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 222 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 223 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 224 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 225 */
/* 226 */         if (!(!(scan_isNull))) continue;
/* 227 */
/* 228 */         filter_numOutputRows.add(1);
/* 229 */
/* 230 */         // generate join key for stream side
/* 231 */
/* 232 */         boolean bhj_isNull = false;
/* 233 */         long bhj_value = -1L;
/* 234 */         if (!false) {
/* 235 */           bhj_value = (long) scan_value;
/* 236 */         }
/* 237 */         // find matches from HashedRelation
/* 238 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 239 */         if (bhj_matched == null) continue;
/* 240 */
/* 241 */         bhj_numOutputRows.add(1);
/* 242 */
/* 243 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 244 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 245 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 246 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 247 */         boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 248 */         int bhj_value2 = bhj_isNull2 ? -1 : (bhj_matched.getInt(0));
/* 249 */
/* 250 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 251 */
/* 252 */         UnsafeRow agg_fastAggBuffer = null;
/* 253 */
/* 254 */         if (true) {
/* 255 */           if (!bhj_isNull2) {
/* 256 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 257 */               bhj_value2);
/* 258 */           }
/* 259 */         }
/* 260 */
/* 261 */         if (agg_fastAggBuffer == null) {
/* 262 */           // generate grouping key
/* 263 */           agg_rowWriter.zeroOutNullBytes();
/* 264 */
/* 265 */           if (bhj_isNull2) {
/* 266 */             agg_rowWriter.setNullAt(0);
/* 267 */           } else {
/* 268 */             agg_rowWriter.write(0, bhj_value2);
/* 269 */           }
/* 270 */           agg_value4 = 42;
/* 271 */
/* 272 */           if (!bhj_isNull2) {
/* 273 */             agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value2, agg_value4);
/* 274 */           }
/* 275 */           if (true) {
/* 276 */             // try to get the buffer from hash map
/* 277 */             agg_unsafeRowAggBuffer =
/* 278 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 279 */           }
/* 280 */           if (agg_unsafeRowAggBuffer == null) {
/* 281 */             if (agg_sorter == null) {
/* 282 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 283 */             } else {
/* 284 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 285 */             }
/* 286 */
/* 287 */             // the hash map had be spilled, it should have enough memory now,
/* 288 */             // try  to allocate buffer again.
/* 289 */             agg_unsafeRowAggBuffer =
/* 290 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 291 */             if (agg_unsafeRowAggBuffer == null) {
/* 292 */               // failed to allocate the first page
/* 293 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 294 */             }
/* 295 */           }
/* 296 */         }
/* 297 */
/* 298 */         if (agg_fastAggBuffer != null) {
/* 299 */           // update fast row
/* 300 */
/* 301 */           // common sub-expressions
/* 302 */
/* 303 */           // evaluate aggregate function
/* 304 */           boolean agg_isNull17 = true;
/* 305 */           double agg_value18 = -1.0;
/* 306 */
/* 307 */           boolean agg_isNull19 = agg_fastAggBuffer.isNullAt(0);
/* 308 */           double agg_value20 = agg_isNull19 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 309 */           boolean agg_isNull18 = agg_isNull19;
/* 310 */           double agg_value19 = agg_value20;
/* 311 */           if (agg_isNull18) {
/* 312 */             boolean agg_isNull20 = false;
/* 313 */             double agg_value21 = -1.0;
/* 314 */             if (!false) {
/* 315 */               agg_value21 = (double) 0;
/* 316 */             }
/* 317 */             if (!agg_isNull20) {
/* 318 */               agg_isNull18 = false;
/* 319 */               agg_value19 = agg_value21;
/* 320 */             }
/* 321 */           }
/* 322 */
/* 323 */           boolean agg_isNull22 = true;
/* 324 */           double agg_value23 = -1.0;
/* 325 */
/* 326 */           boolean agg_isNull23 = scan_isNull1;
/* 327 */           double agg_value24 = -1.0;
/* 328 */           if (!scan_isNull1) {
/* 329 */             agg_value24 = (double) scan_value1;
/* 330 */           }
/* 331 */           if (!agg_isNull23) {
/* 332 */             if (!scan_isNull2) {
/* 333 */               agg_isNull22 = false; // resultCode could change nullability.
/* 334 */               agg_value23 = agg_value24 * scan_value2;
/* 335 */
/* 336 */             }
/* 337 */
/* 338 */           }
/* 339 */           if (!agg_isNull22) {
/* 340 */             agg_isNull17 = false; // resultCode could change nullability.
/* 341 */             agg_value18 = agg_value19 + agg_value23;
/* 342 */
/* 343 */           }
/* 344 */           boolean agg_isNull16 = agg_isNull17;
/* 345 */           double agg_value17 = agg_value18;
/* 346 */           if (agg_isNull16) {
/* 347 */             boolean agg_isNull26 = agg_fastAggBuffer.isNullAt(0);
/* 348 */             double agg_value27 = agg_isNull26 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 349 */             if (!agg_isNull26) {
/* 350 */               agg_isNull16 = false;
/* 351 */               agg_value17 = agg_value27;
/* 352 */             }
/* 353 */           }
/* 354 */           // update fast row
/* 355 */           if (!agg_isNull16) {
/* 356 */             agg_fastAggBuffer.setDouble(0, agg_value17);
/* 357 */           } else {
/* 358 */             agg_fastAggBuffer.setNullAt(0);
/* 359 */           }
/* 360 */
/* 361 */         } else {
/* 362 */           // update unsafe row
/* 363 */
/* 364 */           // common sub-expressions
/* 365 */
/* 366 */           // evaluate aggregate function
/* 367 */           boolean agg_isNull6 = true;
/* 368 */           double agg_value7 = -1.0;
/* 369 */
/* 370 */           boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 371 */           double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 372 */           boolean agg_isNull7 = agg_isNull8;
/* 373 */           double agg_value8 = agg_value9;
/* 374 */           if (agg_isNull7) {
/* 375 */             boolean agg_isNull9 = false;
/* 376 */             double agg_value10 = -1.0;
/* 377 */             if (!false) {
/* 378 */               agg_value10 = (double) 0;
/* 379 */             }
/* 380 */             if (!agg_isNull9) {
/* 381 */               agg_isNull7 = false;
/* 382 */               agg_value8 = agg_value10;
/* 383 */             }
/* 384 */           }
/* 385 */
/* 386 */           boolean agg_isNull11 = true;
/* 387 */           double agg_value12 = -1.0;
/* 388 */
/* 389 */           boolean agg_isNull12 = scan_isNull1;
/* 390 */           double agg_value13 = -1.0;
/* 391 */           if (!scan_isNull1) {
/* 392 */             agg_value13 = (double) scan_value1;
/* 393 */           }
/* 394 */           if (!agg_isNull12) {
/* 395 */             if (!scan_isNull2) {
/* 396 */               agg_isNull11 = false; // resultCode could change nullability.
/* 397 */               agg_value12 = agg_value13 * scan_value2;
/* 398 */
/* 399 */             }
/* 400 */
/* 401 */           }
/* 402 */           if (!agg_isNull11) {
/* 403 */             agg_isNull6 = false; // resultCode could change nullability.
/* 404 */             agg_value7 = agg_value8 + agg_value12;
/* 405 */
/* 406 */           }
/* 407 */           boolean agg_isNull5 = agg_isNull6;
/* 408 */           double agg_value6 = agg_value7;
/* 409 */           if (agg_isNull5) {
/* 410 */             boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 411 */             double agg_value16 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 412 */             if (!agg_isNull15) {
/* 413 */               agg_isNull5 = false;
/* 414 */               agg_value6 = agg_value16;
/* 415 */             }
/* 416 */           }
/* 417 */           // update unsafe row buffer
/* 418 */           if (!agg_isNull5) {
/* 419 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 420 */           } else {
/* 421 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 422 */           }
/* 423 */
/* 424 */         }
/* 425 */         // shouldStop check is eliminated
/* 426 */       }
/* 427 */       scan_batchIdx = scan_numRows;
/* 428 */       scan_batch = null;
/* 429 */       scan_nextBatch();
/* 430 */     }
/* 431 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 432 */     scan_scanTime1 = 0;
/* 433 */
/* 434 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 435 */
/* 436 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 437 */   }
/* 438 */
/* 439 */   private void wholestagecodegen_init_2() {
/* 440 */     project_result1 = new UnsafeRow(3);
/* 441 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 442 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 443 */     agg_result1 = new UnsafeRow(1);
/* 444 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 445 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 446 */
/* 447 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 448 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 449 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 450 */
/* 451 */   }
/* 452 */
/* 453 */   private void wholestagecodegen_init_1() {
/* 454 */     filter_result = new UnsafeRow(4);
/* 455 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 456 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 457 */     project_result = new UnsafeRow(3);
/* 458 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 459 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 460 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 461 */
/* 462 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 463 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 464 */
/* 465 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 466 */     bhj_result = new UnsafeRow(4);
/* 467 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 468 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 469 */
/* 470 */   }
/* 471 */
/* 472 */   protected void processNext() throws java.io.IOException {
/* 473 */     if (!agg_initAgg) {
/* 474 */       agg_initAgg = true;
/* 475 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 476 */       agg_doAggregateWithKeys();
/* 477 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 478 */     }
/* 479 */
/* 480 */     // output the result
/* 481 */
/* 482 */     while (agg_fastHashMapIter.next()) {
/* 483 */       wholestagecodegen_numOutputRows.add(1);
/* 484 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 485 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 486 */
/* 487 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 488 */
/* 489 */       append(agg_resultRow);
/* 490 */
/* 491 */       if (shouldStop()) return;
/* 492 */     }
/* 493 */     agg_fastHashMap.close();
/* 494 */
/* 495 */     while (agg_mapIter.next()) {
/* 496 */       wholestagecodegen_numOutputRows.add(1);
/* 497 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 498 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 499 */
/* 500 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 501 */
/* 502 */       append(agg_resultRow);
/* 503 */
/* 504 */       if (shouldStop()) return;
/* 505 */     }
/* 506 */
/* 507 */     agg_mapIter.close();
/* 508 */     if (agg_sorter == null) {
/* 509 */       agg_hashMap.free();
/* 510 */     }
/* 511 */   }
/* 512 */ }

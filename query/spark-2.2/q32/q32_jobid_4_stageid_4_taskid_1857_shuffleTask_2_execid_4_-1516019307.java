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
/* 030 */   private UnsafeRow scan_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 034 */   private UnsafeRow filter_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 037 */   private UnsafeRow project_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 040 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 041 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 043 */   private UnsafeRow bhj_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 046 */   private UnsafeRow project_result1;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 049 */   private UnsafeRow agg_result1;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 052 */   private int agg_value7;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 054 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 055 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 056 */
/* 057 */   public GeneratedIterator(Object[] references) {
/* 058 */     this.references = references;
/* 059 */   }
/* 060 */
/* 061 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 062 */     partitionIndex = index;
/* 063 */     this.inputs = inputs;
/* 064 */     wholestagecodegen_init_0();
/* 065 */     wholestagecodegen_init_1();
/* 066 */     wholestagecodegen_init_2();
/* 067 */
/* 068 */   }
/* 069 */
/* 070 */   private void wholestagecodegen_init_0() {
/* 071 */     agg_initAgg = false;
/* 072 */
/* 073 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 074 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 075 */
/* 076 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 077 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 078 */     scan_input = inputs[0];
/* 079 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 080 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 081 */     scan_scanTime1 = 0;
/* 082 */     scan_batch = null;
/* 083 */     scan_batchIdx = 0;
/* 084 */     scan_colInstance0 = null;
/* 085 */     scan_colInstance1 = null;
/* 086 */     scan_colInstance2 = null;
/* 087 */     scan_result = new UnsafeRow(3);
/* 088 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 089 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 090 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
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
/* 103 */
/* 104 */     }
/* 105 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 106 */   }
/* 107 */
/* 108 */   public class agg_FastHashMap {
/* 109 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 110 */     private int[] buckets;
/* 111 */     private int capacity = 1 << 16;
/* 112 */     private double loadFactor = 0.5;
/* 113 */     private int numBuckets = (int) (capacity / loadFactor);
/* 114 */     private int maxSteps = 2;
/* 115 */     private int numRows = 0;
/* 116 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 117 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 118 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.LongType);
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
/* 230 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 231 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 232 */
/* 233 */         // generate join key for stream side
/* 234 */
/* 235 */         boolean bhj_isNull = scan_isNull2;
/* 236 */         long bhj_value = -1L;
/* 237 */         if (!scan_isNull2) {
/* 238 */           bhj_value = (long) scan_value2;
/* 239 */         }
/* 240 */         // find matches from HashedRelation
/* 241 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 242 */         if (bhj_matched == null) continue;
/* 243 */
/* 244 */         bhj_numOutputRows.add(1);
/* 245 */
/* 246 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 247 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 248 */
/* 249 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 250 */
/* 251 */         UnsafeRow agg_fastAggBuffer = null;
/* 252 */
/* 253 */         if (true) {
/* 254 */           if (!false) {
/* 255 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 256 */               scan_value);
/* 257 */           }
/* 258 */         }
/* 259 */
/* 260 */         if (agg_fastAggBuffer == null) {
/* 261 */           // generate grouping key
/* 262 */           agg_rowWriter.write(0, scan_value);
/* 263 */           agg_value7 = 42;
/* 264 */
/* 265 */           if (!false) {
/* 266 */             agg_value7 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value, agg_value7);
/* 267 */           }
/* 268 */           if (true) {
/* 269 */             // try to get the buffer from hash map
/* 270 */             agg_unsafeRowAggBuffer =
/* 271 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value7);
/* 272 */           }
/* 273 */           if (agg_unsafeRowAggBuffer == null) {
/* 274 */             if (agg_sorter == null) {
/* 275 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 276 */             } else {
/* 277 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 278 */             }
/* 279 */
/* 280 */             // the hash map had be spilled, it should have enough memory now,
/* 281 */             // try  to allocate buffer again.
/* 282 */             agg_unsafeRowAggBuffer =
/* 283 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value7);
/* 284 */             if (agg_unsafeRowAggBuffer == null) {
/* 285 */               // failed to allocate the first page
/* 286 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 287 */             }
/* 288 */           }
/* 289 */         }
/* 290 */
/* 291 */         if (agg_fastAggBuffer != null) {
/* 292 */           // update fast row
/* 293 */
/* 294 */           // common sub-expressions
/* 295 */
/* 296 */           // evaluate aggregate function
/* 297 */           boolean agg_isNull20 = true;
/* 298 */           double agg_value22 = -1.0;
/* 299 */
/* 300 */           boolean agg_isNull21 = agg_fastAggBuffer.isNullAt(0);
/* 301 */           double agg_value23 = agg_isNull21 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 302 */           if (!agg_isNull21) {
/* 303 */             boolean agg_isNull22 = scan_isNull1;
/* 304 */             double agg_value24 = scan_value1;
/* 305 */             if (agg_isNull22) {
/* 306 */               boolean agg_isNull24 = false;
/* 307 */               double agg_value26 = -1.0;
/* 308 */               if (!false) {
/* 309 */                 agg_value26 = (double) 0;
/* 310 */               }
/* 311 */               if (!agg_isNull24) {
/* 312 */                 agg_isNull22 = false;
/* 313 */                 agg_value24 = agg_value26;
/* 314 */               }
/* 315 */             }
/* 316 */
/* 317 */             agg_isNull20 = false; // resultCode could change nullability.
/* 318 */             agg_value22 = agg_value23 + agg_value24;
/* 319 */
/* 320 */           }
/* 321 */           boolean agg_isNull26 = false;
/* 322 */           long agg_value28 = -1L;
/* 323 */           if (!false && scan_isNull1) {
/* 324 */             boolean agg_isNull29 = agg_fastAggBuffer.isNullAt(1);
/* 325 */             long agg_value31 = agg_isNull29 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 326 */             agg_isNull26 = agg_isNull29;
/* 327 */             agg_value28 = agg_value31;
/* 328 */           } else {
/* 329 */             boolean agg_isNull30 = true;
/* 330 */             long agg_value32 = -1L;
/* 331 */
/* 332 */             boolean agg_isNull31 = agg_fastAggBuffer.isNullAt(1);
/* 333 */             long agg_value33 = agg_isNull31 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 334 */             if (!agg_isNull31) {
/* 335 */               agg_isNull30 = false; // resultCode could change nullability.
/* 336 */               agg_value32 = agg_value33 + 1L;
/* 337 */
/* 338 */             }
/* 339 */             agg_isNull26 = agg_isNull30;
/* 340 */             agg_value28 = agg_value32;
/* 341 */           }
/* 342 */           // update fast row
/* 343 */           if (!agg_isNull20) {
/* 344 */             agg_fastAggBuffer.setDouble(0, agg_value22);
/* 345 */           } else {
/* 346 */             agg_fastAggBuffer.setNullAt(0);
/* 347 */           }
/* 348 */
/* 349 */           if (!agg_isNull26) {
/* 350 */             agg_fastAggBuffer.setLong(1, agg_value28);
/* 351 */           } else {
/* 352 */             agg_fastAggBuffer.setNullAt(1);
/* 353 */           }
/* 354 */
/* 355 */         } else {
/* 356 */           // update unsafe row
/* 357 */
/* 358 */           // common sub-expressions
/* 359 */
/* 360 */           // evaluate aggregate function
/* 361 */           boolean agg_isNull7 = true;
/* 362 */           double agg_value9 = -1.0;
/* 363 */
/* 364 */           boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 365 */           double agg_value10 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 366 */           if (!agg_isNull8) {
/* 367 */             boolean agg_isNull9 = scan_isNull1;
/* 368 */             double agg_value11 = scan_value1;
/* 369 */             if (agg_isNull9) {
/* 370 */               boolean agg_isNull11 = false;
/* 371 */               double agg_value13 = -1.0;
/* 372 */               if (!false) {
/* 373 */                 agg_value13 = (double) 0;
/* 374 */               }
/* 375 */               if (!agg_isNull11) {
/* 376 */                 agg_isNull9 = false;
/* 377 */                 agg_value11 = agg_value13;
/* 378 */               }
/* 379 */             }
/* 380 */
/* 381 */             agg_isNull7 = false; // resultCode could change nullability.
/* 382 */             agg_value9 = agg_value10 + agg_value11;
/* 383 */
/* 384 */           }
/* 385 */           boolean agg_isNull13 = false;
/* 386 */           long agg_value15 = -1L;
/* 387 */           if (!false && scan_isNull1) {
/* 388 */             boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 389 */             long agg_value18 = agg_isNull16 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 390 */             agg_isNull13 = agg_isNull16;
/* 391 */             agg_value15 = agg_value18;
/* 392 */           } else {
/* 393 */             boolean agg_isNull17 = true;
/* 394 */             long agg_value19 = -1L;
/* 395 */
/* 396 */             boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 397 */             long agg_value20 = agg_isNull18 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 398 */             if (!agg_isNull18) {
/* 399 */               agg_isNull17 = false; // resultCode could change nullability.
/* 400 */               agg_value19 = agg_value20 + 1L;
/* 401 */
/* 402 */             }
/* 403 */             agg_isNull13 = agg_isNull17;
/* 404 */             agg_value15 = agg_value19;
/* 405 */           }
/* 406 */           // update unsafe row buffer
/* 407 */           if (!agg_isNull7) {
/* 408 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 409 */           } else {
/* 410 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 411 */           }
/* 412 */
/* 413 */           if (!agg_isNull13) {
/* 414 */             agg_unsafeRowAggBuffer.setLong(1, agg_value15);
/* 415 */           } else {
/* 416 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 417 */           }
/* 418 */
/* 419 */         }
/* 420 */         // shouldStop check is eliminated
/* 421 */       }
/* 422 */       scan_batchIdx = scan_numRows;
/* 423 */       scan_batch = null;
/* 424 */       scan_nextBatch();
/* 425 */     }
/* 426 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 427 */     scan_scanTime1 = 0;
/* 428 */
/* 429 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 430 */
/* 431 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 432 */   }
/* 433 */
/* 434 */   private void wholestagecodegen_init_2() {
/* 435 */     project_result1 = new UnsafeRow(2);
/* 436 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 437 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 438 */     agg_result1 = new UnsafeRow(1);
/* 439 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 440 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 441 */
/* 442 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 443 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 444 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 445 */
/* 446 */   }
/* 447 */
/* 448 */   private void wholestagecodegen_init_1() {
/* 449 */     filter_result = new UnsafeRow(3);
/* 450 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 451 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 452 */     project_result = new UnsafeRow(3);
/* 453 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 454 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 455 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 456 */
/* 457 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 458 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 459 */
/* 460 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 461 */     bhj_result = new UnsafeRow(4);
/* 462 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 463 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 464 */
/* 465 */   }
/* 466 */
/* 467 */   protected void processNext() throws java.io.IOException {
/* 468 */     if (!agg_initAgg) {
/* 469 */       agg_initAgg = true;
/* 470 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 471 */       agg_doAggregateWithKeys();
/* 472 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 473 */     }
/* 474 */
/* 475 */     // output the result
/* 476 */
/* 477 */     while (agg_fastHashMapIter.next()) {
/* 478 */       wholestagecodegen_numOutputRows.add(1);
/* 479 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 480 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 481 */
/* 482 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 483 */
/* 484 */       append(agg_resultRow);
/* 485 */
/* 486 */       if (shouldStop()) return;
/* 487 */     }
/* 488 */     agg_fastHashMap.close();
/* 489 */
/* 490 */     while (agg_mapIter.next()) {
/* 491 */       wholestagecodegen_numOutputRows.add(1);
/* 492 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 493 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 494 */
/* 495 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 496 */
/* 497 */       append(agg_resultRow);
/* 498 */
/* 499 */       if (shouldStop()) return;
/* 500 */     }
/* 501 */
/* 502 */     agg_mapIter.close();
/* 503 */     if (agg_sorter == null) {
/* 504 */       agg_hashMap.free();
/* 505 */     }
/* 506 */   }
/* 507 */ }

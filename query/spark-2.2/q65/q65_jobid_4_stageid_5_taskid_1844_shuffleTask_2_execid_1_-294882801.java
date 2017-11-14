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
/* 048 */   private UnsafeRow agg_result2;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 051 */   private int agg_value6;
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
/* 078 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 079 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
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
/* 117 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 118 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 119 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 120 */     private Object emptyVBase;
/* 121 */     private long emptyVOff;
/* 122 */     private int emptyVLen;
/* 123 */     private boolean isBatchFull = false;
/* 124 */
/* 125 */     public agg_FastHashMap(
/* 126 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 127 */       InternalRow emptyAggregationBuffer) {
/* 128 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 129 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 130 */
/* 131 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 132 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 133 */
/* 134 */       emptyVBase = emptyBuffer;
/* 135 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 136 */       emptyVLen = emptyBuffer.length;
/* 137 */
/* 138 */       buckets = new int[numBuckets];
/* 139 */       java.util.Arrays.fill(buckets, -1);
/* 140 */     }
/* 141 */
/* 142 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key, int agg_key1) {
/* 143 */       long h = hash(agg_key, agg_key1);
/* 144 */       int step = 0;
/* 145 */       int idx = (int) h & (numBuckets - 1);
/* 146 */       while (step < maxSteps) {
/* 147 */         // Return bucket index if it's either an empty slot or already contains the key
/* 148 */         if (buckets[idx] == -1) {
/* 149 */           if (numRows < capacity && !isBatchFull) {
/* 150 */             // creating the unsafe for new entry
/* 151 */             UnsafeRow agg_result = new UnsafeRow(2);
/* 152 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 153 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 154 */               0);
/* 155 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 156 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 157 */               agg_holder,
/* 158 */               2);
/* 159 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 160 */             agg_rowWriter.zeroOutNullBytes();
/* 161 */             agg_rowWriter.write(0, agg_key);
/* 162 */             agg_rowWriter.write(1, agg_key1);
/* 163 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 164 */             Object kbase = agg_result.getBaseObject();
/* 165 */             long koff = agg_result.getBaseOffset();
/* 166 */             int klen = agg_result.getSizeInBytes();
/* 167 */
/* 168 */             UnsafeRow vRow
/* 169 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 170 */             if (vRow == null) {
/* 171 */               isBatchFull = true;
/* 172 */             } else {
/* 173 */               buckets[idx] = numRows++;
/* 174 */             }
/* 175 */             return vRow;
/* 176 */           } else {
/* 177 */             // No more space
/* 178 */             return null;
/* 179 */           }
/* 180 */         } else if (equals(idx, agg_key, agg_key1)) {
/* 181 */           return batch.getValueRow(buckets[idx]);
/* 182 */         }
/* 183 */         idx = (idx + 1) & (numBuckets - 1);
/* 184 */         step++;
/* 185 */       }
/* 186 */       // Didn't find it
/* 187 */       return null;
/* 188 */     }
/* 189 */
/* 190 */     private boolean equals(int idx, int agg_key, int agg_key1) {
/* 191 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 192 */       return (row.getInt(0) == agg_key) && (row.getInt(1) == agg_key1);
/* 193 */     }
/* 194 */
/* 195 */     private long hash(int agg_key, int agg_key1) {
/* 196 */       long agg_hash = 0;
/* 197 */
/* 198 */       int agg_result = agg_key;
/* 199 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 200 */
/* 201 */       int agg_result1 = agg_key1;
/* 202 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 203 */
/* 204 */       return agg_hash;
/* 205 */     }
/* 206 */
/* 207 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 208 */       return batch.rowIterator();
/* 209 */     }
/* 210 */
/* 211 */     public void close() {
/* 212 */       batch.close();
/* 213 */     }
/* 214 */
/* 215 */   }
/* 216 */
/* 217 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 218 */     agg_hashMap = agg_plan.createHashMap();
/* 219 */
/* 220 */     if (scan_batch == null) {
/* 221 */       scan_nextBatch();
/* 222 */     }
/* 223 */     while (scan_batch != null) {
/* 224 */       int scan_numRows = scan_batch.numRows();
/* 225 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 226 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 227 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 228 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 229 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 230 */
/* 231 */         if (!(!(scan_isNull1))) continue;
/* 232 */
/* 233 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 234 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 235 */
/* 236 */         if (!(!(scan_isNull))) continue;
/* 237 */
/* 238 */         filter_numOutputRows.add(1);
/* 239 */
/* 240 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 241 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 242 */
/* 243 */         // generate join key for stream side
/* 244 */
/* 245 */         boolean bhj_isNull = scan_isNull3;
/* 246 */         long bhj_value = -1L;
/* 247 */         if (!scan_isNull3) {
/* 248 */           bhj_value = (long) scan_value3;
/* 249 */         }
/* 250 */         // find matches from HashedRelation
/* 251 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 252 */         if (bhj_matched == null) continue;
/* 253 */
/* 254 */         bhj_numOutputRows.add(1);
/* 255 */
/* 256 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 257 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 258 */
/* 259 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 260 */
/* 261 */         UnsafeRow agg_fastAggBuffer = null;
/* 262 */
/* 263 */         if (true) {
/* 264 */           if (!false && !false) {
/* 265 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 266 */               scan_value1, scan_value);
/* 267 */           }
/* 268 */         }
/* 269 */
/* 270 */         if (agg_fastAggBuffer == null) {
/* 271 */           // generate grouping key
/* 272 */           agg_rowWriter.write(0, scan_value1);
/* 273 */
/* 274 */           agg_rowWriter.write(1, scan_value);
/* 275 */           agg_value6 = 42;
/* 276 */
/* 277 */           if (!false) {
/* 278 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value1, agg_value6);
/* 279 */           }
/* 280 */
/* 281 */           if (!false) {
/* 282 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value, agg_value6);
/* 283 */           }
/* 284 */           if (true) {
/* 285 */             // try to get the buffer from hash map
/* 286 */             agg_unsafeRowAggBuffer =
/* 287 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 288 */           }
/* 289 */           if (agg_unsafeRowAggBuffer == null) {
/* 290 */             if (agg_sorter == null) {
/* 291 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 292 */             } else {
/* 293 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 294 */             }
/* 295 */
/* 296 */             // the hash map had be spilled, it should have enough memory now,
/* 297 */             // try  to allocate buffer again.
/* 298 */             agg_unsafeRowAggBuffer =
/* 299 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 300 */             if (agg_unsafeRowAggBuffer == null) {
/* 301 */               // failed to allocate the first page
/* 302 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 303 */             }
/* 304 */           }
/* 305 */         }
/* 306 */
/* 307 */         if (agg_fastAggBuffer != null) {
/* 308 */           // update fast row
/* 309 */
/* 310 */           // common sub-expressions
/* 311 */
/* 312 */           // evaluate aggregate function
/* 313 */           boolean agg_isNull17 = true;
/* 314 */           double agg_value18 = -1.0;
/* 315 */
/* 316 */           boolean agg_isNull19 = agg_fastAggBuffer.isNullAt(0);
/* 317 */           double agg_value20 = agg_isNull19 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 318 */           boolean agg_isNull18 = agg_isNull19;
/* 319 */           double agg_value19 = agg_value20;
/* 320 */           if (agg_isNull18) {
/* 321 */             boolean agg_isNull20 = false;
/* 322 */             double agg_value21 = -1.0;
/* 323 */             if (!false) {
/* 324 */               agg_value21 = (double) 0;
/* 325 */             }
/* 326 */             if (!agg_isNull20) {
/* 327 */               agg_isNull18 = false;
/* 328 */               agg_value19 = agg_value21;
/* 329 */             }
/* 330 */           }
/* 331 */
/* 332 */           if (!scan_isNull2) {
/* 333 */             agg_isNull17 = false; // resultCode could change nullability.
/* 334 */             agg_value18 = agg_value19 + scan_value2;
/* 335 */
/* 336 */           }
/* 337 */           boolean agg_isNull16 = agg_isNull17;
/* 338 */           double agg_value17 = agg_value18;
/* 339 */           if (agg_isNull16) {
/* 340 */             boolean agg_isNull23 = agg_fastAggBuffer.isNullAt(0);
/* 341 */             double agg_value24 = agg_isNull23 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 342 */             if (!agg_isNull23) {
/* 343 */               agg_isNull16 = false;
/* 344 */               agg_value17 = agg_value24;
/* 345 */             }
/* 346 */           }
/* 347 */           // update fast row
/* 348 */           if (!agg_isNull16) {
/* 349 */             agg_fastAggBuffer.setDouble(0, agg_value17);
/* 350 */           } else {
/* 351 */             agg_fastAggBuffer.setNullAt(0);
/* 352 */           }
/* 353 */
/* 354 */         } else {
/* 355 */           // update unsafe row
/* 356 */
/* 357 */           // common sub-expressions
/* 358 */
/* 359 */           // evaluate aggregate function
/* 360 */           boolean agg_isNull9 = true;
/* 361 */           double agg_value10 = -1.0;
/* 362 */
/* 363 */           boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 364 */           double agg_value12 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 365 */           boolean agg_isNull10 = agg_isNull11;
/* 366 */           double agg_value11 = agg_value12;
/* 367 */           if (agg_isNull10) {
/* 368 */             boolean agg_isNull12 = false;
/* 369 */             double agg_value13 = -1.0;
/* 370 */             if (!false) {
/* 371 */               agg_value13 = (double) 0;
/* 372 */             }
/* 373 */             if (!agg_isNull12) {
/* 374 */               agg_isNull10 = false;
/* 375 */               agg_value11 = agg_value13;
/* 376 */             }
/* 377 */           }
/* 378 */
/* 379 */           if (!scan_isNull2) {
/* 380 */             agg_isNull9 = false; // resultCode could change nullability.
/* 381 */             agg_value10 = agg_value11 + scan_value2;
/* 382 */
/* 383 */           }
/* 384 */           boolean agg_isNull8 = agg_isNull9;
/* 385 */           double agg_value9 = agg_value10;
/* 386 */           if (agg_isNull8) {
/* 387 */             boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 388 */             double agg_value16 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 389 */             if (!agg_isNull15) {
/* 390 */               agg_isNull8 = false;
/* 391 */               agg_value9 = agg_value16;
/* 392 */             }
/* 393 */           }
/* 394 */           // update unsafe row buffer
/* 395 */           if (!agg_isNull8) {
/* 396 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 397 */           } else {
/* 398 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 399 */           }
/* 400 */
/* 401 */         }
/* 402 */         // shouldStop check is eliminated
/* 403 */       }
/* 404 */       scan_batchIdx = scan_numRows;
/* 405 */       scan_batch = null;
/* 406 */       scan_nextBatch();
/* 407 */     }
/* 408 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 409 */     scan_scanTime1 = 0;
/* 410 */
/* 411 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 412 */
/* 413 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 414 */   }
/* 415 */
/* 416 */   private void wholestagecodegen_init_2() {
/* 417 */     project_result1 = new UnsafeRow(3);
/* 418 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 419 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 420 */     agg_result2 = new UnsafeRow(2);
/* 421 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 422 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 423 */
/* 424 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 425 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 426 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 427 */
/* 428 */   }
/* 429 */
/* 430 */   private void wholestagecodegen_init_1() {
/* 431 */     filter_result = new UnsafeRow(4);
/* 432 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 433 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 434 */     project_result = new UnsafeRow(4);
/* 435 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 436 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 437 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 438 */
/* 439 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 440 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 441 */
/* 442 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 443 */     bhj_result = new UnsafeRow(5);
/* 444 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 445 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 446 */
/* 447 */   }
/* 448 */
/* 449 */   protected void processNext() throws java.io.IOException {
/* 450 */     if (!agg_initAgg) {
/* 451 */       agg_initAgg = true;
/* 452 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 453 */       agg_doAggregateWithKeys();
/* 454 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 455 */     }
/* 456 */
/* 457 */     // output the result
/* 458 */
/* 459 */     while (agg_fastHashMapIter.next()) {
/* 460 */       wholestagecodegen_numOutputRows.add(1);
/* 461 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 462 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 463 */
/* 464 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 465 */
/* 466 */       append(agg_resultRow);
/* 467 */
/* 468 */       if (shouldStop()) return;
/* 469 */     }
/* 470 */     agg_fastHashMap.close();
/* 471 */
/* 472 */     while (agg_mapIter.next()) {
/* 473 */       wholestagecodegen_numOutputRows.add(1);
/* 474 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 475 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 476 */
/* 477 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 478 */
/* 479 */       append(agg_resultRow);
/* 480 */
/* 481 */       if (shouldStop()) return;
/* 482 */     }
/* 483 */
/* 484 */     agg_mapIter.close();
/* 485 */     if (agg_sorter == null) {
/* 486 */       agg_hashMap.free();
/* 487 */     }
/* 488 */   }
/* 489 */ }

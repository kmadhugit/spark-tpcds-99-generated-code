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
/* 233 */         filter_numOutputRows.add(1);
/* 234 */
/* 235 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 236 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 237 */
/* 238 */         // generate join key for stream side
/* 239 */
/* 240 */         boolean bhj_isNull = scan_isNull3;
/* 241 */         long bhj_value = -1L;
/* 242 */         if (!scan_isNull3) {
/* 243 */           bhj_value = (long) scan_value3;
/* 244 */         }
/* 245 */         // find matches from HashedRelation
/* 246 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 247 */         if (bhj_matched == null) continue;
/* 248 */
/* 249 */         bhj_numOutputRows.add(1);
/* 250 */
/* 251 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 252 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 253 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 254 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 255 */
/* 256 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 257 */
/* 258 */         UnsafeRow agg_fastAggBuffer = null;
/* 259 */
/* 260 */         if (true) {
/* 261 */           if (!false && !scan_isNull) {
/* 262 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 263 */               scan_value1, scan_value);
/* 264 */           }
/* 265 */         }
/* 266 */
/* 267 */         if (agg_fastAggBuffer == null) {
/* 268 */           // generate grouping key
/* 269 */           agg_rowWriter.zeroOutNullBytes();
/* 270 */
/* 271 */           agg_rowWriter.write(0, scan_value1);
/* 272 */
/* 273 */           if (scan_isNull) {
/* 274 */             agg_rowWriter.setNullAt(1);
/* 275 */           } else {
/* 276 */             agg_rowWriter.write(1, scan_value);
/* 277 */           }
/* 278 */           agg_value6 = 42;
/* 279 */
/* 280 */           if (!false) {
/* 281 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value1, agg_value6);
/* 282 */           }
/* 283 */
/* 284 */           if (!scan_isNull) {
/* 285 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value, agg_value6);
/* 286 */           }
/* 287 */           if (true) {
/* 288 */             // try to get the buffer from hash map
/* 289 */             agg_unsafeRowAggBuffer =
/* 290 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 291 */           }
/* 292 */           if (agg_unsafeRowAggBuffer == null) {
/* 293 */             if (agg_sorter == null) {
/* 294 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 295 */             } else {
/* 296 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 297 */             }
/* 298 */
/* 299 */             // the hash map had be spilled, it should have enough memory now,
/* 300 */             // try  to allocate buffer again.
/* 301 */             agg_unsafeRowAggBuffer =
/* 302 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 303 */             if (agg_unsafeRowAggBuffer == null) {
/* 304 */               // failed to allocate the first page
/* 305 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 306 */             }
/* 307 */           }
/* 308 */         }
/* 309 */
/* 310 */         if (agg_fastAggBuffer != null) {
/* 311 */           // update fast row
/* 312 */
/* 313 */           // common sub-expressions
/* 314 */
/* 315 */           // evaluate aggregate function
/* 316 */           boolean agg_isNull17 = true;
/* 317 */           double agg_value18 = -1.0;
/* 318 */
/* 319 */           boolean agg_isNull19 = agg_fastAggBuffer.isNullAt(0);
/* 320 */           double agg_value20 = agg_isNull19 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 321 */           boolean agg_isNull18 = agg_isNull19;
/* 322 */           double agg_value19 = agg_value20;
/* 323 */           if (agg_isNull18) {
/* 324 */             boolean agg_isNull20 = false;
/* 325 */             double agg_value21 = -1.0;
/* 326 */             if (!false) {
/* 327 */               agg_value21 = (double) 0;
/* 328 */             }
/* 329 */             if (!agg_isNull20) {
/* 330 */               agg_isNull18 = false;
/* 331 */               agg_value19 = agg_value21;
/* 332 */             }
/* 333 */           }
/* 334 */
/* 335 */           if (!scan_isNull2) {
/* 336 */             agg_isNull17 = false; // resultCode could change nullability.
/* 337 */             agg_value18 = agg_value19 + scan_value2;
/* 338 */
/* 339 */           }
/* 340 */           boolean agg_isNull16 = agg_isNull17;
/* 341 */           double agg_value17 = agg_value18;
/* 342 */           if (agg_isNull16) {
/* 343 */             boolean agg_isNull23 = agg_fastAggBuffer.isNullAt(0);
/* 344 */             double agg_value24 = agg_isNull23 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 345 */             if (!agg_isNull23) {
/* 346 */               agg_isNull16 = false;
/* 347 */               agg_value17 = agg_value24;
/* 348 */             }
/* 349 */           }
/* 350 */           // update fast row
/* 351 */           if (!agg_isNull16) {
/* 352 */             agg_fastAggBuffer.setDouble(0, agg_value17);
/* 353 */           } else {
/* 354 */             agg_fastAggBuffer.setNullAt(0);
/* 355 */           }
/* 356 */
/* 357 */         } else {
/* 358 */           // update unsafe row
/* 359 */
/* 360 */           // common sub-expressions
/* 361 */
/* 362 */           // evaluate aggregate function
/* 363 */           boolean agg_isNull9 = true;
/* 364 */           double agg_value10 = -1.0;
/* 365 */
/* 366 */           boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 367 */           double agg_value12 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 368 */           boolean agg_isNull10 = agg_isNull11;
/* 369 */           double agg_value11 = agg_value12;
/* 370 */           if (agg_isNull10) {
/* 371 */             boolean agg_isNull12 = false;
/* 372 */             double agg_value13 = -1.0;
/* 373 */             if (!false) {
/* 374 */               agg_value13 = (double) 0;
/* 375 */             }
/* 376 */             if (!agg_isNull12) {
/* 377 */               agg_isNull10 = false;
/* 378 */               agg_value11 = agg_value13;
/* 379 */             }
/* 380 */           }
/* 381 */
/* 382 */           if (!scan_isNull2) {
/* 383 */             agg_isNull9 = false; // resultCode could change nullability.
/* 384 */             agg_value10 = agg_value11 + scan_value2;
/* 385 */
/* 386 */           }
/* 387 */           boolean agg_isNull8 = agg_isNull9;
/* 388 */           double agg_value9 = agg_value10;
/* 389 */           if (agg_isNull8) {
/* 390 */             boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 391 */             double agg_value16 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 392 */             if (!agg_isNull15) {
/* 393 */               agg_isNull8 = false;
/* 394 */               agg_value9 = agg_value16;
/* 395 */             }
/* 396 */           }
/* 397 */           // update unsafe row buffer
/* 398 */           if (!agg_isNull8) {
/* 399 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 400 */           } else {
/* 401 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 402 */           }
/* 403 */
/* 404 */         }
/* 405 */         // shouldStop check is eliminated
/* 406 */       }
/* 407 */       scan_batchIdx = scan_numRows;
/* 408 */       scan_batch = null;
/* 409 */       scan_nextBatch();
/* 410 */     }
/* 411 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 412 */     scan_scanTime1 = 0;
/* 413 */
/* 414 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 415 */
/* 416 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 417 */   }
/* 418 */
/* 419 */   private void wholestagecodegen_init_2() {
/* 420 */     project_result1 = new UnsafeRow(3);
/* 421 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 422 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 423 */     agg_result2 = new UnsafeRow(2);
/* 424 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 425 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 426 */
/* 427 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 428 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 429 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 430 */
/* 431 */   }
/* 432 */
/* 433 */   private void wholestagecodegen_init_1() {
/* 434 */     filter_result = new UnsafeRow(4);
/* 435 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 436 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 437 */     project_result = new UnsafeRow(4);
/* 438 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 439 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 440 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 441 */
/* 442 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 443 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 444 */
/* 445 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 446 */     bhj_result = new UnsafeRow(5);
/* 447 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 448 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 449 */
/* 450 */   }
/* 451 */
/* 452 */   protected void processNext() throws java.io.IOException {
/* 453 */     if (!agg_initAgg) {
/* 454 */       agg_initAgg = true;
/* 455 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 456 */       agg_doAggregateWithKeys();
/* 457 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 458 */     }
/* 459 */
/* 460 */     // output the result
/* 461 */
/* 462 */     while (agg_fastHashMapIter.next()) {
/* 463 */       wholestagecodegen_numOutputRows.add(1);
/* 464 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 465 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 466 */
/* 467 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 468 */
/* 469 */       append(agg_resultRow);
/* 470 */
/* 471 */       if (shouldStop()) return;
/* 472 */     }
/* 473 */     agg_fastHashMap.close();
/* 474 */
/* 475 */     while (agg_mapIter.next()) {
/* 476 */       wholestagecodegen_numOutputRows.add(1);
/* 477 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 478 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 479 */
/* 480 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 481 */
/* 482 */       append(agg_resultRow);
/* 483 */
/* 484 */       if (shouldStop()) return;
/* 485 */     }
/* 486 */
/* 487 */     agg_mapIter.close();
/* 488 */     if (agg_sorter == null) {
/* 489 */       agg_hashMap.free();
/* 490 */     }
/* 491 */   }
/* 492 */ }

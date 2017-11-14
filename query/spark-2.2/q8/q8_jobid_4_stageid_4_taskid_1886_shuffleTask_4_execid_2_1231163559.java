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
/* 027 */   private UnsafeRow scan_result;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 031 */   private UnsafeRow filter_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 034 */   private UnsafeRow project_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 037 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 038 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 040 */   private UnsafeRow bhj_result;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 043 */   private UnsafeRow project_result1;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 046 */   private UnsafeRow agg_result1;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 049 */   private int agg_value4;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 052 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 053 */
/* 054 */   public GeneratedIterator(Object[] references) {
/* 055 */     this.references = references;
/* 056 */   }
/* 057 */
/* 058 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 059 */     partitionIndex = index;
/* 060 */     this.inputs = inputs;
/* 061 */     wholestagecodegen_init_0();
/* 062 */     wholestagecodegen_init_1();
/* 063 */     wholestagecodegen_init_2();
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */   private void wholestagecodegen_init_0() {
/* 068 */     agg_initAgg = false;
/* 069 */
/* 070 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 071 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 072 */
/* 073 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 074 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 075 */     scan_input = inputs[0];
/* 076 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 077 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 078 */     scan_scanTime1 = 0;
/* 079 */     scan_batch = null;
/* 080 */     scan_batchIdx = 0;
/* 081 */     scan_colInstance0 = null;
/* 082 */     scan_colInstance1 = null;
/* 083 */     scan_result = new UnsafeRow(2);
/* 084 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 085 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 2);
/* 086 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 087 */
/* 088 */   }
/* 089 */
/* 090 */   private void scan_nextBatch() throws java.io.IOException {
/* 091 */     long getBatchStart = System.nanoTime();
/* 092 */     if (scan_input.hasNext()) {
/* 093 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 094 */       scan_numOutputRows.add(scan_batch.numRows());
/* 095 */       scan_batchIdx = 0;
/* 096 */       scan_colInstance0 = scan_batch.column(0);
/* 097 */       scan_colInstance1 = scan_batch.column(1);
/* 098 */
/* 099 */     }
/* 100 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 101 */   }
/* 102 */
/* 103 */   public class agg_FastHashMap {
/* 104 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 105 */     private int[] buckets;
/* 106 */     private int capacity = 1 << 16;
/* 107 */     private double loadFactor = 0.5;
/* 108 */     private int numBuckets = (int) (capacity / loadFactor);
/* 109 */     private int maxSteps = 2;
/* 110 */     private int numRows = 0;
/* 111 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType);
/* 112 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.LongType);
/* 113 */     private Object emptyVBase;
/* 114 */     private long emptyVOff;
/* 115 */     private int emptyVLen;
/* 116 */     private boolean isBatchFull = false;
/* 117 */
/* 118 */     public agg_FastHashMap(
/* 119 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 120 */       InternalRow emptyAggregationBuffer) {
/* 121 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 122 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 123 */
/* 124 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 125 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 126 */
/* 127 */       emptyVBase = emptyBuffer;
/* 128 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 129 */       emptyVLen = emptyBuffer.length;
/* 130 */
/* 131 */       buckets = new int[numBuckets];
/* 132 */       java.util.Arrays.fill(buckets, -1);
/* 133 */     }
/* 134 */
/* 135 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key) {
/* 136 */       long h = hash(agg_key);
/* 137 */       int step = 0;
/* 138 */       int idx = (int) h & (numBuckets - 1);
/* 139 */       while (step < maxSteps) {
/* 140 */         // Return bucket index if it's either an empty slot or already contains the key
/* 141 */         if (buckets[idx] == -1) {
/* 142 */           if (numRows < capacity && !isBatchFull) {
/* 143 */             // creating the unsafe for new entry
/* 144 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 145 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 146 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 147 */               32);
/* 148 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 149 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 150 */               agg_holder,
/* 151 */               1);
/* 152 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 153 */             agg_rowWriter.zeroOutNullBytes();
/* 154 */             agg_rowWriter.write(0, agg_key);
/* 155 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 156 */             Object kbase = agg_result.getBaseObject();
/* 157 */             long koff = agg_result.getBaseOffset();
/* 158 */             int klen = agg_result.getSizeInBytes();
/* 159 */
/* 160 */             UnsafeRow vRow
/* 161 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 162 */             if (vRow == null) {
/* 163 */               isBatchFull = true;
/* 164 */             } else {
/* 165 */               buckets[idx] = numRows++;
/* 166 */             }
/* 167 */             return vRow;
/* 168 */           } else {
/* 169 */             // No more space
/* 170 */             return null;
/* 171 */           }
/* 172 */         } else if (equals(idx, agg_key)) {
/* 173 */           return batch.getValueRow(buckets[idx]);
/* 174 */         }
/* 175 */         idx = (idx + 1) & (numBuckets - 1);
/* 176 */         step++;
/* 177 */       }
/* 178 */       // Didn't find it
/* 179 */       return null;
/* 180 */     }
/* 181 */
/* 182 */     private boolean equals(int idx, UTF8String agg_key) {
/* 183 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 184 */       return (row.getUTF8String(0).equals(agg_key));
/* 185 */     }
/* 186 */
/* 187 */     private long hash(UTF8String agg_key) {
/* 188 */       long agg_hash = 0;
/* 189 */
/* 190 */       int agg_result = 0;
/* 191 */       byte[] agg_bytes = agg_key.getBytes();
/* 192 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 193 */         int agg_hash1 = agg_bytes[i];
/* 194 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 195 */       }
/* 196 */
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
/* 237 */         // find matches from HashRelation
/* 238 */         scala.collection.Iterator bhj_matches = bhj_isNull ? null : (scala.collection.Iterator)bhj_relation.get(bhj_value);
/* 239 */         if (bhj_matches == null) continue;
/* 240 */         while (bhj_matches.hasNext()) {
/* 241 */           UnsafeRow bhj_matched = (UnsafeRow) bhj_matches.next();
/* 242 */
/* 243 */           bhj_numOutputRows.add(1);
/* 244 */
/* 245 */           boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 246 */           UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 247 */
/* 248 */           UnsafeRow agg_unsafeRowAggBuffer = null;
/* 249 */
/* 250 */           UnsafeRow agg_fastAggBuffer = null;
/* 251 */
/* 252 */           if (true) {
/* 253 */             if (!scan_isNull1) {
/* 254 */               agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 255 */                 scan_value1);
/* 256 */             }
/* 257 */           }
/* 258 */
/* 259 */           if (agg_fastAggBuffer == null) {
/* 260 */             // generate grouping key
/* 261 */             agg_holder.reset();
/* 262 */
/* 263 */             agg_rowWriter.zeroOutNullBytes();
/* 264 */
/* 265 */             if (scan_isNull1) {
/* 266 */               agg_rowWriter.setNullAt(0);
/* 267 */             } else {
/* 268 */               agg_rowWriter.write(0, scan_value1);
/* 269 */             }
/* 270 */             agg_result1.setTotalSize(agg_holder.totalSize());
/* 271 */             agg_value4 = 42;
/* 272 */
/* 273 */             if (!scan_isNull1) {
/* 274 */               agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value1.getBaseObject(), scan_value1.getBaseOffset(), scan_value1.numBytes(), agg_value4);
/* 275 */             }
/* 276 */             if (true) {
/* 277 */               // try to get the buffer from hash map
/* 278 */               agg_unsafeRowAggBuffer =
/* 279 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 280 */             }
/* 281 */             if (agg_unsafeRowAggBuffer == null) {
/* 282 */               if (agg_sorter == null) {
/* 283 */                 agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 284 */               } else {
/* 285 */                 agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 286 */               }
/* 287 */
/* 288 */               // the hash map had be spilled, it should have enough memory now,
/* 289 */               // try  to allocate buffer again.
/* 290 */               agg_unsafeRowAggBuffer =
/* 291 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 292 */               if (agg_unsafeRowAggBuffer == null) {
/* 293 */                 // failed to allocate the first page
/* 294 */                 throw new OutOfMemoryError("No enough memory for aggregation");
/* 295 */               }
/* 296 */             }
/* 297 */           }
/* 298 */
/* 299 */           if (agg_fastAggBuffer != null) {
/* 300 */             // update fast row
/* 301 */
/* 302 */             // common sub-expressions
/* 303 */
/* 304 */             // evaluate aggregate function
/* 305 */             boolean agg_isNull8 = false;
/* 306 */
/* 307 */             long agg_value10 = agg_fastAggBuffer.getLong(0);
/* 308 */
/* 309 */             long agg_value9 = -1L;
/* 310 */             agg_value9 = agg_value10 + 1L;
/* 311 */             // update fast row
/* 312 */             agg_fastAggBuffer.setLong(0, agg_value9);
/* 313 */
/* 314 */           } else {
/* 315 */             // update unsafe row
/* 316 */
/* 317 */             // common sub-expressions
/* 318 */
/* 319 */             // evaluate aggregate function
/* 320 */             boolean agg_isNull5 = false;
/* 321 */
/* 322 */             long agg_value7 = agg_unsafeRowAggBuffer.getLong(0);
/* 323 */
/* 324 */             long agg_value6 = -1L;
/* 325 */             agg_value6 = agg_value7 + 1L;
/* 326 */             // update unsafe row buffer
/* 327 */             agg_unsafeRowAggBuffer.setLong(0, agg_value6);
/* 328 */
/* 329 */           }
/* 330 */
/* 331 */         }
/* 332 */         // shouldStop check is eliminated
/* 333 */       }
/* 334 */       scan_batchIdx = scan_numRows;
/* 335 */       scan_batch = null;
/* 336 */       scan_nextBatch();
/* 337 */     }
/* 338 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 339 */     scan_scanTime1 = 0;
/* 340 */
/* 341 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 342 */
/* 343 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 344 */   }
/* 345 */
/* 346 */   private void wholestagecodegen_init_2() {
/* 347 */     project_result1 = new UnsafeRow(1);
/* 348 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 349 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 1);
/* 350 */     agg_result1 = new UnsafeRow(1);
/* 351 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 352 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 353 */
/* 354 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 355 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 356 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 357 */
/* 358 */   }
/* 359 */
/* 360 */   private void wholestagecodegen_init_1() {
/* 361 */     filter_result = new UnsafeRow(2);
/* 362 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 363 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 364 */     project_result = new UnsafeRow(2);
/* 365 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 366 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 367 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 368 */
/* 369 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 370 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 371 */
/* 372 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 373 */     bhj_result = new UnsafeRow(3);
/* 374 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 375 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 3);
/* 376 */
/* 377 */   }
/* 378 */
/* 379 */   protected void processNext() throws java.io.IOException {
/* 380 */     if (!agg_initAgg) {
/* 381 */       agg_initAgg = true;
/* 382 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 383 */       agg_doAggregateWithKeys();
/* 384 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 385 */     }
/* 386 */
/* 387 */     // output the result
/* 388 */
/* 389 */     while (agg_fastHashMapIter.next()) {
/* 390 */       wholestagecodegen_numOutputRows.add(1);
/* 391 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 392 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 393 */
/* 394 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 395 */
/* 396 */       append(agg_resultRow.copy());
/* 397 */
/* 398 */       if (shouldStop()) return;
/* 399 */     }
/* 400 */     agg_fastHashMap.close();
/* 401 */
/* 402 */     while (agg_mapIter.next()) {
/* 403 */       wholestagecodegen_numOutputRows.add(1);
/* 404 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 405 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 406 */
/* 407 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 408 */
/* 409 */       append(agg_resultRow.copy());
/* 410 */
/* 411 */       if (shouldStop()) return;
/* 412 */     }
/* 413 */
/* 414 */     agg_mapIter.close();
/* 415 */     if (agg_sorter == null) {
/* 416 */       agg_hashMap.free();
/* 417 */     }
/* 418 */   }
/* 419 */ }

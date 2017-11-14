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
/* 076 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 077 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 078 */     scan_scanTime1 = 0;
/* 079 */     scan_batch = null;
/* 080 */     scan_batchIdx = 0;
/* 081 */     scan_colInstance0 = null;
/* 082 */     scan_colInstance1 = null;
/* 083 */     scan_result = new UnsafeRow(2);
/* 084 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 085 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 2);
/* 086 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
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
/* 111 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("ca_zip", org.apache.spark.sql.types.DataTypes.StringType);
/* 112 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("count", org.apache.spark.sql.types.DataTypes.LongType);
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
/* 219 */       int numRows = scan_batch.numRows();
/* 220 */       while (scan_batchIdx < numRows) {
/* 221 */         int scan_rowIdx = scan_batchIdx++;
/* 222 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 223 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 224 */
/* 225 */         if (!(!(scan_isNull))) continue;
/* 226 */
/* 227 */         filter_numOutputRows.add(1);
/* 228 */
/* 229 */         // generate join key for stream side
/* 230 */
/* 231 */         boolean bhj_isNull = false;
/* 232 */         long bhj_value = -1L;
/* 233 */         if (!false) {
/* 234 */           bhj_value = (long) scan_value;
/* 235 */         }
/* 236 */         // find matches from HashRelation
/* 237 */         scala.collection.Iterator bhj_matches = bhj_isNull ? null : (scala.collection.Iterator)bhj_relation.get(bhj_value);
/* 238 */         if (bhj_matches == null) continue;
/* 239 */         while (bhj_matches.hasNext()) {
/* 240 */           UnsafeRow bhj_matched = (UnsafeRow) bhj_matches.next();
/* 241 */
/* 242 */           bhj_numOutputRows.add(1);
/* 243 */
/* 244 */           boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 245 */           UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 246 */
/* 247 */           UnsafeRow agg_unsafeRowAggBuffer = null;
/* 248 */
/* 249 */           UnsafeRow agg_fastAggBuffer = null;
/* 250 */
/* 251 */           if (true) {
/* 252 */             if (!scan_isNull1) {
/* 253 */               agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 254 */                 scan_value1);
/* 255 */             }
/* 256 */           }
/* 257 */
/* 258 */           if (agg_fastAggBuffer == null) {
/* 259 */             // generate grouping key
/* 260 */             agg_holder.reset();
/* 261 */
/* 262 */             agg_rowWriter.zeroOutNullBytes();
/* 263 */
/* 264 */             if (scan_isNull1) {
/* 265 */               agg_rowWriter.setNullAt(0);
/* 266 */             } else {
/* 267 */               agg_rowWriter.write(0, scan_value1);
/* 268 */             }
/* 269 */             agg_result1.setTotalSize(agg_holder.totalSize());
/* 270 */             agg_value4 = 42;
/* 271 */
/* 272 */             if (!scan_isNull1) {
/* 273 */               agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value1.getBaseObject(), scan_value1.getBaseOffset(), scan_value1.numBytes(), agg_value4);
/* 274 */             }
/* 275 */             if (true) {
/* 276 */               // try to get the buffer from hash map
/* 277 */               agg_unsafeRowAggBuffer =
/* 278 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 279 */             }
/* 280 */             if (agg_unsafeRowAggBuffer == null) {
/* 281 */               if (agg_sorter == null) {
/* 282 */                 agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 283 */               } else {
/* 284 */                 agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 285 */               }
/* 286 */
/* 287 */               // the hash map had be spilled, it should have enough memory now,
/* 288 */               // try  to allocate buffer again.
/* 289 */               agg_unsafeRowAggBuffer =
/* 290 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 291 */               if (agg_unsafeRowAggBuffer == null) {
/* 292 */                 // failed to allocate the first page
/* 293 */                 throw new OutOfMemoryError("No enough memory for aggregation");
/* 294 */               }
/* 295 */             }
/* 296 */           }
/* 297 */
/* 298 */           if (agg_fastAggBuffer != null) {
/* 299 */             // update fast row
/* 300 */
/* 301 */             // common sub-expressions
/* 302 */
/* 303 */             // evaluate aggregate function
/* 304 */             boolean agg_isNull8 = false;
/* 305 */
/* 306 */             long agg_value10 = agg_fastAggBuffer.getLong(0);
/* 307 */
/* 308 */             long agg_value9 = -1L;
/* 309 */             agg_value9 = agg_value10 + 1L;
/* 310 */             // update fast row
/* 311 */             agg_fastAggBuffer.setLong(0, agg_value9);
/* 312 */
/* 313 */           } else {
/* 314 */             // update unsafe row
/* 315 */
/* 316 */             // common sub-expressions
/* 317 */
/* 318 */             // evaluate aggregate function
/* 319 */             boolean agg_isNull5 = false;
/* 320 */
/* 321 */             long agg_value7 = agg_unsafeRowAggBuffer.getLong(0);
/* 322 */
/* 323 */             long agg_value6 = -1L;
/* 324 */             agg_value6 = agg_value7 + 1L;
/* 325 */             // update unsafe row buffer
/* 326 */             agg_unsafeRowAggBuffer.setLong(0, agg_value6);
/* 327 */
/* 328 */           }
/* 329 */
/* 330 */         }
/* 331 */         if (shouldStop()) return;
/* 332 */       }
/* 333 */       scan_batch = null;
/* 334 */       scan_nextBatch();
/* 335 */     }
/* 336 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 337 */     scan_scanTime1 = 0;
/* 338 */
/* 339 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 340 */
/* 341 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 342 */   }
/* 343 */
/* 344 */   private void wholestagecodegen_init_2() {
/* 345 */     project_result1 = new UnsafeRow(1);
/* 346 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 347 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 1);
/* 348 */     agg_result1 = new UnsafeRow(1);
/* 349 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 350 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 351 */
/* 352 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 353 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 354 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 355 */
/* 356 */   }
/* 357 */
/* 358 */   private void wholestagecodegen_init_1() {
/* 359 */     filter_result = new UnsafeRow(2);
/* 360 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 361 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 362 */     project_result = new UnsafeRow(2);
/* 363 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 364 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 365 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 366 */
/* 367 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 368 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 369 */
/* 370 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 371 */     bhj_result = new UnsafeRow(3);
/* 372 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 373 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 3);
/* 374 */
/* 375 */   }
/* 376 */
/* 377 */   protected void processNext() throws java.io.IOException {
/* 378 */     if (!agg_initAgg) {
/* 379 */       agg_initAgg = true;
/* 380 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 381 */       agg_doAggregateWithKeys();
/* 382 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 383 */     }
/* 384 */
/* 385 */     // output the result
/* 386 */
/* 387 */     while (agg_fastHashMapIter.next()) {
/* 388 */       wholestagecodegen_numOutputRows.add(1);
/* 389 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 390 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 391 */
/* 392 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 393 */
/* 394 */       append(agg_resultRow.copy());
/* 395 */
/* 396 */       if (shouldStop()) return;
/* 397 */     }
/* 398 */     agg_fastHashMap.close();
/* 399 */
/* 400 */     while (agg_mapIter.next()) {
/* 401 */       wholestagecodegen_numOutputRows.add(1);
/* 402 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 403 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 404 */
/* 405 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 406 */
/* 407 */       append(agg_resultRow.copy());
/* 408 */
/* 409 */       if (shouldStop()) return;
/* 410 */     }
/* 411 */
/* 412 */     agg_mapIter.close();
/* 413 */     if (agg_sorter == null) {
/* 414 */       agg_hashMap.free();
/* 415 */     }
/* 416 */   }
/* 417 */ }

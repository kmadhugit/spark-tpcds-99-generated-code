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
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
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
/* 049 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 050 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 052 */   private UnsafeRow bhj_result1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 055 */   private UnsafeRow project_result2;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 058 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 059 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 060 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 061 */   private UnsafeRow bhj_result2;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 064 */   private UnsafeRow project_result3;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 067 */   private UnsafeRow agg_result2;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 070 */   private int agg_value6;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 072 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 073 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 074 */
/* 075 */   public GeneratedIterator(Object[] references) {
/* 076 */     this.references = references;
/* 077 */   }
/* 078 */
/* 079 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 080 */     partitionIndex = index;
/* 081 */     this.inputs = inputs;
/* 082 */     wholestagecodegen_init_0();
/* 083 */     wholestagecodegen_init_1();
/* 084 */     wholestagecodegen_init_2();
/* 085 */     wholestagecodegen_init_3();
/* 086 */     wholestagecodegen_init_4();
/* 087 */
/* 088 */   }
/* 089 */
/* 090 */   private void wholestagecodegen_init_0() {
/* 091 */     agg_initAgg = false;
/* 092 */
/* 093 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 094 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 095 */
/* 096 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 097 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 098 */     scan_input = inputs[0];
/* 099 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 100 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 101 */     scan_scanTime1 = 0;
/* 102 */     scan_batch = null;
/* 103 */     scan_batchIdx = 0;
/* 104 */     scan_colInstance0 = null;
/* 105 */     scan_colInstance1 = null;
/* 106 */     scan_colInstance2 = null;
/* 107 */     scan_colInstance3 = null;
/* 108 */     scan_colInstance4 = null;
/* 109 */     scan_result = new UnsafeRow(5);
/* 110 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 111 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 5);
/* 112 */
/* 113 */   }
/* 114 */
/* 115 */   private void wholestagecodegen_init_3() {
/* 116 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 3);
/* 117 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 118 */
/* 119 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 120 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 121 */
/* 122 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 123 */     bhj_result2 = new UnsafeRow(4);
/* 124 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 0);
/* 125 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 4);
/* 126 */     project_result3 = new UnsafeRow(2);
/* 127 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 128 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 2);
/* 129 */     agg_result2 = new UnsafeRow(2);
/* 130 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 131 */
/* 132 */   }
/* 133 */
/* 134 */   private void scan_nextBatch() throws java.io.IOException {
/* 135 */     long getBatchStart = System.nanoTime();
/* 136 */     if (scan_input.hasNext()) {
/* 137 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 138 */       scan_numOutputRows.add(scan_batch.numRows());
/* 139 */       scan_batchIdx = 0;
/* 140 */       scan_colInstance0 = scan_batch.column(0);
/* 141 */       scan_colInstance1 = scan_batch.column(1);
/* 142 */       scan_colInstance2 = scan_batch.column(2);
/* 143 */       scan_colInstance3 = scan_batch.column(3);
/* 144 */       scan_colInstance4 = scan_batch.column(4);
/* 145 */
/* 146 */     }
/* 147 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 148 */   }
/* 149 */
/* 150 */   public class agg_FastHashMap {
/* 151 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 152 */     private int[] buckets;
/* 153 */     private int capacity = 1 << 16;
/* 154 */     private double loadFactor = 0.5;
/* 155 */     private int numBuckets = (int) (capacity / loadFactor);
/* 156 */     private int maxSteps = 2;
/* 157 */     private int numRows = 0;
/* 158 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 159 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 160 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.LongType);
/* 161 */     private Object emptyVBase;
/* 162 */     private long emptyVOff;
/* 163 */     private int emptyVLen;
/* 164 */     private boolean isBatchFull = false;
/* 165 */
/* 166 */     public agg_FastHashMap(
/* 167 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 168 */       InternalRow emptyAggregationBuffer) {
/* 169 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 170 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 171 */
/* 172 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 173 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 174 */
/* 175 */       emptyVBase = emptyBuffer;
/* 176 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 177 */       emptyVLen = emptyBuffer.length;
/* 178 */
/* 179 */       buckets = new int[numBuckets];
/* 180 */       java.util.Arrays.fill(buckets, -1);
/* 181 */     }
/* 182 */
/* 183 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key, int agg_key1) {
/* 184 */       long h = hash(agg_key, agg_key1);
/* 185 */       int step = 0;
/* 186 */       int idx = (int) h & (numBuckets - 1);
/* 187 */       while (step < maxSteps) {
/* 188 */         // Return bucket index if it's either an empty slot or already contains the key
/* 189 */         if (buckets[idx] == -1) {
/* 190 */           if (numRows < capacity && !isBatchFull) {
/* 191 */             // creating the unsafe for new entry
/* 192 */             UnsafeRow agg_result = new UnsafeRow(2);
/* 193 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 194 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 195 */               0);
/* 196 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 197 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 198 */               agg_holder,
/* 199 */               2);
/* 200 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 201 */             agg_rowWriter.zeroOutNullBytes();
/* 202 */             agg_rowWriter.write(0, agg_key);
/* 203 */             agg_rowWriter.write(1, agg_key1);
/* 204 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 205 */             Object kbase = agg_result.getBaseObject();
/* 206 */             long koff = agg_result.getBaseOffset();
/* 207 */             int klen = agg_result.getSizeInBytes();
/* 208 */
/* 209 */             UnsafeRow vRow
/* 210 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 211 */             if (vRow == null) {
/* 212 */               isBatchFull = true;
/* 213 */             } else {
/* 214 */               buckets[idx] = numRows++;
/* 215 */             }
/* 216 */             return vRow;
/* 217 */           } else {
/* 218 */             // No more space
/* 219 */             return null;
/* 220 */           }
/* 221 */         } else if (equals(idx, agg_key, agg_key1)) {
/* 222 */           return batch.getValueRow(buckets[idx]);
/* 223 */         }
/* 224 */         idx = (idx + 1) & (numBuckets - 1);
/* 225 */         step++;
/* 226 */       }
/* 227 */       // Didn't find it
/* 228 */       return null;
/* 229 */     }
/* 230 */
/* 231 */     private boolean equals(int idx, int agg_key, int agg_key1) {
/* 232 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 233 */       return (row.getInt(0) == agg_key) && (row.getInt(1) == agg_key1);
/* 234 */     }
/* 235 */
/* 236 */     private long hash(int agg_key, int agg_key1) {
/* 237 */       long agg_hash = 0;
/* 238 */
/* 239 */       int agg_result = agg_key;
/* 240 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 241 */
/* 242 */       int agg_result1 = agg_key1;
/* 243 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 244 */
/* 245 */       return agg_hash;
/* 246 */     }
/* 247 */
/* 248 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 249 */       return batch.rowIterator();
/* 250 */     }
/* 251 */
/* 252 */     public void close() {
/* 253 */       batch.close();
/* 254 */     }
/* 255 */
/* 256 */   }
/* 257 */
/* 258 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 259 */     agg_hashMap = agg_plan.createHashMap();
/* 260 */
/* 261 */     if (scan_batch == null) {
/* 262 */       scan_nextBatch();
/* 263 */     }
/* 264 */     while (scan_batch != null) {
/* 265 */       int scan_numRows = scan_batch.numRows();
/* 266 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 267 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 268 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 269 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 270 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 271 */
/* 272 */         if (!(!(scan_isNull2))) continue;
/* 273 */
/* 274 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 275 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 276 */
/* 277 */         if (!(!(scan_isNull1))) continue;
/* 278 */
/* 279 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 280 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 281 */
/* 282 */         if (!(!(scan_isNull))) continue;
/* 283 */
/* 284 */         filter_numOutputRows.add(1);
/* 285 */
/* 286 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 287 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 288 */
/* 289 */         // generate join key for stream side
/* 290 */
/* 291 */         boolean bhj_isNull = scan_isNull4;
/* 292 */         long bhj_value = -1L;
/* 293 */         if (!scan_isNull4) {
/* 294 */           bhj_value = (long) scan_value4;
/* 295 */         }
/* 296 */         // find matches from HashedRelation
/* 297 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 298 */         if (bhj_matched == null) continue;
/* 299 */
/* 300 */         bhj_numOutputRows.add(1);
/* 301 */
/* 302 */         // generate join key for stream side
/* 303 */
/* 304 */         boolean bhj_isNull9 = false;
/* 305 */         long bhj_value9 = -1L;
/* 306 */         if (!false) {
/* 307 */           bhj_value9 = (long) scan_value2;
/* 308 */         }
/* 309 */         // find matches from HashedRelation
/* 310 */         UnsafeRow bhj_matched1 = bhj_isNull9 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value9);
/* 311 */         if (bhj_matched1 == null) continue;
/* 312 */
/* 313 */         bhj_numOutputRows1.add(1);
/* 314 */
/* 315 */         // generate join key for stream side
/* 316 */
/* 317 */         boolean bhj_isNull17 = false;
/* 318 */         long bhj_value17 = -1L;
/* 319 */         if (!false) {
/* 320 */           bhj_value17 = (long) scan_value1;
/* 321 */         }
/* 322 */         // find matches from HashedRelation
/* 323 */         UnsafeRow bhj_matched2 = bhj_isNull17 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value17);
/* 324 */         if (bhj_matched2 == null) continue;
/* 325 */
/* 326 */         bhj_numOutputRows2.add(1);
/* 327 */
/* 328 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 329 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 330 */
/* 331 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 332 */
/* 333 */         UnsafeRow agg_fastAggBuffer = null;
/* 334 */
/* 335 */         if (true) {
/* 336 */           if (!scan_isNull3 && !false) {
/* 337 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 338 */               scan_value3, scan_value);
/* 339 */           }
/* 340 */         }
/* 341 */
/* 342 */         if (agg_fastAggBuffer == null) {
/* 343 */           // generate grouping key
/* 344 */           agg_rowWriter.zeroOutNullBytes();
/* 345 */
/* 346 */           if (scan_isNull3) {
/* 347 */             agg_rowWriter.setNullAt(0);
/* 348 */           } else {
/* 349 */             agg_rowWriter.write(0, scan_value3);
/* 350 */           }
/* 351 */
/* 352 */           agg_rowWriter.write(1, scan_value);
/* 353 */           agg_value6 = 42;
/* 354 */
/* 355 */           if (!scan_isNull3) {
/* 356 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value3, agg_value6);
/* 357 */           }
/* 358 */
/* 359 */           if (!false) {
/* 360 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value, agg_value6);
/* 361 */           }
/* 362 */           if (true) {
/* 363 */             // try to get the buffer from hash map
/* 364 */             agg_unsafeRowAggBuffer =
/* 365 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 366 */           }
/* 367 */           if (agg_unsafeRowAggBuffer == null) {
/* 368 */             if (agg_sorter == null) {
/* 369 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 370 */             } else {
/* 371 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 372 */             }
/* 373 */
/* 374 */             // the hash map had be spilled, it should have enough memory now,
/* 375 */             // try  to allocate buffer again.
/* 376 */             agg_unsafeRowAggBuffer =
/* 377 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 378 */             if (agg_unsafeRowAggBuffer == null) {
/* 379 */               // failed to allocate the first page
/* 380 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 381 */             }
/* 382 */           }
/* 383 */         }
/* 384 */
/* 385 */         if (agg_fastAggBuffer != null) {
/* 386 */           // update fast row
/* 387 */
/* 388 */           // common sub-expressions
/* 389 */
/* 390 */           // evaluate aggregate function
/* 391 */           boolean agg_isNull11 = false;
/* 392 */
/* 393 */           long agg_value13 = agg_fastAggBuffer.getLong(0);
/* 394 */
/* 395 */           long agg_value12 = -1L;
/* 396 */           agg_value12 = agg_value13 + 1L;
/* 397 */           // update fast row
/* 398 */           agg_fastAggBuffer.setLong(0, agg_value12);
/* 399 */
/* 400 */         } else {
/* 401 */           // update unsafe row
/* 402 */
/* 403 */           // common sub-expressions
/* 404 */
/* 405 */           // evaluate aggregate function
/* 406 */           boolean agg_isNull8 = false;
/* 407 */
/* 408 */           long agg_value10 = agg_unsafeRowAggBuffer.getLong(0);
/* 409 */
/* 410 */           long agg_value9 = -1L;
/* 411 */           agg_value9 = agg_value10 + 1L;
/* 412 */           // update unsafe row buffer
/* 413 */           agg_unsafeRowAggBuffer.setLong(0, agg_value9);
/* 414 */
/* 415 */         }
/* 416 */         // shouldStop check is eliminated
/* 417 */       }
/* 418 */       scan_batchIdx = scan_numRows;
/* 419 */       scan_batch = null;
/* 420 */       scan_nextBatch();
/* 421 */     }
/* 422 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 423 */     scan_scanTime1 = 0;
/* 424 */
/* 425 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 426 */
/* 427 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 428 */   }
/* 429 */
/* 430 */   private void wholestagecodegen_init_2() {
/* 431 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 432 */     project_result1 = new UnsafeRow(4);
/* 433 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 434 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 435 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[11];
/* 436 */
/* 437 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 438 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 439 */
/* 440 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 441 */     bhj_result1 = new UnsafeRow(5);
/* 442 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 443 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 5);
/* 444 */     project_result2 = new UnsafeRow(3);
/* 445 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 446 */
/* 447 */   }
/* 448 */
/* 449 */   private void wholestagecodegen_init_1() {
/* 450 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 451 */     filter_result = new UnsafeRow(5);
/* 452 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 453 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 454 */     project_result = new UnsafeRow(5);
/* 455 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 456 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 457 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 458 */
/* 459 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 460 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 461 */
/* 462 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 463 */     bhj_result = new UnsafeRow(6);
/* 464 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 465 */
/* 466 */   }
/* 467 */
/* 468 */   private void wholestagecodegen_init_4() {
/* 469 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 470 */
/* 471 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 472 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 473 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 474 */
/* 475 */   }
/* 476 */
/* 477 */   protected void processNext() throws java.io.IOException {
/* 478 */     if (!agg_initAgg) {
/* 479 */       agg_initAgg = true;
/* 480 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 481 */       agg_doAggregateWithKeys();
/* 482 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 483 */     }
/* 484 */
/* 485 */     // output the result
/* 486 */
/* 487 */     while (agg_fastHashMapIter.next()) {
/* 488 */       wholestagecodegen_numOutputRows.add(1);
/* 489 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 490 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 491 */
/* 492 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 493 */
/* 494 */       append(agg_resultRow);
/* 495 */
/* 496 */       if (shouldStop()) return;
/* 497 */     }
/* 498 */     agg_fastHashMap.close();
/* 499 */
/* 500 */     while (agg_mapIter.next()) {
/* 501 */       wholestagecodegen_numOutputRows.add(1);
/* 502 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 503 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 504 */
/* 505 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 506 */
/* 507 */       append(agg_resultRow);
/* 508 */
/* 509 */       if (shouldStop()) return;
/* 510 */     }
/* 511 */
/* 512 */     agg_mapIter.close();
/* 513 */     if (agg_sorter == null) {
/* 514 */       agg_hashMap.free();
/* 515 */     }
/* 516 */   }
/* 517 */ }

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
/* 028 */   private UnsafeRow scan_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 032 */   private UnsafeRow filter_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 039 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 041 */   private UnsafeRow bhj_result;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 044 */   private UnsafeRow project_result1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 047 */   private UnsafeRow agg_result2;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 050 */   private int agg_value6;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 052 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 053 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 054 */
/* 055 */   public GeneratedIterator(Object[] references) {
/* 056 */     this.references = references;
/* 057 */   }
/* 058 */
/* 059 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 060 */     partitionIndex = index;
/* 061 */     this.inputs = inputs;
/* 062 */     wholestagecodegen_init_0();
/* 063 */     wholestagecodegen_init_1();
/* 064 */     wholestagecodegen_init_2();
/* 065 */
/* 066 */   }
/* 067 */
/* 068 */   private void wholestagecodegen_init_0() {
/* 069 */     agg_initAgg = false;
/* 070 */
/* 071 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 072 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 073 */
/* 074 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 075 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 076 */     scan_input = inputs[0];
/* 077 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 078 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 079 */     scan_scanTime1 = 0;
/* 080 */     scan_batch = null;
/* 081 */     scan_batchIdx = 0;
/* 082 */     scan_colInstance0 = null;
/* 083 */     scan_colInstance1 = null;
/* 084 */     scan_colInstance2 = null;
/* 085 */     scan_result = new UnsafeRow(3);
/* 086 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 087 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 088 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 089 */
/* 090 */   }
/* 091 */
/* 092 */   private void scan_nextBatch() throws java.io.IOException {
/* 093 */     long getBatchStart = System.nanoTime();
/* 094 */     if (scan_input.hasNext()) {
/* 095 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 096 */       scan_numOutputRows.add(scan_batch.numRows());
/* 097 */       scan_batchIdx = 0;
/* 098 */       scan_colInstance0 = scan_batch.column(0);
/* 099 */       scan_colInstance1 = scan_batch.column(1);
/* 100 */       scan_colInstance2 = scan_batch.column(2);
/* 101 */
/* 102 */     }
/* 103 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 104 */   }
/* 105 */
/* 106 */   public class agg_FastHashMap {
/* 107 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 108 */     private int[] buckets;
/* 109 */     private int capacity = 1 << 16;
/* 110 */     private double loadFactor = 0.5;
/* 111 */     private int numBuckets = (int) (capacity / loadFactor);
/* 112 */     private int maxSteps = 2;
/* 113 */     private int numRows = 0;
/* 114 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 115 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType);
/* 116 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 117 */     private Object emptyVBase;
/* 118 */     private long emptyVOff;
/* 119 */     private int emptyVLen;
/* 120 */     private boolean isBatchFull = false;
/* 121 */
/* 122 */     public agg_FastHashMap(
/* 123 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 124 */       InternalRow emptyAggregationBuffer) {
/* 125 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 126 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 127 */
/* 128 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 129 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 130 */
/* 131 */       emptyVBase = emptyBuffer;
/* 132 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 133 */       emptyVLen = emptyBuffer.length;
/* 134 */
/* 135 */       buckets = new int[numBuckets];
/* 136 */       java.util.Arrays.fill(buckets, -1);
/* 137 */     }
/* 138 */
/* 139 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key, UTF8String agg_key1) {
/* 140 */       long h = hash(agg_key, agg_key1);
/* 141 */       int step = 0;
/* 142 */       int idx = (int) h & (numBuckets - 1);
/* 143 */       while (step < maxSteps) {
/* 144 */         // Return bucket index if it's either an empty slot or already contains the key
/* 145 */         if (buckets[idx] == -1) {
/* 146 */           if (numRows < capacity && !isBatchFull) {
/* 147 */             // creating the unsafe for new entry
/* 148 */             UnsafeRow agg_result = new UnsafeRow(2);
/* 149 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 150 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 151 */               32);
/* 152 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 153 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 154 */               agg_holder,
/* 155 */               2);
/* 156 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 157 */             agg_rowWriter.zeroOutNullBytes();
/* 158 */             agg_rowWriter.write(0, agg_key);
/* 159 */             agg_rowWriter.write(1, agg_key1);
/* 160 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 161 */             Object kbase = agg_result.getBaseObject();
/* 162 */             long koff = agg_result.getBaseOffset();
/* 163 */             int klen = agg_result.getSizeInBytes();
/* 164 */
/* 165 */             UnsafeRow vRow
/* 166 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 167 */             if (vRow == null) {
/* 168 */               isBatchFull = true;
/* 169 */             } else {
/* 170 */               buckets[idx] = numRows++;
/* 171 */             }
/* 172 */             return vRow;
/* 173 */           } else {
/* 174 */             // No more space
/* 175 */             return null;
/* 176 */           }
/* 177 */         } else if (equals(idx, agg_key, agg_key1)) {
/* 178 */           return batch.getValueRow(buckets[idx]);
/* 179 */         }
/* 180 */         idx = (idx + 1) & (numBuckets - 1);
/* 181 */         step++;
/* 182 */       }
/* 183 */       // Didn't find it
/* 184 */       return null;
/* 185 */     }
/* 186 */
/* 187 */     private boolean equals(int idx, int agg_key, UTF8String agg_key1) {
/* 188 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 189 */       return (row.getInt(0) == agg_key) && (row.getUTF8String(1).equals(agg_key1));
/* 190 */     }
/* 191 */
/* 192 */     private long hash(int agg_key, UTF8String agg_key1) {
/* 193 */       long agg_hash = 0;
/* 194 */
/* 195 */       int agg_result = agg_key;
/* 196 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 197 */
/* 198 */       int agg_result1 = 0;
/* 199 */       byte[] agg_bytes = agg_key1.getBytes();
/* 200 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 201 */         int agg_hash1 = agg_bytes[i];
/* 202 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash1 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 203 */       }
/* 204 */
/* 205 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 206 */
/* 207 */       return agg_hash;
/* 208 */     }
/* 209 */
/* 210 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 211 */       return batch.rowIterator();
/* 212 */     }
/* 213 */
/* 214 */     public void close() {
/* 215 */       batch.close();
/* 216 */     }
/* 217 */
/* 218 */   }
/* 219 */
/* 220 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 221 */     agg_hashMap = agg_plan.createHashMap();
/* 222 */
/* 223 */     if (scan_batch == null) {
/* 224 */       scan_nextBatch();
/* 225 */     }
/* 226 */     while (scan_batch != null) {
/* 227 */       int scan_numRows = scan_batch.numRows();
/* 228 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 229 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 230 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 231 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 232 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 233 */
/* 234 */         if (!(!(scan_isNull))) continue;
/* 235 */
/* 236 */         filter_numOutputRows.add(1);
/* 237 */
/* 238 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 239 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 240 */
/* 241 */         // generate join key for stream side
/* 242 */
/* 243 */         boolean bhj_isNull = scan_isNull2;
/* 244 */         long bhj_value = -1L;
/* 245 */         if (!scan_isNull2) {
/* 246 */           bhj_value = (long) scan_value2;
/* 247 */         }
/* 248 */         // find matches from HashedRelation
/* 249 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 250 */         if (bhj_matched == null) continue;
/* 251 */
/* 252 */         bhj_numOutputRows.add(1);
/* 253 */
/* 254 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 255 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 256 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 257 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 258 */
/* 259 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 260 */
/* 261 */         UnsafeRow agg_fastAggBuffer = null;
/* 262 */
/* 263 */         if (true) {
/* 264 */           if (!false && !bhj_isNull3) {
/* 265 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 266 */               scan_value, bhj_value3);
/* 267 */           }
/* 268 */         }
/* 269 */
/* 270 */         if (agg_fastAggBuffer == null) {
/* 271 */           // generate grouping key
/* 272 */           agg_holder.reset();
/* 273 */
/* 274 */           agg_rowWriter.zeroOutNullBytes();
/* 275 */
/* 276 */           agg_rowWriter.write(0, scan_value);
/* 277 */
/* 278 */           if (bhj_isNull3) {
/* 279 */             agg_rowWriter.setNullAt(1);
/* 280 */           } else {
/* 281 */             agg_rowWriter.write(1, bhj_value3);
/* 282 */           }
/* 283 */           agg_result2.setTotalSize(agg_holder.totalSize());
/* 284 */           agg_value6 = 42;
/* 285 */
/* 286 */           if (!false) {
/* 287 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value, agg_value6);
/* 288 */           }
/* 289 */
/* 290 */           if (!bhj_isNull3) {
/* 291 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value6);
/* 292 */           }
/* 293 */           if (true) {
/* 294 */             // try to get the buffer from hash map
/* 295 */             agg_unsafeRowAggBuffer =
/* 296 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 297 */           }
/* 298 */           if (agg_unsafeRowAggBuffer == null) {
/* 299 */             if (agg_sorter == null) {
/* 300 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 301 */             } else {
/* 302 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 303 */             }
/* 304 */
/* 305 */             // the hash map had be spilled, it should have enough memory now,
/* 306 */             // try  to allocate buffer again.
/* 307 */             agg_unsafeRowAggBuffer =
/* 308 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 309 */             if (agg_unsafeRowAggBuffer == null) {
/* 310 */               // failed to allocate the first page
/* 311 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 312 */             }
/* 313 */           }
/* 314 */         }
/* 315 */
/* 316 */         if (agg_fastAggBuffer != null) {
/* 317 */           // update fast row
/* 318 */
/* 319 */           // common sub-expressions
/* 320 */
/* 321 */           // evaluate aggregate function
/* 322 */           boolean agg_isNull17 = true;
/* 323 */           double agg_value18 = -1.0;
/* 324 */
/* 325 */           boolean agg_isNull19 = agg_fastAggBuffer.isNullAt(0);
/* 326 */           double agg_value20 = agg_isNull19 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 327 */           boolean agg_isNull18 = agg_isNull19;
/* 328 */           double agg_value19 = agg_value20;
/* 329 */           if (agg_isNull18) {
/* 330 */             boolean agg_isNull20 = false;
/* 331 */             double agg_value21 = -1.0;
/* 332 */             if (!false) {
/* 333 */               agg_value21 = (double) 0;
/* 334 */             }
/* 335 */             if (!agg_isNull20) {
/* 336 */               agg_isNull18 = false;
/* 337 */               agg_value19 = agg_value21;
/* 338 */             }
/* 339 */           }
/* 340 */
/* 341 */           if (!scan_isNull1) {
/* 342 */             agg_isNull17 = false; // resultCode could change nullability.
/* 343 */             agg_value18 = agg_value19 + scan_value1;
/* 344 */
/* 345 */           }
/* 346 */           boolean agg_isNull16 = agg_isNull17;
/* 347 */           double agg_value17 = agg_value18;
/* 348 */           if (agg_isNull16) {
/* 349 */             boolean agg_isNull23 = agg_fastAggBuffer.isNullAt(0);
/* 350 */             double agg_value24 = agg_isNull23 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 351 */             if (!agg_isNull23) {
/* 352 */               agg_isNull16 = false;
/* 353 */               agg_value17 = agg_value24;
/* 354 */             }
/* 355 */           }
/* 356 */           // update fast row
/* 357 */           if (!agg_isNull16) {
/* 358 */             agg_fastAggBuffer.setDouble(0, agg_value17);
/* 359 */           } else {
/* 360 */             agg_fastAggBuffer.setNullAt(0);
/* 361 */           }
/* 362 */
/* 363 */         } else {
/* 364 */           // update unsafe row
/* 365 */
/* 366 */           // common sub-expressions
/* 367 */
/* 368 */           // evaluate aggregate function
/* 369 */           boolean agg_isNull9 = true;
/* 370 */           double agg_value10 = -1.0;
/* 371 */
/* 372 */           boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 373 */           double agg_value12 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 374 */           boolean agg_isNull10 = agg_isNull11;
/* 375 */           double agg_value11 = agg_value12;
/* 376 */           if (agg_isNull10) {
/* 377 */             boolean agg_isNull12 = false;
/* 378 */             double agg_value13 = -1.0;
/* 379 */             if (!false) {
/* 380 */               agg_value13 = (double) 0;
/* 381 */             }
/* 382 */             if (!agg_isNull12) {
/* 383 */               agg_isNull10 = false;
/* 384 */               agg_value11 = agg_value13;
/* 385 */             }
/* 386 */           }
/* 387 */
/* 388 */           if (!scan_isNull1) {
/* 389 */             agg_isNull9 = false; // resultCode could change nullability.
/* 390 */             agg_value10 = agg_value11 + scan_value1;
/* 391 */
/* 392 */           }
/* 393 */           boolean agg_isNull8 = agg_isNull9;
/* 394 */           double agg_value9 = agg_value10;
/* 395 */           if (agg_isNull8) {
/* 396 */             boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 397 */             double agg_value16 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 398 */             if (!agg_isNull15) {
/* 399 */               agg_isNull8 = false;
/* 400 */               agg_value9 = agg_value16;
/* 401 */             }
/* 402 */           }
/* 403 */           // update unsafe row buffer
/* 404 */           if (!agg_isNull8) {
/* 405 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 406 */           } else {
/* 407 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 408 */           }
/* 409 */
/* 410 */         }
/* 411 */         // shouldStop check is eliminated
/* 412 */       }
/* 413 */       scan_batchIdx = scan_numRows;
/* 414 */       scan_batch = null;
/* 415 */       scan_nextBatch();
/* 416 */     }
/* 417 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 418 */     scan_scanTime1 = 0;
/* 419 */
/* 420 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 421 */
/* 422 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 423 */   }
/* 424 */
/* 425 */   private void wholestagecodegen_init_2() {
/* 426 */     project_result1 = new UnsafeRow(3);
/* 427 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 428 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 429 */     agg_result2 = new UnsafeRow(2);
/* 430 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 32);
/* 431 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 432 */
/* 433 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 434 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 435 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 436 */
/* 437 */   }
/* 438 */
/* 439 */   private void wholestagecodegen_init_1() {
/* 440 */     filter_result = new UnsafeRow(3);
/* 441 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 442 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 443 */     project_result = new UnsafeRow(3);
/* 444 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 445 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 446 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 447 */
/* 448 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 449 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 450 */
/* 451 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 452 */     bhj_result = new UnsafeRow(5);
/* 453 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 454 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 455 */
/* 456 */   }
/* 457 */
/* 458 */   protected void processNext() throws java.io.IOException {
/* 459 */     if (!agg_initAgg) {
/* 460 */       agg_initAgg = true;
/* 461 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 462 */       agg_doAggregateWithKeys();
/* 463 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 464 */     }
/* 465 */
/* 466 */     // output the result
/* 467 */
/* 468 */     while (agg_fastHashMapIter.next()) {
/* 469 */       wholestagecodegen_numOutputRows.add(1);
/* 470 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 471 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 472 */
/* 473 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 474 */
/* 475 */       append(agg_resultRow);
/* 476 */
/* 477 */       if (shouldStop()) return;
/* 478 */     }
/* 479 */     agg_fastHashMap.close();
/* 480 */
/* 481 */     while (agg_mapIter.next()) {
/* 482 */       wholestagecodegen_numOutputRows.add(1);
/* 483 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 484 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 485 */
/* 486 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 487 */
/* 488 */       append(agg_resultRow);
/* 489 */
/* 490 */       if (shouldStop()) return;
/* 491 */     }
/* 492 */
/* 493 */     agg_mapIter.close();
/* 494 */     if (agg_sorter == null) {
/* 495 */       agg_hashMap.free();
/* 496 */     }
/* 497 */   }
/* 498 */ }

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
/* 048 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 049 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 051 */   private UnsafeRow bhj_result1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 054 */   private UnsafeRow project_result2;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 057 */   private UnsafeRow agg_result1;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 060 */   private int agg_value4;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 062 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 063 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 064 */
/* 065 */   public GeneratedIterator(Object[] references) {
/* 066 */     this.references = references;
/* 067 */   }
/* 068 */
/* 069 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 070 */     partitionIndex = index;
/* 071 */     this.inputs = inputs;
/* 072 */     wholestagecodegen_init_0();
/* 073 */     wholestagecodegen_init_1();
/* 074 */     wholestagecodegen_init_2();
/* 075 */     wholestagecodegen_init_3();
/* 076 */
/* 077 */   }
/* 078 */
/* 079 */   private void wholestagecodegen_init_0() {
/* 080 */     agg_initAgg = false;
/* 081 */
/* 082 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 083 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 084 */
/* 085 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 086 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 087 */     scan_input = inputs[0];
/* 088 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 089 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 090 */     scan_scanTime1 = 0;
/* 091 */     scan_batch = null;
/* 092 */     scan_batchIdx = 0;
/* 093 */     scan_colInstance0 = null;
/* 094 */     scan_colInstance1 = null;
/* 095 */     scan_colInstance2 = null;
/* 096 */     scan_colInstance3 = null;
/* 097 */     scan_result = new UnsafeRow(4);
/* 098 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 099 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 100 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 101 */
/* 102 */   }
/* 103 */
/* 104 */   private void wholestagecodegen_init_3() {
/* 105 */     agg_result1 = new UnsafeRow(1);
/* 106 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 107 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 108 */
/* 109 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 110 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 111 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 112 */
/* 113 */   }
/* 114 */
/* 115 */   private void scan_nextBatch() throws java.io.IOException {
/* 116 */     long getBatchStart = System.nanoTime();
/* 117 */     if (scan_input.hasNext()) {
/* 118 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 119 */       scan_numOutputRows.add(scan_batch.numRows());
/* 120 */       scan_batchIdx = 0;
/* 121 */       scan_colInstance0 = scan_batch.column(0);
/* 122 */       scan_colInstance1 = scan_batch.column(1);
/* 123 */       scan_colInstance2 = scan_batch.column(2);
/* 124 */       scan_colInstance3 = scan_batch.column(3);
/* 125 */
/* 126 */     }
/* 127 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 128 */   }
/* 129 */
/* 130 */   public class agg_FastHashMap {
/* 131 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 132 */     private int[] buckets;
/* 133 */     private int capacity = 1 << 16;
/* 134 */     private double loadFactor = 0.5;
/* 135 */     private int numBuckets = (int) (capacity / loadFactor);
/* 136 */     private int maxSteps = 2;
/* 137 */     private int numRows = 0;
/* 138 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 139 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 140 */     private Object emptyVBase;
/* 141 */     private long emptyVOff;
/* 142 */     private int emptyVLen;
/* 143 */     private boolean isBatchFull = false;
/* 144 */
/* 145 */     public agg_FastHashMap(
/* 146 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 147 */       InternalRow emptyAggregationBuffer) {
/* 148 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 149 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 150 */
/* 151 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 152 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 153 */
/* 154 */       emptyVBase = emptyBuffer;
/* 155 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 156 */       emptyVLen = emptyBuffer.length;
/* 157 */
/* 158 */       buckets = new int[numBuckets];
/* 159 */       java.util.Arrays.fill(buckets, -1);
/* 160 */     }
/* 161 */
/* 162 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 163 */       long h = hash(agg_key);
/* 164 */       int step = 0;
/* 165 */       int idx = (int) h & (numBuckets - 1);
/* 166 */       while (step < maxSteps) {
/* 167 */         // Return bucket index if it's either an empty slot or already contains the key
/* 168 */         if (buckets[idx] == -1) {
/* 169 */           if (numRows < capacity && !isBatchFull) {
/* 170 */             // creating the unsafe for new entry
/* 171 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 172 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 173 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 174 */               0);
/* 175 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 176 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 177 */               agg_holder,
/* 178 */               1);
/* 179 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 180 */             agg_rowWriter.zeroOutNullBytes();
/* 181 */             agg_rowWriter.write(0, agg_key);
/* 182 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 183 */             Object kbase = agg_result.getBaseObject();
/* 184 */             long koff = agg_result.getBaseOffset();
/* 185 */             int klen = agg_result.getSizeInBytes();
/* 186 */
/* 187 */             UnsafeRow vRow
/* 188 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 189 */             if (vRow == null) {
/* 190 */               isBatchFull = true;
/* 191 */             } else {
/* 192 */               buckets[idx] = numRows++;
/* 193 */             }
/* 194 */             return vRow;
/* 195 */           } else {
/* 196 */             // No more space
/* 197 */             return null;
/* 198 */           }
/* 199 */         } else if (equals(idx, agg_key)) {
/* 200 */           return batch.getValueRow(buckets[idx]);
/* 201 */         }
/* 202 */         idx = (idx + 1) & (numBuckets - 1);
/* 203 */         step++;
/* 204 */       }
/* 205 */       // Didn't find it
/* 206 */       return null;
/* 207 */     }
/* 208 */
/* 209 */     private boolean equals(int idx, int agg_key) {
/* 210 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 211 */       return (row.getInt(0) == agg_key);
/* 212 */     }
/* 213 */
/* 214 */     private long hash(int agg_key) {
/* 215 */       long agg_hash = 0;
/* 216 */
/* 217 */       int agg_result = agg_key;
/* 218 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 219 */
/* 220 */       return agg_hash;
/* 221 */     }
/* 222 */
/* 223 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 224 */       return batch.rowIterator();
/* 225 */     }
/* 226 */
/* 227 */     public void close() {
/* 228 */       batch.close();
/* 229 */     }
/* 230 */
/* 231 */   }
/* 232 */
/* 233 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 234 */     agg_hashMap = agg_plan.createHashMap();
/* 235 */
/* 236 */     if (scan_batch == null) {
/* 237 */       scan_nextBatch();
/* 238 */     }
/* 239 */     while (scan_batch != null) {
/* 240 */       int scan_numRows = scan_batch.numRows();
/* 241 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 242 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 243 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 244 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 245 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 246 */
/* 247 */         if (!(!(scan_isNull))) continue;
/* 248 */
/* 249 */         filter_numOutputRows.add(1);
/* 250 */
/* 251 */         // generate join key for stream side
/* 252 */
/* 253 */         boolean bhj_isNull = false;
/* 254 */         long bhj_value = -1L;
/* 255 */         if (!false) {
/* 256 */           bhj_value = (long) scan_value;
/* 257 */         }
/* 258 */         // find matches from HashedRelation
/* 259 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 260 */         if (bhj_matched == null) continue;
/* 261 */
/* 262 */         bhj_numOutputRows.add(1);
/* 263 */
/* 264 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 265 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 266 */
/* 267 */         // generate join key for stream side
/* 268 */
/* 269 */         boolean bhj_isNull8 = scan_isNull3;
/* 270 */         long bhj_value8 = -1L;
/* 271 */         if (!scan_isNull3) {
/* 272 */           bhj_value8 = (long) scan_value3;
/* 273 */         }
/* 274 */         // find matches from HashedRelation
/* 275 */         UnsafeRow bhj_matched1 = bhj_isNull8 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value8);
/* 276 */         if (bhj_matched1 == null) continue;
/* 277 */
/* 278 */         bhj_numOutputRows1.add(1);
/* 279 */
/* 280 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 281 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 282 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 283 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 284 */         boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 285 */         int bhj_value2 = bhj_isNull2 ? -1 : (bhj_matched.getInt(0));
/* 286 */
/* 287 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 288 */
/* 289 */         UnsafeRow agg_fastAggBuffer = null;
/* 290 */
/* 291 */         if (true) {
/* 292 */           if (!bhj_isNull2) {
/* 293 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 294 */               bhj_value2);
/* 295 */           }
/* 296 */         }
/* 297 */
/* 298 */         if (agg_fastAggBuffer == null) {
/* 299 */           // generate grouping key
/* 300 */           agg_rowWriter.zeroOutNullBytes();
/* 301 */
/* 302 */           if (bhj_isNull2) {
/* 303 */             agg_rowWriter.setNullAt(0);
/* 304 */           } else {
/* 305 */             agg_rowWriter.write(0, bhj_value2);
/* 306 */           }
/* 307 */           agg_value4 = 42;
/* 308 */
/* 309 */           if (!bhj_isNull2) {
/* 310 */             agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value2, agg_value4);
/* 311 */           }
/* 312 */           if (true) {
/* 313 */             // try to get the buffer from hash map
/* 314 */             agg_unsafeRowAggBuffer =
/* 315 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 316 */           }
/* 317 */           if (agg_unsafeRowAggBuffer == null) {
/* 318 */             if (agg_sorter == null) {
/* 319 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 320 */             } else {
/* 321 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 322 */             }
/* 323 */
/* 324 */             // the hash map had be spilled, it should have enough memory now,
/* 325 */             // try  to allocate buffer again.
/* 326 */             agg_unsafeRowAggBuffer =
/* 327 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 328 */             if (agg_unsafeRowAggBuffer == null) {
/* 329 */               // failed to allocate the first page
/* 330 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 331 */             }
/* 332 */           }
/* 333 */         }
/* 334 */
/* 335 */         if (agg_fastAggBuffer != null) {
/* 336 */           // update fast row
/* 337 */
/* 338 */           // common sub-expressions
/* 339 */
/* 340 */           // evaluate aggregate function
/* 341 */           boolean agg_isNull17 = true;
/* 342 */           double agg_value18 = -1.0;
/* 343 */
/* 344 */           boolean agg_isNull19 = agg_fastAggBuffer.isNullAt(0);
/* 345 */           double agg_value20 = agg_isNull19 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 346 */           boolean agg_isNull18 = agg_isNull19;
/* 347 */           double agg_value19 = agg_value20;
/* 348 */           if (agg_isNull18) {
/* 349 */             boolean agg_isNull20 = false;
/* 350 */             double agg_value21 = -1.0;
/* 351 */             if (!false) {
/* 352 */               agg_value21 = (double) 0;
/* 353 */             }
/* 354 */             if (!agg_isNull20) {
/* 355 */               agg_isNull18 = false;
/* 356 */               agg_value19 = agg_value21;
/* 357 */             }
/* 358 */           }
/* 359 */
/* 360 */           boolean agg_isNull22 = true;
/* 361 */           double agg_value23 = -1.0;
/* 362 */
/* 363 */           boolean agg_isNull23 = scan_isNull1;
/* 364 */           double agg_value24 = -1.0;
/* 365 */           if (!scan_isNull1) {
/* 366 */             agg_value24 = (double) scan_value1;
/* 367 */           }
/* 368 */           if (!agg_isNull23) {
/* 369 */             if (!scan_isNull2) {
/* 370 */               agg_isNull22 = false; // resultCode could change nullability.
/* 371 */               agg_value23 = agg_value24 * scan_value2;
/* 372 */
/* 373 */             }
/* 374 */
/* 375 */           }
/* 376 */           if (!agg_isNull22) {
/* 377 */             agg_isNull17 = false; // resultCode could change nullability.
/* 378 */             agg_value18 = agg_value19 + agg_value23;
/* 379 */
/* 380 */           }
/* 381 */           boolean agg_isNull16 = agg_isNull17;
/* 382 */           double agg_value17 = agg_value18;
/* 383 */           if (agg_isNull16) {
/* 384 */             boolean agg_isNull26 = agg_fastAggBuffer.isNullAt(0);
/* 385 */             double agg_value27 = agg_isNull26 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 386 */             if (!agg_isNull26) {
/* 387 */               agg_isNull16 = false;
/* 388 */               agg_value17 = agg_value27;
/* 389 */             }
/* 390 */           }
/* 391 */           // update fast row
/* 392 */           if (!agg_isNull16) {
/* 393 */             agg_fastAggBuffer.setDouble(0, agg_value17);
/* 394 */           } else {
/* 395 */             agg_fastAggBuffer.setNullAt(0);
/* 396 */           }
/* 397 */
/* 398 */         } else {
/* 399 */           // update unsafe row
/* 400 */
/* 401 */           // common sub-expressions
/* 402 */
/* 403 */           // evaluate aggregate function
/* 404 */           boolean agg_isNull6 = true;
/* 405 */           double agg_value7 = -1.0;
/* 406 */
/* 407 */           boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 408 */           double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 409 */           boolean agg_isNull7 = agg_isNull8;
/* 410 */           double agg_value8 = agg_value9;
/* 411 */           if (agg_isNull7) {
/* 412 */             boolean agg_isNull9 = false;
/* 413 */             double agg_value10 = -1.0;
/* 414 */             if (!false) {
/* 415 */               agg_value10 = (double) 0;
/* 416 */             }
/* 417 */             if (!agg_isNull9) {
/* 418 */               agg_isNull7 = false;
/* 419 */               agg_value8 = agg_value10;
/* 420 */             }
/* 421 */           }
/* 422 */
/* 423 */           boolean agg_isNull11 = true;
/* 424 */           double agg_value12 = -1.0;
/* 425 */
/* 426 */           boolean agg_isNull12 = scan_isNull1;
/* 427 */           double agg_value13 = -1.0;
/* 428 */           if (!scan_isNull1) {
/* 429 */             agg_value13 = (double) scan_value1;
/* 430 */           }
/* 431 */           if (!agg_isNull12) {
/* 432 */             if (!scan_isNull2) {
/* 433 */               agg_isNull11 = false; // resultCode could change nullability.
/* 434 */               agg_value12 = agg_value13 * scan_value2;
/* 435 */
/* 436 */             }
/* 437 */
/* 438 */           }
/* 439 */           if (!agg_isNull11) {
/* 440 */             agg_isNull6 = false; // resultCode could change nullability.
/* 441 */             agg_value7 = agg_value8 + agg_value12;
/* 442 */
/* 443 */           }
/* 444 */           boolean agg_isNull5 = agg_isNull6;
/* 445 */           double agg_value6 = agg_value7;
/* 446 */           if (agg_isNull5) {
/* 447 */             boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 448 */             double agg_value16 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 449 */             if (!agg_isNull15) {
/* 450 */               agg_isNull5 = false;
/* 451 */               agg_value6 = agg_value16;
/* 452 */             }
/* 453 */           }
/* 454 */           // update unsafe row buffer
/* 455 */           if (!agg_isNull5) {
/* 456 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 457 */           } else {
/* 458 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 459 */           }
/* 460 */
/* 461 */         }
/* 462 */         // shouldStop check is eliminated
/* 463 */       }
/* 464 */       scan_batchIdx = scan_numRows;
/* 465 */       scan_batch = null;
/* 466 */       scan_nextBatch();
/* 467 */     }
/* 468 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 469 */     scan_scanTime1 = 0;
/* 470 */
/* 471 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 472 */
/* 473 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 474 */   }
/* 475 */
/* 476 */   private void wholestagecodegen_init_2() {
/* 477 */     project_result1 = new UnsafeRow(4);
/* 478 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 479 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 480 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 481 */
/* 482 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 483 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 484 */
/* 485 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 486 */     bhj_result1 = new UnsafeRow(5);
/* 487 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 488 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 5);
/* 489 */     project_result2 = new UnsafeRow(3);
/* 490 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 491 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 3);
/* 492 */
/* 493 */   }
/* 494 */
/* 495 */   private void wholestagecodegen_init_1() {
/* 496 */     filter_result = new UnsafeRow(4);
/* 497 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 498 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 499 */     project_result = new UnsafeRow(4);
/* 500 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 501 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 502 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 503 */
/* 504 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 505 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 506 */
/* 507 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 508 */     bhj_result = new UnsafeRow(5);
/* 509 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 510 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 511 */
/* 512 */   }
/* 513 */
/* 514 */   protected void processNext() throws java.io.IOException {
/* 515 */     if (!agg_initAgg) {
/* 516 */       agg_initAgg = true;
/* 517 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 518 */       agg_doAggregateWithKeys();
/* 519 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 520 */     }
/* 521 */
/* 522 */     // output the result
/* 523 */
/* 524 */     while (agg_fastHashMapIter.next()) {
/* 525 */       wholestagecodegen_numOutputRows.add(1);
/* 526 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 527 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 528 */
/* 529 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 530 */
/* 531 */       append(agg_resultRow);
/* 532 */
/* 533 */       if (shouldStop()) return;
/* 534 */     }
/* 535 */     agg_fastHashMap.close();
/* 536 */
/* 537 */     while (agg_mapIter.next()) {
/* 538 */       wholestagecodegen_numOutputRows.add(1);
/* 539 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 540 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 541 */
/* 542 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 543 */
/* 544 */       append(agg_resultRow);
/* 545 */
/* 546 */       if (shouldStop()) return;
/* 547 */     }
/* 548 */
/* 549 */     agg_mapIter.close();
/* 550 */     if (agg_sorter == null) {
/* 551 */       agg_hashMap.free();
/* 552 */     }
/* 553 */   }
/* 554 */ }

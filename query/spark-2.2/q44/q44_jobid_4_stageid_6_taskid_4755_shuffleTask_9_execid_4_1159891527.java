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
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private long agg_bufValue3;
/* 017 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 018 */   private agg_FastHashMap agg_fastHashMap;
/* 019 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 020 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 021 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 022 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 025 */   private scala.collection.Iterator scan_input;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 028 */   private long scan_scanTime1;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 030 */   private int scan_batchIdx;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 035 */   private UnsafeRow scan_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 039 */   private UnsafeRow filter_result;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 042 */   private UnsafeRow project_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 045 */   private UnsafeRow agg_result1;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 048 */   private int agg_value12;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 052 */
/* 053 */   public GeneratedIterator(Object[] references) {
/* 054 */     this.references = references;
/* 055 */   }
/* 056 */
/* 057 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 058 */     partitionIndex = index;
/* 059 */     this.inputs = inputs;
/* 060 */     wholestagecodegen_init_0();
/* 061 */     wholestagecodegen_init_1();
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */   private void wholestagecodegen_init_0() {
/* 066 */     agg_initAgg = false;
/* 067 */
/* 068 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 069 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 070 */
/* 071 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 072 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 073 */     scan_input = inputs[0];
/* 074 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 075 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 076 */     scan_scanTime1 = 0;
/* 077 */     scan_batch = null;
/* 078 */     scan_batchIdx = 0;
/* 079 */     scan_colInstance0 = null;
/* 080 */     scan_colInstance1 = null;
/* 081 */     scan_colInstance2 = null;
/* 082 */     scan_colInstance3 = null;
/* 083 */     scan_result = new UnsafeRow(4);
/* 084 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 085 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 086 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
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
/* 098 */       scan_colInstance2 = scan_batch.column(2);
/* 099 */       scan_colInstance3 = scan_batch.column(3);
/* 100 */
/* 101 */     }
/* 102 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 103 */   }
/* 104 */
/* 105 */   public class agg_FastHashMap {
/* 106 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 107 */     private int[] buckets;
/* 108 */     private int capacity = 1 << 16;
/* 109 */     private double loadFactor = 0.5;
/* 110 */     private int numBuckets = (int) (capacity / loadFactor);
/* 111 */     private int maxSteps = 2;
/* 112 */     private int numRows = 0;
/* 113 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 114 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 115 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.LongType)
/* 116 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 117 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.LongType);
/* 118 */     private Object emptyVBase;
/* 119 */     private long emptyVOff;
/* 120 */     private int emptyVLen;
/* 121 */     private boolean isBatchFull = false;
/* 122 */
/* 123 */     public agg_FastHashMap(
/* 124 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 125 */       InternalRow emptyAggregationBuffer) {
/* 126 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 127 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 128 */
/* 129 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 130 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 131 */
/* 132 */       emptyVBase = emptyBuffer;
/* 133 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 134 */       emptyVLen = emptyBuffer.length;
/* 135 */
/* 136 */       buckets = new int[numBuckets];
/* 137 */       java.util.Arrays.fill(buckets, -1);
/* 138 */     }
/* 139 */
/* 140 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 141 */       long h = hash(agg_key);
/* 142 */       int step = 0;
/* 143 */       int idx = (int) h & (numBuckets - 1);
/* 144 */       while (step < maxSteps) {
/* 145 */         // Return bucket index if it's either an empty slot or already contains the key
/* 146 */         if (buckets[idx] == -1) {
/* 147 */           if (numRows < capacity && !isBatchFull) {
/* 148 */             // creating the unsafe for new entry
/* 149 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 150 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 151 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 152 */               0);
/* 153 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 154 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 155 */               agg_holder,
/* 156 */               1);
/* 157 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 158 */             agg_rowWriter.zeroOutNullBytes();
/* 159 */             agg_rowWriter.write(0, agg_key);
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
/* 177 */         } else if (equals(idx, agg_key)) {
/* 178 */           return batch.getValueRow(buckets[idx]);
/* 179 */         }
/* 180 */         idx = (idx + 1) & (numBuckets - 1);
/* 181 */         step++;
/* 182 */       }
/* 183 */       // Didn't find it
/* 184 */       return null;
/* 185 */     }
/* 186 */
/* 187 */     private boolean equals(int idx, int agg_key) {
/* 188 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 189 */       return (row.getInt(0) == agg_key);
/* 190 */     }
/* 191 */
/* 192 */     private long hash(int agg_key) {
/* 193 */       long agg_hash = 0;
/* 194 */
/* 195 */       int agg_result = agg_key;
/* 196 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 197 */
/* 198 */       return agg_hash;
/* 199 */     }
/* 200 */
/* 201 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 202 */       return batch.rowIterator();
/* 203 */     }
/* 204 */
/* 205 */     public void close() {
/* 206 */       batch.close();
/* 207 */     }
/* 208 */
/* 209 */   }
/* 210 */
/* 211 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 212 */     agg_hashMap = agg_plan.createHashMap();
/* 213 */
/* 214 */     if (scan_batch == null) {
/* 215 */       scan_nextBatch();
/* 216 */     }
/* 217 */     while (scan_batch != null) {
/* 218 */       int scan_numRows = scan_batch.numRows();
/* 219 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 220 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 221 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 222 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 223 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 224 */
/* 225 */         if (!(!(scan_isNull1))) continue;
/* 226 */
/* 227 */         boolean filter_isNull2 = false;
/* 228 */
/* 229 */         boolean filter_value2 = false;
/* 230 */         filter_value2 = scan_value1 == 4;
/* 231 */         if (!filter_value2) continue;
/* 232 */
/* 233 */         filter_numOutputRows.add(1);
/* 234 */
/* 235 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 236 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 237 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 238 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 239 */
/* 240 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 241 */
/* 242 */         UnsafeRow agg_fastAggBuffer = null;
/* 243 */
/* 244 */         if (true) {
/* 245 */           if (!scan_isNull) {
/* 246 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 247 */               scan_value);
/* 248 */           }
/* 249 */         }
/* 250 */
/* 251 */         if (agg_fastAggBuffer == null) {
/* 252 */           // generate grouping key
/* 253 */           agg_rowWriter.zeroOutNullBytes();
/* 254 */
/* 255 */           if (scan_isNull) {
/* 256 */             agg_rowWriter.setNullAt(0);
/* 257 */           } else {
/* 258 */             agg_rowWriter.write(0, scan_value);
/* 259 */           }
/* 260 */           agg_value12 = 42;
/* 261 */
/* 262 */           if (!scan_isNull) {
/* 263 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value, agg_value12);
/* 264 */           }
/* 265 */           if (true) {
/* 266 */             // try to get the buffer from hash map
/* 267 */             agg_unsafeRowAggBuffer =
/* 268 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value12);
/* 269 */           }
/* 270 */           if (agg_unsafeRowAggBuffer == null) {
/* 271 */             if (agg_sorter == null) {
/* 272 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 273 */             } else {
/* 274 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 275 */             }
/* 276 */
/* 277 */             // the hash map had be spilled, it should have enough memory now,
/* 278 */             // try  to allocate buffer again.
/* 279 */             agg_unsafeRowAggBuffer =
/* 280 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value12);
/* 281 */             if (agg_unsafeRowAggBuffer == null) {
/* 282 */               // failed to allocate the first page
/* 283 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 284 */             }
/* 285 */           }
/* 286 */         }
/* 287 */
/* 288 */         if (agg_fastAggBuffer != null) {
/* 289 */           // update fast row
/* 290 */
/* 291 */           // common sub-expressions
/* 292 */           boolean agg_isNull30 = scan_isNull2;
/* 293 */           double agg_value34 = scan_value2;
/* 294 */           if (agg_isNull30) {
/* 295 */             boolean agg_isNull32 = false;
/* 296 */             double agg_value36 = -1.0;
/* 297 */             if (!false) {
/* 298 */               agg_value36 = (double) 0;
/* 299 */             }
/* 300 */             if (!agg_isNull32) {
/* 301 */               agg_isNull30 = false;
/* 302 */               agg_value34 = agg_value36;
/* 303 */             }
/* 304 */           }
/* 305 */
/* 306 */           // evaluate aggregate function
/* 307 */           boolean agg_isNull36 = true;
/* 308 */           double agg_value40 = -1.0;
/* 309 */
/* 310 */           boolean agg_isNull37 = agg_fastAggBuffer.isNullAt(0);
/* 311 */           double agg_value41 = agg_isNull37 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 312 */           if (!agg_isNull37) {
/* 313 */             agg_isNull36 = false; // resultCode could change nullability.
/* 314 */             agg_value40 = agg_value41 + agg_value34;
/* 315 */
/* 316 */           }
/* 317 */           boolean agg_isNull38 = false;
/* 318 */           long agg_value42 = -1L;
/* 319 */           if (!false && scan_isNull2) {
/* 320 */             boolean agg_isNull39 = agg_fastAggBuffer.isNullAt(1);
/* 321 */             long agg_value43 = agg_isNull39 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 322 */             agg_isNull38 = agg_isNull39;
/* 323 */             agg_value42 = agg_value43;
/* 324 */           } else {
/* 325 */             boolean agg_isNull40 = true;
/* 326 */             long agg_value44 = -1L;
/* 327 */
/* 328 */             boolean agg_isNull41 = agg_fastAggBuffer.isNullAt(1);
/* 329 */             long agg_value45 = agg_isNull41 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 330 */             if (!agg_isNull41) {
/* 331 */               agg_isNull40 = false; // resultCode could change nullability.
/* 332 */               agg_value44 = agg_value45 + 1L;
/* 333 */
/* 334 */             }
/* 335 */             agg_isNull38 = agg_isNull40;
/* 336 */             agg_value42 = agg_value44;
/* 337 */           }
/* 338 */           boolean agg_isNull43 = true;
/* 339 */           double agg_value47 = -1.0;
/* 340 */
/* 341 */           boolean agg_isNull44 = agg_fastAggBuffer.isNullAt(2);
/* 342 */           double agg_value48 = agg_isNull44 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 343 */           if (!agg_isNull44) {
/* 344 */             agg_isNull43 = false; // resultCode could change nullability.
/* 345 */             agg_value47 = agg_value48 + agg_value34;
/* 346 */
/* 347 */           }
/* 348 */           boolean agg_isNull45 = false;
/* 349 */           long agg_value49 = -1L;
/* 350 */           if (!false && scan_isNull2) {
/* 351 */             boolean agg_isNull46 = agg_fastAggBuffer.isNullAt(3);
/* 352 */             long agg_value50 = agg_isNull46 ? -1L : (agg_fastAggBuffer.getLong(3));
/* 353 */             agg_isNull45 = agg_isNull46;
/* 354 */             agg_value49 = agg_value50;
/* 355 */           } else {
/* 356 */             boolean agg_isNull47 = true;
/* 357 */             long agg_value51 = -1L;
/* 358 */
/* 359 */             boolean agg_isNull48 = agg_fastAggBuffer.isNullAt(3);
/* 360 */             long agg_value52 = agg_isNull48 ? -1L : (agg_fastAggBuffer.getLong(3));
/* 361 */             if (!agg_isNull48) {
/* 362 */               agg_isNull47 = false; // resultCode could change nullability.
/* 363 */               agg_value51 = agg_value52 + 1L;
/* 364 */
/* 365 */             }
/* 366 */             agg_isNull45 = agg_isNull47;
/* 367 */             agg_value49 = agg_value51;
/* 368 */           }
/* 369 */           // update fast row
/* 370 */           if (!agg_isNull36) {
/* 371 */             agg_fastAggBuffer.setDouble(0, agg_value40);
/* 372 */           } else {
/* 373 */             agg_fastAggBuffer.setNullAt(0);
/* 374 */           }
/* 375 */
/* 376 */           if (!agg_isNull38) {
/* 377 */             agg_fastAggBuffer.setLong(1, agg_value42);
/* 378 */           } else {
/* 379 */             agg_fastAggBuffer.setNullAt(1);
/* 380 */           }
/* 381 */
/* 382 */           if (!agg_isNull43) {
/* 383 */             agg_fastAggBuffer.setDouble(2, agg_value47);
/* 384 */           } else {
/* 385 */             agg_fastAggBuffer.setNullAt(2);
/* 386 */           }
/* 387 */
/* 388 */           if (!agg_isNull45) {
/* 389 */             agg_fastAggBuffer.setLong(3, agg_value49);
/* 390 */           } else {
/* 391 */             agg_fastAggBuffer.setNullAt(3);
/* 392 */           }
/* 393 */
/* 394 */         } else {
/* 395 */           // update unsafe row
/* 396 */
/* 397 */           // common sub-expressions
/* 398 */           boolean agg_isNull10 = scan_isNull2;
/* 399 */           double agg_value14 = scan_value2;
/* 400 */           if (agg_isNull10) {
/* 401 */             boolean agg_isNull12 = false;
/* 402 */             double agg_value16 = -1.0;
/* 403 */             if (!false) {
/* 404 */               agg_value16 = (double) 0;
/* 405 */             }
/* 406 */             if (!agg_isNull12) {
/* 407 */               agg_isNull10 = false;
/* 408 */               agg_value14 = agg_value16;
/* 409 */             }
/* 410 */           }
/* 411 */
/* 412 */           // evaluate aggregate function
/* 413 */           boolean agg_isNull16 = true;
/* 414 */           double agg_value20 = -1.0;
/* 415 */
/* 416 */           boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 417 */           double agg_value21 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 418 */           if (!agg_isNull17) {
/* 419 */             agg_isNull16 = false; // resultCode could change nullability.
/* 420 */             agg_value20 = agg_value21 + agg_value14;
/* 421 */
/* 422 */           }
/* 423 */           boolean agg_isNull18 = false;
/* 424 */           long agg_value22 = -1L;
/* 425 */           if (!false && scan_isNull2) {
/* 426 */             boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 427 */             long agg_value23 = agg_isNull19 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 428 */             agg_isNull18 = agg_isNull19;
/* 429 */             agg_value22 = agg_value23;
/* 430 */           } else {
/* 431 */             boolean agg_isNull20 = true;
/* 432 */             long agg_value24 = -1L;
/* 433 */
/* 434 */             boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 435 */             long agg_value25 = agg_isNull21 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 436 */             if (!agg_isNull21) {
/* 437 */               agg_isNull20 = false; // resultCode could change nullability.
/* 438 */               agg_value24 = agg_value25 + 1L;
/* 439 */
/* 440 */             }
/* 441 */             agg_isNull18 = agg_isNull20;
/* 442 */             agg_value22 = agg_value24;
/* 443 */           }
/* 444 */           boolean agg_isNull23 = true;
/* 445 */           double agg_value27 = -1.0;
/* 446 */
/* 447 */           boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 448 */           double agg_value28 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 449 */           if (!agg_isNull24) {
/* 450 */             agg_isNull23 = false; // resultCode could change nullability.
/* 451 */             agg_value27 = agg_value28 + agg_value14;
/* 452 */
/* 453 */           }
/* 454 */           boolean agg_isNull25 = false;
/* 455 */           long agg_value29 = -1L;
/* 456 */           if (!false && scan_isNull2) {
/* 457 */             boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 458 */             long agg_value30 = agg_isNull26 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 459 */             agg_isNull25 = agg_isNull26;
/* 460 */             agg_value29 = agg_value30;
/* 461 */           } else {
/* 462 */             boolean agg_isNull27 = true;
/* 463 */             long agg_value31 = -1L;
/* 464 */
/* 465 */             boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 466 */             long agg_value32 = agg_isNull28 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 467 */             if (!agg_isNull28) {
/* 468 */               agg_isNull27 = false; // resultCode could change nullability.
/* 469 */               agg_value31 = agg_value32 + 1L;
/* 470 */
/* 471 */             }
/* 472 */             agg_isNull25 = agg_isNull27;
/* 473 */             agg_value29 = agg_value31;
/* 474 */           }
/* 475 */           // update unsafe row buffer
/* 476 */           if (!agg_isNull16) {
/* 477 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value20);
/* 478 */           } else {
/* 479 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 480 */           }
/* 481 */
/* 482 */           if (!agg_isNull18) {
/* 483 */             agg_unsafeRowAggBuffer.setLong(1, agg_value22);
/* 484 */           } else {
/* 485 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 486 */           }
/* 487 */
/* 488 */           if (!agg_isNull23) {
/* 489 */             agg_unsafeRowAggBuffer.setDouble(2, agg_value27);
/* 490 */           } else {
/* 491 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 492 */           }
/* 493 */
/* 494 */           if (!agg_isNull25) {
/* 495 */             agg_unsafeRowAggBuffer.setLong(3, agg_value29);
/* 496 */           } else {
/* 497 */             agg_unsafeRowAggBuffer.setNullAt(3);
/* 498 */           }
/* 499 */
/* 500 */         }
/* 501 */         // shouldStop check is eliminated
/* 502 */       }
/* 503 */       scan_batchIdx = scan_numRows;
/* 504 */       scan_batch = null;
/* 505 */       scan_nextBatch();
/* 506 */     }
/* 507 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 508 */     scan_scanTime1 = 0;
/* 509 */
/* 510 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 511 */
/* 512 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 513 */   }
/* 514 */
/* 515 */   private void wholestagecodegen_init_1() {
/* 516 */     filter_result = new UnsafeRow(4);
/* 517 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 518 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 519 */     project_result = new UnsafeRow(2);
/* 520 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 521 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 522 */     agg_result1 = new UnsafeRow(1);
/* 523 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 524 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 525 */
/* 526 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 527 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 528 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 529 */
/* 530 */   }
/* 531 */
/* 532 */   protected void processNext() throws java.io.IOException {
/* 533 */     if (!agg_initAgg) {
/* 534 */       agg_initAgg = true;
/* 535 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 536 */       agg_doAggregateWithKeys();
/* 537 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 538 */     }
/* 539 */
/* 540 */     // output the result
/* 541 */
/* 542 */     while (agg_fastHashMapIter.next()) {
/* 543 */       wholestagecodegen_numOutputRows.add(1);
/* 544 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 545 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 546 */
/* 547 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 548 */
/* 549 */       append(agg_resultRow);
/* 550 */
/* 551 */       if (shouldStop()) return;
/* 552 */     }
/* 553 */     agg_fastHashMap.close();
/* 554 */
/* 555 */     while (agg_mapIter.next()) {
/* 556 */       wholestagecodegen_numOutputRows.add(1);
/* 557 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 558 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 559 */
/* 560 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 561 */
/* 562 */       append(agg_resultRow);
/* 563 */
/* 564 */       if (shouldStop()) return;
/* 565 */     }
/* 566 */
/* 567 */     agg_mapIter.close();
/* 568 */     if (agg_sorter == null) {
/* 569 */       agg_hashMap.free();
/* 570 */     }
/* 571 */   }
/* 572 */ }

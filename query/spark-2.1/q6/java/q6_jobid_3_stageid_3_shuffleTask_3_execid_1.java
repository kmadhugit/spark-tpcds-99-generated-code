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
/* 039 */   private UnsafeRow agg_result1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 042 */   private int agg_value7;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 044 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 046 */
/* 047 */   public GeneratedIterator(Object[] references) {
/* 048 */     this.references = references;
/* 049 */   }
/* 050 */
/* 051 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 052 */     partitionIndex = index;
/* 053 */     this.inputs = inputs;
/* 054 */     wholestagecodegen_init_0();
/* 055 */     wholestagecodegen_init_1();
/* 056 */
/* 057 */   }
/* 058 */
/* 059 */   private void wholestagecodegen_init_0() {
/* 060 */     agg_initAgg = false;
/* 061 */
/* 062 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 063 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 064 */
/* 065 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 066 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 067 */     scan_input = inputs[0];
/* 068 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 069 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 070 */     scan_scanTime1 = 0;
/* 071 */     scan_batch = null;
/* 072 */     scan_batchIdx = 0;
/* 073 */     scan_colInstance0 = null;
/* 074 */     scan_colInstance1 = null;
/* 075 */     scan_result = new UnsafeRow(2);
/* 076 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 077 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 2);
/* 078 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 079 */
/* 080 */   }
/* 081 */
/* 082 */   private void scan_nextBatch() throws java.io.IOException {
/* 083 */     long getBatchStart = System.nanoTime();
/* 084 */     if (scan_input.hasNext()) {
/* 085 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 086 */       scan_numOutputRows.add(scan_batch.numRows());
/* 087 */       scan_batchIdx = 0;
/* 088 */       scan_colInstance0 = scan_batch.column(0);
/* 089 */       scan_colInstance1 = scan_batch.column(1);
/* 090 */
/* 091 */     }
/* 092 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 093 */   }
/* 094 */
/* 095 */   public class agg_FastHashMap {
/* 096 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 097 */     private int[] buckets;
/* 098 */     private int capacity = 1 << 16;
/* 099 */     private double loadFactor = 0.5;
/* 100 */     private int numBuckets = (int) (capacity / loadFactor);
/* 101 */     private int maxSteps = 2;
/* 102 */     private int numRows = 0;
/* 103 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("i_category", org.apache.spark.sql.types.DataTypes.StringType);
/* 104 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 105 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType);
/* 106 */     private Object emptyVBase;
/* 107 */     private long emptyVOff;
/* 108 */     private int emptyVLen;
/* 109 */     private boolean isBatchFull = false;
/* 110 */
/* 111 */     public agg_FastHashMap(
/* 112 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 113 */       InternalRow emptyAggregationBuffer) {
/* 114 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 115 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 116 */
/* 117 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 118 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 119 */
/* 120 */       emptyVBase = emptyBuffer;
/* 121 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 122 */       emptyVLen = emptyBuffer.length;
/* 123 */
/* 124 */       buckets = new int[numBuckets];
/* 125 */       java.util.Arrays.fill(buckets, -1);
/* 126 */     }
/* 127 */
/* 128 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key) {
/* 129 */       long h = hash(agg_key);
/* 130 */       int step = 0;
/* 131 */       int idx = (int) h & (numBuckets - 1);
/* 132 */       while (step < maxSteps) {
/* 133 */         // Return bucket index if it's either an empty slot or already contains the key
/* 134 */         if (buckets[idx] == -1) {
/* 135 */           if (numRows < capacity && !isBatchFull) {
/* 136 */             // creating the unsafe for new entry
/* 137 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 138 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 139 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 140 */               32);
/* 141 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 142 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 143 */               agg_holder,
/* 144 */               1);
/* 145 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 146 */             agg_rowWriter.zeroOutNullBytes();
/* 147 */             agg_rowWriter.write(0, agg_key);
/* 148 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 149 */             Object kbase = agg_result.getBaseObject();
/* 150 */             long koff = agg_result.getBaseOffset();
/* 151 */             int klen = agg_result.getSizeInBytes();
/* 152 */
/* 153 */             UnsafeRow vRow
/* 154 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 155 */             if (vRow == null) {
/* 156 */               isBatchFull = true;
/* 157 */             } else {
/* 158 */               buckets[idx] = numRows++;
/* 159 */             }
/* 160 */             return vRow;
/* 161 */           } else {
/* 162 */             // No more space
/* 163 */             return null;
/* 164 */           }
/* 165 */         } else if (equals(idx, agg_key)) {
/* 166 */           return batch.getValueRow(buckets[idx]);
/* 167 */         }
/* 168 */         idx = (idx + 1) & (numBuckets - 1);
/* 169 */         step++;
/* 170 */       }
/* 171 */       // Didn't find it
/* 172 */       return null;
/* 173 */     }
/* 174 */
/* 175 */     private boolean equals(int idx, UTF8String agg_key) {
/* 176 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 177 */       return (row.getUTF8String(0).equals(agg_key));
/* 178 */     }
/* 179 */
/* 180 */     private long hash(UTF8String agg_key) {
/* 181 */       long agg_hash = 0;
/* 182 */
/* 183 */       int agg_result = 0;
/* 184 */       byte[] agg_bytes = agg_key.getBytes();
/* 185 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 186 */         int agg_hash1 = agg_bytes[i];
/* 187 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 188 */       }
/* 189 */
/* 190 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 191 */
/* 192 */       return agg_hash;
/* 193 */     }
/* 194 */
/* 195 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 196 */       return batch.rowIterator();
/* 197 */     }
/* 198 */
/* 199 */     public void close() {
/* 200 */       batch.close();
/* 201 */     }
/* 202 */
/* 203 */   }
/* 204 */
/* 205 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 206 */     agg_hashMap = agg_plan.createHashMap();
/* 207 */
/* 208 */     if (scan_batch == null) {
/* 209 */       scan_nextBatch();
/* 210 */     }
/* 211 */     while (scan_batch != null) {
/* 212 */       int numRows = scan_batch.numRows();
/* 213 */       while (scan_batchIdx < numRows) {
/* 214 */         int scan_rowIdx = scan_batchIdx++;
/* 215 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 216 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 217 */
/* 218 */         if (!(!(scan_isNull1))) continue;
/* 219 */
/* 220 */         filter_numOutputRows.add(1);
/* 221 */
/* 222 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 223 */         double scan_value = scan_isNull ? -1.0 : (scan_colInstance0.getDouble(scan_rowIdx));
/* 224 */
/* 225 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 226 */
/* 227 */         UnsafeRow agg_fastAggBuffer = null;
/* 228 */
/* 229 */         if (true) {
/* 230 */           if (!false) {
/* 231 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 232 */               scan_value1);
/* 233 */           }
/* 234 */         }
/* 235 */
/* 236 */         if (agg_fastAggBuffer == null) {
/* 237 */           // generate grouping key
/* 238 */           agg_holder.reset();
/* 239 */
/* 240 */           agg_rowWriter.write(0, scan_value1);
/* 241 */           agg_result1.setTotalSize(agg_holder.totalSize());
/* 242 */           agg_value7 = 42;
/* 243 */
/* 244 */           if (!false) {
/* 245 */             agg_value7 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value1.getBaseObject(), scan_value1.getBaseOffset(), scan_value1.numBytes(), agg_value7);
/* 246 */           }
/* 247 */           if (true) {
/* 248 */             // try to get the buffer from hash map
/* 249 */             agg_unsafeRowAggBuffer =
/* 250 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value7);
/* 251 */           }
/* 252 */           if (agg_unsafeRowAggBuffer == null) {
/* 253 */             if (agg_sorter == null) {
/* 254 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 255 */             } else {
/* 256 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 257 */             }
/* 258 */
/* 259 */             // the hash map had be spilled, it should have enough memory now,
/* 260 */             // try  to allocate buffer again.
/* 261 */             agg_unsafeRowAggBuffer =
/* 262 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value7);
/* 263 */             if (agg_unsafeRowAggBuffer == null) {
/* 264 */               // failed to allocate the first page
/* 265 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 266 */             }
/* 267 */           }
/* 268 */         }
/* 269 */
/* 270 */         if (agg_fastAggBuffer != null) {
/* 271 */           // update fast row
/* 272 */
/* 273 */           // common sub-expressions
/* 274 */
/* 275 */           // evaluate aggregate function
/* 276 */           boolean agg_isNull21 = true;
/* 277 */           double agg_value23 = -1.0;
/* 278 */
/* 279 */           boolean agg_isNull22 = agg_fastAggBuffer.isNullAt(0);
/* 280 */           double agg_value24 = agg_isNull22 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 281 */           if (!agg_isNull22) {
/* 282 */             boolean agg_isNull24 = scan_isNull;
/* 283 */             double agg_value26 = -1.0;
/* 284 */             if (!scan_isNull) {
/* 285 */               agg_value26 = scan_value;
/* 286 */             }
/* 287 */             boolean agg_isNull23 = agg_isNull24;
/* 288 */             double agg_value25 = agg_value26;
/* 289 */             if (agg_isNull23) {
/* 290 */               boolean agg_isNull26 = false;
/* 291 */               double agg_value28 = -1.0;
/* 292 */               if (!false) {
/* 293 */                 agg_value28 = (double) 0;
/* 294 */               }
/* 295 */               if (!agg_isNull26) {
/* 296 */                 agg_isNull23 = false;
/* 297 */                 agg_value25 = agg_value28;
/* 298 */               }
/* 299 */             }
/* 300 */
/* 301 */             agg_isNull21 = false; // resultCode could change nullability.
/* 302 */             agg_value23 = agg_value24 + agg_value25;
/* 303 */
/* 304 */           }
/* 305 */           boolean agg_isNull28 = false;
/* 306 */           long agg_value30 = -1L;
/* 307 */           if (!false && scan_isNull) {
/* 308 */             boolean agg_isNull31 = agg_fastAggBuffer.isNullAt(1);
/* 309 */             long agg_value33 = agg_isNull31 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 310 */             agg_isNull28 = agg_isNull31;
/* 311 */             agg_value30 = agg_value33;
/* 312 */           } else {
/* 313 */             boolean agg_isNull32 = true;
/* 314 */             long agg_value34 = -1L;
/* 315 */
/* 316 */             boolean agg_isNull33 = agg_fastAggBuffer.isNullAt(1);
/* 317 */             long agg_value35 = agg_isNull33 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 318 */             if (!agg_isNull33) {
/* 319 */               agg_isNull32 = false; // resultCode could change nullability.
/* 320 */               agg_value34 = agg_value35 + 1L;
/* 321 */
/* 322 */             }
/* 323 */             agg_isNull28 = agg_isNull32;
/* 324 */             agg_value30 = agg_value34;
/* 325 */           }
/* 326 */           // update fast row
/* 327 */           if (!agg_isNull21) {
/* 328 */             agg_fastAggBuffer.setDouble(0, agg_value23);
/* 329 */           } else {
/* 330 */             agg_fastAggBuffer.setNullAt(0);
/* 331 */           }
/* 332 */
/* 333 */           if (!agg_isNull28) {
/* 334 */             agg_fastAggBuffer.setLong(1, agg_value30);
/* 335 */           } else {
/* 336 */             agg_fastAggBuffer.setNullAt(1);
/* 337 */           }
/* 338 */
/* 339 */         } else {
/* 340 */           // update unsafe row
/* 341 */
/* 342 */           // common sub-expressions
/* 343 */
/* 344 */           // evaluate aggregate function
/* 345 */           boolean agg_isNull7 = true;
/* 346 */           double agg_value9 = -1.0;
/* 347 */
/* 348 */           boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 349 */           double agg_value10 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 350 */           if (!agg_isNull8) {
/* 351 */             boolean agg_isNull10 = scan_isNull;
/* 352 */             double agg_value12 = -1.0;
/* 353 */             if (!scan_isNull) {
/* 354 */               agg_value12 = scan_value;
/* 355 */             }
/* 356 */             boolean agg_isNull9 = agg_isNull10;
/* 357 */             double agg_value11 = agg_value12;
/* 358 */             if (agg_isNull9) {
/* 359 */               boolean agg_isNull12 = false;
/* 360 */               double agg_value14 = -1.0;
/* 361 */               if (!false) {
/* 362 */                 agg_value14 = (double) 0;
/* 363 */               }
/* 364 */               if (!agg_isNull12) {
/* 365 */                 agg_isNull9 = false;
/* 366 */                 agg_value11 = agg_value14;
/* 367 */               }
/* 368 */             }
/* 369 */
/* 370 */             agg_isNull7 = false; // resultCode could change nullability.
/* 371 */             agg_value9 = agg_value10 + agg_value11;
/* 372 */
/* 373 */           }
/* 374 */           boolean agg_isNull14 = false;
/* 375 */           long agg_value16 = -1L;
/* 376 */           if (!false && scan_isNull) {
/* 377 */             boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 378 */             long agg_value19 = agg_isNull17 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 379 */             agg_isNull14 = agg_isNull17;
/* 380 */             agg_value16 = agg_value19;
/* 381 */           } else {
/* 382 */             boolean agg_isNull18 = true;
/* 383 */             long agg_value20 = -1L;
/* 384 */
/* 385 */             boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 386 */             long agg_value21 = agg_isNull19 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 387 */             if (!agg_isNull19) {
/* 388 */               agg_isNull18 = false; // resultCode could change nullability.
/* 389 */               agg_value20 = agg_value21 + 1L;
/* 390 */
/* 391 */             }
/* 392 */             agg_isNull14 = agg_isNull18;
/* 393 */             agg_value16 = agg_value20;
/* 394 */           }
/* 395 */           // update unsafe row buffer
/* 396 */           if (!agg_isNull7) {
/* 397 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 398 */           } else {
/* 399 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 400 */           }
/* 401 */
/* 402 */           if (!agg_isNull14) {
/* 403 */             agg_unsafeRowAggBuffer.setLong(1, agg_value16);
/* 404 */           } else {
/* 405 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 406 */           }
/* 407 */
/* 408 */         }
/* 409 */         if (shouldStop()) return;
/* 410 */       }
/* 411 */       scan_batch = null;
/* 412 */       scan_nextBatch();
/* 413 */     }
/* 414 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 415 */     scan_scanTime1 = 0;
/* 416 */
/* 417 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 418 */
/* 419 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 420 */   }
/* 421 */
/* 422 */   private void wholestagecodegen_init_1() {
/* 423 */     filter_result = new UnsafeRow(2);
/* 424 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 425 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 426 */     project_result = new UnsafeRow(2);
/* 427 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 428 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 429 */     agg_result1 = new UnsafeRow(1);
/* 430 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 431 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 432 */
/* 433 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 434 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 435 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 436 */
/* 437 */   }
/* 438 */
/* 439 */   protected void processNext() throws java.io.IOException {
/* 440 */     if (!agg_initAgg) {
/* 441 */       agg_initAgg = true;
/* 442 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 443 */       agg_doAggregateWithKeys();
/* 444 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 445 */     }
/* 446 */
/* 447 */     // output the result
/* 448 */
/* 449 */     while (agg_fastHashMapIter.next()) {
/* 450 */       wholestagecodegen_numOutputRows.add(1);
/* 451 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 452 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 453 */
/* 454 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 455 */
/* 456 */       append(agg_resultRow);
/* 457 */
/* 458 */       if (shouldStop()) return;
/* 459 */     }
/* 460 */     agg_fastHashMap.close();
/* 461 */
/* 462 */     while (agg_mapIter.next()) {
/* 463 */       wholestagecodegen_numOutputRows.add(1);
/* 464 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 465 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 466 */
/* 467 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 468 */
/* 469 */       append(agg_resultRow);
/* 470 */
/* 471 */       if (shouldStop()) return;
/* 472 */     }
/* 473 */
/* 474 */     agg_mapIter.close();
/* 475 */     if (agg_sorter == null) {
/* 476 */       agg_hashMap.free();
/* 477 */     }
/* 478 */   }
/* 479 */ }

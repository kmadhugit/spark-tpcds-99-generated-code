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
/* 068 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 069 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 070 */     scan_scanTime1 = 0;
/* 071 */     scan_batch = null;
/* 072 */     scan_batchIdx = 0;
/* 073 */     scan_colInstance0 = null;
/* 074 */     scan_colInstance1 = null;
/* 075 */     scan_result = new UnsafeRow(2);
/* 076 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 077 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 2);
/* 078 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
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
/* 103 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType);
/* 104 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 105 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.LongType);
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
/* 212 */       int scan_numRows = scan_batch.numRows();
/* 213 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 214 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 215 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 216 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 217 */         UTF8String scan_value1 = scan_isNull1 ? null : (scan_colInstance1.getUTF8String(scan_rowIdx));
/* 218 */
/* 219 */         if (!(!(scan_isNull1))) continue;
/* 220 */
/* 221 */         filter_numOutputRows.add(1);
/* 222 */
/* 223 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 224 */         double scan_value = scan_isNull ? -1.0 : (scan_colInstance0.getDouble(scan_rowIdx));
/* 225 */
/* 226 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 227 */
/* 228 */         UnsafeRow agg_fastAggBuffer = null;
/* 229 */
/* 230 */         if (true) {
/* 231 */           if (!false) {
/* 232 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 233 */               scan_value1);
/* 234 */           }
/* 235 */         }
/* 236 */
/* 237 */         if (agg_fastAggBuffer == null) {
/* 238 */           // generate grouping key
/* 239 */           agg_holder.reset();
/* 240 */
/* 241 */           agg_rowWriter.write(0, scan_value1);
/* 242 */           agg_result1.setTotalSize(agg_holder.totalSize());
/* 243 */           agg_value7 = 42;
/* 244 */
/* 245 */           if (!false) {
/* 246 */             agg_value7 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value1.getBaseObject(), scan_value1.getBaseOffset(), scan_value1.numBytes(), agg_value7);
/* 247 */           }
/* 248 */           if (true) {
/* 249 */             // try to get the buffer from hash map
/* 250 */             agg_unsafeRowAggBuffer =
/* 251 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value7);
/* 252 */           }
/* 253 */           if (agg_unsafeRowAggBuffer == null) {
/* 254 */             if (agg_sorter == null) {
/* 255 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 256 */             } else {
/* 257 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 258 */             }
/* 259 */
/* 260 */             // the hash map had be spilled, it should have enough memory now,
/* 261 */             // try  to allocate buffer again.
/* 262 */             agg_unsafeRowAggBuffer =
/* 263 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value7);
/* 264 */             if (agg_unsafeRowAggBuffer == null) {
/* 265 */               // failed to allocate the first page
/* 266 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 267 */             }
/* 268 */           }
/* 269 */         }
/* 270 */
/* 271 */         if (agg_fastAggBuffer != null) {
/* 272 */           // update fast row
/* 273 */
/* 274 */           // common sub-expressions
/* 275 */
/* 276 */           // evaluate aggregate function
/* 277 */           boolean agg_isNull20 = true;
/* 278 */           double agg_value22 = -1.0;
/* 279 */
/* 280 */           boolean agg_isNull21 = agg_fastAggBuffer.isNullAt(0);
/* 281 */           double agg_value23 = agg_isNull21 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 282 */           if (!agg_isNull21) {
/* 283 */             boolean agg_isNull22 = scan_isNull;
/* 284 */             double agg_value24 = scan_value;
/* 285 */             if (agg_isNull22) {
/* 286 */               boolean agg_isNull24 = false;
/* 287 */               double agg_value26 = -1.0;
/* 288 */               if (!false) {
/* 289 */                 agg_value26 = (double) 0;
/* 290 */               }
/* 291 */               if (!agg_isNull24) {
/* 292 */                 agg_isNull22 = false;
/* 293 */                 agg_value24 = agg_value26;
/* 294 */               }
/* 295 */             }
/* 296 */
/* 297 */             agg_isNull20 = false; // resultCode could change nullability.
/* 298 */             agg_value22 = agg_value23 + agg_value24;
/* 299 */
/* 300 */           }
/* 301 */           boolean agg_isNull26 = false;
/* 302 */           long agg_value28 = -1L;
/* 303 */           if (!false && scan_isNull) {
/* 304 */             boolean agg_isNull29 = agg_fastAggBuffer.isNullAt(1);
/* 305 */             long agg_value31 = agg_isNull29 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 306 */             agg_isNull26 = agg_isNull29;
/* 307 */             agg_value28 = agg_value31;
/* 308 */           } else {
/* 309 */             boolean agg_isNull30 = true;
/* 310 */             long agg_value32 = -1L;
/* 311 */
/* 312 */             boolean agg_isNull31 = agg_fastAggBuffer.isNullAt(1);
/* 313 */             long agg_value33 = agg_isNull31 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 314 */             if (!agg_isNull31) {
/* 315 */               agg_isNull30 = false; // resultCode could change nullability.
/* 316 */               agg_value32 = agg_value33 + 1L;
/* 317 */
/* 318 */             }
/* 319 */             agg_isNull26 = agg_isNull30;
/* 320 */             agg_value28 = agg_value32;
/* 321 */           }
/* 322 */           // update fast row
/* 323 */           if (!agg_isNull20) {
/* 324 */             agg_fastAggBuffer.setDouble(0, agg_value22);
/* 325 */           } else {
/* 326 */             agg_fastAggBuffer.setNullAt(0);
/* 327 */           }
/* 328 */
/* 329 */           if (!agg_isNull26) {
/* 330 */             agg_fastAggBuffer.setLong(1, agg_value28);
/* 331 */           } else {
/* 332 */             agg_fastAggBuffer.setNullAt(1);
/* 333 */           }
/* 334 */
/* 335 */         } else {
/* 336 */           // update unsafe row
/* 337 */
/* 338 */           // common sub-expressions
/* 339 */
/* 340 */           // evaluate aggregate function
/* 341 */           boolean agg_isNull7 = true;
/* 342 */           double agg_value9 = -1.0;
/* 343 */
/* 344 */           boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 345 */           double agg_value10 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 346 */           if (!agg_isNull8) {
/* 347 */             boolean agg_isNull9 = scan_isNull;
/* 348 */             double agg_value11 = scan_value;
/* 349 */             if (agg_isNull9) {
/* 350 */               boolean agg_isNull11 = false;
/* 351 */               double agg_value13 = -1.0;
/* 352 */               if (!false) {
/* 353 */                 agg_value13 = (double) 0;
/* 354 */               }
/* 355 */               if (!agg_isNull11) {
/* 356 */                 agg_isNull9 = false;
/* 357 */                 agg_value11 = agg_value13;
/* 358 */               }
/* 359 */             }
/* 360 */
/* 361 */             agg_isNull7 = false; // resultCode could change nullability.
/* 362 */             agg_value9 = agg_value10 + agg_value11;
/* 363 */
/* 364 */           }
/* 365 */           boolean agg_isNull13 = false;
/* 366 */           long agg_value15 = -1L;
/* 367 */           if (!false && scan_isNull) {
/* 368 */             boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 369 */             long agg_value18 = agg_isNull16 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 370 */             agg_isNull13 = agg_isNull16;
/* 371 */             agg_value15 = agg_value18;
/* 372 */           } else {
/* 373 */             boolean agg_isNull17 = true;
/* 374 */             long agg_value19 = -1L;
/* 375 */
/* 376 */             boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 377 */             long agg_value20 = agg_isNull18 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 378 */             if (!agg_isNull18) {
/* 379 */               agg_isNull17 = false; // resultCode could change nullability.
/* 380 */               agg_value19 = agg_value20 + 1L;
/* 381 */
/* 382 */             }
/* 383 */             agg_isNull13 = agg_isNull17;
/* 384 */             agg_value15 = agg_value19;
/* 385 */           }
/* 386 */           // update unsafe row buffer
/* 387 */           if (!agg_isNull7) {
/* 388 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 389 */           } else {
/* 390 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 391 */           }
/* 392 */
/* 393 */           if (!agg_isNull13) {
/* 394 */             agg_unsafeRowAggBuffer.setLong(1, agg_value15);
/* 395 */           } else {
/* 396 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 397 */           }
/* 398 */
/* 399 */         }
/* 400 */         // shouldStop check is eliminated
/* 401 */       }
/* 402 */       scan_batchIdx = scan_numRows;
/* 403 */       scan_batch = null;
/* 404 */       scan_nextBatch();
/* 405 */     }
/* 406 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 407 */     scan_scanTime1 = 0;
/* 408 */
/* 409 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 410 */
/* 411 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 412 */   }
/* 413 */
/* 414 */   private void wholestagecodegen_init_1() {
/* 415 */     filter_result = new UnsafeRow(2);
/* 416 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 417 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 418 */     project_result = new UnsafeRow(2);
/* 419 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 420 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 421 */     agg_result1 = new UnsafeRow(1);
/* 422 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 423 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 424 */
/* 425 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 426 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 427 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 428 */
/* 429 */   }
/* 430 */
/* 431 */   protected void processNext() throws java.io.IOException {
/* 432 */     if (!agg_initAgg) {
/* 433 */       agg_initAgg = true;
/* 434 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 435 */       agg_doAggregateWithKeys();
/* 436 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 437 */     }
/* 438 */
/* 439 */     // output the result
/* 440 */
/* 441 */     while (agg_fastHashMapIter.next()) {
/* 442 */       wholestagecodegen_numOutputRows.add(1);
/* 443 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 444 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 445 */
/* 446 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 447 */
/* 448 */       append(agg_resultRow);
/* 449 */
/* 450 */       if (shouldStop()) return;
/* 451 */     }
/* 452 */     agg_fastHashMap.close();
/* 453 */
/* 454 */     while (agg_mapIter.next()) {
/* 455 */       wholestagecodegen_numOutputRows.add(1);
/* 456 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 457 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 458 */
/* 459 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 460 */
/* 461 */       append(agg_resultRow);
/* 462 */
/* 463 */       if (shouldStop()) return;
/* 464 */     }
/* 465 */
/* 466 */     agg_mapIter.close();
/* 467 */     if (agg_sorter == null) {
/* 468 */       agg_hashMap.free();
/* 469 */     }
/* 470 */   }
/* 471 */ }

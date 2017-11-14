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
/* 021 */   private boolean agg_initAgg1;
/* 022 */   private boolean agg_bufIsNull2;
/* 023 */   private double agg_bufValue2;
/* 024 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan1;
/* 025 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap1;
/* 026 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter1;
/* 027 */   private org.apache.spark.unsafe.KVIterator agg_mapIter1;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory1;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize1;
/* 030 */   private scala.collection.Iterator inputadapter_input;
/* 031 */   private UnsafeRow agg_result1;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 034 */   private int agg_value11;
/* 035 */   private UnsafeRow agg_result2;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 038 */   private UnsafeRow agg_result3;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder2;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter2;
/* 041 */   private int agg_value32;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 047 */
/* 048 */   public GeneratedIterator(Object[] references) {
/* 049 */     this.references = references;
/* 050 */   }
/* 051 */
/* 052 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 053 */     partitionIndex = index;
/* 054 */     this.inputs = inputs;
/* 055 */     wholestagecodegen_init_0();
/* 056 */     wholestagecodegen_init_1();
/* 057 */
/* 058 */   }
/* 059 */
/* 060 */   private void wholestagecodegen_init_0() {
/* 061 */     agg_initAgg = false;
/* 062 */
/* 063 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 064 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 065 */
/* 066 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 067 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 068 */     agg_initAgg1 = false;
/* 069 */
/* 070 */     this.agg_plan1 = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[3];
/* 071 */
/* 072 */     this.agg_peakMemory1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 073 */     this.agg_spillSize1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 074 */     inputadapter_input = inputs[0];
/* 075 */     agg_result1 = new UnsafeRow(2);
/* 076 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 077 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 078 */
/* 079 */     agg_result2 = new UnsafeRow(2);
/* 080 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */   public class agg_FastHashMap {
/* 085 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 086 */     private int[] buckets;
/* 087 */     private int capacity = 1 << 16;
/* 088 */     private double loadFactor = 0.5;
/* 089 */     private int numBuckets = (int) (capacity / loadFactor);
/* 090 */     private int maxSteps = 2;
/* 091 */     private int numRows = 0;
/* 092 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("ss_store_sk", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 093 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 094 */     .add("count", org.apache.spark.sql.types.DataTypes.LongType);
/* 095 */     private Object emptyVBase;
/* 096 */     private long emptyVOff;
/* 097 */     private int emptyVLen;
/* 098 */     private boolean isBatchFull = false;
/* 099 */
/* 100 */     public agg_FastHashMap(
/* 101 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 102 */       InternalRow emptyAggregationBuffer) {
/* 103 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 104 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 105 */
/* 106 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 107 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 108 */
/* 109 */       emptyVBase = emptyBuffer;
/* 110 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 111 */       emptyVLen = emptyBuffer.length;
/* 112 */
/* 113 */       buckets = new int[numBuckets];
/* 114 */       java.util.Arrays.fill(buckets, -1);
/* 115 */     }
/* 116 */
/* 117 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 118 */       long h = hash(agg_key);
/* 119 */       int step = 0;
/* 120 */       int idx = (int) h & (numBuckets - 1);
/* 121 */       while (step < maxSteps) {
/* 122 */         // Return bucket index if it's either an empty slot or already contains the key
/* 123 */         if (buckets[idx] == -1) {
/* 124 */           if (numRows < capacity && !isBatchFull) {
/* 125 */             // creating the unsafe for new entry
/* 126 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 127 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 128 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 129 */               0);
/* 130 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 131 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 132 */               agg_holder,
/* 133 */               1);
/* 134 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 135 */             agg_rowWriter.zeroOutNullBytes();
/* 136 */             agg_rowWriter.write(0, agg_key);
/* 137 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 138 */             Object kbase = agg_result.getBaseObject();
/* 139 */             long koff = agg_result.getBaseOffset();
/* 140 */             int klen = agg_result.getSizeInBytes();
/* 141 */
/* 142 */             UnsafeRow vRow
/* 143 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 144 */             if (vRow == null) {
/* 145 */               isBatchFull = true;
/* 146 */             } else {
/* 147 */               buckets[idx] = numRows++;
/* 148 */             }
/* 149 */             return vRow;
/* 150 */           } else {
/* 151 */             // No more space
/* 152 */             return null;
/* 153 */           }
/* 154 */         } else if (equals(idx, agg_key)) {
/* 155 */           return batch.getValueRow(buckets[idx]);
/* 156 */         }
/* 157 */         idx = (idx + 1) & (numBuckets - 1);
/* 158 */         step++;
/* 159 */       }
/* 160 */       // Didn't find it
/* 161 */       return null;
/* 162 */     }
/* 163 */
/* 164 */     private boolean equals(int idx, int agg_key) {
/* 165 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 166 */       return (row.getInt(0) == agg_key);
/* 167 */     }
/* 168 */
/* 169 */     private long hash(int agg_key) {
/* 170 */       long agg_hash = 0;
/* 171 */
/* 172 */       int agg_result = agg_key;
/* 173 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 174 */
/* 175 */       return agg_hash;
/* 176 */     }
/* 177 */
/* 178 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 179 */       return batch.rowIterator();
/* 180 */     }
/* 181 */
/* 182 */     public void close() {
/* 183 */       batch.close();
/* 184 */     }
/* 185 */
/* 186 */   }
/* 187 */
/* 188 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 189 */     agg_hashMap = agg_plan.createHashMap();
/* 190 */
/* 191 */     if (!agg_initAgg1) {
/* 192 */       agg_initAgg1 = true;
/* 193 */       long agg_beforeAgg = System.nanoTime();
/* 194 */       agg_doAggregateWithKeys1();
/* 195 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 196 */     }
/* 197 */
/* 198 */     // output the result
/* 199 */
/* 200 */     while (agg_mapIter1.next()) {
/* 201 */       agg_numOutputRows.add(1);
/* 202 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter1.getKey();
/* 203 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter1.getValue();
/* 204 */
/* 205 */       boolean agg_isNull19 = agg_aggKey.isNullAt(0);
/* 206 */       int agg_value22 = agg_isNull19 ? -1 : (agg_aggKey.getInt(0));
/* 207 */       boolean agg_isNull20 = agg_aggKey.isNullAt(1);
/* 208 */       int agg_value23 = agg_isNull20 ? -1 : (agg_aggKey.getInt(1));
/* 209 */       boolean agg_isNull21 = agg_aggBuffer.isNullAt(0);
/* 210 */       double agg_value24 = agg_isNull21 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 211 */
/* 212 */       UnsafeRow agg_unsafeRowAggBuffer1 = null;
/* 213 */
/* 214 */       UnsafeRow agg_fastAggBuffer1 = null;
/* 215 */
/* 216 */       if (true) {
/* 217 */         if (!agg_isNull19) {
/* 218 */           agg_fastAggBuffer1 = agg_fastHashMap.findOrInsert(
/* 219 */             agg_value22);
/* 220 */         }
/* 221 */       }
/* 222 */
/* 223 */       if (agg_fastAggBuffer1 == null) {
/* 224 */         // generate grouping key
/* 225 */         agg_rowWriter2.zeroOutNullBytes();
/* 226 */
/* 227 */         if (agg_isNull19) {
/* 228 */           agg_rowWriter2.setNullAt(0);
/* 229 */         } else {
/* 230 */           agg_rowWriter2.write(0, agg_value22);
/* 231 */         }
/* 232 */         agg_value32 = 42;
/* 233 */
/* 234 */         if (!agg_isNull19) {
/* 235 */           agg_value32 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value22, agg_value32);
/* 236 */         }
/* 237 */         if (true) {
/* 238 */           // try to get the buffer from hash map
/* 239 */           agg_unsafeRowAggBuffer1 =
/* 240 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value32);
/* 241 */         }
/* 242 */         if (agg_unsafeRowAggBuffer1 == null) {
/* 243 */           if (agg_sorter == null) {
/* 244 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 245 */           } else {
/* 246 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 247 */           }
/* 248 */
/* 249 */           // the hash map had be spilled, it should have enough memory now,
/* 250 */           // try  to allocate buffer again.
/* 251 */           agg_unsafeRowAggBuffer1 =
/* 252 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value32);
/* 253 */           if (agg_unsafeRowAggBuffer1 == null) {
/* 254 */             // failed to allocate the first page
/* 255 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 256 */           }
/* 257 */         }
/* 258 */       }
/* 259 */
/* 260 */       if (agg_fastAggBuffer1 != null) {
/* 261 */         // update fast row
/* 262 */
/* 263 */         // common sub-expressions
/* 264 */
/* 265 */         // evaluate aggregate function
/* 266 */         boolean agg_isNull45 = true;
/* 267 */         double agg_value48 = -1.0;
/* 268 */
/* 269 */         boolean agg_isNull46 = agg_fastAggBuffer1.isNullAt(0);
/* 270 */         double agg_value49 = agg_isNull46 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 271 */         if (!agg_isNull46) {
/* 272 */           boolean agg_isNull48 = agg_isNull21;
/* 273 */           double agg_value51 = -1.0;
/* 274 */           if (!agg_isNull21) {
/* 275 */             agg_value51 = agg_value24;
/* 276 */           }
/* 277 */           boolean agg_isNull47 = agg_isNull48;
/* 278 */           double agg_value50 = agg_value51;
/* 279 */           if (agg_isNull47) {
/* 280 */             boolean agg_isNull50 = false;
/* 281 */             double agg_value53 = -1.0;
/* 282 */             if (!false) {
/* 283 */               agg_value53 = (double) 0;
/* 284 */             }
/* 285 */             if (!agg_isNull50) {
/* 286 */               agg_isNull47 = false;
/* 287 */               agg_value50 = agg_value53;
/* 288 */             }
/* 289 */           }
/* 290 */
/* 291 */           agg_isNull45 = false; // resultCode could change nullability.
/* 292 */           agg_value48 = agg_value49 + agg_value50;
/* 293 */
/* 294 */         }
/* 295 */         boolean agg_isNull52 = false;
/* 296 */         long agg_value55 = -1L;
/* 297 */         if (!false && agg_isNull21) {
/* 298 */           boolean agg_isNull55 = agg_fastAggBuffer1.isNullAt(1);
/* 299 */           long agg_value58 = agg_isNull55 ? -1L : (agg_fastAggBuffer1.getLong(1));
/* 300 */           agg_isNull52 = agg_isNull55;
/* 301 */           agg_value55 = agg_value58;
/* 302 */         } else {
/* 303 */           boolean agg_isNull56 = true;
/* 304 */           long agg_value59 = -1L;
/* 305 */
/* 306 */           boolean agg_isNull57 = agg_fastAggBuffer1.isNullAt(1);
/* 307 */           long agg_value60 = agg_isNull57 ? -1L : (agg_fastAggBuffer1.getLong(1));
/* 308 */           if (!agg_isNull57) {
/* 309 */             agg_isNull56 = false; // resultCode could change nullability.
/* 310 */             agg_value59 = agg_value60 + 1L;
/* 311 */
/* 312 */           }
/* 313 */           agg_isNull52 = agg_isNull56;
/* 314 */           agg_value55 = agg_value59;
/* 315 */         }
/* 316 */         // update fast row
/* 317 */         if (!agg_isNull45) {
/* 318 */           agg_fastAggBuffer1.setDouble(0, agg_value48);
/* 319 */         } else {
/* 320 */           agg_fastAggBuffer1.setNullAt(0);
/* 321 */         }
/* 322 */
/* 323 */         if (!agg_isNull52) {
/* 324 */           agg_fastAggBuffer1.setLong(1, agg_value55);
/* 325 */         } else {
/* 326 */           agg_fastAggBuffer1.setNullAt(1);
/* 327 */         }
/* 328 */
/* 329 */       } else {
/* 330 */         // update unsafe row
/* 331 */
/* 332 */         // common sub-expressions
/* 333 */
/* 334 */         // evaluate aggregate function
/* 335 */         boolean agg_isNull31 = true;
/* 336 */         double agg_value34 = -1.0;
/* 337 */
/* 338 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 339 */         double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 340 */         if (!agg_isNull32) {
/* 341 */           boolean agg_isNull34 = agg_isNull21;
/* 342 */           double agg_value37 = -1.0;
/* 343 */           if (!agg_isNull21) {
/* 344 */             agg_value37 = agg_value24;
/* 345 */           }
/* 346 */           boolean agg_isNull33 = agg_isNull34;
/* 347 */           double agg_value36 = agg_value37;
/* 348 */           if (agg_isNull33) {
/* 349 */             boolean agg_isNull36 = false;
/* 350 */             double agg_value39 = -1.0;
/* 351 */             if (!false) {
/* 352 */               agg_value39 = (double) 0;
/* 353 */             }
/* 354 */             if (!agg_isNull36) {
/* 355 */               agg_isNull33 = false;
/* 356 */               agg_value36 = agg_value39;
/* 357 */             }
/* 358 */           }
/* 359 */
/* 360 */           agg_isNull31 = false; // resultCode could change nullability.
/* 361 */           agg_value34 = agg_value35 + agg_value36;
/* 362 */
/* 363 */         }
/* 364 */         boolean agg_isNull38 = false;
/* 365 */         long agg_value41 = -1L;
/* 366 */         if (!false && agg_isNull21) {
/* 367 */           boolean agg_isNull41 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 368 */           long agg_value44 = agg_isNull41 ? -1L : (agg_unsafeRowAggBuffer1.getLong(1));
/* 369 */           agg_isNull38 = agg_isNull41;
/* 370 */           agg_value41 = agg_value44;
/* 371 */         } else {
/* 372 */           boolean agg_isNull42 = true;
/* 373 */           long agg_value45 = -1L;
/* 374 */
/* 375 */           boolean agg_isNull43 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 376 */           long agg_value46 = agg_isNull43 ? -1L : (agg_unsafeRowAggBuffer1.getLong(1));
/* 377 */           if (!agg_isNull43) {
/* 378 */             agg_isNull42 = false; // resultCode could change nullability.
/* 379 */             agg_value45 = agg_value46 + 1L;
/* 380 */
/* 381 */           }
/* 382 */           agg_isNull38 = agg_isNull42;
/* 383 */           agg_value41 = agg_value45;
/* 384 */         }
/* 385 */         // update unsafe row buffer
/* 386 */         if (!agg_isNull31) {
/* 387 */           agg_unsafeRowAggBuffer1.setDouble(0, agg_value34);
/* 388 */         } else {
/* 389 */           agg_unsafeRowAggBuffer1.setNullAt(0);
/* 390 */         }
/* 391 */
/* 392 */         if (!agg_isNull38) {
/* 393 */           agg_unsafeRowAggBuffer1.setLong(1, agg_value41);
/* 394 */         } else {
/* 395 */           agg_unsafeRowAggBuffer1.setNullAt(1);
/* 396 */         }
/* 397 */
/* 398 */       }
/* 399 */
/* 400 */       if (shouldStop()) return;
/* 401 */     }
/* 402 */
/* 403 */     agg_mapIter1.close();
/* 404 */     if (agg_sorter1 == null) {
/* 405 */       agg_hashMap1.free();
/* 406 */     }
/* 407 */
/* 408 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 409 */
/* 410 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 411 */   }
/* 412 */
/* 413 */   private void agg_doAggregateWithKeys1() throws java.io.IOException {
/* 414 */     agg_hashMap1 = agg_plan1.createHashMap();
/* 415 */
/* 416 */     while (inputadapter_input.hasNext()) {
/* 417 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 418 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 419 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 420 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 421 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 422 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 423 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 424 */
/* 425 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 426 */
/* 427 */       UnsafeRow agg_fastAggBuffer = null;
/* 428 */
/* 429 */       if (agg_fastAggBuffer == null) {
/* 430 */         // generate grouping key
/* 431 */         agg_rowWriter.zeroOutNullBytes();
/* 432 */
/* 433 */         if (inputadapter_isNull) {
/* 434 */           agg_rowWriter.setNullAt(0);
/* 435 */         } else {
/* 436 */           agg_rowWriter.write(0, inputadapter_value);
/* 437 */         }
/* 438 */
/* 439 */         if (inputadapter_isNull1) {
/* 440 */           agg_rowWriter.setNullAt(1);
/* 441 */         } else {
/* 442 */           agg_rowWriter.write(1, inputadapter_value1);
/* 443 */         }
/* 444 */         agg_value11 = 42;
/* 445 */
/* 446 */         if (!inputadapter_isNull) {
/* 447 */           agg_value11 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value11);
/* 448 */         }
/* 449 */
/* 450 */         if (!inputadapter_isNull1) {
/* 451 */           agg_value11 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value11);
/* 452 */         }
/* 453 */         if (true) {
/* 454 */           // try to get the buffer from hash map
/* 455 */           agg_unsafeRowAggBuffer =
/* 456 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result1, agg_value11);
/* 457 */         }
/* 458 */         if (agg_unsafeRowAggBuffer == null) {
/* 459 */           if (agg_sorter1 == null) {
/* 460 */             agg_sorter1 = agg_hashMap1.destructAndCreateExternalSorter();
/* 461 */           } else {
/* 462 */             agg_sorter1.merge(agg_hashMap1.destructAndCreateExternalSorter());
/* 463 */           }
/* 464 */
/* 465 */           // the hash map had be spilled, it should have enough memory now,
/* 466 */           // try  to allocate buffer again.
/* 467 */           agg_unsafeRowAggBuffer =
/* 468 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result1, agg_value11);
/* 469 */           if (agg_unsafeRowAggBuffer == null) {
/* 470 */             // failed to allocate the first page
/* 471 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 472 */           }
/* 473 */         }
/* 474 */       }
/* 475 */
/* 476 */       if (agg_fastAggBuffer != null) {
/* 477 */         // update fast row
/* 478 */
/* 479 */       } else {
/* 480 */         // update unsafe row
/* 481 */
/* 482 */         // common sub-expressions
/* 483 */
/* 484 */         // evaluate aggregate function
/* 485 */         boolean agg_isNull12 = true;
/* 486 */         double agg_value15 = -1.0;
/* 487 */
/* 488 */         boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 489 */         double agg_value17 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 490 */         boolean agg_isNull13 = agg_isNull14;
/* 491 */         double agg_value16 = agg_value17;
/* 492 */         if (agg_isNull13) {
/* 493 */           boolean agg_isNull15 = false;
/* 494 */           double agg_value18 = -1.0;
/* 495 */           if (!false) {
/* 496 */             agg_value18 = (double) 0;
/* 497 */           }
/* 498 */           if (!agg_isNull15) {
/* 499 */             agg_isNull13 = false;
/* 500 */             agg_value16 = agg_value18;
/* 501 */           }
/* 502 */         }
/* 503 */
/* 504 */         if (!inputadapter_isNull2) {
/* 505 */           agg_isNull12 = false; // resultCode could change nullability.
/* 506 */           agg_value15 = agg_value16 + inputadapter_value2;
/* 507 */
/* 508 */         }
/* 509 */         boolean agg_isNull11 = agg_isNull12;
/* 510 */         double agg_value14 = agg_value15;
/* 511 */         if (agg_isNull11) {
/* 512 */           boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 513 */           double agg_value21 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 514 */           if (!agg_isNull18) {
/* 515 */             agg_isNull11 = false;
/* 516 */             agg_value14 = agg_value21;
/* 517 */           }
/* 518 */         }
/* 519 */         // update unsafe row buffer
/* 520 */         if (!agg_isNull11) {
/* 521 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value14);
/* 522 */         } else {
/* 523 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 524 */         }
/* 525 */
/* 526 */       }
/* 527 */       if (shouldStop()) return;
/* 528 */     }
/* 529 */
/* 530 */     agg_mapIter1 = agg_plan1.finishAggregate(agg_hashMap1, agg_sorter1, agg_peakMemory1, agg_spillSize1);
/* 531 */   }
/* 532 */
/* 533 */   private void wholestagecodegen_init_1() {
/* 534 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 535 */     agg_result3 = new UnsafeRow(1);
/* 536 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 0);
/* 537 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 1);
/* 538 */
/* 539 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 540 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 541 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 542 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 543 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 544 */
/* 545 */   }
/* 546 */
/* 547 */   protected void processNext() throws java.io.IOException {
/* 548 */     if (!agg_initAgg) {
/* 549 */       agg_initAgg = true;
/* 550 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 551 */       agg_doAggregateWithKeys();
/* 552 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 553 */     }
/* 554 */
/* 555 */     // output the result
/* 556 */
/* 557 */     while (agg_fastHashMapIter.next()) {
/* 558 */       wholestagecodegen_numOutputRows.add(1);
/* 559 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 560 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 561 */
/* 562 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 563 */
/* 564 */       append(agg_resultRow);
/* 565 */
/* 566 */       if (shouldStop()) return;
/* 567 */     }
/* 568 */     agg_fastHashMap.close();
/* 569 */
/* 570 */     while (agg_mapIter.next()) {
/* 571 */       wholestagecodegen_numOutputRows.add(1);
/* 572 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_mapIter.getKey();
/* 573 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_mapIter.getValue();
/* 574 */
/* 575 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 576 */
/* 577 */       append(agg_resultRow);
/* 578 */
/* 579 */       if (shouldStop()) return;
/* 580 */     }
/* 581 */
/* 582 */     agg_mapIter.close();
/* 583 */     if (agg_sorter == null) {
/* 584 */       agg_hashMap.free();
/* 585 */     }
/* 586 */   }
/* 587 */ }

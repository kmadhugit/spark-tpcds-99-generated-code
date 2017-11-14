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
/* 070 */     this.agg_plan1 = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[6];
/* 071 */
/* 072 */     this.agg_peakMemory1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 073 */     this.agg_spillSize1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
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
/* 092 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 093 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 094 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.LongType);
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
/* 266 */         boolean agg_isNull44 = true;
/* 267 */         double agg_value47 = -1.0;
/* 268 */
/* 269 */         boolean agg_isNull45 = agg_fastAggBuffer1.isNullAt(0);
/* 270 */         double agg_value48 = agg_isNull45 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 271 */         if (!agg_isNull45) {
/* 272 */           boolean agg_isNull46 = agg_isNull21;
/* 273 */           double agg_value49 = agg_value24;
/* 274 */           if (agg_isNull46) {
/* 275 */             boolean agg_isNull48 = false;
/* 276 */             double agg_value51 = -1.0;
/* 277 */             if (!false) {
/* 278 */               agg_value51 = (double) 0;
/* 279 */             }
/* 280 */             if (!agg_isNull48) {
/* 281 */               agg_isNull46 = false;
/* 282 */               agg_value49 = agg_value51;
/* 283 */             }
/* 284 */           }
/* 285 */
/* 286 */           agg_isNull44 = false; // resultCode could change nullability.
/* 287 */           agg_value47 = agg_value48 + agg_value49;
/* 288 */
/* 289 */         }
/* 290 */         boolean agg_isNull50 = false;
/* 291 */         long agg_value53 = -1L;
/* 292 */         if (!false && agg_isNull21) {
/* 293 */           boolean agg_isNull53 = agg_fastAggBuffer1.isNullAt(1);
/* 294 */           long agg_value56 = agg_isNull53 ? -1L : (agg_fastAggBuffer1.getLong(1));
/* 295 */           agg_isNull50 = agg_isNull53;
/* 296 */           agg_value53 = agg_value56;
/* 297 */         } else {
/* 298 */           boolean agg_isNull54 = true;
/* 299 */           long agg_value57 = -1L;
/* 300 */
/* 301 */           boolean agg_isNull55 = agg_fastAggBuffer1.isNullAt(1);
/* 302 */           long agg_value58 = agg_isNull55 ? -1L : (agg_fastAggBuffer1.getLong(1));
/* 303 */           if (!agg_isNull55) {
/* 304 */             agg_isNull54 = false; // resultCode could change nullability.
/* 305 */             agg_value57 = agg_value58 + 1L;
/* 306 */
/* 307 */           }
/* 308 */           agg_isNull50 = agg_isNull54;
/* 309 */           agg_value53 = agg_value57;
/* 310 */         }
/* 311 */         // update fast row
/* 312 */         if (!agg_isNull44) {
/* 313 */           agg_fastAggBuffer1.setDouble(0, agg_value47);
/* 314 */         } else {
/* 315 */           agg_fastAggBuffer1.setNullAt(0);
/* 316 */         }
/* 317 */
/* 318 */         if (!agg_isNull50) {
/* 319 */           agg_fastAggBuffer1.setLong(1, agg_value53);
/* 320 */         } else {
/* 321 */           agg_fastAggBuffer1.setNullAt(1);
/* 322 */         }
/* 323 */
/* 324 */       } else {
/* 325 */         // update unsafe row
/* 326 */
/* 327 */         // common sub-expressions
/* 328 */
/* 329 */         // evaluate aggregate function
/* 330 */         boolean agg_isNull31 = true;
/* 331 */         double agg_value34 = -1.0;
/* 332 */
/* 333 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 334 */         double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 335 */         if (!agg_isNull32) {
/* 336 */           boolean agg_isNull33 = agg_isNull21;
/* 337 */           double agg_value36 = agg_value24;
/* 338 */           if (agg_isNull33) {
/* 339 */             boolean agg_isNull35 = false;
/* 340 */             double agg_value38 = -1.0;
/* 341 */             if (!false) {
/* 342 */               agg_value38 = (double) 0;
/* 343 */             }
/* 344 */             if (!agg_isNull35) {
/* 345 */               agg_isNull33 = false;
/* 346 */               agg_value36 = agg_value38;
/* 347 */             }
/* 348 */           }
/* 349 */
/* 350 */           agg_isNull31 = false; // resultCode could change nullability.
/* 351 */           agg_value34 = agg_value35 + agg_value36;
/* 352 */
/* 353 */         }
/* 354 */         boolean agg_isNull37 = false;
/* 355 */         long agg_value40 = -1L;
/* 356 */         if (!false && agg_isNull21) {
/* 357 */           boolean agg_isNull40 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 358 */           long agg_value43 = agg_isNull40 ? -1L : (agg_unsafeRowAggBuffer1.getLong(1));
/* 359 */           agg_isNull37 = agg_isNull40;
/* 360 */           agg_value40 = agg_value43;
/* 361 */         } else {
/* 362 */           boolean agg_isNull41 = true;
/* 363 */           long agg_value44 = -1L;
/* 364 */
/* 365 */           boolean agg_isNull42 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 366 */           long agg_value45 = agg_isNull42 ? -1L : (agg_unsafeRowAggBuffer1.getLong(1));
/* 367 */           if (!agg_isNull42) {
/* 368 */             agg_isNull41 = false; // resultCode could change nullability.
/* 369 */             agg_value44 = agg_value45 + 1L;
/* 370 */
/* 371 */           }
/* 372 */           agg_isNull37 = agg_isNull41;
/* 373 */           agg_value40 = agg_value44;
/* 374 */         }
/* 375 */         // update unsafe row buffer
/* 376 */         if (!agg_isNull31) {
/* 377 */           agg_unsafeRowAggBuffer1.setDouble(0, agg_value34);
/* 378 */         } else {
/* 379 */           agg_unsafeRowAggBuffer1.setNullAt(0);
/* 380 */         }
/* 381 */
/* 382 */         if (!agg_isNull37) {
/* 383 */           agg_unsafeRowAggBuffer1.setLong(1, agg_value40);
/* 384 */         } else {
/* 385 */           agg_unsafeRowAggBuffer1.setNullAt(1);
/* 386 */         }
/* 387 */
/* 388 */       }
/* 389 */
/* 390 */       if (shouldStop()) return;
/* 391 */     }
/* 392 */
/* 393 */     agg_mapIter1.close();
/* 394 */     if (agg_sorter1 == null) {
/* 395 */       agg_hashMap1.free();
/* 396 */     }
/* 397 */
/* 398 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 399 */
/* 400 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 401 */   }
/* 402 */
/* 403 */   private void agg_doAggregateWithKeys1() throws java.io.IOException {
/* 404 */     agg_hashMap1 = agg_plan1.createHashMap();
/* 405 */
/* 406 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 407 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 408 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 409 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 410 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 411 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 412 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 413 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 414 */
/* 415 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 416 */
/* 417 */       UnsafeRow agg_fastAggBuffer = null;
/* 418 */
/* 419 */       if (agg_fastAggBuffer == null) {
/* 420 */         // generate grouping key
/* 421 */         agg_rowWriter.zeroOutNullBytes();
/* 422 */
/* 423 */         if (inputadapter_isNull) {
/* 424 */           agg_rowWriter.setNullAt(0);
/* 425 */         } else {
/* 426 */           agg_rowWriter.write(0, inputadapter_value);
/* 427 */         }
/* 428 */
/* 429 */         if (inputadapter_isNull1) {
/* 430 */           agg_rowWriter.setNullAt(1);
/* 431 */         } else {
/* 432 */           agg_rowWriter.write(1, inputadapter_value1);
/* 433 */         }
/* 434 */         agg_value11 = 42;
/* 435 */
/* 436 */         if (!inputadapter_isNull) {
/* 437 */           agg_value11 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value11);
/* 438 */         }
/* 439 */
/* 440 */         if (!inputadapter_isNull1) {
/* 441 */           agg_value11 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value11);
/* 442 */         }
/* 443 */         if (true) {
/* 444 */           // try to get the buffer from hash map
/* 445 */           agg_unsafeRowAggBuffer =
/* 446 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result1, agg_value11);
/* 447 */         }
/* 448 */         if (agg_unsafeRowAggBuffer == null) {
/* 449 */           if (agg_sorter1 == null) {
/* 450 */             agg_sorter1 = agg_hashMap1.destructAndCreateExternalSorter();
/* 451 */           } else {
/* 452 */             agg_sorter1.merge(agg_hashMap1.destructAndCreateExternalSorter());
/* 453 */           }
/* 454 */
/* 455 */           // the hash map had be spilled, it should have enough memory now,
/* 456 */           // try  to allocate buffer again.
/* 457 */           agg_unsafeRowAggBuffer =
/* 458 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result1, agg_value11);
/* 459 */           if (agg_unsafeRowAggBuffer == null) {
/* 460 */             // failed to allocate the first page
/* 461 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 462 */           }
/* 463 */         }
/* 464 */       }
/* 465 */
/* 466 */       if (agg_fastAggBuffer != null) {
/* 467 */         // update fast row
/* 468 */
/* 469 */       } else {
/* 470 */         // update unsafe row
/* 471 */
/* 472 */         // common sub-expressions
/* 473 */
/* 474 */         // evaluate aggregate function
/* 475 */         boolean agg_isNull12 = true;
/* 476 */         double agg_value15 = -1.0;
/* 477 */
/* 478 */         boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 479 */         double agg_value17 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 480 */         boolean agg_isNull13 = agg_isNull14;
/* 481 */         double agg_value16 = agg_value17;
/* 482 */         if (agg_isNull13) {
/* 483 */           boolean agg_isNull15 = false;
/* 484 */           double agg_value18 = -1.0;
/* 485 */           if (!false) {
/* 486 */             agg_value18 = (double) 0;
/* 487 */           }
/* 488 */           if (!agg_isNull15) {
/* 489 */             agg_isNull13 = false;
/* 490 */             agg_value16 = agg_value18;
/* 491 */           }
/* 492 */         }
/* 493 */
/* 494 */         if (!inputadapter_isNull2) {
/* 495 */           agg_isNull12 = false; // resultCode could change nullability.
/* 496 */           agg_value15 = agg_value16 + inputadapter_value2;
/* 497 */
/* 498 */         }
/* 499 */         boolean agg_isNull11 = agg_isNull12;
/* 500 */         double agg_value14 = agg_value15;
/* 501 */         if (agg_isNull11) {
/* 502 */           boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 503 */           double agg_value21 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 504 */           if (!agg_isNull18) {
/* 505 */             agg_isNull11 = false;
/* 506 */             agg_value14 = agg_value21;
/* 507 */           }
/* 508 */         }
/* 509 */         // update unsafe row buffer
/* 510 */         if (!agg_isNull11) {
/* 511 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value14);
/* 512 */         } else {
/* 513 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 514 */         }
/* 515 */
/* 516 */       }
/* 517 */       if (shouldStop()) return;
/* 518 */     }
/* 519 */
/* 520 */     agg_mapIter1 = agg_plan1.finishAggregate(agg_hashMap1, agg_sorter1, agg_peakMemory1, agg_spillSize1);
/* 521 */   }
/* 522 */
/* 523 */   private void wholestagecodegen_init_1() {
/* 524 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 525 */     agg_result3 = new UnsafeRow(1);
/* 526 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 0);
/* 527 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 1);
/* 528 */
/* 529 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 530 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 531 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 532 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 533 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 534 */
/* 535 */   }
/* 536 */
/* 537 */   protected void processNext() throws java.io.IOException {
/* 538 */     if (!agg_initAgg) {
/* 539 */       agg_initAgg = true;
/* 540 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 541 */       agg_doAggregateWithKeys();
/* 542 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 543 */     }
/* 544 */
/* 545 */     // output the result
/* 546 */
/* 547 */     while (agg_fastHashMapIter.next()) {
/* 548 */       wholestagecodegen_numOutputRows.add(1);
/* 549 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 550 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 551 */
/* 552 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 553 */
/* 554 */       append(agg_resultRow);
/* 555 */
/* 556 */       if (shouldStop()) return;
/* 557 */     }
/* 558 */     agg_fastHashMap.close();
/* 559 */
/* 560 */     while (agg_mapIter.next()) {
/* 561 */       wholestagecodegen_numOutputRows.add(1);
/* 562 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_mapIter.getKey();
/* 563 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_mapIter.getValue();
/* 564 */
/* 565 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 566 */
/* 567 */       append(agg_resultRow);
/* 568 */
/* 569 */       if (shouldStop()) return;
/* 570 */     }
/* 571 */
/* 572 */     agg_mapIter.close();
/* 573 */     if (agg_sorter == null) {
/* 574 */       agg_hashMap.free();
/* 575 */     }
/* 576 */   }
/* 577 */ }

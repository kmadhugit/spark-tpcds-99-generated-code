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
/* 019 */   private boolean agg_initAgg1;
/* 020 */   private boolean agg_bufIsNull1;
/* 021 */   private double agg_bufValue1;
/* 022 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan1;
/* 023 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap1;
/* 024 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter1;
/* 025 */   private org.apache.spark.unsafe.KVIterator agg_mapIter1;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize1;
/* 028 */   private scala.collection.Iterator inputadapter_input;
/* 029 */   private UnsafeRow agg_result1;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 032 */   private int agg_value6;
/* 033 */   private UnsafeRow agg_result2;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 036 */   private UnsafeRow agg_result3;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder2;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter2;
/* 039 */   private int agg_value26;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 044 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 045 */
/* 046 */   public GeneratedIterator(Object[] references) {
/* 047 */     this.references = references;
/* 048 */   }
/* 049 */
/* 050 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 051 */     partitionIndex = index;
/* 052 */     this.inputs = inputs;
/* 053 */     wholestagecodegen_init_0();
/* 054 */     wholestagecodegen_init_1();
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void wholestagecodegen_init_0() {
/* 059 */     agg_initAgg = false;
/* 060 */
/* 061 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 062 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 063 */
/* 064 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 065 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 066 */     agg_initAgg1 = false;
/* 067 */
/* 068 */     this.agg_plan1 = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[3];
/* 069 */
/* 070 */     this.agg_peakMemory1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 071 */     this.agg_spillSize1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 072 */     inputadapter_input = inputs[0];
/* 073 */     agg_result1 = new UnsafeRow(1);
/* 074 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 075 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 076 */
/* 077 */     agg_result2 = new UnsafeRow(1);
/* 078 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 079 */
/* 080 */   }
/* 081 */
/* 082 */   public class agg_FastHashMap {
/* 083 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 084 */     private int[] buckets;
/* 085 */     private int capacity = 1 << 16;
/* 086 */     private double loadFactor = 0.5;
/* 087 */     private int numBuckets = (int) (capacity / loadFactor);
/* 088 */     private int maxSteps = 2;
/* 089 */     private int numRows = 0;
/* 090 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("segment", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 091 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("count", org.apache.spark.sql.types.DataTypes.LongType);
/* 092 */     private Object emptyVBase;
/* 093 */     private long emptyVOff;
/* 094 */     private int emptyVLen;
/* 095 */     private boolean isBatchFull = false;
/* 096 */
/* 097 */     public agg_FastHashMap(
/* 098 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 099 */       InternalRow emptyAggregationBuffer) {
/* 100 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 101 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 102 */
/* 103 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 104 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 105 */
/* 106 */       emptyVBase = emptyBuffer;
/* 107 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 108 */       emptyVLen = emptyBuffer.length;
/* 109 */
/* 110 */       buckets = new int[numBuckets];
/* 111 */       java.util.Arrays.fill(buckets, -1);
/* 112 */     }
/* 113 */
/* 114 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 115 */       long h = hash(agg_key);
/* 116 */       int step = 0;
/* 117 */       int idx = (int) h & (numBuckets - 1);
/* 118 */       while (step < maxSteps) {
/* 119 */         // Return bucket index if it's either an empty slot or already contains the key
/* 120 */         if (buckets[idx] == -1) {
/* 121 */           if (numRows < capacity && !isBatchFull) {
/* 122 */             // creating the unsafe for new entry
/* 123 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 124 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 125 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 126 */               0);
/* 127 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 128 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 129 */               agg_holder,
/* 130 */               1);
/* 131 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 132 */             agg_rowWriter.zeroOutNullBytes();
/* 133 */             agg_rowWriter.write(0, agg_key);
/* 134 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 135 */             Object kbase = agg_result.getBaseObject();
/* 136 */             long koff = agg_result.getBaseOffset();
/* 137 */             int klen = agg_result.getSizeInBytes();
/* 138 */
/* 139 */             UnsafeRow vRow
/* 140 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 141 */             if (vRow == null) {
/* 142 */               isBatchFull = true;
/* 143 */             } else {
/* 144 */               buckets[idx] = numRows++;
/* 145 */             }
/* 146 */             return vRow;
/* 147 */           } else {
/* 148 */             // No more space
/* 149 */             return null;
/* 150 */           }
/* 151 */         } else if (equals(idx, agg_key)) {
/* 152 */           return batch.getValueRow(buckets[idx]);
/* 153 */         }
/* 154 */         idx = (idx + 1) & (numBuckets - 1);
/* 155 */         step++;
/* 156 */       }
/* 157 */       // Didn't find it
/* 158 */       return null;
/* 159 */     }
/* 160 */
/* 161 */     private boolean equals(int idx, int agg_key) {
/* 162 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 163 */       return (row.getInt(0) == agg_key);
/* 164 */     }
/* 165 */
/* 166 */     private long hash(int agg_key) {
/* 167 */       long agg_hash = 0;
/* 168 */
/* 169 */       int agg_result = agg_key;
/* 170 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 171 */
/* 172 */       return agg_hash;
/* 173 */     }
/* 174 */
/* 175 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 176 */       return batch.rowIterator();
/* 177 */     }
/* 178 */
/* 179 */     public void close() {
/* 180 */       batch.close();
/* 181 */     }
/* 182 */
/* 183 */   }
/* 184 */
/* 185 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 186 */     agg_hashMap = agg_plan.createHashMap();
/* 187 */
/* 188 */     if (!agg_initAgg1) {
/* 189 */       agg_initAgg1 = true;
/* 190 */       long agg_beforeAgg = System.nanoTime();
/* 191 */       agg_doAggregateWithKeys1();
/* 192 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 193 */     }
/* 194 */
/* 195 */     // output the result
/* 196 */
/* 197 */     while (agg_mapIter1.next()) {
/* 198 */       agg_numOutputRows.add(1);
/* 199 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter1.getKey();
/* 200 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter1.getValue();
/* 201 */
/* 202 */       boolean agg_isNull14 = agg_aggKey.isNullAt(0);
/* 203 */       int agg_value16 = agg_isNull14 ? -1 : (agg_aggKey.getInt(0));
/* 204 */       boolean agg_isNull15 = agg_aggBuffer.isNullAt(0);
/* 205 */       double agg_value17 = agg_isNull15 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 206 */
/* 207 */       boolean agg_isNull18 = false;
/* 208 */       double agg_value20 = -1.0;
/* 209 */       if (false || 50.0D == 0) {
/* 210 */         agg_isNull18 = true;
/* 211 */       } else {
/* 212 */         if (agg_isNull15) {
/* 213 */           agg_isNull18 = true;
/* 214 */         } else {
/* 215 */           agg_value20 = (double)(agg_value17 / 50.0D);
/* 216 */         }
/* 217 */       }
/* 218 */       boolean agg_isNull17 = agg_isNull18;
/* 219 */       int agg_value19 = -1;
/* 220 */       if (!agg_isNull18) {
/* 221 */         agg_value19 = (int) agg_value20;
/* 222 */       }
/* 223 */
/* 224 */       UnsafeRow agg_unsafeRowAggBuffer1 = null;
/* 225 */
/* 226 */       UnsafeRow agg_fastAggBuffer1 = null;
/* 227 */
/* 228 */       if (true) {
/* 229 */         if (!agg_isNull17) {
/* 230 */           agg_fastAggBuffer1 = agg_fastHashMap.findOrInsert(
/* 231 */             agg_value19);
/* 232 */         }
/* 233 */       }
/* 234 */
/* 235 */       if (agg_fastAggBuffer1 == null) {
/* 236 */         // generate grouping key
/* 237 */         agg_rowWriter2.zeroOutNullBytes();
/* 238 */
/* 239 */         if (agg_isNull17) {
/* 240 */           agg_rowWriter2.setNullAt(0);
/* 241 */         } else {
/* 242 */           agg_rowWriter2.write(0, agg_value19);
/* 243 */         }
/* 244 */         agg_value26 = 42;
/* 245 */
/* 246 */         if (!agg_isNull17) {
/* 247 */           agg_value26 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value19, agg_value26);
/* 248 */         }
/* 249 */         if (true) {
/* 250 */           // try to get the buffer from hash map
/* 251 */           agg_unsafeRowAggBuffer1 =
/* 252 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value26);
/* 253 */         }
/* 254 */         if (agg_unsafeRowAggBuffer1 == null) {
/* 255 */           if (agg_sorter == null) {
/* 256 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 257 */           } else {
/* 258 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 259 */           }
/* 260 */
/* 261 */           // the hash map had be spilled, it should have enough memory now,
/* 262 */           // try  to allocate buffer again.
/* 263 */           agg_unsafeRowAggBuffer1 =
/* 264 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value26);
/* 265 */           if (agg_unsafeRowAggBuffer1 == null) {
/* 266 */             // failed to allocate the first page
/* 267 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 268 */           }
/* 269 */         }
/* 270 */       }
/* 271 */
/* 272 */       if (agg_fastAggBuffer1 != null) {
/* 273 */         // update fast row
/* 274 */
/* 275 */         // common sub-expressions
/* 276 */
/* 277 */         // evaluate aggregate function
/* 278 */         boolean agg_isNull29 = false;
/* 279 */
/* 280 */         long agg_value32 = agg_fastAggBuffer1.getLong(0);
/* 281 */
/* 282 */         long agg_value31 = -1L;
/* 283 */         agg_value31 = agg_value32 + 1L;
/* 284 */         // update fast row
/* 285 */         agg_fastAggBuffer1.setLong(0, agg_value31);
/* 286 */
/* 287 */       } else {
/* 288 */         // update unsafe row
/* 289 */
/* 290 */         // common sub-expressions
/* 291 */
/* 292 */         // evaluate aggregate function
/* 293 */         boolean agg_isNull26 = false;
/* 294 */
/* 295 */         long agg_value29 = agg_unsafeRowAggBuffer1.getLong(0);
/* 296 */
/* 297 */         long agg_value28 = -1L;
/* 298 */         agg_value28 = agg_value29 + 1L;
/* 299 */         // update unsafe row buffer
/* 300 */         agg_unsafeRowAggBuffer1.setLong(0, agg_value28);
/* 301 */
/* 302 */       }
/* 303 */
/* 304 */       if (shouldStop()) return;
/* 305 */     }
/* 306 */
/* 307 */     agg_mapIter1.close();
/* 308 */     if (agg_sorter1 == null) {
/* 309 */       agg_hashMap1.free();
/* 310 */     }
/* 311 */
/* 312 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 313 */
/* 314 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 315 */   }
/* 316 */
/* 317 */   private void agg_doAggregateWithKeys1() throws java.io.IOException {
/* 318 */     agg_hashMap1 = agg_plan1.createHashMap();
/* 319 */
/* 320 */     while (inputadapter_input.hasNext()) {
/* 321 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 322 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 323 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 324 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 325 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 326 */
/* 327 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 328 */
/* 329 */       UnsafeRow agg_fastAggBuffer = null;
/* 330 */
/* 331 */       if (agg_fastAggBuffer == null) {
/* 332 */         // generate grouping key
/* 333 */         agg_rowWriter.zeroOutNullBytes();
/* 334 */
/* 335 */         if (inputadapter_isNull) {
/* 336 */           agg_rowWriter.setNullAt(0);
/* 337 */         } else {
/* 338 */           agg_rowWriter.write(0, inputadapter_value);
/* 339 */         }
/* 340 */         agg_value6 = 42;
/* 341 */
/* 342 */         if (!inputadapter_isNull) {
/* 343 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value6);
/* 344 */         }
/* 345 */         if (true) {
/* 346 */           // try to get the buffer from hash map
/* 347 */           agg_unsafeRowAggBuffer =
/* 348 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result1, agg_value6);
/* 349 */         }
/* 350 */         if (agg_unsafeRowAggBuffer == null) {
/* 351 */           if (agg_sorter1 == null) {
/* 352 */             agg_sorter1 = agg_hashMap1.destructAndCreateExternalSorter();
/* 353 */           } else {
/* 354 */             agg_sorter1.merge(agg_hashMap1.destructAndCreateExternalSorter());
/* 355 */           }
/* 356 */
/* 357 */           // the hash map had be spilled, it should have enough memory now,
/* 358 */           // try  to allocate buffer again.
/* 359 */           agg_unsafeRowAggBuffer =
/* 360 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result1, agg_value6);
/* 361 */           if (agg_unsafeRowAggBuffer == null) {
/* 362 */             // failed to allocate the first page
/* 363 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 364 */           }
/* 365 */         }
/* 366 */       }
/* 367 */
/* 368 */       if (agg_fastAggBuffer != null) {
/* 369 */         // update fast row
/* 370 */
/* 371 */       } else {
/* 372 */         // update unsafe row
/* 373 */
/* 374 */         // common sub-expressions
/* 375 */
/* 376 */         // evaluate aggregate function
/* 377 */         boolean agg_isNull7 = true;
/* 378 */         double agg_value9 = -1.0;
/* 379 */
/* 380 */         boolean agg_isNull9 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 381 */         double agg_value11 = agg_isNull9 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 382 */         boolean agg_isNull8 = agg_isNull9;
/* 383 */         double agg_value10 = agg_value11;
/* 384 */         if (agg_isNull8) {
/* 385 */           boolean agg_isNull10 = false;
/* 386 */           double agg_value12 = -1.0;
/* 387 */           if (!false) {
/* 388 */             agg_value12 = (double) 0;
/* 389 */           }
/* 390 */           if (!agg_isNull10) {
/* 391 */             agg_isNull8 = false;
/* 392 */             agg_value10 = agg_value12;
/* 393 */           }
/* 394 */         }
/* 395 */
/* 396 */         if (!inputadapter_isNull1) {
/* 397 */           agg_isNull7 = false; // resultCode could change nullability.
/* 398 */           agg_value9 = agg_value10 + inputadapter_value1;
/* 399 */
/* 400 */         }
/* 401 */         boolean agg_isNull6 = agg_isNull7;
/* 402 */         double agg_value8 = agg_value9;
/* 403 */         if (agg_isNull6) {
/* 404 */           boolean agg_isNull13 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 405 */           double agg_value15 = agg_isNull13 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 406 */           if (!agg_isNull13) {
/* 407 */             agg_isNull6 = false;
/* 408 */             agg_value8 = agg_value15;
/* 409 */           }
/* 410 */         }
/* 411 */         // update unsafe row buffer
/* 412 */         if (!agg_isNull6) {
/* 413 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value8);
/* 414 */         } else {
/* 415 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 416 */         }
/* 417 */
/* 418 */       }
/* 419 */       if (shouldStop()) return;
/* 420 */     }
/* 421 */
/* 422 */     agg_mapIter1 = agg_plan1.finishAggregate(agg_hashMap1, agg_sorter1, agg_peakMemory1, agg_spillSize1);
/* 423 */   }
/* 424 */
/* 425 */   private void wholestagecodegen_init_1() {
/* 426 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 1);
/* 427 */     agg_result3 = new UnsafeRow(1);
/* 428 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 0);
/* 429 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 1);
/* 430 */
/* 431 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 432 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 433 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 434 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 435 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
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
/* 451 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 452 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 453 */
/* 454 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 455 */
/* 456 */       append(agg_resultRow);
/* 457 */
/* 458 */       if (shouldStop()) return;
/* 459 */     }
/* 460 */     agg_fastHashMap.close();
/* 461 */
/* 462 */     while (agg_mapIter.next()) {
/* 463 */       wholestagecodegen_numOutputRows.add(1);
/* 464 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_mapIter.getKey();
/* 465 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_mapIter.getValue();
/* 466 */
/* 467 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
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

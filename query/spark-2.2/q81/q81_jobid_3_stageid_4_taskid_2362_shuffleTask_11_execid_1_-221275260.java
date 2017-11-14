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
/* 076 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 077 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 078 */
/* 079 */     agg_result2 = new UnsafeRow(2);
/* 080 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 32);
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
/* 092 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType);
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
/* 117 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key) {
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
/* 129 */               32);
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
/* 164 */     private boolean equals(int idx, UTF8String agg_key) {
/* 165 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 166 */       return (row.getUTF8String(0).equals(agg_key));
/* 167 */     }
/* 168 */
/* 169 */     private long hash(UTF8String agg_key) {
/* 170 */       long agg_hash = 0;
/* 171 */
/* 172 */       int agg_result = 0;
/* 173 */       byte[] agg_bytes = agg_key.getBytes();
/* 174 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 175 */         int agg_hash1 = agg_bytes[i];
/* 176 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 177 */       }
/* 178 */
/* 179 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 180 */
/* 181 */       return agg_hash;
/* 182 */     }
/* 183 */
/* 184 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 185 */       return batch.rowIterator();
/* 186 */     }
/* 187 */
/* 188 */     public void close() {
/* 189 */       batch.close();
/* 190 */     }
/* 191 */
/* 192 */   }
/* 193 */
/* 194 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 195 */     agg_hashMap = agg_plan.createHashMap();
/* 196 */
/* 197 */     if (!agg_initAgg1) {
/* 198 */       agg_initAgg1 = true;
/* 199 */       long agg_beforeAgg = System.nanoTime();
/* 200 */       agg_doAggregateWithKeys1();
/* 201 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 202 */     }
/* 203 */
/* 204 */     // output the result
/* 205 */
/* 206 */     while (agg_mapIter1.next()) {
/* 207 */       agg_numOutputRows.add(1);
/* 208 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter1.getKey();
/* 209 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter1.getValue();
/* 210 */
/* 211 */       boolean agg_isNull19 = agg_aggKey.isNullAt(0);
/* 212 */       int agg_value22 = agg_isNull19 ? -1 : (agg_aggKey.getInt(0));
/* 213 */       boolean agg_isNull20 = agg_aggKey.isNullAt(1);
/* 214 */       UTF8String agg_value23 = agg_isNull20 ? null : (agg_aggKey.getUTF8String(1));
/* 215 */       boolean agg_isNull21 = agg_aggBuffer.isNullAt(0);
/* 216 */       double agg_value24 = agg_isNull21 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 217 */
/* 218 */       UnsafeRow agg_unsafeRowAggBuffer1 = null;
/* 219 */
/* 220 */       UnsafeRow agg_fastAggBuffer1 = null;
/* 221 */
/* 222 */       if (true) {
/* 223 */         if (!agg_isNull20) {
/* 224 */           agg_fastAggBuffer1 = agg_fastHashMap.findOrInsert(
/* 225 */             agg_value23);
/* 226 */         }
/* 227 */       }
/* 228 */
/* 229 */       if (agg_fastAggBuffer1 == null) {
/* 230 */         // generate grouping key
/* 231 */         agg_holder2.reset();
/* 232 */
/* 233 */         agg_rowWriter2.zeroOutNullBytes();
/* 234 */
/* 235 */         if (agg_isNull20) {
/* 236 */           agg_rowWriter2.setNullAt(0);
/* 237 */         } else {
/* 238 */           agg_rowWriter2.write(0, agg_value23);
/* 239 */         }
/* 240 */         agg_result3.setTotalSize(agg_holder2.totalSize());
/* 241 */         agg_value32 = 42;
/* 242 */
/* 243 */         if (!agg_isNull20) {
/* 244 */           agg_value32 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(agg_value23.getBaseObject(), agg_value23.getBaseOffset(), agg_value23.numBytes(), agg_value32);
/* 245 */         }
/* 246 */         if (true) {
/* 247 */           // try to get the buffer from hash map
/* 248 */           agg_unsafeRowAggBuffer1 =
/* 249 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value32);
/* 250 */         }
/* 251 */         if (agg_unsafeRowAggBuffer1 == null) {
/* 252 */           if (agg_sorter == null) {
/* 253 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 254 */           } else {
/* 255 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 256 */           }
/* 257 */
/* 258 */           // the hash map had be spilled, it should have enough memory now,
/* 259 */           // try  to allocate buffer again.
/* 260 */           agg_unsafeRowAggBuffer1 =
/* 261 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value32);
/* 262 */           if (agg_unsafeRowAggBuffer1 == null) {
/* 263 */             // failed to allocate the first page
/* 264 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 265 */           }
/* 266 */         }
/* 267 */       }
/* 268 */
/* 269 */       if (agg_fastAggBuffer1 != null) {
/* 270 */         // update fast row
/* 271 */
/* 272 */         // common sub-expressions
/* 273 */
/* 274 */         // evaluate aggregate function
/* 275 */         boolean agg_isNull44 = true;
/* 276 */         double agg_value47 = -1.0;
/* 277 */
/* 278 */         boolean agg_isNull45 = agg_fastAggBuffer1.isNullAt(0);
/* 279 */         double agg_value48 = agg_isNull45 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 280 */         if (!agg_isNull45) {
/* 281 */           boolean agg_isNull46 = agg_isNull21;
/* 282 */           double agg_value49 = agg_value24;
/* 283 */           if (agg_isNull46) {
/* 284 */             boolean agg_isNull48 = false;
/* 285 */             double agg_value51 = -1.0;
/* 286 */             if (!false) {
/* 287 */               agg_value51 = (double) 0;
/* 288 */             }
/* 289 */             if (!agg_isNull48) {
/* 290 */               agg_isNull46 = false;
/* 291 */               agg_value49 = agg_value51;
/* 292 */             }
/* 293 */           }
/* 294 */
/* 295 */           agg_isNull44 = false; // resultCode could change nullability.
/* 296 */           agg_value47 = agg_value48 + agg_value49;
/* 297 */
/* 298 */         }
/* 299 */         boolean agg_isNull50 = false;
/* 300 */         long agg_value53 = -1L;
/* 301 */         if (!false && agg_isNull21) {
/* 302 */           boolean agg_isNull53 = agg_fastAggBuffer1.isNullAt(1);
/* 303 */           long agg_value56 = agg_isNull53 ? -1L : (agg_fastAggBuffer1.getLong(1));
/* 304 */           agg_isNull50 = agg_isNull53;
/* 305 */           agg_value53 = agg_value56;
/* 306 */         } else {
/* 307 */           boolean agg_isNull54 = true;
/* 308 */           long agg_value57 = -1L;
/* 309 */
/* 310 */           boolean agg_isNull55 = agg_fastAggBuffer1.isNullAt(1);
/* 311 */           long agg_value58 = agg_isNull55 ? -1L : (agg_fastAggBuffer1.getLong(1));
/* 312 */           if (!agg_isNull55) {
/* 313 */             agg_isNull54 = false; // resultCode could change nullability.
/* 314 */             agg_value57 = agg_value58 + 1L;
/* 315 */
/* 316 */           }
/* 317 */           agg_isNull50 = agg_isNull54;
/* 318 */           agg_value53 = agg_value57;
/* 319 */         }
/* 320 */         // update fast row
/* 321 */         if (!agg_isNull44) {
/* 322 */           agg_fastAggBuffer1.setDouble(0, agg_value47);
/* 323 */         } else {
/* 324 */           agg_fastAggBuffer1.setNullAt(0);
/* 325 */         }
/* 326 */
/* 327 */         if (!agg_isNull50) {
/* 328 */           agg_fastAggBuffer1.setLong(1, agg_value53);
/* 329 */         } else {
/* 330 */           agg_fastAggBuffer1.setNullAt(1);
/* 331 */         }
/* 332 */
/* 333 */       } else {
/* 334 */         // update unsafe row
/* 335 */
/* 336 */         // common sub-expressions
/* 337 */
/* 338 */         // evaluate aggregate function
/* 339 */         boolean agg_isNull31 = true;
/* 340 */         double agg_value34 = -1.0;
/* 341 */
/* 342 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 343 */         double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 344 */         if (!agg_isNull32) {
/* 345 */           boolean agg_isNull33 = agg_isNull21;
/* 346 */           double agg_value36 = agg_value24;
/* 347 */           if (agg_isNull33) {
/* 348 */             boolean agg_isNull35 = false;
/* 349 */             double agg_value38 = -1.0;
/* 350 */             if (!false) {
/* 351 */               agg_value38 = (double) 0;
/* 352 */             }
/* 353 */             if (!agg_isNull35) {
/* 354 */               agg_isNull33 = false;
/* 355 */               agg_value36 = agg_value38;
/* 356 */             }
/* 357 */           }
/* 358 */
/* 359 */           agg_isNull31 = false; // resultCode could change nullability.
/* 360 */           agg_value34 = agg_value35 + agg_value36;
/* 361 */
/* 362 */         }
/* 363 */         boolean agg_isNull37 = false;
/* 364 */         long agg_value40 = -1L;
/* 365 */         if (!false && agg_isNull21) {
/* 366 */           boolean agg_isNull40 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 367 */           long agg_value43 = agg_isNull40 ? -1L : (agg_unsafeRowAggBuffer1.getLong(1));
/* 368 */           agg_isNull37 = agg_isNull40;
/* 369 */           agg_value40 = agg_value43;
/* 370 */         } else {
/* 371 */           boolean agg_isNull41 = true;
/* 372 */           long agg_value44 = -1L;
/* 373 */
/* 374 */           boolean agg_isNull42 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 375 */           long agg_value45 = agg_isNull42 ? -1L : (agg_unsafeRowAggBuffer1.getLong(1));
/* 376 */           if (!agg_isNull42) {
/* 377 */             agg_isNull41 = false; // resultCode could change nullability.
/* 378 */             agg_value44 = agg_value45 + 1L;
/* 379 */
/* 380 */           }
/* 381 */           agg_isNull37 = agg_isNull41;
/* 382 */           agg_value40 = agg_value44;
/* 383 */         }
/* 384 */         // update unsafe row buffer
/* 385 */         if (!agg_isNull31) {
/* 386 */           agg_unsafeRowAggBuffer1.setDouble(0, agg_value34);
/* 387 */         } else {
/* 388 */           agg_unsafeRowAggBuffer1.setNullAt(0);
/* 389 */         }
/* 390 */
/* 391 */         if (!agg_isNull37) {
/* 392 */           agg_unsafeRowAggBuffer1.setLong(1, agg_value40);
/* 393 */         } else {
/* 394 */           agg_unsafeRowAggBuffer1.setNullAt(1);
/* 395 */         }
/* 396 */
/* 397 */       }
/* 398 */
/* 399 */       if (shouldStop()) return;
/* 400 */     }
/* 401 */
/* 402 */     agg_mapIter1.close();
/* 403 */     if (agg_sorter1 == null) {
/* 404 */       agg_hashMap1.free();
/* 405 */     }
/* 406 */
/* 407 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 408 */
/* 409 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 410 */   }
/* 411 */
/* 412 */   private void agg_doAggregateWithKeys1() throws java.io.IOException {
/* 413 */     agg_hashMap1 = agg_plan1.createHashMap();
/* 414 */
/* 415 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 416 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 417 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 418 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 419 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 420 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 421 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 422 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 423 */
/* 424 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 425 */
/* 426 */       UnsafeRow agg_fastAggBuffer = null;
/* 427 */
/* 428 */       if (agg_fastAggBuffer == null) {
/* 429 */         // generate grouping key
/* 430 */         agg_holder.reset();
/* 431 */
/* 432 */         agg_rowWriter.zeroOutNullBytes();
/* 433 */
/* 434 */         if (inputadapter_isNull) {
/* 435 */           agg_rowWriter.setNullAt(0);
/* 436 */         } else {
/* 437 */           agg_rowWriter.write(0, inputadapter_value);
/* 438 */         }
/* 439 */
/* 440 */         if (inputadapter_isNull1) {
/* 441 */           agg_rowWriter.setNullAt(1);
/* 442 */         } else {
/* 443 */           agg_rowWriter.write(1, inputadapter_value1);
/* 444 */         }
/* 445 */         agg_result1.setTotalSize(agg_holder.totalSize());
/* 446 */         agg_value11 = 42;
/* 447 */
/* 448 */         if (!inputadapter_isNull) {
/* 449 */           agg_value11 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value11);
/* 450 */         }
/* 451 */
/* 452 */         if (!inputadapter_isNull1) {
/* 453 */           agg_value11 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value11);
/* 454 */         }
/* 455 */         if (true) {
/* 456 */           // try to get the buffer from hash map
/* 457 */           agg_unsafeRowAggBuffer =
/* 458 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result1, agg_value11);
/* 459 */         }
/* 460 */         if (agg_unsafeRowAggBuffer == null) {
/* 461 */           if (agg_sorter1 == null) {
/* 462 */             agg_sorter1 = agg_hashMap1.destructAndCreateExternalSorter();
/* 463 */           } else {
/* 464 */             agg_sorter1.merge(agg_hashMap1.destructAndCreateExternalSorter());
/* 465 */           }
/* 466 */
/* 467 */           // the hash map had be spilled, it should have enough memory now,
/* 468 */           // try  to allocate buffer again.
/* 469 */           agg_unsafeRowAggBuffer =
/* 470 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result1, agg_value11);
/* 471 */           if (agg_unsafeRowAggBuffer == null) {
/* 472 */             // failed to allocate the first page
/* 473 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 474 */           }
/* 475 */         }
/* 476 */       }
/* 477 */
/* 478 */       if (agg_fastAggBuffer != null) {
/* 479 */         // update fast row
/* 480 */
/* 481 */       } else {
/* 482 */         // update unsafe row
/* 483 */
/* 484 */         // common sub-expressions
/* 485 */
/* 486 */         // evaluate aggregate function
/* 487 */         boolean agg_isNull12 = true;
/* 488 */         double agg_value15 = -1.0;
/* 489 */
/* 490 */         boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 491 */         double agg_value17 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 492 */         boolean agg_isNull13 = agg_isNull14;
/* 493 */         double agg_value16 = agg_value17;
/* 494 */         if (agg_isNull13) {
/* 495 */           boolean agg_isNull15 = false;
/* 496 */           double agg_value18 = -1.0;
/* 497 */           if (!false) {
/* 498 */             agg_value18 = (double) 0;
/* 499 */           }
/* 500 */           if (!agg_isNull15) {
/* 501 */             agg_isNull13 = false;
/* 502 */             agg_value16 = agg_value18;
/* 503 */           }
/* 504 */         }
/* 505 */
/* 506 */         if (!inputadapter_isNull2) {
/* 507 */           agg_isNull12 = false; // resultCode could change nullability.
/* 508 */           agg_value15 = agg_value16 + inputadapter_value2;
/* 509 */
/* 510 */         }
/* 511 */         boolean agg_isNull11 = agg_isNull12;
/* 512 */         double agg_value14 = agg_value15;
/* 513 */         if (agg_isNull11) {
/* 514 */           boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 515 */           double agg_value21 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 516 */           if (!agg_isNull18) {
/* 517 */             agg_isNull11 = false;
/* 518 */             agg_value14 = agg_value21;
/* 519 */           }
/* 520 */         }
/* 521 */         // update unsafe row buffer
/* 522 */         if (!agg_isNull11) {
/* 523 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value14);
/* 524 */         } else {
/* 525 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 526 */         }
/* 527 */
/* 528 */       }
/* 529 */       if (shouldStop()) return;
/* 530 */     }
/* 531 */
/* 532 */     agg_mapIter1 = agg_plan1.finishAggregate(agg_hashMap1, agg_sorter1, agg_peakMemory1, agg_spillSize1);
/* 533 */   }
/* 534 */
/* 535 */   private void wholestagecodegen_init_1() {
/* 536 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 537 */     agg_result3 = new UnsafeRow(1);
/* 538 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 32);
/* 539 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 1);
/* 540 */
/* 541 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 542 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 543 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 544 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 545 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 546 */
/* 547 */   }
/* 548 */
/* 549 */   protected void processNext() throws java.io.IOException {
/* 550 */     if (!agg_initAgg) {
/* 551 */       agg_initAgg = true;
/* 552 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 553 */       agg_doAggregateWithKeys();
/* 554 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 555 */     }
/* 556 */
/* 557 */     // output the result
/* 558 */
/* 559 */     while (agg_fastHashMapIter.next()) {
/* 560 */       wholestagecodegen_numOutputRows.add(1);
/* 561 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 562 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 563 */
/* 564 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 565 */
/* 566 */       append(agg_resultRow);
/* 567 */
/* 568 */       if (shouldStop()) return;
/* 569 */     }
/* 570 */     agg_fastHashMap.close();
/* 571 */
/* 572 */     while (agg_mapIter.next()) {
/* 573 */       wholestagecodegen_numOutputRows.add(1);
/* 574 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_mapIter.getKey();
/* 575 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_mapIter.getValue();
/* 576 */
/* 577 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 578 */
/* 579 */       append(agg_resultRow);
/* 580 */
/* 581 */       if (shouldStop()) return;
/* 582 */     }
/* 583 */
/* 584 */     agg_mapIter.close();
/* 585 */     if (agg_sorter == null) {
/* 586 */       agg_hashMap.free();
/* 587 */     }
/* 588 */   }
/* 589 */ }

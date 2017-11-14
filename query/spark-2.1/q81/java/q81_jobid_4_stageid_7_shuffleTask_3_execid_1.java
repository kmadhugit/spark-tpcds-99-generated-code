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
/* 092 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("ctr_state", org.apache.spark.sql.types.DataTypes.StringType);
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
/* 275 */         boolean agg_isNull45 = true;
/* 276 */         double agg_value48 = -1.0;
/* 277 */
/* 278 */         boolean agg_isNull46 = agg_fastAggBuffer1.isNullAt(0);
/* 279 */         double agg_value49 = agg_isNull46 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 280 */         if (!agg_isNull46) {
/* 281 */           boolean agg_isNull48 = agg_isNull21;
/* 282 */           double agg_value51 = -1.0;
/* 283 */           if (!agg_isNull21) {
/* 284 */             agg_value51 = agg_value24;
/* 285 */           }
/* 286 */           boolean agg_isNull47 = agg_isNull48;
/* 287 */           double agg_value50 = agg_value51;
/* 288 */           if (agg_isNull47) {
/* 289 */             boolean agg_isNull50 = false;
/* 290 */             double agg_value53 = -1.0;
/* 291 */             if (!false) {
/* 292 */               agg_value53 = (double) 0;
/* 293 */             }
/* 294 */             if (!agg_isNull50) {
/* 295 */               agg_isNull47 = false;
/* 296 */               agg_value50 = agg_value53;
/* 297 */             }
/* 298 */           }
/* 299 */
/* 300 */           agg_isNull45 = false; // resultCode could change nullability.
/* 301 */           agg_value48 = agg_value49 + agg_value50;
/* 302 */
/* 303 */         }
/* 304 */         boolean agg_isNull52 = false;
/* 305 */         long agg_value55 = -1L;
/* 306 */         if (!false && agg_isNull21) {
/* 307 */           boolean agg_isNull55 = agg_fastAggBuffer1.isNullAt(1);
/* 308 */           long agg_value58 = agg_isNull55 ? -1L : (agg_fastAggBuffer1.getLong(1));
/* 309 */           agg_isNull52 = agg_isNull55;
/* 310 */           agg_value55 = agg_value58;
/* 311 */         } else {
/* 312 */           boolean agg_isNull56 = true;
/* 313 */           long agg_value59 = -1L;
/* 314 */
/* 315 */           boolean agg_isNull57 = agg_fastAggBuffer1.isNullAt(1);
/* 316 */           long agg_value60 = agg_isNull57 ? -1L : (agg_fastAggBuffer1.getLong(1));
/* 317 */           if (!agg_isNull57) {
/* 318 */             agg_isNull56 = false; // resultCode could change nullability.
/* 319 */             agg_value59 = agg_value60 + 1L;
/* 320 */
/* 321 */           }
/* 322 */           agg_isNull52 = agg_isNull56;
/* 323 */           agg_value55 = agg_value59;
/* 324 */         }
/* 325 */         // update fast row
/* 326 */         if (!agg_isNull45) {
/* 327 */           agg_fastAggBuffer1.setDouble(0, agg_value48);
/* 328 */         } else {
/* 329 */           agg_fastAggBuffer1.setNullAt(0);
/* 330 */         }
/* 331 */
/* 332 */         if (!agg_isNull52) {
/* 333 */           agg_fastAggBuffer1.setLong(1, agg_value55);
/* 334 */         } else {
/* 335 */           agg_fastAggBuffer1.setNullAt(1);
/* 336 */         }
/* 337 */
/* 338 */       } else {
/* 339 */         // update unsafe row
/* 340 */
/* 341 */         // common sub-expressions
/* 342 */
/* 343 */         // evaluate aggregate function
/* 344 */         boolean agg_isNull31 = true;
/* 345 */         double agg_value34 = -1.0;
/* 346 */
/* 347 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 348 */         double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 349 */         if (!agg_isNull32) {
/* 350 */           boolean agg_isNull34 = agg_isNull21;
/* 351 */           double agg_value37 = -1.0;
/* 352 */           if (!agg_isNull21) {
/* 353 */             agg_value37 = agg_value24;
/* 354 */           }
/* 355 */           boolean agg_isNull33 = agg_isNull34;
/* 356 */           double agg_value36 = agg_value37;
/* 357 */           if (agg_isNull33) {
/* 358 */             boolean agg_isNull36 = false;
/* 359 */             double agg_value39 = -1.0;
/* 360 */             if (!false) {
/* 361 */               agg_value39 = (double) 0;
/* 362 */             }
/* 363 */             if (!agg_isNull36) {
/* 364 */               agg_isNull33 = false;
/* 365 */               agg_value36 = agg_value39;
/* 366 */             }
/* 367 */           }
/* 368 */
/* 369 */           agg_isNull31 = false; // resultCode could change nullability.
/* 370 */           agg_value34 = agg_value35 + agg_value36;
/* 371 */
/* 372 */         }
/* 373 */         boolean agg_isNull38 = false;
/* 374 */         long agg_value41 = -1L;
/* 375 */         if (!false && agg_isNull21) {
/* 376 */           boolean agg_isNull41 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 377 */           long agg_value44 = agg_isNull41 ? -1L : (agg_unsafeRowAggBuffer1.getLong(1));
/* 378 */           agg_isNull38 = agg_isNull41;
/* 379 */           agg_value41 = agg_value44;
/* 380 */         } else {
/* 381 */           boolean agg_isNull42 = true;
/* 382 */           long agg_value45 = -1L;
/* 383 */
/* 384 */           boolean agg_isNull43 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 385 */           long agg_value46 = agg_isNull43 ? -1L : (agg_unsafeRowAggBuffer1.getLong(1));
/* 386 */           if (!agg_isNull43) {
/* 387 */             agg_isNull42 = false; // resultCode could change nullability.
/* 388 */             agg_value45 = agg_value46 + 1L;
/* 389 */
/* 390 */           }
/* 391 */           agg_isNull38 = agg_isNull42;
/* 392 */           agg_value41 = agg_value45;
/* 393 */         }
/* 394 */         // update unsafe row buffer
/* 395 */         if (!agg_isNull31) {
/* 396 */           agg_unsafeRowAggBuffer1.setDouble(0, agg_value34);
/* 397 */         } else {
/* 398 */           agg_unsafeRowAggBuffer1.setNullAt(0);
/* 399 */         }
/* 400 */
/* 401 */         if (!agg_isNull38) {
/* 402 */           agg_unsafeRowAggBuffer1.setLong(1, agg_value41);
/* 403 */         } else {
/* 404 */           agg_unsafeRowAggBuffer1.setNullAt(1);
/* 405 */         }
/* 406 */
/* 407 */       }
/* 408 */
/* 409 */       if (shouldStop()) return;
/* 410 */     }
/* 411 */
/* 412 */     agg_mapIter1.close();
/* 413 */     if (agg_sorter1 == null) {
/* 414 */       agg_hashMap1.free();
/* 415 */     }
/* 416 */
/* 417 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 418 */
/* 419 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 420 */   }
/* 421 */
/* 422 */   private void agg_doAggregateWithKeys1() throws java.io.IOException {
/* 423 */     agg_hashMap1 = agg_plan1.createHashMap();
/* 424 */
/* 425 */     while (inputadapter_input.hasNext()) {
/* 426 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 427 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 428 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 429 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 430 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 431 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 432 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 433 */
/* 434 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 435 */
/* 436 */       UnsafeRow agg_fastAggBuffer = null;
/* 437 */
/* 438 */       if (agg_fastAggBuffer == null) {
/* 439 */         // generate grouping key
/* 440 */         agg_holder.reset();
/* 441 */
/* 442 */         agg_rowWriter.zeroOutNullBytes();
/* 443 */
/* 444 */         if (inputadapter_isNull) {
/* 445 */           agg_rowWriter.setNullAt(0);
/* 446 */         } else {
/* 447 */           agg_rowWriter.write(0, inputadapter_value);
/* 448 */         }
/* 449 */
/* 450 */         if (inputadapter_isNull1) {
/* 451 */           agg_rowWriter.setNullAt(1);
/* 452 */         } else {
/* 453 */           agg_rowWriter.write(1, inputadapter_value1);
/* 454 */         }
/* 455 */         agg_result1.setTotalSize(agg_holder.totalSize());
/* 456 */         agg_value11 = 42;
/* 457 */
/* 458 */         if (!inputadapter_isNull) {
/* 459 */           agg_value11 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value11);
/* 460 */         }
/* 461 */
/* 462 */         if (!inputadapter_isNull1) {
/* 463 */           agg_value11 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value11);
/* 464 */         }
/* 465 */         if (true) {
/* 466 */           // try to get the buffer from hash map
/* 467 */           agg_unsafeRowAggBuffer =
/* 468 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result1, agg_value11);
/* 469 */         }
/* 470 */         if (agg_unsafeRowAggBuffer == null) {
/* 471 */           if (agg_sorter1 == null) {
/* 472 */             agg_sorter1 = agg_hashMap1.destructAndCreateExternalSorter();
/* 473 */           } else {
/* 474 */             agg_sorter1.merge(agg_hashMap1.destructAndCreateExternalSorter());
/* 475 */           }
/* 476 */
/* 477 */           // the hash map had be spilled, it should have enough memory now,
/* 478 */           // try  to allocate buffer again.
/* 479 */           agg_unsafeRowAggBuffer =
/* 480 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result1, agg_value11);
/* 481 */           if (agg_unsafeRowAggBuffer == null) {
/* 482 */             // failed to allocate the first page
/* 483 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 484 */           }
/* 485 */         }
/* 486 */       }
/* 487 */
/* 488 */       if (agg_fastAggBuffer != null) {
/* 489 */         // update fast row
/* 490 */
/* 491 */       } else {
/* 492 */         // update unsafe row
/* 493 */
/* 494 */         // common sub-expressions
/* 495 */
/* 496 */         // evaluate aggregate function
/* 497 */         boolean agg_isNull12 = true;
/* 498 */         double agg_value15 = -1.0;
/* 499 */
/* 500 */         boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 501 */         double agg_value17 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 502 */         boolean agg_isNull13 = agg_isNull14;
/* 503 */         double agg_value16 = agg_value17;
/* 504 */         if (agg_isNull13) {
/* 505 */           boolean agg_isNull15 = false;
/* 506 */           double agg_value18 = -1.0;
/* 507 */           if (!false) {
/* 508 */             agg_value18 = (double) 0;
/* 509 */           }
/* 510 */           if (!agg_isNull15) {
/* 511 */             agg_isNull13 = false;
/* 512 */             agg_value16 = agg_value18;
/* 513 */           }
/* 514 */         }
/* 515 */
/* 516 */         if (!inputadapter_isNull2) {
/* 517 */           agg_isNull12 = false; // resultCode could change nullability.
/* 518 */           agg_value15 = agg_value16 + inputadapter_value2;
/* 519 */
/* 520 */         }
/* 521 */         boolean agg_isNull11 = agg_isNull12;
/* 522 */         double agg_value14 = agg_value15;
/* 523 */         if (agg_isNull11) {
/* 524 */           boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 525 */           double agg_value21 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 526 */           if (!agg_isNull18) {
/* 527 */             agg_isNull11 = false;
/* 528 */             agg_value14 = agg_value21;
/* 529 */           }
/* 530 */         }
/* 531 */         // update unsafe row buffer
/* 532 */         if (!agg_isNull11) {
/* 533 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value14);
/* 534 */         } else {
/* 535 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 536 */         }
/* 537 */
/* 538 */       }
/* 539 */       if (shouldStop()) return;
/* 540 */     }
/* 541 */
/* 542 */     agg_mapIter1 = agg_plan1.finishAggregate(agg_hashMap1, agg_sorter1, agg_peakMemory1, agg_spillSize1);
/* 543 */   }
/* 544 */
/* 545 */   private void wholestagecodegen_init_1() {
/* 546 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 547 */     agg_result3 = new UnsafeRow(1);
/* 548 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 32);
/* 549 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 1);
/* 550 */
/* 551 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 552 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 553 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 554 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 555 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 556 */
/* 557 */   }
/* 558 */
/* 559 */   protected void processNext() throws java.io.IOException {
/* 560 */     if (!agg_initAgg) {
/* 561 */       agg_initAgg = true;
/* 562 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 563 */       agg_doAggregateWithKeys();
/* 564 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 565 */     }
/* 566 */
/* 567 */     // output the result
/* 568 */
/* 569 */     while (agg_fastHashMapIter.next()) {
/* 570 */       wholestagecodegen_numOutputRows.add(1);
/* 571 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 572 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 573 */
/* 574 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 575 */
/* 576 */       append(agg_resultRow);
/* 577 */
/* 578 */       if (shouldStop()) return;
/* 579 */     }
/* 580 */     agg_fastHashMap.close();
/* 581 */
/* 582 */     while (agg_mapIter.next()) {
/* 583 */       wholestagecodegen_numOutputRows.add(1);
/* 584 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_mapIter.getKey();
/* 585 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_mapIter.getValue();
/* 586 */
/* 587 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey1, agg_aggBuffer1);
/* 588 */
/* 589 */       append(agg_resultRow);
/* 590 */
/* 591 */       if (shouldStop()) return;
/* 592 */     }
/* 593 */
/* 594 */     agg_mapIter.close();
/* 595 */     if (agg_sorter == null) {
/* 596 */       agg_hashMap.free();
/* 597 */     }
/* 598 */   }
/* 599 */ }

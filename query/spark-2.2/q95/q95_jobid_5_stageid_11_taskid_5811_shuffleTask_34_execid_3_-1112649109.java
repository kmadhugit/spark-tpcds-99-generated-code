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
/* 012 */   private double agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private long agg_bufValue2;
/* 015 */   private boolean agg_initAgg1;
/* 016 */   private boolean agg_bufIsNull3;
/* 017 */   private double agg_bufValue3;
/* 018 */   private boolean agg_bufIsNull4;
/* 019 */   private double agg_bufValue4;
/* 020 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 021 */   private agg_FastHashMap agg_fastHashMap;
/* 022 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 023 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 024 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 025 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 028 */   private scala.collection.Iterator inputadapter_input;
/* 029 */   private UnsafeRow agg_result1;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 032 */   private int agg_value9;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows1;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime1;
/* 038 */   private UnsafeRow agg_result2;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 041 */
/* 042 */   public GeneratedIterator(Object[] references) {
/* 043 */     this.references = references;
/* 044 */   }
/* 045 */
/* 046 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 047 */     partitionIndex = index;
/* 048 */     this.inputs = inputs;
/* 049 */     wholestagecodegen_init_0();
/* 050 */     wholestagecodegen_init_1();
/* 051 */
/* 052 */   }
/* 053 */
/* 054 */   private void wholestagecodegen_init_0() {
/* 055 */     agg_initAgg = false;
/* 056 */
/* 057 */     agg_initAgg1 = false;
/* 058 */
/* 059 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 060 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 061 */
/* 062 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 063 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 064 */     inputadapter_input = inputs[0];
/* 065 */     agg_result1 = new UnsafeRow(1);
/* 066 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 067 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 068 */
/* 069 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 070 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 071 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 072 */     this.agg_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 073 */     this.agg_aggTime1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 074 */
/* 075 */   }
/* 076 */
/* 077 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 078 */     // initialize aggregation buffer
/* 079 */     final double agg_value = -1.0;
/* 080 */     agg_bufIsNull = true;
/* 081 */     agg_bufValue = agg_value;
/* 082 */     final double agg_value1 = -1.0;
/* 083 */     agg_bufIsNull1 = true;
/* 084 */     agg_bufValue1 = agg_value1;
/* 085 */     agg_bufIsNull2 = false;
/* 086 */     agg_bufValue2 = 0L;
/* 087 */
/* 088 */     if (!agg_initAgg1) {
/* 089 */       agg_initAgg1 = true;
/* 090 */       long agg_beforeAgg = System.nanoTime();
/* 091 */       agg_doAggregateWithKeys();
/* 092 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 093 */     }
/* 094 */
/* 095 */     // output the result
/* 096 */
/* 097 */     while (agg_fastHashMapIter.next()) {
/* 098 */       agg_numOutputRows.add(1);
/* 099 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 100 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 101 */
/* 102 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 103 */
/* 104 */       boolean agg_isNull41 = agg_resultRow.isNullAt(0);
/* 105 */       int agg_value43 = agg_isNull41 ? -1 : (agg_resultRow.getInt(0));
/* 106 */       boolean agg_isNull42 = agg_resultRow.isNullAt(1);
/* 107 */       double agg_value44 = agg_isNull42 ? -1.0 : (agg_resultRow.getDouble(1));
/* 108 */       boolean agg_isNull43 = agg_resultRow.isNullAt(2);
/* 109 */       double agg_value45 = agg_isNull43 ? -1.0 : (agg_resultRow.getDouble(2));
/* 110 */
/* 111 */       // do aggregate
/* 112 */       // common sub-expressions
/* 113 */
/* 114 */       // evaluate aggregate function
/* 115 */       boolean agg_isNull45 = true;
/* 116 */       double agg_value47 = -1.0;
/* 117 */
/* 118 */       boolean agg_isNull46 = agg_bufIsNull;
/* 119 */       double agg_value48 = agg_bufValue;
/* 120 */       if (agg_isNull46) {
/* 121 */         boolean agg_isNull48 = false;
/* 122 */         double agg_value50 = -1.0;
/* 123 */         if (!false) {
/* 124 */           agg_value50 = (double) 0;
/* 125 */         }
/* 126 */         if (!agg_isNull48) {
/* 127 */           agg_isNull46 = false;
/* 128 */           agg_value48 = agg_value50;
/* 129 */         }
/* 130 */       }
/* 131 */
/* 132 */       if (!agg_isNull42) {
/* 133 */         agg_isNull45 = false; // resultCode could change nullability.
/* 134 */         agg_value47 = agg_value48 + agg_value44;
/* 135 */
/* 136 */       }
/* 137 */       boolean agg_isNull44 = agg_isNull45;
/* 138 */       double agg_value46 = agg_value47;
/* 139 */       if (agg_isNull44) {
/* 140 */         if (!agg_bufIsNull) {
/* 141 */           agg_isNull44 = false;
/* 142 */           agg_value46 = agg_bufValue;
/* 143 */         }
/* 144 */       }
/* 145 */       boolean agg_isNull53 = true;
/* 146 */       double agg_value55 = -1.0;
/* 147 */
/* 148 */       boolean agg_isNull54 = agg_bufIsNull1;
/* 149 */       double agg_value56 = agg_bufValue1;
/* 150 */       if (agg_isNull54) {
/* 151 */         boolean agg_isNull56 = false;
/* 152 */         double agg_value58 = -1.0;
/* 153 */         if (!false) {
/* 154 */           agg_value58 = (double) 0;
/* 155 */         }
/* 156 */         if (!agg_isNull56) {
/* 157 */           agg_isNull54 = false;
/* 158 */           agg_value56 = agg_value58;
/* 159 */         }
/* 160 */       }
/* 161 */
/* 162 */       if (!agg_isNull43) {
/* 163 */         agg_isNull53 = false; // resultCode could change nullability.
/* 164 */         agg_value55 = agg_value56 + agg_value45;
/* 165 */
/* 166 */       }
/* 167 */       boolean agg_isNull52 = agg_isNull53;
/* 168 */       double agg_value54 = agg_value55;
/* 169 */       if (agg_isNull52) {
/* 170 */         if (!agg_bufIsNull1) {
/* 171 */           agg_isNull52 = false;
/* 172 */           agg_value54 = agg_bufValue1;
/* 173 */         }
/* 174 */       }
/* 175 */       boolean agg_isNull60 = false;
/* 176 */       long agg_value62 = -1L;
/* 177 */       if (!false && agg_isNull41) {
/* 178 */         agg_isNull60 = agg_bufIsNull2;
/* 179 */         agg_value62 = agg_bufValue2;
/* 180 */       } else {
/* 181 */         boolean agg_isNull64 = false;
/* 182 */
/* 183 */         long agg_value66 = -1L;
/* 184 */         agg_value66 = agg_bufValue2 + 1L;
/* 185 */         agg_isNull60 = false;
/* 186 */         agg_value62 = agg_value66;
/* 187 */       }
/* 188 */       // update aggregation buffer
/* 189 */       agg_bufIsNull = agg_isNull44;
/* 190 */       agg_bufValue = agg_value46;
/* 191 */
/* 192 */       agg_bufIsNull1 = agg_isNull52;
/* 193 */       agg_bufValue1 = agg_value54;
/* 194 */
/* 195 */       agg_bufIsNull2 = agg_isNull60;
/* 196 */       agg_bufValue2 = agg_value62;
/* 197 */
/* 198 */       if (shouldStop()) return;
/* 199 */     }
/* 200 */     agg_fastHashMap.close();
/* 201 */
/* 202 */     while (agg_mapIter.next()) {
/* 203 */       agg_numOutputRows.add(1);
/* 204 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 205 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 206 */
/* 207 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 208 */
/* 209 */       boolean agg_isNull41 = agg_resultRow.isNullAt(0);
/* 210 */       int agg_value43 = agg_isNull41 ? -1 : (agg_resultRow.getInt(0));
/* 211 */       boolean agg_isNull42 = agg_resultRow.isNullAt(1);
/* 212 */       double agg_value44 = agg_isNull42 ? -1.0 : (agg_resultRow.getDouble(1));
/* 213 */       boolean agg_isNull43 = agg_resultRow.isNullAt(2);
/* 214 */       double agg_value45 = agg_isNull43 ? -1.0 : (agg_resultRow.getDouble(2));
/* 215 */
/* 216 */       // do aggregate
/* 217 */       // common sub-expressions
/* 218 */
/* 219 */       // evaluate aggregate function
/* 220 */       boolean agg_isNull45 = true;
/* 221 */       double agg_value47 = -1.0;
/* 222 */
/* 223 */       boolean agg_isNull46 = agg_bufIsNull;
/* 224 */       double agg_value48 = agg_bufValue;
/* 225 */       if (agg_isNull46) {
/* 226 */         boolean agg_isNull48 = false;
/* 227 */         double agg_value50 = -1.0;
/* 228 */         if (!false) {
/* 229 */           agg_value50 = (double) 0;
/* 230 */         }
/* 231 */         if (!agg_isNull48) {
/* 232 */           agg_isNull46 = false;
/* 233 */           agg_value48 = agg_value50;
/* 234 */         }
/* 235 */       }
/* 236 */
/* 237 */       if (!agg_isNull42) {
/* 238 */         agg_isNull45 = false; // resultCode could change nullability.
/* 239 */         agg_value47 = agg_value48 + agg_value44;
/* 240 */
/* 241 */       }
/* 242 */       boolean agg_isNull44 = agg_isNull45;
/* 243 */       double agg_value46 = agg_value47;
/* 244 */       if (agg_isNull44) {
/* 245 */         if (!agg_bufIsNull) {
/* 246 */           agg_isNull44 = false;
/* 247 */           agg_value46 = agg_bufValue;
/* 248 */         }
/* 249 */       }
/* 250 */       boolean agg_isNull53 = true;
/* 251 */       double agg_value55 = -1.0;
/* 252 */
/* 253 */       boolean agg_isNull54 = agg_bufIsNull1;
/* 254 */       double agg_value56 = agg_bufValue1;
/* 255 */       if (agg_isNull54) {
/* 256 */         boolean agg_isNull56 = false;
/* 257 */         double agg_value58 = -1.0;
/* 258 */         if (!false) {
/* 259 */           agg_value58 = (double) 0;
/* 260 */         }
/* 261 */         if (!agg_isNull56) {
/* 262 */           agg_isNull54 = false;
/* 263 */           agg_value56 = agg_value58;
/* 264 */         }
/* 265 */       }
/* 266 */
/* 267 */       if (!agg_isNull43) {
/* 268 */         agg_isNull53 = false; // resultCode could change nullability.
/* 269 */         agg_value55 = agg_value56 + agg_value45;
/* 270 */
/* 271 */       }
/* 272 */       boolean agg_isNull52 = agg_isNull53;
/* 273 */       double agg_value54 = agg_value55;
/* 274 */       if (agg_isNull52) {
/* 275 */         if (!agg_bufIsNull1) {
/* 276 */           agg_isNull52 = false;
/* 277 */           agg_value54 = agg_bufValue1;
/* 278 */         }
/* 279 */       }
/* 280 */       boolean agg_isNull60 = false;
/* 281 */       long agg_value62 = -1L;
/* 282 */       if (!false && agg_isNull41) {
/* 283 */         agg_isNull60 = agg_bufIsNull2;
/* 284 */         agg_value62 = agg_bufValue2;
/* 285 */       } else {
/* 286 */         boolean agg_isNull64 = false;
/* 287 */
/* 288 */         long agg_value66 = -1L;
/* 289 */         agg_value66 = agg_bufValue2 + 1L;
/* 290 */         agg_isNull60 = false;
/* 291 */         agg_value62 = agg_value66;
/* 292 */       }
/* 293 */       // update aggregation buffer
/* 294 */       agg_bufIsNull = agg_isNull44;
/* 295 */       agg_bufValue = agg_value46;
/* 296 */
/* 297 */       agg_bufIsNull1 = agg_isNull52;
/* 298 */       agg_bufValue1 = agg_value54;
/* 299 */
/* 300 */       agg_bufIsNull2 = agg_isNull60;
/* 301 */       agg_bufValue2 = agg_value62;
/* 302 */
/* 303 */       if (shouldStop()) return;
/* 304 */     }
/* 305 */
/* 306 */     agg_mapIter.close();
/* 307 */     if (agg_sorter == null) {
/* 308 */       agg_hashMap.free();
/* 309 */     }
/* 310 */
/* 311 */   }
/* 312 */
/* 313 */   public class agg_FastHashMap {
/* 314 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 315 */     private int[] buckets;
/* 316 */     private int capacity = 1 << 16;
/* 317 */     private double loadFactor = 0.5;
/* 318 */     private int numBuckets = (int) (capacity / loadFactor);
/* 319 */     private int maxSteps = 2;
/* 320 */     private int numRows = 0;
/* 321 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 322 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 323 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 324 */     private Object emptyVBase;
/* 325 */     private long emptyVOff;
/* 326 */     private int emptyVLen;
/* 327 */     private boolean isBatchFull = false;
/* 328 */
/* 329 */     public agg_FastHashMap(
/* 330 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 331 */       InternalRow emptyAggregationBuffer) {
/* 332 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 333 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 334 */
/* 335 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 336 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 337 */
/* 338 */       emptyVBase = emptyBuffer;
/* 339 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 340 */       emptyVLen = emptyBuffer.length;
/* 341 */
/* 342 */       buckets = new int[numBuckets];
/* 343 */       java.util.Arrays.fill(buckets, -1);
/* 344 */     }
/* 345 */
/* 346 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 347 */       long h = hash(agg_key);
/* 348 */       int step = 0;
/* 349 */       int idx = (int) h & (numBuckets - 1);
/* 350 */       while (step < maxSteps) {
/* 351 */         // Return bucket index if it's either an empty slot or already contains the key
/* 352 */         if (buckets[idx] == -1) {
/* 353 */           if (numRows < capacity && !isBatchFull) {
/* 354 */             // creating the unsafe for new entry
/* 355 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 356 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 357 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 358 */               0);
/* 359 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 360 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 361 */               agg_holder,
/* 362 */               1);
/* 363 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 364 */             agg_rowWriter.zeroOutNullBytes();
/* 365 */             agg_rowWriter.write(0, agg_key);
/* 366 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 367 */             Object kbase = agg_result.getBaseObject();
/* 368 */             long koff = agg_result.getBaseOffset();
/* 369 */             int klen = agg_result.getSizeInBytes();
/* 370 */
/* 371 */             UnsafeRow vRow
/* 372 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 373 */             if (vRow == null) {
/* 374 */               isBatchFull = true;
/* 375 */             } else {
/* 376 */               buckets[idx] = numRows++;
/* 377 */             }
/* 378 */             return vRow;
/* 379 */           } else {
/* 380 */             // No more space
/* 381 */             return null;
/* 382 */           }
/* 383 */         } else if (equals(idx, agg_key)) {
/* 384 */           return batch.getValueRow(buckets[idx]);
/* 385 */         }
/* 386 */         idx = (idx + 1) & (numBuckets - 1);
/* 387 */         step++;
/* 388 */       }
/* 389 */       // Didn't find it
/* 390 */       return null;
/* 391 */     }
/* 392 */
/* 393 */     private boolean equals(int idx, int agg_key) {
/* 394 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 395 */       return (row.getInt(0) == agg_key);
/* 396 */     }
/* 397 */
/* 398 */     private long hash(int agg_key) {
/* 399 */       long agg_hash = 0;
/* 400 */
/* 401 */       int agg_result = agg_key;
/* 402 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 403 */
/* 404 */       return agg_hash;
/* 405 */     }
/* 406 */
/* 407 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 408 */       return batch.rowIterator();
/* 409 */     }
/* 410 */
/* 411 */     public void close() {
/* 412 */       batch.close();
/* 413 */     }
/* 414 */
/* 415 */   }
/* 416 */
/* 417 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 418 */     agg_hashMap = agg_plan.createHashMap();
/* 419 */
/* 420 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 421 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 422 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 423 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 424 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 425 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 426 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 427 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 428 */
/* 429 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 430 */
/* 431 */       UnsafeRow agg_fastAggBuffer = null;
/* 432 */
/* 433 */       if (true) {
/* 434 */         if (!inputadapter_isNull) {
/* 435 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 436 */             inputadapter_value);
/* 437 */         }
/* 438 */       }
/* 439 */
/* 440 */       if (agg_fastAggBuffer == null) {
/* 441 */         // generate grouping key
/* 442 */         agg_rowWriter.zeroOutNullBytes();
/* 443 */
/* 444 */         if (inputadapter_isNull) {
/* 445 */           agg_rowWriter.setNullAt(0);
/* 446 */         } else {
/* 447 */           agg_rowWriter.write(0, inputadapter_value);
/* 448 */         }
/* 449 */         agg_value9 = 42;
/* 450 */
/* 451 */         if (!inputadapter_isNull) {
/* 452 */           agg_value9 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value9);
/* 453 */         }
/* 454 */         if (true) {
/* 455 */           // try to get the buffer from hash map
/* 456 */           agg_unsafeRowAggBuffer =
/* 457 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value9);
/* 458 */         }
/* 459 */         if (agg_unsafeRowAggBuffer == null) {
/* 460 */           if (agg_sorter == null) {
/* 461 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 462 */           } else {
/* 463 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 464 */           }
/* 465 */
/* 466 */           // the hash map had be spilled, it should have enough memory now,
/* 467 */           // try  to allocate buffer again.
/* 468 */           agg_unsafeRowAggBuffer =
/* 469 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value9);
/* 470 */           if (agg_unsafeRowAggBuffer == null) {
/* 471 */             // failed to allocate the first page
/* 472 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 473 */           }
/* 474 */         }
/* 475 */       }
/* 476 */
/* 477 */       if (agg_fastAggBuffer != null) {
/* 478 */         // update fast row
/* 479 */
/* 480 */         // common sub-expressions
/* 481 */
/* 482 */         // evaluate aggregate function
/* 483 */         boolean agg_isNull26 = true;
/* 484 */         double agg_value28 = -1.0;
/* 485 */
/* 486 */         boolean agg_isNull28 = agg_fastAggBuffer.isNullAt(0);
/* 487 */         double agg_value30 = agg_isNull28 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 488 */         boolean agg_isNull27 = agg_isNull28;
/* 489 */         double agg_value29 = agg_value30;
/* 490 */         if (agg_isNull27) {
/* 491 */           boolean agg_isNull29 = false;
/* 492 */           double agg_value31 = -1.0;
/* 493 */           if (!false) {
/* 494 */             agg_value31 = (double) 0;
/* 495 */           }
/* 496 */           if (!agg_isNull29) {
/* 497 */             agg_isNull27 = false;
/* 498 */             agg_value29 = agg_value31;
/* 499 */           }
/* 500 */         }
/* 501 */
/* 502 */         if (!inputadapter_isNull1) {
/* 503 */           agg_isNull26 = false; // resultCode could change nullability.
/* 504 */           agg_value28 = agg_value29 + inputadapter_value1;
/* 505 */
/* 506 */         }
/* 507 */         boolean agg_isNull25 = agg_isNull26;
/* 508 */         double agg_value27 = agg_value28;
/* 509 */         if (agg_isNull25) {
/* 510 */           boolean agg_isNull32 = agg_fastAggBuffer.isNullAt(0);
/* 511 */           double agg_value34 = agg_isNull32 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 512 */           if (!agg_isNull32) {
/* 513 */             agg_isNull25 = false;
/* 514 */             agg_value27 = agg_value34;
/* 515 */           }
/* 516 */         }
/* 517 */         boolean agg_isNull34 = true;
/* 518 */         double agg_value36 = -1.0;
/* 519 */
/* 520 */         boolean agg_isNull36 = agg_fastAggBuffer.isNullAt(1);
/* 521 */         double agg_value38 = agg_isNull36 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 522 */         boolean agg_isNull35 = agg_isNull36;
/* 523 */         double agg_value37 = agg_value38;
/* 524 */         if (agg_isNull35) {
/* 525 */           boolean agg_isNull37 = false;
/* 526 */           double agg_value39 = -1.0;
/* 527 */           if (!false) {
/* 528 */             agg_value39 = (double) 0;
/* 529 */           }
/* 530 */           if (!agg_isNull37) {
/* 531 */             agg_isNull35 = false;
/* 532 */             agg_value37 = agg_value39;
/* 533 */           }
/* 534 */         }
/* 535 */
/* 536 */         if (!inputadapter_isNull2) {
/* 537 */           agg_isNull34 = false; // resultCode could change nullability.
/* 538 */           agg_value36 = agg_value37 + inputadapter_value2;
/* 539 */
/* 540 */         }
/* 541 */         boolean agg_isNull33 = agg_isNull34;
/* 542 */         double agg_value35 = agg_value36;
/* 543 */         if (agg_isNull33) {
/* 544 */           boolean agg_isNull40 = agg_fastAggBuffer.isNullAt(1);
/* 545 */           double agg_value42 = agg_isNull40 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 546 */           if (!agg_isNull40) {
/* 547 */             agg_isNull33 = false;
/* 548 */             agg_value35 = agg_value42;
/* 549 */           }
/* 550 */         }
/* 551 */         // update fast row
/* 552 */         if (!agg_isNull25) {
/* 553 */           agg_fastAggBuffer.setDouble(0, agg_value27);
/* 554 */         } else {
/* 555 */           agg_fastAggBuffer.setNullAt(0);
/* 556 */         }
/* 557 */
/* 558 */         if (!agg_isNull33) {
/* 559 */           agg_fastAggBuffer.setDouble(1, agg_value35);
/* 560 */         } else {
/* 561 */           agg_fastAggBuffer.setNullAt(1);
/* 562 */         }
/* 563 */
/* 564 */       } else {
/* 565 */         // update unsafe row
/* 566 */
/* 567 */         // common sub-expressions
/* 568 */
/* 569 */         // evaluate aggregate function
/* 570 */         boolean agg_isNull10 = true;
/* 571 */         double agg_value12 = -1.0;
/* 572 */
/* 573 */         boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 574 */         double agg_value14 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 575 */         boolean agg_isNull11 = agg_isNull12;
/* 576 */         double agg_value13 = agg_value14;
/* 577 */         if (agg_isNull11) {
/* 578 */           boolean agg_isNull13 = false;
/* 579 */           double agg_value15 = -1.0;
/* 580 */           if (!false) {
/* 581 */             agg_value15 = (double) 0;
/* 582 */           }
/* 583 */           if (!agg_isNull13) {
/* 584 */             agg_isNull11 = false;
/* 585 */             agg_value13 = agg_value15;
/* 586 */           }
/* 587 */         }
/* 588 */
/* 589 */         if (!inputadapter_isNull1) {
/* 590 */           agg_isNull10 = false; // resultCode could change nullability.
/* 591 */           agg_value12 = agg_value13 + inputadapter_value1;
/* 592 */
/* 593 */         }
/* 594 */         boolean agg_isNull9 = agg_isNull10;
/* 595 */         double agg_value11 = agg_value12;
/* 596 */         if (agg_isNull9) {
/* 597 */           boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 598 */           double agg_value18 = agg_isNull16 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 599 */           if (!agg_isNull16) {
/* 600 */             agg_isNull9 = false;
/* 601 */             agg_value11 = agg_value18;
/* 602 */           }
/* 603 */         }
/* 604 */         boolean agg_isNull18 = true;
/* 605 */         double agg_value20 = -1.0;
/* 606 */
/* 607 */         boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 608 */         double agg_value22 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 609 */         boolean agg_isNull19 = agg_isNull20;
/* 610 */         double agg_value21 = agg_value22;
/* 611 */         if (agg_isNull19) {
/* 612 */           boolean agg_isNull21 = false;
/* 613 */           double agg_value23 = -1.0;
/* 614 */           if (!false) {
/* 615 */             agg_value23 = (double) 0;
/* 616 */           }
/* 617 */           if (!agg_isNull21) {
/* 618 */             agg_isNull19 = false;
/* 619 */             agg_value21 = agg_value23;
/* 620 */           }
/* 621 */         }
/* 622 */
/* 623 */         if (!inputadapter_isNull2) {
/* 624 */           agg_isNull18 = false; // resultCode could change nullability.
/* 625 */           agg_value20 = agg_value21 + inputadapter_value2;
/* 626 */
/* 627 */         }
/* 628 */         boolean agg_isNull17 = agg_isNull18;
/* 629 */         double agg_value19 = agg_value20;
/* 630 */         if (agg_isNull17) {
/* 631 */           boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 632 */           double agg_value26 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 633 */           if (!agg_isNull24) {
/* 634 */             agg_isNull17 = false;
/* 635 */             agg_value19 = agg_value26;
/* 636 */           }
/* 637 */         }
/* 638 */         // update unsafe row buffer
/* 639 */         if (!agg_isNull9) {
/* 640 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value11);
/* 641 */         } else {
/* 642 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 643 */         }
/* 644 */
/* 645 */         if (!agg_isNull17) {
/* 646 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value19);
/* 647 */         } else {
/* 648 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 649 */         }
/* 650 */
/* 651 */       }
/* 652 */       if (shouldStop()) return;
/* 653 */     }
/* 654 */
/* 655 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 656 */
/* 657 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 658 */   }
/* 659 */
/* 660 */   private void wholestagecodegen_init_1() {
/* 661 */     agg_result2 = new UnsafeRow(3);
/* 662 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 663 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 664 */
/* 665 */   }
/* 666 */
/* 667 */   protected void processNext() throws java.io.IOException {
/* 668 */     while (!agg_initAgg) {
/* 669 */       agg_initAgg = true;
/* 670 */       long agg_beforeAgg1 = System.nanoTime();
/* 671 */       agg_doAggregateWithoutKey();
/* 672 */       agg_aggTime1.add((System.nanoTime() - agg_beforeAgg1) / 1000000);
/* 673 */
/* 674 */       // output the result
/* 675 */
/* 676 */       agg_numOutputRows1.add(1);
/* 677 */       agg_rowWriter1.zeroOutNullBytes();
/* 678 */
/* 679 */       if (agg_bufIsNull) {
/* 680 */         agg_rowWriter1.setNullAt(0);
/* 681 */       } else {
/* 682 */         agg_rowWriter1.write(0, agg_bufValue);
/* 683 */       }
/* 684 */
/* 685 */       if (agg_bufIsNull1) {
/* 686 */         agg_rowWriter1.setNullAt(1);
/* 687 */       } else {
/* 688 */         agg_rowWriter1.write(1, agg_bufValue1);
/* 689 */       }
/* 690 */
/* 691 */       if (agg_bufIsNull2) {
/* 692 */         agg_rowWriter1.setNullAt(2);
/* 693 */       } else {
/* 694 */         agg_rowWriter1.write(2, agg_bufValue2);
/* 695 */       }
/* 696 */       append(agg_result2);
/* 697 */     }
/* 698 */   }
/* 699 */ }

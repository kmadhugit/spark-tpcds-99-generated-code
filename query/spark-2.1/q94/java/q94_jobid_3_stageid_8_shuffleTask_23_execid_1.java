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
/* 070 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 071 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 072 */     this.agg_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 073 */     this.agg_aggTime1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
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
/* 104 */       boolean agg_isNull37 = agg_resultRow.isNullAt(0);
/* 105 */       int agg_value39 = agg_isNull37 ? -1 : (agg_resultRow.getInt(0));
/* 106 */       boolean agg_isNull38 = agg_resultRow.isNullAt(1);
/* 107 */       double agg_value40 = agg_isNull38 ? -1.0 : (agg_resultRow.getDouble(1));
/* 108 */       boolean agg_isNull39 = agg_resultRow.isNullAt(2);
/* 109 */       double agg_value41 = agg_isNull39 ? -1.0 : (agg_resultRow.getDouble(2));
/* 110 */
/* 111 */       // do aggregate
/* 112 */       // common sub-expressions
/* 113 */       boolean agg_isNull40 = false;
/* 114 */       double agg_value42 = -1.0;
/* 115 */       if (!false) {
/* 116 */         agg_value42 = (double) 0;
/* 117 */       }
/* 118 */       // evaluate aggregate function
/* 119 */       boolean agg_isNull43 = true;
/* 120 */       double agg_value45 = -1.0;
/* 121 */
/* 122 */       boolean agg_isNull44 = agg_bufIsNull;
/* 123 */       double agg_value46 = agg_bufValue;
/* 124 */       if (agg_isNull44) {
/* 125 */         if (!agg_isNull40) {
/* 126 */           agg_isNull44 = false;
/* 127 */           agg_value46 = agg_value42;
/* 128 */         }
/* 129 */       }
/* 130 */
/* 131 */       if (!agg_isNull38) {
/* 132 */         agg_isNull43 = false; // resultCode could change nullability.
/* 133 */         agg_value45 = agg_value46 + agg_value40;
/* 134 */
/* 135 */       }
/* 136 */       boolean agg_isNull42 = agg_isNull43;
/* 137 */       double agg_value44 = agg_value45;
/* 138 */       if (agg_isNull42) {
/* 139 */         if (!agg_bufIsNull) {
/* 140 */           agg_isNull42 = false;
/* 141 */           agg_value44 = agg_bufValue;
/* 142 */         }
/* 143 */       }
/* 144 */       boolean agg_isNull49 = true;
/* 145 */       double agg_value51 = -1.0;
/* 146 */
/* 147 */       boolean agg_isNull50 = agg_bufIsNull1;
/* 148 */       double agg_value52 = agg_bufValue1;
/* 149 */       if (agg_isNull50) {
/* 150 */         if (!agg_isNull40) {
/* 151 */           agg_isNull50 = false;
/* 152 */           agg_value52 = agg_value42;
/* 153 */         }
/* 154 */       }
/* 155 */
/* 156 */       if (!agg_isNull39) {
/* 157 */         agg_isNull49 = false; // resultCode could change nullability.
/* 158 */         agg_value51 = agg_value52 + agg_value41;
/* 159 */
/* 160 */       }
/* 161 */       boolean agg_isNull48 = agg_isNull49;
/* 162 */       double agg_value50 = agg_value51;
/* 163 */       if (agg_isNull48) {
/* 164 */         if (!agg_bufIsNull1) {
/* 165 */           agg_isNull48 = false;
/* 166 */           agg_value50 = agg_bufValue1;
/* 167 */         }
/* 168 */       }
/* 169 */       boolean agg_isNull54 = false;
/* 170 */       long agg_value56 = -1L;
/* 171 */       if (!false && agg_isNull37) {
/* 172 */         agg_isNull54 = agg_bufIsNull2;
/* 173 */         agg_value56 = agg_bufValue2;
/* 174 */       } else {
/* 175 */         boolean agg_isNull58 = false;
/* 176 */
/* 177 */         long agg_value60 = -1L;
/* 178 */         agg_value60 = agg_bufValue2 + 1L;
/* 179 */         agg_isNull54 = false;
/* 180 */         agg_value56 = agg_value60;
/* 181 */       }
/* 182 */       // update aggregation buffer
/* 183 */       agg_bufIsNull = agg_isNull42;
/* 184 */       agg_bufValue = agg_value44;
/* 185 */
/* 186 */       agg_bufIsNull1 = agg_isNull48;
/* 187 */       agg_bufValue1 = agg_value50;
/* 188 */
/* 189 */       agg_bufIsNull2 = agg_isNull54;
/* 190 */       agg_bufValue2 = agg_value56;
/* 191 */
/* 192 */       if (shouldStop()) return;
/* 193 */     }
/* 194 */     agg_fastHashMap.close();
/* 195 */
/* 196 */     while (agg_mapIter.next()) {
/* 197 */       agg_numOutputRows.add(1);
/* 198 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 199 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 200 */
/* 201 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 202 */
/* 203 */       boolean agg_isNull37 = agg_resultRow.isNullAt(0);
/* 204 */       int agg_value39 = agg_isNull37 ? -1 : (agg_resultRow.getInt(0));
/* 205 */       boolean agg_isNull38 = agg_resultRow.isNullAt(1);
/* 206 */       double agg_value40 = agg_isNull38 ? -1.0 : (agg_resultRow.getDouble(1));
/* 207 */       boolean agg_isNull39 = agg_resultRow.isNullAt(2);
/* 208 */       double agg_value41 = agg_isNull39 ? -1.0 : (agg_resultRow.getDouble(2));
/* 209 */
/* 210 */       // do aggregate
/* 211 */       // common sub-expressions
/* 212 */       boolean agg_isNull40 = false;
/* 213 */       double agg_value42 = -1.0;
/* 214 */       if (!false) {
/* 215 */         agg_value42 = (double) 0;
/* 216 */       }
/* 217 */       // evaluate aggregate function
/* 218 */       boolean agg_isNull43 = true;
/* 219 */       double agg_value45 = -1.0;
/* 220 */
/* 221 */       boolean agg_isNull44 = agg_bufIsNull;
/* 222 */       double agg_value46 = agg_bufValue;
/* 223 */       if (agg_isNull44) {
/* 224 */         if (!agg_isNull40) {
/* 225 */           agg_isNull44 = false;
/* 226 */           agg_value46 = agg_value42;
/* 227 */         }
/* 228 */       }
/* 229 */
/* 230 */       if (!agg_isNull38) {
/* 231 */         agg_isNull43 = false; // resultCode could change nullability.
/* 232 */         agg_value45 = agg_value46 + agg_value40;
/* 233 */
/* 234 */       }
/* 235 */       boolean agg_isNull42 = agg_isNull43;
/* 236 */       double agg_value44 = agg_value45;
/* 237 */       if (agg_isNull42) {
/* 238 */         if (!agg_bufIsNull) {
/* 239 */           agg_isNull42 = false;
/* 240 */           agg_value44 = agg_bufValue;
/* 241 */         }
/* 242 */       }
/* 243 */       boolean agg_isNull49 = true;
/* 244 */       double agg_value51 = -1.0;
/* 245 */
/* 246 */       boolean agg_isNull50 = agg_bufIsNull1;
/* 247 */       double agg_value52 = agg_bufValue1;
/* 248 */       if (agg_isNull50) {
/* 249 */         if (!agg_isNull40) {
/* 250 */           agg_isNull50 = false;
/* 251 */           agg_value52 = agg_value42;
/* 252 */         }
/* 253 */       }
/* 254 */
/* 255 */       if (!agg_isNull39) {
/* 256 */         agg_isNull49 = false; // resultCode could change nullability.
/* 257 */         agg_value51 = agg_value52 + agg_value41;
/* 258 */
/* 259 */       }
/* 260 */       boolean agg_isNull48 = agg_isNull49;
/* 261 */       double agg_value50 = agg_value51;
/* 262 */       if (agg_isNull48) {
/* 263 */         if (!agg_bufIsNull1) {
/* 264 */           agg_isNull48 = false;
/* 265 */           agg_value50 = agg_bufValue1;
/* 266 */         }
/* 267 */       }
/* 268 */       boolean agg_isNull54 = false;
/* 269 */       long agg_value56 = -1L;
/* 270 */       if (!false && agg_isNull37) {
/* 271 */         agg_isNull54 = agg_bufIsNull2;
/* 272 */         agg_value56 = agg_bufValue2;
/* 273 */       } else {
/* 274 */         boolean agg_isNull58 = false;
/* 275 */
/* 276 */         long agg_value60 = -1L;
/* 277 */         agg_value60 = agg_bufValue2 + 1L;
/* 278 */         agg_isNull54 = false;
/* 279 */         agg_value56 = agg_value60;
/* 280 */       }
/* 281 */       // update aggregation buffer
/* 282 */       agg_bufIsNull = agg_isNull42;
/* 283 */       agg_bufValue = agg_value44;
/* 284 */
/* 285 */       agg_bufIsNull1 = agg_isNull48;
/* 286 */       agg_bufValue1 = agg_value50;
/* 287 */
/* 288 */       agg_bufIsNull2 = agg_isNull54;
/* 289 */       agg_bufValue2 = agg_value56;
/* 290 */
/* 291 */       if (shouldStop()) return;
/* 292 */     }
/* 293 */
/* 294 */     agg_mapIter.close();
/* 295 */     if (agg_sorter == null) {
/* 296 */       agg_hashMap.free();
/* 297 */     }
/* 298 */
/* 299 */   }
/* 300 */
/* 301 */   public class agg_FastHashMap {
/* 302 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 303 */     private int[] buckets;
/* 304 */     private int capacity = 1 << 16;
/* 305 */     private double loadFactor = 0.5;
/* 306 */     private int numBuckets = (int) (capacity / loadFactor);
/* 307 */     private int maxSteps = 2;
/* 308 */     private int numRows = 0;
/* 309 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("ws_order_number", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 310 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 311 */     .add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 312 */     private Object emptyVBase;
/* 313 */     private long emptyVOff;
/* 314 */     private int emptyVLen;
/* 315 */     private boolean isBatchFull = false;
/* 316 */
/* 317 */     public agg_FastHashMap(
/* 318 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 319 */       InternalRow emptyAggregationBuffer) {
/* 320 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 321 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 322 */
/* 323 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 324 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 325 */
/* 326 */       emptyVBase = emptyBuffer;
/* 327 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 328 */       emptyVLen = emptyBuffer.length;
/* 329 */
/* 330 */       buckets = new int[numBuckets];
/* 331 */       java.util.Arrays.fill(buckets, -1);
/* 332 */     }
/* 333 */
/* 334 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 335 */       long h = hash(agg_key);
/* 336 */       int step = 0;
/* 337 */       int idx = (int) h & (numBuckets - 1);
/* 338 */       while (step < maxSteps) {
/* 339 */         // Return bucket index if it's either an empty slot or already contains the key
/* 340 */         if (buckets[idx] == -1) {
/* 341 */           if (numRows < capacity && !isBatchFull) {
/* 342 */             // creating the unsafe for new entry
/* 343 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 344 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 345 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 346 */               0);
/* 347 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 348 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 349 */               agg_holder,
/* 350 */               1);
/* 351 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 352 */             agg_rowWriter.zeroOutNullBytes();
/* 353 */             agg_rowWriter.write(0, agg_key);
/* 354 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 355 */             Object kbase = agg_result.getBaseObject();
/* 356 */             long koff = agg_result.getBaseOffset();
/* 357 */             int klen = agg_result.getSizeInBytes();
/* 358 */
/* 359 */             UnsafeRow vRow
/* 360 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 361 */             if (vRow == null) {
/* 362 */               isBatchFull = true;
/* 363 */             } else {
/* 364 */               buckets[idx] = numRows++;
/* 365 */             }
/* 366 */             return vRow;
/* 367 */           } else {
/* 368 */             // No more space
/* 369 */             return null;
/* 370 */           }
/* 371 */         } else if (equals(idx, agg_key)) {
/* 372 */           return batch.getValueRow(buckets[idx]);
/* 373 */         }
/* 374 */         idx = (idx + 1) & (numBuckets - 1);
/* 375 */         step++;
/* 376 */       }
/* 377 */       // Didn't find it
/* 378 */       return null;
/* 379 */     }
/* 380 */
/* 381 */     private boolean equals(int idx, int agg_key) {
/* 382 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 383 */       return (row.getInt(0) == agg_key);
/* 384 */     }
/* 385 */
/* 386 */     private long hash(int agg_key) {
/* 387 */       long agg_hash = 0;
/* 388 */
/* 389 */       int agg_result = agg_key;
/* 390 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 391 */
/* 392 */       return agg_hash;
/* 393 */     }
/* 394 */
/* 395 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 396 */       return batch.rowIterator();
/* 397 */     }
/* 398 */
/* 399 */     public void close() {
/* 400 */       batch.close();
/* 401 */     }
/* 402 */
/* 403 */   }
/* 404 */
/* 405 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 406 */     agg_hashMap = agg_plan.createHashMap();
/* 407 */
/* 408 */     while (inputadapter_input.hasNext()) {
/* 409 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 410 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 411 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 412 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 413 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 414 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 415 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 416 */
/* 417 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 418 */
/* 419 */       UnsafeRow agg_fastAggBuffer = null;
/* 420 */
/* 421 */       if (true) {
/* 422 */         if (!inputadapter_isNull) {
/* 423 */           agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 424 */             inputadapter_value);
/* 425 */         }
/* 426 */       }
/* 427 */
/* 428 */       if (agg_fastAggBuffer == null) {
/* 429 */         // generate grouping key
/* 430 */         agg_rowWriter.zeroOutNullBytes();
/* 431 */
/* 432 */         if (inputadapter_isNull) {
/* 433 */           agg_rowWriter.setNullAt(0);
/* 434 */         } else {
/* 435 */           agg_rowWriter.write(0, inputadapter_value);
/* 436 */         }
/* 437 */         agg_value9 = 42;
/* 438 */
/* 439 */         if (!inputadapter_isNull) {
/* 440 */           agg_value9 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value9);
/* 441 */         }
/* 442 */         if (true) {
/* 443 */           // try to get the buffer from hash map
/* 444 */           agg_unsafeRowAggBuffer =
/* 445 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value9);
/* 446 */         }
/* 447 */         if (agg_unsafeRowAggBuffer == null) {
/* 448 */           if (agg_sorter == null) {
/* 449 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 450 */           } else {
/* 451 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 452 */           }
/* 453 */
/* 454 */           // the hash map had be spilled, it should have enough memory now,
/* 455 */           // try  to allocate buffer again.
/* 456 */           agg_unsafeRowAggBuffer =
/* 457 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value9);
/* 458 */           if (agg_unsafeRowAggBuffer == null) {
/* 459 */             // failed to allocate the first page
/* 460 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 461 */           }
/* 462 */         }
/* 463 */       }
/* 464 */
/* 465 */       if (agg_fastAggBuffer != null) {
/* 466 */         // update fast row
/* 467 */
/* 468 */         // common sub-expressions
/* 469 */         boolean agg_isNull23 = false;
/* 470 */         double agg_value25 = -1.0;
/* 471 */         if (!false) {
/* 472 */           agg_value25 = (double) 0;
/* 473 */         }
/* 474 */         // evaluate aggregate function
/* 475 */         boolean agg_isNull26 = true;
/* 476 */         double agg_value28 = -1.0;
/* 477 */
/* 478 */         boolean agg_isNull28 = agg_fastAggBuffer.isNullAt(0);
/* 479 */         double agg_value30 = agg_isNull28 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 480 */         boolean agg_isNull27 = agg_isNull28;
/* 481 */         double agg_value29 = agg_value30;
/* 482 */         if (agg_isNull27) {
/* 483 */           if (!agg_isNull23) {
/* 484 */             agg_isNull27 = false;
/* 485 */             agg_value29 = agg_value25;
/* 486 */           }
/* 487 */         }
/* 488 */
/* 489 */         if (!inputadapter_isNull1) {
/* 490 */           agg_isNull26 = false; // resultCode could change nullability.
/* 491 */           agg_value28 = agg_value29 + inputadapter_value1;
/* 492 */
/* 493 */         }
/* 494 */         boolean agg_isNull25 = agg_isNull26;
/* 495 */         double agg_value27 = agg_value28;
/* 496 */         if (agg_isNull25) {
/* 497 */           boolean agg_isNull30 = agg_fastAggBuffer.isNullAt(0);
/* 498 */           double agg_value32 = agg_isNull30 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 499 */           if (!agg_isNull30) {
/* 500 */             agg_isNull25 = false;
/* 501 */             agg_value27 = agg_value32;
/* 502 */           }
/* 503 */         }
/* 504 */         boolean agg_isNull32 = true;
/* 505 */         double agg_value34 = -1.0;
/* 506 */
/* 507 */         boolean agg_isNull34 = agg_fastAggBuffer.isNullAt(1);
/* 508 */         double agg_value36 = agg_isNull34 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 509 */         boolean agg_isNull33 = agg_isNull34;
/* 510 */         double agg_value35 = agg_value36;
/* 511 */         if (agg_isNull33) {
/* 512 */           if (!agg_isNull23) {
/* 513 */             agg_isNull33 = false;
/* 514 */             agg_value35 = agg_value25;
/* 515 */           }
/* 516 */         }
/* 517 */
/* 518 */         if (!inputadapter_isNull2) {
/* 519 */           agg_isNull32 = false; // resultCode could change nullability.
/* 520 */           agg_value34 = agg_value35 + inputadapter_value2;
/* 521 */
/* 522 */         }
/* 523 */         boolean agg_isNull31 = agg_isNull32;
/* 524 */         double agg_value33 = agg_value34;
/* 525 */         if (agg_isNull31) {
/* 526 */           boolean agg_isNull36 = agg_fastAggBuffer.isNullAt(1);
/* 527 */           double agg_value38 = agg_isNull36 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 528 */           if (!agg_isNull36) {
/* 529 */             agg_isNull31 = false;
/* 530 */             agg_value33 = agg_value38;
/* 531 */           }
/* 532 */         }
/* 533 */         // update fast row
/* 534 */         if (!agg_isNull25) {
/* 535 */           agg_fastAggBuffer.setDouble(0, agg_value27);
/* 536 */         } else {
/* 537 */           agg_fastAggBuffer.setNullAt(0);
/* 538 */         }
/* 539 */
/* 540 */         if (!agg_isNull31) {
/* 541 */           agg_fastAggBuffer.setDouble(1, agg_value33);
/* 542 */         } else {
/* 543 */           agg_fastAggBuffer.setNullAt(1);
/* 544 */         }
/* 545 */
/* 546 */       } else {
/* 547 */         // update unsafe row
/* 548 */
/* 549 */         // common sub-expressions
/* 550 */         boolean agg_isNull9 = false;
/* 551 */         double agg_value11 = -1.0;
/* 552 */         if (!false) {
/* 553 */           agg_value11 = (double) 0;
/* 554 */         }
/* 555 */         // evaluate aggregate function
/* 556 */         boolean agg_isNull12 = true;
/* 557 */         double agg_value14 = -1.0;
/* 558 */
/* 559 */         boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 560 */         double agg_value16 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 561 */         boolean agg_isNull13 = agg_isNull14;
/* 562 */         double agg_value15 = agg_value16;
/* 563 */         if (agg_isNull13) {
/* 564 */           if (!agg_isNull9) {
/* 565 */             agg_isNull13 = false;
/* 566 */             agg_value15 = agg_value11;
/* 567 */           }
/* 568 */         }
/* 569 */
/* 570 */         if (!inputadapter_isNull1) {
/* 571 */           agg_isNull12 = false; // resultCode could change nullability.
/* 572 */           agg_value14 = agg_value15 + inputadapter_value1;
/* 573 */
/* 574 */         }
/* 575 */         boolean agg_isNull11 = agg_isNull12;
/* 576 */         double agg_value13 = agg_value14;
/* 577 */         if (agg_isNull11) {
/* 578 */           boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 579 */           double agg_value18 = agg_isNull16 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 580 */           if (!agg_isNull16) {
/* 581 */             agg_isNull11 = false;
/* 582 */             agg_value13 = agg_value18;
/* 583 */           }
/* 584 */         }
/* 585 */         boolean agg_isNull18 = true;
/* 586 */         double agg_value20 = -1.0;
/* 587 */
/* 588 */         boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 589 */         double agg_value22 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 590 */         boolean agg_isNull19 = agg_isNull20;
/* 591 */         double agg_value21 = agg_value22;
/* 592 */         if (agg_isNull19) {
/* 593 */           if (!agg_isNull9) {
/* 594 */             agg_isNull19 = false;
/* 595 */             agg_value21 = agg_value11;
/* 596 */           }
/* 597 */         }
/* 598 */
/* 599 */         if (!inputadapter_isNull2) {
/* 600 */           agg_isNull18 = false; // resultCode could change nullability.
/* 601 */           agg_value20 = agg_value21 + inputadapter_value2;
/* 602 */
/* 603 */         }
/* 604 */         boolean agg_isNull17 = agg_isNull18;
/* 605 */         double agg_value19 = agg_value20;
/* 606 */         if (agg_isNull17) {
/* 607 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 608 */           double agg_value24 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 609 */           if (!agg_isNull22) {
/* 610 */             agg_isNull17 = false;
/* 611 */             agg_value19 = agg_value24;
/* 612 */           }
/* 613 */         }
/* 614 */         // update unsafe row buffer
/* 615 */         if (!agg_isNull11) {
/* 616 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value13);
/* 617 */         } else {
/* 618 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 619 */         }
/* 620 */
/* 621 */         if (!agg_isNull17) {
/* 622 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value19);
/* 623 */         } else {
/* 624 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 625 */         }
/* 626 */
/* 627 */       }
/* 628 */       if (shouldStop()) return;
/* 629 */     }
/* 630 */
/* 631 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 632 */
/* 633 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 634 */   }
/* 635 */
/* 636 */   private void wholestagecodegen_init_1() {
/* 637 */     agg_result2 = new UnsafeRow(3);
/* 638 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 639 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 640 */
/* 641 */   }
/* 642 */
/* 643 */   protected void processNext() throws java.io.IOException {
/* 644 */     while (!agg_initAgg) {
/* 645 */       agg_initAgg = true;
/* 646 */       long agg_beforeAgg1 = System.nanoTime();
/* 647 */       agg_doAggregateWithoutKey();
/* 648 */       agg_aggTime1.add((System.nanoTime() - agg_beforeAgg1) / 1000000);
/* 649 */
/* 650 */       // output the result
/* 651 */
/* 652 */       agg_numOutputRows1.add(1);
/* 653 */       agg_rowWriter1.zeroOutNullBytes();
/* 654 */
/* 655 */       if (agg_bufIsNull) {
/* 656 */         agg_rowWriter1.setNullAt(0);
/* 657 */       } else {
/* 658 */         agg_rowWriter1.write(0, agg_bufValue);
/* 659 */       }
/* 660 */
/* 661 */       if (agg_bufIsNull1) {
/* 662 */         agg_rowWriter1.setNullAt(1);
/* 663 */       } else {
/* 664 */         agg_rowWriter1.write(1, agg_bufValue1);
/* 665 */       }
/* 666 */
/* 667 */       if (agg_bufIsNull2) {
/* 668 */         agg_rowWriter1.setNullAt(2);
/* 669 */       } else {
/* 670 */         agg_rowWriter1.write(2, agg_bufValue2);
/* 671 */       }
/* 672 */       append(agg_result2);
/* 673 */     }
/* 674 */   }
/* 675 */ }

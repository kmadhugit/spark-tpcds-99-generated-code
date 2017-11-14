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
/* 021 */   private scala.collection.Iterator smj_leftInput;
/* 022 */   private scala.collection.Iterator smj_rightInput;
/* 023 */   private InternalRow smj_leftRow;
/* 024 */   private InternalRow smj_rightRow;
/* 025 */   private int smj_value2;
/* 026 */   private org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray smj_matches;
/* 027 */   private int smj_value3;
/* 028 */   private UTF8String smj_value4;
/* 029 */   private boolean smj_isNull2;
/* 030 */   private int smj_value5;
/* 031 */   private boolean smj_isNull3;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric smj_numOutputRows;
/* 033 */   private UnsafeRow smj_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder smj_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter smj_rowWriter;
/* 036 */   private UnsafeRow project_result;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 039 */   private UnsafeRow agg_result1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 042 */   private int agg_value6;
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
/* 067 */     smj_leftInput = inputs[0];
/* 068 */     smj_rightInput = inputs[1];
/* 069 */
/* 070 */     smj_rightRow = null;
/* 071 */
/* 072 */     smj_matches = new org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray(2147483647);
/* 073 */
/* 074 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 075 */     smj_result = new UnsafeRow(3);
/* 076 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 32);
/* 077 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 3);
/* 078 */     project_result = new UnsafeRow(1);
/* 079 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 080 */
/* 081 */   }
/* 082 */
/* 083 */   public class agg_FastHashMap {
/* 084 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 085 */     private int[] buckets;
/* 086 */     private int capacity = 1 << 16;
/* 087 */     private double loadFactor = 0.5;
/* 088 */     private int numBuckets = (int) (capacity / loadFactor);
/* 089 */     private int maxSteps = 2;
/* 090 */     private int numRows = 0;
/* 091 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType);
/* 092 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.LongType)
/* 093 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.LongType);
/* 094 */     private Object emptyVBase;
/* 095 */     private long emptyVOff;
/* 096 */     private int emptyVLen;
/* 097 */     private boolean isBatchFull = false;
/* 098 */
/* 099 */     public agg_FastHashMap(
/* 100 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 101 */       InternalRow emptyAggregationBuffer) {
/* 102 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 103 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 104 */
/* 105 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 106 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 107 */
/* 108 */       emptyVBase = emptyBuffer;
/* 109 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 110 */       emptyVLen = emptyBuffer.length;
/* 111 */
/* 112 */       buckets = new int[numBuckets];
/* 113 */       java.util.Arrays.fill(buckets, -1);
/* 114 */     }
/* 115 */
/* 116 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key) {
/* 117 */       long h = hash(agg_key);
/* 118 */       int step = 0;
/* 119 */       int idx = (int) h & (numBuckets - 1);
/* 120 */       while (step < maxSteps) {
/* 121 */         // Return bucket index if it's either an empty slot or already contains the key
/* 122 */         if (buckets[idx] == -1) {
/* 123 */           if (numRows < capacity && !isBatchFull) {
/* 124 */             // creating the unsafe for new entry
/* 125 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 126 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 127 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 128 */               32);
/* 129 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 130 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 131 */               agg_holder,
/* 132 */               1);
/* 133 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 134 */             agg_rowWriter.zeroOutNullBytes();
/* 135 */             agg_rowWriter.write(0, agg_key);
/* 136 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 137 */             Object kbase = agg_result.getBaseObject();
/* 138 */             long koff = agg_result.getBaseOffset();
/* 139 */             int klen = agg_result.getSizeInBytes();
/* 140 */
/* 141 */             UnsafeRow vRow
/* 142 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 143 */             if (vRow == null) {
/* 144 */               isBatchFull = true;
/* 145 */             } else {
/* 146 */               buckets[idx] = numRows++;
/* 147 */             }
/* 148 */             return vRow;
/* 149 */           } else {
/* 150 */             // No more space
/* 151 */             return null;
/* 152 */           }
/* 153 */         } else if (equals(idx, agg_key)) {
/* 154 */           return batch.getValueRow(buckets[idx]);
/* 155 */         }
/* 156 */         idx = (idx + 1) & (numBuckets - 1);
/* 157 */         step++;
/* 158 */       }
/* 159 */       // Didn't find it
/* 160 */       return null;
/* 161 */     }
/* 162 */
/* 163 */     private boolean equals(int idx, UTF8String agg_key) {
/* 164 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 165 */       return (row.getUTF8String(0).equals(agg_key));
/* 166 */     }
/* 167 */
/* 168 */     private long hash(UTF8String agg_key) {
/* 169 */       long agg_hash = 0;
/* 170 */
/* 171 */       int agg_result = 0;
/* 172 */       byte[] agg_bytes = agg_key.getBytes();
/* 173 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 174 */         int agg_hash1 = agg_bytes[i];
/* 175 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 176 */       }
/* 177 */
/* 178 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 179 */
/* 180 */       return agg_hash;
/* 181 */     }
/* 182 */
/* 183 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 184 */       return batch.rowIterator();
/* 185 */     }
/* 186 */
/* 187 */     public void close() {
/* 188 */       batch.close();
/* 189 */     }
/* 190 */
/* 191 */   }
/* 192 */
/* 193 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 194 */     agg_hashMap = agg_plan.createHashMap();
/* 195 */
/* 196 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 197 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 198 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 199 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 200 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 201 */       scala.collection.Iterator<UnsafeRow> smj_iterator = smj_matches.generateIterator();
/* 202 */       while (smj_iterator.hasNext()) {
/* 203 */         InternalRow smj_rightRow1 = (InternalRow) smj_iterator.next();
/* 204 */
/* 205 */         smj_numOutputRows.add(1);
/* 206 */
/* 207 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 208 */
/* 209 */         UnsafeRow agg_fastAggBuffer = null;
/* 210 */
/* 211 */         if (true) {
/* 212 */           if (!smj_isNull2) {
/* 213 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 214 */               smj_value4);
/* 215 */           }
/* 216 */         }
/* 217 */
/* 218 */         if (agg_fastAggBuffer == null) {
/* 219 */           // generate grouping key
/* 220 */           agg_holder.reset();
/* 221 */
/* 222 */           agg_rowWriter.zeroOutNullBytes();
/* 223 */
/* 224 */           if (smj_isNull2) {
/* 225 */             agg_rowWriter.setNullAt(0);
/* 226 */           } else {
/* 227 */             agg_rowWriter.write(0, smj_value4);
/* 228 */           }
/* 229 */           agg_result1.setTotalSize(agg_holder.totalSize());
/* 230 */           agg_value6 = 42;
/* 231 */
/* 232 */           if (!smj_isNull2) {
/* 233 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value4.getBaseObject(), smj_value4.getBaseOffset(), smj_value4.numBytes(), agg_value6);
/* 234 */           }
/* 235 */           if (true) {
/* 236 */             // try to get the buffer from hash map
/* 237 */             agg_unsafeRowAggBuffer =
/* 238 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value6);
/* 239 */           }
/* 240 */           if (agg_unsafeRowAggBuffer == null) {
/* 241 */             if (agg_sorter == null) {
/* 242 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 243 */             } else {
/* 244 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 245 */             }
/* 246 */
/* 247 */             // the hash map had be spilled, it should have enough memory now,
/* 248 */             // try  to allocate buffer again.
/* 249 */             agg_unsafeRowAggBuffer =
/* 250 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value6);
/* 251 */             if (agg_unsafeRowAggBuffer == null) {
/* 252 */               // failed to allocate the first page
/* 253 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 254 */             }
/* 255 */           }
/* 256 */         }
/* 257 */
/* 258 */         if (agg_fastAggBuffer != null) {
/* 259 */           // update fast row
/* 260 */
/* 261 */           // common sub-expressions
/* 262 */
/* 263 */           // evaluate aggregate function
/* 264 */           boolean agg_isNull12 = false;
/* 265 */
/* 266 */           long agg_value15 = agg_fastAggBuffer.getLong(0);
/* 267 */
/* 268 */           long agg_value14 = -1L;
/* 269 */           agg_value14 = agg_value15 + 1L;
/* 270 */           boolean agg_isNull15 = false;
/* 271 */
/* 272 */           long agg_value18 = agg_fastAggBuffer.getLong(1);
/* 273 */
/* 274 */           long agg_value17 = -1L;
/* 275 */           agg_value17 = agg_value18 + 1L;
/* 276 */           // update fast row
/* 277 */           agg_fastAggBuffer.setLong(0, agg_value14);
/* 278 */           agg_fastAggBuffer.setLong(1, agg_value17);
/* 279 */
/* 280 */         } else {
/* 281 */           // update unsafe row
/* 282 */
/* 283 */           // common sub-expressions
/* 284 */
/* 285 */           // evaluate aggregate function
/* 286 */           boolean agg_isNull6 = false;
/* 287 */
/* 288 */           long agg_value9 = agg_unsafeRowAggBuffer.getLong(0);
/* 289 */
/* 290 */           long agg_value8 = -1L;
/* 291 */           agg_value8 = agg_value9 + 1L;
/* 292 */           boolean agg_isNull9 = false;
/* 293 */
/* 294 */           long agg_value12 = agg_unsafeRowAggBuffer.getLong(1);
/* 295 */
/* 296 */           long agg_value11 = -1L;
/* 297 */           agg_value11 = agg_value12 + 1L;
/* 298 */           // update unsafe row buffer
/* 299 */           agg_unsafeRowAggBuffer.setLong(0, agg_value8);
/* 300 */           agg_unsafeRowAggBuffer.setLong(1, agg_value11);
/* 301 */
/* 302 */         }
/* 303 */
/* 304 */       }
/* 305 */       if (shouldStop()) return;
/* 306 */     }
/* 307 */
/* 308 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 309 */
/* 310 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 311 */   }
/* 312 */
/* 313 */   private boolean findNextInnerJoinRows(
/* 314 */     scala.collection.Iterator leftIter,
/* 315 */     scala.collection.Iterator rightIter) {
/* 316 */     smj_leftRow = null;
/* 317 */     int comp = 0;
/* 318 */     while (smj_leftRow == null) {
/* 319 */       if (!leftIter.hasNext()) return false;
/* 320 */       smj_leftRow = (InternalRow) leftIter.next();
/* 321 */
/* 322 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 323 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 324 */       if (smj_isNull) {
/* 325 */         smj_leftRow = null;
/* 326 */         continue;
/* 327 */       }
/* 328 */       if (!smj_matches.isEmpty()) {
/* 329 */         comp = 0;
/* 330 */         if (comp == 0) {
/* 331 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 332 */         }
/* 333 */
/* 334 */         if (comp == 0) {
/* 335 */           return true;
/* 336 */         }
/* 337 */         smj_matches.clear();
/* 338 */       }
/* 339 */
/* 340 */       do {
/* 341 */         if (smj_rightRow == null) {
/* 342 */           if (!rightIter.hasNext()) {
/* 343 */             smj_value3 = smj_value;
/* 344 */             return !smj_matches.isEmpty();
/* 345 */           }
/* 346 */           smj_rightRow = (InternalRow) rightIter.next();
/* 347 */
/* 348 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 349 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 350 */           if (smj_isNull1) {
/* 351 */             smj_rightRow = null;
/* 352 */             continue;
/* 353 */           }
/* 354 */           smj_value2 = smj_value1;
/* 355 */         }
/* 356 */
/* 357 */         comp = 0;
/* 358 */         if (comp == 0) {
/* 359 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 360 */         }
/* 361 */
/* 362 */         if (comp > 0) {
/* 363 */           smj_rightRow = null;
/* 364 */         } else if (comp < 0) {
/* 365 */           if (!smj_matches.isEmpty()) {
/* 366 */             smj_value3 = smj_value;
/* 367 */             return true;
/* 368 */           }
/* 369 */           smj_leftRow = null;
/* 370 */         } else {
/* 371 */           smj_matches.add((UnsafeRow) smj_rightRow);
/* 372 */           smj_rightRow = null;;
/* 373 */         }
/* 374 */       } while (smj_leftRow != null);
/* 375 */     }
/* 376 */     return false; // unreachable
/* 377 */   }
/* 378 */
/* 379 */   private void wholestagecodegen_init_1() {
/* 380 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 381 */     agg_result1 = new UnsafeRow(1);
/* 382 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 383 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 384 */
/* 385 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 386 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 387 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 388 */
/* 389 */   }
/* 390 */
/* 391 */   protected void processNext() throws java.io.IOException {
/* 392 */     if (!agg_initAgg) {
/* 393 */       agg_initAgg = true;
/* 394 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 395 */       agg_doAggregateWithKeys();
/* 396 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 397 */     }
/* 398 */
/* 399 */     // output the result
/* 400 */
/* 401 */     while (agg_fastHashMapIter.next()) {
/* 402 */       wholestagecodegen_numOutputRows.add(1);
/* 403 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 404 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 405 */
/* 406 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 407 */
/* 408 */       append(agg_resultRow.copy());
/* 409 */
/* 410 */       if (shouldStop()) return;
/* 411 */     }
/* 412 */     agg_fastHashMap.close();
/* 413 */
/* 414 */     while (agg_mapIter.next()) {
/* 415 */       wholestagecodegen_numOutputRows.add(1);
/* 416 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 417 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 418 */
/* 419 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 420 */
/* 421 */       append(agg_resultRow.copy());
/* 422 */
/* 423 */       if (shouldStop()) return;
/* 424 */     }
/* 425 */
/* 426 */     agg_mapIter.close();
/* 427 */     if (agg_sorter == null) {
/* 428 */       agg_hashMap.free();
/* 429 */     }
/* 430 */   }
/* 431 */ }

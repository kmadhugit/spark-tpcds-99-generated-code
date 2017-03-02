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
/* 026 */   private java.util.ArrayList smj_matches;
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
/* 072 */     smj_matches = new java.util.ArrayList();
/* 073 */
/* 074 */     this.smj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 075 */     smj_result = new UnsafeRow(3);
/* 076 */     this.smj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(smj_result, 32);
/* 077 */     this.smj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(smj_holder, 3);
/* 078 */     project_result = new UnsafeRow(1);
/* 079 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 080 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
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
/* 092 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("ca_state", org.apache.spark.sql.types.DataTypes.StringType);
/* 093 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("count", org.apache.spark.sql.types.DataTypes.LongType)
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
/* 197 */     while (findNextInnerJoinRows(smj_leftInput, smj_rightInput)) {
/* 198 */       int smj_size = smj_matches.size();
/* 199 */       smj_isNull2 = smj_leftRow.isNullAt(0);
/* 200 */       smj_value4 = smj_isNull2 ? null : (smj_leftRow.getUTF8String(0));
/* 201 */       smj_isNull3 = smj_leftRow.isNullAt(1);
/* 202 */       smj_value5 = smj_isNull3 ? -1 : (smj_leftRow.getInt(1));
/* 203 */       for (int smj_i = 0; smj_i < smj_size; smj_i ++) {
/* 204 */         InternalRow smj_rightRow1 = (InternalRow) smj_matches.get(smj_i);
/* 205 */
/* 206 */         smj_numOutputRows.add(1);
/* 207 */
/* 208 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 209 */
/* 210 */         UnsafeRow agg_fastAggBuffer = null;
/* 211 */
/* 212 */         if (true) {
/* 213 */           if (!smj_isNull2) {
/* 214 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 215 */               smj_value4);
/* 216 */           }
/* 217 */         }
/* 218 */
/* 219 */         if (agg_fastAggBuffer == null) {
/* 220 */           // generate grouping key
/* 221 */           agg_holder.reset();
/* 222 */
/* 223 */           agg_rowWriter.zeroOutNullBytes();
/* 224 */
/* 225 */           if (smj_isNull2) {
/* 226 */             agg_rowWriter.setNullAt(0);
/* 227 */           } else {
/* 228 */             agg_rowWriter.write(0, smj_value4);
/* 229 */           }
/* 230 */           agg_result1.setTotalSize(agg_holder.totalSize());
/* 231 */           agg_value6 = 42;
/* 232 */
/* 233 */           if (!smj_isNull2) {
/* 234 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(smj_value4.getBaseObject(), smj_value4.getBaseOffset(), smj_value4.numBytes(), agg_value6);
/* 235 */           }
/* 236 */           if (true) {
/* 237 */             // try to get the buffer from hash map
/* 238 */             agg_unsafeRowAggBuffer =
/* 239 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value6);
/* 240 */           }
/* 241 */           if (agg_unsafeRowAggBuffer == null) {
/* 242 */             if (agg_sorter == null) {
/* 243 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 244 */             } else {
/* 245 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 246 */             }
/* 247 */
/* 248 */             // the hash map had be spilled, it should have enough memory now,
/* 249 */             // try  to allocate buffer again.
/* 250 */             agg_unsafeRowAggBuffer =
/* 251 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value6);
/* 252 */             if (agg_unsafeRowAggBuffer == null) {
/* 253 */               // failed to allocate the first page
/* 254 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 255 */             }
/* 256 */           }
/* 257 */         }
/* 258 */
/* 259 */         if (agg_fastAggBuffer != null) {
/* 260 */           // update fast row
/* 261 */
/* 262 */           // common sub-expressions
/* 263 */
/* 264 */           // evaluate aggregate function
/* 265 */           boolean agg_isNull12 = false;
/* 266 */
/* 267 */           long agg_value15 = agg_fastAggBuffer.getLong(0);
/* 268 */
/* 269 */           long agg_value14 = -1L;
/* 270 */           agg_value14 = agg_value15 + 1L;
/* 271 */           boolean agg_isNull15 = false;
/* 272 */
/* 273 */           long agg_value18 = agg_fastAggBuffer.getLong(1);
/* 274 */
/* 275 */           long agg_value17 = -1L;
/* 276 */           agg_value17 = agg_value18 + 1L;
/* 277 */           // update fast row
/* 278 */           agg_fastAggBuffer.setLong(0, agg_value14);
/* 279 */           agg_fastAggBuffer.setLong(1, agg_value17);
/* 280 */
/* 281 */         } else {
/* 282 */           // update unsafe row
/* 283 */
/* 284 */           // common sub-expressions
/* 285 */
/* 286 */           // evaluate aggregate function
/* 287 */           boolean agg_isNull6 = false;
/* 288 */
/* 289 */           long agg_value9 = agg_unsafeRowAggBuffer.getLong(0);
/* 290 */
/* 291 */           long agg_value8 = -1L;
/* 292 */           agg_value8 = agg_value9 + 1L;
/* 293 */           boolean agg_isNull9 = false;
/* 294 */
/* 295 */           long agg_value12 = agg_unsafeRowAggBuffer.getLong(1);
/* 296 */
/* 297 */           long agg_value11 = -1L;
/* 298 */           agg_value11 = agg_value12 + 1L;
/* 299 */           // update unsafe row buffer
/* 300 */           agg_unsafeRowAggBuffer.setLong(0, agg_value8);
/* 301 */           agg_unsafeRowAggBuffer.setLong(1, agg_value11);
/* 302 */
/* 303 */         }
/* 304 */
/* 305 */       }
/* 306 */       if (shouldStop()) return;
/* 307 */     }
/* 308 */
/* 309 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 310 */
/* 311 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 312 */   }
/* 313 */
/* 314 */   private boolean findNextInnerJoinRows(
/* 315 */     scala.collection.Iterator leftIter,
/* 316 */     scala.collection.Iterator rightIter) {
/* 317 */     smj_leftRow = null;
/* 318 */     int comp = 0;
/* 319 */     while (smj_leftRow == null) {
/* 320 */       if (!leftIter.hasNext()) return false;
/* 321 */       smj_leftRow = (InternalRow) leftIter.next();
/* 322 */
/* 323 */       boolean smj_isNull = smj_leftRow.isNullAt(1);
/* 324 */       int smj_value = smj_isNull ? -1 : (smj_leftRow.getInt(1));
/* 325 */       if (smj_isNull) {
/* 326 */         smj_leftRow = null;
/* 327 */         continue;
/* 328 */       }
/* 329 */       if (!smj_matches.isEmpty()) {
/* 330 */         comp = 0;
/* 331 */         if (comp == 0) {
/* 332 */           comp = (smj_value > smj_value3 ? 1 : smj_value < smj_value3 ? -1 : 0);
/* 333 */         }
/* 334 */
/* 335 */         if (comp == 0) {
/* 336 */           return true;
/* 337 */         }
/* 338 */         smj_matches.clear();
/* 339 */       }
/* 340 */
/* 341 */       do {
/* 342 */         if (smj_rightRow == null) {
/* 343 */           if (!rightIter.hasNext()) {
/* 344 */             smj_value3 = smj_value;
/* 345 */             return !smj_matches.isEmpty();
/* 346 */           }
/* 347 */           smj_rightRow = (InternalRow) rightIter.next();
/* 348 */
/* 349 */           boolean smj_isNull1 = smj_rightRow.isNullAt(0);
/* 350 */           int smj_value1 = smj_isNull1 ? -1 : (smj_rightRow.getInt(0));
/* 351 */           if (smj_isNull1) {
/* 352 */             smj_rightRow = null;
/* 353 */             continue;
/* 354 */           }
/* 355 */           smj_value2 = smj_value1;
/* 356 */         }
/* 357 */
/* 358 */         comp = 0;
/* 359 */         if (comp == 0) {
/* 360 */           comp = (smj_value > smj_value2 ? 1 : smj_value < smj_value2 ? -1 : 0);
/* 361 */         }
/* 362 */
/* 363 */         if (comp > 0) {
/* 364 */           smj_rightRow = null;
/* 365 */         } else if (comp < 0) {
/* 366 */           if (!smj_matches.isEmpty()) {
/* 367 */             smj_value3 = smj_value;
/* 368 */             return true;
/* 369 */           }
/* 370 */           smj_leftRow = null;
/* 371 */         } else {
/* 372 */           smj_matches.add(smj_rightRow.copy());
/* 373 */           smj_rightRow = null;;
/* 374 */         }
/* 375 */       } while (smj_leftRow != null);
/* 376 */     }
/* 377 */     return false; // unreachable
/* 378 */   }
/* 379 */
/* 380 */   private void wholestagecodegen_init_1() {
/* 381 */     agg_result1 = new UnsafeRow(1);
/* 382 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 383 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 384 */
/* 385 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 386 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 387 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
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

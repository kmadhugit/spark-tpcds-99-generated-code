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
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private agg_FastHashMap agg_fastHashMap;
/* 013 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator scan_input;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 022 */   private long scan_scanTime1;
/* 023 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 024 */   private int scan_batchIdx;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 026 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
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
/* 039 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 040 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 042 */   private UnsafeRow bhj_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 045 */   private UnsafeRow project_result1;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 048 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 049 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 051 */   private UnsafeRow bhj_result1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 054 */   private UnsafeRow project_result2;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 057 */   private UnsafeRow agg_result2;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 060 */   private int agg_value6;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 062 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 063 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 064 */
/* 065 */   public GeneratedIterator(Object[] references) {
/* 066 */     this.references = references;
/* 067 */   }
/* 068 */
/* 069 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 070 */     partitionIndex = index;
/* 071 */     this.inputs = inputs;
/* 072 */     wholestagecodegen_init_0();
/* 073 */     wholestagecodegen_init_1();
/* 074 */     wholestagecodegen_init_2();
/* 075 */     wholestagecodegen_init_3();
/* 076 */
/* 077 */   }
/* 078 */
/* 079 */   private void wholestagecodegen_init_0() {
/* 080 */     agg_initAgg = false;
/* 081 */
/* 082 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 083 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 084 */
/* 085 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 086 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 087 */     scan_input = inputs[0];
/* 088 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 089 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 090 */     scan_scanTime1 = 0;
/* 091 */     scan_batch = null;
/* 092 */     scan_batchIdx = 0;
/* 093 */     scan_colInstance0 = null;
/* 094 */     scan_colInstance1 = null;
/* 095 */     scan_colInstance2 = null;
/* 096 */     scan_colInstance3 = null;
/* 097 */     scan_result = new UnsafeRow(4);
/* 098 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 099 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 100 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 101 */
/* 102 */   }
/* 103 */
/* 104 */   private void wholestagecodegen_init_3() {
/* 105 */     agg_result2 = new UnsafeRow(2);
/* 106 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 32);
/* 107 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 108 */
/* 109 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 110 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 111 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 112 */
/* 113 */   }
/* 114 */
/* 115 */   private void scan_nextBatch() throws java.io.IOException {
/* 116 */     long getBatchStart = System.nanoTime();
/* 117 */     if (scan_input.hasNext()) {
/* 118 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 119 */       scan_numOutputRows.add(scan_batch.numRows());
/* 120 */       scan_batchIdx = 0;
/* 121 */       scan_colInstance0 = scan_batch.column(0);
/* 122 */       scan_colInstance1 = scan_batch.column(1);
/* 123 */       scan_colInstance2 = scan_batch.column(2);
/* 124 */       scan_colInstance3 = scan_batch.column(3);
/* 125 */
/* 126 */     }
/* 127 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 128 */   }
/* 129 */
/* 130 */   public class agg_FastHashMap {
/* 131 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 132 */     private int[] buckets;
/* 133 */     private int capacity = 1 << 16;
/* 134 */     private double loadFactor = 0.5;
/* 135 */     private int numBuckets = (int) (capacity / loadFactor);
/* 136 */     private int maxSteps = 2;
/* 137 */     private int numRows = 0;
/* 138 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.LongType)
/* 139 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType);
/* 140 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 141 */     private Object emptyVBase;
/* 142 */     private long emptyVOff;
/* 143 */     private int emptyVLen;
/* 144 */     private boolean isBatchFull = false;
/* 145 */
/* 146 */     public agg_FastHashMap(
/* 147 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 148 */       InternalRow emptyAggregationBuffer) {
/* 149 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 150 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 151 */
/* 152 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 153 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 154 */
/* 155 */       emptyVBase = emptyBuffer;
/* 156 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 157 */       emptyVLen = emptyBuffer.length;
/* 158 */
/* 159 */       buckets = new int[numBuckets];
/* 160 */       java.util.Arrays.fill(buckets, -1);
/* 161 */     }
/* 162 */
/* 163 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(long agg_key, UTF8String agg_key1) {
/* 164 */       long h = hash(agg_key, agg_key1);
/* 165 */       int step = 0;
/* 166 */       int idx = (int) h & (numBuckets - 1);
/* 167 */       while (step < maxSteps) {
/* 168 */         // Return bucket index if it's either an empty slot or already contains the key
/* 169 */         if (buckets[idx] == -1) {
/* 170 */           if (numRows < capacity && !isBatchFull) {
/* 171 */             // creating the unsafe for new entry
/* 172 */             UnsafeRow agg_result = new UnsafeRow(2);
/* 173 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 174 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 175 */               32);
/* 176 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 177 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 178 */               agg_holder,
/* 179 */               2);
/* 180 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 181 */             agg_rowWriter.zeroOutNullBytes();
/* 182 */             agg_rowWriter.write(0, agg_key);
/* 183 */             agg_rowWriter.write(1, agg_key1);
/* 184 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 185 */             Object kbase = agg_result.getBaseObject();
/* 186 */             long koff = agg_result.getBaseOffset();
/* 187 */             int klen = agg_result.getSizeInBytes();
/* 188 */
/* 189 */             UnsafeRow vRow
/* 190 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 191 */             if (vRow == null) {
/* 192 */               isBatchFull = true;
/* 193 */             } else {
/* 194 */               buckets[idx] = numRows++;
/* 195 */             }
/* 196 */             return vRow;
/* 197 */           } else {
/* 198 */             // No more space
/* 199 */             return null;
/* 200 */           }
/* 201 */         } else if (equals(idx, agg_key, agg_key1)) {
/* 202 */           return batch.getValueRow(buckets[idx]);
/* 203 */         }
/* 204 */         idx = (idx + 1) & (numBuckets - 1);
/* 205 */         step++;
/* 206 */       }
/* 207 */       // Didn't find it
/* 208 */       return null;
/* 209 */     }
/* 210 */
/* 211 */     private boolean equals(int idx, long agg_key, UTF8String agg_key1) {
/* 212 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 213 */       return (row.getLong(0) == agg_key) && (row.getUTF8String(1).equals(agg_key1));
/* 214 */     }
/* 215 */
/* 216 */     private long hash(long agg_key, UTF8String agg_key1) {
/* 217 */       long agg_hash = 0;
/* 218 */
/* 219 */       long agg_result = agg_key;
/* 220 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 221 */
/* 222 */       int agg_result1 = 0;
/* 223 */       byte[] agg_bytes = agg_key1.getBytes();
/* 224 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 225 */         int agg_hash1 = agg_bytes[i];
/* 226 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash1 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 227 */       }
/* 228 */
/* 229 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 230 */
/* 231 */       return agg_hash;
/* 232 */     }
/* 233 */
/* 234 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 235 */       return batch.rowIterator();
/* 236 */     }
/* 237 */
/* 238 */     public void close() {
/* 239 */       batch.close();
/* 240 */     }
/* 241 */
/* 242 */   }
/* 243 */
/* 244 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 245 */     agg_hashMap = agg_plan.createHashMap();
/* 246 */
/* 247 */     if (scan_batch == null) {
/* 248 */       scan_nextBatch();
/* 249 */     }
/* 250 */     while (scan_batch != null) {
/* 251 */       int scan_numRows = scan_batch.numRows();
/* 252 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 253 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 254 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 255 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 256 */         long scan_value1 = scan_isNull1 ? -1L : (scan_colInstance1.getLong(scan_rowIdx));
/* 257 */
/* 258 */         if (!(!(scan_isNull1))) continue;
/* 259 */
/* 260 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 261 */         long scan_value = scan_isNull ? -1L : (scan_colInstance0.getLong(scan_rowIdx));
/* 262 */
/* 263 */         if (!(!(scan_isNull))) continue;
/* 264 */
/* 265 */         filter_numOutputRows.add(1);
/* 266 */
/* 267 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 268 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 269 */
/* 270 */         // generate join key for stream side
/* 271 */
/* 272 */         boolean bhj_isNull = scan_isNull3;
/* 273 */         long bhj_value = -1L;
/* 274 */         if (!scan_isNull3) {
/* 275 */           bhj_value = (long) scan_value3;
/* 276 */         }
/* 277 */         // find matches from HashedRelation
/* 278 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 279 */         if (bhj_matched == null) continue;
/* 280 */
/* 281 */         bhj_numOutputRows.add(1);
/* 282 */
/* 283 */         // generate join key for stream side
/* 284 */
/* 285 */         // find matches from HashedRelation
/* 286 */         UnsafeRow bhj_matched1 = false ? null: (UnsafeRow)bhj_relation1.getValue(scan_value1);
/* 287 */         if (bhj_matched1 == null) continue;
/* 288 */
/* 289 */         bhj_numOutputRows1.add(1);
/* 290 */
/* 291 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 292 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 293 */         boolean bhj_isNull10 = bhj_matched1.isNullAt(1);
/* 294 */         UTF8String bhj_value10 = bhj_isNull10 ? null : (bhj_matched1.getUTF8String(1));
/* 295 */
/* 296 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 297 */
/* 298 */         UnsafeRow agg_fastAggBuffer = null;
/* 299 */
/* 300 */         if (true) {
/* 301 */           if (!false && !bhj_isNull10) {
/* 302 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 303 */               scan_value, bhj_value10);
/* 304 */           }
/* 305 */         }
/* 306 */
/* 307 */         if (agg_fastAggBuffer == null) {
/* 308 */           // generate grouping key
/* 309 */           agg_holder.reset();
/* 310 */
/* 311 */           agg_rowWriter.zeroOutNullBytes();
/* 312 */
/* 313 */           agg_rowWriter.write(0, scan_value);
/* 314 */
/* 315 */           if (bhj_isNull10) {
/* 316 */             agg_rowWriter.setNullAt(1);
/* 317 */           } else {
/* 318 */             agg_rowWriter.write(1, bhj_value10);
/* 319 */           }
/* 320 */           agg_result2.setTotalSize(agg_holder.totalSize());
/* 321 */           agg_value6 = 42;
/* 322 */
/* 323 */           if (!false) {
/* 324 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashLong(scan_value, agg_value6);
/* 325 */           }
/* 326 */
/* 327 */           if (!bhj_isNull10) {
/* 328 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value10.getBaseObject(), bhj_value10.getBaseOffset(), bhj_value10.numBytes(), agg_value6);
/* 329 */           }
/* 330 */           if (true) {
/* 331 */             // try to get the buffer from hash map
/* 332 */             agg_unsafeRowAggBuffer =
/* 333 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 334 */           }
/* 335 */           if (agg_unsafeRowAggBuffer == null) {
/* 336 */             if (agg_sorter == null) {
/* 337 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 338 */             } else {
/* 339 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 340 */             }
/* 341 */
/* 342 */             // the hash map had be spilled, it should have enough memory now,
/* 343 */             // try  to allocate buffer again.
/* 344 */             agg_unsafeRowAggBuffer =
/* 345 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 346 */             if (agg_unsafeRowAggBuffer == null) {
/* 347 */               // failed to allocate the first page
/* 348 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 349 */             }
/* 350 */           }
/* 351 */         }
/* 352 */
/* 353 */         if (agg_fastAggBuffer != null) {
/* 354 */           // update fast row
/* 355 */
/* 356 */           // common sub-expressions
/* 357 */
/* 358 */           // evaluate aggregate function
/* 359 */           boolean agg_isNull17 = true;
/* 360 */           double agg_value18 = -1.0;
/* 361 */
/* 362 */           boolean agg_isNull19 = agg_fastAggBuffer.isNullAt(0);
/* 363 */           double agg_value20 = agg_isNull19 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 364 */           boolean agg_isNull18 = agg_isNull19;
/* 365 */           double agg_value19 = agg_value20;
/* 366 */           if (agg_isNull18) {
/* 367 */             boolean agg_isNull20 = false;
/* 368 */             double agg_value21 = -1.0;
/* 369 */             if (!false) {
/* 370 */               agg_value21 = (double) 0;
/* 371 */             }
/* 372 */             if (!agg_isNull20) {
/* 373 */               agg_isNull18 = false;
/* 374 */               agg_value19 = agg_value21;
/* 375 */             }
/* 376 */           }
/* 377 */
/* 378 */           if (!scan_isNull2) {
/* 379 */             agg_isNull17 = false; // resultCode could change nullability.
/* 380 */             agg_value18 = agg_value19 + scan_value2;
/* 381 */
/* 382 */           }
/* 383 */           boolean agg_isNull16 = agg_isNull17;
/* 384 */           double agg_value17 = agg_value18;
/* 385 */           if (agg_isNull16) {
/* 386 */             boolean agg_isNull23 = agg_fastAggBuffer.isNullAt(0);
/* 387 */             double agg_value24 = agg_isNull23 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 388 */             if (!agg_isNull23) {
/* 389 */               agg_isNull16 = false;
/* 390 */               agg_value17 = agg_value24;
/* 391 */             }
/* 392 */           }
/* 393 */           // update fast row
/* 394 */           if (!agg_isNull16) {
/* 395 */             agg_fastAggBuffer.setDouble(0, agg_value17);
/* 396 */           } else {
/* 397 */             agg_fastAggBuffer.setNullAt(0);
/* 398 */           }
/* 399 */
/* 400 */         } else {
/* 401 */           // update unsafe row
/* 402 */
/* 403 */           // common sub-expressions
/* 404 */
/* 405 */           // evaluate aggregate function
/* 406 */           boolean agg_isNull9 = true;
/* 407 */           double agg_value10 = -1.0;
/* 408 */
/* 409 */           boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 410 */           double agg_value12 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 411 */           boolean agg_isNull10 = agg_isNull11;
/* 412 */           double agg_value11 = agg_value12;
/* 413 */           if (agg_isNull10) {
/* 414 */             boolean agg_isNull12 = false;
/* 415 */             double agg_value13 = -1.0;
/* 416 */             if (!false) {
/* 417 */               agg_value13 = (double) 0;
/* 418 */             }
/* 419 */             if (!agg_isNull12) {
/* 420 */               agg_isNull10 = false;
/* 421 */               agg_value11 = agg_value13;
/* 422 */             }
/* 423 */           }
/* 424 */
/* 425 */           if (!scan_isNull2) {
/* 426 */             agg_isNull9 = false; // resultCode could change nullability.
/* 427 */             agg_value10 = agg_value11 + scan_value2;
/* 428 */
/* 429 */           }
/* 430 */           boolean agg_isNull8 = agg_isNull9;
/* 431 */           double agg_value9 = agg_value10;
/* 432 */           if (agg_isNull8) {
/* 433 */             boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 434 */             double agg_value16 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 435 */             if (!agg_isNull15) {
/* 436 */               agg_isNull8 = false;
/* 437 */               agg_value9 = agg_value16;
/* 438 */             }
/* 439 */           }
/* 440 */           // update unsafe row buffer
/* 441 */           if (!agg_isNull8) {
/* 442 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 443 */           } else {
/* 444 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 445 */           }
/* 446 */
/* 447 */         }
/* 448 */         // shouldStop check is eliminated
/* 449 */       }
/* 450 */       scan_batchIdx = scan_numRows;
/* 451 */       scan_batch = null;
/* 452 */       scan_nextBatch();
/* 453 */     }
/* 454 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 455 */     scan_scanTime1 = 0;
/* 456 */
/* 457 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 458 */
/* 459 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 460 */   }
/* 461 */
/* 462 */   private void wholestagecodegen_init_2() {
/* 463 */     project_result1 = new UnsafeRow(3);
/* 464 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 465 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 466 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[11];
/* 467 */
/* 468 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 469 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 470 */
/* 471 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 472 */     bhj_result1 = new UnsafeRow(5);
/* 473 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 474 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 5);
/* 475 */     project_result2 = new UnsafeRow(3);
/* 476 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 477 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 3);
/* 478 */
/* 479 */   }
/* 480 */
/* 481 */   private void wholestagecodegen_init_1() {
/* 482 */     filter_result = new UnsafeRow(4);
/* 483 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 484 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 485 */     project_result = new UnsafeRow(4);
/* 486 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 487 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 488 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 489 */
/* 490 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 491 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 492 */
/* 493 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 494 */     bhj_result = new UnsafeRow(5);
/* 495 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 496 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 497 */
/* 498 */   }
/* 499 */
/* 500 */   protected void processNext() throws java.io.IOException {
/* 501 */     if (!agg_initAgg) {
/* 502 */       agg_initAgg = true;
/* 503 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 504 */       agg_doAggregateWithKeys();
/* 505 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 506 */     }
/* 507 */
/* 508 */     // output the result
/* 509 */
/* 510 */     while (agg_fastHashMapIter.next()) {
/* 511 */       wholestagecodegen_numOutputRows.add(1);
/* 512 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 513 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 514 */
/* 515 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 516 */
/* 517 */       append(agg_resultRow);
/* 518 */
/* 519 */       if (shouldStop()) return;
/* 520 */     }
/* 521 */     agg_fastHashMap.close();
/* 522 */
/* 523 */     while (agg_mapIter.next()) {
/* 524 */       wholestagecodegen_numOutputRows.add(1);
/* 525 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 526 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 527 */
/* 528 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 529 */
/* 530 */       append(agg_resultRow);
/* 531 */
/* 532 */       if (shouldStop()) return;
/* 533 */     }
/* 534 */
/* 535 */     agg_mapIter.close();
/* 536 */     if (agg_sorter == null) {
/* 537 */       agg_hashMap.free();
/* 538 */     }
/* 539 */   }
/* 540 */ }

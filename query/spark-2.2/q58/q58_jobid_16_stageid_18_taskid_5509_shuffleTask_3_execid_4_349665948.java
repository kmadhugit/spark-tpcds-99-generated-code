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
/* 028 */   private UnsafeRow scan_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 032 */   private UnsafeRow filter_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 039 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 041 */   private UnsafeRow bhj_result;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 044 */   private UnsafeRow project_result1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 047 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 048 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 049 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 050 */   private UnsafeRow bhj_result1;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 053 */   private UnsafeRow project_result2;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 056 */   private UnsafeRow agg_result1;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 059 */   private int agg_value4;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 061 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 062 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 063 */
/* 064 */   public GeneratedIterator(Object[] references) {
/* 065 */     this.references = references;
/* 066 */   }
/* 067 */
/* 068 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 069 */     partitionIndex = index;
/* 070 */     this.inputs = inputs;
/* 071 */     wholestagecodegen_init_0();
/* 072 */     wholestagecodegen_init_1();
/* 073 */     wholestagecodegen_init_2();
/* 074 */     wholestagecodegen_init_3();
/* 075 */
/* 076 */   }
/* 077 */
/* 078 */   private void wholestagecodegen_init_0() {
/* 079 */     agg_initAgg = false;
/* 080 */
/* 081 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 082 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 083 */
/* 084 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 085 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 086 */     scan_input = inputs[0];
/* 087 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 088 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 089 */     scan_scanTime1 = 0;
/* 090 */     scan_batch = null;
/* 091 */     scan_batchIdx = 0;
/* 092 */     scan_colInstance0 = null;
/* 093 */     scan_colInstance1 = null;
/* 094 */     scan_colInstance2 = null;
/* 095 */     scan_result = new UnsafeRow(3);
/* 096 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 097 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 098 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 099 */
/* 100 */   }
/* 101 */
/* 102 */   private void wholestagecodegen_init_3() {
/* 103 */     agg_result1 = new UnsafeRow(1);
/* 104 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 105 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 106 */
/* 107 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 108 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 109 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 110 */
/* 111 */   }
/* 112 */
/* 113 */   private void scan_nextBatch() throws java.io.IOException {
/* 114 */     long getBatchStart = System.nanoTime();
/* 115 */     if (scan_input.hasNext()) {
/* 116 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 117 */       scan_numOutputRows.add(scan_batch.numRows());
/* 118 */       scan_batchIdx = 0;
/* 119 */       scan_colInstance0 = scan_batch.column(0);
/* 120 */       scan_colInstance1 = scan_batch.column(1);
/* 121 */       scan_colInstance2 = scan_batch.column(2);
/* 122 */
/* 123 */     }
/* 124 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 125 */   }
/* 126 */
/* 127 */   public class agg_FastHashMap {
/* 128 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 129 */     private int[] buckets;
/* 130 */     private int capacity = 1 << 16;
/* 131 */     private double loadFactor = 0.5;
/* 132 */     private int numBuckets = (int) (capacity / loadFactor);
/* 133 */     private int maxSteps = 2;
/* 134 */     private int numRows = 0;
/* 135 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType);
/* 136 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 137 */     private Object emptyVBase;
/* 138 */     private long emptyVOff;
/* 139 */     private int emptyVLen;
/* 140 */     private boolean isBatchFull = false;
/* 141 */
/* 142 */     public agg_FastHashMap(
/* 143 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 144 */       InternalRow emptyAggregationBuffer) {
/* 145 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 146 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 147 */
/* 148 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 149 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 150 */
/* 151 */       emptyVBase = emptyBuffer;
/* 152 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 153 */       emptyVLen = emptyBuffer.length;
/* 154 */
/* 155 */       buckets = new int[numBuckets];
/* 156 */       java.util.Arrays.fill(buckets, -1);
/* 157 */     }
/* 158 */
/* 159 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key) {
/* 160 */       long h = hash(agg_key);
/* 161 */       int step = 0;
/* 162 */       int idx = (int) h & (numBuckets - 1);
/* 163 */       while (step < maxSteps) {
/* 164 */         // Return bucket index if it's either an empty slot or already contains the key
/* 165 */         if (buckets[idx] == -1) {
/* 166 */           if (numRows < capacity && !isBatchFull) {
/* 167 */             // creating the unsafe for new entry
/* 168 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 169 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 170 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 171 */               32);
/* 172 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 173 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 174 */               agg_holder,
/* 175 */               1);
/* 176 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 177 */             agg_rowWriter.zeroOutNullBytes();
/* 178 */             agg_rowWriter.write(0, agg_key);
/* 179 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 180 */             Object kbase = agg_result.getBaseObject();
/* 181 */             long koff = agg_result.getBaseOffset();
/* 182 */             int klen = agg_result.getSizeInBytes();
/* 183 */
/* 184 */             UnsafeRow vRow
/* 185 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 186 */             if (vRow == null) {
/* 187 */               isBatchFull = true;
/* 188 */             } else {
/* 189 */               buckets[idx] = numRows++;
/* 190 */             }
/* 191 */             return vRow;
/* 192 */           } else {
/* 193 */             // No more space
/* 194 */             return null;
/* 195 */           }
/* 196 */         } else if (equals(idx, agg_key)) {
/* 197 */           return batch.getValueRow(buckets[idx]);
/* 198 */         }
/* 199 */         idx = (idx + 1) & (numBuckets - 1);
/* 200 */         step++;
/* 201 */       }
/* 202 */       // Didn't find it
/* 203 */       return null;
/* 204 */     }
/* 205 */
/* 206 */     private boolean equals(int idx, UTF8String agg_key) {
/* 207 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 208 */       return (row.getUTF8String(0).equals(agg_key));
/* 209 */     }
/* 210 */
/* 211 */     private long hash(UTF8String agg_key) {
/* 212 */       long agg_hash = 0;
/* 213 */
/* 214 */       int agg_result = 0;
/* 215 */       byte[] agg_bytes = agg_key.getBytes();
/* 216 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 217 */         int agg_hash1 = agg_bytes[i];
/* 218 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 219 */       }
/* 220 */
/* 221 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 222 */
/* 223 */       return agg_hash;
/* 224 */     }
/* 225 */
/* 226 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 227 */       return batch.rowIterator();
/* 228 */     }
/* 229 */
/* 230 */     public void close() {
/* 231 */       batch.close();
/* 232 */     }
/* 233 */
/* 234 */   }
/* 235 */
/* 236 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 237 */     agg_hashMap = agg_plan.createHashMap();
/* 238 */
/* 239 */     if (scan_batch == null) {
/* 240 */       scan_nextBatch();
/* 241 */     }
/* 242 */     while (scan_batch != null) {
/* 243 */       int scan_numRows = scan_batch.numRows();
/* 244 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 245 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 246 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 247 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 248 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 249 */
/* 250 */         if (!(!(scan_isNull))) continue;
/* 251 */
/* 252 */         filter_numOutputRows.add(1);
/* 253 */
/* 254 */         // generate join key for stream side
/* 255 */
/* 256 */         boolean bhj_isNull = false;
/* 257 */         long bhj_value = -1L;
/* 258 */         if (!false) {
/* 259 */           bhj_value = (long) scan_value;
/* 260 */         }
/* 261 */         // find matches from HashedRelation
/* 262 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 263 */         if (bhj_matched == null) continue;
/* 264 */
/* 265 */         bhj_numOutputRows.add(1);
/* 266 */
/* 267 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 268 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 269 */
/* 270 */         // generate join key for stream side
/* 271 */
/* 272 */         boolean bhj_isNull9 = scan_isNull2;
/* 273 */         long bhj_value9 = -1L;
/* 274 */         if (!scan_isNull2) {
/* 275 */           bhj_value9 = (long) scan_value2;
/* 276 */         }
/* 277 */         // find matches from HashedRelation
/* 278 */         UnsafeRow bhj_matched1 = bhj_isNull9 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value9);
/* 279 */         if (bhj_matched1 == null) continue;
/* 280 */
/* 281 */         bhj_numOutputRows1.add(1);
/* 282 */
/* 283 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 284 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 285 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 286 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 287 */
/* 288 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 289 */
/* 290 */         UnsafeRow agg_fastAggBuffer = null;
/* 291 */
/* 292 */         if (true) {
/* 293 */           if (!bhj_isNull3) {
/* 294 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 295 */               bhj_value3);
/* 296 */           }
/* 297 */         }
/* 298 */
/* 299 */         if (agg_fastAggBuffer == null) {
/* 300 */           // generate grouping key
/* 301 */           agg_holder.reset();
/* 302 */
/* 303 */           agg_rowWriter.zeroOutNullBytes();
/* 304 */
/* 305 */           if (bhj_isNull3) {
/* 306 */             agg_rowWriter.setNullAt(0);
/* 307 */           } else {
/* 308 */             agg_rowWriter.write(0, bhj_value3);
/* 309 */           }
/* 310 */           agg_result1.setTotalSize(agg_holder.totalSize());
/* 311 */           agg_value4 = 42;
/* 312 */
/* 313 */           if (!bhj_isNull3) {
/* 314 */             agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value4);
/* 315 */           }
/* 316 */           if (true) {
/* 317 */             // try to get the buffer from hash map
/* 318 */             agg_unsafeRowAggBuffer =
/* 319 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 320 */           }
/* 321 */           if (agg_unsafeRowAggBuffer == null) {
/* 322 */             if (agg_sorter == null) {
/* 323 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 324 */             } else {
/* 325 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 326 */             }
/* 327 */
/* 328 */             // the hash map had be spilled, it should have enough memory now,
/* 329 */             // try  to allocate buffer again.
/* 330 */             agg_unsafeRowAggBuffer =
/* 331 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 332 */             if (agg_unsafeRowAggBuffer == null) {
/* 333 */               // failed to allocate the first page
/* 334 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 335 */             }
/* 336 */           }
/* 337 */         }
/* 338 */
/* 339 */         if (agg_fastAggBuffer != null) {
/* 340 */           // update fast row
/* 341 */
/* 342 */           // common sub-expressions
/* 343 */
/* 344 */           // evaluate aggregate function
/* 345 */           boolean agg_isNull14 = true;
/* 346 */           double agg_value15 = -1.0;
/* 347 */
/* 348 */           boolean agg_isNull16 = agg_fastAggBuffer.isNullAt(0);
/* 349 */           double agg_value17 = agg_isNull16 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 350 */           boolean agg_isNull15 = agg_isNull16;
/* 351 */           double agg_value16 = agg_value17;
/* 352 */           if (agg_isNull15) {
/* 353 */             boolean agg_isNull17 = false;
/* 354 */             double agg_value18 = -1.0;
/* 355 */             if (!false) {
/* 356 */               agg_value18 = (double) 0;
/* 357 */             }
/* 358 */             if (!agg_isNull17) {
/* 359 */               agg_isNull15 = false;
/* 360 */               agg_value16 = agg_value18;
/* 361 */             }
/* 362 */           }
/* 363 */
/* 364 */           if (!scan_isNull1) {
/* 365 */             agg_isNull14 = false; // resultCode could change nullability.
/* 366 */             agg_value15 = agg_value16 + scan_value1;
/* 367 */
/* 368 */           }
/* 369 */           boolean agg_isNull13 = agg_isNull14;
/* 370 */           double agg_value14 = agg_value15;
/* 371 */           if (agg_isNull13) {
/* 372 */             boolean agg_isNull20 = agg_fastAggBuffer.isNullAt(0);
/* 373 */             double agg_value21 = agg_isNull20 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 374 */             if (!agg_isNull20) {
/* 375 */               agg_isNull13 = false;
/* 376 */               agg_value14 = agg_value21;
/* 377 */             }
/* 378 */           }
/* 379 */           // update fast row
/* 380 */           if (!agg_isNull13) {
/* 381 */             agg_fastAggBuffer.setDouble(0, agg_value14);
/* 382 */           } else {
/* 383 */             agg_fastAggBuffer.setNullAt(0);
/* 384 */           }
/* 385 */
/* 386 */         } else {
/* 387 */           // update unsafe row
/* 388 */
/* 389 */           // common sub-expressions
/* 390 */
/* 391 */           // evaluate aggregate function
/* 392 */           boolean agg_isNull6 = true;
/* 393 */           double agg_value7 = -1.0;
/* 394 */
/* 395 */           boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 396 */           double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 397 */           boolean agg_isNull7 = agg_isNull8;
/* 398 */           double agg_value8 = agg_value9;
/* 399 */           if (agg_isNull7) {
/* 400 */             boolean agg_isNull9 = false;
/* 401 */             double agg_value10 = -1.0;
/* 402 */             if (!false) {
/* 403 */               agg_value10 = (double) 0;
/* 404 */             }
/* 405 */             if (!agg_isNull9) {
/* 406 */               agg_isNull7 = false;
/* 407 */               agg_value8 = agg_value10;
/* 408 */             }
/* 409 */           }
/* 410 */
/* 411 */           if (!scan_isNull1) {
/* 412 */             agg_isNull6 = false; // resultCode could change nullability.
/* 413 */             agg_value7 = agg_value8 + scan_value1;
/* 414 */
/* 415 */           }
/* 416 */           boolean agg_isNull5 = agg_isNull6;
/* 417 */           double agg_value6 = agg_value7;
/* 418 */           if (agg_isNull5) {
/* 419 */             boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 420 */             double agg_value13 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 421 */             if (!agg_isNull12) {
/* 422 */               agg_isNull5 = false;
/* 423 */               agg_value6 = agg_value13;
/* 424 */             }
/* 425 */           }
/* 426 */           // update unsafe row buffer
/* 427 */           if (!agg_isNull5) {
/* 428 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 429 */           } else {
/* 430 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 431 */           }
/* 432 */
/* 433 */         }
/* 434 */         // shouldStop check is eliminated
/* 435 */       }
/* 436 */       scan_batchIdx = scan_numRows;
/* 437 */       scan_batch = null;
/* 438 */       scan_nextBatch();
/* 439 */     }
/* 440 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 441 */     scan_scanTime1 = 0;
/* 442 */
/* 443 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 444 */
/* 445 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 446 */   }
/* 447 */
/* 448 */   private void wholestagecodegen_init_2() {
/* 449 */     project_result1 = new UnsafeRow(3);
/* 450 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 451 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 452 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 453 */
/* 454 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 455 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 456 */
/* 457 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 458 */     bhj_result1 = new UnsafeRow(4);
/* 459 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 460 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 4);
/* 461 */     project_result2 = new UnsafeRow(2);
/* 462 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 463 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 2);
/* 464 */
/* 465 */   }
/* 466 */
/* 467 */   private void wholestagecodegen_init_1() {
/* 468 */     filter_result = new UnsafeRow(3);
/* 469 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 470 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 471 */     project_result = new UnsafeRow(3);
/* 472 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 473 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 474 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 475 */
/* 476 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 477 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 478 */
/* 479 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 480 */     bhj_result = new UnsafeRow(5);
/* 481 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 482 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 483 */
/* 484 */   }
/* 485 */
/* 486 */   protected void processNext() throws java.io.IOException {
/* 487 */     if (!agg_initAgg) {
/* 488 */       agg_initAgg = true;
/* 489 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 490 */       agg_doAggregateWithKeys();
/* 491 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 492 */     }
/* 493 */
/* 494 */     // output the result
/* 495 */
/* 496 */     while (agg_fastHashMapIter.next()) {
/* 497 */       wholestagecodegen_numOutputRows.add(1);
/* 498 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 499 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 500 */
/* 501 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 502 */
/* 503 */       append(agg_resultRow);
/* 504 */
/* 505 */       if (shouldStop()) return;
/* 506 */     }
/* 507 */     agg_fastHashMap.close();
/* 508 */
/* 509 */     while (agg_mapIter.next()) {
/* 510 */       wholestagecodegen_numOutputRows.add(1);
/* 511 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 512 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 513 */
/* 514 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 515 */
/* 516 */       append(agg_resultRow);
/* 517 */
/* 518 */       if (shouldStop()) return;
/* 519 */     }
/* 520 */
/* 521 */     agg_mapIter.close();
/* 522 */     if (agg_sorter == null) {
/* 523 */       agg_hashMap.free();
/* 524 */     }
/* 525 */   }
/* 526 */ }

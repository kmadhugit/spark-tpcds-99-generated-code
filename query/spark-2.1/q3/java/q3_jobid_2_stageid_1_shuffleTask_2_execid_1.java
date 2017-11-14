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
/* 056 */   private UnsafeRow agg_result3;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 059 */   private int agg_value8;
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
/* 087 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 088 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 089 */     scan_scanTime1 = 0;
/* 090 */     scan_batch = null;
/* 091 */     scan_batchIdx = 0;
/* 092 */     scan_colInstance0 = null;
/* 093 */     scan_colInstance1 = null;
/* 094 */     scan_colInstance2 = null;
/* 095 */     scan_result = new UnsafeRow(3);
/* 096 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 097 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 098 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 099 */
/* 100 */   }
/* 101 */
/* 102 */   private void wholestagecodegen_init_3() {
/* 103 */     agg_result3 = new UnsafeRow(3);
/* 104 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 32);
/* 105 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 106 */
/* 107 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 108 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 109 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
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
/* 135 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("d_year", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 136 */     .add("i_brand", org.apache.spark.sql.types.DataTypes.StringType)
/* 137 */     .add("i_brand_id", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 138 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 139 */     private Object emptyVBase;
/* 140 */     private long emptyVOff;
/* 141 */     private int emptyVLen;
/* 142 */     private boolean isBatchFull = false;
/* 143 */
/* 144 */     public agg_FastHashMap(
/* 145 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 146 */       InternalRow emptyAggregationBuffer) {
/* 147 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 148 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 149 */
/* 150 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 151 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 152 */
/* 153 */       emptyVBase = emptyBuffer;
/* 154 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 155 */       emptyVLen = emptyBuffer.length;
/* 156 */
/* 157 */       buckets = new int[numBuckets];
/* 158 */       java.util.Arrays.fill(buckets, -1);
/* 159 */     }
/* 160 */
/* 161 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key, UTF8String agg_key1, int agg_key2) {
/* 162 */       long h = hash(agg_key, agg_key1, agg_key2);
/* 163 */       int step = 0;
/* 164 */       int idx = (int) h & (numBuckets - 1);
/* 165 */       while (step < maxSteps) {
/* 166 */         // Return bucket index if it's either an empty slot or already contains the key
/* 167 */         if (buckets[idx] == -1) {
/* 168 */           if (numRows < capacity && !isBatchFull) {
/* 169 */             // creating the unsafe for new entry
/* 170 */             UnsafeRow agg_result = new UnsafeRow(3);
/* 171 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 172 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 173 */               32);
/* 174 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 175 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 176 */               agg_holder,
/* 177 */               3);
/* 178 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 179 */             agg_rowWriter.zeroOutNullBytes();
/* 180 */             agg_rowWriter.write(0, agg_key);
/* 181 */             agg_rowWriter.write(1, agg_key1);
/* 182 */             agg_rowWriter.write(2, agg_key2);
/* 183 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 184 */             Object kbase = agg_result.getBaseObject();
/* 185 */             long koff = agg_result.getBaseOffset();
/* 186 */             int klen = agg_result.getSizeInBytes();
/* 187 */
/* 188 */             UnsafeRow vRow
/* 189 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 190 */             if (vRow == null) {
/* 191 */               isBatchFull = true;
/* 192 */             } else {
/* 193 */               buckets[idx] = numRows++;
/* 194 */             }
/* 195 */             return vRow;
/* 196 */           } else {
/* 197 */             // No more space
/* 198 */             return null;
/* 199 */           }
/* 200 */         } else if (equals(idx, agg_key, agg_key1, agg_key2)) {
/* 201 */           return batch.getValueRow(buckets[idx]);
/* 202 */         }
/* 203 */         idx = (idx + 1) & (numBuckets - 1);
/* 204 */         step++;
/* 205 */       }
/* 206 */       // Didn't find it
/* 207 */       return null;
/* 208 */     }
/* 209 */
/* 210 */     private boolean equals(int idx, int agg_key, UTF8String agg_key1, int agg_key2) {
/* 211 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 212 */       return (row.getInt(0) == agg_key) && (row.getUTF8String(1).equals(agg_key1)) && (row.getInt(2) == agg_key2);
/* 213 */     }
/* 214 */
/* 215 */     private long hash(int agg_key, UTF8String agg_key1, int agg_key2) {
/* 216 */       long agg_hash = 0;
/* 217 */
/* 218 */       int agg_result = agg_key;
/* 219 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 220 */
/* 221 */       int agg_result1 = 0;
/* 222 */       byte[] agg_bytes = agg_key1.getBytes();
/* 223 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 224 */         int agg_hash1 = agg_bytes[i];
/* 225 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash1 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 226 */       }
/* 227 */
/* 228 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 229 */
/* 230 */       int agg_result2 = agg_key2;
/* 231 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 232 */
/* 233 */       return agg_hash;
/* 234 */     }
/* 235 */
/* 236 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 237 */       return batch.rowIterator();
/* 238 */     }
/* 239 */
/* 240 */     public void close() {
/* 241 */       batch.close();
/* 242 */     }
/* 243 */
/* 244 */   }
/* 245 */
/* 246 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 247 */     agg_hashMap = agg_plan.createHashMap();
/* 248 */
/* 249 */     if (scan_batch == null) {
/* 250 */       scan_nextBatch();
/* 251 */     }
/* 252 */     while (scan_batch != null) {
/* 253 */       int numRows = scan_batch.numRows();
/* 254 */       while (scan_batchIdx < numRows) {
/* 255 */         int scan_rowIdx = scan_batchIdx++;
/* 256 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 257 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 258 */
/* 259 */         if (!(!(scan_isNull2))) continue;
/* 260 */
/* 261 */         boolean filter_isNull2 = false;
/* 262 */
/* 263 */         boolean filter_value2 = false;
/* 264 */         filter_value2 = scan_value2 == 11;
/* 265 */         if (!filter_value2) continue;
/* 266 */
/* 267 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 268 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 269 */
/* 270 */         if (!(!(scan_isNull))) continue;
/* 271 */
/* 272 */         filter_numOutputRows.add(1);
/* 273 */
/* 274 */         // generate join key for stream side
/* 275 */
/* 276 */         boolean bhj_isNull = false;
/* 277 */         long bhj_value = -1L;
/* 278 */         if (!false) {
/* 279 */           bhj_value = (long) scan_value;
/* 280 */         }
/* 281 */         // find matches from HashedRelation
/* 282 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 283 */         if (bhj_matched == null) continue;
/* 284 */
/* 285 */         bhj_numOutputRows.add(1);
/* 286 */
/* 287 */         boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 288 */         int bhj_value2 = bhj_isNull2 ? -1 : (bhj_matched.getInt(0));
/* 289 */
/* 290 */         // generate join key for stream side
/* 291 */
/* 292 */         boolean bhj_isNull10 = bhj_isNull2;
/* 293 */         long bhj_value10 = -1L;
/* 294 */         if (!bhj_isNull2) {
/* 295 */           bhj_value10 = (long) bhj_value2;
/* 296 */         }
/* 297 */         // find matches from HashedRelation
/* 298 */         UnsafeRow bhj_matched1 = bhj_isNull10 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value10);
/* 299 */         if (bhj_matched1 == null) continue;
/* 300 */
/* 301 */         bhj_numOutputRows1.add(1);
/* 302 */
/* 303 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 304 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 305 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 306 */         double bhj_value3 = bhj_isNull3 ? -1.0 : (bhj_matched.getDouble(1));
/* 307 */         boolean bhj_isNull13 = bhj_matched1.isNullAt(1);
/* 308 */         int bhj_value13 = bhj_isNull13 ? -1 : (bhj_matched1.getInt(1));
/* 309 */         boolean bhj_isNull14 = bhj_matched1.isNullAt(2);
/* 310 */         UTF8String bhj_value14 = bhj_isNull14 ? null : (bhj_matched1.getUTF8String(2));
/* 311 */
/* 312 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 313 */
/* 314 */         UnsafeRow agg_fastAggBuffer = null;
/* 315 */
/* 316 */         if (true) {
/* 317 */           if (!scan_isNull1 && !bhj_isNull14 && !bhj_isNull13) {
/* 318 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 319 */               scan_value1, bhj_value14, bhj_value13);
/* 320 */           }
/* 321 */         }
/* 322 */
/* 323 */         if (agg_fastAggBuffer == null) {
/* 324 */           // generate grouping key
/* 325 */           agg_holder.reset();
/* 326 */
/* 327 */           agg_rowWriter.zeroOutNullBytes();
/* 328 */
/* 329 */           if (scan_isNull1) {
/* 330 */             agg_rowWriter.setNullAt(0);
/* 331 */           } else {
/* 332 */             agg_rowWriter.write(0, scan_value1);
/* 333 */           }
/* 334 */
/* 335 */           if (bhj_isNull14) {
/* 336 */             agg_rowWriter.setNullAt(1);
/* 337 */           } else {
/* 338 */             agg_rowWriter.write(1, bhj_value14);
/* 339 */           }
/* 340 */
/* 341 */           if (bhj_isNull13) {
/* 342 */             agg_rowWriter.setNullAt(2);
/* 343 */           } else {
/* 344 */             agg_rowWriter.write(2, bhj_value13);
/* 345 */           }
/* 346 */           agg_result3.setTotalSize(agg_holder.totalSize());
/* 347 */           agg_value8 = 42;
/* 348 */
/* 349 */           if (!scan_isNull1) {
/* 350 */             agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value1, agg_value8);
/* 351 */           }
/* 352 */
/* 353 */           if (!bhj_isNull14) {
/* 354 */             agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value14.getBaseObject(), bhj_value14.getBaseOffset(), bhj_value14.numBytes(), agg_value8);
/* 355 */           }
/* 356 */
/* 357 */           if (!bhj_isNull13) {
/* 358 */             agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value13, agg_value8);
/* 359 */           }
/* 360 */           if (true) {
/* 361 */             // try to get the buffer from hash map
/* 362 */             agg_unsafeRowAggBuffer =
/* 363 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value8);
/* 364 */           }
/* 365 */           if (agg_unsafeRowAggBuffer == null) {
/* 366 */             if (agg_sorter == null) {
/* 367 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 368 */             } else {
/* 369 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 370 */             }
/* 371 */
/* 372 */             // the hash map had be spilled, it should have enough memory now,
/* 373 */             // try  to allocate buffer again.
/* 374 */             agg_unsafeRowAggBuffer =
/* 375 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value8);
/* 376 */             if (agg_unsafeRowAggBuffer == null) {
/* 377 */               // failed to allocate the first page
/* 378 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 379 */             }
/* 380 */           }
/* 381 */         }
/* 382 */
/* 383 */         if (agg_fastAggBuffer != null) {
/* 384 */           // update fast row
/* 385 */
/* 386 */           // common sub-expressions
/* 387 */
/* 388 */           // evaluate aggregate function
/* 389 */           boolean agg_isNull21 = true;
/* 390 */           double agg_value22 = -1.0;
/* 391 */
/* 392 */           boolean agg_isNull23 = agg_fastAggBuffer.isNullAt(0);
/* 393 */           double agg_value24 = agg_isNull23 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 394 */           boolean agg_isNull22 = agg_isNull23;
/* 395 */           double agg_value23 = agg_value24;
/* 396 */           if (agg_isNull22) {
/* 397 */             boolean agg_isNull24 = false;
/* 398 */             double agg_value25 = -1.0;
/* 399 */             if (!false) {
/* 400 */               agg_value25 = (double) 0;
/* 401 */             }
/* 402 */             if (!agg_isNull24) {
/* 403 */               agg_isNull22 = false;
/* 404 */               agg_value23 = agg_value25;
/* 405 */             }
/* 406 */           }
/* 407 */
/* 408 */           boolean agg_isNull26 = bhj_isNull3;
/* 409 */           double agg_value27 = -1.0;
/* 410 */           if (!bhj_isNull3) {
/* 411 */             agg_value27 = bhj_value3;
/* 412 */           }
/* 413 */           if (!agg_isNull26) {
/* 414 */             agg_isNull21 = false; // resultCode could change nullability.
/* 415 */             agg_value22 = agg_value23 + agg_value27;
/* 416 */
/* 417 */           }
/* 418 */           boolean agg_isNull20 = agg_isNull21;
/* 419 */           double agg_value21 = agg_value22;
/* 420 */           if (agg_isNull20) {
/* 421 */             boolean agg_isNull28 = agg_fastAggBuffer.isNullAt(0);
/* 422 */             double agg_value29 = agg_isNull28 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 423 */             if (!agg_isNull28) {
/* 424 */               agg_isNull20 = false;
/* 425 */               agg_value21 = agg_value29;
/* 426 */             }
/* 427 */           }
/* 428 */           // update fast row
/* 429 */           if (!agg_isNull20) {
/* 430 */             agg_fastAggBuffer.setDouble(0, agg_value21);
/* 431 */           } else {
/* 432 */             agg_fastAggBuffer.setNullAt(0);
/* 433 */           }
/* 434 */
/* 435 */         } else {
/* 436 */           // update unsafe row
/* 437 */
/* 438 */           // common sub-expressions
/* 439 */
/* 440 */           // evaluate aggregate function
/* 441 */           boolean agg_isNull12 = true;
/* 442 */           double agg_value13 = -1.0;
/* 443 */
/* 444 */           boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 445 */           double agg_value15 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 446 */           boolean agg_isNull13 = agg_isNull14;
/* 447 */           double agg_value14 = agg_value15;
/* 448 */           if (agg_isNull13) {
/* 449 */             boolean agg_isNull15 = false;
/* 450 */             double agg_value16 = -1.0;
/* 451 */             if (!false) {
/* 452 */               agg_value16 = (double) 0;
/* 453 */             }
/* 454 */             if (!agg_isNull15) {
/* 455 */               agg_isNull13 = false;
/* 456 */               agg_value14 = agg_value16;
/* 457 */             }
/* 458 */           }
/* 459 */
/* 460 */           boolean agg_isNull17 = bhj_isNull3;
/* 461 */           double agg_value18 = -1.0;
/* 462 */           if (!bhj_isNull3) {
/* 463 */             agg_value18 = bhj_value3;
/* 464 */           }
/* 465 */           if (!agg_isNull17) {
/* 466 */             agg_isNull12 = false; // resultCode could change nullability.
/* 467 */             agg_value13 = agg_value14 + agg_value18;
/* 468 */
/* 469 */           }
/* 470 */           boolean agg_isNull11 = agg_isNull12;
/* 471 */           double agg_value12 = agg_value13;
/* 472 */           if (agg_isNull11) {
/* 473 */             boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 474 */             double agg_value20 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 475 */             if (!agg_isNull19) {
/* 476 */               agg_isNull11 = false;
/* 477 */               agg_value12 = agg_value20;
/* 478 */             }
/* 479 */           }
/* 480 */           // update unsafe row buffer
/* 481 */           if (!agg_isNull11) {
/* 482 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value12);
/* 483 */           } else {
/* 484 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 485 */           }
/* 486 */
/* 487 */         }
/* 488 */         if (shouldStop()) return;
/* 489 */       }
/* 490 */       scan_batch = null;
/* 491 */       scan_nextBatch();
/* 492 */     }
/* 493 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 494 */     scan_scanTime1 = 0;
/* 495 */
/* 496 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 497 */
/* 498 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 499 */   }
/* 500 */
/* 501 */   private void wholestagecodegen_init_2() {
/* 502 */     project_result1 = new UnsafeRow(3);
/* 503 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 504 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 505 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 506 */
/* 507 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 508 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 509 */
/* 510 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 511 */     bhj_result1 = new UnsafeRow(6);
/* 512 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 513 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 514 */     project_result2 = new UnsafeRow(4);
/* 515 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 516 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 4);
/* 517 */
/* 518 */   }
/* 519 */
/* 520 */   private void wholestagecodegen_init_1() {
/* 521 */     filter_result = new UnsafeRow(3);
/* 522 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 523 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 524 */     project_result = new UnsafeRow(2);
/* 525 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 526 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 527 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 528 */
/* 529 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 530 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 531 */
/* 532 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 533 */     bhj_result = new UnsafeRow(5);
/* 534 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 535 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 536 */
/* 537 */   }
/* 538 */
/* 539 */   protected void processNext() throws java.io.IOException {
/* 540 */     if (!agg_initAgg) {
/* 541 */       agg_initAgg = true;
/* 542 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 543 */       agg_doAggregateWithKeys();
/* 544 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 545 */     }
/* 546 */
/* 547 */     // output the result
/* 548 */
/* 549 */     while (agg_fastHashMapIter.next()) {
/* 550 */       wholestagecodegen_numOutputRows.add(1);
/* 551 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 552 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 553 */
/* 554 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 555 */
/* 556 */       append(agg_resultRow);
/* 557 */
/* 558 */       if (shouldStop()) return;
/* 559 */     }
/* 560 */     agg_fastHashMap.close();
/* 561 */
/* 562 */     while (agg_mapIter.next()) {
/* 563 */       wholestagecodegen_numOutputRows.add(1);
/* 564 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 565 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 566 */
/* 567 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 568 */
/* 569 */       append(agg_resultRow);
/* 570 */
/* 571 */       if (shouldStop()) return;
/* 572 */     }
/* 573 */
/* 574 */     agg_mapIter.close();
/* 575 */     if (agg_sorter == null) {
/* 576 */       agg_hashMap.free();
/* 577 */     }
/* 578 */   }
/* 579 */ }

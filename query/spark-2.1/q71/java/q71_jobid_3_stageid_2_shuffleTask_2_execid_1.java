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
/* 057 */   private UnsafeRow agg_result4;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 060 */   private int agg_value10;
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
/* 088 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 089 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 090 */     scan_scanTime1 = 0;
/* 091 */     scan_batch = null;
/* 092 */     scan_batchIdx = 0;
/* 093 */     scan_colInstance0 = null;
/* 094 */     scan_colInstance1 = null;
/* 095 */     scan_colInstance2 = null;
/* 096 */     scan_colInstance3 = null;
/* 097 */     scan_result = new UnsafeRow(4);
/* 098 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 32);
/* 099 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 100 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 101 */
/* 102 */   }
/* 103 */
/* 104 */   private void wholestagecodegen_init_3() {
/* 105 */     agg_result4 = new UnsafeRow(4);
/* 106 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 32);
/* 107 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 108 */
/* 109 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 110 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 111 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
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
/* 138 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("i_brand", org.apache.spark.sql.types.DataTypes.StringType)
/* 139 */     .add("i_brand_id", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 140 */     .add("t_hour", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 141 */     .add("t_minute", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 142 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("sum", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 143 */     private Object emptyVBase;
/* 144 */     private long emptyVOff;
/* 145 */     private int emptyVLen;
/* 146 */     private boolean isBatchFull = false;
/* 147 */
/* 148 */     public agg_FastHashMap(
/* 149 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 150 */       InternalRow emptyAggregationBuffer) {
/* 151 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 152 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 153 */
/* 154 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 155 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 156 */
/* 157 */       emptyVBase = emptyBuffer;
/* 158 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 159 */       emptyVLen = emptyBuffer.length;
/* 160 */
/* 161 */       buckets = new int[numBuckets];
/* 162 */       java.util.Arrays.fill(buckets, -1);
/* 163 */     }
/* 164 */
/* 165 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3) {
/* 166 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3);
/* 167 */       int step = 0;
/* 168 */       int idx = (int) h & (numBuckets - 1);
/* 169 */       while (step < maxSteps) {
/* 170 */         // Return bucket index if it's either an empty slot or already contains the key
/* 171 */         if (buckets[idx] == -1) {
/* 172 */           if (numRows < capacity && !isBatchFull) {
/* 173 */             // creating the unsafe for new entry
/* 174 */             UnsafeRow agg_result = new UnsafeRow(4);
/* 175 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 176 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 177 */               32);
/* 178 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 179 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 180 */               agg_holder,
/* 181 */               4);
/* 182 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 183 */             agg_rowWriter.zeroOutNullBytes();
/* 184 */             agg_rowWriter.write(0, agg_key);
/* 185 */             agg_rowWriter.write(1, agg_key1);
/* 186 */             agg_rowWriter.write(2, agg_key2);
/* 187 */             agg_rowWriter.write(3, agg_key3);
/* 188 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 189 */             Object kbase = agg_result.getBaseObject();
/* 190 */             long koff = agg_result.getBaseOffset();
/* 191 */             int klen = agg_result.getSizeInBytes();
/* 192 */
/* 193 */             UnsafeRow vRow
/* 194 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 195 */             if (vRow == null) {
/* 196 */               isBatchFull = true;
/* 197 */             } else {
/* 198 */               buckets[idx] = numRows++;
/* 199 */             }
/* 200 */             return vRow;
/* 201 */           } else {
/* 202 */             // No more space
/* 203 */             return null;
/* 204 */           }
/* 205 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3)) {
/* 206 */           return batch.getValueRow(buckets[idx]);
/* 207 */         }
/* 208 */         idx = (idx + 1) & (numBuckets - 1);
/* 209 */         step++;
/* 210 */       }
/* 211 */       // Didn't find it
/* 212 */       return null;
/* 213 */     }
/* 214 */
/* 215 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3) {
/* 216 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 217 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1) && (row.getInt(2) == agg_key2) && (row.getInt(3) == agg_key3);
/* 218 */     }
/* 219 */
/* 220 */     private long hash(UTF8String agg_key, int agg_key1, int agg_key2, int agg_key3) {
/* 221 */       long agg_hash = 0;
/* 222 */
/* 223 */       int agg_result = 0;
/* 224 */       byte[] agg_bytes = agg_key.getBytes();
/* 225 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 226 */         int agg_hash1 = agg_bytes[i];
/* 227 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 228 */       }
/* 229 */
/* 230 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 231 */
/* 232 */       int agg_result1 = agg_key1;
/* 233 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 234 */
/* 235 */       int agg_result2 = agg_key2;
/* 236 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 237 */
/* 238 */       int agg_result3 = agg_key3;
/* 239 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 240 */
/* 241 */       return agg_hash;
/* 242 */     }
/* 243 */
/* 244 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 245 */       return batch.rowIterator();
/* 246 */     }
/* 247 */
/* 248 */     public void close() {
/* 249 */       batch.close();
/* 250 */     }
/* 251 */
/* 252 */   }
/* 253 */
/* 254 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 255 */     agg_hashMap = agg_plan.createHashMap();
/* 256 */
/* 257 */     if (scan_batch == null) {
/* 258 */       scan_nextBatch();
/* 259 */     }
/* 260 */     while (scan_batch != null) {
/* 261 */       int numRows = scan_batch.numRows();
/* 262 */       while (scan_batchIdx < numRows) {
/* 263 */         int scan_rowIdx = scan_batchIdx++;
/* 264 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 265 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 266 */
/* 267 */         if (!(!(scan_isNull3))) continue;
/* 268 */
/* 269 */         boolean filter_isNull2 = false;
/* 270 */
/* 271 */         boolean filter_value2 = false;
/* 272 */         filter_value2 = scan_value3 == 1;
/* 273 */         if (!filter_value2) continue;
/* 274 */
/* 275 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 276 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 277 */
/* 278 */         if (!(!(scan_isNull))) continue;
/* 279 */
/* 280 */         filter_numOutputRows.add(1);
/* 281 */
/* 282 */         // generate join key for stream side
/* 283 */
/* 284 */         boolean bhj_isNull = false;
/* 285 */         long bhj_value = -1L;
/* 286 */         if (!false) {
/* 287 */           bhj_value = (long) scan_value;
/* 288 */         }
/* 289 */         // find matches from HashedRelation
/* 290 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 291 */         if (bhj_matched == null) continue;
/* 292 */
/* 293 */         bhj_numOutputRows.add(1);
/* 294 */
/* 295 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 296 */         int bhj_value4 = bhj_isNull4 ? -1 : (bhj_matched.getInt(2));
/* 297 */
/* 298 */         // generate join key for stream side
/* 299 */
/* 300 */         boolean bhj_isNull11 = bhj_isNull4;
/* 301 */         long bhj_value11 = -1L;
/* 302 */         if (!bhj_isNull4) {
/* 303 */           bhj_value11 = (long) bhj_value4;
/* 304 */         }
/* 305 */         // find matches from HashedRelation
/* 306 */         UnsafeRow bhj_matched1 = bhj_isNull11 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value11);
/* 307 */         if (bhj_matched1 == null) continue;
/* 308 */
/* 309 */         bhj_numOutputRows1.add(1);
/* 310 */
/* 311 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 312 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 313 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 314 */         UTF8String scan_value2 = scan_isNull2 ? null : (scan_colInstance2.getUTF8String(scan_rowIdx));
/* 315 */         boolean bhj_isNull2 = bhj_matched.isNullAt(0);
/* 316 */         double bhj_value2 = bhj_isNull2 ? -1.0 : (bhj_matched.getDouble(0));
/* 317 */         boolean bhj_isNull14 = bhj_matched1.isNullAt(1);
/* 318 */         int bhj_value14 = bhj_isNull14 ? -1 : (bhj_matched1.getInt(1));
/* 319 */         boolean bhj_isNull15 = bhj_matched1.isNullAt(2);
/* 320 */         int bhj_value15 = bhj_isNull15 ? -1 : (bhj_matched1.getInt(2));
/* 321 */
/* 322 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 323 */
/* 324 */         UnsafeRow agg_fastAggBuffer = null;
/* 325 */
/* 326 */         if (true) {
/* 327 */           if (!scan_isNull2 && !scan_isNull1 && !bhj_isNull14 && !bhj_isNull15) {
/* 328 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 329 */               scan_value2, scan_value1, bhj_value14, bhj_value15);
/* 330 */           }
/* 331 */         }
/* 332 */
/* 333 */         if (agg_fastAggBuffer == null) {
/* 334 */           // generate grouping key
/* 335 */           agg_holder.reset();
/* 336 */
/* 337 */           agg_rowWriter.zeroOutNullBytes();
/* 338 */
/* 339 */           if (scan_isNull2) {
/* 340 */             agg_rowWriter.setNullAt(0);
/* 341 */           } else {
/* 342 */             agg_rowWriter.write(0, scan_value2);
/* 343 */           }
/* 344 */
/* 345 */           if (scan_isNull1) {
/* 346 */             agg_rowWriter.setNullAt(1);
/* 347 */           } else {
/* 348 */             agg_rowWriter.write(1, scan_value1);
/* 349 */           }
/* 350 */
/* 351 */           if (bhj_isNull14) {
/* 352 */             agg_rowWriter.setNullAt(2);
/* 353 */           } else {
/* 354 */             agg_rowWriter.write(2, bhj_value14);
/* 355 */           }
/* 356 */
/* 357 */           if (bhj_isNull15) {
/* 358 */             agg_rowWriter.setNullAt(3);
/* 359 */           } else {
/* 360 */             agg_rowWriter.write(3, bhj_value15);
/* 361 */           }
/* 362 */           agg_result4.setTotalSize(agg_holder.totalSize());
/* 363 */           agg_value10 = 42;
/* 364 */
/* 365 */           if (!scan_isNull2) {
/* 366 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(scan_value2.getBaseObject(), scan_value2.getBaseOffset(), scan_value2.numBytes(), agg_value10);
/* 367 */           }
/* 368 */
/* 369 */           if (!scan_isNull1) {
/* 370 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value1, agg_value10);
/* 371 */           }
/* 372 */
/* 373 */           if (!bhj_isNull14) {
/* 374 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value14, agg_value10);
/* 375 */           }
/* 376 */
/* 377 */           if (!bhj_isNull15) {
/* 378 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value15, agg_value10);
/* 379 */           }
/* 380 */           if (true) {
/* 381 */             // try to get the buffer from hash map
/* 382 */             agg_unsafeRowAggBuffer =
/* 383 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value10);
/* 384 */           }
/* 385 */           if (agg_unsafeRowAggBuffer == null) {
/* 386 */             if (agg_sorter == null) {
/* 387 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 388 */             } else {
/* 389 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 390 */             }
/* 391 */
/* 392 */             // the hash map had be spilled, it should have enough memory now,
/* 393 */             // try  to allocate buffer again.
/* 394 */             agg_unsafeRowAggBuffer =
/* 395 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value10);
/* 396 */             if (agg_unsafeRowAggBuffer == null) {
/* 397 */               // failed to allocate the first page
/* 398 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 399 */             }
/* 400 */           }
/* 401 */         }
/* 402 */
/* 403 */         if (agg_fastAggBuffer != null) {
/* 404 */           // update fast row
/* 405 */
/* 406 */           // common sub-expressions
/* 407 */
/* 408 */           // evaluate aggregate function
/* 409 */           boolean agg_isNull24 = true;
/* 410 */           double agg_value25 = -1.0;
/* 411 */
/* 412 */           boolean agg_isNull26 = agg_fastAggBuffer.isNullAt(0);
/* 413 */           double agg_value27 = agg_isNull26 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 414 */           boolean agg_isNull25 = agg_isNull26;
/* 415 */           double agg_value26 = agg_value27;
/* 416 */           if (agg_isNull25) {
/* 417 */             boolean agg_isNull27 = false;
/* 418 */             double agg_value28 = -1.0;
/* 419 */             if (!false) {
/* 420 */               agg_value28 = (double) 0;
/* 421 */             }
/* 422 */             if (!agg_isNull27) {
/* 423 */               agg_isNull25 = false;
/* 424 */               agg_value26 = agg_value28;
/* 425 */             }
/* 426 */           }
/* 427 */
/* 428 */           boolean agg_isNull29 = bhj_isNull2;
/* 429 */           double agg_value30 = -1.0;
/* 430 */           if (!bhj_isNull2) {
/* 431 */             agg_value30 = bhj_value2;
/* 432 */           }
/* 433 */           if (!agg_isNull29) {
/* 434 */             agg_isNull24 = false; // resultCode could change nullability.
/* 435 */             agg_value25 = agg_value26 + agg_value30;
/* 436 */
/* 437 */           }
/* 438 */           boolean agg_isNull23 = agg_isNull24;
/* 439 */           double agg_value24 = agg_value25;
/* 440 */           if (agg_isNull23) {
/* 441 */             boolean agg_isNull31 = agg_fastAggBuffer.isNullAt(0);
/* 442 */             double agg_value32 = agg_isNull31 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 443 */             if (!agg_isNull31) {
/* 444 */               agg_isNull23 = false;
/* 445 */               agg_value24 = agg_value32;
/* 446 */             }
/* 447 */           }
/* 448 */           // update fast row
/* 449 */           if (!agg_isNull23) {
/* 450 */             agg_fastAggBuffer.setDouble(0, agg_value24);
/* 451 */           } else {
/* 452 */             agg_fastAggBuffer.setNullAt(0);
/* 453 */           }
/* 454 */
/* 455 */         } else {
/* 456 */           // update unsafe row
/* 457 */
/* 458 */           // common sub-expressions
/* 459 */
/* 460 */           // evaluate aggregate function
/* 461 */           boolean agg_isNull15 = true;
/* 462 */           double agg_value16 = -1.0;
/* 463 */
/* 464 */           boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 465 */           double agg_value18 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 466 */           boolean agg_isNull16 = agg_isNull17;
/* 467 */           double agg_value17 = agg_value18;
/* 468 */           if (agg_isNull16) {
/* 469 */             boolean agg_isNull18 = false;
/* 470 */             double agg_value19 = -1.0;
/* 471 */             if (!false) {
/* 472 */               agg_value19 = (double) 0;
/* 473 */             }
/* 474 */             if (!agg_isNull18) {
/* 475 */               agg_isNull16 = false;
/* 476 */               agg_value17 = agg_value19;
/* 477 */             }
/* 478 */           }
/* 479 */
/* 480 */           boolean agg_isNull20 = bhj_isNull2;
/* 481 */           double agg_value21 = -1.0;
/* 482 */           if (!bhj_isNull2) {
/* 483 */             agg_value21 = bhj_value2;
/* 484 */           }
/* 485 */           if (!agg_isNull20) {
/* 486 */             agg_isNull15 = false; // resultCode could change nullability.
/* 487 */             agg_value16 = agg_value17 + agg_value21;
/* 488 */
/* 489 */           }
/* 490 */           boolean agg_isNull14 = agg_isNull15;
/* 491 */           double agg_value15 = agg_value16;
/* 492 */           if (agg_isNull14) {
/* 493 */             boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 494 */             double agg_value23 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 495 */             if (!agg_isNull22) {
/* 496 */               agg_isNull14 = false;
/* 497 */               agg_value15 = agg_value23;
/* 498 */             }
/* 499 */           }
/* 500 */           // update unsafe row buffer
/* 501 */           if (!agg_isNull14) {
/* 502 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value15);
/* 503 */           } else {
/* 504 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 505 */           }
/* 506 */
/* 507 */         }
/* 508 */         if (shouldStop()) return;
/* 509 */       }
/* 510 */       scan_batch = null;
/* 511 */       scan_nextBatch();
/* 512 */     }
/* 513 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 514 */     scan_scanTime1 = 0;
/* 515 */
/* 516 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 517 */
/* 518 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 519 */   }
/* 520 */
/* 521 */   private void wholestagecodegen_init_2() {
/* 522 */     project_result1 = new UnsafeRow(4);
/* 523 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 524 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 525 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 526 */
/* 527 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 528 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 529 */
/* 530 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 531 */     bhj_result1 = new UnsafeRow(7);
/* 532 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 533 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 534 */     project_result2 = new UnsafeRow(5);
/* 535 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 536 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 5);
/* 537 */
/* 538 */   }
/* 539 */
/* 540 */   private void wholestagecodegen_init_1() {
/* 541 */     filter_result = new UnsafeRow(4);
/* 542 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 543 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 544 */     project_result = new UnsafeRow(3);
/* 545 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 546 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 547 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[6];
/* 548 */
/* 549 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 550 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 551 */
/* 552 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 553 */     bhj_result = new UnsafeRow(6);
/* 554 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 555 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
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
/* 571 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 572 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 573 */
/* 574 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 575 */
/* 576 */       append(agg_resultRow);
/* 577 */
/* 578 */       if (shouldStop()) return;
/* 579 */     }
/* 580 */     agg_fastHashMap.close();
/* 581 */
/* 582 */     while (agg_mapIter.next()) {
/* 583 */       wholestagecodegen_numOutputRows.add(1);
/* 584 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 585 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 586 */
/* 587 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
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

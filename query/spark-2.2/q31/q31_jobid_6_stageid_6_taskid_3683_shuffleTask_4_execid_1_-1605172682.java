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
/* 087 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 088 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 089 */     scan_scanTime1 = 0;
/* 090 */     scan_batch = null;
/* 091 */     scan_batchIdx = 0;
/* 092 */     scan_colInstance0 = null;
/* 093 */     scan_colInstance1 = null;
/* 094 */     scan_colInstance2 = null;
/* 095 */     scan_result = new UnsafeRow(3);
/* 096 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 097 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 098 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 099 */
/* 100 */   }
/* 101 */
/* 102 */   private void wholestagecodegen_init_3() {
/* 103 */     agg_result3 = new UnsafeRow(3);
/* 104 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 32);
/* 105 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 106 */
/* 107 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 108 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 109 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
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
/* 135 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 136 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 137 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 138 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType);
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
/* 161 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1, int agg_key2) {
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
/* 210 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1, int agg_key2) {
/* 211 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 212 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1) && (row.getInt(2) == agg_key2);
/* 213 */     }
/* 214 */
/* 215 */     private long hash(UTF8String agg_key, int agg_key1, int agg_key2) {
/* 216 */       long agg_hash = 0;
/* 217 */
/* 218 */       int agg_result = 0;
/* 219 */       byte[] agg_bytes = agg_key.getBytes();
/* 220 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 221 */         int agg_hash1 = agg_bytes[i];
/* 222 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 223 */       }
/* 224 */
/* 225 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 226 */
/* 227 */       int agg_result1 = agg_key1;
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
/* 253 */       int scan_numRows = scan_batch.numRows();
/* 254 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 255 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 256 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 257 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 258 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 259 */
/* 260 */         if (!(!(scan_isNull))) continue;
/* 261 */
/* 262 */         filter_numOutputRows.add(1);
/* 263 */
/* 264 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 265 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 266 */
/* 267 */         // generate join key for stream side
/* 268 */
/* 269 */         boolean bhj_isNull = scan_isNull2;
/* 270 */         long bhj_value = -1L;
/* 271 */         if (!scan_isNull2) {
/* 272 */           bhj_value = (long) scan_value2;
/* 273 */         }
/* 274 */         // find matches from HashedRelation
/* 275 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 276 */         if (bhj_matched == null) continue;
/* 277 */
/* 278 */         bhj_numOutputRows.add(1);
/* 279 */
/* 280 */         // generate join key for stream side
/* 281 */
/* 282 */         boolean bhj_isNull11 = false;
/* 283 */         long bhj_value11 = -1L;
/* 284 */         if (!false) {
/* 285 */           bhj_value11 = (long) scan_value;
/* 286 */         }
/* 287 */         // find matches from HashedRelation
/* 288 */         UnsafeRow bhj_matched1 = bhj_isNull11 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value11);
/* 289 */         if (bhj_matched1 == null) continue;
/* 290 */
/* 291 */         bhj_numOutputRows1.add(1);
/* 292 */
/* 293 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 294 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 295 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 296 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 297 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 298 */         int bhj_value4 = bhj_isNull4 ? -1 : (bhj_matched.getInt(2));
/* 299 */         boolean bhj_isNull14 = bhj_matched1.isNullAt(1);
/* 300 */         UTF8String bhj_value14 = bhj_isNull14 ? null : (bhj_matched1.getUTF8String(1));
/* 301 */
/* 302 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 303 */
/* 304 */         UnsafeRow agg_fastAggBuffer = null;
/* 305 */
/* 306 */         if (true) {
/* 307 */           if (!bhj_isNull14 && !bhj_isNull4 && !bhj_isNull3) {
/* 308 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 309 */               bhj_value14, bhj_value4, bhj_value3);
/* 310 */           }
/* 311 */         }
/* 312 */
/* 313 */         if (agg_fastAggBuffer == null) {
/* 314 */           // generate grouping key
/* 315 */           agg_holder.reset();
/* 316 */
/* 317 */           agg_rowWriter.zeroOutNullBytes();
/* 318 */
/* 319 */           if (bhj_isNull14) {
/* 320 */             agg_rowWriter.setNullAt(0);
/* 321 */           } else {
/* 322 */             agg_rowWriter.write(0, bhj_value14);
/* 323 */           }
/* 324 */
/* 325 */           if (bhj_isNull4) {
/* 326 */             agg_rowWriter.setNullAt(1);
/* 327 */           } else {
/* 328 */             agg_rowWriter.write(1, bhj_value4);
/* 329 */           }
/* 330 */
/* 331 */           if (bhj_isNull3) {
/* 332 */             agg_rowWriter.setNullAt(2);
/* 333 */           } else {
/* 334 */             agg_rowWriter.write(2, bhj_value3);
/* 335 */           }
/* 336 */           agg_result3.setTotalSize(agg_holder.totalSize());
/* 337 */           agg_value8 = 42;
/* 338 */
/* 339 */           if (!bhj_isNull14) {
/* 340 */             agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value14.getBaseObject(), bhj_value14.getBaseOffset(), bhj_value14.numBytes(), agg_value8);
/* 341 */           }
/* 342 */
/* 343 */           if (!bhj_isNull4) {
/* 344 */             agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value4, agg_value8);
/* 345 */           }
/* 346 */
/* 347 */           if (!bhj_isNull3) {
/* 348 */             agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value3, agg_value8);
/* 349 */           }
/* 350 */           if (true) {
/* 351 */             // try to get the buffer from hash map
/* 352 */             agg_unsafeRowAggBuffer =
/* 353 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value8);
/* 354 */           }
/* 355 */           if (agg_unsafeRowAggBuffer == null) {
/* 356 */             if (agg_sorter == null) {
/* 357 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 358 */             } else {
/* 359 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 360 */             }
/* 361 */
/* 362 */             // the hash map had be spilled, it should have enough memory now,
/* 363 */             // try  to allocate buffer again.
/* 364 */             agg_unsafeRowAggBuffer =
/* 365 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value8);
/* 366 */             if (agg_unsafeRowAggBuffer == null) {
/* 367 */               // failed to allocate the first page
/* 368 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 369 */             }
/* 370 */           }
/* 371 */         }
/* 372 */
/* 373 */         if (agg_fastAggBuffer != null) {
/* 374 */           // update fast row
/* 375 */
/* 376 */           // common sub-expressions
/* 377 */
/* 378 */           // evaluate aggregate function
/* 379 */           boolean agg_isNull20 = true;
/* 380 */           double agg_value21 = -1.0;
/* 381 */
/* 382 */           boolean agg_isNull22 = agg_fastAggBuffer.isNullAt(0);
/* 383 */           double agg_value23 = agg_isNull22 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 384 */           boolean agg_isNull21 = agg_isNull22;
/* 385 */           double agg_value22 = agg_value23;
/* 386 */           if (agg_isNull21) {
/* 387 */             boolean agg_isNull23 = false;
/* 388 */             double agg_value24 = -1.0;
/* 389 */             if (!false) {
/* 390 */               agg_value24 = (double) 0;
/* 391 */             }
/* 392 */             if (!agg_isNull23) {
/* 393 */               agg_isNull21 = false;
/* 394 */               agg_value22 = agg_value24;
/* 395 */             }
/* 396 */           }
/* 397 */
/* 398 */           if (!scan_isNull1) {
/* 399 */             agg_isNull20 = false; // resultCode could change nullability.
/* 400 */             agg_value21 = agg_value22 + scan_value1;
/* 401 */
/* 402 */           }
/* 403 */           boolean agg_isNull19 = agg_isNull20;
/* 404 */           double agg_value20 = agg_value21;
/* 405 */           if (agg_isNull19) {
/* 406 */             boolean agg_isNull26 = agg_fastAggBuffer.isNullAt(0);
/* 407 */             double agg_value27 = agg_isNull26 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 408 */             if (!agg_isNull26) {
/* 409 */               agg_isNull19 = false;
/* 410 */               agg_value20 = agg_value27;
/* 411 */             }
/* 412 */           }
/* 413 */           // update fast row
/* 414 */           if (!agg_isNull19) {
/* 415 */             agg_fastAggBuffer.setDouble(0, agg_value20);
/* 416 */           } else {
/* 417 */             agg_fastAggBuffer.setNullAt(0);
/* 418 */           }
/* 419 */
/* 420 */         } else {
/* 421 */           // update unsafe row
/* 422 */
/* 423 */           // common sub-expressions
/* 424 */
/* 425 */           // evaluate aggregate function
/* 426 */           boolean agg_isNull12 = true;
/* 427 */           double agg_value13 = -1.0;
/* 428 */
/* 429 */           boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 430 */           double agg_value15 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 431 */           boolean agg_isNull13 = agg_isNull14;
/* 432 */           double agg_value14 = agg_value15;
/* 433 */           if (agg_isNull13) {
/* 434 */             boolean agg_isNull15 = false;
/* 435 */             double agg_value16 = -1.0;
/* 436 */             if (!false) {
/* 437 */               agg_value16 = (double) 0;
/* 438 */             }
/* 439 */             if (!agg_isNull15) {
/* 440 */               agg_isNull13 = false;
/* 441 */               agg_value14 = agg_value16;
/* 442 */             }
/* 443 */           }
/* 444 */
/* 445 */           if (!scan_isNull1) {
/* 446 */             agg_isNull12 = false; // resultCode could change nullability.
/* 447 */             agg_value13 = agg_value14 + scan_value1;
/* 448 */
/* 449 */           }
/* 450 */           boolean agg_isNull11 = agg_isNull12;
/* 451 */           double agg_value12 = agg_value13;
/* 452 */           if (agg_isNull11) {
/* 453 */             boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 454 */             double agg_value19 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 455 */             if (!agg_isNull18) {
/* 456 */               agg_isNull11 = false;
/* 457 */               agg_value12 = agg_value19;
/* 458 */             }
/* 459 */           }
/* 460 */           // update unsafe row buffer
/* 461 */           if (!agg_isNull11) {
/* 462 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value12);
/* 463 */           } else {
/* 464 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 465 */           }
/* 466 */
/* 467 */         }
/* 468 */         // shouldStop check is eliminated
/* 469 */       }
/* 470 */       scan_batchIdx = scan_numRows;
/* 471 */       scan_batch = null;
/* 472 */       scan_nextBatch();
/* 473 */     }
/* 474 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 475 */     scan_scanTime1 = 0;
/* 476 */
/* 477 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 478 */
/* 479 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 480 */   }
/* 481 */
/* 482 */   private void wholestagecodegen_init_2() {
/* 483 */     project_result1 = new UnsafeRow(4);
/* 484 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 485 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 486 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 487 */
/* 488 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 489 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 490 */
/* 491 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 492 */     bhj_result1 = new UnsafeRow(6);
/* 493 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 494 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 495 */     project_result2 = new UnsafeRow(4);
/* 496 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 497 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 4);
/* 498 */
/* 499 */   }
/* 500 */
/* 501 */   private void wholestagecodegen_init_1() {
/* 502 */     filter_result = new UnsafeRow(3);
/* 503 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 504 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 505 */     project_result = new UnsafeRow(3);
/* 506 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 507 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 508 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 509 */
/* 510 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 511 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 512 */
/* 513 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 514 */     bhj_result = new UnsafeRow(6);
/* 515 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 516 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 517 */
/* 518 */   }
/* 519 */
/* 520 */   protected void processNext() throws java.io.IOException {
/* 521 */     if (!agg_initAgg) {
/* 522 */       agg_initAgg = true;
/* 523 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 524 */       agg_doAggregateWithKeys();
/* 525 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 526 */     }
/* 527 */
/* 528 */     // output the result
/* 529 */
/* 530 */     while (agg_fastHashMapIter.next()) {
/* 531 */       wholestagecodegen_numOutputRows.add(1);
/* 532 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 533 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 534 */
/* 535 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 536 */
/* 537 */       append(agg_resultRow);
/* 538 */
/* 539 */       if (shouldStop()) return;
/* 540 */     }
/* 541 */     agg_fastHashMap.close();
/* 542 */
/* 543 */     while (agg_mapIter.next()) {
/* 544 */       wholestagecodegen_numOutputRows.add(1);
/* 545 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 546 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 547 */
/* 548 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 549 */
/* 550 */       append(agg_resultRow);
/* 551 */
/* 552 */       if (shouldStop()) return;
/* 553 */     }
/* 554 */
/* 555 */     agg_mapIter.close();
/* 556 */     if (agg_sorter == null) {
/* 557 */       agg_hashMap.free();
/* 558 */     }
/* 559 */   }
/* 560 */ }

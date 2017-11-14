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
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private double agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private double agg_bufValue6;
/* 023 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 024 */   private agg_FastHashMap agg_fastHashMap;
/* 025 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 026 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 027 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 028 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 031 */   private scala.collection.Iterator scan_input;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 034 */   private long scan_scanTime1;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 036 */   private int scan_batchIdx;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 038 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 039 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 040 */   private UnsafeRow scan_result;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 044 */   private UnsafeRow filter_result;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 047 */   private UnsafeRow project_result;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 050 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 051 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 052 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 053 */   private UnsafeRow bhj_result;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 056 */   private UnsafeRow project_result1;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 059 */   private UnsafeRow agg_result2;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 062 */   private int agg_value18;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 064 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 065 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 066 */
/* 067 */   public GeneratedIterator(Object[] references) {
/* 068 */     this.references = references;
/* 069 */   }
/* 070 */
/* 071 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 072 */     partitionIndex = index;
/* 073 */     this.inputs = inputs;
/* 074 */     wholestagecodegen_init_0();
/* 075 */     wholestagecodegen_init_1();
/* 076 */     wholestagecodegen_init_2();
/* 077 */
/* 078 */   }
/* 079 */
/* 080 */   private void wholestagecodegen_init_0() {
/* 081 */     agg_initAgg = false;
/* 082 */
/* 083 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 084 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 085 */
/* 086 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 087 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 088 */     scan_input = inputs[0];
/* 089 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 090 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 091 */     scan_scanTime1 = 0;
/* 092 */     scan_batch = null;
/* 093 */     scan_batchIdx = 0;
/* 094 */     scan_colInstance0 = null;
/* 095 */     scan_colInstance1 = null;
/* 096 */     scan_colInstance2 = null;
/* 097 */     scan_result = new UnsafeRow(3);
/* 098 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 099 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 100 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 101 */
/* 102 */   }
/* 103 */
/* 104 */   private void scan_nextBatch() throws java.io.IOException {
/* 105 */     long getBatchStart = System.nanoTime();
/* 106 */     if (scan_input.hasNext()) {
/* 107 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 108 */       scan_numOutputRows.add(scan_batch.numRows());
/* 109 */       scan_batchIdx = 0;
/* 110 */       scan_colInstance0 = scan_batch.column(0);
/* 111 */       scan_colInstance1 = scan_batch.column(1);
/* 112 */       scan_colInstance2 = scan_batch.column(2);
/* 113 */
/* 114 */     }
/* 115 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 116 */   }
/* 117 */
/* 118 */   public class agg_FastHashMap {
/* 119 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 120 */     private int[] buckets;
/* 121 */     private int capacity = 1 << 16;
/* 122 */     private double loadFactor = 0.5;
/* 123 */     private int numBuckets = (int) (capacity / loadFactor);
/* 124 */     private int maxSteps = 2;
/* 125 */     private int numRows = 0;
/* 126 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 127 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 128 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 129 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 130 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 131 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 132 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 133 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 134 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 135 */     private Object emptyVBase;
/* 136 */     private long emptyVOff;
/* 137 */     private int emptyVLen;
/* 138 */     private boolean isBatchFull = false;
/* 139 */
/* 140 */     public agg_FastHashMap(
/* 141 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 142 */       InternalRow emptyAggregationBuffer) {
/* 143 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 144 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 145 */
/* 146 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 147 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 148 */
/* 149 */       emptyVBase = emptyBuffer;
/* 150 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 151 */       emptyVLen = emptyBuffer.length;
/* 152 */
/* 153 */       buckets = new int[numBuckets];
/* 154 */       java.util.Arrays.fill(buckets, -1);
/* 155 */     }
/* 156 */
/* 157 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key, int agg_key1) {
/* 158 */       long h = hash(agg_key, agg_key1);
/* 159 */       int step = 0;
/* 160 */       int idx = (int) h & (numBuckets - 1);
/* 161 */       while (step < maxSteps) {
/* 162 */         // Return bucket index if it's either an empty slot or already contains the key
/* 163 */         if (buckets[idx] == -1) {
/* 164 */           if (numRows < capacity && !isBatchFull) {
/* 165 */             // creating the unsafe for new entry
/* 166 */             UnsafeRow agg_result = new UnsafeRow(2);
/* 167 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 168 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 169 */               0);
/* 170 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 171 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 172 */               agg_holder,
/* 173 */               2);
/* 174 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 175 */             agg_rowWriter.zeroOutNullBytes();
/* 176 */             agg_rowWriter.write(0, agg_key);
/* 177 */             agg_rowWriter.write(1, agg_key1);
/* 178 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 179 */             Object kbase = agg_result.getBaseObject();
/* 180 */             long koff = agg_result.getBaseOffset();
/* 181 */             int klen = agg_result.getSizeInBytes();
/* 182 */
/* 183 */             UnsafeRow vRow
/* 184 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 185 */             if (vRow == null) {
/* 186 */               isBatchFull = true;
/* 187 */             } else {
/* 188 */               buckets[idx] = numRows++;
/* 189 */             }
/* 190 */             return vRow;
/* 191 */           } else {
/* 192 */             // No more space
/* 193 */             return null;
/* 194 */           }
/* 195 */         } else if (equals(idx, agg_key, agg_key1)) {
/* 196 */           return batch.getValueRow(buckets[idx]);
/* 197 */         }
/* 198 */         idx = (idx + 1) & (numBuckets - 1);
/* 199 */         step++;
/* 200 */       }
/* 201 */       // Didn't find it
/* 202 */       return null;
/* 203 */     }
/* 204 */
/* 205 */     private boolean equals(int idx, int agg_key, int agg_key1) {
/* 206 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 207 */       return (row.getInt(0) == agg_key) && (row.getInt(1) == agg_key1);
/* 208 */     }
/* 209 */
/* 210 */     private long hash(int agg_key, int agg_key1) {
/* 211 */       long agg_hash = 0;
/* 212 */
/* 213 */       int agg_result = agg_key;
/* 214 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 215 */
/* 216 */       int agg_result1 = agg_key1;
/* 217 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 218 */
/* 219 */       return agg_hash;
/* 220 */     }
/* 221 */
/* 222 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 223 */       return batch.rowIterator();
/* 224 */     }
/* 225 */
/* 226 */     public void close() {
/* 227 */       batch.close();
/* 228 */     }
/* 229 */
/* 230 */   }
/* 231 */
/* 232 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 233 */     agg_hashMap = agg_plan.createHashMap();
/* 234 */
/* 235 */     if (scan_batch == null) {
/* 236 */       scan_nextBatch();
/* 237 */     }
/* 238 */     while (scan_batch != null) {
/* 239 */       int scan_numRows = scan_batch.numRows();
/* 240 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 241 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 242 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 243 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 244 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 245 */
/* 246 */         if (!(!(scan_isNull))) continue;
/* 247 */
/* 248 */         filter_numOutputRows.add(1);
/* 249 */
/* 250 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 251 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 252 */
/* 253 */         // generate join key for stream side
/* 254 */
/* 255 */         boolean bhj_isNull = scan_isNull2;
/* 256 */         long bhj_value = -1L;
/* 257 */         if (!scan_isNull2) {
/* 258 */           bhj_value = (long) scan_value2;
/* 259 */         }
/* 260 */         // find matches from HashedRelation
/* 261 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 262 */         if (bhj_matched == null) continue;
/* 263 */
/* 264 */         bhj_numOutputRows.add(1);
/* 265 */
/* 266 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 267 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 268 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 269 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 270 */         boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 271 */         UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 272 */
/* 273 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 274 */
/* 275 */         UnsafeRow agg_fastAggBuffer = null;
/* 276 */
/* 277 */         if (true) {
/* 278 */           if (!bhj_isNull3 && !false) {
/* 279 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 280 */               bhj_value3, scan_value);
/* 281 */           }
/* 282 */         }
/* 283 */
/* 284 */         if (agg_fastAggBuffer == null) {
/* 285 */           // generate grouping key
/* 286 */           agg_rowWriter.zeroOutNullBytes();
/* 287 */
/* 288 */           if (bhj_isNull3) {
/* 289 */             agg_rowWriter.setNullAt(0);
/* 290 */           } else {
/* 291 */             agg_rowWriter.write(0, bhj_value3);
/* 292 */           }
/* 293 */
/* 294 */           agg_rowWriter.write(1, scan_value);
/* 295 */           agg_value18 = 42;
/* 296 */
/* 297 */           if (!bhj_isNull3) {
/* 298 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value3, agg_value18);
/* 299 */           }
/* 300 */
/* 301 */           if (!false) {
/* 302 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value, agg_value18);
/* 303 */           }
/* 304 */           if (true) {
/* 305 */             // try to get the buffer from hash map
/* 306 */             agg_unsafeRowAggBuffer =
/* 307 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value18);
/* 308 */           }
/* 309 */           if (agg_unsafeRowAggBuffer == null) {
/* 310 */             if (agg_sorter == null) {
/* 311 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 312 */             } else {
/* 313 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 314 */             }
/* 315 */
/* 316 */             // the hash map had be spilled, it should have enough memory now,
/* 317 */             // try  to allocate buffer again.
/* 318 */             agg_unsafeRowAggBuffer =
/* 319 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value18);
/* 320 */             if (agg_unsafeRowAggBuffer == null) {
/* 321 */               // failed to allocate the first page
/* 322 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 323 */             }
/* 324 */           }
/* 325 */         }
/* 326 */
/* 327 */         if (agg_fastAggBuffer != null) {
/* 328 */           // update fast row
/* 329 */
/* 330 */           // common sub-expressions
/* 331 */
/* 332 */           // evaluate aggregate function
/* 333 */           boolean agg_isNull106 = true;
/* 334 */           double agg_value113 = -1.0;
/* 335 */
/* 336 */           boolean agg_isNull108 = agg_fastAggBuffer.isNullAt(0);
/* 337 */           double agg_value115 = agg_isNull108 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 338 */           boolean agg_isNull107 = agg_isNull108;
/* 339 */           double agg_value114 = agg_value115;
/* 340 */           if (agg_isNull107) {
/* 341 */             boolean agg_isNull109 = false;
/* 342 */             double agg_value116 = -1.0;
/* 343 */             if (!false) {
/* 344 */               agg_value116 = (double) 0;
/* 345 */             }
/* 346 */             if (!agg_isNull109) {
/* 347 */               agg_isNull107 = false;
/* 348 */               agg_value114 = agg_value116;
/* 349 */             }
/* 350 */           }
/* 351 */
/* 352 */           boolean agg_isNull111 = true;
/* 353 */           double agg_value118 = -1.0;
/* 354 */
/* 355 */           boolean agg_isNull112 = true;
/* 356 */           boolean agg_value119 = false;
/* 357 */
/* 358 */           if (!bhj_isNull4) {
/* 359 */             agg_isNull112 = false; // resultCode could change nullability.
/* 360 */             agg_value119 = bhj_value4.equals(((UTF8String) references[24]));
/* 361 */
/* 362 */           }
/* 363 */           if (!agg_isNull112 && agg_value119) {
/* 364 */             agg_isNull111 = scan_isNull1;
/* 365 */             agg_value118 = scan_value1;
/* 366 */           }
/* 367 */
/* 368 */           else {
/* 369 */             final double agg_value123 = -1.0;
/* 370 */             agg_isNull111 = true;
/* 371 */             agg_value118 = agg_value123;
/* 372 */           }
/* 373 */           if (!agg_isNull111) {
/* 374 */             agg_isNull106 = false; // resultCode could change nullability.
/* 375 */             agg_value113 = agg_value114 + agg_value118;
/* 376 */
/* 377 */           }
/* 378 */           boolean agg_isNull105 = agg_isNull106;
/* 379 */           double agg_value112 = agg_value113;
/* 380 */           if (agg_isNull105) {
/* 381 */             boolean agg_isNull117 = agg_fastAggBuffer.isNullAt(0);
/* 382 */             double agg_value124 = agg_isNull117 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 383 */             if (!agg_isNull117) {
/* 384 */               agg_isNull105 = false;
/* 385 */               agg_value112 = agg_value124;
/* 386 */             }
/* 387 */           }
/* 388 */           boolean agg_isNull119 = true;
/* 389 */           double agg_value126 = -1.0;
/* 390 */
/* 391 */           boolean agg_isNull121 = agg_fastAggBuffer.isNullAt(1);
/* 392 */           double agg_value128 = agg_isNull121 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 393 */           boolean agg_isNull120 = agg_isNull121;
/* 394 */           double agg_value127 = agg_value128;
/* 395 */           if (agg_isNull120) {
/* 396 */             boolean agg_isNull122 = false;
/* 397 */             double agg_value129 = -1.0;
/* 398 */             if (!false) {
/* 399 */               agg_value129 = (double) 0;
/* 400 */             }
/* 401 */             if (!agg_isNull122) {
/* 402 */               agg_isNull120 = false;
/* 403 */               agg_value127 = agg_value129;
/* 404 */             }
/* 405 */           }
/* 406 */
/* 407 */           boolean agg_isNull124 = true;
/* 408 */           double agg_value131 = -1.0;
/* 409 */
/* 410 */           boolean agg_isNull125 = true;
/* 411 */           boolean agg_value132 = false;
/* 412 */
/* 413 */           if (!bhj_isNull4) {
/* 414 */             agg_isNull125 = false; // resultCode could change nullability.
/* 415 */             agg_value132 = bhj_value4.equals(((UTF8String) references[25]));
/* 416 */
/* 417 */           }
/* 418 */           if (!agg_isNull125 && agg_value132) {
/* 419 */             agg_isNull124 = scan_isNull1;
/* 420 */             agg_value131 = scan_value1;
/* 421 */           }
/* 422 */
/* 423 */           else {
/* 424 */             final double agg_value136 = -1.0;
/* 425 */             agg_isNull124 = true;
/* 426 */             agg_value131 = agg_value136;
/* 427 */           }
/* 428 */           if (!agg_isNull124) {
/* 429 */             agg_isNull119 = false; // resultCode could change nullability.
/* 430 */             agg_value126 = agg_value127 + agg_value131;
/* 431 */
/* 432 */           }
/* 433 */           boolean agg_isNull118 = agg_isNull119;
/* 434 */           double agg_value125 = agg_value126;
/* 435 */           if (agg_isNull118) {
/* 436 */             boolean agg_isNull130 = agg_fastAggBuffer.isNullAt(1);
/* 437 */             double agg_value137 = agg_isNull130 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 438 */             if (!agg_isNull130) {
/* 439 */               agg_isNull118 = false;
/* 440 */               agg_value125 = agg_value137;
/* 441 */             }
/* 442 */           }
/* 443 */           boolean agg_isNull132 = true;
/* 444 */           double agg_value139 = -1.0;
/* 445 */
/* 446 */           boolean agg_isNull134 = agg_fastAggBuffer.isNullAt(2);
/* 447 */           double agg_value141 = agg_isNull134 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 448 */           boolean agg_isNull133 = agg_isNull134;
/* 449 */           double agg_value140 = agg_value141;
/* 450 */           if (agg_isNull133) {
/* 451 */             boolean agg_isNull135 = false;
/* 452 */             double agg_value142 = -1.0;
/* 453 */             if (!false) {
/* 454 */               agg_value142 = (double) 0;
/* 455 */             }
/* 456 */             if (!agg_isNull135) {
/* 457 */               agg_isNull133 = false;
/* 458 */               agg_value140 = agg_value142;
/* 459 */             }
/* 460 */           }
/* 461 */
/* 462 */           boolean agg_isNull137 = true;
/* 463 */           double agg_value144 = -1.0;
/* 464 */
/* 465 */           boolean agg_isNull138 = true;
/* 466 */           boolean agg_value145 = false;
/* 467 */
/* 468 */           if (!bhj_isNull4) {
/* 469 */             agg_isNull138 = false; // resultCode could change nullability.
/* 470 */             agg_value145 = bhj_value4.equals(((UTF8String) references[26]));
/* 471 */
/* 472 */           }
/* 473 */           if (!agg_isNull138 && agg_value145) {
/* 474 */             agg_isNull137 = scan_isNull1;
/* 475 */             agg_value144 = scan_value1;
/* 476 */           }
/* 477 */
/* 478 */           else {
/* 479 */             final double agg_value149 = -1.0;
/* 480 */             agg_isNull137 = true;
/* 481 */             agg_value144 = agg_value149;
/* 482 */           }
/* 483 */           if (!agg_isNull137) {
/* 484 */             agg_isNull132 = false; // resultCode could change nullability.
/* 485 */             agg_value139 = agg_value140 + agg_value144;
/* 486 */
/* 487 */           }
/* 488 */           boolean agg_isNull131 = agg_isNull132;
/* 489 */           double agg_value138 = agg_value139;
/* 490 */           if (agg_isNull131) {
/* 491 */             boolean agg_isNull143 = agg_fastAggBuffer.isNullAt(2);
/* 492 */             double agg_value150 = agg_isNull143 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 493 */             if (!agg_isNull143) {
/* 494 */               agg_isNull131 = false;
/* 495 */               agg_value138 = agg_value150;
/* 496 */             }
/* 497 */           }
/* 498 */           boolean agg_isNull145 = true;
/* 499 */           double agg_value152 = -1.0;
/* 500 */
/* 501 */           boolean agg_isNull147 = agg_fastAggBuffer.isNullAt(3);
/* 502 */           double agg_value154 = agg_isNull147 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 503 */           boolean agg_isNull146 = agg_isNull147;
/* 504 */           double agg_value153 = agg_value154;
/* 505 */           if (agg_isNull146) {
/* 506 */             boolean agg_isNull148 = false;
/* 507 */             double agg_value155 = -1.0;
/* 508 */             if (!false) {
/* 509 */               agg_value155 = (double) 0;
/* 510 */             }
/* 511 */             if (!agg_isNull148) {
/* 512 */               agg_isNull146 = false;
/* 513 */               agg_value153 = agg_value155;
/* 514 */             }
/* 515 */           }
/* 516 */
/* 517 */           boolean agg_isNull150 = true;
/* 518 */           double agg_value157 = -1.0;
/* 519 */
/* 520 */           boolean agg_isNull151 = true;
/* 521 */           boolean agg_value158 = false;
/* 522 */
/* 523 */           if (!bhj_isNull4) {
/* 524 */             agg_isNull151 = false; // resultCode could change nullability.
/* 525 */             agg_value158 = bhj_value4.equals(((UTF8String) references[27]));
/* 526 */
/* 527 */           }
/* 528 */           if (!agg_isNull151 && agg_value158) {
/* 529 */             agg_isNull150 = scan_isNull1;
/* 530 */             agg_value157 = scan_value1;
/* 531 */           }
/* 532 */
/* 533 */           else {
/* 534 */             final double agg_value162 = -1.0;
/* 535 */             agg_isNull150 = true;
/* 536 */             agg_value157 = agg_value162;
/* 537 */           }
/* 538 */           if (!agg_isNull150) {
/* 539 */             agg_isNull145 = false; // resultCode could change nullability.
/* 540 */             agg_value152 = agg_value153 + agg_value157;
/* 541 */
/* 542 */           }
/* 543 */           boolean agg_isNull144 = agg_isNull145;
/* 544 */           double agg_value151 = agg_value152;
/* 545 */           if (agg_isNull144) {
/* 546 */             boolean agg_isNull156 = agg_fastAggBuffer.isNullAt(3);
/* 547 */             double agg_value163 = agg_isNull156 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 548 */             if (!agg_isNull156) {
/* 549 */               agg_isNull144 = false;
/* 550 */               agg_value151 = agg_value163;
/* 551 */             }
/* 552 */           }
/* 553 */           boolean agg_isNull158 = true;
/* 554 */           double agg_value165 = -1.0;
/* 555 */
/* 556 */           boolean agg_isNull160 = agg_fastAggBuffer.isNullAt(4);
/* 557 */           double agg_value167 = agg_isNull160 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 558 */           boolean agg_isNull159 = agg_isNull160;
/* 559 */           double agg_value166 = agg_value167;
/* 560 */           if (agg_isNull159) {
/* 561 */             boolean agg_isNull161 = false;
/* 562 */             double agg_value168 = -1.0;
/* 563 */             if (!false) {
/* 564 */               agg_value168 = (double) 0;
/* 565 */             }
/* 566 */             if (!agg_isNull161) {
/* 567 */               agg_isNull159 = false;
/* 568 */               agg_value166 = agg_value168;
/* 569 */             }
/* 570 */           }
/* 571 */
/* 572 */           boolean agg_isNull163 = true;
/* 573 */           double agg_value170 = -1.0;
/* 574 */
/* 575 */           boolean agg_isNull164 = true;
/* 576 */           boolean agg_value171 = false;
/* 577 */
/* 578 */           if (!bhj_isNull4) {
/* 579 */             agg_isNull164 = false; // resultCode could change nullability.
/* 580 */             agg_value171 = bhj_value4.equals(((UTF8String) references[28]));
/* 581 */
/* 582 */           }
/* 583 */           if (!agg_isNull164 && agg_value171) {
/* 584 */             agg_isNull163 = scan_isNull1;
/* 585 */             agg_value170 = scan_value1;
/* 586 */           }
/* 587 */
/* 588 */           else {
/* 589 */             final double agg_value175 = -1.0;
/* 590 */             agg_isNull163 = true;
/* 591 */             agg_value170 = agg_value175;
/* 592 */           }
/* 593 */           if (!agg_isNull163) {
/* 594 */             agg_isNull158 = false; // resultCode could change nullability.
/* 595 */             agg_value165 = agg_value166 + agg_value170;
/* 596 */
/* 597 */           }
/* 598 */           boolean agg_isNull157 = agg_isNull158;
/* 599 */           double agg_value164 = agg_value165;
/* 600 */           if (agg_isNull157) {
/* 601 */             boolean agg_isNull169 = agg_fastAggBuffer.isNullAt(4);
/* 602 */             double agg_value176 = agg_isNull169 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 603 */             if (!agg_isNull169) {
/* 604 */               agg_isNull157 = false;
/* 605 */               agg_value164 = agg_value176;
/* 606 */             }
/* 607 */           }
/* 608 */           boolean agg_isNull171 = true;
/* 609 */           double agg_value178 = -1.0;
/* 610 */
/* 611 */           boolean agg_isNull173 = agg_fastAggBuffer.isNullAt(5);
/* 612 */           double agg_value180 = agg_isNull173 ? -1.0 : (agg_fastAggBuffer.getDouble(5));
/* 613 */           boolean agg_isNull172 = agg_isNull173;
/* 614 */           double agg_value179 = agg_value180;
/* 615 */           if (agg_isNull172) {
/* 616 */             boolean agg_isNull174 = false;
/* 617 */             double agg_value181 = -1.0;
/* 618 */             if (!false) {
/* 619 */               agg_value181 = (double) 0;
/* 620 */             }
/* 621 */             if (!agg_isNull174) {
/* 622 */               agg_isNull172 = false;
/* 623 */               agg_value179 = agg_value181;
/* 624 */             }
/* 625 */           }
/* 626 */
/* 627 */           boolean agg_isNull176 = true;
/* 628 */           double agg_value183 = -1.0;
/* 629 */
/* 630 */           boolean agg_isNull177 = true;
/* 631 */           boolean agg_value184 = false;
/* 632 */
/* 633 */           if (!bhj_isNull4) {
/* 634 */             agg_isNull177 = false; // resultCode could change nullability.
/* 635 */             agg_value184 = bhj_value4.equals(((UTF8String) references[29]));
/* 636 */
/* 637 */           }
/* 638 */           if (!agg_isNull177 && agg_value184) {
/* 639 */             agg_isNull176 = scan_isNull1;
/* 640 */             agg_value183 = scan_value1;
/* 641 */           }
/* 642 */
/* 643 */           else {
/* 644 */             final double agg_value188 = -1.0;
/* 645 */             agg_isNull176 = true;
/* 646 */             agg_value183 = agg_value188;
/* 647 */           }
/* 648 */           if (!agg_isNull176) {
/* 649 */             agg_isNull171 = false; // resultCode could change nullability.
/* 650 */             agg_value178 = agg_value179 + agg_value183;
/* 651 */
/* 652 */           }
/* 653 */           boolean agg_isNull170 = agg_isNull171;
/* 654 */           double agg_value177 = agg_value178;
/* 655 */           if (agg_isNull170) {
/* 656 */             boolean agg_isNull182 = agg_fastAggBuffer.isNullAt(5);
/* 657 */             double agg_value189 = agg_isNull182 ? -1.0 : (agg_fastAggBuffer.getDouble(5));
/* 658 */             if (!agg_isNull182) {
/* 659 */               agg_isNull170 = false;
/* 660 */               agg_value177 = agg_value189;
/* 661 */             }
/* 662 */           }
/* 663 */           boolean agg_isNull184 = true;
/* 664 */           double agg_value191 = -1.0;
/* 665 */
/* 666 */           boolean agg_isNull186 = agg_fastAggBuffer.isNullAt(6);
/* 667 */           double agg_value193 = agg_isNull186 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 668 */           boolean agg_isNull185 = agg_isNull186;
/* 669 */           double agg_value192 = agg_value193;
/* 670 */           if (agg_isNull185) {
/* 671 */             boolean agg_isNull187 = false;
/* 672 */             double agg_value194 = -1.0;
/* 673 */             if (!false) {
/* 674 */               agg_value194 = (double) 0;
/* 675 */             }
/* 676 */             if (!agg_isNull187) {
/* 677 */               agg_isNull185 = false;
/* 678 */               agg_value192 = agg_value194;
/* 679 */             }
/* 680 */           }
/* 681 */
/* 682 */           boolean agg_isNull189 = true;
/* 683 */           double agg_value196 = -1.0;
/* 684 */
/* 685 */           boolean agg_isNull190 = true;
/* 686 */           boolean agg_value197 = false;
/* 687 */
/* 688 */           if (!bhj_isNull4) {
/* 689 */             agg_isNull190 = false; // resultCode could change nullability.
/* 690 */             agg_value197 = bhj_value4.equals(((UTF8String) references[30]));
/* 691 */
/* 692 */           }
/* 693 */           if (!agg_isNull190 && agg_value197) {
/* 694 */             agg_isNull189 = scan_isNull1;
/* 695 */             agg_value196 = scan_value1;
/* 696 */           }
/* 697 */
/* 698 */           else {
/* 699 */             final double agg_value201 = -1.0;
/* 700 */             agg_isNull189 = true;
/* 701 */             agg_value196 = agg_value201;
/* 702 */           }
/* 703 */           if (!agg_isNull189) {
/* 704 */             agg_isNull184 = false; // resultCode could change nullability.
/* 705 */             agg_value191 = agg_value192 + agg_value196;
/* 706 */
/* 707 */           }
/* 708 */           boolean agg_isNull183 = agg_isNull184;
/* 709 */           double agg_value190 = agg_value191;
/* 710 */           if (agg_isNull183) {
/* 711 */             boolean agg_isNull195 = agg_fastAggBuffer.isNullAt(6);
/* 712 */             double agg_value202 = agg_isNull195 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 713 */             if (!agg_isNull195) {
/* 714 */               agg_isNull183 = false;
/* 715 */               agg_value190 = agg_value202;
/* 716 */             }
/* 717 */           }
/* 718 */           // update fast row
/* 719 */           if (!agg_isNull105) {
/* 720 */             agg_fastAggBuffer.setDouble(0, agg_value112);
/* 721 */           } else {
/* 722 */             agg_fastAggBuffer.setNullAt(0);
/* 723 */           }
/* 724 */
/* 725 */           if (!agg_isNull118) {
/* 726 */             agg_fastAggBuffer.setDouble(1, agg_value125);
/* 727 */           } else {
/* 728 */             agg_fastAggBuffer.setNullAt(1);
/* 729 */           }
/* 730 */
/* 731 */           if (!agg_isNull131) {
/* 732 */             agg_fastAggBuffer.setDouble(2, agg_value138);
/* 733 */           } else {
/* 734 */             agg_fastAggBuffer.setNullAt(2);
/* 735 */           }
/* 736 */
/* 737 */           if (!agg_isNull144) {
/* 738 */             agg_fastAggBuffer.setDouble(3, agg_value151);
/* 739 */           } else {
/* 740 */             agg_fastAggBuffer.setNullAt(3);
/* 741 */           }
/* 742 */
/* 743 */           if (!agg_isNull157) {
/* 744 */             agg_fastAggBuffer.setDouble(4, agg_value164);
/* 745 */           } else {
/* 746 */             agg_fastAggBuffer.setNullAt(4);
/* 747 */           }
/* 748 */
/* 749 */           if (!agg_isNull170) {
/* 750 */             agg_fastAggBuffer.setDouble(5, agg_value177);
/* 751 */           } else {
/* 752 */             agg_fastAggBuffer.setNullAt(5);
/* 753 */           }
/* 754 */
/* 755 */           if (!agg_isNull183) {
/* 756 */             agg_fastAggBuffer.setDouble(6, agg_value190);
/* 757 */           } else {
/* 758 */             agg_fastAggBuffer.setNullAt(6);
/* 759 */           }
/* 760 */
/* 761 */         } else {
/* 762 */           // update unsafe row
/* 763 */
/* 764 */           // common sub-expressions
/* 765 */
/* 766 */           // evaluate aggregate function
/* 767 */           boolean agg_isNull15 = true;
/* 768 */           double agg_value22 = -1.0;
/* 769 */
/* 770 */           boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 771 */           double agg_value24 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 772 */           boolean agg_isNull16 = agg_isNull17;
/* 773 */           double agg_value23 = agg_value24;
/* 774 */           if (agg_isNull16) {
/* 775 */             boolean agg_isNull18 = false;
/* 776 */             double agg_value25 = -1.0;
/* 777 */             if (!false) {
/* 778 */               agg_value25 = (double) 0;
/* 779 */             }
/* 780 */             if (!agg_isNull18) {
/* 781 */               agg_isNull16 = false;
/* 782 */               agg_value23 = agg_value25;
/* 783 */             }
/* 784 */           }
/* 785 */
/* 786 */           boolean agg_isNull20 = true;
/* 787 */           double agg_value27 = -1.0;
/* 788 */
/* 789 */           boolean agg_isNull21 = true;
/* 790 */           boolean agg_value28 = false;
/* 791 */
/* 792 */           if (!bhj_isNull4) {
/* 793 */             agg_isNull21 = false; // resultCode could change nullability.
/* 794 */             agg_value28 = bhj_value4.equals(((UTF8String) references[17]));
/* 795 */
/* 796 */           }
/* 797 */           if (!agg_isNull21 && agg_value28) {
/* 798 */             agg_isNull20 = scan_isNull1;
/* 799 */             agg_value27 = scan_value1;
/* 800 */           }
/* 801 */
/* 802 */           else {
/* 803 */             final double agg_value32 = -1.0;
/* 804 */             agg_isNull20 = true;
/* 805 */             agg_value27 = agg_value32;
/* 806 */           }
/* 807 */           if (!agg_isNull20) {
/* 808 */             agg_isNull15 = false; // resultCode could change nullability.
/* 809 */             agg_value22 = agg_value23 + agg_value27;
/* 810 */
/* 811 */           }
/* 812 */           boolean agg_isNull14 = agg_isNull15;
/* 813 */           double agg_value21 = agg_value22;
/* 814 */           if (agg_isNull14) {
/* 815 */             boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 816 */             double agg_value33 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 817 */             if (!agg_isNull26) {
/* 818 */               agg_isNull14 = false;
/* 819 */               agg_value21 = agg_value33;
/* 820 */             }
/* 821 */           }
/* 822 */           boolean agg_isNull28 = true;
/* 823 */           double agg_value35 = -1.0;
/* 824 */
/* 825 */           boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 826 */           double agg_value37 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 827 */           boolean agg_isNull29 = agg_isNull30;
/* 828 */           double agg_value36 = agg_value37;
/* 829 */           if (agg_isNull29) {
/* 830 */             boolean agg_isNull31 = false;
/* 831 */             double agg_value38 = -1.0;
/* 832 */             if (!false) {
/* 833 */               agg_value38 = (double) 0;
/* 834 */             }
/* 835 */             if (!agg_isNull31) {
/* 836 */               agg_isNull29 = false;
/* 837 */               agg_value36 = agg_value38;
/* 838 */             }
/* 839 */           }
/* 840 */
/* 841 */           boolean agg_isNull33 = true;
/* 842 */           double agg_value40 = -1.0;
/* 843 */
/* 844 */           boolean agg_isNull34 = true;
/* 845 */           boolean agg_value41 = false;
/* 846 */
/* 847 */           if (!bhj_isNull4) {
/* 848 */             agg_isNull34 = false; // resultCode could change nullability.
/* 849 */             agg_value41 = bhj_value4.equals(((UTF8String) references[18]));
/* 850 */
/* 851 */           }
/* 852 */           if (!agg_isNull34 && agg_value41) {
/* 853 */             agg_isNull33 = scan_isNull1;
/* 854 */             agg_value40 = scan_value1;
/* 855 */           }
/* 856 */
/* 857 */           else {
/* 858 */             final double agg_value45 = -1.0;
/* 859 */             agg_isNull33 = true;
/* 860 */             agg_value40 = agg_value45;
/* 861 */           }
/* 862 */           if (!agg_isNull33) {
/* 863 */             agg_isNull28 = false; // resultCode could change nullability.
/* 864 */             agg_value35 = agg_value36 + agg_value40;
/* 865 */
/* 866 */           }
/* 867 */           boolean agg_isNull27 = agg_isNull28;
/* 868 */           double agg_value34 = agg_value35;
/* 869 */           if (agg_isNull27) {
/* 870 */             boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 871 */             double agg_value46 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 872 */             if (!agg_isNull39) {
/* 873 */               agg_isNull27 = false;
/* 874 */               agg_value34 = agg_value46;
/* 875 */             }
/* 876 */           }
/* 877 */           boolean agg_isNull41 = true;
/* 878 */           double agg_value48 = -1.0;
/* 879 */
/* 880 */           boolean agg_isNull43 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 881 */           double agg_value50 = agg_isNull43 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 882 */           boolean agg_isNull42 = agg_isNull43;
/* 883 */           double agg_value49 = agg_value50;
/* 884 */           if (agg_isNull42) {
/* 885 */             boolean agg_isNull44 = false;
/* 886 */             double agg_value51 = -1.0;
/* 887 */             if (!false) {
/* 888 */               agg_value51 = (double) 0;
/* 889 */             }
/* 890 */             if (!agg_isNull44) {
/* 891 */               agg_isNull42 = false;
/* 892 */               agg_value49 = agg_value51;
/* 893 */             }
/* 894 */           }
/* 895 */
/* 896 */           boolean agg_isNull46 = true;
/* 897 */           double agg_value53 = -1.0;
/* 898 */
/* 899 */           boolean agg_isNull47 = true;
/* 900 */           boolean agg_value54 = false;
/* 901 */
/* 902 */           if (!bhj_isNull4) {
/* 903 */             agg_isNull47 = false; // resultCode could change nullability.
/* 904 */             agg_value54 = bhj_value4.equals(((UTF8String) references[19]));
/* 905 */
/* 906 */           }
/* 907 */           if (!agg_isNull47 && agg_value54) {
/* 908 */             agg_isNull46 = scan_isNull1;
/* 909 */             agg_value53 = scan_value1;
/* 910 */           }
/* 911 */
/* 912 */           else {
/* 913 */             final double agg_value58 = -1.0;
/* 914 */             agg_isNull46 = true;
/* 915 */             agg_value53 = agg_value58;
/* 916 */           }
/* 917 */           if (!agg_isNull46) {
/* 918 */             agg_isNull41 = false; // resultCode could change nullability.
/* 919 */             agg_value48 = agg_value49 + agg_value53;
/* 920 */
/* 921 */           }
/* 922 */           boolean agg_isNull40 = agg_isNull41;
/* 923 */           double agg_value47 = agg_value48;
/* 924 */           if (agg_isNull40) {
/* 925 */             boolean agg_isNull52 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 926 */             double agg_value59 = agg_isNull52 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 927 */             if (!agg_isNull52) {
/* 928 */               agg_isNull40 = false;
/* 929 */               agg_value47 = agg_value59;
/* 930 */             }
/* 931 */           }
/* 932 */           boolean agg_isNull54 = true;
/* 933 */           double agg_value61 = -1.0;
/* 934 */
/* 935 */           boolean agg_isNull56 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 936 */           double agg_value63 = agg_isNull56 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 937 */           boolean agg_isNull55 = agg_isNull56;
/* 938 */           double agg_value62 = agg_value63;
/* 939 */           if (agg_isNull55) {
/* 940 */             boolean agg_isNull57 = false;
/* 941 */             double agg_value64 = -1.0;
/* 942 */             if (!false) {
/* 943 */               agg_value64 = (double) 0;
/* 944 */             }
/* 945 */             if (!agg_isNull57) {
/* 946 */               agg_isNull55 = false;
/* 947 */               agg_value62 = agg_value64;
/* 948 */             }
/* 949 */           }
/* 950 */
/* 951 */           boolean agg_isNull59 = true;
/* 952 */           double agg_value66 = -1.0;
/* 953 */
/* 954 */           boolean agg_isNull60 = true;
/* 955 */           boolean agg_value67 = false;
/* 956 */
/* 957 */           if (!bhj_isNull4) {
/* 958 */             agg_isNull60 = false; // resultCode could change nullability.
/* 959 */             agg_value67 = bhj_value4.equals(((UTF8String) references[20]));
/* 960 */
/* 961 */           }
/* 962 */           if (!agg_isNull60 && agg_value67) {
/* 963 */             agg_isNull59 = scan_isNull1;
/* 964 */             agg_value66 = scan_value1;
/* 965 */           }
/* 966 */
/* 967 */           else {
/* 968 */             final double agg_value71 = -1.0;
/* 969 */             agg_isNull59 = true;
/* 970 */             agg_value66 = agg_value71;
/* 971 */           }
/* 972 */           if (!agg_isNull59) {
/* 973 */             agg_isNull54 = false; // resultCode could change nullability.
/* 974 */             agg_value61 = agg_value62 + agg_value66;
/* 975 */
/* 976 */           }
/* 977 */           boolean agg_isNull53 = agg_isNull54;
/* 978 */           double agg_value60 = agg_value61;
/* 979 */           if (agg_isNull53) {
/* 980 */             boolean agg_isNull65 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 981 */             double agg_value72 = agg_isNull65 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 982 */             if (!agg_isNull65) {
/* 983 */               agg_isNull53 = false;
/* 984 */               agg_value60 = agg_value72;
/* 985 */             }
/* 986 */           }
/* 987 */           boolean agg_isNull67 = true;
/* 988 */           double agg_value74 = -1.0;
/* 989 */
/* 990 */           boolean agg_isNull69 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 991 */           double agg_value76 = agg_isNull69 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 992 */           boolean agg_isNull68 = agg_isNull69;
/* 993 */           double agg_value75 = agg_value76;
/* 994 */           if (agg_isNull68) {
/* 995 */             boolean agg_isNull70 = false;
/* 996 */             double agg_value77 = -1.0;
/* 997 */             if (!false) {
/* 998 */               agg_value77 = (double) 0;
/* 999 */             }
/* 1000 */             if (!agg_isNull70) {
/* 1001 */               agg_isNull68 = false;
/* 1002 */               agg_value75 = agg_value77;
/* 1003 */             }
/* 1004 */           }
/* 1005 */
/* 1006 */           boolean agg_isNull72 = true;
/* 1007 */           double agg_value79 = -1.0;
/* 1008 */
/* 1009 */           boolean agg_isNull73 = true;
/* 1010 */           boolean agg_value80 = false;
/* 1011 */
/* 1012 */           if (!bhj_isNull4) {
/* 1013 */             agg_isNull73 = false; // resultCode could change nullability.
/* 1014 */             agg_value80 = bhj_value4.equals(((UTF8String) references[21]));
/* 1015 */
/* 1016 */           }
/* 1017 */           if (!agg_isNull73 && agg_value80) {
/* 1018 */             agg_isNull72 = scan_isNull1;
/* 1019 */             agg_value79 = scan_value1;
/* 1020 */           }
/* 1021 */
/* 1022 */           else {
/* 1023 */             final double agg_value84 = -1.0;
/* 1024 */             agg_isNull72 = true;
/* 1025 */             agg_value79 = agg_value84;
/* 1026 */           }
/* 1027 */           if (!agg_isNull72) {
/* 1028 */             agg_isNull67 = false; // resultCode could change nullability.
/* 1029 */             agg_value74 = agg_value75 + agg_value79;
/* 1030 */
/* 1031 */           }
/* 1032 */           boolean agg_isNull66 = agg_isNull67;
/* 1033 */           double agg_value73 = agg_value74;
/* 1034 */           if (agg_isNull66) {
/* 1035 */             boolean agg_isNull78 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 1036 */             double agg_value85 = agg_isNull78 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 1037 */             if (!agg_isNull78) {
/* 1038 */               agg_isNull66 = false;
/* 1039 */               agg_value73 = agg_value85;
/* 1040 */             }
/* 1041 */           }
/* 1042 */           boolean agg_isNull80 = true;
/* 1043 */           double agg_value87 = -1.0;
/* 1044 */
/* 1045 */           boolean agg_isNull82 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 1046 */           double agg_value89 = agg_isNull82 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 1047 */           boolean agg_isNull81 = agg_isNull82;
/* 1048 */           double agg_value88 = agg_value89;
/* 1049 */           if (agg_isNull81) {
/* 1050 */             boolean agg_isNull83 = false;
/* 1051 */             double agg_value90 = -1.0;
/* 1052 */             if (!false) {
/* 1053 */               agg_value90 = (double) 0;
/* 1054 */             }
/* 1055 */             if (!agg_isNull83) {
/* 1056 */               agg_isNull81 = false;
/* 1057 */               agg_value88 = agg_value90;
/* 1058 */             }
/* 1059 */           }
/* 1060 */
/* 1061 */           boolean agg_isNull85 = true;
/* 1062 */           double agg_value92 = -1.0;
/* 1063 */
/* 1064 */           boolean agg_isNull86 = true;
/* 1065 */           boolean agg_value93 = false;
/* 1066 */
/* 1067 */           if (!bhj_isNull4) {
/* 1068 */             agg_isNull86 = false; // resultCode could change nullability.
/* 1069 */             agg_value93 = bhj_value4.equals(((UTF8String) references[22]));
/* 1070 */
/* 1071 */           }
/* 1072 */           if (!agg_isNull86 && agg_value93) {
/* 1073 */             agg_isNull85 = scan_isNull1;
/* 1074 */             agg_value92 = scan_value1;
/* 1075 */           }
/* 1076 */
/* 1077 */           else {
/* 1078 */             final double agg_value97 = -1.0;
/* 1079 */             agg_isNull85 = true;
/* 1080 */             agg_value92 = agg_value97;
/* 1081 */           }
/* 1082 */           if (!agg_isNull85) {
/* 1083 */             agg_isNull80 = false; // resultCode could change nullability.
/* 1084 */             agg_value87 = agg_value88 + agg_value92;
/* 1085 */
/* 1086 */           }
/* 1087 */           boolean agg_isNull79 = agg_isNull80;
/* 1088 */           double agg_value86 = agg_value87;
/* 1089 */           if (agg_isNull79) {
/* 1090 */             boolean agg_isNull91 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 1091 */             double agg_value98 = agg_isNull91 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 1092 */             if (!agg_isNull91) {
/* 1093 */               agg_isNull79 = false;
/* 1094 */               agg_value86 = agg_value98;
/* 1095 */             }
/* 1096 */           }
/* 1097 */           boolean agg_isNull93 = true;
/* 1098 */           double agg_value100 = -1.0;
/* 1099 */
/* 1100 */           boolean agg_isNull95 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 1101 */           double agg_value102 = agg_isNull95 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 1102 */           boolean agg_isNull94 = agg_isNull95;
/* 1103 */           double agg_value101 = agg_value102;
/* 1104 */           if (agg_isNull94) {
/* 1105 */             boolean agg_isNull96 = false;
/* 1106 */             double agg_value103 = -1.0;
/* 1107 */             if (!false) {
/* 1108 */               agg_value103 = (double) 0;
/* 1109 */             }
/* 1110 */             if (!agg_isNull96) {
/* 1111 */               agg_isNull94 = false;
/* 1112 */               agg_value101 = agg_value103;
/* 1113 */             }
/* 1114 */           }
/* 1115 */
/* 1116 */           boolean agg_isNull98 = true;
/* 1117 */           double agg_value105 = -1.0;
/* 1118 */
/* 1119 */           boolean agg_isNull99 = true;
/* 1120 */           boolean agg_value106 = false;
/* 1121 */
/* 1122 */           if (!bhj_isNull4) {
/* 1123 */             agg_isNull99 = false; // resultCode could change nullability.
/* 1124 */             agg_value106 = bhj_value4.equals(((UTF8String) references[23]));
/* 1125 */
/* 1126 */           }
/* 1127 */           if (!agg_isNull99 && agg_value106) {
/* 1128 */             agg_isNull98 = scan_isNull1;
/* 1129 */             agg_value105 = scan_value1;
/* 1130 */           }
/* 1131 */
/* 1132 */           else {
/* 1133 */             final double agg_value110 = -1.0;
/* 1134 */             agg_isNull98 = true;
/* 1135 */             agg_value105 = agg_value110;
/* 1136 */           }
/* 1137 */           if (!agg_isNull98) {
/* 1138 */             agg_isNull93 = false; // resultCode could change nullability.
/* 1139 */             agg_value100 = agg_value101 + agg_value105;
/* 1140 */
/* 1141 */           }
/* 1142 */           boolean agg_isNull92 = agg_isNull93;
/* 1143 */           double agg_value99 = agg_value100;
/* 1144 */           if (agg_isNull92) {
/* 1145 */             boolean agg_isNull104 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 1146 */             double agg_value111 = agg_isNull104 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 1147 */             if (!agg_isNull104) {
/* 1148 */               agg_isNull92 = false;
/* 1149 */               agg_value99 = agg_value111;
/* 1150 */             }
/* 1151 */           }
/* 1152 */           // update unsafe row buffer
/* 1153 */           if (!agg_isNull14) {
/* 1154 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value21);
/* 1155 */           } else {
/* 1156 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 1157 */           }
/* 1158 */
/* 1159 */           if (!agg_isNull27) {
/* 1160 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value34);
/* 1161 */           } else {
/* 1162 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 1163 */           }
/* 1164 */
/* 1165 */           if (!agg_isNull40) {
/* 1166 */             agg_unsafeRowAggBuffer.setDouble(2, agg_value47);
/* 1167 */           } else {
/* 1168 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 1169 */           }
/* 1170 */
/* 1171 */           if (!agg_isNull53) {
/* 1172 */             agg_unsafeRowAggBuffer.setDouble(3, agg_value60);
/* 1173 */           } else {
/* 1174 */             agg_unsafeRowAggBuffer.setNullAt(3);
/* 1175 */           }
/* 1176 */
/* 1177 */           if (!agg_isNull66) {
/* 1178 */             agg_unsafeRowAggBuffer.setDouble(4, agg_value73);
/* 1179 */           } else {
/* 1180 */             agg_unsafeRowAggBuffer.setNullAt(4);
/* 1181 */           }
/* 1182 */
/* 1183 */           if (!agg_isNull79) {
/* 1184 */             agg_unsafeRowAggBuffer.setDouble(5, agg_value86);
/* 1185 */           } else {
/* 1186 */             agg_unsafeRowAggBuffer.setNullAt(5);
/* 1187 */           }
/* 1188 */
/* 1189 */           if (!agg_isNull92) {
/* 1190 */             agg_unsafeRowAggBuffer.setDouble(6, agg_value99);
/* 1191 */           } else {
/* 1192 */             agg_unsafeRowAggBuffer.setNullAt(6);
/* 1193 */           }
/* 1194 */
/* 1195 */         }
/* 1196 */         // shouldStop check is eliminated
/* 1197 */       }
/* 1198 */       scan_batchIdx = scan_numRows;
/* 1199 */       scan_batch = null;
/* 1200 */       scan_nextBatch();
/* 1201 */     }
/* 1202 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 1203 */     scan_scanTime1 = 0;
/* 1204 */
/* 1205 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 1206 */
/* 1207 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1208 */   }
/* 1209 */
/* 1210 */   private void wholestagecodegen_init_2() {
/* 1211 */     project_result1 = new UnsafeRow(4);
/* 1212 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 1213 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 1214 */     agg_result2 = new UnsafeRow(2);
/* 1215 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 1216 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 1217 */
/* 1218 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 1219 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[31];
/* 1220 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[32];
/* 1221 */
/* 1222 */   }
/* 1223 */
/* 1224 */   private void wholestagecodegen_init_1() {
/* 1225 */     filter_result = new UnsafeRow(3);
/* 1226 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 1227 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 1228 */     project_result = new UnsafeRow(3);
/* 1229 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 1230 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 1231 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 1232 */
/* 1233 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1234 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1235 */
/* 1236 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 1237 */     bhj_result = new UnsafeRow(6);
/* 1238 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 1239 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 1240 */
/* 1241 */   }
/* 1242 */
/* 1243 */   protected void processNext() throws java.io.IOException {
/* 1244 */     if (!agg_initAgg) {
/* 1245 */       agg_initAgg = true;
/* 1246 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1247 */       agg_doAggregateWithKeys();
/* 1248 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1249 */     }
/* 1250 */
/* 1251 */     // output the result
/* 1252 */
/* 1253 */     while (agg_fastHashMapIter.next()) {
/* 1254 */       wholestagecodegen_numOutputRows.add(1);
/* 1255 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1256 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1257 */
/* 1258 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1259 */
/* 1260 */       append(agg_resultRow);
/* 1261 */
/* 1262 */       if (shouldStop()) return;
/* 1263 */     }
/* 1264 */     agg_fastHashMap.close();
/* 1265 */
/* 1266 */     while (agg_mapIter.next()) {
/* 1267 */       wholestagecodegen_numOutputRows.add(1);
/* 1268 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1269 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1270 */
/* 1271 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1272 */
/* 1273 */       append(agg_resultRow);
/* 1274 */
/* 1275 */       if (shouldStop()) return;
/* 1276 */     }
/* 1277 */
/* 1278 */     agg_mapIter.close();
/* 1279 */     if (agg_sorter == null) {
/* 1280 */       agg_hashMap.free();
/* 1281 */     }
/* 1282 */   }
/* 1283 */ }

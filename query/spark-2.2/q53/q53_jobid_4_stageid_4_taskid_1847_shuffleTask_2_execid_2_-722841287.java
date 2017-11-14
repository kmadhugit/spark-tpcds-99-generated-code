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
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private agg_FastHashMap agg_fastHashMap;
/* 015 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 016 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 017 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 018 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 021 */   private scala.collection.Iterator scan_input;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 024 */   private long scan_scanTime1;
/* 025 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 026 */   private int scan_batchIdx;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 028 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 031 */   private UnsafeRow scan_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 035 */   private UnsafeRow filter_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 038 */   private UnsafeRow project_result;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 041 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 042 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 044 */   private UnsafeRow bhj_result;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 047 */   private UnsafeRow project_result1;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 050 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 051 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 052 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 053 */   private UnsafeRow bhj_result1;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 056 */   private UnsafeRow project_result2;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 059 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 060 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 061 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 062 */   private UnsafeRow bhj_result2;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 065 */   private UnsafeRow project_result3;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 068 */   private UnsafeRow agg_result2;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 071 */   private int agg_value8;
/* 072 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 073 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 074 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 075 */
/* 076 */   public GeneratedIterator(Object[] references) {
/* 077 */     this.references = references;
/* 078 */   }
/* 079 */
/* 080 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 081 */     partitionIndex = index;
/* 082 */     this.inputs = inputs;
/* 083 */     wholestagecodegen_init_0();
/* 084 */     wholestagecodegen_init_1();
/* 085 */     wholestagecodegen_init_2();
/* 086 */     wholestagecodegen_init_3();
/* 087 */     wholestagecodegen_init_4();
/* 088 */
/* 089 */   }
/* 090 */
/* 091 */   private void wholestagecodegen_init_0() {
/* 092 */     agg_initAgg = false;
/* 093 */
/* 094 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 095 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 096 */
/* 097 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 098 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 099 */     scan_input = inputs[0];
/* 100 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 101 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 102 */     scan_scanTime1 = 0;
/* 103 */     scan_batch = null;
/* 104 */     scan_batchIdx = 0;
/* 105 */     scan_colInstance0 = null;
/* 106 */     scan_colInstance1 = null;
/* 107 */     scan_colInstance2 = null;
/* 108 */     scan_colInstance3 = null;
/* 109 */     scan_result = new UnsafeRow(4);
/* 110 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 111 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 112 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 113 */
/* 114 */   }
/* 115 */
/* 116 */   private void wholestagecodegen_init_3() {
/* 117 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[14];
/* 118 */
/* 119 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 120 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 121 */
/* 122 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 123 */     bhj_result2 = new UnsafeRow(5);
/* 124 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 0);
/* 125 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 5);
/* 126 */     project_result3 = new UnsafeRow(3);
/* 127 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 128 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 3);
/* 129 */     agg_result2 = new UnsafeRow(2);
/* 130 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 131 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 132 */
/* 133 */   }
/* 134 */
/* 135 */   private void scan_nextBatch() throws java.io.IOException {
/* 136 */     long getBatchStart = System.nanoTime();
/* 137 */     if (scan_input.hasNext()) {
/* 138 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 139 */       scan_numOutputRows.add(scan_batch.numRows());
/* 140 */       scan_batchIdx = 0;
/* 141 */       scan_colInstance0 = scan_batch.column(0);
/* 142 */       scan_colInstance1 = scan_batch.column(1);
/* 143 */       scan_colInstance2 = scan_batch.column(2);
/* 144 */       scan_colInstance3 = scan_batch.column(3);
/* 145 */
/* 146 */     }
/* 147 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 148 */   }
/* 149 */
/* 150 */   public class agg_FastHashMap {
/* 151 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 152 */     private int[] buckets;
/* 153 */     private int capacity = 1 << 16;
/* 154 */     private double loadFactor = 0.5;
/* 155 */     private int numBuckets = (int) (capacity / loadFactor);
/* 156 */     private int maxSteps = 2;
/* 157 */     private int numRows = 0;
/* 158 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 159 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 160 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 161 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 162 */     private Object emptyVBase;
/* 163 */     private long emptyVOff;
/* 164 */     private int emptyVLen;
/* 165 */     private boolean isBatchFull = false;
/* 166 */
/* 167 */     public agg_FastHashMap(
/* 168 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 169 */       InternalRow emptyAggregationBuffer) {
/* 170 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 171 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 172 */
/* 173 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 174 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 175 */
/* 176 */       emptyVBase = emptyBuffer;
/* 177 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 178 */       emptyVLen = emptyBuffer.length;
/* 179 */
/* 180 */       buckets = new int[numBuckets];
/* 181 */       java.util.Arrays.fill(buckets, -1);
/* 182 */     }
/* 183 */
/* 184 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key, int agg_key1) {
/* 185 */       long h = hash(agg_key, agg_key1);
/* 186 */       int step = 0;
/* 187 */       int idx = (int) h & (numBuckets - 1);
/* 188 */       while (step < maxSteps) {
/* 189 */         // Return bucket index if it's either an empty slot or already contains the key
/* 190 */         if (buckets[idx] == -1) {
/* 191 */           if (numRows < capacity && !isBatchFull) {
/* 192 */             // creating the unsafe for new entry
/* 193 */             UnsafeRow agg_result = new UnsafeRow(2);
/* 194 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 195 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 196 */               0);
/* 197 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 198 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 199 */               agg_holder,
/* 200 */               2);
/* 201 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 202 */             agg_rowWriter.zeroOutNullBytes();
/* 203 */             agg_rowWriter.write(0, agg_key);
/* 204 */             agg_rowWriter.write(1, agg_key1);
/* 205 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 206 */             Object kbase = agg_result.getBaseObject();
/* 207 */             long koff = agg_result.getBaseOffset();
/* 208 */             int klen = agg_result.getSizeInBytes();
/* 209 */
/* 210 */             UnsafeRow vRow
/* 211 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 212 */             if (vRow == null) {
/* 213 */               isBatchFull = true;
/* 214 */             } else {
/* 215 */               buckets[idx] = numRows++;
/* 216 */             }
/* 217 */             return vRow;
/* 218 */           } else {
/* 219 */             // No more space
/* 220 */             return null;
/* 221 */           }
/* 222 */         } else if (equals(idx, agg_key, agg_key1)) {
/* 223 */           return batch.getValueRow(buckets[idx]);
/* 224 */         }
/* 225 */         idx = (idx + 1) & (numBuckets - 1);
/* 226 */         step++;
/* 227 */       }
/* 228 */       // Didn't find it
/* 229 */       return null;
/* 230 */     }
/* 231 */
/* 232 */     private boolean equals(int idx, int agg_key, int agg_key1) {
/* 233 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 234 */       return (row.getInt(0) == agg_key) && (row.getInt(1) == agg_key1);
/* 235 */     }
/* 236 */
/* 237 */     private long hash(int agg_key, int agg_key1) {
/* 238 */       long agg_hash = 0;
/* 239 */
/* 240 */       int agg_result = agg_key;
/* 241 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 242 */
/* 243 */       int agg_result1 = agg_key1;
/* 244 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 245 */
/* 246 */       return agg_hash;
/* 247 */     }
/* 248 */
/* 249 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 250 */       return batch.rowIterator();
/* 251 */     }
/* 252 */
/* 253 */     public void close() {
/* 254 */       batch.close();
/* 255 */     }
/* 256 */
/* 257 */   }
/* 258 */
/* 259 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 260 */     agg_hashMap = agg_plan.createHashMap();
/* 261 */
/* 262 */     if (scan_batch == null) {
/* 263 */       scan_nextBatch();
/* 264 */     }
/* 265 */     while (scan_batch != null) {
/* 266 */       int scan_numRows = scan_batch.numRows();
/* 267 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 268 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 269 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 270 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 271 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 272 */
/* 273 */         if (!(!(scan_isNull))) continue;
/* 274 */
/* 275 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 276 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 277 */
/* 278 */         if (!(!(scan_isNull1))) continue;
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
/* 295 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 296 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 297 */
/* 298 */         // generate join key for stream side
/* 299 */
/* 300 */         boolean bhj_isNull10 = scan_isNull3;
/* 301 */         long bhj_value10 = -1L;
/* 302 */         if (!scan_isNull3) {
/* 303 */           bhj_value10 = (long) scan_value3;
/* 304 */         }
/* 305 */         // find matches from HashedRelation
/* 306 */         UnsafeRow bhj_matched1 = bhj_isNull10 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value10);
/* 307 */         if (bhj_matched1 == null) continue;
/* 308 */
/* 309 */         bhj_numOutputRows1.add(1);
/* 310 */
/* 311 */         // generate join key for stream side
/* 312 */
/* 313 */         boolean bhj_isNull20 = false;
/* 314 */         long bhj_value20 = -1L;
/* 315 */         if (!false) {
/* 316 */           bhj_value20 = (long) scan_value1;
/* 317 */         }
/* 318 */         // find matches from HashedRelation
/* 319 */         UnsafeRow bhj_matched2 = bhj_isNull20 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value20);
/* 320 */         if (bhj_matched2 == null) continue;
/* 321 */
/* 322 */         bhj_numOutputRows2.add(1);
/* 323 */
/* 324 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 325 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 326 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 327 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 328 */         boolean bhj_isNull13 = bhj_matched1.isNullAt(1);
/* 329 */         int bhj_value13 = bhj_isNull13 ? -1 : (bhj_matched1.getInt(1));
/* 330 */
/* 331 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 332 */
/* 333 */         UnsafeRow agg_fastAggBuffer = null;
/* 334 */
/* 335 */         if (true) {
/* 336 */           if (!bhj_isNull3 && !bhj_isNull13) {
/* 337 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 338 */               bhj_value3, bhj_value13);
/* 339 */           }
/* 340 */         }
/* 341 */
/* 342 */         if (agg_fastAggBuffer == null) {
/* 343 */           // generate grouping key
/* 344 */           agg_rowWriter.zeroOutNullBytes();
/* 345 */
/* 346 */           if (bhj_isNull3) {
/* 347 */             agg_rowWriter.setNullAt(0);
/* 348 */           } else {
/* 349 */             agg_rowWriter.write(0, bhj_value3);
/* 350 */           }
/* 351 */
/* 352 */           if (bhj_isNull13) {
/* 353 */             agg_rowWriter.setNullAt(1);
/* 354 */           } else {
/* 355 */             agg_rowWriter.write(1, bhj_value13);
/* 356 */           }
/* 357 */           agg_value8 = 42;
/* 358 */
/* 359 */           if (!bhj_isNull3) {
/* 360 */             agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value3, agg_value8);
/* 361 */           }
/* 362 */
/* 363 */           if (!bhj_isNull13) {
/* 364 */             agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value13, agg_value8);
/* 365 */           }
/* 366 */           if (true) {
/* 367 */             // try to get the buffer from hash map
/* 368 */             agg_unsafeRowAggBuffer =
/* 369 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value8);
/* 370 */           }
/* 371 */           if (agg_unsafeRowAggBuffer == null) {
/* 372 */             if (agg_sorter == null) {
/* 373 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 374 */             } else {
/* 375 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 376 */             }
/* 377 */
/* 378 */             // the hash map had be spilled, it should have enough memory now,
/* 379 */             // try  to allocate buffer again.
/* 380 */             agg_unsafeRowAggBuffer =
/* 381 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value8);
/* 382 */             if (agg_unsafeRowAggBuffer == null) {
/* 383 */               // failed to allocate the first page
/* 384 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 385 */             }
/* 386 */           }
/* 387 */         }
/* 388 */
/* 389 */         if (agg_fastAggBuffer != null) {
/* 390 */           // update fast row
/* 391 */
/* 392 */           // common sub-expressions
/* 393 */
/* 394 */           // evaluate aggregate function
/* 395 */           boolean agg_isNull28 = true;
/* 396 */           double agg_value30 = -1.0;
/* 397 */
/* 398 */           boolean agg_isNull30 = agg_fastAggBuffer.isNullAt(0);
/* 399 */           double agg_value32 = agg_isNull30 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 400 */           boolean agg_isNull29 = agg_isNull30;
/* 401 */           double agg_value31 = agg_value32;
/* 402 */           if (agg_isNull29) {
/* 403 */             boolean agg_isNull31 = false;
/* 404 */             double agg_value33 = -1.0;
/* 405 */             if (!false) {
/* 406 */               agg_value33 = (double) 0;
/* 407 */             }
/* 408 */             if (!agg_isNull31) {
/* 409 */               agg_isNull29 = false;
/* 410 */               agg_value31 = agg_value33;
/* 411 */             }
/* 412 */           }
/* 413 */
/* 414 */           if (!scan_isNull2) {
/* 415 */             agg_isNull28 = false; // resultCode could change nullability.
/* 416 */             agg_value30 = agg_value31 + scan_value2;
/* 417 */
/* 418 */           }
/* 419 */           boolean agg_isNull27 = agg_isNull28;
/* 420 */           double agg_value29 = agg_value30;
/* 421 */           if (agg_isNull27) {
/* 422 */             boolean agg_isNull34 = agg_fastAggBuffer.isNullAt(0);
/* 423 */             double agg_value36 = agg_isNull34 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 424 */             if (!agg_isNull34) {
/* 425 */               agg_isNull27 = false;
/* 426 */               agg_value29 = agg_value36;
/* 427 */             }
/* 428 */           }
/* 429 */           boolean agg_isNull36 = true;
/* 430 */           double agg_value38 = -1.0;
/* 431 */
/* 432 */           boolean agg_isNull38 = agg_fastAggBuffer.isNullAt(1);
/* 433 */           double agg_value40 = agg_isNull38 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 434 */           boolean agg_isNull37 = agg_isNull38;
/* 435 */           double agg_value39 = agg_value40;
/* 436 */           if (agg_isNull37) {
/* 437 */             boolean agg_isNull39 = false;
/* 438 */             double agg_value41 = -1.0;
/* 439 */             if (!false) {
/* 440 */               agg_value41 = (double) 0;
/* 441 */             }
/* 442 */             if (!agg_isNull39) {
/* 443 */               agg_isNull37 = false;
/* 444 */               agg_value39 = agg_value41;
/* 445 */             }
/* 446 */           }
/* 447 */
/* 448 */           if (!scan_isNull2) {
/* 449 */             agg_isNull36 = false; // resultCode could change nullability.
/* 450 */             agg_value38 = agg_value39 + scan_value2;
/* 451 */
/* 452 */           }
/* 453 */           boolean agg_isNull35 = agg_isNull36;
/* 454 */           double agg_value37 = agg_value38;
/* 455 */           if (agg_isNull35) {
/* 456 */             boolean agg_isNull42 = agg_fastAggBuffer.isNullAt(1);
/* 457 */             double agg_value44 = agg_isNull42 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 458 */             if (!agg_isNull42) {
/* 459 */               agg_isNull35 = false;
/* 460 */               agg_value37 = agg_value44;
/* 461 */             }
/* 462 */           }
/* 463 */           // update fast row
/* 464 */           if (!agg_isNull27) {
/* 465 */             agg_fastAggBuffer.setDouble(0, agg_value29);
/* 466 */           } else {
/* 467 */             agg_fastAggBuffer.setNullAt(0);
/* 468 */           }
/* 469 */
/* 470 */           if (!agg_isNull35) {
/* 471 */             agg_fastAggBuffer.setDouble(1, agg_value37);
/* 472 */           } else {
/* 473 */             agg_fastAggBuffer.setNullAt(1);
/* 474 */           }
/* 475 */
/* 476 */         } else {
/* 477 */           // update unsafe row
/* 478 */
/* 479 */           // common sub-expressions
/* 480 */
/* 481 */           // evaluate aggregate function
/* 482 */           boolean agg_isNull11 = true;
/* 483 */           double agg_value13 = -1.0;
/* 484 */
/* 485 */           boolean agg_isNull13 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 486 */           double agg_value15 = agg_isNull13 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 487 */           boolean agg_isNull12 = agg_isNull13;
/* 488 */           double agg_value14 = agg_value15;
/* 489 */           if (agg_isNull12) {
/* 490 */             boolean agg_isNull14 = false;
/* 491 */             double agg_value16 = -1.0;
/* 492 */             if (!false) {
/* 493 */               agg_value16 = (double) 0;
/* 494 */             }
/* 495 */             if (!agg_isNull14) {
/* 496 */               agg_isNull12 = false;
/* 497 */               agg_value14 = agg_value16;
/* 498 */             }
/* 499 */           }
/* 500 */
/* 501 */           if (!scan_isNull2) {
/* 502 */             agg_isNull11 = false; // resultCode could change nullability.
/* 503 */             agg_value13 = agg_value14 + scan_value2;
/* 504 */
/* 505 */           }
/* 506 */           boolean agg_isNull10 = agg_isNull11;
/* 507 */           double agg_value12 = agg_value13;
/* 508 */           if (agg_isNull10) {
/* 509 */             boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 510 */             double agg_value19 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 511 */             if (!agg_isNull17) {
/* 512 */               agg_isNull10 = false;
/* 513 */               agg_value12 = agg_value19;
/* 514 */             }
/* 515 */           }
/* 516 */           boolean agg_isNull19 = true;
/* 517 */           double agg_value21 = -1.0;
/* 518 */
/* 519 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 520 */           double agg_value23 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 521 */           boolean agg_isNull20 = agg_isNull21;
/* 522 */           double agg_value22 = agg_value23;
/* 523 */           if (agg_isNull20) {
/* 524 */             boolean agg_isNull22 = false;
/* 525 */             double agg_value24 = -1.0;
/* 526 */             if (!false) {
/* 527 */               agg_value24 = (double) 0;
/* 528 */             }
/* 529 */             if (!agg_isNull22) {
/* 530 */               agg_isNull20 = false;
/* 531 */               agg_value22 = agg_value24;
/* 532 */             }
/* 533 */           }
/* 534 */
/* 535 */           if (!scan_isNull2) {
/* 536 */             agg_isNull19 = false; // resultCode could change nullability.
/* 537 */             agg_value21 = agg_value22 + scan_value2;
/* 538 */
/* 539 */           }
/* 540 */           boolean agg_isNull18 = agg_isNull19;
/* 541 */           double agg_value20 = agg_value21;
/* 542 */           if (agg_isNull18) {
/* 543 */             boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 544 */             double agg_value27 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 545 */             if (!agg_isNull25) {
/* 546 */               agg_isNull18 = false;
/* 547 */               agg_value20 = agg_value27;
/* 548 */             }
/* 549 */           }
/* 550 */           // update unsafe row buffer
/* 551 */           if (!agg_isNull10) {
/* 552 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value12);
/* 553 */           } else {
/* 554 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 555 */           }
/* 556 */
/* 557 */           if (!agg_isNull18) {
/* 558 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value20);
/* 559 */           } else {
/* 560 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 561 */           }
/* 562 */
/* 563 */         }
/* 564 */         // shouldStop check is eliminated
/* 565 */       }
/* 566 */       scan_batchIdx = scan_numRows;
/* 567 */       scan_batch = null;
/* 568 */       scan_nextBatch();
/* 569 */     }
/* 570 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 571 */     scan_scanTime1 = 0;
/* 572 */
/* 573 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 574 */
/* 575 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 576 */   }
/* 577 */
/* 578 */   private void wholestagecodegen_init_2() {
/* 579 */     project_result1 = new UnsafeRow(4);
/* 580 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 581 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 582 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 583 */
/* 584 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 585 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 586 */
/* 587 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 588 */     bhj_result1 = new UnsafeRow(6);
/* 589 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 590 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 591 */     project_result2 = new UnsafeRow(4);
/* 592 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 593 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 4);
/* 594 */
/* 595 */   }
/* 596 */
/* 597 */   private void wholestagecodegen_init_1() {
/* 598 */     filter_result = new UnsafeRow(4);
/* 599 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 600 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 601 */     project_result = new UnsafeRow(4);
/* 602 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 603 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 604 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 605 */
/* 606 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 607 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 608 */
/* 609 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 610 */     bhj_result = new UnsafeRow(6);
/* 611 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 612 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 613 */
/* 614 */   }
/* 615 */
/* 616 */   private void wholestagecodegen_init_4() {
/* 617 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 618 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 619 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 620 */
/* 621 */   }
/* 622 */
/* 623 */   protected void processNext() throws java.io.IOException {
/* 624 */     if (!agg_initAgg) {
/* 625 */       agg_initAgg = true;
/* 626 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 627 */       agg_doAggregateWithKeys();
/* 628 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 629 */     }
/* 630 */
/* 631 */     // output the result
/* 632 */
/* 633 */     while (agg_fastHashMapIter.next()) {
/* 634 */       wholestagecodegen_numOutputRows.add(1);
/* 635 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 636 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 637 */
/* 638 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 639 */
/* 640 */       append(agg_resultRow);
/* 641 */
/* 642 */       if (shouldStop()) return;
/* 643 */     }
/* 644 */     agg_fastHashMap.close();
/* 645 */
/* 646 */     while (agg_mapIter.next()) {
/* 647 */       wholestagecodegen_numOutputRows.add(1);
/* 648 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 649 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 650 */
/* 651 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 652 */
/* 653 */       append(agg_resultRow);
/* 654 */
/* 655 */       if (shouldStop()) return;
/* 656 */     }
/* 657 */
/* 658 */     agg_mapIter.close();
/* 659 */     if (agg_sorter == null) {
/* 660 */       agg_hashMap.free();
/* 661 */     }
/* 662 */   }
/* 663 */ }

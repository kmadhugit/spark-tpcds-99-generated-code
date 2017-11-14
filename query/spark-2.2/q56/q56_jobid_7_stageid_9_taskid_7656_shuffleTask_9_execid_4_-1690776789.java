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
/* 057 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 058 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 059 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 060 */   private UnsafeRow bhj_result2;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 063 */   private UnsafeRow project_result3;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 066 */   private UnsafeRow agg_result1;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 069 */   private int agg_value4;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 071 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 072 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 073 */
/* 074 */   public GeneratedIterator(Object[] references) {
/* 075 */     this.references = references;
/* 076 */   }
/* 077 */
/* 078 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 079 */     partitionIndex = index;
/* 080 */     this.inputs = inputs;
/* 081 */     wholestagecodegen_init_0();
/* 082 */     wholestagecodegen_init_1();
/* 083 */     wholestagecodegen_init_2();
/* 084 */     wholestagecodegen_init_3();
/* 085 */     wholestagecodegen_init_4();
/* 086 */
/* 087 */   }
/* 088 */
/* 089 */   private void wholestagecodegen_init_0() {
/* 090 */     agg_initAgg = false;
/* 091 */
/* 092 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 093 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 094 */
/* 095 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 096 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 097 */     scan_input = inputs[0];
/* 098 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 099 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 100 */     scan_scanTime1 = 0;
/* 101 */     scan_batch = null;
/* 102 */     scan_batchIdx = 0;
/* 103 */     scan_colInstance0 = null;
/* 104 */     scan_colInstance1 = null;
/* 105 */     scan_colInstance2 = null;
/* 106 */     scan_colInstance3 = null;
/* 107 */     scan_result = new UnsafeRow(4);
/* 108 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 109 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 110 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 111 */
/* 112 */   }
/* 113 */
/* 114 */   private void wholestagecodegen_init_3() {
/* 115 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 116 */
/* 117 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 118 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 119 */
/* 120 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 121 */     bhj_result2 = new UnsafeRow(4);
/* 122 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 32);
/* 123 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 4);
/* 124 */     project_result3 = new UnsafeRow(2);
/* 125 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 32);
/* 126 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 2);
/* 127 */     agg_result1 = new UnsafeRow(1);
/* 128 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 129 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 130 */
/* 131 */   }
/* 132 */
/* 133 */   private void scan_nextBatch() throws java.io.IOException {
/* 134 */     long getBatchStart = System.nanoTime();
/* 135 */     if (scan_input.hasNext()) {
/* 136 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 137 */       scan_numOutputRows.add(scan_batch.numRows());
/* 138 */       scan_batchIdx = 0;
/* 139 */       scan_colInstance0 = scan_batch.column(0);
/* 140 */       scan_colInstance1 = scan_batch.column(1);
/* 141 */       scan_colInstance2 = scan_batch.column(2);
/* 142 */       scan_colInstance3 = scan_batch.column(3);
/* 143 */
/* 144 */     }
/* 145 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 146 */   }
/* 147 */
/* 148 */   public class agg_FastHashMap {
/* 149 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 150 */     private int[] buckets;
/* 151 */     private int capacity = 1 << 16;
/* 152 */     private double loadFactor = 0.5;
/* 153 */     private int numBuckets = (int) (capacity / loadFactor);
/* 154 */     private int maxSteps = 2;
/* 155 */     private int numRows = 0;
/* 156 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType);
/* 157 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 158 */     private Object emptyVBase;
/* 159 */     private long emptyVOff;
/* 160 */     private int emptyVLen;
/* 161 */     private boolean isBatchFull = false;
/* 162 */
/* 163 */     public agg_FastHashMap(
/* 164 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 165 */       InternalRow emptyAggregationBuffer) {
/* 166 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 167 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 168 */
/* 169 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 170 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 171 */
/* 172 */       emptyVBase = emptyBuffer;
/* 173 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 174 */       emptyVLen = emptyBuffer.length;
/* 175 */
/* 176 */       buckets = new int[numBuckets];
/* 177 */       java.util.Arrays.fill(buckets, -1);
/* 178 */     }
/* 179 */
/* 180 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key) {
/* 181 */       long h = hash(agg_key);
/* 182 */       int step = 0;
/* 183 */       int idx = (int) h & (numBuckets - 1);
/* 184 */       while (step < maxSteps) {
/* 185 */         // Return bucket index if it's either an empty slot or already contains the key
/* 186 */         if (buckets[idx] == -1) {
/* 187 */           if (numRows < capacity && !isBatchFull) {
/* 188 */             // creating the unsafe for new entry
/* 189 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 190 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 191 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 192 */               32);
/* 193 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 194 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 195 */               agg_holder,
/* 196 */               1);
/* 197 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 198 */             agg_rowWriter.zeroOutNullBytes();
/* 199 */             agg_rowWriter.write(0, agg_key);
/* 200 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 201 */             Object kbase = agg_result.getBaseObject();
/* 202 */             long koff = agg_result.getBaseOffset();
/* 203 */             int klen = agg_result.getSizeInBytes();
/* 204 */
/* 205 */             UnsafeRow vRow
/* 206 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 207 */             if (vRow == null) {
/* 208 */               isBatchFull = true;
/* 209 */             } else {
/* 210 */               buckets[idx] = numRows++;
/* 211 */             }
/* 212 */             return vRow;
/* 213 */           } else {
/* 214 */             // No more space
/* 215 */             return null;
/* 216 */           }
/* 217 */         } else if (equals(idx, agg_key)) {
/* 218 */           return batch.getValueRow(buckets[idx]);
/* 219 */         }
/* 220 */         idx = (idx + 1) & (numBuckets - 1);
/* 221 */         step++;
/* 222 */       }
/* 223 */       // Didn't find it
/* 224 */       return null;
/* 225 */     }
/* 226 */
/* 227 */     private boolean equals(int idx, UTF8String agg_key) {
/* 228 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 229 */       return (row.getUTF8String(0).equals(agg_key));
/* 230 */     }
/* 231 */
/* 232 */     private long hash(UTF8String agg_key) {
/* 233 */       long agg_hash = 0;
/* 234 */
/* 235 */       int agg_result = 0;
/* 236 */       byte[] agg_bytes = agg_key.getBytes();
/* 237 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 238 */         int agg_hash1 = agg_bytes[i];
/* 239 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 240 */       }
/* 241 */
/* 242 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 243 */
/* 244 */       return agg_hash;
/* 245 */     }
/* 246 */
/* 247 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 248 */       return batch.rowIterator();
/* 249 */     }
/* 250 */
/* 251 */     public void close() {
/* 252 */       batch.close();
/* 253 */     }
/* 254 */
/* 255 */   }
/* 256 */
/* 257 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 258 */     agg_hashMap = agg_plan.createHashMap();
/* 259 */
/* 260 */     if (scan_batch == null) {
/* 261 */       scan_nextBatch();
/* 262 */     }
/* 263 */     while (scan_batch != null) {
/* 264 */       int scan_numRows = scan_batch.numRows();
/* 265 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 266 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 267 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 268 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 269 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 270 */
/* 271 */         if (!(!(scan_isNull))) continue;
/* 272 */
/* 273 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 274 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 275 */
/* 276 */         if (!(!(scan_isNull1))) continue;
/* 277 */
/* 278 */         filter_numOutputRows.add(1);
/* 279 */
/* 280 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 281 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 282 */
/* 283 */         // generate join key for stream side
/* 284 */
/* 285 */         boolean bhj_isNull = scan_isNull3;
/* 286 */         long bhj_value = -1L;
/* 287 */         if (!scan_isNull3) {
/* 288 */           bhj_value = (long) scan_value3;
/* 289 */         }
/* 290 */         // find matches from HashedRelation
/* 291 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 292 */         if (bhj_matched == null) continue;
/* 293 */
/* 294 */         bhj_numOutputRows.add(1);
/* 295 */
/* 296 */         // generate join key for stream side
/* 297 */
/* 298 */         boolean bhj_isNull8 = false;
/* 299 */         long bhj_value8 = -1L;
/* 300 */         if (!false) {
/* 301 */           bhj_value8 = (long) scan_value;
/* 302 */         }
/* 303 */         // find matches from HashedRelation
/* 304 */         UnsafeRow bhj_matched1 = bhj_isNull8 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value8);
/* 305 */         if (bhj_matched1 == null) continue;
/* 306 */
/* 307 */         bhj_numOutputRows1.add(1);
/* 308 */
/* 309 */         // generate join key for stream side
/* 310 */
/* 311 */         boolean bhj_isNull15 = false;
/* 312 */         long bhj_value15 = -1L;
/* 313 */         if (!false) {
/* 314 */           bhj_value15 = (long) scan_value1;
/* 315 */         }
/* 316 */         // find matches from HashedRelation
/* 317 */         UnsafeRow bhj_matched2 = bhj_isNull15 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value15);
/* 318 */         if (bhj_matched2 == null) continue;
/* 319 */
/* 320 */         bhj_numOutputRows2.add(1);
/* 321 */
/* 322 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 323 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 324 */         boolean bhj_isNull18 = bhj_matched2.isNullAt(1);
/* 325 */         UTF8String bhj_value18 = bhj_isNull18 ? null : (bhj_matched2.getUTF8String(1));
/* 326 */
/* 327 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 328 */
/* 329 */         UnsafeRow agg_fastAggBuffer = null;
/* 330 */
/* 331 */         if (true) {
/* 332 */           if (!bhj_isNull18) {
/* 333 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 334 */               bhj_value18);
/* 335 */           }
/* 336 */         }
/* 337 */
/* 338 */         if (agg_fastAggBuffer == null) {
/* 339 */           // generate grouping key
/* 340 */           agg_holder.reset();
/* 341 */
/* 342 */           agg_rowWriter.zeroOutNullBytes();
/* 343 */
/* 344 */           if (bhj_isNull18) {
/* 345 */             agg_rowWriter.setNullAt(0);
/* 346 */           } else {
/* 347 */             agg_rowWriter.write(0, bhj_value18);
/* 348 */           }
/* 349 */           agg_result1.setTotalSize(agg_holder.totalSize());
/* 350 */           agg_value4 = 42;
/* 351 */
/* 352 */           if (!bhj_isNull18) {
/* 353 */             agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value18.getBaseObject(), bhj_value18.getBaseOffset(), bhj_value18.numBytes(), agg_value4);
/* 354 */           }
/* 355 */           if (true) {
/* 356 */             // try to get the buffer from hash map
/* 357 */             agg_unsafeRowAggBuffer =
/* 358 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 359 */           }
/* 360 */           if (agg_unsafeRowAggBuffer == null) {
/* 361 */             if (agg_sorter == null) {
/* 362 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 363 */             } else {
/* 364 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 365 */             }
/* 366 */
/* 367 */             // the hash map had be spilled, it should have enough memory now,
/* 368 */             // try  to allocate buffer again.
/* 369 */             agg_unsafeRowAggBuffer =
/* 370 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 371 */             if (agg_unsafeRowAggBuffer == null) {
/* 372 */               // failed to allocate the first page
/* 373 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 374 */             }
/* 375 */           }
/* 376 */         }
/* 377 */
/* 378 */         if (agg_fastAggBuffer != null) {
/* 379 */           // update fast row
/* 380 */
/* 381 */           // common sub-expressions
/* 382 */
/* 383 */           // evaluate aggregate function
/* 384 */           boolean agg_isNull14 = true;
/* 385 */           double agg_value15 = -1.0;
/* 386 */
/* 387 */           boolean agg_isNull16 = agg_fastAggBuffer.isNullAt(0);
/* 388 */           double agg_value17 = agg_isNull16 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 389 */           boolean agg_isNull15 = agg_isNull16;
/* 390 */           double agg_value16 = agg_value17;
/* 391 */           if (agg_isNull15) {
/* 392 */             boolean agg_isNull17 = false;
/* 393 */             double agg_value18 = -1.0;
/* 394 */             if (!false) {
/* 395 */               agg_value18 = (double) 0;
/* 396 */             }
/* 397 */             if (!agg_isNull17) {
/* 398 */               agg_isNull15 = false;
/* 399 */               agg_value16 = agg_value18;
/* 400 */             }
/* 401 */           }
/* 402 */
/* 403 */           if (!scan_isNull2) {
/* 404 */             agg_isNull14 = false; // resultCode could change nullability.
/* 405 */             agg_value15 = agg_value16 + scan_value2;
/* 406 */
/* 407 */           }
/* 408 */           boolean agg_isNull13 = agg_isNull14;
/* 409 */           double agg_value14 = agg_value15;
/* 410 */           if (agg_isNull13) {
/* 411 */             boolean agg_isNull20 = agg_fastAggBuffer.isNullAt(0);
/* 412 */             double agg_value21 = agg_isNull20 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 413 */             if (!agg_isNull20) {
/* 414 */               agg_isNull13 = false;
/* 415 */               agg_value14 = agg_value21;
/* 416 */             }
/* 417 */           }
/* 418 */           // update fast row
/* 419 */           if (!agg_isNull13) {
/* 420 */             agg_fastAggBuffer.setDouble(0, agg_value14);
/* 421 */           } else {
/* 422 */             agg_fastAggBuffer.setNullAt(0);
/* 423 */           }
/* 424 */
/* 425 */         } else {
/* 426 */           // update unsafe row
/* 427 */
/* 428 */           // common sub-expressions
/* 429 */
/* 430 */           // evaluate aggregate function
/* 431 */           boolean agg_isNull6 = true;
/* 432 */           double agg_value7 = -1.0;
/* 433 */
/* 434 */           boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 435 */           double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 436 */           boolean agg_isNull7 = agg_isNull8;
/* 437 */           double agg_value8 = agg_value9;
/* 438 */           if (agg_isNull7) {
/* 439 */             boolean agg_isNull9 = false;
/* 440 */             double agg_value10 = -1.0;
/* 441 */             if (!false) {
/* 442 */               agg_value10 = (double) 0;
/* 443 */             }
/* 444 */             if (!agg_isNull9) {
/* 445 */               agg_isNull7 = false;
/* 446 */               agg_value8 = agg_value10;
/* 447 */             }
/* 448 */           }
/* 449 */
/* 450 */           if (!scan_isNull2) {
/* 451 */             agg_isNull6 = false; // resultCode could change nullability.
/* 452 */             agg_value7 = agg_value8 + scan_value2;
/* 453 */
/* 454 */           }
/* 455 */           boolean agg_isNull5 = agg_isNull6;
/* 456 */           double agg_value6 = agg_value7;
/* 457 */           if (agg_isNull5) {
/* 458 */             boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 459 */             double agg_value13 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 460 */             if (!agg_isNull12) {
/* 461 */               agg_isNull5 = false;
/* 462 */               agg_value6 = agg_value13;
/* 463 */             }
/* 464 */           }
/* 465 */           // update unsafe row buffer
/* 466 */           if (!agg_isNull5) {
/* 467 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 468 */           } else {
/* 469 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 470 */           }
/* 471 */
/* 472 */         }
/* 473 */         // shouldStop check is eliminated
/* 474 */       }
/* 475 */       scan_batchIdx = scan_numRows;
/* 476 */       scan_batch = null;
/* 477 */       scan_nextBatch();
/* 478 */     }
/* 479 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 480 */     scan_scanTime1 = 0;
/* 481 */
/* 482 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 483 */
/* 484 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 485 */   }
/* 486 */
/* 487 */   private void wholestagecodegen_init_2() {
/* 488 */     project_result1 = new UnsafeRow(3);
/* 489 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 490 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 491 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 492 */
/* 493 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 494 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 495 */
/* 496 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 497 */     bhj_result1 = new UnsafeRow(4);
/* 498 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 499 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 4);
/* 500 */     project_result2 = new UnsafeRow(2);
/* 501 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 502 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 2);
/* 503 */
/* 504 */   }
/* 505 */
/* 506 */   private void wholestagecodegen_init_1() {
/* 507 */     filter_result = new UnsafeRow(4);
/* 508 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 509 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 510 */     project_result = new UnsafeRow(4);
/* 511 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 512 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 513 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 514 */
/* 515 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 516 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 517 */
/* 518 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 519 */     bhj_result = new UnsafeRow(5);
/* 520 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 521 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 522 */
/* 523 */   }
/* 524 */
/* 525 */   private void wholestagecodegen_init_4() {
/* 526 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 527 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 528 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 529 */
/* 530 */   }
/* 531 */
/* 532 */   protected void processNext() throws java.io.IOException {
/* 533 */     if (!agg_initAgg) {
/* 534 */       agg_initAgg = true;
/* 535 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 536 */       agg_doAggregateWithKeys();
/* 537 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 538 */     }
/* 539 */
/* 540 */     // output the result
/* 541 */
/* 542 */     while (agg_fastHashMapIter.next()) {
/* 543 */       wholestagecodegen_numOutputRows.add(1);
/* 544 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 545 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 546 */
/* 547 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 548 */
/* 549 */       append(agg_resultRow);
/* 550 */
/* 551 */       if (shouldStop()) return;
/* 552 */     }
/* 553 */     agg_fastHashMap.close();
/* 554 */
/* 555 */     while (agg_mapIter.next()) {
/* 556 */       wholestagecodegen_numOutputRows.add(1);
/* 557 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 558 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 559 */
/* 560 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 561 */
/* 562 */       append(agg_resultRow);
/* 563 */
/* 564 */       if (shouldStop()) return;
/* 565 */     }
/* 566 */
/* 567 */     agg_mapIter.close();
/* 568 */     if (agg_sorter == null) {
/* 569 */       agg_hashMap.free();
/* 570 */     }
/* 571 */   }
/* 572 */ }

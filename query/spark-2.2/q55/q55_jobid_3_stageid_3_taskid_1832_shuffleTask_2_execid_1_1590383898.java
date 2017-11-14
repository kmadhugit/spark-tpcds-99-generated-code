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
/* 056 */   private UnsafeRow agg_result2;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 059 */   private int agg_value6;
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
/* 087 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 088 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 089 */     scan_scanTime1 = 0;
/* 090 */     scan_batch = null;
/* 091 */     scan_batchIdx = 0;
/* 092 */     scan_colInstance0 = null;
/* 093 */     scan_colInstance1 = null;
/* 094 */     scan_colInstance2 = null;
/* 095 */     scan_result = new UnsafeRow(3);
/* 096 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 097 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 098 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 099 */
/* 100 */   }
/* 101 */
/* 102 */   private void wholestagecodegen_init_3() {
/* 103 */     agg_result2 = new UnsafeRow(2);
/* 104 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 32);
/* 105 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 106 */
/* 107 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 108 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 109 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
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
/* 136 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 137 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 138 */     private Object emptyVBase;
/* 139 */     private long emptyVOff;
/* 140 */     private int emptyVLen;
/* 141 */     private boolean isBatchFull = false;
/* 142 */
/* 143 */     public agg_FastHashMap(
/* 144 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 145 */       InternalRow emptyAggregationBuffer) {
/* 146 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 147 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 148 */
/* 149 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 150 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 151 */
/* 152 */       emptyVBase = emptyBuffer;
/* 153 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 154 */       emptyVLen = emptyBuffer.length;
/* 155 */
/* 156 */       buckets = new int[numBuckets];
/* 157 */       java.util.Arrays.fill(buckets, -1);
/* 158 */     }
/* 159 */
/* 160 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1) {
/* 161 */       long h = hash(agg_key, agg_key1);
/* 162 */       int step = 0;
/* 163 */       int idx = (int) h & (numBuckets - 1);
/* 164 */       while (step < maxSteps) {
/* 165 */         // Return bucket index if it's either an empty slot or already contains the key
/* 166 */         if (buckets[idx] == -1) {
/* 167 */           if (numRows < capacity && !isBatchFull) {
/* 168 */             // creating the unsafe for new entry
/* 169 */             UnsafeRow agg_result = new UnsafeRow(2);
/* 170 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 171 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 172 */               32);
/* 173 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 174 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 175 */               agg_holder,
/* 176 */               2);
/* 177 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 178 */             agg_rowWriter.zeroOutNullBytes();
/* 179 */             agg_rowWriter.write(0, agg_key);
/* 180 */             agg_rowWriter.write(1, agg_key1);
/* 181 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 182 */             Object kbase = agg_result.getBaseObject();
/* 183 */             long koff = agg_result.getBaseOffset();
/* 184 */             int klen = agg_result.getSizeInBytes();
/* 185 */
/* 186 */             UnsafeRow vRow
/* 187 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 188 */             if (vRow == null) {
/* 189 */               isBatchFull = true;
/* 190 */             } else {
/* 191 */               buckets[idx] = numRows++;
/* 192 */             }
/* 193 */             return vRow;
/* 194 */           } else {
/* 195 */             // No more space
/* 196 */             return null;
/* 197 */           }
/* 198 */         } else if (equals(idx, agg_key, agg_key1)) {
/* 199 */           return batch.getValueRow(buckets[idx]);
/* 200 */         }
/* 201 */         idx = (idx + 1) & (numBuckets - 1);
/* 202 */         step++;
/* 203 */       }
/* 204 */       // Didn't find it
/* 205 */       return null;
/* 206 */     }
/* 207 */
/* 208 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1) {
/* 209 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 210 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1);
/* 211 */     }
/* 212 */
/* 213 */     private long hash(UTF8String agg_key, int agg_key1) {
/* 214 */       long agg_hash = 0;
/* 215 */
/* 216 */       int agg_result = 0;
/* 217 */       byte[] agg_bytes = agg_key.getBytes();
/* 218 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 219 */         int agg_hash1 = agg_bytes[i];
/* 220 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 221 */       }
/* 222 */
/* 223 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 224 */
/* 225 */       int agg_result1 = agg_key1;
/* 226 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 227 */
/* 228 */       return agg_hash;
/* 229 */     }
/* 230 */
/* 231 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 232 */       return batch.rowIterator();
/* 233 */     }
/* 234 */
/* 235 */     public void close() {
/* 236 */       batch.close();
/* 237 */     }
/* 238 */
/* 239 */   }
/* 240 */
/* 241 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 242 */     agg_hashMap = agg_plan.createHashMap();
/* 243 */
/* 244 */     if (scan_batch == null) {
/* 245 */       scan_nextBatch();
/* 246 */     }
/* 247 */     while (scan_batch != null) {
/* 248 */       int scan_numRows = scan_batch.numRows();
/* 249 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 250 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 251 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 252 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 253 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 254 */
/* 255 */         if (!(!(scan_isNull))) continue;
/* 256 */
/* 257 */         filter_numOutputRows.add(1);
/* 258 */
/* 259 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 260 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 261 */
/* 262 */         // generate join key for stream side
/* 263 */
/* 264 */         boolean bhj_isNull = scan_isNull2;
/* 265 */         long bhj_value = -1L;
/* 266 */         if (!scan_isNull2) {
/* 267 */           bhj_value = (long) scan_value2;
/* 268 */         }
/* 269 */         // find matches from HashedRelation
/* 270 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 271 */         if (bhj_matched == null) continue;
/* 272 */
/* 273 */         bhj_numOutputRows.add(1);
/* 274 */
/* 275 */         // generate join key for stream side
/* 276 */
/* 277 */         boolean bhj_isNull7 = false;
/* 278 */         long bhj_value7 = -1L;
/* 279 */         if (!false) {
/* 280 */           bhj_value7 = (long) scan_value;
/* 281 */         }
/* 282 */         // find matches from HashedRelation
/* 283 */         UnsafeRow bhj_matched1 = bhj_isNull7 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value7);
/* 284 */         if (bhj_matched1 == null) continue;
/* 285 */
/* 286 */         bhj_numOutputRows1.add(1);
/* 287 */
/* 288 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 289 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 290 */         boolean bhj_isNull10 = bhj_matched1.isNullAt(1);
/* 291 */         int bhj_value10 = bhj_isNull10 ? -1 : (bhj_matched1.getInt(1));
/* 292 */         boolean bhj_isNull11 = bhj_matched1.isNullAt(2);
/* 293 */         UTF8String bhj_value11 = bhj_isNull11 ? null : (bhj_matched1.getUTF8String(2));
/* 294 */
/* 295 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 296 */
/* 297 */         UnsafeRow agg_fastAggBuffer = null;
/* 298 */
/* 299 */         if (true) {
/* 300 */           if (!bhj_isNull11 && !bhj_isNull10) {
/* 301 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 302 */               bhj_value11, bhj_value10);
/* 303 */           }
/* 304 */         }
/* 305 */
/* 306 */         if (agg_fastAggBuffer == null) {
/* 307 */           // generate grouping key
/* 308 */           agg_holder.reset();
/* 309 */
/* 310 */           agg_rowWriter.zeroOutNullBytes();
/* 311 */
/* 312 */           if (bhj_isNull11) {
/* 313 */             agg_rowWriter.setNullAt(0);
/* 314 */           } else {
/* 315 */             agg_rowWriter.write(0, bhj_value11);
/* 316 */           }
/* 317 */
/* 318 */           if (bhj_isNull10) {
/* 319 */             agg_rowWriter.setNullAt(1);
/* 320 */           } else {
/* 321 */             agg_rowWriter.write(1, bhj_value10);
/* 322 */           }
/* 323 */           agg_result2.setTotalSize(agg_holder.totalSize());
/* 324 */           agg_value6 = 42;
/* 325 */
/* 326 */           if (!bhj_isNull11) {
/* 327 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value11.getBaseObject(), bhj_value11.getBaseOffset(), bhj_value11.numBytes(), agg_value6);
/* 328 */           }
/* 329 */
/* 330 */           if (!bhj_isNull10) {
/* 331 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value10, agg_value6);
/* 332 */           }
/* 333 */           if (true) {
/* 334 */             // try to get the buffer from hash map
/* 335 */             agg_unsafeRowAggBuffer =
/* 336 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 337 */           }
/* 338 */           if (agg_unsafeRowAggBuffer == null) {
/* 339 */             if (agg_sorter == null) {
/* 340 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 341 */             } else {
/* 342 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 343 */             }
/* 344 */
/* 345 */             // the hash map had be spilled, it should have enough memory now,
/* 346 */             // try  to allocate buffer again.
/* 347 */             agg_unsafeRowAggBuffer =
/* 348 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 349 */             if (agg_unsafeRowAggBuffer == null) {
/* 350 */               // failed to allocate the first page
/* 351 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 352 */             }
/* 353 */           }
/* 354 */         }
/* 355 */
/* 356 */         if (agg_fastAggBuffer != null) {
/* 357 */           // update fast row
/* 358 */
/* 359 */           // common sub-expressions
/* 360 */
/* 361 */           // evaluate aggregate function
/* 362 */           boolean agg_isNull17 = true;
/* 363 */           double agg_value18 = -1.0;
/* 364 */
/* 365 */           boolean agg_isNull19 = agg_fastAggBuffer.isNullAt(0);
/* 366 */           double agg_value20 = agg_isNull19 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 367 */           boolean agg_isNull18 = agg_isNull19;
/* 368 */           double agg_value19 = agg_value20;
/* 369 */           if (agg_isNull18) {
/* 370 */             boolean agg_isNull20 = false;
/* 371 */             double agg_value21 = -1.0;
/* 372 */             if (!false) {
/* 373 */               agg_value21 = (double) 0;
/* 374 */             }
/* 375 */             if (!agg_isNull20) {
/* 376 */               agg_isNull18 = false;
/* 377 */               agg_value19 = agg_value21;
/* 378 */             }
/* 379 */           }
/* 380 */
/* 381 */           if (!scan_isNull1) {
/* 382 */             agg_isNull17 = false; // resultCode could change nullability.
/* 383 */             agg_value18 = agg_value19 + scan_value1;
/* 384 */
/* 385 */           }
/* 386 */           boolean agg_isNull16 = agg_isNull17;
/* 387 */           double agg_value17 = agg_value18;
/* 388 */           if (agg_isNull16) {
/* 389 */             boolean agg_isNull23 = agg_fastAggBuffer.isNullAt(0);
/* 390 */             double agg_value24 = agg_isNull23 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 391 */             if (!agg_isNull23) {
/* 392 */               agg_isNull16 = false;
/* 393 */               agg_value17 = agg_value24;
/* 394 */             }
/* 395 */           }
/* 396 */           // update fast row
/* 397 */           if (!agg_isNull16) {
/* 398 */             agg_fastAggBuffer.setDouble(0, agg_value17);
/* 399 */           } else {
/* 400 */             agg_fastAggBuffer.setNullAt(0);
/* 401 */           }
/* 402 */
/* 403 */         } else {
/* 404 */           // update unsafe row
/* 405 */
/* 406 */           // common sub-expressions
/* 407 */
/* 408 */           // evaluate aggregate function
/* 409 */           boolean agg_isNull9 = true;
/* 410 */           double agg_value10 = -1.0;
/* 411 */
/* 412 */           boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 413 */           double agg_value12 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 414 */           boolean agg_isNull10 = agg_isNull11;
/* 415 */           double agg_value11 = agg_value12;
/* 416 */           if (agg_isNull10) {
/* 417 */             boolean agg_isNull12 = false;
/* 418 */             double agg_value13 = -1.0;
/* 419 */             if (!false) {
/* 420 */               agg_value13 = (double) 0;
/* 421 */             }
/* 422 */             if (!agg_isNull12) {
/* 423 */               agg_isNull10 = false;
/* 424 */               agg_value11 = agg_value13;
/* 425 */             }
/* 426 */           }
/* 427 */
/* 428 */           if (!scan_isNull1) {
/* 429 */             agg_isNull9 = false; // resultCode could change nullability.
/* 430 */             agg_value10 = agg_value11 + scan_value1;
/* 431 */
/* 432 */           }
/* 433 */           boolean agg_isNull8 = agg_isNull9;
/* 434 */           double agg_value9 = agg_value10;
/* 435 */           if (agg_isNull8) {
/* 436 */             boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 437 */             double agg_value16 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 438 */             if (!agg_isNull15) {
/* 439 */               agg_isNull8 = false;
/* 440 */               agg_value9 = agg_value16;
/* 441 */             }
/* 442 */           }
/* 443 */           // update unsafe row buffer
/* 444 */           if (!agg_isNull8) {
/* 445 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 446 */           } else {
/* 447 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 448 */           }
/* 449 */
/* 450 */         }
/* 451 */         // shouldStop check is eliminated
/* 452 */       }
/* 453 */       scan_batchIdx = scan_numRows;
/* 454 */       scan_batch = null;
/* 455 */       scan_nextBatch();
/* 456 */     }
/* 457 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 458 */     scan_scanTime1 = 0;
/* 459 */
/* 460 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 461 */
/* 462 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 463 */   }
/* 464 */
/* 465 */   private void wholestagecodegen_init_2() {
/* 466 */     project_result1 = new UnsafeRow(2);
/* 467 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 468 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 469 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[11];
/* 470 */
/* 471 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 472 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 473 */
/* 474 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 475 */     bhj_result1 = new UnsafeRow(5);
/* 476 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 32);
/* 477 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 5);
/* 478 */     project_result2 = new UnsafeRow(3);
/* 479 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 32);
/* 480 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 3);
/* 481 */
/* 482 */   }
/* 483 */
/* 484 */   private void wholestagecodegen_init_1() {
/* 485 */     filter_result = new UnsafeRow(3);
/* 486 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 487 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 488 */     project_result = new UnsafeRow(3);
/* 489 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 490 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 491 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 492 */
/* 493 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 494 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 495 */
/* 496 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 497 */     bhj_result = new UnsafeRow(4);
/* 498 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 499 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 500 */
/* 501 */   }
/* 502 */
/* 503 */   protected void processNext() throws java.io.IOException {
/* 504 */     if (!agg_initAgg) {
/* 505 */       agg_initAgg = true;
/* 506 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 507 */       agg_doAggregateWithKeys();
/* 508 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 509 */     }
/* 510 */
/* 511 */     // output the result
/* 512 */
/* 513 */     while (agg_fastHashMapIter.next()) {
/* 514 */       wholestagecodegen_numOutputRows.add(1);
/* 515 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 516 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 517 */
/* 518 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 519 */
/* 520 */       append(agg_resultRow);
/* 521 */
/* 522 */       if (shouldStop()) return;
/* 523 */     }
/* 524 */     agg_fastHashMap.close();
/* 525 */
/* 526 */     while (agg_mapIter.next()) {
/* 527 */       wholestagecodegen_numOutputRows.add(1);
/* 528 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 529 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 530 */
/* 531 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 532 */
/* 533 */       append(agg_resultRow);
/* 534 */
/* 535 */       if (shouldStop()) return;
/* 536 */     }
/* 537 */
/* 538 */     agg_mapIter.close();
/* 539 */     if (agg_sorter == null) {
/* 540 */       agg_hashMap.free();
/* 541 */     }
/* 542 */   }
/* 543 */ }

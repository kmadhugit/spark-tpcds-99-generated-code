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
/* 059 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 060 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 061 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 062 */   private UnsafeRow bhj_result1;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 065 */   private UnsafeRow project_result2;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 068 */   private UnsafeRow agg_result2;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 071 */   private int agg_value18;
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
/* 087 */
/* 088 */   }
/* 089 */
/* 090 */   private void wholestagecodegen_init_0() {
/* 091 */     agg_initAgg = false;
/* 092 */
/* 093 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 094 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 095 */
/* 096 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 097 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 098 */     scan_input = inputs[0];
/* 099 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 100 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 101 */     scan_scanTime1 = 0;
/* 102 */     scan_batch = null;
/* 103 */     scan_batchIdx = 0;
/* 104 */     scan_colInstance0 = null;
/* 105 */     scan_colInstance1 = null;
/* 106 */     scan_colInstance2 = null;
/* 107 */     scan_result = new UnsafeRow(3);
/* 108 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 109 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 110 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 111 */
/* 112 */   }
/* 113 */
/* 114 */   private void wholestagecodegen_init_3() {
/* 115 */     agg_result2 = new UnsafeRow(2);
/* 116 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 64);
/* 117 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 118 */
/* 119 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 120 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[33];
/* 121 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[34];
/* 122 */
/* 123 */   }
/* 124 */
/* 125 */   private void scan_nextBatch() throws java.io.IOException {
/* 126 */     long getBatchStart = System.nanoTime();
/* 127 */     if (scan_input.hasNext()) {
/* 128 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 129 */       scan_numOutputRows.add(scan_batch.numRows());
/* 130 */       scan_batchIdx = 0;
/* 131 */       scan_colInstance0 = scan_batch.column(0);
/* 132 */       scan_colInstance1 = scan_batch.column(1);
/* 133 */       scan_colInstance2 = scan_batch.column(2);
/* 134 */
/* 135 */     }
/* 136 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 137 */   }
/* 138 */
/* 139 */   public class agg_FastHashMap {
/* 140 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 141 */     private int[] buckets;
/* 142 */     private int capacity = 1 << 16;
/* 143 */     private double loadFactor = 0.5;
/* 144 */     private int numBuckets = (int) (capacity / loadFactor);
/* 145 */     private int maxSteps = 2;
/* 146 */     private int numRows = 0;
/* 147 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 148 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType);
/* 149 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 150 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 151 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 152 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 153 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 154 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 155 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 156 */     private Object emptyVBase;
/* 157 */     private long emptyVOff;
/* 158 */     private int emptyVLen;
/* 159 */     private boolean isBatchFull = false;
/* 160 */
/* 161 */     public agg_FastHashMap(
/* 162 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 163 */       InternalRow emptyAggregationBuffer) {
/* 164 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 165 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 166 */
/* 167 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 168 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 169 */
/* 170 */       emptyVBase = emptyBuffer;
/* 171 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 172 */       emptyVLen = emptyBuffer.length;
/* 173 */
/* 174 */       buckets = new int[numBuckets];
/* 175 */       java.util.Arrays.fill(buckets, -1);
/* 176 */     }
/* 177 */
/* 178 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1) {
/* 179 */       long h = hash(agg_key, agg_key1);
/* 180 */       int step = 0;
/* 181 */       int idx = (int) h & (numBuckets - 1);
/* 182 */       while (step < maxSteps) {
/* 183 */         // Return bucket index if it's either an empty slot or already contains the key
/* 184 */         if (buckets[idx] == -1) {
/* 185 */           if (numRows < capacity && !isBatchFull) {
/* 186 */             // creating the unsafe for new entry
/* 187 */             UnsafeRow agg_result = new UnsafeRow(2);
/* 188 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 189 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 190 */               64);
/* 191 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 192 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 193 */               agg_holder,
/* 194 */               2);
/* 195 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 196 */             agg_rowWriter.zeroOutNullBytes();
/* 197 */             agg_rowWriter.write(0, agg_key);
/* 198 */             agg_rowWriter.write(1, agg_key1);
/* 199 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 200 */             Object kbase = agg_result.getBaseObject();
/* 201 */             long koff = agg_result.getBaseOffset();
/* 202 */             int klen = agg_result.getSizeInBytes();
/* 203 */
/* 204 */             UnsafeRow vRow
/* 205 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 206 */             if (vRow == null) {
/* 207 */               isBatchFull = true;
/* 208 */             } else {
/* 209 */               buckets[idx] = numRows++;
/* 210 */             }
/* 211 */             return vRow;
/* 212 */           } else {
/* 213 */             // No more space
/* 214 */             return null;
/* 215 */           }
/* 216 */         } else if (equals(idx, agg_key, agg_key1)) {
/* 217 */           return batch.getValueRow(buckets[idx]);
/* 218 */         }
/* 219 */         idx = (idx + 1) & (numBuckets - 1);
/* 220 */         step++;
/* 221 */       }
/* 222 */       // Didn't find it
/* 223 */       return null;
/* 224 */     }
/* 225 */
/* 226 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1) {
/* 227 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 228 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1));
/* 229 */     }
/* 230 */
/* 231 */     private long hash(UTF8String agg_key, UTF8String agg_key1) {
/* 232 */       long agg_hash = 0;
/* 233 */
/* 234 */       int agg_result = 0;
/* 235 */       byte[] agg_bytes = agg_key.getBytes();
/* 236 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 237 */         int agg_hash1 = agg_bytes[i];
/* 238 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 239 */       }
/* 240 */
/* 241 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 242 */
/* 243 */       int agg_result1 = 0;
/* 244 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 245 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 246 */         int agg_hash2 = agg_bytes1[i];
/* 247 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 248 */       }
/* 249 */
/* 250 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 251 */
/* 252 */       return agg_hash;
/* 253 */     }
/* 254 */
/* 255 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 256 */       return batch.rowIterator();
/* 257 */     }
/* 258 */
/* 259 */     public void close() {
/* 260 */       batch.close();
/* 261 */     }
/* 262 */
/* 263 */   }
/* 264 */
/* 265 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 266 */     agg_hashMap = agg_plan.createHashMap();
/* 267 */
/* 268 */     if (scan_batch == null) {
/* 269 */       scan_nextBatch();
/* 270 */     }
/* 271 */     while (scan_batch != null) {
/* 272 */       int scan_numRows = scan_batch.numRows();
/* 273 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 274 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 275 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 276 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 277 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 278 */
/* 279 */         if (!(!(scan_isNull))) continue;
/* 280 */
/* 281 */         filter_numOutputRows.add(1);
/* 282 */
/* 283 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 284 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 285 */
/* 286 */         // generate join key for stream side
/* 287 */
/* 288 */         boolean bhj_isNull = scan_isNull2;
/* 289 */         long bhj_value = -1L;
/* 290 */         if (!scan_isNull2) {
/* 291 */           bhj_value = (long) scan_value2;
/* 292 */         }
/* 293 */         // find matches from HashedRelation
/* 294 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 295 */         if (bhj_matched == null) continue;
/* 296 */
/* 297 */         bhj_numOutputRows.add(1);
/* 298 */
/* 299 */         // generate join key for stream side
/* 300 */
/* 301 */         boolean bhj_isNull9 = false;
/* 302 */         long bhj_value9 = -1L;
/* 303 */         if (!false) {
/* 304 */           bhj_value9 = (long) scan_value;
/* 305 */         }
/* 306 */         // find matches from HashedRelation
/* 307 */         UnsafeRow bhj_matched1 = bhj_isNull9 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value9);
/* 308 */         if (bhj_matched1 == null) continue;
/* 309 */
/* 310 */         bhj_numOutputRows1.add(1);
/* 311 */
/* 312 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 313 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 314 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 315 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 316 */         boolean bhj_isNull12 = bhj_matched1.isNullAt(1);
/* 317 */         UTF8String bhj_value12 = bhj_isNull12 ? null : (bhj_matched1.getUTF8String(1));
/* 318 */         boolean bhj_isNull13 = bhj_matched1.isNullAt(2);
/* 319 */         UTF8String bhj_value13 = bhj_isNull13 ? null : (bhj_matched1.getUTF8String(2));
/* 320 */
/* 321 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 322 */
/* 323 */         UnsafeRow agg_fastAggBuffer = null;
/* 324 */
/* 325 */         if (true) {
/* 326 */           if (!bhj_isNull13 && !bhj_isNull12) {
/* 327 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 328 */               bhj_value13, bhj_value12);
/* 329 */           }
/* 330 */         }
/* 331 */
/* 332 */         if (agg_fastAggBuffer == null) {
/* 333 */           // generate grouping key
/* 334 */           agg_holder.reset();
/* 335 */
/* 336 */           agg_rowWriter.zeroOutNullBytes();
/* 337 */
/* 338 */           if (bhj_isNull13) {
/* 339 */             agg_rowWriter.setNullAt(0);
/* 340 */           } else {
/* 341 */             agg_rowWriter.write(0, bhj_value13);
/* 342 */           }
/* 343 */
/* 344 */           if (bhj_isNull12) {
/* 345 */             agg_rowWriter.setNullAt(1);
/* 346 */           } else {
/* 347 */             agg_rowWriter.write(1, bhj_value12);
/* 348 */           }
/* 349 */           agg_result2.setTotalSize(agg_holder.totalSize());
/* 350 */           agg_value18 = 42;
/* 351 */
/* 352 */           if (!bhj_isNull13) {
/* 353 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value13.getBaseObject(), bhj_value13.getBaseOffset(), bhj_value13.numBytes(), agg_value18);
/* 354 */           }
/* 355 */
/* 356 */           if (!bhj_isNull12) {
/* 357 */             agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value12.getBaseObject(), bhj_value12.getBaseOffset(), bhj_value12.numBytes(), agg_value18);
/* 358 */           }
/* 359 */           if (true) {
/* 360 */             // try to get the buffer from hash map
/* 361 */             agg_unsafeRowAggBuffer =
/* 362 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value18);
/* 363 */           }
/* 364 */           if (agg_unsafeRowAggBuffer == null) {
/* 365 */             if (agg_sorter == null) {
/* 366 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 367 */             } else {
/* 368 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 369 */             }
/* 370 */
/* 371 */             // the hash map had be spilled, it should have enough memory now,
/* 372 */             // try  to allocate buffer again.
/* 373 */             agg_unsafeRowAggBuffer =
/* 374 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value18);
/* 375 */             if (agg_unsafeRowAggBuffer == null) {
/* 376 */               // failed to allocate the first page
/* 377 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 378 */             }
/* 379 */           }
/* 380 */         }
/* 381 */
/* 382 */         if (agg_fastAggBuffer != null) {
/* 383 */           // update fast row
/* 384 */
/* 385 */           // common sub-expressions
/* 386 */
/* 387 */           // evaluate aggregate function
/* 388 */           boolean agg_isNull106 = true;
/* 389 */           double agg_value113 = -1.0;
/* 390 */
/* 391 */           boolean agg_isNull108 = agg_fastAggBuffer.isNullAt(0);
/* 392 */           double agg_value115 = agg_isNull108 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 393 */           boolean agg_isNull107 = agg_isNull108;
/* 394 */           double agg_value114 = agg_value115;
/* 395 */           if (agg_isNull107) {
/* 396 */             boolean agg_isNull109 = false;
/* 397 */             double agg_value116 = -1.0;
/* 398 */             if (!false) {
/* 399 */               agg_value116 = (double) 0;
/* 400 */             }
/* 401 */             if (!agg_isNull109) {
/* 402 */               agg_isNull107 = false;
/* 403 */               agg_value114 = agg_value116;
/* 404 */             }
/* 405 */           }
/* 406 */
/* 407 */           boolean agg_isNull111 = true;
/* 408 */           double agg_value118 = -1.0;
/* 409 */
/* 410 */           boolean agg_isNull112 = true;
/* 411 */           boolean agg_value119 = false;
/* 412 */
/* 413 */           if (!bhj_isNull3) {
/* 414 */             agg_isNull112 = false; // resultCode could change nullability.
/* 415 */             agg_value119 = bhj_value3.equals(((UTF8String) references[26]));
/* 416 */
/* 417 */           }
/* 418 */           if (!agg_isNull112 && agg_value119) {
/* 419 */             agg_isNull111 = scan_isNull1;
/* 420 */             agg_value118 = scan_value1;
/* 421 */           }
/* 422 */
/* 423 */           else {
/* 424 */             final double agg_value123 = -1.0;
/* 425 */             agg_isNull111 = true;
/* 426 */             agg_value118 = agg_value123;
/* 427 */           }
/* 428 */           if (!agg_isNull111) {
/* 429 */             agg_isNull106 = false; // resultCode could change nullability.
/* 430 */             agg_value113 = agg_value114 + agg_value118;
/* 431 */
/* 432 */           }
/* 433 */           boolean agg_isNull105 = agg_isNull106;
/* 434 */           double agg_value112 = agg_value113;
/* 435 */           if (agg_isNull105) {
/* 436 */             boolean agg_isNull117 = agg_fastAggBuffer.isNullAt(0);
/* 437 */             double agg_value124 = agg_isNull117 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 438 */             if (!agg_isNull117) {
/* 439 */               agg_isNull105 = false;
/* 440 */               agg_value112 = agg_value124;
/* 441 */             }
/* 442 */           }
/* 443 */           boolean agg_isNull119 = true;
/* 444 */           double agg_value126 = -1.0;
/* 445 */
/* 446 */           boolean agg_isNull121 = agg_fastAggBuffer.isNullAt(1);
/* 447 */           double agg_value128 = agg_isNull121 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 448 */           boolean agg_isNull120 = agg_isNull121;
/* 449 */           double agg_value127 = agg_value128;
/* 450 */           if (agg_isNull120) {
/* 451 */             boolean agg_isNull122 = false;
/* 452 */             double agg_value129 = -1.0;
/* 453 */             if (!false) {
/* 454 */               agg_value129 = (double) 0;
/* 455 */             }
/* 456 */             if (!agg_isNull122) {
/* 457 */               agg_isNull120 = false;
/* 458 */               agg_value127 = agg_value129;
/* 459 */             }
/* 460 */           }
/* 461 */
/* 462 */           boolean agg_isNull124 = true;
/* 463 */           double agg_value131 = -1.0;
/* 464 */
/* 465 */           boolean agg_isNull125 = true;
/* 466 */           boolean agg_value132 = false;
/* 467 */
/* 468 */           if (!bhj_isNull3) {
/* 469 */             agg_isNull125 = false; // resultCode could change nullability.
/* 470 */             agg_value132 = bhj_value3.equals(((UTF8String) references[27]));
/* 471 */
/* 472 */           }
/* 473 */           if (!agg_isNull125 && agg_value132) {
/* 474 */             agg_isNull124 = scan_isNull1;
/* 475 */             agg_value131 = scan_value1;
/* 476 */           }
/* 477 */
/* 478 */           else {
/* 479 */             final double agg_value136 = -1.0;
/* 480 */             agg_isNull124 = true;
/* 481 */             agg_value131 = agg_value136;
/* 482 */           }
/* 483 */           if (!agg_isNull124) {
/* 484 */             agg_isNull119 = false; // resultCode could change nullability.
/* 485 */             agg_value126 = agg_value127 + agg_value131;
/* 486 */
/* 487 */           }
/* 488 */           boolean agg_isNull118 = agg_isNull119;
/* 489 */           double agg_value125 = agg_value126;
/* 490 */           if (agg_isNull118) {
/* 491 */             boolean agg_isNull130 = agg_fastAggBuffer.isNullAt(1);
/* 492 */             double agg_value137 = agg_isNull130 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 493 */             if (!agg_isNull130) {
/* 494 */               agg_isNull118 = false;
/* 495 */               agg_value125 = agg_value137;
/* 496 */             }
/* 497 */           }
/* 498 */           boolean agg_isNull132 = true;
/* 499 */           double agg_value139 = -1.0;
/* 500 */
/* 501 */           boolean agg_isNull134 = agg_fastAggBuffer.isNullAt(2);
/* 502 */           double agg_value141 = agg_isNull134 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 503 */           boolean agg_isNull133 = agg_isNull134;
/* 504 */           double agg_value140 = agg_value141;
/* 505 */           if (agg_isNull133) {
/* 506 */             boolean agg_isNull135 = false;
/* 507 */             double agg_value142 = -1.0;
/* 508 */             if (!false) {
/* 509 */               agg_value142 = (double) 0;
/* 510 */             }
/* 511 */             if (!agg_isNull135) {
/* 512 */               agg_isNull133 = false;
/* 513 */               agg_value140 = agg_value142;
/* 514 */             }
/* 515 */           }
/* 516 */
/* 517 */           boolean agg_isNull137 = true;
/* 518 */           double agg_value144 = -1.0;
/* 519 */
/* 520 */           boolean agg_isNull138 = true;
/* 521 */           boolean agg_value145 = false;
/* 522 */
/* 523 */           if (!bhj_isNull3) {
/* 524 */             agg_isNull138 = false; // resultCode could change nullability.
/* 525 */             agg_value145 = bhj_value3.equals(((UTF8String) references[28]));
/* 526 */
/* 527 */           }
/* 528 */           if (!agg_isNull138 && agg_value145) {
/* 529 */             agg_isNull137 = scan_isNull1;
/* 530 */             agg_value144 = scan_value1;
/* 531 */           }
/* 532 */
/* 533 */           else {
/* 534 */             final double agg_value149 = -1.0;
/* 535 */             agg_isNull137 = true;
/* 536 */             agg_value144 = agg_value149;
/* 537 */           }
/* 538 */           if (!agg_isNull137) {
/* 539 */             agg_isNull132 = false; // resultCode could change nullability.
/* 540 */             agg_value139 = agg_value140 + agg_value144;
/* 541 */
/* 542 */           }
/* 543 */           boolean agg_isNull131 = agg_isNull132;
/* 544 */           double agg_value138 = agg_value139;
/* 545 */           if (agg_isNull131) {
/* 546 */             boolean agg_isNull143 = agg_fastAggBuffer.isNullAt(2);
/* 547 */             double agg_value150 = agg_isNull143 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 548 */             if (!agg_isNull143) {
/* 549 */               agg_isNull131 = false;
/* 550 */               agg_value138 = agg_value150;
/* 551 */             }
/* 552 */           }
/* 553 */           boolean agg_isNull145 = true;
/* 554 */           double agg_value152 = -1.0;
/* 555 */
/* 556 */           boolean agg_isNull147 = agg_fastAggBuffer.isNullAt(3);
/* 557 */           double agg_value154 = agg_isNull147 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 558 */           boolean agg_isNull146 = agg_isNull147;
/* 559 */           double agg_value153 = agg_value154;
/* 560 */           if (agg_isNull146) {
/* 561 */             boolean agg_isNull148 = false;
/* 562 */             double agg_value155 = -1.0;
/* 563 */             if (!false) {
/* 564 */               agg_value155 = (double) 0;
/* 565 */             }
/* 566 */             if (!agg_isNull148) {
/* 567 */               agg_isNull146 = false;
/* 568 */               agg_value153 = agg_value155;
/* 569 */             }
/* 570 */           }
/* 571 */
/* 572 */           boolean agg_isNull150 = true;
/* 573 */           double agg_value157 = -1.0;
/* 574 */
/* 575 */           boolean agg_isNull151 = true;
/* 576 */           boolean agg_value158 = false;
/* 577 */
/* 578 */           if (!bhj_isNull3) {
/* 579 */             agg_isNull151 = false; // resultCode could change nullability.
/* 580 */             agg_value158 = bhj_value3.equals(((UTF8String) references[29]));
/* 581 */
/* 582 */           }
/* 583 */           if (!agg_isNull151 && agg_value158) {
/* 584 */             agg_isNull150 = scan_isNull1;
/* 585 */             agg_value157 = scan_value1;
/* 586 */           }
/* 587 */
/* 588 */           else {
/* 589 */             final double agg_value162 = -1.0;
/* 590 */             agg_isNull150 = true;
/* 591 */             agg_value157 = agg_value162;
/* 592 */           }
/* 593 */           if (!agg_isNull150) {
/* 594 */             agg_isNull145 = false; // resultCode could change nullability.
/* 595 */             agg_value152 = agg_value153 + agg_value157;
/* 596 */
/* 597 */           }
/* 598 */           boolean agg_isNull144 = agg_isNull145;
/* 599 */           double agg_value151 = agg_value152;
/* 600 */           if (agg_isNull144) {
/* 601 */             boolean agg_isNull156 = agg_fastAggBuffer.isNullAt(3);
/* 602 */             double agg_value163 = agg_isNull156 ? -1.0 : (agg_fastAggBuffer.getDouble(3));
/* 603 */             if (!agg_isNull156) {
/* 604 */               agg_isNull144 = false;
/* 605 */               agg_value151 = agg_value163;
/* 606 */             }
/* 607 */           }
/* 608 */           boolean agg_isNull158 = true;
/* 609 */           double agg_value165 = -1.0;
/* 610 */
/* 611 */           boolean agg_isNull160 = agg_fastAggBuffer.isNullAt(4);
/* 612 */           double agg_value167 = agg_isNull160 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 613 */           boolean agg_isNull159 = agg_isNull160;
/* 614 */           double agg_value166 = agg_value167;
/* 615 */           if (agg_isNull159) {
/* 616 */             boolean agg_isNull161 = false;
/* 617 */             double agg_value168 = -1.0;
/* 618 */             if (!false) {
/* 619 */               agg_value168 = (double) 0;
/* 620 */             }
/* 621 */             if (!agg_isNull161) {
/* 622 */               agg_isNull159 = false;
/* 623 */               agg_value166 = agg_value168;
/* 624 */             }
/* 625 */           }
/* 626 */
/* 627 */           boolean agg_isNull163 = true;
/* 628 */           double agg_value170 = -1.0;
/* 629 */
/* 630 */           boolean agg_isNull164 = true;
/* 631 */           boolean agg_value171 = false;
/* 632 */
/* 633 */           if (!bhj_isNull3) {
/* 634 */             agg_isNull164 = false; // resultCode could change nullability.
/* 635 */             agg_value171 = bhj_value3.equals(((UTF8String) references[30]));
/* 636 */
/* 637 */           }
/* 638 */           if (!agg_isNull164 && agg_value171) {
/* 639 */             agg_isNull163 = scan_isNull1;
/* 640 */             agg_value170 = scan_value1;
/* 641 */           }
/* 642 */
/* 643 */           else {
/* 644 */             final double agg_value175 = -1.0;
/* 645 */             agg_isNull163 = true;
/* 646 */             agg_value170 = agg_value175;
/* 647 */           }
/* 648 */           if (!agg_isNull163) {
/* 649 */             agg_isNull158 = false; // resultCode could change nullability.
/* 650 */             agg_value165 = agg_value166 + agg_value170;
/* 651 */
/* 652 */           }
/* 653 */           boolean agg_isNull157 = agg_isNull158;
/* 654 */           double agg_value164 = agg_value165;
/* 655 */           if (agg_isNull157) {
/* 656 */             boolean agg_isNull169 = agg_fastAggBuffer.isNullAt(4);
/* 657 */             double agg_value176 = agg_isNull169 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 658 */             if (!agg_isNull169) {
/* 659 */               agg_isNull157 = false;
/* 660 */               agg_value164 = agg_value176;
/* 661 */             }
/* 662 */           }
/* 663 */           boolean agg_isNull171 = true;
/* 664 */           double agg_value178 = -1.0;
/* 665 */
/* 666 */           boolean agg_isNull173 = agg_fastAggBuffer.isNullAt(5);
/* 667 */           double agg_value180 = agg_isNull173 ? -1.0 : (agg_fastAggBuffer.getDouble(5));
/* 668 */           boolean agg_isNull172 = agg_isNull173;
/* 669 */           double agg_value179 = agg_value180;
/* 670 */           if (agg_isNull172) {
/* 671 */             boolean agg_isNull174 = false;
/* 672 */             double agg_value181 = -1.0;
/* 673 */             if (!false) {
/* 674 */               agg_value181 = (double) 0;
/* 675 */             }
/* 676 */             if (!agg_isNull174) {
/* 677 */               agg_isNull172 = false;
/* 678 */               agg_value179 = agg_value181;
/* 679 */             }
/* 680 */           }
/* 681 */
/* 682 */           boolean agg_isNull176 = true;
/* 683 */           double agg_value183 = -1.0;
/* 684 */
/* 685 */           boolean agg_isNull177 = true;
/* 686 */           boolean agg_value184 = false;
/* 687 */
/* 688 */           if (!bhj_isNull3) {
/* 689 */             agg_isNull177 = false; // resultCode could change nullability.
/* 690 */             agg_value184 = bhj_value3.equals(((UTF8String) references[31]));
/* 691 */
/* 692 */           }
/* 693 */           if (!agg_isNull177 && agg_value184) {
/* 694 */             agg_isNull176 = scan_isNull1;
/* 695 */             agg_value183 = scan_value1;
/* 696 */           }
/* 697 */
/* 698 */           else {
/* 699 */             final double agg_value188 = -1.0;
/* 700 */             agg_isNull176 = true;
/* 701 */             agg_value183 = agg_value188;
/* 702 */           }
/* 703 */           if (!agg_isNull176) {
/* 704 */             agg_isNull171 = false; // resultCode could change nullability.
/* 705 */             agg_value178 = agg_value179 + agg_value183;
/* 706 */
/* 707 */           }
/* 708 */           boolean agg_isNull170 = agg_isNull171;
/* 709 */           double agg_value177 = agg_value178;
/* 710 */           if (agg_isNull170) {
/* 711 */             boolean agg_isNull182 = agg_fastAggBuffer.isNullAt(5);
/* 712 */             double agg_value189 = agg_isNull182 ? -1.0 : (agg_fastAggBuffer.getDouble(5));
/* 713 */             if (!agg_isNull182) {
/* 714 */               agg_isNull170 = false;
/* 715 */               agg_value177 = agg_value189;
/* 716 */             }
/* 717 */           }
/* 718 */           boolean agg_isNull184 = true;
/* 719 */           double agg_value191 = -1.0;
/* 720 */
/* 721 */           boolean agg_isNull186 = agg_fastAggBuffer.isNullAt(6);
/* 722 */           double agg_value193 = agg_isNull186 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 723 */           boolean agg_isNull185 = agg_isNull186;
/* 724 */           double agg_value192 = agg_value193;
/* 725 */           if (agg_isNull185) {
/* 726 */             boolean agg_isNull187 = false;
/* 727 */             double agg_value194 = -1.0;
/* 728 */             if (!false) {
/* 729 */               agg_value194 = (double) 0;
/* 730 */             }
/* 731 */             if (!agg_isNull187) {
/* 732 */               agg_isNull185 = false;
/* 733 */               agg_value192 = agg_value194;
/* 734 */             }
/* 735 */           }
/* 736 */
/* 737 */           boolean agg_isNull189 = true;
/* 738 */           double agg_value196 = -1.0;
/* 739 */
/* 740 */           boolean agg_isNull190 = true;
/* 741 */           boolean agg_value197 = false;
/* 742 */
/* 743 */           if (!bhj_isNull3) {
/* 744 */             agg_isNull190 = false; // resultCode could change nullability.
/* 745 */             agg_value197 = bhj_value3.equals(((UTF8String) references[32]));
/* 746 */
/* 747 */           }
/* 748 */           if (!agg_isNull190 && agg_value197) {
/* 749 */             agg_isNull189 = scan_isNull1;
/* 750 */             agg_value196 = scan_value1;
/* 751 */           }
/* 752 */
/* 753 */           else {
/* 754 */             final double agg_value201 = -1.0;
/* 755 */             agg_isNull189 = true;
/* 756 */             agg_value196 = agg_value201;
/* 757 */           }
/* 758 */           if (!agg_isNull189) {
/* 759 */             agg_isNull184 = false; // resultCode could change nullability.
/* 760 */             agg_value191 = agg_value192 + agg_value196;
/* 761 */
/* 762 */           }
/* 763 */           boolean agg_isNull183 = agg_isNull184;
/* 764 */           double agg_value190 = agg_value191;
/* 765 */           if (agg_isNull183) {
/* 766 */             boolean agg_isNull195 = agg_fastAggBuffer.isNullAt(6);
/* 767 */             double agg_value202 = agg_isNull195 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 768 */             if (!agg_isNull195) {
/* 769 */               agg_isNull183 = false;
/* 770 */               agg_value190 = agg_value202;
/* 771 */             }
/* 772 */           }
/* 773 */           // update fast row
/* 774 */           if (!agg_isNull105) {
/* 775 */             agg_fastAggBuffer.setDouble(0, agg_value112);
/* 776 */           } else {
/* 777 */             agg_fastAggBuffer.setNullAt(0);
/* 778 */           }
/* 779 */
/* 780 */           if (!agg_isNull118) {
/* 781 */             agg_fastAggBuffer.setDouble(1, agg_value125);
/* 782 */           } else {
/* 783 */             agg_fastAggBuffer.setNullAt(1);
/* 784 */           }
/* 785 */
/* 786 */           if (!agg_isNull131) {
/* 787 */             agg_fastAggBuffer.setDouble(2, agg_value138);
/* 788 */           } else {
/* 789 */             agg_fastAggBuffer.setNullAt(2);
/* 790 */           }
/* 791 */
/* 792 */           if (!agg_isNull144) {
/* 793 */             agg_fastAggBuffer.setDouble(3, agg_value151);
/* 794 */           } else {
/* 795 */             agg_fastAggBuffer.setNullAt(3);
/* 796 */           }
/* 797 */
/* 798 */           if (!agg_isNull157) {
/* 799 */             agg_fastAggBuffer.setDouble(4, agg_value164);
/* 800 */           } else {
/* 801 */             agg_fastAggBuffer.setNullAt(4);
/* 802 */           }
/* 803 */
/* 804 */           if (!agg_isNull170) {
/* 805 */             agg_fastAggBuffer.setDouble(5, agg_value177);
/* 806 */           } else {
/* 807 */             agg_fastAggBuffer.setNullAt(5);
/* 808 */           }
/* 809 */
/* 810 */           if (!agg_isNull183) {
/* 811 */             agg_fastAggBuffer.setDouble(6, agg_value190);
/* 812 */           } else {
/* 813 */             agg_fastAggBuffer.setNullAt(6);
/* 814 */           }
/* 815 */
/* 816 */         } else {
/* 817 */           // update unsafe row
/* 818 */
/* 819 */           // common sub-expressions
/* 820 */
/* 821 */           // evaluate aggregate function
/* 822 */           boolean agg_isNull15 = true;
/* 823 */           double agg_value22 = -1.0;
/* 824 */
/* 825 */           boolean agg_isNull17 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 826 */           double agg_value24 = agg_isNull17 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 827 */           boolean agg_isNull16 = agg_isNull17;
/* 828 */           double agg_value23 = agg_value24;
/* 829 */           if (agg_isNull16) {
/* 830 */             boolean agg_isNull18 = false;
/* 831 */             double agg_value25 = -1.0;
/* 832 */             if (!false) {
/* 833 */               agg_value25 = (double) 0;
/* 834 */             }
/* 835 */             if (!agg_isNull18) {
/* 836 */               agg_isNull16 = false;
/* 837 */               agg_value23 = agg_value25;
/* 838 */             }
/* 839 */           }
/* 840 */
/* 841 */           boolean agg_isNull20 = true;
/* 842 */           double agg_value27 = -1.0;
/* 843 */
/* 844 */           boolean agg_isNull21 = true;
/* 845 */           boolean agg_value28 = false;
/* 846 */
/* 847 */           if (!bhj_isNull3) {
/* 848 */             agg_isNull21 = false; // resultCode could change nullability.
/* 849 */             agg_value28 = bhj_value3.equals(((UTF8String) references[19]));
/* 850 */
/* 851 */           }
/* 852 */           if (!agg_isNull21 && agg_value28) {
/* 853 */             agg_isNull20 = scan_isNull1;
/* 854 */             agg_value27 = scan_value1;
/* 855 */           }
/* 856 */
/* 857 */           else {
/* 858 */             final double agg_value32 = -1.0;
/* 859 */             agg_isNull20 = true;
/* 860 */             agg_value27 = agg_value32;
/* 861 */           }
/* 862 */           if (!agg_isNull20) {
/* 863 */             agg_isNull15 = false; // resultCode could change nullability.
/* 864 */             agg_value22 = agg_value23 + agg_value27;
/* 865 */
/* 866 */           }
/* 867 */           boolean agg_isNull14 = agg_isNull15;
/* 868 */           double agg_value21 = agg_value22;
/* 869 */           if (agg_isNull14) {
/* 870 */             boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 871 */             double agg_value33 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 872 */             if (!agg_isNull26) {
/* 873 */               agg_isNull14 = false;
/* 874 */               agg_value21 = agg_value33;
/* 875 */             }
/* 876 */           }
/* 877 */           boolean agg_isNull28 = true;
/* 878 */           double agg_value35 = -1.0;
/* 879 */
/* 880 */           boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 881 */           double agg_value37 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 882 */           boolean agg_isNull29 = agg_isNull30;
/* 883 */           double agg_value36 = agg_value37;
/* 884 */           if (agg_isNull29) {
/* 885 */             boolean agg_isNull31 = false;
/* 886 */             double agg_value38 = -1.0;
/* 887 */             if (!false) {
/* 888 */               agg_value38 = (double) 0;
/* 889 */             }
/* 890 */             if (!agg_isNull31) {
/* 891 */               agg_isNull29 = false;
/* 892 */               agg_value36 = agg_value38;
/* 893 */             }
/* 894 */           }
/* 895 */
/* 896 */           boolean agg_isNull33 = true;
/* 897 */           double agg_value40 = -1.0;
/* 898 */
/* 899 */           boolean agg_isNull34 = true;
/* 900 */           boolean agg_value41 = false;
/* 901 */
/* 902 */           if (!bhj_isNull3) {
/* 903 */             agg_isNull34 = false; // resultCode could change nullability.
/* 904 */             agg_value41 = bhj_value3.equals(((UTF8String) references[20]));
/* 905 */
/* 906 */           }
/* 907 */           if (!agg_isNull34 && agg_value41) {
/* 908 */             agg_isNull33 = scan_isNull1;
/* 909 */             agg_value40 = scan_value1;
/* 910 */           }
/* 911 */
/* 912 */           else {
/* 913 */             final double agg_value45 = -1.0;
/* 914 */             agg_isNull33 = true;
/* 915 */             agg_value40 = agg_value45;
/* 916 */           }
/* 917 */           if (!agg_isNull33) {
/* 918 */             agg_isNull28 = false; // resultCode could change nullability.
/* 919 */             agg_value35 = agg_value36 + agg_value40;
/* 920 */
/* 921 */           }
/* 922 */           boolean agg_isNull27 = agg_isNull28;
/* 923 */           double agg_value34 = agg_value35;
/* 924 */           if (agg_isNull27) {
/* 925 */             boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 926 */             double agg_value46 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 927 */             if (!agg_isNull39) {
/* 928 */               agg_isNull27 = false;
/* 929 */               agg_value34 = agg_value46;
/* 930 */             }
/* 931 */           }
/* 932 */           boolean agg_isNull41 = true;
/* 933 */           double agg_value48 = -1.0;
/* 934 */
/* 935 */           boolean agg_isNull43 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 936 */           double agg_value50 = agg_isNull43 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 937 */           boolean agg_isNull42 = agg_isNull43;
/* 938 */           double agg_value49 = agg_value50;
/* 939 */           if (agg_isNull42) {
/* 940 */             boolean agg_isNull44 = false;
/* 941 */             double agg_value51 = -1.0;
/* 942 */             if (!false) {
/* 943 */               agg_value51 = (double) 0;
/* 944 */             }
/* 945 */             if (!agg_isNull44) {
/* 946 */               agg_isNull42 = false;
/* 947 */               agg_value49 = agg_value51;
/* 948 */             }
/* 949 */           }
/* 950 */
/* 951 */           boolean agg_isNull46 = true;
/* 952 */           double agg_value53 = -1.0;
/* 953 */
/* 954 */           boolean agg_isNull47 = true;
/* 955 */           boolean agg_value54 = false;
/* 956 */
/* 957 */           if (!bhj_isNull3) {
/* 958 */             agg_isNull47 = false; // resultCode could change nullability.
/* 959 */             agg_value54 = bhj_value3.equals(((UTF8String) references[21]));
/* 960 */
/* 961 */           }
/* 962 */           if (!agg_isNull47 && agg_value54) {
/* 963 */             agg_isNull46 = scan_isNull1;
/* 964 */             agg_value53 = scan_value1;
/* 965 */           }
/* 966 */
/* 967 */           else {
/* 968 */             final double agg_value58 = -1.0;
/* 969 */             agg_isNull46 = true;
/* 970 */             agg_value53 = agg_value58;
/* 971 */           }
/* 972 */           if (!agg_isNull46) {
/* 973 */             agg_isNull41 = false; // resultCode could change nullability.
/* 974 */             agg_value48 = agg_value49 + agg_value53;
/* 975 */
/* 976 */           }
/* 977 */           boolean agg_isNull40 = agg_isNull41;
/* 978 */           double agg_value47 = agg_value48;
/* 979 */           if (agg_isNull40) {
/* 980 */             boolean agg_isNull52 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 981 */             double agg_value59 = agg_isNull52 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 982 */             if (!agg_isNull52) {
/* 983 */               agg_isNull40 = false;
/* 984 */               agg_value47 = agg_value59;
/* 985 */             }
/* 986 */           }
/* 987 */           boolean agg_isNull54 = true;
/* 988 */           double agg_value61 = -1.0;
/* 989 */
/* 990 */           boolean agg_isNull56 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 991 */           double agg_value63 = agg_isNull56 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 992 */           boolean agg_isNull55 = agg_isNull56;
/* 993 */           double agg_value62 = agg_value63;
/* 994 */           if (agg_isNull55) {
/* 995 */             boolean agg_isNull57 = false;
/* 996 */             double agg_value64 = -1.0;
/* 997 */             if (!false) {
/* 998 */               agg_value64 = (double) 0;
/* 999 */             }
/* 1000 */             if (!agg_isNull57) {
/* 1001 */               agg_isNull55 = false;
/* 1002 */               agg_value62 = agg_value64;
/* 1003 */             }
/* 1004 */           }
/* 1005 */
/* 1006 */           boolean agg_isNull59 = true;
/* 1007 */           double agg_value66 = -1.0;
/* 1008 */
/* 1009 */           boolean agg_isNull60 = true;
/* 1010 */           boolean agg_value67 = false;
/* 1011 */
/* 1012 */           if (!bhj_isNull3) {
/* 1013 */             agg_isNull60 = false; // resultCode could change nullability.
/* 1014 */             agg_value67 = bhj_value3.equals(((UTF8String) references[22]));
/* 1015 */
/* 1016 */           }
/* 1017 */           if (!agg_isNull60 && agg_value67) {
/* 1018 */             agg_isNull59 = scan_isNull1;
/* 1019 */             agg_value66 = scan_value1;
/* 1020 */           }
/* 1021 */
/* 1022 */           else {
/* 1023 */             final double agg_value71 = -1.0;
/* 1024 */             agg_isNull59 = true;
/* 1025 */             agg_value66 = agg_value71;
/* 1026 */           }
/* 1027 */           if (!agg_isNull59) {
/* 1028 */             agg_isNull54 = false; // resultCode could change nullability.
/* 1029 */             agg_value61 = agg_value62 + agg_value66;
/* 1030 */
/* 1031 */           }
/* 1032 */           boolean agg_isNull53 = agg_isNull54;
/* 1033 */           double agg_value60 = agg_value61;
/* 1034 */           if (agg_isNull53) {
/* 1035 */             boolean agg_isNull65 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 1036 */             double agg_value72 = agg_isNull65 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 1037 */             if (!agg_isNull65) {
/* 1038 */               agg_isNull53 = false;
/* 1039 */               agg_value60 = agg_value72;
/* 1040 */             }
/* 1041 */           }
/* 1042 */           boolean agg_isNull67 = true;
/* 1043 */           double agg_value74 = -1.0;
/* 1044 */
/* 1045 */           boolean agg_isNull69 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 1046 */           double agg_value76 = agg_isNull69 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 1047 */           boolean agg_isNull68 = agg_isNull69;
/* 1048 */           double agg_value75 = agg_value76;
/* 1049 */           if (agg_isNull68) {
/* 1050 */             boolean agg_isNull70 = false;
/* 1051 */             double agg_value77 = -1.0;
/* 1052 */             if (!false) {
/* 1053 */               agg_value77 = (double) 0;
/* 1054 */             }
/* 1055 */             if (!agg_isNull70) {
/* 1056 */               agg_isNull68 = false;
/* 1057 */               agg_value75 = agg_value77;
/* 1058 */             }
/* 1059 */           }
/* 1060 */
/* 1061 */           boolean agg_isNull72 = true;
/* 1062 */           double agg_value79 = -1.0;
/* 1063 */
/* 1064 */           boolean agg_isNull73 = true;
/* 1065 */           boolean agg_value80 = false;
/* 1066 */
/* 1067 */           if (!bhj_isNull3) {
/* 1068 */             agg_isNull73 = false; // resultCode could change nullability.
/* 1069 */             agg_value80 = bhj_value3.equals(((UTF8String) references[23]));
/* 1070 */
/* 1071 */           }
/* 1072 */           if (!agg_isNull73 && agg_value80) {
/* 1073 */             agg_isNull72 = scan_isNull1;
/* 1074 */             agg_value79 = scan_value1;
/* 1075 */           }
/* 1076 */
/* 1077 */           else {
/* 1078 */             final double agg_value84 = -1.0;
/* 1079 */             agg_isNull72 = true;
/* 1080 */             agg_value79 = agg_value84;
/* 1081 */           }
/* 1082 */           if (!agg_isNull72) {
/* 1083 */             agg_isNull67 = false; // resultCode could change nullability.
/* 1084 */             agg_value74 = agg_value75 + agg_value79;
/* 1085 */
/* 1086 */           }
/* 1087 */           boolean agg_isNull66 = agg_isNull67;
/* 1088 */           double agg_value73 = agg_value74;
/* 1089 */           if (agg_isNull66) {
/* 1090 */             boolean agg_isNull78 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 1091 */             double agg_value85 = agg_isNull78 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 1092 */             if (!agg_isNull78) {
/* 1093 */               agg_isNull66 = false;
/* 1094 */               agg_value73 = agg_value85;
/* 1095 */             }
/* 1096 */           }
/* 1097 */           boolean agg_isNull80 = true;
/* 1098 */           double agg_value87 = -1.0;
/* 1099 */
/* 1100 */           boolean agg_isNull82 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 1101 */           double agg_value89 = agg_isNull82 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 1102 */           boolean agg_isNull81 = agg_isNull82;
/* 1103 */           double agg_value88 = agg_value89;
/* 1104 */           if (agg_isNull81) {
/* 1105 */             boolean agg_isNull83 = false;
/* 1106 */             double agg_value90 = -1.0;
/* 1107 */             if (!false) {
/* 1108 */               agg_value90 = (double) 0;
/* 1109 */             }
/* 1110 */             if (!agg_isNull83) {
/* 1111 */               agg_isNull81 = false;
/* 1112 */               agg_value88 = agg_value90;
/* 1113 */             }
/* 1114 */           }
/* 1115 */
/* 1116 */           boolean agg_isNull85 = true;
/* 1117 */           double agg_value92 = -1.0;
/* 1118 */
/* 1119 */           boolean agg_isNull86 = true;
/* 1120 */           boolean agg_value93 = false;
/* 1121 */
/* 1122 */           if (!bhj_isNull3) {
/* 1123 */             agg_isNull86 = false; // resultCode could change nullability.
/* 1124 */             agg_value93 = bhj_value3.equals(((UTF8String) references[24]));
/* 1125 */
/* 1126 */           }
/* 1127 */           if (!agg_isNull86 && agg_value93) {
/* 1128 */             agg_isNull85 = scan_isNull1;
/* 1129 */             agg_value92 = scan_value1;
/* 1130 */           }
/* 1131 */
/* 1132 */           else {
/* 1133 */             final double agg_value97 = -1.0;
/* 1134 */             agg_isNull85 = true;
/* 1135 */             agg_value92 = agg_value97;
/* 1136 */           }
/* 1137 */           if (!agg_isNull85) {
/* 1138 */             agg_isNull80 = false; // resultCode could change nullability.
/* 1139 */             agg_value87 = agg_value88 + agg_value92;
/* 1140 */
/* 1141 */           }
/* 1142 */           boolean agg_isNull79 = agg_isNull80;
/* 1143 */           double agg_value86 = agg_value87;
/* 1144 */           if (agg_isNull79) {
/* 1145 */             boolean agg_isNull91 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 1146 */             double agg_value98 = agg_isNull91 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 1147 */             if (!agg_isNull91) {
/* 1148 */               agg_isNull79 = false;
/* 1149 */               agg_value86 = agg_value98;
/* 1150 */             }
/* 1151 */           }
/* 1152 */           boolean agg_isNull93 = true;
/* 1153 */           double agg_value100 = -1.0;
/* 1154 */
/* 1155 */           boolean agg_isNull95 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 1156 */           double agg_value102 = agg_isNull95 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 1157 */           boolean agg_isNull94 = agg_isNull95;
/* 1158 */           double agg_value101 = agg_value102;
/* 1159 */           if (agg_isNull94) {
/* 1160 */             boolean agg_isNull96 = false;
/* 1161 */             double agg_value103 = -1.0;
/* 1162 */             if (!false) {
/* 1163 */               agg_value103 = (double) 0;
/* 1164 */             }
/* 1165 */             if (!agg_isNull96) {
/* 1166 */               agg_isNull94 = false;
/* 1167 */               agg_value101 = agg_value103;
/* 1168 */             }
/* 1169 */           }
/* 1170 */
/* 1171 */           boolean agg_isNull98 = true;
/* 1172 */           double agg_value105 = -1.0;
/* 1173 */
/* 1174 */           boolean agg_isNull99 = true;
/* 1175 */           boolean agg_value106 = false;
/* 1176 */
/* 1177 */           if (!bhj_isNull3) {
/* 1178 */             agg_isNull99 = false; // resultCode could change nullability.
/* 1179 */             agg_value106 = bhj_value3.equals(((UTF8String) references[25]));
/* 1180 */
/* 1181 */           }
/* 1182 */           if (!agg_isNull99 && agg_value106) {
/* 1183 */             agg_isNull98 = scan_isNull1;
/* 1184 */             agg_value105 = scan_value1;
/* 1185 */           }
/* 1186 */
/* 1187 */           else {
/* 1188 */             final double agg_value110 = -1.0;
/* 1189 */             agg_isNull98 = true;
/* 1190 */             agg_value105 = agg_value110;
/* 1191 */           }
/* 1192 */           if (!agg_isNull98) {
/* 1193 */             agg_isNull93 = false; // resultCode could change nullability.
/* 1194 */             agg_value100 = agg_value101 + agg_value105;
/* 1195 */
/* 1196 */           }
/* 1197 */           boolean agg_isNull92 = agg_isNull93;
/* 1198 */           double agg_value99 = agg_value100;
/* 1199 */           if (agg_isNull92) {
/* 1200 */             boolean agg_isNull104 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 1201 */             double agg_value111 = agg_isNull104 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 1202 */             if (!agg_isNull104) {
/* 1203 */               agg_isNull92 = false;
/* 1204 */               agg_value99 = agg_value111;
/* 1205 */             }
/* 1206 */           }
/* 1207 */           // update unsafe row buffer
/* 1208 */           if (!agg_isNull14) {
/* 1209 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value21);
/* 1210 */           } else {
/* 1211 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 1212 */           }
/* 1213 */
/* 1214 */           if (!agg_isNull27) {
/* 1215 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value34);
/* 1216 */           } else {
/* 1217 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 1218 */           }
/* 1219 */
/* 1220 */           if (!agg_isNull40) {
/* 1221 */             agg_unsafeRowAggBuffer.setDouble(2, agg_value47);
/* 1222 */           } else {
/* 1223 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 1224 */           }
/* 1225 */
/* 1226 */           if (!agg_isNull53) {
/* 1227 */             agg_unsafeRowAggBuffer.setDouble(3, agg_value60);
/* 1228 */           } else {
/* 1229 */             agg_unsafeRowAggBuffer.setNullAt(3);
/* 1230 */           }
/* 1231 */
/* 1232 */           if (!agg_isNull66) {
/* 1233 */             agg_unsafeRowAggBuffer.setDouble(4, agg_value73);
/* 1234 */           } else {
/* 1235 */             agg_unsafeRowAggBuffer.setNullAt(4);
/* 1236 */           }
/* 1237 */
/* 1238 */           if (!agg_isNull79) {
/* 1239 */             agg_unsafeRowAggBuffer.setDouble(5, agg_value86);
/* 1240 */           } else {
/* 1241 */             agg_unsafeRowAggBuffer.setNullAt(5);
/* 1242 */           }
/* 1243 */
/* 1244 */           if (!agg_isNull92) {
/* 1245 */             agg_unsafeRowAggBuffer.setDouble(6, agg_value99);
/* 1246 */           } else {
/* 1247 */             agg_unsafeRowAggBuffer.setNullAt(6);
/* 1248 */           }
/* 1249 */
/* 1250 */         }
/* 1251 */         // shouldStop check is eliminated
/* 1252 */       }
/* 1253 */       scan_batchIdx = scan_numRows;
/* 1254 */       scan_batch = null;
/* 1255 */       scan_nextBatch();
/* 1256 */     }
/* 1257 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 1258 */     scan_scanTime1 = 0;
/* 1259 */
/* 1260 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 1261 */
/* 1262 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1263 */   }
/* 1264 */
/* 1265 */   private void wholestagecodegen_init_2() {
/* 1266 */     project_result1 = new UnsafeRow(3);
/* 1267 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 1268 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 3);
/* 1269 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[17];
/* 1270 */
/* 1271 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 1272 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 1273 */
/* 1274 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 1275 */     bhj_result1 = new UnsafeRow(6);
/* 1276 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 96);
/* 1277 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 1278 */     project_result2 = new UnsafeRow(4);
/* 1279 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 96);
/* 1280 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 4);
/* 1281 */
/* 1282 */   }
/* 1283 */
/* 1284 */   private void wholestagecodegen_init_1() {
/* 1285 */     filter_result = new UnsafeRow(3);
/* 1286 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 1287 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 1288 */     project_result = new UnsafeRow(3);
/* 1289 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 1290 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 1291 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 1292 */
/* 1293 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1294 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1295 */
/* 1296 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 1297 */     bhj_result = new UnsafeRow(5);
/* 1298 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 1299 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 5);
/* 1300 */
/* 1301 */   }
/* 1302 */
/* 1303 */   protected void processNext() throws java.io.IOException {
/* 1304 */     if (!agg_initAgg) {
/* 1305 */       agg_initAgg = true;
/* 1306 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1307 */       agg_doAggregateWithKeys();
/* 1308 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1309 */     }
/* 1310 */
/* 1311 */     // output the result
/* 1312 */
/* 1313 */     while (agg_fastHashMapIter.next()) {
/* 1314 */       wholestagecodegen_numOutputRows.add(1);
/* 1315 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1316 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1317 */
/* 1318 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1319 */
/* 1320 */       append(agg_resultRow);
/* 1321 */
/* 1322 */       if (shouldStop()) return;
/* 1323 */     }
/* 1324 */     agg_fastHashMap.close();
/* 1325 */
/* 1326 */     while (agg_mapIter.next()) {
/* 1327 */       wholestagecodegen_numOutputRows.add(1);
/* 1328 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1329 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1330 */
/* 1331 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1332 */
/* 1333 */       append(agg_resultRow);
/* 1334 */
/* 1335 */       if (shouldStop()) return;
/* 1336 */     }
/* 1337 */
/* 1338 */     agg_mapIter.close();
/* 1339 */     if (agg_sorter == null) {
/* 1340 */       agg_hashMap.free();
/* 1341 */     }
/* 1342 */   }
/* 1343 */ }

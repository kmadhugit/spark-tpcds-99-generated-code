/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
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
/* 027 */   private UnsafeRow scan_result;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 031 */   private UnsafeRow filter_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 034 */   private UnsafeRow project_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 037 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 038 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 040 */   private UnsafeRow bhj_result;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 043 */   private UnsafeRow project_result1;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 046 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 047 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 048 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 049 */   private UnsafeRow bhj_result1;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 051 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 052 */   private UnsafeRow project_result2;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 055 */   private UnsafeRow agg_result3;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 058 */   private int agg_value14;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 060 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 061 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 062 */
/* 063 */   public GeneratedIterator(Object[] references) {
/* 064 */     this.references = references;
/* 065 */   }
/* 066 */
/* 067 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 068 */     partitionIndex = index;
/* 069 */     this.inputs = inputs;
/* 070 */     wholestagecodegen_init_0();
/* 071 */     wholestagecodegen_init_1();
/* 072 */     wholestagecodegen_init_2();
/* 073 */     wholestagecodegen_init_3();
/* 074 */
/* 075 */   }
/* 076 */
/* 077 */   private void wholestagecodegen_init_0() {
/* 078 */     agg_initAgg = false;
/* 079 */
/* 080 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 081 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 082 */
/* 083 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 084 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 085 */     scan_input = inputs[0];
/* 086 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 087 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 088 */     scan_scanTime1 = 0;
/* 089 */     scan_batch = null;
/* 090 */     scan_batchIdx = 0;
/* 091 */     scan_colInstance0 = null;
/* 092 */     scan_colInstance1 = null;
/* 093 */     scan_result = new UnsafeRow(2);
/* 094 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 095 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 2);
/* 096 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 097 */
/* 098 */   }
/* 099 */
/* 100 */   private void wholestagecodegen_init_3() {
/* 101 */     agg_result3 = new UnsafeRow(3);
/* 102 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 64);
/* 103 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 104 */
/* 105 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 106 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 107 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 108 */
/* 109 */   }
/* 110 */
/* 111 */   private void scan_nextBatch() throws java.io.IOException {
/* 112 */     long getBatchStart = System.nanoTime();
/* 113 */     if (scan_input.hasNext()) {
/* 114 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 115 */       scan_numOutputRows.add(scan_batch.numRows());
/* 116 */       scan_batchIdx = 0;
/* 117 */       scan_colInstance0 = scan_batch.column(0);
/* 118 */       scan_colInstance1 = scan_batch.column(1);
/* 119 */
/* 120 */     }
/* 121 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 122 */   }
/* 123 */
/* 124 */   public class agg_FastHashMap {
/* 125 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 126 */     private int[] buckets;
/* 127 */     private int capacity = 1 << 16;
/* 128 */     private double loadFactor = 0.5;
/* 129 */     private int numBuckets = (int) (capacity / loadFactor);
/* 130 */     private int maxSteps = 2;
/* 131 */     private int numRows = 0;
/* 132 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 133 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 134 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.StringType);
/* 135 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.LongType);
/* 136 */     private Object emptyVBase;
/* 137 */     private long emptyVOff;
/* 138 */     private int emptyVLen;
/* 139 */     private boolean isBatchFull = false;
/* 140 */
/* 141 */     public agg_FastHashMap(
/* 142 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 143 */       InternalRow emptyAggregationBuffer) {
/* 144 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 145 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 146 */
/* 147 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 148 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 149 */
/* 150 */       emptyVBase = emptyBuffer;
/* 151 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 152 */       emptyVLen = emptyBuffer.length;
/* 153 */
/* 154 */       buckets = new int[numBuckets];
/* 155 */       java.util.Arrays.fill(buckets, -1);
/* 156 */     }
/* 157 */
/* 158 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, int agg_key1, UTF8String agg_key2) {
/* 159 */       long h = hash(agg_key, agg_key1, agg_key2);
/* 160 */       int step = 0;
/* 161 */       int idx = (int) h & (numBuckets - 1);
/* 162 */       while (step < maxSteps) {
/* 163 */         // Return bucket index if it's either an empty slot or already contains the key
/* 164 */         if (buckets[idx] == -1) {
/* 165 */           if (numRows < capacity && !isBatchFull) {
/* 166 */             // creating the unsafe for new entry
/* 167 */             UnsafeRow agg_result = new UnsafeRow(3);
/* 168 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 169 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 170 */               64);
/* 171 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 172 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 173 */               agg_holder,
/* 174 */               3);
/* 175 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 176 */             agg_rowWriter.zeroOutNullBytes();
/* 177 */             agg_rowWriter.write(0, agg_key);
/* 178 */             agg_rowWriter.write(1, agg_key1);
/* 179 */             agg_rowWriter.write(2, agg_key2);
/* 180 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 181 */             Object kbase = agg_result.getBaseObject();
/* 182 */             long koff = agg_result.getBaseOffset();
/* 183 */             int klen = agg_result.getSizeInBytes();
/* 184 */
/* 185 */             UnsafeRow vRow
/* 186 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 187 */             if (vRow == null) {
/* 188 */               isBatchFull = true;
/* 189 */             } else {
/* 190 */               buckets[idx] = numRows++;
/* 191 */             }
/* 192 */             return vRow;
/* 193 */           } else {
/* 194 */             // No more space
/* 195 */             return null;
/* 196 */           }
/* 197 */         } else if (equals(idx, agg_key, agg_key1, agg_key2)) {
/* 198 */           return batch.getValueRow(buckets[idx]);
/* 199 */         }
/* 200 */         idx = (idx + 1) & (numBuckets - 1);
/* 201 */         step++;
/* 202 */       }
/* 203 */       // Didn't find it
/* 204 */       return null;
/* 205 */     }
/* 206 */
/* 207 */     private boolean equals(int idx, UTF8String agg_key, int agg_key1, UTF8String agg_key2) {
/* 208 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 209 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getInt(1) == agg_key1) && (row.getUTF8String(2).equals(agg_key2));
/* 210 */     }
/* 211 */
/* 212 */     private long hash(UTF8String agg_key, int agg_key1, UTF8String agg_key2) {
/* 213 */       long agg_hash = 0;
/* 214 */
/* 215 */       int agg_result = 0;
/* 216 */       byte[] agg_bytes = agg_key.getBytes();
/* 217 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 218 */         int agg_hash1 = agg_bytes[i];
/* 219 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 220 */       }
/* 221 */
/* 222 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 223 */
/* 224 */       int agg_result1 = agg_key1;
/* 225 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 226 */
/* 227 */       int agg_result2 = 0;
/* 228 */       byte[] agg_bytes1 = agg_key2.getBytes();
/* 229 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 230 */         int agg_hash2 = agg_bytes1[i];
/* 231 */         agg_result2 = (agg_result2 ^ (0x9e3779b9)) + agg_hash2 + (agg_result2 << 6) + (agg_result2 >>> 2);
/* 232 */       }
/* 233 */
/* 234 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 235 */
/* 236 */       return agg_hash;
/* 237 */     }
/* 238 */
/* 239 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 240 */       return batch.rowIterator();
/* 241 */     }
/* 242 */
/* 243 */     public void close() {
/* 244 */       batch.close();
/* 245 */     }
/* 246 */
/* 247 */   }
/* 248 */
/* 249 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 250 */     agg_hashMap = agg_plan.createHashMap();
/* 251 */
/* 252 */     if (scan_batch == null) {
/* 253 */       scan_nextBatch();
/* 254 */     }
/* 255 */     while (scan_batch != null) {
/* 256 */       int scan_numRows = scan_batch.numRows();
/* 257 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 258 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 259 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 260 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 261 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 262 */
/* 263 */         if (!(!(scan_isNull))) continue;
/* 264 */
/* 265 */         filter_numOutputRows.add(1);
/* 266 */
/* 267 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 268 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 269 */
/* 270 */         // generate join key for stream side
/* 271 */
/* 272 */         boolean bhj_isNull = scan_isNull1;
/* 273 */         long bhj_value = -1L;
/* 274 */         if (!scan_isNull1) {
/* 275 */           bhj_value = (long) scan_value1;
/* 276 */         }
/* 277 */         // find matches from HashedRelation
/* 278 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 279 */         if (bhj_matched == null) continue;
/* 280 */
/* 281 */         bhj_numOutputRows.add(1);
/* 282 */
/* 283 */         // generate join key for stream side
/* 284 */
/* 285 */         boolean bhj_isNull8 = false;
/* 286 */         long bhj_value8 = -1L;
/* 287 */         if (!false) {
/* 288 */           bhj_value8 = (long) scan_value;
/* 289 */         }
/* 290 */         // find matches from HashedRelation
/* 291 */         UnsafeRow bhj_matched1 = bhj_isNull8 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value8);
/* 292 */         if (bhj_matched1 == null) continue;
/* 293 */
/* 294 */         bhj_numOutputRows1.add(1);
/* 295 */
/* 296 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 297 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 298 */         boolean bhj_isNull10 = bhj_matched1.isNullAt(0);
/* 299 */         int bhj_value10 = bhj_isNull10 ? -1 : (bhj_matched1.getInt(0));
/* 300 */         boolean bhj_isNull11 = bhj_matched1.isNullAt(1);
/* 301 */         UTF8String bhj_value11 = bhj_isNull11 ? null : (bhj_matched1.getUTF8String(1));
/* 302 */
/* 303 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 304 */
/* 305 */         UnsafeRow agg_fastAggBuffer = null;
/* 306 */
/* 307 */         if (true) {
/* 308 */           boolean agg_isNull7 = true;
/* 309 */           UTF8String agg_value8 = null;
/* 310 */
/* 311 */           if (!bhj_isNull11) {
/* 312 */             agg_isNull7 = false; // resultCode could change nullability.
/* 313 */             agg_value8 = bhj_value11.substringSQL(1, 30);
/* 314 */
/* 315 */           }
/* 316 */
/* 317 */           if (!agg_isNull7 && !bhj_isNull10 && !bhj_isNull3) {
/* 318 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 319 */               agg_value8, bhj_value10, bhj_value3);
/* 320 */           }
/* 321 */         }
/* 322 */
/* 323 */         if (agg_fastAggBuffer == null) {
/* 324 */           // generate grouping key
/* 325 */           agg_holder.reset();
/* 326 */
/* 327 */           agg_rowWriter.zeroOutNullBytes();
/* 328 */
/* 329 */           boolean agg_isNull1 = true;
/* 330 */           UTF8String agg_value2 = null;
/* 331 */
/* 332 */           if (!bhj_isNull11) {
/* 333 */             agg_isNull1 = false; // resultCode could change nullability.
/* 334 */             agg_value2 = bhj_value11.substringSQL(1, 30);
/* 335 */
/* 336 */           }
/* 337 */           if (agg_isNull1) {
/* 338 */             agg_rowWriter.setNullAt(0);
/* 339 */           } else {
/* 340 */             agg_rowWriter.write(0, agg_value2);
/* 341 */           }
/* 342 */
/* 343 */           if (bhj_isNull10) {
/* 344 */             agg_rowWriter.setNullAt(1);
/* 345 */           } else {
/* 346 */             agg_rowWriter.write(1, bhj_value10);
/* 347 */           }
/* 348 */
/* 349 */           if (bhj_isNull3) {
/* 350 */             agg_rowWriter.setNullAt(2);
/* 351 */           } else {
/* 352 */             agg_rowWriter.write(2, bhj_value3);
/* 353 */           }
/* 354 */           agg_result3.setTotalSize(agg_holder.totalSize());
/* 355 */           agg_value14 = 42;
/* 356 */
/* 357 */           boolean agg_isNull14 = true;
/* 358 */           UTF8String agg_value15 = null;
/* 359 */
/* 360 */           if (!bhj_isNull11) {
/* 361 */             agg_isNull14 = false; // resultCode could change nullability.
/* 362 */             agg_value15 = bhj_value11.substringSQL(1, 30);
/* 363 */
/* 364 */           }
/* 365 */           if (!agg_isNull14) {
/* 366 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(agg_value15.getBaseObject(), agg_value15.getBaseOffset(), agg_value15.numBytes(), agg_value14);
/* 367 */           }
/* 368 */
/* 369 */           if (!bhj_isNull10) {
/* 370 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value10, agg_value14);
/* 371 */           }
/* 372 */
/* 373 */           if (!bhj_isNull3) {
/* 374 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value14);
/* 375 */           }
/* 376 */           if (true) {
/* 377 */             // try to get the buffer from hash map
/* 378 */             agg_unsafeRowAggBuffer =
/* 379 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value14);
/* 380 */           }
/* 381 */           if (agg_unsafeRowAggBuffer == null) {
/* 382 */             if (agg_sorter == null) {
/* 383 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 384 */             } else {
/* 385 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 386 */             }
/* 387 */
/* 388 */             // the hash map had be spilled, it should have enough memory now,
/* 389 */             // try  to allocate buffer again.
/* 390 */             agg_unsafeRowAggBuffer =
/* 391 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value14);
/* 392 */             if (agg_unsafeRowAggBuffer == null) {
/* 393 */               // failed to allocate the first page
/* 394 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 395 */             }
/* 396 */           }
/* 397 */         }
/* 398 */
/* 399 */         if (agg_fastAggBuffer != null) {
/* 400 */           // update fast row
/* 401 */
/* 402 */           // common sub-expressions
/* 403 */
/* 404 */           // evaluate aggregate function
/* 405 */           boolean agg_isNull23 = false;
/* 406 */
/* 407 */           long agg_value25 = agg_fastAggBuffer.getLong(0);
/* 408 */
/* 409 */           long agg_value24 = -1L;
/* 410 */           agg_value24 = agg_value25 + 1L;
/* 411 */           // update fast row
/* 412 */           agg_fastAggBuffer.setLong(0, agg_value24);
/* 413 */
/* 414 */         } else {
/* 415 */           // update unsafe row
/* 416 */
/* 417 */           // common sub-expressions
/* 418 */
/* 419 */           // evaluate aggregate function
/* 420 */           boolean agg_isNull20 = false;
/* 421 */
/* 422 */           long agg_value22 = agg_unsafeRowAggBuffer.getLong(0);
/* 423 */
/* 424 */           long agg_value21 = -1L;
/* 425 */           agg_value21 = agg_value22 + 1L;
/* 426 */           // update unsafe row buffer
/* 427 */           agg_unsafeRowAggBuffer.setLong(0, agg_value21);
/* 428 */
/* 429 */         }
/* 430 */         // shouldStop check is eliminated
/* 431 */       }
/* 432 */       scan_batchIdx = scan_numRows;
/* 433 */       scan_batch = null;
/* 434 */       scan_nextBatch();
/* 435 */     }
/* 436 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 437 */     scan_scanTime1 = 0;
/* 438 */
/* 439 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 440 */
/* 441 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 442 */   }
/* 443 */
/* 444 */   private void wholestagecodegen_init_2() {
/* 445 */     project_result1 = new UnsafeRow(2);
/* 446 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 447 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 448 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 449 */
/* 450 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 451 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 452 */
/* 453 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 454 */     bhj_result1 = new UnsafeRow(4);
/* 455 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 456 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 4);
/* 457 */     project_result2 = new UnsafeRow(3);
/* 458 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 459 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 3);
/* 460 */
/* 461 */   }
/* 462 */
/* 463 */   private void wholestagecodegen_init_1() {
/* 464 */     filter_result = new UnsafeRow(2);
/* 465 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 466 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 2);
/* 467 */     project_result = new UnsafeRow(2);
/* 468 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 469 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 470 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 471 */
/* 472 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 473 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 474 */
/* 475 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 476 */     bhj_result = new UnsafeRow(4);
/* 477 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 478 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 479 */
/* 480 */   }
/* 481 */
/* 482 */   protected void processNext() throws java.io.IOException {
/* 483 */     if (!agg_initAgg) {
/* 484 */       agg_initAgg = true;
/* 485 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 486 */       agg_doAggregateWithKeys();
/* 487 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 488 */     }
/* 489 */
/* 490 */     // output the result
/* 491 */
/* 492 */     while (agg_fastHashMapIter.next()) {
/* 493 */       wholestagecodegen_numOutputRows.add(1);
/* 494 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 495 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 496 */
/* 497 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 498 */
/* 499 */       append(agg_resultRow);
/* 500 */
/* 501 */       if (shouldStop()) return;
/* 502 */     }
/* 503 */     agg_fastHashMap.close();
/* 504 */
/* 505 */     while (agg_mapIter.next()) {
/* 506 */       wholestagecodegen_numOutputRows.add(1);
/* 507 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 508 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 509 */
/* 510 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 511 */
/* 512 */       append(agg_resultRow);
/* 513 */
/* 514 */       if (shouldStop()) return;
/* 515 */     }
/* 516 */
/* 517 */     agg_mapIter.close();
/* 518 */     if (agg_sorter == null) {
/* 519 */       agg_hashMap.free();
/* 520 */     }
/* 521 */   }
/* 522 */ }

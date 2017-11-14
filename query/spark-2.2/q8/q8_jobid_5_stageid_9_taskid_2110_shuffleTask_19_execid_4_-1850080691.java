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
/* 056 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 057 */   private org.apache.spark.sql.execution.joins.UnsafeHashedRelation bhj_relation2;
/* 058 */   private UnsafeRow bhj_result2;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 061 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 062 */   private UnsafeRow bhj_result3;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 065 */   private UnsafeRow project_result3;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 068 */   private UnsafeRow agg_result1;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 071 */   private int agg_value4;
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
/* 100 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 101 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 102 */     scan_scanTime1 = 0;
/* 103 */     scan_batch = null;
/* 104 */     scan_batchIdx = 0;
/* 105 */     scan_colInstance0 = null;
/* 106 */     scan_colInstance1 = null;
/* 107 */     scan_colInstance2 = null;
/* 108 */     scan_result = new UnsafeRow(3);
/* 109 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 110 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 111 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 112 */
/* 113 */   }
/* 114 */
/* 115 */   private void wholestagecodegen_init_3() {
/* 116 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 117 */
/* 118 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.UnsafeHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 119 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 120 */
/* 121 */     bhj_result2 = new UnsafeRow(1);
/* 122 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 32);
/* 123 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 1);
/* 124 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 125 */     bhj_result3 = new UnsafeRow(4);
/* 126 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 96);
/* 127 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 4);
/* 128 */     project_result3 = new UnsafeRow(2);
/* 129 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 32);
/* 130 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 2);
/* 131 */
/* 132 */   }
/* 133 */
/* 134 */   private void scan_nextBatch() throws java.io.IOException {
/* 135 */     long getBatchStart = System.nanoTime();
/* 136 */     if (scan_input.hasNext()) {
/* 137 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 138 */       scan_numOutputRows.add(scan_batch.numRows());
/* 139 */       scan_batchIdx = 0;
/* 140 */       scan_colInstance0 = scan_batch.column(0);
/* 141 */       scan_colInstance1 = scan_batch.column(1);
/* 142 */       scan_colInstance2 = scan_batch.column(2);
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
/* 273 */         filter_numOutputRows.add(1);
/* 274 */
/* 275 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 276 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 277 */
/* 278 */         // generate join key for stream side
/* 279 */
/* 280 */         boolean bhj_isNull = scan_isNull2;
/* 281 */         long bhj_value = -1L;
/* 282 */         if (!scan_isNull2) {
/* 283 */           bhj_value = (long) scan_value2;
/* 284 */         }
/* 285 */         // find matches from HashedRelation
/* 286 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 287 */         if (bhj_matched == null) continue;
/* 288 */
/* 289 */         bhj_numOutputRows.add(1);
/* 290 */
/* 291 */         // generate join key for stream side
/* 292 */
/* 293 */         boolean bhj_isNull7 = false;
/* 294 */         long bhj_value7 = -1L;
/* 295 */         if (!false) {
/* 296 */           bhj_value7 = (long) scan_value;
/* 297 */         }
/* 298 */         // find matches from HashedRelation
/* 299 */         UnsafeRow bhj_matched1 = bhj_isNull7 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value7);
/* 300 */         if (bhj_matched1 == null) continue;
/* 301 */
/* 302 */         bhj_numOutputRows1.add(1);
/* 303 */
/* 304 */         boolean bhj_isNull11 = bhj_matched1.isNullAt(2);
/* 305 */         UTF8String bhj_value11 = bhj_isNull11 ? null : (bhj_matched1.getUTF8String(2));
/* 306 */
/* 307 */         // generate join key for stream side
/* 308 */
/* 309 */         bhj_holder2.reset();
/* 310 */
/* 311 */         bhj_rowWriter2.zeroOutNullBytes();
/* 312 */
/* 313 */         boolean bhj_isNull17 = true;
/* 314 */         UTF8String bhj_value17 = null;
/* 315 */
/* 316 */         if (!bhj_isNull11) {
/* 317 */           bhj_isNull17 = false; // resultCode could change nullability.
/* 318 */           bhj_value17 = bhj_value11.substringSQL(1, 2);
/* 319 */
/* 320 */         }
/* 321 */         if (bhj_isNull17) {
/* 322 */           bhj_rowWriter2.setNullAt(0);
/* 323 */         } else {
/* 324 */           bhj_rowWriter2.write(0, bhj_value17);
/* 325 */         }
/* 326 */         bhj_result2.setTotalSize(bhj_holder2.totalSize());
/* 327 */
/* 328 */         // find matches from HashRelation
/* 329 */         scala.collection.Iterator bhj_matches = bhj_result2.anyNull() ? null : (scala.collection.Iterator)bhj_relation2.get(bhj_result2);
/* 330 */         if (bhj_matches == null) continue;
/* 331 */         while (bhj_matches.hasNext()) {
/* 332 */           UnsafeRow bhj_matched2 = (UnsafeRow) bhj_matches.next();
/* 333 */
/* 334 */           bhj_numOutputRows2.add(1);
/* 335 */
/* 336 */           boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 337 */           double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 338 */           boolean bhj_isNull10 = bhj_matched1.isNullAt(1);
/* 339 */           UTF8String bhj_value10 = bhj_isNull10 ? null : (bhj_matched1.getUTF8String(1));
/* 340 */
/* 341 */           UnsafeRow agg_unsafeRowAggBuffer = null;
/* 342 */
/* 343 */           UnsafeRow agg_fastAggBuffer = null;
/* 344 */
/* 345 */           if (true) {
/* 346 */             if (!bhj_isNull10) {
/* 347 */               agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 348 */                 bhj_value10);
/* 349 */             }
/* 350 */           }
/* 351 */
/* 352 */           if (agg_fastAggBuffer == null) {
/* 353 */             // generate grouping key
/* 354 */             agg_holder.reset();
/* 355 */
/* 356 */             agg_rowWriter.zeroOutNullBytes();
/* 357 */
/* 358 */             if (bhj_isNull10) {
/* 359 */               agg_rowWriter.setNullAt(0);
/* 360 */             } else {
/* 361 */               agg_rowWriter.write(0, bhj_value10);
/* 362 */             }
/* 363 */             agg_result1.setTotalSize(agg_holder.totalSize());
/* 364 */             agg_value4 = 42;
/* 365 */
/* 366 */             if (!bhj_isNull10) {
/* 367 */               agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value10.getBaseObject(), bhj_value10.getBaseOffset(), bhj_value10.numBytes(), agg_value4);
/* 368 */             }
/* 369 */             if (true) {
/* 370 */               // try to get the buffer from hash map
/* 371 */               agg_unsafeRowAggBuffer =
/* 372 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 373 */             }
/* 374 */             if (agg_unsafeRowAggBuffer == null) {
/* 375 */               if (agg_sorter == null) {
/* 376 */                 agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 377 */               } else {
/* 378 */                 agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 379 */               }
/* 380 */
/* 381 */               // the hash map had be spilled, it should have enough memory now,
/* 382 */               // try  to allocate buffer again.
/* 383 */               agg_unsafeRowAggBuffer =
/* 384 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value4);
/* 385 */               if (agg_unsafeRowAggBuffer == null) {
/* 386 */                 // failed to allocate the first page
/* 387 */                 throw new OutOfMemoryError("No enough memory for aggregation");
/* 388 */               }
/* 389 */             }
/* 390 */           }
/* 391 */
/* 392 */           if (agg_fastAggBuffer != null) {
/* 393 */             // update fast row
/* 394 */
/* 395 */             // common sub-expressions
/* 396 */
/* 397 */             // evaluate aggregate function
/* 398 */             boolean agg_isNull14 = true;
/* 399 */             double agg_value15 = -1.0;
/* 400 */
/* 401 */             boolean agg_isNull16 = agg_fastAggBuffer.isNullAt(0);
/* 402 */             double agg_value17 = agg_isNull16 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 403 */             boolean agg_isNull15 = agg_isNull16;
/* 404 */             double agg_value16 = agg_value17;
/* 405 */             if (agg_isNull15) {
/* 406 */               boolean agg_isNull17 = false;
/* 407 */               double agg_value18 = -1.0;
/* 408 */               if (!false) {
/* 409 */                 agg_value18 = (double) 0;
/* 410 */               }
/* 411 */               if (!agg_isNull17) {
/* 412 */                 agg_isNull15 = false;
/* 413 */                 agg_value16 = agg_value18;
/* 414 */               }
/* 415 */             }
/* 416 */
/* 417 */             if (!scan_isNull1) {
/* 418 */               agg_isNull14 = false; // resultCode could change nullability.
/* 419 */               agg_value15 = agg_value16 + scan_value1;
/* 420 */
/* 421 */             }
/* 422 */             boolean agg_isNull13 = agg_isNull14;
/* 423 */             double agg_value14 = agg_value15;
/* 424 */             if (agg_isNull13) {
/* 425 */               boolean agg_isNull20 = agg_fastAggBuffer.isNullAt(0);
/* 426 */               double agg_value21 = agg_isNull20 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 427 */               if (!agg_isNull20) {
/* 428 */                 agg_isNull13 = false;
/* 429 */                 agg_value14 = agg_value21;
/* 430 */               }
/* 431 */             }
/* 432 */             // update fast row
/* 433 */             if (!agg_isNull13) {
/* 434 */               agg_fastAggBuffer.setDouble(0, agg_value14);
/* 435 */             } else {
/* 436 */               agg_fastAggBuffer.setNullAt(0);
/* 437 */             }
/* 438 */
/* 439 */           } else {
/* 440 */             // update unsafe row
/* 441 */
/* 442 */             // common sub-expressions
/* 443 */
/* 444 */             // evaluate aggregate function
/* 445 */             boolean agg_isNull6 = true;
/* 446 */             double agg_value7 = -1.0;
/* 447 */
/* 448 */             boolean agg_isNull8 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 449 */             double agg_value9 = agg_isNull8 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 450 */             boolean agg_isNull7 = agg_isNull8;
/* 451 */             double agg_value8 = agg_value9;
/* 452 */             if (agg_isNull7) {
/* 453 */               boolean agg_isNull9 = false;
/* 454 */               double agg_value10 = -1.0;
/* 455 */               if (!false) {
/* 456 */                 agg_value10 = (double) 0;
/* 457 */               }
/* 458 */               if (!agg_isNull9) {
/* 459 */                 agg_isNull7 = false;
/* 460 */                 agg_value8 = agg_value10;
/* 461 */               }
/* 462 */             }
/* 463 */
/* 464 */             if (!scan_isNull1) {
/* 465 */               agg_isNull6 = false; // resultCode could change nullability.
/* 466 */               agg_value7 = agg_value8 + scan_value1;
/* 467 */
/* 468 */             }
/* 469 */             boolean agg_isNull5 = agg_isNull6;
/* 470 */             double agg_value6 = agg_value7;
/* 471 */             if (agg_isNull5) {
/* 472 */               boolean agg_isNull12 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 473 */               double agg_value13 = agg_isNull12 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 474 */               if (!agg_isNull12) {
/* 475 */                 agg_isNull5 = false;
/* 476 */                 agg_value6 = agg_value13;
/* 477 */               }
/* 478 */             }
/* 479 */             // update unsafe row buffer
/* 480 */             if (!agg_isNull5) {
/* 481 */               agg_unsafeRowAggBuffer.setDouble(0, agg_value6);
/* 482 */             } else {
/* 483 */               agg_unsafeRowAggBuffer.setNullAt(0);
/* 484 */             }
/* 485 */
/* 486 */           }
/* 487 */
/* 488 */         }
/* 489 */         // shouldStop check is eliminated
/* 490 */       }
/* 491 */       scan_batchIdx = scan_numRows;
/* 492 */       scan_batch = null;
/* 493 */       scan_nextBatch();
/* 494 */     }
/* 495 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 496 */     scan_scanTime1 = 0;
/* 497 */
/* 498 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 499 */
/* 500 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 501 */   }
/* 502 */
/* 503 */   private void wholestagecodegen_init_2() {
/* 504 */     project_result1 = new UnsafeRow(2);
/* 505 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 506 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 507 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 508 */
/* 509 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 510 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 511 */
/* 512 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 513 */     bhj_result1 = new UnsafeRow(5);
/* 514 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 515 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 5);
/* 516 */     project_result2 = new UnsafeRow(3);
/* 517 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 518 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 3);
/* 519 */
/* 520 */   }
/* 521 */
/* 522 */   private void wholestagecodegen_init_1() {
/* 523 */     filter_result = new UnsafeRow(3);
/* 524 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 525 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 526 */     project_result = new UnsafeRow(3);
/* 527 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 528 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 529 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[8];
/* 530 */
/* 531 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 532 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 533 */
/* 534 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 535 */     bhj_result = new UnsafeRow(4);
/* 536 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 537 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 538 */
/* 539 */   }
/* 540 */
/* 541 */   private void wholestagecodegen_init_4() {
/* 542 */     agg_result1 = new UnsafeRow(1);
/* 543 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 544 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 545 */
/* 546 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 547 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 548 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 549 */
/* 550 */   }
/* 551 */
/* 552 */   protected void processNext() throws java.io.IOException {
/* 553 */     if (!agg_initAgg) {
/* 554 */       agg_initAgg = true;
/* 555 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 556 */       agg_doAggregateWithKeys();
/* 557 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 558 */     }
/* 559 */
/* 560 */     // output the result
/* 561 */
/* 562 */     while (agg_fastHashMapIter.next()) {
/* 563 */       wholestagecodegen_numOutputRows.add(1);
/* 564 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 565 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 566 */
/* 567 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 568 */
/* 569 */       append(agg_resultRow.copy());
/* 570 */
/* 571 */       if (shouldStop()) return;
/* 572 */     }
/* 573 */     agg_fastHashMap.close();
/* 574 */
/* 575 */     while (agg_mapIter.next()) {
/* 576 */       wholestagecodegen_numOutputRows.add(1);
/* 577 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 578 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 579 */
/* 580 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 581 */
/* 582 */       append(agg_resultRow.copy());
/* 583 */
/* 584 */       if (shouldStop()) return;
/* 585 */     }
/* 586 */
/* 587 */     agg_mapIter.close();
/* 588 */     if (agg_sorter == null) {
/* 589 */       agg_hashMap.free();
/* 590 */     }
/* 591 */   }
/* 592 */ }

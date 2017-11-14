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
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
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
/* 123 */     bhj_result2 = new UnsafeRow(6);
/* 124 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 96);
/* 125 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 6);
/* 126 */     project_result3 = new UnsafeRow(4);
/* 127 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 96);
/* 128 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 4);
/* 129 */     agg_result2 = new UnsafeRow(2);
/* 130 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 64);
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
/* 158 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 159 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType);
/* 160 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.LongType)
/* 161 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.LongType);
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
/* 184 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1) {
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
/* 196 */               64);
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
/* 232 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1) {
/* 233 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 234 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1));
/* 235 */     }
/* 236 */
/* 237 */     private long hash(UTF8String agg_key, UTF8String agg_key1) {
/* 238 */       long agg_hash = 0;
/* 239 */
/* 240 */       int agg_result = 0;
/* 241 */       byte[] agg_bytes = agg_key.getBytes();
/* 242 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 243 */         int agg_hash1 = agg_bytes[i];
/* 244 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 245 */       }
/* 246 */
/* 247 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 248 */
/* 249 */       int agg_result1 = 0;
/* 250 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 251 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 252 */         int agg_hash2 = agg_bytes1[i];
/* 253 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 254 */       }
/* 255 */
/* 256 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 257 */
/* 258 */       return agg_hash;
/* 259 */     }
/* 260 */
/* 261 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 262 */       return batch.rowIterator();
/* 263 */     }
/* 264 */
/* 265 */     public void close() {
/* 266 */       batch.close();
/* 267 */     }
/* 268 */
/* 269 */   }
/* 270 */
/* 271 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 272 */     agg_hashMap = agg_plan.createHashMap();
/* 273 */
/* 274 */     if (scan_batch == null) {
/* 275 */       scan_nextBatch();
/* 276 */     }
/* 277 */     while (scan_batch != null) {
/* 278 */       int scan_numRows = scan_batch.numRows();
/* 279 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 280 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 281 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 282 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 283 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 284 */
/* 285 */         if (!(!(scan_isNull1))) continue;
/* 286 */
/* 287 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 288 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 289 */
/* 290 */         if (!(!(scan_isNull))) continue;
/* 291 */
/* 292 */         filter_numOutputRows.add(1);
/* 293 */
/* 294 */         // generate join key for stream side
/* 295 */
/* 296 */         boolean bhj_isNull = false;
/* 297 */         long bhj_value = -1L;
/* 298 */         if (!false) {
/* 299 */           bhj_value = (long) scan_value1;
/* 300 */         }
/* 301 */         // find matches from HashedRelation
/* 302 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 303 */         if (bhj_matched == null) continue;
/* 304 */
/* 305 */         bhj_numOutputRows.add(1);
/* 306 */
/* 307 */         // generate join key for stream side
/* 308 */
/* 309 */         boolean bhj_isNull10 = false;
/* 310 */         long bhj_value10 = -1L;
/* 311 */         if (!false) {
/* 312 */           bhj_value10 = (long) scan_value;
/* 313 */         }
/* 314 */         // find matches from HashedRelation
/* 315 */         UnsafeRow bhj_matched1 = bhj_isNull10 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value10);
/* 316 */         if (bhj_matched1 == null) continue;
/* 317 */
/* 318 */         bhj_numOutputRows1.add(1);
/* 319 */
/* 320 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 321 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 322 */
/* 323 */         // generate join key for stream side
/* 324 */
/* 325 */         boolean bhj_isNull20 = scan_isNull3;
/* 326 */         long bhj_value20 = -1L;
/* 327 */         if (!scan_isNull3) {
/* 328 */           bhj_value20 = (long) scan_value3;
/* 329 */         }
/* 330 */         // find matches from HashedRelation
/* 331 */         UnsafeRow bhj_matched2 = bhj_isNull20 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value20);
/* 332 */         if (bhj_matched2 == null) continue;
/* 333 */
/* 334 */         bhj_numOutputRows2.add(1);
/* 335 */
/* 336 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 337 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 338 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 339 */         UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 340 */         boolean bhj_isNull13 = bhj_matched1.isNullAt(1);
/* 341 */         UTF8String bhj_value13 = bhj_isNull13 ? null : (bhj_matched1.getUTF8String(1));
/* 342 */         boolean bhj_isNull23 = bhj_matched2.isNullAt(1);
/* 343 */         UTF8String bhj_value23 = bhj_isNull23 ? null : (bhj_matched2.getUTF8String(1));
/* 344 */
/* 345 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 346 */
/* 347 */         UnsafeRow agg_fastAggBuffer = null;
/* 348 */
/* 349 */         if (true) {
/* 350 */           if (!bhj_isNull3 && !bhj_isNull13) {
/* 351 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 352 */               bhj_value3, bhj_value13);
/* 353 */           }
/* 354 */         }
/* 355 */
/* 356 */         if (agg_fastAggBuffer == null) {
/* 357 */           // generate grouping key
/* 358 */           agg_holder.reset();
/* 359 */
/* 360 */           agg_rowWriter.zeroOutNullBytes();
/* 361 */
/* 362 */           if (bhj_isNull3) {
/* 363 */             agg_rowWriter.setNullAt(0);
/* 364 */           } else {
/* 365 */             agg_rowWriter.write(0, bhj_value3);
/* 366 */           }
/* 367 */
/* 368 */           if (bhj_isNull13) {
/* 369 */             agg_rowWriter.setNullAt(1);
/* 370 */           } else {
/* 371 */             agg_rowWriter.write(1, bhj_value13);
/* 372 */           }
/* 373 */           agg_result2.setTotalSize(agg_holder.totalSize());
/* 374 */           agg_value8 = 42;
/* 375 */
/* 376 */           if (!bhj_isNull3) {
/* 377 */             agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value3.getBaseObject(), bhj_value3.getBaseOffset(), bhj_value3.numBytes(), agg_value8);
/* 378 */           }
/* 379 */
/* 380 */           if (!bhj_isNull13) {
/* 381 */             agg_value8 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value13.getBaseObject(), bhj_value13.getBaseOffset(), bhj_value13.numBytes(), agg_value8);
/* 382 */           }
/* 383 */           if (true) {
/* 384 */             // try to get the buffer from hash map
/* 385 */             agg_unsafeRowAggBuffer =
/* 386 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value8);
/* 387 */           }
/* 388 */           if (agg_unsafeRowAggBuffer == null) {
/* 389 */             if (agg_sorter == null) {
/* 390 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 391 */             } else {
/* 392 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 393 */             }
/* 394 */
/* 395 */             // the hash map had be spilled, it should have enough memory now,
/* 396 */             // try  to allocate buffer again.
/* 397 */             agg_unsafeRowAggBuffer =
/* 398 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value8);
/* 399 */             if (agg_unsafeRowAggBuffer == null) {
/* 400 */               // failed to allocate the first page
/* 401 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 402 */             }
/* 403 */           }
/* 404 */         }
/* 405 */
/* 406 */         if (agg_fastAggBuffer != null) {
/* 407 */           // update fast row
/* 408 */
/* 409 */           // common sub-expressions
/* 410 */           boolean agg_isNull37 = bhj_isNull23;
/* 411 */           int agg_value39 = -1;
/* 412 */           if (!bhj_isNull23) {
/* 413 */             scala.Option<Integer> agg_intOpt1 =
/* 414 */             org.apache.spark.sql.catalyst.util.DateTimeUtils.stringToDate(bhj_value23);
/* 415 */             if (agg_intOpt1.isDefined()) {
/* 416 */               agg_value39 = ((Integer) agg_intOpt1.get()).intValue();
/* 417 */             } else {
/* 418 */               agg_isNull37 = true;
/* 419 */             }
/* 420 */
/* 421 */           }
/* 422 */           // evaluate aggregate function
/* 423 */           boolean agg_isNull40 = true;
/* 424 */           long agg_value42 = -1L;
/* 425 */
/* 426 */           boolean agg_isNull42 = agg_fastAggBuffer.isNullAt(0);
/* 427 */           long agg_value44 = agg_isNull42 ? -1L : (agg_fastAggBuffer.getLong(0));
/* 428 */           boolean agg_isNull41 = agg_isNull42;
/* 429 */           long agg_value43 = agg_value44;
/* 430 */           if (agg_isNull41) {
/* 431 */             boolean agg_isNull43 = false;
/* 432 */             long agg_value45 = -1L;
/* 433 */             if (!false) {
/* 434 */               agg_value45 = (long) 0;
/* 435 */             }
/* 436 */             if (!agg_isNull43) {
/* 437 */               agg_isNull41 = false;
/* 438 */               agg_value43 = agg_value45;
/* 439 */             }
/* 440 */           }
/* 441 */
/* 442 */           boolean agg_isNull46 = true;
/* 443 */           int agg_value48 = -1;
/* 444 */
/* 445 */           boolean agg_isNull47 = true;
/* 446 */           boolean agg_value49 = false;
/* 447 */
/* 448 */           if (!agg_isNull37) {
/* 449 */             agg_isNull47 = false; // resultCode could change nullability.
/* 450 */             agg_value49 = agg_value39 < 11027;
/* 451 */
/* 452 */           }
/* 453 */           if (!agg_isNull47 && agg_value49) {
/* 454 */             agg_isNull46 = scan_isNull2;
/* 455 */             agg_value48 = scan_value2;
/* 456 */           }
/* 457 */
/* 458 */           else {
/* 459 */             agg_isNull46 = false;
/* 460 */             agg_value48 = 0;
/* 461 */           }
/* 462 */           boolean agg_isNull45 = agg_isNull46;
/* 463 */           long agg_value47 = -1L;
/* 464 */           if (!agg_isNull46) {
/* 465 */             agg_value47 = (long) agg_value48;
/* 466 */           }
/* 467 */           if (!agg_isNull45) {
/* 468 */             agg_isNull40 = false; // resultCode could change nullability.
/* 469 */             agg_value42 = agg_value43 + agg_value47;
/* 470 */
/* 471 */           }
/* 472 */           boolean agg_isNull39 = agg_isNull40;
/* 473 */           long agg_value41 = agg_value42;
/* 474 */           if (agg_isNull39) {
/* 475 */             boolean agg_isNull51 = agg_fastAggBuffer.isNullAt(0);
/* 476 */             long agg_value53 = agg_isNull51 ? -1L : (agg_fastAggBuffer.getLong(0));
/* 477 */             if (!agg_isNull51) {
/* 478 */               agg_isNull39 = false;
/* 479 */               agg_value41 = agg_value53;
/* 480 */             }
/* 481 */           }
/* 482 */           boolean agg_isNull53 = true;
/* 483 */           long agg_value55 = -1L;
/* 484 */
/* 485 */           boolean agg_isNull55 = agg_fastAggBuffer.isNullAt(1);
/* 486 */           long agg_value57 = agg_isNull55 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 487 */           boolean agg_isNull54 = agg_isNull55;
/* 488 */           long agg_value56 = agg_value57;
/* 489 */           if (agg_isNull54) {
/* 490 */             boolean agg_isNull56 = false;
/* 491 */             long agg_value58 = -1L;
/* 492 */             if (!false) {
/* 493 */               agg_value58 = (long) 0;
/* 494 */             }
/* 495 */             if (!agg_isNull56) {
/* 496 */               agg_isNull54 = false;
/* 497 */               agg_value56 = agg_value58;
/* 498 */             }
/* 499 */           }
/* 500 */
/* 501 */           boolean agg_isNull59 = true;
/* 502 */           int agg_value61 = -1;
/* 503 */
/* 504 */           boolean agg_isNull60 = true;
/* 505 */           boolean agg_value62 = false;
/* 506 */
/* 507 */           if (!agg_isNull37) {
/* 508 */             agg_isNull60 = false; // resultCode could change nullability.
/* 509 */             agg_value62 = agg_value39 >= 11027;
/* 510 */
/* 511 */           }
/* 512 */           if (!agg_isNull60 && agg_value62) {
/* 513 */             agg_isNull59 = scan_isNull2;
/* 514 */             agg_value61 = scan_value2;
/* 515 */           }
/* 516 */
/* 517 */           else {
/* 518 */             agg_isNull59 = false;
/* 519 */             agg_value61 = 0;
/* 520 */           }
/* 521 */           boolean agg_isNull58 = agg_isNull59;
/* 522 */           long agg_value60 = -1L;
/* 523 */           if (!agg_isNull59) {
/* 524 */             agg_value60 = (long) agg_value61;
/* 525 */           }
/* 526 */           if (!agg_isNull58) {
/* 527 */             agg_isNull53 = false; // resultCode could change nullability.
/* 528 */             agg_value55 = agg_value56 + agg_value60;
/* 529 */
/* 530 */           }
/* 531 */           boolean agg_isNull52 = agg_isNull53;
/* 532 */           long agg_value54 = agg_value55;
/* 533 */           if (agg_isNull52) {
/* 534 */             boolean agg_isNull64 = agg_fastAggBuffer.isNullAt(1);
/* 535 */             long agg_value66 = agg_isNull64 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 536 */             if (!agg_isNull64) {
/* 537 */               agg_isNull52 = false;
/* 538 */               agg_value54 = agg_value66;
/* 539 */             }
/* 540 */           }
/* 541 */           // update fast row
/* 542 */           if (!agg_isNull39) {
/* 543 */             agg_fastAggBuffer.setLong(0, agg_value41);
/* 544 */           } else {
/* 545 */             agg_fastAggBuffer.setNullAt(0);
/* 546 */           }
/* 547 */
/* 548 */           if (!agg_isNull52) {
/* 549 */             agg_fastAggBuffer.setLong(1, agg_value54);
/* 550 */           } else {
/* 551 */             agg_fastAggBuffer.setNullAt(1);
/* 552 */           }
/* 553 */
/* 554 */         } else {
/* 555 */           // update unsafe row
/* 556 */
/* 557 */           // common sub-expressions
/* 558 */           boolean agg_isNull9 = bhj_isNull23;
/* 559 */           int agg_value11 = -1;
/* 560 */           if (!bhj_isNull23) {
/* 561 */             scala.Option<Integer> agg_intOpt =
/* 562 */             org.apache.spark.sql.catalyst.util.DateTimeUtils.stringToDate(bhj_value23);
/* 563 */             if (agg_intOpt.isDefined()) {
/* 564 */               agg_value11 = ((Integer) agg_intOpt.get()).intValue();
/* 565 */             } else {
/* 566 */               agg_isNull9 = true;
/* 567 */             }
/* 568 */
/* 569 */           }
/* 570 */           // evaluate aggregate function
/* 571 */           boolean agg_isNull12 = true;
/* 572 */           long agg_value14 = -1L;
/* 573 */
/* 574 */           boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 575 */           long agg_value16 = agg_isNull14 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 576 */           boolean agg_isNull13 = agg_isNull14;
/* 577 */           long agg_value15 = agg_value16;
/* 578 */           if (agg_isNull13) {
/* 579 */             boolean agg_isNull15 = false;
/* 580 */             long agg_value17 = -1L;
/* 581 */             if (!false) {
/* 582 */               agg_value17 = (long) 0;
/* 583 */             }
/* 584 */             if (!agg_isNull15) {
/* 585 */               agg_isNull13 = false;
/* 586 */               agg_value15 = agg_value17;
/* 587 */             }
/* 588 */           }
/* 589 */
/* 590 */           boolean agg_isNull18 = true;
/* 591 */           int agg_value20 = -1;
/* 592 */
/* 593 */           boolean agg_isNull19 = true;
/* 594 */           boolean agg_value21 = false;
/* 595 */
/* 596 */           if (!agg_isNull9) {
/* 597 */             agg_isNull19 = false; // resultCode could change nullability.
/* 598 */             agg_value21 = agg_value11 < 11027;
/* 599 */
/* 600 */           }
/* 601 */           if (!agg_isNull19 && agg_value21) {
/* 602 */             agg_isNull18 = scan_isNull2;
/* 603 */             agg_value20 = scan_value2;
/* 604 */           }
/* 605 */
/* 606 */           else {
/* 607 */             agg_isNull18 = false;
/* 608 */             agg_value20 = 0;
/* 609 */           }
/* 610 */           boolean agg_isNull17 = agg_isNull18;
/* 611 */           long agg_value19 = -1L;
/* 612 */           if (!agg_isNull18) {
/* 613 */             agg_value19 = (long) agg_value20;
/* 614 */           }
/* 615 */           if (!agg_isNull17) {
/* 616 */             agg_isNull12 = false; // resultCode could change nullability.
/* 617 */             agg_value14 = agg_value15 + agg_value19;
/* 618 */
/* 619 */           }
/* 620 */           boolean agg_isNull11 = agg_isNull12;
/* 621 */           long agg_value13 = agg_value14;
/* 622 */           if (agg_isNull11) {
/* 623 */             boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 624 */             long agg_value25 = agg_isNull23 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 625 */             if (!agg_isNull23) {
/* 626 */               agg_isNull11 = false;
/* 627 */               agg_value13 = agg_value25;
/* 628 */             }
/* 629 */           }
/* 630 */           boolean agg_isNull25 = true;
/* 631 */           long agg_value27 = -1L;
/* 632 */
/* 633 */           boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 634 */           long agg_value29 = agg_isNull27 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 635 */           boolean agg_isNull26 = agg_isNull27;
/* 636 */           long agg_value28 = agg_value29;
/* 637 */           if (agg_isNull26) {
/* 638 */             boolean agg_isNull28 = false;
/* 639 */             long agg_value30 = -1L;
/* 640 */             if (!false) {
/* 641 */               agg_value30 = (long) 0;
/* 642 */             }
/* 643 */             if (!agg_isNull28) {
/* 644 */               agg_isNull26 = false;
/* 645 */               agg_value28 = agg_value30;
/* 646 */             }
/* 647 */           }
/* 648 */
/* 649 */           boolean agg_isNull31 = true;
/* 650 */           int agg_value33 = -1;
/* 651 */
/* 652 */           boolean agg_isNull32 = true;
/* 653 */           boolean agg_value34 = false;
/* 654 */
/* 655 */           if (!agg_isNull9) {
/* 656 */             agg_isNull32 = false; // resultCode could change nullability.
/* 657 */             agg_value34 = agg_value11 >= 11027;
/* 658 */
/* 659 */           }
/* 660 */           if (!agg_isNull32 && agg_value34) {
/* 661 */             agg_isNull31 = scan_isNull2;
/* 662 */             agg_value33 = scan_value2;
/* 663 */           }
/* 664 */
/* 665 */           else {
/* 666 */             agg_isNull31 = false;
/* 667 */             agg_value33 = 0;
/* 668 */           }
/* 669 */           boolean agg_isNull30 = agg_isNull31;
/* 670 */           long agg_value32 = -1L;
/* 671 */           if (!agg_isNull31) {
/* 672 */             agg_value32 = (long) agg_value33;
/* 673 */           }
/* 674 */           if (!agg_isNull30) {
/* 675 */             agg_isNull25 = false; // resultCode could change nullability.
/* 676 */             agg_value27 = agg_value28 + agg_value32;
/* 677 */
/* 678 */           }
/* 679 */           boolean agg_isNull24 = agg_isNull25;
/* 680 */           long agg_value26 = agg_value27;
/* 681 */           if (agg_isNull24) {
/* 682 */             boolean agg_isNull36 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 683 */             long agg_value38 = agg_isNull36 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 684 */             if (!agg_isNull36) {
/* 685 */               agg_isNull24 = false;
/* 686 */               agg_value26 = agg_value38;
/* 687 */             }
/* 688 */           }
/* 689 */           // update unsafe row buffer
/* 690 */           if (!agg_isNull11) {
/* 691 */             agg_unsafeRowAggBuffer.setLong(0, agg_value13);
/* 692 */           } else {
/* 693 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 694 */           }
/* 695 */
/* 696 */           if (!agg_isNull24) {
/* 697 */             agg_unsafeRowAggBuffer.setLong(1, agg_value26);
/* 698 */           } else {
/* 699 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 700 */           }
/* 701 */
/* 702 */         }
/* 703 */         // shouldStop check is eliminated
/* 704 */       }
/* 705 */       scan_batchIdx = scan_numRows;
/* 706 */       scan_batch = null;
/* 707 */       scan_nextBatch();
/* 708 */     }
/* 709 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 710 */     scan_scanTime1 = 0;
/* 711 */
/* 712 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 713 */
/* 714 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 715 */   }
/* 716 */
/* 717 */   private void wholestagecodegen_init_2() {
/* 718 */     project_result1 = new UnsafeRow(4);
/* 719 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 32);
/* 720 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 721 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 722 */
/* 723 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 724 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 725 */
/* 726 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 727 */     bhj_result1 = new UnsafeRow(6);
/* 728 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 729 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 730 */     project_result2 = new UnsafeRow(4);
/* 731 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 732 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 4);
/* 733 */
/* 734 */   }
/* 735 */
/* 736 */   private void wholestagecodegen_init_1() {
/* 737 */     filter_result = new UnsafeRow(4);
/* 738 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 739 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 740 */     project_result = new UnsafeRow(4);
/* 741 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 742 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 743 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[10];
/* 744 */
/* 745 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 746 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 747 */
/* 748 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 749 */     bhj_result = new UnsafeRow(6);
/* 750 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 32);
/* 751 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 752 */
/* 753 */   }
/* 754 */
/* 755 */   private void wholestagecodegen_init_4() {
/* 756 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 757 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 758 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 759 */
/* 760 */   }
/* 761 */
/* 762 */   protected void processNext() throws java.io.IOException {
/* 763 */     if (!agg_initAgg) {
/* 764 */       agg_initAgg = true;
/* 765 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 766 */       agg_doAggregateWithKeys();
/* 767 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 768 */     }
/* 769 */
/* 770 */     // output the result
/* 771 */
/* 772 */     while (agg_fastHashMapIter.next()) {
/* 773 */       wholestagecodegen_numOutputRows.add(1);
/* 774 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 775 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 776 */
/* 777 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 778 */
/* 779 */       append(agg_resultRow);
/* 780 */
/* 781 */       if (shouldStop()) return;
/* 782 */     }
/* 783 */     agg_fastHashMap.close();
/* 784 */
/* 785 */     while (agg_mapIter.next()) {
/* 786 */       wholestagecodegen_numOutputRows.add(1);
/* 787 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 788 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 789 */
/* 790 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 791 */
/* 792 */       append(agg_resultRow);
/* 793 */
/* 794 */       if (shouldStop()) return;
/* 795 */     }
/* 796 */
/* 797 */     agg_mapIter.close();
/* 798 */     if (agg_sorter == null) {
/* 799 */       agg_hashMap.free();
/* 800 */     }
/* 801 */   }
/* 802 */ }

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
/* 030 */   private UnsafeRow scan_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 034 */   private UnsafeRow filter_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 037 */   private UnsafeRow project_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 040 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 041 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 043 */   private UnsafeRow bhj_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 046 */   private UnsafeRow project_result1;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 049 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 050 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 052 */   private UnsafeRow bhj_result1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 054 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 055 */   private UnsafeRow project_result2;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 057 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 058 */   private org.apache.spark.sql.execution.metric.SQLMetric expand_numOutputRows;
/* 059 */   private UnsafeRow expand_result;
/* 060 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder expand_holder;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter expand_rowWriter;
/* 062 */   private UnsafeRow agg_result3;
/* 063 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 065 */   private int agg_value10;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 067 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 068 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 069 */
/* 070 */   public GeneratedIterator(Object[] references) {
/* 071 */     this.references = references;
/* 072 */   }
/* 073 */
/* 074 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 075 */     partitionIndex = index;
/* 076 */     this.inputs = inputs;
/* 077 */     wholestagecodegen_init_0();
/* 078 */     wholestagecodegen_init_1();
/* 079 */     wholestagecodegen_init_2();
/* 080 */     wholestagecodegen_init_3();
/* 081 */
/* 082 */   }
/* 083 */
/* 084 */   private void wholestagecodegen_init_0() {
/* 085 */     agg_initAgg = false;
/* 086 */
/* 087 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 088 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 089 */
/* 090 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 091 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 092 */     scan_input = inputs[0];
/* 093 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 094 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 095 */     scan_scanTime1 = 0;
/* 096 */     scan_batch = null;
/* 097 */     scan_batchIdx = 0;
/* 098 */     scan_colInstance0 = null;
/* 099 */     scan_colInstance1 = null;
/* 100 */     scan_colInstance2 = null;
/* 101 */     scan_result = new UnsafeRow(3);
/* 102 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 103 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 3);
/* 104 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 105 */
/* 106 */   }
/* 107 */
/* 108 */   private void wholestagecodegen_init_3() {
/* 109 */     this.expand_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 110 */     expand_result = new UnsafeRow(4);
/* 111 */     this.expand_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(expand_result, 64);
/* 112 */     this.expand_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(expand_holder, 4);
/* 113 */     agg_result3 = new UnsafeRow(3);
/* 114 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 64);
/* 115 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 116 */
/* 117 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 118 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 119 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 120 */
/* 121 */   }
/* 122 */
/* 123 */   private void scan_nextBatch() throws java.io.IOException {
/* 124 */     long getBatchStart = System.nanoTime();
/* 125 */     if (scan_input.hasNext()) {
/* 126 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 127 */       scan_numOutputRows.add(scan_batch.numRows());
/* 128 */       scan_batchIdx = 0;
/* 129 */       scan_colInstance0 = scan_batch.column(0);
/* 130 */       scan_colInstance1 = scan_batch.column(1);
/* 131 */       scan_colInstance2 = scan_batch.column(2);
/* 132 */
/* 133 */     }
/* 134 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 135 */   }
/* 136 */
/* 137 */   public class agg_FastHashMap {
/* 138 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 139 */     private int[] buckets;
/* 140 */     private int capacity = 1 << 16;
/* 141 */     private double loadFactor = 0.5;
/* 142 */     private int numBuckets = (int) (capacity / loadFactor);
/* 143 */     private int maxSteps = 2;
/* 144 */     private int numRows = 0;
/* 145 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 146 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType)
/* 147 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 148 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 149 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 150 */     private Object emptyVBase;
/* 151 */     private long emptyVOff;
/* 152 */     private int emptyVLen;
/* 153 */     private boolean isBatchFull = false;
/* 154 */
/* 155 */     public agg_FastHashMap(
/* 156 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 157 */       InternalRow emptyAggregationBuffer) {
/* 158 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 159 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 160 */
/* 161 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 162 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 163 */
/* 164 */       emptyVBase = emptyBuffer;
/* 165 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 166 */       emptyVLen = emptyBuffer.length;
/* 167 */
/* 168 */       buckets = new int[numBuckets];
/* 169 */       java.util.Arrays.fill(buckets, -1);
/* 170 */     }
/* 171 */
/* 172 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 173 */       long h = hash(agg_key, agg_key1, agg_key2);
/* 174 */       int step = 0;
/* 175 */       int idx = (int) h & (numBuckets - 1);
/* 176 */       while (step < maxSteps) {
/* 177 */         // Return bucket index if it's either an empty slot or already contains the key
/* 178 */         if (buckets[idx] == -1) {
/* 179 */           if (numRows < capacity && !isBatchFull) {
/* 180 */             // creating the unsafe for new entry
/* 181 */             UnsafeRow agg_result = new UnsafeRow(3);
/* 182 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 183 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 184 */               64);
/* 185 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 186 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 187 */               agg_holder,
/* 188 */               3);
/* 189 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 190 */             agg_rowWriter.zeroOutNullBytes();
/* 191 */             agg_rowWriter.write(0, agg_key);
/* 192 */             agg_rowWriter.write(1, agg_key1);
/* 193 */             agg_rowWriter.write(2, agg_key2);
/* 194 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 195 */             Object kbase = agg_result.getBaseObject();
/* 196 */             long koff = agg_result.getBaseOffset();
/* 197 */             int klen = agg_result.getSizeInBytes();
/* 198 */
/* 199 */             UnsafeRow vRow
/* 200 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 201 */             if (vRow == null) {
/* 202 */               isBatchFull = true;
/* 203 */             } else {
/* 204 */               buckets[idx] = numRows++;
/* 205 */             }
/* 206 */             return vRow;
/* 207 */           } else {
/* 208 */             // No more space
/* 209 */             return null;
/* 210 */           }
/* 211 */         } else if (equals(idx, agg_key, agg_key1, agg_key2)) {
/* 212 */           return batch.getValueRow(buckets[idx]);
/* 213 */         }
/* 214 */         idx = (idx + 1) & (numBuckets - 1);
/* 215 */         step++;
/* 216 */       }
/* 217 */       // Didn't find it
/* 218 */       return null;
/* 219 */     }
/* 220 */
/* 221 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 222 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 223 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1)) && (row.getInt(2) == agg_key2);
/* 224 */     }
/* 225 */
/* 226 */     private long hash(UTF8String agg_key, UTF8String agg_key1, int agg_key2) {
/* 227 */       long agg_hash = 0;
/* 228 */
/* 229 */       int agg_result = 0;
/* 230 */       byte[] agg_bytes = agg_key.getBytes();
/* 231 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 232 */         int agg_hash1 = agg_bytes[i];
/* 233 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 234 */       }
/* 235 */
/* 236 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 237 */
/* 238 */       int agg_result1 = 0;
/* 239 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 240 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 241 */         int agg_hash2 = agg_bytes1[i];
/* 242 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 243 */       }
/* 244 */
/* 245 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 246 */
/* 247 */       int agg_result2 = agg_key2;
/* 248 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 249 */
/* 250 */       return agg_hash;
/* 251 */     }
/* 252 */
/* 253 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 254 */       return batch.rowIterator();
/* 255 */     }
/* 256 */
/* 257 */     public void close() {
/* 258 */       batch.close();
/* 259 */     }
/* 260 */
/* 261 */   }
/* 262 */
/* 263 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 264 */     agg_hashMap = agg_plan.createHashMap();
/* 265 */
/* 266 */     if (scan_batch == null) {
/* 267 */       scan_nextBatch();
/* 268 */     }
/* 269 */     while (scan_batch != null) {
/* 270 */       int scan_numRows = scan_batch.numRows();
/* 271 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 272 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 273 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 274 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 275 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 276 */
/* 277 */         if (!(!(scan_isNull))) continue;
/* 278 */
/* 279 */         filter_numOutputRows.add(1);
/* 280 */
/* 281 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 282 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 283 */
/* 284 */         // generate join key for stream side
/* 285 */
/* 286 */         boolean bhj_isNull = scan_isNull2;
/* 287 */         long bhj_value = -1L;
/* 288 */         if (!scan_isNull2) {
/* 289 */           bhj_value = (long) scan_value2;
/* 290 */         }
/* 291 */         // find matches from HashedRelation
/* 292 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 293 */         if (bhj_matched == null) continue;
/* 294 */
/* 295 */         bhj_numOutputRows.add(1);
/* 296 */
/* 297 */         // generate join key for stream side
/* 298 */
/* 299 */         boolean bhj_isNull7 = false;
/* 300 */         long bhj_value7 = -1L;
/* 301 */         if (!false) {
/* 302 */           bhj_value7 = (long) scan_value;
/* 303 */         }
/* 304 */         // find matches from HashedRelation
/* 305 */         UnsafeRow bhj_matched1 = bhj_isNull7 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value7);
/* 306 */         if (bhj_matched1 == null) continue;
/* 307 */
/* 308 */         bhj_numOutputRows1.add(1);
/* 309 */
/* 310 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 311 */         double scan_value1 = scan_isNull1 ? -1.0 : (scan_colInstance1.getDouble(scan_rowIdx));
/* 312 */         boolean bhj_isNull11 = bhj_matched1.isNullAt(2);
/* 313 */         UTF8String bhj_value11 = bhj_isNull11 ? null : (bhj_matched1.getUTF8String(2));
/* 314 */         boolean bhj_isNull10 = bhj_matched1.isNullAt(1);
/* 315 */         UTF8String bhj_value10 = bhj_isNull10 ? null : (bhj_matched1.getUTF8String(1));
/* 316 */
/* 317 */         boolean expand_isNull1 = true;
/* 318 */         UTF8String expand_value1 = null;
/* 319 */         boolean expand_isNull2 = true;
/* 320 */         UTF8String expand_value2 = null;
/* 321 */         boolean expand_isNull3 = true;
/* 322 */         int expand_value3 = -1;
/* 323 */         for (int expand_i = 0; expand_i < 3; expand_i ++) {
/* 324 */           switch (expand_i) {
/* 325 */           case 0:
/* 326 */             expand_isNull1 = bhj_isNull11;
/* 327 */             expand_value1 = bhj_value11;
/* 328 */
/* 329 */             expand_isNull2 = bhj_isNull10;
/* 330 */             expand_value2 = bhj_value10;
/* 331 */
/* 332 */             expand_isNull3 = false;
/* 333 */             expand_value3 = 0;
/* 334 */             break;
/* 335 */
/* 336 */           case 1:
/* 337 */             expand_isNull1 = bhj_isNull11;
/* 338 */             expand_value1 = bhj_value11;
/* 339 */
/* 340 */             final UTF8String expand_value8 = null;
/* 341 */             expand_isNull2 = true;
/* 342 */             expand_value2 = expand_value8;
/* 343 */
/* 344 */             expand_isNull3 = false;
/* 345 */             expand_value3 = 1;
/* 346 */             break;
/* 347 */
/* 348 */           case 2:
/* 349 */             final UTF8String expand_value10 = null;
/* 350 */             expand_isNull1 = true;
/* 351 */             expand_value1 = expand_value10;
/* 352 */
/* 353 */             final UTF8String expand_value11 = null;
/* 354 */             expand_isNull2 = true;
/* 355 */             expand_value2 = expand_value11;
/* 356 */
/* 357 */             expand_isNull3 = false;
/* 358 */             expand_value3 = 3;
/* 359 */             break;
/* 360 */           }
/* 361 */           expand_numOutputRows.add(1);
/* 362 */
/* 363 */           UnsafeRow agg_unsafeRowAggBuffer = null;
/* 364 */
/* 365 */           UnsafeRow agg_fastAggBuffer = null;
/* 366 */
/* 367 */           if (true) {
/* 368 */             if (!expand_isNull1 && !expand_isNull2 && !expand_isNull3) {
/* 369 */               agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 370 */                 expand_value1, expand_value2, expand_value3);
/* 371 */             }
/* 372 */           }
/* 373 */
/* 374 */           if (agg_fastAggBuffer == null) {
/* 375 */             // generate grouping key
/* 376 */             agg_holder.reset();
/* 377 */
/* 378 */             agg_rowWriter.zeroOutNullBytes();
/* 379 */
/* 380 */             if (expand_isNull1) {
/* 381 */               agg_rowWriter.setNullAt(0);
/* 382 */             } else {
/* 383 */               agg_rowWriter.write(0, expand_value1);
/* 384 */             }
/* 385 */
/* 386 */             if (expand_isNull2) {
/* 387 */               agg_rowWriter.setNullAt(1);
/* 388 */             } else {
/* 389 */               agg_rowWriter.write(1, expand_value2);
/* 390 */             }
/* 391 */
/* 392 */             if (expand_isNull3) {
/* 393 */               agg_rowWriter.setNullAt(2);
/* 394 */             } else {
/* 395 */               agg_rowWriter.write(2, expand_value3);
/* 396 */             }
/* 397 */             agg_result3.setTotalSize(agg_holder.totalSize());
/* 398 */             agg_value10 = 42;
/* 399 */
/* 400 */             if (!expand_isNull1) {
/* 401 */               agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value1.getBaseObject(), expand_value1.getBaseOffset(), expand_value1.numBytes(), agg_value10);
/* 402 */             }
/* 403 */
/* 404 */             if (!expand_isNull2) {
/* 405 */               agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(expand_value2.getBaseObject(), expand_value2.getBaseOffset(), expand_value2.numBytes(), agg_value10);
/* 406 */             }
/* 407 */
/* 408 */             agg_value10 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(expand_value3, agg_value10);
/* 409 */             if (true) {
/* 410 */               // try to get the buffer from hash map
/* 411 */               agg_unsafeRowAggBuffer =
/* 412 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value10);
/* 413 */             }
/* 414 */             if (agg_unsafeRowAggBuffer == null) {
/* 415 */               if (agg_sorter == null) {
/* 416 */                 agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 417 */               } else {
/* 418 */                 agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 419 */               }
/* 420 */
/* 421 */               // the hash map had be spilled, it should have enough memory now,
/* 422 */               // try  to allocate buffer again.
/* 423 */               agg_unsafeRowAggBuffer =
/* 424 */               agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value10);
/* 425 */               if (agg_unsafeRowAggBuffer == null) {
/* 426 */                 // failed to allocate the first page
/* 427 */                 throw new OutOfMemoryError("No enough memory for aggregation");
/* 428 */               }
/* 429 */             }
/* 430 */           }
/* 431 */
/* 432 */           if (agg_fastAggBuffer != null) {
/* 433 */             // update fast row
/* 434 */
/* 435 */             // common sub-expressions
/* 436 */
/* 437 */             // evaluate aggregate function
/* 438 */             boolean agg_isNull31 = true;
/* 439 */             double agg_value33 = -1.0;
/* 440 */
/* 441 */             boolean agg_isNull33 = agg_fastAggBuffer.isNullAt(0);
/* 442 */             double agg_value35 = agg_isNull33 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 443 */             boolean agg_isNull32 = agg_isNull33;
/* 444 */             double agg_value34 = agg_value35;
/* 445 */             if (agg_isNull32) {
/* 446 */               boolean agg_isNull34 = false;
/* 447 */               double agg_value36 = -1.0;
/* 448 */               if (!false) {
/* 449 */                 agg_value36 = (double) 0;
/* 450 */               }
/* 451 */               if (!agg_isNull34) {
/* 452 */                 agg_isNull32 = false;
/* 453 */                 agg_value34 = agg_value36;
/* 454 */               }
/* 455 */             }
/* 456 */
/* 457 */             if (!scan_isNull1) {
/* 458 */               agg_isNull31 = false; // resultCode could change nullability.
/* 459 */               agg_value33 = agg_value34 + scan_value1;
/* 460 */
/* 461 */             }
/* 462 */             boolean agg_isNull30 = agg_isNull31;
/* 463 */             double agg_value32 = agg_value33;
/* 464 */             if (agg_isNull30) {
/* 465 */               boolean agg_isNull37 = agg_fastAggBuffer.isNullAt(0);
/* 466 */               double agg_value39 = agg_isNull37 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 467 */               if (!agg_isNull37) {
/* 468 */                 agg_isNull30 = false;
/* 469 */                 agg_value32 = agg_value39;
/* 470 */               }
/* 471 */             }
/* 472 */             boolean agg_isNull39 = true;
/* 473 */             double agg_value41 = -1.0;
/* 474 */
/* 475 */             boolean agg_isNull41 = agg_fastAggBuffer.isNullAt(1);
/* 476 */             double agg_value43 = agg_isNull41 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 477 */             boolean agg_isNull40 = agg_isNull41;
/* 478 */             double agg_value42 = agg_value43;
/* 479 */             if (agg_isNull40) {
/* 480 */               boolean agg_isNull42 = false;
/* 481 */               double agg_value44 = -1.0;
/* 482 */               if (!false) {
/* 483 */                 agg_value44 = (double) 0;
/* 484 */               }
/* 485 */               if (!agg_isNull42) {
/* 486 */                 agg_isNull40 = false;
/* 487 */                 agg_value42 = agg_value44;
/* 488 */               }
/* 489 */             }
/* 490 */
/* 491 */             if (!scan_isNull1) {
/* 492 */               agg_isNull39 = false; // resultCode could change nullability.
/* 493 */               agg_value41 = agg_value42 + scan_value1;
/* 494 */
/* 495 */             }
/* 496 */             boolean agg_isNull38 = agg_isNull39;
/* 497 */             double agg_value40 = agg_value41;
/* 498 */             if (agg_isNull38) {
/* 499 */               boolean agg_isNull45 = agg_fastAggBuffer.isNullAt(1);
/* 500 */               double agg_value47 = agg_isNull45 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 501 */               if (!agg_isNull45) {
/* 502 */                 agg_isNull38 = false;
/* 503 */                 agg_value40 = agg_value47;
/* 504 */               }
/* 505 */             }
/* 506 */             // update fast row
/* 507 */             if (!agg_isNull30) {
/* 508 */               agg_fastAggBuffer.setDouble(0, agg_value32);
/* 509 */             } else {
/* 510 */               agg_fastAggBuffer.setNullAt(0);
/* 511 */             }
/* 512 */
/* 513 */             if (!agg_isNull38) {
/* 514 */               agg_fastAggBuffer.setDouble(1, agg_value40);
/* 515 */             } else {
/* 516 */               agg_fastAggBuffer.setNullAt(1);
/* 517 */             }
/* 518 */
/* 519 */           } else {
/* 520 */             // update unsafe row
/* 521 */
/* 522 */             // common sub-expressions
/* 523 */
/* 524 */             // evaluate aggregate function
/* 525 */             boolean agg_isNull14 = true;
/* 526 */             double agg_value16 = -1.0;
/* 527 */
/* 528 */             boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 529 */             double agg_value18 = agg_isNull16 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 530 */             boolean agg_isNull15 = agg_isNull16;
/* 531 */             double agg_value17 = agg_value18;
/* 532 */             if (agg_isNull15) {
/* 533 */               boolean agg_isNull17 = false;
/* 534 */               double agg_value19 = -1.0;
/* 535 */               if (!false) {
/* 536 */                 agg_value19 = (double) 0;
/* 537 */               }
/* 538 */               if (!agg_isNull17) {
/* 539 */                 agg_isNull15 = false;
/* 540 */                 agg_value17 = agg_value19;
/* 541 */               }
/* 542 */             }
/* 543 */
/* 544 */             if (!scan_isNull1) {
/* 545 */               agg_isNull14 = false; // resultCode could change nullability.
/* 546 */               agg_value16 = agg_value17 + scan_value1;
/* 547 */
/* 548 */             }
/* 549 */             boolean agg_isNull13 = agg_isNull14;
/* 550 */             double agg_value15 = agg_value16;
/* 551 */             if (agg_isNull13) {
/* 552 */               boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 553 */               double agg_value22 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 554 */               if (!agg_isNull20) {
/* 555 */                 agg_isNull13 = false;
/* 556 */                 agg_value15 = agg_value22;
/* 557 */               }
/* 558 */             }
/* 559 */             boolean agg_isNull22 = true;
/* 560 */             double agg_value24 = -1.0;
/* 561 */
/* 562 */             boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 563 */             double agg_value26 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 564 */             boolean agg_isNull23 = agg_isNull24;
/* 565 */             double agg_value25 = agg_value26;
/* 566 */             if (agg_isNull23) {
/* 567 */               boolean agg_isNull25 = false;
/* 568 */               double agg_value27 = -1.0;
/* 569 */               if (!false) {
/* 570 */                 agg_value27 = (double) 0;
/* 571 */               }
/* 572 */               if (!agg_isNull25) {
/* 573 */                 agg_isNull23 = false;
/* 574 */                 agg_value25 = agg_value27;
/* 575 */               }
/* 576 */             }
/* 577 */
/* 578 */             if (!scan_isNull1) {
/* 579 */               agg_isNull22 = false; // resultCode could change nullability.
/* 580 */               agg_value24 = agg_value25 + scan_value1;
/* 581 */
/* 582 */             }
/* 583 */             boolean agg_isNull21 = agg_isNull22;
/* 584 */             double agg_value23 = agg_value24;
/* 585 */             if (agg_isNull21) {
/* 586 */               boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 587 */               double agg_value30 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 588 */               if (!agg_isNull28) {
/* 589 */                 agg_isNull21 = false;
/* 590 */                 agg_value23 = agg_value30;
/* 591 */               }
/* 592 */             }
/* 593 */             // update unsafe row buffer
/* 594 */             if (!agg_isNull13) {
/* 595 */               agg_unsafeRowAggBuffer.setDouble(0, agg_value15);
/* 596 */             } else {
/* 597 */               agg_unsafeRowAggBuffer.setNullAt(0);
/* 598 */             }
/* 599 */
/* 600 */             if (!agg_isNull21) {
/* 601 */               agg_unsafeRowAggBuffer.setDouble(1, agg_value23);
/* 602 */             } else {
/* 603 */               agg_unsafeRowAggBuffer.setNullAt(1);
/* 604 */             }
/* 605 */
/* 606 */           }
/* 607 */
/* 608 */         }
/* 609 */         // shouldStop check is eliminated
/* 610 */       }
/* 611 */       scan_batchIdx = scan_numRows;
/* 612 */       scan_batch = null;
/* 613 */       scan_nextBatch();
/* 614 */     }
/* 615 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 616 */     scan_scanTime1 = 0;
/* 617 */
/* 618 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 619 */
/* 620 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 621 */   }
/* 622 */
/* 623 */   private void wholestagecodegen_init_2() {
/* 624 */     project_result1 = new UnsafeRow(2);
/* 625 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 626 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 2);
/* 627 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 628 */
/* 629 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 630 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 631 */
/* 632 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 633 */     bhj_result1 = new UnsafeRow(5);
/* 634 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 635 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 5);
/* 636 */     project_result2 = new UnsafeRow(3);
/* 637 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 638 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 3);
/* 639 */
/* 640 */   }
/* 641 */
/* 642 */   private void wholestagecodegen_init_1() {
/* 643 */     filter_result = new UnsafeRow(3);
/* 644 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 645 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 646 */     project_result = new UnsafeRow(3);
/* 647 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 648 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 3);
/* 649 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[11];
/* 650 */
/* 651 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 652 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 653 */
/* 654 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 655 */     bhj_result = new UnsafeRow(4);
/* 656 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 657 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 658 */
/* 659 */   }
/* 660 */
/* 661 */   protected void processNext() throws java.io.IOException {
/* 662 */     if (!agg_initAgg) {
/* 663 */       agg_initAgg = true;
/* 664 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 665 */       agg_doAggregateWithKeys();
/* 666 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 667 */     }
/* 668 */
/* 669 */     // output the result
/* 670 */
/* 671 */     while (agg_fastHashMapIter.next()) {
/* 672 */       wholestagecodegen_numOutputRows.add(1);
/* 673 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 674 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 675 */
/* 676 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 677 */
/* 678 */       append(agg_resultRow.copy());
/* 679 */
/* 680 */       if (shouldStop()) return;
/* 681 */     }
/* 682 */     agg_fastHashMap.close();
/* 683 */
/* 684 */     while (agg_mapIter.next()) {
/* 685 */       wholestagecodegen_numOutputRows.add(1);
/* 686 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 687 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 688 */
/* 689 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 690 */
/* 691 */       append(agg_resultRow.copy());
/* 692 */
/* 693 */       if (shouldStop()) return;
/* 694 */     }
/* 695 */
/* 696 */     agg_mapIter.close();
/* 697 */     if (agg_sorter == null) {
/* 698 */       agg_hashMap.free();
/* 699 */     }
/* 700 */   }
/* 701 */ }

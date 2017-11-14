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
/* 066 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 067 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 068 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 069 */   private UnsafeRow bhj_result3;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 072 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast4;
/* 073 */   private org.apache.spark.sql.execution.joins.UnsafeHashedRelation bhj_relation4;
/* 074 */   private UnsafeRow bhj_result4;
/* 075 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder4;
/* 076 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter4;
/* 077 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows4;
/* 078 */   private UnsafeRow bhj_result5;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder5;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter5;
/* 081 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows1;
/* 082 */   private UnsafeRow filter_result1;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder1;
/* 084 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter1;
/* 085 */   private UnsafeRow project_result4;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 087 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 088 */   private UnsafeRow agg_result2;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 090 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 091 */   private int agg_value6;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 093 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 094 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 095 */
/* 096 */   public GeneratedIterator(Object[] references) {
/* 097 */     this.references = references;
/* 098 */   }
/* 099 */
/* 100 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 101 */     partitionIndex = index;
/* 102 */     this.inputs = inputs;
/* 103 */     wholestagecodegen_init_0();
/* 104 */     wholestagecodegen_init_1();
/* 105 */     wholestagecodegen_init_2();
/* 106 */     wholestagecodegen_init_3();
/* 107 */     wholestagecodegen_init_4();
/* 108 */     wholestagecodegen_init_5();
/* 109 */     wholestagecodegen_init_6();
/* 110 */
/* 111 */   }
/* 112 */
/* 113 */   private void wholestagecodegen_init_0() {
/* 114 */     agg_initAgg = false;
/* 115 */
/* 116 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 117 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 118 */
/* 119 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 120 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 121 */     scan_input = inputs[0];
/* 122 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 123 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 124 */     scan_scanTime1 = 0;
/* 125 */     scan_batch = null;
/* 126 */     scan_batchIdx = 0;
/* 127 */     scan_colInstance0 = null;
/* 128 */     scan_colInstance1 = null;
/* 129 */     scan_colInstance2 = null;
/* 130 */     scan_colInstance3 = null;
/* 131 */     scan_result = new UnsafeRow(4);
/* 132 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 133 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 4);
/* 134 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 135 */
/* 136 */   }
/* 137 */
/* 138 */   private void wholestagecodegen_init_3() {
/* 139 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 140 */
/* 141 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 142 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 143 */
/* 144 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 145 */     bhj_result2 = new UnsafeRow(6);
/* 146 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 64);
/* 147 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 6);
/* 148 */     project_result3 = new UnsafeRow(4);
/* 149 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 64);
/* 150 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 4);
/* 151 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 152 */
/* 153 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 154 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 155 */
/* 156 */   }
/* 157 */
/* 158 */   private void scan_nextBatch() throws java.io.IOException {
/* 159 */     long getBatchStart = System.nanoTime();
/* 160 */     if (scan_input.hasNext()) {
/* 161 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 162 */       scan_numOutputRows.add(scan_batch.numRows());
/* 163 */       scan_batchIdx = 0;
/* 164 */       scan_colInstance0 = scan_batch.column(0);
/* 165 */       scan_colInstance1 = scan_batch.column(1);
/* 166 */       scan_colInstance2 = scan_batch.column(2);
/* 167 */       scan_colInstance3 = scan_batch.column(3);
/* 168 */
/* 169 */     }
/* 170 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 171 */   }
/* 172 */
/* 173 */   public class agg_FastHashMap {
/* 174 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 175 */     private int[] buckets;
/* 176 */     private int capacity = 1 << 16;
/* 177 */     private double loadFactor = 0.5;
/* 178 */     private int numBuckets = (int) (capacity / loadFactor);
/* 179 */     private int maxSteps = 2;
/* 180 */     private int numRows = 0;
/* 181 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType)
/* 182 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.StringType);
/* 183 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 184 */     private Object emptyVBase;
/* 185 */     private long emptyVOff;
/* 186 */     private int emptyVLen;
/* 187 */     private boolean isBatchFull = false;
/* 188 */
/* 189 */     public agg_FastHashMap(
/* 190 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 191 */       InternalRow emptyAggregationBuffer) {
/* 192 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 193 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 194 */
/* 195 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 196 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 197 */
/* 198 */       emptyVBase = emptyBuffer;
/* 199 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 200 */       emptyVLen = emptyBuffer.length;
/* 201 */
/* 202 */       buckets = new int[numBuckets];
/* 203 */       java.util.Arrays.fill(buckets, -1);
/* 204 */     }
/* 205 */
/* 206 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key, UTF8String agg_key1) {
/* 207 */       long h = hash(agg_key, agg_key1);
/* 208 */       int step = 0;
/* 209 */       int idx = (int) h & (numBuckets - 1);
/* 210 */       while (step < maxSteps) {
/* 211 */         // Return bucket index if it's either an empty slot or already contains the key
/* 212 */         if (buckets[idx] == -1) {
/* 213 */           if (numRows < capacity && !isBatchFull) {
/* 214 */             // creating the unsafe for new entry
/* 215 */             UnsafeRow agg_result = new UnsafeRow(2);
/* 216 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 217 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 218 */               64);
/* 219 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 220 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 221 */               agg_holder,
/* 222 */               2);
/* 223 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 224 */             agg_rowWriter.zeroOutNullBytes();
/* 225 */             agg_rowWriter.write(0, agg_key);
/* 226 */             agg_rowWriter.write(1, agg_key1);
/* 227 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 228 */             Object kbase = agg_result.getBaseObject();
/* 229 */             long koff = agg_result.getBaseOffset();
/* 230 */             int klen = agg_result.getSizeInBytes();
/* 231 */
/* 232 */             UnsafeRow vRow
/* 233 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 234 */             if (vRow == null) {
/* 235 */               isBatchFull = true;
/* 236 */             } else {
/* 237 */               buckets[idx] = numRows++;
/* 238 */             }
/* 239 */             return vRow;
/* 240 */           } else {
/* 241 */             // No more space
/* 242 */             return null;
/* 243 */           }
/* 244 */         } else if (equals(idx, agg_key, agg_key1)) {
/* 245 */           return batch.getValueRow(buckets[idx]);
/* 246 */         }
/* 247 */         idx = (idx + 1) & (numBuckets - 1);
/* 248 */         step++;
/* 249 */       }
/* 250 */       // Didn't find it
/* 251 */       return null;
/* 252 */     }
/* 253 */
/* 254 */     private boolean equals(int idx, UTF8String agg_key, UTF8String agg_key1) {
/* 255 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 256 */       return (row.getUTF8String(0).equals(agg_key)) && (row.getUTF8String(1).equals(agg_key1));
/* 257 */     }
/* 258 */
/* 259 */     private long hash(UTF8String agg_key, UTF8String agg_key1) {
/* 260 */       long agg_hash = 0;
/* 261 */
/* 262 */       int agg_result = 0;
/* 263 */       byte[] agg_bytes = agg_key.getBytes();
/* 264 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 265 */         int agg_hash1 = agg_bytes[i];
/* 266 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 267 */       }
/* 268 */
/* 269 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 270 */
/* 271 */       int agg_result1 = 0;
/* 272 */       byte[] agg_bytes1 = agg_key1.getBytes();
/* 273 */       for (int i = 0; i < agg_bytes1.length; i++) {
/* 274 */         int agg_hash2 = agg_bytes1[i];
/* 275 */         agg_result1 = (agg_result1 ^ (0x9e3779b9)) + agg_hash2 + (agg_result1 << 6) + (agg_result1 >>> 2);
/* 276 */       }
/* 277 */
/* 278 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 279 */
/* 280 */       return agg_hash;
/* 281 */     }
/* 282 */
/* 283 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 284 */       return batch.rowIterator();
/* 285 */     }
/* 286 */
/* 287 */     public void close() {
/* 288 */       batch.close();
/* 289 */     }
/* 290 */
/* 291 */   }
/* 292 */
/* 293 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 294 */     agg_hashMap = agg_plan.createHashMap();
/* 295 */
/* 296 */     if (scan_batch == null) {
/* 297 */       scan_nextBatch();
/* 298 */     }
/* 299 */     while (scan_batch != null) {
/* 300 */       int scan_numRows = scan_batch.numRows();
/* 301 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 302 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 303 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 304 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 305 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 306 */
/* 307 */         if (!(!(scan_isNull1))) continue;
/* 308 */
/* 309 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 310 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 311 */
/* 312 */         if (!(!(scan_isNull))) continue;
/* 313 */
/* 314 */         filter_numOutputRows.add(1);
/* 315 */
/* 316 */         // generate join key for stream side
/* 317 */
/* 318 */         boolean bhj_isNull = false;
/* 319 */         long bhj_value = -1L;
/* 320 */         if (!false) {
/* 321 */           bhj_value = (long) scan_value1;
/* 322 */         }
/* 323 */         // find matches from HashedRelation
/* 324 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 325 */         if (bhj_matched == null) continue;
/* 326 */
/* 327 */         bhj_numOutputRows.add(1);
/* 328 */
/* 329 */         boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 330 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 331 */
/* 332 */         // generate join key for stream side
/* 333 */
/* 334 */         boolean bhj_isNull10 = bhj_isNull3;
/* 335 */         long bhj_value10 = -1L;
/* 336 */         if (!bhj_isNull3) {
/* 337 */           bhj_value10 = (long) bhj_value3;
/* 338 */         }
/* 339 */         // find matches from HashedRelation
/* 340 */         UnsafeRow bhj_matched1 = bhj_isNull10 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value10);
/* 341 */         if (bhj_matched1 == null) continue;
/* 342 */
/* 343 */         bhj_numOutputRows1.add(1);
/* 344 */
/* 345 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 346 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 347 */
/* 348 */         // generate join key for stream side
/* 349 */
/* 350 */         boolean bhj_isNull22 = scan_isNull3;
/* 351 */         long bhj_value22 = -1L;
/* 352 */         if (!scan_isNull3) {
/* 353 */           bhj_value22 = (long) scan_value3;
/* 354 */         }
/* 355 */         // find matches from HashedRelation
/* 356 */         UnsafeRow bhj_matched2 = bhj_isNull22 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value22);
/* 357 */         if (bhj_matched2 == null) continue;
/* 358 */
/* 359 */         bhj_numOutputRows2.add(1);
/* 360 */
/* 361 */         // generate join key for stream side
/* 362 */
/* 363 */         boolean bhj_isNull31 = false;
/* 364 */         long bhj_value31 = -1L;
/* 365 */         if (!false) {
/* 366 */           bhj_value31 = (long) scan_value;
/* 367 */         }
/* 368 */         // find matches from HashedRelation
/* 369 */         UnsafeRow bhj_matched3 = bhj_isNull31 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value31);
/* 370 */         if (bhj_matched3 == null) continue;
/* 371 */
/* 372 */         bhj_numOutputRows3.add(1);
/* 373 */
/* 374 */         boolean bhj_isNull34 = bhj_matched3.isNullAt(1);
/* 375 */         UTF8String bhj_value34 = bhj_isNull34 ? null : (bhj_matched3.getUTF8String(1));
/* 376 */
/* 377 */         // generate join key for stream side
/* 378 */
/* 379 */         bhj_holder4.reset();
/* 380 */
/* 381 */         bhj_rowWriter4.zeroOutNullBytes();
/* 382 */
/* 383 */         if (bhj_isNull34) {
/* 384 */           bhj_rowWriter4.setNullAt(0);
/* 385 */         } else {
/* 386 */           bhj_rowWriter4.write(0, bhj_value34);
/* 387 */         }
/* 388 */         bhj_result4.setTotalSize(bhj_holder4.totalSize());
/* 389 */
/* 390 */         // find matches from HashRelation
/* 391 */         scala.collection.Iterator bhj_matches = bhj_result4.anyNull() ? null : (scala.collection.Iterator)bhj_relation4.get(bhj_result4);
/* 392 */         boolean bhj_exists = false;
/* 393 */         if (bhj_matches != null) {
/* 394 */           while (!bhj_exists && bhj_matches.hasNext()) {
/* 395 */             UnsafeRow bhj_matched4 = (UnsafeRow) bhj_matches.next();
/* 396 */             bhj_exists = true;
/* 397 */           }
/* 398 */         }
/* 399 */         bhj_numOutputRows4.add(1);
/* 400 */
/* 401 */         boolean bhj_isNull14 = bhj_matched1.isNullAt(2);
/* 402 */         UTF8String bhj_value14 = bhj_isNull14 ? null : (bhj_matched1.getUTF8String(2));
/* 403 */
/* 404 */         boolean filter_isNull10 = true;
/* 405 */         UTF8String filter_value10 = null;
/* 406 */
/* 407 */         if (!bhj_isNull14) {
/* 408 */           filter_isNull10 = false; // resultCode could change nullability.
/* 409 */           filter_value10 = bhj_value14.substringSQL(1, 5);
/* 410 */
/* 411 */         }
/* 412 */         boolean filter_value9 = false;
/* 413 */         boolean filter_isNull9 = filter_isNull10;
/* 414 */         if (!filter_isNull9) {
/* 415 */           if (!filter_value9) {
/* 416 */             if (false) {
/* 417 */               filter_isNull9 = true;
/* 418 */             } else if (filter_value10.equals(((UTF8String) references[20]))) {
/* 419 */               filter_isNull9 = false;
/* 420 */               filter_value9 = true;
/* 421 */             }
/* 422 */           }
/* 423 */
/* 424 */           if (!filter_value9) {
/* 425 */             if (false) {
/* 426 */               filter_isNull9 = true;
/* 427 */             } else if (filter_value10.equals(((UTF8String) references[21]))) {
/* 428 */               filter_isNull9 = false;
/* 429 */               filter_value9 = true;
/* 430 */             }
/* 431 */           }
/* 432 */
/* 433 */           if (!filter_value9) {
/* 434 */             if (false) {
/* 435 */               filter_isNull9 = true;
/* 436 */             } else if (filter_value10.equals(((UTF8String) references[22]))) {
/* 437 */               filter_isNull9 = false;
/* 438 */               filter_value9 = true;
/* 439 */             }
/* 440 */           }
/* 441 */
/* 442 */           if (!filter_value9) {
/* 443 */             if (false) {
/* 444 */               filter_isNull9 = true;
/* 445 */             } else if (filter_value10.equals(((UTF8String) references[23]))) {
/* 446 */               filter_isNull9 = false;
/* 447 */               filter_value9 = true;
/* 448 */             }
/* 449 */           }
/* 450 */
/* 451 */           if (!filter_value9) {
/* 452 */             if (false) {
/* 453 */               filter_isNull9 = true;
/* 454 */             } else if (filter_value10.equals(((UTF8String) references[24]))) {
/* 455 */               filter_isNull9 = false;
/* 456 */               filter_value9 = true;
/* 457 */             }
/* 458 */           }
/* 459 */
/* 460 */           if (!filter_value9) {
/* 461 */             if (false) {
/* 462 */               filter_isNull9 = true;
/* 463 */             } else if (filter_value10.equals(((UTF8String) references[25]))) {
/* 464 */               filter_isNull9 = false;
/* 465 */               filter_value9 = true;
/* 466 */             }
/* 467 */           }
/* 468 */
/* 469 */           if (!filter_value9) {
/* 470 */             if (false) {
/* 471 */               filter_isNull9 = true;
/* 472 */             } else if (filter_value10.equals(((UTF8String) references[26]))) {
/* 473 */               filter_isNull9 = false;
/* 474 */               filter_value9 = true;
/* 475 */             }
/* 476 */           }
/* 477 */
/* 478 */           if (!filter_value9) {
/* 479 */             if (false) {
/* 480 */               filter_isNull9 = true;
/* 481 */             } else if (filter_value10.equals(((UTF8String) references[27]))) {
/* 482 */               filter_isNull9 = false;
/* 483 */               filter_value9 = true;
/* 484 */             }
/* 485 */           }
/* 486 */
/* 487 */           if (!filter_value9) {
/* 488 */             if (false) {
/* 489 */               filter_isNull9 = true;
/* 490 */             } else if (filter_value10.equals(((UTF8String) references[28]))) {
/* 491 */               filter_isNull9 = false;
/* 492 */               filter_value9 = true;
/* 493 */             }
/* 494 */           }
/* 495 */
/* 496 */         }
/* 497 */         boolean filter_isNull8 = false;
/* 498 */         boolean filter_value8 = true;
/* 499 */
/* 500 */         if (!filter_isNull9 && filter_value9) {
/* 501 */         } else {
/* 502 */           if (!false && bhj_exists) {
/* 503 */           } else if (!filter_isNull9 && !false) {
/* 504 */             filter_value8 = false;
/* 505 */           } else {
/* 506 */             filter_isNull8 = true;
/* 507 */           }
/* 508 */         }
/* 509 */         if (filter_isNull8 || !filter_value8) continue;
/* 510 */
/* 511 */         filter_numOutputRows1.add(1);
/* 512 */
/* 513 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 514 */         double scan_value2 = scan_isNull2 ? -1.0 : (scan_colInstance2.getDouble(scan_rowIdx));
/* 515 */         boolean bhj_isNull13 = bhj_matched1.isNullAt(1);
/* 516 */         UTF8String bhj_value13 = bhj_isNull13 ? null : (bhj_matched1.getUTF8String(1));
/* 517 */
/* 518 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 519 */
/* 520 */         UnsafeRow agg_fastAggBuffer = null;
/* 521 */
/* 522 */         if (true) {
/* 523 */           if (!bhj_isNull14 && !bhj_isNull13) {
/* 524 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 525 */               bhj_value14, bhj_value13);
/* 526 */           }
/* 527 */         }
/* 528 */
/* 529 */         if (agg_fastAggBuffer == null) {
/* 530 */           // generate grouping key
/* 531 */           agg_holder.reset();
/* 532 */
/* 533 */           agg_rowWriter.zeroOutNullBytes();
/* 534 */
/* 535 */           if (bhj_isNull14) {
/* 536 */             agg_rowWriter.setNullAt(0);
/* 537 */           } else {
/* 538 */             agg_rowWriter.write(0, bhj_value14);
/* 539 */           }
/* 540 */
/* 541 */           if (bhj_isNull13) {
/* 542 */             agg_rowWriter.setNullAt(1);
/* 543 */           } else {
/* 544 */             agg_rowWriter.write(1, bhj_value13);
/* 545 */           }
/* 546 */           agg_result2.setTotalSize(agg_holder.totalSize());
/* 547 */           agg_value6 = 42;
/* 548 */
/* 549 */           if (!bhj_isNull14) {
/* 550 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value14.getBaseObject(), bhj_value14.getBaseOffset(), bhj_value14.numBytes(), agg_value6);
/* 551 */           }
/* 552 */
/* 553 */           if (!bhj_isNull13) {
/* 554 */             agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value13.getBaseObject(), bhj_value13.getBaseOffset(), bhj_value13.numBytes(), agg_value6);
/* 555 */           }
/* 556 */           if (true) {
/* 557 */             // try to get the buffer from hash map
/* 558 */             agg_unsafeRowAggBuffer =
/* 559 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 560 */           }
/* 561 */           if (agg_unsafeRowAggBuffer == null) {
/* 562 */             if (agg_sorter == null) {
/* 563 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 564 */             } else {
/* 565 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 566 */             }
/* 567 */
/* 568 */             // the hash map had be spilled, it should have enough memory now,
/* 569 */             // try  to allocate buffer again.
/* 570 */             agg_unsafeRowAggBuffer =
/* 571 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result2, agg_value6);
/* 572 */             if (agg_unsafeRowAggBuffer == null) {
/* 573 */               // failed to allocate the first page
/* 574 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 575 */             }
/* 576 */           }
/* 577 */         }
/* 578 */
/* 579 */         if (agg_fastAggBuffer != null) {
/* 580 */           // update fast row
/* 581 */
/* 582 */           // common sub-expressions
/* 583 */
/* 584 */           // evaluate aggregate function
/* 585 */           boolean agg_isNull17 = true;
/* 586 */           double agg_value18 = -1.0;
/* 587 */
/* 588 */           boolean agg_isNull19 = agg_fastAggBuffer.isNullAt(0);
/* 589 */           double agg_value20 = agg_isNull19 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 590 */           boolean agg_isNull18 = agg_isNull19;
/* 591 */           double agg_value19 = agg_value20;
/* 592 */           if (agg_isNull18) {
/* 593 */             boolean agg_isNull20 = false;
/* 594 */             double agg_value21 = -1.0;
/* 595 */             if (!false) {
/* 596 */               agg_value21 = (double) 0;
/* 597 */             }
/* 598 */             if (!agg_isNull20) {
/* 599 */               agg_isNull18 = false;
/* 600 */               agg_value19 = agg_value21;
/* 601 */             }
/* 602 */           }
/* 603 */
/* 604 */           if (!scan_isNull2) {
/* 605 */             agg_isNull17 = false; // resultCode could change nullability.
/* 606 */             agg_value18 = agg_value19 + scan_value2;
/* 607 */
/* 608 */           }
/* 609 */           boolean agg_isNull16 = agg_isNull17;
/* 610 */           double agg_value17 = agg_value18;
/* 611 */           if (agg_isNull16) {
/* 612 */             boolean agg_isNull23 = agg_fastAggBuffer.isNullAt(0);
/* 613 */             double agg_value24 = agg_isNull23 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 614 */             if (!agg_isNull23) {
/* 615 */               agg_isNull16 = false;
/* 616 */               agg_value17 = agg_value24;
/* 617 */             }
/* 618 */           }
/* 619 */           // update fast row
/* 620 */           if (!agg_isNull16) {
/* 621 */             agg_fastAggBuffer.setDouble(0, agg_value17);
/* 622 */           } else {
/* 623 */             agg_fastAggBuffer.setNullAt(0);
/* 624 */           }
/* 625 */
/* 626 */         } else {
/* 627 */           // update unsafe row
/* 628 */
/* 629 */           // common sub-expressions
/* 630 */
/* 631 */           // evaluate aggregate function
/* 632 */           boolean agg_isNull9 = true;
/* 633 */           double agg_value10 = -1.0;
/* 634 */
/* 635 */           boolean agg_isNull11 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 636 */           double agg_value12 = agg_isNull11 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 637 */           boolean agg_isNull10 = agg_isNull11;
/* 638 */           double agg_value11 = agg_value12;
/* 639 */           if (agg_isNull10) {
/* 640 */             boolean agg_isNull12 = false;
/* 641 */             double agg_value13 = -1.0;
/* 642 */             if (!false) {
/* 643 */               agg_value13 = (double) 0;
/* 644 */             }
/* 645 */             if (!agg_isNull12) {
/* 646 */               agg_isNull10 = false;
/* 647 */               agg_value11 = agg_value13;
/* 648 */             }
/* 649 */           }
/* 650 */
/* 651 */           if (!scan_isNull2) {
/* 652 */             agg_isNull9 = false; // resultCode could change nullability.
/* 653 */             agg_value10 = agg_value11 + scan_value2;
/* 654 */
/* 655 */           }
/* 656 */           boolean agg_isNull8 = agg_isNull9;
/* 657 */           double agg_value9 = agg_value10;
/* 658 */           if (agg_isNull8) {
/* 659 */             boolean agg_isNull15 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 660 */             double agg_value16 = agg_isNull15 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 661 */             if (!agg_isNull15) {
/* 662 */               agg_isNull8 = false;
/* 663 */               agg_value9 = agg_value16;
/* 664 */             }
/* 665 */           }
/* 666 */           // update unsafe row buffer
/* 667 */           if (!agg_isNull8) {
/* 668 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value9);
/* 669 */           } else {
/* 670 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 671 */           }
/* 672 */
/* 673 */         }
/* 674 */         // shouldStop check is eliminated
/* 675 */       }
/* 676 */       scan_batchIdx = scan_numRows;
/* 677 */       scan_batch = null;
/* 678 */       scan_nextBatch();
/* 679 */     }
/* 680 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 681 */     scan_scanTime1 = 0;
/* 682 */
/* 683 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 684 */
/* 685 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 686 */   }
/* 687 */
/* 688 */   private void wholestagecodegen_init_5() {
/* 689 */     this.bhj_rowWriter5 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder5, 7);
/* 690 */     this.filter_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 691 */     filter_result1 = new UnsafeRow(7);
/* 692 */     this.filter_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result1, 96);
/* 693 */     this.filter_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder1, 7);
/* 694 */     project_result4 = new UnsafeRow(3);
/* 695 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 64);
/* 696 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 3);
/* 697 */     agg_result2 = new UnsafeRow(2);
/* 698 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 64);
/* 699 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 700 */
/* 701 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 702 */
/* 703 */   }
/* 704 */
/* 705 */   private void wholestagecodegen_init_2() {
/* 706 */     project_result1 = new UnsafeRow(4);
/* 707 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 708 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 4);
/* 709 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[11];
/* 710 */
/* 711 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 712 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 713 */
/* 714 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 715 */     bhj_result1 = new UnsafeRow(7);
/* 716 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 64);
/* 717 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 718 */     project_result2 = new UnsafeRow(5);
/* 719 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 64);
/* 720 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 5);
/* 721 */
/* 722 */   }
/* 723 */
/* 724 */   private void wholestagecodegen_init_1() {
/* 725 */     filter_result = new UnsafeRow(4);
/* 726 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 727 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 4);
/* 728 */     project_result = new UnsafeRow(4);
/* 729 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 730 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 4);
/* 731 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[9];
/* 732 */
/* 733 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 734 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 735 */
/* 736 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 737 */     bhj_result = new UnsafeRow(6);
/* 738 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 739 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 6);
/* 740 */
/* 741 */   }
/* 742 */
/* 743 */   private void wholestagecodegen_init_4() {
/* 744 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 745 */     bhj_result3 = new UnsafeRow(6);
/* 746 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 96);
/* 747 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 6);
/* 748 */     this.bhj_broadcast4 = (org.apache.spark.broadcast.TorrentBroadcast) references[17];
/* 749 */
/* 750 */     bhj_relation4 = ((org.apache.spark.sql.execution.joins.UnsafeHashedRelation) bhj_broadcast4.value()).asReadOnlyCopy();
/* 751 */     incPeakExecutionMemory(bhj_relation4.estimatedSize());
/* 752 */
/* 753 */     bhj_result4 = new UnsafeRow(1);
/* 754 */     this.bhj_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result4, 32);
/* 755 */     this.bhj_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder4, 1);
/* 756 */     this.bhj_numOutputRows4 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 757 */     bhj_result5 = new UnsafeRow(7);
/* 758 */     this.bhj_holder5 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result5, 96);
/* 759 */
/* 760 */   }
/* 761 */
/* 762 */   private void wholestagecodegen_init_6() {
/* 763 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[29];
/* 764 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[30];
/* 765 */
/* 766 */   }
/* 767 */
/* 768 */   protected void processNext() throws java.io.IOException {
/* 769 */     if (!agg_initAgg) {
/* 770 */       agg_initAgg = true;
/* 771 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 772 */       agg_doAggregateWithKeys();
/* 773 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 774 */     }
/* 775 */
/* 776 */     // output the result
/* 777 */
/* 778 */     while (agg_fastHashMapIter.next()) {
/* 779 */       wholestagecodegen_numOutputRows.add(1);
/* 780 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 781 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 782 */
/* 783 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 784 */
/* 785 */       append(agg_resultRow);
/* 786 */
/* 787 */       if (shouldStop()) return;
/* 788 */     }
/* 789 */     agg_fastHashMap.close();
/* 790 */
/* 791 */     while (agg_mapIter.next()) {
/* 792 */       wholestagecodegen_numOutputRows.add(1);
/* 793 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 794 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 795 */
/* 796 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 797 */
/* 798 */       append(agg_resultRow);
/* 799 */
/* 800 */       if (shouldStop()) return;
/* 801 */     }
/* 802 */
/* 803 */     agg_mapIter.close();
/* 804 */     if (agg_sorter == null) {
/* 805 */       agg_hashMap.free();
/* 806 */     }
/* 807 */   }
/* 808 */ }

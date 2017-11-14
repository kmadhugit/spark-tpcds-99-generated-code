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
/* 015 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 016 */   private agg_FastHashMap agg_fastHashMap;
/* 017 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 018 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 019 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 020 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 023 */   private scala.collection.Iterator scan_input;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 026 */   private long scan_scanTime1;
/* 027 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 028 */   private int scan_batchIdx;
/* 029 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 030 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 035 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 036 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance8;
/* 038 */   private UnsafeRow scan_result;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 042 */   private UnsafeRow filter_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 045 */   private UnsafeRow project_result;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 047 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 048 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 049 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 051 */   private UnsafeRow bhj_result;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 054 */   private UnsafeRow project_result1;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 057 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 058 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 059 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 060 */   private UnsafeRow bhj_result1;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 063 */   private UnsafeRow project_result2;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 066 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 067 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 068 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 069 */   private UnsafeRow bhj_result2;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 072 */   private UnsafeRow project_result3;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 075 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 076 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 077 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 078 */   private UnsafeRow bhj_result3;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 081 */   private UnsafeRow project_result4;
/* 082 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 084 */   private UnsafeRow agg_result4;
/* 085 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 086 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 087 */   private int agg_value14;
/* 088 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 089 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 090 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 091 */
/* 092 */   public GeneratedIterator(Object[] references) {
/* 093 */     this.references = references;
/* 094 */   }
/* 095 */
/* 096 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 097 */     partitionIndex = index;
/* 098 */     this.inputs = inputs;
/* 099 */     wholestagecodegen_init_0();
/* 100 */     wholestagecodegen_init_1();
/* 101 */     wholestagecodegen_init_2();
/* 102 */     wholestagecodegen_init_3();
/* 103 */     wholestagecodegen_init_4();
/* 104 */     wholestagecodegen_init_5();
/* 105 */
/* 106 */   }
/* 107 */
/* 108 */   private void wholestagecodegen_init_0() {
/* 109 */     agg_initAgg = false;
/* 110 */
/* 111 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 112 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 113 */
/* 114 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 115 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 116 */     scan_input = inputs[0];
/* 117 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 118 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 119 */     scan_scanTime1 = 0;
/* 120 */     scan_batch = null;
/* 121 */     scan_batchIdx = 0;
/* 122 */     scan_colInstance0 = null;
/* 123 */     scan_colInstance1 = null;
/* 124 */     scan_colInstance2 = null;
/* 125 */     scan_colInstance3 = null;
/* 126 */     scan_colInstance4 = null;
/* 127 */     scan_colInstance5 = null;
/* 128 */     scan_colInstance6 = null;
/* 129 */     scan_colInstance7 = null;
/* 130 */     scan_colInstance8 = null;
/* 131 */     scan_result = new UnsafeRow(9);
/* 132 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 133 */
/* 134 */   }
/* 135 */
/* 136 */   private void wholestagecodegen_init_3() {
/* 137 */     project_result2 = new UnsafeRow(7);
/* 138 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 139 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 7);
/* 140 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[17];
/* 141 */
/* 142 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 143 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 144 */
/* 145 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 146 */     bhj_result2 = new UnsafeRow(8);
/* 147 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 0);
/* 148 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 8);
/* 149 */     project_result3 = new UnsafeRow(6);
/* 150 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 151 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 6);
/* 152 */
/* 153 */   }
/* 154 */
/* 155 */   private void scan_nextBatch() throws java.io.IOException {
/* 156 */     long getBatchStart = System.nanoTime();
/* 157 */     if (scan_input.hasNext()) {
/* 158 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 159 */       scan_numOutputRows.add(scan_batch.numRows());
/* 160 */       scan_batchIdx = 0;
/* 161 */       scan_colInstance0 = scan_batch.column(0);
/* 162 */       scan_colInstance1 = scan_batch.column(1);
/* 163 */       scan_colInstance2 = scan_batch.column(2);
/* 164 */       scan_colInstance3 = scan_batch.column(3);
/* 165 */       scan_colInstance4 = scan_batch.column(4);
/* 166 */       scan_colInstance5 = scan_batch.column(5);
/* 167 */       scan_colInstance6 = scan_batch.column(6);
/* 168 */       scan_colInstance7 = scan_batch.column(7);
/* 169 */       scan_colInstance8 = scan_batch.column(8);
/* 170 */
/* 171 */     }
/* 172 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 173 */   }
/* 174 */
/* 175 */   public class agg_FastHashMap {
/* 176 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 177 */     private int[] buckets;
/* 178 */     private int capacity = 1 << 16;
/* 179 */     private double loadFactor = 0.5;
/* 180 */     private int numBuckets = (int) (capacity / loadFactor);
/* 181 */     private int maxSteps = 2;
/* 182 */     private int numRows = 0;
/* 183 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 184 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 185 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 186 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType);
/* 187 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 188 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 189 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 190 */     private Object emptyVBase;
/* 191 */     private long emptyVOff;
/* 192 */     private int emptyVLen;
/* 193 */     private boolean isBatchFull = false;
/* 194 */
/* 195 */     public agg_FastHashMap(
/* 196 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 197 */       InternalRow emptyAggregationBuffer) {
/* 198 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 199 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 200 */
/* 201 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 202 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 203 */
/* 204 */       emptyVBase = emptyBuffer;
/* 205 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 206 */       emptyVLen = emptyBuffer.length;
/* 207 */
/* 208 */       buckets = new int[numBuckets];
/* 209 */       java.util.Arrays.fill(buckets, -1);
/* 210 */     }
/* 211 */
/* 212 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key, int agg_key1, int agg_key2, UTF8String agg_key3) {
/* 213 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3);
/* 214 */       int step = 0;
/* 215 */       int idx = (int) h & (numBuckets - 1);
/* 216 */       while (step < maxSteps) {
/* 217 */         // Return bucket index if it's either an empty slot or already contains the key
/* 218 */         if (buckets[idx] == -1) {
/* 219 */           if (numRows < capacity && !isBatchFull) {
/* 220 */             // creating the unsafe for new entry
/* 221 */             UnsafeRow agg_result = new UnsafeRow(4);
/* 222 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 223 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 224 */               32);
/* 225 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 226 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 227 */               agg_holder,
/* 228 */               4);
/* 229 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 230 */             agg_rowWriter.zeroOutNullBytes();
/* 231 */             agg_rowWriter.write(0, agg_key);
/* 232 */             agg_rowWriter.write(1, agg_key1);
/* 233 */             agg_rowWriter.write(2, agg_key2);
/* 234 */             agg_rowWriter.write(3, agg_key3);
/* 235 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 236 */             Object kbase = agg_result.getBaseObject();
/* 237 */             long koff = agg_result.getBaseOffset();
/* 238 */             int klen = agg_result.getSizeInBytes();
/* 239 */
/* 240 */             UnsafeRow vRow
/* 241 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 242 */             if (vRow == null) {
/* 243 */               isBatchFull = true;
/* 244 */             } else {
/* 245 */               buckets[idx] = numRows++;
/* 246 */             }
/* 247 */             return vRow;
/* 248 */           } else {
/* 249 */             // No more space
/* 250 */             return null;
/* 251 */           }
/* 252 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3)) {
/* 253 */           return batch.getValueRow(buckets[idx]);
/* 254 */         }
/* 255 */         idx = (idx + 1) & (numBuckets - 1);
/* 256 */         step++;
/* 257 */       }
/* 258 */       // Didn't find it
/* 259 */       return null;
/* 260 */     }
/* 261 */
/* 262 */     private boolean equals(int idx, int agg_key, int agg_key1, int agg_key2, UTF8String agg_key3) {
/* 263 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 264 */       return (row.getInt(0) == agg_key) && (row.getInt(1) == agg_key1) && (row.getInt(2) == agg_key2) && (row.getUTF8String(3).equals(agg_key3));
/* 265 */     }
/* 266 */
/* 267 */     private long hash(int agg_key, int agg_key1, int agg_key2, UTF8String agg_key3) {
/* 268 */       long agg_hash = 0;
/* 269 */
/* 270 */       int agg_result = agg_key;
/* 271 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 272 */
/* 273 */       int agg_result1 = agg_key1;
/* 274 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 275 */
/* 276 */       int agg_result2 = agg_key2;
/* 277 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 278 */
/* 279 */       int agg_result3 = 0;
/* 280 */       byte[] agg_bytes = agg_key3.getBytes();
/* 281 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 282 */         int agg_hash1 = agg_bytes[i];
/* 283 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash1 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 284 */       }
/* 285 */
/* 286 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 287 */
/* 288 */       return agg_hash;
/* 289 */     }
/* 290 */
/* 291 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 292 */       return batch.rowIterator();
/* 293 */     }
/* 294 */
/* 295 */     public void close() {
/* 296 */       batch.close();
/* 297 */     }
/* 298 */
/* 299 */   }
/* 300 */
/* 301 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 302 */     agg_hashMap = agg_plan.createHashMap();
/* 303 */
/* 304 */     if (scan_batch == null) {
/* 305 */       scan_nextBatch();
/* 306 */     }
/* 307 */     while (scan_batch != null) {
/* 308 */       int scan_numRows = scan_batch.numRows();
/* 309 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 310 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 311 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 312 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 313 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 314 */
/* 315 */         if (!(!(scan_isNull3))) continue;
/* 316 */
/* 317 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 318 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 319 */
/* 320 */         if (!(!(scan_isNull1))) continue;
/* 321 */
/* 322 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 323 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 324 */
/* 325 */         if (!(!(scan_isNull2))) continue;
/* 326 */
/* 327 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 328 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 329 */
/* 330 */         if (!(!(scan_isNull))) continue;
/* 331 */
/* 332 */         filter_numOutputRows.add(1);
/* 333 */
/* 334 */         boolean scan_isNull8 = scan_colInstance8.isNullAt(scan_rowIdx);
/* 335 */         int scan_value8 = scan_isNull8 ? -1 : (scan_colInstance8.getInt(scan_rowIdx));
/* 336 */
/* 337 */         // generate join key for stream side
/* 338 */
/* 339 */         boolean bhj_isNull = scan_isNull8;
/* 340 */         long bhj_value = -1L;
/* 341 */         if (!scan_isNull8) {
/* 342 */           bhj_value = (long) scan_value8;
/* 343 */         }
/* 344 */         // find matches from HashedRelation
/* 345 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 346 */         if (bhj_matched == null) continue;
/* 347 */
/* 348 */         bhj_numOutputRows.add(1);
/* 349 */
/* 350 */         // generate join key for stream side
/* 351 */
/* 352 */         boolean bhj_isNull13 = false;
/* 353 */         long bhj_value13 = -1L;
/* 354 */         if (!false) {
/* 355 */           bhj_value13 = (long) scan_value3;
/* 356 */         }
/* 357 */         // find matches from HashedRelation
/* 358 */         UnsafeRow bhj_matched1 = bhj_isNull13 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value13);
/* 359 */         if (bhj_matched1 == null) continue;
/* 360 */
/* 361 */         bhj_numOutputRows1.add(1);
/* 362 */
/* 363 */         // generate join key for stream side
/* 364 */
/* 365 */         boolean bhj_isNull25 = false;
/* 366 */         long bhj_value25 = -1L;
/* 367 */         if (!false) {
/* 368 */           bhj_value25 = (long) scan_value1;
/* 369 */         }
/* 370 */         // find matches from HashedRelation
/* 371 */         UnsafeRow bhj_matched2 = bhj_isNull25 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value25);
/* 372 */         if (bhj_matched2 == null) continue;
/* 373 */
/* 374 */         bhj_numOutputRows2.add(1);
/* 375 */
/* 376 */         // generate join key for stream side
/* 377 */
/* 378 */         boolean bhj_isNull36 = false;
/* 379 */         long bhj_value36 = -1L;
/* 380 */         if (!false) {
/* 381 */           bhj_value36 = (long) scan_value2;
/* 382 */         }
/* 383 */         // find matches from HashedRelation
/* 384 */         UnsafeRow bhj_matched3 = bhj_isNull36 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value36);
/* 385 */         if (bhj_matched3 == null) continue;
/* 386 */
/* 387 */         bhj_numOutputRows3.add(1);
/* 388 */
/* 389 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 390 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 391 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 392 */         double scan_value5 = scan_isNull5 ? -1.0 : (scan_colInstance5.getDouble(scan_rowIdx));
/* 393 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 394 */         double scan_value6 = scan_isNull6 ? -1.0 : (scan_colInstance6.getDouble(scan_rowIdx));
/* 395 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 396 */         double scan_value7 = scan_isNull7 ? -1.0 : (scan_colInstance7.getDouble(scan_rowIdx));
/* 397 */         boolean bhj_isNull39 = bhj_matched3.isNullAt(1);
/* 398 */         UTF8String bhj_value39 = bhj_isNull39 ? null : (bhj_matched3.getUTF8String(1));
/* 399 */
/* 400 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 401 */
/* 402 */         UnsafeRow agg_fastAggBuffer = null;
/* 403 */
/* 404 */         if (true) {
/* 405 */           if (!scan_isNull4 && !false && !false && !bhj_isNull39) {
/* 406 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 407 */               scan_value4, scan_value, scan_value2, bhj_value39);
/* 408 */           }
/* 409 */         }
/* 410 */
/* 411 */         if (agg_fastAggBuffer == null) {
/* 412 */           // generate grouping key
/* 413 */           agg_holder.reset();
/* 414 */
/* 415 */           agg_rowWriter.zeroOutNullBytes();
/* 416 */
/* 417 */           if (scan_isNull4) {
/* 418 */             agg_rowWriter.setNullAt(0);
/* 419 */           } else {
/* 420 */             agg_rowWriter.write(0, scan_value4);
/* 421 */           }
/* 422 */
/* 423 */           agg_rowWriter.write(1, scan_value);
/* 424 */
/* 425 */           agg_rowWriter.write(2, scan_value2);
/* 426 */
/* 427 */           if (bhj_isNull39) {
/* 428 */             agg_rowWriter.setNullAt(3);
/* 429 */           } else {
/* 430 */             agg_rowWriter.write(3, bhj_value39);
/* 431 */           }
/* 432 */           agg_result4.setTotalSize(agg_holder.totalSize());
/* 433 */           agg_value14 = 42;
/* 434 */
/* 435 */           if (!scan_isNull4) {
/* 436 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value4, agg_value14);
/* 437 */           }
/* 438 */
/* 439 */           if (!false) {
/* 440 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value, agg_value14);
/* 441 */           }
/* 442 */
/* 443 */           if (!false) {
/* 444 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value2, agg_value14);
/* 445 */           }
/* 446 */
/* 447 */           if (!bhj_isNull39) {
/* 448 */             agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value39.getBaseObject(), bhj_value39.getBaseOffset(), bhj_value39.numBytes(), agg_value14);
/* 449 */           }
/* 450 */           if (true) {
/* 451 */             // try to get the buffer from hash map
/* 452 */             agg_unsafeRowAggBuffer =
/* 453 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value14);
/* 454 */           }
/* 455 */           if (agg_unsafeRowAggBuffer == null) {
/* 456 */             if (agg_sorter == null) {
/* 457 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 458 */             } else {
/* 459 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 460 */             }
/* 461 */
/* 462 */             // the hash map had be spilled, it should have enough memory now,
/* 463 */             // try  to allocate buffer again.
/* 464 */             agg_unsafeRowAggBuffer =
/* 465 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value14);
/* 466 */             if (agg_unsafeRowAggBuffer == null) {
/* 467 */               // failed to allocate the first page
/* 468 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 469 */             }
/* 470 */           }
/* 471 */         }
/* 472 */
/* 473 */         if (agg_fastAggBuffer != null) {
/* 474 */           // update fast row
/* 475 */
/* 476 */           // common sub-expressions
/* 477 */
/* 478 */           // evaluate aggregate function
/* 479 */           boolean agg_isNull41 = true;
/* 480 */           double agg_value44 = -1.0;
/* 481 */
/* 482 */           boolean agg_isNull43 = agg_fastAggBuffer.isNullAt(0);
/* 483 */           double agg_value46 = agg_isNull43 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 484 */           boolean agg_isNull42 = agg_isNull43;
/* 485 */           double agg_value45 = agg_value46;
/* 486 */           if (agg_isNull42) {
/* 487 */             boolean agg_isNull44 = false;
/* 488 */             double agg_value47 = -1.0;
/* 489 */             if (!false) {
/* 490 */               agg_value47 = (double) 0;
/* 491 */             }
/* 492 */             if (!agg_isNull44) {
/* 493 */               agg_isNull42 = false;
/* 494 */               agg_value45 = agg_value47;
/* 495 */             }
/* 496 */           }
/* 497 */
/* 498 */           if (!scan_isNull5) {
/* 499 */             agg_isNull41 = false; // resultCode could change nullability.
/* 500 */             agg_value44 = agg_value45 + scan_value5;
/* 501 */
/* 502 */           }
/* 503 */           boolean agg_isNull40 = agg_isNull41;
/* 504 */           double agg_value43 = agg_value44;
/* 505 */           if (agg_isNull40) {
/* 506 */             boolean agg_isNull47 = agg_fastAggBuffer.isNullAt(0);
/* 507 */             double agg_value50 = agg_isNull47 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 508 */             if (!agg_isNull47) {
/* 509 */               agg_isNull40 = false;
/* 510 */               agg_value43 = agg_value50;
/* 511 */             }
/* 512 */           }
/* 513 */           boolean agg_isNull49 = true;
/* 514 */           double agg_value52 = -1.0;
/* 515 */
/* 516 */           boolean agg_isNull51 = agg_fastAggBuffer.isNullAt(1);
/* 517 */           double agg_value54 = agg_isNull51 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 518 */           boolean agg_isNull50 = agg_isNull51;
/* 519 */           double agg_value53 = agg_value54;
/* 520 */           if (agg_isNull50) {
/* 521 */             boolean agg_isNull52 = false;
/* 522 */             double agg_value55 = -1.0;
/* 523 */             if (!false) {
/* 524 */               agg_value55 = (double) 0;
/* 525 */             }
/* 526 */             if (!agg_isNull52) {
/* 527 */               agg_isNull50 = false;
/* 528 */               agg_value53 = agg_value55;
/* 529 */             }
/* 530 */           }
/* 531 */
/* 532 */           if (!scan_isNull6) {
/* 533 */             agg_isNull49 = false; // resultCode could change nullability.
/* 534 */             agg_value52 = agg_value53 + scan_value6;
/* 535 */
/* 536 */           }
/* 537 */           boolean agg_isNull48 = agg_isNull49;
/* 538 */           double agg_value51 = agg_value52;
/* 539 */           if (agg_isNull48) {
/* 540 */             boolean agg_isNull55 = agg_fastAggBuffer.isNullAt(1);
/* 541 */             double agg_value58 = agg_isNull55 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 542 */             if (!agg_isNull55) {
/* 543 */               agg_isNull48 = false;
/* 544 */               agg_value51 = agg_value58;
/* 545 */             }
/* 546 */           }
/* 547 */           boolean agg_isNull57 = true;
/* 548 */           double agg_value60 = -1.0;
/* 549 */
/* 550 */           boolean agg_isNull59 = agg_fastAggBuffer.isNullAt(2);
/* 551 */           double agg_value62 = agg_isNull59 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 552 */           boolean agg_isNull58 = agg_isNull59;
/* 553 */           double agg_value61 = agg_value62;
/* 554 */           if (agg_isNull58) {
/* 555 */             boolean agg_isNull60 = false;
/* 556 */             double agg_value63 = -1.0;
/* 557 */             if (!false) {
/* 558 */               agg_value63 = (double) 0;
/* 559 */             }
/* 560 */             if (!agg_isNull60) {
/* 561 */               agg_isNull58 = false;
/* 562 */               agg_value61 = agg_value63;
/* 563 */             }
/* 564 */           }
/* 565 */
/* 566 */           if (!scan_isNull7) {
/* 567 */             agg_isNull57 = false; // resultCode could change nullability.
/* 568 */             agg_value60 = agg_value61 + scan_value7;
/* 569 */
/* 570 */           }
/* 571 */           boolean agg_isNull56 = agg_isNull57;
/* 572 */           double agg_value59 = agg_value60;
/* 573 */           if (agg_isNull56) {
/* 574 */             boolean agg_isNull63 = agg_fastAggBuffer.isNullAt(2);
/* 575 */             double agg_value66 = agg_isNull63 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 576 */             if (!agg_isNull63) {
/* 577 */               agg_isNull56 = false;
/* 578 */               agg_value59 = agg_value66;
/* 579 */             }
/* 580 */           }
/* 581 */           // update fast row
/* 582 */           if (!agg_isNull40) {
/* 583 */             agg_fastAggBuffer.setDouble(0, agg_value43);
/* 584 */           } else {
/* 585 */             agg_fastAggBuffer.setNullAt(0);
/* 586 */           }
/* 587 */
/* 588 */           if (!agg_isNull48) {
/* 589 */             agg_fastAggBuffer.setDouble(1, agg_value51);
/* 590 */           } else {
/* 591 */             agg_fastAggBuffer.setNullAt(1);
/* 592 */           }
/* 593 */
/* 594 */           if (!agg_isNull56) {
/* 595 */             agg_fastAggBuffer.setDouble(2, agg_value59);
/* 596 */           } else {
/* 597 */             agg_fastAggBuffer.setNullAt(2);
/* 598 */           }
/* 599 */
/* 600 */         } else {
/* 601 */           // update unsafe row
/* 602 */
/* 603 */           // common sub-expressions
/* 604 */
/* 605 */           // evaluate aggregate function
/* 606 */           boolean agg_isNull17 = true;
/* 607 */           double agg_value20 = -1.0;
/* 608 */
/* 609 */           boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 610 */           double agg_value22 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 611 */           boolean agg_isNull18 = agg_isNull19;
/* 612 */           double agg_value21 = agg_value22;
/* 613 */           if (agg_isNull18) {
/* 614 */             boolean agg_isNull20 = false;
/* 615 */             double agg_value23 = -1.0;
/* 616 */             if (!false) {
/* 617 */               agg_value23 = (double) 0;
/* 618 */             }
/* 619 */             if (!agg_isNull20) {
/* 620 */               agg_isNull18 = false;
/* 621 */               agg_value21 = agg_value23;
/* 622 */             }
/* 623 */           }
/* 624 */
/* 625 */           if (!scan_isNull5) {
/* 626 */             agg_isNull17 = false; // resultCode could change nullability.
/* 627 */             agg_value20 = agg_value21 + scan_value5;
/* 628 */
/* 629 */           }
/* 630 */           boolean agg_isNull16 = agg_isNull17;
/* 631 */           double agg_value19 = agg_value20;
/* 632 */           if (agg_isNull16) {
/* 633 */             boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 634 */             double agg_value26 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 635 */             if (!agg_isNull23) {
/* 636 */               agg_isNull16 = false;
/* 637 */               agg_value19 = agg_value26;
/* 638 */             }
/* 639 */           }
/* 640 */           boolean agg_isNull25 = true;
/* 641 */           double agg_value28 = -1.0;
/* 642 */
/* 643 */           boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 644 */           double agg_value30 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 645 */           boolean agg_isNull26 = agg_isNull27;
/* 646 */           double agg_value29 = agg_value30;
/* 647 */           if (agg_isNull26) {
/* 648 */             boolean agg_isNull28 = false;
/* 649 */             double agg_value31 = -1.0;
/* 650 */             if (!false) {
/* 651 */               agg_value31 = (double) 0;
/* 652 */             }
/* 653 */             if (!agg_isNull28) {
/* 654 */               agg_isNull26 = false;
/* 655 */               agg_value29 = agg_value31;
/* 656 */             }
/* 657 */           }
/* 658 */
/* 659 */           if (!scan_isNull6) {
/* 660 */             agg_isNull25 = false; // resultCode could change nullability.
/* 661 */             agg_value28 = agg_value29 + scan_value6;
/* 662 */
/* 663 */           }
/* 664 */           boolean agg_isNull24 = agg_isNull25;
/* 665 */           double agg_value27 = agg_value28;
/* 666 */           if (agg_isNull24) {
/* 667 */             boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 668 */             double agg_value34 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 669 */             if (!agg_isNull31) {
/* 670 */               agg_isNull24 = false;
/* 671 */               agg_value27 = agg_value34;
/* 672 */             }
/* 673 */           }
/* 674 */           boolean agg_isNull33 = true;
/* 675 */           double agg_value36 = -1.0;
/* 676 */
/* 677 */           boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 678 */           double agg_value38 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 679 */           boolean agg_isNull34 = agg_isNull35;
/* 680 */           double agg_value37 = agg_value38;
/* 681 */           if (agg_isNull34) {
/* 682 */             boolean agg_isNull36 = false;
/* 683 */             double agg_value39 = -1.0;
/* 684 */             if (!false) {
/* 685 */               agg_value39 = (double) 0;
/* 686 */             }
/* 687 */             if (!agg_isNull36) {
/* 688 */               agg_isNull34 = false;
/* 689 */               agg_value37 = agg_value39;
/* 690 */             }
/* 691 */           }
/* 692 */
/* 693 */           if (!scan_isNull7) {
/* 694 */             agg_isNull33 = false; // resultCode could change nullability.
/* 695 */             agg_value36 = agg_value37 + scan_value7;
/* 696 */
/* 697 */           }
/* 698 */           boolean agg_isNull32 = agg_isNull33;
/* 699 */           double agg_value35 = agg_value36;
/* 700 */           if (agg_isNull32) {
/* 701 */             boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 702 */             double agg_value42 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 703 */             if (!agg_isNull39) {
/* 704 */               agg_isNull32 = false;
/* 705 */               agg_value35 = agg_value42;
/* 706 */             }
/* 707 */           }
/* 708 */           // update unsafe row buffer
/* 709 */           if (!agg_isNull16) {
/* 710 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value19);
/* 711 */           } else {
/* 712 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 713 */           }
/* 714 */
/* 715 */           if (!agg_isNull24) {
/* 716 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value27);
/* 717 */           } else {
/* 718 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 719 */           }
/* 720 */
/* 721 */           if (!agg_isNull32) {
/* 722 */             agg_unsafeRowAggBuffer.setDouble(2, agg_value35);
/* 723 */           } else {
/* 724 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 725 */           }
/* 726 */
/* 727 */         }
/* 728 */         // shouldStop check is eliminated
/* 729 */       }
/* 730 */       scan_batchIdx = scan_numRows;
/* 731 */       scan_batch = null;
/* 732 */       scan_nextBatch();
/* 733 */     }
/* 734 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 735 */     scan_scanTime1 = 0;
/* 736 */
/* 737 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 738 */
/* 739 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 740 */   }
/* 741 */
/* 742 */   private void wholestagecodegen_init_5() {
/* 743 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 744 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 745 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 746 */
/* 747 */   }
/* 748 */
/* 749 */   private void wholestagecodegen_init_2() {
/* 750 */     bhj_result = new UnsafeRow(10);
/* 751 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 752 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 10);
/* 753 */     project_result1 = new UnsafeRow(8);
/* 754 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 755 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 8);
/* 756 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 757 */
/* 758 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 759 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 760 */
/* 761 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 762 */     bhj_result1 = new UnsafeRow(9);
/* 763 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 764 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 9);
/* 765 */
/* 766 */   }
/* 767 */
/* 768 */   private void wholestagecodegen_init_1() {
/* 769 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 9);
/* 770 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 771 */     filter_result = new UnsafeRow(9);
/* 772 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 773 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 9);
/* 774 */     project_result = new UnsafeRow(9);
/* 775 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 776 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 9);
/* 777 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[13];
/* 778 */
/* 779 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 780 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 781 */
/* 782 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 783 */
/* 784 */   }
/* 785 */
/* 786 */   private void wholestagecodegen_init_4() {
/* 787 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[19];
/* 788 */
/* 789 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 790 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 791 */
/* 792 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 793 */     bhj_result3 = new UnsafeRow(8);
/* 794 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 32);
/* 795 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 8);
/* 796 */     project_result4 = new UnsafeRow(7);
/* 797 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 32);
/* 798 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 7);
/* 799 */     agg_result4 = new UnsafeRow(4);
/* 800 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 32);
/* 801 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 802 */
/* 803 */   }
/* 804 */
/* 805 */   protected void processNext() throws java.io.IOException {
/* 806 */     if (!agg_initAgg) {
/* 807 */       agg_initAgg = true;
/* 808 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 809 */       agg_doAggregateWithKeys();
/* 810 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 811 */     }
/* 812 */
/* 813 */     // output the result
/* 814 */
/* 815 */     while (agg_fastHashMapIter.next()) {
/* 816 */       wholestagecodegen_numOutputRows.add(1);
/* 817 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 818 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 819 */
/* 820 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 821 */
/* 822 */       append(agg_resultRow);
/* 823 */
/* 824 */       if (shouldStop()) return;
/* 825 */     }
/* 826 */     agg_fastHashMap.close();
/* 827 */
/* 828 */     while (agg_mapIter.next()) {
/* 829 */       wholestagecodegen_numOutputRows.add(1);
/* 830 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 831 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 832 */
/* 833 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 834 */
/* 835 */       append(agg_resultRow);
/* 836 */
/* 837 */       if (shouldStop()) return;
/* 838 */     }
/* 839 */
/* 840 */     agg_mapIter.close();
/* 841 */     if (agg_sorter == null) {
/* 842 */       agg_hashMap.free();
/* 843 */     }
/* 844 */   }
/* 845 */ }

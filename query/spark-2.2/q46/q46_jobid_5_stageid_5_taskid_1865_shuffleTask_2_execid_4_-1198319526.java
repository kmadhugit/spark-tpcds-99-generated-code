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
/* 031 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 032 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 033 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 034 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 035 */   private UnsafeRow scan_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 039 */   private UnsafeRow filter_result;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 042 */   private UnsafeRow project_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 045 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 046 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 048 */   private UnsafeRow bhj_result;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 051 */   private UnsafeRow project_result1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 054 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 055 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 056 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 057 */   private UnsafeRow bhj_result1;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 060 */   private UnsafeRow project_result2;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 063 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 064 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 065 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 066 */   private UnsafeRow bhj_result2;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 069 */   private UnsafeRow project_result3;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 072 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 073 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 074 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 075 */   private UnsafeRow bhj_result3;
/* 076 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 077 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 078 */   private UnsafeRow project_result4;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 081 */   private UnsafeRow agg_result4;
/* 082 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 084 */   private int agg_value12;
/* 085 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 086 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 087 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 088 */
/* 089 */   public GeneratedIterator(Object[] references) {
/* 090 */     this.references = references;
/* 091 */   }
/* 092 */
/* 093 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 094 */     partitionIndex = index;
/* 095 */     this.inputs = inputs;
/* 096 */     wholestagecodegen_init_0();
/* 097 */     wholestagecodegen_init_1();
/* 098 */     wholestagecodegen_init_2();
/* 099 */     wholestagecodegen_init_3();
/* 100 */     wholestagecodegen_init_4();
/* 101 */     wholestagecodegen_init_5();
/* 102 */
/* 103 */   }
/* 104 */
/* 105 */   private void wholestagecodegen_init_0() {
/* 106 */     agg_initAgg = false;
/* 107 */
/* 108 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 109 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 110 */
/* 111 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 112 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 113 */     scan_input = inputs[0];
/* 114 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 115 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 116 */     scan_scanTime1 = 0;
/* 117 */     scan_batch = null;
/* 118 */     scan_batchIdx = 0;
/* 119 */     scan_colInstance0 = null;
/* 120 */     scan_colInstance1 = null;
/* 121 */     scan_colInstance2 = null;
/* 122 */     scan_colInstance3 = null;
/* 123 */     scan_colInstance4 = null;
/* 124 */     scan_colInstance5 = null;
/* 125 */     scan_colInstance6 = null;
/* 126 */     scan_colInstance7 = null;
/* 127 */     scan_result = new UnsafeRow(8);
/* 128 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 129 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 8);
/* 130 */
/* 131 */   }
/* 132 */
/* 133 */   private void wholestagecodegen_init_3() {
/* 134 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 135 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[16];
/* 136 */
/* 137 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 138 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 139 */
/* 140 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 141 */     bhj_result2 = new UnsafeRow(7);
/* 142 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 0);
/* 143 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 7);
/* 144 */     project_result3 = new UnsafeRow(5);
/* 145 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 146 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 5);
/* 147 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[18];
/* 148 */
/* 149 */   }
/* 150 */
/* 151 */   private void scan_nextBatch() throws java.io.IOException {
/* 152 */     long getBatchStart = System.nanoTime();
/* 153 */     if (scan_input.hasNext()) {
/* 154 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 155 */       scan_numOutputRows.add(scan_batch.numRows());
/* 156 */       scan_batchIdx = 0;
/* 157 */       scan_colInstance0 = scan_batch.column(0);
/* 158 */       scan_colInstance1 = scan_batch.column(1);
/* 159 */       scan_colInstance2 = scan_batch.column(2);
/* 160 */       scan_colInstance3 = scan_batch.column(3);
/* 161 */       scan_colInstance4 = scan_batch.column(4);
/* 162 */       scan_colInstance5 = scan_batch.column(5);
/* 163 */       scan_colInstance6 = scan_batch.column(6);
/* 164 */       scan_colInstance7 = scan_batch.column(7);
/* 165 */
/* 166 */     }
/* 167 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 168 */   }
/* 169 */
/* 170 */   public class agg_FastHashMap {
/* 171 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 172 */     private int[] buckets;
/* 173 */     private int capacity = 1 << 16;
/* 174 */     private double loadFactor = 0.5;
/* 175 */     private int numBuckets = (int) (capacity / loadFactor);
/* 176 */     private int maxSteps = 2;
/* 177 */     private int numRows = 0;
/* 178 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 179 */     .add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 180 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.IntegerType)
/* 181 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.StringType);
/* 182 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 183 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType);
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
/* 206 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key, int agg_key1, int agg_key2, UTF8String agg_key3) {
/* 207 */       long h = hash(agg_key, agg_key1, agg_key2, agg_key3);
/* 208 */       int step = 0;
/* 209 */       int idx = (int) h & (numBuckets - 1);
/* 210 */       while (step < maxSteps) {
/* 211 */         // Return bucket index if it's either an empty slot or already contains the key
/* 212 */         if (buckets[idx] == -1) {
/* 213 */           if (numRows < capacity && !isBatchFull) {
/* 214 */             // creating the unsafe for new entry
/* 215 */             UnsafeRow agg_result = new UnsafeRow(4);
/* 216 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 217 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 218 */               32);
/* 219 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 220 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 221 */               agg_holder,
/* 222 */               4);
/* 223 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 224 */             agg_rowWriter.zeroOutNullBytes();
/* 225 */             agg_rowWriter.write(0, agg_key);
/* 226 */             agg_rowWriter.write(1, agg_key1);
/* 227 */             agg_rowWriter.write(2, agg_key2);
/* 228 */             agg_rowWriter.write(3, agg_key3);
/* 229 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 230 */             Object kbase = agg_result.getBaseObject();
/* 231 */             long koff = agg_result.getBaseOffset();
/* 232 */             int klen = agg_result.getSizeInBytes();
/* 233 */
/* 234 */             UnsafeRow vRow
/* 235 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 236 */             if (vRow == null) {
/* 237 */               isBatchFull = true;
/* 238 */             } else {
/* 239 */               buckets[idx] = numRows++;
/* 240 */             }
/* 241 */             return vRow;
/* 242 */           } else {
/* 243 */             // No more space
/* 244 */             return null;
/* 245 */           }
/* 246 */         } else if (equals(idx, agg_key, agg_key1, agg_key2, agg_key3)) {
/* 247 */           return batch.getValueRow(buckets[idx]);
/* 248 */         }
/* 249 */         idx = (idx + 1) & (numBuckets - 1);
/* 250 */         step++;
/* 251 */       }
/* 252 */       // Didn't find it
/* 253 */       return null;
/* 254 */     }
/* 255 */
/* 256 */     private boolean equals(int idx, int agg_key, int agg_key1, int agg_key2, UTF8String agg_key3) {
/* 257 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 258 */       return (row.getInt(0) == agg_key) && (row.getInt(1) == agg_key1) && (row.getInt(2) == agg_key2) && (row.getUTF8String(3).equals(agg_key3));
/* 259 */     }
/* 260 */
/* 261 */     private long hash(int agg_key, int agg_key1, int agg_key2, UTF8String agg_key3) {
/* 262 */       long agg_hash = 0;
/* 263 */
/* 264 */       int agg_result = agg_key;
/* 265 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 266 */
/* 267 */       int agg_result1 = agg_key1;
/* 268 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result1 + (agg_hash << 6) + (agg_hash >>> 2);
/* 269 */
/* 270 */       int agg_result2 = agg_key2;
/* 271 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result2 + (agg_hash << 6) + (agg_hash >>> 2);
/* 272 */
/* 273 */       int agg_result3 = 0;
/* 274 */       byte[] agg_bytes = agg_key3.getBytes();
/* 275 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 276 */         int agg_hash1 = agg_bytes[i];
/* 277 */         agg_result3 = (agg_result3 ^ (0x9e3779b9)) + agg_hash1 + (agg_result3 << 6) + (agg_result3 >>> 2);
/* 278 */       }
/* 279 */
/* 280 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result3 + (agg_hash << 6) + (agg_hash >>> 2);
/* 281 */
/* 282 */       return agg_hash;
/* 283 */     }
/* 284 */
/* 285 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 286 */       return batch.rowIterator();
/* 287 */     }
/* 288 */
/* 289 */     public void close() {
/* 290 */       batch.close();
/* 291 */     }
/* 292 */
/* 293 */   }
/* 294 */
/* 295 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 296 */     agg_hashMap = agg_plan.createHashMap();
/* 297 */
/* 298 */     if (scan_batch == null) {
/* 299 */       scan_nextBatch();
/* 300 */     }
/* 301 */     while (scan_batch != null) {
/* 302 */       int scan_numRows = scan_batch.numRows();
/* 303 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 304 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 305 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 306 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 307 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 308 */
/* 309 */         if (!(!(scan_isNull3))) continue;
/* 310 */
/* 311 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 312 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 313 */
/* 314 */         if (!(!(scan_isNull1))) continue;
/* 315 */
/* 316 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 317 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 318 */
/* 319 */         if (!(!(scan_isNull2))) continue;
/* 320 */
/* 321 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 322 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 323 */
/* 324 */         if (!(!(scan_isNull))) continue;
/* 325 */
/* 326 */         filter_numOutputRows.add(1);
/* 327 */
/* 328 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 329 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 330 */
/* 331 */         // generate join key for stream side
/* 332 */
/* 333 */         boolean bhj_isNull = scan_isNull7;
/* 334 */         long bhj_value = -1L;
/* 335 */         if (!scan_isNull7) {
/* 336 */           bhj_value = (long) scan_value7;
/* 337 */         }
/* 338 */         // find matches from HashedRelation
/* 339 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 340 */         if (bhj_matched == null) continue;
/* 341 */
/* 342 */         bhj_numOutputRows.add(1);
/* 343 */
/* 344 */         // generate join key for stream side
/* 345 */
/* 346 */         boolean bhj_isNull12 = false;
/* 347 */         long bhj_value12 = -1L;
/* 348 */         if (!false) {
/* 349 */           bhj_value12 = (long) scan_value3;
/* 350 */         }
/* 351 */         // find matches from HashedRelation
/* 352 */         UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 353 */         if (bhj_matched1 == null) continue;
/* 354 */
/* 355 */         bhj_numOutputRows1.add(1);
/* 356 */
/* 357 */         // generate join key for stream side
/* 358 */
/* 359 */         boolean bhj_isNull23 = false;
/* 360 */         long bhj_value23 = -1L;
/* 361 */         if (!false) {
/* 362 */           bhj_value23 = (long) scan_value1;
/* 363 */         }
/* 364 */         // find matches from HashedRelation
/* 365 */         UnsafeRow bhj_matched2 = bhj_isNull23 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value23);
/* 366 */         if (bhj_matched2 == null) continue;
/* 367 */
/* 368 */         bhj_numOutputRows2.add(1);
/* 369 */
/* 370 */         // generate join key for stream side
/* 371 */
/* 372 */         boolean bhj_isNull33 = false;
/* 373 */         long bhj_value33 = -1L;
/* 374 */         if (!false) {
/* 375 */           bhj_value33 = (long) scan_value2;
/* 376 */         }
/* 377 */         // find matches from HashedRelation
/* 378 */         UnsafeRow bhj_matched3 = bhj_isNull33 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value33);
/* 379 */         if (bhj_matched3 == null) continue;
/* 380 */
/* 381 */         bhj_numOutputRows3.add(1);
/* 382 */
/* 383 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 384 */         int scan_value4 = scan_isNull4 ? -1 : (scan_colInstance4.getInt(scan_rowIdx));
/* 385 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 386 */         double scan_value5 = scan_isNull5 ? -1.0 : (scan_colInstance5.getDouble(scan_rowIdx));
/* 387 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 388 */         double scan_value6 = scan_isNull6 ? -1.0 : (scan_colInstance6.getDouble(scan_rowIdx));
/* 389 */         boolean bhj_isNull36 = bhj_matched3.isNullAt(1);
/* 390 */         UTF8String bhj_value36 = bhj_isNull36 ? null : (bhj_matched3.getUTF8String(1));
/* 391 */
/* 392 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 393 */
/* 394 */         UnsafeRow agg_fastAggBuffer = null;
/* 395 */
/* 396 */         if (true) {
/* 397 */           if (!scan_isNull4 && !false && !false && !bhj_isNull36) {
/* 398 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 399 */               scan_value4, scan_value, scan_value2, bhj_value36);
/* 400 */           }
/* 401 */         }
/* 402 */
/* 403 */         if (agg_fastAggBuffer == null) {
/* 404 */           // generate grouping key
/* 405 */           agg_holder.reset();
/* 406 */
/* 407 */           agg_rowWriter.zeroOutNullBytes();
/* 408 */
/* 409 */           if (scan_isNull4) {
/* 410 */             agg_rowWriter.setNullAt(0);
/* 411 */           } else {
/* 412 */             agg_rowWriter.write(0, scan_value4);
/* 413 */           }
/* 414 */
/* 415 */           agg_rowWriter.write(1, scan_value);
/* 416 */
/* 417 */           agg_rowWriter.write(2, scan_value2);
/* 418 */
/* 419 */           if (bhj_isNull36) {
/* 420 */             agg_rowWriter.setNullAt(3);
/* 421 */           } else {
/* 422 */             agg_rowWriter.write(3, bhj_value36);
/* 423 */           }
/* 424 */           agg_result4.setTotalSize(agg_holder.totalSize());
/* 425 */           agg_value12 = 42;
/* 426 */
/* 427 */           if (!scan_isNull4) {
/* 428 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value4, agg_value12);
/* 429 */           }
/* 430 */
/* 431 */           if (!false) {
/* 432 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value, agg_value12);
/* 433 */           }
/* 434 */
/* 435 */           if (!false) {
/* 436 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(scan_value2, agg_value12);
/* 437 */           }
/* 438 */
/* 439 */           if (!bhj_isNull36) {
/* 440 */             agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value36.getBaseObject(), bhj_value36.getBaseOffset(), bhj_value36.numBytes(), agg_value12);
/* 441 */           }
/* 442 */           if (true) {
/* 443 */             // try to get the buffer from hash map
/* 444 */             agg_unsafeRowAggBuffer =
/* 445 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value12);
/* 446 */           }
/* 447 */           if (agg_unsafeRowAggBuffer == null) {
/* 448 */             if (agg_sorter == null) {
/* 449 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 450 */             } else {
/* 451 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 452 */             }
/* 453 */
/* 454 */             // the hash map had be spilled, it should have enough memory now,
/* 455 */             // try  to allocate buffer again.
/* 456 */             agg_unsafeRowAggBuffer =
/* 457 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result4, agg_value12);
/* 458 */             if (agg_unsafeRowAggBuffer == null) {
/* 459 */               // failed to allocate the first page
/* 460 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 461 */             }
/* 462 */           }
/* 463 */         }
/* 464 */
/* 465 */         if (agg_fastAggBuffer != null) {
/* 466 */           // update fast row
/* 467 */
/* 468 */           // common sub-expressions
/* 469 */
/* 470 */           // evaluate aggregate function
/* 471 */           boolean agg_isNull32 = true;
/* 472 */           double agg_value34 = -1.0;
/* 473 */
/* 474 */           boolean agg_isNull34 = agg_fastAggBuffer.isNullAt(0);
/* 475 */           double agg_value36 = agg_isNull34 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 476 */           boolean agg_isNull33 = agg_isNull34;
/* 477 */           double agg_value35 = agg_value36;
/* 478 */           if (agg_isNull33) {
/* 479 */             boolean agg_isNull35 = false;
/* 480 */             double agg_value37 = -1.0;
/* 481 */             if (!false) {
/* 482 */               agg_value37 = (double) 0;
/* 483 */             }
/* 484 */             if (!agg_isNull35) {
/* 485 */               agg_isNull33 = false;
/* 486 */               agg_value35 = agg_value37;
/* 487 */             }
/* 488 */           }
/* 489 */
/* 490 */           if (!scan_isNull5) {
/* 491 */             agg_isNull32 = false; // resultCode could change nullability.
/* 492 */             agg_value34 = agg_value35 + scan_value5;
/* 493 */
/* 494 */           }
/* 495 */           boolean agg_isNull31 = agg_isNull32;
/* 496 */           double agg_value33 = agg_value34;
/* 497 */           if (agg_isNull31) {
/* 498 */             boolean agg_isNull38 = agg_fastAggBuffer.isNullAt(0);
/* 499 */             double agg_value40 = agg_isNull38 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 500 */             if (!agg_isNull38) {
/* 501 */               agg_isNull31 = false;
/* 502 */               agg_value33 = agg_value40;
/* 503 */             }
/* 504 */           }
/* 505 */           boolean agg_isNull40 = true;
/* 506 */           double agg_value42 = -1.0;
/* 507 */
/* 508 */           boolean agg_isNull42 = agg_fastAggBuffer.isNullAt(1);
/* 509 */           double agg_value44 = agg_isNull42 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 510 */           boolean agg_isNull41 = agg_isNull42;
/* 511 */           double agg_value43 = agg_value44;
/* 512 */           if (agg_isNull41) {
/* 513 */             boolean agg_isNull43 = false;
/* 514 */             double agg_value45 = -1.0;
/* 515 */             if (!false) {
/* 516 */               agg_value45 = (double) 0;
/* 517 */             }
/* 518 */             if (!agg_isNull43) {
/* 519 */               agg_isNull41 = false;
/* 520 */               agg_value43 = agg_value45;
/* 521 */             }
/* 522 */           }
/* 523 */
/* 524 */           if (!scan_isNull6) {
/* 525 */             agg_isNull40 = false; // resultCode could change nullability.
/* 526 */             agg_value42 = agg_value43 + scan_value6;
/* 527 */
/* 528 */           }
/* 529 */           boolean agg_isNull39 = agg_isNull40;
/* 530 */           double agg_value41 = agg_value42;
/* 531 */           if (agg_isNull39) {
/* 532 */             boolean agg_isNull46 = agg_fastAggBuffer.isNullAt(1);
/* 533 */             double agg_value48 = agg_isNull46 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 534 */             if (!agg_isNull46) {
/* 535 */               agg_isNull39 = false;
/* 536 */               agg_value41 = agg_value48;
/* 537 */             }
/* 538 */           }
/* 539 */           // update fast row
/* 540 */           if (!agg_isNull31) {
/* 541 */             agg_fastAggBuffer.setDouble(0, agg_value33);
/* 542 */           } else {
/* 543 */             agg_fastAggBuffer.setNullAt(0);
/* 544 */           }
/* 545 */
/* 546 */           if (!agg_isNull39) {
/* 547 */             agg_fastAggBuffer.setDouble(1, agg_value41);
/* 548 */           } else {
/* 549 */             agg_fastAggBuffer.setNullAt(1);
/* 550 */           }
/* 551 */
/* 552 */         } else {
/* 553 */           // update unsafe row
/* 554 */
/* 555 */           // common sub-expressions
/* 556 */
/* 557 */           // evaluate aggregate function
/* 558 */           boolean agg_isNull16 = true;
/* 559 */           double agg_value18 = -1.0;
/* 560 */
/* 561 */           boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 562 */           double agg_value20 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 563 */           boolean agg_isNull17 = agg_isNull18;
/* 564 */           double agg_value19 = agg_value20;
/* 565 */           if (agg_isNull17) {
/* 566 */             boolean agg_isNull19 = false;
/* 567 */             double agg_value21 = -1.0;
/* 568 */             if (!false) {
/* 569 */               agg_value21 = (double) 0;
/* 570 */             }
/* 571 */             if (!agg_isNull19) {
/* 572 */               agg_isNull17 = false;
/* 573 */               agg_value19 = agg_value21;
/* 574 */             }
/* 575 */           }
/* 576 */
/* 577 */           if (!scan_isNull5) {
/* 578 */             agg_isNull16 = false; // resultCode could change nullability.
/* 579 */             agg_value18 = agg_value19 + scan_value5;
/* 580 */
/* 581 */           }
/* 582 */           boolean agg_isNull15 = agg_isNull16;
/* 583 */           double agg_value17 = agg_value18;
/* 584 */           if (agg_isNull15) {
/* 585 */             boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 586 */             double agg_value24 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 587 */             if (!agg_isNull22) {
/* 588 */               agg_isNull15 = false;
/* 589 */               agg_value17 = agg_value24;
/* 590 */             }
/* 591 */           }
/* 592 */           boolean agg_isNull24 = true;
/* 593 */           double agg_value26 = -1.0;
/* 594 */
/* 595 */           boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 596 */           double agg_value28 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 597 */           boolean agg_isNull25 = agg_isNull26;
/* 598 */           double agg_value27 = agg_value28;
/* 599 */           if (agg_isNull25) {
/* 600 */             boolean agg_isNull27 = false;
/* 601 */             double agg_value29 = -1.0;
/* 602 */             if (!false) {
/* 603 */               agg_value29 = (double) 0;
/* 604 */             }
/* 605 */             if (!agg_isNull27) {
/* 606 */               agg_isNull25 = false;
/* 607 */               agg_value27 = agg_value29;
/* 608 */             }
/* 609 */           }
/* 610 */
/* 611 */           if (!scan_isNull6) {
/* 612 */             agg_isNull24 = false; // resultCode could change nullability.
/* 613 */             agg_value26 = agg_value27 + scan_value6;
/* 614 */
/* 615 */           }
/* 616 */           boolean agg_isNull23 = agg_isNull24;
/* 617 */           double agg_value25 = agg_value26;
/* 618 */           if (agg_isNull23) {
/* 619 */             boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 620 */             double agg_value32 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 621 */             if (!agg_isNull30) {
/* 622 */               agg_isNull23 = false;
/* 623 */               agg_value25 = agg_value32;
/* 624 */             }
/* 625 */           }
/* 626 */           // update unsafe row buffer
/* 627 */           if (!agg_isNull15) {
/* 628 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value17);
/* 629 */           } else {
/* 630 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 631 */           }
/* 632 */
/* 633 */           if (!agg_isNull23) {
/* 634 */             agg_unsafeRowAggBuffer.setDouble(1, agg_value25);
/* 635 */           } else {
/* 636 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 637 */           }
/* 638 */
/* 639 */         }
/* 640 */         // shouldStop check is eliminated
/* 641 */       }
/* 642 */       scan_batchIdx = scan_numRows;
/* 643 */       scan_batch = null;
/* 644 */       scan_nextBatch();
/* 645 */     }
/* 646 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 647 */     scan_scanTime1 = 0;
/* 648 */
/* 649 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 650 */
/* 651 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 652 */   }
/* 653 */
/* 654 */   private void wholestagecodegen_init_5() {
/* 655 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 656 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 657 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 658 */
/* 659 */   }
/* 660 */
/* 661 */   private void wholestagecodegen_init_2() {
/* 662 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 663 */     project_result1 = new UnsafeRow(7);
/* 664 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 665 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 7);
/* 666 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[14];
/* 667 */
/* 668 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 669 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 670 */
/* 671 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 672 */     bhj_result1 = new UnsafeRow(8);
/* 673 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 674 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 675 */     project_result2 = new UnsafeRow(6);
/* 676 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 677 */
/* 678 */   }
/* 679 */
/* 680 */   private void wholestagecodegen_init_1() {
/* 681 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[11];
/* 682 */     filter_result = new UnsafeRow(8);
/* 683 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 684 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 8);
/* 685 */     project_result = new UnsafeRow(8);
/* 686 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 687 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 688 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 689 */
/* 690 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 691 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 692 */
/* 693 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 694 */     bhj_result = new UnsafeRow(9);
/* 695 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 696 */
/* 697 */   }
/* 698 */
/* 699 */   private void wholestagecodegen_init_4() {
/* 700 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 701 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 702 */
/* 703 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 704 */     bhj_result3 = new UnsafeRow(7);
/* 705 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 32);
/* 706 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 7);
/* 707 */     project_result4 = new UnsafeRow(6);
/* 708 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 32);
/* 709 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 6);
/* 710 */     agg_result4 = new UnsafeRow(4);
/* 711 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 32);
/* 712 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 713 */
/* 714 */   }
/* 715 */
/* 716 */   protected void processNext() throws java.io.IOException {
/* 717 */     if (!agg_initAgg) {
/* 718 */       agg_initAgg = true;
/* 719 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 720 */       agg_doAggregateWithKeys();
/* 721 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 722 */     }
/* 723 */
/* 724 */     // output the result
/* 725 */
/* 726 */     while (agg_fastHashMapIter.next()) {
/* 727 */       wholestagecodegen_numOutputRows.add(1);
/* 728 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 729 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 730 */
/* 731 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 732 */
/* 733 */       append(agg_resultRow);
/* 734 */
/* 735 */       if (shouldStop()) return;
/* 736 */     }
/* 737 */     agg_fastHashMap.close();
/* 738 */
/* 739 */     while (agg_mapIter.next()) {
/* 740 */       wholestagecodegen_numOutputRows.add(1);
/* 741 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 742 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 743 */
/* 744 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 745 */
/* 746 */       append(agg_resultRow);
/* 747 */
/* 748 */       if (shouldStop()) return;
/* 749 */     }
/* 750 */
/* 751 */     agg_mapIter.close();
/* 752 */     if (agg_sorter == null) {
/* 753 */       agg_hashMap.free();
/* 754 */     }
/* 755 */   }
/* 756 */ }

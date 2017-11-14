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
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private long agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private long agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private double agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private long agg_bufValue7;
/* 025 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 026 */   private agg_FastHashMap agg_fastHashMap;
/* 027 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 028 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 029 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 030 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 033 */   private scala.collection.Iterator scan_input;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_numOutputRows;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric scan_scanTime;
/* 036 */   private long scan_scanTime1;
/* 037 */   private org.apache.spark.sql.execution.vectorized.ColumnarBatch scan_batch;
/* 038 */   private int scan_batchIdx;
/* 039 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance0;
/* 040 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance1;
/* 041 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance2;
/* 042 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance3;
/* 043 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance4;
/* 044 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance5;
/* 045 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance6;
/* 046 */   private org.apache.spark.sql.execution.vectorized.ColumnVector scan_colInstance7;
/* 047 */   private UnsafeRow scan_result;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder scan_holder;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter scan_rowWriter;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 051 */   private UnsafeRow filter_result;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 054 */   private UnsafeRow project_result;
/* 055 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 056 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 057 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 058 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 059 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 060 */   private UnsafeRow bhj_result;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 063 */   private UnsafeRow project_result1;
/* 064 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 066 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 067 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 068 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 069 */   private UnsafeRow bhj_result1;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 072 */   private UnsafeRow project_result2;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 075 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 076 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 077 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 078 */   private UnsafeRow bhj_result2;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 080 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 081 */   private UnsafeRow project_result3;
/* 082 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 084 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast3;
/* 085 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation3;
/* 086 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows3;
/* 087 */   private UnsafeRow bhj_result3;
/* 088 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder3;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter3;
/* 090 */   private UnsafeRow project_result4;
/* 091 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder4;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter4;
/* 093 */   private UnsafeRow agg_result1;
/* 094 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 095 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 096 */   private int agg_value22;
/* 097 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 098 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 099 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 100 */
/* 101 */   public GeneratedIterator(Object[] references) {
/* 102 */     this.references = references;
/* 103 */   }
/* 104 */
/* 105 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 106 */     partitionIndex = index;
/* 107 */     this.inputs = inputs;
/* 108 */     wholestagecodegen_init_0();
/* 109 */     wholestagecodegen_init_1();
/* 110 */     wholestagecodegen_init_2();
/* 111 */     wholestagecodegen_init_3();
/* 112 */     wholestagecodegen_init_4();
/* 113 */     wholestagecodegen_init_5();
/* 114 */
/* 115 */   }
/* 116 */
/* 117 */   private void wholestagecodegen_init_0() {
/* 118 */     agg_initAgg = false;
/* 119 */
/* 120 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 121 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 122 */
/* 123 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 124 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 125 */     scan_input = inputs[0];
/* 126 */     this.scan_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[12];
/* 127 */     this.scan_scanTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 128 */     scan_scanTime1 = 0;
/* 129 */     scan_batch = null;
/* 130 */     scan_batchIdx = 0;
/* 131 */     scan_colInstance0 = null;
/* 132 */     scan_colInstance1 = null;
/* 133 */     scan_colInstance2 = null;
/* 134 */     scan_colInstance3 = null;
/* 135 */     scan_colInstance4 = null;
/* 136 */     scan_colInstance5 = null;
/* 137 */     scan_colInstance6 = null;
/* 138 */     scan_colInstance7 = null;
/* 139 */     scan_result = new UnsafeRow(8);
/* 140 */     this.scan_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(scan_result, 0);
/* 141 */     this.scan_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(scan_holder, 8);
/* 142 */
/* 143 */   }
/* 144 */
/* 145 */   private void wholestagecodegen_init_3() {
/* 146 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 6);
/* 147 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[19];
/* 148 */
/* 149 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 150 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 151 */
/* 152 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 153 */     bhj_result2 = new UnsafeRow(8);
/* 154 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 32);
/* 155 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 8);
/* 156 */     project_result3 = new UnsafeRow(6);
/* 157 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 32);
/* 158 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 6);
/* 159 */     this.bhj_broadcast3 = (org.apache.spark.broadcast.TorrentBroadcast) references[21];
/* 160 */
/* 161 */   }
/* 162 */
/* 163 */   private void scan_nextBatch() throws java.io.IOException {
/* 164 */     long getBatchStart = System.nanoTime();
/* 165 */     if (scan_input.hasNext()) {
/* 166 */       scan_batch = (org.apache.spark.sql.execution.vectorized.ColumnarBatch)scan_input.next();
/* 167 */       scan_numOutputRows.add(scan_batch.numRows());
/* 168 */       scan_batchIdx = 0;
/* 169 */       scan_colInstance0 = scan_batch.column(0);
/* 170 */       scan_colInstance1 = scan_batch.column(1);
/* 171 */       scan_colInstance2 = scan_batch.column(2);
/* 172 */       scan_colInstance3 = scan_batch.column(3);
/* 173 */       scan_colInstance4 = scan_batch.column(4);
/* 174 */       scan_colInstance5 = scan_batch.column(5);
/* 175 */       scan_colInstance6 = scan_batch.column(6);
/* 176 */       scan_colInstance7 = scan_batch.column(7);
/* 177 */
/* 178 */     }
/* 179 */     scan_scanTime1 += System.nanoTime() - getBatchStart;
/* 180 */   }
/* 181 */
/* 182 */   public class agg_FastHashMap {
/* 183 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 184 */     private int[] buckets;
/* 185 */     private int capacity = 1 << 16;
/* 186 */     private double loadFactor = 0.5;
/* 187 */     private int numBuckets = (int) (capacity / loadFactor);
/* 188 */     private int maxSteps = 2;
/* 189 */     private int numRows = 0;
/* 190 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.StringType);
/* 191 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 192 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.LongType)
/* 193 */     .add("((java.lang.String) references[6])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 194 */     .add("((java.lang.String) references[7])", org.apache.spark.sql.types.DataTypes.LongType)
/* 195 */     .add("((java.lang.String) references[8])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 196 */     .add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.LongType)
/* 197 */     .add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 198 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.LongType);
/* 199 */     private Object emptyVBase;
/* 200 */     private long emptyVOff;
/* 201 */     private int emptyVLen;
/* 202 */     private boolean isBatchFull = false;
/* 203 */
/* 204 */     public agg_FastHashMap(
/* 205 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 206 */       InternalRow emptyAggregationBuffer) {
/* 207 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 208 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 209 */
/* 210 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 211 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 212 */
/* 213 */       emptyVBase = emptyBuffer;
/* 214 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 215 */       emptyVLen = emptyBuffer.length;
/* 216 */
/* 217 */       buckets = new int[numBuckets];
/* 218 */       java.util.Arrays.fill(buckets, -1);
/* 219 */     }
/* 220 */
/* 221 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(UTF8String agg_key) {
/* 222 */       long h = hash(agg_key);
/* 223 */       int step = 0;
/* 224 */       int idx = (int) h & (numBuckets - 1);
/* 225 */       while (step < maxSteps) {
/* 226 */         // Return bucket index if it's either an empty slot or already contains the key
/* 227 */         if (buckets[idx] == -1) {
/* 228 */           if (numRows < capacity && !isBatchFull) {
/* 229 */             // creating the unsafe for new entry
/* 230 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 231 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 232 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 233 */               32);
/* 234 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 235 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 236 */               agg_holder,
/* 237 */               1);
/* 238 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 239 */             agg_rowWriter.zeroOutNullBytes();
/* 240 */             agg_rowWriter.write(0, agg_key);
/* 241 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 242 */             Object kbase = agg_result.getBaseObject();
/* 243 */             long koff = agg_result.getBaseOffset();
/* 244 */             int klen = agg_result.getSizeInBytes();
/* 245 */
/* 246 */             UnsafeRow vRow
/* 247 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 248 */             if (vRow == null) {
/* 249 */               isBatchFull = true;
/* 250 */             } else {
/* 251 */               buckets[idx] = numRows++;
/* 252 */             }
/* 253 */             return vRow;
/* 254 */           } else {
/* 255 */             // No more space
/* 256 */             return null;
/* 257 */           }
/* 258 */         } else if (equals(idx, agg_key)) {
/* 259 */           return batch.getValueRow(buckets[idx]);
/* 260 */         }
/* 261 */         idx = (idx + 1) & (numBuckets - 1);
/* 262 */         step++;
/* 263 */       }
/* 264 */       // Didn't find it
/* 265 */       return null;
/* 266 */     }
/* 267 */
/* 268 */     private boolean equals(int idx, UTF8String agg_key) {
/* 269 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 270 */       return (row.getUTF8String(0).equals(agg_key));
/* 271 */     }
/* 272 */
/* 273 */     private long hash(UTF8String agg_key) {
/* 274 */       long agg_hash = 0;
/* 275 */
/* 276 */       int agg_result = 0;
/* 277 */       byte[] agg_bytes = agg_key.getBytes();
/* 278 */       for (int i = 0; i < agg_bytes.length; i++) {
/* 279 */         int agg_hash1 = agg_bytes[i];
/* 280 */         agg_result = (agg_result ^ (0x9e3779b9)) + agg_hash1 + (agg_result << 6) + (agg_result >>> 2);
/* 281 */       }
/* 282 */
/* 283 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 284 */
/* 285 */       return agg_hash;
/* 286 */     }
/* 287 */
/* 288 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 289 */       return batch.rowIterator();
/* 290 */     }
/* 291 */
/* 292 */     public void close() {
/* 293 */       batch.close();
/* 294 */     }
/* 295 */
/* 296 */   }
/* 297 */
/* 298 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 299 */     agg_hashMap = agg_plan.createHashMap();
/* 300 */
/* 301 */     if (scan_batch == null) {
/* 302 */       scan_nextBatch();
/* 303 */     }
/* 304 */     while (scan_batch != null) {
/* 305 */       int scan_numRows = scan_batch.numRows();
/* 306 */       int scan_localEnd = scan_numRows - scan_batchIdx;
/* 307 */       for (int scan_localIdx = 0; scan_localIdx < scan_localEnd; scan_localIdx++) {
/* 308 */         int scan_rowIdx = scan_batchIdx + scan_localIdx;
/* 309 */         boolean scan_isNull = scan_colInstance0.isNullAt(scan_rowIdx);
/* 310 */         int scan_value = scan_isNull ? -1 : (scan_colInstance0.getInt(scan_rowIdx));
/* 311 */
/* 312 */         if (!(!(scan_isNull))) continue;
/* 313 */
/* 314 */         boolean scan_isNull1 = scan_colInstance1.isNullAt(scan_rowIdx);
/* 315 */         int scan_value1 = scan_isNull1 ? -1 : (scan_colInstance1.getInt(scan_rowIdx));
/* 316 */
/* 317 */         if (!(!(scan_isNull1))) continue;
/* 318 */
/* 319 */         boolean scan_isNull2 = scan_colInstance2.isNullAt(scan_rowIdx);
/* 320 */         int scan_value2 = scan_isNull2 ? -1 : (scan_colInstance2.getInt(scan_rowIdx));
/* 321 */
/* 322 */         if (!(!(scan_isNull2))) continue;
/* 323 */
/* 324 */         filter_numOutputRows.add(1);
/* 325 */
/* 326 */         // generate join key for stream side
/* 327 */
/* 328 */         boolean bhj_isNull = false;
/* 329 */         long bhj_value = -1L;
/* 330 */         if (!false) {
/* 331 */           bhj_value = (long) scan_value;
/* 332 */         }
/* 333 */         // find matches from HashedRelation
/* 334 */         UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 335 */         if (bhj_matched == null) continue;
/* 336 */
/* 337 */         bhj_numOutputRows.add(1);
/* 338 */
/* 339 */         boolean scan_isNull7 = scan_colInstance7.isNullAt(scan_rowIdx);
/* 340 */         int scan_value7 = scan_isNull7 ? -1 : (scan_colInstance7.getInt(scan_rowIdx));
/* 341 */
/* 342 */         // generate join key for stream side
/* 343 */
/* 344 */         boolean bhj_isNull12 = scan_isNull7;
/* 345 */         long bhj_value12 = -1L;
/* 346 */         if (!scan_isNull7) {
/* 347 */           bhj_value12 = (long) scan_value7;
/* 348 */         }
/* 349 */         // find matches from HashedRelation
/* 350 */         UnsafeRow bhj_matched1 = bhj_isNull12 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value12);
/* 351 */         if (bhj_matched1 == null) continue;
/* 352 */
/* 353 */         bhj_numOutputRows1.add(1);
/* 354 */
/* 355 */         // generate join key for stream side
/* 356 */
/* 357 */         boolean bhj_isNull23 = false;
/* 358 */         long bhj_value23 = -1L;
/* 359 */         if (!false) {
/* 360 */           bhj_value23 = (long) scan_value1;
/* 361 */         }
/* 362 */         // find matches from HashedRelation
/* 363 */         UnsafeRow bhj_matched2 = bhj_isNull23 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value23);
/* 364 */         if (bhj_matched2 == null) continue;
/* 365 */
/* 366 */         bhj_numOutputRows2.add(1);
/* 367 */
/* 368 */         // generate join key for stream side
/* 369 */
/* 370 */         boolean bhj_isNull35 = false;
/* 371 */         long bhj_value35 = -1L;
/* 372 */         if (!false) {
/* 373 */           bhj_value35 = (long) scan_value2;
/* 374 */         }
/* 375 */         // find matches from HashedRelation
/* 376 */         UnsafeRow bhj_matched3 = bhj_isNull35 ? null: (UnsafeRow)bhj_relation3.getValue(bhj_value35);
/* 377 */         if (bhj_matched3 == null) continue;
/* 378 */
/* 379 */         bhj_numOutputRows3.add(1);
/* 380 */
/* 381 */         boolean scan_isNull3 = scan_colInstance3.isNullAt(scan_rowIdx);
/* 382 */         int scan_value3 = scan_isNull3 ? -1 : (scan_colInstance3.getInt(scan_rowIdx));
/* 383 */         boolean scan_isNull4 = scan_colInstance4.isNullAt(scan_rowIdx);
/* 384 */         double scan_value4 = scan_isNull4 ? -1.0 : (scan_colInstance4.getDouble(scan_rowIdx));
/* 385 */         boolean scan_isNull5 = scan_colInstance5.isNullAt(scan_rowIdx);
/* 386 */         double scan_value5 = scan_isNull5 ? -1.0 : (scan_colInstance5.getDouble(scan_rowIdx));
/* 387 */         boolean scan_isNull6 = scan_colInstance6.isNullAt(scan_rowIdx);
/* 388 */         double scan_value6 = scan_isNull6 ? -1.0 : (scan_colInstance6.getDouble(scan_rowIdx));
/* 389 */         boolean bhj_isNull26 = bhj_matched2.isNullAt(1);
/* 390 */         UTF8String bhj_value26 = bhj_isNull26 ? null : (bhj_matched2.getUTF8String(1));
/* 391 */
/* 392 */         UnsafeRow agg_unsafeRowAggBuffer = null;
/* 393 */
/* 394 */         UnsafeRow agg_fastAggBuffer = null;
/* 395 */
/* 396 */         if (true) {
/* 397 */           if (!bhj_isNull26) {
/* 398 */             agg_fastAggBuffer = agg_fastHashMap.findOrInsert(
/* 399 */               bhj_value26);
/* 400 */           }
/* 401 */         }
/* 402 */
/* 403 */         if (agg_fastAggBuffer == null) {
/* 404 */           // generate grouping key
/* 405 */           agg_holder.reset();
/* 406 */
/* 407 */           agg_rowWriter.zeroOutNullBytes();
/* 408 */
/* 409 */           if (bhj_isNull26) {
/* 410 */             agg_rowWriter.setNullAt(0);
/* 411 */           } else {
/* 412 */             agg_rowWriter.write(0, bhj_value26);
/* 413 */           }
/* 414 */           agg_result1.setTotalSize(agg_holder.totalSize());
/* 415 */           agg_value22 = 42;
/* 416 */
/* 417 */           if (!bhj_isNull26) {
/* 418 */             agg_value22 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(bhj_value26.getBaseObject(), bhj_value26.getBaseOffset(), bhj_value26.numBytes(), agg_value22);
/* 419 */           }
/* 420 */           if (true) {
/* 421 */             // try to get the buffer from hash map
/* 422 */             agg_unsafeRowAggBuffer =
/* 423 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value22);
/* 424 */           }
/* 425 */           if (agg_unsafeRowAggBuffer == null) {
/* 426 */             if (agg_sorter == null) {
/* 427 */               agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 428 */             } else {
/* 429 */               agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 430 */             }
/* 431 */
/* 432 */             // the hash map had be spilled, it should have enough memory now,
/* 433 */             // try  to allocate buffer again.
/* 434 */             agg_unsafeRowAggBuffer =
/* 435 */             agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result1, agg_value22);
/* 436 */             if (agg_unsafeRowAggBuffer == null) {
/* 437 */               // failed to allocate the first page
/* 438 */               throw new OutOfMemoryError("No enough memory for aggregation");
/* 439 */             }
/* 440 */           }
/* 441 */         }
/* 442 */
/* 443 */         if (agg_fastAggBuffer != null) {
/* 444 */           // update fast row
/* 445 */
/* 446 */           // common sub-expressions
/* 447 */           boolean agg_isNull69 = scan_isNull3;
/* 448 */           long agg_value77 = -1L;
/* 449 */           if (!scan_isNull3) {
/* 450 */             agg_value77 = (long) scan_value3;
/* 451 */           }
/* 452 */           // evaluate aggregate function
/* 453 */           boolean agg_isNull71 = true;
/* 454 */           double agg_value79 = -1.0;
/* 455 */
/* 456 */           boolean agg_isNull72 = agg_fastAggBuffer.isNullAt(0);
/* 457 */           double agg_value80 = agg_isNull72 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 458 */           if (!agg_isNull72) {
/* 459 */             boolean agg_isNull74 = agg_isNull69;
/* 460 */             double agg_value82 = -1.0;
/* 461 */             if (!agg_isNull69) {
/* 462 */               agg_value82 = (double) agg_value77;
/* 463 */             }
/* 464 */             boolean agg_isNull73 = agg_isNull74;
/* 465 */             double agg_value81 = agg_value82;
/* 466 */             if (agg_isNull73) {
/* 467 */               boolean agg_isNull75 = false;
/* 468 */               double agg_value83 = -1.0;
/* 469 */               if (!false) {
/* 470 */                 agg_value83 = (double) 0;
/* 471 */               }
/* 472 */               if (!agg_isNull75) {
/* 473 */                 agg_isNull73 = false;
/* 474 */                 agg_value81 = agg_value83;
/* 475 */               }
/* 476 */             }
/* 477 */
/* 478 */             agg_isNull71 = false; // resultCode could change nullability.
/* 479 */             agg_value79 = agg_value80 + agg_value81;
/* 480 */
/* 481 */           }
/* 482 */           boolean agg_isNull77 = false;
/* 483 */           long agg_value85 = -1L;
/* 484 */           if (!false && agg_isNull69) {
/* 485 */             boolean agg_isNull79 = agg_fastAggBuffer.isNullAt(1);
/* 486 */             long agg_value87 = agg_isNull79 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 487 */             agg_isNull77 = agg_isNull79;
/* 488 */             agg_value85 = agg_value87;
/* 489 */           } else {
/* 490 */             boolean agg_isNull80 = true;
/* 491 */             long agg_value88 = -1L;
/* 492 */
/* 493 */             boolean agg_isNull81 = agg_fastAggBuffer.isNullAt(1);
/* 494 */             long agg_value89 = agg_isNull81 ? -1L : (agg_fastAggBuffer.getLong(1));
/* 495 */             if (!agg_isNull81) {
/* 496 */               agg_isNull80 = false; // resultCode could change nullability.
/* 497 */               agg_value88 = agg_value89 + 1L;
/* 498 */
/* 499 */             }
/* 500 */             agg_isNull77 = agg_isNull80;
/* 501 */             agg_value85 = agg_value88;
/* 502 */           }
/* 503 */           boolean agg_isNull83 = true;
/* 504 */           double agg_value91 = -1.0;
/* 505 */
/* 506 */           boolean agg_isNull84 = agg_fastAggBuffer.isNullAt(2);
/* 507 */           double agg_value92 = agg_isNull84 ? -1.0 : (agg_fastAggBuffer.getDouble(2));
/* 508 */           if (!agg_isNull84) {
/* 509 */             boolean agg_isNull85 = scan_isNull4;
/* 510 */             double agg_value93 = scan_value4;
/* 511 */             if (agg_isNull85) {
/* 512 */               boolean agg_isNull87 = false;
/* 513 */               double agg_value95 = -1.0;
/* 514 */               if (!false) {
/* 515 */                 agg_value95 = (double) 0;
/* 516 */               }
/* 517 */               if (!agg_isNull87) {
/* 518 */                 agg_isNull85 = false;
/* 519 */                 agg_value93 = agg_value95;
/* 520 */               }
/* 521 */             }
/* 522 */
/* 523 */             agg_isNull83 = false; // resultCode could change nullability.
/* 524 */             agg_value91 = agg_value92 + agg_value93;
/* 525 */
/* 526 */           }
/* 527 */           boolean agg_isNull89 = false;
/* 528 */           long agg_value97 = -1L;
/* 529 */           if (!false && scan_isNull4) {
/* 530 */             boolean agg_isNull92 = agg_fastAggBuffer.isNullAt(3);
/* 531 */             long agg_value100 = agg_isNull92 ? -1L : (agg_fastAggBuffer.getLong(3));
/* 532 */             agg_isNull89 = agg_isNull92;
/* 533 */             agg_value97 = agg_value100;
/* 534 */           } else {
/* 535 */             boolean agg_isNull93 = true;
/* 536 */             long agg_value101 = -1L;
/* 537 */
/* 538 */             boolean agg_isNull94 = agg_fastAggBuffer.isNullAt(3);
/* 539 */             long agg_value102 = agg_isNull94 ? -1L : (agg_fastAggBuffer.getLong(3));
/* 540 */             if (!agg_isNull94) {
/* 541 */               agg_isNull93 = false; // resultCode could change nullability.
/* 542 */               agg_value101 = agg_value102 + 1L;
/* 543 */
/* 544 */             }
/* 545 */             agg_isNull89 = agg_isNull93;
/* 546 */             agg_value97 = agg_value101;
/* 547 */           }
/* 548 */           boolean agg_isNull96 = true;
/* 549 */           double agg_value104 = -1.0;
/* 550 */
/* 551 */           boolean agg_isNull97 = agg_fastAggBuffer.isNullAt(4);
/* 552 */           double agg_value105 = agg_isNull97 ? -1.0 : (agg_fastAggBuffer.getDouble(4));
/* 553 */           if (!agg_isNull97) {
/* 554 */             boolean agg_isNull98 = scan_isNull6;
/* 555 */             double agg_value106 = scan_value6;
/* 556 */             if (agg_isNull98) {
/* 557 */               boolean agg_isNull100 = false;
/* 558 */               double agg_value108 = -1.0;
/* 559 */               if (!false) {
/* 560 */                 agg_value108 = (double) 0;
/* 561 */               }
/* 562 */               if (!agg_isNull100) {
/* 563 */                 agg_isNull98 = false;
/* 564 */                 agg_value106 = agg_value108;
/* 565 */               }
/* 566 */             }
/* 567 */
/* 568 */             agg_isNull96 = false; // resultCode could change nullability.
/* 569 */             agg_value104 = agg_value105 + agg_value106;
/* 570 */
/* 571 */           }
/* 572 */           boolean agg_isNull102 = false;
/* 573 */           long agg_value110 = -1L;
/* 574 */           if (!false && scan_isNull6) {
/* 575 */             boolean agg_isNull105 = agg_fastAggBuffer.isNullAt(5);
/* 576 */             long agg_value113 = agg_isNull105 ? -1L : (agg_fastAggBuffer.getLong(5));
/* 577 */             agg_isNull102 = agg_isNull105;
/* 578 */             agg_value110 = agg_value113;
/* 579 */           } else {
/* 580 */             boolean agg_isNull106 = true;
/* 581 */             long agg_value114 = -1L;
/* 582 */
/* 583 */             boolean agg_isNull107 = agg_fastAggBuffer.isNullAt(5);
/* 584 */             long agg_value115 = agg_isNull107 ? -1L : (agg_fastAggBuffer.getLong(5));
/* 585 */             if (!agg_isNull107) {
/* 586 */               agg_isNull106 = false; // resultCode could change nullability.
/* 587 */               agg_value114 = agg_value115 + 1L;
/* 588 */
/* 589 */             }
/* 590 */             agg_isNull102 = agg_isNull106;
/* 591 */             agg_value110 = agg_value114;
/* 592 */           }
/* 593 */           boolean agg_isNull109 = true;
/* 594 */           double agg_value117 = -1.0;
/* 595 */
/* 596 */           boolean agg_isNull110 = agg_fastAggBuffer.isNullAt(6);
/* 597 */           double agg_value118 = agg_isNull110 ? -1.0 : (agg_fastAggBuffer.getDouble(6));
/* 598 */           if (!agg_isNull110) {
/* 599 */             boolean agg_isNull111 = scan_isNull5;
/* 600 */             double agg_value119 = scan_value5;
/* 601 */             if (agg_isNull111) {
/* 602 */               boolean agg_isNull113 = false;
/* 603 */               double agg_value121 = -1.0;
/* 604 */               if (!false) {
/* 605 */                 agg_value121 = (double) 0;
/* 606 */               }
/* 607 */               if (!agg_isNull113) {
/* 608 */                 agg_isNull111 = false;
/* 609 */                 agg_value119 = agg_value121;
/* 610 */               }
/* 611 */             }
/* 612 */
/* 613 */             agg_isNull109 = false; // resultCode could change nullability.
/* 614 */             agg_value117 = agg_value118 + agg_value119;
/* 615 */
/* 616 */           }
/* 617 */           boolean agg_isNull115 = false;
/* 618 */           long agg_value123 = -1L;
/* 619 */           if (!false && scan_isNull5) {
/* 620 */             boolean agg_isNull118 = agg_fastAggBuffer.isNullAt(7);
/* 621 */             long agg_value126 = agg_isNull118 ? -1L : (agg_fastAggBuffer.getLong(7));
/* 622 */             agg_isNull115 = agg_isNull118;
/* 623 */             agg_value123 = agg_value126;
/* 624 */           } else {
/* 625 */             boolean agg_isNull119 = true;
/* 626 */             long agg_value127 = -1L;
/* 627 */
/* 628 */             boolean agg_isNull120 = agg_fastAggBuffer.isNullAt(7);
/* 629 */             long agg_value128 = agg_isNull120 ? -1L : (agg_fastAggBuffer.getLong(7));
/* 630 */             if (!agg_isNull120) {
/* 631 */               agg_isNull119 = false; // resultCode could change nullability.
/* 632 */               agg_value127 = agg_value128 + 1L;
/* 633 */
/* 634 */             }
/* 635 */             agg_isNull115 = agg_isNull119;
/* 636 */             agg_value123 = agg_value127;
/* 637 */           }
/* 638 */           // update fast row
/* 639 */           if (!agg_isNull71) {
/* 640 */             agg_fastAggBuffer.setDouble(0, agg_value79);
/* 641 */           } else {
/* 642 */             agg_fastAggBuffer.setNullAt(0);
/* 643 */           }
/* 644 */
/* 645 */           if (!agg_isNull77) {
/* 646 */             agg_fastAggBuffer.setLong(1, agg_value85);
/* 647 */           } else {
/* 648 */             agg_fastAggBuffer.setNullAt(1);
/* 649 */           }
/* 650 */
/* 651 */           if (!agg_isNull83) {
/* 652 */             agg_fastAggBuffer.setDouble(2, agg_value91);
/* 653 */           } else {
/* 654 */             agg_fastAggBuffer.setNullAt(2);
/* 655 */           }
/* 656 */
/* 657 */           if (!agg_isNull89) {
/* 658 */             agg_fastAggBuffer.setLong(3, agg_value97);
/* 659 */           } else {
/* 660 */             agg_fastAggBuffer.setNullAt(3);
/* 661 */           }
/* 662 */
/* 663 */           if (!agg_isNull96) {
/* 664 */             agg_fastAggBuffer.setDouble(4, agg_value104);
/* 665 */           } else {
/* 666 */             agg_fastAggBuffer.setNullAt(4);
/* 667 */           }
/* 668 */
/* 669 */           if (!agg_isNull102) {
/* 670 */             agg_fastAggBuffer.setLong(5, agg_value110);
/* 671 */           } else {
/* 672 */             agg_fastAggBuffer.setNullAt(5);
/* 673 */           }
/* 674 */
/* 675 */           if (!agg_isNull109) {
/* 676 */             agg_fastAggBuffer.setDouble(6, agg_value117);
/* 677 */           } else {
/* 678 */             agg_fastAggBuffer.setNullAt(6);
/* 679 */           }
/* 680 */
/* 681 */           if (!agg_isNull115) {
/* 682 */             agg_fastAggBuffer.setLong(7, agg_value123);
/* 683 */           } else {
/* 684 */             agg_fastAggBuffer.setNullAt(7);
/* 685 */           }
/* 686 */
/* 687 */         } else {
/* 688 */           // update unsafe row
/* 689 */
/* 690 */           // common sub-expressions
/* 691 */           boolean agg_isNull16 = scan_isNull3;
/* 692 */           long agg_value24 = -1L;
/* 693 */           if (!scan_isNull3) {
/* 694 */             agg_value24 = (long) scan_value3;
/* 695 */           }
/* 696 */           // evaluate aggregate function
/* 697 */           boolean agg_isNull18 = true;
/* 698 */           double agg_value26 = -1.0;
/* 699 */
/* 700 */           boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 701 */           double agg_value27 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 702 */           if (!agg_isNull19) {
/* 703 */             boolean agg_isNull21 = agg_isNull16;
/* 704 */             double agg_value29 = -1.0;
/* 705 */             if (!agg_isNull16) {
/* 706 */               agg_value29 = (double) agg_value24;
/* 707 */             }
/* 708 */             boolean agg_isNull20 = agg_isNull21;
/* 709 */             double agg_value28 = agg_value29;
/* 710 */             if (agg_isNull20) {
/* 711 */               boolean agg_isNull22 = false;
/* 712 */               double agg_value30 = -1.0;
/* 713 */               if (!false) {
/* 714 */                 agg_value30 = (double) 0;
/* 715 */               }
/* 716 */               if (!agg_isNull22) {
/* 717 */                 agg_isNull20 = false;
/* 718 */                 agg_value28 = agg_value30;
/* 719 */               }
/* 720 */             }
/* 721 */
/* 722 */             agg_isNull18 = false; // resultCode could change nullability.
/* 723 */             agg_value26 = agg_value27 + agg_value28;
/* 724 */
/* 725 */           }
/* 726 */           boolean agg_isNull24 = false;
/* 727 */           long agg_value32 = -1L;
/* 728 */           if (!false && agg_isNull16) {
/* 729 */             boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 730 */             long agg_value34 = agg_isNull26 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 731 */             agg_isNull24 = agg_isNull26;
/* 732 */             agg_value32 = agg_value34;
/* 733 */           } else {
/* 734 */             boolean agg_isNull27 = true;
/* 735 */             long agg_value35 = -1L;
/* 736 */
/* 737 */             boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 738 */             long agg_value36 = agg_isNull28 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 739 */             if (!agg_isNull28) {
/* 740 */               agg_isNull27 = false; // resultCode could change nullability.
/* 741 */               agg_value35 = agg_value36 + 1L;
/* 742 */
/* 743 */             }
/* 744 */             agg_isNull24 = agg_isNull27;
/* 745 */             agg_value32 = agg_value35;
/* 746 */           }
/* 747 */           boolean agg_isNull30 = true;
/* 748 */           double agg_value38 = -1.0;
/* 749 */
/* 750 */           boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 751 */           double agg_value39 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 752 */           if (!agg_isNull31) {
/* 753 */             boolean agg_isNull32 = scan_isNull4;
/* 754 */             double agg_value40 = scan_value4;
/* 755 */             if (agg_isNull32) {
/* 756 */               boolean agg_isNull34 = false;
/* 757 */               double agg_value42 = -1.0;
/* 758 */               if (!false) {
/* 759 */                 agg_value42 = (double) 0;
/* 760 */               }
/* 761 */               if (!agg_isNull34) {
/* 762 */                 agg_isNull32 = false;
/* 763 */                 agg_value40 = agg_value42;
/* 764 */               }
/* 765 */             }
/* 766 */
/* 767 */             agg_isNull30 = false; // resultCode could change nullability.
/* 768 */             agg_value38 = agg_value39 + agg_value40;
/* 769 */
/* 770 */           }
/* 771 */           boolean agg_isNull36 = false;
/* 772 */           long agg_value44 = -1L;
/* 773 */           if (!false && scan_isNull4) {
/* 774 */             boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 775 */             long agg_value47 = agg_isNull39 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 776 */             agg_isNull36 = agg_isNull39;
/* 777 */             agg_value44 = agg_value47;
/* 778 */           } else {
/* 779 */             boolean agg_isNull40 = true;
/* 780 */             long agg_value48 = -1L;
/* 781 */
/* 782 */             boolean agg_isNull41 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 783 */             long agg_value49 = agg_isNull41 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 784 */             if (!agg_isNull41) {
/* 785 */               agg_isNull40 = false; // resultCode could change nullability.
/* 786 */               agg_value48 = agg_value49 + 1L;
/* 787 */
/* 788 */             }
/* 789 */             agg_isNull36 = agg_isNull40;
/* 790 */             agg_value44 = agg_value48;
/* 791 */           }
/* 792 */           boolean agg_isNull43 = true;
/* 793 */           double agg_value51 = -1.0;
/* 794 */
/* 795 */           boolean agg_isNull44 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 796 */           double agg_value52 = agg_isNull44 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 797 */           if (!agg_isNull44) {
/* 798 */             boolean agg_isNull45 = scan_isNull6;
/* 799 */             double agg_value53 = scan_value6;
/* 800 */             if (agg_isNull45) {
/* 801 */               boolean agg_isNull47 = false;
/* 802 */               double agg_value55 = -1.0;
/* 803 */               if (!false) {
/* 804 */                 agg_value55 = (double) 0;
/* 805 */               }
/* 806 */               if (!agg_isNull47) {
/* 807 */                 agg_isNull45 = false;
/* 808 */                 agg_value53 = agg_value55;
/* 809 */               }
/* 810 */             }
/* 811 */
/* 812 */             agg_isNull43 = false; // resultCode could change nullability.
/* 813 */             agg_value51 = agg_value52 + agg_value53;
/* 814 */
/* 815 */           }
/* 816 */           boolean agg_isNull49 = false;
/* 817 */           long agg_value57 = -1L;
/* 818 */           if (!false && scan_isNull6) {
/* 819 */             boolean agg_isNull52 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 820 */             long agg_value60 = agg_isNull52 ? -1L : (agg_unsafeRowAggBuffer.getLong(5));
/* 821 */             agg_isNull49 = agg_isNull52;
/* 822 */             agg_value57 = agg_value60;
/* 823 */           } else {
/* 824 */             boolean agg_isNull53 = true;
/* 825 */             long agg_value61 = -1L;
/* 826 */
/* 827 */             boolean agg_isNull54 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 828 */             long agg_value62 = agg_isNull54 ? -1L : (agg_unsafeRowAggBuffer.getLong(5));
/* 829 */             if (!agg_isNull54) {
/* 830 */               agg_isNull53 = false; // resultCode could change nullability.
/* 831 */               agg_value61 = agg_value62 + 1L;
/* 832 */
/* 833 */             }
/* 834 */             agg_isNull49 = agg_isNull53;
/* 835 */             agg_value57 = agg_value61;
/* 836 */           }
/* 837 */           boolean agg_isNull56 = true;
/* 838 */           double agg_value64 = -1.0;
/* 839 */
/* 840 */           boolean agg_isNull57 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 841 */           double agg_value65 = agg_isNull57 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 842 */           if (!agg_isNull57) {
/* 843 */             boolean agg_isNull58 = scan_isNull5;
/* 844 */             double agg_value66 = scan_value5;
/* 845 */             if (agg_isNull58) {
/* 846 */               boolean agg_isNull60 = false;
/* 847 */               double agg_value68 = -1.0;
/* 848 */               if (!false) {
/* 849 */                 agg_value68 = (double) 0;
/* 850 */               }
/* 851 */               if (!agg_isNull60) {
/* 852 */                 agg_isNull58 = false;
/* 853 */                 agg_value66 = agg_value68;
/* 854 */               }
/* 855 */             }
/* 856 */
/* 857 */             agg_isNull56 = false; // resultCode could change nullability.
/* 858 */             agg_value64 = agg_value65 + agg_value66;
/* 859 */
/* 860 */           }
/* 861 */           boolean agg_isNull62 = false;
/* 862 */           long agg_value70 = -1L;
/* 863 */           if (!false && scan_isNull5) {
/* 864 */             boolean agg_isNull65 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 865 */             long agg_value73 = agg_isNull65 ? -1L : (agg_unsafeRowAggBuffer.getLong(7));
/* 866 */             agg_isNull62 = agg_isNull65;
/* 867 */             agg_value70 = agg_value73;
/* 868 */           } else {
/* 869 */             boolean agg_isNull66 = true;
/* 870 */             long agg_value74 = -1L;
/* 871 */
/* 872 */             boolean agg_isNull67 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 873 */             long agg_value75 = agg_isNull67 ? -1L : (agg_unsafeRowAggBuffer.getLong(7));
/* 874 */             if (!agg_isNull67) {
/* 875 */               agg_isNull66 = false; // resultCode could change nullability.
/* 876 */               agg_value74 = agg_value75 + 1L;
/* 877 */
/* 878 */             }
/* 879 */             agg_isNull62 = agg_isNull66;
/* 880 */             agg_value70 = agg_value74;
/* 881 */           }
/* 882 */           // update unsafe row buffer
/* 883 */           if (!agg_isNull18) {
/* 884 */             agg_unsafeRowAggBuffer.setDouble(0, agg_value26);
/* 885 */           } else {
/* 886 */             agg_unsafeRowAggBuffer.setNullAt(0);
/* 887 */           }
/* 888 */
/* 889 */           if (!agg_isNull24) {
/* 890 */             agg_unsafeRowAggBuffer.setLong(1, agg_value32);
/* 891 */           } else {
/* 892 */             agg_unsafeRowAggBuffer.setNullAt(1);
/* 893 */           }
/* 894 */
/* 895 */           if (!agg_isNull30) {
/* 896 */             agg_unsafeRowAggBuffer.setDouble(2, agg_value38);
/* 897 */           } else {
/* 898 */             agg_unsafeRowAggBuffer.setNullAt(2);
/* 899 */           }
/* 900 */
/* 901 */           if (!agg_isNull36) {
/* 902 */             agg_unsafeRowAggBuffer.setLong(3, agg_value44);
/* 903 */           } else {
/* 904 */             agg_unsafeRowAggBuffer.setNullAt(3);
/* 905 */           }
/* 906 */
/* 907 */           if (!agg_isNull43) {
/* 908 */             agg_unsafeRowAggBuffer.setDouble(4, agg_value51);
/* 909 */           } else {
/* 910 */             agg_unsafeRowAggBuffer.setNullAt(4);
/* 911 */           }
/* 912 */
/* 913 */           if (!agg_isNull49) {
/* 914 */             agg_unsafeRowAggBuffer.setLong(5, agg_value57);
/* 915 */           } else {
/* 916 */             agg_unsafeRowAggBuffer.setNullAt(5);
/* 917 */           }
/* 918 */
/* 919 */           if (!agg_isNull56) {
/* 920 */             agg_unsafeRowAggBuffer.setDouble(6, agg_value64);
/* 921 */           } else {
/* 922 */             agg_unsafeRowAggBuffer.setNullAt(6);
/* 923 */           }
/* 924 */
/* 925 */           if (!agg_isNull62) {
/* 926 */             agg_unsafeRowAggBuffer.setLong(7, agg_value70);
/* 927 */           } else {
/* 928 */             agg_unsafeRowAggBuffer.setNullAt(7);
/* 929 */           }
/* 930 */
/* 931 */         }
/* 932 */         // shouldStop check is eliminated
/* 933 */       }
/* 934 */       scan_batchIdx = scan_numRows;
/* 935 */       scan_batch = null;
/* 936 */       scan_nextBatch();
/* 937 */     }
/* 938 */     scan_scanTime.add(scan_scanTime1 / (1000 * 1000));
/* 939 */     scan_scanTime1 = 0;
/* 940 */
/* 941 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 942 */
/* 943 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 944 */   }
/* 945 */
/* 946 */   private void wholestagecodegen_init_5() {
/* 947 */     agg_unsafeRowJoiner = agg_plan.createUnsafeJoiner();
/* 948 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[23];
/* 949 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[24];
/* 950 */
/* 951 */   }
/* 952 */
/* 953 */   private void wholestagecodegen_init_2() {
/* 954 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 955 */     project_result1 = new UnsafeRow(7);
/* 956 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 957 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 7);
/* 958 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[17];
/* 959 */
/* 960 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 961 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 962 */
/* 963 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 964 */     bhj_result1 = new UnsafeRow(8);
/* 965 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 966 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 8);
/* 967 */     project_result2 = new UnsafeRow(6);
/* 968 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 969 */
/* 970 */   }
/* 971 */
/* 972 */   private void wholestagecodegen_init_1() {
/* 973 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[14];
/* 974 */     filter_result = new UnsafeRow(8);
/* 975 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 976 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 8);
/* 977 */     project_result = new UnsafeRow(8);
/* 978 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 979 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 980 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[15];
/* 981 */
/* 982 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 983 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 984 */
/* 985 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[16];
/* 986 */     bhj_result = new UnsafeRow(9);
/* 987 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 988 */
/* 989 */   }
/* 990 */
/* 991 */   private void wholestagecodegen_init_4() {
/* 992 */     bhj_relation3 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast3.value()).asReadOnlyCopy();
/* 993 */     incPeakExecutionMemory(bhj_relation3.estimatedSize());
/* 994 */
/* 995 */     this.bhj_numOutputRows3 = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 996 */     bhj_result3 = new UnsafeRow(7);
/* 997 */     this.bhj_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result3, 32);
/* 998 */     this.bhj_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder3, 7);
/* 999 */     project_result4 = new UnsafeRow(5);
/* 1000 */     this.project_holder4 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result4, 32);
/* 1001 */     this.project_rowWriter4 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder4, 5);
/* 1002 */     agg_result1 = new UnsafeRow(1);
/* 1003 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 1004 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 1005 */
/* 1006 */   }
/* 1007 */
/* 1008 */   protected void processNext() throws java.io.IOException {
/* 1009 */     if (!agg_initAgg) {
/* 1010 */       agg_initAgg = true;
/* 1011 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1012 */       agg_doAggregateWithKeys();
/* 1013 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1014 */     }
/* 1015 */
/* 1016 */     // output the result
/* 1017 */
/* 1018 */     while (agg_fastHashMapIter.next()) {
/* 1019 */       wholestagecodegen_numOutputRows.add(1);
/* 1020 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 1021 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 1022 */
/* 1023 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1024 */
/* 1025 */       append(agg_resultRow);
/* 1026 */
/* 1027 */       if (shouldStop()) return;
/* 1028 */     }
/* 1029 */     agg_fastHashMap.close();
/* 1030 */
/* 1031 */     while (agg_mapIter.next()) {
/* 1032 */       wholestagecodegen_numOutputRows.add(1);
/* 1033 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1034 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1035 */
/* 1036 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 1037 */
/* 1038 */       append(agg_resultRow);
/* 1039 */
/* 1040 */       if (shouldStop()) return;
/* 1041 */     }
/* 1042 */
/* 1043 */     agg_mapIter.close();
/* 1044 */     if (agg_sorter == null) {
/* 1045 */       agg_hashMap.free();
/* 1046 */     }
/* 1047 */   }
/* 1048 */ }
